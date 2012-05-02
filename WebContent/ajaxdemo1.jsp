<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax demo 001</title>
<link type="text/css" href="common/js/thirdpart/css/flick/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript" src="common/js/thirdpart/jquery.js"></script>
<script type="text/javascript" src="common/js/thirdpart/jquery-ui.js"></script>
<script src="common/js/thirdpart/minified/jquery.ui.core.js"></script>
<script src="common/js/thirdpart/minified/jquery.ui.widget.js"></script>
<script src="common/js/thirdpart/minified/jquery.ui.button.js"></script>
<script>
$(function() {
    $("#ucb").button({
    	icons:{
    		primary:"ui-icon-contact"
    	}
    });
    $("#regb").button({
    	icons:{
    		primary:"ui-icon-key"
    	}
    });
    $("#ris").hide();
    //操作事件动作
    $("#ucb").click(function(){
    	//TODO ajax检测帐号是否出现重复
//     	window.alert("test1");
    	//想servlet发送请求，请求查询当前所有用户帐号
    	$.post("simpledemo",{ "user": ($("#username").val()) },function(data){
// 			alert("反馈信息："+date);
			$("#ris").html(data);
			$("#ris").show();
    		});
//     	window.alert("test2");
    	//servlet处理得到所有帐号列表
    	
    	//检验是否有当前帐号相同的已注册帐号，显示不同的提示信息。
//     	$("#ris").addClass("ui-state-error ui-corner-all");
//     	$("#ris").css({padding:"0.5em",color:"#c33"});
//     	$("#ris").html("出现重复帐号！");
//     	$("#ris").show();
    	
//     	$("#ris").addClass("ui-state-highlight ui-corner-all");
//     	$("#ris").css({padding:"0.5em",color:"#72BCE0"});
//     	$("#ris").html("该帐号可以注册！");
//     	$("#ris").show();

		
    });
});


</script>
<style>
*{font-size:12px;}
</style>
</head>
<body>
<div class="demo">
		<input id="username" name="username" type="text" /><span id="ris">return info span</span><br /><br />
		<button id="ucb">检测帐号是否存在</button><br /><br />
		<button id="regb">注册</button>
</div>
</body>
</html>