<?php
   if(!isset($_SESSION))
      session_start();

   //header('Content-Type: application/xhtml+xml; charset=utf-8');

   if (!isset ($_SESSION['login']) || !isset ($_SESSION['motdepasse'])) {
      // Si l’utilisateur/trice n’est pas connecté-e, on le renvoie à la page de connexion
      header('Status: 304');
      header('Location: connexion.php'); // redirection vers la page de connexion
      die();
   }

   require_once ('utils.php');
?>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
   <head>
      <meta charset="utf-8" />
      <title>
         <?php if(isset($titre))
            echo htmlspecialchars($titre) . ' - ';
         ?>
         Gestion du Théâtre
      </title>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
     <link href="style.css" rel="stylesheet" media="all" type="text/css" />
   </head>
   <body>
		<?php
			include_once("navigation.php");
		?>
		<h1> Gestion du Théâtre </h1>
		<?php

			if(isset($titre))
				echo '<h2>', $titre, '</h2>';

			if(!isset($ne_pas_connecter) || !$ne_pas_connecter) {
				// Si la page n'a pas demandé à ne pas se connecter, on se connecte
				Connexion ($_SESSION['login'], $_SESSION['motdepasse'], $lien, $codeerreur);

				if (!$lien) { // erreur
					echo LeMessage ($codeerreur);
					include('pied.php');
					die();
				}
			}
		?>


<?php
error_reporting(E_ALL);

define("GET_DATE_FORMAT","Y-m-d");
if(isset($_GET['firstday'])){
    //on vérifie le format de l'entrée GET : n'oubliez pas qu'il ne faut jamais faire confiance aux entrées utilisateur!
    try{
        
        $firstDay = DateTime::createFromFormat(GET_DATE_FORMAT,$_GET['firstday']);//si la donnée est au mauvais format, une exception est lancée
        
        $firstDay->modify("first day of this month");//pour être vraiment sûr que les données sont cohérentes
    }catch(Excpetion $e){
        
        $firstDay = new DateTime("first day of this month");
    }
}else{
    $firstDay = new DateTime("first day of this month");
}



$formatter_semaine = new IntlDateFormatter("fr_FR",IntlDateFormatter::FULL,IntlDateFormatter::FULL,'Europe/Paris',
                IntlDateFormatter::GREGORIAN,"EEEE" );
$formatter_semaine->setPattern("EEEE");
$formatter_mois = new IntlDateFormatter("fr_FR",IntlDateFormatter::FULL,IntlDateFormatter::NONE,'Europe/Paris',
                IntlDateFormatter::GREGORIAN,"MMMM" );
$formatter_mois->setPattern("MMMM");
?>
<h1><?php echo $formatter_mois->format($firstDay);?></h1>
<?php
$lastDay = clone $firstDay;
$lastDay->modify("last day of this month");// le dernier jour du mois
$offset_depart = $firstDay->format("w");// le nombre de jour qu'il faut passer au début du calendrier
$offset_fin = 6 - $lastDay->format("w");// le nombre de jour qu'il reste dans la dernière semaine du calendrier
$firstDay->modify("-$offset_depart days" );
$lastDay->modify("+$offset_fin days");
$dateInitWeek = clone $firstDay;
$endInitWeek = clone $dateInitWeek;
$endInitWeek->modify("+7 days");
$intervalInitWeek = new DateInterval("P1DT0S");
$aujourdhui = new DateTime("today");
?>
<table>
    <tbody>
        <tr>
            <?php 
            foreach(new DatePeriod($dateInitWeek,$intervalInitWeek,$endInitWeek) as $jour){
                 if($jour->format("w")==0){
                    echo "<th class=\"dimanche\">",$formatter_semaine->format($jour),"</th>";
                }else{
                    echo "<th>",$formatter_semaine->format($jour),"</th>";
                }
                
            }?>
        </tr>

<?php

$lastDay->modify("+1 day");//c'est une astuce pour utiliser DatePeriod 
//qui ne sait pas prendre en compte le dernier jour si on ne fait pas ça
$intervale_iteration = new DateInterval("P1DT0S");
$iterateur = new DatePeriod($firstDay,$intervale_iteration,$lastDay);
$i = 0;
foreach($iterateur as $jour){
    if($i == 0){
        echo "<tr>";
    }
    if($jour == $aujourdhui){
                    echo "<td id=\"today\">",$jour->format("d"),"</td>";
                }else if($jour->format("w")==0){
                    echo "<td class=\"dimanche\">",$jour->format("d"),"</td>";
                }else{
                    echo "<td>",$jour->format("d"),"</td>";
                }
    $i++;
    $i %=7;
    if($i == 0){
        echo "<tr/>";
    }
}
?>
    </tbody>
</table>

<?php 

$datetime1 = date_create('2009-10-11');
$datetime2 = date_create('2009-10-13');
$interval = date_diff($datetime1, $datetime2);
echo $interval->format('%m mois');


	$debut= new DateTime(to_char($dateDebut, 'DD/MM/YYYY HH24:MI'));
	$fin= new DateTime(to_char($dateFin, 'DD/MM/YYYY HH24:MI'));
	$duree = $dateFin->diff($dateDebut);
	echo $duree;

	$date = DateTime::createFromFormat('d/m',$maDate);
	
	include 'pied.php';
 ?>