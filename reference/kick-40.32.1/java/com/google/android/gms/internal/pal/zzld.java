package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzld extends zzkx {
    private zzme zza = zzlc.zza;
    private zzkz zzb = null;
    private HttpURLConnection zzc;

    zzld() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        HttpURLConnection httpURLConnection = this.zzc;
        zzky.zzb();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final URLConnection zzb(final URL url, int i) throws IOException {
        final int i2 = 26624;
        this.zza = new zzme(i2) { // from class: com.google.android.gms.internal.pal.zzla
            @Override // com.google.android.gms.internal.pal.zzme
            public final /* synthetic */ Object zza() {
                return 26624;
            }
        };
        this.zzb = new zzkz() { // from class: com.google.android.gms.internal.pal.zzlb
            @Override // com.google.android.gms.internal.pal.zzkz
            public final /* synthetic */ URLConnection zza() {
                int i3 = zzku.zzb;
                return url.openConnection();
            }
        };
        Integer num = -1;
        zzky.zza(((Integer) this.zza.zza()).intValue(), num.intValue());
        zzkz zzkzVar = this.zzb;
        zzkzVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzkzVar.zza();
        this.zzc = httpURLConnection;
        return httpURLConnection;
    }
}
