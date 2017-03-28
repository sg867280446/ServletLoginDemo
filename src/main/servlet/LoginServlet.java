package main.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login" , urlPatterns = { "/login" })
@SuppressWarnings("unchecked")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = -7232348095464908546L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		System.out.println("登陆方法已经进来");
		System.out.println("循环输出cookie值");
		Cookie [] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				System.out.println("name : "+c.getName()+"---- value : "+c.getValue());
			}
		}
		System.out.println("输出session值");
		if(req.getSession() != null){		
			HttpSession session = req.getSession();
			System.out.println(req.getSession().getId());
			System.out.println("session 还有 "+session.getMaxInactiveInterval()+" 秒失效");
			session.setMaxInactiveInterval(1000);
			System.out.println("session 被设置为1000秒后失效");
			System.out.println("现在的时间是 "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("用户名 : "+username+"----密码 : "+password);
		System.out.println("开始验证用户密码是否正确");
		
		
		Map<String,String> userMap = (Map<String, String>) this.getServletContext().getAttribute("userMap");
		if(userMap.containsKey(username)&&userMap.get(username).equals(password)){
			System.out.println("登录成功");
			//resp.getWriter().print("登录成功");
		}else{
			System.out.println("登录失败");
			//resp.getWriter().print("登录失败");
		}
				
		System.out.println("登陆方法已经结束");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
	}
	
	public void init(){
		/**
		 * 初始化用户名密码
		 */
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("huangjunlong","123");
		userMap.put("geek","321");
		this.getServletContext().setAttribute("userMap", userMap);
	}
}
