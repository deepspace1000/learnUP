/*
 * This file is generated by jOOQ.
 */
package ch.learntrack.backend.persistence.tables


import ch.learntrack.backend.persistence.Public
import ch.learntrack.backend.persistence.keys.PK_SCHOOL
import ch.learntrack.backend.persistence.keys.T_GRADE__FK_GRADE_SCHOOL
import ch.learntrack.backend.persistence.keys.T_USER_SCHOOL__FK_USER_SCHOOL_SCHOOL
import ch.learntrack.backend.persistence.tables.GradeTable.TGradePath
import ch.learntrack.backend.persistence.tables.UserSchoolTable.TUserSchoolPath
import ch.learntrack.backend.persistence.tables.UserTable.TUserPath
import ch.learntrack.backend.persistence.tables.records.SchoolRecord

import java.time.LocalDateTime
import java.util.UUID

import kotlin.collections.Collection

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
public open class SchoolTable(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, SchoolRecord>?,
    parentPath: InverseForeignKey<out Record, SchoolRecord>?,
    aliased: Table<SchoolRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<SchoolRecord>(
    alias,
    Public.PUBLIC,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    public companion object {

        /**
         * The reference instance of <code>public.t_school</code>
         */
        public val SCHOOL: SchoolTable = SchoolTable()
    }

    /**
     * The class holding records for this type
     */
    public override fun getRecordType(): Class<SchoolRecord> = SchoolRecord::class.java

    /**
     * The column <code>public.t_school.id</code>.
     */
    public val ID: TableField<SchoolRecord, UUID?> = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.t_school.name</code>.
     */
    public val NAME: TableField<SchoolRecord, String?> = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "")

    /**
     * The column <code>public.t_school.address</code>.
     */
    public val ADDRESS: TableField<SchoolRecord, String?> = createField(DSL.name("address"), SQLDataType.VARCHAR.nullable(false), this, "")

    /**
     * The column <code>public.t_school.city</code>.
     */
    public val CITY: TableField<SchoolRecord, String?> = createField(DSL.name("city"), SQLDataType.VARCHAR.nullable(false), this, "")

    /**
     * The column <code>public.t_school.postcode</code>.
     */
    public val POSTCODE: TableField<SchoolRecord, Int?> = createField(DSL.name("postcode"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>public.t_school.created</code>.
     */
    public val CREATED: TableField<SchoolRecord, LocalDateTime?> = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.t_school.updated</code>.
     */
    public val UPDATED: TableField<SchoolRecord, LocalDateTime?> = createField(DSL.name("updated"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<SchoolRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<SchoolRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<SchoolRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.t_school</code> table reference
     */
    public constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.t_school</code> table reference
     */
    public constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.t_school</code> table reference
     */
    public constructor(): this(DSL.name("t_school"), null)

    public constructor(path: Table<out Record>, childPath: ForeignKey<out Record, SchoolRecord>?, parentPath: InverseForeignKey<out Record, SchoolRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, SCHOOL, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public open class TSchoolPath : SchoolTable, Path<SchoolRecord> {
        public constructor(path: Table<out Record>, childPath: ForeignKey<out Record, SchoolRecord>?, parentPath: InverseForeignKey<out Record, SchoolRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<SchoolRecord>): super(alias, aliased)
        public override fun `as`(alias: String): TSchoolPath = TSchoolPath(DSL.name(alias), this)
        public override fun `as`(alias: Name): TSchoolPath = TSchoolPath(alias, this)
        public override fun `as`(alias: Table<*>): TSchoolPath = TSchoolPath(alias.qualifiedName, this)
    }
    public override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    public override fun getPrimaryKey(): UniqueKey<SchoolRecord> = PK_SCHOOL

    private lateinit var _tGrade: TGradePath

    /**
     * Get the implicit to-many join path to the <code>public.t_grade</code>
     * table
     */
    public fun tGrade(): TGradePath {
        if (!this::_tGrade.isInitialized)
            _tGrade = TGradePath(this, null, T_GRADE__FK_GRADE_SCHOOL.inverseKey)

        return _tGrade;
    }

    public val tGrade: TGradePath
        get(): TGradePath = tGrade()

    private lateinit var _tUserSchool: TUserSchoolPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.t_user_school</code> table
     */
    public fun tUserSchool(): TUserSchoolPath {
        if (!this::_tUserSchool.isInitialized)
            _tUserSchool = TUserSchoolPath(this, null, T_USER_SCHOOL__FK_USER_SCHOOL_SCHOOL.inverseKey)

        return _tUserSchool;
    }

    public val tUserSchool: TUserSchoolPath
        get(): TUserSchoolPath = tUserSchool()

    /**
     * Get the implicit many-to-many join path to the <code>public.t_user</code>
     * table
     */
    public val tUser: TUserPath
        get(): TUserPath = tUserSchool().tUser()
    public override fun `as`(alias: String): SchoolTable = SchoolTable(DSL.name(alias), this)
    public override fun `as`(alias: Name): SchoolTable = SchoolTable(alias, this)
    public override fun `as`(alias: Table<*>): SchoolTable = SchoolTable(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    public override fun rename(name: String): SchoolTable = SchoolTable(DSL.name(name), null)

    /**
     * Rename this table
     */
    public override fun rename(name: Name): SchoolTable = SchoolTable(name, null)

    /**
     * Rename this table
     */
    public override fun rename(name: Table<*>): SchoolTable = SchoolTable(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    public override fun where(condition: Condition): SchoolTable = SchoolTable(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    public override fun where(conditions: Collection<Condition>): SchoolTable = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    public override fun where(vararg conditions: Condition): SchoolTable = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    public override fun where(condition: Field<Boolean?>): SchoolTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(condition: SQL): SchoolTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(@Stringly.SQL condition: String): SchoolTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(@Stringly.SQL condition: String, vararg binds: Any?): SchoolTable = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): SchoolTable = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    public override fun whereExists(select: Select<*>): SchoolTable = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    public override fun whereNotExists(select: Select<*>): SchoolTable = where(DSL.notExists(select))
}
