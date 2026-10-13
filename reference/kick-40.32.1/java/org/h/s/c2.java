package org.h.s;

import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes11.dex */
public abstract class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoroutineDispatcher f493a = Dispatchers.getDefault();
    public static boolean b;

    public static void a(Function0 initMethod) {
        Intrinsics.checkNotNullParameter(initMethod, "initMethod");
        b = true;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(f493a), null, null, new b2(initMethod, null), 3, null).start();
        } else {
            initMethod.invoke();
        }
    }
}
