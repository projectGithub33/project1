package ensa.messagerie.presentation;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ensa.messagerie.metier.IMessageMetier;
import ensa.messagerie.model.Message;

public class AuthentificationServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		HttpSession session = req.getSession(); 
		int id_sender = 0;
		try {
			IMessageMetier message = (IMessageMetier)Naming.lookup("rmi://localhost:1080/serviceMessagerie8");
			String login=req.getParameter("login");
			String password=req.getParameter("password");
	     	
			id_sender = message.authentification(login,password);
			if(id_sender != 0) {
				session.setAttribute("userID", id_sender);
				List<Message> listMsg = message.Read(id_sender);
				List<String> listFrend= message.frendList(id_sender);
				
				req.setAttribute("listMsg",listMsg);
				req.setAttribute("listFrend",listFrend);
				req.getRequestDispatcher("/vues/acceuil.jsp").forward(req, resp);	
			}
			else  {
				req.setAttribute("message", "Mot de passe ou login incorrect");
				req.getRequestDispatcher("/vues/authentification.jsp").forward(req, resp);
			}
		
	
		}catch(NotBoundException e) {
			e.printStackTrace();
		}
			
	}

}
