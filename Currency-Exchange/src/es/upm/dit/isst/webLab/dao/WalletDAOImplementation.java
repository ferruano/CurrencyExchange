package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Wallet;

import org.hibernate.Session;

import java.util.Collection;

public class WalletDAOImplementation implements WalletDAO {

    private static WalletDAOImplementation instance = null;
    private WalletDAOImplementation() {}
    public static WalletDAOImplementation getInstance() {
        if( null == instance )
            instance = new WalletDAOImplementation();
        return instance;
    }

    @Override
    public void create(Wallet wallet) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.save(wallet);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Wallet read(int walletID) {
        Session session = SessionFactoryService.get().openSession();
        Wallet wallet = null;
        try {
            session.beginTransaction();
            wallet = session.get(Wallet.class, walletID);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return wallet;
    }

    @Override
    public void update(Wallet wallet) {

        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(wallet);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Wallet wallet) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(wallet);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Wallet> readAll() {
        Session session = SessionFactoryService.get().openSession();
        Collection<Wallet> wallets = null;
        try {
            session.beginTransaction();
            wallets = session.createQuery("from Wallet").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return wallets;
    }
}