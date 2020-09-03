package application.encoders

import cats.syntax.functor._

import io.circe.generic.semiauto.deriveDecoder
import io.circe.generic.semiauto.deriveEncoder
import io.circe.generic.extras.semiauto._
import io.circe.{ Decoder, Encoder }

import domain.normal.models._
import domain.nested.models._


object ObjectIdEncoderDecoder{

    implicit val cbCompanyObjectIdDecoder        = deriveUnwrappedDecoder[CbCompanyObjectId]
    implicit val cbCompanyObjectIdEncoder        = deriveUnwrappedEncoder[CbCompanyObjectId]

    implicit val cbFinancialOrgObjectIdDecoder   = deriveUnwrappedDecoder[CbFinancialOrgObjectId]
    implicit val cbFinancialOrgObjectIdEncoder   = deriveUnwrappedEncoder[CbFinancialOrgObjectId]

    implicit val cbPersonObjectIdDecoder         = deriveUnwrappedDecoder[CbPersonObjectId]
    implicit val cbPersonObjectIdEncoder         = deriveUnwrappedEncoder[CbPersonObjectId]

    implicit val cbProductObjectIdDecoder        = deriveUnwrappedDecoder[CbProductObjectId]
    implicit val cbProductObjectIdEncoder        = deriveUnwrappedEncoder[CbProductObjectId]

    implicit val encodeCbObjectId: Encoder[CbObjectId] = Encoder.instance {
        case v: CbCompanyObjectId         => cbCompanyObjectIdEncoder(v)
        case v: CbFinancialOrgObjectId    => cbFinancialOrgObjectIdEncoder(v)
        case v: CbPersonObjectId          => cbPersonObjectIdEncoder(v)
        case v: CbProductObjectId         => cbProductObjectIdEncoder(v)
    }

    implicit val decodeCbObjectId: Decoder[CbObjectId] =
        List[Decoder[CbObjectId]](
            cbCompanyObjectIdDecoder.widen,
            cbFinancialOrgObjectIdDecoder.widen,
            cbPersonObjectIdDecoder.widen,
            cbProductObjectIdDecoder.widen
        ).reduceLeft(_ or _)

}

object ObjectEncoderDecoder{
    import ObjectIdEncoderDecoder._

    implicit val cbCompanyObjectDecoder         = deriveDecoder[CbCompanyObject]
    implicit val cbCompanyObjectEncoder         = deriveEncoder[CbCompanyObject]

    implicit val cbFinancialOrgObjectDecoder    = deriveDecoder[CbFinancialOrgObject]
    implicit val cbFinancialOrgObjectEncoder    = deriveEncoder[CbFinancialOrgObject]

    implicit val cbPersonObjectDecoder          = deriveDecoder[CbPersonObject]
    implicit val cbPersonObjectEncoder          = deriveEncoder[CbPersonObject]

    implicit val cbProductObjectDecoder         = deriveDecoder[CbProductObject]
    implicit val cbProductObjectEncoder         = deriveEncoder[CbProductObject]

    implicit val cbObjectEncoder: Encoder[CbObject] = Encoder.instance {
        case v: CbCompanyObject         => cbCompanyObjectEncoder(v)
        case v: CbFinancialOrgObject    => cbFinancialOrgObjectEncoder(v)
        case v: CbPersonObject          => cbPersonObjectEncoder(v)
        case v: CbProductObject         => cbProductObjectEncoder(v)
    }

    implicit val cbObjectDecoder: Decoder[CbObject] =
        List[Decoder[CbObject]](
            cbCompanyObjectDecoder.widen,
            cbFinancialOrgObjectDecoder.widen,
            cbPersonObjectDecoder.widen,
            cbProductObjectDecoder.widen
        ).reduceLeft(_ or _)
}

object CbModelsEncoderDecoder{
    import ObjectIdEncoderDecoder._

    implicit val cbAcquisitionDecoder           = deriveDecoder[CbAcquisition]
    implicit val cbAcquisitionEncoder           = deriveEncoder[CbAcquisition]

    implicit val cbDegreeDecoder                = deriveDecoder[CbDegree]
    implicit val cbDegreeEncoder                = deriveEncoder[CbDegree]

    implicit val cbOfficeDecoder                = deriveDecoder[CbOffice]
    implicit val cbOfficeEncoder                = deriveEncoder[CbOffice]

    implicit val cbFundingRoundDecoder          = deriveDecoder[CbFundingRound]
    implicit val cbFundingRoundEncoder          = deriveEncoder[CbFundingRound]

    implicit val cbInvestmentDecoder            = deriveDecoder[CbInvestment]
    implicit val cbInvestmentEncoder            = deriveEncoder[CbInvestment]

    implicit val cbIPODecoder                   = deriveDecoder[CbIPO]
    implicit val cbIPOEncoder                   = deriveEncoder[CbIPO]

    implicit val cbbMilestoneDecoder            = deriveDecoder[CbMilestone]
    implicit val cbbMilestoneEncoder            = deriveEncoder[CbMilestone]

    implicit val cbPersonDecoder                = deriveDecoder[CbPerson]
    implicit val cbPersonEncoder                = deriveEncoder[CbPerson]

    implicit val cbRelationshipDecoder          = deriveDecoder[CbRelationship]
    implicit val cbRelationshipEncoder          = deriveEncoder[CbRelationship]
}

object NestedEncodersDecoders{
    import ObjectIdEncoderDecoder._
    import ObjectEncoderDecoder._
    import CbModelsEncoderDecoder._

    implicit val nestedAcquiredDecoder          = deriveDecoder[NestedAcquired]
    implicit val nestedAcquiredEncoder          = deriveEncoder[NestedAcquired]

    implicit val nestedAcquiringDecoder         = deriveDecoder[NestedAcquiring]
    implicit val nestedAcquiringEncoder         = deriveEncoder[NestedAcquiring]

    implicit val nestedPersonDecoder            = deriveDecoder[NestedPerson]
    implicit val nestedPersonEncoder            = deriveEncoder[NestedPerson]

    implicit val nestedRelationshipDecoder      = deriveDecoder[NestedRelationship]
    implicit val nestedRelationshipEncoder      = deriveEncoder[NestedRelationship]

    implicit val nestedInvestmentDecoder        = deriveDecoder[NestedInvestment]
    implicit val nestedInvestmentEncoder        = deriveEncoder[NestedInvestment]

    implicit val nestedFundingRoundDecoder      = deriveDecoder[NestedFundingRound]
    implicit val nestedFundingRoundEncoder      = deriveEncoder[NestedFundingRound]

    implicit val nestedCompanyDecoder           = deriveDecoder[NestedCompany]
    implicit val nestedCompanyEncoder           = deriveEncoder[NestedCompany]
}

import NestedEncodersDecoders._


