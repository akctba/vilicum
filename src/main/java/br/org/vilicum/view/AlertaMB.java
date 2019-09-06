package br.org.vilicum.view;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.vilicum.business.AlertaBC;
import java.io.Serializable;

@ViewController
public class AlertaMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4531227454555912194L;

	@Inject
	private AlertaBC alertaBC;
	
	private Long idAlerta;
	
	
	public void marcaFeito() {
		System.out.println("### Chamou marcaFeito com id " + this.idAlerta);
	}


	public Long getIdAlerta() {
		return idAlerta;
	}


	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}
}
