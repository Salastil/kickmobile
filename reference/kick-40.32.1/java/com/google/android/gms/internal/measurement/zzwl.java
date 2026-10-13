package com.google.android.gms.internal.measurement;

import androidx.collection.SimpleArrayMap;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzwl {
    private static final zzwj zza = zzwj.zza(Boolean.class);

    @Nullable
    private final zzwl zzb;
    private final SimpleArrayMap zzc;
    private boolean zzd = false;

    /* synthetic */ zzwl(zzwl zzwlVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        if (zzwlVar != null) {
            Preconditions.checkArgument(zzwlVar.zzd);
        }
        this.zzb = zzwlVar;
        this.zzc = simpleArrayMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static zzwl zza(zzwl zzwlVar, zzwl zzwlVar2) {
        if (zzwlVar.zzc()) {
            return zzwlVar2;
        }
        if (zzwlVar2.zzc()) {
            return zzwlVar;
        }
        ImmutableSet<zzwl> immutableSetOf = ImmutableSet.of(zzwlVar, zzwlVar2);
        if (immutableSetOf.isEmpty()) {
            return zzwk.zza;
        }
        if (immutableSetOf.size() == 1) {
            return (zzwl) immutableSetOf.iterator().next();
        }
        int size = 0;
        for (zzwl zzwlVar3 : immutableSetOf) {
            do {
                size += zzwlVar3.zzc.getSize();
                zzwlVar3 = zzwlVar3.zzb;
            } while (zzwlVar3 != null);
        }
        if (size == 0) {
            return zzwk.zza;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap(size);
        for (zzwl zzwlVar4 : immutableSetOf) {
            do {
                int i = 0;
                while (true) {
                    SimpleArrayMap simpleArrayMap2 = zzwlVar4.zzc;
                    if (i >= simpleArrayMap2.getSize()) {
                        break;
                    }
                    Preconditions.checkArgument(simpleArrayMap.put((zzwj) simpleArrayMap2.keyAt(i), simpleArrayMap2.valueAt(i)) == null, "Duplicate bindings: %s", simpleArrayMap2.keyAt(i));
                    i++;
                }
                zzwlVar4 = zzwlVar4.zzb;
            } while (zzwlVar4 != null);
        }
        return new zzwk(null, simpleArrayMap, 0 == true ? 1 : 0).zzb();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SpanExtras<");
        for (zzwl zzwlVar = this; zzwlVar != null; zzwlVar = zzwlVar.zzb) {
            for (int i = 0; i < zzwlVar.zzc.getSize(); i++) {
                sb.append("[");
                sb.append(this.zzc.valueAt(i));
                sb.append("], ");
            }
        }
        sb.append(">");
        return sb.toString();
    }

    final zzwl zzb() {
        if (this.zzd) {
            throw new IllegalStateException("Already frozen");
        }
        this.zzd = true;
        zzwl zzwlVar = this.zzb;
        return (zzwlVar == null || !this.zzc.isEmpty()) ? this : zzwlVar;
    }

    public final boolean zzc() {
        return this == zzwk.zza;
    }

    final boolean zzd(zzwj zzwjVar) {
        if (this.zzc.containsKey(zzwjVar)) {
            return true;
        }
        zzwl zzwlVar = this.zzb;
        return zzwlVar != null && zzwlVar.zzd(zzwjVar);
    }

    final boolean zze() {
        return this.zzd;
    }

    final /* synthetic */ SimpleArrayMap zzg() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzd;
    }
}
