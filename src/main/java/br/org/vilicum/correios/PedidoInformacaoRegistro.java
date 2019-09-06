
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de pedidoInformacaoRegistro complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="pedidoInformacaoRegistro">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cliente.bean.master.sigep.bsb.correios.com.br/}pedidoInformacao">
 *       &lt;sequence>
 *         &lt;element name="cliente" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}cliente" minOccurs="0"/>
 *         &lt;element name="codigoRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conta" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}conta" minOccurs="0"/>
 *         &lt;element name="conteudoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cpfCnpj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinatario" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}destinatario" minOccurs="0"/>
 *         &lt;element name="embalagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="motivo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="observacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postagem" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}postagem" minOccurs="0"/>
 *         &lt;element name="remetente" type="{http://cliente.bean.master.sigep.bsb.correios.com.br/}remetente" minOccurs="0"/>
 *         &lt;element name="servico" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pedidoInformacaoRegistro", propOrder = {
    "cliente",
    "codigoRegistro",
    "conta",
    "conteudoObjeto",
    "cpfCnpj",
    "destinatario",
    "embalagem",
    "motivo",
    "observacao",
    "postagem",
    "remetente",
    "servico",
    "tipoDocumento"
})
public class PedidoInformacaoRegistro
    extends PedidoInformacao
{

    protected Cliente cliente;
    protected String codigoRegistro;
    protected Conta conta;
    protected String conteudoObjeto;
    protected String cpfCnpj;
    protected Destinatario destinatario;
    protected String embalagem;
    protected Integer motivo;
    protected String observacao;
    protected Postagem postagem;
    protected Remetente remetente;
    protected Integer servico;
    protected String tipoDocumento;

    /**
     * Obtém o valor da propriedade cliente.
     * 
     * @return
     *     possible object is
     *     {@link Cliente }
     *     
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o valor da propriedade cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link Cliente }
     *     
     */
    public void setCliente(Cliente value) {
        this.cliente = value;
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
     * Obtém o valor da propriedade conta.
     * 
     * @return
     *     possible object is
     *     {@link Conta }
     *     
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * Define o valor da propriedade conta.
     * 
     * @param value
     *     allowed object is
     *     {@link Conta }
     *     
     */
    public void setConta(Conta value) {
        this.conta = value;
    }

    /**
     * Obtém o valor da propriedade conteudoObjeto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConteudoObjeto() {
        return conteudoObjeto;
    }

    /**
     * Define o valor da propriedade conteudoObjeto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConteudoObjeto(String value) {
        this.conteudoObjeto = value;
    }

    /**
     * Obtém o valor da propriedade cpfCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * Define o valor da propriedade cpfCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfCnpj(String value) {
        this.cpfCnpj = value;
    }

    /**
     * Obtém o valor da propriedade destinatario.
     * 
     * @return
     *     possible object is
     *     {@link Destinatario }
     *     
     */
    public Destinatario getDestinatario() {
        return destinatario;
    }

    /**
     * Define o valor da propriedade destinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link Destinatario }
     *     
     */
    public void setDestinatario(Destinatario value) {
        this.destinatario = value;
    }

    /**
     * Obtém o valor da propriedade embalagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmbalagem() {
        return embalagem;
    }

    /**
     * Define o valor da propriedade embalagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmbalagem(String value) {
        this.embalagem = value;
    }

    /**
     * Obtém o valor da propriedade motivo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMotivo() {
        return motivo;
    }

    /**
     * Define o valor da propriedade motivo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMotivo(Integer value) {
        this.motivo = value;
    }

    /**
     * Obtém o valor da propriedade observacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Define o valor da propriedade observacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservacao(String value) {
        this.observacao = value;
    }

    /**
     * Obtém o valor da propriedade postagem.
     * 
     * @return
     *     possible object is
     *     {@link Postagem }
     *     
     */
    public Postagem getPostagem() {
        return postagem;
    }

    /**
     * Define o valor da propriedade postagem.
     * 
     * @param value
     *     allowed object is
     *     {@link Postagem }
     *     
     */
    public void setPostagem(Postagem value) {
        this.postagem = value;
    }

    /**
     * Obtém o valor da propriedade remetente.
     * 
     * @return
     *     possible object is
     *     {@link Remetente }
     *     
     */
    public Remetente getRemetente() {
        return remetente;
    }

    /**
     * Define o valor da propriedade remetente.
     * 
     * @param value
     *     allowed object is
     *     {@link Remetente }
     *     
     */
    public void setRemetente(Remetente value) {
        this.remetente = value;
    }

    /**
     * Obtém o valor da propriedade servico.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getServico() {
        return servico;
    }

    /**
     * Define o valor da propriedade servico.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServico(Integer value) {
        this.servico = value;
    }

    /**
     * Obtém o valor da propriedade tipoDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Define o valor da propriedade tipoDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

}
