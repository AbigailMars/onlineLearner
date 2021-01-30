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
		<#if kurs ??>
		<p>
			${kurs.name}
		</p>
		</#if>
			<form name="form" action = "insertEnroll?kid=${kurs.kid}" method="post">
		<p> Einschreibeschluessel <input type = "text" name = "einschreibeschluessel"> </input> </p>        
		  <input type = "submit" value ="Erstellen"> </input>
	</form>
	</div>
	</div>

</body>
</html>