package ch.learntrack.backend.admin.grade

import java.util.UUID

public data class GradeDto(
    val id: UUID,
    val name: String,
)

public data class CreateGradeDto(
    val name: String,
    val schoolId: UUID,
)