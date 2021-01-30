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
</style>

<body>
	<div id="wrapper">
		<div id="header">
		<h1> OnlineLearner Website </h1>
		</div>
	   
		<div id="site">
		<p>
			Kurs erstellen 
		</p>
			<form name="form" action = "insertKurs" onsubmit = "return beforeSubmit(this);" method="post">
		<p> Name <input type = "text" name = "name"> </input> </p>
		<p> Einschreibeschluessel <input type = "text" name = "einschreibeschluessel"> </input> </p>
        <p> Anz.freier Plaeze <input type = "text " name = "plaeze" min = "1" max = "100"> </input> </p>
        <p> Beschreibungstext <textarea row="5" cols="30" name ="beschreibungstext"/></textarea> </p>
		<input type = "submit" value ="Erstellen"> </input>
	</form>
	</div>
	</div>
<script type="text/javascript">
function beforeSubmit(form){
if(form.name.value==''){
alert('die Länge des eingegeben Namen leer ist');
form.name.focus();
return false;
}

return true;
}
</script>
	
</body>
</html>