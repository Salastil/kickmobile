package com.datadog.android.trace;

import com.datadog.android.core.sampling.DeterministicSampler;
import com.datadog.android.trace.api.span.DatadogSpan;
import com.datadog.android.trace.internal.net.SpanSamplingIdProvider;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeterministicTraceSampler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0013\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/datadog/android/trace/DeterministicTraceSampler;", "Lcom/datadog/android/core/sampling/DeterministicSampler;", "Lcom/datadog/android/trace/api/span/DatadogSpan;", "sampleRate", "", "(F)V", "", "(D)V", "sampleRateProvider", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "dd-sdk-android-trace_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class DeterministicTraceSampler extends DeterministicSampler<DatadogSpan> {

    /* JADX INFO: renamed from: com.datadog.android.trace.DeterministicTraceSampler$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeterministicTraceSampler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<DatadogSpan, ULong> {
        AnonymousClass1(Object obj) {
            super(1, obj, SpanSamplingIdProvider.class, "provideId", "provideId-I7RO_PI(Lcom/datadog/android/trace/api/span/DatadogSpan;)J", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ULong invoke(DatadogSpan datadogSpan) {
            return ULong.m12861boximpl(m11155invokeI7RO_PI(datadogSpan));
        }

        /* JADX INFO: renamed from: invoke-I7RO_PI, reason: not valid java name */
        public final long m11155invokeI7RO_PI(DatadogSpan p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((SpanSamplingIdProvider) this.receiver).m11156provideIdI7RO_PI(p0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeterministicTraceSampler(Function0<Float> sampleRateProvider) {
        super(new AnonymousClass1(SpanSamplingIdProvider.INSTANCE), sampleRateProvider);
        Intrinsics.checkNotNullParameter(sampleRateProvider, "sampleRateProvider");
    }

    public DeterministicTraceSampler(final float f) {
        this(new Function0<Float>() { // from class: com.datadog.android.trace.DeterministicTraceSampler.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(f);
            }
        });
    }

    public DeterministicTraceSampler(double d) {
        this((float) d);
    }
}
