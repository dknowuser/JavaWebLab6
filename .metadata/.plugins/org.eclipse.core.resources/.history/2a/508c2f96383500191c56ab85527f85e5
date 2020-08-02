<%-- Автор: Марчук Л.Б., Дата 19.02.2019,
Стартовая страница: Вывод заголовка таблицы --%>

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
<%
	request.setCharacterEncoding("UTF-8");
	String section = request.getParameter("section");
	if(section == null)
		throw new IllegalArgumentException("Section expected.");
%>
<h1> Список продуктов в отделе: <%=section%></h1>
<%@include file="ListData.jsp"%>
</body>
</html>