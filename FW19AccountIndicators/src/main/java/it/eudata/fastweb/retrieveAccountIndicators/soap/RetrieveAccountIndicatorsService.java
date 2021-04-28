package it.eudata.fastweb.retrieveAccountIndicators.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * OSB Service
 *
 * This class was generated by Apache CXF 3.1.5
 * 2019-03-19T17:41:23.694+01:00
 * Generated source version: 3.1.5
 * 
 */
@WebServiceClient(name = "RetrieveAccountIndicatorsService", 
                  wsdlLocation = "file:RetrieveAccountIndicators.wsdl",
                  targetNamespace = "http://it.fastweb.esb.org/RetrieveAccountIndicators") 
public class RetrieveAccountIndicatorsService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://it.fastweb.esb.org/RetrieveAccountIndicators", "RetrieveAccountIndicatorsService");
    public final static QName RetrieveAccountIndicatorsPort = new QName("http://it.fastweb.esb.org/RetrieveAccountIndicators", "RetrieveAccountIndicatorsPort");
    static {
        URL url = null;
        try {
            url = new URL("file:RetrieveAccountIndicators.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RetrieveAccountIndicatorsService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:RetrieveAccountIndicators.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RetrieveAccountIndicatorsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RetrieveAccountIndicatorsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RetrieveAccountIndicatorsService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public RetrieveAccountIndicatorsService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public RetrieveAccountIndicatorsService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public RetrieveAccountIndicatorsService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns RetrieveAccountIndicatorsPortType
     */
    @WebEndpoint(name = "RetrieveAccountIndicatorsPort")
    public RetrieveAccountIndicatorsPortType getRetrieveAccountIndicatorsPort() {
        return super.getPort(RetrieveAccountIndicatorsPort, RetrieveAccountIndicatorsPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RetrieveAccountIndicatorsPortType
     */
    @WebEndpoint(name = "RetrieveAccountIndicatorsPort")
    public RetrieveAccountIndicatorsPortType getRetrieveAccountIndicatorsPort(WebServiceFeature... features) {
        return super.getPort(RetrieveAccountIndicatorsPort, RetrieveAccountIndicatorsPortType.class, features);
    }

}
