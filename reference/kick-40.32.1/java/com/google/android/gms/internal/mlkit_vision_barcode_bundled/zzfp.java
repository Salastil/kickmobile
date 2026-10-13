package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.eac.EACTags;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.3.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzfp<T> implements zzge<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgz.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzgs zzl;
    private final zzdt zzm;

    private zzfp(int[] iArr, Object[] objArr, int i, int i2, zzfm zzfmVar, boolean z, int[] iArr2, int i3, int i4, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzdtVar != null && (zzfmVar instanceof zzed)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzgsVar;
        this.zzm = zzdtVar;
        this.zzg = zzfmVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzgz.zzq(obj, j, (1 << (iZzp >>> 20)) | zzgz.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzgz.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzp >>> 20)) & zzgz.zzc(obj, j)) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzgz.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzgz.zzb(obj, j2)) != 0;
            case 2:
                return zzgz.zzd(obj, j2) != 0;
            case 3:
                return zzgz.zzd(obj, j2) != 0;
            case 4:
                return zzgz.zzc(obj, j2) != 0;
            case 5:
                return zzgz.zzd(obj, j2) != 0;
            case 6:
                return zzgz.zzc(obj, j2) != 0;
            case 7:
                return zzgz.zzw(obj, j2);
            case 8:
                Object objZzf = zzgz.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzdf) {
                    return !zzdf.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzgz.zzf(obj, j2) != null;
            case 10:
                return !zzdf.zzb.equals(zzgz.zzf(obj, j2));
            case 11:
                return zzgz.zzc(obj, j2) != 0;
            case 12:
                return zzgz.zzc(obj, j2) != 0;
            case 13:
                return zzgz.zzc(obj, j2) != 0;
            case 14:
                return zzgz.zzd(obj, j2) != 0;
            case 15:
                return zzgz.zzc(obj, j2) != 0;
            case 16:
                return zzgz.zzd(obj, j2) != 0;
            case 17:
                return zzgz.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzge zzgeVar) {
        return zzgeVar.zzk(zzgz.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzY();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzgz.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzgz.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhh zzhhVar) throws IOException {
        if (obj instanceof String) {
            zzhhVar.zzG(i, (String) obj);
        } else {
            zzhhVar.zzd(i, (zzdf) obj);
        }
    }

    static zzgt zzd(Object obj) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        if (zzgtVar != zzgt.zzc()) {
            return zzgtVar;
        }
        zzgt zzgtVarZzf = zzgt.zzf();
        zzehVar.zzc = zzgtVarZzf;
        return zzgtVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x026d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0270  */
    /* JADX WARN: Code duplicated, block: B:130:0x028a  */
    /* JADX WARN: Code duplicated, block: B:131:0x028d  */
    /* JADX WARN: Code duplicated, block: B:170:0x034e  */
    /* JADX WARN: Code duplicated, block: B:185:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ad  */
    static zzfp zzl(Class cls, zzfj zzfjVar, zzfs zzfsVar, zzez zzezVar, zzgs zzgsVar, zzdt zzdtVar, zzfh zzfhVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char cCharAt;
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
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        char c;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZzz2;
        int i27;
        Object obj2;
        Field fieldZzz3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(zzfjVar instanceof zzfw)) {
            throw null;
        }
        zzfw zzfwVar = (zzfw) zzfjVar;
        String strZzd = zzfwVar.zzd();
        int length = strZzd.length();
        char c2 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (strZzd.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i34 = iCharAt2 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = strZzd.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt2 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
            iArr = zza;
            i7 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt3 = strZzd.charAt(i33);
            if (iCharAt3 >= 55296) {
                int i37 = iCharAt3 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = strZzd.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt3 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt4 = strZzd.charAt(i36);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
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
                iCharAt4 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt5 = strZzd.charAt(i39);
            if (iCharAt5 >= 55296) {
                int i43 = iCharAt5 & 8191;
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
                iCharAt5 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt6 = strZzd.charAt(i42);
            if (iCharAt6 >= 55296) {
                int i46 = iCharAt6 & 8191;
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
                iCharAt6 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt = strZzd.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
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
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt7 = strZzd.charAt(i48);
            if (iCharAt7 >= 55296) {
                int i52 = iCharAt7 & 8191;
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
                iCharAt7 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt8 = strZzd.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
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
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int iCharAt9 = strZzd.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
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
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i8;
            }
            int i60 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i61 = iCharAt7;
            i2 = iCharAt5;
            i3 = i61;
            i4 = iCharAt6;
            i5 = iCharAt9;
            i6 = i60;
            iArr = iArr2;
            i7 = iCharAt3;
            i33 = i57;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzfwVar.zze();
        Class<?> cls2 = zzfwVar.zza().getClass();
        int i62 = i5 + i3;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i5;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i33 < length) {
            int i68 = i33 + 1;
            int iCharAt10 = strZzd.charAt(i33);
            if (iCharAt10 >= c2) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i30 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i30;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i16 = i30;
            } else {
                i16 = i68;
            }
            int i72 = i16 + 1;
            int iCharAt11 = strZzd.charAt(i16);
            if (iCharAt11 >= c2) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i29 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c2) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i29;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i17 = i29;
            } else {
                i17 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            zzfw zzfwVar2 = zzfwVar;
            int i77 = iCharAt11 & 2048;
            if (i76 >= 51) {
                int i78 = i17 + 1;
                int iCharAt12 = strZzd.charAt(i17);
                char c3 = 55296;
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i28 = i80 + 1;
                        cCharAt10 = strZzd.charAt(i80);
                        if (cCharAt10 < c3) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i80 = i28;
                        c3 = 55296;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i81);
                    i23 = i28;
                } else {
                    i23 = i78;
                }
                int i82 = i23;
                int i83 = i76 - 51;
                if (i83 == 9 || i83 == 17) {
                    i24 = i6 + 1;
                    int i84 = i67 / 3;
                    objArr[i84 + i84 + 1] = objArrZze[i6];
                } else {
                    if (i83 != 12) {
                        i25 = i77;
                    } else if (zzfwVar2.zzc() == 1 || i77 != 0) {
                        i24 = i6 + 1;
                        int i85 = i67 / 3;
                        objArr[i85 + i85 + 1] = objArrZze[i6];
                    } else {
                        i25 = 0;
                    }
                    i26 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i26];
                    int i86 = i25;
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i26] = fieldZzz2;
                    }
                    int i87 = i7;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i27 = i26 + 1;
                    obj2 = objArrZze[i27];
                    i18 = i87;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i27] = fieldZzz3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    strZzd = strZzd;
                    i20 = i86;
                    i17 = i82;
                    i19 = 0;
                    c = 55296;
                }
                i6 = i24;
                i25 = i77;
                i26 = iCharAt12 + iCharAt12;
                obj = objArrZze[i26];
                int i88 = i25;
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i26] = fieldZzz2;
                }
                int i89 = i7;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz2);
                i27 = i26 + 1;
                obj2 = objArrZze[i27];
                i18 = i89;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i27] = fieldZzz3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                strZzd = strZzd;
                i20 = i88;
                i17 = i82;
                i19 = 0;
                c = 55296;
            } else {
                i18 = i7;
                int i90 = i6 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i6]);
                if (i76 == 9 || i76 == 17) {
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldZzz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i6 += 2;
                            i22 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (zzfwVar2.zzc() == 1 || i77 != 0) {
                                i6 += 2;
                                int i92 = i67 / 3;
                                objArr[i92 + i92 + 1] = objArrZze[i90];
                            } else {
                                i6 = i90;
                                i77 = 0;
                            }
                        } else if (i76 == 50) {
                            int i93 = i6 + 2;
                            int i94 = i64 + 1;
                            iArr[i64] = i67;
                            int i95 = i67 / 3;
                            int i96 = i95 + i95;
                            objArr[i96] = objArrZze[i90];
                            if (i77 != 0) {
                                objArr[i96 + 1] = objArrZze[i93];
                                i6 += 3;
                                i64 = i94;
                            } else {
                                i6 = i93;
                                i64 = i94;
                                i77 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            c = 55296;
                            iObjectFieldOffset2 = 1048575;
                            i19 = 0;
                        } else {
                            int i97 = i17 + 1;
                            int iCharAt13 = strZzd.charAt(i17);
                            if (iCharAt13 >= 55296) {
                                int i98 = iCharAt13 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i21 = i97 + 1;
                                    cCharAt9 = strZzd.charAt(i97);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i98 |= (cCharAt9 & 8191) << i99;
                                    i99 += 13;
                                    i97 = i21;
                                }
                                iCharAt13 = i98 | (cCharAt9 << i99);
                            } else {
                                i21 = i97;
                            }
                            int i100 = i18 + i18 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i100];
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i100] = fieldZzz;
                            }
                            int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz);
                            i19 = iCharAt13 % 32;
                            i17 = i21;
                            c = 55296;
                            iObjectFieldOffset2 = iObjectFieldOffset3;
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i20 = i77;
                    } else {
                        i22 = 1;
                        i6 += 2;
                    }
                    int i101 = i67 / 3;
                    objArr[i101 + i101 + i22] = objArrZze[i90];
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    if ((iCharAt11 & 4096) != 0) {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    } else {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i20 = i77;
                }
                i6 = i90;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                if ((iCharAt11 & 4096) != 0) {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                } else {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i20 = i77;
            }
            int i102 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i103 = i67 + 2;
            iArr3[i102] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i20 != 0 ? Integer.MIN_VALUE : 0) | (i76 << 20) | iObjectFieldOffset;
            i67 += 3;
            iArr3[i103] = (i19 << 20) | iObjectFieldOffset2;
            i33 = i17;
            strZzd = strZzd;
            c2 = c;
            zzfwVar = zzfwVar2;
            length = length;
            i7 = i18;
        }
        return new zzfp(iArr3, objArr, i2, i4, zzfwVar.zza(), false, iArr, i5, i62, zzfsVar, zzezVar, zzgsVar, zzdtVar, zzfhVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzgz.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzgz.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzgz.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzgz.zzf(obj, j)).longValue();
    }

    private final zzel zzu(int i) {
        int i2 = i / 3;
        return (zzel) this.zzd[i2 + i2 + 1];
    }

    private final zzge zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzge zzgeVar = (zzge) objArr[i3];
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzge zzgeVarZzb = zzfu.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzgeVarZzb;
        return zzgeVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzge zzgeVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzge zzgeVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:141:0x038a  */
    /* JADX WARN: Code duplicated, block: B:211:0x054c  */
    /* JADX WARN: Code duplicated, block: B:280:0x0710 A[PHI: r0
      0x0710: PHI (r0v9 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>) = 
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v46 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp<T>)
     binds: [B:18:0x004f, B:278:0x0703, B:243:0x0639, B:276:0x06fb, B:218:0x057f, B:135:0x036a, B:132:0x0353, B:129:0x033c, B:126:0x0325, B:123:0x030e, B:120:0x02f6, B:117:0x02de, B:114:0x02c6, B:111:0x02ac, B:108:0x0294, B:105:0x027c, B:102:0x0264, B:99:0x024c, B:96:0x0234, B:82:0x01e0, B:84:0x01ee, B:78:0x01c4, B:74:0x01b4, B:70:0x019d, B:67:0x0188, B:64:0x0172, B:61:0x0165, B:58:0x0158, B:55:0x0149, B:49:0x011f, B:46:0x010b, B:42:0x00ed, B:39:0x00d7, B:36:0x00c0, B:33:0x00b2, B:30:0x00a4, B:27:0x0089, B:24:0x006e, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(Object obj) {
        int i;
        int iZzA;
        int iZzA2;
        int iZzB;
        int iZzA3;
        int iZzA4;
        int iZzA5;
        int iZzd;
        int iZzA6;
        int iZzh;
        int iZzg;
        int size;
        int iZzl;
        int iZzA7;
        int iZzA8;
        int iZzA9;
        int iZzB2;
        int iZze;
        int iZzA10;
        int iZzA11;
        int iZzw;
        int iZzA12;
        int iZzA13;
        int iZzA14;
        int iZzd2;
        int iZzA15;
        zzfp<T> zzfpVar = this;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 0;
        int i4 = 0;
        int iZzA16 = 0;
        int i5 = 1048575;
        while (i3 < zzfpVar.zzc.length) {
            int iZzs = zzfpVar.zzs(i3);
            int iZzr = zzr(iZzs);
            int[] iArr = zzfpVar.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzr <= 17) {
                if (i8 != i5) {
                    i4 = i8 == i2 ? 0 : unsafe.getInt(obj, i8);
                    i5 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzs & i2;
            if (iZzr >= zzdy.DOUBLE_LIST_PACKED.zza()) {
                zzdy.SINT64_LIST_PACKED.zza();
            }
            int i10 = iZzA16;
            long j = i9;
            switch (iZzr) {
                case 0:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzA16 = i10 + zzdn.zzA(i6 << 3) + 8;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        iZzA4 = iZzA + 4;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA2 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j2);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzA2 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j3);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzA2 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j4);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzA4 = iZzA3 + 8;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        iZzA4 = iZzA + 4;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzA4 = zzdn.zzA(i6 << 3) + 1;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        int i11 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzdf) {
                            iZzA5 = zzdn.zzA(i11);
                            iZzd = ((zzdf) object).zzd();
                            iZzA6 = zzdn.zzA(iZzd);
                            iZzA4 = iZzA5 + iZzA6 + iZzd;
                            iZzA16 = i10 + iZzA4;
                            zzfpVar = this;
                            i3 += 3;
                            i2 = 1048575;
                        } else {
                            iZzA2 = zzdn.zzA(i11);
                            iZzB = zzdn.zzz((String) object);
                            iZzA4 = iZzA2 + iZzB;
                            iZzA16 = i10 + iZzA4;
                            zzfpVar = this;
                            i3 += 3;
                            i2 = 1048575;
                        }
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzh = zzgg.zzh(i6, unsafe.getObject(obj, j), zzfpVar.zzv(i3));
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        zzdf zzdfVar = (zzdf) unsafe.getObject(obj, j);
                        iZzA5 = zzdn.zzA(i6 << 3);
                        iZzd = zzdfVar.zzd();
                        iZzA6 = zzdn.zzA(iZzd);
                        iZzA4 = iZzA5 + iZzA6 + iZzd;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzA2 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA(i12);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzA2 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB(j5);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzA = zzdn.zzA(i6 << 3);
                        iZzA4 = iZzA + 4;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzA3 = zzdn.zzA(i6 << 3);
                        iZzA4 = iZzA3 + 8;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzA2 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzA((i13 >> 31) ^ (i13 + i13));
                        iZzA4 = iZzA2 + iZzB;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzA2 = zzdn.zzA(i6 << 3);
                        iZzB = zzdn.zzB((j6 >> 63) ^ (j6 + j6));
                        iZzA4 = iZzA2 + iZzB;
                        iZzA16 = i10 + iZzA4;
                        zzfpVar = this;
                        i3 += 3;
                        i2 = 1048575;
                    }
                    zzfpVar = this;
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzfpVar.zzJ(obj, i3, i5, i4, i)) {
                        iZzh = zzdn.zzw(i6, (zzfm) unsafe.getObject(obj, j), zzfpVar.zzv(i3));
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 18:
                    iZzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 19:
                    iZzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzgg.zza;
                    if (list.size() == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzgg.zzg(list) + (list.size() * zzdn.zzA(i6 << 3));
                    }
                    iZzA16 = iZzg + i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zzgg.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgg.zzl(list2);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzh = iZzl + iZzB2;
                    }
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzgg.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgg.zzf(list3);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzh = iZzl + iZzB2;
                    }
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 23:
                    iZzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 24:
                    iZzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgg.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = size2 * (zzdn.zzA(i6 << 3) + 1);
                    }
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i18 = zzgg.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzdn.zzA(i6 << 3) * size3;
                        if (list5 instanceof zzey) {
                            zzey zzeyVar = (zzey) list5;
                            for (int i19 = 0; i19 < size3; i19++) {
                                Object objZza = zzeyVar.zza();
                                if (objZza instanceof zzdf) {
                                    int iZzd3 = ((zzdf) objZza).zzd();
                                    iZzg += zzdn.zzA(iZzd3) + iZzd3;
                                } else {
                                    iZzg += zzdn.zzz((String) objZza);
                                }
                            }
                        } else {
                            for (int i20 = 0; i20 < size3; i20++) {
                                Object obj2 = list5.get(i20);
                                if (obj2 instanceof zzdf) {
                                    int iZzd4 = ((zzdf) obj2).zzd();
                                    iZzg += zzdn.zzA(iZzd4) + iZzd4;
                                } else {
                                    iZzg += zzdn.zzz((String) obj2);
                                }
                            }
                        }
                    }
                    iZzA16 = iZzg + i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv = zzfpVar.zzv(i3);
                    int i21 = zzgg.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzA8 = 0;
                    } else {
                        iZzA8 = zzdn.zzA(i6 << 3) * size4;
                        for (int i22 = 0; i22 < size4; i22++) {
                            Object obj3 = list6.get(i22);
                            if (obj3 instanceof zzex) {
                                int iZza = ((zzex) obj3).zza();
                                iZzA8 += zzdn.zzA(iZza) + iZza;
                            } else {
                                iZzA8 += zzdn.zzy((zzfm) obj3, zzgeVarZzv);
                            }
                        }
                    }
                    iZzA16 = i10 + iZzA8;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzgg.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzA9 = 0;
                    } else {
                        iZzA9 = size5 * zzdn.zzA(i6 << 3);
                        for (int i24 = 0; i24 < list7.size(); i24++) {
                            int iZzd5 = ((zzdf) list7.get(i24)).zzd();
                            iZzA9 += zzdn.zzA(iZzd5) + iZzd5;
                        }
                    }
                    iZzA16 = i10 + iZzA9;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i25 = zzgg.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgg.zzk(list8);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzh = iZzl + iZzB2;
                    }
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i26 = zzgg.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgg.zza(list9);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzh = iZzl + iZzB2;
                    }
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 31:
                    iZzh = zzgg.zzb(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 32:
                    iZzh = zzgg.zzd(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i27 = zzgg.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgg.zzi(list10);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzh = iZzl + iZzB2;
                    }
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i28 = zzgg.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgg.zzj(list11);
                        iZzA7 = zzdn.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzh = iZzl + iZzB2;
                    }
                    iZzA16 = i10 + iZzh;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zzgg.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zzgg.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zzgg.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i29 = zzgg.zza;
                    iZze = list12.size();
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zzgg.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zzgg.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zzgg.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zzgg.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zzgg.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 48:
                    iZze = zzgg.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzA10 = zzdn.zzA(i6 << 3);
                        iZzA11 = zzdn.zzA(iZze);
                        iZzA9 = iZzA10 + iZzA11 + iZze;
                        iZzA16 = i10 + iZzA9;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv2 = zzfpVar.zzv(i3);
                    int i30 = zzgg.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzw = 0;
                    } else {
                        iZzw = 0;
                        for (int i31 = 0; i31 < size6; i31++) {
                            iZzw += zzdn.zzw(i6, (zzfm) list13.get(i31), zzgeVarZzv2);
                        }
                    }
                    iZzA16 = i10 + iZzw;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 50:
                    zzfg zzfgVar = (zzfg) unsafe.getObject(obj, j);
                    if (!zzfgVar.isEmpty()) {
                        Iterator it = zzfgVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 51:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzA12 = zzdn.zzA(i6 << 3);
                        iZzh = iZzA12 + 8;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzA13 = zzdn.zzA(i6 << 3);
                        iZzh = iZzA13 + 4;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 53:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        long jZzt = zzt(obj, j);
                        iZzl = zzdn.zzA(i6 << 3);
                        iZzB2 = zzdn.zzB(jZzt);
                        iZzh = iZzl + iZzB2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 54:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        long jZzt2 = zzt(obj, j);
                        iZzl = zzdn.zzA(i6 << 3);
                        iZzB2 = zzdn.zzB(jZzt2);
                        iZzh = iZzl + iZzB2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 55:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        long jZzo = zzo(obj, j);
                        iZzl = zzdn.zzA(i6 << 3);
                        iZzB2 = zzdn.zzB(jZzo);
                        iZzh = iZzl + iZzB2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzA12 = zzdn.zzA(i6 << 3);
                        iZzh = iZzA12 + 8;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzA13 = zzdn.zzA(i6 << 3);
                        iZzh = iZzA13 + 4;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 58:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzh = zzdn.zzA(i6 << 3) + 1;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        int i32 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzdf) {
                            iZzA14 = zzdn.zzA(i32);
                            iZzd2 = ((zzdf) object2).zzd();
                            iZzA15 = zzdn.zzA(iZzd2);
                            iZzh = iZzA14 + iZzA15 + iZzd2;
                            iZzA16 = i10 + iZzh;
                        } else {
                            iZzl = zzdn.zzA(i32);
                            iZzB2 = zzdn.zzz((String) object2);
                            iZzh = iZzl + iZzB2;
                            iZzA16 = i10 + iZzh;
                        }
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 60:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzh = zzgg.zzh(i6, unsafe.getObject(obj, j), zzfpVar.zzv(i3));
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 61:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        zzdf zzdfVar2 = (zzdf) unsafe.getObject(obj, j);
                        iZzA14 = zzdn.zzA(i6 << 3);
                        iZzd2 = zzdfVar2.zzd();
                        iZzA15 = zzdn.zzA(iZzd2);
                        iZzh = iZzA14 + iZzA15 + iZzd2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        int iZzo = zzo(obj, j);
                        iZzl = zzdn.zzA(i6 << 3);
                        iZzB2 = zzdn.zzA(iZzo);
                        iZzh = iZzl + iZzB2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 63:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        long jZzo2 = zzo(obj, j);
                        iZzl = zzdn.zzA(i6 << 3);
                        iZzB2 = zzdn.zzB(jZzo2);
                        iZzh = iZzl + iZzB2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzA13 = zzdn.zzA(i6 << 3);
                        iZzh = iZzA13 + 4;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 65:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzA12 = zzdn.zzA(i6 << 3);
                        iZzh = iZzA12 + 8;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 66:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        int iZzo2 = zzo(obj, j);
                        iZzl = zzdn.zzA(i6 << 3);
                        iZzB2 = zzdn.zzA((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        iZzh = iZzl + iZzB2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        long jZzt3 = zzt(obj, j);
                        iZzl = zzdn.zzA(i6 << 3);
                        iZzB2 = zzdn.zzB((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        iZzh = iZzl + iZzB2;
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzfpVar.zzM(obj, i6, i3)) {
                        iZzh = zzdn.zzw(i6, (zzfm) unsafe.getObject(obj, j), zzfpVar.zzv(i3));
                        iZzA16 = i10 + iZzh;
                    } else {
                        iZzA16 = i10;
                    }
                    i3 += 3;
                    i2 = 1048575;
                    break;
                default:
                    iZzA16 = i10;
                    i3 += 3;
                    i2 = 1048575;
                    break;
            }
        }
        int iZza2 = iZzA16 + ((zzeh) obj).zzc.zza();
        if (!zzfpVar.zzh) {
            return iZza2;
        }
        zzdx zzdxVar = ((zzed) obj).zzb;
        int iZzc = zzdxVar.zza.zzc();
        int iZza3 = 0;
        for (int i33 = 0; i33 < iZzc; i33++) {
            Map.Entry entryZzg = zzdxVar.zza.zzg(i33);
            iZza3 += zzdx.zza((zzdw) ((zzgi) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry2 : zzdxVar.zza.zzd()) {
            iZza3 += zzdx.zza((zzdw) entry2.getKey(), entry2.getValue());
        }
        return iZza2 + iZza3;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzs = zzs(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzgz.zza(obj, j));
                    byte[] bArr = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzgz.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr2 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr3 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr4 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzep.zza(zzgz.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzgz.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr5 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzgz.zzd(obj, j);
                    byte[] bArr6 = zzep.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzgz.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzep.zza(zzN(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzgz.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzep.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzM(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzgz.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + ((zzeh) obj).zzc.hashCode();
        return this.zzh ? (iHashCode2 * 53) + ((zzed) obj).zzb.zza.hashCode() : iHashCode2;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 36601. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    final int zzc(java.lang.Object r36, byte[] r37, int r38, int r39, int r40, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu r41) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        return ((zzeh) this.zzg).zzK();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x0077  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzeh) {
                zzeh zzehVar = (zzeh) obj;
                zzehVar.zzW(Integer.MAX_VALUE);
                zzehVar.zza = 0;
                zzehVar.zzU();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzs = zzs(i);
                int i2 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzv(i).zzf(zzb.getObject(obj, j));
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
                                ((zzeo) zzgz.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzfg) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, this.zzc[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzgz.zzo(obj, j, zzgz.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzgz.zzp(obj, j, zzgz.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzgz.zzm(obj, j, zzgz.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzgz.zzq(obj, j, zzgz.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzgz.zzr(obj, j, zzgz.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    zzeo zzeoVarZzd = (zzeo) zzgz.zzf(obj, j);
                    zzeo zzeoVar = (zzeo) zzgz.zzf(obj2, j);
                    int size = zzeoVarZzd.size();
                    int size2 = zzeoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzeoVarZzd.zzc()) {
                            zzeoVarZzd = zzeoVarZzd.zzd(size2 + size);
                        }
                        zzeoVarZzd.addAll(zzeoVar);
                    }
                    if (size > 0) {
                        zzeoVar = zzeoVarZzd;
                    }
                    zzgz.zzs(obj, j, zzeoVar);
                    break;
                case 50:
                    int i4 = zzgg.zza;
                    zzgz.zzs(obj, j, zzfh.zza(zzgz.zzf(obj, j), zzgz.zzf(obj2, j)));
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
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzgz.zzs(obj, j, zzgz.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    zzC(obj, obj2, i);
                    break;
            }
        }
        zzgg.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zzgg.zzo(this.zzm, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcuVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzcuVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzhh zzhhVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        int i;
        int i2;
        int i3;
        int i4;
        zzfp<T> zzfpVar = this;
        if (zzfpVar.zzh) {
            zzdx zzdxVar = ((zzed) obj).zzb;
            if (zzdxVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzdxVar.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = zzfpVar.zzc;
        Unsafe unsafe = zzb;
        int i5 = 0;
        int i6 = 1048575;
        int i7 = 0;
        while (i5 < iArr.length) {
            int iZzs = zzfpVar.zzs(i5);
            int[] iArr2 = zzfpVar.zzc;
            int iZzr = zzr(iZzs);
            int i8 = iArr2[i5];
            if (iZzr <= 17) {
                int i9 = iArr2[i5 + 2];
                int i10 = i9 & 1048575;
                if (i10 != i6) {
                    i = 1;
                    i7 = i10 == 1048575 ? 0 : unsafe.getInt(obj, i10);
                    i6 = i10;
                } else {
                    i = 1;
                }
                i2 = i6;
                i3 = i7;
                i4 = i << (i9 >>> 20);
            } else {
                i = 1;
                i2 = i6;
                i3 = i7;
                i4 = 0;
            }
            while (entry != null && ((zzee) entry.getKey()).zza <= i8) {
                zzfpVar.zzm.zzb(zzhhVar, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long j = iZzs & 1048575;
            switch (iZzr) {
                case 0:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzf(i8, zzgz.zza(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 1:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzo(i8, zzgz.zzb(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 2:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzt(i8, unsafe.getLong(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 3:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzK(i8, unsafe.getLong(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 4:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzr(i8, unsafe.getInt(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 5:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzm(i8, unsafe.getLong(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 6:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 7:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzb(i8, zzgz.zzw(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 8:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzO(i8, unsafe.getObject(obj, j), zzhhVar);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 9:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzv(i8, unsafe.getObject(obj, j), zzfpVar.zzv(i5));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 10:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzd(i8, (zzdf) unsafe.getObject(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 11:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzI(i8, unsafe.getInt(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 12:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 13:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzx(i8, unsafe.getInt(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 14:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzz(i8, unsafe.getLong(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 15:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzB(i8, unsafe.getInt(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 16:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzD(i8, unsafe.getLong(obj, j));
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 17:
                    if (zzfpVar.zzJ(obj, i5, i2, i3, i4)) {
                        zzhhVar.zzq(i8, unsafe.getObject(obj, j), zzfpVar.zzv(i5));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 18:
                    zzgg.zzr(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 19:
                    zzgg.zzv(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 20:
                    zzgg.zzx(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 21:
                    zzgg.zzD(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 22:
                    zzgg.zzw(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 23:
                    zzgg.zzu(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 24:
                    zzgg.zzt(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 25:
                    zzgg.zzq(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 26:
                    int i11 = zzfpVar.zzc[i5];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzgg.zza;
                    if (list != null && !list.isEmpty()) {
                        zzhhVar.zzH(i11, list);
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 27:
                    int i13 = zzfpVar.zzc[i5];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv = zzfpVar.zzv(i5);
                    int i14 = zzgg.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            ((zzdo) zzhhVar).zzv(i13, list2.get(i15), zzgeVarZzv);
                        }
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 28:
                    int i16 = zzfpVar.zzc[i5];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgg.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhhVar.zze(i16, list3);
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 29:
                    zzgg.zzC(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 30:
                    zzgg.zzs(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 31:
                    zzgg.zzy(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 32:
                    zzgg.zzz(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 33:
                    zzgg.zzA(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 34:
                    zzgg.zzB(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, false);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 35:
                    zzgg.zzr(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 36:
                    zzgg.zzv(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 37:
                    zzgg.zzx(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 38:
                    zzgg.zzD(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 39:
                    zzgg.zzw(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 40:
                    zzgg.zzu(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 41:
                    zzgg.zzt(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 42:
                    zzgg.zzq(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 43:
                    zzgg.zzC(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 44:
                    zzgg.zzs(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 45:
                    zzgg.zzy(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 46:
                    zzgg.zzz(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 47:
                    zzgg.zzA(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 48:
                    zzgg.zzB(zzfpVar.zzc[i5], (List) unsafe.getObject(obj, j), zzhhVar, i);
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 49:
                    int i18 = zzfpVar.zzc[i5];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzge zzgeVarZzv2 = zzfpVar.zzv(i5);
                    int i19 = zzgg.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            ((zzdo) zzhhVar).zzq(i18, list4.get(i20), zzgeVarZzv2);
                        }
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 51:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzf(i8, zzm(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 52:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzo(i8, zzn(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 53:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzt(i8, zzt(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 54:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzK(i8, zzt(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 55:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzr(i8, zzo(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 56:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzm(i8, zzt(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 57:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzk(i8, zzo(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 58:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzb(i8, zzN(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzO(i8, unsafe.getObject(obj, j), zzhhVar);
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 60:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzv(i8, unsafe.getObject(obj, j), zzfpVar.zzv(i5));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 61:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzd(i8, (zzdf) unsafe.getObject(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 62:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzI(i8, zzo(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 63:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzi(i8, zzo(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 64:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzx(i8, zzo(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 65:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzz(i8, zzt(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 66:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzB(i8, zzo(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case 67:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzD(i8, zzt(obj, j));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzfpVar.zzM(obj, i8, i5)) {
                        zzhhVar.zzq(i8, unsafe.getObject(obj, j), zzfpVar.zzv(i5));
                    }
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
                default:
                    i5 += 3;
                    i7 = i3;
                    i6 = i2;
                    entry = entry;
                    break;
            }
        }
        while (entry != null) {
            zzfpVar.zzm.zzb(zzhhVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        ((zzeh) obj).zzc.zzl(zzhhVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzgz.zza(obj, j)) != Double.doubleToLongBits(zzgz.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzgz.zzb(obj, j)) != Float.floatToIntBits(zzgz.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzgz.zzw(obj, j) != zzgz.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzgz.zzc(obj, j) != zzgz.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzgz.zzd(obj, j) != zzgz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
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
                    zZzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
                    break;
                case 50:
                    zZzE = zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j));
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
                    long jZzp = zzp(i) & 1048575;
                    if (zzgz.zzc(obj, jZzp) != zzgz.zzc(obj2, jZzp) || !zzgg.zzE(zzgz.zzf(obj, j), zzgz.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzeh) obj).zzc.equals(((zzeh) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzed) obj).zzb.equals(((zzed) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2 A[LOOP:1: B:45:0x00a1->B:50:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzge zzgeVarZzv;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i4];
            int i8 = iArr2[i7];
            int iZzs = this.zzs(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                i = i6;
                i2 = i5;
            }
            zzfp<T> zzfpVar = this;
            Object obj2 = obj;
            if ((268435456 & iZzs) != 0 && !zzfpVar.zzJ(obj2, i7, i, i2, i11)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzfpVar.zzJ(obj2, i7, i, i2, i11) && !zzK(obj2, iZzs, zzfpVar.zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzgz.zzf(obj2, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgeVarZzv = zzfpVar.zzv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgeVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzfpVar.zzM(obj2, i8, i7) && !zzK(obj2, iZzs, zzfpVar.zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzgz.zzf(obj2, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzgeVarZzv = zzfpVar.zzv(i7);
                    while (i3 < list.size()) {
                        if (!zzgeVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzfg) zzgz.zzf(obj2, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i4++;
            this = zzfpVar;
            obj = obj2;
            i6 = i;
            i5 = i2;
        }
        return !this.zzh || ((zzed) obj).zzb.zzk();
    }
}
