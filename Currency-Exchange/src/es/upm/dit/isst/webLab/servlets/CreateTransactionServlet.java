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
		
		Transaction transaction = new Transaction();
		
		String email = req.getParameter("email");
		String amount = req.getParameter("amount");
		
		double oldAmount = Double.parseDouble(req.getParameter("oldAmount"));
		double newAmount = Double.parseDouble(req.getParameter("newAmount"));
		
		if (amount != null && Double.parseDouble(amount) == 0.0) {
			req.getSession().setAttribute( "correcto", true);
			getServletContext().getRequestDispatcher( "/ManageView.jsp" ).forward( req, resp );
			return;
		}
		String transactionType = req.getParameter("transactionType");
		
		Date date = new Date();
		Long timestamp = date.getTime();
		String timeString = timestamp.toString();
		
		Client client = cdao.read(email);
		Integer accountId = client.getAccount().getAccountID();
		String accountString = accountId.toString();
		String transactionId = timeString + accountString;
		
		int from = Integer.parseInt(req.getParameter("from"));
		int to = Integer.parseInt(req.getParameter("to"));
		
		transaction.setTransactionID(transactionId);
		if (amount != null) {		
			transaction.setAmmount(Double.parseDouble(amount));
		}
		transaction.setTransactionType(Integer.parseInt(transactionType));
		transaction.setCurrencyType(client.getLocalCurrency());
		transaction.setTransactionDate(date);
		transaction.setUser(client.getAccount());
				
		WalletDAO wdao = WalletDAOImplementation.getInstance();
		Wallet wallet = client.getAccount().getWallet();
		
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
			req.getSession().setAttribute( "correcto", true);
			getServletContext().getRequestDispatcher( "/ManageView.jsp" ).forward( req, resp );
		}
		
		if (transactionType.equals("1")) {
			
			Double withdrawAmount = transaction.getAmmount();
			req.getSession().setAttribute( "client", client);
			Boolean correcto = true;
			
			switch(client.getLocalCurrency()) {
			
				case Constants.CURRENCY_AUD:
					if (withdrawAmount > wallet.getAud()) {
						correcto = false;
						break;
					}
					tdao.create(transaction);
					wallet.setAud(wallet.getAud() - withdrawAmount);
					break;
				case Constants.CURRENCY_CAD:
					if (withdrawAmount > wallet.getCad()) {
						correcto = false;
						break;
					}
					tdao.create(transaction);
					wallet.setCad(wallet.getCad() - withdrawAmount);
					break;
				case Constants.CURRENCY_EUR:
					if (withdrawAmount > wallet.getEur()) {
						correcto = false;
						break;
					}
					tdao.create(transaction);
					wallet.setEur(wallet.getEur() - withdrawAmount);				
					break;
				case Constants.CURRENCY_GBP:
					if (withdrawAmount > wallet.getGbp()) {
						correcto = false;
						break;
					}
					tdao.create(transaction);
					wallet.setGbp(wallet.getGbp() - withdrawAmount);
					break;
				case Constants.CURRENCY_SFR:
					if (withdrawAmount > wallet.getSfr()) {
						correcto = false;
						break;
					}
					tdao.create(transaction);
					wallet.setSfr(wallet.getSfr() - withdrawAmount);
					break;
				case Constants.CURRENCY_USD:
					if (withdrawAmount > wallet.getUsd()) {
						correcto = false;
						break;
					}
					tdao.create(transaction);
					wallet.setUsd(wallet.getUsd() - withdrawAmount);
					break;
				case Constants.CURRENCY_YEN:
					if (withdrawAmount > wallet.getYen()) {
						correcto = false;
						break;
					}
					tdao.create(transaction);
					wallet.setYen(wallet.getYen() - withdrawAmount);		
					break;		
			}
			
			wdao.update(wallet);
			req.getSession().setAttribute( "correcto", correcto);
			getServletContext().getRequestDispatcher( "/ManageView.jsp" ).forward( req, resp );
		}
		
		if(transactionType.equals("2")) {
			
			Boolean enough = true;
			
			Transaction firstTransaction = transferTransaction(transactionId, oldAmount, 1, from, date, client.getAccount());
			switch(from) {
			
				case Constants.CURRENCY_AUD:
					if (oldAmount > wallet.getAud()) {
						enough = false;
						break;
					}
					tdao.create(firstTransaction);
					wallet.setAud(wallet.getAud() - oldAmount);
					break;
				case Constants.CURRENCY_CAD:
					if (oldAmount > wallet.getCad()) {
						enough = false;
						break;
					}
					tdao.create(firstTransaction);
					wallet.setCad(wallet.getCad() - oldAmount);
					break;
				case Constants.CURRENCY_EUR:
					if (oldAmount > wallet.getEur()) {
						enough = false;
						break;
					}
					tdao.create(firstTransaction);
					wallet.setEur(wallet.getEur() - oldAmount);
					break;
				case Constants.CURRENCY_GBP:
					if (oldAmount > wallet.getGbp()) {
						enough = false;
						break;
					}
					tdao.create(firstTransaction);
					wallet.setGbp(wallet.getGbp() - oldAmount);
					break;
				case Constants.CURRENCY_SFR:
					if (oldAmount > wallet.getSfr()) {
						enough = false;
						break;
					}
					tdao.create(firstTransaction);
					wallet.setSfr(wallet.getSfr() - oldAmount);
					break;
				case Constants.CURRENCY_USD:
					if (oldAmount > wallet.getUsd()) {
						enough = false;
						break;
					}
					tdao.create(firstTransaction);
					wallet.setUsd(wallet.getUsd() - oldAmount);
					break;
				case Constants.CURRENCY_YEN:
					if (oldAmount > wallet.getYen()) {
						enough = false;
						break;
					}
					tdao.create(firstTransaction);
					wallet.setYen(wallet.getYen() - oldAmount);
					break;
			}
			
			if (enough) {
				Transaction secondTransaction = transferTransaction(transactionId, newAmount, 0, to, date, client.getAccount());
				switch(to) {
				
					case Constants.CURRENCY_AUD:
						tdao.create(secondTransaction);
						wallet.setAud(wallet.getAud() + newAmount);
						break;
					case Constants.CURRENCY_CAD:
						tdao.create(secondTransaction);
						wallet.setCad(wallet.getCad() + newAmount);
						break;
					case Constants.CURRENCY_EUR:
						tdao.create(secondTransaction);
						wallet.setEur(wallet.getEur() + newAmount);
						break;
					case Constants.CURRENCY_GBP:
						tdao.create(secondTransaction);
						wallet.setGbp(wallet.getGbp() + newAmount);
						break;
					case Constants.CURRENCY_SFR:
						tdao.create(secondTransaction);
						wallet.setSfr(wallet.getSfr() + newAmount);
						break;
					case Constants.CURRENCY_USD:
						tdao.create(secondTransaction);
						wallet.setUsd(wallet.getUsd() + newAmount);
						break;
					case Constants.CURRENCY_YEN:
						tdao.create(secondTransaction);
						wallet.setYen(wallet.getYen() + newAmount);
						break;
				}
			}
			wdao.update(wallet);
			resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + client.getEmail() );
		}
	}
	
	private Transaction transferTransaction(String transactionId, Double amount, int transactionType, int currencyType, Date date, Account account ) {
		Transaction t = new Transaction();
		t.setTransactionID(transactionId);
		t.setAmmount(amount);
		t.setTransactionType(transactionType);
		t.setCurrencyType(currencyType);
		t.setTransactionDate(date);
		t.setUser(account);
		return t;
	}
	
	
}