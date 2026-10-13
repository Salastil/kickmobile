package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.eac.EACTags;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzamz<T> implements zzanl<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzaoc.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzamv zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzand zzn;
    private final zzamh zzo;
    private final zzaob<?, ?> zzp;
    private final zzalh<?> zzq;
    private final zzams zzr;

    private static int zza(byte[] bArr, int i, int i2, zzaoj zzaojVar, Class<?> cls, zzaka zzakaVar) throws IOException {
        switch (zzanc.zza[zzaojVar.ordinal()]) {
            case 1:
                int iZzd = zzajx.zzd(bArr, i, zzakaVar);
                zzakaVar.zzc = Boolean.valueOf(zzakaVar.zzb != 0);
                return iZzd;
            case 2:
                return zzajx.zza(bArr, i, zzakaVar);
            case 3:
                zzakaVar.zzc = Double.valueOf(zzajx.zza(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzakaVar.zzc = Integer.valueOf(zzajx.zzc(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzakaVar.zzc = Long.valueOf(zzajx.zzd(bArr, i));
                return i + 8;
            case 8:
                zzakaVar.zzc = Float.valueOf(zzajx.zzb(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iZzc = zzajx.zzc(bArr, i, zzakaVar);
                zzakaVar.zzc = Integer.valueOf(zzakaVar.zza);
                return iZzc;
            case 12:
            case 13:
                int iZzd2 = zzajx.zzd(bArr, i, zzakaVar);
                zzakaVar.zzc = Long.valueOf(zzakaVar.zzb);
                return iZzd2;
            case 14:
                return zzajx.zza(zzank.zza().zza(cls), bArr, i, i2, zzakaVar);
            case 15:
                int iZzc2 = zzajx.zzc(bArr, i, zzakaVar);
                zzakaVar.zzc = Integer.valueOf(zzakn.zza(zzakaVar.zza));
                return iZzc2;
            case 16:
                int iZzd3 = zzajx.zzd(bArr, i, zzakaVar);
                zzakaVar.zzc = Long.valueOf(zzakn.zza(zzakaVar.zzb));
                return iZzd3;
            case 17:
                return zzajx.zzb(bArr, i, zzakaVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final int zza(T t) {
        int i;
        int i2;
        int i3;
        zzamz<T> zzamzVar;
        T t2;
        int iZzd;
        int iZzd2;
        int iZzc;
        int iZzd3;
        int iZzd4;
        int iZzd5;
        int iZzd6;
        int iZzd7;
        int iZzd8;
        Unsafe unsafe = zzb;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 1048575;
        while (i5 < this.zzc.length) {
            int iZzc2 = this.zzc(i5);
            int i8 = (267386880 & iZzc2) >>> 20;
            int[] iArr = this.zzc;
            int i9 = iArr[i5];
            int i10 = iArr[i5 + 2];
            int i11 = i10 & 1048575;
            if (i8 <= 17) {
                if (i11 != i7) {
                    i4 = i11 == 1048575 ? 0 : unsafe.getInt(t, i11);
                    i7 = i11;
                }
                i = 1 << (i10 >>> 20);
            } else {
                i = 0;
            }
            long j = iZzc2 & 1048575;
            if (i8 >= zzaln.DOUBLE_LIST_PACKED.zza()) {
                zzaln.SINT64_LIST_PACKED.zza();
            }
            switch (i8) {
                case 0:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzd = zzaky.zzd(i9 << 3);
                        iZzc = iZzd + 8;
                        i6 += iZzc;
                    }
                    break;
                case 1:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzd2 = zzaky.zzd(i9 << 3);
                        iZzc = iZzd2 + 4;
                        i6 += iZzc;
                    }
                    break;
                case 2:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zzc(i9, unsafe.getLong(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 3:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zze(i9, unsafe.getLong(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 4:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zzf(i9, unsafe.getInt(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 5:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzd = zzaky.zzd(i9 << 3);
                        iZzc = iZzd + 8;
                        i6 += iZzc;
                    }
                    break;
                case 6:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzd2 = zzaky.zzd(i9 << 3);
                        iZzc = iZzd2 + 4;
                        i6 += iZzc;
                    }
                    break;
                case 7:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zzd(i9 << 3) + 1;
                        i6 += iZzc;
                    }
                    break;
                case 8:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        Object object = unsafe.getObject(t2, j);
                        if (object instanceof zzakb) {
                            iZzc = zzaky.zzc(i9, (zzakb) object);
                        } else {
                            iZzc = zzaky.zzb(i9, (String) object);
                        }
                        i6 += iZzc;
                    }
                    break;
                case 9:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzano.zza(i9, unsafe.getObject(t2, j), (zzanl<?>) zzamzVar.zze(i5));
                        i6 += iZzc;
                    }
                    break;
                case 10:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zzc(i9, (zzakb) unsafe.getObject(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 11:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zzh(i9, unsafe.getInt(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 12:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zze(i9, unsafe.getInt(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 13:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzd2 = zzaky.zzd(i9 << 3);
                        iZzc = iZzd2 + 4;
                        i6 += iZzc;
                    }
                    break;
                case 14:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzd = zzaky.zzd(i9 << 3);
                        iZzc = iZzd + 8;
                        i6 += iZzc;
                    }
                    break;
                case 15:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zzg(i9, unsafe.getInt(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 16:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzaky.zzd(i9, unsafe.getLong(t2, j));
                        i6 += iZzc;
                    }
                    break;
                case 17:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    if (zzamzVar.zza(t2, i5, i2, i3, i)) {
                        iZzc = zzano.zza(i9, (zzamv) unsafe.getObject(t2, j), zzamzVar.zze(i5));
                        i6 += iZzc;
                    }
                    break;
                case 18:
                    iZzd3 = zzano.zzd(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 19:
                    iZzd3 = zzano.zzc(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 20:
                    iZzd3 = zzano.zzf(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 21:
                    iZzd3 = zzano.zzj(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 22:
                    iZzd3 = zzano.zze(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 23:
                    iZzd3 = zzano.zzd(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 24:
                    iZzd3 = zzano.zzc(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 25:
                    iZzd3 = zzano.zza(i9, (List<?>) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 26:
                    iZzd3 = zzano.zzb(i9, (List) unsafe.getObject(t, j));
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 27:
                    iZzd3 = zzano.zzb(i9, (List<?>) unsafe.getObject(t, j), (zzanl<?>) this.zze(i5));
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 28:
                    iZzd3 = zzano.zza(i9, (List<zzakb>) unsafe.getObject(t, j));
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 29:
                    iZzd3 = zzano.zzi(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 30:
                    iZzd3 = zzano.zzb(i9, (List<Integer>) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 31:
                    iZzd3 = zzano.zzc(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 32:
                    iZzd3 = zzano.zzd(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 33:
                    iZzd3 = zzano.zzg(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 34:
                    iZzd3 = zzano.zzh(i9, (List) unsafe.getObject(t, j), false);
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 35:
                    iZzd4 = zzano.zzd((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 36:
                    iZzd4 = zzano.zzc((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 37:
                    iZzd4 = zzano.zzf((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 38:
                    iZzd4 = zzano.zzj((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 39:
                    iZzd4 = zzano.zze((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 40:
                    iZzd4 = zzano.zzd((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 41:
                    iZzd4 = zzano.zzc((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 42:
                    iZzd4 = zzano.zza((List<?>) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 43:
                    iZzd4 = zzano.zzi((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 44:
                    iZzd4 = zzano.zzb((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 45:
                    iZzd4 = zzano.zzc((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 46:
                    iZzd4 = zzano.zzd((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 47:
                    iZzd4 = zzano.zzg((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 48:
                    iZzd4 = zzano.zzh((List) unsafe.getObject(t, j));
                    if (iZzd4 > 0) {
                        iZzd5 = zzaky.zzd(i9 << 3);
                        iZzd6 = zzaky.zzd(iZzd4);
                        i6 += iZzd5 + iZzd6 + iZzd4;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 49:
                    iZzd3 = zzano.zza(i9, (List<zzamv>) unsafe.getObject(t, j), (zzanl<?>) this.zze(i5));
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 50:
                    iZzd3 = this.zzr.zza(i9, unsafe.getObject(t, j), this.zzf(i5));
                    i6 += iZzd3;
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 51:
                    if (this.zzc(t, i9, i5)) {
                        iZzd7 = zzaky.zzd(i9 << 3);
                        iZzd3 = iZzd7 + 8;
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 52:
                    if (this.zzc(t, i9, i5)) {
                        iZzd8 = zzaky.zzd(i9 << 3);
                        iZzd3 = iZzd8 + 4;
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 53:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zzc(i9, zzb(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 54:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zze(i9, zzb(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 55:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zzf(i9, zza(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 56:
                    if (this.zzc(t, i9, i5)) {
                        iZzd7 = zzaky.zzd(i9 << 3);
                        iZzd3 = iZzd7 + 8;
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 57:
                    if (this.zzc(t, i9, i5)) {
                        iZzd8 = zzaky.zzd(i9 << 3);
                        iZzd3 = iZzd8 + 4;
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 58:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zzd(i9 << 3) + 1;
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (this.zzc(t, i9, i5)) {
                        Object object2 = unsafe.getObject(t, j);
                        if (object2 instanceof zzakb) {
                            iZzd3 = zzaky.zzc(i9, (zzakb) object2);
                        } else {
                            iZzd3 = zzaky.zzb(i9, (String) object2);
                        }
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 60:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzano.zza(i9, unsafe.getObject(t, j), (zzanl<?>) this.zze(i5));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 61:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zzc(i9, (zzakb) unsafe.getObject(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 62:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zzh(i9, zza(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 63:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zze(i9, zza(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 64:
                    if (this.zzc(t, i9, i5)) {
                        iZzd8 = zzaky.zzd(i9 << 3);
                        iZzd3 = iZzd8 + 4;
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 65:
                    if (this.zzc(t, i9, i5)) {
                        iZzd7 = zzaky.zzd(i9 << 3);
                        iZzd3 = iZzd7 + 8;
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 66:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zzg(i9, zza(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case 67:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzaky.zzd(i9, zzb(t, j));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (this.zzc(t, i9, i5)) {
                        iZzd3 = zzano.zza(i9, (zzamv) unsafe.getObject(t, j), this.zze(i5));
                        i6 += iZzd3;
                    }
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
                default:
                    i2 = i7;
                    i3 = i4;
                    zzamzVar = this;
                    t2 = t;
                    break;
            }
            i5 += 3;
            this = zzamzVar;
            t = t2;
            i7 = i2;
            i4 = i3;
        }
        zzamz<T> zzamzVar2 = this;
        T t3 = t;
        zzaob<?, ?> zzaobVar = zzamzVar2.zzp;
        int iZza = i6 + zzaobVar.zza(zzaobVar.zzd(t3));
        if (!zzamzVar2.zzh) {
            return iZza;
        }
        zzalm<T> zzalmVarZza = zzamzVar2.zzq.zza(t3);
        int iZza2 = zzalmVarZza.zza.zza();
        int iZza3 = 0;
        for (int i12 = 0; i12 < iZza2; i12++) {
            Map.Entry entryZza = zzalmVarZza.zza.zza(i12);
            iZza3 += zzalm.zza((zzalo<?>) entryZza.getKey(), entryZza.getValue());
        }
        for (Map.Entry entry : zzalmVarZza.zza.zzb()) {
            iZza3 += zzalm.zza((zzalo<?>) entry.getKey(), entry.getValue());
        }
        return iZza + iZza3;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final int zzb(T t) {
        int i;
        int iZza;
        int length = this.zzc.length;
        int iHashCode = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int iZzc = zzc(i2);
            int i3 = (267386880 & iZzc) >>> 20;
            if (i3 <= 50 || i3 >= 69) {
                long j = 1048575 & iZzc;
                int iHashCode2 = 37;
                switch (i3) {
                    case 0:
                        i = iHashCode * 53;
                        iZza = zzalw.zza(Double.doubleToLongBits(zzaoc.zza(t, j)));
                        iHashCode = i + iZza;
                        break;
                    case 1:
                        i = iHashCode * 53;
                        iZza = Float.floatToIntBits(zzaoc.zzb(t, j));
                        iHashCode = i + iZza;
                        break;
                    case 2:
                        i = iHashCode * 53;
                        iZza = zzalw.zza(zzaoc.zzd(t, j));
                        iHashCode = i + iZza;
                        break;
                    case 3:
                        i = iHashCode * 53;
                        iZza = zzalw.zza(zzaoc.zzd(t, j));
                        iHashCode = i + iZza;
                        break;
                    case 4:
                        i = iHashCode * 53;
                        iZza = zzaoc.zzc(t, j);
                        iHashCode = i + iZza;
                        break;
                    case 5:
                        i = iHashCode * 53;
                        iZza = zzalw.zza(zzaoc.zzd(t, j));
                        iHashCode = i + iZza;
                        break;
                    case 6:
                        i = iHashCode * 53;
                        iZza = zzaoc.zzc(t, j);
                        iHashCode = i + iZza;
                        break;
                    case 7:
                        i = iHashCode * 53;
                        iZza = zzalw.zza(zzaoc.zzh(t, j));
                        iHashCode = i + iZza;
                        break;
                    case 8:
                        i = iHashCode * 53;
                        iZza = ((String) zzaoc.zze(t, j)).hashCode();
                        iHashCode = i + iZza;
                        break;
                    case 9:
                        Object objZze = zzaoc.zze(t, j);
                        if (objZze != null) {
                            iHashCode2 = objZze.hashCode();
                        }
                        iHashCode = (iHashCode * 53) + iHashCode2;
                        break;
                    case 10:
                        i = iHashCode * 53;
                        iZza = zzaoc.zze(t, j).hashCode();
                        iHashCode = i + iZza;
                        break;
                    case 11:
                        i = iHashCode * 53;
                        iZza = zzaoc.zzc(t, j);
                        iHashCode = i + iZza;
                        break;
                    case 12:
                        i = iHashCode * 53;
                        iZza = zzaoc.zzc(t, j);
                        iHashCode = i + iZza;
                        break;
                    case 13:
                        i = iHashCode * 53;
                        iZza = zzaoc.zzc(t, j);
                        iHashCode = i + iZza;
                        break;
                    case 14:
                        i = iHashCode * 53;
                        iZza = zzalw.zza(zzaoc.zzd(t, j));
                        iHashCode = i + iZza;
                        break;
                    case 15:
                        i = iHashCode * 53;
                        iZza = zzaoc.zzc(t, j);
                        iHashCode = i + iZza;
                        break;
                    case 16:
                        i = iHashCode * 53;
                        iZza = zzalw.zza(zzaoc.zzd(t, j));
                        iHashCode = i + iZza;
                        break;
                    case 17:
                        Object objZze2 = zzaoc.zze(t, j);
                        if (objZze2 != null) {
                            iHashCode2 = objZze2.hashCode();
                        }
                        iHashCode = (iHashCode * 53) + iHashCode2;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        i = iHashCode * 53;
                        iZza = zzaoc.zze(t, j).hashCode();
                        iHashCode = i + iZza;
                        break;
                    case 50:
                        i = iHashCode * 53;
                        iZza = zzaoc.zze(t, j).hashCode();
                        iHashCode = i + iZza;
                        break;
                }
            }
        }
        int i4 = this.zzm;
        while (true) {
            int[] iArr = this.zzk;
            if (i4 < iArr.length) {
                int i5 = iArr[i4];
                if (!zzc(t, 0, i5)) {
                    iHashCode = (iHashCode * 53) + zzaoc.zze(t, zzc(i5) & 1048575).hashCode();
                }
                i4++;
            } else {
                int iHashCode3 = (iHashCode * 53) + this.zzp.zzd(t).hashCode();
                return this.zzh ? (iHashCode3 * 53) + this.zzq.zza(t).hashCode() : iHashCode3;
            }
        }
    }

    private static <T> int zza(T t, long j) {
        return ((Integer) zzaoc.zze(t, j)).intValue();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 37241. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zza(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.p002firebaseauthapi.zzaka r38) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzamz.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzaka):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzb(T t, long j) {
        return ((Long) zzaoc.zze(t, j)).longValue();
    }

    private final zzaly zzd(int i) {
        return (zzaly) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:124:0x025b  */
    /* JADX WARN: Code duplicated, block: B:125:0x025e  */
    /* JADX WARN: Code duplicated, block: B:128:0x027d  */
    /* JADX WARN: Code duplicated, block: B:129:0x0280  */
    /* JADX WARN: Code duplicated, block: B:183:0x0387  */
    /* JADX WARN: Code duplicated, block: B:184:0x038a  */
    /* JADX WARN: Code duplicated, block: B:187:0x0391  */
    /* JADX WARN: Code duplicated, block: B:188:0x0394  */
    /* JADX WARN: Code duplicated, block: B:191:0x039b  */
    /* JADX WARN: Code duplicated, block: B:192:0x039e  */
    static <T> zzamz<T> zza(Class<T> cls, zzamt zzamtVar, zzand zzandVar, zzamh zzamhVar, zzaob<?, ?> zzaobVar, zzalh<?> zzalhVar, zzams zzamsVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int[] iArr;
        int i8;
        char cCharAt;
        int i9;
        int i10;
        char cCharAt2;
        int i11;
        char cCharAt3;
        int i12;
        char cCharAt4;
        int i13;
        char cCharAt5;
        int i14;
        char cCharAt6;
        int i15;
        char cCharAt7;
        int i16;
        zzanm zzanmVar;
        int i17;
        int[] iArr2;
        int i18;
        int i19;
        int i20;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        Field fieldZza;
        int i21;
        int i22;
        char cCharAt8;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Object obj;
        Field fieldZza2;
        int i29;
        Object obj2;
        Field fieldZza3;
        int i30;
        char cCharAt9;
        int i31;
        char cCharAt10;
        int i32;
        char cCharAt11;
        int i33;
        char cCharAt12;
        if (zzb == null) {
            throw new RuntimeException("Lite gencode is primarily intended for Android use and uses sun.misc.Unsafe which is not available in the current environment. To run in this environment, you may need to switch to standard gencode.");
        }
        if (zzamtVar instanceof zzanm) {
            zzanm zzanmVar2 = (zzanm) zzamtVar;
            String strZzd = zzanmVar2.zzd();
            int length = strZzd.length();
            char c = 55296;
            if (strZzd.charAt(0) >= 55296) {
                int i34 = 1;
                while (true) {
                    i = i34 + 1;
                    if (strZzd.charAt(i34) < 55296) {
                        break;
                    }
                    i34 = i;
                }
            } else {
                i = 1;
            }
            int i35 = i + 1;
            int iCharAt2 = strZzd.charAt(i);
            if (iCharAt2 >= 55296) {
                int i36 = iCharAt2 & 8191;
                int i37 = 13;
                while (true) {
                    i33 = i35 + 1;
                    cCharAt12 = strZzd.charAt(i35);
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt12 & 8191) << i37;
                    i37 += 13;
                    i35 = i33;
                }
                iCharAt2 = i36 | (cCharAt12 << i37);
                i35 = i33;
            }
            if (iCharAt2 == 0) {
                i3 = 0;
                i7 = 0;
                iCharAt = 0;
                i2 = 0;
                i6 = 0;
                i5 = 0;
                iArr = zza;
                i4 = 0;
            } else {
                int i38 = i35 + 1;
                int iCharAt3 = strZzd.charAt(i35);
                if (iCharAt3 >= 55296) {
                    int i39 = iCharAt3 & 8191;
                    int i40 = 13;
                    while (true) {
                        i15 = i38 + 1;
                        cCharAt7 = strZzd.charAt(i38);
                        if (cCharAt7 < 55296) {
                            break;
                        }
                        i39 |= (cCharAt7 & 8191) << i40;
                        i40 += 13;
                        i38 = i15;
                    }
                    iCharAt3 = i39 | (cCharAt7 << i40);
                    i38 = i15;
                }
                int i41 = i38 + 1;
                int iCharAt4 = strZzd.charAt(i38);
                if (iCharAt4 >= 55296) {
                    int i42 = iCharAt4 & 8191;
                    int i43 = 13;
                    while (true) {
                        i14 = i41 + 1;
                        cCharAt6 = strZzd.charAt(i41);
                        if (cCharAt6 < 55296) {
                            break;
                        }
                        i42 |= (cCharAt6 & 8191) << i43;
                        i43 += 13;
                        i41 = i14;
                    }
                    iCharAt4 = i42 | (cCharAt6 << i43);
                    i41 = i14;
                }
                int i44 = i41 + 1;
                int iCharAt5 = strZzd.charAt(i41);
                if (iCharAt5 >= 55296) {
                    int i45 = iCharAt5 & 8191;
                    int i46 = 13;
                    while (true) {
                        i13 = i44 + 1;
                        cCharAt5 = strZzd.charAt(i44);
                        if (cCharAt5 < 55296) {
                            break;
                        }
                        i45 |= (cCharAt5 & 8191) << i46;
                        i46 += 13;
                        i44 = i13;
                    }
                    iCharAt5 = i45 | (cCharAt5 << i46);
                    i44 = i13;
                }
                int i47 = i44 + 1;
                int iCharAt6 = strZzd.charAt(i44);
                if (iCharAt6 >= 55296) {
                    int i48 = iCharAt6 & 8191;
                    int i49 = 13;
                    while (true) {
                        i12 = i47 + 1;
                        cCharAt4 = strZzd.charAt(i47);
                        if (cCharAt4 < 55296) {
                            break;
                        }
                        i48 |= (cCharAt4 & 8191) << i49;
                        i49 += 13;
                        i47 = i12;
                    }
                    iCharAt6 = i48 | (cCharAt4 << i49);
                    i47 = i12;
                }
                int i50 = i47 + 1;
                iCharAt = strZzd.charAt(i47);
                if (iCharAt >= 55296) {
                    int i51 = iCharAt & 8191;
                    int i52 = 13;
                    while (true) {
                        i11 = i50 + 1;
                        cCharAt3 = strZzd.charAt(i50);
                        if (cCharAt3 < 55296) {
                            break;
                        }
                        i51 |= (cCharAt3 & 8191) << i52;
                        i52 += 13;
                        i50 = i11;
                    }
                    iCharAt = i51 | (cCharAt3 << i52);
                    i50 = i11;
                }
                int i53 = i50 + 1;
                int iCharAt7 = strZzd.charAt(i50);
                if (iCharAt7 >= 55296) {
                    int i54 = iCharAt7 & 8191;
                    int i55 = 13;
                    while (true) {
                        i10 = i53 + 1;
                        cCharAt2 = strZzd.charAt(i53);
                        if (cCharAt2 < 55296) {
                            break;
                        }
                        i54 |= (cCharAt2 & 8191) << i55;
                        i55 += 13;
                        i53 = i10;
                    }
                    iCharAt7 = i54 | (cCharAt2 << i55);
                    i53 = i10;
                }
                int i56 = i53 + 1;
                if (strZzd.charAt(i53) >= 55296) {
                    while (true) {
                        i9 = i56 + 1;
                        if (strZzd.charAt(i56) < 55296) {
                            break;
                        }
                        i56 = i9;
                    }
                    i56 = i9;
                }
                int i57 = i56 + 1;
                int iCharAt8 = strZzd.charAt(i56);
                if (iCharAt8 >= 55296) {
                    int i58 = iCharAt8 & 8191;
                    int i59 = 13;
                    while (true) {
                        i8 = i57 + 1;
                        cCharAt = strZzd.charAt(i57);
                        if (cCharAt < 55296) {
                            break;
                        }
                        i58 |= (cCharAt & 8191) << i59;
                        i59 += 13;
                        i57 = i8;
                    }
                    iCharAt8 = i58 | (cCharAt << i59);
                    i57 = i8;
                }
                int[] iArr3 = new int[iCharAt8 + iCharAt7 + iCharAt3];
                int i60 = (iCharAt3 << 1) + iCharAt4;
                int i61 = iCharAt7;
                i2 = iCharAt5;
                i3 = i61;
                i4 = iCharAt3;
                i35 = i57;
                i5 = iCharAt8;
                i6 = iCharAt6;
                i7 = i60;
                iArr = iArr3;
            }
            Unsafe unsafe = zzb;
            Object[] objArrZze = zzanmVar2.zze();
            Class<?> cls2 = zzanmVar2.zza().getClass();
            int[] iArr4 = new int[iCharAt * 3];
            Object[] objArr = new Object[iCharAt << 1];
            int i62 = i5 + i3;
            int i63 = i5;
            int i64 = i62;
            int i65 = 0;
            int i66 = 0;
            while (i35 < length) {
                int i67 = i35 + 1;
                int iCharAt9 = strZzd.charAt(i35);
                if (iCharAt9 >= c) {
                    int i68 = iCharAt9 & 8191;
                    int i69 = i67;
                    int i70 = 13;
                    while (true) {
                        i32 = i69 + 1;
                        cCharAt11 = strZzd.charAt(i69);
                        if (cCharAt11 < c) {
                            break;
                        }
                        i68 |= (cCharAt11 & 8191) << i70;
                        i70 += 13;
                        i69 = i32;
                    }
                    iCharAt9 = i68 | (cCharAt11 << i70);
                    i16 = i32;
                } else {
                    i16 = i67;
                }
                int i71 = i16 + 1;
                int iCharAt10 = strZzd.charAt(i16);
                if (iCharAt10 >= c) {
                    int i72 = iCharAt10 & 8191;
                    int i73 = i71;
                    int i74 = 13;
                    while (true) {
                        i31 = i73 + 1;
                        cCharAt10 = strZzd.charAt(i73);
                        zzanmVar = zzanmVar2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i72 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i73 = i31;
                        zzanmVar2 = zzanmVar;
                    }
                    iCharAt10 = i72 | (cCharAt10 << i74);
                    i17 = i31;
                } else {
                    zzanmVar = zzanmVar2;
                    i17 = i71;
                }
                int i75 = iCharAt10 & 255;
                int i76 = length;
                if ((iCharAt10 & 1024) != 0) {
                    iArr[i66] = i65;
                    i66++;
                }
                int i77 = iCharAt9;
                if (i75 >= 51) {
                    i20 = i17 + 1;
                    int iCharAt11 = strZzd.charAt(i17);
                    char c2 = 55296;
                    if (iCharAt11 >= 55296) {
                        int i78 = iCharAt11 & 8191;
                        int i79 = 13;
                        while (true) {
                            i30 = i20 + 1;
                            cCharAt9 = strZzd.charAt(i20);
                            if (cCharAt9 < c2) {
                                break;
                            }
                            i78 |= (cCharAt9 & 8191) << i79;
                            i79 += 13;
                            i20 = i30;
                            c2 = 55296;
                        }
                        iCharAt11 = i78 | (cCharAt9 << i79);
                        i20 = i30;
                    }
                    int i80 = i75 - 51;
                    int i81 = iCharAt11;
                    if (i80 == 9 || i80 == 17) {
                        i27 = i7 + 1;
                        objArr[((i65 / 3) << 1) + 1] = objArrZze[i7];
                    } else {
                        if (i80 == 12 && (zzanmVar.zzb().equals(zzanh.PROTO2) || (iCharAt10 & 2048) != 0)) {
                            i27 = i7 + 1;
                            objArr[((i65 / 3) << 1) + 1] = objArrZze[i7];
                        }
                        i28 = i81 << 1;
                        obj = objArrZze[i28];
                        if (obj instanceof Field) {
                            fieldZza2 = (Field) obj;
                        } else {
                            fieldZza2 = zza(cls2, (String) obj);
                            objArrZze[i28] = fieldZza2;
                            iArr[i64] = i65;
                            i64++;
                        }
                        iArr2 = iArr4;
                        i18 = i4;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza2);
                        i29 = i28 + 1;
                        obj2 = objArrZze[i29];
                        if (obj2 instanceof Field) {
                            fieldZza3 = (Field) obj2;
                        } else {
                            fieldZza3 = zza(cls2, (String) obj2);
                            objArrZze[i29] = fieldZza3;
                        }
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                        i19 = i7;
                    }
                    i7 = i27;
                    i28 = i81 << 1;
                    obj = objArrZze[i28];
                    if (obj instanceof Field) {
                        fieldZza2 = (Field) obj;
                    } else {
                        fieldZza2 = zza(cls2, (String) obj);
                        objArrZze[i28] = fieldZza2;
                        iArr[i64] = i65;
                        i64++;
                    }
                    iArr2 = iArr4;
                    i18 = i4;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZza2);
                    i29 = i28 + 1;
                    obj2 = objArrZze[i29];
                    if (obj2 instanceof Field) {
                        fieldZza3 = (Field) obj2;
                    } else {
                        fieldZza3 = zza(cls2, (String) obj2);
                        objArrZze[i29] = fieldZza3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza3);
                    i19 = i7;
                } else {
                    iArr2 = iArr4;
                    i18 = i4;
                    int i82 = i7 + 1;
                    Field fieldZza4 = zza(cls2, (String) objArrZze[i7]);
                    if (i75 == 9 || i75 == 17) {
                        objArr[((i65 / 3) << 1) + 1] = fieldZza4.getType();
                    } else {
                        if (i75 == 27 || i75 == 49) {
                            i23 = i7 + 2;
                            objArr[((i65 / 3) << 1) + 1] = objArrZze[i82];
                        } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                            if (zzanmVar.zzb() == zzanh.PROTO2 || (iCharAt10 & 2048) != 0) {
                                i23 = i7 + 2;
                                objArr[((i65 / 3) << 1) + 1] = objArrZze[i82];
                            }
                            int i83 = i65 + 1;
                            iArr2[i65] = i77;
                            int i84 = i65 + 2;
                            int i85 = iObjectFieldOffset;
                            if ((iCharAt10 & 512) != 0) {
                                i24 = 536870912;
                            } else {
                                i24 = 0;
                            }
                            int i86 = i24;
                            if ((iCharAt10 & 256) != 0) {
                                i25 = 268435456;
                            } else {
                                i25 = 0;
                            }
                            int i87 = i86 | i25;
                            if ((iCharAt10 & 2048) != 0) {
                                i26 = Integer.MIN_VALUE;
                            } else {
                                i26 = 0;
                            }
                            iArr2[i83] = i87 | i26 | (i75 << 20) | i85;
                            i65 += 3;
                            iArr2[i84] = (i21 << 20) | iObjectFieldOffset2;
                            i35 = i20;
                            strZzd = strZzd;
                            length = i76;
                            zzanmVar2 = zzanmVar;
                            i4 = i18;
                            c = 55296;
                            i7 = i19;
                            iArr4 = iArr2;
                        } else if (i75 == 50) {
                            int i88 = i63 + 1;
                            iArr[i63] = i65;
                            int i89 = (i65 / 3) << 1;
                            int i90 = i7 + 2;
                            objArr[i89] = objArrZze[i82];
                            if ((iCharAt10 & 2048) != 0) {
                                i82 = i7 + 3;
                                objArr[i89 + 1] = objArrZze[i90];
                            } else {
                                i82 = i90;
                            }
                            i63 = i88;
                        }
                        i82 = i23;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZza4);
                    if ((iCharAt10 & 4096) == 0 || i75 > 17) {
                        i19 = i82;
                        i20 = i17;
                        iObjectFieldOffset = iObjectFieldOffset3;
                        iObjectFieldOffset2 = 1048575;
                    } else {
                        int i91 = i17 + 1;
                        int iCharAt12 = strZzd.charAt(i17);
                        if (iCharAt12 >= 55296) {
                            int i92 = iCharAt12 & 8191;
                            int i93 = 13;
                            while (true) {
                                i22 = i91 + 1;
                                cCharAt8 = strZzd.charAt(i91);
                                if (cCharAt8 < 55296) {
                                    break;
                                }
                                i92 |= (cCharAt8 & 8191) << i93;
                                i93 += 13;
                                i91 = i22;
                            }
                            iCharAt12 = i92 | (cCharAt8 << i93);
                            i91 = i22;
                        }
                        int i94 = (i18 << 1) + (iCharAt12 / 32);
                        Object obj3 = objArrZze[i94];
                        int i95 = iCharAt12;
                        if (obj3 instanceof Field) {
                            fieldZza = (Field) obj3;
                        } else {
                            fieldZza = zza(cls2, (String) obj3);
                            objArrZze[i94] = fieldZza;
                        }
                        strZzd = strZzd;
                        i21 = i95 % 32;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZza);
                        iObjectFieldOffset = iObjectFieldOffset3;
                        int i96 = i91;
                        i19 = i82;
                        i20 = i96;
                    }
                    int i810 = i65 + 1;
                    iArr2[i65] = i77;
                    int i811 = i65 + 2;
                    int i812 = iObjectFieldOffset;
                    if ((iCharAt10 & 512) != 0) {
                        i24 = 536870912;
                    } else {
                        i24 = 0;
                    }
                    int i813 = i24;
                    if ((iCharAt10 & 256) != 0) {
                        i25 = 268435456;
                    } else {
                        i25 = 0;
                    }
                    int i814 = i813 | i25;
                    if ((iCharAt10 & 2048) != 0) {
                        i26 = Integer.MIN_VALUE;
                    } else {
                        i26 = 0;
                    }
                    iArr2[i810] = i814 | i26 | (i75 << 20) | i812;
                    i65 += 3;
                    iArr2[i811] = (i21 << 20) | iObjectFieldOffset2;
                    i35 = i20;
                    strZzd = strZzd;
                    length = i76;
                    zzanmVar2 = zzanmVar;
                    i4 = i18;
                    c = 55296;
                    i7 = i19;
                    iArr4 = iArr2;
                }
                i21 = 0;
                int i815 = i65 + 1;
                iArr2[i65] = i77;
                int i816 = i65 + 2;
                int i817 = iObjectFieldOffset;
                if ((iCharAt10 & 512) != 0) {
                    i24 = 536870912;
                } else {
                    i24 = 0;
                }
                int i818 = i24;
                if ((iCharAt10 & 256) != 0) {
                    i25 = 268435456;
                } else {
                    i25 = 0;
                }
                int i819 = i818 | i25;
                if ((iCharAt10 & 2048) != 0) {
                    i26 = Integer.MIN_VALUE;
                } else {
                    i26 = 0;
                }
                iArr2[i815] = i819 | i26 | (i75 << 20) | i817;
                i65 += 3;
                iArr2[i816] = (i21 << 20) | iObjectFieldOffset2;
                i35 = i20;
                strZzd = strZzd;
                length = i76;
                zzanmVar2 = zzanmVar;
                i4 = i18;
                c = 55296;
                i7 = i19;
                iArr4 = iArr2;
            }
            return new zzamz<>(iArr4, objArr, i2, i6, zzanmVar2.zza(), false, iArr, i5, i62, zzandVar, zzamhVar, zzaobVar, zzalhVar, zzamsVar);
        }
        throw new NoSuchMethodError();
    }

    private final zzanl zze(int i) {
        int i2 = (i / 3) << 1;
        zzanl zzanlVar = (zzanl) this.zzd[i2];
        if (zzanlVar != null) {
            return zzanlVar;
        }
        zzanl zzanlVarZza = zzank.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zzanlVarZza;
        return zzanlVarZza;
    }

    static zzaoa zzc(Object obj) {
        zzalt zzaltVar = (zzalt) obj;
        zzaoa zzaoaVar = zzaltVar.zzb;
        if (zzaoaVar != zzaoa.zzc()) {
            return zzaoaVar;
        }
        zzaoa zzaoaVarZzd = zzaoa.zzd();
        zzaltVar.zzb = zzaoaVarZzd;
        return zzaoaVarZzd;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzaob<UT, UB> zzaobVar, Object obj2) {
        zzaly zzalyVarZzd;
        int i2 = this.zzc[i];
        Object objZze = zzaoc.zze(obj, zzc(i) & 1048575);
        return (objZze == null || (zzalyVarZzd = zzd(i)) == null) ? ub : (UB) zza(i, i2, this.zzr.zze(objZze), zzalyVarZzd, ub, zzaobVar, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzaly zzalyVar, UB ub, zzaob<UT, UB> zzaobVar, Object obj) {
        zzamq<?, ?> zzamqVarZza = this.zzr.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzalyVar.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzaobVar.zzc(obj);
                }
                zzakk zzakkVarZzb = zzakb.zzb(zzamn.zza(zzamqVarZza, next.getKey(), next.getValue()));
                try {
                    zzamn.zza(zzakkVarZzb.zzb(), zzamqVarZza, next.getKey(), next.getValue());
                    zzaobVar.zza(ub, i2, zzakkVarZzb.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i) {
        zzanl zzanlVarZze = zze(i);
        long jZzc = zzc(i) & 1048575;
        if (!zzc(t, i)) {
            return zzanlVarZze.zza();
        }
        Object object = zzb.getObject(t, jZzc);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzanlVarZze.zza();
        if (object != null) {
            zzanlVarZze.zza(objZza, object);
        }
        return objZza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object zza(T t, int i, int i2) {
        zzanl zzanlVarZze = zze(i2);
        if (!zzc(t, i, i2)) {
            return zzanlVarZze.zza();
        }
        Object object = zzb.getObject(t, zzc(i2) & 1048575);
        if (zzg(object)) {
            return object;
        }
        Object objZza = zzanlVarZze.zza();
        if (object != null) {
            zzanlVarZze.zza(objZza, object);
        }
        return objZza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final T zza() {
        return (T) this.zzn.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    private zzamz(int[] iArr, Object[] objArr, int i, int i2, zzamv zzamvVar, boolean z, int[] iArr2, int i3, int i4, zzand zzandVar, zzamh zzamhVar, zzaob<?, ?> zzaobVar, zzalh<?> zzalhVar, zzams zzamsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzamvVar instanceof zzalt;
        this.zzh = zzalhVar != null && zzalhVar.zza(zzamvVar);
        this.zzj = false;
        this.zzk = iArr2;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = zzandVar;
        this.zzo = zzamhVar;
        this.zzp = zzaobVar;
        this.zzq = zzalhVar;
        this.zzg = zzamvVar;
        this.zzr = zzamsVar;
    }

    private static void zzf(Object obj) {
        if (zzg(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zzd(T t) {
        if (zzg(t)) {
            if (t instanceof zzalt) {
                zzalt zzaltVar = (zzalt) t;
                zzaltVar.zza(Integer.MAX_VALUE);
                zzaltVar.zza = 0;
                zzaltVar.zzt();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzc = zzc(i);
                long j = 1048575 & iZzc;
                int i2 = (iZzc & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 != 60 && i2 != 68) {
                        switch (i2) {
                            case 17:
                                if (zzc(t, i)) {
                                    zze(i).zzd(zzb.getObject(t, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzo.zzb(t, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzr.zzc(object));
                                }
                                break;
                        }
                    } else if (zzc(t, this.zzc[i], i)) {
                        zze(i).zzd(zzb.getObject(t, j));
                    }
                } else if (zzc(t, i)) {
                    zze(i).zzd(zzb.getObject(t, j));
                }
            }
            this.zzp.zzf(t);
            if (this.zzh) {
                this.zzq.zzc(t);
            }
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, T t2) {
        zzf(t);
        zzalw.zza(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzc = zzc(i);
            long j = 1048575 & iZzc;
            int i2 = this.zzc[i];
            switch ((iZzc & 267386880) >>> 20) {
                case 0:
                    if (zzc(t2, i)) {
                        zzaoc.zza(t, j, zzaoc.zza(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 1:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzb(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 2:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 3:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 4:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 5:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 6:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 7:
                    if (zzc(t2, i)) {
                        zzaoc.zzc(t, j, zzaoc.zzh(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 8:
                    if (zzc(t2, i)) {
                        zzaoc.zza(t, j, zzaoc.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzc(t2, i)) {
                        zzaoc.zza(t, j, zzaoc.zze(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 11:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 12:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 13:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 14:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 15:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzc(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 16:
                    if (zzc(t2, i)) {
                        zzaoc.zza((Object) t, j, zzaoc.zzd(t2, j));
                        zzb((Object) t, i);
                    }
                    break;
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzo.zza(t, t2, j);
                    break;
                case 50:
                    zzano.zza(this.zzr, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzc(t2, i2, i)) {
                        zzaoc.zza(t, j, zzaoc.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzc(t2, i2, i)) {
                        zzaoc.zza(t, j, zzaoc.zze(t2, j));
                        zzb(t, i2, i);
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzano.zza(this.zzp, t, t2);
        if (this.zzh) {
            zzano.zza(this.zzq, t, t2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:175:0x059c A[Catch: all -> 0x05cb, TryCatch #5 {all -> 0x05cb, blocks: (B:173:0x0597, B:175:0x059c, B:176:0x05a1), top: B:211:0x0597 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x05af A[LOOP:5: B:179:0x05ab->B:181:0x05af, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:184:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:186:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:197:0x05dc A[LOOP:1: B:195:0x05d8->B:197:0x05dc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:200:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:224:0x05a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:238:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.google.android.gms.internal.firebase-auth-api.zzakw] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, zzakw zzakwVar, zzalf zzalfVar) throws Throwable {
        T t2;
        int i;
        Object objZza;
        T t3;
        zzalh<?> zzalhVar;
        zzamz<T> zzamzVar;
        zzalf zzalfVar2;
        T t4;
        Object objZza2;
        T t5;
        int i2;
        Object objZza3;
        T t6;
        zzamz<T> zzamzVar2 = this;
        zzalf zzalfVar3 = zzalfVar;
        zzalw.zza(zzalfVar3);
        zzf(t);
        zzaob zzaobVar = zzamzVar2.zzp;
        zzalh<?> zzalhVar2 = zzamzVar2.zzq;
        Object objZza4 = null;
        zzalm zzalmVarZzb = null;
        while (true) {
            try {
                int iZzc = zzakwVar.zzc();
                int iZza = zzamzVar2.zza(iZzc);
                if (iZza < 0) {
                    if (iZzc == Integer.MAX_VALUE) {
                        int i3 = zzamzVar2.zzl;
                        Object objZza5 = objZza4;
                        while (i3 < zzamzVar2.zzm) {
                            objZza5 = zzamzVar2.zza(t, zzamzVar2.zzk[i3], objZza5, (zzaob<UT, Object>) zzaobVar, t);
                            i3++;
                            zzamzVar2 = zzamzVar2;
                        }
                        if (objZza5 != null) {
                            zzaobVar.zzb(t, objZza5);
                            return;
                        }
                        return;
                    }
                    zzamzVar = zzamzVar2;
                    t4 = t;
                    try {
                        Object objZza6 = !zzamzVar.zzh ? null : zzalhVar2.zza(zzalfVar3, zzamzVar.zzg, iZzc);
                        if (objZza6 != null) {
                            if (zzalmVarZzb == null) {
                                zzalmVarZzb = zzalhVar2.zzb(t4);
                            }
                            zzalm zzalmVar = zzalmVarZzb;
                            zzaob zzaobVar2 = zzaobVar;
                            try {
                                objZza4 = zzalhVar2.zza(t4, zzakwVar, objZza6, zzalfVar3, zzalmVar, objZza4, zzaobVar2);
                                zzalmVarZzb = zzalmVar;
                                zzaobVar = zzaobVar2;
                                zzalhVar = zzalhVar2;
                                zzalfVar2 = zzalfVar3;
                                zzamzVar2 = zzamzVar;
                                zzalfVar3 = zzalfVar2;
                                zzalhVar2 = zzalhVar;
                                zzalmVarZzb = zzalmVarZzb;
                            } catch (Throwable th) {
                                th = th;
                                t2 = t4;
                                zzaobVar = zzaobVar2;
                                zzamzVar2 = zzamzVar;
                                i = zzamzVar2.zzl;
                                objZza = objZza4;
                                while (i < zzamzVar2.zzm) {
                                    objZza = zzamzVar2.zza(t2, zzamzVar2.zzk[i], objZza, (zzaob<UT, Object>) zzaobVar, t);
                                    i++;
                                    zzamzVar2 = this;
                                }
                                t3 = t2;
                                if (objZza != null) {
                                    zzaobVar.zzb(t3, objZza);
                                }
                                throw th;
                            }
                        } else {
                            zzalhVar = zzalhVar2;
                            t2 = t4;
                            zzalfVar2 = zzalfVar3;
                            try {
                                zzaobVar.zza((zzakw) zzakwVar);
                                if (objZza4 == null) {
                                    try {
                                        objZza4 = zzaobVar.zzc(t2);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        zzamzVar2 = zzamzVar;
                                        i = zzamzVar2.zzl;
                                        objZza = objZza4;
                                        while (i < zzamzVar2.zzm) {
                                            objZza = zzamzVar2.zza(t2, zzamzVar2.zzk[i], objZza, (zzaob<UT, Object>) zzaobVar, t);
                                            i++;
                                            zzamzVar2 = this;
                                        }
                                        t3 = t2;
                                        if (objZza != null) {
                                            zzaobVar.zzb(t3, objZza);
                                        }
                                        throw th;
                                    }
                                }
                                if (!zzaobVar.zza(objZza4, (zzakw) zzakwVar, 0)) {
                                    Object objZza7 = objZza4;
                                    for (int i4 = zzamzVar.zzl; i4 < zzamzVar.zzm; i4++) {
                                        objZza7 = zzamzVar.zza(t2, zzamzVar.zzk[i4], objZza7, (zzaob<UT, Object>) zzaobVar, t);
                                    }
                                    if (objZza7 != null) {
                                        zzaobVar.zzb(t2, objZza7);
                                        return;
                                    }
                                    return;
                                }
                                zzalmVarZzb = zzalmVarZzb;
                                zzamzVar2 = zzamzVar;
                                zzalfVar3 = zzalfVar2;
                                zzalhVar2 = zzalhVar;
                                zzalmVarZzb = zzalmVarZzb;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        t2 = t4;
                        zzamzVar2 = zzamzVar;
                        i = zzamzVar2.zzl;
                        objZza = objZza4;
                        while (i < zzamzVar2.zzm) {
                            objZza = zzamzVar2.zza(t2, zzamzVar2.zzk[i], objZza, (zzaob<UT, Object>) zzaobVar, t);
                            i++;
                            zzamzVar2 = this;
                        }
                        t3 = t2;
                        if (objZza != null) {
                            zzaobVar.zzb(t3, objZza);
                        }
                        throw th;
                    }
                } else {
                    zzalhVar = zzalhVar2;
                    zzamzVar = zzamzVar2;
                    zzalfVar2 = zzalfVar3;
                    t4 = t;
                    int iZzc2 = zzamzVar.zzc(iZza);
                    switch ((267386880 & iZzc2) >>> 20) {
                        case 0:
                            zzaoc.zza(t4, iZzc2 & 1048575, zzakwVar.zza());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 1:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzb());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 2:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzl());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 3:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzo());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 4:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzg());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 5:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzk());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 6:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzf());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 7:
                            zzaoc.zzc(t4, iZzc2 & 1048575, zzakwVar.zzs());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 8:
                            zzamzVar.zza((Object) t4, iZzc2, (zzakw) zzakwVar);
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 9:
                            zzamv zzamvVar = (zzamv) zzamzVar.zza((Object) t4, iZza);
                            zzakwVar.zzb(zzamvVar, zzamzVar.zze(iZza), zzalfVar2);
                            zzamzVar.zza(t4, iZza, zzamvVar);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 10:
                            zzaoc.zza(t4, iZzc2 & 1048575, zzakwVar.zzp());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 11:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzj());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 12:
                            int iZze = zzakwVar.zze();
                            zzaly zzalyVarZzd = zzamzVar.zzd(iZza);
                            if (zzalyVarZzd == null || zzalyVarZzd.zza(iZze)) {
                                zzaoc.zza((Object) t4, iZzc2 & 1048575, iZze);
                                zzamzVar.zzb((Object) t4, iZza);
                                zzalmVarZzb = zzalmVarZzb;
                            } else {
                                objZza4 = zzano.zza(t4, iZzc, iZze, objZza4, zzaobVar);
                                zzalmVarZzb = zzalmVarZzb;
                            }
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 13:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzh());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 14:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzm());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 15:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzi());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 16:
                            zzaoc.zza((Object) t4, iZzc2 & 1048575, zzakwVar.zzn());
                            zzamzVar.zzb((Object) t4, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 17:
                            zzamv zzamvVar2 = (zzamv) zzamzVar.zza((Object) t4, iZza);
                            zzakwVar.zza(zzamvVar2, zzamzVar.zze(iZza), zzalfVar2);
                            zzamzVar.zza(t4, iZza, zzamvVar2);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 18:
                            zzakwVar.zzc(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 19:
                            zzakwVar.zzg(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 20:
                            zzakwVar.zzi(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 21:
                            zzakwVar.zzq(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 22:
                            zzakwVar.zzh(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 23:
                            zzakwVar.zzf(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 24:
                            zzakwVar.zze(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 25:
                            zzakwVar.zza(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 26:
                            boolean zZzg = zzg(iZzc2);
                            zzamh zzamhVar = zzamzVar.zzo;
                            if (zZzg) {
                                zzakwVar.zzo(zzamhVar.zza(t4, iZzc2 & 1048575));
                                zzalmVarZzb = zzalmVarZzb;
                            } else {
                                zzakwVar.zzn(zzamhVar.zza(t4, iZzc2 & 1048575));
                                zzalmVarZzb = zzalmVarZzb;
                            }
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 27:
                            zzakwVar.zzb(zzamzVar.zzo.zza(t4, iZzc2 & 1048575), zzamzVar.zze(iZza), zzalfVar2);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 28:
                            zzakwVar.zzb(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 29:
                            zzakwVar.zzp(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 30:
                            List listZza = zzamzVar.zzo.zza(t4, iZzc2 & 1048575);
                            zzakwVar.zzd(listZza);
                            zzaly zzalyVarZzd2 = zzamzVar.zzd(iZza);
                            Object obj = objZza4;
                            zzaob zzaobVar3 = zzaobVar;
                            objZza2 = zzano.zza(t4, iZzc, listZza, zzalyVarZzd2, obj, zzaobVar3);
                            zzaobVar = zzaobVar3;
                            objZza4 = objZza2;
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 31:
                            zzakwVar.zzj(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 32:
                            zzakwVar.zzk(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 33:
                            zzakwVar.zzl(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 34:
                            zzakwVar.zzm(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 35:
                            zzakwVar.zzc(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 36:
                            zzakwVar.zzg(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 37:
                            zzakwVar.zzi(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 38:
                            zzakwVar.zzq(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 39:
                            zzakwVar.zzh(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 40:
                            zzakwVar.zzf(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 41:
                            zzakwVar.zze(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 42:
                            zzakwVar.zza(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 43:
                            zzakwVar.zzp(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 44:
                            List listZza2 = zzamzVar.zzo.zza(t4, iZzc2 & 1048575);
                            zzakwVar.zzd(listZza2);
                            zzaly zzalyVarZzd3 = zzamzVar.zzd(iZza);
                            Object obj2 = objZza4;
                            zzaob zzaobVar4 = zzaobVar;
                            try {
                                objZza2 = zzano.zza(t4, iZzc, listZza2, zzalyVarZzd3, obj2, zzaobVar4);
                                zzaobVar = zzaobVar4;
                                objZza4 = objZza2;
                                zzalmVarZzb = zzalmVarZzb;
                                zzamzVar2 = zzamzVar;
                            } catch (zzamg unused) {
                                objZza4 = obj2;
                                zzaobVar = zzaobVar4;
                                t5 = t4;
                                zzamzVar2 = zzamzVar;
                                try {
                                    zzaobVar.zza((zzakw) zzakwVar);
                                    if (objZza4 == null) {
                                        objZza4 = zzaobVar.zzc(t5);
                                    }
                                    if (!zzaobVar.zza(objZza4, (zzakw) zzakwVar, 0)) {
                                        i2 = zzamzVar2.zzl;
                                        objZza3 = objZza4;
                                        while (i2 < zzamzVar2.zzm) {
                                            T t7 = t5;
                                            objZza3 = zzamzVar2.zza(t7, zzamzVar2.zzk[i2], objZza3, (zzaob<UT, Object>) zzaobVar, t);
                                            i2++;
                                            t5 = t7;
                                        }
                                        t6 = t5;
                                        if (objZza3 != null) {
                                            zzaobVar.zzb(t6, objZza3);
                                            return;
                                        }
                                        return;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    t2 = t5;
                                    i = zzamzVar2.zzl;
                                    objZza = objZza4;
                                    while (i < zzamzVar2.zzm) {
                                        objZza = zzamzVar2.zza(t2, zzamzVar2.zzk[i], objZza, (zzaob<UT, Object>) zzaobVar, t);
                                        i++;
                                        zzamzVar2 = this;
                                    }
                                    t3 = t2;
                                    if (objZza != null) {
                                        zzaobVar.zzb(t3, objZza);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                objZza4 = obj2;
                                zzaobVar = zzaobVar4;
                                t2 = t4;
                                zzamzVar2 = zzamzVar;
                                i = zzamzVar2.zzl;
                                objZza = objZza4;
                                while (i < zzamzVar2.zzm) {
                                    objZza = zzamzVar2.zza(t2, zzamzVar2.zzk[i], objZza, (zzaob<UT, Object>) zzaobVar, t);
                                    i++;
                                    zzamzVar2 = this;
                                }
                                t3 = t2;
                                if (objZza != null) {
                                    zzaobVar.zzb(t3, objZza);
                                }
                                throw th;
                            }
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 45:
                            zzakwVar.zzj(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 46:
                            zzakwVar.zzk(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 47:
                            zzakwVar.zzl(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 48:
                            zzakwVar.zzm(zzamzVar.zzo.zza(t4, iZzc2 & 1048575));
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 49:
                            zzakwVar.zza(zzamzVar.zzo.zza(t4, iZzc2 & 1048575), zzamzVar.zze(iZza), zzalfVar2);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 50:
                            Object objZzf = zzamzVar.zzf(iZza);
                            long jZzc = zzamzVar.zzc(iZza) & 1048575;
                            Object objZze = zzaoc.zze(t4, jZzc);
                            zzams zzamsVar = zzamzVar.zzr;
                            if (objZze == null) {
                                objZze = zzamsVar.zzb(objZzf);
                                zzaoc.zza(t4, jZzc, objZze);
                            } else if (zzamsVar.zzf(objZze)) {
                                Object objZzb = zzamzVar.zzr.zzb(objZzf);
                                zzamzVar.zzr.zza(objZzb, objZze);
                                zzaoc.zza(t4, jZzc, objZzb);
                                objZze = objZzb;
                            }
                            zzakwVar.zza(zzamzVar.zzr.zze(objZze), zzamzVar.zzr.zza(objZzf), zzalfVar2);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 51:
                            zzaoc.zza(t4, iZzc2 & 1048575, Double.valueOf(zzakwVar.zza()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 52:
                            zzaoc.zza(t4, iZzc2 & 1048575, Float.valueOf(zzakwVar.zzb()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 53:
                            zzaoc.zza(t4, iZzc2 & 1048575, Long.valueOf(zzakwVar.zzl()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 54:
                            zzaoc.zza(t4, iZzc2 & 1048575, Long.valueOf(zzakwVar.zzo()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 55:
                            zzaoc.zza(t4, iZzc2 & 1048575, Integer.valueOf(zzakwVar.zzg()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 56:
                            zzaoc.zza(t4, iZzc2 & 1048575, Long.valueOf(zzakwVar.zzk()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 57:
                            zzaoc.zza(t4, iZzc2 & 1048575, Integer.valueOf(zzakwVar.zzf()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 58:
                            zzaoc.zza(t4, iZzc2 & 1048575, Boolean.valueOf(zzakwVar.zzs()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                            zzamzVar.zza((Object) t4, iZzc2, (zzakw) zzakwVar);
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 60:
                            zzamv zzamvVar3 = (zzamv) zzamzVar.zza(t4, iZzc, iZza);
                            zzakwVar.zzb(zzamvVar3, zzamzVar.zze(iZza), zzalfVar2);
                            zzamzVar.zza(t4, iZzc, iZza, zzamvVar3);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 61:
                            zzaoc.zza(t4, iZzc2 & 1048575, zzakwVar.zzp());
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 62:
                            zzaoc.zza(t4, iZzc2 & 1048575, Integer.valueOf(zzakwVar.zzj()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 63:
                            int iZze2 = zzakwVar.zze();
                            zzaly zzalyVarZzd4 = zzamzVar.zzd(iZza);
                            if (zzalyVarZzd4 == null || zzalyVarZzd4.zza(iZze2)) {
                                zzaoc.zza(t4, iZzc2 & 1048575, Integer.valueOf(iZze2));
                                zzamzVar.zzb(t4, iZzc, iZza);
                                zzalmVarZzb = zzalmVarZzb;
                            } else {
                                objZza4 = zzano.zza(t4, iZzc, iZze2, objZza4, zzaobVar);
                                zzalmVarZzb = zzalmVarZzb;
                            }
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 64:
                            zzaoc.zza(t4, iZzc2 & 1048575, Integer.valueOf(zzakwVar.zzh()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 65:
                            zzaoc.zza(t4, iZzc2 & 1048575, Long.valueOf(zzakwVar.zzm()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 66:
                            zzaoc.zza(t4, iZzc2 & 1048575, Integer.valueOf(zzakwVar.zzi()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case 67:
                            zzaoc.zza(t4, iZzc2 & 1048575, Long.valueOf(zzakwVar.zzn()));
                            zzamzVar.zzb(t4, iZzc, iZza);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        case EACTags.APPLICATION_IMAGE /* 68 */:
                            zzamv zzamvVar4 = (zzamv) zzamzVar.zza(t4, iZzc, iZza);
                            zzakwVar.zza(zzamvVar4, zzamzVar.zze(iZza), zzalfVar2);
                            zzamzVar.zza(t4, iZzc, iZza, zzamvVar4);
                            zzalmVarZzb = zzalmVarZzb;
                            zzamzVar2 = zzamzVar;
                            zzalfVar3 = zzalfVar2;
                            zzalhVar2 = zzalhVar;
                            zzalmVarZzb = zzalmVarZzb;
                            break;
                        default:
                            if (objZza4 == null) {
                                try {
                                    objZza4 = zzaobVar.zzc(t4);
                                } catch (zzamg unused2) {
                                    t5 = t4;
                                    zzamzVar2 = zzamzVar;
                                    zzaobVar.zza((zzakw) zzakwVar);
                                    if (objZza4 == null) {
                                        objZza4 = zzaobVar.zzc(t5);
                                    }
                                    if (!zzaobVar.zza(objZza4, (zzakw) zzakwVar, 0)) {
                                        i2 = zzamzVar2.zzl;
                                        objZza3 = objZza4;
                                        while (i2 < zzamzVar2.zzm) {
                                            T t8 = t5;
                                            objZza3 = zzamzVar2.zza(t8, zzamzVar2.zzk[i2], objZza3, (zzaob<UT, Object>) zzaobVar, t);
                                            i2++;
                                            t5 = t8;
                                        }
                                        t6 = t5;
                                        if (objZza3 != null) {
                                            zzaobVar.zzb(t6, objZza3);
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                            try {
                                if (!zzaobVar.zza(objZza4, (zzakw) zzakwVar, 0)) {
                                    int i5 = zzamzVar.zzl;
                                    Object objZza8 = objZza4;
                                    while (i5 < zzamzVar.zzm) {
                                        T t9 = t4;
                                        objZza8 = zzamzVar.zza(t9, zzamzVar.zzk[i5], objZza8, (zzaob<UT, Object>) zzaobVar, t);
                                        i5++;
                                        t4 = t9;
                                    }
                                    T t10 = t4;
                                    if (objZza8 != null) {
                                        zzaobVar.zzb(t10, objZza8);
                                        return;
                                    }
                                    return;
                                }
                                zzalmVarZzb = zzalmVarZzb;
                                zzamzVar2 = zzamzVar;
                                zzalfVar3 = zzalfVar2;
                                zzalhVar2 = zzalhVar;
                                zzalmVarZzb = zzalmVarZzb;
                            } catch (Throwable th7) {
                                th = th7;
                                t5 = t4;
                                zzamzVar2 = zzamzVar;
                                t2 = t5;
                                i = zzamzVar2.zzl;
                                objZza = objZza4;
                                while (i < zzamzVar2.zzm) {
                                    objZza = zzamzVar2.zza(t2, zzamzVar2.zzk[i], objZza, (zzaob<UT, Object>) zzaobVar, t);
                                    i++;
                                    zzamzVar2 = this;
                                }
                                t3 = t2;
                                if (objZza != null) {
                                    zzaobVar.zzb(t3, objZza);
                                }
                                throw th;
                            }
                            break;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                t2 = t;
            }
            i = zzamzVar2.zzl;
            objZza = objZza4;
            while (i < zzamzVar2.zzm) {
                objZza = zzamzVar2.zza(t2, zzamzVar2.zzk[i], objZza, (zzaob<UT, Object>) zzaobVar, t);
                i++;
                zzamzVar2 = this;
            }
            t3 = t2;
            if (objZza != null) {
                zzaobVar.zzb(t3, objZza);
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, byte[] bArr, int i, int i2, zzaka zzakaVar) throws IOException {
        zza(t, bArr, i, i2, 0, zzakaVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zza(T t, T t2, int i) {
        if (zzc(t2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzanl zzanlVarZze = zze(i);
            if (!zzc(t, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzanlVarZze.zza();
                    zzanlVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb((Object) t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzanlVarZze.zza();
                zzanlVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzanlVarZze.zza(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc(t2, i2, i)) {
            long jZzc = zzc(i) & 1048575;
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, jZzc);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + String.valueOf(t2));
            }
            zzanl zzanlVarZze = zze(i);
            if (!zzc(t, i2, i)) {
                if (!zzg(object)) {
                    unsafe.putObject(t, jZzc, object);
                } else {
                    Object objZza = zzanlVarZze.zza();
                    zzanlVarZze.zza(objZza, object);
                    unsafe.putObject(t, jZzc, objZza);
                }
                zzb(t, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jZzc);
            if (!zzg(object2)) {
                Object objZza2 = zzanlVarZze.zza();
                zzanlVarZze.zza(objZza2, object2);
                unsafe.putObject(t, jZzc, objZza2);
                object2 = objZza2;
            }
            zzanlVarZze.zza(object2, object);
        }
    }

    private final void zza(Object obj, int i, zzakw zzakwVar) throws IOException {
        if (zzg(i)) {
            zzaoc.zza(obj, i & 1048575, zzakwVar.zzr());
        } else if (this.zzi) {
            zzaoc.zza(obj, i & 1048575, zzakwVar.zzq());
        } else {
            zzaoc.zza(obj, i & 1048575, zzakwVar.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int iZzb = zzb(i);
        long j = 1048575 & iZzb;
        if (j == 1048575) {
            return;
        }
        zzaoc.zza((Object) t, j, (1 << (iZzb >>> 20)) | zzaoc.zzc(t, j));
    }

    private final void zzb(T t, int i, int i2) {
        zzaoc.zza((Object) t, zzb(i2) & 1048575, i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, zzc(i) & 1048575, obj);
        zzb((Object) t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, zzc(i2) & 1048575, obj);
        zzb(t, i, i2);
    }

    private static void zza(int i, Object obj, zzale zzaleVar) throws IOException {
        if (obj instanceof String) {
            zzaleVar.zza(i, (String) obj);
        } else {
            zzaleVar.zza(i, (zzakb) obj);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final void zza(T t, zzale zzaleVar) throws IOException {
        Map.Entry<?, ?> entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        int i4;
        zzamz<T> zzamzVar = this;
        if (zzamzVar.zzh) {
            zzalm<T> zzalmVarZza = zzamzVar.zzq.zza(t);
            if (zzalmVarZza.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzc = zzalmVarZza.zzc();
                entry = (Map.Entry) itZzc.next();
                it = itZzc;
            }
        } else {
            entry = null;
            it = null;
        }
        int length = zzamzVar.zzc.length;
        Unsafe unsafe = zzb;
        int i5 = 0;
        int i6 = 1048575;
        int i7 = 0;
        while (i5 < length) {
            int iZzc = zzamzVar.zzc(i5);
            int[] iArr = zzamzVar.zzc;
            int i8 = iArr[i5];
            int i9 = (iZzc & 267386880) >>> 20;
            if (i9 <= 17) {
                int i10 = iArr[i5 + 2];
                int i11 = i10 & 1048575;
                if (i11 != i6) {
                    i = 1;
                    i7 = i11 == 1048575 ? 0 : unsafe.getInt(t, i11);
                    i6 = i11;
                } else {
                    i = 1;
                }
                i2 = i6;
                i3 = i7;
                i4 = i << (i10 >>> 20);
            } else {
                i = 1;
                i2 = i6;
                i3 = i7;
                i4 = 0;
            }
            while (entry != null && zzamzVar.zzq.zza(entry) <= i8) {
                zzamzVar.zzq.zza(zzaleVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzc & 1048575;
            switch (i9) {
                case 0:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zza(i8, zzaoc.zza(t, j));
                    }
                    break;
                case 1:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zza(i8, zzaoc.zzb(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 2:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzb(i8, unsafe.getLong(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 3:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zze(i8, unsafe.getLong(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 4:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzc(i8, unsafe.getInt(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 5:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zza(i8, unsafe.getLong(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 6:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzb(i8, unsafe.getInt(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 7:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zza(i8, zzaoc.zzh(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 8:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zza(i8, unsafe.getObject(t, j), zzaleVar);
                    }
                    zzamzVar = this;
                    break;
                case 9:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzb(i8, unsafe.getObject(t, j), zzamzVar.zze(i5));
                    }
                    break;
                case 10:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zza(i8, (zzakb) unsafe.getObject(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 11:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzf(i8, unsafe.getInt(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 12:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zza(i8, unsafe.getInt(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 13:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzd(i8, unsafe.getInt(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 14:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzc(i8, unsafe.getLong(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 15:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zze(i8, unsafe.getInt(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 16:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zzd(i8, unsafe.getLong(t, j));
                    }
                    zzamzVar = this;
                    break;
                case 17:
                    if (zzamzVar.zza(t, i5, i2, i3, i4)) {
                        zzaleVar.zza(i8, unsafe.getObject(t, j), zzamzVar.zze(i5));
                    }
                    break;
                case 18:
                    zzano.zzb(zzamzVar.zzc[i5], (List<Double>) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 19:
                    zzano.zzf(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 20:
                    zzano.zzh(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 21:
                    zzano.zzn(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 22:
                    zzano.zzg(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 23:
                    zzano.zze(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 24:
                    zzano.zzd(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 25:
                    zzano.zza(zzamzVar.zzc[i5], (List<Boolean>) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 26:
                    zzano.zzb(zzamzVar.zzc[i5], (List<String>) unsafe.getObject(t, j), zzaleVar);
                    break;
                case 27:
                    zzano.zzb(zzamzVar.zzc[i5], (List<?>) unsafe.getObject(t, j), zzaleVar, (zzanl<?>) zzamzVar.zze(i5));
                    break;
                case 28:
                    zzano.zza(zzamzVar.zzc[i5], (List<zzakb>) unsafe.getObject(t, j), zzaleVar);
                    break;
                case 29:
                    zzano.zzm(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 30:
                    zzano.zzc(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 31:
                    zzano.zzi(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 32:
                    zzano.zzj(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 33:
                    zzano.zzk(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 34:
                    zzano.zzl(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, false);
                    break;
                case 35:
                    zzano.zzb(zzamzVar.zzc[i5], (List<Double>) unsafe.getObject(t, j), zzaleVar, (boolean) i);
                    break;
                case 36:
                    zzano.zzf(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 37:
                    zzano.zzh(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 38:
                    zzano.zzn(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 39:
                    zzano.zzg(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 40:
                    zzano.zze(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 41:
                    zzano.zzd(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 42:
                    zzano.zza(zzamzVar.zzc[i5], (List<Boolean>) unsafe.getObject(t, j), zzaleVar, (boolean) i);
                    break;
                case 43:
                    zzano.zzm(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 44:
                    zzano.zzc(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 45:
                    zzano.zzi(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 46:
                    zzano.zzj(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 47:
                    zzano.zzk(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 48:
                    zzano.zzl(zzamzVar.zzc[i5], (List) unsafe.getObject(t, j), zzaleVar, i);
                    break;
                case 49:
                    zzano.zza(zzamzVar.zzc[i5], (List<?>) unsafe.getObject(t, j), zzaleVar, (zzanl<?>) zzamzVar.zze(i5));
                    break;
                case 50:
                    Object object = unsafe.getObject(t, j);
                    if (object != null) {
                        zzaleVar.zza(i8, zzamzVar.zzr.zza(zzamzVar.zzf(i5)), zzamzVar.zzr.zzd(object));
                    }
                    break;
                case 51:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zza(i8, ((Double) zzaoc.zze(t, j)).doubleValue());
                    }
                    break;
                case 52:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zza(i8, ((Float) zzaoc.zze(t, j)).floatValue());
                    }
                    break;
                case 53:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzb(i8, zzb(t, j));
                    }
                    break;
                case 54:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zze(i8, zzb(t, j));
                    }
                    break;
                case 55:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzc(i8, zza(t, j));
                    }
                    break;
                case 56:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zza(i8, zzb(t, j));
                    }
                    break;
                case 57:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzb(i8, zza(t, j));
                    }
                    break;
                case 58:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zza(i8, ((Boolean) zzaoc.zze(t, j)).booleanValue());
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zza(i8, unsafe.getObject(t, j), zzaleVar);
                    }
                    break;
                case 60:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzb(i8, unsafe.getObject(t, j), zzamzVar.zze(i5));
                    }
                    break;
                case 61:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zza(i8, (zzakb) unsafe.getObject(t, j));
                    }
                    break;
                case 62:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzf(i8, zza(t, j));
                    }
                    break;
                case 63:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zza(i8, zza(t, j));
                    }
                    break;
                case 64:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzd(i8, zza(t, j));
                    }
                    break;
                case 65:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzc(i8, zzb(t, j));
                    }
                    break;
                case 66:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zze(i8, zza(t, j));
                    }
                    break;
                case 67:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zzd(i8, zzb(t, j));
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzamzVar.zzc(t, i8, i5)) {
                        zzaleVar.zza(i8, unsafe.getObject(t, j), zzamzVar.zze(i5));
                    }
                    break;
                default:
                    break;
            }
            i5 += 3;
            i7 = i3;
            i6 = i2;
            entry = entry;
        }
        while (entry != null) {
            zzamzVar.zzq.zza(zzaleVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        zzaob<?, ?> zzaobVar = zzamzVar.zzp;
        zzaobVar.zzb(zzaobVar.zzd(t), zzaleVar);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc(t, i) == zzc(t2, i);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01be  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final boolean zzb(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean zZza = true;
            if (i < length) {
                int iZzc = zzc(i);
                int i2 = (267386880 & iZzc) >>> 20;
                if (i2 <= 50 || i2 >= 69) {
                    long j = 1048575 & iZzc;
                    switch (i2) {
                        case 0:
                            if (!zzc(t, t2, i) || Double.doubleToLongBits(zzaoc.zza(t, j)) != Double.doubleToLongBits(zzaoc.zza(t2, j))) {
                                zZza = false;
                            }
                            break;
                        case 1:
                            if (!zzc(t, t2, i) || Float.floatToIntBits(zzaoc.zzb(t, j)) != Float.floatToIntBits(zzaoc.zzb(t2, j))) {
                                zZza = false;
                            }
                            break;
                        case 2:
                            if (!zzc(t, t2, i) || zzaoc.zzd(t, j) != zzaoc.zzd(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 3:
                            if (!zzc(t, t2, i) || zzaoc.zzd(t, j) != zzaoc.zzd(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 4:
                            if (!zzc(t, t2, i) || zzaoc.zzc(t, j) != zzaoc.zzc(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 5:
                            if (!zzc(t, t2, i) || zzaoc.zzd(t, j) != zzaoc.zzd(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 6:
                            if (!zzc(t, t2, i) || zzaoc.zzc(t, j) != zzaoc.zzc(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 7:
                            if (!zzc(t, t2, i) || zzaoc.zzh(t, j) != zzaoc.zzh(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 8:
                            if (!zzc(t, t2, i) || !zzano.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j))) {
                                zZza = false;
                            }
                            break;
                        case 9:
                            if (!zzc(t, t2, i) || !zzano.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j))) {
                                zZza = false;
                            }
                            break;
                        case 10:
                            if (!zzc(t, t2, i) || !zzano.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j))) {
                                zZza = false;
                            }
                            break;
                        case 11:
                            if (!zzc(t, t2, i) || zzaoc.zzc(t, j) != zzaoc.zzc(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 12:
                            if (!zzc(t, t2, i) || zzaoc.zzc(t, j) != zzaoc.zzc(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 13:
                            if (!zzc(t, t2, i) || zzaoc.zzc(t, j) != zzaoc.zzc(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 14:
                            if (!zzc(t, t2, i) || zzaoc.zzd(t, j) != zzaoc.zzd(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 15:
                            if (!zzc(t, t2, i) || zzaoc.zzc(t, j) != zzaoc.zzc(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 16:
                            if (!zzc(t, t2, i) || zzaoc.zzd(t, j) != zzaoc.zzd(t2, j)) {
                                zZza = false;
                            }
                            break;
                        case 17:
                            if (!zzc(t, t2, i) || !zzano.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j))) {
                                zZza = false;
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            zZza = zzano.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j));
                            break;
                        case 50:
                            zZza = zzano.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j));
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case EACTags.APPLICATION_IMAGE /* 68 */:
                            if (!zzd(t, t2, i) || !zzano.zza(zzaoc.zze(t, j), zzaoc.zze(t2, j))) {
                                zZza = false;
                            }
                            break;
                    }
                    if (!zZza) {
                        return false;
                    }
                }
                i += 3;
            } else {
                int i3 = this.zzm;
                while (true) {
                    int[] iArr = this.zzk;
                    if (i3 < iArr.length) {
                        int i4 = iArr[i3];
                        if (!zzd(t, t2, i4)) {
                            return false;
                        }
                        if (!zzc(t, 0, i4)) {
                            long jZzc = zzc(i4) & 1048575;
                            if (!zzano.zza(zzaoc.zze(t, jZzc), zzaoc.zze(t2, jZzc))) {
                                return false;
                            }
                        }
                        i3++;
                    } else {
                        if (!this.zzp.zzd(t).equals(this.zzp.zzd(t2))) {
                            return false;
                        }
                        if (this.zzh) {
                            return this.zzq.zza(t).equals(this.zzq.zza(t2));
                        }
                        return true;
                    }
                }
            }
        }
    }

    private final boolean zzc(T t, int i) {
        int iZzb = zzb(i);
        long j = iZzb & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzb >>> 20)) & zzaoc.zzc(t, j)) != 0;
        }
        int iZzc = zzc(i);
        long j2 = iZzc & 1048575;
        switch ((iZzc & 267386880) >>> 20) {
            case 0:
                return Double.doubleToRawLongBits(zzaoc.zza(t, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzaoc.zzb(t, j2)) != 0;
            case 2:
                return zzaoc.zzd(t, j2) != 0;
            case 3:
                return zzaoc.zzd(t, j2) != 0;
            case 4:
                return zzaoc.zzc(t, j2) != 0;
            case 5:
                return zzaoc.zzd(t, j2) != 0;
            case 6:
                return zzaoc.zzc(t, j2) != 0;
            case 7:
                return zzaoc.zzh(t, j2);
            case 8:
                Object objZze = zzaoc.zze(t, j2);
                if (objZze instanceof String) {
                    return !((String) objZze).isEmpty();
                }
                if (objZze instanceof zzakb) {
                    return !zzakb.zza.equals(objZze);
                }
                return zzb();
            case 9:
                return zzaoc.zze(t, j2) != null;
            case 10:
                return !zzakb.zza.equals(zzaoc.zze(t, j2));
            case 11:
                return zzaoc.zzc(t, j2) != 0;
            case 12:
                return zzaoc.zzc(t, j2) != 0;
            case 13:
                return zzaoc.zzc(t, j2) != 0;
            case 14:
                return zzaoc.zzd(t, j2) != 0;
            case 15:
                return zzaoc.zzc(t, j2) != 0;
            case 16:
                return zzaoc.zzd(t, j2) != 0;
            case 17:
                return zzaoc.zze(t, j2) != null;
            default:
                return zzb();
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc(t, i);
        }
        return (i3 & i4) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ef A[LOOP:2: B:53:0x00de->B:58:0x00ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21, types: [com.google.android.gms.internal.firebase-auth-api.zzanl] */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v7, types: [com.google.android.gms.internal.firebase-auth-api.zzanl] */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzanl
    public final boolean zze(T t) {
        int i;
        int i2;
        zzamz<T> zzamzVar;
        T t2;
        List list;
        ?? Zze;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.zzl) {
            int i7 = this.zzk[i5];
            int iZzc = this.zzc(i7);
            int i8 = this.zzc[i7 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i4) {
                if (i9 != 1048575) {
                    i6 = zzb.getInt(t, i9);
                }
                i2 = i6;
                i = i9;
            } else {
                i = i4;
                i2 = i6;
            }
            if ((268435456 & iZzc) != 0) {
                zzamzVar = this;
                t2 = t;
                if (!zzamzVar.zza(t2, i7, i, i2, i10)) {
                    return false;
                }
            } else {
                zzamzVar = this;
                t2 = t;
            }
            int i11 = (267386880 & iZzc) >>> 20;
            if (i11 == 9 || i11 == 17) {
                if (zzamzVar.zza(t2, i7, i, i2, i10) && !zza((Object) t2, iZzc, zzamzVar.zze(i7))) {
                    return false;
                }
            } else if (i11 == 27) {
                list = (List) zzaoc.zze(t2, iZzc & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    Zze = zzamzVar.zze(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!Zze.zze(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (i11 == 60 || i11 == 68) {
                if (zzamzVar.zzc(t2, zzamzVar.zzc[i7], i7) && !zza((Object) t2, iZzc, zzamzVar.zze(i7))) {
                    return false;
                }
            } else if (i11 == 49) {
                list = (List) zzaoc.zze(t2, iZzc & 1048575);
                if (list.isEmpty()) {
                    Zze = zzamzVar.zze(i7);
                    while (i3 < list.size()) {
                        if (!Zze.zze(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (i11 != 50) {
                continue;
            } else {
                Map<?, ?> mapZzd = zzamzVar.zzr.zzd(zzaoc.zze(t2, iZzc & 1048575));
                if (mapZzd.isEmpty()) {
                    continue;
                } else if (zzamzVar.zzr.zza(zzamzVar.zzf(i7)).zzc.zzb() == zzaoq.MESSAGE) {
                    ?? Zza = 0;
                    for (Object obj : mapZzd.values()) {
                        if (Zza == 0) {
                            Zza = Zza;
                            Zza = zzank.zza().zza(((zzalt) obj).getClass());
                        }
                        Zza = Zza;
                        if (!Zza.zze(obj)) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            }
            i5++;
            this = zzamzVar;
            t = t2;
            i4 = i;
            i6 = i2;
        }
        zzamz<T> zzamzVar2 = this;
        return !zzamzVar2.zzh || zzamzVar2.zzq.zza(t).zze();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzanl zzanlVar) {
        return zzanlVar.zze(zzaoc.zze(obj, i & 1048575));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzalt) {
            return ((zzalt) obj).zzu();
        }
        return true;
    }

    private final boolean zzd(T t, T t2, int i) {
        long jZzb = zzb(i) & 1048575;
        return zzaoc.zzc(t, jZzb) == zzaoc.zzc(t2, jZzb);
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzaoc.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private final boolean zzb() {
        throw new IllegalArgumentException();
    }
}
