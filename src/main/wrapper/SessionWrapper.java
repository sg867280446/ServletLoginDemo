package main.wrapper;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import main.session.MySession;

public class SessionWrapper extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public static Map<String,HttpSession> map = new HashMap<String,HttpSession>();
	public SessionWrapper(HttpServletRequest request) {		
		super(request);
		this.request = request;
		// TODO Auto-generated constructor stub
	}
	
	public HttpSession getSession(){
		Cookie [] cookies = request.getCookies();
		
		if(cookies != null){
			for(Cookie c : cookies){
				if(c.getName().equals("JSESSIONID")&&map.containsKey(c.getValue())){
					return map.get(c.getValue());					
				}
			}
		}
		MySession session = new MySession(String.valueOf(System.currentTimeMillis()));	
		map.put(session.getId(), session);		
		return session;		
	}
	
}
