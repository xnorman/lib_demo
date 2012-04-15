<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" language="javascript">
function changeImg(url){
	   var a = document.getElementById("codeimage");
	   a.src = url + Math.random();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片验证码</title>
</head>
<body>
	<script>alert(location.href);</script>
	<span id="mySpan2"><img id="codeimage" align="middle" src="ImageCode" /><a
		href="javascript:changeImg('ImageCode?t=');">看不清</a> </span><br />
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			//+ path + "/";
			+ request.getRequestURI()+ "? "+request.getQueryString();
	out.println(basePath);
%>
	<br /><a href="HostInfo">访问统计</a>
</body>
</html>