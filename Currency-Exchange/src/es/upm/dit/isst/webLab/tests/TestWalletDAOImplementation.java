package es.upm.dit.isst.webLab.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.webLab.dao.WalletDAO;
import es.upm.dit.isst.webLab.dao.WalletDAOImplementation;
import es.upm.dit.isst.webLab.model.Wallet;
import es.upm.dit.isst.webLab.model.Account;

class TestWalletDAOImplementation {
	Account account = null;
	Wallet wallet = null;
	WalletDAO wdao = WalletDAOImplementation.getInstance();

	@BeforeEach
	void setUp() throws Exception {
		
		wallet = new Wallet();
		wallet.setWalletID(666);
		wallet.setAud(0);
		wallet.setCad(0);
		wallet.setEur(0);
		wallet.setGbp(0);
		wallet.setOwner(account);
		wallet.setSfr(0);
		wallet.setUsd(0);
		wallet.setYen(0);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		wdao.delete( wallet );
	}

	@Test
	void testCreate() {
		wdao.create( wallet );
		Wallet actualWallet = wdao.read(wallet.getWalletID());
		assertEquals(wallet.getWalletID(), actualWallet.getWalletID());
	}

	@Test
	void testRead() {
		wdao.create( wallet );
		Wallet actualWallet = wdao.read(wallet.getWalletID());
		assertEquals(wallet.getWalletID(), actualWallet.getWalletID());
	}

	@Test
	void testUpdate() {
		wdao.create( wallet );
		Wallet uWallet = wdao.read(wallet.getWalletID());
		uWallet.setEur(500);
		wdao.update(uWallet);
		Wallet updatedWallet = wdao.read(wallet.getWalletID());
		assertEquals(wallet.getWalletID(), updatedWallet.getWalletID());
		assertNotEquals(wallet.getEur(), updatedWallet.getEur());
	}

	@Test
	void testDelete() {
		wdao.create( wallet );
		wdao.delete( wallet);
		Wallet newWallet = wdao.read(wallet.getWalletID());
		assertNull(newWallet);
	}

	@Test
	void testReadAll() {
		wdao.create( wallet );
		Wallet wallet2 = wallet;
		wallet2.setWalletID(2921);
		wdao.create(wallet2);
		Collection<Wallet> wallets = wdao.readAll();
		
		assertEquals(5, wallets.size()); // Ya tenemos 3 wallets en la bbdd
		wdao.delete(wallet2);
	}
}
