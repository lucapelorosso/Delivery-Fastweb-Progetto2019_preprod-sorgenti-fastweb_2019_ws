package it.eudata.fastweb.retrieveAccountByTelephoneNumber.resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.apache.logging.log4j.Logger;

import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.beans.RetriveNumberRequestBean;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.service.AccountTelephoneService;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.InputDataType;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberRequestType;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.RetrieveAccountByTelephoneNumberResponseType;
import it.eudata.fastweb.retrieveAccountByTelephoneNumber.soap.TransactionDataType;
import it.eudata.fastweb.ws.core.authentication.AuthenticationAnnotation;
import it.eudata.fastweb.ws.core.logger.LoggerAnnotation;
import it.eudata.fastweb.ws.core.rs.annotations.NullResponseBinding;

@Api(authorizations = { @Authorization(value = "token", scopes = {}) })
@Path("RetrieveAccountByPhone")
@RequestScoped
public class AccountTelephoneResource {

	@Context
	private SecurityContext securityContext;

	@Context
	private HttpHeaders headers;

	@Inject
	private Logger logger;

	@Inject
	@Named("AccountTelephoneServiceImpl")
	private AccountTelephoneService accountTelephoneService;

	@PostConstruct
	public void init() {
		logger.debug("Resource initialized");
	}

	@POST()
	@Path("/")
	@NullResponseBinding
	@LoggerAnnotation
	@AuthenticationAnnotation
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response retrieveAccountByTelephoneNumber(RetriveNumberRequestBean requestBean) throws Exception {
		Response response = null;
		try {
			RetrieveAccountByTelephoneNumberResponseType accountIndicatorsResponseType = accountTelephoneService.retrieveAccountByTelephoneNumber(bean2Soap(requestBean));
			response = Response.ok(accountIndicatorsResponseType).build();
		} catch (Exception e) {
			logger.error("" + e.getMessage());
			response = Response.serverError().build();
		}
		return response;
	}

	RetrieveAccountByTelephoneNumberRequestType bean2Soap(RetriveNumberRequestBean requestBean) {
		RetrieveAccountByTelephoneNumberRequestType response = new RetrieveAccountByTelephoneNumberRequestType();
		response.setInputData(new InputDataType());
		response.setTransactionData(new TransactionDataType());

		response.getInputData().setTelephoneNumber(requestBean.getTelephoneNumber());
		response.getTransactionData().setSenderName("EUDATA");
		response.getTransactionData().setTransactionId(UUID.randomUUID().toString());
		Calendar now = Calendar.getInstance();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String transactionTime = simpleDateFormat.format(now.getTime());
		response.getTransactionData().setTransactionTime(transactionTime);
		return response;
	}

}
