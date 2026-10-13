package com.google.re2j;

/* JADX INFO: loaded from: classes8.dex */
final class Inst {
    public static final int ALT = 1;
    public static final int ALT_MATCH = 2;
    public static final int CAPTURE = 3;
    public static final int EMPTY_WIDTH = 4;
    public static final int FAIL = 5;
    public static final int MATCH = 6;
    public static final int NOP = 7;
    public static final int RUNE = 8;
    public static final int RUNE1 = 9;
    public static final int RUNE_ANY = 10;
    public static final int RUNE_ANY_NOT_NL = 11;
    int arg;
    int op;
    int out;
    int[] runes;

    static boolean isRuneOp(int i) {
        return 8 <= i && i <= 11;
    }

    Inst(int i) {
        this.op = i;
    }

    boolean matchRune(int i) {
        int[] iArr;
        int[] iArr2 = this.runes;
        if (iArr2.length == 1) {
            int i2 = iArr2[0];
            if (i == i2) {
                return true;
            }
            if ((this.arg & 1) != 0) {
                for (int iSimpleFold = Unicode.simpleFold(i2); iSimpleFold != i2; iSimpleFold = Unicode.simpleFold(iSimpleFold)) {
                    if (i == iSimpleFold) {
                        return true;
                    }
                }
            }
            return false;
        }
        int i3 = 0;
        while (true) {
            iArr = this.runes;
            if (i3 >= iArr.length || i3 > 8) {
                break;
            }
            if (i < iArr[i3]) {
                return false;
            }
            if (i <= iArr[i3 + 1]) {
                return true;
            }
            i3 += 2;
        }
        int length = iArr.length / 2;
        int i4 = 0;
        while (i4 < length) {
            int i5 = ((length - i4) / 2) + i4;
            int[] iArr3 = this.runes;
            int i6 = i5 * 2;
            if (iArr3[i6] > i) {
                length = i5;
            } else {
                if (i <= iArr3[i6 + 1]) {
                    return true;
                }
                i4 = i5 + 1;
            }
        }
        return false;
    }

    public String toString() {
        switch (this.op) {
            case 1:
                return "alt -> " + this.out + ", " + this.arg;
            case 2:
                return "altmatch -> " + this.out + ", " + this.arg;
            case 3:
                return "cap " + this.arg + " -> " + this.out;
            case 4:
                return "empty " + this.arg + " -> " + this.out;
            case 5:
                return "fail";
            case 6:
                return "match";
            case 7:
                return "nop -> " + this.out;
            case 8:
                if (this.runes == null) {
                    return "rune <null>";
                }
                StringBuilder sb = new StringBuilder("rune ");
                sb.append(escapeRunes(this.runes));
                sb.append((this.arg & 1) != 0 ? "/i" : "");
                sb.append(" -> ");
                sb.append(this.out);
                return sb.toString();
            case 9:
                return "rune1 " + escapeRunes(this.runes) + " -> " + this.out;
            case 10:
                return "any -> " + this.out;
            case 11:
                return "anynotnl -> " + this.out;
            default:
                throw new IllegalStateException("unhandled case in Inst.toString");
        }
    }

    private static String escapeRunes(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        for (int i : iArr) {
            Utils.escapeRune(sb, i);
        }
        sb.append('\"');
        return sb.toString();
    }
}
