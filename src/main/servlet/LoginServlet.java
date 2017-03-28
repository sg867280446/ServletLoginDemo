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
		System.out.println("��½�����Ѿ�����");
		System.out.println("ѭ�����cookieֵ");
		Cookie [] cookies = req.getCookies();
		if(cookies != null){
			for(Cookie c : cookies){
				System.out.println("name : "+c.getName()+"---- value : "+c.getValue());
			}
		}
		System.out.println("���sessionֵ");
		if(req.getSession() != null){		
			HttpSession session = req.getSession();
			System.out.println(req.getSession().getId());
			System.out.println("session ���� "+session.getMaxInactiveInterval()+" ��ʧЧ");
			session.setMaxInactiveInterval(1000);
			System.out.println("session ������Ϊ1000���ʧЧ");
			System.out.println("���ڵ�ʱ���� "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		}
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("�û��� : "+username+"----���� : "+password);
		System.out.println("��ʼ��֤�û������Ƿ���ȷ");
		
		
		Map<String,String> userMap = (Map<String, String>) this.getServletContext().getAttribute("userMap");
		if(userMap.containsKey(username)&&userMap.get(username).equals(password)){
			System.out.println("��¼�ɹ�");
			//resp.getWriter().print("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
			//resp.getWriter().print("��¼ʧ��");
		}
				
		System.out.println("��½�����Ѿ�����");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
	}
	
	public void init(){
		/**
		 * ��ʼ���û�������
		 */
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("huangjunlong","123");
		userMap.put("geek","321");
		this.getServletContext().setAttribute("userMap", userMap);
	}
}
