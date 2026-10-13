package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.eac.EACTags;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@9.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzhu<T> implements zzib<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzix.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhr zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zziq zzl;
    private final zzgd zzm;

    private zzhu(int[] iArr, Object[] objArr, int i, int i2, zzhr zzhrVar, boolean z, int[] iArr2, int i3, int i4, zzhw zzhwVar, zzhe zzheVar, zziq zziqVar, zzgd zzgdVar, zzhn zzhnVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzgdVar != null && (zzhrVar instanceof zzgm)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zziqVar;
        this.zzm = zzgdVar;
        this.zzg = zzhrVar;
    }

    private final void zzA(Object obj, Object obj2, int i) {
        if (zzH(obj2, i)) {
            int iZzq = zzq(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzq;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzib zzibVarZzt = zzt(i);
            if (!zzH(obj, i)) {
                if (zzK(object)) {
                    Object objZze = zzibVarZzt.zze();
                    zzibVarZzt.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzC(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzK(object2)) {
                Object objZze2 = zzibVarZzt.zze();
                zzibVarZzt.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzibVarZzt.zzg(object2, object);
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzq = zzq(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzq;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzib zzibVarZzt = zzt(i);
            if (!zzM(obj, i2, i)) {
                if (zzK(object)) {
                    Object objZze = zzibVarZzt.zze();
                    zzibVarZzt.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzK(object2)) {
                Object objZze2 = zzibVarZzt.zze();
                zzibVarZzt.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzibVarZzt.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, int i) {
        int iZzn = zzn(i);
        long j = 1048575 & iZzn;
        if (j == 1048575) {
            return;
        }
        zzix.zzn(obj, j, (1 << (iZzn >>> 20)) | zzix.zzc(obj, j));
    }

    private final void zzD(Object obj, int i, int i2) {
        zzix.zzn(obj, zzn(i2) & 1048575, i);
    }

    private final void zzE(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzq(i) & 1048575, obj2);
        zzC(obj, i);
    }

    private final void zzF(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzq(i2) & 1048575, obj2);
        zzD(obj, i, i2);
    }

    private final boolean zzG(Object obj, Object obj2, int i) {
        return zzH(obj, i) == zzH(obj2, i);
    }

    private final boolean zzH(Object obj, int i) {
        int iZzn = zzn(i);
        long j = iZzn & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzn >>> 20)) & zzix.zzc(obj, j)) != 0;
        }
        int iZzq = zzq(i);
        long j2 = iZzq & 1048575;
        switch (zzp(iZzq)) {
            case 0:
                return Double.doubleToRawLongBits(zzix.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzix.zzb(obj, j2)) != 0;
            case 2:
                return zzix.zzd(obj, j2) != 0;
            case 3:
                return zzix.zzd(obj, j2) != 0;
            case 4:
                return zzix.zzc(obj, j2) != 0;
            case 5:
                return zzix.zzd(obj, j2) != 0;
            case 6:
                return zzix.zzc(obj, j2) != 0;
            case 7:
                return zzix.zzt(obj, j2);
            case 8:
                Object objZzf = zzix.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzfp) {
                    return !zzfp.zza.equals(objZzf);
                }
                return zzN();
            case 9:
                return zzix.zzf(obj, j2) != null;
            case 10:
                return !zzfp.zza.equals(zzix.zzf(obj, j2));
            case 11:
                return zzix.zzc(obj, j2) != 0;
            case 12:
                return zzix.zzc(obj, j2) != 0;
            case 13:
                return zzix.zzc(obj, j2) != 0;
            case 14:
                return zzix.zzd(obj, j2) != 0;
            case 15:
                return zzix.zzc(obj, j2) != 0;
            case 16:
                return zzix.zzd(obj, j2) != 0;
            case 17:
                return zzix.zzf(obj, j2) != null;
            default:
                return zzN();
        }
    }

    private final boolean zzI(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzH(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzJ(Object obj, int i, zzib zzibVar) {
        return zzibVar.zzk(zzix.zzf(obj, i & 1048575));
    }

    private static boolean zzK(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgp) {
            return ((zzgp) obj).zzF();
        }
        return true;
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        long jZzn = zzn(i) & 1048575;
        return zzix.zzc(obj, jZzn) == zzix.zzc(obj2, jZzn);
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzix.zzc(obj, (long) (zzn(i2) & 1048575)) == i;
    }

    private boolean zzN() {
        throw new IllegalArgumentException();
    }

    private static final int zzO(byte[] bArr, int i, int i2, zzjg zzjgVar, Class cls, zzfd zzfdVar) throws IOException {
        zzjg zzjgVar2 = zzjg.DOUBLE;
        switch (zzjgVar) {
            case DOUBLE:
                int i3 = i + 8;
                zzfdVar.zzc = Double.valueOf(Double.longBitsToDouble(zzfe.zzp(bArr, i)));
                return i3;
            case FLOAT:
                int i4 = i + 4;
                zzfdVar.zzc = Float.valueOf(Float.intBitsToFloat(zzfe.zzb(bArr, i)));
                return i4;
            case INT64:
            case UINT64:
                int iZzl = zzfe.zzl(bArr, i, zzfdVar);
                zzfdVar.zzc = Long.valueOf(zzfdVar.zzb);
                return iZzl;
            case INT32:
            case UINT32:
            case ENUM:
                int iZzi = zzfe.zzi(bArr, i, zzfdVar);
                zzfdVar.zzc = Integer.valueOf(zzfdVar.zza);
                return iZzi;
            case FIXED64:
            case SFIXED64:
                int i5 = i + 8;
                zzfdVar.zzc = Long.valueOf(zzfe.zzp(bArr, i));
                return i5;
            case FIXED32:
            case SFIXED32:
                int i6 = i + 4;
                zzfdVar.zzc = Integer.valueOf(zzfe.zzb(bArr, i));
                return i6;
            case BOOL:
                int iZzl2 = zzfe.zzl(bArr, i, zzfdVar);
                zzfdVar.zzc = Boolean.valueOf(zzfdVar.zzb != 0);
                return iZzl2;
            case STRING:
                return zzfe.zzg(bArr, i, zzfdVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzfe.zzd(zzhy.zza().zzb(cls), bArr, i, i2, zzfdVar);
            case BYTES:
                return zzfe.zza(bArr, i, zzfdVar);
            case SINT32:
                int iZzi2 = zzfe.zzi(bArr, i, zzfdVar);
                zzfdVar.zzc = Integer.valueOf(zzft.zzb(zzfdVar.zza));
                return iZzi2;
            case SINT64:
                int iZzl3 = zzfe.zzl(bArr, i, zzfdVar);
                zzfdVar.zzc = Long.valueOf(zzft.zzc(zzfdVar.zzb));
                return iZzl3;
        }
    }

    private static final void zzP(int i, Object obj, zzji zzjiVar) throws IOException {
        if (obj instanceof String) {
            zzjiVar.zzH(i, (String) obj);
        } else {
            zzjiVar.zzd(i, (zzfp) obj);
        }
    }

    static zzir zzd(Object obj) {
        zzgp zzgpVar = (zzgp) obj;
        zzir zzirVar = zzgpVar.zzc;
        if (zzirVar != zzir.zzc()) {
            return zzirVar;
        }
        zzir zzirVarZzf = zzir.zzf();
        zzgpVar.zzc = zzirVarZzf;
        return zzirVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x025f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0262  */
    /* JADX WARN: Code duplicated, block: B:131:0x0280  */
    /* JADX WARN: Code duplicated, block: B:132:0x0283  */
    static zzhu zzl(Class cls, zzhp zzhpVar, zzhw zzhwVar, zzhe zzheVar, zziq zziqVar, zzgd zzgdVar, zzhn zzhnVar) {
        int i;
        int iCharAt;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        Field fieldZzy;
        int i22;
        char cCharAt8;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        Object obj;
        Field fieldZzy2;
        int i29;
        Object obj2;
        Field fieldZzy3;
        int i30;
        char cCharAt9;
        int i31;
        char cCharAt10;
        int i32;
        char cCharAt11;
        int i33;
        char cCharAt12;
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            throw new RuntimeException("Lite gencode is primarily intended for Android use and uses sun.misc.Unsafe which is not available in the current environment. To run in this environment, you may need to switch to standard gencode.");
        }
        if (!(zzhpVar instanceof zzia)) {
            throw null;
        }
        zzia zziaVar = (zzia) zzhpVar;
        String strZzd = zziaVar.zzd();
        int length = strZzd.length();
        int i34 = 0;
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i35 = 1;
            while (true) {
                i = i35 + 1;
                if (strZzd.charAt(i35) < 55296) {
                    break;
                }
                i35 = i;
            }
        } else {
            i = 1;
        }
        int i36 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i37 = iCharAt2 & 8191;
            int i38 = 13;
            while (true) {
                i33 = i36 + 1;
                cCharAt12 = strZzd.charAt(i36);
                if (cCharAt12 < 55296) {
                    break;
                }
                i37 |= (cCharAt12 & 8191) << i38;
                i38 += 13;
                i36 = i33;
            }
            iCharAt2 = i37 | (cCharAt12 << i38);
            i36 = i33;
        }
        if (iCharAt2 == 0) {
            iCharAt = 0;
            i5 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = zza;
            i3 = 0;
        } else {
            int i39 = i36 + 1;
            int iCharAt3 = strZzd.charAt(i36);
            if (iCharAt3 >= 55296) {
                int i40 = iCharAt3 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = strZzd.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt3 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt4 = strZzd.charAt(i39);
            if (iCharAt4 >= 55296) {
                int i43 = iCharAt4 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = strZzd.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt4 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt5 = strZzd.charAt(i42);
            if (iCharAt5 >= 55296) {
                int i46 = iCharAt5 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = strZzd.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt5 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            int iCharAt6 = strZzd.charAt(i45);
            if (iCharAt6 >= 55296) {
                int i49 = iCharAt6 & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = strZzd.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt6 = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            iCharAt = strZzd.charAt(i48);
            if (iCharAt >= 55296) {
                int i52 = iCharAt & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = strZzd.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt7 = strZzd.charAt(i51);
            if (iCharAt7 >= 55296) {
                int i55 = iCharAt7 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = strZzd.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt7 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            if (strZzd.charAt(i54) >= 55296) {
                while (true) {
                    i8 = i57 + 1;
                    if (strZzd.charAt(i57) < 55296) {
                        break;
                    }
                    i57 = i8;
                }
                i57 = i8;
            }
            int i58 = i57 + 1;
            int iCharAt8 = strZzd.charAt(i57);
            if (iCharAt8 >= 55296) {
                int i59 = iCharAt8 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt8 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            i2 = iCharAt3 + iCharAt3 + iCharAt4;
            i34 = iCharAt3;
            iArr = new int[iCharAt8 + iCharAt7 + iCharAt3];
            i3 = iCharAt7;
            i36 = i58;
            i4 = iCharAt8;
            i5 = iCharAt5;
            i6 = iCharAt6;
        }
        Object[] objArrZze = zziaVar.zze();
        Class<?> cls2 = zziaVar.zza().getClass();
        int i61 = i4 + i3;
        int i62 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i62];
        int i63 = i4;
        int i64 = i61;
        int i65 = 0;
        int i66 = 0;
        while (i36 < length) {
            int i67 = i36 + 1;
            int iCharAt9 = strZzd.charAt(i36);
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
                i15 = i32;
            } else {
                i15 = i67;
            }
            int i71 = i15 + 1;
            int iCharAt10 = strZzd.charAt(i15);
            if (iCharAt10 >= c) {
                int i72 = iCharAt10 & 8191;
                int i73 = i71;
                int i74 = 13;
                while (true) {
                    i31 = i73 + 1;
                    cCharAt10 = strZzd.charAt(i73);
                    if (cCharAt10 < c) {
                        break;
                    }
                    i72 |= (cCharAt10 & 8191) << i74;
                    i74 += 13;
                    i73 = i31;
                }
                iCharAt10 = i72 | (cCharAt10 << i74);
                i16 = i31;
            } else {
                i16 = i71;
            }
            if ((iCharAt10 & 1024) != 0) {
                iArr[i65] = i66;
                i65++;
            }
            int i75 = iCharAt10 & 255;
            zzia zziaVar2 = zziaVar;
            int i76 = iCharAt10 & 2048;
            if (i75 >= 51) {
                int i77 = i16 + 1;
                int iCharAt11 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt11 >= 55296) {
                    int i78 = iCharAt11 & 8191;
                    int i79 = i77;
                    int i80 = 13;
                    while (true) {
                        i30 = i79 + 1;
                        cCharAt9 = strZzd.charAt(i79);
                        if (cCharAt9 < c2) {
                            break;
                        }
                        i78 |= (cCharAt9 & 8191) << i80;
                        i80 += 13;
                        i79 = i30;
                        c2 = 55296;
                    }
                    iCharAt11 = i78 | (cCharAt9 << i80);
                    i25 = i30;
                } else {
                    i25 = i77;
                }
                int i81 = i25;
                int i82 = i75 - 51;
                i17 = length;
                if (i82 == 9 || i82 == 17) {
                    i26 = i2 + 1;
                    int i83 = i66 / 3;
                    objArr[i83 + i83 + 1] = objArrZze[i2];
                } else {
                    if (i82 != 12) {
                        i27 = i76;
                    } else if (zziaVar2.zzc() == 1 || i76 != 0) {
                        i26 = i2 + 1;
                        int i84 = i66 / 3;
                        objArr[i84 + i84 + 1] = objArrZze[i2];
                    } else {
                        i27 = 0;
                    }
                    i28 = iCharAt11 + iCharAt11;
                    obj = objArrZze[i28];
                    int i85 = i27;
                    if (obj instanceof Field) {
                        fieldZzy2 = (Field) obj;
                    } else {
                        fieldZzy2 = zzy(cls2, (String) obj);
                        objArrZze[i28] = fieldZzy2;
                        iArr[i64] = i66;
                        i64++;
                    }
                    int i86 = i34;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzy2);
                    i29 = i28 + 1;
                    obj2 = objArrZze[i29];
                    i18 = i86;
                    if (obj2 instanceof Field) {
                        fieldZzy3 = (Field) obj2;
                    } else {
                        fieldZzy3 = zzy(cls2, (String) obj2);
                        objArrZze[i29] = fieldZzy3;
                    }
                    i16 = i81;
                    i21 = 0;
                    i19 = i2;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzy3);
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i20 = i85;
                }
                i2 = i26;
                i27 = i76;
                i28 = iCharAt11 + iCharAt11;
                obj = objArrZze[i28];
                int i87 = i27;
                if (obj instanceof Field) {
                    fieldZzy2 = (Field) obj;
                } else {
                    fieldZzy2 = zzy(cls2, (String) obj);
                    objArrZze[i28] = fieldZzy2;
                    iArr[i64] = i66;
                    i64++;
                }
                int i88 = i34;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzy2);
                i29 = i28 + 1;
                obj2 = objArrZze[i29];
                i18 = i88;
                if (obj2 instanceof Field) {
                    fieldZzy3 = (Field) obj2;
                } else {
                    fieldZzy3 = zzy(cls2, (String) obj2);
                    objArrZze[i29] = fieldZzy3;
                }
                i16 = i81;
                i21 = 0;
                i19 = i2;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzy3);
                iObjectFieldOffset = iObjectFieldOffset4;
                i20 = i87;
            } else {
                i17 = length;
                i18 = i34;
                int i89 = i2 + 1;
                Field fieldZzy4 = zzy(cls2, (String) objArrZze[i2]);
                if (i75 == 9 || i75 == 17) {
                    i19 = i89;
                    int i90 = i66 / 3;
                    objArr[i90 + i90 + 1] = fieldZzy4.getType();
                } else {
                    if (i75 == 27) {
                        i23 = 1;
                        i24 = i2 + 2;
                    } else if (i75 == 49) {
                        i24 = i2 + 2;
                        i23 = 1;
                    } else if (i75 == 12 || i75 == 30 || i75 == 44) {
                        i19 = i89;
                        if (zziaVar2.zzc() == 1 || i76 != 0) {
                            i24 = i2 + 2;
                            int i91 = i66 / 3;
                            objArr[i91 + i91 + 1] = objArrZze[i19];
                            i19 = i24;
                        } else {
                            i76 = 0;
                        }
                    } else if (i75 == 50) {
                        int i92 = i2 + 2;
                        int i93 = i63 + 1;
                        iArr[i63] = i66;
                        int i94 = i66 / 3;
                        int i95 = i94 + i94;
                        objArr[i95] = objArrZze[i89];
                        if (i76 != 0) {
                            i89 = i2 + 3;
                            objArr[i95 + 1] = objArrZze[i92];
                            i63 = i93;
                            i19 = i89;
                        } else {
                            i63 = i93;
                            i76 = 0;
                            i19 = i92;
                        }
                    } else {
                        i19 = i89;
                    }
                    int i96 = i66 / 3;
                    objArr[i96 + i96 + i23] = objArrZze[i89];
                    i19 = i24;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzy4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt10 & 4096) == 0 || i75 > 17) {
                    i20 = i76;
                    i21 = 0;
                } else {
                    int i97 = i16 + 1;
                    int iCharAt12 = strZzd.charAt(i16);
                    if (iCharAt12 >= 55296) {
                        int i98 = iCharAt12 & 8191;
                        int i99 = 13;
                        while (true) {
                            i22 = i97 + 1;
                            cCharAt8 = strZzd.charAt(i97);
                            if (cCharAt8 < 55296) {
                                break;
                            }
                            i98 |= (cCharAt8 & 8191) << i99;
                            i99 += 13;
                            i97 = i22;
                        }
                        iCharAt12 = i98 | (cCharAt8 << i99);
                        i97 = i22;
                    }
                    int i100 = i18 + i18 + (iCharAt12 / 32);
                    Object obj3 = objArrZze[i100];
                    if (obj3 instanceof Field) {
                        fieldZzy = (Field) obj3;
                    } else {
                        fieldZzy = zzy(cls2, (String) obj3);
                        objArrZze[i100] = fieldZzy;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzy);
                    i21 = iCharAt12 % 32;
                    i20 = i76;
                    iObjectFieldOffset = iObjectFieldOffset;
                    i16 = i97;
                }
            }
            int i101 = i66 + 1;
            iArr2[i66] = iCharAt9;
            int i102 = i66 + 2;
            iArr2[i101] = ((iCharAt10 & 512) != 0 ? 536870912 : 0) | ((iCharAt10 & 256) != 0 ? 268435456 : 0) | (i20 != 0 ? Integer.MIN_VALUE : 0) | (i75 << 20) | iObjectFieldOffset;
            i66 += 3;
            iArr2[i102] = (i21 << 20) | iObjectFieldOffset2;
            i36 = i16;
            zziaVar = zziaVar2;
            i2 = i19;
            strZzd = strZzd;
            length = i17;
            i34 = i18;
            c = 55296;
        }
        return new zzhu(iArr2, objArr, i5, i6, zziaVar.zza(), false, iArr, i4, i61, zzhwVar, zzheVar, zziqVar, zzgdVar, zzhnVar);
    }

    private static int zzm(Object obj, long j) {
        return ((Integer) zzix.zzf(obj, j)).intValue();
    }

    private final int zzn(int i) {
        return this.zzc[i + 2];
    }

    private final int zzo(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static int zzp(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzq(int i) {
        return this.zzc[i + 1];
    }

    private static long zzr(Object obj, long j) {
        return ((Long) zzix.zzf(obj, j)).longValue();
    }

    private final zzgs zzs(int i) {
        int i2 = i / 3;
        return (zzgs) this.zzd[i2 + i2 + 1];
    }

    private final zzib zzt(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzib zzibVar = (zzib) objArr[i3];
        if (zzibVar != null) {
            return zzibVar;
        }
        zzib zzibVarZzb = zzhy.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzibVarZzb;
        return zzibVarZzb;
    }

    private final Object zzu(Object obj, int i, Object obj2, zziq zziqVar, Object obj3) {
        zzgs zzgsVarZzs;
        int i2 = this.zzc[i];
        Object objZzf = zzix.zzf(obj, zzq(i) & 1048575);
        if (objZzf == null || (zzgsVarZzs = zzs(i)) == null) {
            return obj2;
        }
        zzhk zzhkVarZzc = ((zzhl) zzv(i)).zzc();
        Iterator it = ((zzhm) objZzf).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzgsVarZzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzis.zza(obj3);
                }
                int iZzb = zzhl.zzb(zzhkVarZzc, entry.getKey(), entry.getValue());
                zzfp zzfpVar = zzfp.zza;
                byte[] bArr = new byte[iZzb];
                zzfu zzfuVar = new zzfu(bArr, 0, iZzb);
                try {
                    zzhl.zze(zzfuVar, zzhkVarZzc, entry.getKey(), entry.getValue());
                    ((zzir) obj2).zzj((i2 << 3) | 2, zzfl.zza(zzfuVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private final Object zzv(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzw(Object obj, int i) {
        zzib zzibVarZzt = zzt(i);
        int iZzq = zzq(i) & 1048575;
        if (!zzH(obj, i)) {
            return zzibVarZzt.zze();
        }
        Object object = zzb.getObject(obj, iZzq);
        if (zzK(object)) {
            return object;
        }
        Object objZze = zzibVarZzt.zze();
        if (object != null) {
            zzibVarZzt.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzx(Object obj, int i, int i2) {
        zzib zzibVarZzt = zzt(i2);
        if (!zzM(obj, i, i2)) {
            return zzibVarZzt.zze();
        }
        Object object = zzb.getObject(obj, zzq(i2) & 1048575);
        if (zzK(object)) {
            return object;
        }
        Object objZze = zzibVarZzt.zze();
        if (object != null) {
            zzibVarZzt.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzy(Class cls, String str) {
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

    private static void zzz(Object obj) {
        if (!zzK(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    /* JADX WARN: Code duplicated, block: B:140:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:206:0x055f  */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final int zza(Object obj) {
        int i;
        int iZzy;
        int iZzy2;
        int iZzz;
        int iZzy3;
        int iZzy4;
        int iZzy5;
        int iZzb;
        int iZzy6;
        int iZzy7;
        int iZzi;
        int iZzy8;
        int iZza;
        int iZzh;
        int size;
        int iZzl;
        int iZzy9;
        int iZzb2;
        int iZzy10;
        int iZzb3;
        int iZzy11;
        int iZzy12;
        int iZzy13;
        int iZzz2;
        int iZzf;
        int iZzy14;
        int iZzy15;
        int iZza2;
        int iZzy16;
        int iZzy17;
        zzhu<T> zzhuVar = this;
        Unsafe unsafe = zzb;
        int i2 = 0;
        int i3 = 0;
        int iZzy18 = 0;
        int i4 = 1048575;
        while (true) {
            int[] iArr = zzhuVar.zzc;
            if (i2 >= iArr.length) {
                int iZza3 = iZzy18 + ((zzgp) obj).zzc.zza();
                if (!zzhuVar.zzh) {
                    return iZza3;
                }
                zzii zziiVar = ((zzgm) obj).zzb.zza;
                int iZzc = zziiVar.zzc();
                int iZzc2 = 0;
                for (int i5 = 0; i5 < iZzc; i5++) {
                    Map.Entry entryZzg = zziiVar.zzg(i5);
                    iZzc2 += zzgh.zzc(((zzie) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zziiVar.zzd()) {
                    iZzc2 += zzgh.zzc((zzgg) entry.getKey(), entry.getValue());
                }
                return iZza3 + iZzc2;
            }
            int iZzq = zzhuVar.zzq(i2);
            int iZzp = zzp(iZzq);
            int i6 = iArr[i2];
            int i7 = iArr[i2 + 2];
            int i8 = i7 & 1048575;
            if (iZzp <= 17) {
                if (i8 != i4) {
                    i3 = i8 == 1048575 ? 0 : unsafe.getInt(obj, i8);
                    i4 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzq & 1048575;
            if (iZzp >= zzgi.DOUBLE_LIST_PACKED.zza()) {
                zzgi.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzp) {
                case 0:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZzy18 += zzfx.zzy(i6 << 3) + 8;
                    }
                    break;
                case 1:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZzy = zzfx.zzy(i6 << 3);
                        iZzy4 = iZzy + 4;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 2:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzy2 = zzfx.zzy(i6 << 3);
                        iZzz = zzfx.zzz(j2);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 3:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzy2 = zzfx.zzy(i6 << 3);
                        iZzz = zzfx.zzz(j3);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 4:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzy2 = zzfx.zzy(i6 << 3);
                        iZzz = zzfx.zzz(j4);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 5:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZzy3 = zzfx.zzy(i6 << 3);
                        iZzy4 = iZzy3 + 8;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 6:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZzy = zzfx.zzy(i6 << 3);
                        iZzy4 = iZzy + 4;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 7:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZzy4 = zzfx.zzy(i6 << 3) + 1;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 8:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzfp) {
                            iZzy5 = zzfx.zzy(i10);
                            iZzb = ((zzfp) object).zzd();
                            iZzy6 = zzfx.zzy(iZzb);
                        } else {
                            iZzy5 = zzfx.zzy(i10);
                            int i11 = zzjc.zza;
                            iZzb = zziz.zzb((String) object);
                            iZzy6 = zzfx.zzy(iZzb);
                        }
                        iZzy4 = iZzy5 + iZzy6 + iZzb;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 9:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        int i12 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        zzib zzibVarZzt = zzhuVar.zzt(i2);
                        int i13 = zzic.zza;
                        iZzy7 = zzfx.zzy(i12);
                        iZzi = ((zzfa) object2).zzi(zzibVarZzt);
                        iZzy8 = zzfx.zzy(iZzi);
                        iZza = iZzy7 + iZzy8 + iZzi;
                        iZzy18 += iZza;
                    }
                    break;
                case 10:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        zzfp zzfpVar = (zzfp) unsafe.getObject(obj, j);
                        iZzy5 = zzfx.zzy(i6 << 3);
                        iZzb = zzfpVar.zzd();
                        iZzy6 = zzfx.zzy(iZzb);
                        iZzy4 = iZzy5 + iZzy6 + iZzb;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 11:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        int i14 = unsafe.getInt(obj, j);
                        iZzy2 = zzfx.zzy(i6 << 3);
                        iZzz = zzfx.zzy(i14);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 12:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzy2 = zzfx.zzy(i6 << 3);
                        iZzz = zzfx.zzz(j5);
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 13:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZzy = zzfx.zzy(i6 << 3);
                        iZzy4 = iZzy + 4;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 14:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZzy3 = zzfx.zzy(i6 << 3);
                        iZzy4 = iZzy3 + 8;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 15:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        int i15 = unsafe.getInt(obj, j);
                        iZzy2 = zzfx.zzy(i6 << 3);
                        iZzz = zzfx.zzy((i15 >> 31) ^ (i15 + i15));
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 16:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzy2 = zzfx.zzy(i6 << 3);
                        iZzz = zzfx.zzz((j6 >> 63) ^ (j6 + j6));
                        iZzy4 = iZzy2 + iZzz;
                        iZzy18 += iZzy4;
                    }
                    zzhuVar = this;
                    break;
                case 17:
                    if (zzhuVar.zzI(obj, i2, i4, i3, i)) {
                        iZza = zzic.zza(i6, (zzhr) unsafe.getObject(obj, j), zzhuVar.zzt(i2));
                        iZzy18 += iZza;
                    }
                    break;
                case 18:
                    iZza = zzic.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZza;
                    break;
                case 19:
                    iZza = zzic.zzc(i6, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZza;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i16 = zzic.zza;
                    if (list.size() == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = zzic.zzh(list) + (list.size() * zzfx.zzy(i6 << 3));
                    }
                    iZzy18 += iZzh;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i17 = zzic.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZza = 0;
                    } else {
                        iZzl = zzic.zzl(list2);
                        iZzy9 = zzfx.zzy(i6 << 3);
                        iZzz2 = size * iZzy9;
                        iZza = iZzl + iZzz2;
                    }
                    iZzy18 += iZza;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i18 = zzic.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZza = 0;
                    } else {
                        iZzl = zzic.zzg(list3);
                        iZzy9 = zzfx.zzy(i6 << 3);
                        iZzz2 = size * iZzy9;
                        iZza = iZzl + iZzz2;
                    }
                    iZzy18 += iZza;
                    break;
                case 23:
                    iZza = zzic.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZza;
                    break;
                case 24:
                    iZza = zzic.zzc(i6, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZza;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i19 = zzic.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZza = 0;
                    } else {
                        iZza = size2 * (zzfx.zzy(i6 << 3) + 1);
                    }
                    iZzy18 += iZza;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i20 = zzic.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = zzfx.zzy(i6 << 3) * size3;
                        if (list5 instanceof zzhd) {
                            zzhd zzhdVar = (zzhd) list5;
                            for (int i21 = 0; i21 < size3; i21++) {
                                Object objZza = zzhdVar.zza();
                                if (objZza instanceof zzfp) {
                                    iZzb3 = ((zzfp) objZza).zzd();
                                    iZzy11 = zzfx.zzy(iZzb3);
                                } else {
                                    int i22 = zzjc.zza;
                                    iZzb3 = zziz.zzb((String) objZza);
                                    iZzy11 = zzfx.zzy(iZzb3);
                                }
                                iZzh += iZzy11 + iZzb3;
                            }
                        } else {
                            for (int i23 = 0; i23 < size3; i23++) {
                                Object obj2 = list5.get(i23);
                                if (obj2 instanceof zzfp) {
                                    iZzb2 = ((zzfp) obj2).zzd();
                                    iZzy10 = zzfx.zzy(iZzb2);
                                } else {
                                    int i24 = zzjc.zza;
                                    iZzb2 = zziz.zzb((String) obj2);
                                    iZzy10 = zzfx.zzy(iZzb2);
                                }
                                iZzh += iZzy10 + iZzb2;
                            }
                        }
                    }
                    iZzy18 += iZzh;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzib zzibVarZzt2 = zzhuVar.zzt(i2);
                    int i25 = zzic.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzy12 = 0;
                    } else {
                        iZzy12 = zzfx.zzy(i6 << 3) * size4;
                        for (int i26 = 0; i26 < size4; i26++) {
                            int iZzi2 = ((zzfa) list6.get(i26)).zzi(zzibVarZzt2);
                            iZzy12 += zzfx.zzy(iZzi2) + iZzi2;
                        }
                    }
                    iZzy18 += iZzy12;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i27 = zzic.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzy13 = 0;
                    } else {
                        iZzy13 = size5 * zzfx.zzy(i6 << 3);
                        for (int i28 = 0; i28 < list7.size(); i28++) {
                            int iZzd = ((zzfp) list7.get(i28)).zzd();
                            iZzy13 += zzfx.zzy(iZzd) + iZzd;
                        }
                    }
                    iZzy18 += iZzy13;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i29 = zzic.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZza = 0;
                    } else {
                        iZzl = zzic.zzk(list8);
                        iZzy9 = zzfx.zzy(i6 << 3);
                        iZzz2 = size * iZzy9;
                        iZza = iZzl + iZzz2;
                    }
                    iZzy18 += iZza;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i30 = zzic.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZza = 0;
                    } else {
                        iZzl = zzic.zzb(list9);
                        iZzy9 = zzfx.zzy(i6 << 3);
                        iZzz2 = size * iZzy9;
                        iZza = iZzl + iZzz2;
                    }
                    iZzy18 += iZza;
                    break;
                case 31:
                    iZza = zzic.zzc(i6, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZza;
                    break;
                case 32:
                    iZza = zzic.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzy18 += iZza;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i31 = zzic.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZza = 0;
                    } else {
                        iZzl = zzic.zzi(list10);
                        iZzy9 = zzfx.zzy(i6 << 3);
                        iZzz2 = size * iZzy9;
                        iZza = iZzl + iZzz2;
                    }
                    iZzy18 += iZza;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i32 = zzic.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZza = 0;
                    } else {
                        iZzl = zzic.zzj(list11);
                        iZzy9 = zzfx.zzy(i6 << 3);
                        iZzz2 = size * iZzy9;
                        iZza = iZzl + iZzz2;
                    }
                    iZzy18 += iZza;
                    break;
                case 35:
                    iZzf = zzic.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 36:
                    iZzf = zzic.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 37:
                    iZzf = zzic.zzh((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 38:
                    iZzf = zzic.zzl((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 39:
                    iZzf = zzic.zzg((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 40:
                    iZzf = zzic.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 41:
                    iZzf = zzic.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i33 = zzic.zza;
                    iZzf = list12.size();
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 43:
                    iZzf = zzic.zzk((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 44:
                    iZzf = zzic.zzb((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 45:
                    iZzf = zzic.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 46:
                    iZzf = zzic.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 47:
                    iZzf = zzic.zzi((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 48:
                    iZzf = zzic.zzj((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy14 = zzfx.zzy(i6 << 3);
                        iZzy15 = zzfx.zzy(iZzf);
                        iZzy13 = iZzy14 + iZzy15 + iZzf;
                        iZzy18 += iZzy13;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzib zzibVarZzt3 = zzhuVar.zzt(i2);
                    int i34 = zzic.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZza2 = 0;
                    } else {
                        iZza2 = 0;
                        for (int i35 = 0; i35 < size6; i35++) {
                            iZza2 += zzic.zza(i6, (zzhr) list13.get(i35), zzibVarZzt3);
                        }
                    }
                    iZzy18 += iZza2;
                    break;
                case 50:
                    zzhm zzhmVar = (zzhm) unsafe.getObject(obj, j);
                    zzhl zzhlVar = (zzhl) zzhuVar.zzv(i2);
                    if (zzhmVar.isEmpty()) {
                        iZzh = 0;
                    } else {
                        iZzh = 0;
                        for (Map.Entry entry2 : zzhmVar.entrySet()) {
                            iZzh += zzhlVar.zza(i6, entry2.getKey(), entry2.getValue());
                        }
                    }
                    iZzy18 += iZzh;
                    break;
                case 51:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZzy16 = zzfx.zzy(i6 << 3);
                        iZza = iZzy16 + 8;
                        iZzy18 += iZza;
                    }
                    break;
                case 52:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZzy17 = zzfx.zzy(i6 << 3);
                        iZza = iZzy17 + 4;
                        iZzy18 += iZza;
                    }
                    break;
                case 53:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        long jZzr = zzr(obj, j);
                        iZzl = zzfx.zzy(i6 << 3);
                        iZzz2 = zzfx.zzz(jZzr);
                        iZza = iZzl + iZzz2;
                        iZzy18 += iZza;
                    }
                    break;
                case 54:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        long jZzr2 = zzr(obj, j);
                        iZzl = zzfx.zzy(i6 << 3);
                        iZzz2 = zzfx.zzz(jZzr2);
                        iZza = iZzl + iZzz2;
                        iZzy18 += iZza;
                    }
                    break;
                case 55:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        long jZzm = zzm(obj, j);
                        iZzl = zzfx.zzy(i6 << 3);
                        iZzz2 = zzfx.zzz(jZzm);
                        iZza = iZzl + iZzz2;
                        iZzy18 += iZza;
                    }
                    break;
                case 56:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZzy16 = zzfx.zzy(i6 << 3);
                        iZza = iZzy16 + 8;
                        iZzy18 += iZza;
                    }
                    break;
                case 57:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZzy17 = zzfx.zzy(i6 << 3);
                        iZza = iZzy17 + 4;
                        iZzy18 += iZza;
                    }
                    break;
                case 58:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZza = zzfx.zzy(i6 << 3) + 1;
                        iZzy18 += iZza;
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        int i36 = i6 << 3;
                        Object object3 = unsafe.getObject(obj, j);
                        if (object3 instanceof zzfp) {
                            iZzy7 = zzfx.zzy(i36);
                            iZzi = ((zzfp) object3).zzd();
                            iZzy8 = zzfx.zzy(iZzi);
                        } else {
                            iZzy7 = zzfx.zzy(i36);
                            int i37 = zzjc.zza;
                            iZzi = zziz.zzb((String) object3);
                            iZzy8 = zzfx.zzy(iZzi);
                        }
                        iZza = iZzy7 + iZzy8 + iZzi;
                        iZzy18 += iZza;
                    }
                    break;
                case 60:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        int i38 = i6 << 3;
                        Object object4 = unsafe.getObject(obj, j);
                        zzib zzibVarZzt4 = zzhuVar.zzt(i2);
                        int i39 = zzic.zza;
                        iZzy7 = zzfx.zzy(i38);
                        iZzi = ((zzfa) object4).zzi(zzibVarZzt4);
                        iZzy8 = zzfx.zzy(iZzi);
                        iZza = iZzy7 + iZzy8 + iZzi;
                        iZzy18 += iZza;
                    }
                    break;
                case 61:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        zzfp zzfpVar2 = (zzfp) unsafe.getObject(obj, j);
                        iZzy7 = zzfx.zzy(i6 << 3);
                        iZzi = zzfpVar2.zzd();
                        iZzy8 = zzfx.zzy(iZzi);
                        iZza = iZzy7 + iZzy8 + iZzi;
                        iZzy18 += iZza;
                    }
                    break;
                case 62:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        int iZzm = zzm(obj, j);
                        iZzl = zzfx.zzy(i6 << 3);
                        iZzz2 = zzfx.zzy(iZzm);
                        iZza = iZzl + iZzz2;
                        iZzy18 += iZza;
                    }
                    break;
                case 63:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        long jZzm2 = zzm(obj, j);
                        iZzl = zzfx.zzy(i6 << 3);
                        iZzz2 = zzfx.zzz(jZzm2);
                        iZza = iZzl + iZzz2;
                        iZzy18 += iZza;
                    }
                    break;
                case 64:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZzy17 = zzfx.zzy(i6 << 3);
                        iZza = iZzy17 + 4;
                        iZzy18 += iZza;
                    }
                    break;
                case 65:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZzy16 = zzfx.zzy(i6 << 3);
                        iZza = iZzy16 + 8;
                        iZzy18 += iZza;
                    }
                    break;
                case 66:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        int iZzm2 = zzm(obj, j);
                        iZzl = zzfx.zzy(i6 << 3);
                        iZzz2 = zzfx.zzy((iZzm2 >> 31) ^ (iZzm2 + iZzm2));
                        iZza = iZzl + iZzz2;
                        iZzy18 += iZza;
                    }
                    break;
                case 67:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        long jZzr3 = zzr(obj, j);
                        iZzl = zzfx.zzy(i6 << 3);
                        iZzz2 = zzfx.zzz((jZzr3 >> 63) ^ (jZzr3 + jZzr3));
                        iZza = iZzl + iZzz2;
                        iZzy18 += iZza;
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzhuVar.zzM(obj, i6, i2)) {
                        iZza = zzic.zza(i6, (zzhr) unsafe.getObject(obj, j), zzhuVar.zzt(i2));
                        iZzy18 += iZza;
                    }
                    break;
            }
            i2 += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int iHashCode = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzq = zzq(i3);
            int iZzp = zzp(iZzq);
            if (iZzp <= 50 || iZzp >= 69) {
                long j = iZzq & 1048575;
                int iHashCode2 = 37;
                switch (iZzp) {
                    case 0:
                        i = iHashCode * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzix.zza(obj, j));
                        byte[] bArr = zzgv.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 1:
                        i = iHashCode * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzix.zzb(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 2:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j);
                        byte[] bArr2 = zzgv.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 3:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j);
                        byte[] bArr3 = zzgv.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 4:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 5:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j);
                        byte[] bArr4 = zzgv.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 6:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 7:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzgv.zza(zzix.zzt(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 8:
                        i = iHashCode * 53;
                        iFloatToIntBits = ((String) zzix.zzf(obj, j)).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 9:
                        i2 = iHashCode * 53;
                        Object objZzf = zzix.zzf(obj, j);
                        if (objZzf != null) {
                            iHashCode2 = objZzf.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
                        break;
                    case 10:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzf(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 11:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 12:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 13:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 14:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j);
                        byte[] bArr5 = zzgv.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 15:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 16:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzix.zzd(obj, j);
                        byte[] bArr6 = zzgv.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 17:
                        i2 = iHashCode * 53;
                        Object objZzf2 = zzix.zzf(obj, j);
                        if (objZzf2 != null) {
                            iHashCode2 = objZzf2.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
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
                        iFloatToIntBits = zzix.zzf(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 50:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzix.zzf(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                }
            }
        }
        int i4 = this.zzk;
        while (true) {
            int[] iArr = this.zzi;
            if (i4 >= iArr.length) {
                int iHashCode3 = (iHashCode * 53) + ((zzgp) obj).zzc.hashCode();
                return this.zzh ? (iHashCode3 * 53) + ((zzgm) obj).zzb.zza.hashCode() : iHashCode3;
            }
            int i5 = iArr[i4];
            if (!zzM(obj, 0, i5)) {
                iHashCode = (iHashCode * 53) + zzix.zzf(obj, zzq(i5) & 1048575).hashCode();
            }
            i4++;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 39221. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzc(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.play_billing.zzfd r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzhu.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzfd):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final Object zze() {
        return ((zzgp) this.zzg).zzs();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzf(Object obj) {
        if (zzK(obj)) {
            if (obj instanceof zzgp) {
                zzgp zzgpVar = (zzgp) obj;
                zzgpVar.zzC(Integer.MAX_VALUE);
                zzgpVar.zza = 0;
                zzgpVar.zzA();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzq = zzq(i);
                int i2 = 1048575 & iZzq;
                int iZzp = zzp(iZzq);
                long j = i2;
                if (iZzp != 9) {
                    if (iZzp != 60 && iZzp != 68) {
                        switch (iZzp) {
                            case 17:
                                if (zzH(obj, i)) {
                                    zzt(i).zzf(zzb.getObject(obj, j));
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
                                ((zzgu) zzix.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzhm) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzt(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzH(obj, i)) {
                    zzt(i).zzf(zzb.getObject(obj, j));
                }
            }
            ((zzgp) obj).zzc.zzh();
            if (this.zzh) {
                ((zzgm) obj).zzb.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzg(Object obj, Object obj2) {
        zzz(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzic.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzic.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzq = zzq(i);
            int i2 = 1048575 & iZzq;
            int iZzp = zzp(iZzq);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzp) {
                case 0:
                    if (zzH(obj2, i)) {
                        zzix.zzl(obj, j, zzix.zza(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 1:
                    if (zzH(obj2, i)) {
                        zzix.zzm(obj, j, zzix.zzb(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 2:
                    if (zzH(obj2, i)) {
                        zzix.zzo(obj, j, zzix.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 3:
                    if (zzH(obj2, i)) {
                        zzix.zzo(obj, j, zzix.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 4:
                    if (zzH(obj2, i)) {
                        zzix.zzn(obj, j, zzix.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 5:
                    if (zzH(obj2, i)) {
                        zzix.zzo(obj, j, zzix.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 6:
                    if (zzH(obj2, i)) {
                        zzix.zzn(obj, j, zzix.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 7:
                    if (zzH(obj2, i)) {
                        zzix.zzk(obj, j, zzix.zzt(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 8:
                    if (zzH(obj2, i)) {
                        zzix.zzp(obj, j, zzix.zzf(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 9:
                    zzA(obj, obj2, i);
                    break;
                case 10:
                    if (zzH(obj2, i)) {
                        zzix.zzp(obj, j, zzix.zzf(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 11:
                    if (zzH(obj2, i)) {
                        zzix.zzn(obj, j, zzix.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 12:
                    if (zzH(obj2, i)) {
                        zzix.zzn(obj, j, zzix.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 13:
                    if (zzH(obj2, i)) {
                        zzix.zzn(obj, j, zzix.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 14:
                    if (zzH(obj2, i)) {
                        zzix.zzo(obj, j, zzix.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 15:
                    if (zzH(obj2, i)) {
                        zzix.zzn(obj, j, zzix.zzc(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 16:
                    if (zzH(obj2, i)) {
                        zzix.zzo(obj, j, zzix.zzd(obj2, j));
                        zzC(obj, i);
                    }
                    break;
                case 17:
                    zzA(obj, obj2, i);
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
                    zzgu zzguVarZzd = (zzgu) zzix.zzf(obj, j);
                    zzgu zzguVar = (zzgu) zzix.zzf(obj2, j);
                    int size = zzguVarZzd.size();
                    int size2 = zzguVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzguVarZzd.zzc()) {
                            zzguVarZzd = zzguVarZzd.zzd(size2 + size);
                        }
                        zzguVarZzd.addAll(zzguVar);
                    }
                    if (size > 0) {
                        zzguVar = zzguVarZzd;
                    }
                    zzix.zzp(obj, j, zzguVar);
                    break;
                case 50:
                    int i4 = zzic.zza;
                    zzix.zzp(obj, j, zzhn.zza(zzix.zzf(obj, j), zzix.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzix.zzp(obj, j, zzix.zzf(obj2, j));
                        zzD(obj, i3, i);
                    }
                    break;
                case 60:
                    zzB(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzix.zzp(obj, j, zzix.zzf(obj2, j));
                        zzD(obj, i3, i);
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    zzB(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzfd zzfdVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzfdVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final void zzi(Object obj, zzji zzjiVar) throws IOException {
        Map.Entry entry;
        int i;
        zzhu<T> zzhuVar = this;
        if (zzhuVar.zzh) {
            zzgh zzghVar = ((zzgm) obj).zzb;
            if (zzghVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzghVar.zzf().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = zzhuVar.zzc;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < iArr.length) {
            int iZzq = zzhuVar.zzq(i4);
            int iZzp = zzp(iZzq);
            int i6 = iArr[i4];
            if (iZzp <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = i8 == i2 ? 0 : unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            if (entry != null) {
                throw null;
            }
            long j = iZzq & i2;
            switch (iZzp) {
                case 0:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzf(i6, zzix.zza(obj, j));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 1:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzo(i6, zzix.zzb(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 2:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzt(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 3:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzL(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 4:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzr(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 5:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzm(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 6:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzk(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 7:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzb(i6, zzix.zzt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 8:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzP(i6, unsafe.getObject(obj, j), zzjiVar);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 9:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzw(i6, unsafe.getObject(obj, j), zzhuVar.zzt(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 10:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzd(i6, (zzfp) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 11:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzJ(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 12:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzi(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 13:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzy(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 14:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzA(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 15:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzC(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 16:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzE(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 17:
                    if (zzhuVar.zzI(obj, i4, i3, i5, i)) {
                        zzjiVar.zzq(i6, unsafe.getObject(obj, j), zzhuVar.zzt(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 18:
                    zzic.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 19:
                    zzic.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 20:
                    zzic.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 21:
                    zzic.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 22:
                    zzic.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 23:
                    zzic.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 24:
                    zzic.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 25:
                    zzic.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 26:
                    int i9 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    int i10 = zzic.zza;
                    if (list != null && !list.isEmpty()) {
                        zzjiVar.zzI(i9, list);
                    }
                    break;
                case 27:
                    int i11 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzib zzibVarZzt = zzhuVar.zzt(i4);
                    int i12 = zzic.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i13 = 0; i13 < list2.size(); i13++) {
                            ((zzfy) zzjiVar).zzw(i11, list2.get(i13), zzibVarZzt);
                        }
                    }
                    break;
                case 28:
                    int i14 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzic.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzjiVar.zze(i14, list3);
                    }
                    break;
                case 29:
                    zzic.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 30:
                    zzic.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 31:
                    zzic.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 32:
                    zzic.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 33:
                    zzic.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 34:
                    zzic.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzhuVar = this;
                    break;
                case 35:
                    zzic.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 36:
                    zzic.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 37:
                    zzic.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 38:
                    zzic.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 39:
                    zzic.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 40:
                    zzic.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 41:
                    zzic.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 42:
                    zzic.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 43:
                    zzic.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 44:
                    zzic.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 45:
                    zzic.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 46:
                    zzic.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 47:
                    zzic.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 48:
                    zzic.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzjiVar, true);
                    break;
                case 49:
                    int i16 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzib zzibVarZzt2 = zzhuVar.zzt(i4);
                    int i17 = zzic.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            ((zzfy) zzjiVar).zzq(i16, list4.get(i18), zzibVarZzt2);
                        }
                    }
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j);
                    if (object != null) {
                        zzjiVar.zzv(i6, ((zzhl) zzhuVar.zzv(i4)).zzc(), (zzhm) object);
                    }
                    break;
                case 51:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzf(i6, ((Double) zzix.zzf(obj, j)).doubleValue());
                    }
                    break;
                case 52:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzo(i6, ((Float) zzix.zzf(obj, j)).floatValue());
                    }
                    break;
                case 53:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzt(i6, zzr(obj, j));
                    }
                    break;
                case 54:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzL(i6, zzr(obj, j));
                    }
                    break;
                case 55:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzr(i6, zzm(obj, j));
                    }
                    break;
                case 56:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzm(i6, zzr(obj, j));
                    }
                    break;
                case 57:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzk(i6, zzm(obj, j));
                    }
                    break;
                case 58:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzb(i6, ((Boolean) zzix.zzf(obj, j)).booleanValue());
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzP(i6, unsafe.getObject(obj, j), zzjiVar);
                    }
                    break;
                case 60:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzw(i6, unsafe.getObject(obj, j), zzhuVar.zzt(i4));
                    }
                    break;
                case 61:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzd(i6, (zzfp) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzJ(i6, zzm(obj, j));
                    }
                    break;
                case 63:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzi(i6, zzm(obj, j));
                    }
                    break;
                case 64:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzy(i6, zzm(obj, j));
                    }
                    break;
                case 65:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzA(i6, zzr(obj, j));
                    }
                    break;
                case 66:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzC(i6, zzm(obj, j));
                    }
                    break;
                case 67:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzE(i6, zzr(obj, j));
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzhuVar.zzM(obj, i6, i4)) {
                        zzjiVar.zzq(i6, unsafe.getObject(obj, j), zzhuVar.zzt(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
            zzhuVar = this;
        }
        if (entry != null) {
            throw null;
        }
        ((zzgp) obj).zzc.zzl(zzjiVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzib
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzq = zzq(i);
            int iZzp = zzp(iZzq);
            if (iZzp <= 50 || iZzp >= 69) {
                long j = iZzq & 1048575;
                switch (iZzp) {
                    case 0:
                        if (!zzG(obj, obj2, i) || Double.doubleToLongBits(zzix.zza(obj, j)) != Double.doubleToLongBits(zzix.zza(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 1:
                        if (!zzG(obj, obj2, i) || Float.floatToIntBits(zzix.zzb(obj, j)) != Float.floatToIntBits(zzix.zzb(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 2:
                        if (!zzG(obj, obj2, i) || zzix.zzd(obj, j) != zzix.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 3:
                        if (!zzG(obj, obj2, i) || zzix.zzd(obj, j) != zzix.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 4:
                        if (!zzG(obj, obj2, i) || zzix.zzc(obj, j) != zzix.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 5:
                        if (!zzG(obj, obj2, i) || zzix.zzd(obj, j) != zzix.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 6:
                        if (!zzG(obj, obj2, i) || zzix.zzc(obj, j) != zzix.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 7:
                        if (!zzG(obj, obj2, i) || zzix.zzt(obj, j) != zzix.zzt(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 8:
                        if (!zzG(obj, obj2, i) || !zzic.zzE(zzix.zzf(obj, j), zzix.zzf(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 9:
                        if (!zzG(obj, obj2, i) || !zzic.zzE(zzix.zzf(obj, j), zzix.zzf(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 10:
                        if (!zzG(obj, obj2, i) || !zzic.zzE(zzix.zzf(obj, j), zzix.zzf(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 11:
                        if (!zzG(obj, obj2, i) || zzix.zzc(obj, j) != zzix.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 12:
                        if (!zzG(obj, obj2, i) || zzix.zzc(obj, j) != zzix.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 13:
                        if (!zzG(obj, obj2, i) || zzix.zzc(obj, j) != zzix.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 14:
                        if (!zzG(obj, obj2, i) || zzix.zzd(obj, j) != zzix.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 15:
                        if (!zzG(obj, obj2, i) || zzix.zzc(obj, j) != zzix.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 16:
                        if (!zzG(obj, obj2, i) || zzix.zzd(obj, j) != zzix.zzd(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 17:
                        if (!zzG(obj, obj2, i) || !zzic.zzE(zzix.zzf(obj, j), zzix.zzf(obj2, j))) {
                            return false;
                        }
                        continue;
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
                        zZzE = zzic.zzE(zzix.zzf(obj, j), zzix.zzf(obj2, j));
                        break;
                    case 50:
                        zZzE = zzic.zzE(zzix.zzf(obj, j), zzix.zzf(obj2, j));
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
                        if (!zzL(obj, obj2, i) || !zzic.zzE(zzix.zzf(obj, j), zzix.zzf(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    default:
                        continue;
                }
                if (!zZzE) {
                    return false;
                }
            }
        }
        int i2 = this.zzk;
        while (true) {
            int[] iArr = this.zzi;
            if (i2 >= iArr.length) {
                if (!((zzgp) obj).zzc.equals(((zzgp) obj2).zzc)) {
                    return false;
                }
                if (this.zzh) {
                    return ((zzgm) obj).zzb.equals(((zzgm) obj2).zzb);
                }
                return true;
            }
            int i3 = iArr[i2];
            if (!zzL(obj, obj2, i3)) {
                return false;
            }
            if (!zzM(obj, 0, i3)) {
                long jZzq = zzq(i3) & 1048575;
                if (!zzic.zzE(zzix.zzf(obj, jZzq), zzix.zzf(obj2, jZzq))) {
                    return false;
                }
            }
            i2++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00be  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e3 A[LOOP:2: B:52:0x00d2->B:57:0x00e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00f7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzib
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzib zzibVarZzt;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzj) {
            int i7 = this.zzi[i4];
            int iZzq = this.zzq(i7);
            int[] iArr = this.zzc;
            int i8 = iArr[i7 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i6) {
                if (i9 != 1048575) {
                    i5 = zzb.getInt(obj, i9);
                }
                i2 = i5;
                i = i9;
            } else {
                i = i6;
                i2 = i5;
            }
            zzhu<T> zzhuVar = this;
            Object obj2 = obj;
            if ((268435456 & iZzq) != 0 && !zzhuVar.zzI(obj2, i7, i, i2, i10)) {
                return false;
            }
            int iZzp = zzp(iZzq);
            if (iZzp == 9 || iZzp == 17) {
                if (zzhuVar.zzI(obj2, i7, i, i2, i10) && !zzJ(obj2, iZzq, zzhuVar.zzt(i7))) {
                    return false;
                }
            } else if (iZzp == 27) {
                list = (List) zzix.zzf(obj2, iZzq & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzibVarZzt = zzhuVar.zzt(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzibVarZzt.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzp == 60 || iZzp == 68) {
                if (zzhuVar.zzM(obj2, iArr[i7], i7) && !zzJ(obj2, iZzq, zzhuVar.zzt(i7))) {
                    return false;
                }
            } else if (iZzp == 49) {
                list = (List) zzix.zzf(obj2, iZzq & 1048575);
                if (list.isEmpty()) {
                    zzibVarZzt = zzhuVar.zzt(i7);
                    while (i3 < list.size()) {
                        if (!zzibVarZzt.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzp != 50) {
                continue;
            } else {
                zzhm zzhmVar = (zzhm) zzix.zzf(obj2, iZzq & 1048575);
                if (!zzhmVar.isEmpty() && ((zzhl) zzhuVar.zzv(i7)).zzc().zzc.zzb() == zzjh.MESSAGE) {
                    zzib zzibVarZzb = null;
                    for (Object obj3 : zzhmVar.values()) {
                        if (zzibVarZzb == null) {
                            zzibVarZzb = zzhy.zza().zzb(obj3.getClass());
                        }
                        if (!zzibVarZzb.zzk(obj3)) {
                            return false;
                        }
                    }
                }
            }
            i4++;
            this = zzhuVar;
            obj = obj2;
            i6 = i;
            i5 = i2;
        }
        return !this.zzh || ((zzgm) obj).zzb.zzj();
    }
}
