package com.xleon.demo.ipseek;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HostInfo
 */
public class HostInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HostInfo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		
		out.write("<html><head><title></title></head><body>");
		
		String agent = request.getHeader("User-Agent");
		StringTokenizer st = new StringTokenizer(agent, ";)");
        st.nextToken();
        String browser = st.nextToken();
      //得到用戶的瀏覽器名
        String os = st.nextToken();
      //得到用戶的操作系統名
        out.write("浏览器名："+browser+"<br />");
        out.write("操作系统名："+os+"<br />");
		
		this.getServletContext().getServerInfo();
		Enumeration es = this.getServletContext().getAttributeNames();
		for (Enumeration e = es; e.hasMoreElements();) {
			String thisName = e.nextElement().toString();
			String thisValue = this.getServletContext().getInitParameter(
					thisName);
			out.write(thisName + "----" + thisValue+"<br />");

		}
		out.write("<hr />");
		
		Enumeration he = request.getHeaderNames();
		for (Enumeration e2 = he; e2.hasMoreElements();) {
			String ename = e2.nextElement().toString();
			String ev = request.getHeader(ename);
			out.write(ename + "=====" + ev+"<br />");
		}
		out.write("<hr />");
		
		out.write(request.getHeader("x-forwarded-for")==null?"":"request.getHeader(\"x-forwarded-for\")="+request.getHeader("x-forwarded-for"));

		out.write("this.getServletContext().getMinorVersion()="
				+ this.getServletContext().getMinorVersion()+"<br />");
		out.write("this.getServletContext().getServerInfo()="
				+ this.getServletContext().getServerInfo()+"<br />");
		out.write("this.getServletContext().getMajorVersion()="
				+ this.getServletContext().getMajorVersion()+"<br />");
		out.write("request.getServerPort()=" + request.getServerPort()+"<br />");
		out.write("request.getServerName()=" + request.getServerName()+"<br />");
		out.write("this.getServletContext().getServerInfo()="
				+ this.getServletContext().getServerInfo()+"<br />");

		out.write("<hr />");
		out.write("request.getRemoteHost()=" + request.getRemoteHost()+"<br />");
		out.write("request.getRomoteAddr()=" + request.getRemoteAddr()+"<br />");
		out.write("request.getRemotePort()=" + request.getRemotePort()+"<br />");
		out.write("request.getRemoteUser()=" + request.getRemoteUser()+"<br />");
		out.write("request.getRequestURI()=" + request.getRequestURI()+"<br />");
		out.write("request.getHeader(\"User-Agent\")"
				+ request.getHeader("User-Agent")+"<br />");

		out.write("System.getProperty(\"os.name\")="
				+ System.getProperty("os.name")+"<br />");
		out.write("System.getProperty(\"os.version\")="
				+ System.getProperty("os.version")+"<br />");
		out.write("System.getProperty(\"os.arch\")="
				+ System.getProperty("os.arch")+"<br />");
		
		out.write("this.getIpAddr(request)="+this.getIpAddr(request)+"<br />");
		
		out.write("<hr />");
		IPSeeker aa = IPSeeker.getInstance();
		//System.out.println(aa.getAddress("121.15.224.162"));
		System.out.println(aa.getAddress(this.getIpAddr(request)));
		out.write(aa.getAddress(this.getIpAddr(request)));
		
		out.write("<hr />");
		out.write("request.getRequestURI()="+request.getRequestURI()+"<br />");
		out.write("request.getHeader(\"Referer\")="+request.getHeader("Referer")+"<br />");
		
		out.write("<hr />");
		out.write("</body>");
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
