package org.h.s;

import androidx.camera.camera2.pipe.compat.Camera2DeviceCloserImpl;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes11.dex */
public final class w0 {
    public static final w0 A;
    public static final w0 B;
    public static final w0 C;
    public static final w0 D;
    public static final w0 E;
    public static final w0 F;
    public static final w0 G;
    public static final w0 H;
    public static final w0 I;
    public static final w0 J;
    public static final w0 K;
    public static final w0 L;
    public static final w0 M;
    public static final w0 N;
    public static final w0 O;
    public static final w0 P;
    public static final w0 Q;
    public static final w0 R;
    public static final w0 S;
    public static final w0 T;
    public static final w0 U;
    public static final w0 V;
    public static final w0 W;
    public static final w0 X;
    public static final w0 Y;
    public static final w0 Z;
    public static final w0 a0;
    public static final w0 b0;
    public static final w0 c;
    public static final w0 c0;
    public static final w0 d;
    public static final w0 d0;
    public static final w0 e;
    public static final w0 e0;
    public static final w0 f;
    public static final w0 f0;
    public static final w0 g;
    public static final w0 g0;
    public static final w0 h;
    public static final w0 h0;
    public static final w0 i;
    public static final w0 i0;
    public static final w0 j;
    public static final w0 j0;
    public static final w0 k;
    public static final w0 k0;
    public static final w0 l;
    public static final w0 l0;
    public static final w0 m;
    public static final w0 m0;
    public static final w0 n;
    public static final /* synthetic */ w0[] n0;
    public static final w0 o;
    public static final w0 p;
    public static final w0 q;
    public static final w0 r;
    public static final w0 s;
    public static final w0 t;
    public static final w0 u;
    public static final w0 v;
    public static final w0 w;
    public static final w0 x;
    public static final w0 y;
    public static final w0 z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f584a;
    public final x0 b;

