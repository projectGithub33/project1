package ensa.messagerie.metier;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import ensa.messagerie.model.Message;

public interface IMessageMetier extends Remote{
	public void connecterDB()throws RemoteException;
	 public List<String> frendList(int idUser)throws RemoteException;
	 public List<Message> Read(int id_receiver) throws RemoteException;
	 public void Send(int id_receiver, int id_sender, String texte) throws RemoteException;
	 public int getUserID(String username)throws RemoteException;
	 public int authentification(String login, String password)throws RemoteException;
	 public void inscription(String login,String password)throws RemoteException;

}
