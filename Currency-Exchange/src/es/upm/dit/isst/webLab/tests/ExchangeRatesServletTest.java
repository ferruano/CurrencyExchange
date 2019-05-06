package es.upm.dit.isst.webLab.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.webLab.servlets.ExchangeRatesServlet;

class ExchangeRatesServletTest {
	ExchangeRatesServlet servlet;
	
	@BeforeEach
	void setUp() throws Exception {
		servlet = new ExchangeRatesServlet();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testNumberToCurrency() {
		int numberAUD = 1;
		int numberEUR = 3;
		
		assertEquals("AUD", servlet.numberToCurrency(numberAUD));
		assertEquals("EUR", servlet.numberToCurrency(numberEUR));
		//fail("Not yet implemented");
	}

	@Test
	void testGetRowHidden() {
		String eur = "EUR";
		assertEquals("display:none;visibility:hidden;",servlet.getRowHidden(eur)[1]);
		assertEquals("",servlet.getRowHidden(eur)[0]);
		assertEquals("",servlet.getRowHidden(eur)[2]);
		//fail("Not yet implemented");
	}

}
