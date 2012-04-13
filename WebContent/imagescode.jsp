<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" language="javascript">
  function changeImg(){
   var a=document.getElementById("mySpan");
   a.innerHTML='<img align="middle" src="PicCodeDemo"/>  <a href="#" onclick="changeImg();">看不清</a>'; //会复盖“mySpan”位置
  }
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片验证码</title>
</head>
<body>
  <span id="mySpan"><img align="middle" src="PicCodeDemo" /><a
   href="#" onclick="changeImg();">看不清</a> </span> 
</body>
</html>