<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/header.jsp" %>
    
<div class="panel-heading">투표 등록 화면</div>
<div class="panel-body">

<style>

textarea {
	resize: none;
}

</style>

<form  method="post">
  <p>
  <input type="text" name="title" value="이해했어?">
  </p>
  <p>
  <textarea rows="3" cols="30" name="descp">
이해해 주길 바래...plz
  </textarea>
  </p>
  <input type='submit'>
  <input type='reset'>
</form>

</div>

<%@include file="/WEB-INF/include/footer.jsp" %>
