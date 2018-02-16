<?php 

include('entete_hureauo.php');

echo '<p><a href="reserver.php"><input type="button" value="Retour reservation"></input></a></p>';
echo '<p><a href="recherche.php?action=reset_cookie"><input type="button" value="Retour recherche"></input></a></p>';
$resa = unserialize($_COOKIE['reservation']);

// Ici on stock dans notre variable prix tel que $prix[nom_de_la_zone] renvoi le prix du ticket dans cette zone
$prix = array();
$requete = ("SELECT nomc, prix
		FROM LesCategories");

	$curseur = oci_parse ($lien, $requete) ;

	
		$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
	
	
	}
	else {

		// oci_execute a réussi, on fetch sur le premier résultat
		$res = oci_fetch ($curseur);

		if (!$res) {
			echo "Erreur, la requete n'as pas aboutie";

		}
		else {
			
			
			do{
			$nom_zone=oci_result($curseur,1);
			$prix_zone=oci_result($curseur,2);
			$prix[$nom_zone] = $prix_zone;
			
			
			
				
		
			} while(oci_fetch($curseur));	
		}
	}

	// on libère le curseur
	oci_free_statement($curseur);

// On recupere le nom des zones ainsi que leurs identifiants, stocké dans $zone	
$requete = ("SELECT nomc
		FROM LesZones");

	$curseur = oci_parse ($lien, $requete) ;

	
		$ok = @oci_execute ($curseur) ;

	// on teste $ok pour voir si oci_execute s'est bien passé
	if (!$ok) {

		// oci_execute a échoué, on affiche l'erreur
		$error_message = oci_error($curseur);
	
	
	}
	else {

		// oci_execute a réussi, on fetch sur le premier résultat
		$res = oci_fetch ($curseur);

		if (!$res) {
			echo "Erreur, la requete n'as pas aboutie";

		}
		else {
			$min_rang=array();
			$zone = array();
			$zone['nb_zone']=0;
			
			do{
			$var=oci_result($curseur,1);
			$zone['nb_zone']++;
			$zone['nom_zone'][$zone['nb_zone']] = $var ;
			
			
				
		
			} while(oci_fetch($curseur));	
		}
	}

	// on libère le curseur
	oci_free_statement($curseur);

// On cree notre variable ticket qui vas contenir tout les tickets
// tickets[0] contient le nombre de tickets
// tickets[n] contient les différentes informations du ticket	
	
$ticket = array();
$ticket[0] = 0;
for($i = 1; $i <= $zone['nb_zone'] ; $i++){
	$nom_zone=$zone['nom_zone'][$i];
	for($j = 1 ; $j <= $resa[$nom_zone][0]; $j++) {
		$ticket[0]++;
		$nb_ticket = $ticket[0];
		$ticket[$nb_ticket] = array();
		$ticket[$nb_ticket]['nom_zone'] = $nom_zone;
		$ticket[$nb_ticket]['rang'] = $resa[$nom_zone][$j][rang];
		$ticket[$nb_ticket]['place'] = $resa[$nom_zone][$j][place];
			}
}
$ticket['total']=0;

for($i=1; $i <= $ticket[0]; $i++){
	$ticket['total'] = $ticket['total'] + $prix[ $ticket[$i]['nom_zone']];
	echo "<br></br>";

}
// On enregistre la variable en cookie.
setcookie('ticket',serialize($ticket), time()+300, "/");

echo "<p> Le prix a payé pour les ";
echo $ticket[0];
echo " place est de ";
echo $ticket['total'];
echo "</p> <br></br> <p> Procéder au paiment </p> " ;
?>

<a href="paiement_effectue.php"> <img src="image/paypal.jpeg" height="100" width="100"></img></a>
<a href="paiement_effectue.php"> <img src="image/cb.png" height="100" width="100"></img></a>
















<?php

include('pied.php');

?>