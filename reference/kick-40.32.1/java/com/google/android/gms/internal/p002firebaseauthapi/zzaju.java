package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzajt;
import com.google.android.gms.internal.p002firebaseauthapi.zzaju;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzaju<MessageType extends zzaju<MessageType, BuilderType>, BuilderType extends zzajt<MessageType, BuilderType>> implements zzamv {
    protected transient int zza = 0;

    int zzi() {
        throw new UnsupportedOperationException();
    }

    int zza(zzanl zzanlVar) {
        int iZzi = zzi();
        if (iZzi != -1) {
            return iZzi;
        }
        int iZza = zzanlVar.zza(this);
        zza(iZza);
        return iZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzamv
    public final zzakb a_() {
        try {
            zzakk zzakkVarZzb = zzakb.zzb(zzl());
            zza(zzakkVarZzb.zzb());
            return zzakkVarZzb.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    void zza(int i) {
        throw new UnsupportedOperationException();
    }

    public final void zza(OutputStream outputStream) throws IOException {
        int iZzl = zzl();
        if (iZzl > 4096) {
            iZzl = 4096;
        }
        zzalc zzalcVar = new zzalc(outputStream, iZzl);
        zza(zzalcVar);
        zzalcVar.zzb();
    }

    public final byte[] zzk() {
        try {
            int iZzl = zzl();
            byte[] bArr = new byte[iZzl];
            zzakx zzakxVar = new zzakx(bArr, 0, iZzl);
            zza(zzakxVar);
            zzakxVar.zzc();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
