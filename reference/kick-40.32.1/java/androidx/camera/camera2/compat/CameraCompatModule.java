package androidx.camera.camera2.compat;

import androidx.camera.camera2.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.compat.workaround.InactiveSurfaceCloser;
import androidx.camera.camera2.compat.workaround.MeteringRegionCorrection;
import androidx.camera.camera2.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.compat.workaround.UseFlashModeTorchFor3aUpdate;
import androidx.camera.camera2.compat.workaround.UseTorchAsFlash;
import dagger.Module;
import kotlin.Metadata;

/* JADX INFO: compiled from: CameraCompatModule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/camera/camera2/compat/CameraCompatModule;", "", "<init>", "()V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module(includes = {AutoFlashAEModeDisabler.Bindings.class, InactiveSurfaceCloser.Bindings.class, MeteringRegionCorrection.Bindings.class, UseFlashModeTorchFor3aUpdate.Bindings.class, UseTorchAsFlash.Bindings.class, TemplateParamsOverride.Bindings.class})
public abstract class CameraCompatModule {
}
