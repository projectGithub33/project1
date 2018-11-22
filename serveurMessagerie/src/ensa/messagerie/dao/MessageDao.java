package ensa.messagerie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ensa.messagerie.model.Message;

public class MessageDao implements IMessageDao {
	public static Connection cnx ;
	@Override
	public void connecterDB() {
		
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");
	            String url="jdbc:mysql://localhost:3306/serviceMessagerie";
	            String user="root";
	            String password="";
	            cnx=DriverManager.getConnection(url,user,password);
	            if (cnx != null) {
	                System.out.println("Connected to the database serviceMessagerie");
	               
	            }
	            
	        }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("An error occurred. Maybe user/password is invalid");
	          
	        }	
	       
	      
	       
	}

	@Override
	public List<Message> Read(int id_receiver) {
		
		List<Message> listToken= new ArrayList();
		
		
		Statement st;
		ResultSet	rs = null ;
		 
		 String texte;
		
		try {
			st = cnx.createStatement();
		
			rs = st.executeQuery("select * from messages , users where id_receiver = "+id_receiver+" and messages.id_sender = users.id ");
           while (rs.next()) {
        	 
        	 
        	   texte = rs.getString("texte");
        	  
        	   String sender = rs.getString("login");
        	   Message msg = new Message();
        	   msg.setSender(sender);
        	   msg.setTexte(texte);
        	   listToken.add(msg);
        	        
        	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return listToken;
	}

	@Override
	public void Send(int id_receiver, int id_sender,String texte) {
	
	    Statement st;
		       
		try {
			st = cnx.createStatement();
			int i = st.executeUpdate("INSERT INTO messages(id_receiver,id_sender,texte) VALUES("+id_receiver+","+id_sender+",'"+texte+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public int getUserID(String username)
	 {
		
		int id_received = 0;
		try {
			Statement  st = cnx.createStatement();
		
			ResultSet	rs = st.executeQuery("select * from users where login ='"+username+"'");
			if(rs.next())
			   {
				id_received = rs.getInt("id");
			   }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return id_received;
	 }
	 


	@Override
	public int authentification(String login, String password)  {
		
		
		int id_sender = 0;
		try {
			Statement  st = cnx.createStatement();

			ResultSet rs = st.executeQuery("select * from users where login ='"+login+"' and password ='"+password+"'");
			if(rs.next())
			   {
				id_sender = rs.getInt("id");
			   }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return id_sender;
			
		
	}

	@Override
	public void inscription(String login, String password)  {
		
	    		       
		try {
			 Statement st = cnx.createStatement();
			 int i = st.executeUpdate("INSERT INTO users(login,password) VALUES('"+login+"','"+password+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public List<String> frendList(int idUser)  {
		
		List<String> listToken= new ArrayList();
		Statement st;
		ResultSet	rs = null ;
		try {
			st = cnx.createStatement();
		
			rs = st.executeQuery("select * from users where id != "+idUser+"");
           while (rs.next()) {
        	
        	   listToken.add(rs.getString("login"));
        	   
        	            
        	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return listToken;
	}





}
