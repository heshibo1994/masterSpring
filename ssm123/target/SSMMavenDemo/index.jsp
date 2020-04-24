<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/student">
    用户姓名：<input type="text"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>