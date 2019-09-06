package br.org.vilicum.security;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.naming.AuthenticationException;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.org.vilicum.business.UsuarioBC;
import br.org.vilicum.exception.InvalidCredentialsException;
import br.org.vilicum.util.CustomDate;

@SessionScoped
public class Autenticador implements Authenticator {

	/**
	 * 
	 */
	private static final long serialVersionUID = -763310061086440526L;
	
	@Inject 
	private Credenciais credenciais;
	
	@Inject 
	private UsuarioBC usuarioBC;
	
	@Inject	
	private ResourceBundle bundle;

	@Override
	public void authenticate() throws Exception {
		
		String login = credenciais.getUsername();
		String senha = credenciais.getPassword();
		
		if (login != null 
				&& !login.equals("")
				&& senha != null
				&& !senha.equals("")) {
			
			br.org.vilicum.domain.Usuario usr = usuarioBC.load(login);
			
			try {
				if (usr != null) {
					String digest = Cripto.digest(senha);
					if (digest.equals(usr.getPassword())) {
						
						if (CustomDate.vencida(usr.getExclusao())) {
							throw new InvalidCredentialsException(bundle.getString("usuarioNaoAutenticado"));
						}
						
						if (usr.getCongregacao() != null &&
								CustomDate.vencida(usr.getCongregacao().getExclusao())) {
							throw new InvalidCredentialsException(bundle.getString("usuarioNaoAutenticado"));
						}
						
						credenciais.setUsuario(usr);
						credenciais.setUltimoAcesso(usr.getUltimoAcesso());
						
						usr.setUltimoAcesso(CustomDate.getCurrentDate());
						usuarioBC.update(usr);
						
					} else {
						throw new InvalidCredentialsException(bundle.getString("usuarioNaoAutenticado"));
					}
				} else {
					throw new InvalidCredentialsException(bundle.getString("usuarioNaoAutenticado"));
				}
			} catch (Exception e) {
				throw new AuthenticationException();
			}
		} else {
			throw new InvalidCredentialsException(bundle.getString("usuarioNaoAutenticado"));
		}
	}

	@Override
	public User getUser() {
		return credenciais.getUsuario();
	}

	@Override
	public void unauthenticate() throws Exception {
		credenciais.setUsuario(null);
		credenciais.setUsername("");
		credenciais.setPassword("");
		credenciais.setUltimoAcesso(null);
	}
	
}
