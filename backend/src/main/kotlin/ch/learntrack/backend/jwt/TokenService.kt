package ch.learntrack.backend.jwt

import ch.learntrack.backend.BackendProperties
import ch.learntrack.backend.common.LearnTrackAuthorizationException
import io.jsonwebtoken.Jwts

import java.lang.Exception
import java.time.Instant
import java.time.temporal.ChronoUnit
import java.util.Date
import java.util.UUID
import javax.crypto.spec.SecretKeySpec

public class TokenService(private val backendProperties: BackendProperties) {
    public fun createJwtToken(userId: UUID): String = Jwts.builder()
        .subject(userId.toString())
        .expiration(Date.from(Instant.now().plus(backendProperties.jwt.expirationInHours, ChronoUnit.HOURS)))
        .signWith(backendProperties.jwt.key.toSecretKey())
        .compact()

    public fun parseIdFromToken(jwt: String): UUID {
        try {
            val userId = Jwts.parser()
                .verifyWith(backendProperties.jwt.key.toSecretKey())
                .build()
                .parseSignedClaims(jwt)
                .payload
                .subject

            return UUID.fromString(userId)
        } catch (e: Exception) {
            throw LearnTrackAuthorizationException("Invalid token")
        }
    }

    private fun String.toSecretKey() = SecretKeySpec(this.toByteArray(), "HmacSHA256")
}
