<?php

	// récupération des variables
	$numSpec = $_POST['noSpec'];
	$nomSpec=" ";
	$date = $_POST['date'];
	$time = $_POST['time'];
	$dateRep = $date." ".$time;

	$previous_page = "modif_rpz.php";
	include('entete_v2.php');

	// ----------envoi a la bdd
	var_dump("UPDATE LesRepresentations set dateRep = to_date('".$dateRep."', 'DD/MM/YYYY HH24:MI') 
				WHERE noSpec = ".$numSpec." ");
	// construction des requêtes
	$requete1 = "UPDATE LesRepresentations set dateRep = to_date('".$dateRep."', 'DD/MM/YYYY HH24:MI') 
				WHERE noSpec = ".$numSpec." ";

	// analyse de la requete 1 et association au curseur
	$curseur = oci_parse ($lien, $requete1) ;

	// association des variables
	//oci_bind_by_name ($curseur1,':n', $numSpec);
	//oci_bind_by_name($curseur1, ':d', $dateRep)

	// execution de la requete
	$ok = @oci_execute ($curseur, OCI_NO_AUTO_COMMIT) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		echo LeMessage ("majRejetee")."<br /><br />";
		$e = oci_error($curseur);
	
		echo LeMessageOracle ($e['code'], $e['message']) ;

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
