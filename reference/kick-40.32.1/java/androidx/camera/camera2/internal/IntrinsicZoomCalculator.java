package androidx.camera.camera2.internal;

import androidx.camera.camera2.pipe.CameraMetadata;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntrinsicZoomCalculator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \b2\u00020\u0001:\u0002\u0007\bJ\u0017\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;", "", "calculateIntrinsicZoomRatio", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "(Landroidx/camera/camera2/pipe/CameraMetadata;)Ljava/lang/Float;", "Bindings", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IntrinsicZoomCalculator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: IntrinsicZoomCalculator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/internal/IntrinsicZoomCalculator$Bindings;", "", "<init>", "()V", "bindIntrinsicZoomCalculatorImpl", "Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;", "impl", "Landroidx/camera/camera2/internal/IntrinsicZoomCalculatorImpl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        public abstract IntrinsicZoomCalculator bindIntrinsicZoomCalculatorImpl(IntrinsicZoomCalculatorImpl impl);
    }

    Float calculateIntrinsicZoomRatio(CameraMetadata cameraMetadata);

    /* JADX INFO: compiled from: IntrinsicZoomCalculator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/internal/IntrinsicZoomCalculator$Companion;", "", "<init>", "()V", "NO_OP_INTRINSIC_ZOOM_CALCULATOR", "Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;", "getNO_OP_INTRINSIC_ZOOM_CALCULATOR", "()Landroidx/camera/camera2/internal/IntrinsicZoomCalculator;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IntrinsicZoomCalculator NO_OP_INTRINSIC_ZOOM_CALCULATOR = new IntrinsicZoomCalculator() { // from class: androidx.camera.camera2.internal.IntrinsicZoomCalculator$Companion$NO_OP_INTRINSIC_ZOOM_CALCULATOR$1
            @Override // androidx.camera.camera2.internal.IntrinsicZoomCalculator
            public Float calculateIntrinsicZoomRatio(CameraMetadata cameraMetadata) {
                Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
                return Float.valueOf(1.0f);
            }
        };

        private Companion() {
        }

        public final IntrinsicZoomCalculator getNO_OP_INTRINSIC_ZOOM_CALCULATOR() {
            return NO_OP_INTRINSIC_ZOOM_CALCULATOR;
        }
    }
}
