package it.eudata.fastweb.retrieveAccountByTelephoneNumber.service.impl;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.http.HTTPConduit;

import it.eudata.fastweb.retrieveAccountByTelephoneNumber.configuration.AccountTelehponeServiceEnum;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.service.AccountTelephoneService;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberPortType;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberRequestType;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberResponseType;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberService;
import it.eudata.fastweb.ws.core.logger.LoggerAnnotation;

@Named("AccountTelephoneServiceImpl")
@ApplicationScoped
public class AccountTelephoneServiceImpl extends AccountTelephoneService {
		
	@PostConstruct
	public void init() {

		// -Dorg.apache.cxf.Logger=org.apache.cxf.common.logging.Log4jLogger
		// -Dorg.apache.cxf.Logger=org.apache.cxf.common.logging.Slf4jLogger
		String apacheLogProp = System.getProperty("org.apache.cxf.Logger");
		if (apacheLogProp == null) {
			System.setProperty("org.apache.cxf.Logger", "org.apache.cxf.common.logging.Slf4jLogger");
		}
	}
	
	@Override
	@LoggerAnnotation
	public RetrieveAccountByTelephoneNumberResponseType retrieveAccountByTelephoneNumber(RetrieveAccountByTelephoneNumberRequestType retrieveAccountByTelephoneNumberRequest ) {
		String wsdlURL = configurationService.getProperty(AccountTelehponeServiceEnum.ACCOUNT_TELEPHONE_SERVICE_WSDL.getValue(), String.class);
		String endpoint = configurationService.getProperty(AccountTelehponeServiceEnum.ACCOUNT_TELEPHONE_SERVICE_ENDPOINT.getValue(), String.class);

		RetrieveAccountByTelephoneNumberService ss;
		RetrieveAccountByTelephoneNumberResponseType response = null;
		try {
			ss = new RetrieveAccountByTelephoneNumberService(new File(wsdlURL).toURI().toURL());
			RetrieveAccountByTelephoneNumberPortType port = ss.getRetrieveAccountByTelephoneNumberPort();
			Client client = ClientProxy.getClient(port);
			client.getRequestContext().put(Message.ENDPOINT_ADDRESS, endpoint);
			((HTTPConduit) client.getConduit()).setAuthorization(basicAuthorization());

			response = port.retrieveAccountByTelephoneNumber(retrieveAccountByTelephoneNumberRequest);
		} catch (Exception e) {
			logger.error("Error occours on calling endpoint [" + endpoint + "] , message= " + e.getMessage());
			if (logger.isTraceEnabled())
				logger.trace("", e);
		}

		return response;
	}

	public AuthorizationPolicy basicAuthorization() {
		String username = configurationService.getProperty(AccountTelehponeServiceEnum.OAG_USERNAME.getValue(), String.class);
		String password = configurationService.getProperty(AccountTelehponeServiceEnum.OAG_PASSWORD.getValue(), String.class);
		AuthorizationPolicy authorizationPolicy = new AuthorizationPolicy();
		authorizationPolicy.setUserName(username);
		authorizationPolicy.setPassword(password);
		authorizationPolicy.setAuthorizationType("Basic");

		return authorizationPolicy;
	}

}
