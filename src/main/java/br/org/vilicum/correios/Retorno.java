
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de retorno complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="retorno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoPI" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="codigoRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoRetorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataPrazoResposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataResposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataUltimaRecorrencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mensagemRetorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resposta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retorno", propOrder = {
    "codigoPI",
    "codigoRegistro",
    "codigoRetorno",
    "dataPrazoResposta",
    "dataRegistro",
    "dataResposta",
    "dataUltimaRecorrencia",
    "id",
    "mensagemRetorno",
    "resposta"
})
public class Retorno {

    protected Long codigoPI;
    protected String codigoRegistro;
    protected String codigoRetorno;
    protected String dataPrazoResposta;
    protected String dataRegistro;
    protected String dataResposta;
    protected String dataUltimaRecorrencia;
    protected Long id;
    protected String mensagemRetorno;
    protected String resposta;

    /**
     * Obtém o valor da propriedade codigoPI.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodigoPI() {
        return codigoPI;
    }

    /**
     * Define o valor da propriedade codigoPI.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodigoPI(Long value) {
        this.codigoPI = value;
    }

    /**
     * Obtém o valor da propriedade codigoRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    /**
     * Define o valor da propriedade codigoRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRegistro(String value) {
        this.codigoRegistro = value;
    }

    /**
     * Obtém o valor da propriedade codigoRetorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRetorno() {
        return codigoRetorno;
    }

    /**
     * Define o valor da propriedade codigoRetorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRetorno(String value) {
        this.codigoRetorno = value;
    }

    /**
     * Obtém o valor da propriedade dataPrazoResposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataPrazoResposta() {
        return dataPrazoResposta;
    }

    /**
     * Define o valor da propriedade dataPrazoResposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataPrazoResposta(String value) {
        this.dataPrazoResposta = value;
    }

    /**
     * Obtém o valor da propriedade dataRegistro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRegistro() {
        return dataRegistro;
    }

    /**
     * Define o valor da propriedade dataRegistro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRegistro(String value) {
        this.dataRegistro = value;
    }

    /**
     * Obtém o valor da propriedade dataResposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataResposta() {
        return dataResposta;
    }

    /**
     * Define o valor da propriedade dataResposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataResposta(String value) {
        this.dataResposta = value;
    }

    /**
     * Obtém o valor da propriedade dataUltimaRecorrencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataUltimaRecorrencia() {
        return dataUltimaRecorrencia;
    }

    /**
     * Define o valor da propriedade dataUltimaRecorrencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataUltimaRecorrencia(String value) {
        this.dataUltimaRecorrencia = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade mensagemRetorno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    /**
     * Define o valor da propriedade mensagemRetorno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagemRetorno(String value) {
        this.mensagemRetorno = value;
    }

    /**
     * Obtém o valor da propriedade resposta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * Define o valor da propriedade resposta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResposta(String value) {
        this.resposta = value;
    }

}
