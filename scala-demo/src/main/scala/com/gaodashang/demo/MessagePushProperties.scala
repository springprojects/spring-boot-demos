package com.gaodashang.demo

import org.springframework.boot.context.properties.ConfigurationProperties

import scala.beans.BeanProperty

/**
 * comments.
 * @author eva
 */
@ConfigurationProperties("messagepush.iphone")
class MessagePushProperties {

  @BeanProperty
  var key:String = _

  @BeanProperty
  var password:String = _

}
