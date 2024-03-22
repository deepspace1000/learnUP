package ch.learnup.backend.whoami

import ch.learnup.backend.IntegrationTest
import ch.learnup.backend.utils.createGradeFromTemplate
import ch.learnup.backend.utils.createSchoolFromTemplate
import ch.learnup.backend.utils.createUserFromTemplate
import ch.learnup.backend.utils.createUserGradeFromTemplate
import ch.learnup.backend.utils.createUserSchoolFromTemplate
import ch.learnup.backend.utils.deleteAll
import ch.learnup.backend.utils.gradeTemplateId
import ch.learnup.backend.utils.runInTransaction
import ch.learnup.backend.utils.schoolTemplateId
import ch.learnup.backend.utils.userTemplateId
import java.util.UUID
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

private const val schoolNotAssigned = "eff58eb7-6214-468f-b7b4-2894d897dffb"
class WhoamiIntegrationTest: IntegrationTest() {

    private val schoolNotAssignedId = UUID.fromString(schoolNotAssigned)
    @BeforeEach
    fun seedDatabase() {
        transactionManager.runInTransaction {
            userDao.insert(createUserFromTemplate())
            schoolDao.insert(createSchoolFromTemplate())
            schoolDao.insert(createSchoolFromTemplate(id = schoolNotAssignedId))
            gradeDao.insert(createGradeFromTemplate())
            userSchoolDao.insert(createUserSchoolFromTemplate())
            userGradeDao.insert(createUserGradeFromTemplate())
        }
    }

    @AfterEach
    fun cleanUp() {
        transactionManager.runInTransaction {
            userDao.deleteAll()
            schoolDao.deleteAll()
            gradeDao.deleteAll()
            userSchoolDao.deleteAll()
            userGradeDao.deleteAll()
        }
    }

    @Test
    fun `should return whoami dto`() {
        val result = webClient.get()
            .uri("/whoami")
            .exchange()
            .expectStatus().isOk()
            .expectBody(WhoamiDto::class.java)
            .returnResult().responseBody

        assertThat(requireNotNull(result?.user?.id))
            .isEqualTo(userTemplateId)

        assertThat(requireNotNull(result?.schools?.any { it.id == schoolTemplateId }))
            .isEqualTo(true)

        assertThat(requireNotNull(result?.grades?.any { it.id == gradeTemplateId }))
            .isEqualTo(true)
    }

    @Test
    fun `should not return school for User`() {
        val result = webClient.get()
            .uri("/whoami")
            .exchange()
            .expectStatus().isOk()
            .expectBody(WhoamiDto::class.java)
            .returnResult().responseBody

        assertThat(requireNotNull(result?.user?.id))
            .isEqualTo(userTemplateId)

        assertThat(requireNotNull(result?.schools?.any { it.id == schoolNotAssignedId }))
            .isEqualTo(false)

        assertThat(requireNotNull(result?.grades?.any { it.id == gradeTemplateId }))
            .isEqualTo(true)
    }
}