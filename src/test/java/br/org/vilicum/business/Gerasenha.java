package br.org.vilicum.business;

import br.org.vilicum.security.Cripto;

public class Gerasenha {

	public static void main(String[] args) {
		String s = Cripto.randomKey();
		
		String s2 = Cripto.digest(s);
		
		System.out.println(s);
		System.out.println(s2);
		
		System.out.println(Cripto.digest("123"));
		/*
		-- senha 123
		update usuario u set u.PASSWORD = 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3'
		 */
		
	}

}
