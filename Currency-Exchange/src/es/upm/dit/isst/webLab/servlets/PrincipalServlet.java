package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;

@WebServlet({ "/PrincipalServlet", "/" })
public class PrincipalServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String email = "admin@admin";
//		ClientDAO cdao = ClientDAOImplementation.getInstance();
//		req.getSession().setAttribute( "client", cdao.read(email));
		
		String email = req.getParameter("email");
		ClientDAO cdao = ClientDAOImplementation.getInstance();
		req.getSession().setAttribute( "client", cdao.read(email));
		
		getServletContext().getRequestDispatcher( "/PrincipalView.jsp" ).forward( req, resp );

		
	}
	
/*
 INSERT INTO CLIENT (EMAIL, ADDRESS, DATEOFBIRTH, NAME, LOCALCURRENCY, PASSWORD, SURNAMES)
VALUES ('marcos@gmail.com', 'Calle Ramos', '1997-11-22', 'Marcos', 1, '4813494D137E1631BBA301D5ACAB6E7BB7AA74CE1185D456565EF51D737677B2', 'Quibra');

INSERT INTO ACCOUNT (ACCOUNTID, CARDNUMBER, OWNER_EMAIL)
VALUES (0, 000000000000, 'marcos@gmail.com');

INSERT INTO WALLET (WALLETID, AUD, CAD, EUR, GBP, SFR, USD, YEN, OWNER_ACCOUNTID)
VALUES (0001, 0, 0, 100, 0, 0, 0, 0, 0);
 */
	
	
}
