<?php # Script 9.6 - view_users.php #2
// This script retrieves all the records from the users table.
$page_title = 'View the Current Users';
include('includes/header.html');
// Page header:
echo '<h1>Registered Users</h1>';
require('../mysqli_connect.php'); // Connect to the db.

//make the query
//AS nicknames column
//date format makes a date
$q = "SELECT CONCAT(last_name, ',', first_name) AS name, DATE_FORMAT(registration_date, '%M %d %Y') AS dr FROM users ORDER BY registration_date ASC";

$r = @mysqli_query($dbc, $q);

// Count the number of returned rows:
$num = mysqli_num_rows($r);

//query returns true if it ran succesfully
if($num > 0){
	// Print how many users there are:
	echo "<p>There are currently $num registered users.</p>\n";

	//Create a stupid header
	echo '<table width="60%">
	<thead>
	<tr>
		<th align="left">Name</th>
		<th align="left">Date Registered</th>
	</tr>
	</thead>
	<tbody>
	';

	//creates a table based on the data
	while ($row = mysqli_fetch_array($r, MYSQLI_ASSOC)) {
		echo '<tr><td align="left">' . $row['name'] . '</td><td align="left">' . $row['dr'] . '</td></tr>
		';
	}
	echo '</tbody></table>'; // Close the table.
	mysqli_free_result ($r); // Free up the resources.
} else { // If no records were returned.
	echo '<p class="error">There are currently no registered users.</p>';
}
mysqli_close($dbc); // Close the database connection.
include('includes/footer.html');
?>
