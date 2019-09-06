
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de conta complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="conta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoBanco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeBanco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroAgencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroConta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conta", propOrder = {
    "codigoBanco",
    "nomeBanco",
    "numeroAgencia",
    "numeroConta"
})
public class Conta {

    protected String codigoBanco;
    protected String nomeBanco;
    protected String numeroAgencia;
    protected String numeroConta;

    /**
     * Obtém o valor da propriedade codigoBanco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoBanco() {
        return codigoBanco;
    }

    /**
     * Define o valor da propriedade codigoBanco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoBanco(String value) {
        this.codigoBanco = value;
    }

    /**
     * Obtém o valor da propriedade nomeBanco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeBanco() {
        return nomeBanco;
    }

    /**
     * Define o valor da propriedade nomeBanco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeBanco(String value) {
        this.nomeBanco = value;
    }

    /**
     * Obtém o valor da propriedade numeroAgencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    /**
     * Define o valor da propriedade numeroAgencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroAgencia(String value) {
        this.numeroAgencia = value;
    }

    /**
     * Obtém o valor da propriedade numeroConta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroConta() {
        return numeroConta;
    }

    /**
     * Define o valor da propriedade numeroConta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroConta(String value) {
        this.numeroConta = value;
    }

}
