<html>
<body>
<h2>Login Page</h2>
	<form action="/login" method="POST">
	
	<label for="name">Username:</label>
		<input type="text" name="name" id="name" pattern =".{3,20}" required><br>
		
	<label for="password">Password:</label>
		<input type="password" name="password" id="password" pattern =".{5,20}" required><br>
		
	<input type="Submit" value="Login">
	
	</form>
</body>
</html>