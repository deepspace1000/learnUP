package ch.learntrack.backend.grade

import ch.learntrack.backend.common.EntityService
import ch.learntrack.backend.persistence.fetchByNameAndSchoolId
import ch.learntrack.backend.persistence.fetchGradesForUserByUserId
import ch.learntrack.backend.persistence.tables.daos.GradeDao
import ch.learntrack.backend.persistence.tables.pojos.Grade
import ch.learntrack.backend.persistence.tables.records.GradeRecord
import java.util.UUID

public class GradeService(private val gradeDao: GradeDao) : EntityService<GradeDto, GradeRecord, Grade>(gradeDao) {
    public override fun mapToDto(pojo: Grade): GradeDto = GradeDto(
        id = pojo.id,
        name = pojo.name,
        schoolId = pojo.schoolId,
    )

    public fun getGradesForUserByUserId(userId: UUID): List<GradeDto> = gradeDao.fetchGradesForUserByUserId(userId).map(
        ::mapToDto,
    )

    public fun getGradesBySchoolId(schoolId: UUID): List<GradeDto> = gradeDao.fetchBySchoolId(schoolId).map(
        ::mapToDto)

    public fun getGradeByNameAndSchoolId(schoolId: UUID, name: String): Grade? = gradeDao.fetchByNameAndSchoolId(
        schoolId,
        name,
    )

    public fun isGradeNameExistingInThisSchool(schoolId: UUID, name: String): Boolean =
        getGradeByNameAndSchoolId(schoolId, name) != null
}
