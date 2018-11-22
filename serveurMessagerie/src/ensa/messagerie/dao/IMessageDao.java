package ensa.messagerie.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ensa.messagerie.model.Message;

public interface IMessageDao {
	public List<String> frendList(int idUser);
	 public List<Message> Read(int id_receiver);
	 public void Send(int id_receiver, int id_sender, String texte);
	 public int getUserID(String username);
     public void connecterDB();
     public int authentification(String login, String password) ;
     public void inscription(String login,String password);
 
//     public void logout(String login) ;
//     public List<String> getAllUsers(); 

}
