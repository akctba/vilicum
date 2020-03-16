package br.org.vilicum.correios;

import java.io.InputStream;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class BuscaCEP {
	
//	
//	<return>
//	    <bairro>Xaxim</bairro>
//	    <cep>81710310</cep>
//	    <cidade>Curitiba</cidade>
//	    <complemento2></complemento2>
//	    <end>Rua João Machado</end>
//	    <uf>PR</uf>
//    </return>
//	
	private String cep, bairro, cidade, complemento, endereco, uf;
	private boolean found = false;
	
	// constructor
	public BuscaCEP(String _cep) {
		
		cep = _cep;
		
		if (cep != null) {
			cep = cep.replaceAll("-", "");
		}
	}
	
	public void buscarEndereco() throws Exception {
		try {
			Unirest.setTimeouts(0, 0);
			HttpResponse<String> response = Unirest
					.post("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl")
					.header("Content-Type", "application/xml")
					.body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" \n\txmlns:cli=\"http://cliente.bean.master.sigep.bsb.correios.com.br/\">\n <soapenv:Header/>\n <soapenv:Body>\n <cli:consultaCEP>\n <cep>81710310</cep>\n </cli:consultaCEP>\n </soapenv:Body>\n</soapenv:Envelope> ")
					.asString();

			InputStream rawBody = response.getRawBody();
			
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(rawBody);
			Element root = document.getDocumentElement();
			
			this.bairro = root.getElementsByTagName("bairro").item(0).getNodeValue();
			this.cidade = root.getElementsByTagName("cidade").item(0).getNodeValue();
			this.complemento = root.getElementsByTagName("complemento2").item(0).getNodeValue();
			this.endereco = root.getElementsByTagName("end").item(0).getNodeValue();
			this.uf = root.getElementsByTagName("uf").item(0).getNodeValue();
			
			this.found = true;
		} catch (Exception e) {
			throw e;
		}
		
		
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}


	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	public boolean isFound() {
		return found;
	}
	
	

}
