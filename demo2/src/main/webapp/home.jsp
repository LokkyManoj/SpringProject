<!DOCTYPE html>
<html lang="en">
<body>
<h1>welcome to Webpage </h1>

<form action="click" method=get>

Name:<input type="text" placeholder="Name" name="name" pattern="[A-Za-z\s]{1,50}" title="Name should only contain letters and spaces (max 50 characters)" required><br>
Age:<input type="number" placeholder="Age" name="age" min="1" max="120" title="Age should be between 1 and 100"  required><br>
MobileNo:<input type="text" placeholder="MobileNo" name="mobileNo" pattern="^\d{10}$" title="Mobile number should be exactly 10 digits" required><br> required><br>
Gender:<input type="text" name="gender" placeholder="Gender" pattern="male|female|other" title="Gender should be 'Male', 'Female', or 'Other'" required><br>
Address:<input type="text" name="address" placeholder="Address" pattern=".{1,100}" title="Address should be between 1 and 100 characters" required><br><br>

<input type=submit value="Click her to Register">

</form>
</body>
</html>
