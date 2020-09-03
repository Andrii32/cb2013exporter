package infrastructure.normal.database

import cats.effect.IO
import fs2.Stream
import shapeless.{Generic, ::, HList, HNil }
import doobie._
import doobie.implicits._
import doobie.implicits.javatime._
import doobie.util.transactor.Transactor

import domain.normal.models._
import domain.normal.models.CbObject._
import domain.normal.models.CbObjectId._
import domain.normal.CbRepository
import DoobieMappings._


class DbCbRepository(transactor: Transactor[IO]) extends CbRepository[IO] {

    def streamCompanyObjectsIds: Stream[IO, CbCompanyObjectId] =
        sql"""|SELECT
              |   id
              |FROM
              |   cb_objects
              |WHERE
              |   entity_type = 'Company'
        """.stripMargin
        .query[CbCompanyObjectId]
        .stream
        .transact(transactor)

    private def getObjectById(id: CbObjectId): IO[CbObjectHList] =
        sql"""|SELECT
              |   id,
              |   entity_type,
              |   entity_id,
              |   parent_id,
              |   name,
              |   normalized_name,
              |   permalink,
              |   category_code,
              |   status,
              |   founded_at,
              |   closed_at,
              |   domain,
              |   homepage_url,
              |   twitter_username,
              |   logo_url,
              |   logo_width,
              |   logo_height,
              |   short_description,
              |   description,
              |   overview,
              |   tag_list,
              |   country_code,
              |   state_code,
              |   city,
              |   region,
              |   first_investment_at,
              |   last_investment_at,
              |   investment_rounds,
              |   invested_companies,
              |   first_funding_at,
              |   last_funding_at,
              |   funding_rounds,
              |   funding_total_usd,
              |   first_milestone_at,
              |   last_milestone_at,
              |   milestones,
              |   relationships,
              |   created_by,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_objects
              |WHERE
              |   id = ${id.value}
        """
        .stripMargin
        .query[CbObjectHList]
        .unique
        .transact(transactor)

    def getCompanyObjectById(id: CbCompanyObjectId): IO[CbCompanyObject] =
        getObjectById(id)
            .map({
                case (head: CbCompanyObjectId) :: tail
                    => Generic[CbCompanyObject].from(head :: tail)
                case _
                    => throw new Exception("Error propagation")
            })

    def getFinancialOrgObjectById(id: CbFinancialOrgObjectId): IO[CbFinancialOrgObject] =
        getObjectById(id)
            .map({
                case (head: CbFinancialOrgObjectId) :: tail
                    => Generic[CbFinancialOrgObject].from(head :: tail)
                case _
                    => throw new Exception("Error propagation")
            })

    def getPersonObjectById(id: CbPersonObjectId): IO[CbPersonObject] =
        getObjectById(id)
            .map({
                case (head: CbPersonObjectId) :: tail
                    => Generic[CbPersonObject].from(head :: tail)
                case _
                    => throw new Exception("Error propagation")
            })

    def getProductObjectById(id: CbProductObjectId): IO[CbProductObject] =
        getObjectById(id)
            .map({
                case (head: CbProductObjectId) :: tail
                    => Generic[CbProductObject].from(head :: tail)
                case _
                    => throw new Exception("Error propagation")
            })

    def getAcquisitionsByAcquiringObjectId(object_id: CbCompanyObjectId): IO[List[CbAcquisition]] =
        sql"""|SELECT
              |   id,
              |   acquisition_id,
              |   acquiring_object_id,
              |   acquired_object_id,
              |   term_code,
              |   price_amount,
              |   price_currency_code,
              |   acquired_at,
              |   source_url,
              |   source_description,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_acquisitions
              |WHERE
              |   acquiring_object_id = ${object_id.value}
        """
        .stripMargin
        .query[CbAcquisition]
        .to[List]
        .transact(transactor)

    def getAcquisitionsByAcquiredObjectId(object_id: CbCompanyObjectId): IO[List[CbAcquisition]] =
        sql"""|SELECT
              |   id,
              |   acquisition_id,
              |   acquiring_object_id,
              |   acquired_object_id,
              |   term_code,
              |   price_amount,
              |   price_currency_code,
              |   acquired_at,
              |   source_url,
              |   source_description,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_acquisitions
              |WHERE
              |   acquired_object_id = $object_id
        """
        .stripMargin
        .query[CbAcquisition]
        .to[List]
        .transact(transactor)

    def getDegreesByObjectId(object_id: CbPersonObjectId): IO[List[CbDegree]] =
        sql"""|SELECT
              |   id,
              |   object_id,
              |   degree_type,
              |   subject,
              |   institution,
              |   graduated_at,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_degrees
              |WHERE
              |   object_id = $object_id
        """
        .stripMargin
        .query[CbDegree]
        .to[List]
        .transact(transactor)


