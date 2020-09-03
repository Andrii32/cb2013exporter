package domain.nested.models

import domain.normal.models._


case class NestedCompany(
    id:                 CbCompanyObjectId,
    company_object:     CbObject,
    offices:            List[CbOffice],
    ipos:               List[CbIPO],
    funding_rounds:     List[NestedFundingRound],
    relationships:      List[NestedRelationship],
    acquired:           List[NestedAcquired],
    acquiring:          List[NestedAcquiring],
    milestones:         List[CbMilestone]
)
