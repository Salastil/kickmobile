package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzrp extends zzsn {
    private final List zza;

    private zzrp(InputStream inputStream, List list) {
        super(inputStream);
        this.zza = list;
    }

    @Nullable
    public static zzrp zza(List list, Uri uri, InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzsz zzszVarZza = ((zztb) it.next()).zza();
            if (zzszVarZza != null) {
                arrayList.add(zzszVarZza);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzrp(inputStream, arrayList);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            try {
                ((zzsz) it.next()).close();
            } catch (Throwable unused) {
            }
        }
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = this.in.read();
        if (i != -1) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                ((zzsz) it.next()).zza();
            }
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzsn, java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i = this.in.read(bArr);
        if (i != -1) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                ((zzsz) it.next()).zza();
            }
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.in.read(bArr, i, i2);
        if (i3 != -1) {
            Iterator it = this.zza.iterator();
            while (it.hasNext()) {
                ((zzsz) it.next()).zza();
            }
        }
        return i3;
    }
}
