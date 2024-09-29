package com.example.e_mazing;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

public class DES {
    private static final String ALGORITHM = "DES/CBC/PKCS5Padding";
    private static final String CHARSET = "UTF-8";
    private static final String INIT_VECTOR = "12345678"; // 8 bytes IV for DES

    // Method to encrypt the message using DES
    public static String encrypt(String key, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET));
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKeySpec secretKey = new SecretKeySpec(decodedKey, "DES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encrypted = cipher.doFinal(message.getBytes(CHARSET));

        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Method to decrypt the message using DES
    public static String decrypt(String key, String encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET));
        byte[] decodedKey = Base64.getDecoder().decode(key);
        SecretKeySpec secretKey = new SecretKeySpec(decodedKey, "DES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

        return new String(decrypted, CHARSET);
    }

    // To generate a random DES key (Optional if you want to generate a key)
    public static String generateDESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56); // DES uses a 56-bit key
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}