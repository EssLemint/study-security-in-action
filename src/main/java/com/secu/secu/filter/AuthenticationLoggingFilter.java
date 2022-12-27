package com.secu.secu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {

  private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    var httpRequest = (HttpServletRequest)request;
    var httpResponse = (HttpServletResponse)response;

    String requestId = httpRequest.getHeader("Request-Id");
    logger.info("authenticated requestId  = " + requestId);

    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
