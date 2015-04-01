package com.gaodashang.demo

import org.apache.commons.logging.{LogFactory, Log}
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

/**
 * comments.
 * @author eva
 */
class ApplicationStartup extends ApplicationListener[ContextRefreshedEvent]{

  private val logger: Log = LogFactory.getLog(getClass)

  override def onApplicationEvent(event: ContextRefreshedEvent): Unit = {
    logger.debug("context refreshed.")
  }
}
