<%-- 
    Document   : updateCar
    Created on : 29 ส.ค. 2567, 16:19:39
    Author     : fax14
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Car" %>
<!DOCTYPE html>
<html>
    <body>
        <% Car car = (Car) session.getAttribute("car");%>
        <p>แก้ไขข้อมูลของเล่น</p>
        <form action="addCar">
            <input type="text" name="name" value="<%= car.getName()%>"><br/>
            <input type="text" name="type" value="<%= car.gettype()%>"><br/>
            <input type="text" name="size" value="<%= car.getsize()%>"><br/>
            <input type="text" name="color" value="<%= car.getcolor()%>"><br/>
            <input type="text" name="price" value="<%=car.getPrice()%>"<br/>
            <input type="submit" value="แก้ไข">            
        </form>
        <% session.removeAttribute("Car"); %>
    </body>
</html>