<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a New Order</title>
</head>
<body>
<form action="/orders" method="post">
    <div>
        <label for="username">User name</label>
        <input type="text" id="username" name="username" value="" />
    </div>
    <div>
        <label for="itemName">Item name</label>
        <input type="text" id="itemName" name="itemName" value="" />
    </div>
    <div>
        <label for="itemQuantity">Quantity</label>
        <input type="number" id="itemQuantity" name="itemQuantity" value=""/>
    </div>
    <div>
        <p>Gluten Free (true/false):</p>
        <div>
            <input type="radio" id="true" name="glutenFree" value="true" />
            <label for="true">True</label>
        </div>
        <div>
            <input type="radio" id="false" name="glutenFree" value="false" />
            <label for="false">False</label>
        </div>
    </div>
    <div>
        <label for="imageUrl">Url</label>
        <input type="url" id="imageUrl" name="imageUrl" value="" />
    </div>

    <input type="submit" value="Submit" />
</form>
</body>
</html>
