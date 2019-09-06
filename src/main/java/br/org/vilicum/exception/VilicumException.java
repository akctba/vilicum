package br.org.vilicum.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;

@ApplicationException(rollback = true)
public class VilicumException extends RuntimeException {

	public VilicumException() {
		super("Erro na aplica��o!");
		// criar exce��o por tipo de erro
	}
}
