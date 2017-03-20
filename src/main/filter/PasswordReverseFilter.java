package main.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import main.wrapper.PasswordReverseWrapper;

@WebFilter(filterName="PasswordReverseFilter",urlPatterns="/*")
public class PasswordReverseFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("password reverse filter destory");		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("password reverse filter working");
		PasswordReverseWrapper prw = new PasswordReverseWrapper((HttpServletRequest)request);
		filterChain.doFilter(prw, response);
		System.out.println("password reverse filter end");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("password reverse filter init");	
	}

}
