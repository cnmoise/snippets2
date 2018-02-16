<?php
	$login=theatre;
	$titre = 'Representations programées';
	include('entete.php');

	// construction de la requete
	$requete = ("
		select noSpec, nomS, to_char(dateRep, 'DD-MON-YY HH:MM') dateRep from ".$login.".LesSpectacles natural join ".$login.".LesRepresentations
		order by noSpec, dateRep
	");

	// analyse de la requete et association au curseur
	$curseur = oci_parse ($lien, $requete) ;

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
			echo "<table><tr><th>Numéro du Spectacle</th><th>Nom du Spectacle</th><th>Dates du spectacle</th></tr>" ;

			// on affiche un résultat et on passe au suivant s'il existe
			do {

				$numS = oci_result($curseur,1) ;
				$nomS = oci_result($curseur,2) ;
				$dateRep = oci_result($curseur, 3);
				echo "<tr><td>$numS</td><td>$nomS</td><td>$dateRep</td></tr>";

			} while (oci_fetch ($curseur));

			echo "</table>";
		}

	}

	// on libère le curseur
	oci_free_statement($curseur);

	<a href="Ajouter_Representations.php"><input type="button" name="Ajouter une Representation" value="Ajouter"></a>

	include('pied.php');
?>
