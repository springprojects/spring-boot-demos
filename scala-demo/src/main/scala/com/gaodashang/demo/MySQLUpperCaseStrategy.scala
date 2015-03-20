package com.gaodashang.demo

import org.hibernate.cfg.ImprovedNamingStrategy

/**
 * comments.
 * @author eva
 */
class MySQLUpperCaseStrategy extends ImprovedNamingStrategy{
  override def columnName(columnName: String): String = {
    val columnLowerCaseName:String = super.columnName(columnName)
    val columnUpperCaseName:String = columnLowerCaseName.toUpperCase
    columnUpperCaseName
  }

  override def tableName(tableName: String): String = {
    super.tableName(tableName).toUpperCase
  }
}
