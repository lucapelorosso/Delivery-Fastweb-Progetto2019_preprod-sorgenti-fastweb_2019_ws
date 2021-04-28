package it.eudata.fastweb.retrieveAccountByTelephoneNumber.configuration;

public enum AccountTelehponeServiceEnum {
	
	OAG_USERNAME("it.eudata.fastweb.oag.username"),
	OAG_PASSWORD("it.eudata.fastweb.oag.password"),
	ACCOUNT_TELEPHONE_SERVICE_WSDL("it.eudata.fastweb.retrieveAccountByTelephoneNumber.wsdl"),
	ACCOUNT_TELEPHONE_SERVICE_ENDPOINT("it.eudata.fastweb.retrieveAccountByTelephoneNumber.endpoint");
	

	private final String value;

	AccountTelehponeServiceEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
