package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;

@WebServlet({ "/PrincipalServlet", "/" })
public class PrincipalServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = "admin@admin";
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		req.getSession().setAttribute( "client", cdao.read(email));
		
		getServletContext().getRequestDispatcher( "/PrincipalView.jsp" ).forward( req, resp );

		
	}
	

	
	
}
