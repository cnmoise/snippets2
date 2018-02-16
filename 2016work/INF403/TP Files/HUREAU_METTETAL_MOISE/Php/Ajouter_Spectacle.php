<?php
	$titre = 'Ajouter un Spectacle';
	
	$previous_page = "GererRepresentations.php";
	include('entete_v2.php');
	
	// construction de la requete
	$requete = ("
		select noSpec, nomS from LesSpectacles
		order by noSpec
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
			echo "<table><tr><th>Numéro du Spectacle</th><th>Nom du Spectacle</th></tr>" ;

			// on affiche un résultat et on passe au suivant s'il existe
			do {

				$numS = oci_result($curseur,1) ;
				$nomS = oci_result($curseur,2) ;
				echo "<tr><td>$numS</td><td>$nomS</td></tr>";

			} while (oci_fetch ($curseur));

			echo "</table>";
		}

	}

	// on libère le curseur
	oci_free_statement($curseur);

	//---------------------------------------------------------- formulaire
?>
	<form action="Ajouter_Spectacle_action.php" method="post">
		<label for="nom">Entrez un nom de spectacle :</label>
		<input type="text" name="nom" id="nom"/>
		<br /><br />
		<label for="duree">Entrez la durée en minutes du spectacle :</label>
		<input type="number" name="duree" id="duree"/>
		<br /><br />
		<input type="submit" value="Valider" />
		<input type="reset" value="Annuler" />
	</form>

<?php
	include('pied.php');

?>
