package com.google.android.gms.internal.measurement;

import android.net.Uri;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzrs {
    private final zzsx zza;
    private final List zzb;
    private final List zzc;
    private final Uri zzd;
    private final Uri zze;

    zzrs(zzrr zzrrVar) {
        this.zza = zzrrVar.zzf();
        this.zzb = zzrrVar.zzg();
        this.zzc = zzrrVar.zzh();
        this.zzd = zzrrVar.zzi();
        this.zze = zzrrVar.zzj();
    }

    public final zzsx zza() {
        return this.zza;
    }

    public final Uri zzb() {
        return this.zze;
    }

    public final List zzc(InputStream inputStream) throws IOException {
        zzrp zzrpVarZza;
        ArrayList arrayList = new ArrayList();
        arrayList.add(inputStream);
        List list = this.zzc;
        if (!list.isEmpty() && (zzrpVarZza = zzrp.zza(list, this.zzd, inputStream)) != null) {
            arrayList.add(zzrpVarZza);
        }
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            arrayList.add(((zztc) it.next()).zzb(this.zzd, (InputStream) Iterables.getLast(arrayList)));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public final List zzd(OutputStream outputStream) throws IOException {
        zzrq zzrqVarZza;
        ArrayList arrayList = new ArrayList();
        arrayList.add(outputStream);
        List list = this.zzc;
        if (!list.isEmpty() && (zzrqVarZza = zzrq.zza(list, this.zzd, outputStream)) != null) {
            arrayList.add(zzrqVarZza);
        }
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            arrayList.add(((zztc) it.next()).zzc(this.zzd, (OutputStream) Iterables.getLast(arrayList)));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public final boolean zze() {
        return !this.zzb.isEmpty();
    }
}
