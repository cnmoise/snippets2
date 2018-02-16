<?php

	// récupération des variables
	$numSpec = $_POST['noSpec'];
	$nomSpec=" ";
	$date = $_POST['date'];
	$time = $_POST['time'];
	$dateRep = $date." ".$time;

	$previous_page = "Supprimer_Representations.php";
	include('entete_v2.php');
	// construction de la requete
	$requete = ("
		SELECT nomS from LesSpectacles
		WHERE noSpec = :n
	");

	// analyse de la requete et association au curseur
	$curseur = oci_parse ($lien, $requete) ;

	// affectation de la variable
	oci_bind_by_name ($curseur,':n', $numSpec);

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
			// on affiche un résultat et on passe au suivant s'il existe
			do {

				$nomSpec = oci_result($curseur,1) ;
			} while (oci_fetch ($curseur));
		}

	}

	// on libère le curseur
	oci_free_statement($curseur);


	// ----------envoi a la bdd
	echo $numSpec;
	echo " ";
	echo $dateRep;
	// construction des requêtes
	$requete = "DELETE FROM LesRepresentations WHERE noSpec=".$numSpec." and dateRep=to_date('".$dateRep."', 'YYYY-MM-DD HH24:MI')";

	// analyse de la requete 1 et association au curseur
	$curseur = oci_parse ($lien, $requete) ;

	// association des variables
	//oci_bind_by_name ($curseur1,':o', $numSpec);
	//oci_bind_by_name($curseur1, ':d', $dateRep)

	// execution de la requete
	$ok = @oci_execute ($curseur, OCI_NO_AUTO_COMMIT) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		echo LeMessage ("majRejetee")."<br /><br />";
		$e = oci_error($curseur);
		if ($e['code'] == 1) {
			echo LeMessage ("spectacleconnu") ;
		}
		else {
			echo LeMessageOracle ($e['code'], $e['message']) ;
		}

		// terminaison de la transaction : annulation
		oci_rollback ($lien) ;

	}
	else {

			echo LeMessage ("majOK") ;
			// terminaison de la transaction : validation
			oci_commit ($lien) ;

	}

	// on libère le curseur
	oci_free_statement($curseur);

	include('pied.php');

?>
