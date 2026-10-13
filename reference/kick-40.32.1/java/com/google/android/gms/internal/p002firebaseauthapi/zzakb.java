package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzakb implements Serializable, Iterable<Byte> {
    public static final zzakb zza = new zzakm(zzalw.zza);
    private static final zzaki zzb = new zzakl();
    private int zzc = 0;

    static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    abstract byte zza(int i);

    public abstract int zza();

    public abstract zzakb zza(int i, int i2);

    abstract void zza(zzakc zzakcVar) throws IOException;

    protected abstract void zza(byte[] bArr, int i, int i2, int i3);

    protected abstract boolean zza(zzakb zzakbVar);

    protected abstract int zzb(int i, int i2, int i3);

    public abstract zzakn zzb();

    static int zza(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    public final int hashCode() {
        int iZzb = this.zzc;
        if (iZzb == 0) {
            int iZza = zza();
            iZzb = zzb(iZza, 0, iZza);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzc = iZzb;
        }
        return iZzb;
    }

    static zzakk zzb(int i) {
        return new zzakk(i);
    }

    public static zzakb zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzakb zza(byte[] bArr, int i, int i2) {
        try {
            return zza(bArr, i, i2, false);
        } catch (zzamd e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    static zzakb zza(byte[] bArr, int i, int i2, boolean z) throws zzamd {
        if (i2 == 0) {
            return zza;
        }
        zza(i, i + i2, bArr.length);
        return new zzakm(zzb.zza(bArr, i, i2));
    }

    static zzakb zzb(byte[] bArr) {
        try {
            return zza(bArr, false);
        } catch (zzamd e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    static zzakb zza(byte[] bArr, boolean z) throws zzamd {
        if (bArr.length == 0) {
            return zza;
        }
        return new zzakm(bArr);
    }

    public final String toString() {
        String strZza;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer numValueOf = Integer.valueOf(zza());
        if (zza() <= 50) {
            strZza = zzanw.zza(zzc());
        } else {
            strZza = zzanw.zza(zza(0, 47).zzc()) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, numValueOf, strZza);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzake(this);
    }

    static {
        new zzakd();
    }

    zzakb() {
    }

    static /* synthetic */ boolean zza(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i + i3;
        zza(i, i4, bArr.length);
        zza(i2, i3 + i2, bArr2.length);
        while (i < i4) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzakb)) {
            return false;
        }
        zzakb zzakbVar = (zzakb) obj;
        int iZza = zza();
        if (iZza != zzakbVar.zza()) {
            return false;
        }
        if (iZza == 0) {
            return true;
        }
        int i = this.zzc;
        int i2 = zzakbVar.zzc;
        if (i == 0 || i2 == 0 || i == i2) {
            return zza(zzakbVar);
        }
        return false;
    }

    public final byte[] zzc() {
        int iZza = zza();
        if (iZza == 0) {
            return zzalw.zza;
        }
        byte[] bArr = new byte[iZza];
        zza(bArr, 0, 0, iZza);
        return bArr;
    }
}
