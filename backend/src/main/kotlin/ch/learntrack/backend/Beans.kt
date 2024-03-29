package ch.learntrack.backend

import ch.learntrack.backend.common.LearnTrackExceptionHandler
import ch.learntrack.backend.grade.gradeBeans
import ch.learntrack.backend.jwt.jwtBeans
import ch.learntrack.backend.school.schoolBeans
import ch.learntrack.backend.security.securityBeans
import ch.learntrack.backend.user.userBeans
import ch.learntrack.backend.usergrade.userGradeBeans
import ch.learntrack.backend.userschool.userSchoolBeans
import ch.learntrack.backend.whoami.whoamiBeans
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.media.Schema
import org.springdoc.core.customizers.OpenApiCustomizer
import org.springframework.context.support.BeanDefinitionDsl
import org.springframework.context.support.beans

private val libraryBeans = beans {
    bean {
        OpenApiCustomizer { openApi: OpenAPI ->
            // Mark nullable types as such in the OpenAPI spec to improve the generated TypeScript types
            openApi.components.schemas.values
                .filter { schema: Schema<*> -> schema.type == "object" }
                .forEach { schema: Schema<*> ->
                    if (schema.properties != null && schema.required != null) {
                        schema.properties.entries
                            .filter { prop -> !schema.required.contains(prop.key) }
                            .forEach { entry -> entry.value.setNullable(true) }
                    }
                }
        }
    }
}

private val handlerBeans = beans {
    bean<LearnTrackExceptionHandler>()
}

public val beans: List<BeanDefinitionDsl> = listOf(
    libraryBeans,
    handlerBeans,
    userBeans,
    jwtBeans,
    securityBeans,
    whoamiBeans,
    gradeBeans,
    schoolBeans,
    userSchoolBeans,
    userGradeBeans,
)
