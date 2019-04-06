package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Professor;

import org.hibernate.Session;

import java.util.Collection;

public class ProfessorDAOImplementation implements ProfessorDAO {

    private static ProfessorDAOImplementation instance = null;
    private ProfessorDAOImplementation() {}
    public static ProfessorDAOImplementation getInstance() {
        if( null == instance )
            instance = new ProfessorDAOImplementation();
        return instance;
    }

    @Override
    public void create(Professor professor) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.save(professor);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Professor read(String email) {
        Session session = SessionFactoryService.get().openSession();
        Professor professor = null;
        try {
            session.beginTransaction();
            professor = session.get(Professor.class, email);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return professor;
    }

    @Override
    public void update(Professor professor) {

        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(professor);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Professor professor) {
        Session session = SessionFactoryService.get().openSession();
        try {
            session.beginTransaction();
            session.delete(professor);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Collection<Professor> readAll() {
        Session session = SessionFactoryService.get().openSession();
        Collection<Professor> professors = null;
        try {
            session.beginTransaction();
            professors = session.createQuery("from Professor").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            session.close();
        }
        return professors;
    }
}
