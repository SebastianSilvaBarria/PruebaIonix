package com.ionix.prueba.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.util.Base64Utils;

import jdk.internal.org.jline.utils.Log;

public class Utils {

	public static String encoder(String param) {
		
		String rutEncriptado = null;
		try {
			DESKeySpec keySpec = new DESKeySpec("ionix12456".getBytes("UTF-8"));
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			byte[] clearText = param.getBytes("UTF-8");
			Cipher cipher = Cipher.getInstance("DES");
			rutEncriptado = Base64Utils.encodeToString(clearText);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			Log.info(e);
		} catch (NoSuchAlgorithmException e) {
			Log.info(e);
			
		} catch (NoSuchPaddingException e) {
			Log.info(e);
		}
		return rutEncriptado;
	}
}
