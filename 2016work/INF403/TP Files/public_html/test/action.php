<?php 
	switch($_GET['action']) {
	case "reset_filtre":
		unset($_SESSION['filtre']);
		break;
	case "reset_cookie";
		unset($_COOKIE['reservation']);
		include('var.php');
	default:
		break;
		
}


?>