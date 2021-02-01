<html>
<head><title>NewCourse</title></head>
<style type="text/css">
* {
   margin:0;
   padding:0;
}

body{
   text-align:center;
   background: #efe4bf none repeat scroll 0 0;
}

#wrapper{
   width:960px;
   margin:0 auto;
   text-align:left;
   background-color: #fff;
   border-radius: 0 0 10px 10px;
   padding: 20px;
   box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
}

#header{
 color: #fff;
 background-color: #2c5b9c;
 height: 3.5em;
 padding: 1em 0em 1em 1em;
 
}

#site{
    background-color: #ff==f;
    padding: 20px 0px 0px 0px;
}
.centerBlock{
	margin:0 auto;
}

#button{
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  background-color: #4CAF50;
  float:right;
}

input[type=text], select, textarea {
  width: 50%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

input[type=number] {
  width: 5%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}
</style>

<body>
	<div id="wrapper">
		<div id="header">
		<h1 align = center> onlineLearner </h1>
		</div>
	   
		<div id="site">
		<p id="title">
			<h1>Kurs erstellen </h1><br>
		</p>
		<form name="form" action = "insertKurs" onsubmit = "return beforeSubmit(this);" method="post">
		<p> Name <input type = "text" name = "name"> </input></h4> </p></br>
		<p> Einschreibeschluessel  <input type = "text" name = "einschreibeschluessel"> </input> </p></br>
        <p> Anz.freier Plaetze  <input type = "number" name = "plaeze" min = "1" max = "100"> </input> </p></br>
        <p> Beschreibungstext  <textarea style="height:100px" name ="beschreibungstext"/></textarea> </p></br>
		<div><input id="button" type = "submit" value ="Erstellen"> </input></div>
	</form>
	  </br></br></br>	
	</div>
	</div>
	
<script type="text/javascript">

function beforeSubmit(form){
if(form.name.value==''){
alert('die Länge des eingegeben Namen leer ist');
form.name.focus();
return false;
}
if(form.name.value.length > 50){
alert('die Länge des eingegeben Namen 50 überschreitet');
form.name.focus();
return false;
}
return true;
}

</script>
	
</body>
</html>