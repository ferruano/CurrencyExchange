package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.Wallet;

import java.util.Collection;

public interface WalletDAO {

    void create(Wallet wallet);

    Wallet read(int walletID);

    void update(Wallet wallet);

    void delete(Wallet wallet);

    Collection<Wallet> readAll();
}
