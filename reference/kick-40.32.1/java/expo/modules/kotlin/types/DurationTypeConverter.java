package expo.modules.kotlin.types;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: DurationTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016¨\u0006\u0015"}, d2 = {"Lexpo/modules/kotlin/types/DurationTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Lkotlin/time/Duration;", "<init>", "()V", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "convertFromDynamic-ZBGTal8", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/types/ConverterContext;Z)J", "convertFromAny", "", "convertFromAny-ZBGTal8", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/ConverterContext;Z)J", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DurationTypeConverter extends DynamicAwareTypeConverters<Duration> {
    public static final int $stable = 0;

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    public boolean isTrivial() {
        return false;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public /* bridge */ /* synthetic */ Duration convertFromAny(Object obj, ConverterContext converterContext, boolean z) {
        return Duration.m14062boximpl(m11974convertFromAnyZBGTal8(obj, converterContext, z));
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public /* bridge */ /* synthetic */ Duration convertFromDynamic(Dynamic dynamic, ConverterContext converterContext, boolean z) {
        return Duration.m14062boximpl(m11975convertFromDynamicZBGTal8(dynamic, converterContext, z));
    }

    /* JADX INFO: renamed from: convertFromDynamic-ZBGTal8, reason: not valid java name */
    public long m11975convertFromDynamicZBGTal8(Dynamic value, ConverterContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        if (value.getType() != ReadableType.Number) {
            throw new IllegalArgumentException("Expected a number, but received " + value.getType());
        }
        return DurationKt.toDuration(value.asDouble(), DurationUnit.SECONDS);
    }

    /* JADX INFO: renamed from: convertFromAny-ZBGTal8, reason: not valid java name */
    public long m11974convertFromAnyZBGTal8(Object value, ConverterContext context, boolean forceConversion) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        return DurationKt.toDuration(((Double) value).doubleValue(), DurationUnit.SECONDS);
    }

    @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
    /* JADX INFO: renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.DOUBLE);
    }
}
