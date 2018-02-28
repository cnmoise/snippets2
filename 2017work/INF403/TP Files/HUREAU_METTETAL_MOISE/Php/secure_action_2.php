<?php
session_start();
$_SESSION['mail'] = $_POST['mail'];

if (!empty($_POST['mail'])) {
	echo "Votre login est ".$_SESSION['login'].", votre mot de passe : ".$_SESSION['mdp'].", votre mail : ".$_SESSION['mail'].", et vous venez de l'index : ".$_SESSION['index'].".";

}
else {
	echo "erreur : mail non renseigné";
}


?>