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
	<span id="mySpan"><img id="codeimage" align="middle" src="PicCodeDemo" /><a
		href="javascript:changeImg('PicCodeDemo?t=');">看不清</a> </span>
	<a href="HostInfo">访问统计</a>
</body>
</html>