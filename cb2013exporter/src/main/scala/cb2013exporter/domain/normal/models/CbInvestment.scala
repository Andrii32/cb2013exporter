package domain.normal.models

import java.time.{LocalDate, LocalDateTime}


case class CbInvestment(
    id:                 Long,
    funding_round_id:   Long,
    funded_object_id:   CbCompanyObjectId,
    investor_object_id: CbObjectId,
    created_at:         Option[LocalDateTime],
    updated_at:         Option[LocalDateTime],
)


