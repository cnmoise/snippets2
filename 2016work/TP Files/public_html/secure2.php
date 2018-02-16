<?php
echo ('
		<form action="secure_action.php" method="get">
			Veuillez saisir votre login :
			<input type="text" name="login" />
			<br /><br />
			Veuillez saisir votre mdp :
			<input type="password" name="mdp" />
			<br /><br />
			<input type="submit" value="Valider" />
			<input type="reset" value="Annuler" />
		</form>
	');



?>