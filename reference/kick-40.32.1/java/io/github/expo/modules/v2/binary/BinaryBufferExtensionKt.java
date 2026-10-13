package io.github.expo.modules.v2.binary;

import io.github.expo.kolibri.binary.BinaryBuffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BinaryBufferExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"newSharedView", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "Lio/github/expo/kolibri/binary/BinaryBuffer$Companion;", "limit", "", "(Lio/github/expo/kolibri/binary/BinaryBuffer$Companion;I)Ljava/nio/ByteBuffer;", "rewind", "rewind-uOnPpUM", "(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;", "react_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BinaryBufferExtensionKt {
    public static /* synthetic */ ByteBuffer newSharedView$default(BinaryBuffer.Companion companion, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return newSharedView(companion, i);
    }

    public static final ByteBuffer newSharedView(BinaryBuffer.Companion companion, int i) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        ByteBuffer byteBufferM12246duplicateViewBdoBPnE = BinaryBuffer.m12246duplicateViewBdoBPnE(BinaryBuffer.INSTANCE.m12309sharedBdoBPnE());
        if (i > 0) {
            BinaryBuffer.m12304setLimitimpl(byteBufferM12246duplicateViewBdoBPnE, i);
        }
        return byteBufferM12246duplicateViewBdoBPnE;
    }

    /* JADX INFO: renamed from: rewind-uOnPpUM$default, reason: not valid java name */
    public static /* synthetic */ ByteBuffer m12315rewinduOnPpUM$default(ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return m12314rewinduOnPpUM(byteBuffer, i);
    }

    /* JADX INFO: renamed from: rewind-uOnPpUM, reason: not valid java name */
    public static final ByteBuffer m12314rewinduOnPpUM(ByteBuffer rewind, int i) {
        Intrinsics.checkNotNullParameter(rewind, "$this$rewind");
        BinaryBuffer.m12305setPositionimpl(rewind, 0);
        if (i > 0) {
            BinaryBuffer.m12304setLimitimpl(rewind, i);
        }
        return rewind;
    }
}
