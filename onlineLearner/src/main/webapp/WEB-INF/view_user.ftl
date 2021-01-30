<html>
<head><title>Hello World</title>
 
<body>
  <table class="datatable">
    <tr>
        <td>email</td> <td>name</td>
    </tr>
    <#if userList ??>
    <#list userList as user>
    <tr>
        <td>${user.email}</td> <td>${user.name}</td>
    </tr>
   </#list>
   </#if>
  </table>
</body>
</html>