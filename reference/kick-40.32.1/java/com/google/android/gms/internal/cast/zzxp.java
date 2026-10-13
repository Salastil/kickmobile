package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzxp extends zzxd {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzxp.class.getName());
    private static final boolean zzd = zzaak.zza();
    Object zza;

    private zzxp() {
        throw null;
    }

    /* synthetic */ zzxp(byte[] bArr) {
    }

    public static int zzw(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzx(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zzy(String str) {
        int length;
        try {
            length = zzaam.zza(str);
        } catch (zzaal unused) {
            length = str.getBytes(zzym.zza).length;
        }
        return zzw(length) + length;
    }

    final void zzA(String str, zzaal zzaalVar) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaalVar);
        byte[] bytes = str.getBytes(zzym.zza);
        try {
            int length = bytes.length;
            zzo(length);
            zzt(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzxo(e);
        }
    }

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzg(int i, long j) throws IOException;

    public abstract void zzh(int i, boolean z) throws IOException;

    public abstract void zzi(int i, String str) throws IOException;

    public abstract void zzj(int i, zzxk zzxkVar) throws IOException;

    public abstract void zzk(int i, zzzi zzziVar) throws IOException;

    public abstract void zzl(int i, zzxk zzxkVar) throws IOException;

    public abstract void zzm(byte b) throws IOException;

    public abstract void zzn(int i) throws IOException;

    public abstract void zzo(int i) throws IOException;

    public abstract void zzp(int i) throws IOException;

    public abstract void zzq(long j) throws IOException;

    public abstract void zzr(long j) throws IOException;

    public abstract void zzt(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzv();

    public final void zzz() {
        if (zzv() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }
}
