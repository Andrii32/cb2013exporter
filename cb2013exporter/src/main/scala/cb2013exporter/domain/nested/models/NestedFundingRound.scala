package domain.nested.models

import domain.normal.models._


case class NestedFundingRound(
    funding_round:      CbFundingRound,
    investments:        List[NestedInvestment],
)