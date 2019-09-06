package br.org.vilicum.view;

import static br.org.vilicum.util.Validator.*;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.mail.Mail;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractPageBean;
import br.org.vilicum.business.UsuarioBC;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.security.Credenciais;
import br.org.vilicum.security.Cripto;
import br.org.vilicum.util.CustomDate;
import java.io.Serializable;

@ViewController
@NextView("./RecSenhaResposta.xhtml")
public class RecSenhaMB extends AbstractPageBean implements Serializable {
	
	private static final long serialVersionUID = 1317918924097335210L;

	private String email = "";
	
	private String loginrec = "";
	
	private boolean encontrado = false;
	
	private String detalhes = "";
	
	@Inject
	private Credenciais credentials;

	@Inject
	private SecurityContext securityContext;

	@Inject
	private MessageContext messageContext;
	
	@Inject
	private UsuarioBC userBC;
	
	@Inject
    private Mail mail;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEncontrado() {
		return encontrado;
	}

	public void setEncontrado(boolean encontrado) {
		this.encontrado = encontrado;
	}

	public String getLoginrec() {
		return loginrec;
	}

	public void setLoginrec(String login) {
		this.loginrec = login;
	}
	
	/**
	 * Recriar senha
	 * @return proxima página
	 */
	public String retrieve() {
		this.encontrado = false;
		if (validarFormulario()) {
			Usuario user = userBC.byIdEmail(this.loginrec, this.email);
			
			if (user != null) {
				if (CustomDate.vencida(user.getExclusao())) {
					String b = "Usuário bloqueado no sistema. Entre em contato pelo formulário Fale Conosco.";
					messageContext.add(b, SeverityType.INFO);
					detalhes += b + "<br/>";
				} else {
					Congregacao congregacao = user.getCongregacao();
					if (CustomDate.vencida(congregacao.getExclusao())) {
						String c = "Congregação bloqueada no sistema. Entre em contato pelo formulário Fale Conosco.";
						messageContext.add(c, SeverityType.INFO);
						detalhes += c + "<br/>";
					}
					
					//criar nova senha aleatoria
					String randomKey = Cripto.randomKey();
					
					//gravar nova senha
					user.setPassword(Cripto.digest(randomKey));
					user.setTrocarSenha(true);
					userBC.update(user);
					
					//enviar para o email
					mail
			            .to(this.email)
			            .from("vilicum@celsaojoao.com.br")
			            .body().html(template(this.loginrec, randomKey))
			            .subject("Vilicum - Nova senha")
			            .replyTo("nao_responder@celsaojoao.com.br")
			            .send();
					
					this.encontrado = true;
				}
			}
		}
		return getNextView();
	}

	private boolean validarFormulario() {
		boolean r = true;
		
		if (isEmpty(this.loginrec)) {
			messageContext.add("Usuário não informado", SeverityType.INFO);
			r = false;
		}
		if (isEmpty(this.email)) {
			messageContext.add("Email não informado", SeverityType.INFO);
			r = false;
		} else if (!email(this.email)) {
			messageContext.add("Email informado não está correto", SeverityType.INFO);
			r = false;
		}
		
		return r;
	}

	private String template(String usuario, String novasenha) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta charset=\"ISO-8859-1\">");
		sb.append("<title>Vilicum - nova senha</title>");
		sb.append("</head>");
		sb.append("<body style=\"background-color:#f1f1f1\">");
		sb.append("<h1>Vilicum - nova senha</h1>");
		sb.append("<p>Você solicitou uma nova senha através do formulário <i>Esqueci minha senha</i>.</p>");
		sb.append("<ul>");
		sb.append("<li><b>Usuario:</b> $usuario </li>");
		sb.append("<li><b>Nova senha:</b> $novasenha </li>");
		sb.append("</ul>");
		sb.append("<p>Ao entrar com a nova senha, o sistema irá solicitar que você realize a troca por uma senha se sua preferência.</p>");
		sb.append("<p><a href=\"http://celsaojoao.com.br/vilicum\">Acesse o sistema e troque sua senha agora mesmo.</a> </p>");
		sb.append("</body>");
		sb.append("</html>");
		
		String template = sb.toString();
		
		template = template.replaceAll("$usuario", usuario);
		template = template.replaceAll("$novasenha", novasenha);
		
		return template;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
}
