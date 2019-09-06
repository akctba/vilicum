package br.org.vilicum.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;

@ApplicationException
public class InvalidCredentialsException extends br.gov.frameworkdemoiselle.security.AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7446928296301037466L;

	public InvalidCredentialsException(String message) {
		super(message);
	}
	
}
