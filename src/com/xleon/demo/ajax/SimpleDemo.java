package com.xleon.demo.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleDemo
 */
public class SimpleDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleDemo() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO 处理ajax请求
        response.setContentType("text/html;charset=utf-8");  
        PrintWriter out=response.getWriter();  
        String username=request.getParameter("user").toLowerCase();  
        
        List<String> userlist = new ArrayList<String>();
        userlist.add("Tom");
        userlist.add("jack");
        userlist.add("xleon");
        userlist.add("root");
        
        int flag = 0;
        
        if(username.length()<=0)flag++;
        
        for (String string : userlist) {
			if(string.toLowerCase().trim().equals(username))flag++;
		}
        
        System.out.println("username:"+username);
        System.out.println("flag:"+flag);
        if(flag>0){  
            out.print("帐号已经存在，请重新注册其他帐号。");  
        }  
        else{  
            out.print("恭喜，该帐号可以使用。");  
        }  
        out.close();  
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request, response);
	}
}
