package enc;

import java.util.Scanner;

public class GenEnc {
    String P, C;

    GenEnc() {
        this.P = "";
    }

    GenEnc(String P) {
        this.P = P;
        stdForm();
    }

    GenEnc(GenEnc g) {
        this.P = g.P;
    }

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        this.P = sc.nextLine();
        sc.close();
        stdForm();
    }

    void stdForm() {
        String temp = "";
        for (int i = 0; i < P.length(); i++) {
            char c = P.charAt(i);
            if (Character.isAlphabetic(c)) {
                temp += Character.toLowerCase(c);
            }
        }
        this.P = temp;
    }

    int mod(int a, int m) {
        return (a % m + m) % m;
    }
}
