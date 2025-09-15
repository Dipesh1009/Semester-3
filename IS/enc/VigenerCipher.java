package enc;

public class VigenerCipher extends GenEnc {
    String key;

    VigenerCipher() {
        super();
        this.key = "lemon";
    }

    VigenerCipher(String P, String key) {
        super(P);
        this.key = key.toLowerCase();
    }

    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        int keyLength = key.length();
        for (int i = 0; i < P.length(); i++) {
            char pChar = P.charAt(i);
            char kChar = key.charAt(i % keyLength);
            char cChar = (char) (mod((pChar - 'a') + (kChar - 'a'), 26) + 'a');
            encrypted.append(cChar);
        }
        return C = encrypted.toString().toUpperCase();
    }

    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        int keyLength = key.length();
        for (int i = 0; i < C.length(); i++) {
            char cChar = C.charAt(i);
            char kChar = key.charAt(i % keyLength);
            char pChar = (char) (mod((cChar - 'a') - (kChar - 'a'), 26) + 'a');
            decrypted.append(pChar);
        }
        return P = decrypted.toString();
    }
    
}
