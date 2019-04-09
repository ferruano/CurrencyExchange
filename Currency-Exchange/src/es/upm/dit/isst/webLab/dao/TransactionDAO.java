package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Transaction;

import java.util.Collection;

public interface TransactionDAO {

    void create(Transaction transaction);

    Transaction read(int transactionID);

    void update(Transaction transaction);

    void delete(Transaction transaction);

    Collection<Transaction> readAll();
}
