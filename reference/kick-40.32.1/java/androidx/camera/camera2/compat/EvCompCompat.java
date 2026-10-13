package androidx.camera.camera2.compat;

import android.util.Range;
import android.util.Rational;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.datadog.android.rum.internal.RumFeature;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: EvCompCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0019J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/compat/EvCompCompat;", "", "supported", "", "getSupported", "()Z", "range", "Landroid/util/Range;", "", "getRange", "()Landroid/util/Range;", "step", "Landroid/util/Rational;", "getStep", "()Landroid/util/Rational;", "stopRunningTask", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "applyAsync", "Lkotlinx/coroutines/Deferred;", "evCompIndex", "requestControl", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "cancelPreviousTask", "Bindings", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface EvCompCompat {

    /* JADX INFO: compiled from: EvCompCompat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/compat/EvCompCompat$Bindings;", "", "<init>", "()V", "bindEvCompImpl", "Landroidx/camera/camera2/compat/EvCompCompat;", "impl", "Landroidx/camera/camera2/compat/EvCompImpl;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Module
    public static abstract class Bindings {
        @Binds
        public abstract EvCompCompat bindEvCompImpl(EvCompImpl impl);
    }

    Deferred<Integer> applyAsync(int evCompIndex, UseCaseCameraRequestControl requestControl, boolean cancelPreviousTask);

    Range<Integer> getRange();

    Rational getStep();

    boolean getSupported();

    void stopRunningTask(Throwable throwable);
}
