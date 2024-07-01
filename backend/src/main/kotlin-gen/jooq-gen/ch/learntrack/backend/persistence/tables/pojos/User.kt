/*
 * This file is generated by jOOQ.
 */
package ch.learntrack.backend.persistence.tables.pojos


import ch.learntrack.backend.persistence.UserRole

import java.io.Serializable
import java.time.LocalDateTime
import java.util.UUID


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
public data class User(
    public val id: UUID,
    public val firstName: String,
    public val middleName: String? = null,
    public val lastName: String,
    public val eMail: String,
    public val password: String,
    public val userRole: UserRole,
    public val birthdate: LocalDateTime? = null,
    public val created: LocalDateTime? = null,
    public val updated: LocalDateTime? = null
): Serializable {

    public override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: User = other as User
        if (this.id != o.id)
            return false
        if (this.firstName != o.firstName)
            return false
        if (this.middleName == null) {
            if (o.middleName != null)
                return false
        }
        else if (this.middleName != o.middleName)
            return false
        if (this.lastName != o.lastName)
            return false
        if (this.eMail != o.eMail)
            return false
        if (this.password != o.password)
            return false
        if (this.userRole != o.userRole)
            return false
        if (this.birthdate == null) {
            if (o.birthdate != null)
                return false
        }
        else if (this.birthdate != o.birthdate)
            return false
        if (this.created == null) {
            if (o.created != null)
                return false
        }
        else if (this.created != o.created)
            return false
        if (this.updated == null) {
            if (o.updated != null)
                return false
        }
        else if (this.updated != o.updated)
            return false
        return true
    }

    public override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + this.id.hashCode()
        result = prime * result + this.firstName.hashCode()
        result = prime * result + (if (this.middleName == null) 0 else this.middleName.hashCode())
        result = prime * result + this.lastName.hashCode()
        result = prime * result + this.eMail.hashCode()
        result = prime * result + this.password.hashCode()
        result = prime * result + this.userRole.hashCode()
        result = prime * result + (if (this.birthdate == null) 0 else this.birthdate.hashCode())
        result = prime * result + (if (this.created == null) 0 else this.created.hashCode())
        result = prime * result + (if (this.updated == null) 0 else this.updated.hashCode())
        return result
    }

    public override fun toString(): String {
        val sb = StringBuilder("User (")

        sb.append(id)
        sb.append(", ").append(firstName)
        sb.append(", ").append(middleName)
        sb.append(", ").append(lastName)
        sb.append(", ").append(eMail)
        sb.append(", ").append(password)
        sb.append(", ").append(userRole)
        sb.append(", ").append(birthdate)
        sb.append(", ").append(created)
        sb.append(", ").append(updated)

        sb.append(")")
        return sb.toString()
    }
}
