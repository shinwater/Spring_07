<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:set value="${dto }" var="cont"></c:set>
		<form action="products_updateOk.do" method="post">
			제품번호: ${cont.getPnum() }
			<input type="hidden" value="${cont.getPnum() }" name="pnum">
			<br /> 제품카테고리: ${cont.getCategory_fk() }<br />
			제품명: ${cont.getProducts_name() }<br /> 이피코드: ${cont.getEp_code_fk() }<br />
			납품가: <input type="text" name="input_price"
				value="${cont.getInput_price() }"><br /> 판매가: <input
				type="text" name="output_price" value="${cont.getOutput_price() }"><br />
			배송비: <input type="text" name="trans_cost"
				value="${cont.getTrans_cost() }"><br /> 마일리지: <input
				type="text" name="mileage" value="${cont.getMileage() }"><br />
			제조사: ${cont.getCompany() }<br /> <input type="submit" value="수정"><br />





		</form>
	</div>
</body>
</html>