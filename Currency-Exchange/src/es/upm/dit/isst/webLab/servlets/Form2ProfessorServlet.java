package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import es.upm.dit.isst.webLab.dao.TFGDAO;
import es.upm.dit.isst.webLab.dao.TFGDAOImplementation;
import es.upm.dit.isst.webLab.model.TFG;

@WebServlet("/Form2ProfessorServlet")
public class Form2ProfessorServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TFGDAO tdao = TFGDAOImplementation.getInstance();
		
		String email = req.getParameter("email");
		TFG tfg = tdao.read(email);
		
		tfg.setStatus(2);
		
		tdao.update(tfg);
		
		resp.sendRedirect( req.getContextPath() + "/ProfessorServlet?email=" +  tfg.getAdvisor().getEmail());
	}
}
