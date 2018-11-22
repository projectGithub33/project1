package ensa.messagerie.presentation;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ensa.messagerie.metier.IMessageMetier;

public class InscriptionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
	try {
		IMessageMetier message = (IMessageMetier)Naming.lookup("rmi://localhost:1099/serviceMessagerie");
		String login=req.getParameter("login");
		String password=req.getParameter("password");
		
		message.inscription(login,password);
		
		req.setAttribute("message", "Votre compte a ete creer avec succes , veuillez vous connecter ");
		
	}catch(NotBoundException e) {
		e.printStackTrace();
        req.setAttribute("message", "Erreur lors d'inscription ");
		
	}

	req.getRequestDispatcher("/vues/authentification.jsp").forward(req, resp);



	}
}
