<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="java.util.*"%>
<%@ page  import="ensa.messagerie.model.Message"%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3 align="center" style="color:red;">
		       		<%
		       			if(request.getAttribute("message") == "inserted"){		       				
		       					out.println("Votre message a été envoyé avec succés !");		       		
		       			}
		       		%></h3>
<table border="2" align="center"  cellpadding="5" cellspacing="6"  >
<tr>
<th colspan="6" align="center" style="color: white; background: darkblue;">Service Messagerie RMI 

</th>

	
</tr>
<tr>
	<td>
		<form  method ="get" action="envoyer">
		  <table >
		  	       		        
		  		<tr>
		  		  <th align="right">Envoyer a :</th>
		  		  <td><input type="text" name="receiver"/></td>
		  		<tr>  
		  		<tr>
		  		  <th align="right">message :</th>
		  		  <td><textarea rows="5" cols="30"  name="texte"></textarea></td>
		  		<tr>  		
		  		<tr>
		  		
		  		<td><input type="submit" value="Envoyer"></td>
		      
		        </tr>
		  </table>
	  </form>
	</td>
	<td>
	<form  method ="get" action="deconnexion">
			<input type="submit" value="deconnexion">
</form>
	<p style=" background: lightgrey;"> Liste des amis </p>
	<%

		     List<String> listFrend = (List<String>) request.getAttribute("listFrend"); 
	for (String s : listFrend ) {
		out.println(s);
	
    %>
    <br> <% } %>
	</td>
	
</tr>
 
 <tr>
	<td>Messages recus: 
	
	<table  >		
	         <%  List<Message> listMsg = (List<Message>) request.getAttribute("listMsg"); 
			  		     for (Message s : listMsg) {
  		
			  		%>	    
		  		<tr>
			  	
			  		   <td><% out.println(s.getSender()); %></td>
			  		    <td><% out.println(s.getTexte());%></td>
	  		  
		  		<tr>  			  		<%  }
%> 
	
		  		
    

     </table></td>
</tr>
</table>	 
</body>
</html>