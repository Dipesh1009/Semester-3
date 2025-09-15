package enc;

public class RailFenceCipher extends GenEnc {
    RailFenceCipher() {
        super();
    }

    RailFenceCipher(String P) {
        super(P);
    }


    public String encrypt(String P) {
        int rails = 2; // Number of rails
        char[][] rail = new char[rails][P.length()];

        // Fill the rail matrix with newline characters
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < P.length(); j++) {
                rail[i][j] = '\n';
            }
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < P.length(); i++) {
            if (row == 0 || row == rails - 1) {
                dirDown = !dirDown;
            }
            rail[row][col++] = P.charAt(i);
            row += dirDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < P.length(); j++) {
                if (rail[i][j] != '\n') {
                    result.append(rail[i][j]);
                }
            }
        }
        return result.toString();
    }
    public String decrypt(String C) {
        int rails = 2; // Number of rails
        char[][] rail = new char[rails][C.length()];

        // Fill the rail matrix with newline characters
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < C.length(); j++) {
                rail[i][j] = '\n';
            }
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < C.length(); i++) {
            if (row == 0 || row == rails - 1) {
                dirDown = !dirDown;
            }
            rail[row][col++] = '*';
            row += dirDown ? 1 : -1;
        }

        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < C.length(); j++) {
                if (rail[i][j] == '*' && index < C.length()) {
                    rail[i][j] = C.charAt(index++);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        row = 0;
        col = 0;
        for (int i = 0; i < C.length(); i++) {
            if (row == 0 || row == rails - 1) {
                dirDown = !dirDown;
            }
            if (rail[row][col] != '\n') {
                result.append(rail[row][col++]);
            }
            row += dirDown ? 1 : -1;
        }
        return result.toString();
    }
} 
