package br.org.vilicum.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.report.Report;
import br.gov.frameworkdemoiselle.report.Type;
import br.gov.frameworkdemoiselle.report.annotation.Path;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.util.Faces;
import br.gov.frameworkdemoiselle.util.FileRenderer;
import br.org.vilicum.business.FamiliaBC;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Familia;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.util.CustomDate;
import java.io.Serializable;

@ViewController
public class RelFamiliasMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6825943072430637051L;

	@Inject
	private FamiliaBC familiaBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private FileRenderer renderer;

	@Inject
	@Path("reports/familias.jasper")
	private Report relatorio;

	public List<Familia> familias() {

		List<Familia> ativas = familiaBC.ativas();
		ativas.size();

		return ativas;
	}

	public String showReport() {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Usuario user = (Usuario) securityContext.getUser();
			Congregacao c = user.getCongregacao();
			
			String fileName = "Familias " + c.getNome() + " ";
			fileName += CustomDate.getYMD(CustomDate.getCurrentDate());
			fileName += ".pdf";
			
			byte[] buffer = this.relatorio.export(familias(), param, Type.PDF);
			this.renderer.render(buffer, FileRenderer.ContentType.PDF, fileName);
		} catch (Exception e) {
			Faces.addMessage(e);
		}
		return "";
	}
}
