package infrastructure.normal.database

import doobie.Meta

import domain.normal.models._
import domain.normal.models.CbObjectId._

object DoobieMappings{

    implicit val objectIdMeta                 = Meta[String].imap(v => CbObjectId(v))(v => v.value)
    implicit val companyObjectIdMeta          = Meta[String].imap(v => CbCompanyObjectId(v))(v => v.value)
    implicit val financialOrgObjectIdMeta     = Meta[String].imap(v => CbFinancialOrgObjectId(v))(v => v.value)
    implicit val personObjectIdMeta           = Meta[String].imap(v => CbPersonObjectId(v))(v => v.value)
    implicit val productObjectIdMeta          = Meta[String].imap(v => CbProductObjectId(v))(v => v.value)

}