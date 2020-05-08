<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품리스트</title>
</head>
<body>
	
	<div align="center">
		<table border="1" cellspacing="0" width="500">
			<c:set value="${List }" var="list"/>
			
				<tr>
					<th>제품번호</th><th>제품이름</th>
					<th>입고가</th><th>출고가</th>
				</tr>
				<c:if test="${!empty list }">
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.getPnum() }</td>
							<td><a href="products_cont.do?pnum=${dto.getPnum() }">${dto.getProducts_name() }</a></td>
							<td><fmt:formatNumber value="${dto.getInput_price() }" pattern="#,###,###"/></td>
							<td><fmt:formatNumber value="${dto.getOutput_price() }" pattern="#,###,###"/></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty list }">
					<tr>
						<td colspan="4"><h3>제품이없습니다^*^</h3></td>
					</tr>
				</c:if>
				<tr>
					<td colspan="4" align="right">
						<input type="button" value="제품등록" onclick="location.href='products_insert.do'">
					</td>
				</tr>
		
		</table>
	</div>
</body>
</html>