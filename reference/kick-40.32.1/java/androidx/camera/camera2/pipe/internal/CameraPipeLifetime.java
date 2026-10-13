package androidx.camera.camera2.pipe.internal;

import androidx.camera.camera2.pipe.config.CameraPipeJob;
import androidx.camera.camera2.pipe.core.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: CameraPipeLifetime.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bJ\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "", "cameraPipeJob", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "cameraLock", "isCameraShutdown", "", "cameraShutdownActions", "", "Ljava/lang/Runnable;", "scopeLock", "isScopeShutdown", "scopeShutdownActions", "threadLock", "isThreadShutdown", "threadShutdownActions", "addShutdownAction", "", "shutdownType", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime$ShutdownType;", "shutdownAction", "addCameraShutdownAction", "addScopeShutdownAction", "addThreadShutdownAction", "shutdown", "shutdownCamera", "shutdownScope", "()Lkotlin/Unit;", "shutdownThread", "ShutdownType", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraPipeLifetime {
    private static final long CAMERA_PIPE_JOB_CANCEL_TIMEOUT_MS = 3000;
    private final Object cameraLock;
    private final Job cameraPipeJob;
    private final List<Runnable> cameraShutdownActions;
    private boolean isCameraShutdown;
    private boolean isScopeShutdown;
    private boolean isThreadShutdown;
    private final Object scopeLock;
    private final List<Runnable> scopeShutdownActions;
    private final Object threadLock;
    private final List<Runnable> threadShutdownActions;

    /* JADX INFO: compiled from: CameraPipeLifetime.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime$ShutdownType;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "SCOPE", "THREAD", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ShutdownType {
        CAMERA,
        SCOPE,
        THREAD;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ShutdownType> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: compiled from: CameraPipeLifetime.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShutdownType.values().length];
            try {
                iArr[ShutdownType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShutdownType.SCOPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShutdownType.THREAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public CameraPipeLifetime(@CameraPipeJob Job cameraPipeJob) {
        Intrinsics.checkNotNullParameter(cameraPipeJob, "cameraPipeJob");
        this.cameraPipeJob = cameraPipeJob;
        this.cameraLock = new Object();
        this.cameraShutdownActions = new ArrayList();
        this.scopeLock = new Object();
        this.scopeShutdownActions = new ArrayList();
        this.threadLock = new Object();
        this.threadShutdownActions = new ArrayList();
    }

    public final void addShutdownAction(ShutdownType shutdownType, Runnable shutdownAction) {
        boolean zAddCameraShutdownAction;
        Intrinsics.checkNotNullParameter(shutdownType, "shutdownType");
        Intrinsics.checkNotNullParameter(shutdownAction, "shutdownAction");
        int i = WhenMappings.$EnumSwitchMapping$0[shutdownType.ordinal()];
        if (i == 1) {
            zAddCameraShutdownAction = addCameraShutdownAction(shutdownAction);
        } else if (i == 2) {
            zAddCameraShutdownAction = addScopeShutdownAction(shutdownAction);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            zAddCameraShutdownAction = addThreadShutdownAction(shutdownAction);
        }
        if (zAddCameraShutdownAction) {
            return;
        }
        if (Log.INSTANCE.getERROR_LOGGABLE()) {
            android.util.Log.e(Log.TAG, "CameraPipeLifetime already shut down. This is unexpected. Executing " + shutdownType + " shutdown action immediately...");
        }
        shutdownAction.run();
    }

    private final boolean addCameraShutdownAction(Runnable shutdownAction) {
        boolean zAdd;
        synchronized (this.cameraLock) {
            zAdd = this.isCameraShutdown ? false : this.cameraShutdownActions.add(shutdownAction);
        }
        return zAdd;
    }

    private final boolean addScopeShutdownAction(Runnable shutdownAction) {
        boolean zAdd;
        synchronized (this.scopeLock) {
            zAdd = this.isScopeShutdown ? false : this.scopeShutdownActions.add(shutdownAction);
        }
        return zAdd;
    }

    private final boolean addThreadShutdownAction(Runnable shutdownAction) {
        boolean zAdd;
        synchronized (this.threadLock) {
            zAdd = this.isThreadShutdown ? false : this.threadShutdownActions.add(shutdownAction);
        }
        return zAdd;
    }

    public final void shutdown() {
        shutdownCamera();
        shutdownScope();
        shutdownThread();
    }

    private final void shutdownCamera() {
        synchronized (this.cameraLock) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Shutting down cameras...");
            }
            Iterator<Runnable> it = this.cameraShutdownActions.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final Unit shutdownScope() {
        Unit unit;
        synchronized (this.scopeLock) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Shutting down scopes...");
            }
            Iterator<Runnable> it = this.scopeShutdownActions.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            unit = (Unit) BuildersKt__BuildersKt.runBlocking$default(null, new CameraPipeLifetime$shutdownScope$1$2(this, null), 1, null);
        }
        return unit;
    }

    private final void shutdownThread() {
        synchronized (this.threadLock) {
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Shutting down threads...");
            }
            Iterator<Runnable> it = this.threadShutdownActions.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
