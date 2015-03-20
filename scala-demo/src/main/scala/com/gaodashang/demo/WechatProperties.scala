package com.gaodashang.demo

import org.springframework.boot.context.properties.ConfigurationProperties

import scala.beans.BeanProperty

/**
 * wechat properties.
 * @author eva
 */
@ConfigurationProperties("wechat")
class WechatProperties {

  @BeanProperty
  var appid: String = _

  @BeanProperty
  var secret: String = _

  @BeanProperty
  var accessTokenUrl: String = _

  @BeanProperty
  var jsApiTicketUrl: String = _

  @BeanProperty
  var nonce: String = _
}
