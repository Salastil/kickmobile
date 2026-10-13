package com.google.android.gms.internal.pal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.eac.EACTags;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-pal@@23.1.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzavz<T> implements zzawn<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzaxh.zzs();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzavw zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzaxa zzm;
    private final zzatz zzn;

    private zzavz(int[] iArr, Object[] objArr, int i, int i2, zzavw zzavwVar, boolean z, int[] iArr2, int i3, int i4, zzawb zzawbVar, zzavj zzavjVar, zzaxa zzaxaVar, zzatz zzatzVar, zzavr zzavrVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzavwVar instanceof zzaun;
        boolean z2 = false;
        if (zzatzVar != null && (zzavwVar instanceof zzauk)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzaxaVar;
        this.zzn = zzatzVar;
        this.zzg = zzavwVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzD(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean zzE(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzaun) {
            return ((zzaun) obj).zzat();
        }
        return true;
    }

    private static void zzF(Object obj) {
        if (zzE(obj)) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(strValueOf)));
    }

    private static double zzG(Object obj, long j) {
        return ((Double) zzaxh.zzn(obj, j)).doubleValue();
    }

    private static float zzH(Object obj, long j) {
        return ((Float) zzaxh.zzn(obj, j)).floatValue();
    }

    private static int zzI(Object obj, long j) {
        return ((Integer) zzaxh.zzn(obj, j)).intValue();
    }

    private static long zzJ(Object obj, long j) {
        return ((Long) zzaxh.zzn(obj, j)).longValue();
    }

    private static boolean zzK(Object obj, long j) {
        return ((Boolean) zzaxh.zzn(obj, j)).booleanValue();
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private final boolean zzM(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzB = zzB(i);
        long j = iZzB & 1048575;
        if (j != 1048575) {
            return ((1 << (iZzB >>> 20)) & zzaxh.zzd(obj, j)) != 0;
        }
        int iZzA = zzA(i);
        long j2 = iZzA & 1048575;
        switch (zzC(iZzA)) {
            case 0:
                return Double.doubleToRawLongBits(zzaxh.zzl(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzaxh.zzj(obj, j2)) != 0;
            case 2:
                return zzaxh.zzf(obj, j2) != 0;
            case 3:
                return zzaxh.zzf(obj, j2) != 0;
            case 4:
                return zzaxh.zzd(obj, j2) != 0;
            case 5:
                return zzaxh.zzf(obj, j2) != 0;
            case 6:
                return zzaxh.zzd(obj, j2) != 0;
            case 7:
                return zzaxh.zzh(obj, j2);
            case 8:
                Object objZzn = zzaxh.zzn(obj, j2);
                if (objZzn instanceof String) {
                    return !((String) objZzn).isEmpty();
                }
                if (objZzn instanceof zzatl) {
                    return !zzatl.zza.equals(objZzn);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzaxh.zzn(obj, j2) != null;
            case 10:
                return !zzatl.zza.equals(zzaxh.zzn(obj, j2));
            case 11:
                return zzaxh.zzd(obj, j2) != 0;
            case 12:
                return zzaxh.zzd(obj, j2) != 0;
            case 13:
                return zzaxh.zzd(obj, j2) != 0;
            case 14:
                return zzaxh.zzf(obj, j2) != 0;
            case 15:
                return zzaxh.zzd(obj, j2) != 0;
            case 16:
                return zzaxh.zzf(obj, j2) != 0;
            case 17:
                return zzaxh.zzn(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzO(Object obj, int i) {
        int iZzB = zzB(i);
        long j = 1048575 & iZzB;
        if (j == 1048575) {
            return;
        }
        zzaxh.zze(obj, j, (1 << (iZzB >>> 20)) | zzaxh.zzd(obj, j));
    }

    private final boolean zzP(Object obj, int i, int i2) {
        return zzaxh.zzd(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final void zzQ(Object obj, int i, int i2) {
        zzaxh.zze(obj, zzB(i2) & 1048575, i);
    }

    private final int zzR(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzS(i, 0);
    }

    private final int zzS(int i, int i2) {
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

    private static final void zzT(int i, Object obj, zzaxp zzaxpVar) throws IOException {
        if (obj instanceof String) {
            zzaxpVar.zzm(i, (String) obj);
        } else {
            zzaxpVar.zzn(i, (zzatl) obj);
        }
    }

    static zzaxb zzh(Object obj) {
        zzaun zzaunVar = (zzaun) obj;
        zzaxb zzaxbVar = zzaunVar.zzc;
        if (zzaxbVar != zzaxb.zza()) {
            return zzaxbVar;
        }
        zzaxb zzaxbVarZzb = zzaxb.zzb();
        zzaunVar.zzc = zzaxbVarZzb;
        return zzaxbVarZzb;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x026d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0270  */
    /* JADX WARN: Code duplicated, block: B:130:0x028a  */
    /* JADX WARN: Code duplicated, block: B:131:0x028d  */
    /* JADX WARN: Code duplicated, block: B:170:0x034e  */
    /* JADX WARN: Code duplicated, block: B:185:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ad  */
    static zzavz zzm(Class cls, zzavt zzavtVar, zzawb zzawbVar, zzavj zzavjVar, zzaxa zzaxaVar, zzatz zzatzVar, zzavr zzavrVar) {
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
        Field fieldZzn;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZzn2;
        int i27;
        Object obj2;
        Field fieldZzn3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(zzavtVar instanceof zzawh)) {
            throw null;
        }
        zzawh zzawhVar = (zzawh) zzavtVar;
        String strZzd = zzawhVar.zzd();
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
        Object[] objArrZze = zzawhVar.zze();
        Class<?> cls2 = zzawhVar.zzb().getClass();
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
            zzawh zzawhVar2 = zzawhVar;
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
                    } else if (zzawhVar2.zzc() == 1 || i77 != 0) {
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
                        fieldZzn2 = (Field) obj;
                    } else {
                        fieldZzn2 = zzn(cls2, (String) obj);
                        objArrZze[i26] = fieldZzn2;
                    }
                    int i87 = i7;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn2);
                    i27 = i26 + 1;
                    obj2 = objArrZze[i27];
                    i18 = i87;
                    if (obj2 instanceof Field) {
                        fieldZzn3 = (Field) obj2;
                    } else {
                        fieldZzn3 = zzn(cls2, (String) obj2);
                        objArrZze[i27] = fieldZzn3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
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
                    fieldZzn2 = (Field) obj;
                } else {
                    fieldZzn2 = zzn(cls2, (String) obj);
                    objArrZze[i26] = fieldZzn2;
                }
                int i89 = i7;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn2);
                i27 = i26 + 1;
                obj2 = objArrZze[i27];
                i18 = i89;
                if (obj2 instanceof Field) {
                    fieldZzn3 = (Field) obj2;
                } else {
                    fieldZzn3 = zzn(cls2, (String) obj2);
                    objArrZze[i27] = fieldZzn3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
                strZzd = strZzd;
                i20 = i88;
                i17 = i82;
                i19 = 0;
                c = 55296;
            } else {
                i18 = i7;
                int i90 = i6 + 1;
                Field fieldZzn4 = zzn(cls2, (String) objArrZze[i6]);
                if (i76 == 9 || i76 == 17) {
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldZzn4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i6 += 2;
                            i22 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (zzawhVar2.zzc() == 1 || i77 != 0) {
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
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
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
                                fieldZzn = (Field) obj3;
                            } else {
                                fieldZzn = zzn(cls2, (String) obj3);
                                objArrZze[i100] = fieldZzn;
                            }
                            int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzn);
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
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
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
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
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
            zzawhVar = zzawhVar2;
            length = length;
            i7 = i18;
        }
        return new zzavz(iArr3, objArr, i2, i4, zzawhVar.zzb(), false, iArr, i5, i62, zzawbVar, zzavjVar, zzaxaVar, zzatzVar, zzavrVar);
    }

    private static Field zzn(Class cls, String str) {
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

    private final void zzo(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
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
            zzawn zzawnVarZzq = zzq(i);
            if (!zzN(obj, i)) {
                if (zzE(object)) {
                    Object objZza = zzawnVarZzq.zza();
                    zzawnVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzO(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzawnVarZzq.zza();
                zzawnVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzawnVarZzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzP(obj2, i2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
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
            zzawn zzawnVarZzq = zzq(i);
            if (!zzP(obj, i2, i)) {
                if (zzE(object)) {
                    Object objZza = zzawnVarZzq.zza();
                    zzawnVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzQ(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzawnVarZzq.zza();
                zzawnVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzawnVarZzq.zzd(object2, object);
        }
    }

    private final zzawn zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzawn zzawnVar = (zzawn) objArr[i3];
        if (zzawnVar != null) {
            return zzawnVar;
        }
        zzawn zzawnVarZzb = zzawf.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzawnVarZzb;
        return zzawnVarZzb;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzaus zzs(int i) {
        int i2 = i / 3;
        return (zzaus) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzawn zzawnVarZzq = zzq(i);
        int iZzA = zzA(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzawnVarZzq.zza();
        }
        Object object = zzb.getObject(obj, iZzA);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzawnVarZzq.zza();
        if (object != null) {
            zzawnVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzO(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzawn zzawnVarZzq = zzq(i2);
        if (!zzP(obj, i, i2)) {
            return zzawnVarZzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzawnVarZzq.zza();
        if (object != null) {
            zzawnVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzQ(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzaxa zzaxaVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzn = zzaxh.zzn(obj, zzA(i) & 1048575);
        if (objZzn == null || zzs(i) == null) {
            return obj2;
        }
        throw null;
    }

    private static boolean zzy(Object obj, int i, zzawn zzawnVar) {
        return zzawnVar.zzl(zzaxh.zzn(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzawi zzawiVar) throws IOException {
        long j = i & 1048575;
        if (zzD(i)) {
            zzaxh.zzo(obj, j, zzawiVar.zzm());
        } else if (this.zzi) {
            zzaxh.zzo(obj, j, zzawiVar.zzl());
        } else {
            zzaxh.zzo(obj, j, zzawiVar.zzp());
        }
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final Object zza() {
        return ((zzaun) this.zzg).zzav();
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzC;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzA = zzA(i);
            long j = iZzA & 1048575;
            switch (zzC(iZzA)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzaxh.zzl(obj, j)) != Double.doubleToLongBits(zzaxh.zzl(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzaxh.zzj(obj, j)) != Float.floatToIntBits(zzaxh.zzj(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzaxh.zzf(obj, j) != zzaxh.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzaxh.zzf(obj, j) != zzaxh.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzaxh.zzd(obj, j) != zzaxh.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzaxh.zzf(obj, j) != zzaxh.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzaxh.zzd(obj, j) != zzaxh.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzaxh.zzh(obj, j) != zzaxh.zzh(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzawp.zzC(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzawp.zzC(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzawp.zzC(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzaxh.zzd(obj, j) != zzaxh.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzaxh.zzd(obj, j) != zzaxh.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzaxh.zzd(obj, j) != zzaxh.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzaxh.zzf(obj, j) != zzaxh.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzaxh.zzd(obj, j) != zzaxh.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzaxh.zzf(obj, j) != zzaxh.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzawp.zzC(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j))) {
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
                    zZzC = zzawp.zzC(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j));
                    break;
                case 50:
                    zZzC = zzawp.zzC(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j));
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
                    long jZzB = zzB(i) & 1048575;
                    if (zzaxh.zzd(obj, jZzB) != zzaxh.zzd(obj2, jZzB) || !zzawp.zzC(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j))) {
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
        if (!((zzaun) obj).zzc.equals(((zzaun) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzauk) obj).zza.equals(((zzauk) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.pal.zzawn
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
                int iHashCode = (i4 * 53) + ((zzaun) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzauk) obj).zza.zza.hashCode() : iHashCode;
            }
            int iZzA = zzA(i3);
            int i5 = 1048575 & iZzA;
            int iZzC = zzC(iZzA);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzC) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzaxh.zzl(obj, j));
                    byte[] bArr = zzauz.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzaxh.zzj(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaxh.zzf(obj, j);
                    byte[] bArr2 = zzauz.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaxh.zzf(obj, j);
                    byte[] bArr3 = zzauz.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaxh.zzf(obj, j);
                    byte[] bArr4 = zzauz.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzauz.zza(zzaxh.zzh(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzaxh.zzn(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzn = zzaxh.zzn(obj, j);
                    if (objZzn != null) {
                        iHashCode2 = objZzn.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaxh.zzf(obj, j);
                    byte[] bArr5 = zzauz.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzaxh.zzf(obj, j);
                    byte[] bArr6 = zzauz.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzn2 = zzaxh.zzn(obj, j);
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
                    iFloatToIntBits = zzaxh.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzaxh.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzG(obj, j));
                        byte[] bArr7 = zzauz.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzH(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr8 = zzauz.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr9 = zzauz.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr10 = zzauz.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzauz.zza(zzK(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzaxh.zzn(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzaxh.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzaxh.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr11 = zzauz.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr12 = zzauz.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzaxh.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzd(Object obj, Object obj2) {
        zzF(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzawp.zzE(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzawp.zzD(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzA = zzA(i);
            int i2 = 1048575 & iZzA;
            int iZzC = zzC(iZzA);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzC) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzaxh.zzm(obj, j, zzaxh.zzl(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzaxh.zzk(obj, j, zzaxh.zzj(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzaxh.zzg(obj, j, zzaxh.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzaxh.zzg(obj, j, zzaxh.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzaxh.zze(obj, j, zzaxh.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzaxh.zzg(obj, j, zzaxh.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzaxh.zze(obj, j, zzaxh.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzaxh.zzi(obj, j, zzaxh.zzh(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzaxh.zzo(obj, j, zzaxh.zzn(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 9:
                    zzo(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzaxh.zzo(obj, j, zzaxh.zzn(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzaxh.zze(obj, j, zzaxh.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzaxh.zze(obj, j, zzaxh.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzaxh.zze(obj, j, zzaxh.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzaxh.zzg(obj, j, zzaxh.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzaxh.zze(obj, j, zzaxh.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzaxh.zzg(obj, j, zzaxh.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 17:
                    zzo(obj, obj2, i);
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
                    zzauy zzauyVarZzg = (zzauy) zzaxh.zzn(obj, j);
                    zzauy zzauyVar = (zzauy) zzaxh.zzn(obj2, j);
                    int size = zzauyVarZzg.size();
                    int size2 = zzauyVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzauyVarZzg.zza()) {
                            zzauyVarZzg = zzauyVarZzg.zzg(size2 + size);
                        }
                        zzauyVarZzg.addAll(zzauyVar);
                    }
                    if (size > 0) {
                        zzauyVar = zzauyVarZzg;
                    }
                    zzaxh.zzo(obj, j, zzauyVar);
                    break;
                case 50:
                    int i4 = zzawp.zza;
                    zzaxh.zzo(obj, j, zzavr.zzb(zzaxh.zzn(obj, j), zzaxh.zzn(obj2, j)));
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
                    if (zzP(obj2, i3, i)) {
                        zzaxh.zzo(obj, j, zzaxh.zzn(obj2, j));
                        zzQ(obj, i3, i);
                    }
                    break;
                case 60:
                    zzp(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzP(obj2, i3, i)) {
                        zzaxh.zzo(obj, j, zzaxh.zzn(obj2, j));
                        zzQ(obj, i3, i);
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    zzp(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x0389  */
    /* JADX WARN: Code duplicated, block: B:211:0x0553  */
    @Override // com.google.android.gms.internal.pal.zzawn
    public final int zze(Object obj) {
        int i;
        int iZzu;
        int iZzu2;
        int iZzv;
        int iZzu3;
        int iZzu4;
        int iZzu5;
        int iZzb;
        int iZzu6;
        int iZzz;
        int iZzo;
        int size;
        int iZzp;
        int iZzu7;
        int iZzb2;
        int iZzu8;
        int iZzb3;
        int iZzu9;
        int iZzu10;
        int iZzar;
        int iZzu11;
        int iZzu12;
        int iZzv2;
        int iZzx;
        int iZzu13;
        int iZzu14;
        int iZzA;
        int iZzu15;
        int iZzu16;
        int iZzu17;
        int iZzb4;
        int iZzu18;
        zzavz<T> zzavzVar = this;
        Unsafe unsafe = zzb;
        int i2 = 0;
        int i3 = 0;
        int iZzu19 = 0;
        int i4 = 1048575;
        while (true) {
            int[] iArr = zzavzVar.zzc;
            if (i2 >= iArr.length) {
                int iZzi = iZzu19 + ((zzaun) obj).zzc.zzi();
                if (!zzavzVar.zzh) {
                    return iZzi;
                }
                zzawu zzawuVar = ((zzauk) obj).zza.zza;
                int iZzc = zzawuVar.zzc();
                int iZzg = 0;
                for (int i5 = 0; i5 < iZzc; i5++) {
                    Map.Entry entryZzd = zzawuVar.zzd(i5);
                    iZzg += zzaud.zzg((zzauc) ((zzawr) entryZzd).zza(), entryZzd.getValue());
                }
                for (Map.Entry entry : zzawuVar.zze()) {
                    iZzg += zzaud.zzg((zzauc) entry.getKey(), entry.getValue());
                }
                return iZzi + iZzg;
            }
            int iZzA2 = zzavzVar.zzA(i2);
            int iZzC = zzC(iZzA2);
            int i6 = iArr[i2];
            int i7 = iArr[i2 + 2];
            int i8 = i7 & 1048575;
            if (iZzC <= 17) {
                if (i8 != i4) {
                    i3 = i8 == 1048575 ? 0 : unsafe.getInt(obj, i8);
                    i4 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzA2 & 1048575;
            if (iZzC >= zzaue.DOUBLE_LIST_PACKED.zza()) {
                zzaue.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzC) {
                case 0:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzu19 += zzatt.zzu(i6 << 3) + 8;
                    }
                    i2 += 3;
                    break;
                case 1:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzu = zzatt.zzu(i6 << 3);
                        iZzu4 = iZzu + 4;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 2:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzu2 = zzatt.zzu(i6 << 3);
                        iZzv = zzatt.zzv(j2);
                        iZzu4 = iZzu2 + iZzv;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 3:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzu2 = zzatt.zzu(i6 << 3);
                        iZzv = zzatt.zzv(j3);
                        iZzu4 = iZzu2 + iZzv;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 4:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzu2 = zzatt.zzu(i6 << 3);
                        iZzv = zzatt.zzv(j4);
                        iZzu4 = iZzu2 + iZzv;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 5:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzu3 = zzatt.zzu(i6 << 3);
                        iZzu4 = iZzu3 + 8;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 6:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzu = zzatt.zzu(i6 << 3);
                        iZzu4 = iZzu + 4;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 7:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzu4 = zzatt.zzu(i6 << 3) + 1;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 8:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzatl) {
                            iZzu5 = zzatt.zzu(i10);
                            iZzb = ((zzatl) object).zzb();
                            iZzu6 = zzatt.zzu(iZzb);
                        } else {
                            iZzu5 = zzatt.zzu(i10);
                            iZzb = zzaxm.zzb((String) object);
                            iZzu6 = zzatt.zzu(iZzb);
                        }
                        iZzu4 = iZzu5 + iZzu6 + iZzb;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 9:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzz = zzawp.zzz(i6, unsafe.getObject(obj, j), zzavzVar.zzq(i2));
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 10:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        zzatl zzatlVar = (zzatl) unsafe.getObject(obj, j);
                        iZzu5 = zzatt.zzu(i6 << 3);
                        iZzb = zzatlVar.zzb();
                        iZzu6 = zzatt.zzu(iZzb);
                        iZzu4 = iZzu5 + iZzu6 + iZzb;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 11:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzu2 = zzatt.zzu(i6 << 3);
                        iZzv = zzatt.zzu(i11);
                        iZzu4 = iZzu2 + iZzv;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 12:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzu2 = zzatt.zzu(i6 << 3);
                        iZzv = zzatt.zzv(j5);
                        iZzu4 = iZzu2 + iZzv;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 13:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzu = zzatt.zzu(i6 << 3);
                        iZzu4 = iZzu + 4;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 14:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzu3 = zzatt.zzu(i6 << 3);
                        iZzu4 = iZzu3 + 8;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 15:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzu2 = zzatt.zzu(i6 << 3);
                        iZzv = zzatt.zzu((i12 >> 31) ^ (i12 + i12));
                        iZzu4 = iZzu2 + iZzv;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 16:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzu2 = zzatt.zzu(i6 << 3);
                        iZzv = zzatt.zzv((j6 >> 63) ^ (j6 + j6));
                        iZzu4 = iZzu2 + iZzv;
                        iZzu19 += iZzu4;
                    }
                    zzavzVar = this;
                    i2 += 3;
                    break;
                case 17:
                    if (zzavzVar.zzM(obj, i2, i4, i3, i)) {
                        iZzz = zzawp.zzA(i6, (zzavw) unsafe.getObject(obj, j), zzavzVar.zzq(i2));
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 18:
                    iZzz = zzawp.zzy(i6, (List) unsafe.getObject(obj, j), false);
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 19:
                    iZzz = zzawp.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzawp.zza;
                    if (list.size() == 0) {
                        iZzo = 0;
                    } else {
                        iZzo = zzawp.zzo(list) + (list.size() * zzatt.zzu(i6 << 3));
                    }
                    iZzu19 += iZzo;
                    i2 += 3;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzawp.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzawp.zzp(list2);
                        iZzu7 = zzatt.zzu(i6 << 3);
                        iZzv2 = size * iZzu7;
                        iZzz = iZzp + iZzv2;
                    }
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzawp.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzawp.zzs(list3);
                        iZzu7 = zzatt.zzu(i6 << 3);
                        iZzv2 = size * iZzu7;
                        iZzz = iZzp + iZzv2;
                    }
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 23:
                    iZzz = zzawp.zzy(i6, (List) unsafe.getObject(obj, j), false);
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 24:
                    iZzz = zzawp.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzawp.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzz = 0;
                    } else {
                        iZzz = size2 * (zzatt.zzu(i6 << 3) + 1);
                    }
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i17 = zzawp.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzo = 0;
                    } else {
                        iZzo = zzatt.zzu(i6 << 3) * size3;
                        if (list5 instanceof zzavi) {
                            zzavi zzaviVar = (zzavi) list5;
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object objZzc = zzaviVar.zzc();
                                if (objZzc instanceof zzatl) {
                                    iZzb3 = ((zzatl) objZzc).zzb();
                                    iZzu9 = zzatt.zzu(iZzb3);
                                } else {
                                    iZzb3 = zzaxm.zzb((String) objZzc);
                                    iZzu9 = zzatt.zzu(iZzb3);
                                }
                                iZzo += iZzu9 + iZzb3;
                            }
                        } else {
                            for (int i19 = 0; i19 < size3; i19++) {
                                Object obj2 = list5.get(i19);
                                if (obj2 instanceof zzatl) {
                                    iZzb2 = ((zzatl) obj2).zzb();
                                    iZzu8 = zzatt.zzu(iZzb2);
                                } else {
                                    iZzb2 = zzaxm.zzb((String) obj2);
                                    iZzu8 = zzatt.zzu(iZzb2);
                                }
                                iZzo += iZzu8 + iZzb2;
                            }
                        }
                    }
                    iZzu19 += iZzo;
                    i2 += 3;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzawn zzawnVarZzq = zzavzVar.zzq(i2);
                    int i20 = zzawp.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzu10 = 0;
                    } else {
                        iZzu10 = zzatt.zzu(i6 << 3) * size4;
                        for (int i21 = 0; i21 < size4; i21++) {
                            Object obj3 = list6.get(i21);
                            if (obj3 instanceof zzavh) {
                                iZzar = ((zzavh) obj3).zzb();
                                iZzu11 = zzatt.zzu(iZzar);
                            } else {
                                iZzar = ((zzasx) obj3).zzar(zzawnVarZzq);
                                iZzu11 = zzatt.zzu(iZzar);
                            }
                            iZzu10 += iZzu11 + iZzar;
                        }
                    }
                    iZzu19 += iZzu10;
                    i2 += 3;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzawp.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzu12 = 0;
                    } else {
                        iZzu12 = size5 * zzatt.zzu(i6 << 3);
                        for (int i23 = 0; i23 < list7.size(); i23++) {
                            int iZzb5 = ((zzatl) list7.get(i23)).zzb();
                            iZzu12 += zzatt.zzu(iZzb5) + iZzb5;
                        }
                    }
                    iZzu19 += iZzu12;
                    i2 += 3;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzawp.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzawp.zzt(list8);
                        iZzu7 = zzatt.zzu(i6 << 3);
                        iZzv2 = size * iZzu7;
                        iZzz = iZzp + iZzv2;
                    }
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzawp.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzawp.zzr(list9);
                        iZzu7 = zzatt.zzu(i6 << 3);
                        iZzv2 = size * iZzu7;
                        iZzz = iZzp + iZzv2;
                    }
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 31:
                    iZzz = zzawp.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 32:
                    iZzz = zzawp.zzy(i6, (List) unsafe.getObject(obj, j), false);
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i26 = zzawp.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzawp.zzu(list10);
                        iZzu7 = zzatt.zzu(i6 << 3);
                        iZzv2 = size * iZzu7;
                        iZzz = iZzp + iZzv2;
                    }
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i27 = zzawp.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzz = 0;
                    } else {
                        iZzp = zzawp.zzq(list11);
                        iZzu7 = zzatt.zzu(i6 << 3);
                        iZzv2 = size * iZzu7;
                        iZzz = iZzp + iZzv2;
                    }
                    iZzu19 += iZzz;
                    i2 += 3;
                    break;
                case 35:
                    iZzx = zzawp.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 36:
                    iZzx = zzawp.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 37:
                    iZzx = zzawp.zzo((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 38:
                    iZzx = zzawp.zzp((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 39:
                    iZzx = zzawp.zzs((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 40:
                    iZzx = zzawp.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 41:
                    iZzx = zzawp.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i28 = zzawp.zza;
                    iZzx = list12.size();
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 43:
                    iZzx = zzawp.zzt((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 44:
                    iZzx = zzawp.zzr((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 45:
                    iZzx = zzawp.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 46:
                    iZzx = zzawp.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 47:
                    iZzx = zzawp.zzu((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 48:
                    iZzx = zzawp.zzq((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzu13 = zzatt.zzu(i6 << 3);
                        iZzu14 = zzatt.zzu(iZzx);
                        iZzu12 = iZzu13 + iZzu14 + iZzx;
                        iZzu19 += iZzu12;
                    }
                    i2 += 3;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzawn zzawnVarZzq2 = zzavzVar.zzq(i2);
                    int i29 = zzawp.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzA = 0;
                    } else {
                        iZzA = 0;
                        for (int i30 = 0; i30 < size6; i30++) {
                            iZzA += zzawp.zzA(i6, (zzavw) list13.get(i30), zzawnVarZzq2);
                        }
                    }
                    iZzu19 += iZzA;
                    i2 += 3;
                    break;
                case 50:
                    zzavq zzavqVar = (zzavq) unsafe.getObject(obj, j);
                    if (zzavqVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzavqVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i2 += 3;
                case 51:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzu15 = zzatt.zzu(i6 << 3);
                        iZzz = iZzu15 + 8;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 52:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzu16 = zzatt.zzu(i6 << 3);
                        iZzz = iZzu16 + 4;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 53:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        long jZzJ = zzJ(obj, j);
                        iZzp = zzatt.zzu(i6 << 3);
                        iZzv2 = zzatt.zzv(jZzJ);
                        iZzz = iZzp + iZzv2;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 54:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        long jZzJ2 = zzJ(obj, j);
                        iZzp = zzatt.zzu(i6 << 3);
                        iZzv2 = zzatt.zzv(jZzJ2);
                        iZzz = iZzp + iZzv2;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 55:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        long jZzI = zzI(obj, j);
                        iZzp = zzatt.zzu(i6 << 3);
                        iZzv2 = zzatt.zzv(jZzI);
                        iZzz = iZzp + iZzv2;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 56:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzu15 = zzatt.zzu(i6 << 3);
                        iZzz = iZzu15 + 8;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 57:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzu16 = zzatt.zzu(i6 << 3);
                        iZzz = iZzu16 + 4;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 58:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzz = zzatt.zzu(i6 << 3) + 1;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        int i31 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzatl) {
                            iZzu17 = zzatt.zzu(i31);
                            iZzb4 = ((zzatl) object2).zzb();
                            iZzu18 = zzatt.zzu(iZzb4);
                        } else {
                            iZzu17 = zzatt.zzu(i31);
                            iZzb4 = zzaxm.zzb((String) object2);
                            iZzu18 = zzatt.zzu(iZzb4);
                        }
                        iZzz = iZzu17 + iZzu18 + iZzb4;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 60:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzz = zzawp.zzz(i6, unsafe.getObject(obj, j), zzavzVar.zzq(i2));
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 61:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        zzatl zzatlVar2 = (zzatl) unsafe.getObject(obj, j);
                        iZzu17 = zzatt.zzu(i6 << 3);
                        iZzb4 = zzatlVar2.zzb();
                        iZzu18 = zzatt.zzu(iZzb4);
                        iZzz = iZzu17 + iZzu18 + iZzb4;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 62:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        int iZzI = zzI(obj, j);
                        iZzp = zzatt.zzu(i6 << 3);
                        iZzv2 = zzatt.zzu(iZzI);
                        iZzz = iZzp + iZzv2;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 63:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        long jZzI2 = zzI(obj, j);
                        iZzp = zzatt.zzu(i6 << 3);
                        iZzv2 = zzatt.zzv(jZzI2);
                        iZzz = iZzp + iZzv2;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 64:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzu16 = zzatt.zzu(i6 << 3);
                        iZzz = iZzu16 + 4;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 65:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzu15 = zzatt.zzu(i6 << 3);
                        iZzz = iZzu15 + 8;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 66:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        int iZzI2 = zzI(obj, j);
                        iZzp = zzatt.zzu(i6 << 3);
                        iZzv2 = zzatt.zzu((iZzI2 >> 31) ^ (iZzI2 + iZzI2));
                        iZzz = iZzp + iZzv2;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case 67:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        long jZzJ3 = zzJ(obj, j);
                        iZzp = zzatt.zzu(i6 << 3);
                        iZzv2 = zzatt.zzv((jZzJ3 >> 63) ^ (jZzJ3 + jZzJ3));
                        iZzz = iZzp + iZzv2;
                        iZzu19 += iZzz;
                    }
                    i2 += 3;
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzavzVar.zzP(obj, i6, i2)) {
                        iZzz = zzawp.zzA(i6, (zzavw) unsafe.getObject(obj, j), zzavzVar.zzq(i2));
                        iZzu19 += iZzz;
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
    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzf(Object obj, zzaxp zzaxpVar) throws IOException {
        Map.Entry entry;
        int i;
        zzavz<T> zzavzVar = this;
        if (zzavzVar.zzh) {
            zzaud zzaudVar = ((zzauk) obj).zza;
            if (zzaudVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzaudVar.zzc().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = zzavzVar.zzc;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < iArr.length) {
            int iZzA = zzavzVar.zzA(i4);
            int iZzC = zzC(iZzA);
            int i6 = iArr[i4];
            if (iZzC <= 17) {
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
            long j = iZzA & i2;
            switch (iZzC) {
                case 0:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzf(i6, zzaxh.zzl(obj, j));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 1:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zze(i6, zzaxh.zzj(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 2:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzc(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 3:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzh(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 4:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzi(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 5:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzj(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 6:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzk(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 7:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzl(i6, zzaxh.zzh(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 8:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzT(i6, unsafe.getObject(obj, j), zzaxpVar);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 9:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzr(i6, unsafe.getObject(obj, j), zzavzVar.zzq(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 10:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzn(i6, (zzatl) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 11:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzo(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 12:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzg(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 13:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzb(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 14:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzd(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 15:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzp(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 16:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzq(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 17:
                    if (zzavzVar.zzM(obj, i4, i3, i5, i)) {
                        zzaxpVar.zzs(i6, unsafe.getObject(obj, j), zzavzVar.zzq(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 18:
                    zzawp.zza(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 19:
                    zzawp.zzb(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 20:
                    zzawp.zzc(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 21:
                    zzawp.zzd(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 22:
                    zzawp.zzh(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 23:
                    zzawp.zzf(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 24:
                    zzawp.zzk(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 25:
                    zzawp.zzn(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 26:
                    int i9 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    int i10 = zzawp.zza;
                    if (list != null && !list.isEmpty()) {
                        zzaxpVar.zzF(i9, list);
                    }
                    break;
                case 27:
                    int i11 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzawn zzawnVarZzq = zzavzVar.zzq(i4);
                    int i12 = zzawp.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i13 = 0; i13 < list2.size(); i13++) {
                            ((zzatu) zzaxpVar).zzr(i11, list2.get(i13), zzawnVarZzq);
                        }
                    }
                    break;
                case 28:
                    int i14 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzawp.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzaxpVar.zzG(i14, list3);
                    }
                    break;
                case 29:
                    zzawp.zzi(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 30:
                    zzawp.zzm(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 31:
                    zzawp.zzl(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 32:
                    zzawp.zzg(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 33:
                    zzawp.zzj(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 34:
                    zzawp.zze(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzavzVar = this;
                    break;
                case 35:
                    zzawp.zza(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 36:
                    zzawp.zzb(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 37:
                    zzawp.zzc(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 38:
                    zzawp.zzd(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 39:
                    zzawp.zzh(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 40:
                    zzawp.zzf(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 41:
                    zzawp.zzk(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 42:
                    zzawp.zzn(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 43:
                    zzawp.zzi(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 44:
                    zzawp.zzm(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 45:
                    zzawp.zzl(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 46:
                    zzawp.zzg(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 47:
                    zzawp.zzj(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 48:
                    zzawp.zze(iArr[i4], (List) unsafe.getObject(obj, j), zzaxpVar, true);
                    break;
                case 49:
                    int i16 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzawn zzawnVarZzq2 = zzavzVar.zzq(i4);
                    int i17 = zzawp.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            ((zzatu) zzaxpVar).zzs(i16, list4.get(i18), zzawnVarZzq2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzf(i6, zzG(obj, j));
                    }
                    break;
                case 52:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zze(i6, zzH(obj, j));
                    }
                    break;
                case 53:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzc(i6, zzJ(obj, j));
                    }
                    break;
                case 54:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzh(i6, zzJ(obj, j));
                    }
                    break;
                case 55:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzi(i6, zzI(obj, j));
                    }
                    break;
                case 56:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzj(i6, zzJ(obj, j));
                    }
                    break;
                case 57:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzk(i6, zzI(obj, j));
                    }
                    break;
                case 58:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzl(i6, zzK(obj, j));
                    }
                    break;
                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzT(i6, unsafe.getObject(obj, j), zzaxpVar);
                    }
                    break;
                case 60:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzr(i6, unsafe.getObject(obj, j), zzavzVar.zzq(i4));
                    }
                    break;
                case 61:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzn(i6, (zzatl) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzo(i6, zzI(obj, j));
                    }
                    break;
                case 63:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzg(i6, zzI(obj, j));
                    }
                    break;
                case 64:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzb(i6, zzI(obj, j));
                    }
                    break;
                case 65:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzd(i6, zzJ(obj, j));
                    }
                    break;
                case 66:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzp(i6, zzI(obj, j));
                    }
                    break;
                case 67:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzq(i6, zzJ(obj, j));
                    }
                    break;
                case EACTags.APPLICATION_IMAGE /* 68 */:
                    if (zzavzVar.zzP(obj, i6, i4)) {
                        zzaxpVar.zzs(i6, unsafe.getObject(obj, j), zzavzVar.zzq(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
            zzavzVar = this;
        }
        if (entry != null) {
            throw null;
        }
        ((zzaun) obj).zzc.zzg(zzaxpVar);
    }

    /* JADX WARN: Code duplicated, block: B:196:0x05ab A[LOOP:2: B:194:0x05a7->B:196:0x05ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:198:0x05b8  */
    /* JADX WARN: Code duplicated, block: B:200:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:210:0x05d0 A[LOOP:1: B:208:0x05cc->B:210:0x05d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:212:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:240:0x059b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:321:0x05a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:330:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:331:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzg(Object obj, zzawi zzawiVar, zzaty zzatyVar) throws Throwable {
        Object obj2;
        Throwable th;
        int i;
        zzaxa zzaxaVar;
        Object obj3;
        int i2;
        zzatyVar.getClass();
        zzF(obj);
        zzaxa zzaxaVar2 = this.zzm;
        Object objZzh = null;
        while (true) {
            try {
                int iZzb = zzawiVar.zzb();
                int iZzR = this.zzR(iZzb);
                if (iZzR < 0) {
                    if (iZzb == Integer.MAX_VALUE) {
                        int i3 = this.zzk;
                        while (i3 < this.zzl) {
                            zzavz<T> zzavzVar = this;
                            Object obj4 = obj;
                            zzavzVar.zzx(obj4, this.zzj[i3], objZzh, zzaxaVar2, obj);
                            i3++;
                            obj = obj4;
                            this = zzavzVar;
                            zzaxaVar2 = zzaxaVar2;
                        }
                        zzaxaVar = zzaxaVar2;
                        obj2 = obj;
                    } else {
                        this = this;
                        Object obj5 = obj;
                        zzaxaVar = zzaxaVar2;
                        obj3 = objZzh;
                        try {
                            if ((!this.zzh ? null : zzatyVar.zzc(this.zzg, iZzb)) != null) {
                                throw null;
                            }
                            if (obj3 == null) {
                                try {
                                    objZzh = zzaxaVar.zzh(obj5);
                                } catch (Throwable th2) {
                                    th = th2;
                                    obj2 = obj5;
                                    objZzh = obj3;
                                }
                            } else {
                                objZzh = obj3;
                            }
                            try {
                                if (zzaxaVar.zzk(objZzh, zzawiVar, 0)) {
                                    obj2 = obj5;
                                    this = this;
                                    obj = obj2;
                                    zzaxaVar2 = zzaxaVar;
                                } else {
                                    int i4 = this.zzk;
                                    while (i4 < this.zzl) {
                                        zzaxa zzaxaVar3 = zzaxaVar;
                                        Object obj6 = obj5;
                                        this.zzx(obj6, this.zzj[i4], objZzh, zzaxaVar3, obj5);
                                        zzaxaVar = zzaxaVar3;
                                        i4++;
                                        obj5 = obj6;
                                    }
                                    obj2 = obj5;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                obj2 = obj5;
                            }
                        } catch (Throwable th4) {
                            obj2 = obj5;
                            th = th4;
                            obj2 = obj2;
                            objZzh = obj3;
                            zzaxaVar2 = zzaxaVar;
                            for (i = this.zzk; i < this.zzl; i++) {
                                this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
                            }
                            if (objZzh != null) {
                                throw th;
                            }
                            zzaxaVar2.zzi(obj2, objZzh);
                            throw th;
                        }
                    }
                    zzaxaVar2 = zzaxaVar;
                } else {
                    obj2 = obj;
                    zzaxaVar = zzaxaVar2;
                    obj3 = objZzh;
                    try {
                        int iZzA = this.zzA(iZzR);
                        try {
                            switch (zzC(iZzA)) {
                                case 0:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzm(obj2, iZzA & 1048575, zzawiVar.zzd());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 1:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzk(obj2, iZzA & 1048575, zzawiVar.zze());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 2:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzg(obj2, iZzA & 1048575, zzawiVar.zzg());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 3:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzg(obj2, iZzA & 1048575, zzawiVar.zzf());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 4:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zze(obj2, iZzA & 1048575, zzawiVar.zzh());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 5:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzg(obj2, iZzA & 1048575, zzawiVar.zzi());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 6:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zze(obj2, iZzA & 1048575, zzawiVar.zzj());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 7:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzi(obj2, iZzA & 1048575, zzawiVar.zzk());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 8:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    this.zzz(obj2, iZzA, zzawiVar);
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 9:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzavw zzavwVar = (zzavw) this.zzt(obj2, iZzR);
                                    zzawiVar.zzn(zzavwVar, this.zzq(iZzR), zzatyVar);
                                    this.zzu(obj2, iZzR, zzavwVar);
                                    obj = obj2;
                                    break;
                                case 10:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzo(obj2, iZzA & 1048575, zzawiVar.zzp());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 11:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zze(obj2, iZzA & 1048575, zzawiVar.zzq());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 12:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    int iZzr = zzawiVar.zzr();
                                    zzaus zzausVarZzs = this.zzs(iZzR);
                                    if (zzausVarZzs == null || zzausVarZzs.zza(iZzr)) {
                                        zzaxh.zze(obj2, iZzA & 1048575, iZzr);
                                        this.zzO(obj2, iZzR);
                                    } else {
                                        objZzh = zzawp.zzG(obj2, iZzb, iZzr, objZzh, zzaxaVar2);
                                    }
                                    obj = obj2;
                                    break;
                                case 13:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zze(obj2, iZzA & 1048575, zzawiVar.zzs());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 14:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzg(obj2, iZzA & 1048575, zzawiVar.zzt());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 15:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zze(obj2, iZzA & 1048575, zzawiVar.zzu());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 16:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzaxh.zzg(obj2, iZzA & 1048575, zzawiVar.zzv());
                                    this.zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 17:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzavw zzavwVar2 = (zzavw) this.zzt(obj2, iZzR);
                                    zzawiVar.zzo(zzavwVar2, this.zzq(iZzR), zzatyVar);
                                    this.zzu(obj2, iZzR, zzavwVar2);
                                    obj = obj2;
                                    break;
                                case 18:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzw(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 19:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzx(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 20:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzz(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 21:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzy(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 22:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzA(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 23:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzB(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 24:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzC(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 25:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzD(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 26:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    if (zzD(iZzA)) {
                                        ((zzatq) zzawiVar).zzE(zzavj.zza(obj2, iZzA & 1048575), true);
                                    } else {
                                        ((zzatq) zzawiVar).zzE(zzavj.zza(obj2, iZzA & 1048575), false);
                                    }
                                    obj = obj2;
                                    break;
                                case 27:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzF(zzavj.zza(obj2, iZzA & 1048575), this.zzq(iZzR), zzatyVar);
                                    obj = obj2;
                                    break;
                                case 28:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzH(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 29:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzI(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 30:
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    try {
                                        List listZza = zzavj.zza(obj2, iZzA & 1048575);
                                        zzawiVar.zzJ(listZza);
                                        zzaxaVar = zzaxaVar2;
                                        try {
                                            try {
                                                objZzh = zzawp.zzF(obj2, iZzb, listZza, this.zzs(iZzR), objZzh, zzaxaVar);
                                                obj2 = obj2;
                                                zzaxaVar2 = zzaxaVar;
                                            } catch (zzava unused) {
                                                objZzh = objZzh;
                                                obj2 = obj2;
                                                zzaxaVar2 = zzaxaVar;
                                                this = this;
                                                if (objZzh == null) {
                                                    try {
                                                        objZzh = zzaxaVar2.zzh(obj2);
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        th = th;
                                                        while (i < this.zzl) {
                                                            this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
                                                        }
                                                        if (objZzh != null) {
                                                            throw th;
                                                        }
                                                        zzaxaVar2.zzi(obj2, objZzh);
                                                        throw th;
                                                    }
                                                }
                                                if (!zzaxaVar2.zzk(objZzh, zzawiVar, 0)) {
                                                    for (i2 = this.zzk; i2 < this.zzl; i2++) {
                                                        this.zzx(obj2, this.zzj[i2], objZzh, zzaxaVar2, obj2);
                                                    }
                                                    if (objZzh != null) {
                                                        zzaxaVar2.zzi(obj2, objZzh);
                                                    }
                                                }
                                                this = this;
                                            }
                                        } catch (zzava unused2) {
                                            objZzh = objZzh;
                                            zzaxaVar2 = zzaxaVar;
                                            if (objZzh == null) {
                                                objZzh = zzaxaVar2.zzh(obj2);
                                            }
                                            if (!zzaxaVar2.zzk(objZzh, zzawiVar, 0)) {
                                                while (i2 < this.zzl) {
                                                    this.zzx(obj2, this.zzj[i2], objZzh, zzaxaVar2, obj2);
                                                }
                                                if (objZzh != null) {
                                                    zzaxaVar2.zzi(obj2, objZzh);
                                                }
                                            }
                                            this = this;
                                        }
                                    } catch (zzava unused3) {
                                        this = this;
                                        obj2 = obj2;
                                        if (objZzh == null) {
                                            objZzh = zzaxaVar2.zzh(obj2);
                                        }
                                        if (!zzaxaVar2.zzk(objZzh, zzawiVar, 0)) {
                                            while (i2 < this.zzl) {
                                                this.zzx(obj2, this.zzj[i2], objZzh, zzaxaVar2, obj2);
                                            }
                                            if (objZzh != null) {
                                                zzaxaVar2.zzi(obj2, objZzh);
                                            }
                                        }
                                        this = this;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        obj2 = obj2;
                                        th = th;
                                        this = this;
                                        while (i < this.zzl) {
                                            this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
                                        }
                                        if (objZzh != null) {
                                            throw th;
                                        }
                                        zzaxaVar2.zzi(obj2, objZzh);
                                        throw th;
                                    }
                                    obj = obj2;
                                    break;
                                case 31:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzK(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 32:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzL(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 33:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzM(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 34:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzN(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 35:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzw(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 36:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzx(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 37:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzz(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 38:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzy(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 39:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzA(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 40:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzB(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 41:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzC(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 42:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzD(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 43:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    zzawiVar.zzI(zzavj.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 44:
                                    try {
                                        List listZza2 = zzavj.zza(obj2, iZzA & 1048575);
                                        zzawiVar.zzJ(listZza2);
                                        try {
                                            try {
                                                objZzh = zzawp.zzF(obj2, iZzb, listZza2, this.zzs(iZzR), obj3, zzaxaVar);
                                                obj2 = obj2;
                                                zzaxaVar2 = zzaxaVar;
                                            } catch (zzava unused4) {
                                                obj2 = obj2;
                                                objZzh = obj3;
                                                zzaxaVar2 = zzaxaVar;
                                                this = this;
                                                if (objZzh == null) {
                                                    objZzh = zzaxaVar2.zzh(obj2);
                                                }
                                                if (!zzaxaVar2.zzk(objZzh, zzawiVar, 0)) {
                                                    while (i2 < this.zzl) {
                                                        this.zzx(obj2, this.zzj[i2], objZzh, zzaxaVar2, obj2);
                                                    }
                                                    if (objZzh != null) {
                                                        zzaxaVar2.zzi(obj2, objZzh);
                                                    }
                                                }
                                                this = this;
                                            }
                                            obj = obj2;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            obj2 = obj2;
                                            objZzh = obj3;
                                            zzaxaVar2 = zzaxaVar;
                                            th = th;
                                            this = this;
                                            while (i < this.zzl) {
                                                this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
                                            }
                                            if (objZzh != null) {
                                                throw th;
                                            }
                                            zzaxaVar2.zzi(obj2, objZzh);
                                            throw th;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        obj2 = obj2;
                                    }
                                    break;
                                case 45:
                                    zzawiVar.zzK(zzavj.zza(obj2, iZzA & 1048575));
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 46:
                                    zzawiVar.zzL(zzavj.zza(obj2, iZzA & 1048575));
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 47:
                                    zzawiVar.zzM(zzavj.zza(obj2, iZzA & 1048575));
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 48:
                                    zzawiVar.zzN(zzavj.zza(obj2, iZzA & 1048575));
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 49:
                                    zzawiVar.zzG(zzavj.zza(obj2, iZzA & 1048575), this.zzq(iZzR), zzatyVar);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 50:
                                    Object objZzr = this.zzr(iZzR);
                                    long jZzA = this.zzA(iZzR) & 1048575;
                                    Object objZzn = zzaxh.zzn(obj2, jZzA);
                                    if (objZzn == null) {
                                        objZzn = zzavq.zza().zzc();
                                        zzaxh.zzo(obj2, jZzA, objZzn);
                                    } else if (zzavr.zza(objZzn)) {
                                        Object objZzc = zzavq.zza().zzc();
                                        zzavr.zzb(objZzc, objZzn);
                                        zzaxh.zzo(obj2, jZzA, objZzc);
                                        objZzn = objZzc;
                                    }
                                    throw null;
                                case 51:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Double.valueOf(zzawiVar.zzd()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 52:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Float.valueOf(zzawiVar.zze()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 53:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Long.valueOf(zzawiVar.zzg()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 54:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Long.valueOf(zzawiVar.zzf()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 55:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Integer.valueOf(zzawiVar.zzh()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 56:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Long.valueOf(zzawiVar.zzi()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 57:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Integer.valueOf(zzawiVar.zzj()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 58:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Boolean.valueOf(zzawiVar.zzk()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                                    this.zzz(obj2, iZzA, zzawiVar);
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 60:
                                    zzavw zzavwVar3 = (zzavw) this.zzv(obj2, iZzb, iZzR);
                                    zzawiVar.zzn(zzavwVar3, this.zzq(iZzR), zzatyVar);
                                    this.zzw(obj2, iZzb, iZzR, zzavwVar3);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 61:
                                    zzaxh.zzo(obj2, iZzA & 1048575, zzawiVar.zzp());
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 62:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Integer.valueOf(zzawiVar.zzq()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 63:
                                    int iZzr2 = zzawiVar.zzr();
                                    zzaus zzausVarZzs2 = this.zzs(iZzR);
                                    if (zzausVarZzs2 != null && !zzausVarZzs2.zza(iZzr2)) {
                                        objZzh = zzawp.zzG(obj2, iZzb, iZzr2, obj3, zzaxaVar);
                                        obj = obj2;
                                        zzaxaVar2 = zzaxaVar;
                                    }
                                    zzaxh.zzo(obj2, iZzA & 1048575, Integer.valueOf(iZzr2));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 64:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Integer.valueOf(zzawiVar.zzs()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 65:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Long.valueOf(zzawiVar.zzt()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 66:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Integer.valueOf(zzawiVar.zzu()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case 67:
                                    zzaxh.zzo(obj2, iZzA & 1048575, Long.valueOf(zzawiVar.zzv()));
                                    this.zzQ(obj2, iZzb, iZzR);
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    obj = obj2;
                                    break;
                                case EACTags.APPLICATION_IMAGE /* 68 */:
                                    try {
                                        zzavw zzavwVar4 = (zzavw) this.zzv(obj2, iZzb, iZzR);
                                        zzawiVar.zzo(zzavwVar4, this.zzq(iZzR), zzatyVar);
                                        this.zzw(obj2, iZzb, iZzR, zzavwVar4);
                                        obj2 = obj2;
                                        objZzh = obj3;
                                        zzaxaVar2 = zzaxaVar;
                                        obj = obj2;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        this = this;
                                        obj2 = obj2;
                                        objZzh = obj3;
                                        zzaxaVar2 = zzaxaVar;
                                        while (i < this.zzl) {
                                            this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
                                        }
                                        if (objZzh != null) {
                                            throw th;
                                        }
                                        zzaxaVar2.zzi(obj2, objZzh);
                                        throw th;
                                    }
                                    break;
                                default:
                                    obj2 = obj2;
                                    objZzh = obj3;
                                    zzaxaVar2 = zzaxaVar;
                                    if (objZzh == null) {
                                        try {
                                            try {
                                                objZzh = zzaxaVar2.zzh(obj2);
                                            } catch (Throwable th10) {
                                                th = th10;
                                                th = th;
                                                this = this;
                                                while (i < this.zzl) {
                                                    this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
                                                }
                                                if (objZzh != null) {
                                                    throw th;
                                                }
                                                zzaxaVar2.zzi(obj2, objZzh);
                                                throw th;
                                            }
                                        } catch (zzava unused5) {
                                            this = this;
                                            if (objZzh == null) {
                                                objZzh = zzaxaVar2.zzh(obj2);
                                            }
                                            if (!zzaxaVar2.zzk(objZzh, zzawiVar, 0)) {
                                                while (i2 < this.zzl) {
                                                    this.zzx(obj2, this.zzj[i2], objZzh, zzaxaVar2, obj2);
                                                }
                                                if (objZzh != null) {
                                                    zzaxaVar2.zzi(obj2, objZzh);
                                                }
                                            }
                                            this = this;
                                        }
                                    }
                                    try {
                                        if (!zzaxaVar2.zzk(objZzh, zzawiVar, 0)) {
                                            for (int i5 = this.zzk; i5 < this.zzl; i5++) {
                                                this.zzx(obj2, this.zzj[i5], objZzh, zzaxaVar2, obj2);
                                            }
                                        }
                                        obj = obj2;
                                    } catch (Throwable th11) {
                                        th = th11;
                                        this = this;
                                        th = th;
                                        while (i < this.zzl) {
                                            this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
                                        }
                                        if (objZzh != null) {
                                            throw th;
                                        }
                                        zzaxaVar2.zzi(obj2, objZzh);
                                        throw th;
                                    }
                                    break;
                            }
                        } catch (zzava unused6) {
                            objZzh = obj3;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        this = this;
                        obj2 = obj2;
                        objZzh = obj3;
                        zzaxaVar2 = zzaxaVar;
                    }
                }
                zzaxaVar2 = zzaxaVar;
            } catch (Throwable th13) {
                th = th13;
                this = this;
                obj2 = obj;
            }
            while (i < this.zzl) {
                this.zzx(obj2, this.zzj[i], objZzh, zzaxaVar2, obj2);
            }
            if (objZzh != null) {
                throw th;
            }
            zzaxaVar2.zzi(obj2, objZzh);
            throw th;
        }
        if (objZzh != null) {
            zzaxaVar2.zzi(obj2, objZzh);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 32681. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzi(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, com.google.android.gms.internal.pal.zzatb r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzavz.zzi(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.pal.zzatb):int");
    }

    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzatb zzatbVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzatbVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.pal.zzawn
    public final void zzk(Object obj) {
        if (zzE(obj)) {
            if (obj instanceof zzaun) {
                zzaun zzaunVar = (zzaun) obj;
                zzaunVar.zzaz(Integer.MAX_VALUE);
                zzaunVar.zzb = 0;
                zzaunVar.zzau();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzA = zzA(i);
                int i2 = 1048575 & iZzA;
                int iZzC = zzC(iZzA);
                long j = i2;
                if (iZzC != 9) {
                    if (iZzC != 60 && iZzC != 68) {
                        switch (iZzC) {
                            case 17:
                                if (zzN(obj, i)) {
                                    zzq(i).zzk(zzb.getObject(obj, j));
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
                                ((zzauy) zzaxh.zzn(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzavq) object).zzd();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzP(obj, iArr[i], i)) {
                        zzq(i).zzk(zzb.getObject(obj, j));
                    }
                } else if (zzN(obj, i)) {
                    zzq(i).zzk(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzj(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x008c  */
    /* JADX WARN: Code duplicated, block: B:43:0x009b  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b1 A[LOOP:1: B:44:0x00a0->B:49:0x00b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.pal.zzawn
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        List list;
        zzawn zzawnVarZzq;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzA = zzA(i7);
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
            if ((268435456 & iZzA) != 0 && !zzM(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzC = zzC(iZzA);
            if (iZzC == 9 || iZzC == 17) {
                if (zzM(obj, i7, i, i2, i11) && !zzy(obj, iZzA, zzq(i7))) {
                    return false;
                }
            } else if (iZzC == 27) {
                list = (List) zzaxh.zzn(obj, iZzA & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzawnVarZzq = zzq(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzawnVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzC == 60 || iZzC == 68) {
                if (zzP(obj, i8, i7) && !zzy(obj, iZzA, zzq(i7))) {
                    return false;
                }
            } else if (iZzC == 49) {
                list = (List) zzaxh.zzn(obj, iZzA & 1048575);
                if (list.isEmpty()) {
                    zzawnVarZzq = zzq(i7);
                    while (i3 < list.size()) {
                        if (!zzawnVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzC == 50 && !((zzavq) zzaxh.zzn(obj, iZzA & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzauk) obj).zza.zze();
    }
}
