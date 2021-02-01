
<html>
<head><title>OnlineLearner</title>
<style type="text/css">
* {
   margin:0;
   padding:0;
}
body{
   text-align:center;
   background: #efe4bf  none repeat scroll 0 0;
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
#column{
    float: left;
    width: 40%;
    padding: 5px;
    margin: 5px;
}
#row{
    content: "";
    clear: both;
    display: table;
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
		<h1 align = center> onlineLearner </h1>
	</div>
	   
	<div id="site">
	 <div id="row">
	 <h2 style="text-align: left">Meine Kurse</h2>
	 
	 <#if kursList ??>
     <#list kursList as kurs>
     <div id="column">
         <div>
         <h3><a href = "viewCourse?kid=${kurs.kid}&flag=2">${kurs.name}</a></h3>
             <label>Ersteller: ${kurs.ersteller}</label><br>
             <label>Freie Plaetze: ${kurs.freieplaetze}</label>
         </div>
     </div>
     </#list>
     </#if>
     
     </div>

     <div id="row">
	 <h2 style="text-align: left">Verfuergbare Kurse</h2>
	 <#if vkursList ??>
     <#list vkursList as vkurs>
     <div id="column">
        <div>
            <h3><a href ="viewCourse?kid=${vkurs.kid}&flag=1"> ${vkurs.name} </a></h3>
            <label>Ersteller: ${vkurs.ersteller}</label><br>
            <label>Freie Plaetze: ${vkurs.freieplaetze}</label>
        </div>
    </div>
    </#list>
    </#if>
    	<button id="button" onclick="javascript:window.location.href='newCourse'" style="margin-botton: 50px">Kurs Erstellen</button>
    </div>   
   </div>
   
</body>
</html>