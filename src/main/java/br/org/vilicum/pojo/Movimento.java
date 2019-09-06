package br.org.vilicum.pojo;

import java.util.Date;

public class Movimento implements Comparable<Movimento> {
	
	private long idMem;
	private String membro;
	private String motivo;
	private Date datamov;
	
	public String getMembro() {
		return membro;
	}
	public void setMembro(String membro) {
		this.membro = membro;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Date getDatamov() {
		return datamov;
	}
	public void setDatamov(Date data) {
		this.datamov = data;
	}
	
	@Override
	public int compareTo(Movimento o) {
		int comp = 0;
		if (o == null) {
			return -1;
		}
		if (this.datamov != null && o.getDatamov() != null) {
			comp = this.datamov.compareTo(o.getDatamov());
			if (comp == 0) {
				comp = this.membro.compareTo(o.getMembro());
			}
		}
		return comp;
	}
	public long getIdMem() {
		return idMem;
	}
	public void setIdMem(long idMem) {
		this.idMem = idMem;
	}
}
