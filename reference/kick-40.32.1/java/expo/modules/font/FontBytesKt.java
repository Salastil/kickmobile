package expo.modules.font;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontBytes.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¨\u0006\b"}, d2 = {"readAtMost", "Ljava/nio/ByteBuffer;", "Ljava/io/InputStream;", "count", "", "readWholeFont", "prefix", "rest", "expo-font_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FontBytesKt {
    public static final ByteBuffer readAtMost(InputStream inputStream, int i) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                break;
            }
            i2 += i3;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, i2);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        return byteBufferWrap;
    }

    public static final ByteBuffer readWholeFont(ByteBuffer prefix, InputStream rest) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(rest, "rest");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(prefix.remaining() + rest.available());
        byteBufferAllocateDirect.put(prefix);
        ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(rest);
        while (byteBufferAllocateDirect.hasRemaining() && readableByteChannelNewChannel.read(byteBufferAllocateDirect) >= 0) {
        }
        byte[] bytes = ByteStreamsKt.readBytes(rest);
        if (!byteBufferAllocateDirect.hasRemaining() && bytes.length == 0) {
            byteBufferAllocateDirect.rewind();
            Intrinsics.checkNotNullExpressionValue(byteBufferAllocateDirect, "apply(...)");
            return byteBufferAllocateDirect;
        }
        byteBufferAllocateDirect.flip();
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(byteBufferAllocateDirect.remaining() + bytes.length);
        byteBufferAllocateDirect2.put(byteBufferAllocateDirect);
        byteBufferAllocateDirect2.put(bytes);
        byteBufferAllocateDirect2.rewind();
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocateDirect2, "apply(...)");
        return byteBufferAllocateDirect2;
    }
}
