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
</style>

<body>
	<div id="wrapper">
		<div id="header">
		<h1> Informationen </h1>
	</div>
	   
	<div id="site">
	<#if kurs ??>
      <h2>${kurs.name}</h2></br>
      <h3>Ersteller : ${kurs.ersteller}</h3></br>
      <p>${kurs.beschreibungstext}</p></br>
      <h3>Anz.freier Plaeze : ${kurs.freieplaetze}</h3></br>
   </#if>
   
     <button onclick="javascript:window.location.href='hello'">Kurs Loeschen</button>
      
	 <h2> Liste der Aufgaben</h2>
	

     <table> <tr>
        <td>
	    	<h3>Aufgabe</h3>
		    <#list aufgabeList as aufgabe>
				<label><a href ="newAssignment?anummer=${aufgabe.anummer}">${aufgabe.name}</a></label><br>
		    </#list>
		</td>
	    <td>
		    <h3>Meine Abgabe</h3>
		    <#list aufgabeList as aufgabe>
				<label>${aufgabe.abgabetext}</label><br>
		    </#list>
	    </td>
	    <td>
		    <h3>Bewertungsnote</h3>
		    <#list aufgabeList as aufgabe>
				<label>${aufgabe.note}</label><br>
		    </#list>
	    </td>
   </tr></table>


    
    

</div>
</body>
</html>
