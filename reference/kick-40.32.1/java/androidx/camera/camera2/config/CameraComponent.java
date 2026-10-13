package androidx.camera.camera2.config;

import androidx.camera.camera2.compat.CameraCompatModule;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.StreamSpecsCalculator;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;

/* JADX INFO: compiled from: CameraConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Subcomponent(modules = {CameraModule.class, CameraConfig.class, CameraCompatModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/config/CameraComponent;", "", "getCameraInternal", "Landroidx/camera/core/impl/CameraInternal;", "Builder", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface CameraComponent {

    /* JADX INFO: compiled from: CameraConfig.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/config/CameraComponent$Builder;", "", "config", "Landroidx/camera/camera2/config/CameraConfig;", "streamSpecsCalculator", "Landroidx/camera/core/internal/StreamSpecsCalculator;", "build", "Landroidx/camera/camera2/config/CameraComponent;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Builder {
        CameraComponent build();

        Builder config(CameraConfig config);

        @BindsInstance
        Builder streamSpecsCalculator(StreamSpecsCalculator streamSpecsCalculator);
    }

    CameraInternal getCameraInternal();
}
