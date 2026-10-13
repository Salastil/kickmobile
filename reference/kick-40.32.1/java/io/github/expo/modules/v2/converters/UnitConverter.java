package io.github.expo.modules.v2.converters;

import io.github.expo.modules.v2.types.CppType;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/github/expo/modules/v2/converters/UnitConverter;", "Lio/github/expo/modules/v2/converters/PassthroughConverter;", "", "isNullable", "", "<init>", "(Z)V", "writeValue", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "value", "writeValue-uOnPpUM", "(Ljava/nio/ByteBuffer;Lkotlin/Unit;)V", "readValue", "readValue-R_h_rCc", "(Ljava/nio/ByteBuffer;)V", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnitConverter extends PassthroughConverter<Unit> {
    /* JADX INFO: renamed from: readValue-R_h_rCc, reason: avoid collision after fix types in other method and not valid java name */
    protected void m12372readValueR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: writeValue-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public void mo12337writeValueuOnPpUM(ByteBuffer buf, Unit value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: readValue-R_h_rCc */
    public /* bridge */ /* synthetic */ Unit mo12336readValueR_h_rCc(ByteBuffer byteBuffer) {
        m12372readValueR_h_rCc(byteBuffer);
        return Unit.INSTANCE;
    }

    public UnitConverter(boolean z) {
        super(CppType.INSTANCE.m12444getUNITz4oZPQ(), z, null);
    }
}
