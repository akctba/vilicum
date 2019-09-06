package br.org.vilicum.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Cripto {
	
	private static final String IV = "AAAAAAAABBBBBBB0";
	private static final String k = "0123vilicumbcdef";
	
	public static String digest(String original) {
		String senha = "";
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(original.getBytes("UTF-8"));
			 
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			senha = hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Algoritmo nao reconhecido");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Encoding nao suportado");
		}
		return senha;
	}
	
	/**
	 * Gera senha aleatória de letras e numeros;
	 * @return
	 */
	public static String randomKey() {
		java.util.Random rand = new Random();
		String cod = String.valueOf(Long.toHexString(rand.nextLong()));
		cod = cod.substring(0, 8);
		
		return cod;
	}
	
//	public static String encrypt(String textopuro) throws Exception {
//		return encrypt(textopuro, k);
//	}
//	
//	public static String encrypt(String textopuro, String chaveencriptacao) throws Exception {
//		Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
//		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
//		encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
//		byte[] doFinal = encripta.doFinal(textopuro.getBytes("UTF-8"));
//		return byteArrayToString(doFinal); 
//	}
//
//	public static String decrypt(byte[] textoencriptado) throws Exception {
//		return decrypt(textoencriptado, k);
//	}
//	
//	public static String decrypt(String textoencriptado) throws Exception {
//		if (textoencriptado != null)
//			return decrypt(stringToByteArray(textoencriptado), k);
//		return null;
//	}
//	
//	public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception {
//		Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
//		SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
//		decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
//		return new String(decripta.doFinal(textoencriptado), "UTF-8");
//	}
//
//	public static String decrypt(String encrypt, String chave) throws Exception {
//		return decrypt(encrypt.getBytes("UTF-8"), chave);
//	}
//
//	private static String byteArrayToString(byte[] byteArray) {
//		StringBuilder sb = new StringBuilder();
//		for (byte b : byteArray) {
//			int value = b & 0xFF;
//			if (value < 16)
//				sb.append("0");
//			sb.append(Integer.toString(value, 16));
//		}
//		return sb.toString();
//	}
//
//	private static byte[] stringToByteArray(String valor) {
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		try (DataOutputStream dos = new DataOutputStream(bos)) {
//			dos.writeUTF(valor);
//		} catch (Exception e) {
//			assert (false); // Nunca ocorre com ByteArrays
//		}
//		return bos.toByteArray();
//	}
	
}
