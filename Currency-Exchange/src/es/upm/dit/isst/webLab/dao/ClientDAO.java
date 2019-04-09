package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Client;

import java.util.Collection;

public interface ClientDAO {

    void create(Client client);

    Client read(String email);

    void update(Client client);

    void delete(Client client);

    Collection<Client> readAll();
}
