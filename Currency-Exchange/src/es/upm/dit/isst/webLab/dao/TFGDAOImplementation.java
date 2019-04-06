package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.TFG;
import org.hibernate.Session;

import java.util.Collection;

public class TFGDAOImplementation implements TFGDAO {

    private static TFGDAOImplementation instance = null;
    private TFGDAOImplementation() {}
    public static TFGDAOImplementation getInstance() {
        if( null == instance )
            instance = new TFGDAOImplementation();
        return instance;
    }

    @Override
    public void create(TFG tfg) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.save(tfg);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public TFG read(String email) {
        Session session = SessionFactoryService.get().openSession();
        TFG tfg = null;
        try {
            session.beginTransaction();
            tfg = session.get(TFG.class, email);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return tfg;
    }

    @Override
    public void update(TFG tfg) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(tfg);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(TFG tfg) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(tfg);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<TFG> readAll() {
        Session session = SessionFactoryService.get().openSession();
        Collection<TFG> tfgs = null;
        try {
            session.beginTransaction();
            tfgs = session.createQuery("from TFG").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return tfgs;
    }

}
