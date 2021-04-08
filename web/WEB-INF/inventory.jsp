<%-- 
    Document   : inventory
    Created on : Feb 19, 2021, 2:49:59 PM
    Author     : 709488
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Page</title>
    </head>
    <body>
        <h1>Home Inventory for ${user_name}</h1>
        
        <table cellpadding="5" border="1">
            <tr>
                <th>Category</th>
                <th>Name</th>
                <th>Price</th>
                
            </tr>
            <c:forEach var="item" items="${itemsList}">
                <tr> 
                <td>${item.category.categoryName}</td>
                <td>${item.itemName}</td>
                <td>${item.price}</td>
                <td>
                        <form action="inventory" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="itemID" value="${item.itemID}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        
    

        <h2>Add Item</h2>

        <form action="inventory" method="POST">
            <label for="category">Category</label>
            <select name="category" id="category">
                <c:forEach var="category" items="${categories}">
                <option value="${category.categoryID}">${category.categoryName}</option>
                </c:forEach>
            </select> 
            <br>
            <label for ="itemName">Item Name</label>
            <input type="text" id="itemName" name="itemName">
            <br>
            <label for ="price">Price</label>
            <input type="number" id="price" name="price" min="0" max="10000">
            <br>
            <input type="submit" name="action" value="add">
            <br>
           
            

        </form>
        <p>
            ${errorMessage}
        </p>
        <br>
        
        <br>
        
        <a href="login">Logout</a>
       

    </body>
</html>
