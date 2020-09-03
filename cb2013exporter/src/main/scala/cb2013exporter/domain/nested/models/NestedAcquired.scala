package domain.nested.models

import domain.normal.models._


case class NestedAcquired(
    acuisition:         CbAcquisition,
    acquired:           CbObject
)