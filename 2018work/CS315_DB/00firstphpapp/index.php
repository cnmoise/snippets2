<!DOCTYPE html>
<html>
	<head>
		<title>My To Do List</title>
		<!--
		CDN import, calls all of the necesarry code for JQuery

		We're working with JSON, weather API
		-->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>

		<script>
			$(document).ready(function(){
				//ajax= asyncronous call to web service
				//no reload
				var weatherURL = "http://api.openweathermap.org/data/2.5/weather?q=Chicago,usa&appid=4a5b9754de9964aafd6473bfb5eb734a";
				$.ajax({
					url: weatherURL,
					//because we are reading from the service we use GET??
					type: 'GET',
					success: function(data){
						console.log(data);
						//we grab the temp by calling for it from the data
						//look in API doc
						var temp = data.main.temp;
						var F = 9 / 5 * (temp - 273) + 32;
						var locTemp = "Chicago, " + F + "F.";
						//use #
						//to access an elem by its id
						$("#location_temp").html(locTemp);
					},
					error:function(data){
						alert("THERE IS A PROBLEM");
					}
				})
			});
		</script>
	</head>
	<body>
		<div id="location_temp"></div>
		<h1>To Do Items</h1>
		<ol>
			<?php
				//opens a file in read mode
				$itemsFile = fopen("items.txt", "r");
				//file is open >> Implies true
				//if true
				if($itemsFile){
					//prints every line in the items.txt file while the file is open
					//php can parse HTML code
					while (($line = fgets($itemsFile)) !== false){


						echo "<li>" .$line."</li>";
					}
					fclose($itemsFile);
				}
			?>

		</ol>
		
		<a href="additem.php">Add a New Item</a>
	</body>
</html>

