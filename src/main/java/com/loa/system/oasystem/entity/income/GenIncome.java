package com.loa.system.oasystem.entity.income;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.Data;

@Data
public class GenIncome {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table income
     *
     * @mbg.generated
     */
    public static final Short IS_DELETED = Del.IS_DELETED.value();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table income
     *
     * @mbg.generated
     */
    public static final Short NOT_DELETED = Del.NOT_DELETED.value();

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income.icid
     *
     * @mbg.generated
     */
    private Short icid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income.amount
     *
     * @mbg.generated
     */
    private Double amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income.icdate
     *
     * @mbg.generated
     */
    private LocalDateTime icdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income.ictype
     *
     * @mbg.generated
     */
    private String ictype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income.indesc
     *
     * @mbg.generated
     */
    private String indesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income.userid
     *
     * @mbg.generated
     */
    private String userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column income.del
     *
     * @mbg.generated
     */
    private Short del;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table income
     *
     * @mbg.generated
     */
    public void andLogicalDeleted(boolean deleted) {
        setDel(deleted ? Del.IS_DELETED.value() : Del.NOT_DELETED.value());
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table income
     *
     * @mbg.generated
     */
    public enum Del {
        NOT_DELETED(new Short("0"), "未删除"),
        IS_DELETED(new Short("1"), "已删除");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private final Short value;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private final String name;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        Del(Short value, String name) {
            this.value = value;
            this.name = name;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public Short getValue() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public Short value() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String getName() {
            return this.name;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table income
     *
     * @mbg.generated
     */
    public enum Column {
        icid("icid", "icid", "SMALLINT", false),
        amount("amount", "amount", "DOUBLE", false),
        icdate("icdate", "icdate", "TIMESTAMP", false),
        ictype("ictype", "ictype", "VARCHAR", false),
        indesc("indesc", "indesc", "VARCHAR", false),
        userid("userid", "userid", "VARCHAR", false),
        del("del", "del", "SMALLINT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table income
         *
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public static Column[] all() {
            return Column.values();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table income
         *
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}