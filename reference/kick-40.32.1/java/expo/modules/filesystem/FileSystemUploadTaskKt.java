package expo.modules.filesystem;

import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: compiled from: FileSystemUploadTask.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\t"}, d2 = {"createMultipartRequestBody", "Lokhttp3/RequestBody;", "file", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "options", "Lexpo/modules/filesystem/UploadTaskOptions;", "asRequestBody", "contentType", "", "expo-file-system_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileSystemUploadTaskKt {
    public static final RequestBody createMultipartRequestBody(UnifiedFileInterface file, UploadTaskOptions options) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(options, "options");
        MultipartBody.Builder type = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM);
        Map<String, String> parameters = options.getParameters();
        if (parameters != null) {
            for (Map.Entry<String, String> entry : parameters.entrySet()) {
                type.addFormDataPart(entry.getKey(), entry.getValue());
            }
        }
        String fileName = file.getFileName();
        if (fileName == null) {
            fileName = "upload";
        }
        String mimeType = options.getMimeType();
        if (mimeType == null && (mimeType = file.getType()) == null && (mimeType = URLConnection.guessContentTypeFromName(fileName)) == null) {
            mimeType = "application/octet-stream";
        }
        String fieldName = options.getFieldName();
        if (fieldName == null) {
            fieldName = fileName;
        }
        type.addFormDataPart(fieldName, fileName, asRequestBody(file, mimeType));
        return type.build();
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.FileSystemUploadTaskKt$asRequestBody$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileSystemUploadTask.kt */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"expo/modules/filesystem/FileSystemUploadTaskKt$asRequestBody$1", "Lokhttp3/RequestBody;", "resolvedLength", "", "getResolvedLength", "()J", "resolvedLength$delegate", "Lkotlin/Lazy;", "contentType", "Lokhttp3/MediaType;", "contentLength", "writeTo", "", "sink", "Lokio/BufferedSink;", "expo-file-system_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1 extends RequestBody {
        final /* synthetic */ String $contentType;
        final /* synthetic */ UnifiedFileInterface $this_asRequestBody;

        /* JADX INFO: renamed from: resolvedLength$delegate, reason: from kotlin metadata */
        private final Lazy resolvedLength;

        AnonymousClass1(final UnifiedFileInterface unifiedFileInterface, String str) {
            this.$this_asRequestBody = unifiedFileInterface;
            this.$contentType = str;
            this.resolvedLength = LazyKt.lazy(new Function0() { // from class: expo.modules.filesystem.FileSystemUploadTaskKt$asRequestBody$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Long.valueOf(unifiedFileInterface.length());
                }
            });
        }

        private final long getResolvedLength() {
            return ((Number) this.resolvedLength.getValue()).longValue();
        }

        @Override // okhttp3.RequestBody
        /* JADX INFO: renamed from: contentType */
        public MediaType getContentType() {
            String str = this.$contentType;
            if (str != null) {
                return MediaType.INSTANCE.parse(str);
            }
            return null;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return getResolvedLength();
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            InputStream inputStream = this.$this_asRequestBody.inputStream();
            try {
                sink.writeAll(Okio.source(inputStream));
                CloseableKt.closeFinally(inputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestBody asRequestBody(UnifiedFileInterface unifiedFileInterface, String str) {
        return new AnonymousClass1(unifiedFileInterface, str);
    }
}
