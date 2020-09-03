package domain.normal

import fs2.Stream

import shapeless.{Generic, ::, HList, HNil }

import models._


trait CbRepository[F[_]] {

    def streamCompanyObjectsIds: Stream[F, CbCompanyObjectId]


    def getCompanyObjectById(id: CbCompanyObjectId): F[CbCompanyObject]


    def getFinancialOrgObjectById(id: CbFinancialOrgObjectId): F[CbFinancialOrgObject]


    def getPersonObjectById(id: CbPersonObjectId): F[CbPersonObject]


    def getProductObjectById(id: CbProductObjectId): F[CbProductObject]


    def getAcquisitionsByAcquiringObjectId(object_id: CbCompanyObjectId): F[List[CbAcquisition]]


    def getAcquisitionsByAcquiredObjectId(object_id: CbCompanyObjectId): F[List[CbAcquisition]]


    def getDegreesByObjectId(object_id: CbPersonObjectId): F[List[CbDegree]]


    def getFundsByObjectId(object_id: String): F[List[CbFund]]


    def getFundingRoundsByObjectId(object_id: CbCompanyObjectId): F[List[CbFundingRound]]


    def getInvestmentsByFundedObjectId(funded_object_id: CbCompanyObjectId): F[List[CbInvestment]]


    def getInvestmentsByFundingRoundId(funding_round_id: Long): F[List[CbInvestment]]


    def getIPOsByObjectId(object_id: CbCompanyObjectId): F[List[CbIPO]]


    def getMilestonesByObjectId(object_id: CbObjectId): F[List[CbMilestone]]


    def getOfficesByObjectId(object_id: CbObjectId): F[List[CbOffice]]


    def getPersonByObjectId(object_id: CbPersonObjectId): F[CbPerson]


    def getRelationshipByRelationshipObjectId(relatFnship_object_id: CbObjectId): F[List[CbRelationship]]

}
