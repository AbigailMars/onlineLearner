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
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 2px 2px;
  cursor: pointer;
  background-color: #4CAF50;
  float:right;
}

#aufgabe {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#aufgabe td, #aufgabe th {
  border: 1px solid #ddd;
  padding: 8px;
}

#aufgabe tr:nth-child(even){background-color: #f2f2f2;}

#aufgabe tr:hover {background-color: #ddd;}

#aufgabe th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
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
   <button id ="button" onclick="javascript:window.location.href='deleteCourse?kid=${kurs.kid}'">Kurs Loeschen</button>
     </#if>
    
   </br></br>
   <hr />
      </br>
	 <h2 align = center> Liste der Aufgaben</h2>
	 </br>
	 <table id="aufgabe">
    <tr>
        <td>Aufgabe</td> <td>Meine abgabe</td><td>Bewerbungsnote</td>
    </tr>
	<#if aufgabeList ?? >
    <#list aufgabeList as aufgabe>
    <tr>
        <td><a href ="newAssignment?anummer=${aufgabe.anummer}&kid=${kurs.kid}">${aufgabe.name}</a></td> 
        <td>${aufgabe.abgabetext}</td>
        <td>${aufgabe.note}</td>
    </tr>
   </#list>
   </#if>
   </table>
		</div>
	</div>
	
</body>
</html>
