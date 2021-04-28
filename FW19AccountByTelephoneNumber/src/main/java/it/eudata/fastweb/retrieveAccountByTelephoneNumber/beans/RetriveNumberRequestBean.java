package it.eudata.fastweb.retrieveAccountByTelephoneNumber.beans;

import java.io.Serializable;

public class RetriveNumberRequestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String telephoneNumber;

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Override
	public String toString() {
		return "RetriveNumberRequestBean [telephoneNumber=" + telephoneNumber + "]";
	}

}
