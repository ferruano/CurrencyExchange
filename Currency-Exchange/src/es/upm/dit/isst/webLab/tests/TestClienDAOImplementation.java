package es.upm.dit.isst.webLab.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.dit.isst.webLab.dao.ClientDAO;
import es.upm.dit.isst.webLab.dao.ClientDAOImplementation;
import es.upm.dit.isst.webLab.model.Account;
import es.upm.dit.isst.webLab.model.Client;

class TestClienDAOImplementation {
	
	Client client = null;
	Account account = null;
	ClientDAO cdao = ClientDAOImplementation.getInstance();

	@BeforeEach
	void setUp() throws Exception {
		
		client = new Client();
		client.setAccount(account);
		client.setAddress("Calle Genova");
		client.setDateOfBirth(new Date());
		client.setEmail("marcos@email");
		client.setLocalCurrency(1);
		client.setName("Marcos");
		client.setPassword("root");
		client.setSurnames("Alonso");
	}

	@AfterEach
	void tearDown() throws Exception {
		
		cdao.delete( client );
	}

	@Test
	void testCreate() {
		cdao.create( client );
		Client actualClient = cdao.read(client.getEmail());
		assertEquals(client.getEmail(), actualClient.getEmail());
	}

	@Test
	void testRead() {
		cdao.create( client );
		Client actualClient = cdao.read(client.getEmail());
		assertEquals(client.getEmail(), actualClient.getEmail());
	}

	@Test
	void testUpdate() {
		cdao.create( client );
		Client uClient = cdao.read(client.getEmail());
		uClient.setName("Casas");
		cdao.update(uClient);
		Client updatedClient = cdao.read(client.getEmail());
		assertEquals(client.getEmail(), updatedClient.getEmail());
		assertNotEquals(client.getName(), updatedClient.getName());
	}

	@Test
	void testDelete() {
		cdao.create( client );
		cdao.delete(client);
		Client newClient = cdao.read(client.getEmail());
		assertNull(newClient);
	}

	@Test
	void testReadAll() {
		cdao.create( client );
		Client client2 = client;
		client2.setEmail("pedro@email");
		cdao.create(client2);
		Collection<Client> clients = cdao.readAll();
		
		assertEquals(5, clients.size()); // Ya tenemos 3 clientes en la bbdd
		cdao.delete(client2);
	}

}
