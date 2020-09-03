package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbOffice(
    id:             Long,
    object_id:      CbObjectId,
    office_id:      Long,
    description:    Option[String],
    region:         Option[String],
    address1:       Option[String],
    address2:       Option[String],
    city:           Option[String],
    zip_code:       Option[String],
    state_code:     Option[String],
    country_code:   Option[String],
    latitude:       Option[BigDecimal],
    longitude:      Option[BigDecimal],
    created_at:     Option[LocalDateTime],
    updated_at:     Option[LocalDateTime],
)


