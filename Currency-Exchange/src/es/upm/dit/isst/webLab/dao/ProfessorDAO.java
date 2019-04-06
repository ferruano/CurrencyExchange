package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Professor;

import java.util.Collection;

public interface ProfessorDAO {

    void create(Professor professor);

    Professor read(String email);

    void update(Professor professor);

    void delete(Professor professor);

    Collection<Professor> readAll();
}
