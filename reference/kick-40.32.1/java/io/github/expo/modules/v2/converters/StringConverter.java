package io.github.expo.modules.v2.converters;

import io.github.expo.kolibri.binary.BinaryBuffer;
import io.github.expo.modules.v2.types.CppType;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PassthroughConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/github/expo/modules/v2/converters/StringConverter;", "Lio/github/expo/modules/v2/converters/PassthroughConverter;", "", "isNullable", "", "<init>", "(Z)V", "writeValue", "", "buf", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "value", "writeValue-uOnPpUM", "(Ljava/nio/ByteBuffer;Ljava/lang/String;)V", "readValue", "readValue-R_h_rCc", "(Ljava/nio/ByteBuffer;)Ljava/lang/String;", "react_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StringConverter extends PassthroughConverter<String> {
    public StringConverter(boolean z) {
        super(CppType.INSTANCE.m12443getSTRINGz4oZPQ(), z, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: writeValue-uOnPpUM, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public void mo12337writeValueuOnPpUM(ByteBuffer buf, String value) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        Intrinsics.checkNotNullParameter(value, "value");
        BinaryBuffer.m12293putStringWPjWIpM(buf, value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.github.expo.modules.v2.converters.PassthroughConverter
    /* JADX INFO: renamed from: readValue-R_h_rCc, reason: avoid collision after fix types in other method */
    public String mo12336readValueR_h_rCc(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        return BinaryBuffer.m12271getStringimpl(buf);
    }
}
