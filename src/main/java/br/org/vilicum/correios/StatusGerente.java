
package br.org.vilicum.correios;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de statusGerente.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="statusGerente">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ativo"/>
 *     &lt;enumeration value="Inativo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "statusGerente")
@XmlEnum
public enum StatusGerente {

    @XmlEnumValue("Ativo")
    ATIVO("Ativo"),
    @XmlEnumValue("Inativo")
    INATIVO("Inativo");
    private final String value;

    StatusGerente(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusGerente fromValue(String v) {
        for (StatusGerente c: StatusGerente.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
