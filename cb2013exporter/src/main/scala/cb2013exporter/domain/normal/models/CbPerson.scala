
package domain.normal.models


case class CbPerson(
    id:                 Long,
    object_id:          CbPersonObjectId,
    first_name:         String,
    last_name:          String,
    birthplace:         Option[String],
    affiliation_name:   Option[String],
)
