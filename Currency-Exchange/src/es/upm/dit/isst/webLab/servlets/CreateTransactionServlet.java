package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;
import es.upm.dit.isst.webLab.dao.TransactionDAO;
import es.upm.dit.isst.webLab.dao.TransactionDAOImplementation;
import es.upm.dit.isst.webLab.model.Client;
import es.upm.dit.isst.webLab.model.Transaction;

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
		
		tdao.create(transaction);
		//System.out.println(tdao.read(Long.parseLong(transactionId))); 
		
		if (transactionType.equals("0")) {
			resp.sendRedirect( req.getContextPath() + "/DepositServlet?transactionId=" + transaction.getTransactionID());
		}
		
		if (transactionType.equals("1")) {
			resp.sendRedirect( req.getContextPath() + "/WithdrawServlet?transactionId=" + transaction.getTransactionID());
		}
	}
	
	
}