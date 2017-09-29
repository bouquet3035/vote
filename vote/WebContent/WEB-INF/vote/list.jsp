<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="/WEB-INF/include/header.jsp"%>

<div class="panel-heading">투표 리스트 화면</div>
<div class="panel-body">
	<a href="/vote/register">ADD VOTE</a>
	<table class="table">
		<thead>
			<tr>
				<th>Vno</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Reg Date</th>
				<th>End Date</th>
				<th>Current</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="vo" items="${list}">

				<tr>
					<td>${vo.vno}</td>
					<td>
					  <c:if test="${vo.can}">
					  	<a href='/vote/view?vno=${vo.vno}'>${vo.title}</a>
					  </c:if>
					    ${vo.title}					  
					</td>
					<td>${vo.writer}</td>
					<td><fmt:formatDate pattern="yy-MM-dd HH:mm"
							value="${vo.regdate}" /></td>
					<td><fmt:formatDate pattern="yy-MM-dd HH:mm"
							value="${vo.enddate}" /></td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class="pagination">
	
	<c:if test="${pg.prev}">
	  <li><a href="/vote/index?page=${pg.startPage -1}">이전</a></li>
	</c:if>
	
	<c:forEach var="pnum" begin="${pg.startPage}" end="${pg.endPage}">
		<li><a href="/vote/index?page=${pnum}">${pnum}</a></li>
	</c:forEach>
	
	<c:if test="${pg.next}">
	  <li><a href="/vote/index?page=${pg.endPage + 1 }">다음</a></li>
	</c:if>
		
	</ul>

	</body>
	</html>