
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de produtoTO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="produtoTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="qtd" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produtoTO", propOrder = {
    "codigo",
    "qtd",
    "tipo"
})
public class ProdutoTO {

    protected Long codigo;
    protected Long qtd;
    protected Long tipo;

    /**
     * Obtém o valor da propriedade codigo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCodigo(Long value) {
        this.codigo = value;
    }

    /**
     * Obtém o valor da propriedade qtd.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQtd() {
        return qtd;
    }

    /**
     * Define o valor da propriedade qtd.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQtd(Long value) {
        this.qtd = value;
    }

    /**
     * Obtém o valor da propriedade tipo.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTipo() {
        return tipo;
    }

    /**
     * Define o valor da propriedade tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTipo(Long value) {
        this.tipo = value;
    }

}
