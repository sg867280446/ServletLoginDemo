package main.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("�µ�session������,idΪ : "+arg0.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session������,idΪ : "+arg0.getSession().getId());
	}

}
