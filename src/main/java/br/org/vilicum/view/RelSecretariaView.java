package br.org.vilicum.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.org.vilicum.business.CultoBC;
import br.org.vilicum.business.FrequenciaBC;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.constant.Constantes;
import br.org.vilicum.pojo.Movimento;
import br.org.vilicum.util.CustomDate;
import br.org.vilicum.util.Validator;

@ViewController
public class RelSecretariaView implements Serializable {

	private static final long serialVersionUID = 5763468287537867495L;

	@Inject
	private MembroBC membroBC;
	
	@Inject
	private CultoBC cultoBC;
	
	@Inject
	private FrequenciaBC freqBC;
	
	@Inject
	private ResourceBundle bundle;
	
	private PieChartModel membros1;
	
	private CartesianChartModel frequencia = null;
	
	private CartesianChartModel participacao = null;
	
	private List<Resumo> resumo = null;

	private long ano1, ano2, ano3;
	
	private Date de, ate;
	
	private List<Movimento> entradas;
	private List<Movimento> saidas;
	
	//private boolean mensal = true;
	
//	public boolean isMensal() {
//		return mensal;
//	}
//
//	public void setMensal(boolean mensal) {
//		this.mensal = mensal;
//	}

	@PostConstruct
    public void init() {
		Date curr = CustomDate.getCurrentDate();
		Date dti = CustomDate.getFirstDay(curr).getTime();
		Date dtf = CustomDate.getLastDay(curr).getTime();
		
		setting(dti, dtf);
    }
	
	private void setting(Date dti, Date dtf) {
		this.de = dti;
		this.ate = dtf;
		
		frequencia();
		
        createMembros1();
        
        movimentacao();
        
        participacao();
        
        ano1 = CustomDate.getYear(dti);
		ano2 = ano1-1;
		ano3 = ano2-1;
	}

	private void frequencia() {
		if (frequencia == null) {
			frequencia = new CartesianChartModel();
			
			List<Integer> periodo = freqBC.periodo(4);
			for (int ano : periodo) {
				ChartSeries serie = new ChartSeries();
				serie.setLabel(ano+"");
				
				Map<String, Long> dAno = freqBC.frequencia(ano);
				
				serie.set("Jan", Validator.nvl(dAno.get("Jan")));
				serie.set("Fev", Validator.nvl(dAno.get("Fev")));
				serie.set("Mar", Validator.nvl(dAno.get("Mar")));
				serie.set("Abr", Validator.nvl(dAno.get("Abr")));
				serie.set("Mai", Validator.nvl(dAno.get("Mai")));
				serie.set("Jun", Validator.nvl(dAno.get("Jun")));
				serie.set("Jul", Validator.nvl(dAno.get("Jul")));
				serie.set("Ago", Validator.nvl(dAno.get("Ago")));
				serie.set("Set", Validator.nvl(dAno.get("Set")));
				serie.set("Out", Validator.nvl(dAno.get("Out")));
				serie.set("Nov", Validator.nvl(dAno.get("Nov")));
				serie.set("Dez", Validator.nvl(dAno.get("Dez")));
				frequencia.addSeries(serie);
				
			}
		}
	}

	private void participacao() {
		participacao = new CartesianChartModel();
		int mesFinal = CustomDate.getMonth(this.de);
		String mesRel = mesFinal<10?"0"+mesFinal:""+mesFinal;
		
		List<Integer> periodo = freqBC.periodo(3);
		for (int ano : periodo) {
			ChartSeries serie = new ChartSeries();
			serie.setLabel(ano+"");
			
			Date ini = CustomDate.parseDate("01/01/"+ano);
			
			Date fim = CustomDate.getLastDay(CustomDate.parseDate("10/" + mesRel + "/" + ano)).getTime();
			
			Map<String, Long> dr = freqBC.participacao(ini, fim);
			
			serie.set("0x", Validator.nvl(dr.get("0x")));
			serie.set("1x", Validator.nvl(dr.get("1x")));
			serie.set("6x", Validator.nvl(dr.get("6x")));
			serie.set("11x", Validator.nvl(dr.get("11x")));
			serie.set("16x", Validator.nvl(dr.get("16x")));
			serie.set("21x", Validator.nvl(dr.get("21x")));
			
			participacao.addSeries(serie);
			
		}
		
	}

	private void movimentacao() {
		
		Calendar firstDay = CustomDate.getCalendar(this.de);
		Calendar lastDay = CustomDate.getCalendar(this.ate);
		
		// entradas do periodo
		entradas = membroBC.entradasMes(firstDay, lastDay);
		
		// saidas do periodo
		saidas = membroBC.saidasMes(firstDay, lastDay);
		
	}

	private void createMembros1() {
		membros1 = new PieChartModel();
		
		Map<String, Number> qtdAtivosComungantes = membroBC.qtdAtivosComungantes();
		
//		if (qtdAtivosComungantes!=null) {
//			long comungantes = qtdAtivosComungantes.get(Constantes.COMUNGANTES).longValue();
//			long naocomungantes = qtdAtivosComungantes.get(Constantes.NAO_COMUNGANTES).longValue();
//		}
		
		membros1.setData(qtdAtivosComungantes);
	}
	
	public Date getDe() {
		return de;
	}

	public void setDe(Date de) {
		this.de = de;
	}

	public Date getAte() {
		return ate;
	}

	public void setAte(Date ate) {
		this.ate = ate;
	}

	public PieChartModel getMembros1() {
		return membros1;
	}

	public void setMembros1(PieChartModel membros1) {
		this.membros1 = membros1;
	}

