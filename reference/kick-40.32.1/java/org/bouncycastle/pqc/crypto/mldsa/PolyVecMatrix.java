package org.bouncycastle.pqc.crypto.mldsa;

/* JADX INFO: loaded from: classes11.dex */
class PolyVecMatrix {
    private final PolyVecL[] matrix;

    PolyVecMatrix(MLDSAEngine mLDSAEngine) {
        int dilithiumK = mLDSAEngine.getDilithiumK();
        this.matrix = new PolyVecL[dilithiumK];
        for (int i = 0; i < dilithiumK; i++) {
            this.matrix[i] = new PolyVecL(mLDSAEngine);
        }
    }

    private String addString() {
        StringBuilder sb;
        String string = "[";
        for (int i = 0; i < this.matrix.length; i++) {
            String str = (string + "Outer Matrix " + i + " [") + this.matrix[i].toString();
            if (i == this.matrix.length - 1) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append("]\n");
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append("],\n");
            }
            string = sb.toString();
        }
        return string + "]\n";
    }

    public void expandMatrix(byte[] bArr) {
        int i = 0;
        while (true) {
            PolyVecL[] polyVecLArr = this.matrix;
            if (i >= polyVecLArr.length) {
                return;
            }
            polyVecLArr[i].uniformBlocks(bArr, i << 8);
            i++;
        }
    }

    public void pointwiseMontgomery(PolyVecK polyVecK, PolyVecL polyVecL) {
        for (int i = 0; i < this.matrix.length; i++) {
            polyVecK.getVectorIndex(i).pointwiseAccountMontgomery(this.matrix[i], polyVecL);
        }
    }

    public String toString(String str) {
        return str.concat(": \n" + addString());
    }
}
