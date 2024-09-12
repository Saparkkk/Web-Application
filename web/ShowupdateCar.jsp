<%-- 
    Document   : NatthasetA
    Created on : Jul 18, 2024, 1:51:30 PM
    Author     : NatthaPark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Spark.Car,java.util.Arrays"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-16">
        <title>JSP Page</title>
    </head>
    <form action="NatthasetA">
    <body>
        <%
            Car car = (Car) session.getAttribute("car");
        %>
        <div>เพิ่มสินค้า</div>
        ชื่อผู้จอง: <%= car.getName()%><br/>
        อีเมล: <%= car.getEmail()%><br/>
        ประเภทรถ: <%= car.getCarType()%><br/>
        สีรถ: <%= car.getCarColor()%><br/>
        การเลือกซื้อ: <%= (car.getPaymentType().equals("cash") ? "สด" : "ผ่อนชำระ")%><br/>
        ราคา: <%= car.getCarPrice()%><br/>
        <a href='NatthasetA'>แก้ไขข้อมูล</a>
    </body>
</html>
