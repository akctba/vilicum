package br.org.vilicum.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;
import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.org.vilicum.business.AlertaBC;
import br.org.vilicum.business.CultoBC;
import br.org.vilicum.business.FrequenciaBC;
import br.org.vilicum.business.MembroBC;
import br.org.vilicum.business.UsuarioBC;
import br.org.vilicum.constant.Constantes;
import br.org.vilicum.domain.Alerta;
import br.org.vilicum.util.CustomDate;
import br.org.vilicum.util.Validator;

@ViewController
public class GeralView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5763468287537867495L;

	@Inject
	private Logger logger;
	
	@SuppressWarnings("unused")
	@Inject
	private UsuarioBC usuarioBC;
	
	@Inject
	private MembroBC membroBC;
	
	@Inject
	private AlertaBC alertaBC;
	
	@Inject
	private CultoBC cultoBC;
	
	@Inject
	private SecurityContext securityContext;
	
	@Inject
	private FrequenciaBC freqBC;
	
	private PieChartModel membros1;
	
	private CartesianChartModel frequencia = null;
	
	private MeterGaugeChartModel qualidade;
	private MeterGaugeChartModel atualiza;
	
	
	private Long comungantes;
	private Long naocomungantes;
	//private Long cultos;
	private BigDecimal cadastro;
	private BigDecimal validade;
	
	private Long visitantes;
	
	private List<Alerta> alertas;
	
	@PostConstruct
    public void init() {
        createMembros1();
        cadastro = membroBC.percCadastro();
        
        BigDecimal cem = BigDecimal.valueOf(100);
        validade = cem.subtract(membroBC.validadeCadastro());
    }

	private void createMembros1() {
		membros1 = new PieChartModel();
		
		Map<String, Number> qtdAtivosComungantes = membroBC.qtdAtivosComungantes();
		
		if (qtdAtivosComungantes!=null) {
			comungantes = qtdAtivosComungantes.get(Constantes.COMUNGANTES).longValue();
			naocomungantes = qtdAtivosComungantes.get(Constantes.NAO_COMUNGANTES).longValue();
		}
		
		membros1.setData(qtdAtivosComungantes);
	}

	public PieChartModel getMembros1() {
		return membros1;
	}

	public void setMembros1(PieChartModel membros1) {
		this.membros1 = membros1;
	}

	public List<Alerta> getAlertas() {
		alertas = alertaBC.findAtivos();
		return alertas;
	}

	public void setAlertas(List<Alerta> alertas) {
		this.alertas = alertas;
	}

	public CartesianChartModel getFrequencia() {
		if (frequencia == null) {
			frequencia = new CartesianChartModel();
			
			List<Integer> periodo = freqBC.periodo(3);
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
		
		return frequencia;
	}

	public Long getComungantes() {
		return comungantes;
	}

	public void setComungantes(Long comungantes) {
		this.comungantes = comungantes;
	}

	public Long getNaocomungantes() {
		return naocomungantes;
	}

	public void setNaocomungantes(Long naocomungantes) {
		this.naocomungantes = naocomungantes;
	}

	public Long getCultos() {
		int ano = CustomDate.getYear();
		return cultoBC.contaCultosAno(ano);
	}

	public String getCadastro() {
		//BigDecimal cadastro = membroBC.percCadastro();
		
		return String.format("%.0f", cadastro);
	}

	@SuppressWarnings("serial")
	public MeterGaugeChartModel getQualidade() {
		
		
		List<Number> intervals = new ArrayList<Number>(){{
            add(30);
            //add(50);
            add(90);
            add(100);
		}};
		
		List<Number> ticks = new ArrayList<Number>(){{
			add(0); add(10);
            add(20);
            add(30);
            add(40);
            add(50);
            add(60);
            add(70);
            add(80);
            add(90); add(100);
		}};
		
		qualidade = new MeterGaugeChartModel(cadastro, intervals, ticks);
		
		return qualidade;
	}

	public MeterGaugeChartModel getAtualiza() {
		//BigDecimal validade = membroBC.validadeCadastro();
		
		List<Number> intervals = new ArrayList<Number>(){{
            add(20);
            //add(50);
            add(80);
            add(100);
		}};
		
		List<Number> ticks = new ArrayList<Number>(){{
			add(0); add(10);
            add(20);
            add(30);
            add(40);
            add(50);
            add(60);
            add(70);
            add(80);
            add(90); add(100);
		}};
		
		atualiza = new MeterGaugeChartModel(validade, intervals, ticks);
		
		return atualiza;
	}

	public Long getVisitantes() {
		return getVisitantes(0);
	}
	
	/**
	 * Visitantes ano
	 * @param dif qtd de anos anteriores ao atual
	 * @return
	 */
	public Long getVisitantes(int dif) {
		if(this.visitantes == null) {
			int ano = CustomDate.getYear();
			visitantes = cultoBC.contaVisitantesAno(ano-dif);
		}
		return visitantes;
	}

	public void setVisitantes(Long visitantes) {
		this.visitantes = visitantes;
	}
	
	public String getValidade() {
		return String.format("%.0f", validade);
	}

	public void setValidade(BigDecimal validade) {
		this.validade = validade;
	}
	
}
