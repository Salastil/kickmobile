package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzna implements zzrt {
    private final boolean zza;

    public zzna(boolean z) {
        this.zza = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs openContext) throws IOException {
        zznd zzndVarZzb;
        Intrinsics.checkNotNullParameter(openContext, "openContext");
        InputStream inputStreamZzc = zzst.zzc(openContext);
        try {
            InputStream inputStream = inputStreamZzc;
            int i = 4096;
            if (this.zza) {
                if (inputStream instanceof zzsf) {
                    long length = ((zzsf) inputStream).zza().length();
                    if (length == 0) {
                        i = 512;
                    } else if (length < 4096) {
                        i = (int) length;
                    }
                }
                zzndVarZzb = zznd.zzb(zzacv.zzM(inputStream, i), true);
                Intrinsics.checkNotNullExpressionValue(zzndVarZzb, "parseFrom(...)");
            } else {
                zzndVarZzb = zznd.zzb(zzacv.zzM(inputStream, 4096), false);
                Intrinsics.checkNotNullExpressionValue(zzndVarZzb, "parseFrom(...)");
            }
            CloseableKt.closeFinally(inputStreamZzc, null);
            return zzndVarZzb;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamZzc, th);
                throw th2;
            }
        }
    }
}
