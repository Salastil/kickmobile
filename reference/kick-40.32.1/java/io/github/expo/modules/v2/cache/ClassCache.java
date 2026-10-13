package io.github.expo.modules.v2.cache;

import com.datadog.trace.api.DDSpanTypes;
import io.github.expo.modules.v2.converters.TypeConverter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassCache.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007J \u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\f\u001a\u00020\rJ0\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0012J$\u0010\b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00052\u0006\u0010\f\u001a\u00020\rH\u0002R\"\u0010\u0004\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lio/github/expo/modules/v2/cache/ClassCache;", "", "<init>", "()V", "nullableCache", "Lio/github/expo/modules/v2/cache/Cache;", "Ljava/lang/Class;", "Lio/github/expo/modules/v2/converters/TypeConverter;", DDSpanTypes.CACHE, "put", "", "clazz", "isNullable", "", "value", "get", "getOrPut", "defaultValue", "Lkotlin/Function0;", "ClassCacheBuilder", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClassCache {
    private final Cache<Class<?>, TypeConverter<?>> nullableCache = new Cache<>();
    private final Cache<Class<?>, TypeConverter<?>> cache = new Cache<>();

    public final void put(Class<?> clazz, boolean isNullable, TypeConverter<?> value) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(value, "value");
        cache(isNullable).put(clazz, value);
    }

    public final TypeConverter<?> get(Class<?> clazz, boolean isNullable) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return cache(isNullable).get(clazz);
    }

    public final TypeConverter<?> getOrPut(Class<?> clazz, boolean isNullable, Function0<? extends TypeConverter<?>> defaultValue) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return cache(isNullable).getOrPut(clazz, defaultValue);
    }

    private final Cache<Class<?>, TypeConverter<?>> cache(boolean isNullable) {
        if (isNullable) {
            return this.nullableCache;
        }
        return this.cache;
    }

    /* JADX INFO: compiled from: ClassCache.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ*\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rJ*\u0010\t\u001a\u00020\u00062\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u0010J\r\u0010\u0012\u001a\u00020\u0013*\u00020\u0006H\u0086\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/github/expo/modules/v2/cache/ClassCache$ClassCacheBuilder;", "", "<init>", "()V", "entries", "", "Lio/github/expo/modules/v2/cache/ClassCache$ClassCacheBuilder$Entry;", "build", "Lio/github/expo/modules/v2/cache/ClassCache;", "entry", "type", "Ljava/lang/Class;", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "nullableConverter", "converterFactory", "Lkotlin/Function1;", "", "unaryPlus", "", "Entry", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ClassCacheBuilder {
        private final List<Entry> entries = new ArrayList();

        public final ClassCache build() {
            ClassCache classCache = new ClassCache();
            for (Entry entry : this.entries) {
                classCache.put(entry.getType$react_release(), false, entry.getConverter$react_release());
                classCache.put(entry.getType$react_release(), true, entry.getNullableConverter$react_release());
            }
            return classCache;
        }

        public final Entry entry(Class<?> type, TypeConverter<?> converter, TypeConverter<?> nullableConverter) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(converter, "converter");
            Intrinsics.checkNotNullParameter(nullableConverter, "nullableConverter");
            return new Entry(type, converter, nullableConverter);
        }

        public final Entry entry(Class<?> type, Function1<? super Boolean, ? extends TypeConverter<?>> converterFactory) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(converterFactory, "converterFactory");
            return new Entry(type, converterFactory.invoke(false), converterFactory.invoke(true));
        }

        public final void unaryPlus(Entry entry) {
            Intrinsics.checkNotNullParameter(entry, "<this>");
            this.entries.add(entry);
        }

        /* JADX INFO: compiled from: ClassCache.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\b\u0000\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lio/github/expo/modules/v2/cache/ClassCache$ClassCacheBuilder$Entry;", "", "type", "Ljava/lang/Class;", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "nullableConverter", "<init>", "(Ljava/lang/Class;Lio/github/expo/modules/v2/converters/TypeConverter;Lio/github/expo/modules/v2/converters/TypeConverter;)V", "getType$react_release", "()Ljava/lang/Class;", "getConverter$react_release", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "getNullableConverter$react_release", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Entry {
            private final TypeConverter<?> converter;
            private final TypeConverter<?> nullableConverter;
            private final Class<?> type;

            public Entry(Class<?> type, TypeConverter<?> converter, TypeConverter<?> nullableConverter) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(converter, "converter");
                Intrinsics.checkNotNullParameter(nullableConverter, "nullableConverter");
                this.type = type;
                this.converter = converter;
                this.nullableConverter = nullableConverter;
            }

            public final Class<?> getType$react_release() {
                return this.type;
            }

            public final TypeConverter<?> getConverter$react_release() {
                return this.converter;
            }

            public final TypeConverter<?> getNullableConverter$react_release() {
                return this.nullableConverter;
            }
        }
    }
}
