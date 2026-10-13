package com.google.android.gms.internal.pal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzawl implements Iterator {
    private final ArrayDeque zza;
    private zzatj zzb;

    /* synthetic */ zzawl(zzatl zzatlVar, byte[] bArr) {
        if (!(zzatlVar instanceof zzawm)) {
            this.zza = null;
            this.zzb = (zzatj) zzatlVar;
            return;
        }
        zzawm zzawmVar = (zzawm) zzatlVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzawmVar.zzn());
        this.zza = arrayDeque;
        arrayDeque.push(zzawmVar);
        this.zzb = zzb(zzawmVar.zzm());
    }

    private final zzatj zzb(zzatl zzatlVar) {
        while (zzatlVar instanceof zzawm) {
            zzawm zzawmVar = (zzawm) zzatlVar;
            this.zza.push(zzawmVar);
            zzatlVar = zzawmVar.zzm();
        }
        return (zzatj) zzatlVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzatj next() {
        zzatj zzatjVarZzb;
        zzatj zzatjVar = this.zzb;
        if (zzatjVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzatjVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzatjVarZzb = zzb(((zzawm) arrayDeque.pop()).zzA());
        } while (zzatjVarZzb.zzq());
        this.zzb = zzatjVarZzb;
        return zzatjVar;
    }
}
