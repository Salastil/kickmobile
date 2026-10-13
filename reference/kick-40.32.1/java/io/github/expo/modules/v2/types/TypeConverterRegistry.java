package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.SharedObject;
import io.github.expo.modules.v2.SharedRef;
import io.github.expo.modules.v2.TypedArray;
import io.github.expo.modules.v2.cache.ClassCache;
import io.github.expo.modules.v2.converters.ArrayConverter;
import io.github.expo.modules.v2.converters.EnumConverter;
import io.github.expo.modules.v2.converters.JsHandleConverter;
import io.github.expo.modules.v2.converters.ListConverter;
import io.github.expo.modules.v2.converters.MapConverter;
import io.github.expo.modules.v2.converters.RecordConverter;
import io.github.expo.modules.v2.converters.SetConverter;
import io.github.expo.modules.v2.converters.SharedObjectConverter;
import io.github.expo.modules.v2.converters.SharedRefConverter;
import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.jsi.JavaScriptObject;
import io.github.expo.modules.v2.jsi.JavaScriptValue;
import io.github.expo.modules.v2.records.RecordRegistry;
import io.github.expo.modules.v2.records.RecordType;
import io.github.expo.modules.v2.sharedobjects.SharedObjectRegistry;
import io.ktor.util.NioPathKt$$ExternalSyntheticApiModelOutline0;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: compiled from: TypeConverterRegistry.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/github/expo/modules/v2/types/TypeConverterRegistry;", "", "<init>", "()V", "simpleConvertersCache", "Lio/github/expo/modules/v2/cache/ClassCache;", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "typeDescriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor$Simple;", "Lio/github/expo/modules/v2/types/TypeDescriptor$Parametrized;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TypeConverterRegistry {
    public static final TypeConverterRegistry INSTANCE = new TypeConverterRegistry();
    private static final ClassCache simpleConvertersCache;

    private TypeConverterRegistry() {
    }

    public final TypeConverter<?> converter(TypeDescriptor.Simple typeDescriptor) {
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        final Class<?> clsComponent1 = typeDescriptor.component1();
        final boolean isNullable = typeDescriptor.getIsNullable();
        return simpleConvertersCache.getOrPut(clsComponent1, isNullable, new Function0() { // from class: io.github.expo.modules.v2.types.TypeConverterRegistry$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TypeConverterRegistry.converter$lambda$2(clsComponent1, isNullable);
            }
        });
    }

    static final TypeConverter converter$lambda$2(Class cls, boolean z) {
        if (SharedObject.class.isAssignableFrom(cls)) {
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<out io.github.expo.modules.v2.SharedObject>");
            return new SharedObjectConverter(SharedObjectRegistry.INSTANCE.m12401classIdFortOptiM$react_release(cls), cls, z, null);
        }
        if (cls.isEnum()) {
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
            return new EnumConverter(cls, z);
        }
        RecordType<?> recordTypeTypeFor$react_release = RecordRegistry.INSTANCE.typeFor$react_release((Class<?>) cls);
        if (recordTypeTypeFor$react_release != null) {
            return new RecordConverter(recordTypeTypeFor$react_release, z);
        }
        throw new IllegalArgumentException(cls.getName() + " has no bridge type - describe it with a leaf class, a List/Map, a registered RecordCodec, or register a TypeConverter for it with TypeConverterRegistry.register");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TypeConverter<?> converter(TypeDescriptor.Parametrized typeDescriptor) {
        Class<?> javaClass;
        Intrinsics.checkNotNullParameter(typeDescriptor, "typeDescriptor");
        Class<?> clsComponent1 = typeDescriptor.component1();
        if (SharedRef.class.isAssignableFrom(clsComponent1)) {
            Intrinsics.checkNotNull(clsComponent1, "null cannot be cast to non-null type java.lang.Class<out io.github.expo.modules.v2.SharedObject>");
            Object objSingleOrNull = ArraysKt.singleOrNull(typeDescriptor.getParams());
            DefaultConstructorMarker defaultConstructorMarker = null;
            TypeDescriptor.Simple simple = objSingleOrNull instanceof TypeDescriptor.Simple ? (TypeDescriptor.Simple) objSingleOrNull : null;
            if (simple == null || (javaClass = simple.getJavaClass()) == null) {
                throw new IllegalArgumentException("A SharedRef parameter must name the type it carries, as SharedRef<Something>");
            }
            return new SharedRefConverter(SharedObjectRegistry.INSTANCE.m12401classIdFortOptiM$react_release(clsComponent1), javaClass, typeDescriptor.isNullable(), defaultConstructorMarker);
        }
        if (List.class.isAssignableFrom(clsComponent1)) {
            return new ListConverter(typeDescriptor);
        }
        if (Map.class.isAssignableFrom(clsComponent1)) {
            return new MapConverter(typeDescriptor);
        }
        if (Set.class.isAssignableFrom(clsComponent1)) {
            return new SetConverter(typeDescriptor);
        }
        if (Object[].class.isAssignableFrom(clsComponent1)) {
            return new ArrayConverter(typeDescriptor);
        }
        throw new IllegalArgumentException(clsComponent1.getName() + " has no bridge type — describe it with a leaf class, a List/Map, a registered RecordCodec, or register a TypeConverter for it with TypeConverterRegistry.register");
    }

    static {
        ClassCache.ClassCacheBuilder classCacheBuilder = new ClassCache.ClassCacheBuilder();
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Boolean.class, TypeConverterRegistry$simpleConvertersCache$1$1.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Integer.class, TypeConverterRegistry$simpleConvertersCache$1$2.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Long.class, TypeConverterRegistry$simpleConvertersCache$1$3.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Float.class, TypeConverterRegistry$simpleConvertersCache$1$4.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Double.class, TypeConverterRegistry$simpleConvertersCache$1$5.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(String.class, TypeConverterRegistry$simpleConvertersCache$1$6.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Unit.class, TypeConverterRegistry$simpleConvertersCache$1$7.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Object.class, TypeConverterRegistry$simpleConvertersCache$1$8.INSTANCE));
        final int iM12436getJS_VALUEz4oZPQ = CppType.INSTANCE.m12436getJS_VALUEz4oZPQ();
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(JavaScriptValue.class, new Function1<Boolean, TypeConverter<Object>>() { // from class: io.github.expo.modules.v2.types.TypeConverterRegistry$simpleConvertersCache$lambda$1$$inlined$selectJsHandleConverter-mxgigVc$1
            public final TypeConverter<Object> invoke(boolean z) {
                return new JsHandleConverter(iM12436getJS_VALUEz4oZPQ, z, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TypeConverter<Object> invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }));
        final int iM12435getJS_OBJECTz4oZPQ = CppType.INSTANCE.m12435getJS_OBJECTz4oZPQ();
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(JavaScriptObject.class, new Function1<Boolean, TypeConverter<Object>>() { // from class: io.github.expo.modules.v2.types.TypeConverterRegistry$simpleConvertersCache$lambda$1$$inlined$selectJsHandleConverter-mxgigVc$2
            public final TypeConverter<Object> invoke(boolean z) {
                return new JsHandleConverter(iM12435getJS_OBJECTz4oZPQ, z, null);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TypeConverter<Object> invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        }));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(TypedArray.class, TypeConverterRegistry$simpleConvertersCache$1$11.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(Duration.class, TypeConverterRegistry$simpleConvertersCache$1$12.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(File.class, TypeConverterRegistry$simpleConvertersCache$1$13.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(URL.class, TypeConverterRegistry$simpleConvertersCache$1$14.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(URI.class, TypeConverterRegistry$simpleConvertersCache$1$15.INSTANCE));
        classCacheBuilder.unaryPlus(classCacheBuilder.entry(NioPathKt$$ExternalSyntheticApiModelOutline0.m12594m(), TypeConverterRegistry$simpleConvertersCache$1$16.INSTANCE));
        simpleConvertersCache = classCacheBuilder.build();
    }
}
