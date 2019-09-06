package br.org.vilicum.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.org.vilicum.domain.Congregacao;
import br.org.vilicum.domain.Usuario;
import br.org.vilicum.persistence.CultoDAO;
import br.org.vilicum.util.CustomDate;

@BusinessController
public class FrequenciaBC implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3591024561358046738L;
	
	@Inject
	private CultoDAO dao;
	
	@Inject
	private SecurityContext securityContext;

	public Map<String, Long> frequencia(int ano) {
		
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		List l = dao.frequencia(ano, c);
		
		Map<String, Long> freq = new HashMap<String, Long>();
		
		if (l != null) {
			for (int i=0; i<l.size(); i++) {
				Object[] res = (Object[])l.get(i);
				int m = 0;
				try {
					m = ((Number)res[0]).intValue();
				} catch (Exception e) {}
				Long q = 0L;
				try {
					q = ((Number)res[1]).longValue();
				} catch (Exception e) {}
				
				switch (m) {
				case 1: freq.put("Jan", q); break;
				case 2: freq.put("Fev", q); break;
				case 3: freq.put("Mar", q); break;
				case 4: freq.put("Abr", q); break;
				case 5: freq.put("Mai", q); break;
				case 6: freq.put("Jun", q); break;
				case 7: freq.put("Jul", q); break;
				case 8: freq.put("Ago", q); break;
				case 9: freq.put("Set", q); break;
				case 10: freq.put("Out", q); break;
				case 11: freq.put("Nov", q); break;
				case 12: freq.put("Dez", q); break;
				default:
					break;
				}
				
			}
		}
		
		return freq;
	}

	public List<Integer> periodo(int qtd) {
		List<Integer> lista = new ArrayList<Integer>();
		int currentDate = CustomDate.getYear();
		
		for (int i=currentDate-qtd+1; i<=currentDate ; i++) {
			lista.add(i);
		}
		return lista;
	}

	public Map<String, Long> participacao(Date ini, Date fim) {
		Usuario user = (Usuario) securityContext.getUser();
		Congregacao c = user.getCongregacao();
		
		List l = dao.participacao(c, ini, fim);
		
		Map<String, Long> lista = new HashMap<String, Long>();
		
		if (l != null) {
			for (int i=0; i<l.size(); i++) {
				Object[] res = (Object[])l.get(i);
				long q = ((Number)res[0]).longValue();
				long x = ((Number)res[1]).longValue();
				
				if (q == 0) {
					lista.put("0x", x);
				} else if (q>=1 && q<=5) {
					String k = "1x";
					Long long1 = lista.get(k);
					if (long1 == null || long1 == 0) {
						long1 = x;
					} else {
						long1 += x;
					}
					lista.put(k, long1);
				} else if (q>=6 && q<=10) {
					String k = "6x";
					Long long1 = lista.get(k);
					if (long1 == null || long1 == 0) {
						long1 = x;
					} else {
						long1 += x;
					}
					lista.put(k, long1);
				} else if (q>=11 && q<=15) {
					String k = "11x";
					Long long1 = lista.get(k);
					if (long1 == null || long1 == 0) {
						long1 = x;
					} else {
						long1 += x;
					}
					lista.put(k, long1);
				} else if (q>=16 && q<=20) {
					String k = "16x";
					Long long1 = lista.get(k);
					if (long1 == null || long1 == 0) {
						long1 = x;
					} else {
						long1 += x;
					}
					lista.put(k, long1);
				} else if (q>=21) {
					String k = "21x";
					Long long1 = lista.get(k);
					if (long1 == null || long1 == 0) {
						long1 = x;
					} else {
						long1 += x;
					}
					lista.put(k, long1);
				} 
			}
		}
		
		
		return lista;
	}
	
	
}
