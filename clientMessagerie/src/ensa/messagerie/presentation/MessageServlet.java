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

public class MessageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		HttpSession session = req.getSession(); 
		try {
			IMessageMetier message = (IMessageMetier)Naming.lookup("rmi://localhost:1099/serviceMessagerie");
			String texte=req.getParameter("texte");
			String receiver=req.getParameter("receiver");
			
			int id_receiver=message.getUserID(receiver);
			int id_sender = (int) session.getAttribute("userID");
			
		
		    message.Send(id_receiver,id_sender,texte);
		    
		    List<Message> listMsg = message.Read(id_sender);
			List<String> listFrend= message.frendList(id_sender);
			
			req.setAttribute("listMsg",listMsg);
			req.setAttribute("listFrend",listFrend);
		    req.setAttribute("message", "inserted");
		    req.getRequestDispatcher("/vues/acceuil.jsp").forward(req, resp);
		}catch(NotBoundException e) {
			e.printStackTrace();
		}
		
		
		//
	}
}
