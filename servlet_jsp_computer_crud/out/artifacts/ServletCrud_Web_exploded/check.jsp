<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>验证</title>
  <script type="text/javascript">//js的引用
    function same(){
      loginForm.action = "index.jsp";
      loginForm.submit();
    }
    function different(){
      alert("请输入正确的验证码");
      location.href = "login.html";
    }
  </script>
</head>
<body>
<%
  String userName = request.getParameter("userName");//获取用户名获取HTTP请求中名为"userName"的参数的值，并将其存储在名为userName的字符串变量中
  String password = request.getParameter("userPwd");
%>
<form id="loginForm" name="loginForm" method="post">
  <input type="hidden" id="userName" value=<%=userName %>  name="user.userName">
<!--使用JSP表达式将服务器端的用户名值插入到隐藏字段中。-->
  <input type="hidden" id="userPwd" value=<%=password %> name="user.userPwd">
</form>
<%
  String rand = session.getAttribute("code").toString();//获取session中的验证码 //imput获取用户名和密码，并将其放入隐藏域中
  String input = request.getParameter("code");//获取用户输入的验证码
  if(rand.equals(input)){
    out.print("<script language='javascript'>same();</script>");
  }else{
    out.print("<script language='javascript'>different();</script>");
  }
%>
<!--这是一个条件语句，用于比较会话中的验证码和用户输入的验证码是否相等。如果相等，
表示验证码验证通过，会执行JavaScript函数same()；否则，执行JavaScript函数different()。-->
</body>
</html>