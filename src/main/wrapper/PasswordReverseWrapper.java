package main.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class PasswordReverseWrapper extends HttpServletRequestWrapper{

	public PasswordReverseWrapper(HttpServletRequest request) {
		super(request);
	}
	
    public String getParameter(String name) {
    	System.out.println("PasswordReverseWrapper getParameter");
    	if(name.trim().equals("password")){
    		StringBuffer sb = new StringBuffer(this.getRequest().getParameter(name).trim());
    		return sb.reverse().toString();
    	}
        return this.getRequest().getParameter(name).trim();
    }
	
}
