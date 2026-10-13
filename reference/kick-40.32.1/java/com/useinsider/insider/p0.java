package com.useinsider.insider;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-98dd394663796e8b14f67757bb11d0a7eddfe51029f02e3b44a26a02cd1a9e7a */
/* JADX INFO: loaded from: classes9.dex */
abstract class p0 {
    static JSONObject a(String str, JSONObject jSONObject) {
        return a(str, jSONObject, false);
    }

    static JSONObject a(String str, JSONObject jSONObject, boolean z) {
        int i = z ? 2 : 0;
        try {
            String strEncodeToString = Base64.encodeToString(String.valueOf(jSONObject).getBytes("UTF-8"), i);
            char[] charArray = a(str).toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strEncodeToString.length(); i2++) {
                sb.append((char) (strEncodeToString.charAt(i2) ^ charArray[i2 % charArray.length]));
            }
            String strEncodeToString2 = Base64.encodeToString(String.valueOf(sb).getBytes("UTF-8"), i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("payload", strEncodeToString2);
            return jSONObject2;
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return jSONObject;
        }
    }

    static String a(String str, String str2) {
        return a(str, str2, true);
    }

    static String a(String str, String str2, boolean z) {
        int i = z ? 2 : 0;
        try {
            char[] charArray = a(str2).toCharArray();
            String str3 = new String(Base64.decode(str, i), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str3.length(); i2++) {
                sb.append((char) (str3.charAt(i2) ^ charArray[i2 % charArray.length]));
            }
            return new String(Base64.decode(sb.toString(), i), StandardCharsets.UTF_8);
        } catch (Exception e) {
            Insider.Instance.putException(e);
            return str;
        }
    }

    private static String a(String str) {
        long j = 0;
        for (int i = 0; i < str.length(); i++) {
            try {
                int iIntValue = Integer.valueOf(String.valueOf(str.charAt(i))).intValue() + 1;
                int i2 = i % 4;
                if (i2 == 0) {
                    j |= (long) (iIntValue * 77773);
                } else if (i2 == 1) {
                    j <<= iIntValue % 3;
                } else if (i2 == 2) {
                    j ^= (long) (iIntValue * 139831);
                } else if (i2 == 3) {
                    j >>= iIntValue % 3;
                }
            } catch (Exception e) {
                Insider.Instance.putException(e);
                return str;
            }
        }
        return String.valueOf(j);
    }
}
