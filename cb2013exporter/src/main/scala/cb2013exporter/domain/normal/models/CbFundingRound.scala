package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbFundingRound(
    id:                         Long,
    funding_round_id:           Long,
    object_id:                  CbCompanyObjectId,
    funded_at:                  Option[LocalDate],
    funding_round_type:         Option[String],
    funding_round_code:         Option[String],
    raised_amount_usd:          Option[BigDecimal],
    raised_amount:              Option[BigDecimal],
    raised_currency_code:       Option[String],
    pre_money_valuation_usd:    Option[BigDecimal],
    pre_money_valuation:        Option[BigDecimal],
    pre_money_currency_code:    Option[String],
    post_money_valuation_usd:   Option[BigDecimal],
    post_money_valuation:       Option[BigDecimal],
    post_money_currency_code:   Option[String],
    participants:               Option[Int],
    is_first_round:             Option[Int],
    is_last_round:              Option[Int],
    source_url:                 Option[String],
    source_description:         Option[String],
    created_by:                 Option[String],
    created_at:                 Option[LocalDateTime],
    updated_at:                 Option[LocalDateTime],
)
