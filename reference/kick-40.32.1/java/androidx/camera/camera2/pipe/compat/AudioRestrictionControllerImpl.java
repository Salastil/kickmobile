package androidx.camera.camera2.pipe.compat;

import android.os.Build;
import androidx.camera.camera2.pipe.AudioRestrictionMode;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.config.CameraPipeJob;
import androidx.camera.camera2.pipe.core.CoroutineMutex;
import androidx.camera.camera2.pipe.core.MutexesKt;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: AudioRestrictionController.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B#\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0011H\u0016¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0002\b%J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001cH\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001cH\u0016J\u0017\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0002\b+R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/camera/camera2/pipe/compat/AudioRestrictionControllerImpl;", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraPipeLifetime", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeJob", "Lkotlinx/coroutines/Job;", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;Lkotlinx/coroutines/Job;)V", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/CoroutineScope;", "coroutineMutex", "Landroidx/camera/camera2/pipe/core/CoroutineMutex;", "lock", "", "value", "Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "globalAudioRestrictionMode", "getGlobalAudioRestrictionMode-4o0Og1A", "()Landroidx/camera/camera2/pipe/AudioRestrictionMode;", "setGlobalAudioRestrictionMode-3NUV5dA", "(Landroidx/camera/camera2/pipe/AudioRestrictionMode;)V", "audioRestrictionModeMap", "", "Landroidx/camera/camera2/pipe/CameraGraph;", "activeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/camera/camera2/pipe/compat/AudioRestrictionController$Listener;", "updateCameraGraphAudioRestrictionMode", "", "cameraGraph", "mode", "updateCameraGraphAudioRestrictionMode-TyYSX5E", "(Landroidx/camera/camera2/pipe/CameraGraph;I)V", "removeCameraGraph", "computeAudioRestrictionMode", "computeAudioRestrictionMode-4o0Og1A", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "updateListenersMode", "previousMode", "updateListenersMode-3NUV5dA", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioRestrictionControllerImpl implements AudioRestrictionController {
    private final CopyOnWriteArrayList<AudioRestrictionController.Listener> activeListeners;
    private final Map<CameraGraph, AudioRestrictionMode> audioRestrictionModeMap;
    private final CoroutineMutex coroutineMutex;
    private AudioRestrictionMode globalAudioRestrictionMode;
    private final Object lock;
    private final CoroutineScope scope;

    @Inject
    public AudioRestrictionControllerImpl(Threads threads, CameraPipeLifetime cameraPipeLifetime, @CameraPipeJob Job cameraPipeJob) {
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(cameraPipeLifetime, "cameraPipeLifetime");
        Intrinsics.checkNotNullParameter(cameraPipeJob, "cameraPipeJob");
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob(cameraPipeJob).plus(threads.getLightweightDispatcher().plus(new CoroutineName("CXCP-AudioRestrictionControllerImpl"))));
        this.coroutineMutex = new CoroutineMutex();
        this.lock = new Object();
        this.audioRestrictionModeMap = new LinkedHashMap();
        this.activeListeners = new CopyOnWriteArrayList<>();
        cameraPipeLifetime.addShutdownAction(CameraPipeLifetime.ShutdownType.SCOPE, new Runnable() { // from class: androidx.camera.camera2.pipe.compat.AudioRestrictionControllerImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CoroutineScopeKt.cancel$default(this.f$0.scope, null, 1, null);
            }
        });
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController
    /* JADX INFO: renamed from: getGlobalAudioRestrictionMode-4o0Og1A */
    public AudioRestrictionMode mo818getGlobalAudioRestrictionMode4o0Og1A() {
        AudioRestrictionMode audioRestrictionMode;
        synchronized (this.lock) {
            audioRestrictionMode = this.globalAudioRestrictionMode;
        }
        return audioRestrictionMode;
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController
    /* JADX INFO: renamed from: setGlobalAudioRestrictionMode-3NUV5dA */
    public void mo819setGlobalAudioRestrictionMode3NUV5dA(AudioRestrictionMode audioRestrictionMode) {
        if (audioRestrictionMode == null) {
            throw new IllegalArgumentException("Unsupported setting AudioRestrictionMode to null.".toString());
        }
        synchronized (this.lock) {
            AudioRestrictionMode audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A = m821computeAudioRestrictionMode4o0Og1A();
            this.globalAudioRestrictionMode = audioRestrictionMode;
            m822updateListenersMode3NUV5dA(audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController
    /* JADX INFO: renamed from: updateCameraGraphAudioRestrictionMode-TyYSX5E */
    public void mo820updateCameraGraphAudioRestrictionModeTyYSX5E(CameraGraph cameraGraph, int mode) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        synchronized (this.lock) {
            AudioRestrictionMode audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A = m821computeAudioRestrictionMode4o0Og1A();
            this.audioRestrictionModeMap.put(cameraGraph, AudioRestrictionMode.m187boximpl(mode));
            m822updateListenersMode3NUV5dA(audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController
    public void removeCameraGraph(CameraGraph cameraGraph) {
        Intrinsics.checkNotNullParameter(cameraGraph, "cameraGraph");
        synchronized (this.lock) {
            AudioRestrictionMode audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A = m821computeAudioRestrictionMode4o0Og1A();
            this.audioRestrictionModeMap.remove(cameraGraph);
            m822updateListenersMode3NUV5dA(audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: computeAudioRestrictionMode-4o0Og1A, reason: not valid java name */
    private final AudioRestrictionMode m821computeAudioRestrictionMode4o0Og1A() {
        if (!this.audioRestrictionModeMap.containsValue(AudioRestrictionMode.m187boximpl(AudioRestrictionMode.INSTANCE.m196getAUDIO_RESTRICTION_VIBRATION_SOUND_b5Q8KE()))) {
            AudioRestrictionMode audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A = mo818getGlobalAudioRestrictionMode4o0Og1A();
            if (!(audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A == null ? false : AudioRestrictionMode.m190equalsimpl0(audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A.m193unboximpl(), AudioRestrictionMode.INSTANCE.m196getAUDIO_RESTRICTION_VIBRATION_SOUND_b5Q8KE()))) {
                if (!this.audioRestrictionModeMap.containsValue(AudioRestrictionMode.m187boximpl(AudioRestrictionMode.INSTANCE.m195getAUDIO_RESTRICTION_VIBRATION_b5Q8KE()))) {
                    AudioRestrictionMode audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A2 = mo818getGlobalAudioRestrictionMode4o0Og1A();
                    if (!(audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A2 == null ? false : AudioRestrictionMode.m190equalsimpl0(audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A2.m193unboximpl(), AudioRestrictionMode.INSTANCE.m195getAUDIO_RESTRICTION_VIBRATION_b5Q8KE()))) {
                        if (!this.audioRestrictionModeMap.containsValue(AudioRestrictionMode.m187boximpl(AudioRestrictionMode.INSTANCE.m194getAUDIO_RESTRICTION_NONE_b5Q8KE()))) {
                            AudioRestrictionMode audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A3 = mo818getGlobalAudioRestrictionMode4o0Og1A();
                            if (!(audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A3 != null ? AudioRestrictionMode.m190equalsimpl0(audioRestrictionModeMo818getGlobalAudioRestrictionMode4o0Og1A3.m193unboximpl(), AudioRestrictionMode.INSTANCE.m194getAUDIO_RESTRICTION_NONE_b5Q8KE()) : false)) {
                                return null;
                            }
                        }
                        return AudioRestrictionMode.m187boximpl(AudioRestrictionMode.INSTANCE.m194getAUDIO_RESTRICTION_NONE_b5Q8KE());
                    }
                }
                return AudioRestrictionMode.m187boximpl(AudioRestrictionMode.INSTANCE.m195getAUDIO_RESTRICTION_VIBRATION_b5Q8KE());
            }
        }
        return AudioRestrictionMode.m187boximpl(AudioRestrictionMode.INSTANCE.m196getAUDIO_RESTRICTION_VIBRATION_SOUND_b5Q8KE());
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController
    public void addListener(AudioRestrictionController.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        synchronized (this.lock) {
            this.activeListeners.add(listener);
            AudioRestrictionMode audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A = m821computeAudioRestrictionMode4o0Og1A();
            if (audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A != null) {
                MutexesKt.withLockLaunch(this.coroutineMutex, this.scope, new AudioRestrictionControllerImpl$addListener$1$1(listener, audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A, null));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.AudioRestrictionController
    public void removeListener(AudioRestrictionController.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (Build.VERSION.SDK_INT < 30) {
            return;
        }
        this.activeListeners.remove(listener);
    }

    /* JADX INFO: renamed from: updateListenersMode-3NUV5dA, reason: not valid java name */
    private final void m822updateListenersMode3NUV5dA(AudioRestrictionMode previousMode) {
        AudioRestrictionMode audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A = m821computeAudioRestrictionMode4o0Og1A();
        if (audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A == null || Intrinsics.areEqual(audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A, previousMode)) {
            return;
        }
        MutexesKt.withLockLaunch(this.coroutineMutex, this.scope, new AudioRestrictionControllerImpl$updateListenersMode$1(this, audioRestrictionModeM821computeAudioRestrictionMode4o0Og1A, null));
    }
}
