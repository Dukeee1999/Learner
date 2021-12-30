<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>

		<%@ include file= "/pages/common/login_success_menu.jsp"%>

	</div>
	
	<div id="main">
		
		<table>
			<c:if test="${empty sessionScope.orders}">
				<td>亲，您还没有订单哦!</td>
			</c:if>
			<c:if test="${not empty sessionScope.orders}">
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>


				<c:forEach items="${sessionScope.orders}" var="entry">
				<tr>
					<td>${entry.value.createTime}</td>
					<td>${entry.value.price}</td>
					<c:if test="${entry.value.orderStatus==-1}">
						<td>未发货</td>
					</c:if>
					<c:if test="${entry.value.orderStatus==0}">
						<td>途中</td>
					</c:if>
					<c:if test="${entry.value.orderStatus==1}">
						<td>到货</td>
					</c:if>
					<td><a href="#">查看详情</a></td>
				</tr>
				</c:forEach>

			</c:if>
		</table>
		
	
	</div>

	<%@ include file="/pages/common/footer.jsp"%>
</body>
</html>