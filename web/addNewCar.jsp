<%-- 
    Document   : addNewCar
    Created on : Jul 27, 2024, 12:32:31 PM
    Author     : PARK1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div>เพิ่มสินค้า</div>
    <form action="NatthasetA" method="post">
        ชื่อผู้จอง: <input type="text" name="name"><br/>
        อีเมล: <input type="text" name="email"><br/>
        ชนิดรถ:
        <select name="carType">
            <option value="Lambor">Lambor</option>
            <option value="Benz">Benz</option>
            <option value="Toyota">Toyota</option>
            <option value="Yamaha">Yamaha</option>
            <option value="BMW">BMW</option>
        </select><br/>
        สีรถ:
        <select name="carColor">
            <option value="White">White</option>
            <option value="Orange">Orange</option>
            <option value="Gray">Gray</option>
            <option value="Cream">Cream</option>
            <option value="Black">Black</option>
        </select><br/>
        การเลือกซื้อ:
        <input type="radio" name="paymentType" value="สด"> สด
        <input type="radio" name="paymentType" value="ผ่อนชำระ"> ผ่อนชำระ<br/>
        ราคา: <input type="text" name="carPrice"><br/>
        <input type="submit" value="Submit">
    </form>
    </body>
</html>
