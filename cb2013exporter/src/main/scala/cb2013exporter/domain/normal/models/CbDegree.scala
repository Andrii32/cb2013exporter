package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbDegree(
    id:           Long,
    object_id:    CbPersonObjectId,
    degree_type:  String,
    subject:      Option[String],
    institution:  Option[String],
    graduated_at: Option[LocalDate],
    created_at:   Option[LocalDateTime],
    updated_at:   Option[LocalDateTime],
)


