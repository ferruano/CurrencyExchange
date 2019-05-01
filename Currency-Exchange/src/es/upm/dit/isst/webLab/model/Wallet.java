package es.upm.dit.isst.webLab.model;

import javax.persistence.*;

import java.io.Serializable;

@Entity
public class Wallet implements Serializable {

    @Id
    private int walletID;
    private double usd;
    private double eur;
    private double jpy;
    private double gbp;
    private double chf;
    private double aud;
    private double cad;

    @OneToOne
    private Account owner;
    
    
    public int getWalletID() {
		return walletID;
	}


	public void setWalletID(int walletID) {
		this.walletID = walletID;
	}


	public double getUsd() {
		return usd;
	}


	public void setUsd(double usd) {
		this.usd = usd;
	}


	public double getEur() {
		return eur;
	}


	public void setEur(double eur) {
		this.eur = eur;
	}


	public double getJpy() {
		return jpy;
	}


	public void setJpy(double jpy) {
		this.jpy = jpy;
	}


	public double getGbp() {
		return gbp;
	}


	public void setGbp(double gbp) {
		this.gbp = gbp;
	}


	public double getChf() {
		return chf;
	}


	public void setChf(double chf) {
		this.chf = chf;
	}


	public double getAud() {
		return aud;
	}


	public void setAud(double aud) {
		this.aud = aud;
	}


	public double getCad() {
		return cad;
	}


	public void setCad(double cad) {
		this.cad = cad;
	}


	public Account getOwner() {
		return owner;
	}


	public void setOwner(Account owner) {
		this.owner = owner;
	}


	public Wallet() {

    }

   
}
