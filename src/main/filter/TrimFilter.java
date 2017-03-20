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

import main.wrapper.TrimWrapper;

@WebFilter(filterName="TrimFilter",urlPatterns="/*")
public class TrimFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("time filter destory");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("time filter working");
		//request.para
		TrimWrapper wrapper = new TrimWrapper((HttpServletRequest)request);
		filterChain.doFilter(wrapper, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("time filter start");
	}
	
}
