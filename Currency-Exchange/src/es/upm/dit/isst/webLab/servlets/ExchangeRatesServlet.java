package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;
import javax.ws.rs.GET;
import javax.ws.rs.client.*;

import org.decimal4j.util.DoubleRounder;
import org.json.JSONObject;
import Constants.Constants;

@WebServlet("/ExchangeRatesServlet")
public class ExchangeRatesServlet extends HttpServlet{
	
	//Método local para pasar del numero que dentifica cada moneda a su acrónimo.
	public String numberToCurrency(int number) {		
		switch(number) {
			case 1:
				return "AUD";
			case 2:
				return "CAD";
			case 3:
				return "EUR";
			case 4:
				return "GBP";
			case 5:
				return "CHF";
			case 6:
				return "USD";
			case 7:
				return "JPY";
			default:
				return "USD";
		}	
	}
	
	//Método para no mostrar la fila que coincida con la moneda escogida (para evitar redundancia)
	public String[] getRowHidden(String originCurrency){
		String[] rowsHidden = new String[7];
		
		for(int i=0; i<Constants.currency.length;i++){
			if(originCurrency.equals(Constants.currency[i])){
				rowsHidden[i]="display:none;visibility:hidden;";
			}else{
				rowsHidden[i]="";
			}
		}
		return rowsHidden;
	}
	
	//Método que llama a la API e introduce el valor de cada moneda en el array exRates
	@GET 
	public double[] getExRate(String originCurrency){
		String exchangeKey = "58ffdde58954130b3ede";
		String exchangeKey2 = "d49444542eb8ba4223ea"; //Clave por si usamos la api más de 100 veces cada hora
		double[] exRates = new double[7];
		
		try {
			Client client = ClientBuilder.newClient();
			
			for(int i=0; i<Constants.currency.length;i++) {
				String infoExchange= client.target("https://free.currencyconverterapi.com/api/v6/convert")
						.queryParam("q",originCurrency+"_"+Constants.currency[i])
						.queryParam("compact", "ultra")
						.queryParam("apiKey", exchangeKey)
						.request()
				        .get(String.class);
				
				JSONObject infoEx = new JSONObject(infoExchange);
				double exRate = infoEx.getDouble(originCurrency+"_"+Constants.currency[i]);
				exRates[i] = exRate;
			}
			client.close();
			return exRates;
		}catch(Exception e) {
			System.out.print("ADMIIIIIIINNNNNNN NECESITAS CAMBIAR LA KEY");
		}	
		return exRates;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		String email = req.getParameter("email");
		req.getSession().setAttribute( "client", cdao.read(email) );
		
		String OriginCurrency = req.getParameter("orCurrency"); //Moneda que escoges como origen en el jsp
		double[] exRates = new double[7];
		String[] rowsHidden = new String[7];
		
		//IF para que la primera vez que se entre en la página el valor de la moneda origen sea el que haya
		//escogido el usuario como moneda local. Las deḿas veces será el escogido en la lista del jsp.
		if(OriginCurrency != null) {
			req.getSession().setAttribute( "orCurrency", OriginCurrency);
			exRates = getExRate(OriginCurrency);
			rowsHidden = getRowHidden(OriginCurrency);
		}else if (cdao.read(email) == null) {
			req.getSession().setAttribute( "orCurrency", "USD");
			exRates = getExRate("USD");
			rowsHidden = getRowHidden("USD");
		}
		else {
			String userCurr = numberToCurrency(cdao.read(email).getLocalCurrency());
			req.getSession().setAttribute( "orCurrency", userCurr);
			exRates = getExRate(userCurr);
			rowsHidden = getRowHidden(userCurr);
		}
		
		for(int i = 0; i < exRates.length; i++) {
			exRates[i] = DoubleRounder.round(exRates[i], 2);
		}
		
		req.getSession().setAttribute( "usdRate", exRates[0]);
		req.getSession().setAttribute( "eurRate", exRates[1]);
		req.getSession().setAttribute( "jpyRate", exRates[2]);
		req.getSession().setAttribute( "gbpRate", exRates[3]);
		req.getSession().setAttribute( "chfRate", exRates[4]);
		req.getSession().setAttribute( "audRate", exRates[5]);
		req.getSession().setAttribute( "cadRate", exRates[6]);
		
		req.getSession().setAttribute( "usdHide", rowsHidden[0]);
		req.getSession().setAttribute( "eurHide", rowsHidden[1]);
		req.getSession().setAttribute( "jpyHide", rowsHidden[2]);
		req.getSession().setAttribute( "gbpHide", rowsHidden[3]);
		req.getSession().setAttribute( "chfHide", rowsHidden[4]);
		req.getSession().setAttribute( "audHide", rowsHidden[5]);
		req.getSession().setAttribute( "cadHide", rowsHidden[6]);

		getServletContext().getRequestDispatcher( "/ExchangeRates.jsp" ).forward( req, resp );
	}
	
	
}