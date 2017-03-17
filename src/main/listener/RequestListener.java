package main.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request 已经被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("一个新的request被创建了");
	}

}
