
package br.org.vilicum.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.domain.RegistroPastoral;
import br.org.vilicum.persistence.RegistroPastoralDAO;
import br.org.vilicum.security.DeEncrypter;

@BusinessController
public class RegistroPastoralBC extends DelegateCrud<RegistroPastoral, Long, RegistroPastoralDAO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4425219790298361485L;
	
	@Override
	public RegistroPastoral insert(RegistroPastoral bean) {
		try {
			if (bean != null) {
				String registro = bean.getRegistro();
				String cripto = DeEncrypter.getInstance().encrypt(registro);
				bean.setRegistro(cripto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return super.insert(bean);
	}

	@Override
	public RegistroPastoral update(RegistroPastoral bean) {
		try {
			if (bean != null) {
				String registro = bean.getRegistro();
				String cripto = DeEncrypter.getInstance().encrypt(registro);
				bean.setRegistro(cripto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return super.update(bean);
	}

	
	
	
}
