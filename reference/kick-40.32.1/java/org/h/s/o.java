package org.h.s;

import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import io.mobileshield.sdk.logger.LocalLogger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f548a = new o();
    public static final MessageDigest b;
    public static long c;

    static {
        try {
            b = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            o oVar = f548a;
            String strValueOf = String.valueOf(e.getMessage());
            oVar.getClass();
            LocalLogger.log(16, 26000L, strValueOf);
        }
    }

    public static String a(long j, String str, double d, ArrayList arrayList) {
        byte[] bArrDigest;
        String strA;
        int i;
        MessageDigest messageDigest = b;
        Intrinsics.checkNotNull(messageDigest);
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = ("tp-v2-input, " + j + ", " + str).getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest2 = messageDigest.digest(bytes);
        String str2 = "";
        int i2 = 0;
        int i3 = 0;
        while (i3 < 2) {
            int i4 = 1;
            while (true) {
                MessageDigest messageDigest2 = b;
                Intrinsics.checkNotNull(messageDigest2);
                Intrinsics.checkNotNull(bArrDigest2);
                String str3 = i4 + ", " + a(bArrDigest2);
                Charset UTF_9 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_9, "UTF_8");
                byte[] bytes2 = str3.getBytes(UTF_9);
                Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
                bArrDigest = messageDigest2.digest(bytes2);
                Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
                strA = a(bArrDigest);
                c = 0L;
                Intrinsics.checkNotNullExpressionValue(UTF_9, "UTF_8");
                byte[] bytes3 = strA.getBytes(UTF_9);
                Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
                byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bytes3, i2, 13);
                int length = bArrCopyOfRange.length;
                int i5 = i2;
                while (i5 < length) {
                    c = (16 * c) + ((long) Character.digit(bArrCopyOfRange[i5], 16));
                    i5++;
                    i3 = i3;
                }
                i = i3;
                long j2 = c + 1;
                c = j2;
                if (4.503599627370496E15d / j2 >= d) {
                    break;
                }
                i4++;
                i3 = i;
                i2 = 0;
            }
            arrayList.add(Integer.valueOf(i4));
            i3 = i + 1;
            bArrDigest2 = bArrDigest;
            str2 = strA;
            i2 = 0;
        }
        return str2;
    }

    public static String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(240 & b2) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b2 & Ascii.SI];
        }
        return new String(cArr2);
    }
}
