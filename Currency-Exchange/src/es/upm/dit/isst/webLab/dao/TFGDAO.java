package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.TFG;

import java.util.Collection;

public interface TFGDAO {

    void create(TFG tfg);

    TFG read(String email);

    void update(TFG tfg);


    void delete(TFG tfg);

    Collection<TFG> readAll();
}
