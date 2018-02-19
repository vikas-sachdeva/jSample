<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Jersey File Upload Service</title>
</head>
<body>
	<h1>Jersey File Upload Service</h1>

	<form action="rest/upload/file" method="post"
		enctype="multipart/form-data">

		<p>
			Select a file : <input type="file" name="file" size="45" />
		</p>
		<p>
			File Description : <input type="text" name="fileDescription" />
		</p>
		<input type="submit" value="Upload" />

	</form>

</body>
</html>