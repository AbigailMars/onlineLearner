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

input[type=text] {
  width: 50%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
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
</style>

<body>
	<div id="wrapper">
		<div id="header">
		<#if kurs ??>
		<h1 align = center>${kurs.name}</h1>
		</#if>
		</div>	
		   
		<div id="site">
		
			<form name="form" action = "insertEnroll?kid=${kurs.kid}" method="post">
		<p><h4 align = center> Einschreibeschluessel <input type = "text" name = "einschreibeschluessel"> </input></h4> </p>        
		  <input id="button" type = "submit" value ="Einschreiben"> </input>
	</form>
	</br></br>
	</div>
	</div>

</body>
</html>