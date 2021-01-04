<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Demo - Student Confirmation Page</title>
</head>
<body>
    The student is confirmed: ${student.firstName} ${student.lastName}
    <br><br>
    Country: ${student.country}
    <br><br>
    Favourite Language: ${student.favouriteLanguage}
    <br><br>
    Operating Systems:
    <ul>
        <c:forEach var="system" items="${student.operatingSystems}">
            <li>${system}</li>
        </c:forEach>
    </ul>
</body>
</html>
