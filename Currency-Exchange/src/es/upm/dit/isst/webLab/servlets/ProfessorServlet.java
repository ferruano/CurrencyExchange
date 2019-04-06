package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProfessorDAO;
import es.upm.dit.isst.webLab.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.model.Professor;
import es.upm.dit.isst.webLab.model.TFG;

@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProfessorDAO pdao = ProfessorDAOImplementation.getInstance();
		
		String email = req.getParameter("email");
		Professor professor = pdao.read(email);
				
		
		
		req.getSession().setAttribute( "tfgs_accepted", professor.getAdvisedTFGs() );
		req.getSession().setAttribute( "professor", professor );
		
		getServletContext().getRequestDispatcher( "/ProfessorView.jsp" ).forward( req, resp );
	}
}
