package enc;

import java.util.Scanner;

public class CipherDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        
        System.out.print("Enter key for Cipher: ");
        int key = scanner.nextInt();
        CaeserCipher caesarCipher = new CaeserCipher(plaintext);
        String caesarEncrypted = caesarCipher.encrypt();
        String caesarDecrypted = caesarCipher.decrypt();
        
        System.out.println("Caesar Cipher Encrypted: " + caesarEncrypted);
        System.out.println("Caesar Cipher Decrypted: " + caesarDecrypted);
        
        AdditiveCipher additiveCipher = new AdditiveCipher(plaintext, key);
        String additiveEncrypted = additiveCipher.encrypt();
        String additiveDecrypted = additiveCipher.decrypt();
        
        System.out.println("Additive Cipher Encrypted: " + additiveEncrypted);
        System.out.println("Additive Cipher Decrypted: " + additiveDecrypted);
        
        MultiplicativeCipher multiplicativeCipher = new MultiplicativeCipher(plaintext, key);
        String multiplicativeEncrypted = multiplicativeCipher.encrypt();
        String multiplicativeDecrypted = multiplicativeCipher.decrypt();
        
        System.out.println("Multiplicative Cipher Encrypted: " + multiplicativeEncrypted);
        System.out.println("Multiplicative Cipher Decrypted: " + multiplicativeDecrypted);
        
        scanner.close();
    }
    
}
