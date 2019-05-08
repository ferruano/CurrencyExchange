package es.upm.dit.isst.webLab.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.webLab.dao.TransactionDAO;
import es.upm.dit.isst.webLab.dao.TransactionDAOImplementation;
import es.upm.dit.isst.webLab.model.Account;
import es.upm.dit.isst.webLab.model.Transaction;

class TestTransactionDAOImplementation {

	Account account = null;
	Transaction transaction = null;
	TransactionDAO tdao = TransactionDAOImplementation.getInstance();

	@BeforeEach
	void setUp() throws Exception {
		
		transaction = new Transaction();
		transaction.setTransactionID("hyils");
		transaction.setAmount(30);
		transaction.setCurrencyType(1);
		transaction.setTransactionDate(new Date());
		transaction.setUser(account);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		tdao.delete( transaction );
	}

	@Test
	void testCreate() {
		tdao.create( transaction );
		Transaction actualTransaction = tdao.read(transaction.getTransactionID());
		assertEquals(transaction.getTransactionID(), actualTransaction.getTransactionID());
	}

	@Test
	void testRead() {
		tdao.create( transaction );
		Transaction actualTransaction = tdao.read(transaction.getTransactionID());
		assertEquals(transaction.getTransactionID(), actualTransaction.getTransactionID());
	}

	@Test
	void testUpdate() {
		tdao.create( transaction );
		Transaction uTransaction = tdao.read(transaction.getTransactionID());
		uTransaction.setAmount(90);;
		tdao.update(uTransaction);
		Transaction updatedTransaction = tdao.read(transaction.getTransactionID());
		assertEquals(transaction.getTransactionID(), updatedTransaction.getTransactionID());
		assertNotEquals(transaction.getAmount(), updatedTransaction.getAmount());
	}

	@Test
	void testDelete() {
		tdao.create( transaction );
		tdao.delete( transaction);
		Transaction newTransaction = tdao.read(transaction.getTransactionID());
		assertNull(newTransaction);
	}

	@Test
	void testReadAll() {
		tdao.create( transaction );
		Transaction transaction2 = transaction;
		transaction2.setTransactionID("2921");
		tdao.create(transaction2);
		Collection<Transaction> transactions = tdao.readAll();
		
		assertEquals(true, transactions.size() > 1); // Ya tenemos 3 transactions en la bbdd
		tdao.delete(transaction2);
	}
}
