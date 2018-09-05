<?php
	if(isset($_POST['item']))
	{

		//dynamic web page, as we interact w the webpage, the webpage changes
		$newItem = $_POST['item'];
		$itemsFile = fopen('items.txt', 'a') or die('Cannot open file.');
		fwrite(($itemsFile), $newItem.PHP_EOL);
		fclose($itemsFile);
		echo "New item is succesfully added.";
	}
?>

<!DOCTYPE html>
<html>
	<head>
		<title>My To Do List</title>
		<!--API key

			4a5b9754de9964aafd6473bfb5eb734a-->

		<!--http://api.openweathermap.org/data/2.5/weather?q=Chicago,usa&appid=4a5b9754de9964aafd6473bfb5eb734a-->
	</head>

	<body>
		<h1>Add New Item</h1>
		<form action="additem.php" method="POST">
			<label>New Item: </label> 
			<input type="text" name="item"/>
			<input type="submit"/>
		</form>
		<a href="index.php">See Items</a>
	</body>
</html>

