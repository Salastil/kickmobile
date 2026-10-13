package androidx.camera.core;

import android.content.Context;
import android.view.OrientationEventListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RotationProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 #2\u00020\u0001:\u0003!\"#B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011H\u0007J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, d2 = {"Landroidx/camera/core/RotationProvider;", "", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "ignoreCanDetectForTest", "", "(Landroid/content/Context;Z)V", "lock", "orientationListener", "Landroid/view/OrientationEventListener;", "listeners", "", "Landroidx/camera/core/RotationProvider$Listener;", "Landroidx/camera/core/RotationProvider$ListenerWrapper;", "rotation", "", "value", "isShutdown", "()Z", "updateRotation", "", "newRotation", "updateOrientationForTesting", "orientation", "addListener", "executor", "Ljava/util/concurrent/Executor;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "shutdown", "orientationToSurfaceRotation", "Listener", "ListenerWrapper", "Companion", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RotationProvider {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "RotationProvider";
    private final boolean ignoreCanDetectForTest;
    private boolean isShutdown;
    private final Map<Listener, ListenerWrapper> listeners;
    private final Object lock;
    private final OrientationEventListener orientationListener;
    private volatile int rotation;

    /* JADX INFO: compiled from: RotationProvider.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/camera/core/RotationProvider$Listener;", "", "onRotationChanged", "", "rotation", "", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Listener {
        void onRotationChanged(int rotation);
    }

    /* JADX INFO: renamed from: isShutdown, reason: from getter */
    public final boolean getIsShutdown() {
        return this.isShutdown;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RotationProvider(Context appContext) {
        this(appContext, false);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    public RotationProvider(Context appContext, boolean z) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.lock = new Object();
        this.listeners = new LinkedHashMap();
        this.rotation = -1;
        this.ignoreCanDetectForTest = z;
        this.orientationListener = new OrientationEventListener(appContext) { // from class: androidx.camera.core.RotationProvider.1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                if (orientation == -1) {
                    return;
                }
                this.updateRotation(this.orientationToSurfaceRotation(orientation));
            }
        };
    }

    public /* synthetic */ RotationProvider(Context context, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRotation(int newRotation) {
        List list;
        if (this.rotation != newRotation) {
            this.rotation = newRotation;
            synchronized (this.lock) {
                list = CollectionsKt.toList(this.listeners.values());
                Unit unit = Unit.INSTANCE;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ListenerWrapper) it.next()).onRotationChanged(newRotation);
            }
        }
    }

    public final void updateOrientationForTesting(int orientation) {
        updateRotation(orientationToSurfaceRotation(orientation));
    }

    public final boolean addListener(Executor executor, Listener listener) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            if (!this.ignoreCanDetectForTest && !this.orientationListener.canDetectOrientation()) {
                return false;
            }
            ListenerWrapper listenerWrapper = new ListenerWrapper(listener, executor);
            this.listeners.put(listener, listenerWrapper);
            if (this.rotation != -1) {
                listenerWrapper.onRotationChanged(this.rotation);
            }
            if (this.listeners.size() == 1) {
                this.orientationListener.enable();
            }
            Unit unit = Unit.INSTANCE;
            return true;
        }
    }

    public final void removeListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            ListenerWrapper listenerWrapper = this.listeners.get(listener);
            if (listenerWrapper != null) {
                listenerWrapper.disable();
                this.listeners.remove(listener);
            }
            if (this.listeners.isEmpty()) {
                this.orientationListener.disable();
                this.rotation = -1;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void shutdown() {
        synchronized (this.lock) {
            this.orientationListener.disable();
            this.listeners.clear();
            this.isShutdown = true;
            this.rotation = -1;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int orientationToSurfaceRotation(int orientation) {
        if (this.rotation == -1) {
            if (orientation >= 0 && orientation < 45) {
                return 0;
            }
            if (45 <= orientation && orientation < 135) {
                return 3;
            }
            if (135 > orientation || orientation >= 225) {
                return (225 > orientation || orientation >= 315) ? 0 : 1;
            }
            return 2;
        }
        if ((orientation >= 0 && orientation < 40) || (320 <= orientation && orientation < 360)) {
            return 0;
        }
        if (50 <= orientation && orientation < 130) {
            return 3;
        }
        if (140 <= orientation && orientation < 220) {
            return 2;
        }
        if (230 > orientation || orientation >= 310) {
            return this.rotation;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RotationProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/camera/core/RotationProvider$ListenerWrapper;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroidx/camera/core/RotationProvider$Listener;", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Landroidx/camera/core/RotationProvider$Listener;Ljava/util/concurrent/Executor;)V", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onRotationChanged", "", "rotation", "", "disable", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class ListenerWrapper {
        private final AtomicBoolean enabled;
        private final Executor executor;
        private final Listener listener;

        public ListenerWrapper(Listener listener, Executor executor) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Intrinsics.checkNotNullParameter(executor, "executor");
            this.listener = listener;
            this.executor = executor;
            this.enabled = new AtomicBoolean(true);
        }

        public final void onRotationChanged(final int rotation) {
            if (this.enabled.get()) {
                try {
                    this.executor.execute(new Runnable() { // from class: androidx.camera.core.RotationProvider$ListenerWrapper$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            RotationProvider.ListenerWrapper.onRotationChanged$lambda$0(this.f$0, rotation);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                    Logger.w(RotationProvider.TAG, "Failed to execute the command. Maybe the executor has been shutdown.");
                }
            }
        }

        static final void onRotationChanged$lambda$0(ListenerWrapper listenerWrapper, int i) {
            if (listenerWrapper.enabled.get()) {
                listenerWrapper.listener.onRotationChanged(i);
            }
        }

        public final void disable() {
            this.enabled.set(false);
        }
    }

    /* JADX INFO: compiled from: RotationProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/camera/core/RotationProvider$Companion;", "", "<init>", "()V", "TAG", "", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
