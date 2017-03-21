package main.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TrimWrapper extends HttpServletRequestWrapper{

	public TrimWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	
    public String getParameter(String name) {
    	System.out.println("TrimWrapper getParameter");
        return this.getRequest().getParameter(name).trim();
    }
    
    //you can do more about parameters
}
