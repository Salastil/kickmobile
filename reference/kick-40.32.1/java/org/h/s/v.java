package org.h.s;

import android.util.Base64;
import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public abstract class v {
    public static String a(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String input = new Gson().toJson(data);
        Intrinsics.checkNotNullExpressionValue(input, "toJson(...)");
        Intrinsics.checkNotNullParameter(input, "input");
        String strEncodeToString = Base64.encodeToString(b(input, "6831442c-526a-4cb3-b1f7-d92c925f15eb"), 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public static byte[] b(String str, String str2) {
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str2.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bytes2 = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        ArrayList arrayList = new ArrayList(bytes2.length);
        int length = bytes2.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            arrayList.add(Byte.valueOf((byte) (bytes[i2 % bytes.length] ^ bytes2[i])));
            i++;
            i2++;
        }
        return CollectionsKt.toByteArray(arrayList);
    }

    public static String a(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        char[] charArray = input.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        ArrayList arrayList = new ArrayList(charArray.length);
        for (char c : charArray) {
            int i = c ^ '\t';
            if (i >= 0 && i <= 65535) {
                arrayList.add(Character.valueOf((char) i));
            } else {
                throw new IllegalArgumentException("Invalid Char code: " + i);
            }
        }
        return new String(CollectionsKt.toCharArray(arrayList));
    }

    public static String a(String str, String str2) {
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = str.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArrDecode = Base64.decode(bytes, 8);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            Charset charset = Charsets.UTF_8;
            String str3 = new String(bArrDecode, charset);
            int length = str3.length() < 36 ? str3.length() : 36;
            if (str2.length() < length) {
                return null;
            }
            return new String(b(str3, StringsKt.substring(str2, new IntRange(0, length))), charset);
        } catch (Exception unused) {
            return null;
        }
    }
}
