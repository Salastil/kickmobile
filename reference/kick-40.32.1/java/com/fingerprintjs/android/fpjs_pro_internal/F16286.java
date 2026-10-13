package com.fingerprintjs.android.fpjs_pro_internal;

import androidx.compose.runtime.GapComposerKt;
import com.fingerprintjs.android.fpjs_pro.raw_signal_providers.file_timestamps.FileTimestamps;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
public final class F16286 {
    private static int setPivotYN16904 = 0;
    private static int vD14832N6715 = 1;

    public static /* synthetic */ Object D8871(int i, int i2, Object[] objArr, int i3, int i4, int i5, int i6) {
        int i7 = ~i3;
        int i8 = (~(i7 | i)) | i5;
        int i9 = i | i5 | i7;
        int i10 = i5 + i3 + i2 + (1159740906 * i6) + ((-617157175) * i4);
        int i11 = i10 * i10;
        int i12 = ((i5 * 934236018) - 2089811968) + (934236018 * i3) + (i8 * (-953110385)) + ((-953110385) * i9) + (953110385 * i7) + ((-18874368) * i2) + (1488977920 * i6) + (2111832064 * i4) + (2070937600 * i11);
        int i13 = (i5 * (-824977050)) + 1921657099 + (i3 * (-824977050)) + (i8 * (-923)) + (i9 * (-923)) + (i7 * 923) + (i2 * (-824977973)) + (i6 * (-135083378)) + (i4 * 1125239651) + (i11 * 298844160);
        return i12 + ((i13 * i13) * 2098200576) != 1 ? setPivotYN16904(objArr) : vD14832N6715(objArr);
    }

    private static /* synthetic */ D8871 D8871(F16286 f16286, String str, String str2) {
        int i = 2 % 2;
        int i2 = setPivotYN16904;
        int i3 = (i2 ^ 89) + ((i2 & 89) << 1);
        vD14832N6715 = i3 % 128;
        int i4 = i3 % 2;
        D8871<Long, Throwable> pivotYN16904 = f16286.setPivotYN16904(str, str2);
        int i5 = vD14832N6715 + 55;
        setPivotYN16904 = i5 % 128;
        int i6 = i5 % 2;
        return pivotYN16904;
    }

