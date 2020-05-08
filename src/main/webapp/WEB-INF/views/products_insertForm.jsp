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
		<form action="products_insertOk.do" method="post">
			<table border="1" cellspacing="0">
			<c:set value="${list }" var="List"/>
				<tr>
					<th>카테고리</th>
					<td> 
						<select name="category_fk">
							<c:if test="${empty List }">
								<option value="">:::카테고리 없음:::</option>
							</c:if>
							<c:if test="${!empty List }">
								<c:forEach items="${List }" var="dto">
									<option value="${dto.getCategory_code() }">
									 ${dto.getCategory_name() }[${dto.getCategory_code() }]
									 </option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>제품이름</th>
					<td> <input type="text" name="products_name"></td>
				</tr><tr>
					<th>ep_code</th>
					<td> <input type="text" name="ep_code_fk"></td>
				</tr><tr>
					<th>납품가</th>
					<td> <input type="text" name="input_price"></td>
				</tr><tr>
					<th>판매가</th>
					<td> <input type="text" name="output_price"></td>
				</tr><tr>
					<th>배송비</th>
					<td> <input type="text" name="trans_cost"></td>
				</tr><tr>
					<th>제조사</th>
					<td> <input type="text" name="company"></td>
				</tr><tr>
					<td colspan="2" align="right">  <input type="submit" value="추가"></td>
				</tr>
			
			</table>
		
		</form>
	</div>
</body>
</html>