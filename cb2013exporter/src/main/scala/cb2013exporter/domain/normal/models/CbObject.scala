package domain.normal.models

import java.time.{LocalDate, LocalDateTime}

import shapeless.{Generic, HList, HNil, ::}


sealed trait CbObject

case class CbCompanyObject(
    id:                     CbCompanyObjectId,
    entity_type:            String,
    entity_id:              Long,
    parent_id:              Option[String],
    name:                   String,
    normalized_name:        String,
    permalink:              String,
    category_code:          Option[String],
    status:                 Option[String],
    founded_at:             Option[LocalDate],
    closed_at:              Option[LocalDate],
    domain:                 Option[String],
    homepage_url:           Option[String],
    twitter_username:       Option[String],
    logo_url:               Option[String],
    logo_width:             Option[Int],
    logo_height:            Option[Int],
    short_description:      Option[String],
    description:            Option[String],
    overview:               Option[String],
    tag_list:               Option[String],
    country_code:           Option[String],
    state_code:             Option[String],
    city:                   Option[String],
    region:                 Option[String],
    first_investment_at:    Option[LocalDate],
    last_investment_at:     Option[LocalDate],
    investment_rounds:      Option[Int],
    invested_companies:     Option[Int],
    first_funding_at:       Option[LocalDate],
    last_funding_at:        Option[LocalDate],
    funding_rounds:         Option[Int],
    funding_total_usd:      Option[BigDecimal],
    first_milestone_at:     Option[LocalDate],
    last_milestone_at:      Option[LocalDate],
    milestones:             Option[Int],
    relationships:          Option[Int],
    created_by:             Option[String],
    created_at:             Option[LocalDateTime],
    updated_at:             Option[LocalDateTime],
) extends CbObject

case class CbFinancialOrgObject(
    id:                     CbFinancialOrgObjectId,
    entity_type:            String,
    entity_id:              Long,
    parent_id:              Option[String],
    name:                   String,
    normalized_name:        String,
    permalink:              String,
    category_code:          Option[String],
    status:                 Option[String],
    founded_at:             Option[LocalDate],
    closed_at:              Option[LocalDate],
    domain:                 Option[String],
    homepage_url:           Option[String],
    twitter_username:       Option[String],
    logo_url:               Option[String],
    logo_width:             Option[Int],
    logo_height:            Option[Int],
    short_description:      Option[String],
    description:            Option[String],
    overview:               Option[String],
    tag_list:               Option[String],
    country_code:           Option[String],
    state_code:             Option[String],
    city:                   Option[String],
    region:                 Option[String],
    first_investment_at:    Option[LocalDate],
    last_investment_at:     Option[LocalDate],
    investment_rounds:      Option[Int],
    invested_companies:     Option[Int],
    first_funding_at:       Option[LocalDate],
    last_funding_at:        Option[LocalDate],
    funding_rounds:         Option[Int],
    funding_total_usd:      Option[BigDecimal],
    first_milestone_at:     Option[LocalDate],
    last_milestone_at:      Option[LocalDate],
    milestones:             Option[Int],
    relationships:          Option[Int],
    created_by:             Option[String],
    created_at:             Option[LocalDateTime],
    updated_at:             Option[LocalDateTime],
) extends CbObject

case class CbPersonObject(
    id:                     CbPersonObjectId,
    entity_type:            String,
    entity_id:              Long,
    parent_id:              Option[String],
    name:                   String,
    normalized_name:        String,
    permalink:              String,
    category_code:          Option[String],
    status:                 Option[String],
    founded_at:             Option[LocalDate],
    closed_at:              Option[LocalDate],
    domain:                 Option[String],
    homepage_url:           Option[String],
    twitter_username:       Option[String],
    logo_url:               Option[String],
    logo_width:             Option[Int],
    logo_height:            Option[Int],
    short_description:      Option[String],
    description:            Option[String],
    overview:               Option[String],
    tag_list:               Option[String],
    country_code:           Option[String],
    state_code:             Option[String],
    city:                   Option[String],
    region:                 Option[String],
    first_investment_at:    Option[LocalDate],
    last_investment_at:     Option[LocalDate],
    investment_rounds:      Option[Int],
    invested_companies:     Option[Int],
    first_funding_at:       Option[LocalDate],
    last_funding_at:        Option[LocalDate],
    funding_rounds:         Option[Int],
    funding_total_usd:      Option[BigDecimal],
    first_milestone_at:     Option[LocalDate],
    last_milestone_at:      Option[LocalDate],
    milestones:             Option[Int],
    relationships:          Option[Int],
    created_by:             Option[String],
    created_at:             Option[LocalDateTime],
    updated_at:             Option[LocalDateTime],
) extends CbObject

case class CbProductObject(
    id:                     CbProductObjectId,
    entity_type:            String,
    entity_id:              Long,
    parent_id:              Option[String],
    name:                   String,
    normalized_name:        String,
    permalink:              String,
    category_code:          Option[String],
    status:                 Option[String],
    founded_at:             Option[LocalDate],
    closed_at:              Option[LocalDate],
    domain:                 Option[String],
    homepage_url:           Option[String],
    twitter_username:       Option[String],
    logo_url:               Option[String],
    logo_width:             Option[Int],
    logo_height:            Option[Int],
    short_description:      Option[String],
    description:            Option[String],
    overview:               Option[String],
    tag_list:               Option[String],
    country_code:           Option[String],
    state_code:             Option[String],
    city:                   Option[String],
    region:                 Option[String],
    first_investment_at:    Option[LocalDate],
    last_investment_at:     Option[LocalDate],
    investment_rounds:      Option[Int],
    invested_companies:     Option[Int],
    first_funding_at:       Option[LocalDate],
    last_funding_at:        Option[LocalDate],
    funding_rounds:         Option[Int],
    funding_total_usd:      Option[BigDecimal],
    first_milestone_at:     Option[LocalDate],
    last_milestone_at:      Option[LocalDate],
    milestones:             Option[Int],
    relationships:          Option[Int],
    created_by:             Option[String],
    created_at:             Option[LocalDateTime],
    updated_at:             Option[LocalDateTime],
) extends CbObject

object CbObject{
    type CbObjectHList =
        CbObjectId              ::
        String                  ::
        Long                    ::
        Option[String]          ::
        String                  ::
        String                  ::
        String                  ::
        Option[String]          ::
        Option[String]          ::
        Option[LocalDate]       ::
        Option[LocalDate]       ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[Int]             ::
        Option[Int]             ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[String]          ::
        Option[LocalDate]       ::
        Option[LocalDate]       ::
        Option[Int]             ::
        Option[Int]             ::
        Option[LocalDate]       ::
        Option[LocalDate]       ::
        Option[Int]             ::
        Option[BigDecimal]      ::
        Option[LocalDate]       ::
        Option[LocalDate]       ::
        Option[Int]             ::
        Option[Int]             ::
        Option[String]          ::
        Option[LocalDateTime]   ::
        Option[LocalDateTime]   ::
        HNil

}


