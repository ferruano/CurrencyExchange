package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Client;

import org.hibernate.Session;

import java.util.Collection;

public class ClientDAOImplementation implements ClientDAO {

    private static ClientDAOImplementation instance = null;
    private ClientDAOImplementation() {}
    public static ClientDAOImplementation getInstance() {
        if( null == instance )
            instance = new ClientDAOImplementation();
        return instance;
    }

    @Override
    public void create(Client client) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Client read(String email) {
        Session session = SessionFactoryService.get().openSession();
        Client client = null;
        try {
            session.beginTransaction();
            client = session.get(Client.class, email);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return client;
    }

    @Override
    public void update(Client client) {

        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Client client) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Client> readAll() {
        Session session = SessionFactoryService.get().openSession();
        Collection<Client> clients = null;
        try {
            session.beginTransaction();
            clients = session.createQuery("from Client").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return clients;
    }
}
