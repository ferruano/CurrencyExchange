package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Account;
import org.hibernate.Session;

import java.util.Collection;

public class AccountDAOImplementation implements AccountDAO {

    private static AccountDAOImplementation instance = null;
    private AccountDAOImplementation() {}
    public static AccountDAOImplementation getInstance() {
        if( null == instance )
            instance = new AccountDAOImplementation();
        return instance;
    }

    @Override
    public void create(Account account) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Account read(int accountID) {
        Session session = SessionFactoryService.get().openSession();
        Account account = null;
        try {
            session.beginTransaction();
            account = session.get(Account.class, accountID);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Account account) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(account);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Account> readAll() {
        Session session = SessionFactoryService.get().openSession();
        Collection<Account> accounts = null;
        try {
            session.beginTransaction();
            accounts = session.createQuery("from Account").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return accounts;
    }
	

}
