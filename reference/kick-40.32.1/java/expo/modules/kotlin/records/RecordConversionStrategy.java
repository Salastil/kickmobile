package expo.modules.kotlin.records;

import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.allocators.ObjectConstructor;
import expo.modules.kotlin.allocators.ObjectConstructorFactory;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.ConverterContext;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.types.descriptors.TypeDescriptor;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: RecordTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0011\"\b\b\u0001\u0010\u0001*\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0013H\u0004J%\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&¢\u0006\u0002\u0010\u001bJ3\u0010\u001c\u001a\u00028\u00002\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&¢\u0006\u0002\u0010 R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lexpo/modules/kotlin/records/RecordConversionStrategy;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/records/Record;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "typeDescriptor", "Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "<init>", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;)V", "getConverterProvider", "()Lexpo/modules/kotlin/types/TypeConverterProvider;", "getTypeDescriptor", "()Lexpo/modules/kotlin/types/descriptors/TypeDescriptor;", "objectConstructorFactory", "Lexpo/modules/kotlin/allocators/ObjectConstructorFactory;", "getObjectConstructor", "Lexpo/modules/kotlin/allocators/ObjectConstructor;", "clazz", "Lkotlin/reflect/KClass;", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Lexpo/modules/kotlin/types/ConverterContext;", "forceConversion", "", "(Lcom/facebook/react/bridge/ReadableMap;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "convertFromMap", "map", "", "", "(Ljava/util/Map;Lexpo/modules/kotlin/types/ConverterContext;Z)Lexpo/modules/kotlin/records/Record;", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class RecordConversionStrategy<T extends Record> {
    public static final int $stable = 8;
    private final TypeConverterProvider converterProvider;
    private final ObjectConstructorFactory objectConstructorFactory;
    private final TypeDescriptor typeDescriptor;

    public abstract T convertFromMap(Map<String, ? extends Object> map, ConverterContext context, boolean forceConversion);

    public abstract T convertFromReadableMap(ReadableMap jsMap, ConverterContext context, boolean forceConversion);

    public RecordConversionStrategy(TypeConverterProvider converterProvider, TypeDescriptor typeDescriptor) {
        Intrinsics.checkNotNullParameter(converterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        this.converterProvider = converterProvider;
        this.typeDescriptor = typeDescriptor;
        this.objectConstructorFactory = new ObjectConstructorFactory();
    }

    protected final TypeConverterProvider getConverterProvider() {
        return this.converterProvider;
    }

    protected final TypeDescriptor getTypeDescriptor() {
        return this.typeDescriptor;
    }

    protected final <T> ObjectConstructor<T> getObjectConstructor(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return this.objectConstructorFactory.get(clazz);
    }
}
