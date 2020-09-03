package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbIPO(
    id:                         Long,
    ipo_id:                     Long,
    object_id:                  CbObjectId,
    valuation_amount:           Option[BigDecimal],
    valuation_currency_code:    Option[String],
    raised_amount:              Option[BigDecimal],
    raised_currency_code:       Option[String],
    public_at:                  Option[LocalDate],
    stock_symbol:               Option[String],
    source_url:                 Option[String],
    source_description:         Option[String],
    created_at:                 Option[LocalDateTime],
    updated_at:                 Option[LocalDateTime],
)

