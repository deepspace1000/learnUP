/*
 * This file is generated by jOOQ.
 */
package ch.learntrack.backend.persistence.tables.records


import ch.learntrack.backend.persistence.tables.UserGradeTable
import ch.learntrack.backend.persistence.tables.pojos.UserGrade

import java.util.UUID

import org.jetbrains.annotations.NotNull
import org.jooq.Record2
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
public open class UserGradeRecord private constructor() : UpdatableRecordImpl<UserGradeRecord>(UserGradeTable.USER_GRADE) {

    public open var userId: UUID
        set(value): Unit = set(0, value)
    @NotNull
        get(): UUID = get(0) as UUID

    public open var gradeId: UUID
        set(value): Unit = set(1, value)
    @NotNull
        get(): UUID = get(1) as UUID

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    public override fun key(): Record2<UUID?, UUID?> = super.key() as Record2<UUID?, UUID?>

    /**
     * Create a detached, initialised UserGradeRecord
     */
    public constructor(userId: UUID, gradeId: UUID): this() {
        this.userId = userId
        this.gradeId = gradeId
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised UserGradeRecord
     */
    public constructor(value: UserGrade?): this() {
        if (value != null) {
            this.userId = value.userId
            this.gradeId = value.gradeId
            resetChangedOnNotNull()
        }
    }
}