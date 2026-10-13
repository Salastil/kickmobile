package com.google.android.gms.internal.pal;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzawk {
    static final /* synthetic */ zzatl zza(zzatl zzatlVar, zzatl zzatlVar2, ArrayDeque arrayDeque) {
        zzb(zzatlVar, arrayDeque);
        zzb(zzatlVar2, arrayDeque);
        zzatl zzawmVar = (zzatl) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zzawmVar = new zzawm((zzatl) arrayDeque.pop(), zzawmVar, null);
        }
        return zzawmVar;
    }

    private static final void zzb(zzatl zzatlVar, ArrayDeque arrayDeque) {
        byte[] bArr;
        if (!zzatlVar.zzo()) {
            if (!(zzatlVar instanceof zzawm)) {
                String strValueOf = String.valueOf(zzatlVar.getClass());
                String.valueOf(strValueOf);
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(strValueOf)));
            }
            zzawm zzawmVar = (zzawm) zzatlVar;
            zzb(zzawmVar.zzm(), arrayDeque);
            zzb(zzawmVar.zzA(), arrayDeque);
            return;
        }
        int iZzc = zzc(zzatlVar.zzb(), arrayDeque);
        int iZzl = zzawm.zzl(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzatl) arrayDeque.peek()).zzb() >= iZzl) {
            arrayDeque.push(zzatlVar);
            return;
        }
        int iZzl2 = zzawm.zzl(iZzc);
        zzatl zzawmVar2 = (zzatl) arrayDeque.pop();
        while (true) {
            bArr = null;
            if (arrayDeque.isEmpty() || ((zzatl) arrayDeque.peek()).zzb() >= iZzl2) {
                break;
            } else {
                zzawmVar2 = new zzawm((zzatl) arrayDeque.pop(), zzawmVar2, bArr);
            }
        }
        zzawm zzawmVar3 = new zzawm(zzawmVar2, zzatlVar, bArr);
        while (!arrayDeque.isEmpty()) {
            if (((zzatl) arrayDeque.peek()).zzb() >= zzawm.zzl(zzc(zzawmVar3.zzb(), arrayDeque) + 1)) {
                break;
            } else {
                zzawmVar3 = new zzawm((zzatl) arrayDeque.pop(), zzawmVar3, bArr);
            }
        }
        arrayDeque.push(zzawmVar3);
    }

    private static final int zzc(int i, ArrayDeque arrayDeque) {
        int iBinarySearch = Arrays.binarySearch(zzawm.zzb, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }
}
