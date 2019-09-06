
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de solicitaEtiquetas complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="solicitaEtiquetas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idServico" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="qtdEtiquetas" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="senha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitaEtiquetas", propOrder = {
    "tipoDestinatario",
    "identificador",
    "idServico",
    "qtdEtiquetas",
    "usuario",
    "senha"
})
public class SolicitaEtiquetas {

    protected String tipoDestinatario;
    protected String identificador;
    protected Long idServico;
    protected Integer qtdEtiquetas;
    protected String usuario;
    protected String senha;

    /**
     * Obtém o valor da propriedade tipoDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    /**
     * Define o valor da propriedade tipoDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDestinatario(String value) {
        this.tipoDestinatario = value;
    }

    /**
     * Obtém o valor da propriedade identificador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificador() {
        return identificador;
    }

    /**
     * Define o valor da propriedade identificador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificador(String value) {
        this.identificador = value;
    }

    /**
     * Obtém o valor da propriedade idServico.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdServico() {
        return idServico;
    }

    /**
     * Define o valor da propriedade idServico.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdServico(Long value) {
        this.idServico = value;
    }

    /**
     * Obtém o valor da propriedade qtdEtiquetas.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQtdEtiquetas() {
        return qtdEtiquetas;
    }

    /**
     * Define o valor da propriedade qtdEtiquetas.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQtdEtiquetas(Integer value) {
        this.qtdEtiquetas = value;
    }

    /**
     * Obtém o valor da propriedade usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o valor da propriedade usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtém o valor da propriedade senha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define o valor da propriedade senha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenha(String value) {
        this.senha = value;
    }

}
