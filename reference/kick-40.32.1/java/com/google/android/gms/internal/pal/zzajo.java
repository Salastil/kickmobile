package com.google.android.gms.internal.pal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzajo extends RuntimeException {
    public zzajo(String str) {
        super(str);
    }

    public static Object zza(zzajn zzajnVar) {
        try {
            return zzajnVar.zza();
        } catch (Exception e) {
            throw new zzajo(e);
        }
    }

    public zzajo(Throwable th) {
        super(th);
    }
}
