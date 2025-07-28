package enc;

public class AdditiveCipher extends GenEnc {

    int key;

    AdditiveCipher() {
        super();
        this.key = 3; // Default key
    }
    
    AdditiveCipher(int key) {
        super();
        this.key = key;
    }

    AdditiveCipher(String P, int key) {
        super(P);
        this.key = key;
    }

    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (char c : P.toCharArray()) {
            c = (char) ((c - 'a' + key) % 26 + 'a');
            encrypted.append(c);
        }
        return C = encrypted.toString().toUpperCase();
    }

    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (char c : C.toLowerCase().toCharArray()) {
            int temp = c - 'a' - key;
            if (temp >= 0) 
                c = (char) (temp % 26 + 'a');
            else 
                c = (char) (26 + temp + 'a');
            decrypted.append(c);
        }
        return decrypted.toString();
    }

}