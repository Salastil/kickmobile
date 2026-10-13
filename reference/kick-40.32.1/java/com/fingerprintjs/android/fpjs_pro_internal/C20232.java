package com.fingerprintjs.android.fpjs_pro_internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.autofill.HintConstants;
import com.facebook.common.callercontext.ContextChain;
import com.fingerprintjs.android.fpjs_pro.ConfidenceScore;
import com.fingerprintjs.android.fpjs_pro.Error;
import com.fingerprintjs.android.fpjs_pro.FingerprintJSProResponse;
import com.fingerprintjs.android.fpjs_pro.IpLocation;
import com.fingerprintjs.android.fpjs_pro.ResponseCannotBeParsed;
import com.fingerprintjs.android.fpjs_pro.Timestamp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.useinsider.insiderhybrid.constants.InsiderHybridMethods;
import io.datazoom.sdk.domain.usecases.GetDeviceInfoUseCaseKt;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0016J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0017J\u0011\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\r\u0010\u0018R\u0014\u0010\u0011\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001d"}, d2 = {"Lcom/fingerprintjs/android/fpjs_pro_internal/C20232;", "Lcom/fingerprintjs/android/fpjs_pro_internal/bs;", "Lcom/fingerprintjs/android/fpjs_pro/FingerprintJSProResponse;", "", "p0", "", "p1", "Lcom/fingerprintjs/android/fpjs_pro_internal/Y16199;", "p2", "<init>", "([BZLcom/fingerprintjs/android/fpjs_pro_internal/Y16199;)V", "Lorg/json/JSONObject;", "Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;", "component5", "(Lorg/json/JSONObject;)Lcom/fingerprintjs/android/fpjs_pro/ConfidenceScore;", "", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "vD14832N6715", "(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/fingerprintjs/android/fpjs_pro/Error;", "Lcom/fingerprintjs/android/fpjs_pro/IpLocation;", "component9", "(Lorg/json/JSONObject;)Lcom/fingerprintjs/android/fpjs_pro/IpLocation;", "(Ljava/lang/String;Lorg/json/JSONObject;)Lcom/fingerprintjs/android/fpjs_pro/FingerprintJSProResponse;", "()Lcom/fingerprintjs/android/fpjs_pro/Error;", "()Lcom/fingerprintjs/android/fpjs_pro/FingerprintJSProResponse;", "Lcom/fingerprintjs/android/fpjs_pro_internal/Y16199;", "D8871", "Z", "Lcom/fingerprintjs/android/fpjs_pro/Error;", "Lcom/fingerprintjs/android/fpjs_pro/FingerprintJSProResponse;", "setPivotYN16904"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class C20232 extends bs<FingerprintJSProResponse> {
    private static final byte[] $$a = null;
    private static final int $$b = 0;
    private static int $10;
    private static int $11;
    private static int N14263A23323;
    private static int component8;
    private static int sG29839;
    private static long setPivotYN16904;
    private static char setTopP6481;
    private final boolean D8871;

    /* JADX INFO: renamed from: component5, reason: from kotlin metadata */
    private final Y16199 vD14832N6715;
    private Error component9;

    /* JADX INFO: renamed from: vD14832N6715, reason: from kotlin metadata */
    private FingerprintJSProResponse setPivotYN16904;

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    /* JADX WARN: Code duplicated, block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:10:0x0021
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private static java.lang.String $$c(short r6, byte r7, int r8) {
        /*
            int r6 = r6 + 4
            int r8 = r8 * 2
            int r0 = r8 + 1
            byte[] r1 = com.fingerprintjs.android.fpjs_pro_internal.C20232.$$a
            int r7 = 103 - r7
            byte[] r0 = new byte[r0]
            r2 = 0
            if (r1 != 0) goto L13
            r7 = r6
            r4 = r8
            r3 = r2
            goto L28
        L13:
            r3 = r2
        L14:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r0[r3] = r4
            if (r3 != r8) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r0, r2)
            return r6
        L21:
            int r3 = r3 + 1
            r4 = r1[r6]
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r6 = r6 + r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fingerprintjs.android.fpjs_pro_internal.C20232.$$c(short, byte, int):java.lang.String");
    }

    static void init$0() {
        $$a = new byte[]{58, 104, 54, 119};
        $$b = 14;
    }

    public /* synthetic */ C20232(byte[] bArr, boolean z, component10 component10Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, z, (i & 4) != 0 ? new component10() : component10Var);
    }

    private C20232(byte[] bArr, boolean z, Y16199 y16199) {
        String strOptString;
        super(bArr);
        this.D8871 = z;
        this.vD14832N6715 = y16199;
        try {
            JSONObject jSONObject = new JSONObject(bArr != null ? new String(bArr, Charsets.UTF_8) : "{}");
            strOptString = jSONObject.optString((String) iA15411.component9(ap.component9(), 175334150, -175334147, ap.component9(), ap.component9(), ap.component9(), new Object[0]));
            try {
                if (jSONObject.has((String) iA15411.component9(ap.component9(), 254175322, -254175317, ap.component9(), ap.component9(), ap.component9(), new Object[0]))) {
                    this.component9 = vD14832N6715(strOptString, jSONObject);
                } else {
                    this.setPivotYN16904 = component9(strOptString, jSONObject);
                }
            } catch (Exception unused) {
                this.setPivotYN16904 = null;
                this.component9 = new ResponseCannotBeParsed(strOptString, null, 2, null);
            }
        } catch (Exception unused2) {
            strOptString = "";
        }
    }

    public final Error vD14832N6715() {
        int i = 2 % 2;
        int i2 = N14263A23323 + 39;
        sG29839 = i2 % 128;
        int i3 = i2 % 2;
        Error error = this.component9;
        if (i3 != 0) {
            int i4 = 25 / 0;
        }
        return error;
    }

    public final FingerprintJSProResponse component5() {
        int i = 2 % 2;
        int i2 = N14263A23323 + 37;
        sG29839 = i2 % 128;
        int i3 = i2 % 2;
        FingerprintJSProResponse fingerprintJSProResponse = this.setPivotYN16904;
        if (i3 == 0) {
            return fingerprintJSProResponse;
        }
        throw null;
    }

    private final FingerprintJSProResponse component9(String p0, JSONObject p1) throws JSONException {
        String str;
        String strOptString;
        String strVD14832N6715 = ap.vD14832N6715(p1, "sealedResult");
        JSONObject jSONObject = p1.getJSONObject(InsiderHybridMethods.PRODUCTS).getJSONObject("identification").getJSONObject("data").getJSONObject("result");
        String string = jSONObject.getString("visitorId");
        Intrinsics.checkNotNull(jSONObject);
        ConfidenceScore confidenceScoreComponent5 = component5(jSONObject);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("firstSeenAt");
        IpLocation ipLocationComponent9 = null;
        String strOptString2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("global") : null;
        String strOptString3 = "n\\a";
        if (strOptString2 == null) {
            strOptString2 = "n\\a";
        }
        String strOptString4 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(FirebaseAnalytics.Param.SUBSCRIPTION) : null;
        if (strOptString4 == null) {
            strOptString4 = "n\\a";
        }
        Timestamp timestamp = new Timestamp(strOptString2, strOptString4);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("lastSeenAt");
        String strOptString5 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("global") : null;
        if (strOptString5 == null) {
            strOptString5 = "n\\a";
        }
        String strOptString6 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString(FirebaseAnalytics.Param.SUBSCRIPTION) : null;
        if (strOptString6 == null) {
            strOptString6 = "n\\a";
        }
        Timestamp timestamp2 = new Timestamp(strOptString5, strOptString6);
        boolean zOptBoolean = jSONObject.optBoolean("visitorFound", false);
        if (this.D8871) {
            strOptString3 = jSONObject.optString("ip", "n\\a");
            ipLocationComponent9 = component9(jSONObject);
            String strOptString7 = jSONObject.optString("os", GetDeviceInfoUseCaseKt.PLATFORM);
            String str2 = Build.VERSION.CODENAME;
            if (str2 == null) {
                str2 = "";
            }
            str = strOptString7;
            strOptString = jSONObject.optString("osVersion", str2);
        } else {
            str = "n\\a";
            strOptString = str;
        }
        Intrinsics.checkNotNull(string);
        return new FingerprintJSProResponse(p0, string, confidenceScoreComponent5, zOptBoolean, strOptString3, ipLocationComponent9, str, strOptString, timestamp, timestamp2, strVD14832N6715, jSONObject.toString(), null, 4096, null);
    }

    private final Error vD14832N6715(String p0, JSONObject p1) {
        int i = 2 % 2;
        int i2 = sG29839 + 95;
        N14263A23323 = i2 % 128;
        if (i2 % 2 != 0) {
            int iComponent9 = ap.component9();
            int iComponent10 = ap.component9();
            String strOptString = p1.getJSONObject((String) iA15411.component9(ap.component9(), 254175322, -254175317, iComponent9, iComponent10, ap.component9(), new Object[0])).optString(iA15411.rP23717());
            int iComponent11 = ap.component9();
            int iComponent12 = ap.component9();
            String strVD14832N6715 = ap.vD14832N6715(p1.getJSONObject((String) iA15411.component9(ap.component9(), 254175322, -254175317, iComponent11, iComponent12, ap.component9(), new Object[0])), iA15411.kC4266());
            Y16199 y16199 = this.vD14832N6715;
            Intrinsics.checkNotNull(strOptString);
            return y16199.component5(strOptString, strVD14832N6715, p0);
        }
        int iComponent13 = ap.component9();
        int iComponent14 = ap.component9();
        String strOptString2 = p1.getJSONObject((String) iA15411.component9(ap.component9(), 254175322, -254175317, iComponent13, iComponent14, ap.component9(), new Object[0])).optString(iA15411.rP23717());
        int iComponent15 = ap.component9();
        int iComponent16 = ap.component9();
        String strVD14832N6716 = ap.vD14832N6715(p1.getJSONObject((String) iA15411.component9(ap.component9(), 254175322, -254175317, iComponent15, iComponent16, ap.component9(), new Object[0])), iA15411.kC4266());
        Y16199 y161910 = this.vD14832N6715;
        Intrinsics.checkNotNull(strOptString2);
        y161910.component5(strOptString2, strVD14832N6716, p0);
        Object obj = null;
        obj.hashCode();
        throw null;
    }

    private static ConfidenceScore component5(JSONObject p0) {
        JSONObject jSONObjectOptJSONObject = p0.optJSONObject("confidence");
        return new ConfidenceScore(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optDouble(FirebaseAnalytics.Param.SCORE, 0.0d) : 0.0d);
    }

    private static IpLocation component9(JSONObject p0) {
        JSONObject jSONObjectOptJSONObject = p0.optJSONObject("ipLocation");
        int i = 0;
        int iOptInt = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optInt("accuracyRadius", 0) : 0;
        double dOptDouble = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optDouble("latitude", 0.0d) : 0.0d;
        double dOptDouble2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optDouble("longitude", 0.0d) : 0.0d;
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(HintConstants.AUTOFILL_HINT_POSTAL_CODE, "n\\a") : null;
        if (strOptString == null) {
            strOptString = "n\\a";
        }
        String strOptString2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("timezone", "n\\a") : null;
        if (strOptString2 == null) {
            strOptString2 = "n\\a";
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("city") : null;
        String strOptString3 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("name", "n\\a") : null;
        if (strOptString3 == null) {
            strOptString3 = "n\\a";
        }
        IpLocation.City city = new IpLocation.City(strOptString3);
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("country") : null;
        String strOptString4 = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optString("code", "n\\a") : null;
        String str = strOptString4 == null ? "n\\a" : strOptString4;
        String strOptString5 = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optString("name", "n\\a") : null;
        if (strOptString5 == null) {
            strOptString5 = "n\\a";
        }
        IpLocation.Country country = new IpLocation.Country(str, strOptString5);
        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("continent") : null;
        String strOptString6 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString("code", "n\\a") : null;
        if (strOptString6 == null) {
            strOptString6 = "n\\a";
        }
        String strOptString7 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString("name", "n\\a") : null;
        if (strOptString7 == null) {
            strOptString7 = "n\\a";
        }
        IpLocation.Continent continent = new IpLocation.Continent(strOptString6, strOptString7);
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONArray("subdivisions") : null;
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray(new JSONObject[0]);
        }
        LinkedList linkedList = new LinkedList();
        int length = jSONArrayOptJSONArray.length();
        while (i < length) {
            double d = dOptDouble;
            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i);
            Intrinsics.checkNotNull(jSONObjectOptJSONObject5);
            String strOptString8 = jSONObjectOptJSONObject5.optString("isoCode", "n\\a");
            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray.optJSONObject(i);
            Intrinsics.checkNotNull(jSONObjectOptJSONObject6);
            linkedList.add(new IpLocation.Subdivisions(strOptString8, jSONObjectOptJSONObject6.optString("name", "n\\a")));
            i++;
            iOptInt = iOptInt;
            dOptDouble = d;
        }
        return new IpLocation(iOptInt, dOptDouble, dOptDouble2, strOptString, strOptString2, city, country, continent, linkedList);
    }

    private static void a(int i, String str, char c, String str2, String str3, Object[] objArr) throws Throwable {
        char[] charArray;
        char[] charArray2;
        int i2 = 2 % 2;
        int i3 = $10 + 93;
        $11 = i3 % 128;
        if (i3 % 2 == 0) {
            throw null;
        }
        char[] charArray3 = str3 != null ? str3.toCharArray() : str3;
        byte b = 0;
        if (str2 != null) {
            int i4 = $11 + 85;
            $10 = i4 % 128;
            if (i4 % 2 != 0) {
                charArray = str2.toCharArray();
                int i5 = 46 / 0;
            } else {
                charArray = str2.toCharArray();
            }
        } else {
            charArray = str2;
        }
        char[] cArr = charArray;
        if (str != null) {
            int i6 = $10 + 65;
            $11 = i6 % 128;
            if (i6 % 2 == 0) {
                str.toCharArray();
                throw null;
            }
            charArray2 = str.toCharArray();
        } else {
            charArray2 = str;
        }
        char[] cArr2 = charArray2;
        cn cnVar = new cn();
        int length = charArray3.length;
        char[] cArr3 = new char[length];
        int length2 = cArr2.length;
        char[] cArr4 = new char[length2];
        System.arraycopy(charArray3, 0, cArr3, 0, length);
        System.arraycopy(cArr2, 0, cArr4, 0, length2);
        cArr3[0] = (char) (cArr3[0] ^ c);
        cArr4[2] = (char) (cArr4[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr5 = new char[length3];
        cnVar.setPivotYN16904 = 0;
        while (cnVar.setPivotYN16904 < length3) {
            int i7 = $10 + 13;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            try {
                Object[] objArr2 = {cnVar};
                Object objComponent5 = setSystemGestureExclusionRectsL30479.component5(528238139);
                if (objComponent5 == null) {
                    objComponent5 = setSystemGestureExclusionRectsL30479.vD14832N6715(86 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (55624 - TextUtils.getTrimmedLength("")), (ViewConfiguration.getScrollBarSize() >> 8) + 423, 1305018968, false, "c", new Class[]{Object.class});
                }
                int iIntValue = ((Integer) ((Method) objComponent5).invoke(null, objArr2)).intValue();
                Object[] objArr3 = {cnVar};
                Object objComponent6 = setSystemGestureExclusionRectsL30479.component5(-1013236775);
                if (objComponent6 == null) {
                    objComponent6 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.lastIndexOf("", '0'), (char) (55223 - (ViewConfiguration.getTapTimeout() >> 16)), ((byte) KeyEvent.getModifierMetaStateMask()) + 3270, -1859223622, false, $$c((short) -1, b, b), new Class[]{Object.class});
                }
                int iIntValue2 = ((Integer) ((Method) objComponent6).invoke(null, objArr3)).intValue();
                int i9 = cArr3[cnVar.setPivotYN16904 % 4] * 32718;
                Object[] objArr4 = new Object[3];
                objArr4[2] = Integer.valueOf(cArr4[iIntValue]);
                objArr4[1] = Integer.valueOf(i9);
                objArr4[b] = cnVar;
                Object objComponent7 = setSystemGestureExclusionRectsL30479.component5(-523427508);
                if (objComponent7 == null) {
                    objComponent7 = setSystemGestureExclusionRectsL30479.vD14832N6715((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 52, (char) (42043 - TextUtils.getCapsMode("", b, b)), Color.rgb((int) b, (int) b, (int) b) + 16779524, -1300732625, false, ContextChain.TAG_INFRA, new Class[]{Object.class, Integer.TYPE, Integer.TYPE});
                }
                ((Method) objComponent7).invoke(null, objArr4);
                int i10 = cArr3[iIntValue2] * 32718;
                Object[] objArr5 = new Object[2];
                objArr5[r14] = Integer.valueOf(cArr4[iIntValue]);
                objArr5[b] = Integer.valueOf(i10);
                Object objComponent8 = setSystemGestureExclusionRectsL30479.component5(1175171274);
                if (objComponent8 == null) {
                    byte b2 = b;
                    objComponent8 = setSystemGestureExclusionRectsL30479.vD14832N6715(51 - TextUtils.indexOf((CharSequence) "", '0', (int) b2, (int) b2), (char) (KeyEvent.normalizeMetaState(b2) + 58885), (Process.myTid() >> 22) + 6886, 348058793, false, $$c((short) -1, (byte) 1, b2), new Class[]{Integer.TYPE, Integer.TYPE});
                }
                cArr4[iIntValue2] = ((Character) ((Method) objComponent8).invoke(null, objArr5)).charValue();
                cArr3[iIntValue2] = cnVar.D8871;
                cArr5[cnVar.setPivotYN16904] = (char) (((((long) (cArr[cnVar.setPivotYN16904] ^ cArr3[iIntValue2])) ^ (setPivotYN16904 ^ (-8233799196330309486L))) ^ ((long) ((int) (((long) component8) ^ (-8233799196330309486L))))) ^ ((long) ((char) (((long) setTopP6481) ^ (-8233799196330309486L)))));
                cnVar.setPivotYN16904++;
                b = 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        objArr[0] = new String(cArr5);
    }

    public static void component9(long j, long j2) throws Throwable {
        long j3;
        int i = 2 % 2;
        int i2 = N14263A23323 + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY;
        sG29839 = i2 % 128;
        if (i2 % 2 != 0) {
            j3 = j % (j2 >> 73);
            u.class.getField("vD14832N6715").get(null);
        } else {
            j3 = j ^ (j2 << 32);
            u.class.getField("vD14832N6715").get(null);
        }
        int i3 = sG29839 + 43;
        N14263A23323 = i3 % 128;
        int i4 = i3 % 2;
        try {
            Object[] objArr = {Long.valueOf(j3)};
            Object[] objArr2 = new Object[1];
            a(ImageFormat.getBitsPerPixel(0) + 949725889, "\u0000\u0000\u0000\u0000", (char) ('0' - AndroidCharacter.getMirror('0')), "প괁鈩箓䃧痬鬋", "쁿鮪ﴸ\ue0b0", objArr2);
            Method method = Long.class.getMethod((String) objArr2[0], Long.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, objArr);
            Object obj = w.class.getField("INSTANCE").get(null);
            Method method2 = w.class.getMethod("D8871", null);
            method2.setAccessible(true);
            Object objInvoke2 = method2.invoke(obj, null);
            Object[] objArr3 = new Object[1];
            a(1092432839 - View.MeasureSpec.getSize(0), "\u0000\u0000\u0000\u0000", (char) (14390 - AndroidCharacter.getMirror('0')), "ꠂ칲㈁", "읟ᴳف똸", objArr3);
            Object[] objArr4 = {(String) objArr3[0], objInvoke};
            Object[] objArr5 = new Object[1];
            a(1743804051 - KeyEvent.normalizeMetaState(0), "\u0000\u0000\u0000\u0000", (char) (Color.alpha(0) + 36177), "饁屏⩇", "鎙\uf056內䆍", objArr5);
            Method method3 = Map.class.getMethod((String) objArr5[0], Object.class, Object.class);
            method3.setAccessible(true);
            method3.invoke(objInvoke2, objArr4);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    static {
        init$0();
        $10 = 0;
        $11 = 1;
        sG29839 = 0;
        N14263A23323 = 1;
        setPivotYN16904 = -8233799196330309486L;
        component8 = 1725286546;
        setTopP6481 = (char) 13122;
    }
}