    static {
        x0 x0Var = x0.VERBOSE;
        w0 w0Var = new w0("GenericLog", 0, 100L, x0Var);
        c = w0Var;
        x0 x0Var2 = x0.ERROR;
        w0 w0Var2 = new w0("ExceptionUnexpected", 1, 0L, x0Var2);
        d = w0Var2;
        w0 w0Var3 = new w0("ExceptionMSGetInstance", 2, 1L, x0Var2);
        e = w0Var3;
        w0 w0Var4 = new w0("ExceptionMSInit", 3, 2L, x0Var2);
        f = w0Var4;
        w0 w0Var5 = new w0("ExceptionMSUpdate", 4, 3L, x0Var2);
        g = w0Var5;
        w0 w0Var6 = new w0("ExceptionMSProtect", 5, 4L, x0Var2);
        h = w0Var6;
        w0 w0Var7 = new w0("ExceptionMSParseResponse", 6, 5L, x0Var2);
        w0 w0Var8 = new w0("ExceptionMSCheckResponse", 7, 6L, x0Var2);
        i = w0Var8;
        w0 w0Var9 = new w0("ExceptionMSGetHeaders", 8, 7L, x0Var2);
        j = w0Var9;
        w0 w0Var10 = new w0("ExceptionMSMergeHeaders", 9, 8L, x0Var2);
        k = w0Var10;
        w0 w0Var11 = new w0("ExceptionMSIsReady", 10, 9L, x0Var2);
        l = w0Var11;
        w0 w0Var12 = new w0("ExceptionMSIsReadyAll", 11, 10L, x0Var2);
        m = w0Var12;
        w0 w0Var13 = new w0("ExceptionMSLogger", 12, 11L, x0Var2);
        n = w0Var13;
        w0 w0Var14 = new w0("ExceptionMSObtainInterceptor", 13, 12L, x0Var2);
        o = w0Var14;
        w0 w0Var15 = new w0("ExceptionMSDispose", 14, 13L, x0Var2);
        p = w0Var15;
        x0 x0Var3 = x0.INFO;
        w0 w0Var16 = new w0("MSInit", 15, 1001L, x0Var3);
        q = w0Var16;
        w0 w0Var17 = new w0("MSUpdate", 16, 1002L, x0Var3);
        r = w0Var17;
        w0 w0Var18 = new w0("MSProtect", 17, 1003L, x0Var3);
        s = w0Var18;
        w0 w0Var19 = new w0("MSParseResponse", 18, 1004L, x0Var3);
        t = w0Var19;
        w0 w0Var20 = new w0("MSCheckResponse", 19, 1005L, x0Var3);
        u = w0Var20;
        w0 w0Var21 = new w0("MSGetHeaders", 20, 1006L, x0Var3);
        v = w0Var21;
        w0 w0Var22 = new w0("MSMergeHeaders", 21, 1007L, x0Var3);
        w = w0Var22;
        w0 w0Var23 = new w0("MSIsReady", 22, 1008L, x0Var3);
        x = w0Var23;
        w0 w0Var24 = new w0("MSIsReadyAll", 23, 1009L, x0Var3);
        y = w0Var24;
        w0 w0Var25 = new w0("MSLogger", 24, 1010L, x0Var3);
        z = w0Var25;
        w0 w0Var26 = new w0("MSObtainInterceptor", 25, 1011L, x0Var3);
        w0 w0Var27 = new w0("MSConfigurationInvalid", 26, 1012L, x0Var2);
        w0 w0Var28 = new w0("InitialisationBegin", 27, 2000L, x0Var3);
        A = w0Var28;
        w0 w0Var29 = new w0("InitialisationException", 28, 2001L, x0Var2);
        B = w0Var29;
        w0 w0Var30 = new w0("InterrogationBegin", 29, 3000L, x0Var3);
        C = w0Var30;
        w0 w0Var31 = new w0("InterrogationTokenGetStored", 30, 3001L, x0Var3);
        D = w0Var31;
        w0 w0Var32 = new w0("InterrogationTokenReceived", 31, 3002L, x0Var3);
        E = w0Var32;
        x0 x0Var4 = x0.WARNING;
        w0 w0Var33 = new w0("InterrogationTokenNotReceived", 32, 3003L, x0Var4);
        F = w0Var33;
        w0 w0Var34 = new w0("InterrogationRetriggered", 33, 3004L, x0Var3);
        G = w0Var34;
        w0 w0Var35 = new w0("StateChange", 34, 4000L, x0Var3);
        H = w0Var35;
        w0 w0Var36 = new w0("WebviewLoadUrl", 35, 5000L, x0Var3);
        I = w0Var36;
        w0 w0Var37 = new w0("WebviewReturnedToken", 36, 5001L, x0Var3);
        J = w0Var37;
        w0 w0Var38 = new w0("WebviewReturnedFailure", 37, 5002L, x0Var4);
        K = w0Var38;
        w0 w0Var39 = new w0("WebviewErrorHttp", 38, 5003L, x0Var4);
        L = w0Var39;
        w0 w0Var40 = new w0("WebviewError", 39, 5004L, x0Var4);
        M = w0Var40;
        w0 w0Var41 = new w0("WebviewDeinitError", 40, 5005L, x0Var2);
        w0 w0Var42 = new w0("WebviewInjectJs", 41, 5006L, x0Var);
        N = w0Var42;
        w0 w0Var43 = new w0("WebviewPageStarted", 42, 5007L, x0Var);
        O = w0Var43;
        w0 w0Var44 = new w0("WebviewPageFinished", 43, 5008L, x0Var);
        P = w0Var44;
        w0 w0Var45 = new w0("WebviewLoadResource", 44, 5009L, x0Var);
        Q = w0Var45;
        w0 w0Var46 = new w0("WebviewInitialisationException", 45, 5010L, x0Var4);
        R = w0Var46;
        w0 w0Var47 = new w0("WebviewSetUpException", 46, 5011L, x0Var4);
        S = w0Var47;
        w0 w0Var48 = new w0("ProtectSuccess", 47, Camera2DeviceCloserImpl.CAMERA_CLOSE_TIMEOUT_MS, x0Var3);
        T = w0Var48;
        w0 w0Var49 = new w0("ProtectFailure", 48, 7001L, x0Var3);
        U = w0Var49;
        w0 w0Var50 = new w0("ProtectOkhttpDecorate", 49, 7100L, x0Var3);
        V = w0Var50;
        w0 w0Var51 = new w0("ProtectOkhttpPassThrough", 50, 7101L, x0Var3);
        W = w0Var51;
        w0 w0Var52 = new w0("ProtectOkhttpNotReadyException", 51, 7102L, x0Var2);
        X = w0Var52;
        w0 w0Var53 = new w0("ProtectOkhttpParseResponse", 52, 7103L, x0Var3);
        Y = w0Var53;
        w0 w0Var54 = new w0("ProtectOkhttpException", 53, 7104L, x0Var2);
        Z = w0Var54;
        w0 w0Var55 = new w0("ProtectOkhttpWait", 54, 7105L, x0Var);
        a0 = w0Var55;
        w0 w0Var56 = new w0("HeadersSuccess", 55, 8000L, x0Var3);
        b0 = w0Var56;
        w0 w0Var57 = new w0("HeadersFailure", 56, 8001L, x0Var4);
        c0 = w0Var57;
        w0 w0Var58 = new w0("NetworkTPPost", 57, 9000L, x0Var3);
        d0 = w0Var58;
        w0 w0Var59 = new w0("NetworkTPGet", 58, 9001L, x0Var3);
        e0 = w0Var59;
        w0 w0Var60 = new w0("NetworkTPFailure", 59, 9002L, x0Var4);
        f0 = w0Var60;
        w0 w0Var61 = new w0("NetworkCheck", 60, 9100L, x0Var);
        g0 = w0Var61;
        w0 w0Var62 = new w0("NetworkCheckStatus", 61, 9101L, x0Var3);
        h0 = w0Var62;
        w0 w0Var63 = new w0("NetworkCheckBeginMonitoring", 62, 9102L, x0Var);
        i0 = w0Var63;
        w0 w0Var64 = new w0("NetworkCheckStopMonitoring", 63, 9103L, x0Var);
        j0 = w0Var64;
        w0 w0Var65 = new w0("EventBackgrounded", 64, 10000L, x0Var);
        k0 = w0Var65;
        w0 w0Var66 = new w0("FeatureFlagParse", 65, 12000L, x0Var);
        l0 = w0Var66;
        w0 w0Var67 = new w0("FeatureFlagError", 66, 12001L, x0Var4);
        m0 = w0Var67;
        w0[] w0VarArr = {w0Var, w0Var2, w0Var3, w0Var4, w0Var5, w0Var6, w0Var7, w0Var8, w0Var9, w0Var10, w0Var11, w0Var12, w0Var13, w0Var14, w0Var15, w0Var16, w0Var17, w0Var18, w0Var19, w0Var20, w0Var21, w0Var22, w0Var23, w0Var24, w0Var25, w0Var26, w0Var27, w0Var28, w0Var29, w0Var30, w0Var31, w0Var32, w0Var33, w0Var34, w0Var35, w0Var36, w0Var37, w0Var38, w0Var39, w0Var40, w0Var41, w0Var42, w0Var43, w0Var44, w0Var45, w0Var46, w0Var47, w0Var48, w0Var49, w0Var50, w0Var51, w0Var52, w0Var53, w0Var54, w0Var55, w0Var56, w0Var57, w0Var58, w0Var59, w0Var60, w0Var61, w0Var62, w0Var63, w0Var64, w0Var65, w0Var66, w0Var67};
        n0 = w0VarArr;
        EnumEntriesKt.enumEntries(w0VarArr);
    }

    public w0(String str, int i2, long j2, x0 x0Var) {
        super(str, i2);
        this.f584a = j2;
        this.b = x0Var;
    }

    public static w0 valueOf(String str) {
        return (w0) Enum.valueOf(w0.class, str);
    }

    public static w0[] values() {
        return (w0[]) n0.clone();
    }
}
