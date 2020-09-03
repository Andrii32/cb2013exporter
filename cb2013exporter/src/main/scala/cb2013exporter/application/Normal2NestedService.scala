package application

import cats.implicits._
import cats.Monad
import fs2.Stream

import domain.nested.models._
import domain.normal.models._
import domain.normal.CbRepository


class NestedCompanyService[F[_]](
    repository: CbRepository[F]
) {

    def streamCompanyObjectsIds: Stream[F, CbCompanyObjectId] =
        repository.streamCompanyObjectsIds

    def getNestedCompany(id: CbCompanyObjectId)(implicit M: Monad[F]): F[NestedCompany] = {
        for {
            company_object  <- repository.getCompanyObjectById(id)
            offices         <- repository.getOfficesByObjectId(id)
            ipos            <- repository.getIPOsByObjectId(id)
            funding_rounds  <- repository.getFundingRoundsByObjectId(id)
            relationships   <- repository.getRelationshipByRelationshipObjectId(id)
            acquired        <- repository.getAcquisitionsByAcquiredObjectId(id)
            acquiring       <- repository.getAcquisitionsByAcquiringObjectId(id)
            milestones      <- repository.getMilestonesByObjectId(id)
        } yield {
            // chained https://www.rallyhealth.com/coding/comprehending-for-comprehensions
            // val nested_acquired = acquired
            //   .map(acquisition => repository.getCompanyObjectById(acquisition.acquired_object_id)
            //     .map(company_object => NestedAcquired(acuisition=acquisition, acquired=company_object))
            //   ).sequence

            // for comprehension
            val nested_acquired = acquired.map(a => for {
                company_object <- repository.getCompanyObjectById(a.acquired_object_id)
            } yield NestedAcquired(acuisition=a, acquired=company_object)).sequence

            val nested_acquiring = acquiring.map(a => for {
                company_object <- repository.getCompanyObjectById(a.acquiring_object_id)
            } yield NestedAcquiring(acuisition=a, acquiring=company_object)).sequence

            val nested_realtionships = relationships.map(r => for {
                person_object <- repository.getPersonObjectById(r.person_object_id)
                person        <- repository.getPersonByObjectId(person_object.id)
                degrees       <- repository.getDegreesByObjectId(person_object.id)
            } yield NestedRelationship(
                relationship=r,
                person=NestedPerson(
                    person_object=person_object,
                    person=person,
                    degrees=degrees
                )
            )).sequence

            val nested_founding_rounds = funding_rounds
                .map(funding_round => repository.getInvestmentsByFundingRoundId(funding_round.funding_round_id)
                    .flatMap(investments => investments
                        .map(investment => {
                            investment.investor_object_id match {
                                case id: CbCompanyObjectId      => repository.getCompanyObjectById(id)
                                case id: CbFinancialOrgObjectId => repository.getFinancialOrgObjectById(id)
                                case id: CbPersonObjectId       => repository.getPersonObjectById(id)
                                case v                          => throw new Exception(s"Error propagation ${v}")
                            }
                        }.map(investor_object => NestedInvestment(investment=investment, investor_object=investor_object))).sequence)
                    .map(value => NestedFundingRound(funding_round=funding_round, investments=value))
                ).sequence

            for {
                acquired        <- nested_acquired
                acquiring       <- nested_acquiring
                relationships   <- nested_realtionships
                funding_rounds  <- nested_founding_rounds
            } yield {
                NestedCompany(
                    id=id,
                    company_object=company_object,
                    offices=offices,
                    ipos=ipos,
                    funding_rounds=funding_rounds,
                    relationships=relationships,
                    acquired=acquired,
                    acquiring=acquiring,
                    milestones=milestones
                )
            }
        }
    }.flatten

}