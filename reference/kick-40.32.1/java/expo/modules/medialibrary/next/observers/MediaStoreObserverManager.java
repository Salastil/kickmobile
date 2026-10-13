package expo.modules.medialibrary.next.observers;

import android.content.ContentResolver;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import expo.modules.medialibrary.next.objects.wrappers.MediaType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MediaStoreObserverManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/medialibrary/next/observers/MediaStoreObserverManager;", "", "contentResolver", "Landroid/content/ContentResolver;", "observerScope", "Lkotlinx/coroutines/CoroutineScope;", "onChange", "Lexpo/modules/medialibrary/next/observers/OnMediaLibraryChange;", "<init>", "(Landroid/content/ContentResolver;Lkotlinx/coroutines/CoroutineScope;Lexpo/modules/medialibrary/next/observers/OnMediaLibraryChange;)V", "imagesObserver", "Lexpo/modules/medialibrary/next/observers/MediaStoreContentObserver;", "videosObserver", "startObserving", "", "stopObserving", "expo-media-library_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaStoreObserverManager {
    private final ContentResolver contentResolver;
    private MediaStoreContentObserver imagesObserver;
    private final CoroutineScope observerScope;
    private final OnMediaLibraryChange onChange;
    private MediaStoreContentObserver videosObserver;

    public MediaStoreObserverManager(ContentResolver contentResolver, CoroutineScope observerScope, OnMediaLibraryChange onChange) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Intrinsics.checkNotNullParameter(observerScope, "observerScope");
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        this.contentResolver = contentResolver;
        this.observerScope = observerScope;
        this.onChange = onChange;
    }

    public final void startObserving() {
        if (this.imagesObserver == null && this.videosObserver == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            MediaStoreContentObserver mediaStoreContentObserver = new MediaStoreContentObserver(handler, MediaType.IMAGE, this.onChange, this.observerScope, this.contentResolver);
            this.contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver);
            this.imagesObserver = mediaStoreContentObserver;
            MediaStoreContentObserver mediaStoreContentObserver2 = new MediaStoreContentObserver(handler, MediaType.VIDEO, this.onChange, this.observerScope, this.contentResolver);
            this.contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver2);
            this.videosObserver = mediaStoreContentObserver2;
        }
    }

    public final void stopObserving() {
        MediaStoreContentObserver mediaStoreContentObserver = this.imagesObserver;
        if (mediaStoreContentObserver != null) {
            this.contentResolver.unregisterContentObserver(mediaStoreContentObserver);
            this.imagesObserver = null;
        }
        MediaStoreContentObserver mediaStoreContentObserver2 = this.videosObserver;
        if (mediaStoreContentObserver2 != null) {
            this.contentResolver.unregisterContentObserver(mediaStoreContentObserver2);
            this.videosObserver = null;
        }
    }
}
