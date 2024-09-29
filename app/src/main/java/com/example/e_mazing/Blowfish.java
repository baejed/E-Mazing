package com.example.e_mazing;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;

public class Blowfish {
    private static final String ALGORITHM = "Blowfish/CBC/PKCS5Padding";
    private static final String CHARSET = "UTF-8";
    private static final String INIT_VECTOR = "12345678"; // 8 bytes IV for Blowfish

    // Method to encrypt the message using Blowfish
    public static String encrypt(String key, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET));
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(CHARSET), "Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encrypted = cipher.doFinal(message.getBytes(CHARSET));

        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Method to decrypt the message using Blowfish
    public static String decrypt(String key, String encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(CHARSET));
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(CHARSET), "Blowfish");

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

        return new String(decrypted, CHARSET);
    }

    // To generate a random Blowfish key (Optional if you want to generate a key)
    public static String generateBlowfishKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
        keyGen.init(128); // You can specify key size between 32 and 448 bits
        SecretKey secretKey = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
