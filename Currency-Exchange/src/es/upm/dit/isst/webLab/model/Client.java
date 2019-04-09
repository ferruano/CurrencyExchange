package es.upm.dit.isst.webLab.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Client implements Serializable {
    @Id
    private String email;

    private String password;
    private String name;
    private String surnames;
    private Date dateOfBirth;
    private String address;
    private int localCurrency;
    

    @OneToOne(mappedBy = "owner", fetch = FetchType.EAGER)
    private Account account;

    public Client() {

    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLocalCurrency() {
		return localCurrency;
	}

	public void setLocalCurrency(int localCurrency) {
		this.localCurrency = localCurrency;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
    
}
