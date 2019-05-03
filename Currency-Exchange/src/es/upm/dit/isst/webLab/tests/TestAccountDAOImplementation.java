package es.upm.dit.isst.webLab.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.webLab.dao.AccountDAO;
import es.upm.dit.isst.webLab.dao.AccountDAOImplementation;
import es.upm.dit.isst.webLab.model.Account;
import es.upm.dit.isst.webLab.model.Client;
import es.upm.dit.isst.webLab.model.Transaction;
import es.upm.dit.isst.webLab.model.Wallet;

class TestAccountDAOImplementation {
	Client client = null;
	Account account = null;
	Collection<Transaction> transactions= null;
	Wallet wallet = null;
	AccountDAO adao = AccountDAOImplementation.getInstance();

	@BeforeEach
	void setUp() throws Exception {
		
		account = new Account();
		account.setAccountID(666);
		account.setCardNumber("0000000000000000");
		account.setOwner(client);
		account.setTransactions(transactions);
		account.setWallet(wallet);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		adao.delete( account );
	}

	@Test
	void testCreate() {
		adao.create( account );
		Account actualAccount = adao.read(account.getAccountID());
		assertEquals(account.getAccountID(), actualAccount.getAccountID());
	}

	@Test
	void testRead() {
		adao.create( account );
		Account actualAccount = adao.read(account.getAccountID());
		assertEquals(account.getAccountID(), actualAccount.getAccountID());
	}

	@Test
	void testUpdate() {
		adao.create( account );
		Account uAccount = adao.read(account.getAccountID());
		uAccount.setCardNumber("3000300030003000");
		adao.update(uAccount);
		Account updatedAccount = adao.read(account.getAccountID());
		assertEquals(account.getAccountID(), updatedAccount.getAccountID());
		assertNotEquals(account.getCardNumber(), updatedAccount.getCardNumber());
	}

	@Test
	void testDelete() {
		adao.create( account );
		adao.delete( account);
		Account newAccount = adao.read(account.getAccountID());
		assertNull(newAccount);
	}

	@Test
	void testReadAll() {
		adao.create( account );
		Account account2 = account;
		account2.setAccountID(2921);
		adao.create(account2);
		Collection<Account> accounts = adao.readAll();
		
		assertEquals(5, accounts.size()); // Ya tenemos 3 accountes en la bbdd
		adao.delete(account2);
	}
}
