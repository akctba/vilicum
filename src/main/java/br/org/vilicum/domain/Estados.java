package br.org.vilicum.domain;

public enum Estados {
	AC("Acre"),
	AL("Alagoas"),
	AP("Amapá"),
	AM("Amazonas"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	GO("Goiás"),
	ES("Espírito Santo"),
	MA("Maranhão"),
	MT("Mato Grosso"),
	MS("Mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Pará"),
	PB("Paraiba"),
	PR("Paraná"),
	PE("Pernambuco"),
	PI("Piauí"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rondônia"),
	RR("Rorâima"),
	SP("São Paulo"),
	SC("Santa Catarina"),
	SE("Sergipe"),
	TO("Tocantins");
	
	private String estado;

	Estados(String estado){
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString(){
		return estado;
	}
	
	public static Estados parseEstado(String sigla) {
		sigla = sigla.toUpperCase();
		return Estados.valueOf(sigla);
	}

}
