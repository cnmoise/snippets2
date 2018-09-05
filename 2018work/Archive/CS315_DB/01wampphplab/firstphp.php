<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Document</title>
	</head>
<body>
	<!--
	In order to run PHP code on the server you must
	save your php code in this folder
	C:\wamp64\www\cs315
	
	and call it from
	http://localhost/cs315/filename.php

	

	can embed php into html and
		html into php-->
	<h1>Welcome to PHP Tutorial</h1>
	<?php
		#PHP variables start with $
		$courseName = "CS315";
		// $x = 4;
		// $y = 10;
		// $z = 0;


		echo "<h2>First PHP Program</h2>";
		echo "Welcome to $courseName";
		// $z = $x +$y;
		// echo $z;

		echo "<p>";
		echo "PHP is a server side scripting language\nyou can create dynamic web pages and DB applications using it";
	#Comments
	/*
	variable names can't start w a number

	multi
	line
	comment*/
	echo "</p>";

	#haha super cool trick
	for($i=1; $i < 6; $i++){
		echo "<h$i>PHP<h$i>";
	}

	#foreach only accepts arrays
	#indexed arrays

	$food = array("pizza", "cake", "fries", "pie");
	foreach ($food as $value) {
		#con.cat
		echo $value."<br/>";
	}
	#associative arrays (named pairs)
	$people = array("Jon"=>"34", "Jane"=>"26", "Jaque"=>"42");

	#x represents left term
	#x_value represents right term
	foreach ($people as $x => $x_value) {
		echo $x." is ".$x_value." years old. <br/>";
	}
	?>

</body>
</html>

