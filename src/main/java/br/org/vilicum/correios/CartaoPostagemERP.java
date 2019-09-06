
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
 * <p>Classe Java de cartaoPostagemERP complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cartaoPostagemERP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoAdministrativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contratos" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}contratoERP" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataAtualizacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataVigenciaFim" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataVigenciaInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="datajAtualizacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="datajVigenciaFim" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="datajVigenciaInicio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="descricaoStatusCartao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descricaoUnidadePostagemGenerica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="horajAtualizacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicos" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}servicoERP" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="statusCartaoPostagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unidadeGenerica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unidadesPostagem" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}unidadePostagemERP" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cartaoPostagemERP", propOrder = {
    "codigoAdministrativo",
    "contratos",
    "dataAtualizacao",
    "dataVigenciaFim",
    "dataVigenciaInicio",
    "datajAtualizacao",
    "datajVigenciaFim",
    "datajVigenciaInicio",
    "descricaoStatusCartao",
    "descricaoUnidadePostagemGenerica",
    "horajAtualizacao",
    "numero",
    "servicos",
    "statusCartaoPostagem",
    "statusCodigo",
    "unidadeGenerica",
    "unidadesPostagem"
})
public class CartaoPostagemERP {

    protected String codigoAdministrativo;
    @XmlElement(nillable = true)
    protected List<ContratoERP> contratos;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAtualizacao;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataVigenciaFim;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataVigenciaInicio;
    protected Integer datajAtualizacao;
    protected Integer datajVigenciaFim;
    protected Integer datajVigenciaInicio;
    protected String descricaoStatusCartao;
    protected String descricaoUnidadePostagemGenerica;
    protected Integer horajAtualizacao;
    protected String numero;
    @XmlElement(nillable = true)
    protected List<ServicoERP> servicos;
    protected String statusCartaoPostagem;
    protected String statusCodigo;
    protected String unidadeGenerica;
    @XmlElement(nillable = true)
    protected List<UnidadePostagemERP> unidadesPostagem;

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
     * Gets the value of the contratos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contratos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContratos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContratoERP }
     * 
     * 
     */
    public List<ContratoERP> getContratos() {
        if (contratos == null) {
            contratos = new ArrayList<ContratoERP>();
        }
        return this.contratos;
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
     * Obtém o valor da propriedade dataVigenciaFim.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataVigenciaFim() {
        return dataVigenciaFim;
    }

    /**
     * Define o valor da propriedade dataVigenciaFim.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataVigenciaFim(XMLGregorianCalendar value) {
        this.dataVigenciaFim = value;
    }

    /**
     * Obtém o valor da propriedade dataVigenciaInicio.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataVigenciaInicio() {
        return dataVigenciaInicio;
    }

    /**
     * Define o valor da propriedade dataVigenciaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataVigenciaInicio(XMLGregorianCalendar value) {
        this.dataVigenciaInicio = value;
    }

    /**
     * Obtém o valor da propriedade datajAtualizacao.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDatajAtualizacao() {
        return datajAtualizacao;
    }

    /**
     * Define o valor da propriedade datajAtualizacao.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDatajAtualizacao(Integer value) {
        this.datajAtualizacao = value;
    }

    /**
     * Obtém o valor da propriedade datajVigenciaFim.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDatajVigenciaFim() {
        return datajVigenciaFim;
    }

    /**
     * Define o valor da propriedade datajVigenciaFim.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDatajVigenciaFim(Integer value) {
        this.datajVigenciaFim = value;
    }

    /**
     * Obtém o valor da propriedade datajVigenciaInicio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDatajVigenciaInicio() {
        return datajVigenciaInicio;
    }

    /**
     * Define o valor da propriedade datajVigenciaInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDatajVigenciaInicio(Integer value) {
        this.datajVigenciaInicio = value;
    }

    /**
     * Obtém o valor da propriedade descricaoStatusCartao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoStatusCartao() {
        return descricaoStatusCartao;
    }

    /**
     * Define o valor da propriedade descricaoStatusCartao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoStatusCartao(String value) {
        this.descricaoStatusCartao = value;
    }

    /**
     * Obtém o valor da propriedade descricaoUnidadePostagemGenerica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoUnidadePostagemGenerica() {
        return descricaoUnidadePostagemGenerica;
    }

    /**
     * Define o valor da propriedade descricaoUnidadePostagemGenerica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoUnidadePostagemGenerica(String value) {
        this.descricaoUnidadePostagemGenerica = value;
    }

    /**
     * Obtém o valor da propriedade horajAtualizacao.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHorajAtualizacao() {
        return horajAtualizacao;
    }

    /**
     * Define o valor da propriedade horajAtualizacao.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHorajAtualizacao(Integer value) {
        this.horajAtualizacao = value;
    }

    /**
     * Obtém o valor da propriedade numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o valor da propriedade numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Gets the value of the servicos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicoERP }
     * 
     * 
     */
    public List<ServicoERP> getServicos() {
        if (servicos == null) {
            servicos = new ArrayList<ServicoERP>();
        }
        return this.servicos;
    }

    /**
     * Obtém o valor da propriedade statusCartaoPostagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCartaoPostagem() {
        return statusCartaoPostagem;
    }

    /**
     * Define o valor da propriedade statusCartaoPostagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCartaoPostagem(String value) {
        this.statusCartaoPostagem = value;
    }

    /**
     * Obtém o valor da propriedade statusCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCodigo() {
        return statusCodigo;
    }

    /**
     * Define o valor da propriedade statusCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCodigo(String value) {
        this.statusCodigo = value;
    }

    /**
     * Obtém o valor da propriedade unidadeGenerica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnidadeGenerica() {
        return unidadeGenerica;
    }

    /**
     * Define o valor da propriedade unidadeGenerica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnidadeGenerica(String value) {
        this.unidadeGenerica = value;
    }

    /**
     * Gets the value of the unidadesPostagem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unidadesPostagem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnidadesPostagem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnidadePostagemERP }
     * 
     * 
     */
    public List<UnidadePostagemERP> getUnidadesPostagem() {
        if (unidadesPostagem == null) {
            unidadesPostagem = new ArrayList<UnidadePostagemERP>();
        }
        return this.unidadesPostagem;
    }

}
