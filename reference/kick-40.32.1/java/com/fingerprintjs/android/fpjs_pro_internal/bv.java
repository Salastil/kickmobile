package com.fingerprintjs.android.fpjs_pro_internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.random.Random;
import kotlin.random.URandomKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/bv;", "Lcom/fingerprintjs/android/fpjs_pro_internal/ca;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bu;", "p0", "Lcom/fingerprintjs/android/fpjs_pro_internal/bt;", "p1", "", "p2", "<init>", "(Lcom/fingerprintjs/android/fpjs_pro_internal/bu;Lcom/fingerprintjs/android/fpjs_pro_internal/bt;Z)V", "", "component9", "([B)[B", "component5", "", "setPivotYN16904", "(BB)B", "", "vD14832N6715", "(BB)I", "Lcom/fingerprintjs/android/fpjs_pro_internal/bu;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bt;", "Z", "D8871"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class bv implements ca {

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    private final bu component9;

    /* JADX INFO: renamed from: setPivotYN16904, reason: from kotlin metadata */
    private final boolean component5;
    private final bt vD14832N6715;

    public bv(bu buVar, bt btVar, boolean z) {
        this.component9 = buVar;
        this.vD14832N6715 = btVar;
        this.component5 = z;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.ca
    public final byte[] component5(byte[] p0) {
        if (this.component5) {
            p0 = (byte[]) component9.vD14832N6715(this.component9.vD14832N6715(p0));
        }
        if (p0 == null) {
            return new byte[0];
        }
        boolean z = this.component5;
        byte bM13928nextUIntqCasIEU = (byte) URandomKt.m13928nextUIntqCasIEU(Random.INSTANCE, 127);
        int iM13928nextUIntqCasIEU = ((byte) URandomKt.m13928nextUIntqCasIEU(Random.INSTANCE, 127)) % 128;
        int i = iM13928nextUIntqCasIEU + 4;
        byte[] bArr = new byte[iM13928nextUIntqCasIEU + 11 + p0.length];
        bArr[0] = bM13928nextUIntqCasIEU;
        bArr[1] = setPivotYN16904(bM13928nextUIntqCasIEU, (byte) 3);
        bArr[2] = setPivotYN16904(bM13928nextUIntqCasIEU, z ? (byte) 10 : (byte) 7);
        bArr[3] = setPivotYN16904(bM13928nextUIntqCasIEU, (byte) iM13928nextUIntqCasIEU);
        byte[] bArrNextBytes = Random.INSTANCE.nextBytes(iM13928nextUIntqCasIEU);
        int length = bArrNextBytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2 + 4] = bArrNextBytes[i2];
        }
        byte[] bArrNextBytes2 = Random.INSTANCE.nextBytes(7);
        for (int i3 = 0; i3 < 7; i3++) {
            bArr[i + i3] = bArrNextBytes2[i3];
        }
        int length2 = i + bArrNextBytes2.length;
        int length3 = p0.length;
        for (int i4 = 0; i4 < length3; i4++) {
            bArr[i4 + length2] = (byte) (bArrNextBytes2[i4 % 7] ^ p0[i4]);
        }
        return bArr;
    }

    private static byte setPivotYN16904(byte p0, byte p1) {
        return UByte.m12702constructorimpl((byte) UInt.m12788constructorimpl(UInt.m12788constructorimpl(UByte.m12702constructorimpl(p0) & 255) + UInt.m12788constructorimpl(UByte.m12702constructorimpl(p1) & 255)));
    }

    private static int vD14832N6715(byte p0, byte p1) {
        return UByte.m12702constructorimpl((byte) UInt.m12788constructorimpl(UInt.m12788constructorimpl(UByte.m12702constructorimpl(p0) & 255) - UInt.m12788constructorimpl(UByte.m12702constructorimpl(p1) & 255))) & 255;
    }

    @Override // com.fingerprintjs.android.fpjs_pro_internal.ca
    public final byte[] component9(byte[] p0) {
        byte[] bArr;
        byte[] bArr2;
        byte b = p0[0];
        boolean z = true;
        int iVD14832N6715 = vD14832N6715(p0[1], b);
        int iVD14832N6716 = vD14832N6715(p0[2], b);
        if (iVD14832N6715 != 3 || !CollectionsKt.listOf((Object[]) new Integer[]{7, 10}).contains(Integer.valueOf(iVD14832N6716))) {
            bArr = new byte[0];
        } else {
            int iVD14832N6717 = vD14832N6715(p0[3], b);
            int i = iVD14832N6717 + 4;
            int i2 = iVD14832N6717 + 11;
            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(p0, i, i2);
            int length = p0.length - i2;
            bArr = new byte[length];
            int length2 = p0.length - length;
            for (int i3 = 0; i3 < length; i3++) {
                bArr[i3] = (byte) (p0[length2 + i3] ^ bArrCopyOfRange[i3 % 7]);
            }
            if (iVD14832N6716 != 10) {
            }
            Pair pair = TuplesKt.to(bArr, Boolean.valueOf(z));
            bArr2 = (byte[]) pair.component1();
            return (bArr2.length == 0 && ((Boolean) pair.component2()).booleanValue()) ? (byte[]) component9.component9(this.vD14832N6715.component5(bArr2), new byte[0]) : bArr2;
        }
        z = false;
        Pair pair2 = TuplesKt.to(bArr, Boolean.valueOf(z));
        bArr2 = (byte[]) pair2.component1();
        if (bArr2.length == 0) {
            return bArr2;
        }
    }
}
