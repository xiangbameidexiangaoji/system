package com.loa.system.oasystem.entity.payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.Data;

@Data
public class GenPayment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table payment
     *
     * @mbg.generated
     */
    public static final Short IS_DELETED = Del.IS_DELETED.value();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table payment
     *
     * @mbg.generated
     */
    public static final Short NOT_DELETED = Del.NOT_DELETED.value();

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.pid
     *
     * @mbg.generated
     */
    private Short pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.payname
     *
     * @mbg.generated
     */
    private String payname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.amount
     *
     * @mbg.generated
     */
    private Double amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.paytime
     *
     * @mbg.generated
     */
    private LocalDateTime paytime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.expid
     *
     * @mbg.generated
     */
    private Short expid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.ename
     *
     * @mbg.generated
     */
    private String ename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.del
     *
     * @mbg.generated
     */
    private Short del;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
     *
     * @mbg.generated
     */
    public void andLogicalDeleted(boolean deleted) {
        setDel(deleted ? Del.IS_DELETED.value() : Del.NOT_DELETED.value());
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table payment
     *
     * @mbg.generated
     */
    public enum Del {
        NOT_DELETED(new Short("0"), "未删除"),
        IS_DELETED(new Short("1"), "已删除");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private final Short value;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private final String name;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        Del(Short value, String name) {
            this.value = value;
            this.name = name;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public Short getValue() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public Short value() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String getName() {
            return this.name;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table payment
     *
     * @mbg.generated
     */
    public enum Column {
        pid("pid", "pid", "SMALLINT", false),
        payname("payname", "payname", "VARCHAR", false),
        amount("amount", "amount", "DOUBLE", false),
        paytime("paytime", "paytime", "TIMESTAMP", false),
        expid("expid", "expid", "SMALLINT", false),
        ename("ename", "ename", "VARCHAR", false),
        del("del", "del", "SMALLINT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table payment
         *
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
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
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
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
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public static Column[] all() {
            return Column.values();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table payment
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
         * This method corresponds to the database table payment
         *
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}