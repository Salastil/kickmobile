package org.koin.mp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: KoinPlatformTools.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¨\u0006\u0005"}, d2 = {"getKClassDefaultName", "", "Lorg/koin/mp/KoinPlatformTools;", "kClass", "Lkotlin/reflect/KClass;", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KoinPlatformToolsKt {
    public static final String getKClassDefaultName(KoinPlatformTools koinPlatformTools, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(koinPlatformTools, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return "KClass@" + kClass.hashCode();
    }
}
