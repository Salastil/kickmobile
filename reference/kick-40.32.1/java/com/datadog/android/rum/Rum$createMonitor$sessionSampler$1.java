package com.datadog.android.rum;

import com.datadog.android.internal.sampling.SessionSamplingIdProvider;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Rum.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class Rum$createMonitor$sessionSampler$1 extends FunctionReferenceImpl implements Function1<String, ULong> {
    Rum$createMonitor$sessionSampler$1(Object obj) {
        super(1, obj, SessionSamplingIdProvider.class, "provideId", "provideId-I7RO_PI(Ljava/lang/String;)J", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ULong invoke(String str) {
        return ULong.m12861boximpl(m11152invokeI7RO_PI(str));
    }

    /* JADX INFO: renamed from: invoke-I7RO_PI, reason: not valid java name */
    public final long m11152invokeI7RO_PI(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((SessionSamplingIdProvider) this.receiver).m11151provideIdI7RO_PI(p0);
    }
}
