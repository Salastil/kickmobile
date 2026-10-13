package io.github.expo.kolibri.binary;

import androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticThreadLocal1;
import com.facebook.react.uimanager.ViewProps;
import io.github.expo.kolibri.Kolibri;
import io.github.expo.kolibri.StringExtensionsKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BinaryBuffer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\bC\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087@\u0018\u0000 ³\u00012\u00020\u0001:\u0002³\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0005J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\nJ\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u001f\u0010\u0017J\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020-¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\u001b¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0007¢\u0006\u0004\b4\u0010\nJ\r\u00105\u001a\u00020!¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020%¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020)¢\u0006\u0004\b<\u0010=J\r\u0010>\u001a\u00020-¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C¢\u0006\u0004\bD\u0010EJ\u0015\u0010F\u001a\u00020\u00002\u0006\u0010B\u001a\u00020G¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020\u00002\u0006\u0010B\u001a\u00020K¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\u00020\u00002\u0006\u0010B\u001a\u00020O¢\u0006\u0004\bP\u0010QJ\u0015\u0010R\u001a\u00020\u00002\u0006\u0010B\u001a\u00020S¢\u0006\u0004\bT\u0010UJ\u0015\u0010V\u001a\u00020\u00002\u0006\u0010B\u001a\u00020W¢\u0006\u0004\bX\u0010YJ\u001b\u0010Z\u001a\u00020\u00002\f\u0010B\u001a\b\u0012\u0004\u0012\u00020-0[¢\u0006\u0004\b\\\u0010]J\r\u0010^\u001a\u00020C¢\u0006\u0004\b_\u0010`J\r\u0010a\u001a\u00020G¢\u0006\u0004\bb\u0010cJ\r\u0010d\u001a\u00020K¢\u0006\u0004\be\u0010fJ\r\u0010g\u001a\u00020O¢\u0006\u0004\bh\u0010iJ\r\u0010j\u001a\u00020S¢\u0006\u0004\bk\u0010lJ\r\u0010m\u001a\u00020W¢\u0006\u0004\bn\u0010oJ\u0015\u0010p\u001a\u00020\u00002\u0006\u0010B\u001a\u00020C¢\u0006\u0004\bq\u0010EJ\u0015\u0010r\u001a\u00020\u00002\u0006\u0010B\u001a\u00020G¢\u0006\u0004\bs\u0010IJ\u0015\u0010t\u001a\u00020\u00002\u0006\u0010B\u001a\u00020K¢\u0006\u0004\bu\u0010MJ\u0015\u0010v\u001a\u00020\u00002\u0006\u0010B\u001a\u00020O¢\u0006\u0004\bw\u0010QJ\u0015\u0010x\u001a\u00020\u00002\u0006\u0010B\u001a\u00020W¢\u0006\u0004\by\u0010YJ\u0015\u0010z\u001a\u00020C2\u0006\u0010{\u001a\u00020\u0007¢\u0006\u0004\b|\u0010}J\u0016\u0010~\u001a\u00020G2\u0006\u0010{\u001a\u00020\u0007¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0018\u0010\u0081\u0001\u001a\u00020K2\u0006\u0010{\u001a\u00020\u0007¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0018\u0010\u0084\u0001\u001a\u00020O2\u0006\u0010{\u001a\u00020\u0007¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0018\u0010\u0087\u0001\u001a\u00020W2\u0006\u0010{\u001a\u00020\u0007¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u000f\u0010\u008a\u0001\u001a\u00020\u0000¢\u0006\u0005\b\u008b\u0001\u0010\u0005J\u0017\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u001b¢\u0006\u0005\b\u008d\u0001\u0010\u001dJ\u0017\u0010\u008e\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0005\b\u008f\u0001\u0010\u0017J\u0017\u0010\u0090\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020!¢\u0006\u0005\b\u0091\u0001\u0010#J\u0017\u0010\u0092\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020%¢\u0006\u0005\b\u0093\u0001\u0010'J\u0017\u0010\u0094\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020)¢\u0006\u0005\b\u0095\u0001\u0010+J\u0017\u0010\u0096\u0001\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020-¢\u0006\u0005\b\u0097\u0001\u0010/J\u0017\u0010\u0098\u0001\u001a\u00020\u00002\u0006\u0010B\u001a\u00020W¢\u0006\u0005\b\u0099\u0001\u0010YJ!\u0010\u009a\u0001\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u00072\u0007\u0010\u009b\u0001\u001a\u00020\u0007¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0011\u0010\u009e\u0001\u001a\u00030\u009f\u0001¢\u0006\u0006\b \u0001\u0010¡\u0001J\u0017\u0010¢\u0001\u001a\u00020\u00002\u0006\u0010{\u001a\u00020\u0007¢\u0006\u0005\b£\u0001\u0010\u0017J\u000f\u0010¤\u0001\u001a\u00020\u0007¢\u0006\u0005\b¥\u0001\u0010\nJ\u0018\u0010¦\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020\u0007¢\u0006\u0005\b¨\u0001\u0010\u0017J\u000f\u0010©\u0001\u001a\u00020\u0007¢\u0006\u0005\bª\u0001\u0010\nJ\u001e\u0010«\u0001\u001a\u00020\u001b2\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J\u0012\u0010¯\u0001\u001a\u00020\u0007HÖ\u0001¢\u0006\u0005\b°\u0001\u0010\nJ\u0012\u0010±\u0001\u001a\u00020-HÖ\u0001¢\u0006\u0005\b²\u0001\u0010@R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006´\u0001"}, d2 = {"Lio/github/expo/kolibri/binary/BinaryBuffer;", "", "buffer", "Ljava/nio/ByteBuffer;", "constructor-impl", "(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;", "value", "", ViewProps.POSITION, "getPosition-impl", "(Ljava/nio/ByteBuffer;)I", "setPosition-impl", "(Ljava/nio/ByteBuffer;I)V", "limit", "getLimit-impl", "setLimit-impl", "remaining", "getRemaining-impl", "duplicateView", "duplicateView-BdoBPnE", "putTag", "tag", "putTag-WPjWIpM", "(Ljava/nio/ByteBuffer;I)Ljava/nio/ByteBuffer;", "getTag", "getTag-impl", "putBoolean", "", "putBoolean-WPjWIpM", "(Ljava/nio/ByteBuffer;Z)Ljava/nio/ByteBuffer;", "putInt", "putInt-WPjWIpM", "putLong", "", "putLong-WPjWIpM", "(Ljava/nio/ByteBuffer;J)Ljava/nio/ByteBuffer;", "putFloat", "", "putFloat-WPjWIpM", "(Ljava/nio/ByteBuffer;F)Ljava/nio/ByteBuffer;", "putDouble", "", "putDouble-WPjWIpM", "(Ljava/nio/ByteBuffer;D)Ljava/nio/ByteBuffer;", "putString", "", "putString-WPjWIpM", "(Ljava/nio/ByteBuffer;Ljava/lang/String;)Ljava/nio/ByteBuffer;", "getBoolean", "getBoolean-impl", "(Ljava/nio/ByteBuffer;)Z", "getInt", "getInt-impl", "getLong", "getLong-impl", "(Ljava/nio/ByteBuffer;)J", "getFloat", "getFloat-impl", "(Ljava/nio/ByteBuffer;)F", "getDouble", "getDouble-impl", "(Ljava/nio/ByteBuffer;)D", "getString", "getString-impl", "(Ljava/nio/ByteBuffer;)Ljava/lang/String;", "putDoubleArray", "values", "", "putDoubleArray-WPjWIpM", "(Ljava/nio/ByteBuffer;[D)Ljava/nio/ByteBuffer;", "putIntArray", "", "putIntArray-WPjWIpM", "(Ljava/nio/ByteBuffer;[I)Ljava/nio/ByteBuffer;", "putLongArray", "", "putLongArray-WPjWIpM", "(Ljava/nio/ByteBuffer;[J)Ljava/nio/ByteBuffer;", "putFloatArray", "", "putFloatArray-WPjWIpM", "(Ljava/nio/ByteBuffer;[F)Ljava/nio/ByteBuffer;", "putBooleanArray", "", "putBooleanArray-WPjWIpM", "(Ljava/nio/ByteBuffer;[Z)Ljava/nio/ByteBuffer;", "putByteArray", "", "putByteArray-WPjWIpM", "(Ljava/nio/ByteBuffer;[B)Ljava/nio/ByteBuffer;", "putStringCollection", "", "putStringCollection-WPjWIpM", "(Ljava/nio/ByteBuffer;Ljava/util/Collection;)Ljava/nio/ByteBuffer;", "getDoubleArray", "getDoubleArray-impl", "(Ljava/nio/ByteBuffer;)[D", "getIntArray", "getIntArray-impl", "(Ljava/nio/ByteBuffer;)[I", "getLongArray", "getLongArray-impl", "(Ljava/nio/ByteBuffer;)[J", "getFloatArray", "getFloatArray-impl", "(Ljava/nio/ByteBuffer;)[F", "getBooleanArray", "getBooleanArray-impl", "(Ljava/nio/ByteBuffer;)[Z", "getByteArray", "getByteArray-impl", "(Ljava/nio/ByteBuffer;)[B", "putDoubles", "putDoubles-WPjWIpM", "putInts", "putInts-WPjWIpM", "putLongs", "putLongs-WPjWIpM", "putFloats", "putFloats-WPjWIpM", "putBytes", "putBytes-WPjWIpM", "getDoubles", "count", "getDoubles-impl", "(Ljava/nio/ByteBuffer;I)[D", "getInts", "getInts-impl", "(Ljava/nio/ByteBuffer;I)[I", "getLongs", "getLongs-impl", "(Ljava/nio/ByteBuffer;I)[J", "getFloats", "getFloats-impl", "(Ljava/nio/ByteBuffer;I)[F", "getBytes", "getBytes-impl", "(Ljava/nio/ByteBuffer;I)[B", "putTaggedNull", "putTaggedNull-BdoBPnE", "putTaggedBoolean", "putTaggedBoolean-WPjWIpM", "putTaggedInt", "putTaggedInt-WPjWIpM", "putTaggedLong", "putTaggedLong-WPjWIpM", "putTaggedFloat", "putTaggedFloat-WPjWIpM", "putTaggedDouble", "putTaggedDouble-WPjWIpM", "putTaggedString", "putTaggedString-WPjWIpM", "putTaggedByteArray", "putTaggedByteArray-WPjWIpM", "putListHeader", "elementTag", "putListHeader-cwiCPus", "(Ljava/nio/ByteBuffer;II)Ljava/nio/ByteBuffer;", "getListHeader", "Lio/github/expo/kolibri/binary/ListHeader;", "getListHeader-impl", "(Ljava/nio/ByteBuffer;)Lio/github/expo/kolibri/binary/ListHeader;", "putMapHeader", "putMapHeader-WPjWIpM", "getMapSize", "getMapSize-impl", "putExternalSchemaHeader", "schemaId", "putExternalSchemaHeader-WPjWIpM", "getExternalSchemaId", "getExternalSchemaId-impl", "equals", "other", "equals-impl", "(Ljava/nio/ByteBuffer;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "toString-impl", "Companion", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
public final class BinaryBuffer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ThreadLocal<BinaryBuffer> threadBuffer = new Utf8Old$$ExternalSyntheticThreadLocal1(new Supplier() { // from class: io.github.expo.kolibri.binary.BinaryBuffer$Companion$threadBuffer$1
        @Override // java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            ByteBuffer byteBufferM12310getOo0jTjA = m12310getOo0jTjA();
            if (byteBufferM12310getOo0jTjA != null) {
                return BinaryBuffer.m12244boximpl(byteBufferM12310getOo0jTjA);
            }
            return null;
        }

        /* JADX INFO: renamed from: get-Oo0jTjA, reason: not valid java name */
        public final ByteBuffer m12310getOo0jTjA() {
            Kolibri.INSTANCE.load();
            ByteBuffer byteBufferOrder = BinaryBuffer.INSTANCE.nativeGetBuffer().order(ByteOrder.nativeOrder());
            Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
            return BinaryBuffer.m12245constructorimpl(byteBufferOrder);
        }
    });
    private final ByteBuffer buffer;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BinaryBuffer m12244boximpl(ByteBuffer byteBuffer) {
        return new BinaryBuffer(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static ByteBuffer m12245constructorimpl(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m12247equalsimpl(ByteBuffer byteBuffer, Object obj) {
        return (obj instanceof BinaryBuffer) && Intrinsics.areEqual(byteBuffer, ((BinaryBuffer) obj).getBuffer());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m12248equalsimpl0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return Intrinsics.areEqual(byteBuffer, byteBuffer2);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m12273hashCodeimpl(ByteBuffer byteBuffer) {
        return byteBuffer.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native ByteBuffer nativeGetBuffer();

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m12306toStringimpl(ByteBuffer byteBuffer) {
        return "BinaryBuffer(buffer=" + byteBuffer + ")";
    }

    public boolean equals(Object obj) {
        return m12247equalsimpl(this.buffer, obj);
    }

    public int hashCode() {
        return m12273hashCodeimpl(this.buffer);
    }

    public String toString() {
        return m12306toStringimpl(this.buffer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ ByteBuffer getBuffer() {
        return this.buffer;
    }

    private /* synthetic */ BinaryBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    /* JADX INFO: renamed from: getPosition-impl, reason: not valid java name */
    public static final int m12269getPositionimpl(ByteBuffer byteBuffer) {
        return byteBuffer.position();
    }

    /* JADX INFO: renamed from: setPosition-impl, reason: not valid java name */
    public static final void m12305setPositionimpl(ByteBuffer byteBuffer, int i) {
    }

    /* JADX INFO: renamed from: getLimit-impl, reason: not valid java name */
    public static final int m12263getLimitimpl(ByteBuffer byteBuffer) {
        return byteBuffer.limit();
    }

    /* JADX INFO: renamed from: setLimit-impl, reason: not valid java name */
    public static final void m12304setLimitimpl(ByteBuffer byteBuffer, int i) {
    }

    /* JADX INFO: renamed from: getRemaining-impl, reason: not valid java name */
    public static final int m12270getRemainingimpl(ByteBuffer byteBuffer) {
        return byteBuffer.remaining();
    }

    /* JADX INFO: renamed from: duplicateView-BdoBPnE, reason: not valid java name */
    public static final ByteBuffer m12246duplicateViewBdoBPnE(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferOrder = byteBuffer.duplicate().order(ByteOrder.nativeOrder());
        Intrinsics.checkNotNull(byteBufferOrder);
        return m12245constructorimpl(byteBufferOrder);
    }

    /* JADX INFO: renamed from: putTag-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12295putTagWPjWIpM(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) i);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: getTag-impl, reason: not valid java name */
    public static final int m12272getTagimpl(ByteBuffer byteBuffer) {
        return byteBuffer.get() & 255;
    }

    /* JADX INFO: renamed from: putBoolean-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12274putBooleanWPjWIpM(ByteBuffer byteBuffer, boolean z) {
        byteBuffer.put(z ? (byte) 1 : (byte) 0);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putInt-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12285putIntWPjWIpM(ByteBuffer byteBuffer, int i) {
        byteBuffer.putInt(i);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putLong-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12289putLongWPjWIpM(ByteBuffer byteBuffer, long j) {
        byteBuffer.putLong(j);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putFloat-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12282putFloatWPjWIpM(ByteBuffer byteBuffer, float f) {
        byteBuffer.putFloat(f);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putDouble-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12278putDoubleWPjWIpM(ByteBuffer byteBuffer, double d) {
        byteBuffer.putDouble(d);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putString-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12293putStringWPjWIpM(ByteBuffer byteBuffer, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int length = value.length();
        boolean z = length <= 4096;
        if (StringExtensionsKt.isAscii(value)) {
            byteBuffer.putInt(length);
            if (z) {
                byte[] bArrBytes = StringScratchKt.getStringScratch().get().bytes(length);
                value.getBytes(0, value.length(), bArrBytes, 0);
                byteBuffer.put(bArrBytes, 0, length);
                return byteBuffer;
            }
            byte[] bytes = value.getBytes(Charsets.ISO_8859_1);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byteBuffer.put(bytes);
            return byteBuffer;
        }
        byteBuffer.putInt(-length);
        if (z) {
            char[] cArrChars = StringScratchKt.getStringScratch().get().chars(length);
            value.getChars(0, length, cArrChars, 0);
            byteBuffer.asCharBuffer().put(cArrChars, 0, length);
        } else {
            byteBuffer.asCharBuffer().put(value);
        }
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (length * 2));
        Unit unit = Unit.INSTANCE;
        return byteBuffer;
    }

    /* JADX INFO: renamed from: getBoolean-impl, reason: not valid java name */
    public static final boolean m12249getBooleanimpl(ByteBuffer byteBuffer) {
        return byteBuffer.get() != 0;
    }

    /* JADX INFO: renamed from: getInt-impl, reason: not valid java name */
    public static final int m12260getIntimpl(ByteBuffer byteBuffer) {
        return byteBuffer.getInt();
    }

    /* JADX INFO: renamed from: getLong-impl, reason: not valid java name */
    public static final long m12265getLongimpl(ByteBuffer byteBuffer) {
        return byteBuffer.getLong();
    }

    /* JADX INFO: renamed from: getFloat-impl, reason: not valid java name */
    public static final float m12257getFloatimpl(ByteBuffer byteBuffer) {
        return byteBuffer.getFloat();
    }

    /* JADX INFO: renamed from: getDouble-impl, reason: not valid java name */
    public static final double m12253getDoubleimpl(ByteBuffer byteBuffer) {
        return byteBuffer.getDouble();
    }

    /* JADX INFO: renamed from: getString-impl, reason: not valid java name */
    public static final String m12271getStringimpl(ByteBuffer byteBuffer) {
        String str;
        int i = byteBuffer.getInt();
        if (i >= 0) {
            if (i <= 4096) {
                byte[] bArrBytes = StringScratchKt.getStringScratch().get().bytes(i);
                byteBuffer.get(bArrBytes, 0, i);
                return new String(bArrBytes, 0, i, Charsets.ISO_8859_1);
            }
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return new String(bArr, Charsets.ISO_8859_1);
        }
        int i2 = -i;
        if (i2 <= 4096) {
            char[] cArrChars = StringScratchKt.getStringScratch().get().chars(i2);
            byteBuffer.asCharBuffer().get(cArrChars, 0, i2);
            str = new String(cArrChars, 0, i2);
        } else {
            char[] cArr = new char[i2];
            byteBuffer.asCharBuffer().get(cArr);
            str = new String(cArr);
        }
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (i2 * 2));
        return str;
    }

    /* JADX INFO: renamed from: putDoubleArray-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12279putDoubleArrayWPjWIpM(ByteBuffer byteBuffer, double[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.putInt(values.length);
        m12280putDoublesWPjWIpM(byteBuffer, values);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putIntArray-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12286putIntArrayWPjWIpM(ByteBuffer byteBuffer, int[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.putInt(values.length);
        m12287putIntsWPjWIpM(byteBuffer, values);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putLongArray-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12290putLongArrayWPjWIpM(ByteBuffer byteBuffer, long[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.putInt(values.length);
        m12291putLongsWPjWIpM(byteBuffer, values);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putFloatArray-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12283putFloatArrayWPjWIpM(ByteBuffer byteBuffer, float[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.putInt(values.length);
        m12284putFloatsWPjWIpM(byteBuffer, values);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putBooleanArray-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12275putBooleanArrayWPjWIpM(ByteBuffer byteBuffer, boolean[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.putInt(values.length);
        for (boolean z : values) {
            m12274putBooleanWPjWIpM(byteBuffer, z);
        }
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putByteArray-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12276putByteArrayWPjWIpM(ByteBuffer byteBuffer, byte[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.putInt(values.length);
        byteBuffer.put(values);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putStringCollection-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12294putStringCollectionWPjWIpM(ByteBuffer byteBuffer, Collection<String> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.putInt(values.size());
        Iterator<String> it = values.iterator();
        while (it.hasNext()) {
            m12293putStringWPjWIpM(byteBuffer, it.next());
        }
        return byteBuffer;
    }

    /* JADX INFO: renamed from: getDoubleArray-impl, reason: not valid java name */
    public static final double[] m12254getDoubleArrayimpl(ByteBuffer byteBuffer) {
        return m12255getDoublesimpl(byteBuffer, m12260getIntimpl(byteBuffer));
    }

    /* JADX INFO: renamed from: getIntArray-impl, reason: not valid java name */
    public static final int[] m12261getIntArrayimpl(ByteBuffer byteBuffer) {
        return m12262getIntsimpl(byteBuffer, m12260getIntimpl(byteBuffer));
    }

    /* JADX INFO: renamed from: getLongArray-impl, reason: not valid java name */
    public static final long[] m12266getLongArrayimpl(ByteBuffer byteBuffer) {
        return m12267getLongsimpl(byteBuffer, m12260getIntimpl(byteBuffer));
    }

    /* JADX INFO: renamed from: getFloatArray-impl, reason: not valid java name */
    public static final float[] m12258getFloatArrayimpl(ByteBuffer byteBuffer) {
        return m12259getFloatsimpl(byteBuffer, m12260getIntimpl(byteBuffer));
    }

    /* JADX INFO: renamed from: getBooleanArray-impl, reason: not valid java name */
    public static final boolean[] m12250getBooleanArrayimpl(ByteBuffer byteBuffer) {
        int iM12260getIntimpl = m12260getIntimpl(byteBuffer);
        boolean[] zArr = new boolean[iM12260getIntimpl];
        for (int i = 0; i < iM12260getIntimpl; i++) {
            zArr[i] = m12249getBooleanimpl(byteBuffer);
        }
        return zArr;
    }

    /* JADX INFO: renamed from: getByteArray-impl, reason: not valid java name */
    public static final byte[] m12251getByteArrayimpl(ByteBuffer byteBuffer) {
        return m12252getBytesimpl(byteBuffer, m12260getIntimpl(byteBuffer));
    }

    /* JADX INFO: renamed from: putDoubles-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12280putDoublesWPjWIpM(ByteBuffer byteBuffer, double[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.asDoubleBuffer().put(values);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (values.length * 8));
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putInts-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12287putIntsWPjWIpM(ByteBuffer byteBuffer, int[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.asIntBuffer().put(values);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (values.length * 4));
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putLongs-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12291putLongsWPjWIpM(ByteBuffer byteBuffer, long[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.asLongBuffer().put(values);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (values.length * 8));
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putFloats-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12284putFloatsWPjWIpM(ByteBuffer byteBuffer, float[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.asFloatBuffer().put(values);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (values.length * 4));
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putBytes-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12277putBytesWPjWIpM(ByteBuffer byteBuffer, byte[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        byteBuffer.put(values);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: getDoubles-impl, reason: not valid java name */
    public static final double[] m12255getDoublesimpl(ByteBuffer byteBuffer, int i) {
        double[] dArr = new double[i];
        byteBuffer.asDoubleBuffer().get(dArr);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (i * 8));
        return dArr;
    }

    /* JADX INFO: renamed from: getInts-impl, reason: not valid java name */
    public static final int[] m12262getIntsimpl(ByteBuffer byteBuffer, int i) {
        int[] iArr = new int[i];
        byteBuffer.asIntBuffer().get(iArr);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (i * 4));
        return iArr;
    }

    /* JADX INFO: renamed from: getLongs-impl, reason: not valid java name */
    public static final long[] m12267getLongsimpl(ByteBuffer byteBuffer, int i) {
        long[] jArr = new long[i];
        byteBuffer.asLongBuffer().get(jArr);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (i * 8));
        return jArr;
    }

    /* JADX INFO: renamed from: getFloats-impl, reason: not valid java name */
    public static final float[] m12259getFloatsimpl(ByteBuffer byteBuffer, int i) {
        float[] fArr = new float[i];
        byteBuffer.asFloatBuffer().get(fArr);
        m12305setPositionimpl(byteBuffer, m12269getPositionimpl(byteBuffer) + (i * 4));
        return fArr;
    }

    /* JADX INFO: renamed from: getBytes-impl, reason: not valid java name */
    public static final byte[] m12252getBytesimpl(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    /* JADX INFO: renamed from: putTaggedNull-BdoBPnE, reason: not valid java name */
    public static final ByteBuffer m12302putTaggedNullBdoBPnE(ByteBuffer byteBuffer) {
        m12295putTagWPjWIpM(byteBuffer, 8);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putTaggedBoolean-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12296putTaggedBooleanWPjWIpM(ByteBuffer byteBuffer, boolean z) {
        m12295putTagWPjWIpM(byteBuffer, 0);
        m12274putBooleanWPjWIpM(byteBuffer, z);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putTaggedInt-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12300putTaggedIntWPjWIpM(ByteBuffer byteBuffer, int i) {
        m12295putTagWPjWIpM(byteBuffer, 2);
        m12285putIntWPjWIpM(byteBuffer, i);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putTaggedLong-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12301putTaggedLongWPjWIpM(ByteBuffer byteBuffer, long j) {
        m12295putTagWPjWIpM(byteBuffer, 3);
        m12289putLongWPjWIpM(byteBuffer, j);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putTaggedFloat-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12299putTaggedFloatWPjWIpM(ByteBuffer byteBuffer, float f) {
        m12295putTagWPjWIpM(byteBuffer, 4);
        m12282putFloatWPjWIpM(byteBuffer, f);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putTaggedDouble-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12298putTaggedDoubleWPjWIpM(ByteBuffer byteBuffer, double d) {
        m12295putTagWPjWIpM(byteBuffer, 5);
        m12278putDoubleWPjWIpM(byteBuffer, d);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putTaggedString-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12303putTaggedStringWPjWIpM(ByteBuffer byteBuffer, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        m12295putTagWPjWIpM(byteBuffer, 1);
        m12293putStringWPjWIpM(byteBuffer, value);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putTaggedByteArray-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12297putTaggedByteArrayWPjWIpM(ByteBuffer byteBuffer, byte[] values) {
        Intrinsics.checkNotNullParameter(values, "values");
        m12295putTagWPjWIpM(byteBuffer, 9);
        m12276putByteArrayWPjWIpM(byteBuffer, values);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: putListHeader-cwiCPus, reason: not valid java name */
    public static final ByteBuffer m12288putListHeadercwiCPus(ByteBuffer byteBuffer, int i, int i2) {
        m12295putTagWPjWIpM(byteBuffer, 6);
        m12285putIntWPjWIpM(byteBuffer, i);
        m12295putTagWPjWIpM(byteBuffer, i2);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: getListHeader-impl, reason: not valid java name */
    public static final ListHeader m12264getListHeaderimpl(ByteBuffer byteBuffer) {
        return new ListHeader(m12260getIntimpl(byteBuffer), m12272getTagimpl(byteBuffer));
    }

    /* JADX INFO: renamed from: putMapHeader-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12292putMapHeaderWPjWIpM(ByteBuffer byteBuffer, int i) {
        m12295putTagWPjWIpM(byteBuffer, 7);
        m12285putIntWPjWIpM(byteBuffer, i);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: getMapSize-impl, reason: not valid java name */
    public static final int m12268getMapSizeimpl(ByteBuffer byteBuffer) {
        return m12260getIntimpl(byteBuffer);
    }

    /* JADX INFO: renamed from: putExternalSchemaHeader-WPjWIpM, reason: not valid java name */
    public static final ByteBuffer m12281putExternalSchemaHeaderWPjWIpM(ByteBuffer byteBuffer, int i) {
        m12295putTagWPjWIpM(byteBuffer, 10);
        m12285putIntWPjWIpM(byteBuffer, i);
        return byteBuffer;
    }

    /* JADX INFO: renamed from: getExternalSchemaId-impl, reason: not valid java name */
    public static final int m12256getExternalSchemaIdimpl(ByteBuffer byteBuffer) {
        return m12260getIntimpl(byteBuffer);
    }

    /* JADX INFO: compiled from: BinaryBuffer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0010\u001a\u00020\u0011H\u0083 R2\u0010\r\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00050\u0005 \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/github/expo/kolibri/binary/BinaryBuffer$Companion;", "", "<init>", "()V", "shared", "Lio/github/expo/kolibri/binary/BinaryBuffer;", "shared-BdoBPnE", "()Ljava/nio/ByteBuffer;", "allocate", "capacity", "", "allocate-WPjWIpM", "(I)Ljava/nio/ByteBuffer;", "threadBuffer", "Ljava/lang/ThreadLocal;", "kotlin.jvm.PlatformType", "nativeGetBuffer", "Ljava/nio/ByteBuffer;", "runtime"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final ByteBuffer nativeGetBuffer() {
            return BinaryBuffer.nativeGetBuffer();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: shared-BdoBPnE, reason: not valid java name */
        public final ByteBuffer m12309sharedBdoBPnE() {
            Object obj = BinaryBuffer.threadBuffer.get();
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            return ((BinaryBuffer) obj).getBuffer();
        }

        /* JADX INFO: renamed from: allocate-WPjWIpM, reason: not valid java name */
        public final ByteBuffer m12308allocateWPjWIpM(int capacity) {
            ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(capacity).order(ByteOrder.nativeOrder());
            Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "order(...)");
            return BinaryBuffer.m12245constructorimpl(byteBufferOrder);
        }
    }
}
