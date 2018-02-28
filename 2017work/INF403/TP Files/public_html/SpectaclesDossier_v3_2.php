<?php
	session_start();
	if (isset($_POST['noDossier'])){$_SESSION['dossier'] = $_POST['noDossier'];}
	$titre = "Liste des catégories pour le dossier n°".$_SESSION['dossier'];
	$previous_page = "SpectaclesDossier_v3.php";
	include('entete_v2.php');

	// construction de la requete
	$requete = ("
		SELECT distinct nomC
		FROM theatre.LesTickets natural join theatre.LesSieges natural join theatre.LesZones
		WHERE  noDossier = (:n)
		ORDER BY nomC
	");

	// analyse de la requete et association au curseur
	$curseur = oci_parse ($lien, $requete) ;

	// affectation de la variable
	$dossier = $_SESSION['dossier'];
	oci_bind_by_name ($curseur,':n', $dossier);

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
			echo "<p class=\"erreur\"><b>Aucune catégorie dans le dossier $noDossier</b></p>" ;

		}
		else {

			// on affiche le formulaire de sélection
			echo ("
				<form action=\"SpectaclesDossier_v3_action.php\" method=\"post\">
					<label for=\"sel_nomC\">Veuillez saisir une catégorie :</label>
					<select id=\"sel_nomC\" name=\"categorie\">
			");

			// création des options
			do {

				$nomC = oci_result($curseur, 1);
				echo ("<option value=\"$nomC\">$nomC</option>");

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

