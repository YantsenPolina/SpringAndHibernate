<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Login Page</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
  <h3>Login Page</h3>
  <c:if test="${param.error != null}">
    <i class="failed">Invalid username/password</i>
  </c:if>
  <form:form action="${pageContext.request.contextPath}/authentication" method="POST">
    <p>Username: <input type="text" name="username" /></p>
    <p>Password: <input type="text" name="password" /></p>
    <input type="submit" value="Login" />
  </form:form>
</body>
</html>
