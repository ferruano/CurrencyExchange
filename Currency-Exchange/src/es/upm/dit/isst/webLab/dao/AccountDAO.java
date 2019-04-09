package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Account;

import java.util.Collection;

public interface AccountDAO {

    void create(Account account);

    Account read(int accountID);

    void update(Account account);


    void delete(Account account);

    Collection<Account> readAll();
}
