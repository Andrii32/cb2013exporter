package domain.nested.models

import domain.normal.models._


case class NestedPerson(
    person_object:      CbObject,
    person:             CbPerson,
    degrees:            List[CbDegree]
)