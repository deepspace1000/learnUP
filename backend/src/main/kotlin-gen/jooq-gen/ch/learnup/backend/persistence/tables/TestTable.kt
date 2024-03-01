/*
 * This file is generated by jOOQ.
 */
package ch.learnup.backend.persistence.tables


import ch.learnup.backend.persistence.LearnupBackend
import ch.learnup.backend.persistence.tables.records.TestRecord

import kotlin.collections.Collection

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.InverseForeignKey
import org.jooq.Name
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
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class TestTable(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, TestRecord>?,
    parentPath: InverseForeignKey<out Record, TestRecord>?,
    aliased: Table<TestRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<TestRecord>(
    alias,
    LearnupBackend.LEARNUP_BACKEND,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>learnup_backend.t_test</code>
         */
        val TEST: TestTable = TestTable()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<TestRecord> = TestRecord::class.java

    /**
     * The column <code>learnup_backend.t_test.test</code>.
     */
    val TEST_: TableField<TestRecord, String?> = createField(DSL.name("test"), SQLDataType.VARCHAR(255).defaultValue(DSL.field(DSL.raw("NULL"), SQLDataType.VARCHAR)), this, "")

    private constructor(alias: Name, aliased: Table<TestRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<TestRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<TestRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>learnup_backend.t_test</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>learnup_backend.t_test</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>learnup_backend.t_test</code> table reference
     */
    constructor(): this(DSL.name("t_test"), null)
    override fun getSchema(): Schema? = if (aliased()) null else LearnupBackend.LEARNUP_BACKEND
    override fun `as`(alias: String): TestTable = TestTable(DSL.name(alias), this)
    override fun `as`(alias: Name): TestTable = TestTable(alias, this)
    override fun `as`(alias: Table<*>): TestTable = TestTable(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): TestTable = TestTable(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): TestTable = TestTable(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): TestTable = TestTable(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition): TestTable = TestTable(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): TestTable = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition): TestTable = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>): TestTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): TestTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): TestTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): TestTable = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): TestTable = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): TestTable = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): TestTable = where(DSL.notExists(select))
}
