<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/simple.js"></script>
    <title>Spring MVC Demo - Home Page</title>
</head>
<body>
    <h2>Spring MVC Demo - Home Page</h2>
    <img src="${pageContext.request.contextPath}/resources/image/spring-logo.png" alt="Spring Logo"/>
    <hr>
    <a href="${pageContext.request.contextPath}/hello/showForm">Show Form</a>
    <br><br>
    <a href="${pageContext.request.contextPath}/student/showForm">Student Form</a>
    <br><br>
    <a href="${pageContext.request.contextPath}/customer/showForm">Customer Form</a>
</body>
</html>
