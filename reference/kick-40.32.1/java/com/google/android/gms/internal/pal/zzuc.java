package com.google.android.gms.internal.pal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzuc implements zzuh {
    private final Object zza = "";

    static {
        new zzug(zzuc.class);
    }

    zzuc(Object obj) {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.zza;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException {
        timeUnit.getClass();
        return this.zza;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String string = super.toString();
        int length = String.valueOf(string).length();
        String str = (String) this.zza;
        StringBuilder sb = new StringBuilder(length + 25 + str.length() + 2);
        sb.append(string);
        sb.append("[status=SUCCESS, result=[");
        sb.append(str);
        sb.append("]]");
        return sb.toString();
    }
}
