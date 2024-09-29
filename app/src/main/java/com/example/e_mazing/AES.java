package com.example.e_mazing;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

public class AES {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String CHARSET = "UTF-8";
    private static final String INIT_VECTOR = "RandomInitVector"; // 16 bytes IV for CBC

    // Method to encrypt the message using AES
    public static String encrypt(String key, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET));
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(CHARSET), "AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encrypted = cipher.doFinal(message.getBytes(CHARSET));

        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Method to decrypt the message using AES
    public static String decrypt(String key, String encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET));
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(CHARSET), "AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

        return new String(decrypted, CHARSET);
    }

    // To generate a random AES key (Optional if you want to generate a key)
    public static String generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
