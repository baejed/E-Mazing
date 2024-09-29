package com.example.e_mazing;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import java.util.*;

public class RSA {
    private static final String ALGORITHM = "RSA";

    // Method to encrypt the message using RSA
    public static String encrypt(String publicKeyStr, String message) throws Exception {
        byte[] publicBytes = Base64.getDecoder().decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypted = cipher.doFinal(message.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Method to decrypt the message using RSA
    public static String decrypt(String privateKeyStr, String encryptedMessage) throws Exception {
        byte[] privateBytes = Base64.getDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedMessage));

        return new String(decrypted);
    }

    // To generate an RSA Key Pair (Optional if you want to generate keys)
    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyGen.initialize(512); // RSA with 512-bit keys
        return keyGen.generateKeyPair();
    }

    // Utility to convert PublicKey to String
    public static String publicKeyToString(PublicKey publicKey) {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    // Utility to convert PrivateKey to String
    public static String privateKeyToString(PrivateKey privateKey) {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }
}
