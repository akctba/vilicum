package br.org.vilicum.util;

import java.io.IOException;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import org.primefaces.component.picklist.PickList;
import org.primefaces.component.picklist.PickListRenderer;
import org.primefaces.util.WidgetBuilder;

/**
 * Workaround para o filtro do picklist funcionar
 * @author Alex
 */
public class PickListBugfixRenderer extends PickListRenderer {
	@Override
    protected void encodeClientBehaviors(FacesContext context, ClientBehaviorHolder component, WidgetBuilder wb) throws IOException {
        super.encodeClientBehaviors(context, component, wb);
        PickList pickList = (PickList) component;
        wb.attr("filterMatchMode", pickList.getFilterMatchMode(), null);
    }
}

/* Incluir no faces-config:
	 <render-kit>
	      <renderer>
	          <component-family>org.primefaces.component</component-family>
	          <renderer-type>org.primefaces.component.PickListRenderer</renderer-type>
	          <renderer-class>br.org.vilicum.util.PickListBugfixRenderer</renderer-class>
	      </renderer>
	  </render-kit>
*/