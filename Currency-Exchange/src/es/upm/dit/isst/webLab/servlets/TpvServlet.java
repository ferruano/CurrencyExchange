package es.upm.dit.isst.webLab.servlets;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;

/**
 * Servlet implementation class TpvServlet
 */
@WebServlet("/TpvServlet")
public class TpvServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		String email = req.getParameter("email");
		req.getSession().setAttribute( "client", cdao.read(email) );
		req.getSession().setAttribute( "correcto", true);
		
		getServletContext().getRequestDispatcher( "/TpvView.jsp" ).forward( req, resp );
	}
}
