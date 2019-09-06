package br.org.vilicum.view;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.business.CongregacaoBC;
import br.org.vilicum.business.PerfilBC;
import br.org.vilicum.business.UsuarioBC;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Perfil;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.security.Cripto;

@ViewController
@PreviousView("./usuario_list.jsf")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, String> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Logger logger;
	
	@Inject
	private CongregacaoBC congregacaoBC;
	
	private String password;
	
	@Inject
	private PerfilBC perfilBC;

	@Inject
	private UsuarioBC usuarioBC;
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String insert() {
		Usuario b = getBean();
		try {
			if(this.password!=null && !"".equals(this.password)) {
				String nSenha = Cripto.digest(this.password);
				b.setPassword(nSenha);
			}
			this.usuarioBC.insert(b);
		} catch (Exception e) {
			logger.error("Erro ao inserir novo usuario.", e);
		}
		return ""; //getPreviousView();
	}
	
	@Override
	@Transactional
	@RequiredRole("Administrador")
	public String update() {
		Usuario b = getBean();
		try {
			if(this.password!=null && !"".equals(this.password)) {
				String nSenha = Cripto.digest(this.password);
				b.setPassword(nSenha);
			}
			this.usuarioBC.update(b);
		} catch (Exception e) {
			logger.error("Erro ao atualizar usuario.", e);
		}
		return getPreviousView();
	}
	
	@Override
	protected Usuario handleLoad(String id) {
		setBean(this.usuarioBC.load(id));
		return getBean();
	}
	
	public List<Congregacao> getCongregacoes() {
		return congregacaoBC.ativas();
	}
	
	public List<Perfil> getPerfis() {
		return perfilBC.findAll();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}