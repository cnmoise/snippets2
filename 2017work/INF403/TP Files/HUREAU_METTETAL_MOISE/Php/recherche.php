<?php
// Lorsqu'une personne clic sur le bouton reinitiliser, on se redirige vers cette même page
// et une variable est passé en "GET", on execute en fonction de quel action est à faire.
include('entete_hureauo.php');
if(isset($_GET['action'])){
		
		include('action.php');
	}
	
include('filtre.php');



?>



<?php 

// On verifie que toutes nos variables sont bien présente.

if(isset($filtre['day_before'])){
	$jour_avant = $filtre['day_before'];
} else {
	echo "Erreur jour avant";
}

if(isset($filtre['day_after'])){
	$jour_apres = $filtre['day_after'];
} else {
	echo "Erreur jour apres";
}

if(isset($filtre['hour_before'])){
	$heure_avant = $filtre['hour_before'];
} else {
	echo "Erreur heure avant";
}

if(isset($filtre['hour_after'])){
	$heure_apres = $filtre['hour_after'];
} else {
	echo "Erreur heure apres";
}

if(isset($filtre['nb_places'])){
	$nb_place= $filtre['nb_places'];
} else {
	echo "Erreur nb place";
}






?>

<?php

echo "<br></br>";

// On execute une requete permetant de trier les representations en fonction de nos variable précédente.

$requete = ("SELECT nospec, noms, nvl(place_reserv,0), daterep from lesrepresentations natural join lesspectacles
natural left join (select daterep, nospec, count(noplace) as place_reserv from lestickets group by daterep, nospec) 
where (to_number(to_char(to_timestamp(to_char(daterep,'HH24:MI:SS'), 'hh24:mi:ss'),'sssss'))) <= (to_number(to_char(to_timestamp('$heure_avant', 'hh24:mi:ss'),'sssss')))
AND to_number(to_char(to_timestamp(to_char(daterep,'HH24:MI:SS'), 'hh24:mi:ss'),'sssss')) >= to_number(to_char(to_timestamp('$heure_apres', 'hh24:mi:ss'),'sssss'))
AND daterep >= (to_date('$jour_apres', 'YYYY-MM-DD'))
AND daterep <= (to_date('$jour_avant', 'YYYY-MM-DD'))
AND (nvl(place_reserv,0))+$nb_place < (select count(noplace) from lessieges )");


	$curseur = oci_parse ($lien, $requete) ;

	
		$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {
		echo "<br></br>";
		echo "It works pas!";

		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
		echo $error_message;
	
	}
	else {
		echo '<ul class="menu">';
		// oci_execute a réussi, on fetch sur le premier résultat		
		while(oci_fetch($curseur)){
			$var1=oci_result($curseur,1);
			$var2=oci_result($curseur,2);	
			$var3=oci_result($curseur,3);		
			$var4=oci_result($curseur,4);	
			// Si la variable s'execute, on creer un bouton cliquable vers reserver.php contenant les infos necessaire
				echo '<li> <a href="reserver.php?nospec='.$var1.'&amp;date='.$var4.'&amp;action=reset_cookie"> '.$var2.' Le : '.$var4.'</a></li>';


				
		
			} 	
			
		echo '</ul>';

		
	}
	

	// on libère le curseur
	oci_free_statement($curseur);
	

	
?>

<?php

include('pied.php');

?>
