package com.gaodashang.demo.endpoint

import java.text.MessageFormat
import java.util.Date
import java.util.concurrent.{Callable, ThreadLocalRandom}
import javax.annotation.Resource

import com.gaodashang.demo.{WechatProperties, MessagePushProperties}
import com.gaodashang.demo.domain.{Ticket, Token}
import org.apache.commons.logging.{Log, LogFactory}
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, ResponseBody}
import org.springframework.web.client.RestTemplate

/**
 * comments.
 * @author eva
 */
@Controller
@RequestMapping(value = Array("/message"))
@EnableConfigurationProperties(Array(classOf[MessagePushProperties], classOf[WechatProperties]))
class MainController {

  private val logger: Log = LogFactory.getLog(getClass)
  private var token: Token = null
  private var ticket: Ticket = null

  @Resource
  private val restTemplate:RestTemplate = null

  @Resource
  private val wechatProperties: WechatProperties = null

  @Resource
  private val messagePushProperties: MessagePushProperties = null

  @RequestMapping(value = Array("/deferedOperate"))
  @ResponseBody
  def deferedOperateFunction(cc:String) = new Callable[Int] {
    override def call(): Int = {
      println(cc)
      val processTime: Int = ThreadLocalRandom.current().nextInt(10000, 20000)
      Thread.sleep(processTime)
      println(processTime + "s")
      processTime
    }
  }

  //30s
  @Scheduled(fixedRate = 1000 * 30)
  def updateAccessAndJsApiTicket {
    if (this.logger.isInfoEnabled) {
      this.logger.info("updateAccessAndJsApiTicket scheduled at " + new Date().toString)
    }
    var token: Token = null
    var ticket: Ticket = null
    try {
      token = getAccessToken
      ticket = getJsApiTicket(token.getAccess_token)
      if (this.logger.isInfoEnabled) {
        this.logger.info("accessToken is " + token + ", ticket is " + ticket + ", at " + new Date().toString)
      }
    }
    catch {
      case e: Exception => {
        if (null == token) {
          token = getAccessToken
        }
        if (null == ticket && null != token) {
          ticket = getJsApiTicket(token.getAccess_token)
        }
      }
    }
    this.token = token
    this.ticket = ticket
  }

  def getAccessToken: Token = {
    val url: String = wechatProperties.getAccessTokenUrl
    val result: Token = restTemplate.getForObject(url, classOf[Token])
    return result
  }

  def getJsApiTicket(accessToke: String): Ticket = {
    var url: String = wechatProperties.getJsApiTicketUrl
    url = MessageFormat.format(url, accessToke)
    val result: Ticket = restTemplate.getForObject(url, classOf[Ticket])
    return result
  }

}
