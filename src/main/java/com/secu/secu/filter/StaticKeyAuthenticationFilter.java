package com.secu.secu.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class StaticKeyAuthenticationFilter implements Filter {

  private String authorizationKey = "SD9cICjl1e";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    var httpRequest = (HttpServletRequest)request;
    var httpResponse = (HttpServletResponse)response;

    String authentication = httpRequest.getHeader("Authorization");
    if (authorizationKey.equals(authentication)) {
      chain.doFilter(request, response);
    } else {
      httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
