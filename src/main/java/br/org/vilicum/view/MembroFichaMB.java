package br.org.vilicum.view;

import java.io.Serializable;

import org.primefaces.model.map.MapModel;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.vilicum.domain.Membro;

@ViewController
public class MembroFichaMB implements Serializable {
	
	private static final long serialVersionUID = 2423445808313714800L;
	
	private Membro bean;
	
	private MapModel geoModel;
	
	private String centerGeoMap;

	public Membro getBean() {
		return bean;
	}
	
	

	public void setBean(Membro membro) {
		this.bean = membro;
	}

	public MapModel getGeoModel() {
		return geoModel;
	}

	public void setGeoModel(MapModel geoModel) {
		this.geoModel = geoModel;
	}

	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}
	
	

}