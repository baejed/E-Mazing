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

    public static String rsaTitle() {
        return "RSA (Rivest Shamir Adleman)";
    }

    public static String rsaDescription() {
        return "RSA is a public-key encryption algorithm named after its inventors Rivest, Shamir, and Adleman. " +
                "Introduced in 1977, RSA is widely used for securing sensitive data, particularly in secure communications " +
                "and digital signatures. It is based on the mathematical difficulty of factoring large integers.";
    }

    public static String rsaFeatures() {
        return "• Asymmetric Encryption: RSA uses a pair of keys: a public key for encryption and a private key for decryption. This allows secure communication without needing to share a secret key.\n\n" +
                "• Key Sizes: RSA commonly uses key sizes of 1024, 2048, or 4096 bits. Longer keys offer greater security but at the cost of performance.\n\n" +
                "• Security: The security of RSA depends on the difficulty of factoring the product of two large prime numbers. As computational power increases, larger key sizes are required for continued security.\n\n" +
                "• Uses: RSA is often used for encrypting small amounts of data, such as the keys used in symmetric encryption, or for creating digital signatures to verify the authenticity of data.\n\n" +
                "• Performance: RSA is slower compared to symmetric algorithms like AES, making it less suitable for bulk data encryption but ideal for securing key exchanges and digital signatures.";
    }

    public static String desTitle() {
        return "DES (Data Encryption Standard)";
    }

    public static String desDescription() {
        return "The Data Encryption Standard (DES) is a symmetric encryption algorithm that was widely used from the mid-1970s until the early 2000s. " +
                "It was developed by IBM and adopted as a federal standard by the United States in 1977. Although it has been largely replaced by AES due to security concerns, " +
                "DES played a foundational role in the development of modern encryption algorithms.";
    }

    public static String desFeatures() {
        return "• Symmetric Encryption: DES uses the same key for both encryption and decryption. Secure key distribution is crucial for its operation.\n\n" +
                "• Block Cipher: DES processes data in 64-bit blocks, padding data if necessary to meet the block size requirement.\n\n" +
                "• Key Size: DES uses a 56-bit key, which is now considered too short for modern security needs, making it vulnerable to brute-force attacks.\n\n" +
                "• Structure: DES employs a 16-round Feistel network where each round applies substitution and permutation operations.\n\n" +
                "• Deprecated: Due to vulnerabilities, DES has been replaced by more secure algorithms such as AES. A variant of DES, Triple DES (3DES), is still used in some legacy systems but is also considered outdated.";
    }

    public static String blowfishTitle() {
        return "Blowfish";
    }

    public static String blowfishDescription() {
        return "Blowfish is a symmetric-key block cipher designed by Bruce Schneier in 1993. Known for its speed and effectiveness, Blowfish was " +
                "widely adopted for encryption in software applications. While not as common today due to the rise of AES, Blowfish remains notable " +
                "for its flexibility and high performance.";
    }

    public static String blowfishFeatures() {
        return "• Symmetric Encryption: Blowfish uses the same key for both encryption and decryption. Key management is critical for secure communication.\n\n" +
                "• Block Cipher: Blowfish processes data in 64-bit blocks, similar to DES. However, it allows variable-length keys from 32 to 448 bits, offering flexibility in security vs. performance.\n\n" +
                "• Key Size: Blowfish supports a wide range of key lengths, from 32 bits up to 448 bits, allowing users to adjust security based on their needs.\n\n" +
                "• Structure: Blowfish uses a 16-round Feistel network, similar to DES, but with more complex key scheduling and S-box substitutions, making it harder to attack.\n\n" +
                "• Efficiency: Blowfish is designed to be fast in both software and hardware implementations, making it suitable for a wide range of applications, particularly in the 1990s.\n\n" +
                "• Security: Although Blowfish remains secure, its 64-bit block size makes it less efficient for large datasets. Newer algorithms like AES, with a 128-bit block size, are more suitable for modern encryption needs.";
    }

    public static String v64Title() {
        return "Vigenere64";
    }

    public static String v64Description() {
        return "Vigenere64 is our experimental encryption algorithm that combines the concept of Vigenere cipher to Base64 encoding. " +
                "It is not a standard or widely known encryption algorithm but rather a hybrid of existing concepts. " +
                "If you intend to use this for encryption in practical scenarios, be cautious, as it does not provide strong security by modern cryptographic standards.";
    }

    public static String v64Features() {
        return "• Base64 Encoding: Vigenere64 combines Vigenere cipher techniques with Base64 encoding, providing an extra layer of obfuscation. The message and key are both encoded in Base64 before encryption and decoded after decryption.\n\n" +
                "• Symmetric Encryption: Like the Vigenere cipher, Vigenere64 uses a key that is repeated (or cycled) over the length of the message. The same key is used for both encryption and decryption, making key management essential.\n\n" +
                "• Variable Key Length: The key can be of any length, but during encryption, the key is cycled to match the length of the message. This allows flexibility in the key size.\n\n" +
                "• Incremental Shift: The encryption process involves shifting characters of the Base64-encoded message by the combined index of the corresponding message character and key character, plus both the position and the length of the message, making the encryption more complex.\n\n" +
                "• Non-standard Algorithm: Vigenere64 is an experimental hybrid encryption method and does not meet modern cryptographic standards. Its security relies on obfuscation rather than robust cryptographic principles, making it unsuitable for securing sensitive information.\n\n";
    }
}
