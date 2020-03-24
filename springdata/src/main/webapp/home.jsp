<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Registration Form To add New Aliens</h1>
	<form action="addAlien">
		<label>Id :</label><input type="text" name="aid" /><br /> <label>Name
			:</label><input type="text" name="aname" /><br /> <input type="submit" /><br />
	</form>
	<br />

	<h1>Finding Form To find Aliens by Id</h1>
	<form action="findAlien">
		<label>Id :</label><input type="text" name="aid" /><br /> <input
			type="submit" />
	</form><br />

	<h1>Finding Form To find Aliens by Tech</h1>
	<form action="findByTech">
		<label>Tech :</label><input type="text" name="tech" /><br /> <input
			type="submit" />
	</form><br />


	<h1>Finding Form To find Aliens by Id greater than</h1>
	<form action="findByAidGreaterThan">
		<label>Id :</label><input type="text" name="aid" /><br /> <input
			type="submit" />
	</form><br />
	
		<h1>Finding Form To find Aliens by my own query</h1>
	<form action="findBySortedname">
		<label>Tech :</label><input type="text" name="tech" /><br /> <input
			type="submit" />
	</form><br />
</body>
</html>