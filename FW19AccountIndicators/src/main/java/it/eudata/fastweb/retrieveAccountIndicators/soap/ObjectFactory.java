
package it.eudata.fastweb.retrieveAccountIndicators.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.eudata.fastweb.retrieveAccountIndicators.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RetrieveAccountIndicatorsRequest_QNAME = new QName("http://it.fastweb.esb.org/RetrieveAccountIndicators", "RetrieveAccountIndicatorsRequest");
    private final static QName _RetrieveAccountIndicatorsResponse_QNAME = new QName("http://it.fastweb.esb.org/RetrieveAccountIndicators", "RetrieveAccountIndicatorsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.eudata.fastweb.retrieveAccountIndicators.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransactionDataType }
     * 
     */
    public TransactionDataType createTransactionDataType() {
        return new TransactionDataType();
    }

    /**
     * Create an instance of {@link ResultDataType }
     * 
     */
    public ResultDataType createResultDataType() {
        return new ResultDataType();
    }

    /**
     * Create an instance of {@link RetrieveAccountIndicatorsRequestType }
     * 
     */
    public RetrieveAccountIndicatorsRequestType createRetrieveAccountIndicatorsRequestType() {
        return new RetrieveAccountIndicatorsRequestType();
    }

    /**
     * Create an instance of {@link RetrieveAccountIndicatorsResponseType }
     * 
     */
    public RetrieveAccountIndicatorsResponseType createRetrieveAccountIndicatorsResponseType() {
        return new RetrieveAccountIndicatorsResponseType();
    }

    /**
     * Create an instance of {@link InputDataType }
     * 
     */
    public InputDataType createInputDataType() {
        return new InputDataType();
    }

    /**
     * Create an instance of {@link OutputDataType }
     * 
     */
    public OutputDataType createOutputDataType() {
        return new OutputDataType();
    }

    /**
     * Create an instance of {@link ListOfAccountIndicators }
     * 
     */
    public ListOfAccountIndicators createListOfAccountIndicators() {
        return new ListOfAccountIndicators();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAccountIndicatorsRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.fastweb.esb.org/RetrieveAccountIndicators", name = "RetrieveAccountIndicatorsRequest")
    public JAXBElement<RetrieveAccountIndicatorsRequestType> createRetrieveAccountIndicatorsRequest(RetrieveAccountIndicatorsRequestType value) {
        return new JAXBElement<RetrieveAccountIndicatorsRequestType>(_RetrieveAccountIndicatorsRequest_QNAME, RetrieveAccountIndicatorsRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrieveAccountIndicatorsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://it.fastweb.esb.org/RetrieveAccountIndicators", name = "RetrieveAccountIndicatorsResponse")
    public JAXBElement<RetrieveAccountIndicatorsResponseType> createRetrieveAccountIndicatorsResponse(RetrieveAccountIndicatorsResponseType value) {
        return new JAXBElement<RetrieveAccountIndicatorsResponseType>(_RetrieveAccountIndicatorsResponse_QNAME, RetrieveAccountIndicatorsResponseType.class, null, value);
    }

}
