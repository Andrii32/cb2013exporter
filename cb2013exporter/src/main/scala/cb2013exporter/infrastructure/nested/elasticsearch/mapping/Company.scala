package infrastructure.nested.elasticsearch.mapping

import com.sksamuel.elastic4s.requests.mappings.dynamictemplate.DynamicMapping
import com.sksamuel.elastic4s.requests.indexes.CreateIndexResponse
import com.sksamuel.elastic4s.ElasticDsl._


object CompanyMapping{

    lazy val mapping = properties(
        keywordField("id"),
        objectField("company_object").fields(
            objectFields
        ),
        objectField("offices").fields(
            officeFields
        ),
        objectField("ipos").fields(
            ipoFields
        ),
        objectField("funding_rounds").fields(
            fundingRoundFields
        ),
        objectField("relationships").fields(
            relationshipFields
        ),
        objectField("acquired").fields(
            acquiredFields
        ),
        objectField("acquiring").fields(
            acquiringFields
        ),
        objectField("milestones").fields(
            milestoneFields
        ),
    )
    .dynamic(DynamicMapping.Strict)

    lazy val fundingRoundFields = List(
        objectField("funding_round").fields(
            keywordField("id"),
            keywordField("funding_round_id"),
            keywordField("object_id"),
            dateField("funded_at"),
            keywordField("funding_round_type"),
            keywordField("funding_round_code"),
            longField("raised_amount_usd"),
            longField("raised_amount"),
            keywordField("raised_currency_code"),
            longField("pre_money_valuation_usd"),
            longField("pre_money_valuation"),
            keywordField("pre_money_currency_code"),
            longField("post_money_valuation_usd"),
            longField("post_money_valuation"),
            keywordField("post_money_currency_code"),
            intField("participants"),
            intField("is_first_round"),
            intField("is_last_round"),
            keywordField("source_url"),
            keywordField("source_description"),
            keywordField("created_by"),
            dateField("created_at"),
            dateField("updated_at")
        ),
        objectField("investments").fields(
            objectField("investment").fields(
                investmentFields
            ),
            objectField("investor_object").fields(
                objectFields
            )
        )
    )

    lazy val investmentFields = List(
        keywordField("id"),
        keywordField("funding_round_id"),
        keywordField("funded_object_id"),
        keywordField("investor_object_id"),
        dateField("created_at"),
        dateField("updated_at")
    )

    lazy val relationshipFields = List(
        objectField("relationship").fields(
            keywordField("id"),
            keywordField("relationship_id"),
            keywordField("person_object_id"),
            keywordField("relationship_object_id"),
            dateField("start_at"),
            dateField("end_at"),
            intField("is_past"),
            intField("sequence"),
            keywordField("title"),
            dateField("created_at"),
            dateField("updated_at")
        ),
        objectField("person").fields(
            personFields
        ),
    )

    lazy val personFields = List(
        objectField("person_object").fields(
            objectFields
        ),
        objectField("person").fields(
            keywordField("id"),
            keywordField("object_id"),
            keywordField("first_name"),
            keywordField("last_name"),
            keywordField("birthplace"),
            keywordField("affiliation_name")
        ),
        objectField("degrees").fields(
            keywordField("id"),
            keywordField("object_id"),
            keywordField("degree_type"),
            keywordField("subject"),
            keywordField("institution"),
            dateField("graduated_at"),
            dateField("created_at"),
            dateField("updated_at")
        )
    )

    lazy val acquiredFields = List(
        objectField("acuisition").fields(
            acquisitionFields
        ),
        objectField("acquired").fields(
            objectFields
        )
    )

    lazy val acquiringFields = List(
        objectField("acuisition").fields(
            acquisitionFields
        ),
        objectField("acquiring").fields(
            objectFields
        )
    )

    lazy val acquisitionFields = List(
        keywordField("id"),
        keywordField("acquisition_id"),
        keywordField("acquiring_object_id"),
        keywordField("acquired_object_id"),
        keywordField("term_code"),
        longField("price_amount"),
        keywordField("price_currency_code"),
        dateField("acquired_at"),
        keywordField("source_url"),
        keywordField("source_description"),
        dateField("created_at"),
        dateField("updated_at")
    )

    lazy val milestoneFields = List(
        keywordField("id"),
        keywordField("object_id"),
        keywordField("milestone_at"),
        keywordField("milestone_code"),
        keywordField("description"),
        keywordField("source_url"),
        keywordField("source_description"),
        keywordField("created_at"),
        keywordField("updated_at")
    )

    lazy val ipoFields = List(
        keywordField("id"),
        keywordField("ipo_id"),
        keywordField("object_id"),
        longField("valuation_amount"),
        keywordField("valuation_currency_code"),
        longField("raised_amount"),
        keywordField("raised_currency_code"),
        dateField("public_at"),
        keywordField("stock_symbol"),
        keywordField("source_url"),
        keywordField("source_description"),
        dateField("created_at"),
        dateField("updated_at")
    )

    lazy val officeFields = List(
        keywordField("id"),
        keywordField("object_id"),
        keywordField("office_id"),
        keywordField("description"),
        keywordField("region"),
        keywordField("address1"),
        keywordField("address2"),
        keywordField("city"),
        keywordField("zip_code"),
        keywordField("state_code"),
        keywordField("country_code"),
        longField("latitude"),
        longField("longitude"),
        dateField("created_at"),
        dateField("updated_at")
    )

    lazy val objectFields = List(
        keywordField("id"),
        keywordField("entity_type"),
        keywordField("entity_id"),
        keywordField("parent_id"),
        keywordField("name"),
        keywordField("normalized_name"),
        keywordField("permalink"),
        keywordField("category_code"),
        keywordField("status"),
        dateField("founded_at"),
        dateField("closed_at"),
        keywordField("domain"),
        keywordField("homepage_url"),
        keywordField("twitter_username"),
        keywordField("logo_url"),
        intField("logo_width"),
        intField("logo_height"),
        keywordField("short_description"),
        keywordField("description"),
        keywordField("overview"),
        keywordField("tag_list"),
        keywordField("country_code"),
        keywordField("state_code"),
        keywordField("city"),
        keywordField("region"),
        dateField("first_investment_at"),
        dateField("last_investment_at"),
        intField("investment_rounds"),
        intField("invested_companies"),
        dateField("first_funding_at"),
        dateField("last_funding_at"),
        intField("funding_rounds"),
        longField("funding_total_usd"),
        dateField("first_milestone_at"),
        dateField("last_milestone_at"),
        intField("milestones"),
        intField("relationships"),
        keywordField("created_by"),
        dateField("created_at"),
        dateField("updated_at"),
    )
}


