<?php
$titre = 'Affichage des places réservées';
include('entete.php');

	$requete = ("
		with r1 as (
		select to_char(dateRep, 'DD-MON-YY HH:MM') dateRep, NoSpec, sum(noPlace) as nbPlRes from theatre.LesTickets
		group by dateRep, NoSpec )
		select noSpec, nomS, dateRep, nbPlRes from r1 natural join theatre.LesSpectacles
		order by NoSpec, dateRep
	");
	
	// analyse de la requete et association au curseur
	$curseur = oci_parse ($lien, $requete) ;

	// execution de la requete
	$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) 
	{

		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
		echo "<p class=\"erreur\">{$error_message['message']}</p>";

	}
	else 
	{

		// oci_execute a réussi, on fetch sur le premier résultat
		$res = oci_fetch ($curseur);

		if (!$res) {

			// il n'y a aucun résultat
			echo "<p class=\"erreur\"><b> Spectacle inconnu </b></p>" ;

		}
		else {

			// on affiche la table qui va servir a la mise en page du resultat
			echo "<table><tr><th>Dates du spectacle</th><th>Numéro du Spectacle</th></tr>" ;

			// on affiche un résultat et on passe au suivant s'il existe
			do {
				$numSpec = oci_result($curseur, 1);
				$nomSpec = oci_result($curseur,2) ;
				$dateRep = oci_result($curseur,3) ;
				$nbPl = oci_result($curseur, 4);

				echo "<tr><td>$numSpec</td><td>$nomSpec</td><td>$dateRep</td><td>$nbPl</td></tr>";

			} while (oci_fetch ($curseur));

			echo "</table>";
		}

	}

	// on libère le curseur
	oci_free_statement($curseur);

	include('pied.php');
?>
