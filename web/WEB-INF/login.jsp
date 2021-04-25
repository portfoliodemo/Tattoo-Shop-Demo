

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    
        <h1>Home Inventory</h1>
        
        <h2>Login</h2>
        
        <form action="login" method="POST" >
            <label for="user_name">User Name:</label>
             <input type="text" name="userName" id="userName">
             <br>
             <label for="password">Password:</label>
             <input type="password" name="password" id="password">
             <br>
             <input type="submit" value="Login">
            
        </form>
        
        <a href=" <c:url value='/register' /> ">Don't have an account? register now!</a>
        
        <p>
        ${errorMessage}
        </p>
    
</html>
