package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Transaction;

import org.hibernate.Session;

import java.util.Collection;

public class TransactionDAOImplementation implements TransactionDAO {

    private static TransactionDAOImplementation instance = null;
    private TransactionDAOImplementation() {}
    public static TransactionDAOImplementation getInstance() {
        if( null == instance )
            instance = new TransactionDAOImplementation();
        return instance;
    }

    @Override
    public void create(Transaction transaction) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.save(transaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("==================================================" + e);
        } finally {
            session.close();
        }
    }

    @Override
    public Transaction read(String transactionID) {
        Session session = SessionFactoryService.get().openSession();
        Transaction transaction = null;
        try {
            session.beginTransaction();
            transaction = session.get(Transaction.class, transactionID);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return transaction;
    }

    @Override
    public void update(Transaction transaction) {

        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(transaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Transaction transaction) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(transaction);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Transaction> readAll() {
        Session session = SessionFactoryService.get().openSession();
        Collection<Transaction> transactions = null;
        try {
            session.beginTransaction();
            transactions = session.createQuery("from Transaction").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return transactions;
    }
}
