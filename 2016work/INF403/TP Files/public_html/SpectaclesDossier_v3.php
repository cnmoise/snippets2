<?php

	$titre = 'Liste des dossiers';
	$previous_page = "menu.php";
	include('entete_v2.php');

	// construction de la requete
	$requete = ("
		SELECT distinct noDossier
		FROM theatre.LesTickets --LesDossiers
		ORDER BY noDossier
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
			echo "<p class=\"erreur\"><b>Aucun dossier dans la base de donnée</b></p>" ;

		}
		else {

			// on affiche le formulaire de sélection
			echo ("
				<form action=\"SpectaclesDossier_v3_2.php\" method=\"post\">
					<label for=\"sel_noDossier\">Veuillez saisir un dossier :</label>
					<select id=\"sel_noDossier\" name=\"noDossier\">
			");

			// création des options
			do {

				$noDossier = oci_result($curseur, 1);
				echo ("<option value=\"$noDossier\">$noDossier</option>");

			} while ($res = oci_fetch ($curseur));

			echo ("
					</select>
					<br /><br />
					<input type=\"submit\" value=\"Valider\" />
					<input type=\"reset\" value=\"Annuler\" />
				</form>
			");

		}

	}

	// on libère le curseur
	oci_free_statement($curseur);

	include('pied.php');

?>

