<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<c:set value="${dto }" var="cont"></c:set>
	
	<table border="0" cellspacing="0">
	<tr>
		<th align="right">제품번호 : </th>
		<td> ${cont.getPnum() }</td>
	</tr>
	<tr>
		<th align="right">제품카테고리 : </th>
		<td> ${cont.getCategory_fk() }</td>
	</tr>
	<tr>
		<th align="right">제품명 : </th>
		<td> ${cont.getProducts_name() }</td>
	</tr>
	<tr>
		<th align="right">ep_code : </th>
		<td>${cont.getEp_code_fk() }</td>
	</tr>
	<tr>
		<th align="right">납품가 : </th>
		<td> ${cont.getInput_price() }</td>
	</tr>
	<tr>
		<th align="right">판매가 : </th>
		<td> ${cont.getOutput_price() }</td>
	</tr>
	<tr>
		<th align="right">배송비 : </th>
		<td> ${cont.getTrans_cost() }</td>
	</tr>
	<tr>
		<th align="right">마일리지 : </th>
		<td> ${cont.getMileage() }</td>
	</tr>
	<tr>
		<th align="right">제조사 : </th>
		<td> ${cont.getCompany() }</td>
	</tr>
	<tr>
		<th align="right">상태 : </th>
		<td> ${cont.getStatus() }</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="button" value="수정" onclick="location.href='products_update.do?pnum=${cont.getPnum()}'">
			<input type="button" value="삭제" onclick="location.href='products_delete.do?pnum=${cont.getPnum()}'">
		</td>
	</tr>
	</table>
	
	</div>
</body>
</html>