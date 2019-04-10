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
import es.upm.dit.isst.webLab.dao.WalletDAO;
import es.upm.dit.isst.webLab.dao.WalletDAOImplementation;
import es.upm.dit.isst.webLab.model.Client;
import es.upm.dit.isst.webLab.model.Wallet;
import Constants.Constants;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		WalletDAO wdao = WalletDAOImplementation.getInstance();
		
		String email = req.getParameter("email");
		String amount = req.getParameter("amount");
		
		Client client = cdao.read(email);
		Wallet wallet = wdao.read(client.getAccount().getWallet().getWalletID());
		
		Double withdrawAmount = Double.parseDouble(amount);
		
		switch(client.getLocalCurrency()) {
		
			case Constants.CURRENCY_AUD:
				if (withdrawAmount > wallet.getAud()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				wallet.setAud(wallet.getAud() - withdrawAmount);
				break;
			case Constants.CURRENCY_CAD:
				if (withdrawAmount > wallet.getCad()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				wallet.setCad(wallet.getCad() - withdrawAmount);
				break;
			case Constants.CURRENCY_EUR:
				if (withdrawAmount > wallet.getEur()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				wallet.setEur(wallet.getEur() - withdrawAmount);				
				break;
			case Constants.CURRENCY_GBP:
				if (withdrawAmount > wallet.getGbp()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				wallet.setGbp(wallet.getGbp() - withdrawAmount);
				break;
			case Constants.CURRENCY_SFR:
				if (withdrawAmount > wallet.getSfr()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				wallet.setSfr(wallet.getSfr() - withdrawAmount);
				break;
			case Constants.CURRENCY_USD:
				if (withdrawAmount > wallet.getUsd()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				wallet.setUsd(wallet.getUsd() - withdrawAmount);
				break;
			case Constants.CURRENCY_YEN:
				if (withdrawAmount > wallet.getYen()) {
					throw new ServletException("No dispones de suficiente saldo");
				}
				wallet.setYen(wallet.getYen() - withdrawAmount);		
				break;		
		}
		
		wdao.update(wallet);

		resp.sendRedirect( req.getContextPath() + "/AccountServlet?email=" + email );

	}

}
