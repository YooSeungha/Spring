<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Sp01 Index</title>
</head>
<body style="text-align:center">
<h1>
	sp01 for spring MVC Controller
</h1>
	<P>
	<a href="test/">m01</a>
	<a href="test/base1/">m02</a>
	<a href="test/form">form</a>
	 </P>
	 <p>
	 <a href="test/param1?name=홍길동">m04</a>
	 <a href="test/param2?na=이순신&age=33">m05</a>
	 <a href="test/param3?name=세종대왕&age=55">m06</a>
	 </p>
	 <p>
	 <a href="test/param4?names=홍길동&names=이순신&names=강감찬">m07</a>
	 <a href="test/param5?names=윤동주&names=윤봉길&names=안중근">m08</a>
	 <a href="test/param6?ns=윤동주&ns=윤봉길&ns=안중근">m09</a>
	 </p>
	 <p>
	 <a href="test/param7?list%5B0%5D.name=이순신&list%5B0%5D.age=40&list%5B1%5D.name=홍길동&list%5B1%5D.age=30&dump=KOSMO">m10</a>
	 <a href="test/param8?name=안중근&age=27&dump=장군&grade=3&">m11</a>
	 </p>
	 <p>
	 <a href="test/param9?subject=크리스마스이브&cdate=2022/12/24 18:30:50">m12</a>
	 </p>
</body>
</html>
