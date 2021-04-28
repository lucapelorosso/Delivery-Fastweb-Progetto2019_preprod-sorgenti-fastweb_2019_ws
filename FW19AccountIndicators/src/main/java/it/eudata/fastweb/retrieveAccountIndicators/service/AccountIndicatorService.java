package it.eudata.fastweb.retrieveAccountIndicators.service;

import javax.enterprise.context.ApplicationScoped;

import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsRequestType;
import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsResponseType;
import it.eudata.fastweb.ws.core.FastwebService;



@ApplicationScoped
public abstract class AccountIndicatorService extends FastwebService {

	public abstract RetrieveAccountIndicatorsResponseType retrieveAccountIndicators(RetrieveAccountIndicatorsRequestType accountIndicatorsRequestType);



}
