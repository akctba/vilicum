package br.org.vilicum.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.vilicum.domain.Perfil;

@PersistenceController
public class PerfilDAO extends JPACrud<Perfil, Long> {

	private static final long serialVersionUID = 1L;
	

}
