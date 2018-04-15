<?php
header('Content-type: text/html; charset=utf-8');
$username="dbo722523693";
$password="strasbourg";
$hostname = "db722523693.db.1and1.com";
$database = "db722523693";
//on sélectionne les questions et les réponses pour le quiz

$sql = "SELECT correspondre.Id_question, question.Libelle_question, reponse.Libelle_reponse, reponse.Correct, seance.Code_quizz FROM question INNER JOIN correspondre ON question.Id_question = correspondre.Id_question INNER JOIN reponse ON correspondre.Id_reponse = reponse.Id_reponse INNER JOIN poser ON question.Id_question = poser.Id_question INNER JOIN seance ON seance.Id_seance = poser.Id_seance WHERE seance.Code_quizz = 180312 ORDER BY correspondre.Id_question";
$dbhandle = mysqli_connect($hostname, $username, $password, $database)
or die("Unable to connect to MySQL");
mysqli_set_charset($dbhandle,'utf8mb4');
$result = mysqli_query($dbhandle,$sql);
$json_response = array();
$reponses = array();
//on crée le Json dans des arrays

while ($row = $result->fetch_assoc()) {
	if (!isset($json_response[ $row['Id_question'] ])){
		$json_response[ $row['Id_question'] ] = [
			'Id_question' => $row['Id_question'],
			'Libelle_question' => $row['Libelle_question'],
			'Code_quizz' => $row['Code_quizz'],
			'Reponses' => [],
		];
	}
	$json_response[ $row['Id_question'] ]['Reponses'][] = [
		'Libelle_reponse' => $row['Libelle_reponse'],
		'Correct' => $row['Correct']
	];
}
$data = [];
foreach ($json_response as $element) {
	$data[] = $element;
}
echo json_encode(array("server_response"=>$data));
mysqli_close($dbhandle);
?>