    private static /* synthetic */ Object setPivotYN16904(Object[] objArr) {
        D8871 vd14832n6715;
        F16286 f16286 = (F16286) objArr[0];
        String str = (String) objArr[1];
        int i = 2 % 2;
        N14263A23323 n14263a23323 = new N14263A23323();
        Object obj = null;
        try {
            N14263A23323 n14263a23324 = n14263a23323;
            vd14832n6715 = new vD14832N6715(new FileTimestamps(((Number) n14263a23324.D8871(D8871(f16286, str, I30900.setZV25350.INSTANCE.component5()))).longValue(), ((Number) n14263a23324.D8871(D8871(f16286, str, I30900.bb.INSTANCE.component5()))).longValue(), ((Number) n14263a23324.D8871(D8871(f16286, str, I30900.unregisterForContextMenu.INSTANCE.component5()))).longValue()));
            int i2 = vD14832N6715 + 113;
            setPivotYN16904 = i2 % 128;
            int i3 = i2 % 2;
        } catch (component5 unused) {
            D8871 d8871 = n14263a23323.vD14832N6715;
            if (d8871 == null) {
                int i4 = setPivotYN16904 + 73;
                vD14832N6715 = i4 % 128;
                int i5 = i4 % 2;
                d8871 = null;
            }
            vd14832n6715 = d8871;
        }
        int pivotYN16904 = aw.AnonymousClass4.setPivotYN16904();
        int i6 = ~pivotYN16904;
        int i7 = ~((-1348497813) | i6);
        int i8 = ~pivotYN16904;
        int i9 = 121011194 + (((i7 & 268443668) | (268443668 ^ i7) | (~(1801835393 | i8)) | (~(((-721781250) & pivotYN16904) | ((-721781250) ^ pivotYN16904)))) * (-84));
        int i10 = ~((pivotYN16904 & 1801835393) | (1801835393 ^ pivotYN16904));
        int i11 = (i10 & 1348497812) | (1348497812 ^ i10);
        int i12 = ~((i6 & (-1801835394)) | (i6 ^ (-1801835394)));
        int i13 = ((i11 & i12) | (i11 ^ i12)) * (-84);
        int i14 = (i9 ^ i13) + ((i13 & i9) << 1);
        int i15 = ~((i8 ^ (-1801835394)) | ((-1801835394) & i8));
        int i16 = (i14 - (~(((i15 & 721781249) | (i15 ^ 721781249)) * 84))) - 1;
        int pivotYN16905 = aw.AnonymousClass4.setPivotYN16904();
        int i17 = ~pivotYN16905;
        int i18 = (-1711014696) | i17;
        int i19 = ~((i18 & 1762800580) | (i18 ^ 1762800580));
        int i20 = ~(((-1762800581) ^ i17) | ((-1762800581) & i17) | 1711014695);
        int i21 = ((i19 & i20) | (i19 ^ i20)) * (-184);
        int i22 = ~((i17 & (-1711014696)) | ((-1711014696) ^ i17));
        int i23 = ~pivotYN16905;
        int i24 = (((((-53035517) | i21) << 1) - (i21 ^ (-53035517))) - (~(((~((i23 & (-1762800581)) | ((-1762800581) ^ i23))) | ((i22 & 1628439300) | (1628439300 ^ i22))) * 184))) - 1;
        if (i16 > (i24 ^ 246763016) + ((246763016 & i24) << 1)) {
            return vd14832n6715;
        }
        obj.hashCode();
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e8  */
    private final D8871<Long, Throwable> setPivotYN16904(String str, String str2) {
        setPivotYN16904 setpivotyn16904;
        String value;
        String value2;
        int i;
        MatchGroup matchGroup;
        String value3;
        MatchGroupCollection groups;
        MatchGroup matchGroup2;
        MatchGroup matchGroup3;
        int i2 = 2 % 2;
        try {
            F16286 f16286 = this;
            String str3 = null;
            MatchResult matchResultFind$default = Regex.find$default(new Regex(str2 + "(.*?)(" + I30900.ci.INSTANCE.component5() + ")"), str, 0, 2, null);
            if (matchResultFind$default != null) {
                int i3 = setPivotYN16904 + GapComposerKt.nodeKey;
                vD14832N6715 = i3 % 128;
                if (i3 % 2 == 0) {
                    matchResultFind$default.getGroups();
                    throw null;
                }
                MatchGroupCollection groups2 = matchResultFind$default.getGroups();
                if (groups2 == null || (matchGroup3 = groups2.get(3)) == null) {
                    value = null;
                } else {
                    value = matchGroup3.getValue();
                    int i4 = setPivotYN16904 + 85;
                    vD14832N6715 = i4 % 128;
                    int i5 = i4 % 2;
                }
            } else {
                value = null;
            }
            Intrinsics.checkNotNull(value);
            if (matchResultFind$default == null || (groups = matchResultFind$default.getGroups()) == null || (matchGroup2 = groups.get(5)) == null) {
                int i6 = vD14832N6715 + GapComposerKt.nodeKey;
                setPivotYN16904 = i6 % 128;
                int i7 = i6 % 2;
                value2 = null;
            } else {
                int i8 = vD14832N6715;
                int i9 = (i8 ^ 87) + ((i8 & 87) << 1);
                setPivotYN16904 = i9 % 128;
                if (i9 % 2 != 0) {
                    matchGroup2.getValue();
                    throw null;
                }
                value2 = matchGroup2.getValue();
                int i10 = vD14832N6715 + 43;
                setPivotYN16904 = i10 % 128;
                int i11 = i10 % 2;
            }
            Intrinsics.checkNotNull(value2);
            if (matchResultFind$default != null) {
                int i12 = setPivotYN16904;
                int i13 = ((i12 | 123) << 1) - (i12 ^ 123);
                vD14832N6715 = i13 % 128;
                if (i13 % 2 == 0) {
                    matchResultFind$default.getGroups();
                    str3.hashCode();
                    throw null;
                }
                MatchGroupCollection groups3 = matchResultFind$default.getGroups();
                if (groups3 == null || (matchGroup = groups3.get(7)) == null) {
                    i = setPivotYN16904 + 23;
                } else {
                    int i14 = setPivotYN16904;
                    int i15 = ((i14 | 69) << 1) - (i14 ^ 69);
                    vD14832N6715 = i15 % 128;
                    if (i15 % 2 == 0) {
                        value3 = matchGroup.getValue();
                        int i16 = 31 / 0;
                    } else {
                        value3 = matchGroup.getValue();
                    }
                    str3 = value3;
                    i = setPivotYN16904 + 77;
                }
            } else {
                i = setPivotYN16904 + 23;
            }
            vD14832N6715 = i % 128;
            int i17 = i % 2;
            setpivotyn16904 = new vD14832N6715(component5(value, value2, str3));
        } catch (Throwable th) {
            setpivotyn16904 = new setPivotYN16904(th);
        }
        return bb.component9(setpivotyn16904);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00e0  */
    private final D8871<Long, Throwable> component5(String str, String str2, String str3) {
        setPivotYN16904 setpivotyn16904;
        long jLongValue;
        int i = 2 % 2;
        try {
            F16286 f16286 = this;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(I30900.ch.INSTANCE.component5(), Locale.US);
            try {
                setpivotyn16904 = new vD14832N6715(DesugarTimeZone.getTimeZone(I30900.cv.INSTANCE.component5()));
                int i2 = vD14832N6715;
                int i3 = (i2 & 55) + (i2 | 55);
                setPivotYN16904 = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = 2 / 4;
                }
            } catch (Throwable th) {
                setpivotyn16904 = new setPivotYN16904(th);
            }
            simpleDateFormat.getCalendar().setTimeZone((TimeZone) component9.component9(setpivotyn16904, DesugarTimeZone.getTimeZone(I30900.af.INSTANCE.component5())));
            Date date = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(date);
            long j = Long.parseLong(str2);
            if (str3 != null) {
                int i5 = vD14832N6715;
                int i6 = (i5 ^ 115) + ((i5 & 115) << 1);
                setPivotYN16904 = i6 % 128;
                if (i6 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                    throw null;
                }
                Long l = (Long) component9.vD14832N6715((D8871) D8871(aw.AnonymousClass4.setPivotYN16904(), aw.AnonymousClass4.setPivotYN16904(), new Object[]{this, str3}, -1171053733, aw.AnonymousClass4.setPivotYN16904(), 1171053734, aw.AnonymousClass4.setPivotYN16904()));
                if (l != null) {
                    int i7 = setPivotYN16904 + 105;
                    vD14832N6715 = i7 % 128;
                    int i8 = i7 % 2;
                    jLongValue = l.longValue();
                    int i9 = vD14832N6715;
                    int i10 = (i9 ^ 67) + ((i9 & 67) << 1);
                    setPivotYN16904 = i10 % 128;
                    int i11 = i10 % 2;
                } else {
                    int i12 = setPivotYN16904;
                    int i13 = ((i12 | 29) << 1) - (i12 ^ 29);
                    vD14832N6715 = i13 % 128;
                    int i14 = i13 % 2;
                    jLongValue = 0;
                }
            } else {
                int i15 = setPivotYN16904;
                int i16 = ((i15 | 29) << 1) - (i15 ^ 29);
                vD14832N6715 = i16 % 128;
                int i17 = i16 % 2;
                jLongValue = 0;
            }
            vD14832N6715 vd14832n6715 = new vD14832N6715(Long.valueOf((date.getTime() * 1000000) + j + jLongValue));
            int i18 = vD14832N6715;
            int i19 = (i18 ^ 25) + ((i18 & 25) << 1);
            setPivotYN16904 = i19 % 128;
            int i20 = i19 % 2;
            return vd14832n6715;
        } catch (Throwable th2) {
            return new setPivotYN16904(th2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00e1 A[Catch: all -> 0x016b, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x016b, blocks: (B:3:0x000d, B:7:0x001a, B:9:0x003a, B:11:0x0053, B:14:0x0062, B:18:0x0078, B:19:0x0081, B:20:0x0082, B:24:0x009b, B:39:0x00e1, B:50:0x0128, B:52:0x0134, B:53:0x0139, B:54:0x013a, B:55:0x0143, B:56:0x0144, B:57:0x014d, B:58:0x014e, B:59:0x0157, B:61:0x0161, B:62:0x016a), top: B:66:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:48:0x0111  */
    /* JADX WARN: Code duplicated, block: B:49:0x011b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0134 A[Catch: all -> 0x016b, TryCatch #0 {all -> 0x016b, blocks: (B:3:0x000d, B:7:0x001a, B:9:0x003a, B:11:0x0053, B:14:0x0062, B:18:0x0078, B:19:0x0081, B:20:0x0082, B:24:0x009b, B:39:0x00e1, B:50:0x0128, B:52:0x0134, B:53:0x0139, B:54:0x013a, B:55:0x0143, B:56:0x0144, B:57:0x014d, B:58:0x014e, B:59:0x0157, B:61:0x0161, B:62:0x016a), top: B:66:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:54:0x013a A[Catch: all -> 0x016b, TryCatch #0 {all -> 0x016b, blocks: (B:3:0x000d, B:7:0x001a, B:9:0x003a, B:11:0x0053, B:14:0x0062, B:18:0x0078, B:19:0x0081, B:20:0x0082, B:24:0x009b, B:39:0x00e1, B:50:0x0128, B:52:0x0134, B:53:0x0139, B:54:0x013a, B:55:0x0143, B:56:0x0144, B:57:0x014d, B:58:0x014e, B:59:0x0157, B:61:0x0161, B:62:0x016a), top: B:66:0x000d }] */
    private static /* synthetic */ Object vD14832N6715(Object[] objArr) {
        boolean z;
        char cCharAt;
        long j;
        int i;
        boolean z2 = false;
        F16286 f16286 = (F16286) objArr[0];
        String str = (String) objArr[1];
        int i2 = 2 % 2;
        try {
            if (str.length() != 5) {
                int i3 = setPivotYN16904 + 93;
                vD14832N6715 = i3 % 128;
                int i4 = i3 % 2;
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!CollectionsKt.listOf((Object[]) new Character[]{'-', '+'}).contains(Character.valueOf(str.charAt(0)))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String strSubstring = StringsKt.substring(str, new IntRange(1, 4));
            int i5 = setPivotYN16904;
            int i6 = (i5 & 71) + (i5 | 71);
            vD14832N6715 = i6 % 128;
            int i7 = i6 % 2;
            for (int i8 = 0; i8 < strSubstring.length(); i8++) {
                int i9 = vD14832N6715 + 105;
                setPivotYN16904 = i9 % 128;
                int i10 = i9 % 2;
                if (!Character.isDigit(strSubstring.charAt(i8))) {
                    int i11 = setPivotYN16904 + 97;
                    vD14832N6715 = i11 % 128;
                    int i12 = i11 % 2;
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            long j2 = Long.parseLong(StringsKt.substring(str, new IntRange(1, 2)));
            if (0 > j2 || j2 >= 24) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            long j3 = Long.parseLong(StringsKt.substring(str, new IntRange(3, 4)));
            if (0 > j3) {
                int i13 = vD14832N6715;
                int i14 = (i13 ^ 29) + ((i13 & 29) << 1);
                setPivotYN16904 = i14 % 128;
                int i15 = i14 % 2;
            } else {
                if (j3 < 60) {
                    int i16 = setPivotYN16904;
                    int i17 = (i16 & 87) + (i16 | 87);
                    vD14832N6715 = i17 % 128;
                    if (i17 % 2 != 0) {
                        z = true;
                    }
                    if (z) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    cCharAt = str.charAt(0);
                    if (cCharAt == '+') {
                        int i18 = vD14832N6715;
                        i = (i18 ^ 51) + ((i18 & 51) << 1);
                        setPivotYN16904 = i % 128;
                        if (i % 2 != 0) {
                        }
                        j = ((j2 * 60) + j3) * 60000000000L;
                        if (z2) {
                            int i19 = vD14832N6715 + 77;
                            setPivotYN16904 = i19 % 128;
                            int i20 = i19 % 2;
                        } else {
                            j = -j;
                            int i21 = vD14832N6715;
                            int i22 = (i21 & 91) + (i21 | 91);
                            setPivotYN16904 = i22 % 128;
                            int i23 = i22 % 2;
                        }
                        return new vD14832N6715(Long.valueOf(j));
                    }
                    if (cCharAt == '-') {
                        throw new Exception();
                    }
                    int i24 = setPivotYN16904;
                    int i25 = (i24 & 103) + (i24 | 103);
                    vD14832N6715 = i25 % 128;
                    int i26 = i25 % 2;
                    z2 = true;
                    j = ((j2 * 60) + j3) * 60000000000L;
                    if (z2) {
                        int i110 = vD14832N6715 + 77;
                        setPivotYN16904 = i110 % 128;
                        int i27 = i110 % 2;
                    } else {
                        j = -j;
                        int i28 = vD14832N6715;
                        int i29 = (i28 & 91) + (i28 | 91);
                        setPivotYN16904 = i29 % 128;
                        int i210 = i29 % 2;
                    }
                    return new vD14832N6715(Long.valueOf(j));
                }
                int i30 = setPivotYN16904 + 43;
                vD14832N6715 = i30 % 128;
                if (i30 % 2 == 0) {
                    int i31 = 3 % 5;
                }
            }
            z = false;
            if (z) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cCharAt = str.charAt(0);
            if (cCharAt == '+') {
                int i111 = vD14832N6715;
                i = (i111 ^ 51) + ((i111 & 51) << 1);
                setPivotYN16904 = i % 128;
                if (i % 2 != 0) {
                }
                j = ((j2 * 60) + j3) * 60000000000L;
                if (z2) {
                    int i112 = vD14832N6715 + 77;
                    setPivotYN16904 = i112 % 128;
                    int i211 = i112 % 2;
                } else {
                    j = -j;
                    int i212 = vD14832N6715;
                    int i213 = (i212 & 91) + (i212 | 91);
                    setPivotYN16904 = i213 % 128;
                    int i214 = i213 % 2;
                }
                return new vD14832N6715(Long.valueOf(j));
            }
            if (cCharAt == '-') {
                throw new Exception();
            }
            int i215 = setPivotYN16904;
            int i216 = (i215 & 103) + (i215 | 103);
            vD14832N6715 = i216 % 128;
            int i217 = i216 % 2;
            z2 = true;
            j = ((j2 * 60) + j3) * 60000000000L;
            if (z2) {
                int i113 = vD14832N6715 + 77;
                setPivotYN16904 = i113 % 128;
                int i218 = i113 % 2;
            } else {
                j = -j;
                int i219 = vD14832N6715;
                int i2110 = (i219 & 91) + (i219 | 91);
                setPivotYN16904 = i2110 % 128;
                int i2111 = i2110 % 2;
            }
            return new vD14832N6715(Long.valueOf(j));
        } catch (Throwable th) {
            return new setPivotYN16904(th);
        }
    }

    private D8871<Long, Throwable> component9(String str) {
        return (D8871) D8871(aw.AnonymousClass4.setPivotYN16904(), aw.AnonymousClass4.setPivotYN16904(), new Object[]{this, str}, -1171053733, aw.AnonymousClass4.setPivotYN16904(), 1171053734, aw.AnonymousClass4.setPivotYN16904());
    }

    public final D8871<FileTimestamps, Throwable> component5(String str) {
        return (D8871) D8871(aw.AnonymousClass4.setPivotYN16904(), aw.AnonymousClass4.setPivotYN16904(), new Object[]{this, str}, -318658251, aw.AnonymousClass4.setPivotYN16904(), 318658251, aw.AnonymousClass4.setPivotYN16904());
    }
}
