<?php
	$titre = 'Representations programées';
	$previous_page = "menu.php";
	include('entete_v2.php');

	// construction de la requete
	$requete = ("
		select noSpec, nomS, to_char(dateRep, 'DD/MON/YYYY HH24:MI') dateRep from LesSpectacles natural join LesRepresentations
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

	echo '<p class="gerer"><a href="Ajouter_Representations.php"><input type="button" name="Ajouter" value="Ajouter une Representation"/></a></p>' ;

	echo '<p class="gerer"><a href="modif_rpz.php"><input type="button" name="modif1" value="Modifier une Representation"/></a></p>' ;

	echo '<p class="gerer"><a href="Supprimer_Representations.php"><input type="button" name="Supprimer" value="Supprimer une Representation"/></a></p>' ;

	echo '<p class="gerer"><a href="Ajouter_Spectacle.php"><input type="button" name="Ajouter" value="Ajouter un Spectacle"/></a></p>' ;

	echo '<p class="gerer"><a href="modif_Spectacle.php"><input type="button" name="modif2" value="Modifier un Spectacle"/></a></p>' ;

	echo '<p class="gerer"><a href="Supprimer_Spectacle.php"><input type="button" name="Supprimer" value="Supprimer un Spectacle"/></a></p>' ;

	echo '<p class="gerer"><a href="programmation.php"><input type="button" name="programmation" value="Programmer un Spectacle"/></a></p>' ;

	include('pied.php');
?>
