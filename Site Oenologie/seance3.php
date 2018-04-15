<?php  
header('Content-type: text/html; charset=utf-8');
$username="dbo722523693";  
$password="strasbourg";  
$hostname = "db722523693.db.1and1.com";
$database = "db722523693";  
$sql = "SELECT * FROM `seance` WHERE Id_seance=3";
//connection string with database  
$dbhandle = mysqli_connect($hostname, $username, $password, $database)  
or die("Unable to connect to MySQL");  

mysqli_set_charset($dbhandle,'utf8mb4');
$result = mysqli_query($dbhandle,$sql);  
$json_response = array();  
// fetch data in array format  
while ($row = mysqli_fetch_array($result)) {  
	// Fetch data of Fname Column and store in array of row_array  
	$row_array['Id_seance'] = $row['Id_seance'];  
	$row_array['Libelle'] = $row['Libelle'];  
	$row_array['Date'] = $row['Date'];  
	$row_array['Informations'] = $row['Informations'];  
	$row_array['Code_quizz'] = $row['Code_quizz'];  
	//push the values in the array  
	array_push($json_response,$row_array);  
}  
//  
echo json_encode(array("server_response"=>$json_response)); 
mysqli_close($dbhandle); 
?>  