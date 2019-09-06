package br.org.vilicum.business;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.persistence.UsuarioDAO;
import br.org.vilicum.security.Cripto;
import br.org.vilicum.util.CustomDate;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, String, UsuarioDAO> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3373758565024885163L;
	
	@Inject
	UsuarioDAO dao;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			Usuario user = new Usuario();
			user.setNome("Alex Kayser");
			user.setId("alex");
			String password = Cripto.digest("123");
			user.setPassword(password );
			insert(user);
		}
	}
	
	
	@Override
	public List<Usuario> findAll() {
		return dao.findAtivos();
	}


	@Override
	@RequiredRole("Administrador")
	public void delete(String id) {
		// Nao permitir exclusao fisica
		//super.delete(id);
		if (id == null) {
			return;
		}
		
		Usuario loaded = load(id);
		loaded.setExclusao(CustomDate.getCurrentDate());
		update(loaded);
	}


	@Override
	public void delete(List<String> ids) {
		// nao permitir exclusao fisica
		//super.delete(ids);
		if (ids == null) {
			return;
		}
		
		for (String id : ids) {
			delete(id);
		}
		
	}


	@Override
	@RequiredRole("Administrador")
	public Usuario insert(Usuario bean) {
		if (bean != null) {
			if (bean.getInclusao() == null) {
				bean.setInclusao(CustomDate.getCurrentDate());
			}
			return super.insert(bean);
		}
		return null;
	}


	@Override
	public Usuario update(Usuario bean) {
		if (bean != null) {
			Date currentDate = CustomDate.getCurrentDate();
			if (bean.getInclusao() == null) {
				bean.setInclusao(currentDate);
			}
			bean.setAlteracao(currentDate);
			return super.update(bean);
		}
		return null;
	}
	
	/**
	 * Busca por ID ou email
	 * @param id
	 * @param email
	 * @return
	 */
	public Usuario byIdEmail(String id, String email) {
		Usuario usr = null;
		if (email != null && id != null) {
			usr = dao.findByIdEmail(id, email);
		}
		return usr;
	}

}
