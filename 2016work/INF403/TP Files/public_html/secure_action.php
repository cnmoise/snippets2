<?php
session_start();
if (!empty($_POST['login']) and !empty($_POST['mdp'])) {
	$_SESSION['login'] = $_POST['login'];
	$_SESSION['mdp'] = $_POST['mdp'];
	$_SESSION['index'] = "1";

	echo ('
		<form action="secure_action_2.php" method="post">
			Veuillez saisir votre mail :
			<input type="text" name="mail" />
			<br /><br />
			<input type="submit" value="Valider" />
			<input type="reset" value="Annuler" />
		</form>
	');
}
else if (!empty($_GET['login']) and !empty($_GET['mdp'])) {
	$_SESSION['login'] = $_GET['login'];
	$_SESSION['mdp'] = $_GET['mdp'];
	$_SESSION['index'] = "2";

	echo ('
		<form action="secure_action_2.php" method="post">
			Veuillez saisir votre mail :
			<input type="text" name="mail" />
			<br /><br />
			<input type="submit" value="Valider" />
			<input type="reset" value="Annuler" />
		</form>
	');
}
else {
	if (!empty($_POST['login'])){
		echo "erreur mot de passe";
	}
	else if (!empty($_POST['mdp'])){
		echo "erreur login";
	}
	else if (!empty($_GET['login'])){
		echo "erreur mot de passe";
	}
	else if (!empty($_GET['mdp'])){
		echo "erreur login";
	}
	else{
		echo "erreur login et mot de passe";
	}
}


?>