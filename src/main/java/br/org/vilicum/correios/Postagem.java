
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de postagem complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="postagem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="avisoRecebimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="local" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorDeclarado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postagem", propOrder = {
    "agencia",
    "avisoRecebimento",
    "data",
    "local",
    "valorDeclarado"
})
public class Postagem {

    protected String agencia;
    protected String avisoRecebimento;
    protected String data;
    protected String local;
    protected String valorDeclarado;

    /**
     * Obtém o valor da propriedade agencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * Define o valor da propriedade agencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencia(String value) {
        this.agencia = value;
    }

    /**
     * Obtém o valor da propriedade avisoRecebimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvisoRecebimento() {
        return avisoRecebimento;
    }

    /**
     * Define o valor da propriedade avisoRecebimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvisoRecebimento(String value) {
        this.avisoRecebimento = value;
    }

    /**
     * Obtém o valor da propriedade data.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Define o valor da propriedade data.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

    /**
     * Obtém o valor da propriedade local.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocal() {
        return local;
    }

    /**
     * Define o valor da propriedade local.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocal(String value) {
        this.local = value;
    }

    /**
     * Obtém o valor da propriedade valorDeclarado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorDeclarado() {
        return valorDeclarado;
    }

    /**
     * Define o valor da propriedade valorDeclarado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorDeclarado(String value) {
        this.valorDeclarado = value;
    }

}
