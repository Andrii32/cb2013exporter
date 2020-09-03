package domain.nested.models

import domain.normal.models._


case class NestedInvestment(
    investment:         CbInvestment,
    investor_object:    CbObject
)