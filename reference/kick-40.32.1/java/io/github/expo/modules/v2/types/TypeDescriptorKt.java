package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.TypeConverter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TypeDescriptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005\"\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00048Æ\u0002¢\u0006\f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"nullableSuffix", "", "isNullable", "", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Z", "anyConverter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "", "getAnyConverter$annotations", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)V", "getAnyConverter", "(Lio/github/expo/modules/v2/types/TypeDescriptor;)Lio/github/expo/modules/v2/converters/TypeConverter;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TypeDescriptorKt {
    public static /* synthetic */ void getAnyConverter$annotations(TypeDescriptor typeDescriptor) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String nullableSuffix(String str, boolean z) {
        return str + (z ? "?" : "");
    }

    public static final boolean isNullable(TypeDescriptor typeDescriptor) {
        Intrinsics.checkNotNullParameter(typeDescriptor, "<this>");
        if (typeDescriptor instanceof TypeDescriptor.Primitive) {
            return false;
        }
        if (typeDescriptor instanceof TypeDescriptor.PrimitiveArray) {
            return ((TypeDescriptor.PrimitiveArray) typeDescriptor).isNullable();
        }
        if (typeDescriptor instanceof TypeDescriptor.Simple) {
            return ((TypeDescriptor.Simple) typeDescriptor).isNullable();
        }
        if (typeDescriptor instanceof TypeDescriptor.Parametrized) {
            return ((TypeDescriptor.Parametrized) typeDescriptor).isNullable();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final TypeConverter<Object> getAnyConverter(TypeDescriptor typeDescriptor) {
        Intrinsics.checkNotNullParameter(typeDescriptor, "<this>");
        TypeConverter<?> converter = typeDescriptor.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        return converter;
    }
}
