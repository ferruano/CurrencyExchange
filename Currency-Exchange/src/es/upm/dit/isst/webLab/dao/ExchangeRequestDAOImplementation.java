package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.ExchangeRequest;

import org.hibernate.Session;

import java.util.Collection;

public class ExchangeRequestDAOImplementation implements ExchangeRequestDAO {

    private static ExchangeRequestDAOImplementation instance = null;
    private ExchangeRequestDAOImplementation() {}
    public static ExchangeRequestDAOImplementation getInstance() {
        if( null == instance )
            instance = new ExchangeRequestDAOImplementation();
        return instance;
    }

    @Override
    public void create(ExchangeRequest exchangeRequest) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.save(exchangeRequest);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("==================================================" + e);
        } finally {
            session.close();
        }
    }

    @Override
    public ExchangeRequest read(String exchangeRequestID) {
        Session session = SessionFactoryService.get().openSession();
        ExchangeRequest exchangeRequest = null;
        try {
            session.beginTransaction();
            exchangeRequest = session.get(ExchangeRequest.class, exchangeRequestID);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return exchangeRequest;
    }

    @Override
    public void update(ExchangeRequest exchangeRequest) {

        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(exchangeRequest);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(ExchangeRequest exchangeRequest) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(exchangeRequest);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<ExchangeRequest> readAll() {
        Session session = SessionFactoryService.get().openSession();
        Collection<ExchangeRequest> exchangeRequests = null;
        try {
            session.beginTransaction();
            exchangeRequests = session.createQuery("from ExchangeRequest").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return exchangeRequests;
    }
}
