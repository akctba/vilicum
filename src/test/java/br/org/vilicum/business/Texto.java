package br.org.vilicum.business;

import java.text.Normalizer;

public class Texto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Íves Rôger Möller";
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		  str = str.replaceAll("[^\\p{ASCII}]", "");
		System.out.println(Normalizer.normalize(str, Normalizer.Form.NFD));
		
		Float f = Float.parseFloat("123.123123123");
		System.out.println(String.format("%.2f", f));
	}

}
