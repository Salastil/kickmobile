package io.github.expo.modules.v2.converters;

import io.github.expo.modules.v2.types.CppType;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/github/expo/modules/v2/converters/JsHandleConverter;", "Lio/github/expo/modules/v2/converters/PassthroughConverter;", "", "kind", "Lio/github/expo/modules/v2/types/CppType;", "isNullable", "", "<init>", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "writeValue", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "value", "writeValue-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)V", "readValue", "readValue-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/lang/Object;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JsHandleConverter extends PassthroughConverter<Object> {
    public /* synthetic */ JsHandleConverter(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    private JsHandleConverter(int i, boolean z) {
        super(i, z, null);
    }

    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: writeValue-uOnPpUM */
    protected void mo12337writeValueuOnPpUM(ByteBuffer buf, Object value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException(("No typed encoding for " + CppType.m12417toStringimpl(getKind())).toString());
    }

    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: readValue-R_h_rCc */
    protected Object mo12336readValueR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        throw new IllegalStateException(("No typed decoding for " + CppType.m12417toStringimpl(getKind())).toString());
    }
}
