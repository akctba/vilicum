package br.org.vilicum.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Culto;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.persistence.CultoDAO;
import br.org.vilicum.util.Validator;

@BusinessController
public class CultoBC extends DelegateCrud<Culto, Long, CultoDAO> {
	
	private static final long serialVersionUID = -2092479128420596180L;

	@Inject
	private CultoDAO dao;
	
	@Inject
	private CongregacaoBC congBC;
	
	@Inject
	private PastorBC pastorBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private MessageContext messageContext;

	@Override
	public void delete(Long id) {
		Culto loaded = dao.load(id);
		if (Validator.isEmpty(loaded.getSantaceia())) {
			dao.delete(id);
			messageContext.add("{culto-delete-ok}", loaded.getData());
		} else {
			messageContext.add("{culto-delete-error}");
		}
	}

	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		// super.delete(ids);
	}

	@Override
	public List<Culto> findAll() {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		return dao.findAll(c);
	}
	
	@Override
	public Culto insert(Culto bean) {
		if (bean.getCongregacao() == null) {
			Usuario user = (Usuario) securityContext.getUser();
			Congregacao c = user.getCongregacao();
			bean.setCongregacao(c);
		}
		
		boolean existe = dao.exists(bean);
		
		if (existe) {
			messageContext.add("{culto.insert.dup}",
		             SeverityType.WARN, bean.getData());
		} else {
			bean.setCongregacao(congBC.load(bean.getCongregacao().getId()));
			bean.setPastor(pastorBC.load(bean.getPastor().getId()));
				
			return super.insert(bean);
		}
		return null;
	}

	@Override
	public Culto update(Culto bean) {
		if (bean.getCongregacao() == null) {
			Usuario user = (Usuario) securityContext.getUser();
			Congregacao c = user.getCongregacao();
			bean.setCongregacao(c);
		}
		
		Culto loaded = load(bean.getIdCulto());
		loaded.setCongregacao(congBC.load(bean.getCongregacao().getId()));
		loaded.setPastor(pastorBC.load(bean.getPastor().getId()));
		
		loaded.setSantaceia(bean.getSantaceia());
		
		loaded.setAdultos(bean.getAdultos());
		loaded.setCriancas(bean.getCriancas());
		loaded.setData(bean.getData());
		loaded.setDiacono(bean.isDiacono());
		loaded.setNomeDiacono(bean.getNomeDiacono());
		loaded.setParticipantes(bean.getParticipantes());
		loaded.setPrograma(bean.getPrograma());
		loaded.setVisitantes(bean.getVisitantes());
		
		return super.update(loaded);
	}

	public Long contaCultosAno(int ano) {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.cultosAno(ano, c);
	}

	public Long contaVisitantesAno(long ano) {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		return dao.visitantesAno(ano, c);
	}
	
//	public Map<Long, Long> contaVisitantesAnos(int ano) {
//		Usuario user = (Usuario) securityContext.getUser();
//		Congregacao c = user.getCongregacao();
//		
//		return dao.visitantesAnos(ano, c);
//	}
	
}
