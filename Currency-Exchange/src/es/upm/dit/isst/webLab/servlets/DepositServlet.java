package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		String email = req.getParameter("email");
		req.getSession().setAttribute( "client", cdao.read(email) );
		
		getServletContext().getRequestDispatcher( "/DepositView.jsp" ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		String email = req.getParameter("email");
		String currency = req.getParameter("currency");
		String amount = req.getParameter("amount");
		
		Client c = cdao.read(email);
		switch(c.account.wallet) {
			case "usd":
				c.account.wallet.usd += amount;
				break;
			case "eur":
				c.account.wallet.eur += amount;
				break;
			case "yen":
				c.account.wallet.yen += amount;
				break;
			case "gbp":
				c.account.wallet.gbp += amount;
				break;
			case "sfr":
				c.account.wallet.sfr += amount;
				break;
			case "aud":
				c.account.wallet.aud += amount;
				break;
			case "cad":
				c.account.wallet.cad += amount;
				break;
			default: 
						
		}
		
		cdao.update(c);

		resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );

	}
}
