package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.slf4j.Marker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class zzatl implements Iterable, Serializable {
    public static final zzatl zza = new zzatk(zzauz.zzb);
    private int zzb = 0;

    static {
        int i = zzata.zza;
    }

    zzatl() {
    }

    public static zzatl zzr(byte[] bArr, int i, int i2) {
        try {
            return zzs(bArr, i, i2, false);
        } catch (zzavb e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    static zzatl zzs(byte[] bArr, int i, int i2, boolean z) throws zzavb {
        if (i2 == 0) {
            return zza;
        }
        zzy(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzatk(bArr2);
    }

    static zzatl zzt(byte[] bArr) {
        try {
            return zzu(bArr, false);
        } catch (zzavb e) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e);
        }
    }

    static zzatl zzu(byte[] bArr, boolean z) throws zzavb {
        return bArr.length == 0 ? zza : new zzatk(bArr);
    }

    public static zzatl zzv(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int iMin = 256;
        while (true) {
            byte[] bArr = new byte[iMin];
            int i = 0;
            while (i < iMin) {
                int i2 = inputStream.read(bArr, i, iMin - i);
                if (i2 == -1) {
                    break;
                }
                i += i2;
            }
            zzatl zzatlVarZzr = i == 0 ? null : zzr(bArr, 0, i);
            if (zzatlVarZzr == null) {
                break;
            }
            arrayList.add(zzatlVarZzr);
            iMin = Math.min(iMin + iMin, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? zza : zzi(arrayList.iterator(), size);
    }

    static /* synthetic */ boolean zzz(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4 = i + i3;
        zzy(i, i4, bArr.length);
        zzy(i2, i3 + i2, bArr2.length);
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
        if (!(obj instanceof zzatl)) {
            return false;
        }
        zzatl zzatlVar = (zzatl) obj;
        int iZzb = zzb();
        if (iZzb != zzatlVar.zzb()) {
            return false;
        }
        if (iZzb == 0) {
            return true;
        }
        int i = this.zzb;
        int i2 = zzatlVar.zzb;
        if (i == 0 || i2 == 0 || i == i2) {
            return zzh(zzatlVar);
        }
        return false;
    }

    public final int hashCode() {
        int iZzj = this.zzb;
        if (iZzj == 0) {
            int iZzb = zzb();
            iZzj = zzj(iZzb, 0, iZzb);
            if (iZzj == 0) {
                iZzj = 1;
            }
            this.zzb = iZzj;
        }
        return iZzj;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzb()), zzb() <= 50 ? zzaww.zza(zzx()) : zzaww.zza(zzd(0, 47).zzx()).concat("..."));
    }

    abstract byte zza(int i);

    public abstract int zzb();

    public abstract zzatl zzc(int i, int i2);

    public abstract zzatl zzd(int i, int i2);

    protected abstract void zze(byte[] bArr, int i, int i2, int i3);

    public abstract ByteBuffer zzf();

    abstract void zzg(zzate zzateVar) throws IOException;

    protected abstract boolean zzh(zzatl zzatlVar);

    protected abstract int zzj(int i, int i2, int i3);

    public abstract zzatp zzk();

    protected abstract int zzn();

    protected abstract boolean zzo();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public zzati iterator() {
        return new zzatf(this);
    }

    public final boolean zzq() {
        return zzb() == 0;
    }

    @Deprecated
    public final void zzw(byte[] bArr, int i, int i2, int i3) {
        zzy(0, i3, zzb());
        zzy(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public final byte[] zzx() {
        int iZzb = zzb();
        if (iZzb == 0) {
            return zzauz.zzb;
        }
        byte[] bArr = new byte[iZzb];
        zze(bArr, 0, 0, iZzb);
        return bArr;
    }

    private static zzatl zzi(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return (zzatl) it.next();
        }
        int i2 = i >>> 1;
        zzatl zzatlVarZzi = zzi(it, i2);
        zzatl zzatlVarZzi2 = zzi(it, i - i2);
        if (Integer.MAX_VALUE - zzatlVarZzi.zzb() >= zzatlVarZzi2.zzb()) {
            return zzawm.zzi(zzatlVarZzi, zzatlVarZzi2);
        }
        int iZzb = zzatlVarZzi.zzb();
        int iZzb2 = zzatlVarZzi2.zzb();
        StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 31 + String.valueOf(iZzb2).length());
        sb.append("ByteString would be too long: ");
        sb.append(iZzb);
        sb.append(Marker.ANY_NON_NULL_MARKER);
        sb.append(iZzb2);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzy(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i2).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(i3).length());
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
