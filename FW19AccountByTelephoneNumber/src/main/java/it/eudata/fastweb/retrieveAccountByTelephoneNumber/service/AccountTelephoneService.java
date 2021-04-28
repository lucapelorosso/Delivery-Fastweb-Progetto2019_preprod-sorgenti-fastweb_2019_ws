package it.eudata.fastweb.retrieveAccountByTelephoneNumber.service;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberRequestType;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberResponseType;
import it.eudata.fastweb.ws.core.FastwebService;
import it.eudata.fastweb.ws.core.configuration.service.ConfigurationService;

@ApplicationScoped
public abstract class AccountTelephoneService extends FastwebService {
	@Inject
	protected ConfigurationService configurationService;

	@PostConstruct
	public void init() {
		// -Dorg.apache.cxf.Logger=org.apache.cxf.common.logging.Log4jLogger
		String apacheLogProp = System.getProperty("org.apache.cxf.Logger");
		if (apacheLogProp == null) {
			System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Log4jLogger");
		}
	}

	public abstract RetrieveAccountByTelephoneNumberResponseType retrieveAccountByTelephoneNumber(RetrieveAccountByTelephoneNumberRequestType retrieveAccountByTelephoneNumberRequest);

}
