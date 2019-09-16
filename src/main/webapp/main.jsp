<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-09-11
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${pojo}" var="pojo">
    <h1>${pojo.sid} ${pojo.sname}</h1>

</c:forEach>
</body>
</html>
