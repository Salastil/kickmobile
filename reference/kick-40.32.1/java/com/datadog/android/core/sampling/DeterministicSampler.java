package com.datadog.android.core.sampling;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.api.InternalLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeterministicSampler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0015*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0015B%\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB%\b\u0016\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/datadog/android/core/sampling/DeterministicSampler;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lcom/datadog/android/core/sampling/Sampler;", "idConverter", "Lkotlin/Function1;", "Lkotlin/ULong;", "sampleRate", "", "(Lkotlin/jvm/functions/Function1;F)V", "", "(Lkotlin/jvm/functions/Function1;D)V", "sampleRateProvider", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getSampleRate", "()Ljava/lang/Float;", "sample", "", "item", "(Ljava/lang/Object;)Z", "Companion", "dd-sdk-android-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class DeterministicSampler<T> implements Sampler<T> {
    public static final long MAX_ID = -1;
    public static final long SAMPLER_HASHER = 1111111111111111111L;
    public static final float SAMPLE_ALL_RATE = 100.0f;
    private final Function1<T, ULong> idConverter;
    private final Function0<Float> sampleRateProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public DeterministicSampler(Function1<? super T, ULong> idConverter, Function0<Float> sampleRateProvider) {
        Intrinsics.checkNotNullParameter(idConverter, "idConverter");
        Intrinsics.checkNotNullParameter(sampleRateProvider, "sampleRateProvider");
        this.idConverter = idConverter;
        this.sampleRateProvider = sampleRateProvider;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeterministicSampler(Function1<? super T, ULong> idConverter, final float f) {
        this(idConverter, new Function0<Float>() { // from class: com.datadog.android.core.sampling.DeterministicSampler.1
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
        Intrinsics.checkNotNullParameter(idConverter, "idConverter");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeterministicSampler(Function1<? super T, ULong> idConverter, double d) {
        this((Function1) idConverter, (float) d);
        Intrinsics.checkNotNullParameter(idConverter, "idConverter");
    }

    @Override // com.datadog.android.core.sampling.Sampler
    public boolean sample(T item) {
        Intrinsics.checkNotNullParameter(item, "item");
        float fFloatValue = getSampleRate().floatValue();
        if (fFloatValue >= 100.0f) {
            return true;
        }
        return fFloatValue > 0.0f && Long.compare(ULong.m12867constructorimpl(this.idConverter.invoke(item).getData() * SAMPLER_HASHER) ^ Long.MIN_VALUE, UnsignedKt.doubleToULong((UnsignedKt.ulongToDouble(-1L) * ((double) fFloatValue)) / 100.0d) ^ Long.MIN_VALUE) < 0;
    }

    @Override // com.datadog.android.core.sampling.Sampler
    public Float getSampleRate() {
        final float fFloatValue = this.sampleRateProvider.invoke().floatValue();
        float f = 0.0f;
        if (fFloatValue < 0.0f) {
            InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.sampling.DeterministicSampler.getSampleRate.1
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
                InternalLogger.DefaultImpls.log$default(InternalLogger.INSTANCE.getUNBOUND(), InternalLogger.Level.WARN, InternalLogger.Target.USER, (Function0) new Function0<String>() { // from class: com.datadog.android.core.sampling.DeterministicSampler.getSampleRate.2
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
}