	public CartesianChartModel getFrequencia() {
		return frequencia;
	}

	public Long getCultos() {
		int ano = CustomDate.getYear();
		return cultoBC.contaCultosAno(ano);
	}

	public String getCadastro() {
		BigDecimal cadastro = membroBC.percCadastro();
		
		return String.format("%.2f", cadastro);
	}

	/**
	 * Visitantes ano
	 * @return
	 */
	public List<Resumo> getResumo() {
		
		resumo = new ArrayList<Resumo>();
		
		//Membros
		Map<String, Number> qtdAtivosComungantes = membroBC.qtdAtivosComungantes(this.ate);
		
		long comungantes = qtdAtivosComungantes.get(Constantes.COMUNGANTES).longValue();
		long naocomungantes = qtdAtivosComungantes.get(Constantes.NAO_COMUNGANTES).longValue();
		
		long com2 = membroBC.qtdAtivosComungantes(ano2, true);
		long ncom2 = membroBC.qtdAtivosComungantes(ano2, false);
		long com3 = membroBC.qtdAtivosComungantes(ano3, true);
		long ncom3 = membroBC.qtdAtivosComungantes(ano3, false);
		
		Resumo mem = new Resumo();
		mem.setAssunto("Nro de membros: ");
		mem.setValor1(comungantes+naocomungantes);
		mem.setValor2(com2+ncom2);
		mem.setValor3(com3+ncom3);
		
		Resumo ofertantes = new Resumo();
		ofertantes.setAssunto("Ofertantes: ");
		ofertantes.setValor1(comungantes);
		ofertantes.setValor2(com2);
		ofertantes.setValor3(com3);
		
		Resumo criancas = new Resumo();
		criancas.setAssunto("Não ofertantes: ");
		criancas.setValor1(naocomungantes);
		criancas.setValor2(ncom2);
		criancas.setValor3(ncom3);
		
		
		resumo.add(mem);
		resumo.add(ofertantes);
		resumo.add(criancas);
		
		
		//visitantes
		Resumo vis = new Resumo();
		vis.setAssunto("Visitantes: ");
		vis.setValor1(cultoBC.contaVisitantesAno(ano1));
		vis.setValor2(cultoBC.contaVisitantesAno(ano2));
		vis.setValor3(cultoBC.contaVisitantesAno(ano3));
		resumo.add(vis);
		
		return resumo;
	}
	
	public class Resumo {
		private String assunto;
		private Long valor1, valor2, valor3;
		public String getAssunto() {
			return assunto;
		}
		public void setAssunto(String assunto) {
			this.assunto = assunto;
		}
		public Long getValor1() {
			return valor1;
		}
		public void setValor1(Long valor1) {
			this.valor1 = valor1;
		}
		public Long getValor2() {
			return valor2;
		}
		public void setValor2(Long valor2) {
			this.valor2 = valor2;
		}
		public Long getValor3() {
			return valor3;
		}
		public void setValor3(Long valor3) {
			this.valor3 = valor3;
		}
	}

	public long getAno1() {
		return ano1;
	}

	public void setAno1(long ano1) {
		this.ano1 = ano1;
	}

	public long getAno2() {
		return ano2;
	}

	public void setAno2(long ano2) {
		this.ano2 = ano2;
	}

	public long getAno3() {
		return ano3;
	}

	public void setAno3(long ano3) {
		this.ano3 = ano3;
	}

	public List<Movimento> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Movimento> entradas) {
		this.entradas = entradas;
	}

	public List<Movimento> getSaidas() {
		return saidas;
	}

	public void setSaidas(List<Movimento> saidas) {
		this.saidas = saidas;
	}

	public CartesianChartModel getParticipacao() {
		return participacao;
	}

	public void setParticipacao(CartesianChartModel participacao) {
		this.participacao = participacao;
	}

	public String getPeriodo() {
		String tx = bundle.getString("relatorio.secretaria.periodo", CustomDate.formatDate(de),
				CustomDate.formatDate(this.ate));
		
		return tx ;
	}
	
//	public String anterior() {
//		Date ndi, ndf;
//		if (this.mensal) {
//			ndi = CustomDate.addMonthsDate(this.de, -1);
//			ndf = CustomDate.getLastDay(ndi).getTime();
//		} else {
//			ndi = CustomDate.addMonthsDate(this.de, -6);
//			ndf = CustomDate.addMonthsDate(ndi, 5);
//			ndf = CustomDate.getLastDay(ndf).getTime();
//		}
//		setting(ndi, ndf);
//		return "";
//	}
	
//	public String proximo() {
//		Date ndi, ndf;
//		if (this.mensal) {
//			ndi = CustomDate.addMonthsDate(this.de, 1);
//			ndf = CustomDate.getLastDay(ndi).getTime();
//		} else {
//			ndi = CustomDate.addMonthsDate(this.de, 6);
//			ndf = CustomDate.addMonthsDate(ndi, 5);
//			ndf = CustomDate.getLastDay(ndf).getTime();
//		}
//		setting(ndi, ndf);
//		return "";
//	}
	
//	public String trocarTipo() {
//		this.mensal = !this.mensal;
//		
//		if (this.mensal) {
//			this.de = CustomDate.getFirstDay(this.de).getTime();
//			this.ate = CustomDate.getLastDay(this.de).getTime();
//		} else {
//			// semestral
//			this.de = CustomDate.getFirstDaySemester(this.de);
//			this.ate = CustomDate.getLastDaySemester(this.de);
//		}
//		
//		return "";
//	}
	
	public String pesquisar() {
		setting(this.de, this.ate);
		return "";
	}

}


