package Resources;

import com.example.e_mazing.R;

public class EncryptionDetails {

    public static String aesTitle(){
        return "AES (Advanced Encryption Standard)";
    }

    public static String aesDescription(){
        return "The Advanced Encryption Standard (AES) is a symmetric encryption algorithm " +
                "widely used across the globe to secure data. Established by the National " +
                "Institute of Standards and Technology (NIST) in 2001, AES is a robust and " +
                "efficient encryption standard that replaced the older Data Encryption " +
                "Standard (DES).";
    }

    public static String aesFeatures(){
        return "• Symmetric Encryption: AES uses the same key for both encryption and decryption, making key management crucial.  Both parties must securely share and store the key.\n\n" +
                "• Block Cipher: AES processes data in fixed-size blocks of 128 bits. If the data exceeds this size, it is divided into multiple blocks.\n\n" +
                "• Key Sizes: AES supports three key lengths: 128, 192, and 256 bits. Longer keys offer higher security but may require more processing power.\n\n" +
                "• Structure: AES operates through a series of rounds, involving substitutions, permutations, and mixing of the input data. The number of rounds varies by key length:\n" +
                "\t- 10 rounds for 128-bit keys\n" +
                "\t- 12 rounds for 192-bit keys\n" +
                "\t- 14 rounds for 256-bit keys\n\n" +
                "• Efficiency: AES is designed for speed and efficiency, making it suitable for both hardware and software implementations.";
    }

}
