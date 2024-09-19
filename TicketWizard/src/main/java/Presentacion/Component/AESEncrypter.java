/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Component;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author skevi
 */
public class AESEncrypter {
    
    private static SecretKey secretGeneratedKey;
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Puedes usar 128, 192, o 256 bits para AES
        // keyGen.generateKey();
        this.secretGeneratedKey = keyGen.generateKey();
        return keyGen.generateKey();
    }
    
    public String getSecretKey(){
        return secretKeyToString(secretGeneratedKey);
    }
    
    /**
     * 
     * @param secretKey
     * @return 
     */
    public String secretKeyToString(SecretKey secretKey) {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    /**
     * 
     * @param keyStr
     * @return 
     */
    public SecretKey stringToSecretKey(String keyStr) {
        byte[] decodedKey = Base64.getDecoder().decode(keyStr);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    /**
     * 
     * @param data
     * @param key
     * @return
     * @throws Exception 
     */

    public String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Generar IV aleatorio
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));

        // Concatenar el IV con los datos encriptados y codificar todo en Base64
        byte[] ivAndEncrypted = new byte[iv.length + encryptedBytes.length];
        System.arraycopy(iv, 0, ivAndEncrypted, 0, iv.length);
        System.arraycopy(encryptedBytes, 0, ivAndEncrypted, iv.length, encryptedBytes.length);

        return Base64.getEncoder().encodeToString(ivAndEncrypted);
    }


    /**
     * 
     * @param encryptedData
     * @param key
     * @return
     * @throws Exception 
     */
    public String decrypt(String encryptedData, SecretKey key) throws Exception {
        byte[] ivAndEncrypted = Base64.getDecoder().decode(encryptedData);

        // Extraer el IV (los primeros 16 bytes)
        byte[] iv = new byte[16];
        System.arraycopy(ivAndEncrypted, 0, iv, 0, iv.length);

        // Extraer el texto encriptado
        byte[] encryptedBytes = new byte[ivAndEncrypted.length - iv.length];
        System.arraycopy(ivAndEncrypted, iv.length, encryptedBytes, 0, encryptedBytes.length);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes, "UTF-8");
    }


}
