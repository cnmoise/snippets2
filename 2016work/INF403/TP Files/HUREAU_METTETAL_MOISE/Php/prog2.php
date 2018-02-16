<?php
	$titre = 'Ajouter un Spectacle';
	$previous_page = "programmation.php";
	include('entete_v2.php');
	
	// construction de la requete
	$requete = ("
		select noSpec, dateDebut, dateFin, type from LesProgrammations
		where type = :n
		order by noSpec
	");

	// analyse de la requete et association au curseur
	$curseur = oci_parse ($lien, $requete) ;

	oci_bind_by_name($curseur, ':n', $_POST['type']);

	// execution de la requete
	$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
		echo "<p class=\"erreur\">{$error_message['message']}</p>";

	}
	else {

		// oci_execute a réussi, on fetch sur le premier résultat
		$res = oci_fetch ($curseur);

		if (!$res) {

			// il n'y a aucun résultat
			echo "<p class=\"erreur\"><b> Spectacle inconnu </b></p>" ;

		}
		else {

			// on affiche la table qui va servir a la mise en page du resultat
			echo "<table><tr><th>Numéro du Spectacle</th><th>Date de debut</th><th>date de Fin</th><th>type</th><th>date</th></tr>" ;

			// on affiche un résultat et on passe au suivant s'il existe
			do {

				$numS = oci_result($curseur,1) ;
				$dateDebut = oci_result($curseur,2) ;
				$dateFin = oci_result($curseur, 3);
				$type = oci_result($curseur, 4);

				//$date = new DateTime($dateDebut,new DateTimeZone('Paris/Europe'));
				//$date = DateTime::createFromFormat('DD/MM/YYYY HH24:MI',$dateDebut);

				echo "<tr><td>$numS</td><td>$dateDebut</td><td>$dateFin</td><td>$type</td><td>$date</td></tr>";

			} while (oci_fetch ($curseur));

			echo "</table>";
		}

	}

	// on libère le curseur
	oci_free_statement($curseur);

	//---------------------------------------------------------- Calendrier 

//error_reporting(E_ALL);

define("GET_DATE_FORMAT","Y-m-d");
if(isset($_POST['firstday'])){
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
?></tbody> </table>
<!-- fin du calendrier -->


	<form action="prog3.php" method="post">
		<label for="mois">Entrez une date de début:</label>
		<input type="date" name="mois" id="mois"/>
		<br /><br />
		<input type="submit" value="Valider" />
		<input type="reset" value="Annuler" />
	</form>

<?php
	include('pied.php');

?>
