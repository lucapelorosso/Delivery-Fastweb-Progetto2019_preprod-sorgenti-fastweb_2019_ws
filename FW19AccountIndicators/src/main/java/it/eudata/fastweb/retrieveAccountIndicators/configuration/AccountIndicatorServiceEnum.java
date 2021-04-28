package it.eudata.fastweb.retrieveAccountIndicators.configuration;

public enum AccountIndicatorServiceEnum {
	
	OAG_USERNAME("it.eudata.fastweb.oag.username"),
	OAG_PASSWORD("it.eudata.fastweb.oag.password"),
	ACCOUNT_INDICATORS_SERVICE_WSDL("it.eudata.fastweb.retrieveAccountIndicators.wsdl"),
	ACCOUNT_INDICATORS_SERVICE_ENDPOINT("it.eudata.fastweb.retrieveAccountIndicators.endpoint");

	private final String value;

	AccountIndicatorServiceEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
