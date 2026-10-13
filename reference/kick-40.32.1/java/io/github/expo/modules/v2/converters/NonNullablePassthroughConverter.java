package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lio/github/expo/modules/v2/converters/NonNullablePassthroughConverter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lio/github/expo/modules/v2/converters/PassthroughConverter;", "kind", "Lio/github/expo/modules/v2/types/CppType;", "<init>", "(I)V", "Lio/github/expo/modules/v2/converters/BooleanConverter;", "Lio/github/expo/modules/v2/converters/DoubleConverter;", "Lio/github/expo/modules/v2/converters/FloatConverter;", "Lio/github/expo/modules/v2/converters/IntConverter;", "Lio/github/expo/modules/v2/converters/LongConverter;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class NonNullablePassthroughConverter<T> extends PassthroughConverter<T> {
    public /* synthetic */ NonNullablePassthroughConverter(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private NonNullablePassthroughConverter(int i) {
        super(i, false, null);
    }
}
