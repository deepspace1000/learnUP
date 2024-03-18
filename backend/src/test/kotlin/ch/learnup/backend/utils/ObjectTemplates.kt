package ch.learnup.backend.utils

import ch.learnup.backend.persistence.UserRole
import ch.learnup.backend.persistence.tables.pojos.*
import java.util.UUID

val userTemplateId: UUID = UUID.fromString("40d8b918-8f80-4b92-a3f5-4548d7883c51")
val gradeTemplateId: UUID = UUID.fromString("40d8b918-8f80-4b92-a3f5-4548d7883c52")
val schoolTemplateId: UUID = UUID.fromString("40d8b918-8f80-4b92-a3f5-4548d7883c53")

fun createUserFromTemplate(
    id: UUID = userTemplateId,
    firstName: String = "test",
    lastName: String = "user",
    eMail: String = "testuser@gmail.com",
    password: String = "\$2a\$10\$IVLBCJ8ed8zh1aYeui6Nwu4uauH/Uwtrdkd5PshFdCP9Yo0U2ltjK",
) = User(
    id = id,
    firstName = firstName,
    lastName = lastName,
    eMail = eMail,
    password = password,
    userRole = UserRole.ADMIN,
)

fun createSchoolFromTemplate(
    id: UUID = schoolTemplateId,
    name: String = "Benedict",
    address: String = "Vulkanstrasse 106",
    city: String = "Zürich",
    postcode: Int = 8048,
) = School(
    id = id,
    name = name,
    address = address,
    city = city,
    postcode = postcode,
)

fun createGradeFromTemplate(
    id: UUID = gradeTemplateId,
    name: String = "Class 1A",
    schoolId: UUID = schoolTemplateId,
) = Grade(
    id = id,
    name = name,
    schoolId = schoolId,
)

fun createUserSchoolFromTemplate(
    userId: UUID = userTemplateId,
    schoolId: UUID = schoolTemplateId,
) = UserSchool(
    userId = userId,
    schoolId = schoolId,
)

fun createUserGradeFromTemplate(
    userId: UUID = userTemplateId,
    gradeId: UUID = gradeTemplateId,
) = UserGrade(
    userId = userId,
    gradeId = gradeId,
)