package io.github.expo.modules.v2.args;

import io.github.expo.modules.v2.converters.TypeConverter;
import io.github.expo.modules.v2.types.TypeDescriptor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Bridge.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lio/github/expo/modules/v2/args/Bridge;", "", "<init>", "()V", "fromJni", "value", "type", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "toJni", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Bridge {
    public static final Bridge INSTANCE = new Bridge();

    private Bridge() {
    }

    @JvmStatic
    public static final Object fromJni(Object value, TypeDescriptor type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TypeConverter<?> converter = type.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        return converter.fromJni(value);
    }

    @JvmStatic
    public static final Object toJni(Object value, TypeDescriptor type) {
        Intrinsics.checkNotNullParameter(type, "type");
        TypeConverter<?> converter = type.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        return converter.toJni(value);
    }
}
