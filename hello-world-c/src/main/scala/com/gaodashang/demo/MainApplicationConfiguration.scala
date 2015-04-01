package com.gaodashang.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.ApplicationContext

/**
 * main application configuration.
 * @author eva
 */
@SpringBootApplication
class MainApplicationConfiguration extends SpringBootServletInitializer {

}

object MainApplicationConfiguration {
  def main(args: Array[String]) {
    val ctx:ApplicationContext = SpringApplication.run(classOf[MainApplicationConfiguration], args :_*)
    println("inspect the beans provided by Spring Boot:")
    val beanNames:Array[String] = ctx.getBeanDefinitionNames()
    java.util.Arrays.sort(beanNames, String.CASE_INSENSITIVE_ORDER)
    for (beanName <- beanNames) {
      println(beanName)
    }
  }
}
