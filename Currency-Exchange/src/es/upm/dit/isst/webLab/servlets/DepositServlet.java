package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Constants.Constants;
import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;
import es.upm.dit.isst.webLab.model.Wallet;
import es.upm.dit.isst.webLab.model.Client;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		String email = req.getParameter("email");
		String amount = req.getParameter("amount");
		
		Client client = cdao.read(email);
		Wallet wallet = client.getAccount().getWallet();
		
		Double depositAmount = Double.parseDouble(amount);
		
		switch(client.getLocalCurrency()) {
		
			case Constants.CURRENCY_AUD:
				wallet.setAud(wallet.getAud() + depositAmount);
				break;
			case Constants.CURRENCY_CAD:
				wallet.setCad(wallet.getCad() + depositAmount);
				break;
			case Constants.CURRENCY_EUR:
				wallet.setEur(wallet.getEur() + depositAmount);				
				break;
			case Constants.CURRENCY_GBP:
				wallet.setGbp(wallet.getGbp() + depositAmount);
				break;
			case Constants.CURRENCY_SFR:
				wallet.setSfr(wallet.getSfr() + depositAmount);
				break;
			case Constants.CURRENCY_USD:
				wallet.setUsd(wallet.getUsd() + depositAmount);
				break;
			case Constants.CURRENCY_YEN:
				wallet.setYen(wallet.getYen() + depositAmount);		
				break;	
		}
		
		cdao.update(client);

		resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );

	}
}
