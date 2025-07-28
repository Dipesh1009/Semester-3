package enc;

import java.util.Scanner;

public class MultiplicativeCipher extends GenEnc {

    int key;

    MultiplicativeCipher() {
        super();
        this.key = 3; // Default key
    }
    
    MultiplicativeCipher(int key) {
        super();
        this.key = key;
        if (!isValidKey()) {
            takeKey();
        }
    }

    MultiplicativeCipher(String P, int key) {
        super(P);
        this.key = key;
        if (!isValidKey()) {
            takeKey();
        }
    }

    boolean isValidKey() {
        return key > 0 && key < 26 && gcd(key, 26) == 1;
    }

    void takeKey() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a valid key (1-25, coprime with 26): ");
            key = sc.nextInt();
        } while (!isValidKey());
        sc.close();
    }
    
    private int findInverse(int a) {
        a = a % 26;
        for (int x = 1; x < 26; x += 2)
            if ((a * x) % 26 == 1)
                return x;
        return -1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (char c : P.toCharArray()) { 
            c = (char) (((c - 'a') * key) % 26 + 'a');
            encrypted.append(c);
        }
        return C = encrypted.toString().toUpperCase();
    }

    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        int inv = findInverse(key);
        for (char c : C.toLowerCase().toCharArray()) {
            c = (char) (((c - 'a') * inv) % 26 + 'a');
            decrypted.append(c);
        }
        return decrypted.toString();
    }
}