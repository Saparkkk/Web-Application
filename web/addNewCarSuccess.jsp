<%-- 
    Document   : addNewCarSuccess
    Created on : Jul 27, 2024, 11:19:23 AM
    Author     : PARK1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Spark.Car, java.util.Arrays" %>

<h2>เก็บข้อมูลสำเร็จ</h2>
<%
    Car car = (Car) session.getAttribute("car");
%>
ชื่อผู้จอง: <%= car.getName()%><br/>
อีเมล: <%= car.getEmail()%><br/>
ประเภทรถ: <%= car.getCarType()%><br/>
สีรถ: <%= car.getCarColor()%><br/>
การเลือกซื้อ: <%= car.getPaymentType()%><br/>
ราคา: <%= car.getCarPrice()%><br/>
</table>
