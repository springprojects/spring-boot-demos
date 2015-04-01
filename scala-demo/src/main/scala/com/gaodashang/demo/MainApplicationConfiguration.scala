package com.gaodashang.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{SpringBootApplication, EnableAutoConfiguration}
import org.springframework.boot.autoconfigure.web.HttpEncodingProperties
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.scheduling.annotation.EnableScheduling

/**
 * main application configuration.
 * @author eva
 */
@SpringBootApplication
@EnableScheduling
class MainApplicationConfiguration extends SpringBootServletInitializer {

  @Autowired private val encodingProperties: HttpEncodingProperties = null

  /**
   * 用来处理@ResponseBody返回时请求头中Accept太大的问题
   * @return
   */
  @Bean def stringHttpMessageConverter: StringHttpMessageConverter = {
    val stringHttpMessageConverter: StringHttpMessageConverter = new StringHttpMessageConverter(this.encodingProperties.getCharset)
    stringHttpMessageConverter.setWriteAcceptCharset(false)
    stringHttpMessageConverter
  }

  override def configure(builder: SpringApplicationBuilder): SpringApplicationBuilder = {
    builder.sources(classOf[MainApplicationConfiguration])
  }
}

object MainApplicationConfiguration {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[MainApplicationConfiguration], args :_*)
  }
}
