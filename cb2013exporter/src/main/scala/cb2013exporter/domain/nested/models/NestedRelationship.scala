package domain.nested.models

import domain.normal.models._


case class NestedRelationship(
    relationship:       CbRelationship,
    person:             NestedPerson
)
