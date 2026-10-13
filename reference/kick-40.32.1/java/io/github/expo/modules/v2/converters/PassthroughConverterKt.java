package io.github.expo.modules.v2.converters;

import androidx.exifinterface.media.ExifInterface;
import io.github.expo.modules.v2.types.CppType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062 \b\u0004\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"selectJsHandleConverter", "Lkotlin/Function1;", "", "Lio/github/expo/modules/v2/converters/TypeConverter;", ExifInterface.GPS_DIRECTION_TRUE, "kind", "Lio/github/expo/modules/v2/types/CppType;", "selector", "Lkotlin/Function2;", "selectJsHandleConverter-mxgigVc", "(ILkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function1;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PassthroughConverterKt {
    /* JADX INFO: renamed from: selectJsHandleConverter-mxgigVc, reason: not valid java name */
    public static final <T> Function1<Boolean, TypeConverter<T>> m12362selectJsHandleConvertermxgigVc(final int i, final Function2<? super CppType, ? super Boolean, ? extends TypeConverter<T>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return new Function1<Boolean, TypeConverter<T>>() { // from class: io.github.expo.modules.v2.converters.PassthroughConverterKt$selectJsHandleConverter$1
            public final TypeConverter<T> invoke(boolean z) {
                return selector.invoke(CppType.m12404boximpl(i), Boolean.valueOf(z));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }
        };
    }
}
