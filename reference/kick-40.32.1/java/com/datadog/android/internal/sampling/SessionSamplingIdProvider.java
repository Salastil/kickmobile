package com.datadog.android.internal.sampling;

import com.datadog.android.rum.internal.domain.scope.RumSessionScope;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;

/* JADX INFO: compiled from: SessionSamplingIdProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"Lcom/datadog/android/internal/sampling/SessionSamplingIdProvider;", "", "()V", "provideId", "Lkotlin/ULong;", RumSessionScope.RUM_SESSION_ID_BUS_MESSAGE_KEY, "", "provideId-I7RO_PI", "(Ljava/lang/String;)J", "dd-sdk-android-internal_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SessionSamplingIdProvider {
    public static final SessionSamplingIdProvider INSTANCE = new SessionSamplingIdProvider();

    private SessionSamplingIdProvider() {
    }

    /* JADX INFO: renamed from: provideId-I7RO_PI, reason: not valid java name */
    public final long m11151provideIdI7RO_PI(String sessionId) {
        ULong uLongOrNull;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        String str = (String) CollectionsKt.lastOrNull(StringsKt.split$default((CharSequence) sessionId, new char[]{'-'}, false, 0, 6, (Object) null));
        if (str == null || (uLongOrNull = UStringsKt.toULongOrNull(str, 16)) == null) {
            return 0L;
        }
        return uLongOrNull.getData();
    }
}
