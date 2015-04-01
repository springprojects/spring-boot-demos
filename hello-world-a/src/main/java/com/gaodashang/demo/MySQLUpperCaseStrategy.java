package com.gaodashang.demo;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * comments.
 *
 * @author eva
 */
public class MySQLUpperCaseStrategy extends ImprovedNamingStrategy {

    public String classToTableName(String className) {
        return super.classToTableName(className).toUpperCase();
    }

    public String propertyToColumnName(String propertyName) {
        return super.propertyToColumnName(propertyName).toUpperCase();
    }

    public String tableName(String tableName) {
        return super.tableName(tableName).toUpperCase();
    }

    public String columnName(String columnName) {
        return super.columnName(columnName).toUpperCase();
    }

}
