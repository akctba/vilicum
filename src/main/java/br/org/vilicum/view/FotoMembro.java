package br.org.vilicum.view;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.CaptureEvent;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.vilicum.constant.Constantes;
import br.org.vilicum.security.DeEncrypter;

@ViewController
public class FotoMembro implements Serializable {
	
	private static final long serialVersionUID = -2424110802300101131L;
	
	private String filename;
	
//	private String getRandomImageName() {
//        int i = (int) (Math.random() * 10000000);
//        return String.valueOf(i);
//    }
 
    public String getFilename() {
        return filename;
    }
     
    public void oncapture(CaptureEvent captureEvent) {
    	int i = (int) (Math.random() * 10000000);
    	filename = String.valueOf(i);
        
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
    
    public String salvarFotoCam(String id) {
    	String idc = "0";
        String idm = "0";
        
        try {
			id = DeEncrypter.getInstance().decrypt(id);
			String[] split = id.split(";");
			idc = split[0];
			idm = split[1];
		} catch (Exception e) {
		}
        
        String filePath = Constantes.FOTOS + idc + File.separator;
		String filename = FilenameUtils.getName(idm + ".jpg");
		
		//Cria a pasta se não existir 
        File dir = new File(filePath);
        if (!dir.exists()) {
        	dir.mkdirs();
        }
		
		File source = new File(this.filename);
        File target = new File(filePath+filename);
        
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
