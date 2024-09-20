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
        keyGen.init(128); 
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

    // Definir un IV constante (16 bytes para AES)
    private static final String FIXED_IV = "1234567890123456";

    public String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Convertir el IV fijo a un IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(FIXED_IV.getBytes("UTF-8"));

        // Inicializar el cifrado en modo de encriptación
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

        // Encriptar el texto plano
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));

        // Devolver el texto encriptado en Base64
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedData, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Convertir el IV fijo a un IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(FIXED_IV.getBytes("UTF-8"));

        // Inicializar el cifrado en modo de desencriptación
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

        // Decodificar el texto encriptado de Base64
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

        // Desencriptar los bytes encriptados
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convertir los bytes desencriptados de vuelta a una cadena de texto
        return new String(decryptedBytes, "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        // Aquí va el código de prueba con tu SecretKey (asegúrate de usar la misma clave)
    }

}
