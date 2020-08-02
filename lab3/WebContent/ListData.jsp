<%-- Автор: Марчук Л.Б., Дата 19.02.2019,
Описание: Вывод тела таблицы --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	<%
	// Выбор всех Cookie
	Cookie [] c = request.getCookies();
	String value = null;
	if(c != null)
		for(int i = 0; i < c.length; i++)
		if("color".equals(c[i].getName())) {
			// Запись значения в поле ввода, если найден Cookie
			value = c[i].getValue();
			break;
		}
%>
	body{
		background-color: <%=value %>
	}
</style>
<body>
Содержимое Cookie:<br>
<%
	//Выбор всех Cookie
	c = request.getCookies();
	if(c != null)
		for(int i = 0; i < c.length; i++)
			out.print(c[i].getName() + ": " + c[i].getValue() + " | ");
%><br>
Содержимое переменных сессии:<br>
<%
	out.print("Количество обращений: " + session.getAttribute("counter").toString() + " | ");
	out.print("Дата последнего обращения: " + session.getAttribute("data").toString());
%>

</body>
<table border='1'>
<tr>
<td><b>Название товара</b></td>
<td><b>Цена</b></td>
<td><b>Скидка</b></td>
</tr>
<tr>
<td>Яблоки</td>
<td>100</td>
<td>Да</td>
</tr>
<tr>
<td>Апельсины</td>
<td>60</td>
<td>Нет</td>
</tr>
</table>