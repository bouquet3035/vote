<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>
    
<div class="panel-heading">투표 화면</div>
<div class="panel-body">

<style>

textarea {
	resize: none;
}

</style>

<p>
  <input type="text" name="title" value="${vo.title}" readonly="readonly">
  </p>
  <p>
  <textarea rows="3" cols="30" name="descp" readonly="readonly">
  ${vo.descp}
  </textarea>
  </p>

<form  method="post">
  <input type='hidden' name="vno" value='${vo.vno}'>
  
  <select name="understand" >
    <option value="1">0%</option>
    <option value="2">25%</option>
    <option value="3" selected="selected">50%</option>
    <option value="4">75%</option>
    <option value="5">90% 이상</option>
    
  </select>
  
  <input type='submit'>
  <input type='reset'>
</form>

</div>

<%@include file="/WEB-INF/include/footer.jsp" %>
