<%-- Автор: Марчук Л.Б., Дата 19.02.2019,
Стартовая страница: Вывод заголовка таблицы --%>

<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/ErrorManager.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Магазин</title>
</head>
<body>
Введите ФИО покупателя: <br>
<form METHOD=GET action="PriceProcessor">
<INPUT TYPE=TEXT NAME="client"
> <INPUT TYPE=SUBMIT value="Ввод"> <br>
Введите цвет отображения: <br>
<INPUT TYPE=COLOR name="color" value="#ff0000"
> <br></form>

<%
	request.setCharacterEncoding("UTF-8");
	String section = request.getParameter("section");
	if(section == null)
		throw new IllegalArgumentException("Section expected.");
%>
</body>
</html>