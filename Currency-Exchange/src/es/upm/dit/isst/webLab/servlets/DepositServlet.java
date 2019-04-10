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
import es.upm.dit.isst.webLab.dao.TransactionDAO;
import es.upm.dit.isst.webLab.dao.TransactionDAOImplementation;
import es.upm.dit.isst.webLab.dao.WalletDAO;
import es.upm.dit.isst.webLab.dao.WalletDAOImplementation;
import es.upm.dit.isst.webLab.model.Wallet;
import es.upm.dit.isst.webLab.model.Client;
import es.upm.dit.isst.webLab.model.Transaction;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		WalletDAO wdao = WalletDAOImplementation.getInstance();
		TransactionDAO tdao = TransactionDAOImplementation.getInstance();
		
		String transactionId = req.getParameter("transactionId");
		Transaction transaction = tdao.read(transactionId);
		Client client = transaction.getUser().getOwner();
		Wallet wallet = transaction.getUser().getWallet();
		
		Double depositAmount = transaction.getAmmount();
		
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
	
		wdao.update(wallet);

		resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + client.getEmail() );

	}
}
