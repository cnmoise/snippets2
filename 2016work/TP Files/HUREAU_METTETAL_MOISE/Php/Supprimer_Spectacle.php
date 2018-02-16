<?php
	$titre = 'Supprimer un spectacle ';
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
	$requete = ("
		select distinct noSpec, nomS from LesSpectacles
		order by NoSpec
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
			echo "<p class=\"erreur\"><b>Aucun Spectacle dans la base de donnée </b></p>" ;

		}
		else {

			// on affiche le formulaire de sélection
			echo ("
				<form action=\"Supprimer_Spectacle_action.php\" method=\"post\">
					<label for=\"sel_noSpec\">Sélectionnez un spectacle :</label>
					<select id=\"sel_noSpec\" name=\"noSpec\">
			");

			// création des options
			do {

				$numSpec = oci_result($curseur, 1);
				$nomSpec = oci_result($curseur, 2);

				echo ("<option value=\"$numSpec\">$numSpec $nomSpec</option>");


			} while ($res = oci_fetch ($curseur));

			echo ("
					</select>
					<br /><br />
			");
		}

	}

	// on libère le curseur
	oci_free_statement($curseur);
?>
		<input type="submit" value="Valider" />
		<input type="reset" value="Annuler" />
	</form>

<?php
	include('pied.php');

?>
