package androidx.camera.camera2.pipe;

import android.view.Surface;
import androidx.camera.camera2.pipe.core.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;

/* JADX INFO: compiled from: CameraSurfaceManager.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0019\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0014J\u0019\u0010\u0015\u001a\u00020\r2\n\u0010\u0016\u001a\u00060\u0017R\u00020\u0000H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/camera/camera2/pipe/CameraSurfaceManager;", "", "<init>", "()V", "lock", "useCountMap", "", "Landroid/view/Surface;", "", "listeners", "", "Landroidx/camera/camera2/pipe/CameraSurfaceManager$SurfaceListener;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "registerSurface", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "surface", "registerSurface$camera_camera2_pipe", "onTokenClosed", "surfaceToken", "Landroidx/camera/camera2/pipe/CameraSurfaceManager$SurfaceToken;", "onTokenClosed$camera_camera2_pipe", "SurfaceToken", "SurfaceListener", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraSurfaceManager {
    public static final boolean DEBUG = false;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInt surfaceTokenDebugIds = AtomicFU.atomic(0);
    private final Object lock = new Object();
    private final Map<Surface, Integer> useCountMap = new LinkedHashMap();
    private final Set<SurfaceListener> listeners = new LinkedHashSet();

    /* JADX INFO: compiled from: CameraSurfaceManager.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/CameraSurfaceManager$SurfaceListener;", "", "onSurfaceActive", "", "surface", "Landroid/view/Surface;", "onSurfaceInactive", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SurfaceListener {
        void onSurfaceActive(Surface surface);

        void onSurfaceInactive(Surface surface);
    }

    /* JADX INFO: compiled from: CameraSurfaceManager.kt */
    @kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/camera/camera2/pipe/CameraSurfaceManager$SurfaceToken;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "surface", "Landroid/view/Surface;", "<init>", "(Landroidx/camera/camera2/pipe/CameraSurfaceManager;Landroid/view/Surface;)V", "getSurface$camera_camera2_pipe", "()Landroid/view/Surface;", "debugId", "", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "close", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SurfaceToken implements AutoCloseable {
        private final AtomicBoolean closed;
        private final int debugId;
        private final Surface surface;
        final /* synthetic */ CameraSurfaceManager this$0;

        public SurfaceToken(CameraSurfaceManager cameraSurfaceManager, Surface surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            this.this$0 = cameraSurfaceManager;
            this.surface = surface;
            this.debugId = CameraSurfaceManager.INSTANCE.getSurfaceTokenDebugIds$camera_camera2_pipe().incrementAndGet();
            this.closed = AtomicFU.atomic(false);
        }

        /* JADX INFO: renamed from: getSurface$camera_camera2_pipe, reason: from getter */
        public final Surface getSurface() {
            return this.surface;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed.compareAndSet(false, true)) {
                this.this$0.onTokenClosed$camera_camera2_pipe(this);
            }
        }

        public String toString() {
            return "SurfaceToken-" + this.debugId;
        }
    }

    public final void addListener(SurfaceListener listener) {
        Set setKeySet;
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            this.listeners.add(listener);
            Map<Surface, Integer> map = this.useCountMap;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Surface, Integer> entry : map.entrySet()) {
                if (entry.getValue().intValue() > 0) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            setKeySet = linkedHashMap.keySet();
        }
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            listener.onSurfaceActive((Surface) it.next());
        }
    }

    public final void removeListener(SurfaceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.lock) {
            this.listeners.remove(listener);
        }
    }

    public final AutoCloseable registerSurface$camera_camera2_pipe(Surface surface) {
        SurfaceToken surfaceToken;
        List list;
        Intrinsics.checkNotNullParameter(surface, "surface");
        if (!surface.isValid() && Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "registerSurface: Surface " + surface + " isn't valid!");
        }
        synchronized (this.lock) {
            surfaceToken = new SurfaceToken(this, surface);
            Integer num = this.useCountMap.get(surface);
            int iIntValue = (num != null ? num.intValue() : 0) + 1;
            this.useCountMap.put(surface, Integer.valueOf(iIntValue));
            list = iIntValue == 1 ? CollectionsKt.toList(this.listeners) : null;
            Unit unit = Unit.INSTANCE;
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).onSurfaceActive(surface);
            }
        }
        return surfaceToken;
    }

    public final void onTokenClosed$camera_camera2_pipe(SurfaceToken surfaceToken) {
        Surface surface;
        List list;
        Intrinsics.checkNotNullParameter(surfaceToken, "surfaceToken");
        synchronized (this.lock) {
            surface = surfaceToken.getSurface();
            Integer num = this.useCountMap.get(surface);
            if (num == null) {
                throw new IllegalStateException(("Surface " + surface + " (" + surfaceToken + ") has no use count").toString());
            }
            int iIntValue = num.intValue() - 1;
            this.useCountMap.put(surface, Integer.valueOf(iIntValue));
            if (iIntValue == 0) {
                list = CollectionsKt.toList(this.listeners);
                this.useCountMap.remove(surface);
            } else {
                list = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((SurfaceListener) it.next()).onSurfaceInactive(surface);
            }
        }
    }

    /* JADX INFO: compiled from: CameraSurfaceManager.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/CameraSurfaceManager$Companion;", "", "<init>", "()V", "DEBUG", "", "surfaceTokenDebugIds", "Lkotlinx/atomicfu/AtomicInt;", "getSurfaceTokenDebugIds$camera_camera2_pipe", "()Lkotlinx/atomicfu/AtomicInt;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AtomicInt getSurfaceTokenDebugIds$camera_camera2_pipe() {
            return CameraSurfaceManager.surfaceTokenDebugIds;
        }
    }
}
