package br.org.vilicum.util;

import java.text.Normalizer;
import java.util.Collection;

import org.alfredlibrary.validadores.Email;

public class Validator {
	
	public static boolean isEmpty (String s) {
		return (s == null || s.trim().equals(""));
	}
	
	public static boolean isEmpty (Collection c) {
		return (c == null || c.isEmpty());
	}
	
	public static String removeAcentos(String str) {
		 
	  str = Normalizer.normalize(str, Normalizer.Form.NFD);
	  str = str.replaceAll("[^\\p{ASCII}]", "");
	  return str;
	 
	}
	
	public static Long nvl(Long l) {
		return l==null?0L:l;
	}

	public static boolean email(String email) {
		return Email.isValido(email);
	}
	
}
