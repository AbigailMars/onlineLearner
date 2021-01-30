<html>
<head><title>OnlineLearner</title>
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
			Meine Kurse 
		</p>
	<#if kursList ??>
    <#list kursList as kurs>
    <p><a href = "viewCourse?kid=${kurs.kid}&flag=2">${kurs.name} </a></P><p>${kurs.ersteller}</P><p>${kurs.freieplaetze}</P>
   </#list>
   </#if>
		<p>
			Verfuergbare Kurse
		</p>
	<#if vkursList ??>
    <#list vkursList as vkurs>
    <p><a href ="viewCourse?kid=${vkurs.kid}&flag=1"> ${vkurs.name} </a></P><p>${vkurs.ersteller}</P><p>${vkurs.freieplaetze}</P>
   </#list>
   </#if>
		</div>
	</div>
	<button onclick="javascript:window.location.href='newCourse'">Kurs Erstellen</button>
</body>
</html>
