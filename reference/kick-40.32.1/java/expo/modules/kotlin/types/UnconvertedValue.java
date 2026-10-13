package expo.modules.kotlin.types;

import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import expo.modules.kotlin.exception.Exceptions;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Either.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00070\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/types/UnconvertedValue;", "Lexpo/modules/kotlin/types/DeferredValue;", "unconvertedValue", "", "typeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "<init>", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/TypeConverter;Lexpo/modules/kotlin/types/ConverterContext;)V", "contextHolder", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "convertedValue", "getConvertedValue", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class UnconvertedValue extends DeferredValue {
    public static final int $stable = 8;
    private final WeakReference<ConverterContext> contextHolder;
    private Object convertedValue;
    private final TypeConverter<?> typeConverter;
    private final Object unconvertedValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnconvertedValue(Object unconvertedValue, TypeConverter<?> typeConverter, ConverterContext context) {
        super(null);
        Intrinsics.checkNotNullParameter(unconvertedValue, "unconvertedValue");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(context, "context");
        this.unconvertedValue = unconvertedValue;
        this.typeConverter = typeConverter;
        this.contextHolder = new WeakReference<>(context);
    }

    public final Object getConvertedValue() throws Exceptions.ConverterContextLost {
        if (this.convertedValue == null) {
            ConverterContext converterContext = this.contextHolder.get();
            if (converterContext == null) {
                throw new Exceptions.ConverterContextLost();
            }
            this.convertedValue = this.typeConverter.convert(this.unconvertedValue, converterContext, true);
        }
        Object obj = this.convertedValue;
        Intrinsics.checkNotNull(obj);
        return obj;
    }
}
