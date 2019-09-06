package br.org.vilicum.view;

import java.io.Serializable;

import org.alfredlibrary.utilitarios.correios.CEP;

import br.gov.frameworkdemoiselle.stereotype.ViewController;

@ViewController
public class EnderecoMB implements Serializable {
	
	private static final long serialVersionUID = 4302493219717971167L;

	private String cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
	public void buscarEndereco() {
		String[] ec = CEP.consultarEnderecoCorreios(cep);
		
		if(ec.length < 4) {
			return;
		}
		
		if (!ec[0].equals(cep)) {
			return;
		}
		
		this.logradouro = ec[1];
		this.bairro = ec[2];
		this.cidade = ec[3];
		
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	

}
