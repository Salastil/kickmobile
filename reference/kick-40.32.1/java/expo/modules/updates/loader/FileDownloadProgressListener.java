package expo.modules.updates.loader;

import kotlin.Metadata;

/* JADX INFO: compiled from: FileDownloader.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lexpo/modules/updates/loader/FileDownloadProgressListener;", "", "update", "", "bytesRead", "", "contentLength", "onProgressUpdate", "progress", "", "expo-updates_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface FileDownloadProgressListener {
    void onProgressUpdate(double progress);

    /* JADX INFO: compiled from: FileDownloader.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void update(FileDownloadProgressListener fileDownloadProgressListener, long j, long j2) {
            FileDownloadProgressListener.super.update(j, j2);
        }
    }

    default void update(long bytesRead, long contentLength) {
        if (contentLength > 0) {
            onProgressUpdate(bytesRead / contentLength);
        }
    }
}
