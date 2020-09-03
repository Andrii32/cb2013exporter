package domain.nested.models

import domain.normal.models._


case class NestedAcquiring(
    acuisition:         CbAcquisition,
    acquiring:          CbObject
)