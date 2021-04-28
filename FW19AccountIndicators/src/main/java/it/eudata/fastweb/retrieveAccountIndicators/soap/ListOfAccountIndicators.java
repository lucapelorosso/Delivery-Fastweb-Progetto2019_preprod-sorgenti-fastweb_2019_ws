
package it.eudata.fastweb.retrieveAccountIndicators.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per ListOfAccountIndicators complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ListOfAccountIndicators"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IndName"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="4000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IndValue"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;maxLength value="4000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="IndLud" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListOfAccountIndicators", propOrder = {
    "indName",
    "indValue",
    "indLud"
})
public class ListOfAccountIndicators {

    @XmlElement(name = "IndName", required = true)
    protected String indName;
    @XmlElement(name = "IndValue", required = true)
    protected String indValue;
    @XmlElement(name = "IndLud", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar indLud;

    /**
     * Recupera il valore della proprieta indName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndName() {
        return indName;
    }

    /**
     * Imposta il valore della proprieta indName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndName(String value) {
        this.indName = value;
    }

    /**
     * Recupera il valore della proprieta indValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndValue() {
        return indValue;
    }

    /**
     * Imposta il valore della proprieta indValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndValue(String value) {
        this.indValue = value;
    }

    /**
     * Recupera il valore della proprieta indLud.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIndLud() {
        return indLud;
    }

    /**
     * Imposta il valore della proprieta indLud.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIndLud(XMLGregorianCalendar value) {
        this.indLud = value;
    }

}
