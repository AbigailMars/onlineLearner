<html>
<head><title>ViewCourse</title>
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
  float:right;
  font-size: 16px;
}
a:link, a:visited {
  background-color: #4CAF50;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: #4CAF50;
}

</style>

<body>
	<div id="wrapper">
		<div id="header">
		<h1 align = center> Informationen </h1>
		</div>
	    <div id="site">
	<#if kurs ??>
      <h2 align = center>${kurs.name}</h2></br>
      <p><h4 align = center>Ersteller : ${kurs.ersteller}</h4></P></br>
      <p><h4 align = center>${kurs.beschreibungstext}</h4></P></br>
       <p><h3 align = center>Anz.freier Plaetze : ${kurs.freieplaetze}</h3></P></br>
   </#if>
	 <button id ="button"><a href="newEnroll?kid=${kurs.kid}">Einschreiben</a></button>
		</br></br>
		
		</div>
	</div>
	
</body>
</html>
