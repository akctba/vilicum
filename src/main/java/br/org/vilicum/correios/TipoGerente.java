
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoGerente.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoGerente">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="GerenteConta"/>
 *     &lt;enumeration value="GerenteContaMaster"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoGerente")
@XmlEnum
public enum TipoGerente {

    @XmlEnumValue("GerenteConta")
    GERENTE_CONTA("GerenteConta"),
    @XmlEnumValue("GerenteContaMaster")
    GERENTE_CONTA_MASTER("GerenteContaMaster");
    private final String value;

    TipoGerente(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoGerente fromValue(String v) {
        for (TipoGerente c: TipoGerente.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
