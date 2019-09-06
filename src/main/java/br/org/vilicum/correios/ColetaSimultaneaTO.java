
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de coletaSimultaneaTO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="coletaSimultaneaTO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cliente.bean.master.sigep.bsb.correios.com.br/}coletaTO">
 *       &lt;sequence>
 *         &lt;element name="obj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="obs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coletaSimultaneaTO", propOrder = {
    "obj",
    "obs"
})
public class ColetaSimultaneaTO
    extends ColetaTO
{

    protected String obj;
    protected String obs;

    /**
     * Obtém o valor da propriedade obj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObj() {
        return obj;
    }

    /**
     * Define o valor da propriedade obj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObj(String value) {
        this.obj = value;
    }

    /**
     * Obtém o valor da propriedade obs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObs() {
        return obs;
    }

    /**
     * Define o valor da propriedade obs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObs(String value) {
        this.obs = value;
    }

}
