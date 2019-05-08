package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.*;

import Constants.Constants;
import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;

@WebServlet("/ConfirmationServlet")
public class ConfirmationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		
		String amount = req.getParameter("amount");
		String to = req.getParameter("to");
		String from = req.getParameter("from");
		String email = req.getParameter("email");
		
		String fromCurrency = getCurrency(Integer.parseInt(from));
		String toCurrency = getCurrency(Integer.parseInt(to));;	
		
		double newAmount = Math.floor(getExrate(fromCurrency, toCurrency) * Double.parseDouble(amount) * 100.0)/100.0;
		
		req.getSession().setAttribute( "client", cdao.read(email) );
		req.getSession().setAttribute( "amount", Math.floor(Double.parseDouble(amount)*100)/100);
		req.getSession().setAttribute( "newAmount", Math.floor(newAmount*100)/100);
		req.getSession().setAttribute( "fromCurrency", fromCurrency );
		req.getSession().setAttribute( "toCurrency", toCurrency );
		req.getSession().setAttribute( "from", from );
		req.getSession().setAttribute( "to", to );
		
		getServletContext().getRequestDispatcher( "/ConfirmationView.jsp" ).forward( req, resp );
	}
	
	public double getExrate(String originCurrency, String destCurrency) {
		Client client = ClientBuilder.newClient();
		
		String infoExchange= client.target("https://api.exchangeratesapi.io/latest")
				.queryParam("symbols", destCurrency)
				.queryParam("base", originCurrency)
				.request()
				.get(String.class);
		
		JSONObject infoEx = new JSONObject(infoExchange);
		double exRate = infoEx.getJSONObject("rates").getDouble(destCurrency);
		
		return exRate;
	}
	
	
	private String getCurrency(int c) {
		switch(c) {
	
			case Constants.CURRENCY_AUD:
				return "AUD";
			case Constants.CURRENCY_CAD:
				return "CAD";
			case Constants.CURRENCY_EUR:
				return "EUR";
			case Constants.CURRENCY_GBP:
				return "GBP";
			case Constants.CURRENCY_CHF:
				return "CHF";
			case Constants.CURRENCY_USD:
				return "USD";
			case Constants.CURRENCY_JPY:
				return "JPY";
		}
		return "";
	}
	
	
	
}