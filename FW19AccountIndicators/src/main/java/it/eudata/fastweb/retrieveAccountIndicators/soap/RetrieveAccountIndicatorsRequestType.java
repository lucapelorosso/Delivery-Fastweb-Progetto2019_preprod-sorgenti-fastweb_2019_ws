
package it.eudata.fastweb.retrieveAccountIndicators.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per RetrieveAccountIndicatorsRequestType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="RetrieveAccountIndicatorsRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransactionData" type="{http://it.fastweb.esb.org/TransactionDataTypes}TransactionDataType"/&gt;
 *         &lt;element name="InputData" type="{http://it.fastweb.esb.org/RetrieveAccountIndicators}InputDataType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveAccountIndicatorsRequestType", propOrder = {
    "transactionData",
    "inputData"
})
public class RetrieveAccountIndicatorsRequestType {

    @XmlElement(name = "TransactionData", required = true)
    protected TransactionDataType transactionData;
    @XmlElement(name = "InputData", required = true)
    protected InputDataType inputData;

    /**
     * Recupera il valore della proprieta transactionData.
     * 
     * @return
     *     possible object is
     *     {@link TransactionDataType }
     *     
     */
    public TransactionDataType getTransactionData() {
        return transactionData;
    }

    /**
     * Imposta il valore della proprieta transactionData.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionDataType }
     *     
     */
    public void setTransactionData(TransactionDataType value) {
        this.transactionData = value;
    }

    /**
     * Recupera il valore della proprieta inputData.
     * 
     * @return
     *     possible object is
     *     {@link InputDataType }
     *     
     */
    public InputDataType getInputData() {
        return inputData;
    }

    /**
     * Imposta il valore della proprieta inputData.
     * 
     * @param value
     *     allowed object is
     *     {@link InputDataType }
     *     
     */
    public void setInputData(InputDataType value) {
        this.inputData = value;
    }

}
