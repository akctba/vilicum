
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de retornoCancelamentoTO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="retornoCancelamentoTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cod_erro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo_administrativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msg_erro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objeto_postal" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}objetoSimplificadoTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retornoCancelamentoTO", propOrder = {
    "codErro",
    "codigoAdministrativo",
    "data",
    "hora",
    "msgErro",
    "objetoPostal"
})
public class RetornoCancelamentoTO {

    @XmlElement(name = "cod_erro")
    protected String codErro;
    @XmlElement(name = "codigo_administrativo")
    protected String codigoAdministrativo;
    protected String data;
    protected String hora;
    @XmlElement(name = "msg_erro")
    protected String msgErro;
    @XmlElement(name = "objeto_postal")
    protected ObjetoSimplificadoTO objetoPostal;

    /**
     * Obtém o valor da propriedade codErro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodErro() {
        return codErro;
    }

    /**
     * Define o valor da propriedade codErro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodErro(String value) {
        this.codErro = value;
    }

    /**
     * Obtém o valor da propriedade codigoAdministrativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoAdministrativo() {
        return codigoAdministrativo;
    }

    /**
     * Define o valor da propriedade codigoAdministrativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoAdministrativo(String value) {
        this.codigoAdministrativo = value;
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
     * Obtém o valor da propriedade hora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHora() {
        return hora;
    }

    /**
     * Define o valor da propriedade hora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHora(String value) {
        this.hora = value;
    }

    /**
     * Obtém o valor da propriedade msgErro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgErro() {
        return msgErro;
    }

    /**
     * Define o valor da propriedade msgErro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgErro(String value) {
        this.msgErro = value;
    }

    /**
     * Obtém o valor da propriedade objetoPostal.
     * 
     * @return
     *     possible object is
     *     {@link ObjetoSimplificadoTO }
     *     
     */
    public ObjetoSimplificadoTO getObjetoPostal() {
        return objetoPostal;
    }

    /**
     * Define o valor da propriedade objetoPostal.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjetoSimplificadoTO }
     *     
     */
    public void setObjetoPostal(ObjetoSimplificadoTO value) {
        this.objetoPostal = value;
    }

}
