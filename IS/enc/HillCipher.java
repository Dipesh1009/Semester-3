package enc;

import enc.Mat;

public class HillCipher {
    Mat P, C, key;

    HillCipher() {
        P = new Mat();
        P.set();
        do {	
            key.set();
		} while(key.mulInv(key.det())==-1);
    }

    HillCipher(Mat P, Mat key)
    {
        if (key.mulInv(key.det())==-1)
            throw new IllegalArgumentException("Key matrix is not invertible.");
        this.P = P;
        this.key = key;
    }

    public Mat encrypt() {
        C = key.mul(P);
        return C;
    }

    public Mat decrypt() {
        Mat keyInv = key.inv();
        Mat Pdec = keyInv.mul(C);
        return Pdec;
    }
}
