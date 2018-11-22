<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center" style="color:red;"><%
		       			if(request.getAttribute("message")!= null){		       				
		       					out.println(request.getAttribute("message"));		       		
		       			}
     %></h3><br>

<table  border="2" align="center"  cellpadding="5" cellspacing="6" bordercolor="red">
<tr>
   <td>
		<form  method ="get" action="authentification">
		  <table >
		       <caption>Authentification</caption>
		  		<tr>
		  		  <td>login:</td>
		  		  <td><input type="text" name="login"/></td>
		  		<tr>  
		  		<tr>
		  		  <td>mot de passe :</td>
		  		  <td><input type="password" name="password"/></td>
		  		<tr>  		
		  		<tr>	  		
		  		<td><input type="submit" value="login"></td>
		      
		        </tr>
		  </table>
		</form>
   </td>
   <td>
       <p> Pas encore inscrit : S'inscrire </p>
	   	<form  method ="get" action="inscription"> 
		  <table>
		   		<tr>
		  		  <td>login:</td>
		  		  <td><input type="text" name="login"/></td>
		  		<tr>  
		  		<tr>
		  		  <td>mot de passe :</td>
		  		  <td><input type="password" name="password"/></td>
		  		<tr>  		
		  		<tr>	  		
		  		<td><input type="submit" value="s'inscrire"></td>	      
		        </tr>
		  </table>
	  </form>
	</td>
</table>	

</body>
</html>