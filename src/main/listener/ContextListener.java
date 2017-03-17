package main.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		/**
		 * 正常关闭时才会调用
		 */
		System.out.println("servletcontext 摧毁了");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("servletcontext 建立了");
	}

}
