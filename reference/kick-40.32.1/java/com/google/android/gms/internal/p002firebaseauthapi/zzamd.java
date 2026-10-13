package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public class zzamd extends IOException {
    private boolean zza;

    static zzamg zza() {
        return new zzamg("Protocol message tag had invalid wire type.");
    }

    static zzamd zzb() {
        return new zzamd("Protocol message end-group tag did not match expected tag.");
    }

    static zzamd zzc() {
        return new zzamd("Protocol message contained an invalid tag (zero).");
    }

    static zzamd zzd() {
        return new zzamd("Protocol message had invalid UTF-8.");
    }

    static zzamd zze() {
        return new zzamd("CodedInputStream encountered a malformed varint.");
    }

    static zzamd zzf() {
        return new zzamd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzamd zzg() {
        return new zzamd("Failed to parse the message.");
    }

    static zzamd zzh() {
        return new zzamd("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    static zzamd zzi() {
        return new zzamd("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    static zzamd zzj() {
        return new zzamd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public zzamd(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzamd(String str) {
        super(str);
    }

    public zzamd(String str, IOException iOException) {
        super(str, iOException);
    }

    final void zzk() {
        this.zza = true;
    }

    final boolean zzl() {
        return this.zza;
    }
}
