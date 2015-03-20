package com.gaodashang.demo

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.{AsyncSupportConfigurer, WebMvcConfigurerAdapter}

/**
 * comments.
 * @author eva
 */
@Configuration
class WebMvcConfiguration extends WebMvcConfigurerAdapter {

  override def configureAsyncSupport(configurer: AsyncSupportConfigurer): Unit = {
    super.configureAsyncSupport(configurer)
    configurer.setDefaultTimeout(30000)
  }

}
