<%@page contentType="text/html;charset=utf-8" import="java.util.*, soo.md.domain.Address"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fileupload Form Multi</title>
		<style>
			a{text-decoration:none}
		</style>
	</head>
	<body style="text-align:center">
		<h1>Fileupload Form Multi</h1>

		<form action="/file/upload_mt.do"  method="post" enctype="multipart/form-data">
		 <div>
		   <input type='file' name='files'>
		 </div>
		 <div>
		   <input type='file' name='files'>
		 </div>
		 <div>
		   <input type='file' name='files'>
		 </div>
		 <div>
		   <input type='file' name='files'>
		 </div>
		 <div>
		   <input type='file' name='files'>
		 </div>
		 <div>
		   <input type='submit'>
		 </div>   
		</form>
		
	</body>
</html>