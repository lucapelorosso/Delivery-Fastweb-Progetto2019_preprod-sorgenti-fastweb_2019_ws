package it.eudata.fastweb.retrieveAccountIndicators;

import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import org.jboss.weld.junit4.WeldInitiator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import it.eudata.fastweb.retrieveAccountIndicators.beans.RetriveAccountRequestBean;
import it.eudata.fastweb.retrieveAccountIndicators.service.impl.AccountIndicatorServiceImpl;
import it.eudata.fastweb.retrieveAccountIndicators.soap.InputDataType;
import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsRequestType;
import it.eudata.fastweb.retrieveAccountIndicators.soap.RetrieveAccountIndicatorsResponseType;
import it.eudata.fastweb.retrieveAccountIndicators.soap.TransactionDataType;
import it.eudata.fastweb.ws.core.configuration.ConfigurationFactory;
import it.eudata.fastweb.ws.core.configuration.service.ConfigurationService;
import it.eudata.fastweb.ws.core.logger.LoggerFactory;

public class AccountIndicatorServiceTest {

	@Rule
	public WeldInitiator weld = WeldInitiator.from(ConfigurationFactory.class,LoggerFactory.class,ConfigurationService.class,AccountIndicatorServiceImpl.class).inject(this).build();
	
	@Inject
	AccountIndicatorServiceImpl serviceImpl;

	@Before
	public void setUp() throws Exception {
		
//		-Dconfigfile.path="E:\Documenti\Eudata\clienti\Fastweb\Progetto2019\sorgenti\ws\configuration\test"
		ClassLoader loader = AccountIndicatorServiceTest.class.getClassLoader();
		URL confPath=loader.getResource("configuration");
		
		Path path= Paths.get(confPath.toURI());
		System.out.println(path.toAbsolutePath());
		
		
		System.setProperty("configfile.path", ""+path.toAbsolutePath());
        System.out.println(loader.getResource("it/eudata/fastweb/retrieveAccountIndicators/AccountIndicatorServiceTest.class"));
        
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRetrieveAccountIndicators() {
		
		RetriveAccountRequestBean bean=new RetriveAccountRequestBean();
		bean.setAccountId("0001125");
		RetrieveAccountIndicatorsResponseType  response= serviceImpl.retrieveAccountIndicators(bean2Soap(bean));
		assertNotNull("Verifico che la risposta non sia nulla",response);
	}

	
	RetrieveAccountIndicatorsRequestType bean2Soap(RetriveAccountRequestBean requestBean) {
		RetrieveAccountIndicatorsRequestType response = new RetrieveAccountIndicatorsRequestType();
		response.setInputData(new InputDataType());
		response.setTransactionData(new TransactionDataType());

		response.getInputData().setId(requestBean.getAccountId());
		response.getTransactionData().setSenderName("EUDATA");
		response.getTransactionData().setTransactionId("EUDATA");
		Calendar now = Calendar.getInstance();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String transactionTime = simpleDateFormat.format(now.getTime());
		response.getTransactionData().setTransactionTime(transactionTime);
		return response;
	}
}
