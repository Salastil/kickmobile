package com.datadog.android.core.sampling;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import java.security.SecureRandom;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RateBasedSampler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0018*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0018B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0013\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/datadog/android/core/sampling/RateBasedSampler;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/core/sampling/Sampler;", "sampleRate", "", "(F)V", "", "(D)V", "sampleRateProvider", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "random", "Ljava/security/SecureRandom;", "getRandom", "()Ljava/security/SecureRandom;", "random$delegate", "Lkotlin/Lazy;", "getSampleRate", "()Ljava/lang/Float;", "sample", "", "item", "(Ljava/lang/Object;)Z", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class RateBasedSampler<T> implements Sampler<T> {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float SAMPLE_ALL_RATE = 100.0f;

    /* JADX INFO: renamed from: random$delegate, reason: from kotlin metadata */
    private final Lazy random;
    private final Function0<Float> sampleRateProvider;

    public RateBasedSampler(Function0<Float> sampleRateProvider) {
        Intrinsics.checkNotNullParameter(sampleRateProvider, "sampleRateProvider");
        this.sampleRateProvider = sampleRateProvider;
        this.random = LazyKt.lazy(new Function0<SecureRandom>() { // from class: com.datadog.android.core.sampling.RateBasedSampler$random$2
            @Override // kotlin.jvm.functions.Function0
            public final SecureRandom invoke() {
                return new SecureRandom();
            }
        });
    }

    public RateBasedSampler(final float f) {
        this(new Function0<Float>() { // from class: com.datadog.android.core.sampling.RateBasedSampler.1
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

    public RateBasedSampler(double d) {
        this((float) d);
    }

    private final SecureRandom getRandom() {
        return (SecureRandom) this.random.getValue();
    }

    @Override // com.datadog.android.core.sampling.Sampler
    public boolean sample(T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        float fFloatValue = getSampleRate().floatValue();
        if (fFloatValue == 0.0f) {
            return false;
        }
        return fFloatValue == 100.0f || getRandom().nextFloat() * 100.0f <= fFloatValue;
    }

    @Override // com.datadog.android.core.sampling.Sampler
    public Float getSampleRate() {
        final float fFloatValue = this.sampleRateProvider.invoke().floatValue();
        float f = 0.0f;
        if (fFloatValue < 0.0f) {
            InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.sampling.RateBasedSampler.getSampleRate.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Sample rate value provided " + fFloatValue + " is below 0, setting it to 0.";
                }
            }, (Throwable) null, false, (Map) null, 56, (Object) null);
        } else {
            f = 100.0f;
            if (fFloatValue > 100.0f) {
                InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.sampling.RateBasedSampler.getSampleRate.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Sample rate value provided " + fFloatValue + " is above 100, setting it to 100.";
                    }
                }, (Throwable) null, false, (Map) null, 56, (Object) null);
            }
            return Float.valueOf(fFloatValue);
        }
        fFloatValue = f;
        return Float.valueOf(fFloatValue);
    }

    /* JADX INFO: compiled from: RateBasedSampler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/datadog/android/core/sampling/RateBasedSampler$Companion;", "", "()V", "SAMPLE_ALL_RATE", "", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
