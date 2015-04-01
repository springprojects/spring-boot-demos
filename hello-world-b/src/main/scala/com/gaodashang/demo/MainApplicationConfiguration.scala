package com.gaodashang.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.web.SpringBootServletInitializer

/**
 * main application configuration.
 * @author eva
 */
@SpringBootApplication
class MainApplicationConfiguration extends SpringBootServletInitializer {

}

object MainApplicationConfiguration {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[MainApplicationConfiguration], args :_*)
  }
}
