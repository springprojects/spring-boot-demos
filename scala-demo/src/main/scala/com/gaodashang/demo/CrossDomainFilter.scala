package com.gaodashang.demo

import java.io.IOException
import javax.servlet._
import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component

/**
 * cross domain filter.
 * @author eva
 */
@Component class CrossDomainFilter extends Filter {

  @throws(classOf[ServletException])
  override def init(filterConfig: FilterConfig) {
  }

  @throws(classOf[IOException])
  @throws(classOf[ServletException])
  override def doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
    val servletResponse: HttpServletResponse = response.asInstanceOf[HttpServletResponse]
    servletResponse.setHeader("Access-Control-Allow-Origin", "*")
    servletResponse.setHeader("Access-Crontrol-Allow-Methods", "POST,GET,OPTIONS,DELETE")
    servletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type")
    chain.doFilter(request, servletResponse)
  }

  override def destroy {
  }
}
