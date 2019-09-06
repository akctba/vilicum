package br.org.vilicum.view;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.org.vilicum.business.FamiliaBC;
import br.org.vilicum.business.IngressoBC;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.business.RegistroPastoralBC;
import br.org.vilicum.constant.Constantes;
import br.org.vilicum.domain.EstadoCivil;
import br.org.vilicum.domain.Familia;
import br.org.vilicum.domain.Genero;
import br.org.vilicum.domain.Ingresso;
import br.org.vilicum.domain.Membro;
import br.org.vilicum.domain.RegistroPastoral;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.util.CustomDate;

@ViewController
@PreviousView("./membro_list.jsf")
public class MembroEditMB extends AbstractEditPageBean<Membro, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MembroBC membroBC;
	
	@Inject
	private RegistroPastoralBC registroBC;

	@Inject
	private FamiliaBC familiaBC;

	@Inject
	private IngressoBC ingressoBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private MessageContext messageContext;
	
	@Inject
	private ResourceBundle bundle;
	
	private RegistroPastoral registro = new RegistroPastoral();
	
	private String filename;
	
	@Override
	@Transactional
	public String delete() {
		// this.membroBC.delete(getId());
		Membro bean = getBean();
		if (bean.getDataSaida() == null) {
			bean.setDataSaida(CustomDate.getCurrentDate());
		}
		this.membroBC.update(getBean());

		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.membroBC.insert(getBean());
		String mensagem = bundle.getString("membro-insert-ok", getBean().getNome());
		messageContext.add(mensagem);
		return ""; //getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.membroBC.update(getBean());
		String mensagem = bundle.getString("membro-update-ok", getBean().getNome());
		messageContext.add(mensagem);
		return ""; //getPreviousView();
	}
	
	@Override
	protected Membro handleLoad(Long id) {
		return this.membroBC.load(id);
	}
	
	@RequiredRole("Pastor")
	public String insertRegistro() {
		Usuario pastor = (Usuario)securityContext.getUser();
		
		registro.setDtRegistro(CustomDate.getCurrentTimestamp());
		registro.setMembro(this.getBean());
		registro.setPastor(pastor);
		
		this.registroBC.insert(registro);
		
		this.getBean().getRegistros().add(registro);
		membroBC.update(getBean());
		
		registro = new RegistroPastoral();
		return "";
	}
	
	public String voltar() {
		return getPreviousView();
	}
	
	public List<Familia> getFamilias() {
		return familiaBC.ativas();
	}
	
	public List<Ingresso> getIngressos() {
		return ingressoBC.ativos();
	}
	
	public Genero[] getGeneros() {
		return Genero.values();
	}
	
	public EstadoCivil[] getEstadoCivis() {
		return EstadoCivil.values();
	}

	public RegistroPastoral getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroPastoral registro) {
		this.registro = registro;
	}
	
	public void uploadPhoto(FileUploadEvent e) throws IOException {
		 
        UploadedFile uploadedPhoto=e.getFile();
        Membro mem = this.getBean();
 
        String filePath = Constantes.FOTOS + mem.getCongregacao().getId() + File.separator;
        byte[] bytes=null;
        
        //Cria a pasta se não existir 
        File dir = new File(filePath);
        if (!dir.exists()) {
        	dir.mkdirs();
        }
 
        if (null!=uploadedPhoto) {
            bytes = uploadedPhoto.getContents();
            String filename = FilenameUtils.getName(mem.getId() + ".jpg");
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath+filename)));
            stream.write(bytes);
            stream.close();
        }
 
        FacesContext.getCurrentInstance().addMessage("messagesp",new FacesMessage(FacesMessage.SEVERITY_INFO,"Foto enviada com sucesso", ""));
    }
	
	public String getFilename() {
        return filename;
    }
     
    public void oncapture(CaptureEvent captureEvent) {
    	int i = (int) (Math.random() * 10000000);
    	String idc = String.valueOf(getBean().getCongregacao().getId());
        String idm = String.valueOf(getBean().getId());
    	filename = idc+"-"+idm+"-"+i;
        
        byte[] data = captureEvent.getData();
         
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String newFileName = servletContext.getRealPath("") + File.separator + "images" + File.separator + "tmp" +
                                     File.separator + filename + ".jpg";
        
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        } catch(IOException e) {
            throw new FacesException("Error in writing captured image.", e);
        }
    }
    
    public String salvarFotoCam() {
    	String idc = String.valueOf(getBean().getCongregacao().getId());
        String idm = String.valueOf(getBean().getId());
        
        String filePath = Constantes.FOTOS + idc;
		
		//Cria a pasta se não existir 
        File dir = new File(filePath);
        if (!dir.exists()) {
        	dir.mkdirs();
        }
        
        filePath += File.separator + FilenameUtils.getName(idm + ".jpg");
        
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String newFileName = servletContext.getRealPath("") + File.separator + "images" + File.separator + "tmp" +
                                     File.separator + filename + ".jpg";
		
		File source = new File(newFileName);
        File target = new File(filePath);
        
        try {
			Files.copy(source.toPath(), target.toPath());
			source.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	return "";
    }
    
}