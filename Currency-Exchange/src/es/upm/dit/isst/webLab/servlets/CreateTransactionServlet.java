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
import es.upm.dit.isst.webLab.model.Account;
import es.upm.dit.isst.webLab.model.Client;
import es.upm.dit.isst.webLab.model.Transaction;
import es.upm.dit.isst.webLab.model.Wallet;

@WebServlet("/CreateTransactionServlet")
public class CreateTransactionServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		TransactionDAO tdao = TransactionDAOImplementation.getInstance();
		WalletDAO wdao = WalletDAOImplementation.getInstance();
		
		String email = req.getParameter("email");
		String transactionType = req.getParameter("transactionType");
		
		double amount = 0.0;
		double oldAmount = 0.0;
		double newAmount = 0.0;
		int from = 0;
		int to = 0;
		
		if (transactionType.equals("0")) {
			amount = Double.parseDouble(req.getParameter("amount"));
			if (amount <= 0.0)  {
				getServletContext().getRequestDispatcher( "/ManageView.jsp" ).forward( req, resp );
				return;
			}
		}
		
		if (transactionType.equals("2")) {
			newAmount = Double.parseDouble(req.getParameter("newAmount"));
			oldAmount = Double.parseDouble(req.getParameter("oldAmount"));
			from = Integer.parseInt(req.getParameter("from"));
			to = Integer.parseInt(req.getParameter("to"));
			
			if (oldAmount <= 0.0 || newAmount <= 0)  {
				getServletContext().getRequestDispatcher( "/ExchangeView.jsp" ).forward( req, resp );
				return;
			}
		}
		
		Date date = new Date();
		Long timestamp = date.getTime();
		String timeString = timestamp.toString();

		Client client = cdao.read(email);
		Integer accountId = client.getAccount().getAccountID();
		String accountString = accountId.toString();
		String transactionId = timeString + accountString;
		Wallet wallet = client.getAccount().getWallet();
		Wallet adminWallet = cdao.read("admin@youswap.com").getAccount().getWallet();
		
		if (transactionType.equals("0")) {
			
			Transaction transaction = createTransaction(transactionId, amount, 0, client.getLocalCurrency(), date, client.getAccount());
			
			Double depositAmount = amount;
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
				case Constants.CURRENCY_CHF:
					wallet.setSfr(wallet.getSfr() + depositAmount);
					break;
				case Constants.CURRENCY_USD:
					wallet.setUsd(wallet.getUsd() + depositAmount);
					break;
				case Constants.CURRENCY_JPY:
					wallet.setYen(wallet.getYen() + depositAmount);		
					break;	
			}
		
			wdao.update(wallet);
			req.getSession().setAttribute( "correcto", true);
			getServletContext().getRequestDispatcher( "/ManageView.jsp" ).forward( req, resp );
		}
		
		if(transactionType.equals("2")) {
			
			
			
			Boolean enough = false;
			
			Transaction firstTransaction = createTransaction(transactionId, oldAmount, 2, from, date, client.getAccount());
			switch(from) {
			
				case Constants.CURRENCY_AUD:
					if (oldAmount > wallet.getAud()) {
						break;
					}
					tdao.create(firstTransaction);
					wallet.setAud(wallet.getAud() - oldAmount);
					adminWallet.setAud(adminWallet.getAud() + oldAmount);
					enough = true;
					break;
				case Constants.CURRENCY_CAD:
					if (oldAmount > wallet.getCad()) {
						break;
					}
					tdao.create(firstTransaction);
					wallet.setCad(wallet.getCad() - oldAmount);
					adminWallet.setCad(adminWallet.getCad() + oldAmount);
					enough = true;
					break;
				case Constants.CURRENCY_EUR:
					if (oldAmount > wallet.getEur()) {
						break;
					}
					tdao.create(firstTransaction);
					wallet.setEur(wallet.getEur() - oldAmount);
					adminWallet.setEur(adminWallet.getEur() + oldAmount);
					enough = true;
					break;
				case Constants.CURRENCY_GBP:
					if (oldAmount > wallet.getGbp()) {
						break;
					}
					tdao.create(firstTransaction);
					wallet.setGbp(wallet.getGbp() - oldAmount);
					adminWallet.setGbp(adminWallet.getGbp() + oldAmount);
					enough = true;
					break;
				case Constants.CURRENCY_CHF:
					if (oldAmount > wallet.getSfr()) {
						break;
					}
					tdao.create(firstTransaction);
					wallet.setSfr(wallet.getSfr() - oldAmount);
					adminWallet.setSfr(adminWallet.getSfr() + oldAmount);
					enough = true;
					break;
				case Constants.CURRENCY_USD:
					if (oldAmount > wallet.getUsd()) {
						break;
					}
					tdao.create(firstTransaction);
					wallet.setUsd(wallet.getUsd() - oldAmount);
					adminWallet.setUsd(adminWallet.getUsd() + oldAmount);
					enough = true;
					break;
				case Constants.CURRENCY_JPY:
					if (oldAmount > wallet.getYen()) {
						break;
					}
					tdao.create(firstTransaction);
					wallet.setYen(wallet.getYen() - oldAmount);
					adminWallet.setYen(adminWallet.getYen() + oldAmount);
					enough = true;
					break;
			}
			
			if (enough) {
				Transaction secondTransaction = createTransaction(transactionId+"1", newAmount, 3, to, date, client.getAccount());
				switch(to) {
				
					case Constants.CURRENCY_AUD:
						tdao.create(secondTransaction);
						wallet.setAud(wallet.getAud() + newAmount);
						adminWallet.setAud(adminWallet.getAud() - newAmount);
						break;
					case Constants.CURRENCY_CAD:
						tdao.create(secondTransaction);
						wallet.setCad(wallet.getCad() + newAmount);
						adminWallet.setCad(adminWallet.getCad() - newAmount);
						break;
					case Constants.CURRENCY_EUR:
						tdao.create(secondTransaction);
						wallet.setEur(wallet.getEur() + newAmount);
						adminWallet.setEur(adminWallet.getEur() - newAmount);
						break;
					case Constants.CURRENCY_GBP:
						tdao.create(secondTransaction);
						wallet.setGbp(wallet.getGbp() + newAmount);
						adminWallet.setGbp(adminWallet.getGbp() - newAmount);
						break;
					case Constants.CURRENCY_CHF:
						tdao.create(secondTransaction);
						wallet.setSfr(wallet.getSfr() + newAmount);
						adminWallet.setSfr(adminWallet.getSfr() - newAmount);
						break;
					case Constants.CURRENCY_USD:
						tdao.create(secondTransaction);
						wallet.setUsd(wallet.getUsd() + newAmount);
						adminWallet.setUsd(adminWallet.getUsd() - newAmount);
						break;
					case Constants.CURRENCY_JPY:
						tdao.create(secondTransaction);
						wallet.setYen(wallet.getYen() + newAmount);
						adminWallet.setYen(adminWallet.getYen() - newAmount);
						break;
				}
			}
			wdao.update(wallet);
			wdao.update(adminWallet);
			resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + client.getEmail() );
		}
	}
	
	private Transaction createTransaction(String transactionId, Double amount, int transactionType, int currencyType, Date date, Account account ) {
		Transaction t = new Transaction();
		t.setTransactionID(transactionId);
		t.setAmount(amount);
		t.setTransactionType(transactionType);
		t.setCurrencyType(currencyType);
		t.setTransactionDate(date);
		t.setUser(account);
		return t;
	}
	
	
}