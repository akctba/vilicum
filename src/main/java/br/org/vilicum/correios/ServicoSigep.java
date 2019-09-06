
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de servicoSigep complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="servicoSigep">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="categoriaServico" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}categoriaServico" minOccurs="0"/>
 *         &lt;element name="chancela" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}chancelaMaster" minOccurs="0"/>
 *         &lt;element name="exigeDimensoes" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="exigeValorCobrar" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="imitm" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="servico" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="servicoERP" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}servicoERP" minOccurs="0"/>
 *         &lt;element name="ssiCoCodigoPostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "servicoSigep", propOrder = {
    "categoriaServico",
    "chancela",
    "exigeDimensoes",
    "exigeValorCobrar",
    "imitm",
    "servico",
    "servicoERP",
    "ssiCoCodigoPostal"
})
public class ServicoSigep {

    @XmlSchemaType(name = "string")
    protected CategoriaServico categoriaServico;
    protected ChancelaMaster chancela;
    protected Boolean exigeDimensoes;
    protected Boolean exigeValorCobrar;
    protected long imitm;
    protected long servico;
    protected ServicoERP servicoERP;
    protected String ssiCoCodigoPostal;

    /**
     * Obtém o valor da propriedade categoriaServico.
     * 
     * @return
     *     possible object is
     *     {@link CategoriaServico }
     *     
     */
    public CategoriaServico getCategoriaServico() {
        return categoriaServico;
    }

    /**
     * Define o valor da propriedade categoriaServico.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoriaServico }
     *     
     */
    public void setCategoriaServico(CategoriaServico value) {
        this.categoriaServico = value;
    }

    /**
     * Obtém o valor da propriedade chancela.
     * 
     * @return
     *     possible object is
     *     {@link ChancelaMaster }
     *     
     */
    public ChancelaMaster getChancela() {
        return chancela;
    }

    /**
     * Define o valor da propriedade chancela.
     * 
     * @param value
     *     allowed object is
     *     {@link ChancelaMaster }
     *     
     */
    public void setChancela(ChancelaMaster value) {
        this.chancela = value;
    }

    /**
     * Obtém o valor da propriedade exigeDimensoes.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExigeDimensoes() {
        return exigeDimensoes;
    }

    /**
     * Define o valor da propriedade exigeDimensoes.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExigeDimensoes(Boolean value) {
        this.exigeDimensoes = value;
    }

    /**
     * Obtém o valor da propriedade exigeValorCobrar.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExigeValorCobrar() {
        return exigeValorCobrar;
    }

    /**
     * Define o valor da propriedade exigeValorCobrar.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExigeValorCobrar(Boolean value) {
        this.exigeValorCobrar = value;
    }

    /**
     * Obtém o valor da propriedade imitm.
     * 
     */
    public long getImitm() {
        return imitm;
    }

    /**
     * Define o valor da propriedade imitm.
     * 
     */
    public void setImitm(long value) {
        this.imitm = value;
    }

    /**
     * Obtém o valor da propriedade servico.
     * 
     */
    public long getServico() {
        return servico;
    }

    /**
     * Define o valor da propriedade servico.
     * 
     */
    public void setServico(long value) {
        this.servico = value;
    }

    /**
     * Obtém o valor da propriedade servicoERP.
     * 
     * @return
     *     possible object is
     *     {@link ServicoERP }
     *     
     */
    public ServicoERP getServicoERP() {
        return servicoERP;
    }

    /**
     * Define o valor da propriedade servicoERP.
     * 
     * @param value
     *     allowed object is
     *     {@link ServicoERP }
     *     
     */
    public void setServicoERP(ServicoERP value) {
        this.servicoERP = value;
    }

    /**
     * Obtém o valor da propriedade ssiCoCodigoPostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsiCoCodigoPostal() {
        return ssiCoCodigoPostal;
    }

    /**
     * Define o valor da propriedade ssiCoCodigoPostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsiCoCodigoPostal(String value) {
        this.ssiCoCodigoPostal = value;
    }

}
