package ensa.messagerie.presentation;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ensa.messagerie.metier.IMessageMetier;
import ensa.messagerie.model.Message;

public class DeconnexionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		HttpSession session = req.getSession(); 
		
		try {
			IMessageMetier message = (IMessageMetier)Naming.lookup("rmi://localhost:1099/serviceMessagerie");
			
			session.removeAttribute("userID");
			req.getRequestDispatcher("/vues/authentification.jsp").forward(req, resp);
	
		}catch(NotBoundException e) {
			e.printStackTrace();
		}
			
	}


}
