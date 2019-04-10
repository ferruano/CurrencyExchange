package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import java.util.Date;

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
import es.upm.dit.isst.webLab.model.Client;
import es.upm.dit.isst.webLab.model.Transaction;
import es.upm.dit.isst.webLab.model.Wallet;

@WebServlet("/CreateTransactionServlet")
public class CreateTransactionServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		TransactionDAO tdao = TransactionDAOImplementation.getInstance();
		
		Transaction transaction = new Transaction();
		
		String email = req.getParameter("email");
		String amount = req.getParameter("amount");
		String transactionType = req.getParameter("transactionType");
		
		Date date = new Date();
		Long timestamp = date.getTime();
		String timeString = timestamp.toString();
		
		Client client = cdao.read(email);
		Integer accountId = client.getAccount().getAccountID();
		String accountString = accountId.toString();
		String transactionId = timeString + accountString;
		
		transaction.setTransactionID(transactionId);
		transaction.setAmmount(Double.parseDouble(amount));
		transaction.setTransactionType(Integer.parseInt(transactionType));
		transaction.setCurrencyType(client.getLocalCurrency());
		transaction.setTransactionDate(date);
		transaction.setUser(client.getAccount());
				
		WalletDAO wdao = WalletDAOImplementation.getInstance();
		Wallet wallet = transaction.getUser().getWallet();
		
		if (transactionType.equals("0")) {
			
			Double depositAmount = transaction.getAmmount();
			tdao.create(transaction);
			
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
		
		if (transactionType.equals("1")) {
			
			Double withdrawAmount = transaction.getAmmount();
			
			switch(client.getLocalCurrency()) {
			
				case Constants.CURRENCY_AUD:
					if (withdrawAmount > wallet.getAud()) {
						throw new ServletException("No dispones de suficiente saldo");
					}
					tdao.create(transaction);
					wallet.setAud(wallet.getAud() - withdrawAmount);
					break;
				case Constants.CURRENCY_CAD:
					if (withdrawAmount > wallet.getCad()) {
						throw new ServletException("No dispones de suficiente saldo");
					}
					tdao.create(transaction);
					wallet.setCad(wallet.getCad() - withdrawAmount);
					break;
				case Constants.CURRENCY_EUR:
					if (withdrawAmount > wallet.getEur()) {
						throw new ServletException("No dispones de suficiente saldo");
					}
					tdao.create(transaction);
					wallet.setEur(wallet.getEur() - withdrawAmount);				
					break;
				case Constants.CURRENCY_GBP:
					if (withdrawAmount > wallet.getGbp()) {
						throw new ServletException("No dispones de suficiente saldo");
					}
					tdao.create(transaction);
					wallet.setGbp(wallet.getGbp() - withdrawAmount);
					break;
				case Constants.CURRENCY_SFR:
					if (withdrawAmount > wallet.getSfr()) {
						throw new ServletException("No dispones de suficiente saldo");
					}
					tdao.create(transaction);
					wallet.setSfr(wallet.getSfr() - withdrawAmount);
					break;
				case Constants.CURRENCY_USD:
					if (withdrawAmount > wallet.getUsd()) {
						throw new ServletException("No dispones de suficiente saldo");
					}
					tdao.create(transaction);
					wallet.setUsd(wallet.getUsd() - withdrawAmount);
					break;
				case Constants.CURRENCY_YEN:
					if (withdrawAmount > wallet.getYen()) {
						throw new ServletException("No dispones de suficiente saldo");
					}
					tdao.create(transaction);
					wallet.setYen(wallet.getYen() - withdrawAmount);		
					break;		
			}
			
			wdao.update(wallet);

			resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );
		}
	}
	
	
}