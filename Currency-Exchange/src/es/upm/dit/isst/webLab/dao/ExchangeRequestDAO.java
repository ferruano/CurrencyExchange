package es.upm.dit.isst.webLab.dao;

import es.upm.dit.isst.webLab.model.ExchangeRequest;
import java.util.Collection;

public interface ExchangeRequestDAO {

    void create(ExchangeRequest exchangeRequest);

    ExchangeRequest read(String exchangeRequestID);

    void update(ExchangeRequest exchangeRequest);

    void delete(ExchangeRequest exchangeRequest);

    Collection<ExchangeRequest> readAll();
}
