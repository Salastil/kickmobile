package com.google.android.gms.cast;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.datadog.android.webview.internal.log.WebViewLogEventConsumer;
import com.google.android.gms.cast.internal.CastUtils;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzt {
    private final String zza;
    private final String zzb;
    private final Collection zzc;

    /* synthetic */ zzt(String str, String str2, Collection collection, boolean z, boolean z2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = collection;
    }

    final /* synthetic */ String zza() {
        StringBuilder sb = new StringBuilder(this.zza);
        String str = this.zzb;
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            if (!upperCase.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException("Invalid application ID: ".concat(str));
            }
            sb.append(DomExceptionUtils.SEPARATOR);
            sb.append(upperCase);
        }
        Collection<String> collection = this.zzc;
        boolean z = false;
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            boolean z2 = str != null;
            if (str == null) {
                sb.append(DomExceptionUtils.SEPARATOR);
            }
            sb.append(DomExceptionUtils.SEPARATOR);
            boolean z3 = true;
            for (String str2 : collection) {
                CastUtils.throwIfInvalidNamespace(str2);
                if (!z3) {
                    sb.append(WebViewLogEventConsumer.DDTAGS_SEPARATOR);
                }
                sb.append(CastUtils.zzc(str2));
                z3 = false;
            }
            z = z2;
        } else if (str != null) {
            z = true;
        }
        if (true != z && collection == null) {
            sb.append(DomExceptionUtils.SEPARATOR);
        }
        if (collection == null) {
            sb.append(DomExceptionUtils.SEPARATOR);
        }
        sb.append("//ALLOW_IPV6");
        return sb.toString();
    }
}
