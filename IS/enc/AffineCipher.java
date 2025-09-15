package enc;

public class AffineCipher extends GenEnc {
    int key1, key2, inverseKey;

    AffineCipher() {
        super();
        this.key1 = 3;
        this.key2 = 3; 
        this.inverseKey = multiplicativeInverse(this.key1);
    }
    
    AffineCipher(int key1, int key2) {
        super();
        if (gcd(key1, 26) != 1) {
            throw new IllegalArgumentException("Key1 must be coprime to 26.");
        }
        this.key1 = key1;
        this.key2 = key2;
        this.inverseKey = multiplicativeInverse(key1);
    }

    AffineCipher(String P, int key1, int key2) {
        super(P);
        if (gcd(key1, 26) != 1) {
            throw new IllegalArgumentException("Key1 must be coprime to 26.");
        }
        this.key1 = key1;
        this.key2 = key2;
        this.inverseKey = multiplicativeInverse(key1);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    int multiplicativeInverse(int a) {

        a = a % 26;
        for (int x = 1; x < 26; x++) {
            if ((a * x) % 26 == 1) {
                return x;
            }
        }

        return -1;
    }

    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (char c : P.toCharArray()) {
            c = (char) (mod(((c - 'a') * key1) + key2,26)+ 'a');
            encrypted.append(c);
        }
        return C = encrypted.toString().toUpperCase();
    }

    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (char c : C.toLowerCase().toCharArray()) {
            c = (char) (mod(((c - 'a') - key2) * inverseKey,26)+ 'a');
            decrypted.append(c);
        }
        return decrypted.toString();
    }
}
