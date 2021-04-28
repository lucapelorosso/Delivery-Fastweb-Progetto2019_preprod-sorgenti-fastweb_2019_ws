
package it.eudata.fastweb.retrieveAccountIndicators.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per RetrieveAccountIndicatorsResponseType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="RetrieveAccountIndicatorsResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResultData" type="{http://it.fastweb.esb.org/ResultDataType}ResultDataType"/&gt;
 *         &lt;element name="OutputData" type="{http://it.fastweb.esb.org/RetrieveAccountIndicators}OutputDataType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveAccountIndicatorsResponseType", propOrder = {
    "resultData",
    "outputData"
})
public class RetrieveAccountIndicatorsResponseType {

    @XmlElement(name = "ResultData", required = true)
    protected ResultDataType resultData;
    @XmlElement(name = "OutputData")
    protected OutputDataType outputData;

    /**
     * Recupera il valore della proprieta resultData.
     * 
     * @return
     *     possible object is
     *     {@link ResultDataType }
     *     
     */
    public ResultDataType getResultData() {
        return resultData;
    }

    /**
     * Imposta il valore della proprieta resultData.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultDataType }
     *     
     */
    public void setResultData(ResultDataType value) {
        this.resultData = value;
    }

    /**
     * Recupera il valore della proprieta outputData.
     * 
     * @return
     *     possible object is
     *     {@link OutputDataType }
     *     
     */
    public OutputDataType getOutputData() {
        return outputData;
    }

    /**
     * Imposta il valore della proprieta outputData.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputDataType }
     *     
     */
    public void setOutputData(OutputDataType value) {
        this.outputData = value;
    }

}