    def getFundsByObjectId(object_id: String): IO[List[CbFund]] =
        sql"""|SELECT
              |   id,
              |   fund_id,
              |   object_id,
              |   name,
              |   funded_at,
              |   raised_amount,
              |   raised_currency_code,
              |   source_url,
              |   source_description,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_funds
              |WHERE
              |   object_id = $object_id
        """
        .stripMargin
        .query[CbFund]
        .to[List]
        .transact(transactor)

    def getFundingRoundsByObjectId(object_id: CbCompanyObjectId): IO[List[CbFundingRound]] =
        sql"""|SELECT
              |   id,
              |   funding_round_id,
              |   object_id,
              |   funded_at,
              |   funding_round_type,
              |   funding_round_code,
              |   raised_amount_usd,
              |   raised_amount,
              |   raised_currency_code,
              |   pre_money_valuation_usd,
              |   pre_money_valuation,
              |   pre_money_currency_code,
              |   post_money_valuation_usd,
              |   post_money_valuation,
              |   post_money_currency_code,
              |   participants,
              |   is_first_round,
              |   is_last_round,
              |   source_url,
              |   source_description,
              |   created_by,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_funding_rounds
              |WHERE
              |   object_id = $object_id
        """
        .stripMargin
        .query[CbFundingRound]
        .to[List]
        .transact(transactor)

    def getInvestmentsByFundedObjectId(funded_object_id: CbCompanyObjectId): IO[List[CbInvestment]] =
        sql"""|SELECT
              |   id,
              |   funding_round_id,
              |   funded_object_id,
              |   investor_object_id,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_investments
              |WHERE
              |   funded_object_id = $funded_object_id
        """
        .stripMargin
        .query[CbInvestment]
        .to[List]
        .transact(transactor)

    def getInvestmentsByFundingRoundId(funding_round_id: Long): IO[List[CbInvestment]] =
        sql"""|SELECT
              |   id,
              |   funding_round_id,
              |   funded_object_id,
              |   investor_object_id,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_investments
              |WHERE
              |   funding_round_id = $funding_round_id
        """
        .stripMargin
        .query[CbInvestment]
        .to[List]
        .transact(transactor)

    def getIPOsByObjectId(object_id: CbCompanyObjectId): IO[List[CbIPO]] =
        sql"""|SELECT
              |   id,
              |   ipo_id,
              |   object_id,
              |   valuation_amount,
              |   valuation_currency_code,
              |   raised_amount,
              |   raised_currency_code,
              |   public_at,
              |   stock_symbol,
              |   source_url,
              |   source_description,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_ipos
              |WHERE
              |   object_id = $object_id
        """
        .stripMargin
        .query[CbIPO]
        .to[List]
        .transact(transactor)

    def getMilestonesByObjectId(object_id: CbObjectId): IO[List[CbMilestone]] =
        sql"""|SELECT
              |   id,
              |   object_id,
              |   milestone_at,
              |   milestone_code,
              |   description,
              |   source_url,
              |   source_description,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_milestones
              |WHERE
              |   object_id = $object_id
        """
        .stripMargin
        .query[CbMilestone]
        .to[List]
        .transact(transactor)

    def getOfficesByObjectId(object_id: CbObjectId): IO[List[CbOffice]] =
        sql"""|SELECT
              |   id,
              |   object_id,
              |   office_id,
              |   description,
              |   region,
              |   address1,
              |   address2,
              |   city,
              |   zip_code,
              |   state_code,
              |   country_code,
              |   latitude,
              |   longitude,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_offices
              |WHERE
              |   object_id = $object_id
        """
        .stripMargin
        .query[CbOffice]
        .to[List]
        .transact(transactor)

    def getPersonByObjectId(object_id: CbPersonObjectId): IO[CbPerson] =
        sql"""|SELECT
              |   id,
              |   object_id,
              |   first_name,
              |   last_name,
              |   birthplace,
              |   affiliation_name
              |FROM
              |   cb_people
              |WHERE
              |   object_id = $object_id
        """
        .stripMargin
        .query[CbPerson]
        .unique
        .transact(transactor)

    def getRelationshipByRelationshipObjectId(relationship_object_id: CbObjectId): IO[List[CbRelationship]] =
        sql"""|SELECT
              |   id,
              |   relationship_id,
              |   person_object_id,
              |   relationship_object_id,
              |   start_at,
              |   end_at,
              |   is_past,
              |   sequence,
              |   title,
              |   created_at,
              |   updated_at
              |FROM
              |   cb_relationships
              |WHERE
              |   relationship_object_id = $relationship_object_id
        """
        .stripMargin
        .query[CbRelationship]
        .to[List]
        .transact(transactor)
}