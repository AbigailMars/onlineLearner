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
		<h1> OnlineLearner Website </h1>
		</div>
	   
		<div id="site">
	<#if kurs ??>
      <h3>${kurs.name}</h3></br>
      <p>Ersteller : ${kurs.ersteller}</P></br>
      <p>${kurs.beschreibungstext}</P></br>
       <p>Anz.freier Plaeze : ${kurs.freieplaetze}</P></br>
   </#if>
	 <h3> Liste der Aufgaben</h3>
	 <table class="datatable">
    <tr>
        <td>name</td> <td>abgabetext</td><td>note</td>
    </tr>
	<#if aufgabeList ??>
    <#list aufgabeList as aufgabe>
    <tr>
        <td>${aufgabe.anummer}${aufgabe.name}</td> <td>${aufgabe.abgabetext}</td><td>${aufgabe.note}</td>
    </tr>
   </#list>
   </#if>
   </table>
		</div>
	</div>
	

   <button onclick="javascript:window.location.href='hello'">Kurs Loeschen</button>
</body>
</html>
