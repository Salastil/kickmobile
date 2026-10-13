package androidx.camera.camera2.compat.quirk;

import android.util.Size;
import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CamcorderProfileResolutionQuirk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CamcorderProfileResolutionQuirk;", "Landroidx/camera/core/impl/Quirk;", "streamConfigurationMapCompat", "Landroidx/camera/camera2/compat/StreamConfigurationMapCompat;", "<init>", "(Landroidx/camera/camera2/compat/StreamConfigurationMapCompat;)V", "supportedResolution", "", "Landroid/util/Size;", "getSupportedResolution", "()Ljava/util/List;", "supportedResolution$delegate", "Lkotlin/Lazy;", "getSupportedResolutions", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CamcorderProfileResolutionQuirk implements Quirk {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StreamConfigurationMapCompat streamConfigurationMapCompat;

    /* JADX INFO: renamed from: supportedResolution$delegate, reason: from kotlin metadata */
    private final Lazy supportedResolution;

    public CamcorderProfileResolutionQuirk(StreamConfigurationMapCompat streamConfigurationMapCompat) {
        Intrinsics.checkNotNullParameter(streamConfigurationMapCompat, "streamConfigurationMapCompat");
        this.streamConfigurationMapCompat = streamConfigurationMapCompat;
        this.supportedResolution = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.compat.quirk.CamcorderProfileResolutionQuirk$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CamcorderProfileResolutionQuirk.supportedResolution_delegate$lambda$0(this.f$0);
            }
        });
    }

    private final List<Size> getSupportedResolution() {
        return (List) this.supportedResolution.getValue();
    }

    static final List supportedResolution_delegate$lambda$0(CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk) {
        List listEmptyList;
        Size[] outputSizes = camcorderProfileResolutionQuirk.streamConfigurationMapCompat.getOutputSizes(34);
        if (outputSizes == null || (listEmptyList = ArraysKt.asList(outputSizes)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "supportedResolutions = " + listEmptyList);
        }
        return listEmptyList;
    }

    public final List<Size> getSupportedResolutions() {
        return CollectionsKt.toList(getSupportedResolution());
    }

    /* JADX INFO: compiled from: CamcorderProfileResolutionQuirk.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/compat/quirk/CamcorderProfileResolutionQuirk$Companion;", "", "<init>", "()V", "isEnabled", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isEnabled(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
            return CameraMetadata.INSTANCE.isHardwareLevelLegacy(cameraMetadata);
        }
    }
}
