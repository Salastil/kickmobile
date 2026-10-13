package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzakz extends IOException {
    zzakz() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    zzakz(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }

    private zzakz(String str, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
    }

    zzakz(int i, int i2, int i3, Throwable th) {
        this(i, i2, i3, th);
    }

    private zzakz(long j, long j2, int i, Throwable th) {
        this(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)), th);
    }
}
