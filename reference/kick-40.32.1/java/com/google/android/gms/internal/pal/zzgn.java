package com.google.android.gms.internal.pal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzgn {
    private final zzfb zza;
    private final String zzb;
    private final String zzc;
    private final Class[] zze;
    private volatile Method zzd = null;
    private final CountDownLatch zzf = new CountDownLatch(1);

    public zzgn(zzfb zzfbVar, String str, String str2, Class... clsArr) {
        this.zza = zzfbVar;
        this.zzb = str;
        this.zzc = str2;
        this.zze = clsArr;
        zzfbVar.zzd().submit(new zzgm(this));
    }

    private final String zzc(byte[] bArr, String str) throws UnsupportedEncodingException, zzef {
        return new String(this.zza.zzf().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zzd != null) {
            return this.zzd;
        }
        try {
            if (this.zzf.await(2L, TimeUnit.SECONDS)) {
                return this.zzd;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }

    final /* synthetic */ void zzb() {
        try {
            zzfb zzfbVar = this.zza;
            Class clsLoadClass = zzfbVar.zze().loadClass(zzc(zzfbVar.zzg(), this.zzb));
            if (clsLoadClass != null) {
                this.zzd = clsLoadClass.getMethod(zzc(zzfbVar.zzg(), this.zzc), this.zze);
            }
        } catch (zzef | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } finally {
            this.zzf.countDown();
        }
    }
}
