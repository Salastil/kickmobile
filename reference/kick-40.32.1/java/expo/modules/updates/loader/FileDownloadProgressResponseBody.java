package expo.modules.updates.loader;

import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: compiled from: FileDownloader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lexpo/modules/updates/loader/FileDownloadProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "progressListener", "Lexpo/modules/updates/loader/FileDownloadProgressListener;", "<init>", "(Lokhttp3/ResponseBody;Lexpo/modules/updates/loader/FileDownloadProgressListener;)V", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "bufferedSource", "Lokio/BufferedSource;", "getBufferedSource", "()Lokio/BufferedSource;", "bufferedSource$delegate", "Lkotlin/Lazy;", "source", "Lokio/Source;", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class FileDownloadProgressResponseBody extends ResponseBody {

    /* JADX INFO: renamed from: bufferedSource$delegate, reason: from kotlin metadata */
    private final Lazy bufferedSource;
    private final FileDownloadProgressListener progressListener;
    private final ResponseBody responseBody;

    public FileDownloadProgressResponseBody(ResponseBody responseBody, FileDownloadProgressListener progressListener) {
        Intrinsics.checkNotNullParameter(responseBody, "responseBody");
        Intrinsics.checkNotNullParameter(progressListener, "progressListener");
        this.responseBody = responseBody;
        this.progressListener = progressListener;
        this.bufferedSource = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.loader.FileDownloadProgressResponseBody$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                FileDownloadProgressResponseBody fileDownloadProgressResponseBody = this.f$0;
                return Okio.buffer(fileDownloadProgressResponseBody.source(fileDownloadProgressResponseBody.responseBody.getSource()));
            }
        });
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentType */
    public MediaType get$contentType() {
        return this.responseBody.get$contentType();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: contentLength */
    public long getContentLength() {
        return this.responseBody.getContentLength();
    }

    private final BufferedSource getBufferedSource() {
        return (BufferedSource) this.bufferedSource.getValue();
    }

    @Override // okhttp3.ResponseBody
    /* JADX INFO: renamed from: source */
    public BufferedSource getSource() {
        return getBufferedSource();
    }

    private final Source source(Source source) {
        return new ForwardingSource(source) { // from class: expo.modules.updates.loader.FileDownloadProgressResponseBody.source.1
            private long totalBytesRead;

            public final long getTotalBytesRead() {
                return this.totalBytesRead;
            }

            public final void setTotalBytesRead(long j) {
                this.totalBytesRead = j;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                long j = super.read(sink, byteCount);
                this.totalBytesRead += j != -1 ? j : 0L;
                this.progressListener.update(this.totalBytesRead, this.responseBody.getContentLength());
                return j;
            }
        };
    }
}
