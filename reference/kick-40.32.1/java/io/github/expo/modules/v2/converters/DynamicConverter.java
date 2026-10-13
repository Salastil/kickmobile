package io.github.expo.modules.v2.converters;

import io.github.expo.modules.v2.binary.BinaryValueCodec;
import io.github.expo.modules.v2.types.CppType;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/github/expo/modules/v2/converters/DynamicConverter;", "Lio/github/expo/modules/v2/converters/PassthroughConverter;", "", "isNullable", "", "<init>", "(Z)V", "writeValue", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "value", "writeValue-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)V", "readValue", "readValue-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/lang/Object;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DynamicConverter extends PassthroughConverter<Object> {
    public DynamicConverter(boolean z) {
        super(CppType.INSTANCE.m12420getANYz4oZPQ(), z, null);
    }

    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: writeValue-uOnPpUM */
    protected void mo12337writeValueuOnPpUM(ByteBuffer buf, Object value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(value, "value");
        BinaryValueCodec.INSTANCE.m12323writeDynamicuOnPpUM$react_release(buf, value);
    }

    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: readValue-R_h_rCc */
    protected Object mo12336readValueR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return BinaryValueCodec.INSTANCE.m12322readDynamicR_h_rCc$react_release(buf);
    }
}
