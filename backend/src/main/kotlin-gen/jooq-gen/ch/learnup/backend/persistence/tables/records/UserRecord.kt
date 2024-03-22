/*
 * This file is generated by jOOQ.
 */
package ch.learnup.backend.persistence.tables.records


import ch.learnup.backend.persistence.UserRole
import ch.learnup.backend.persistence.tables.UserTable
import ch.learnup.backend.persistence.tables.pojos.User

import java.time.LocalDateTime
import java.util.UUID

import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import org.jooq.Record1
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class UserRecord private constructor() : UpdatableRecordImpl<UserRecord>(UserTable.USER) {

    open var id: UUID
        set(value): Unit = set(0, value)
    @NotNull
        get(): UUID = get(0) as UUID

    open var firstName: String
        set(value): Unit = set(1, value)
    @NotNull
        get(): String = get(1) as String

    open var middleName: String?
        set(value): Unit = set(2, value)
    @Nullable
        get(): String? = get(2) as String?

    open var lastName: String
        set(value): Unit = set(3, value)
    @NotNull
        get(): String = get(3) as String

    open var eMail: String
        set(value): Unit = set(4, value)
    @NotNull
        get(): String = get(4) as String

    open var password: String
        set(value): Unit = set(5, value)
    @NotNull
        get(): String = get(5) as String

    open var userRole: UserRole
        set(value): Unit = set(6, value)
    @NotNull
        get(): UserRole = get(6) as UserRole

    open var birthdate: LocalDateTime?
        set(value): Unit = set(7, value)
    @Nullable
        get(): LocalDateTime? = get(7) as LocalDateTime?

    open var created: LocalDateTime?
        set(value): Unit = set(8, value)
    @Nullable
        get(): LocalDateTime? = get(8) as LocalDateTime?

    open var updated: LocalDateTime?
        set(value): Unit = set(9, value)
    @Nullable
        get(): LocalDateTime? = get(9) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<UUID?> = super.key() as Record1<UUID?>

    /**
     * Create a detached, initialised UserRecord
     */
    constructor(id: UUID, firstName: String, middleName: String? = null, lastName: String, eMail: String, password: String, userRole: UserRole, birthdate: LocalDateTime? = null, created: LocalDateTime? = null, updated: LocalDateTime? = null): this() {
        this.id = id
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.eMail = eMail
        this.password = password
        this.userRole = userRole
        this.birthdate = birthdate
        this.created = created
        this.updated = updated
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised UserRecord
     */
    constructor(value: User?): this() {
        if (value != null) {
            this.id = value.id
            this.firstName = value.firstName
            this.middleName = value.middleName
            this.lastName = value.lastName
            this.eMail = value.eMail
            this.password = value.password
            this.userRole = value.userRole
            this.birthdate = value.birthdate
            this.created = value.created
            this.updated = value.updated
            resetChangedOnNotNull()
        }
    }
}