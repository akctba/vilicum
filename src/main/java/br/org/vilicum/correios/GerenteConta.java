
package br.org.vilicum.correios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de gerenteConta complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="gerenteConta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientesVisiveis" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}clienteERP" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataAtualizacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataInclusao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataSenha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matricula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="senha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}statusGerente" minOccurs="0"/>
 *         &lt;element name="tipoGerente" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}tipoGerente" minOccurs="0"/>
 *         &lt;element name="usuariosInstalacao" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}usuarioInstalacao" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="validade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gerenteConta", propOrder = {
    "clientesVisiveis",
    "dataAtualizacao",
    "dataInclusao",
    "dataSenha",
    "login",
    "matricula",
    "senha",
    "status",
    "tipoGerente",
    "usuariosInstalacao",
    "validade"
})
public class GerenteConta {

    @XmlElement(nillable = true)
    protected List<ClienteERP> clientesVisiveis;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAtualizacao;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInclusao;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataSenha;
    protected String login;
    protected String matricula;
    protected String senha;
    @XmlSchemaType(name = "string")
    protected StatusGerente status;
    @XmlSchemaType(name = "string")
    protected TipoGerente tipoGerente;
    @XmlElement(nillable = true)
    protected List<UsuarioInstalacao> usuariosInstalacao;
    protected String validade;

    /**
     * Gets the value of the clientesVisiveis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clientesVisiveis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClientesVisiveis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClienteERP }
     * 
     * 
     */
    public List<ClienteERP> getClientesVisiveis() {
        if (clientesVisiveis == null) {
            clientesVisiveis = new ArrayList<ClienteERP>();
        }
        return this.clientesVisiveis;
    }

    /**
     * Obtém o valor da propriedade dataAtualizacao.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    /**
     * Define o valor da propriedade dataAtualizacao.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAtualizacao(XMLGregorianCalendar value) {
        this.dataAtualizacao = value;
    }

    /**
     * Obtém o valor da propriedade dataInclusao.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInclusao() {
        return dataInclusao;
    }

    /**
     * Define o valor da propriedade dataInclusao.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInclusao(XMLGregorianCalendar value) {
        this.dataInclusao = value;
    }

    /**
     * Obtém o valor da propriedade dataSenha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataSenha() {
        return dataSenha;
    }

    /**
     * Define o valor da propriedade dataSenha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataSenha(XMLGregorianCalendar value) {
        this.dataSenha = value;
    }

    /**
     * Obtém o valor da propriedade login.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Define o valor da propriedade login.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Obtém o valor da propriedade matricula.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define o valor da propriedade matricula.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricula(String value) {
        this.matricula = value;
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

    /**
     * Obtém o valor da propriedade status.
     * 
     * @return
     *     possible object is
     *     {@link StatusGerente }
     *     
     */
    public StatusGerente getStatus() {
        return status;
    }

    /**
     * Define o valor da propriedade status.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusGerente }
     *     
     */
    public void setStatus(StatusGerente value) {
        this.status = value;
    }

    /**
     * Obtém o valor da propriedade tipoGerente.
     * 
     * @return
     *     possible object is
     *     {@link TipoGerente }
     *     
     */
    public TipoGerente getTipoGerente() {
        return tipoGerente;
    }

    /**
     * Define o valor da propriedade tipoGerente.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoGerente }
     *     
     */
    public void setTipoGerente(TipoGerente value) {
        this.tipoGerente = value;
    }

    /**
     * Gets the value of the usuariosInstalacao property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuariosInstalacao property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuariosInstalacao().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsuarioInstalacao }
     * 
     * 
     */
    public List<UsuarioInstalacao> getUsuariosInstalacao() {
        if (usuariosInstalacao == null) {
            usuariosInstalacao = new ArrayList<UsuarioInstalacao>();
        }
        return this.usuariosInstalacao;
    }

    /**
     * Obtém o valor da propriedade validade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidade() {
        return validade;
    }

    /**
     * Define o valor da propriedade validade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidade(String value) {
        this.validade = value;
    }

}
