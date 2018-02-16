<?php
	session_start();
	$login = $_SESSION['login'];
	$motdepasse = $_SESSION['motdepasse'];
?>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr" dir="ltr">
<head>
   <title>Gestion du Théâtre : Menu </title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="style.css" rel="stylesheet" media="all" type="text/css">
</head>

<!-- procedures et fonctions pour les mises a jour du Théâtre
	 MC Fauvet, Mars 2015 -->
<body>

<?php require_once ("utils.php");

// si l'une des variables globales est sans valeur, cela signifie
// que le navigateur n'accepte pas les cookies. Inutile de continuer
if (!isset ($login) or !isset ($motdepasse)) {
	$codeerreur = "problemevariables" ;
	echo LeMessage ($codeerreur) ;
}
else {
   include_once("navigation.php");
?>


<?php  
	$firefox = strpos($_SERVER["HTTP_USER_AGENT"], 'Firefox') ? true : false; 
	if($firefox){ 
	echo ' <script>alert("Veuillez utiliser chrome ou opera.. Les input type date ne sont pas géré sinon (format = YYYY-MM-DD) ");</script>';
	}
	?>





















<h1>Bienvenue dans l’application Théâtre !</h1>

      <?php if(isset($_SESSION['login'])) {
         echo '<p id="identif"> Vous êtes identifié-e avec l’identifiant ', $_SESSION['login'], '. <a href="connexion.php">Changer</a>.</p>';
      } else {
         echo '<p id="identif"> Peut-être que vous voulez vous <a href="connexion.php">identifier</a> ?</p>';
      } ?>

      <h2> Contenu des relations de la base de données </h2>
      <ul class="menu">
	      <li><a href="AfficherTablesFournies.php">Contenu des relations fournies <img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a> </li>
	      <li><a href="tables.php"> Relations appartenant au compte connecté <img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
      </ul>

      <h2> Requêtes fournies (observer le comportement et le code) sur la BD fournie </h2>
      <ul class="menu">
	      <li><a href="Coldplay.php"> Représention(s) Coldplay <img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
	      <li><a href="SpectaclesDossier.php"> Pour les spectacles réservés par le dossier No 11, donner les places d'une catégorie donnée <img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a> </li>
      </ul>

      <h2> Requêtes à modifier sur la BD fournie</h2>
      <ul class="menu">
          <li><a href="DetailsTicket.php">Afficher les détails d'un ticket  <img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
	      <li><a href="SpectaclesDossier_v1.php">
		  Pour les spectacles réservés par le dossier No 11, donner les places d'une catégorie donnée<br />(version améliorée 1)<img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
	      <li><a href="SpectaclesDossier_v2.php">
		  Pour les spectacles réservés par le dossier No 11, donner les places d'une catégorie donnée<br />(version améliorée 2)<img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
		  <li><a href="SpectaclesDossier_v3.php">
		  Pour les spectacles réservés par le dossier No 11, donner les places d'une catégorie donnée<br />(version améliorée 3)<img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
      </ul>

      <h2> Requêtes à réaliser sur la BD fournie</h2>
      <ul class="menu">
	      <li><a href="RepresentationsVides.php">Afficher les représentations sans place réservée<img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
	      <li><a href="ResaSpectacles1.php">
		  Pour chaque spectacle, donner son numéro, son nom, les dates de ses<br />répresentations et pour chacune le nombre de places réservées (version avec deux curseurs)<img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
	      <li><a href="ResaSpectacles2.php">
		  Pour chaque spectacle, donner son numéro, son nom, les dates de ses<br />répresentations et pour chacune le nombre de places réservées (version avec un seul curseur)<img class="valid" src="image/valid.jpg" alt="Validé !" width="20" height="20"/></a></li>
      </ul>

      <h2> Requêtes fournies (observer le comportement et le code) sur la BD à créer </h2>
      <ul class="menu">
	      <li><a href="spec_add_v1.php">Une nouvelle représentation du spectacle "Les enfoirés" est programmée le 29/02/2016 (version 1) </a> </li>
	      <li><a href="spec_add_v2.php">Une nouvelle représentation du spectacle "Les enfoirés" est programmée le 29/02/2016 (version 2) </a> </li>
	      <li><a href="spec_add_v3.php">Une nouvelle représentation du spectacle "Les enfoirés" est programmée le 29/02/2016 (version 3) </a> </li>
      </ul>

      <h2> Tâches à réaliser sur la BD à créer</h2>
      <ul class="menu">
		  <li><a href="GererRepresentations.php">Gérer les représentations</a> <br>
		  <li><a href="recherche.php">Gérer les réservations</a> <br>  
      </ul>

<?php } ?>

