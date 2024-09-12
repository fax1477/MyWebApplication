<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Car" %>
<!DOCTYPE html>
<html>
    <body>
        <!-- get session object movie -->
        <% Car car = (Car) session.getAttribute("car");%>
        <p>ของเล่นที่เพิ่มได้แล้ว</p>
        id: <%=car.getId() %><br/>
        ชื่อของเล่น: <%= car.getName() %><br/>
        ประเภท <%= car.gettype() %><br/>
        ขนาด <%= car.getsize() %><br/>
        สี <%= car.getcolor() %><br/>
        ราคา: <%=car.getPrice() %><br/>
        <a href="updateCar.jsp">แก้ไขข้อมูลรถยนต์</a>
    </body>
</html>