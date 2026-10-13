package expo.modules.filesystem.legacy;

import android.util.Base64;
import com.facebook.react.uimanager.ViewProps;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: FileSystemLegacyReader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"readInputStreamAsString", "", "inputStream", "Ljava/io/InputStream;", "encoding", "Lexpo/modules/filesystem/legacy/EncodingType;", "options", "Lexpo/modules/filesystem/legacy/ReadingOptions;", "readBytes", "", "skipBytes", "", ViewProps.POSITION, "", "readByteRange", "length", "", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystemLegacyReaderKt {
    public static final String readInputStreamAsString(InputStream inputStream, EncodingType encodingType, ReadingOptions options) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(options, "options");
        byte[] bytes = readBytes(inputStream, options);
        if (encodingType == EncodingType.BASE64) {
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNull(strEncodeToString);
            return strEncodeToString;
        }
        return new String(bytes, Charsets.UTF_8);
    }

    private static final byte[] readBytes(InputStream inputStream, ReadingOptions readingOptions) throws IOException {
        if (readingOptions.getLength() != null && readingOptions.getPosition() != null) {
            skipBytes(inputStream, readingOptions.getPosition().intValue());
            return readByteRange(inputStream, readingOptions.getLength().intValue());
        }
        return ByteStreamsKt.readBytes(inputStream);
    }

    private static final void skipBytes(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            long jSkip = inputStream.skip(j);
            if (jSkip > 0) {
                j -= jSkip;
            } else if (inputStream.read() == -1) {
                return;
            } else {
                j--;
            }
        }
    }

    private static final byte[] readByteRange(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 <= 0) {
                break;
            }
            i2 += i3;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }
}
