package es.upm.dit.isst.webLab.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Account implements Serializable {

    @Id
    private int accountID;
    private String cardNumber;
    
	@OneToOne
    private Client owner;
    
    @OneToOne(mappedBy = "owner", fetch = FetchType.EAGER)
    private Wallet wallet;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Transaction> transactions;

    public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
	
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
	}

    public Account() {

    }

   
}
