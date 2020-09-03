package domain.normal.models


sealed trait CbObjectId{
    def value: String
}

case class CbCompanyObjectId(value: String)         extends CbObjectId
case class CbFinancialOrgObjectId(value: String)    extends CbObjectId
case class CbPersonObjectId(value: String)          extends CbObjectId
case class CbProductObjectId(value: String)         extends CbObjectId

object CbObjectId{

    def apply(id: String): CbObjectId = id match {
        case id if id.matches("c:[0-9]+") => CbCompanyObjectId(id)
        case id if id.matches("f:[0-9]+") => CbFinancialOrgObjectId(id)
        case id if id.matches("p:[0-9]+") => CbPersonObjectId(id)
        case id if id.matches("r:[0-9]+") => CbFinancialOrgObjectId(id)
        case x                            => throw new Exception(s"Undefined id: ${x}")
    }
}
