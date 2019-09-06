package br.org.vilicum.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;

@ApplicationException
public class AuthenticationException extends br.gov.frameworkdemoiselle.security.AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3917712631205321047L;

	public AuthenticationException(String message) {
		super(message);
	}

}
