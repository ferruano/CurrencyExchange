package es.upm.dit.isst.webLab.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class ExchangeRequest implements Serializable {

    @Id
    private String exchangeRequestID;
    private double amount ;
    private int currencyOrigin;
    private int currencyDestination;
    private double exchangeRate;
    private boolean completed;
    
    @ManyToOne
    private Account user;

	public String getExchangeRequestID() {
		return exchangeRequestID;
	}

	public void setExchangeRequestID(String exchangeRequestID) {
		this.exchangeRequestID = exchangeRequestID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCurrencyOrigin() {
		return currencyOrigin;
	}

	public void setCurrencyOrigin(int currencyOrigin) {
		this.currencyOrigin = currencyOrigin;
	}

	public int getCurrencyDestination() {
		return currencyDestination;
	}

	public void setCurrencyDestination(int currencyDestination) {
		this.currencyDestination = currencyDestination;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}


   
}
