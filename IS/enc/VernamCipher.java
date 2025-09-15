package enc;

public class VernamCipher extends GenEnc {
    String key;

    VernamCipher() {
        super();
        this.key = "abcdefghij";
    }

    VernamCipher(String P, String key) {
        super(P);
        if (key.length() < P.length()) {
            throw new IllegalArgumentException("Key must be at least as long as the plaintext.");
        }
        this.key = key.toLowerCase();
    }

    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < P.length(); i++) {
            char pChar = P.charAt(i);
            char kChar = key.charAt(i);
            char cChar = (char) (mod((pChar - 'a') + (kChar - 'a'), 26) + 'a');
            encrypted.append(cChar);
        }
        return C = encrypted.toString().toUpperCase();
    }

    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < C.length(); i++) {
            char cChar = C.charAt(i);
            char kChar = key.charAt(i);
            char pChar = (char) (mod((cChar - 'a') - (kChar - 'a'), 26) + 'a');
            decrypted.append(pChar);
        }
        return P = decrypted.toString();
    }

    
}
