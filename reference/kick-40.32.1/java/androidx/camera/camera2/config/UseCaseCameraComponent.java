package androidx.camera.camera2.config;

import androidx.camera.camera2.impl.UseCaseCamera;
import dagger.Subcomponent;
import kotlin.Metadata;

/* JADX INFO: compiled from: UseCaseCameraConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Subcomponent(modules = {UseCaseCameraModule.class, UseCaseCameraConfig.class})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/config/UseCaseCameraComponent;", "", "getUseCaseCamera", "Landroidx/camera/camera2/impl/UseCaseCamera;", "getUseCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "Builder", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public interface UseCaseCameraComponent {

    /* JADX INFO: compiled from: UseCaseCameraConfig.kt */
    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/config/UseCaseCameraComponent$Builder;", "", "config", "Landroidx/camera/camera2/config/UseCaseCameraConfig;", "build", "Landroidx/camera/camera2/config/UseCaseCameraComponent;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Builder {
        UseCaseCameraComponent build();

        Builder config(UseCaseCameraConfig config);
    }

    UseCaseCamera getUseCaseCamera();

    UseCaseGraphContext getUseCaseGraphContext();
}
