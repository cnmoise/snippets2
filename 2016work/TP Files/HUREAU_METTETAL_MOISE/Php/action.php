<?php 
// Ceci est l'include dans certaines pages, lorsqu'il est appelé il gère les différentes actions a faire
// Ici on s'en sert principalement pour la gestion des cookies.
	switch($_GET['action']) {
	case "reset_filtre":
		unset($_COOKIE['filtre']);
				break;
	case "reset_cookie";
		
		unset($_COOKIE['reservation']);
		 setcookie('reservation', NULL, -1);
			break;
	default:
		break;
		
}


?>
