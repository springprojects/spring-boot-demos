package com.gaodashang.demo

import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.client.RestTemplate

/**
 * main configuration.
 * @author eva
 */
@Configuration
class MainConfiguration {

  @Bean def restTemplate: RestTemplate = {
    val restTemplate: RestTemplate = new RestTemplate
    return restTemplate
  }

}
