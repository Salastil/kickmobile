package com.google.android.gms.internal.measurement;

import android.net.Uri;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public interface zzsx {
    String zzc();

    default InputStream zzd(Uri uri) throws IOException {
        String strZzc = zzc();
        String.valueOf(strZzc);
        throw new zzsk("openForRead not supported by ".concat(String.valueOf(strZzc)));
    }

    default boolean zze(Uri uri) throws IOException {
        String strZzc = zzc();
        String.valueOf(strZzc);
        throw new zzsk("exists not supported by ".concat(String.valueOf(strZzc)));
    }

    default File zzg(Uri uri) throws IOException {
        String strZzc = zzc();
        String strValueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzc).length() + 28 + String.valueOf(strValueOf).length());
        sb.append("Cannot convert uri to file ");
        sb.append(strZzc);
        sb.append(ServerSentEventKt.SPACE);
        sb.append(strValueOf);
        throw new zzsk(sb.toString());
    }

    default OutputStream zzj(Uri uri) throws IOException {
        String strZzc = zzc();
        String.valueOf(strZzc);
        throw new zzsk("openForWrite not supported by ".concat(String.valueOf(strZzc)));
    }

    default void zzk(Uri uri) throws IOException {
        String strZzc = zzc();
        String.valueOf(strZzc);
        throw new zzsk("deleteFile not supported by ".concat(String.valueOf(strZzc)));
    }

    default void zzl(Uri uri, Uri uri2) throws IOException {
        String strZzc = zzc();
        String.valueOf(strZzc);
        throw new zzsk("rename not supported by ".concat(String.valueOf(strZzc)));
    }
}
