package br.org.vilicum.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;

import br.org.vilicum.constant.Constantes;
import br.org.vilicum.security.DeEncrypter;

@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {
	
	private static final long serialVersionUID = -7059749879973221177L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get ID from request.
        String imageId = request.getParameter("id");
        
        String idc = "0";
        String idm = "0";
        
        try {
			imageId = DeEncrypter.getInstance().decrypt(imageId);
			String[] split = imageId.split(";");
			idc = split[0];
			idm = split[1];
		} catch (Exception e) {
		}

        // Check if ID is supplied to the request.
        if (imageId == null) {
            // Do your thing if the ID is not supplied to the request.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        String filePath = Constantes.FOTOS + idc + File.separator;
		String filename = FilenameUtils.getName(idm + ".jpg");
		File image = new File(filePath+filename);
		
		if(!image.exists()) {
			// carregar foto do anonimo
		    ServletContext scontext = request.getServletContext();
		    String arquivo = scontext.getRealPath("/images/anonimo.jpg");
			image = new File(arquivo);
		}
		
        // Init servlet response.
        response.reset();
        response.setContentType("image/jpeg");
        response.setHeader("Content-Length", String.valueOf(image.length()));

        // Write image content to response.
        Files.copy(image.toPath(), response.getOutputStream());
    }

}
