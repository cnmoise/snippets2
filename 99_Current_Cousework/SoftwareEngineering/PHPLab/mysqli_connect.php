<?php #script
// This file contains the database access information.
// This file also establishes a connection to MySQL,
// selects the database, and sets the encoding.

//put this folder in a safe place to prevent others from using it

define('DB_USER', 'cs319_1_fall2018_group2');
define('DB_PASSWORD', 'cs319Vq@@Qs');
define('DB_HOST', 'http://cs.neiu.edu');
define('DB_NAME', 'cs319_1_fall2018_group2_db');

//handling with an OR clause
//if 1st part is false so the second must be true
$dbc = @mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME) OR die('Could not connect to MySQL: ' . mysqli_connect_error() );

//sets character encoding
mysqli_set_charset($dbc, 'utf8');

//omited the closing tag for reasons