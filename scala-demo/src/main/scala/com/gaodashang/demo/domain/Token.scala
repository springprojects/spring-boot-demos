package com.gaodashang.demo.domain

import scala.beans.BeanProperty

/**
 * token.
 * @author eva
 */
class Token {

  @BeanProperty
  var access_token: String = null

  @BeanProperty
  var expires_in: Int = 0

  override def toString: String = "Token{" + "access_token='" + access_token + '\'' + ", expires_in=" + expires_in + '}'
}
