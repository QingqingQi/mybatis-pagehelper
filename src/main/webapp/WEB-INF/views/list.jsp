<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理系统</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<%--引入 jQuery--%>
<script src="${APP_PATH}/static/js/jquery-3.2.1.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">

		<!-- 标题部分 -->
		<div class="row">
			<div class="col-md-12">
				<h1>员工管理系统</h1>
			</div>
		</div>

		<!-- 两个按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary">新增</button>
				<button type="button" class="btn btn-danger">删除</button>
			</div>
		</div>
		<br>
		<!-- 表格信息 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>员工编号</th>
						<th>员工姓名</th>
						<th>性别</th>
						<th>邮箱</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<td>${emp.empId }</td>
							<td>${emp.empName }</td>
							<td>${emp.gender == 'M' ? '男' : '女' }</td>
							<td>${emp.email }</td>
							<td>
								<button type="button" class="btn btn-info btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									修改
								</button>
								<button type="button" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									删除
								</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

		<!-- 分页信息 -->
		<div class="row">
			<div class="col-md-6">
				<br>
				<h4>共 ${pageInfo.total} 条记录，共 ${pageInfo.pages } 页，当前为第
					${pageInfo.pageNum } 页</h4>
			</div>

			<!-- 分页条 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<c:if test="${pageInfo.pageNum == 1 }">
						<li class="disabled"><a href="emps?pageNo=1"
							aria-label="Previous"><span aria-hidden="true">首页</span></a></li>
					</c:if>
					<c:if test="${pageInfo.pageNum != 1 }">
						<li><a href="emps?pageNo=1" aria-label="Previous"><span
								aria-hidden="true">首页</span></a></li>
					</c:if>
					<c:if test="${pageInfo.hasPreviousPage }">
						<li><a href="emps?pageNo=${pageInfo.pageNum - 1 }"
							aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:if test="${!pageInfo.hasPreviousPage }">
						<li class="disabled"><a
							href="emps?pageNo=${pageInfo.pageNum - 1 }" aria-label="Previous"><span
								aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:forEach items="${pageInfo.navigatepageNums }" var="pageNo">
						<c:if test="${pageNo == pageInfo.pageNum }">
							<li class="active"><a href="#">${pageNo }</a></li>
						</c:if>
						<c:if test="${pageNo != pageInfo.pageNum }">
							<li><a href="emps?pageNo=${pageNo }">${pageNo }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage }">
						<li><a href="emps?pageNo=${pageInfo.pageNum + 1 }"
							aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
					</c:if>
					<c:if test="${!pageInfo.hasNextPage }">
						<li class="disabled"><a
							href="emps?pageNo=${pageInfo.pageNum + 1 }" aria-label="Next"><span
								aria-hidden="true">&raquo;</span></a></li>
					</c:if>
					<c:if test="${pageInfo.pageNum == pageInfo.pages }">
						<li class="disabled"><a href="emps?pageNo=${pageInfo.pages }"
							aria-label="Previous"><span aria-hidden="true">末页</span></a></li>
					</c:if>
					<c:if test="${pageInfo.pageNum != pageInfo.pages }">
						<li><a href="emps?pageNo=${pageInfo.pages }"
							aria-label="Previous"><span aria-hidden="true">末页</span></a></li>
					</c:if>
				</ul>
				</nav>
			</div>
		</div>

	</div>

</body>
</html>