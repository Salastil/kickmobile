package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0086\bø\u0001\u0000\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"selectConverter", "Lio/github/expo/modules/v2/converters/TypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "selector", "Lkotlin/Function0;", "isNullable", "", "Lkotlin/Function1;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TypeConverterKt {
    public static final <T> TypeConverter<T> selectConverter(Function0<? extends TypeConverter<T>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return selector.invoke();
    }

    public static final <T> TypeConverter<T> selectConverter(boolean z, Function1<? super Boolean, ? extends TypeConverter<T>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return selector.invoke(Boolean.valueOf(z));
    }
}
