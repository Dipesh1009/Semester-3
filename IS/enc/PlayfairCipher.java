package enc;

public class PlayfairCipher extends GenEnc {
    private char[][] matrix = new char[5][5];
    private String key;

    public PlayfairCipher(String key) {
        this.key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        generateMatrix();
    }

    private void generateMatrix() {
        boolean[] used = new boolean[26];
        used['J' - 'A'] = true; // Treat 'I' and 'J' as the same letter
        int row = 0, col = 0;

        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                matrix[row][col] = c;
                used[c - 'A'] = true;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (!used[c - 'A']) {
                matrix[row][col] = c;
                used[c - 'A'] = true;
                col++;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
    }

    private String preprocessText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            sb.append(currentChar);
            if (i + 1 < text.length() && text.charAt(i + 1) == currentChar) {
                sb.append('X'); // Insert 'X' between identical letters
            }
        }
        if (sb.length() % 2 != 0) {
            sb.append('X'); // Append 'X' if the length is odd
        }
        return sb.toString();
    }

    private int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null; // Should never happen
    }

    public String encrypt(String plaintext) {
        String processedText = preprocessText(plaintext);
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < processedText.length(); i += 2) {
            char a = processedText.charAt(i);
            char b = processedText.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) { // Same row
                ciphertext.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                ciphertext.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                ciphertext.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                ciphertext.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            } else { // Rectangle swap
                ciphertext.append(matrix[posA[0]][posB[1]]);
                ciphertext.append(matrix[posB[0]][posA[1]]);
            }
        }

        return ciphertext.toString();
    }

    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {
            char a = ciphertext.charAt(i);
            char b = ciphertext.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) { // Same row
                plaintext.append(matrix[posA[0]][(posA[1] + 4) % 5]);
                plaintext.append(matrix[posB[0]][(posB[1] + 4) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                plaintext.append(matrix[(posA[0] + 4) % 5][posA[1]]);
                plaintext.append(matrix[(posB[0] + 4) % 5][posB[1]]);
            } else { // Rectangle swap
                plaintext.append(matrix[posA[0]][posB[1]]);
                plaintext.append(matrix[posB[0]][posA[1]]);
            }
        }

        return plaintext.toString().replace("X", ""); // Remove padding 'X's
    }
}
