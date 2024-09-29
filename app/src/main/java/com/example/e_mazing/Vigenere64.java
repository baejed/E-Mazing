package com.example.e_mazing;
import java.util.*;

public class Vigenere64 {
    private static final String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static String encrypt(String key, String message) throws Exception {
        message = Base64.getEncoder().encodeToString(message.getBytes());
        key = Base64.getEncoder().encodeToString(key.getBytes());
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            if (charset.indexOf(message.charAt(i)) == -1) {
                result += message.charAt(i);
                continue;
            }

            int messageIndex = charset.indexOf(message.charAt(i));
            int keyIndex = charset.indexOf(key.charAt(i % key.length()));
            int resultIndex = (messageIndex + keyIndex + i) % charset.length();
            result += charset.charAt(resultIndex);
        }

        return result;
    }

    public static String decrypt(String key, String message) throws Exception {
        key = Base64.getEncoder().encodeToString(key.getBytes());
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            if (charset.indexOf(message.charAt(i)) == -1) {
                result += message.charAt(i);
                continue;
            }

            int messageIndex = charset.indexOf(message.charAt(i));
            int keyIndex = charset.indexOf(key.charAt(i % key.length()));
            int resultIndex = (messageIndex - keyIndex - i + charset.length()) % charset.length();
            result += charset.charAt(resultIndex);
        }

        return new String(Base64.getDecoder().decode(result)) ;
    }

    public static String generateKey() throws Exception {
        return Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
    }
}