package com.google.android.gms.internal.cast;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.eac.EACTags;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cast@@22.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzzl<T> implements zzzs<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzaak.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzzi zze;
    private final boolean zzf;
    private final int[] zzg;
    private final int zzh;
    private final zzaad zzi;
    private final zzxs zzj;

    private zzzl(int[] iArr, Object[] objArr, int i, int i2, zzzi zzziVar, boolean z, int[] iArr2, int i3, int i4, zzzn zzznVar, zzyv zzyvVar, zzaad zzaadVar, zzxs zzxsVar, zzzd zzzdVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        boolean z2 = false;
        if (zzxsVar != null && (zzziVar instanceof zzyb)) {
            z2 = true;
        }
        this.zzf = z2;
        this.zzg = iArr2;
        this.zzh = i3;
        this.zzi = zzaadVar;
        this.zzj = zzxsVar;
        this.zze = zzziVar;
    }

    private final boolean zzA(Object obj, int i) {
        int iZzq = zzq(i);
        long j = iZzq & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzq >>> 20)) & zzaak.zzd(obj, j)) != 0;
        }
        int iZzp = zzp(i);
        long j2 = iZzp & 1048575;
        switch (zzr(iZzp)) {
            case 0:
                return Double.doubleToRawLongBits(zzaak.zzl(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzaak.zzj(obj, j2)) != 0;
            case 2:
                return zzaak.zzf(obj, j2) != 0;
            case 3:
                return zzaak.zzf(obj, j2) != 0;
            case 4:
                return zzaak.zzd(obj, j2) != 0;
            case 5:
                return zzaak.zzf(obj, j2) != 0;
            case 6:
                return zzaak.zzd(obj, j2) != 0;
            case 7:
                return zzaak.zzh(obj, j2);
            case 8:
                Object objZzn = zzaak.zzn(obj, j2);
                if (objZzn instanceof String) {
                    return !((String) objZzn).isEmpty();
                }
                if (objZzn instanceof zzxk) {
                    return !zzxk.zzb.equals(objZzn);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzaak.zzn(obj, j2) != null;
            case 10:
                return !zzxk.zzb.equals(zzaak.zzn(obj, j2));
            case 11:
                return zzaak.zzd(obj, j2) != 0;
            case 12:
                return zzaak.zzd(obj, j2) != 0;
            case 13:
                return zzaak.zzd(obj, j2) != 0;
            case 14:
                return zzaak.zzf(obj, j2) != 0;
            case 15:
                return zzaak.zzd(obj, j2) != 0;
            case 16:
                return zzaak.zzf(obj, j2) != 0;
            case 17:
                return zzaak.zzn(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzB(Object obj, int i) {
        int iZzq = zzq(i);
        long j = 1048575 & iZzq;
        if (j == 1048575) {
            return;
        }
        zzaak.zze(obj, j, (1 << (iZzq >>> 20)) | zzaak.zzd(obj, j));
    }

    private final boolean zzC(Object obj, int i, int i2) {
        return zzaak.zzd(obj, (long) (zzq(i2) & 1048575)) == i;
    }

    private final void zzD(Object obj, int i, int i2) {
        zzaak.zze(obj, zzq(i2) & 1048575, i);
    }

    private static final void zzE(int i, Object obj, zzaap zzaapVar) throws IOException {
        if (obj instanceof String) {
            zzaapVar.zzm(i, (String) obj);
        } else {
            zzaapVar.zzn(i, (zzxk) obj);
        }
    }

    /* JADX WARN: Code duplicated, block: B:126:0x026d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0270  */
    /* JADX WARN: Code duplicated, block: B:130:0x028a  */
    /* JADX WARN: Code duplicated, block: B:131:0x028d  */
    /* JADX WARN: Code duplicated, block: B:170:0x034e  */
    /* JADX WARN: Code duplicated, block: B:185:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ad  */
    static zzzl zzi(Class cls, zzzf zzzfVar, zzzn zzznVar, zzyv zzyvVar, zzaad zzaadVar, zzxs zzxsVar, zzzd zzzdVar) {
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
        Field fieldZzj;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZzj2;
        int i27;
        Object obj2;
        Field fieldZzj3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(zzzfVar instanceof zzzr)) {
            throw null;
        }
        zzzr zzzrVar = (zzzr) zzzfVar;
        String strZzd = zzzrVar.zzd();
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
        Object[] objArrZze = zzzrVar.zze();
        Class<?> cls2 = zzzrVar.zzb().getClass();
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
            zzzr zzzrVar2 = zzzrVar;
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
                    } else if (zzzrVar2.zzc() == 1 || i77 != 0) {
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
                        fieldZzj2 = (Field) obj;
                    } else {
                        fieldZzj2 = zzj(cls2, (String) obj);
                        objArrZze[i26] = fieldZzj2;
                    }
                    int i87 = i7;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzj2);
                    i27 = i26 + 1;
                    obj2 = objArrZze[i27];
                    i18 = i87;
                    if (obj2 instanceof Field) {
                        fieldZzj3 = (Field) obj2;
                    } else {
                        fieldZzj3 = zzj(cls2, (String) obj2);
                        objArrZze[i27] = fieldZzj3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzj3);
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
                    fieldZzj2 = (Field) obj;
                } else {
                    fieldZzj2 = zzj(cls2, (String) obj);
                    objArrZze[i26] = fieldZzj2;
                }
                int i89 = i7;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzj2);
                i27 = i26 + 1;
                obj2 = objArrZze[i27];
                i18 = i89;
                if (obj2 instanceof Field) {
                    fieldZzj3 = (Field) obj2;
                } else {
                    fieldZzj3 = zzj(cls2, (String) obj2);
                    objArrZze[i27] = fieldZzj3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzj3);
                strZzd = strZzd;
                i20 = i88;
                i17 = i82;
                i19 = 0;
                c = 55296;
            } else {
                i18 = i7;
                int i90 = i6 + 1;
                Field fieldZzj4 = zzj(cls2, (String) objArrZze[i6]);
                if (i76 == 9 || i76 == 17) {
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldZzj4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i6 += 2;
                            i22 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (zzzrVar2.zzc() == 1 || i77 != 0) {
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
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzj4);
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
                                fieldZzj = (Field) obj3;
                            } else {
                                fieldZzj = zzj(cls2, (String) obj3);
                                objArrZze[i100] = fieldZzj;
                            }
                            int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzj);
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
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzj4);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzj4);
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
            zzzrVar = zzzrVar2;
            length = length;
            i7 = i18;
        }
        return new zzzl(iArr3, objArr, i2, i4, zzzrVar.zzb(), false, iArr, i5, i62, zzznVar, zzyvVar, zzaadVar, zzxsVar, zzzdVar);
    }

    private static Field zzj(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzk(Object obj, Object obj2, int i) {
        if (zzA(obj2, i)) {
            int iZzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i2 = this.zzc[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzzs zzzsVarZzm = zzm(i);
            if (!zzA(obj, i)) {
                if (zzs(object)) {
                    Object objZza = zzzsVarZzm.zza();
                    zzzsVarZzm.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzB(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzs(object2)) {
                Object objZza2 = zzzsVarZzm.zza();
                zzzsVarZzm.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzzsVarZzm.zzd(object2, object);
        }
    }

    private final void zzl(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzC(obj2, i2, i)) {
            int iZzp = zzp(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzp;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i3 = iArr[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzzs zzzsVarZzm = zzm(i);
            if (!zzC(obj, i2, i)) {
                if (zzs(object)) {
                    Object objZza = zzzsVarZzm.zza();
                    zzzsVarZzm.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzs(object2)) {
                Object objZza2 = zzzsVarZzm.zza();
                zzzsVarZzm.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzzsVarZzm.zzd(object2, object);
        }
    }

    private final zzzs zzm(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzzs zzzsVar = (zzzs) objArr[i3];
        if (zzzsVar != null) {
            return zzzsVar;
        }
        zzzs zzzsVarZzb = zzzp.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzzsVarZzb;
        return zzzsVarZzb;
    }

    private final Object zzn(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static boolean zzo(Object obj, int i, zzzs zzzsVar) {
        return zzzsVar.zzh(zzaak.zzn(obj, i & 1048575));
    }

    private final int zzp(int i) {
        return this.zzc[i + 1];
    }

    private final int zzq(int i) {
        return this.zzc[i + 2];
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzs(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzyd) {
            return ((zzyd) obj).zzv();
        }
        return true;
    }

    private static double zzt(Object obj, long j) {
        return ((Double) zzaak.zzn(obj, j)).doubleValue();
    }

    private static float zzu(Object obj, long j) {
        return ((Float) zzaak.zzn(obj, j)).floatValue();
    }

    private static int zzv(Object obj, long j) {
        return ((Integer) zzaak.zzn(obj, j)).intValue();
    }

    private static long zzw(Object obj, long j) {
        return ((Long) zzaak.zzn(obj, j)).longValue();
    }

    private static boolean zzx(Object obj, long j) {
        return ((Boolean) zzaak.zzn(obj, j)).booleanValue();
    }

    private final boolean zzy(Object obj, Object obj2, int i) {
        return zzA(obj, i) == zzA(obj2, i);
    }

    private final boolean zzz(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzA(obj, i);
        }
        return (i3 & i4) != 0;
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final Object zza() {
        return ((zzyd) this.zze).zzy();
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzC;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzp = zzp(i);
            long j = iZzp & 1048575;
            switch (zzr(iZzp)) {
                case 0:
                    if (!zzy(obj, obj2, i) || Double.doubleToLongBits(zzaak.zzl(obj, j)) != Double.doubleToLongBits(zzaak.zzl(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzy(obj, obj2, i) || Float.floatToIntBits(zzaak.zzj(obj, j)) != Float.floatToIntBits(zzaak.zzj(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzy(obj, obj2, i) || zzaak.zzf(obj, j) != zzaak.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzy(obj, obj2, i) || zzaak.zzf(obj, j) != zzaak.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzy(obj, obj2, i) || zzaak.zzd(obj, j) != zzaak.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzy(obj, obj2, i) || zzaak.zzf(obj, j) != zzaak.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzy(obj, obj2, i) || zzaak.zzd(obj, j) != zzaak.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzy(obj, obj2, i) || zzaak.zzh(obj, j) != zzaak.zzh(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzy(obj, obj2, i) || !zzzu.zzC(zzaak.zzn(obj, j), zzaak.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzy(obj, obj2, i) || !zzzu.zzC(zzaak.zzn(obj, j), zzaak.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzy(obj, obj2, i) || !zzzu.zzC(zzaak.zzn(obj, j), zzaak.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzy(obj, obj2, i) || zzaak.zzd(obj, j) != zzaak.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzy(obj, obj2, i) || zzaak.zzd(obj, j) != zzaak.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzy(obj, obj2, i) || zzaak.zzd(obj, j) != zzaak.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzy(obj, obj2, i) || zzaak.zzf(obj, j) != zzaak.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzy(obj, obj2, i) || zzaak.zzd(obj, j) != zzaak.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzy(obj, obj2, i) || zzaak.zzf(obj, j) != zzaak.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzy(obj, obj2, i) || !zzzu.zzC(zzaak.zzn(obj, j), zzaak.zzn(obj2, j))) {
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
                    zZzC = zzzu.zzC(zzaak.zzn(obj, j), zzaak.zzn(obj2, j));
                    break;
                case 50:
                    zZzC = zzzu.zzC(zzaak.zzn(obj, j), zzaak.zzn(obj2, j));
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
                    long jZzq = zzq(i) & 1048575;
                    if (zzaak.zzd(obj, jZzq) != zzaak.zzd(obj2, jZzq) || !zzzu.zzC(zzaak.zzn(obj, j), zzaak.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzC) {
                return false;
            }
        }
        if (!((zzyd) obj).zzc.equals(((zzyd) obj2).zzc)) {
            return false;
        }
        if (this.zzf) {
            return ((zzyb) obj).zzb.equals(((zzyb) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final int zzc(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzyd) obj).zzc.hashCode();
                return this.zzf ? (iHashCode * 53) + ((zzyb) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzp = zzp(i3);
            int i5 = 1048575 & iZzp;
            int iZzr = zzr(iZzp);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzaak.zzl(obj, j));
                    byte[] bArr = zzym.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzaak.zzj(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaak.zzf(obj, j);
                    byte[] bArr2 = zzym.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaak.zzf(obj, j);
                    byte[] bArr3 = zzym.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaak.zzf(obj, j);
                    byte[] bArr4 = zzym.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzym.zzb(zzaak.zzh(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzaak.zzn(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzn = zzaak.zzn(obj, j);
                    if (objZzn != null) {
                        iHashCode2 = objZzn.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaak.zzf(obj, j);
                    byte[] bArr5 = zzym.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaak.zzf(obj, j);
                    byte[] bArr6 = zzym.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzn2 = zzaak.zzn(obj, j);
                    if (objZzn2 != null) {
                        iHashCode2 = objZzn2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
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
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzaak.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzt(obj, j));
                        byte[] bArr7 = zzym.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzu(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzw(obj, j);
                        byte[] bArr8 = zzym.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzw(obj, j);
                        byte[] bArr9 = zzym.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzv(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzw(obj, j);
                        byte[] bArr10 = zzym.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzv(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzym.zzb(zzx(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzaak.zzn(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzaak.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzaak.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzv(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzv(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzv(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzw(obj, j);
                        byte[] bArr11 = zzym.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzv(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzw(obj, j);
                        byte[] bArr12 = zzym.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzC(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzaak.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    @Override // com.google.android.gms.internal.cast.zzzs
    public final void zzd(Object obj, Object obj2) {
        if (!zzs(obj)) {
            String strValueOf = String.valueOf(obj);
            String.valueOf(strValueOf);
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(strValueOf)));
        }
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzzu.zzE(this.zzi, obj, obj2);
                if (this.zzf) {
                    zzzu.zzD(this.zzj, obj, obj2);
                    return;
                }
                return;
            }
            int iZzp = zzp(i);
            int i2 = 1048575 & iZzp;
            int iZzr = zzr(iZzp);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzA(obj2, i)) {
                        zzaak.zzm(obj, j, zzaak.zzl(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 1:
                    if (zzA(obj2, i)) {
                        zzaak.zzk(obj, j, zzaak.zzj(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 2:
                    if (zzA(obj2, i)) {
                        zzaak.zzg(obj, j, zzaak.zzf(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 3:
                    if (zzA(obj2, i)) {
                        zzaak.zzg(obj, j, zzaak.zzf(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 4:
                    if (zzA(obj2, i)) {
                        zzaak.zze(obj, j, zzaak.zzd(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 5:
                    if (zzA(obj2, i)) {
                        zzaak.zzg(obj, j, zzaak.zzf(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 6:
                    if (zzA(obj2, i)) {
                        zzaak.zze(obj, j, zzaak.zzd(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 7:
                    if (zzA(obj2, i)) {
                        zzaak.zzi(obj, j, zzaak.zzh(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 8:
                    if (zzA(obj2, i)) {
                        zzaak.zzo(obj, j, zzaak.zzn(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 9:
                    zzk(obj, obj2, i);
                    break;
                case 10:
                    if (zzA(obj2, i)) {
                        zzaak.zzo(obj, j, zzaak.zzn(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 11:
                    if (zzA(obj2, i)) {
                        zzaak.zze(obj, j, zzaak.zzd(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 12:
                    if (zzA(obj2, i)) {
                        zzaak.zze(obj, j, zzaak.zzd(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 13:
                    if (zzA(obj2, i)) {
                        zzaak.zze(obj, j, zzaak.zzd(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 14:
                    if (zzA(obj2, i)) {
                        zzaak.zzg(obj, j, zzaak.zzf(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 15:
                    if (zzA(obj2, i)) {
                        zzaak.zze(obj, j, zzaak.zzd(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 16:
                    if (zzA(obj2, i)) {
                        zzaak.zzg(obj, j, zzaak.zzf(obj2, j));
                        zzB(obj, i);
                    }
                    break;
                case 17:
                    zzk(obj, obj2, i);
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
                    zzyl zzylVarZzf = (zzyl) zzaak.zzn(obj, j);
                    zzyl zzylVar = (zzyl) zzaak.zzn(obj2, j);
                    int size = zzylVarZzf.size();
                    int size2 = zzylVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzylVarZzf.zza()) {
                            zzylVarZzf = zzylVarZzf.zzf(size2 + size);
                        }
                        zzylVarZzf.addAll(zzylVar);
                    }
                    if (size > 0) {
                        zzylVar = zzylVarZzf;
                    }
                    zzaak.zzo(obj, j, zzylVar);
                    break;
                case 50:
                    int i4 = zzzu.zza;
                    zzzc zzzcVarZzb = (zzzc) zzaak.zzn(obj, j);
                    zzzc zzzcVar = (zzzc) zzaak.zzn(obj2, j);
                    if (!zzzcVar.isEmpty()) {
                        if (!zzzcVarZzb.zzd()) {
                            zzzcVarZzb = zzzcVarZzb.zzb();
                        }
                        zzzcVarZzb.zza(zzzcVar);
                    }
                    zzaak.zzo(obj, j, zzzcVarZzb);
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
                    if (zzC(obj2, i3, i)) {
                        zzaak.zzo(obj, j, zzaak.zzn(obj2, j));
                        zzD(obj, i3, i);
                    }
                    break;
                case 60:
                    zzl(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzC(obj2, i3, i)) {
                        zzaak.zzo(obj, j, zzaak.zzn(obj2, j));
                        zzD(obj, i3, i);
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    zzl(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x0385  */
    /* JADX WARN: Code duplicated, block: B:211:0x0549  */
    @Override // com.google.android.gms.internal.cast.zzzs
    public final int zze(Object obj) {
        int i;
        int iZzw;
        int iZzw2;
        int iZzx;
        int iZzw3;
        int iZzw4;
        int iZzw5;
        int iZzc;
        int iZzw6;
        int iZzz;
        int iZzo;
        int size;
        int iZzp;
        int iZzw7;
        int iZzw8;
        int iZzt;
        int iZzw9;
        int iZzw10;
        int iZzx2;
        int iZzx3;
        int iZzw11;
        int iZzw12;
        int iZzA;
        int iZzw13;
        int iZzw14;
        int iZzw15;
        int iZzc2;
        int iZzw16;
        zzzl<T> zzzlVar = this;
        Unsafe unsafe = zzb;
        int i2 = 0;
        int i3 = 0;
        int iZzw17 = 0;
        int i4 = 1048575;
        while (true) {
            int[] iArr = zzzlVar.zzc;
            if (i2 >= iArr.length) {
                int iZzf = iZzw17 + ((zzyd) obj).zzc.zzf();
                if (!zzzlVar.zzf) {
                    return iZzf;
                }
                zzzz zzzzVar = ((zzyb) obj).zzb.zza;
                int iZzc3 = zzzzVar.zzc();
                int iZzg = 0;
                for (int i5 = 0; i5 < iZzc3; i5++) {
                    Map.Entry entryZzd = zzzzVar.zzd(i5);
                    iZzg += zzxw.zzg((zzxv) ((zzzw) entryZzd).zza(), entryZzd.getValue());
                }
                for (Map.Entry entry : zzzzVar.zze()) {
                    iZzg += zzxw.zzg((zzxv) entry.getKey(), entry.getValue());
                }
                return iZzf + iZzg;
            }
            int iZzp2 = zzzlVar.zzp(i2);
            int iZzr = zzr(iZzp2);
            int i6 = iArr[i2];
            int i7 = iArr[i2 + 2];
            int i8 = i7 & 1048575;
            if (iZzr <= 17) {
                if (i8 != i4) {
                    i3 = i8 == 1048575 ? 0 : unsafe.getInt(obj, i8);
                    i4 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzp2 & 1048575;
            if (iZzr >= zzxx.DOUBLE_LIST_PACKED.zza()) {
                zzxx.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzr) {
                case 0:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzw17 += zzxp.zzw(i6 << 3) + 8;
                    }
                    i2 += 3;
                    break;
                case 1:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzw = zzxp.zzw(i6 << 3);
                        iZzw4 = iZzw + 4;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 2:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzw2 = zzxp.zzw(i6 << 3);
                        iZzx = zzxp.zzx(j2);
                        iZzw4 = iZzw2 + iZzx;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 3:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzw2 = zzxp.zzw(i6 << 3);
                        iZzx = zzxp.zzx(j3);
                        iZzw4 = iZzw2 + iZzx;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 4:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzw2 = zzxp.zzw(i6 << 3);
                        iZzx = zzxp.zzx(j4);
                        iZzw4 = iZzw2 + iZzx;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 5:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzw3 = zzxp.zzw(i6 << 3);
                        iZzw4 = iZzw3 + 8;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 6:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzw = zzxp.zzw(i6 << 3);
                        iZzw4 = iZzw + 4;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 7:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzw4 = zzxp.zzw(i6 << 3) + 1;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 8:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzxk) {
                            iZzw5 = zzxp.zzw(i10);
                            iZzc = ((zzxk) object).zzc();
                            iZzw6 = zzxp.zzw(iZzc);
                            iZzw4 = iZzw5 + iZzw6 + iZzc;
                            iZzw17 += iZzw4;
                        } else {
                            iZzw2 = zzxp.zzw(i10);
                            iZzx = zzxp.zzy((String) object);
                            iZzw4 = iZzw2 + iZzx;
                            iZzw17 += iZzw4;
                        }
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 9:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzz = zzzu.zzz(i6, unsafe.getObject(obj, j), zzzlVar.zzm(i2));
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 10:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        zzxk zzxkVar = (zzxk) unsafe.getObject(obj, j);
                        iZzw5 = zzxp.zzw(i6 << 3);
                        iZzc = zzxkVar.zzc();
                        iZzw6 = zzxp.zzw(iZzc);
                        iZzw4 = iZzw5 + iZzw6 + iZzc;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 11:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzw2 = zzxp.zzw(i6 << 3);
                        iZzx = zzxp.zzw(i11);
                        iZzw4 = iZzw2 + iZzx;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 12:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzw2 = zzxp.zzw(i6 << 3);
                        iZzx = zzxp.zzx(j5);
                        iZzw4 = iZzw2 + iZzx;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 13:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzw = zzxp.zzw(i6 << 3);
                        iZzw4 = iZzw + 4;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 14:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzw3 = zzxp.zzw(i6 << 3);
                        iZzw4 = iZzw3 + 8;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 15:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzw2 = zzxp.zzw(i6 << 3);
                        iZzx = zzxp.zzw((i12 >> 31) ^ (i12 + i12));
                        iZzw4 = iZzw2 + iZzx;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 16:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzw2 = zzxp.zzw(i6 << 3);
                        iZzx = zzxp.zzx((j6 >> 63) ^ (j6 + j6));
                        iZzw4 = iZzw2 + iZzx;
                        iZzw17 += iZzw4;
                    }
                    zzzlVar = this;
                    i2 += 3;
                    break;
                case 17:
                    if (zzzlVar.zzz(obj, i2, i4, i3, i)) {
                        iZzz = zzzu.zzA(i6, (zzzi) unsafe.getObject(obj, j), zzzlVar.zzm(i2));
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 18:
                    iZzz = zzzu.zzy(i6, (List) unsafe.getObject(obj, j), false);
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 19:
                    iZzz = zzzu.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzzu.zza;
                    if (list.size() == 0) {
                        iZzo = 0;
                    } else {
                        iZzo = zzzu.zzo(list) + (list.size() * zzxp.zzw(i6 << 3));
                    }
                    iZzw17 += iZzo;
                    i2 += 3;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzzu.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzzu.zzp(list2);
                        iZzw7 = zzxp.zzw(i6 << 3);
                        iZzx2 = size * iZzw7;
                        iZzz = iZzp + iZzx2;
                    }
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzzu.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzzu.zzs(list3);
                        iZzw7 = zzxp.zzw(i6 << 3);
                        iZzx2 = size * iZzw7;
                        iZzz = iZzp + iZzx2;
                    }
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 23:
                    iZzz = zzzu.zzy(i6, (List) unsafe.getObject(obj, j), false);
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 24:
                    iZzz = zzzu.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzzu.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzz = 0;
                    } else {
                        iZzz = size2 * (zzxp.zzw(i6 << 3) + 1);
                    }
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i17 = zzzu.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzo = 0;
                    } else {
                        iZzo = zzxp.zzw(i6 << 3) * size3;
                        if (list5 instanceof zzyu) {
                            zzyu zzyuVar = (zzyu) list5;
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object objZza = zzyuVar.zza();
                                if (objZza instanceof zzxk) {
                                    int iZzc4 = ((zzxk) objZza).zzc();
                                    iZzo += zzxp.zzw(iZzc4) + iZzc4;
                                } else {
                                    iZzo += zzxp.zzy((String) objZza);
                                }
                            }
                        } else {
                            for (int i19 = 0; i19 < size3; i19++) {
                                Object obj2 = list5.get(i19);
                                if (obj2 instanceof zzxk) {
                                    int iZzc5 = ((zzxk) obj2).zzc();
                                    iZzo += zzxp.zzw(iZzc5) + iZzc5;
                                } else {
                                    iZzo += zzxp.zzy((String) obj2);
                                }
                            }
                        }
                    }
                    iZzw17 += iZzo;
                    i2 += 3;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzzs zzzsVarZzm = zzzlVar.zzm(i2);
                    int i20 = zzzu.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzw8 = 0;
                    } else {
                        iZzw8 = zzxp.zzw(i6 << 3) * size4;
                        for (int i21 = 0; i21 < size4; i21++) {
                            Object obj3 = list6.get(i21);
                            if (obj3 instanceof zzyt) {
                                iZzt = ((zzyt) obj3).zzb();
                                iZzw9 = zzxp.zzw(iZzt);
                            } else {
                                iZzt = ((zzwz) obj3).zzt(zzzsVarZzm);
                                iZzw9 = zzxp.zzw(iZzt);
                            }
                            iZzw8 += iZzw9 + iZzt;
                        }
                    }
                    iZzw17 += iZzw8;
                    i2 += 3;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzzu.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzw10 = 0;
                    } else {
                        iZzw10 = size5 * zzxp.zzw(i6 << 3);
                        for (int i23 = 0; i23 < list7.size(); i23++) {
                            int iZzc6 = ((zzxk) list7.get(i23)).zzc();
                            iZzw10 += zzxp.zzw(iZzc6) + iZzc6;
                        }
                    }
                    iZzw17 += iZzw10;
                    i2 += 3;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzzu.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzzu.zzt(list8);
                        iZzw7 = zzxp.zzw(i6 << 3);
                        iZzx2 = size * iZzw7;
                        iZzz = iZzp + iZzx2;
                    }
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzzu.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzzu.zzr(list9);
                        iZzw7 = zzxp.zzw(i6 << 3);
                        iZzx2 = size * iZzw7;
                        iZzz = iZzp + iZzx2;
                    }
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 31:
                    iZzz = zzzu.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 32:
                    iZzz = zzzu.zzy(i6, (List) unsafe.getObject(obj, j), false);
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i26 = zzzu.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzzu.zzu(list10);
                        iZzw7 = zzxp.zzw(i6 << 3);
                        iZzx2 = size * iZzw7;
                        iZzz = iZzp + iZzx2;
                    }
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i27 = zzzu.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzzu.zzq(list11);
                        iZzw7 = zzxp.zzw(i6 << 3);
                        iZzx2 = size * iZzw7;
                        iZzz = iZzp + iZzx2;
                    }
                    iZzw17 += iZzz;
                    i2 += 3;
                    break;
                case 35:
                    iZzx3 = zzzu.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 36:
                    iZzx3 = zzzu.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 37:
                    iZzx3 = zzzu.zzo((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 38:
                    iZzx3 = zzzu.zzp((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 39:
                    iZzx3 = zzzu.zzs((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 40:
                    iZzx3 = zzzu.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 41:
                    iZzx3 = zzzu.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i28 = zzzu.zza;
                    iZzx3 = list12.size();
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 43:
                    iZzx3 = zzzu.zzt((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 44:
                    iZzx3 = zzzu.zzr((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 45:
                    iZzx3 = zzzu.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 46:
                    iZzx3 = zzzu.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 47:
                    iZzx3 = zzzu.zzu((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 48:
                    iZzx3 = zzzu.zzq((List) unsafe.getObject(obj, j));
                    if (iZzx3 > 0) {
                        iZzw11 = zzxp.zzw(i6 << 3);
                        iZzw12 = zzxp.zzw(iZzx3);
                        iZzw10 = iZzw11 + iZzw12 + iZzx3;
                        iZzw17 += iZzw10;
                    }
                    i2 += 3;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzzs zzzsVarZzm2 = zzzlVar.zzm(i2);
                    int i29 = zzzu.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzA = 0;
                    } else {
                        iZzA = 0;
                        for (int i30 = 0; i30 < size6; i30++) {
                            iZzA += zzzu.zzA(i6, (zzzi) list13.get(i30), zzzsVarZzm2);
                        }
                    }
                    iZzw17 += iZzA;
                    i2 += 3;
                    break;
                case 50:
                    zzzc zzzcVar = (zzzc) unsafe.getObject(obj, j);
                    if (zzzcVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzzcVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i2 += 3;
                case 51:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzw13 = zzxp.zzw(i6 << 3);
                        iZzz = iZzw13 + 8;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 52:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzw14 = zzxp.zzw(i6 << 3);
                        iZzz = iZzw14 + 4;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 53:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        long jZzw = zzw(obj, j);
                        iZzp = zzxp.zzw(i6 << 3);
                        iZzx2 = zzxp.zzx(jZzw);
                        iZzz = iZzp + iZzx2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 54:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        long jZzw2 = zzw(obj, j);
                        iZzp = zzxp.zzw(i6 << 3);
                        iZzx2 = zzxp.zzx(jZzw2);
                        iZzz = iZzp + iZzx2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 55:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        long jZzv = zzv(obj, j);
                        iZzp = zzxp.zzw(i6 << 3);
                        iZzx2 = zzxp.zzx(jZzv);
                        iZzz = iZzp + iZzx2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 56:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzw13 = zzxp.zzw(i6 << 3);
                        iZzz = iZzw13 + 8;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 57:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzw14 = zzxp.zzw(i6 << 3);
                        iZzz = iZzw14 + 4;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 58:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzz = zzxp.zzw(i6 << 3) + 1;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        int i31 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzxk) {
                            iZzw15 = zzxp.zzw(i31);
                            iZzc2 = ((zzxk) object2).zzc();
                            iZzw16 = zzxp.zzw(iZzc2);
                            iZzz = iZzw15 + iZzw16 + iZzc2;
                            iZzw17 += iZzz;
                        } else {
                            iZzp = zzxp.zzw(i31);
                            iZzx2 = zzxp.zzy((String) object2);
                            iZzz = iZzp + iZzx2;
                            iZzw17 += iZzz;
                        }
                    }
                    i2 += 3;
                    break;
                case 60:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzz = zzzu.zzz(i6, unsafe.getObject(obj, j), zzzlVar.zzm(i2));
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 61:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        zzxk zzxkVar2 = (zzxk) unsafe.getObject(obj, j);
                        iZzw15 = zzxp.zzw(i6 << 3);
                        iZzc2 = zzxkVar2.zzc();
                        iZzw16 = zzxp.zzw(iZzc2);
                        iZzz = iZzw15 + iZzw16 + iZzc2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 62:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        int iZzv = zzv(obj, j);
                        iZzp = zzxp.zzw(i6 << 3);
                        iZzx2 = zzxp.zzw(iZzv);
                        iZzz = iZzp + iZzx2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 63:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        long jZzv2 = zzv(obj, j);
                        iZzp = zzxp.zzw(i6 << 3);
                        iZzx2 = zzxp.zzx(jZzv2);
                        iZzz = iZzp + iZzx2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 64:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzw14 = zzxp.zzw(i6 << 3);
                        iZzz = iZzw14 + 4;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 65:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzw13 = zzxp.zzw(i6 << 3);
                        iZzz = iZzw13 + 8;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 66:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        int iZzv2 = zzv(obj, j);
                        iZzp = zzxp.zzw(i6 << 3);
                        iZzx2 = zzxp.zzw((iZzv2 >> 31) ^ (iZzv2 + iZzv2));
                        iZzz = iZzp + iZzx2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 67:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        long jZzw3 = zzw(obj, j);
                        iZzp = zzxp.zzw(i6 << 3);
                        iZzx2 = zzxp.zzx((jZzw3 >> 63) ^ (jZzw3 + jZzw3));
                        iZzz = iZzp + iZzx2;
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzzlVar.zzC(obj, i6, i2)) {
                        iZzz = zzzu.zzA(i6, (zzzi) unsafe.getObject(obj, j), zzzlVar.zzm(i2));
                        iZzw17 += iZzz;
                    }
                    i2 += 3;
                    break;
                default:
                    i2 += 3;
                    break;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.cast.zzzs
    public final void zzf(Object obj, zzaap zzaapVar) throws IOException {
        Map.Entry entry;
        int i;
        zzzl<T> zzzlVar = this;
        if (zzzlVar.zzf) {
            zzxw zzxwVar = ((zzyb) obj).zzb;
            if (zzxwVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzxwVar.zzc().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = zzzlVar.zzc;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < iArr.length) {
            int iZzp = zzzlVar.zzp(i4);
            int iZzr = zzr(iZzp);
            int i6 = iArr[i4];
            if (iZzr <= 17) {
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
            long j = iZzp & i2;
            switch (iZzr) {
                case 0:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzf(i6, zzaak.zzl(obj, j));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 1:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zze(i6, zzaak.zzj(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 2:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzc(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 3:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzh(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 4:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzi(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 5:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzj(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 6:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzk(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 7:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzl(i6, zzaak.zzh(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 8:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzE(i6, unsafe.getObject(obj, j), zzaapVar);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 9:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzr(i6, unsafe.getObject(obj, j), zzzlVar.zzm(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 10:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzn(i6, (zzxk) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 11:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzo(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 12:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzg(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 13:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzb(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 14:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzd(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 15:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzp(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 16:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzq(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 17:
                    if (zzzlVar.zzz(obj, i4, i3, i5, i)) {
                        zzaapVar.zzs(i6, unsafe.getObject(obj, j), zzzlVar.zzm(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 18:
                    zzzu.zza(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 19:
                    zzzu.zzb(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 20:
                    zzzu.zzc(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 21:
                    zzzu.zzd(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 22:
                    zzzu.zzh(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 23:
                    zzzu.zzf(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 24:
                    zzzu.zzk(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 25:
                    zzzu.zzn(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 26:
                    int i9 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    int i10 = zzzu.zza;
                    if (list != null && !list.isEmpty()) {
                        zzaapVar.zzD(i9, list);
                    }
                    break;
                case 27:
                    int i11 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzzs zzzsVarZzm = zzzlVar.zzm(i4);
                    int i12 = zzzu.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i13 = 0; i13 < list2.size(); i13++) {
                            ((zzxq) zzaapVar).zzr(i11, list2.get(i13), zzzsVarZzm);
                        }
                    }
                    break;
                case 28:
                    int i14 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzzu.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzaapVar.zzE(i14, list3);
                    }
                    break;
                case 29:
                    zzzu.zzi(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 30:
                    zzzu.zzm(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 31:
                    zzzu.zzl(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 32:
                    zzzu.zzg(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 33:
                    zzzu.zzj(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 34:
                    zzzu.zze(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzzlVar = this;
                    break;
                case 35:
                    zzzu.zza(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 36:
                    zzzu.zzb(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 37:
                    zzzu.zzc(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 38:
                    zzzu.zzd(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 39:
                    zzzu.zzh(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 40:
                    zzzu.zzf(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 41:
                    zzzu.zzk(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 42:
                    zzzu.zzn(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 43:
                    zzzu.zzi(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 44:
                    zzzu.zzm(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 45:
                    zzzu.zzl(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 46:
                    zzzu.zzg(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 47:
                    zzzu.zzj(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 48:
                    zzzu.zze(iArr[i4], (List) unsafe.getObject(obj, j), zzaapVar, true);
                    break;
                case 49:
                    int i16 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzzs zzzsVarZzm2 = zzzlVar.zzm(i4);
                    int i17 = zzzu.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            ((zzxq) zzaapVar).zzs(i16, list4.get(i18), zzzsVarZzm2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzf(i6, zzt(obj, j));
                    }
                    break;
                case 52:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zze(i6, zzu(obj, j));
                    }
                    break;
                case 53:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzc(i6, zzw(obj, j));
                    }
                    break;
                case 54:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzh(i6, zzw(obj, j));
                    }
                    break;
                case 55:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzi(i6, zzv(obj, j));
                    }
                    break;
                case 56:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzj(i6, zzw(obj, j));
                    }
                    break;
                case 57:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzk(i6, zzv(obj, j));
                    }
                    break;
                case 58:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzl(i6, zzx(obj, j));
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzE(i6, unsafe.getObject(obj, j), zzaapVar);
                    }
                    break;
                case 60:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzr(i6, unsafe.getObject(obj, j), zzzlVar.zzm(i4));
                    }
                    break;
                case 61:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzn(i6, (zzxk) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzo(i6, zzv(obj, j));
                    }
                    break;
                case 63:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzg(i6, zzv(obj, j));
                    }
                    break;
                case 64:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzb(i6, zzv(obj, j));
                    }
                    break;
                case 65:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzd(i6, zzw(obj, j));
                    }
                    break;
                case 66:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzp(i6, zzv(obj, j));
                    }
                    break;
                case 67:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzq(i6, zzw(obj, j));
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzzlVar.zzC(obj, i6, i4)) {
                        zzaapVar.zzs(i6, unsafe.getObject(obj, j), zzzlVar.zzm(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
            zzzlVar = this;
        }
        if (entry != null) {
            throw null;
        }
        zzaae zzaaeVar = ((zzyd) obj).zzc;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.cast.zzzs
    public final void zzg(Object obj) {
        if (zzs(obj)) {
            if (obj instanceof zzyd) {
                zzyd zzydVar = (zzyd) obj;
                zzydVar.zzC(Integer.MAX_VALUE);
                zzydVar.zza = 0;
                zzydVar.zzw();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzp = zzp(i);
                int i2 = 1048575 & iZzp;
                int iZzr = zzr(iZzp);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzA(obj, i)) {
                                    zzm(i).zzg(zzb.getObject(obj, j));
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
                                ((zzyl) zzaak.zzn(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzzc) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzC(obj, iArr[i], i)) {
                        zzm(i).zzg(zzb.getObject(obj, j));
                    }
                } else if (zzA(obj, i)) {
                    zzm(i).zzg(zzb.getObject(obj, j));
                }
            }
            this.zzi.zza(obj);
            if (this.zzf) {
                this.zzj.zza(obj);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2 A[LOOP:1: B:45:0x00a1->B:50:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.cast.zzzs
    public final boolean zzh(Object obj) {
        int i;
        int i2;
        List list;
        zzzs zzzsVarZzm;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzh) {
            int[] iArr = this.zzg;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzp = zzp(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                int i12 = i4;
                i = i6;
                i2 = i12;
            }
            if ((268435456 & iZzp) != 0 && !zzz(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzr = zzr(iZzp);
            if (iZzr == 9 || iZzr == 17) {
                if (zzz(obj, i7, i, i2, i11) && !zzo(obj, iZzp, zzm(i7))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzaak.zzn(obj, iZzp & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzzsVarZzm = zzm(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzzsVarZzm.zzh(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzC(obj, i8, i7) && !zzo(obj, iZzp, zzm(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzaak.zzn(obj, iZzp & 1048575);
                if (list.isEmpty()) {
                    zzzsVarZzm = zzm(i7);
                    while (i3 < list.size()) {
                        if (!zzzsVarZzm.zzh(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzzc) zzaak.zzn(obj, iZzp & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzf || ((zzyb) obj).zzb.zze();
    }
}
