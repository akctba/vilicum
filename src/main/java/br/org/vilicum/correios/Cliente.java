
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cliente complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cliente">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="possuiContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cliente", propOrder = {
    "numeroContrato",
    "possuiContrato"
})
public class Cliente {

    protected String numeroContrato;
    protected String possuiContrato;

    /**
     * Obtém o valor da propriedade numeroContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroContrato() {
        return numeroContrato;
    }

    /**
     * Define o valor da propriedade numeroContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroContrato(String value) {
        this.numeroContrato = value;
    }

    /**
     * Obtém o valor da propriedade possuiContrato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPossuiContrato() {
        return possuiContrato;
    }

    /**
     * Define o valor da propriedade possuiContrato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPossuiContrato(String value) {
        this.possuiContrato = value;
    }

}
