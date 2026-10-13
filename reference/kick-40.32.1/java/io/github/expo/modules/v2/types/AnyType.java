package io.github.expo.modules.v2.types;

import io.github.expo.modules.v2.converters.TypeConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnyType.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/github/expo/modules/v2/types/AnyType;", "", "descriptor", "Lio/github/expo/modules/v2/types/TypeDescriptor;", "useBuffer", "", "<init>", "(Lio/github/expo/modules/v2/types/TypeDescriptor;Z)V", "getDescriptor", "()Lio/github/expo/modules/v2/types/TypeDescriptor;", "getUseBuffer", "()Z", "isNullable", "converter", "Lio/github/expo/modules/v2/converters/TypeConverter;", "getConverter", "()Lio/github/expo/modules/v2/converters/TypeConverter;", "anyConverter", "getAnyConverter", "codes", "Lio/github/expo/modules/v2/types/TypeCodes;", "getCodes-pj4Pta4", "()[I", "toString", "", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnyType {
    private final TypeDescriptor descriptor;
    private final boolean useBuffer;

    public AnyType(TypeDescriptor descriptor, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.descriptor = descriptor;
        this.useBuffer = z;
    }

    public /* synthetic */ AnyType(TypeDescriptor typeDescriptor, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeDescriptor, (i & 2) != 0 ? false : z);
    }

    public final TypeDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final boolean getUseBuffer() {
        return this.useBuffer;
    }

    public final boolean isNullable() {
        return TypeDescriptorKt.isNullable(this.descriptor);
    }

    public final TypeConverter<?> getConverter() {
        return this.descriptor.getConverter();
    }

    public final TypeConverter<Object> getAnyConverter() {
        TypeConverter<?> converter = this.descriptor.getConverter();
        Intrinsics.checkNotNull(converter, "null cannot be cast to non-null type io.github.expo.modules.v2.converters.TypeConverter<kotlin.Any>");
        return converter;
    }

    /* JADX INFO: renamed from: getCodes-pj4Pta4, reason: not valid java name */
    public final int[] m12403getCodespj4Pta4() {
        int[] codes = getConverter().getCodes();
        return !this.useBuffer ? codes : TypeCodes.m12460withBufferFlagpj4Pta4(codes);
    }

    public String toString() {
        String str;
        if (this.useBuffer) {
            str = " (buffered)";
        } else {
            str = "";
        }
        return this.descriptor + str;
    }
}
