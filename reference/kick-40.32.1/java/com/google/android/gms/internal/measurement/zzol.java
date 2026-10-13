package com.google.android.gms.internal.measurement;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzol implements zzoh {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final ConcurrentMap zzb;
    private final ConcurrentMap zzc;

    public zzol() {
        new ConcurrentHashMap();
        this.zzb = new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.zzc = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.internal.measurement.zzoh
    public final void zza(zzacr zzacrVar, Set set, String str) {
        Object obj;
        zzok[] zzokVarArr;
        if (!set.isEmpty() && !this.zza.getAndSet(true)) {
            zzbu.zza().zzb(new zzoj(this, null));
        }
        final byte[] bArrZzm = zzacrVar.zzm();
        this.zzb.compute(str, new BiFunction() { // from class: com.google.android.gms.internal.measurement.zzoi
            @Override // java.util.function.BiFunction
            public final /* synthetic */ Object apply(Object obj2, Object obj3) {
                byte[] bArr = (byte[]) obj3;
                byte[] bArr2 = bArrZzm;
                return Arrays.equals(bArr, bArr2) ? bArr : bArr2;
            }
        });
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AtomicReference atomicReference = (AtomicReference) this.zzc.putIfAbsent((String) it.next(), new AtomicReference(new zzok(str, bArrZzm, null)));
            if (atomicReference != null) {
                do {
                    obj = atomicReference.get();
                    if (obj instanceof zzok) {
                        zzok zzokVar = (zzok) obj;
                        if (str.equals(zzokVar.zza())) {
                            zzokVar.zzb(bArrZzm, false);
                            break;
                        } else {
                            zzok zzokVar2 = new zzok(str, bArrZzm, null);
                            zzokVarArr = str.compareTo(zzokVar.zza()) < 0 ? new zzok[]{zzokVar2, zzokVar} : new zzok[]{zzokVar, zzokVar2};
                        }
                    } else {
                        zzok[] zzokVarArr2 = (zzok[]) obj;
                        int iBinarySearch = Arrays.binarySearch(zzokVarArr2, str);
                        if (iBinarySearch >= 0) {
                            zzokVarArr2[iBinarySearch].zzb(bArrZzm, false);
                            break;
                        }
                        int i = ~iBinarySearch;
                        int length = zzokVarArr2.length;
                        int i2 = length + 1;
                        int i3 = length - i;
                        if (i3 == 0) {
                            zzokVarArr = (zzok[]) Arrays.copyOf(zzokVarArr2, i2);
                        } else {
                            zzok[] zzokVarArr3 = new zzok[i2];
                            System.arraycopy(zzokVarArr2, 0, zzokVarArr3, 0, i);
                            System.arraycopy(zzokVarArr2, i, zzokVarArr3, i + 1, i3);
                            zzokVarArr = zzokVarArr3;
                        }
                        zzokVarArr[i] = new zzok(str, bArrZzm, null);
                    }
                } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, obj, zzokVarArr));
            }
        }
    }
}
