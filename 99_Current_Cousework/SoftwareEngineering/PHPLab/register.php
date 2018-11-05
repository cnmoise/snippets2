<?php

//generates page dynamically
$page_title = 'Register';
include ('includes/header.html');

//SUBMISSION CONDITIONAL
if($_SERVER['REQUEST_METHOD'] == 'POST'){

	//errors array, every time user forgets something
	$errors = array();

	require('../mysqli_connect.php'); // Connect to the db.
	//defines dbc variable, see respective file

	if (empty($_POST['first_name'])) {
		$errors[] = 'You forgot to enter your first name.';
	} else {
		$fn = mysqli_real_escape_string($dbc, trim($_POST['first_name']));
	}
	// Check for a last name:
	if (empty($_POST['last_name'])) {
		$errors[] = 'You forgot to enter your last name.';
	} else {
		$ln = mysqli_real_escape_string($dbc, trim($_POST['last_name']));
	}
	// Check for an email address:
	if (empty($_POST['email'])) {
		$errors[] = 'You forgot to enter your email address.';
	} else {
		$e = mysqli_real_escape_string($dbc, trim($_POST['email']));
	}
	// Check for a password and match against the confirmed password:
	if (!empty($_POST['pass1'])) {
		if ($_POST['pass1'] != $_POST['pass2']) {
			$errors[] = 'Your password did not match the confirmed password.';
		} else {
			$p = mysqli_real_escape_string($dbc, trim($_POST['pass1']));
		}
	} else {
		$errors[] = 'You forgot to enter your password.';
	}


	//no dumb user errors
	if(empty($errors)){
		//register user in DB

		require('../mysqli_connect.php');
		//abreviated data collected from the above fields
		$q = "INSERT INTO users (first_name, last_name, email, pass, registration_date) VALUES ('$fn', '$ln', '$e', SHA1('$p'), NOW())";
		$res = @mysqli_query($dbc, $q);

		if($r){

			echo '<h1>Gotcha fool</h1>';
		} else {
			echo '<h1>System Error</h1>;
			<p class="error">You could not be registered due to a system error. We apologize for any inconvenience.</p>';
			// Debugging message:
			echo '<p>' . mysqli_error($dbc) . '<br><br>Query: ' . $q . '</p>';
		}

	//}

	mysqli_close($dbc); // Close the database connection.
	// Include the footer and quit the script:
	include('includes/footer.html');
	exit();
} else { // Report the errors.
		echo '<h1>Error!</h1>
		<p class="error">The following error(s) occurred:<br>';
		foreach ($errors as $msg) { // Print each error.
			echo " - $msg<br>\n";
		}
		echo '</p><p>Please try again.</p><p><br></p>';
	} // End of if (empty($errors)) IF.
	mysqli_close($dbc); // Close the database connection.
} // End of the main Submit conditional.
?>

<h1>Register</h1>

<!--  
	carries over data from one login attempt to the next (sticky)
	if (isset($_POST['first_name'])) echo $_POST['first_name'];  -->
<form action="register.php" method="post">
	<p>First Name: <input type="text" name="first_name" size="15" maxlength="20" value="<?php if (isset($_POST['first_name'])) echo $_POST['first_name']; ?>"></p>
	<p>Last Name: <input type="text" name="last_name" size="15" maxlength="40" value="<?php if (isset($_POST['last_name'])) echo $_POST['last_name']; ?>"></p>
	<p>Email Address: <input type="email" name="email" size="20" maxlength="60" value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>" > </p>
	<p>Password: <input type="password" name="pass1" size="10" maxlength="20" value="<?php if (isset($_POST['pass1'])) echo $_POST['pass1']; ?>" ></p>
	<p>Confirm Password: <input type="password" name="pass2" size="10" maxlength="20" value="<?php if (isset($_POST['pass2'])) echo $_POST['pass2']; ?>" ></p>
	<p><input type="submit" name="submit" value="Register"></p>
</form>
<?php include('includes/footer.html'); ?>