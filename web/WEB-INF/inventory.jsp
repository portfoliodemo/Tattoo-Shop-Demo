<%-- 
    Document   : inventory
    Created on : Feb 19, 2021, 2:49:59 PM
    Author     : 709488
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Page</title>
    </head>
    <body>
        <h1>Home Inventory for ${user_name}</h1>

        <h2>Add Item</h2>

        <form action="inventory" method="POST">
            <label for="category">Category</label>

            <select name="category" id="category">
                <option value="bedroom">Bedroom</option>
                <option value="garage">Garage</option>
                <option value="kitchen">Kitchen</option>
                <option value="livingroom">Living Room</option>
            </select> 
            <br>
            <label for ="itemName">Item Name</label>
            <input type="text" id="itemName" name="itemName">
            <br>
            <label for ="price">Price</label>
            <input type="number" id="price" name="price" min="0" max="10000">
            <br>
            <input type="submit" value="Add">
            <br>
            

        </form>
        <p>
            ${errorMessage}
        </p>
        <br>
        Total value in inventory: ${inventoryValue}
        <br>
        <!--<form action="login" method="POST"> -->
        <a href="login">Logout</a>
       ,<!-- </form> -->

    </body>
</html>
