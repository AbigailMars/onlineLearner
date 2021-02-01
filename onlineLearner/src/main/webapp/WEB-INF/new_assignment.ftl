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
  padding: 15px 30px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  background-color: #4CAF50;
  float:right;
}
input[type=text],textarea {
  width: 50%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}
</style>

<body>
	<div id="wrapper">
		<div id="header">
		<h1 align = center> onlineLearner</h1>
		</div>	   
		<div id="site">
		</br></br>
        <#if kurs ??>
        <p><h3 align = center> Kurs:&nbsp;&nbsp;${kurs.name}</h3></p></br>
        </#if>
		<#if aufgabe ??>
		<p><h3 align = center> Aufgabe:&nbsp;&nbsp; ${aufgabe.name}</h3></p></br>
		<p><h3 align = center> Beschreibung:&nbsp;&nbsp; ${aufgabe.beschreibung}</h3></p></br>
		</#if>
		<form name="form" action = "insertAssignment?anummer=${aufgabe.anummer}&kid=${kurs.kid}"  method="post"></br>
        <p><h3 align = center>Abgabetext:&nbsp;&nbsp; <textarea row="5" cols="30" name ="abgabetext"/></textarea></h3></p></br>
		<input id = "button" type = "submit" value ="Einreichen"> </input>
		</br></br>
	</form>
	</div>
	</div>

</body>
</html>