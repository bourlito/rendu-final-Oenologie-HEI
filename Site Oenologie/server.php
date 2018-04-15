<?php
session_start();

// initializing variables
$username = "";
$errors = array();

// connexion à la base de données
$db = mysqli_connect('db722523693.db.1and1.com', 'dbo722523693', 'strasbourg', 'db722523693');
mysqli_set_charset('utf8');
// si le bouton est cliqué
if (isset($_POST['login_user'])) {
  $username = mysqli_real_escape_string($db, $_POST['username']);
  $password = mysqli_real_escape_string($db, $_POST['password']);

  if (empty($username)) {
  	array_push($errors, "Username is required");
  }
  if (empty($password)) {
  	array_push($errors, "Password is required");
  }
// si il n'y a pas d'erreurs on regarde dans la base de données si le usernae et le mdp concordent
  if (count($errors) == 0) {
  	$query = "SELECT * FROM users WHERE username='$username' AND password='$password'";
  	$results = mysqli_query($db, $query);
  	if (mysqli_num_rows($results) == 1) {
  	  $_SESSION['username'] = $username;
  	  $_SESSION['success'] = "You are now logged in";
      //on renvoit sur la page index 
  	  header('location: index.php');
  	}else {
  		array_push($errors, "Wrong username/password combination");
  	}
  }
}

?>
