package com.google.android.gms.internal.pal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzawm extends zzatl {
    static final int[] zzb = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzatl zzd;
    private final zzatl zze;
    private final int zzf;
    private final int zzg;

    private zzawm(zzatl zzatlVar, zzatl zzatlVar2) {
        this.zzd = zzatlVar;
        this.zze = zzatlVar2;
        int iZzb = zzatlVar.zzb();
        this.zzf = iZzb;
        this.zzc = iZzb + zzatlVar2.zzb();
        this.zzg = Math.max(zzatlVar.zzn(), zzatlVar2.zzn()) + 1;
    }

    /* synthetic */ zzawm(zzatl zzatlVar, zzatl zzatlVar2, byte[] bArr) {
        this(zzatlVar, zzatlVar2);
    }

    private static zzatl zzB(zzatl zzatlVar, zzatl zzatlVar2) {
        int iZzb = zzatlVar.zzb();
        int iZzb2 = zzatlVar2.zzb();
        byte[] bArr = new byte[iZzb + iZzb2];
        zzatlVar.zzw(bArr, 0, 0, iZzb);
        zzatlVar2.zzw(bArr, 0, iZzb, iZzb2);
        return zzatl.zzt(bArr);
    }

    static zzatl zzi(zzatl zzatlVar, zzatl zzatlVar2) {
        if (zzatlVar2.zzb() == 0) {
            return zzatlVar;
        }
        if (zzatlVar.zzb() == 0) {
            return zzatlVar2;
        }
        int iZzb = zzatlVar.zzb() + zzatlVar2.zzb();
        if (iZzb < 128) {
            return zzB(zzatlVar, zzatlVar2);
        }
        if (zzatlVar instanceof zzawm) {
            zzawm zzawmVar = (zzawm) zzatlVar;
            zzatl zzatlVar3 = zzawmVar.zze;
            if (zzatlVar3.zzb() + zzatlVar2.zzb() < 128) {
                return new zzawm(zzawmVar.zzd, zzB(zzatlVar3, zzatlVar2));
            }
            zzatl zzatlVar4 = zzawmVar.zzd;
            if (zzatlVar4.zzn() > zzatlVar3.zzn() && zzawmVar.zzg > zzatlVar2.zzn()) {
                return new zzawm(zzatlVar4, new zzawm(zzatlVar3, zzatlVar2));
            }
        }
        return iZzb >= zzl(Math.max(zzatlVar.zzn(), zzatlVar2.zzn()) + 1) ? new zzawm(zzatlVar, zzatlVar2) : zzawk.zza(zzatlVar, zzatlVar2, new ArrayDeque());
    }

    static int zzl(int i) {
        int[] iArr = zzb;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.pal.zzatl, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzawj(this);
    }

    final /* synthetic */ zzatl zzA() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    final byte zza(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zza(i) : this.zze.zza(i - i2);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatl zzc(int i, int i2) {
        return zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatl zzd(int i, int i2) {
        int i3 = this.zzc;
        int iZzy = zzy(i, i2, i3);
        if (iZzy == 0) {
            return zzatl.zza;
        }
        if (iZzy == i3) {
            return this;
        }
        int i4 = this.zzf;
        if (i2 <= i4) {
            return this.zzd.zzc(i, i2);
        }
        int i5 = i2 - i4;
        if (i >= i4) {
            return this.zze.zzc(i - i4, i5);
        }
        zzatl zzatlVar = this.zzd;
        return new zzawm(zzatlVar.zzc(i, zzatlVar.zzb()), this.zze.zzc(0, i5));
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final ByteBuffer zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    final void zzg(zzate zzateVar) throws IOException {
        this.zzd.zzg(zzateVar);
        this.zze.zzg(zzateVar);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final boolean zzh(zzatl zzatlVar) {
        zzatj zzatjVarZza;
        byte[] bArr = null;
        zzawl zzawlVar = new zzawl(this, bArr);
        zzatj zzatjVarZza2 = zzawlVar.next();
        zzawl zzawlVar2 = new zzawl(zzatlVar, bArr);
        zzatj zzatjVarZza3 = zzawlVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iZzb = zzatjVarZza2.zzb() - i;
            int iZzb2 = zzatjVarZza3.zzb() - i2;
            int iMin = Math.min(iZzb, iZzb2);
            if (!(i == 0 ? zzatjVarZza2.zzi(zzatjVarZza3, i2, iMin) : zzatjVarZza3.zzi(zzatjVarZza2, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.zzc;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzb) {
                zzatjVarZza = zzawlVar.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == iZzb2) {
                zzatjVarZza2 = zzatjVarZza2;
                zzatjVarZza2 = zzatjVarZza;
                zzatjVarZza3 = zzawlVar2.next();
                i2 = 0;
            } else {
                zzatjVarZza2 = zzatjVarZza2;
                zzatjVarZza2 = zzatjVarZza;
                i2 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    public final zzatp zzk() {
        ArrayList arrayList = new ArrayList();
        byte[] bArr = null;
        zzawl zzawlVar = new zzawl(this, bArr);
        while (zzawlVar.hasNext()) {
            arrayList.add(zzawlVar.next().zzf());
        }
        int i = zzatp.zzd;
        return new zzato(new zzavc(arrayList), 4096, bArr);
    }

    final /* synthetic */ zzatl zzm() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final int zzn() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    protected final boolean zzo() {
        return this.zzc >= zzl(this.zzg);
    }

    @Override // com.google.android.gms.internal.pal.zzatl
    /* JADX INFO: renamed from: zzp */
    public final zzati iterator() {
        return new zzawj(this);
    }
}
