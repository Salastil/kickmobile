package org.h.s;

import android.content.Context;
import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import io.ktor.sse.ServerSentEventKt;
import io.mobileshield.sdk.logger.LocalLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.GZIPInputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineDispatcher f529a = Dispatchers.getIO();

    public static String a(byte[] gzipBytes) {
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(gzipBytes, "gzipBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Result.Companion companion = Result.INSTANCE;
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(gzipBytes));
            ByteStreamsKt.copyTo$default(gZIPInputStream, byteArrayOutputStream, 0, 2, null);
            gZIPInputStream.close();
            objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            LocalLogger.log(4, 12003L, thM12687exceptionOrNullimpl.getMessage());
        }
        String string = byteArrayOutputStream.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static String a(String encodedString) {
        String str;
        Object objM12684constructorimpl;
        Intrinsics.checkNotNullParameter(encodedString, "encodedString");
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bArrDecode = Base64.decode(encodedString, 0);
            Intrinsics.checkNotNull(bArrDecode);
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            str = new String(bArrDecode, charsetForName);
            try {
                objM12684constructorimpl = Result.m12684constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                th = th;
                Result.Companion companion2 = Result.INSTANCE;
                objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
            }
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        Throwable thM12687exceptionOrNullimpl = Result.m12687exceptionOrNullimpl(objM12684constructorimpl);
        if (thM12687exceptionOrNullimpl != null) {
            LocalLogger.log(4, 12003L, thM12687exceptionOrNullimpl.getMessage());
        }
        return str;
    }

    public static Object a(String str, Context context, Continuation continuation) {
        String str2;
        LinkedHashMap linkedHashMap;
        Boolean bool;
        List<f3> remoteConfig;
        List<b0> featureFlags;
        try {
            d0 d0Var = (d0) new Gson().fromJson(str, d0.class);
            LinkedHashMap linkedHashMap2 = null;
            if (d0Var == null || (featureFlags = d0Var.getFeatureFlags()) == null) {
                linkedHashMap = null;
            } else {
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(featureFlags, 10)), 16));
                for (b0 b0Var : featureFlags) {
                    Pair pair = TuplesKt.to(b0Var != null ? b0Var.getName() : null, b0Var != null ? Boxing.boxBoolean(b0Var.getValue()) : null);
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
            }
            if (d0Var != null && (remoteConfig = d0Var.getRemoteConfig()) != null) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(remoteConfig, 10)), 16));
                for (f3 f3Var : remoteConfig) {
                    Pair pair2 = TuplesKt.to(f3Var != null ? f3Var.getName() : null, f3Var != null ? f3Var.getValue() : null);
                    linkedHashMap3.put(pair2.getFirst(), pair2.getSecond());
                }
                linkedHashMap2 = linkedHashMap3;
            }
            if (linkedHashMap != null) {
                for (a0 a0Var : a0.values()) {
                    if (a0Var.b && (bool = (Boolean) linkedHashMap.get(a0Var.f486a)) != null) {
                        a0Var.c = bool.booleanValue();
                    }
                }
            }
            if (linkedHashMap2 != null) {
                a(linkedHashMap2);
            }
            LocalLogger.log(16, 12002L, a0.d + "\n" + e3.b);
            if (d0Var == null) {
                g0.a("01e");
            }
        } catch (Exception e) {
            Intrinsics.checkNotNullParameter(e, "e");
            String str3 = g0.f510a;
            if (e instanceof JsonSyntaxException) {
                str2 = "01s";
            } else {
                str2 = e instanceof JsonIOException ? "01p" : "01o";
            }
            Intrinsics.checkNotNullParameter(str2, "<set-?>");
            g0.f510a = str2;
            s3 s3Var = f1.f506a;
            f1.a(w0.m0, g0.a() + ServerSentEventKt.SPACE + e.getMessage());
        }
        Object objA = g0.a(context, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    public static void a(LinkedHashMap linkedHashMap) {
        w2 w2Var = e3.b;
        for (x2 x2Var : w2.a()) {
            Object obj = linkedHashMap.get(x2Var.e);
            if (obj != null) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Double");
                x2Var.f = (int) ((Double) obj).doubleValue();
            }
        }
        w2 w2Var2 = e3.b;
        for (d3 d3Var : w2.b()) {
            Object obj2 = linkedHashMap.get(d3Var.e);
            if (obj2 != null) {
                String string = obj2.toString();
                Intrinsics.checkNotNullParameter(string, "<set-?>");
                d3Var.f = string;
            }
        }
    }
}
