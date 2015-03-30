<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form action="/webbase/RequestDemo" method="post">
<input type="hidden" name="id" value="123"/><br/>
姓名：<input type="text" name="name" /><br/>
密码：<input type="password" name="password" /><br/>
城市：<select name="city">
<option value="beijing">北京</option>
<option value="shanghai">上海</option>
<option value="tianjin">天津</option>
<option value="chongqing">重庆</option>
</select><br/>
性别：<input type="radio" name="gender" value="male"/>男<input type="radio" name="gender" value="female"/>女<br/>
爱好：<input type="checkbox" name="aihao" value="sing"/>唱歌<input type="checkbox" name="aihao" value="dance"/>跳舞
<input type="checkbox" name="aihao" value="football"/>足球<input type="checkbox" name="aihao" value="basketball"/>篮球<br/>
简介：<textarea rows="10" cols="50" name="description"></textarea><br/>
<input type="submit" value="提交"/>
</form>
<br/>
<form action="/webbase/RequestDemo" method="get">
姓名：<input type="text" name="name"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>