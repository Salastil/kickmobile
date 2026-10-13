package androidx.camera.core.impl.utils;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UseCaseUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007J\f\u0010\n\u001a\u00020\u0007*\u00020\tH\u0007J,\u0010\u000b\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\t0\b2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000eH\u0007J*\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\t0\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000eH\u0002J*\u0010\u0012\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\t0\b2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000eH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u00020\t0\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/camera/core/impl/utils/UseCaseUtil;", "", "<init>", "()V", "TAG", "", "containsVideoCapture", "", "", "Landroidx/camera/core/UseCase;", "isVideoCapture", "getVideoStabilization", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "configProvider", "Lkotlin/Function1;", "Landroidx/camera/core/impl/UseCaseConfig;", "getPreviewStabilizationMode", "", "getVideoStabilizationMode", "findVideoCapture", "findPreview", "Landroidx/camera/core/Preview;", "findImageCapture", "Landroidx/camera/core/ImageCapture;", "findImageAnalysis", "Landroidx/camera/core/ImageAnalysis;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UseCaseUtil {
    public static final UseCaseUtil INSTANCE = new UseCaseUtil();
    private static final String TAG = "UseCaseUtil";

    private UseCaseUtil() {
    }

    @JvmStatic
    public static final boolean containsVideoCapture(Collection<? extends UseCase> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        for (UseCase useCase : collection) {
            if (useCase != null && isVideoCapture(useCase)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isVideoCapture(UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "<this>");
        if (useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
            return useCase.getCurrentConfig().getCaptureType() == UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
        }
        Logger.e(TAG, useCase + " UseCase does not have capture type.");
        return false;
    }

    public static /* synthetic */ VideoStabilization getVideoStabilization$default(Collection collection, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.camera.core.impl.utils.UseCaseUtil$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return UseCaseUtil.getVideoStabilization$lambda$0((UseCase) obj2);
                }
            };
        }
        return getVideoStabilization(collection, function1);
    }

    static final UseCaseConfig getVideoStabilization$lambda$0(UseCase it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getCurrentConfig();
    }

    @JvmStatic
    public static final VideoStabilization getVideoStabilization(Collection<? extends UseCase> collection, Function1<? super UseCase, ? extends UseCaseConfig<?>> configProvider) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(configProvider, "configProvider");
        VideoStabilization.Companion companion = VideoStabilization.INSTANCE;
        UseCaseUtil useCaseUtil = INSTANCE;
        return companion.from$camera_core(useCaseUtil.getPreviewStabilizationMode(collection, configProvider), useCaseUtil.getVideoStabilizationMode(collection, configProvider));
    }

    private final int getPreviewStabilizationMode(Collection<? extends UseCase> collection, Function1<? super UseCase, ? extends UseCaseConfig<?>> function1) {
        Iterator<T> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            int previewStabilizationMode = function1.invoke((UseCase) it.next()).getPreviewStabilizationMode();
            if (previewStabilizationMode != 0) {
                if (i != previewStabilizationMode && i != 0) {
                    Logger.w(TAG, "Unexpected configurations: Overwriting current previewStabilizationMode(" + i + ") with useCasePreviewStabilization(" + previewStabilizationMode + ")!");
                }
                i = previewStabilizationMode;
            }
        }
        return i;
    }

    private final int getVideoStabilizationMode(Collection<? extends UseCase> collection, Function1<? super UseCase, ? extends UseCaseConfig<?>> function1) {
        Iterator<T> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            int videoStabilizationMode = function1.invoke((UseCase) it.next()).getVideoStabilizationMode();
            if (videoStabilizationMode != 0) {
                if (i != videoStabilizationMode && i != 0) {
                    Logger.w(TAG, "Unexpected configurations: Overwriting current videoStabilizationMode(" + i + ") with useCaseVideoStabilization(" + videoStabilizationMode + ")!");
                }
                i = videoStabilizationMode;
            }
        }
        return i;
    }

    @JvmStatic
    public static final UseCase findVideoCapture(Collection<? extends UseCase> collection) {
        Object next;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (isVideoCapture((UseCase) next)) {
                return (UseCase) next;
            }
        }
        next = null;
        return (UseCase) next;
    }

    @JvmStatic
    public static final Preview findPreview(Collection<? extends UseCase> collection) {
        Object next;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterator<T> it = collection.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((UseCase) next) instanceof Preview));
        if (next instanceof Preview) {
            return (Preview) next;
        }
        return null;
    }

    @JvmStatic
    public static final ImageCapture findImageCapture(Collection<? extends UseCase> collection) {
        Object next;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterator<T> it = collection.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((UseCase) next) instanceof ImageCapture));
        if (next instanceof ImageCapture) {
            return (ImageCapture) next;
        }
        return null;
    }

    @JvmStatic
    public static final ImageAnalysis findImageAnalysis(Collection<? extends UseCase> collection) {
        Object next;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Iterator<T> it = collection.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((UseCase) next) instanceof ImageAnalysis));
        if (next instanceof ImageAnalysis) {
            return (ImageAnalysis) next;
        }
        return null;
    }
}
