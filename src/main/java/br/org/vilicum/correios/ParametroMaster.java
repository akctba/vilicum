
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de parametroMaster complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="parametroMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prmCoParametro" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="prmTxParametro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prmTxValor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "parametroMaster", propOrder = {
    "prmCoParametro",
    "prmTxParametro",
    "prmTxValor"
})
public class ParametroMaster {

    protected long prmCoParametro;
    protected String prmTxParametro;
    protected String prmTxValor;

    /**
     * Obtém o valor da propriedade prmCoParametro.
     * 
     */
    public long getPrmCoParametro() {
        return prmCoParametro;
    }

    /**
     * Define o valor da propriedade prmCoParametro.
     * 
     */
    public void setPrmCoParametro(long value) {
        this.prmCoParametro = value;
    }

    /**
     * Obtém o valor da propriedade prmTxParametro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmTxParametro() {
        return prmTxParametro;
    }

    /**
     * Define o valor da propriedade prmTxParametro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmTxParametro(String value) {
        this.prmTxParametro = value;
    }

    /**
     * Obtém o valor da propriedade prmTxValor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrmTxValor() {
        return prmTxValor;
    }

    /**
     * Define o valor da propriedade prmTxValor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrmTxValor(String value) {
        this.prmTxValor = value;
    }

}
