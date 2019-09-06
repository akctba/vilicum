package br.org.vilicum.business;

import br.org.vilicum.security.DeEncrypter;

public class EncripterTest {

	public static void main(String[] args) {
		
		
		String someStringValue = "1;3aaaaaaaaaaaabbbbbbbbbbbbd";
		String encrypted = DeEncrypter.getInstance().encrypt(someStringValue );
		System.out.println(encrypted);
		
		String decrypted = DeEncrypter.getInstance().decrypt(encrypted);
		System.out.println(decrypted);

	}

}
