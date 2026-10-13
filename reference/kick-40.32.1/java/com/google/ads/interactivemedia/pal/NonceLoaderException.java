package com.google.ads.interactivemedia.pal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class NonceLoaderException extends Exception {
    private final int zza;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCodes {
        public static final int EMPTY_NONCE = 101;
        public static final int ENCRYPTION_FAILED = 204;
        public static final int FAILED_TO_LOAD_KEYSET = 203;
        public static final int INVALID_CONTEXT = 102;
        public static final int INVALID_NONCE_REQUEST = 103;
        public static final int NONCE_TOO_LONG = 104;
        public static final int PUBLIC_KEY_FAILED_TO_LOAD = 202;
        public static final int UNKNOWN_ERROR = 100;
    }

    public NonceLoaderException(int i, Exception exc) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 35);
        sb.append("NonceLoader exception, errorCode : ");
        sb.append(i);
        super(sb.toString(), exc);
        this.zza = i;
    }

    public static NonceLoaderException zza(int i) {
        return new NonceLoaderException(i, new Exception());
    }

    final int zzb() {
        return this.zza;
    }
}
