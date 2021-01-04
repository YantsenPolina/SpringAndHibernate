<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Demo - Student Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student">
        First Name: <form:input path="firstName"/>
        <br><br>
        Last Name: <form:input path="lastName"/>
        <br><br>
        Country:
        <form:select path="country">
<%--            <form:option value="Canada" label="Canada" />--%>
<%--            <form:option value="Iceland" label="Iceland" />--%>
<%--            <form:option value="New Zealand" label="New Zealand" />--%>
<%--            <form:option value="Great Britain" label="Great Britain" />--%>
<%--            <form:options items="${student.countryOptions}" />--%>
            <form:options items="${countryProperties}" />
        </form:select>
        <br><br>
        Favourite Language:
<%--        C# <form:radiobutton path="favouriteLanguage" value="C#" />--%>
<%--        C++ <form:radiobutton path="favouriteLanguage" value="C++" />--%>
<%--        Java <form:radiobutton path="favouriteLanguage" value="Java" />--%>
<%--        Python <form:radiobutton path="favouriteLanguage" value="Python" />--%>
        <form:radiobuttons path="favouriteLanguage" items="${student.favouriteLanguageOptions}"  />
        <br><br>
        Operating Systems:
        Linux <form:checkbox path="operatingSystems" value="Linux" />
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
        <br><br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
