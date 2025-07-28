package enc;

public class CaeserCipher extends GenEnc {

    CaeserCipher() {
        super();
    }

    CaeserCipher(String P) {
        super(P);
    }

    public String encrypt() {
        StringBuilder encrypted = new StringBuilder();
        for (char c : P.toCharArray()) {
            c = (char) ((c - 'a' + 3) % 26 + 'a');
            encrypted.append(c);
        }
        return C = encrypted.toString().toUpperCase();
    }

    public String decrypt() {
        StringBuilder decrypted = new StringBuilder();
        for (char c : C.toLowerCase().toCharArray()) {
            int temp = c - 'a' - 3;
            if (temp >= 0) 
                c = (char) (temp % 26 + 'a');
            else 
                c = (char) ((26 + temp)  + 'a');
            decrypted.append(c);
        }
        return decrypted.toString();
    }

}
