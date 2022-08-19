<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style>
	a{text-decoration:none}
</style>
<meta charset="utf-8">
<center>
	<font color='gray' size='4' face='휴먼편지체'>
	<hr width='600' size='2' color='gray' noshade>
	<h3>Spring Board</h3>
	<font color='gray' size='4' face='휴먼편지체'>
	<a href='write.do'>글쓰기</a>
	</font>
	<hr width='600' size='2' color='gray' noshade>
	</font>
	
	<table border='2' width='600' align='center' noshade>
	<c:forEach var="list" items="${list}">
	<c:if test="${list.seq eq param.seq}">
	<tr>
	<td width='20%' align='center'>No</td>
	<td>${list.seq}</td>
	</tr>
	<tr>
	<td width='20%' align='center'>Writer</td>
	<td>${list.writer}</td>
	</tr>
	<tr>
	<td align='center'>E-mail</td>
	<td>${list.email}</td>
	</tr>
	<tr>
	<td align='center'>Subject</td>
	<td>${list.subject}</td>
	</tr>
	<tr>
	<td align='center'>Contents</td>
	<td>${list.content}</td>
	</tr>
	</c:if>
	</c:forEach>
	</table>
	
	<hr width='600' size='2' color='gray' noshade>
	<font color='gray' size='4' face='휴먼편지체'>
	<a href='update.do?seq=${param.seq}'>수정</a>
	 &nbsp;&nbsp;| 
	<a href='del.do?seq=${param.seq}'>삭제</a>
	 &nbsp;&nbsp;| 
	<a href='list.do'>목록</a>
	</font>
	<hr width='600' size='2' color='gray' noshade>
</center>
