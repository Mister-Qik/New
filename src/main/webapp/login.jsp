<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-09-16
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="User" method="post"><br>
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password">
    验证码：<input type="text" name="yzm"><img src="Hello"><br>
    <input type="submit" value="登陆">
    <input type="button" value="生成二维码" id="QrCode">


</form>
</body>
<script language="JavaScript" src="js/jquery-3.4.0.min.js"></script>
<script>
    var QR = "<img src='img/qrcode.jpg'>";


    $("#QrCode").click(function () {
        $("form").append(QR);
   })

</script>
</html>
