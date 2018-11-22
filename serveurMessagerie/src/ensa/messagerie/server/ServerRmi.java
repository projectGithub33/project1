package ensa.messagerie.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ensa.messagerie.metier.IMessageMetier;
import ensa.messagerie.metier.MessageMetier;

public class ServerRmi {

	 public static void main(String args[])throws RemoteException, MalformedURLException, AlreadyBoundException
	 {
	  //System.out.println("enter rmi port number");
	  startRegistry(1099);
	  // register exported object to naming directory
	  IMessageMetier message = new MessageMetier();
	  String url = "rmi://localhost:"+1099+"/serviceMessagerie";
	  try
	  {
	   Naming.bind(url,message);
	  }
	  catch(Exception e)
	  {
	   System.out.println(e.getMessage());
	  }
	}

	 public static void startRegistry(int portNo)throws RemoteException
	 {
	  try
	  {
	   Registry r = LocateRegistry.getRegistry(portNo);
	   r.list();
	  }
	  catch(RemoteException e)
	  {
	   System.out.println("registery not created\n");
	   Registry r = LocateRegistry.createRegistry(portNo);
	   r.list();
	   System.out.println("Serveur Rmi en ecoute ...");
	  }
	 }
}
