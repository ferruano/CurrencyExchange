package es.upm.dit.isst.webLab.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Transaction implements Serializable {

    @Id
    private int transactionID;
    private double amount;
    private int transactionType;
    private int currencyType;
    private Date transactionDate;

    @ManyToOne
    private Account user;

    public Transaction() {

    }

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public double getAmmount() {
		return amount;
	}

	public void setAmmount(double ammount) {
		this.amount = ammount;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public int getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(int currencyType) {
		this.currencyType = currencyType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}
	
	

   
}
