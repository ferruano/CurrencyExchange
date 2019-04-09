package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;
import es.upm.dit.isst.webLab.model.Client;

import Constants.Constants;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		String email = req.getParameter("email");
		req.getSession().setAttribute( "client", cdao.read(email) );
		
		getServletContext().getRequestDispatcher( "/WithdrawView.jsp" ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		String email = req.getParameter("email");
		String amount = req.getParameter("amount");
		
		Client client = cdao.read(email);
		
		Double finalAmount = Double.parseDouble(amount);
		
		switch(client.getLocalCurrency()) {
			case Constants.CURRENCY_AUD:
				if (finalAmount > client.getAccount().getWallet().getAud()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				client.getAccount().getWallet().setAud(finalAmount);
				break;
			case Constants.CURRENCY_CAD:
				if (finalAmount > client.getAccount().getWallet().getCad()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				client.getAccount().getWallet().setCad(finalAmount);
				break;
			case Constants.CURRENCY_EUR:
				if (finalAmount > client.getAccount().getWallet().getEur()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				client.getAccount().getWallet().setEur(finalAmount);
				break;
			case Constants.CURRENCY_GBP:
				if (finalAmount > client.getAccount().getWallet().getGbp()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				client.getAccount().getWallet().setGbp(finalAmount);
				break;
			case Constants.CURRENCY_SFR:
				if (finalAmount > client.getAccount().getWallet().getSfr()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				client.getAccount().getWallet().setSfr(finalAmount);
				break;
			case Constants.CURRENCY_USD:
				if (finalAmount > client.getAccount().getWallet().getUsd()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				client.getAccount().getWallet().setUsd(finalAmount);
				break;
			case Constants.CURRENCY_YEN:
				if (finalAmount > client.getAccount().getWallet().getYen()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				client.getAccount().getWallet().setYen(finalAmount);
				break;
			default: 		
		}
		
		cdao.update(client);

		resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );

	}

}
