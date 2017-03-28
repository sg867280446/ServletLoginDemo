package main.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.wrapper.SessionWrapper;

@WebFilter(filterName="SessionFilter",urlPatterns="/*")
public class C_SessionFilter implements Filter{
	@Override
	public void destroy() {
		System.out.println("Session filter destory");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Session filter working");
		SessionWrapper wrapper = new SessionWrapper((HttpServletRequest)request);
		
		
		HttpSession session = wrapper.getSession();
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		httpServletResponse.addCookie(cookie);
		
		filterChain.doFilter(wrapper, httpServletResponse);
		System.out.println("Session filter end");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Session filter init");
	}
}
