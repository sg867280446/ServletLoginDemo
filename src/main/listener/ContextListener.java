package main.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		/**
		 * �����ر�ʱ�Ż����
		 */
		System.out.println("servletcontext �ݻ���");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("servletcontext ������");
	}

}
