package com.gaodashang.demo.domain

import scala.beans.BeanProperty

/**
 * ticket.
 * @author eva
 */
class Ticket {
  @BeanProperty
  var errcode: Int = 0

  @BeanProperty
  var errmsg: String = null

  @BeanProperty
  var ticket: String = null

  @BeanProperty
  var expires_in: Int = 0

  override def toString: String = "Ticket{" + "errcode=" + errcode + ", errmsg='" + errmsg + '\'' + ", ticket='" + ticket + '\'' + ", expires_in=" + expires_in + '}'
}
