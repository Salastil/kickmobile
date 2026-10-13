package org.koin.mp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;

/* JADX INFO: compiled from: KoinPlatformTools.jvm.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"generateId", "", "Lorg/koin/mp/KoinPlatformTools;", "koin-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class KoinPlatformTools_jvmKt {
    public static final String generateId(KoinPlatformTools koinPlatformTools) {
        Intrinsics.checkNotNullParameter(koinPlatformTools, "<this>");
        return Uuid.INSTANCE.random().toString();
    }
}
