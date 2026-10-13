package org.h.s;

import android.content.Context;
import io.mobileshield.sdk.config.Config;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f510a = "01";
    public static Config b;
    public static Long c;
    public static final CoroutineDispatcher d = Dispatchers.getIO();

    public static String a() {
        return f510a;
    }

    public static void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f510a = str;
    }

    public static Object a(Context context, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(m0.f538a, new l0(context, null), continuation);
        if (objWithContext != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            objWithContext = Unit.INSTANCE;
        }
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public static void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(d), null, null, new f0(context, null), 3, null);
    }
}
