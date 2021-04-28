package it.eudata.fastweb.retrieveAccountIndicators.beans;

import java.io.Serializable;

public class RetriveAccountRequestBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "RetriveAccountRequestBean [accountId=" + accountId + "]";
	}
	
	

}
