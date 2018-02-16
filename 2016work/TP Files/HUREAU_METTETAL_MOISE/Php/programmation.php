<?php
	$titre = 'Ajouter un Spectacle';
	
	$previous_page = "GererRepresentations.php";
	include('entete_v2.php');
	
	// construction de la requete
	$requete = ("
		select noSpec, dateDebut, dateFin, type from LesProgrammations
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
			echo "<table><tr><th>Numéro du Spectacle</th><th>Date de debut</th><th>date de Fin</th><th>type</th><th>duree</th></tr>" ;

			// on affiche un résultat et on passe au suivant s'il existe
			do {

				$numS = oci_result($curseur,1) ;
				$dateDebut = oci_result($curseur,2) ;
				$dateFin = oci_result($curseur, 3);
				$type = oci_result($curseur, 4);
				//$debut= new DateTime($dateDebut);
				//$fin= date_create($dateFin);
				//$duree = $dateFin->diff($dateDebut);
				//$duree->format('%R%a days')

				//$debut = DateTime::createFromFormat('d-m-y',$dateDebut);
				//echo $debut;

				echo "<tr><td>$numS</td><td>$dateDebut</td><td>$dateFin</td><td>$type</td><td>$debut</td></tr>";

			} while (oci_fetch ($curseur));

			echo "</table>";
		}

	}

	// on libère le curseur
	oci_free_statement($curseur);

	//---------------------------------------------------------- et formulaire
?>


	<form action="prog2.php" method="post">
		<label for="type">Entrez un type de spectacle :</label>
		<input type="text" name="type" id="type"/>
		<br /><br />
		<input type="submit" value="Valider" />
		<input type="reset" value="Annuler" />
	</form>

<?php
	include('pied.php');

?>
