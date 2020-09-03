
package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbRelationship(
    id:                     Long,
    relationship_id:        Long,
    person_object_id:       CbPersonObjectId,
    relationship_object_id: CbObjectId,
    start_at:               Option[LocalDate],
    end_at:                 Option[LocalDate],
    is_past:                Option[Int],
    sequence:               Option[Int],
    title:                  Option[String],
    created_at:             Option[LocalDateTime],
    updated_at:             Option[LocalDateTime],
)

