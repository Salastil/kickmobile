package io.github.expo.modules.v2.converters;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/github/expo/modules/v2/converters/FloatConverter;", "Lio/github/expo/modules/v2/converters/NonNullablePassthroughConverter;", "", "<init>", "()V", "writeValue", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "value", "writeValue-uOnPpUM", "(Ljava/nio/ByteBuffer;F)V", "readValue", "readValue-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/lang/Float;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FloatConverter extends NonNullablePassthroughConverter<Float> {
    public FloatConverter() {
        super(CppType.INSTANCE.m12431getFLOATz4oZPQ(), null);
    }

    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: writeValue-uOnPpUM */
    public /* bridge */ /* synthetic */ void mo12337writeValueuOnPpUM(ByteBuffer byteBuffer, Object obj) {
        m12354writeValueuOnPpUM(byteBuffer, ((Number) obj).floatValue());
    }

    /* JADX INFO: renamed from: writeValue-uOnPpUM, reason: not valid java name */
    protected void m12354writeValueuOnPpUM(ByteBuffer buf, float value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        BinaryBuffer.m12282putFloatWPjWIpM(buf, value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: readValue-R_h_rCc */
    public Float mo12336readValueR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return Float.valueOf(BinaryBuffer.m12257getFloatimpl(buf));
    }
}
