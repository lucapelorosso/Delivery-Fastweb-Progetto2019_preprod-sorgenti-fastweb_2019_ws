package it.eudata.fastweb.retrieveAccountIndicators.service.impl;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.logging.log4j.Logger;

import it.eudata.fastweb.retrieveAccountIndicators.configuration.AccountIndicatorServiceEnum;
import it.eudata.fastweb.retrieveAccountIndicators.service.AccountIndicatorService;
import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsPortType;
import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsRequestType;
import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsResponseType;
import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsService;
import it.eudata.fastweb.ws.core.configuration.service.ConfigurationService;
import it.eudata.fastweb.ws.core.logger.LoggerAnnotation;

@Named("AccountIndicatorServiceImpl")
@ApplicationScoped
public class AccountIndicatorServiceImpl extends AccountIndicatorService {

	@Inject
	private Logger logger;

	@Inject
	private ConfigurationService configurationService;

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
	public RetrieveAccountIndicatorsResponseType retrieveAccountIndicators(RetrieveAccountIndicatorsRequestType accountIndicatorsRequestType) {

		String wsdlURL = configurationService.getProperty(AccountIndicatorServiceEnum.ACCOUNT_INDICATORS_SERVICE_WSDL.getValue(), String.class);
		String endpoint = configurationService.getProperty(AccountIndicatorServiceEnum.ACCOUNT_INDICATORS_SERVICE_ENDPOINT.getValue(), String.class);

		RetrieveAccountIndicatorsService ss;
		RetrieveAccountIndicatorsResponseType response = null;

		try {
			ss = new RetrieveAccountIndicatorsService(new File(wsdlURL).toURI().toURL());
			RetrieveAccountIndicatorsPortType port = ss.getRetrieveAccountIndicatorsPort();
			Client client = ClientProxy.getClient(port);
			client.getRequestContext().put(Message.ENDPOINT_ADDRESS, endpoint);
			((HTTPConduit) client.getConduit()).setAuthorization(basicAuthorization());


			response = port.retrieveAccountIndicators(accountIndicatorsRequestType);
		} catch (Exception e) {
			logger.error("Error occours on calling endpoint [" + endpoint + "] , message= " + e.getMessage());
			if (logger.isTraceEnabled())
				logger.trace("", e);
		}

		return response;
	}

	public AuthorizationPolicy basicAuthorization() {
		String username=configurationService.getProperty(AccountIndicatorServiceEnum.OAG_USERNAME.getValue(), String.class);
		String password=configurationService.getProperty(AccountIndicatorServiceEnum.OAG_PASSWORD.getValue(), String.class);
		AuthorizationPolicy authorizationPolicy = new AuthorizationPolicy();
		authorizationPolicy.setUserName(username);
		authorizationPolicy.setPassword(password);
		authorizationPolicy.setAuthorizationType("Basic");

		return authorizationPolicy;
	}

}
