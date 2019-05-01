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
VALUES ('marta@gmail.com', 'Calle Ramos', '1997-11-22', 'Marta', 3, '4813494D137E1631BBA301D5ACAB6E7BB7AA74CE1185D456565EF51D737677B2', 'Molina');

INSERT INTO ACCOUNT (ACCOUNTID, CARDNUMBER, OWNER_EMAIL)
VALUES (0, 000000000000, 'marta@gmail.com');

INSERT INTO WALLET (WALLETID, AUD, CAD, EUR, GBP, SFR, USD, YEN, OWNER_ACCOUNTID)
VALUES (0001, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT INTO CLIENT (EMAIL, ADDRESS, DATEOFBIRTH, NAME, LOCALCURRENCY, PASSWORD, SURNAMES)
VALUES ('john@gmail.com', 'Big Ben', '1990-11-22', 'John', 4, '4813494D137E1631BBA301D5ACAB6E7BB7AA74CE1185D456565EF51D737677B2', 'Terry');

INSERT INTO ACCOUNT (ACCOUNTID, CARDNUMBER, OWNER_EMAIL)
VALUES (1, 000000000001, 'john@gmail.com');

INSERT INTO WALLET (WALLETID, AUD, CAD, EUR, GBP, SFR, USD, YEN, OWNER_ACCOUNTID)
VALUES (0002, 0, 0, 0, 0, 0, 0, 0, 1);

INSERT INTO CLIENT (EMAIL, ADDRESS, DATEOFBIRTH, NAME, LOCALCURRENCY, PASSWORD, SURNAMES)
VALUES ('admin@youswap.com', 'Calle Andorra', '1900-11-22', 'admin', 3, '4813494D137E1631BBA301D5ACAB6E7BB7AA74CE1185D456565EF51D737677B2', 'admin');

INSERT INTO ACCOUNT (ACCOUNTID, CARDNUMBER, OWNER_EMAIL)
VALUES (2, 000000000002,'admin@youswap.com');

INSERT INTO WALLET (WALLETID, AUD, CAD, EUR, GBP, SFR, USD, YEN, OWNER_ACCOUNTID)
VALUES (0003, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 2);
 */
	
	
}
