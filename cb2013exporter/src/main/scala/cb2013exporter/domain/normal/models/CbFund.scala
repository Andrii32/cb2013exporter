package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbFund(
    id:                     Long,
    fund_id:                Long,
    object_id:              CbFinancialOrgObjectId,
    name:                   String,
    funded_at:              Option[LocalDate],
    raised_amount:          Option[BigDecimal],
    raised_currency_code:   Option[String],
    source_url:             Option[String],
    source_description:     Option[String],
    created_at:             Option[LocalDateTime],
    updated_at:             Option[LocalDateTime],
)

