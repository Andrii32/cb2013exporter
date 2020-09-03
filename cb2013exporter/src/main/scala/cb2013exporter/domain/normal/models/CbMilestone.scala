package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbMilestone(
    id:                 Long,
    object_id:          CbObjectId,
    milestone_at:       Option[LocalDate],
    milestone_code:     Option[String],
    description:        Option[String],
    source_url:         Option[String],
    source_description: Option[String],
    created_at:         Option[LocalDateTime],
    updated_at:         Option[LocalDateTime],
)

