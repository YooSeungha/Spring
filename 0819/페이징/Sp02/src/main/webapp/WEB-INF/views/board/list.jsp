<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title> Spring Board </title>
	<meta charset="utf-8">
	<style>
		a{text-decoration:none}
	</style>
</head>
<body>
<center>
<font color='gray' size='4' face='휴먼편지체'>
<hr width='600' size='2' color='gray' noshade>
<h3> Spring Board</h3>
<font color='gray' size='4' face='휴먼편지체'>
<a href='../'>인덱스</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='write.do'>글쓰기</a><br/>
</font>
<hr width='600' size='2' color='gray' noshade>

<TABLE border='2' width='600' align='center' noshade>
<TR size='2' align='center' noshade bgcolor='AliceBlue'>
	<th bgcolor='AliceBlue'>no</th>
	<th color='gray'>writer</th>
	<th color='gray'>e-mail</th>
	<th color='gray'>subject</th>
	<th color='gray'>date</th>
	<th color='gray'>delete</th>
</TR>

      

    <c:if test="${empty list}">
	<TR>
     	<td align='center' colspan="5">No Data</td>
	</TR>
	</c:if>
	<c:forEach var="list" items="${list_cp}">
	<TR>
	<c:import url="/update.do">
     <c:param name="seq" value="${list.seq}" />
	</c:import>	
		<td align='center'><a href='content.do?seq=${list.seq}'>${list.seq}</td>
		<td>${list.writer}</td>
		<td>${list.email}</td>
		<td>${list.subject}</td>
		<td>${list.rdate}</td>
		<td align='center'><a href='del.do?seq=${list.seq}'>삭제</a></td>
	</TR>
	</c:forEach>
       
      
</TABLE>
<hr width='600' size='2' color='gray' noshade>
<font color='gray' size='3' face='휴먼편지체'>

    (총페이지수 : ${page_max})
    &nbsp;&nbsp;&nbsp;
    <c:forEach begin = "1" end = "${page_max}" var = "num">
        <a href="list.do?ps=${ps}&cp=${num}">
                	<strong>${num}</strong>
    	</a>&nbsp;
        </c:forEach>
    ( TOTAL : ${list.size()} )
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       페이지 싸이즈 : 
<c:choose>
<c:when test="${ps == 3}">
    <select id="psId" name="ps" onchange="f(this)">
    		   <option value="3" selected>3</option>
		       <option value="5">5</option>
		       <option value="10">10</option>
    </select>
</c:when>
<c:when test="${ps == 5}">
    <select id="psId" name="ps" onchange="f(this)">
    		   <option value="3">3</option>
		       <option value="5" selected>5</option>
		       <option value="10">10</option>
    </select>
</c:when>
<c:when test="${ps == 10}">
    <select id="psId" name="ps" onchange="f(this)">
    		   <option value="3">3</option>
		       <option value="5">5</option>
		       <option value="10" selected>10</option>
    </select>
</c:when>
</c:choose>
    <script language="javascript">
       function f(select){
           //var el = document.getElementById("psId");
           var ps = select.value;
           //alert("ps : " + ps);
           location.href="list.do?ps="+ps;
       }
    </script>
    
</font>
<hr width='600' size='2' color='gray' noshade>
    
</center>
</body>
</html>