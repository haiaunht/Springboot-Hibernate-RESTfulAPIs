<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add a New Rsvp</title>
</head>
<body>
<form action="/admin" method="post">
    <div>
        <label for="title">Title</label>
        <input type="text" id="title" name="title" value=""/>
    </div>
    <div>
        <label for="street">Street</label>
        <input type="text" id="street" name="street" value=""/>
    </div>
    <div>
        <label for="city">City</label>
        <input type="text" id="city" name="city" value=""/>
    </div>
    <div>
        <label for="state">State</label>
        <input  type="text" id="state" name="state" value=""/>
    </div>
    <div>
        <label for="postalCode">Postal Code</label>
        <input  type="text" id="postalCode" name="postalCode" value=""/>
    </div>
    <input type="submit" value="Add" />
</form>
</body>
</html>