package br.org.vilicum.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.vilicum.domain.Departamento;

@PersistenceController
public class DepartamentoDAO extends JPACrud<Departamento, Long> {

	private static final long serialVersionUID = 1L;
	

}
