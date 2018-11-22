package ensa.messagerie.metier;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import ensa.messagerie.dao.IMessageDao;
import ensa.messagerie.dao.MessageDao;
import ensa.messagerie.model.Message;

public class MessageMetier extends UnicastRemoteObject implements IMessageMetier {
	IMessageDao dao =new MessageDao();

	public MessageMetier() throws RemoteException {
		super();
		connecterDB();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Message> Read(int id_receiver) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.Read(id_receiver);
	}

	@Override
	public void Send(int id_receiver, int id_sender,String texte) throws RemoteException {
		// TODO Auto-generated method stub
		dao.Send(id_receiver, id_sender, texte);
	}

	@Override
	public int authentification(String login, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.authentification(login, password);
	}

	@Override
	public void inscription(String login, String password) throws RemoteException {
		// TODO Auto-generated method stub
		dao.inscription(login, password);
		
	}

	@Override
	public int getUserID(String username) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.getUserID(username);
	}

	@Override
	public List<String> frendList(int idUser) throws RemoteException {
		// TODO Auto-generated method stub
		return dao.frendList(idUser);
	}

	@Override
	public void connecterDB() throws RemoteException {
		// TODO Auto-generated method stub
		dao.connecterDB();
	}


   
	

}
