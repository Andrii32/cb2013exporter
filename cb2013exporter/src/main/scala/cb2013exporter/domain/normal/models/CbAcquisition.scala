package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbAcquisition(
    id:                     Long,
    acquisition_id:         Long,
    acquiring_object_id:    CbCompanyObjectId,
    acquired_object_id:     CbCompanyObjectId,
    term_code:              Option[String],
    price_amount:           Option[BigDecimal],
    price_currency_code:    Option[String],
    acquired_at:            Option[LocalDate],
    source_url:             Option[String],
    source_description:     Option[String],
    created_at:             Option[LocalDateTime],
    updated_at:             Option[LocalDateTime],
)



