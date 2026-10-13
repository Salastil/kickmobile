package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a<\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0006\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"createTrivialTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "cppRequireType", "Lexpo/modules/kotlin/jni/ExpectedType;", "dynamicFallback", "Lkotlin/Function1;", "Lcom/facebook/react/bridge/Dynamic;", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class TypeConverterKt {
    public static /* synthetic */ TypeConverter createTrivialTypeConverter$default(ExpectedType cppRequireType, Function1 dynamicFallback, int i, Object obj) {
        if ((i & 2) != 0) {
            Intrinsics.needClassReification();
            dynamicFallback = AnonymousClass1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(cppRequireType, "cppRequireType");
        Intrinsics.checkNotNullParameter(dynamicFallback, "dynamicFallback");
        Intrinsics.needClassReification();
        return new AnonymousClass2(dynamicFallback, cppRequireType);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: expo.modules.kotlin.types.TypeConverterKt$createTrivialTypeConverter$2, reason: invalid class name */
    /* JADX INFO: compiled from: TypeConverter.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J%\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"expo/modules/kotlin/types/TypeConverterKt$createTrivialTypeConverter$2", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "convertFromDynamic", "value", "Lcom/facebook/react/bridge/Dynamic;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Lcom/facebook/react/bridge/Dynamic;Lexpo/modules/kotlin/types/ConverterContext;Z)Ljava/lang/Object;", "convertFromAny", "", "(Ljava/lang/Object;Lexpo/modules/kotlin/types/ConverterContext;Z)Ljava/lang/Object;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = WebmConstants.MkvEbmlElement.PIXEL_WIDTH)
    public static final class AnonymousClass2<T> extends DynamicAwareTypeConverters<T> {
        final /* synthetic */ ExpectedType $cppRequireType;
        final /* synthetic */ Function1<Dynamic, T> $dynamicFallback;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super Dynamic, ? extends T> function1, ExpectedType expectedType) {
            this.$dynamicFallback = function1;
            this.$cppRequireType = expectedType;
        }

        @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
        public T convertFromDynamic(Dynamic value, ConverterContext context, boolean forceConversion) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(context, "context");
            return this.$dynamicFallback.invoke(value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
        public T convertFromAny(Object value, ConverterContext context, boolean forceConversion) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return value;
        }

        @Override // expo.modules.kotlin.types.NonNullableTypeConverter, expo.modules.kotlin.types.TypeConverter
        /* JADX INFO: renamed from: getCppRequiredTypes, reason: from getter */
        public ExpectedType get$cppRequireType() {
            return this.$cppRequireType;
        }
    }

    public static final /* synthetic */ <T> TypeConverter<T> createTrivialTypeConverter(ExpectedType cppRequireType, Function1<? super Dynamic, ? extends T> dynamicFallback) {
        Intrinsics.checkNotNullParameter(cppRequireType, "cppRequireType");
        Intrinsics.checkNotNullParameter(dynamicFallback, "dynamicFallback");
        Intrinsics.needClassReification();
        return new AnonymousClass2(dynamicFallback, cppRequireType);
    }
}
