package expo.modules.interfaces.imageloader;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.kotlin.services.Service;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageLoaderInterface.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH&J1\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "Lexpo/modules/kotlin/services/Service;", "loadImageForDisplayFromURL", "Ljava/util/concurrent/Future;", "Landroid/graphics/Bitmap;", ImagesContract.URL, "", "", "resultListener", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface$ResultListener;", "loadImageForManipulationFromURL", ViewProps.MAX_WIDTH, "", ViewProps.MAX_HEIGHT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lexpo/modules/interfaces/imageloader/ImageLoaderInterface$ResultListener;)V", "ResultListener", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ImageLoaderInterface extends Service {

    /* JADX INFO: compiled from: ImageLoaderInterface.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lexpo/modules/interfaces/imageloader/ImageLoaderInterface$ResultListener;", "", "onSuccess", "", "bitmap", "Landroid/graphics/Bitmap;", "onFailure", "cause", "", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface ResultListener {
        void onFailure(Throwable cause);

        void onSuccess(Bitmap bitmap);
    }

    Future<Bitmap> loadImageForDisplayFromURL(String url);

    void loadImageForDisplayFromURL(String url, ResultListener resultListener);

    Future<Bitmap> loadImageForManipulationFromURL(String url);

    void loadImageForManipulationFromURL(String url, ResultListener resultListener);

    /* JADX INFO: compiled from: ImageLoaderInterface.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void loadImageForManipulationFromURL(ImageLoaderInterface imageLoaderInterface, String url, Integer num, Integer num2, ResultListener resultListener) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(resultListener, "resultListener");
            ImageLoaderInterface.super.loadImageForManipulationFromURL(url, num, num2, resultListener);
        }
    }

    default void loadImageForManipulationFromURL(String url, Integer maxWidth, Integer maxHeight, ResultListener resultListener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(resultListener, "resultListener");
        loadImageForManipulationFromURL(url, resultListener);
    }
}
