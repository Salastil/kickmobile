package androidx.camera.camera2.pipe.internal;

import android.content.Context;
import androidx.camera.camera2.pipe.CameraBackend;
import androidx.camera.camera2.pipe.CameraBackendFactory;
import androidx.camera.camera2.pipe.CameraBackendId;
import androidx.camera.camera2.pipe.CameraBackends;
import androidx.camera.camera2.pipe.CameraContext;
import androidx.camera.camera2.pipe.config.CameraPipeContext;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Threads;
import com.facebook.hermes.intl.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: CameraBackendsImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001%B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u0004\u0018\u00010\u00142\u0006\u0010\"\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b#\u0010$R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006&"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraBackendsImpl;", "Landroidx/camera/camera2/pipe/CameraBackends;", "defaultBackendId", "Landroidx/camera/camera2/pipe/CameraBackendId;", "cameraBackends", "", "Landroidx/camera/camera2/pipe/CameraBackendFactory;", "cameraPipeContext", "Landroid/content/Context;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraPipeLifetime", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "<init>", "(Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/String;", "lock", "", "activeCameraBackends", "", "Landroidx/camera/camera2/pipe/CameraBackend;", Constants.COLLATION_DEFAULT, "getDefault", "()Landroidx/camera/camera2/pipe/CameraBackend;", "allIds", "", "getAllIds", "()Ljava/util/Set;", "activeIds", "getActiveIds", "shutdown", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "backendId", "get-SG3A4s8", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraBackend;", "CameraBackendContext", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraBackendsImpl implements CameraBackends {
    private final Map<CameraBackendId, CameraBackend> activeCameraBackends;
    private final Map<CameraBackendId, CameraBackendFactory> cameraBackends;
    private final Context cameraPipeContext;
    private final CameraBackend default;
    private final String defaultBackendId;
    private final Object lock;
    private final Threads threads;

    public /* synthetic */ CameraBackendsImpl(String str, Map map, @CameraPipeContext Context context, Threads threads, CameraPipeLifetime cameraPipeLifetime, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, context, threads, cameraPipeLifetime);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CameraBackendsImpl(String defaultBackendId, Map<CameraBackendId, ? extends CameraBackendFactory> cameraBackends, Context cameraPipeContext, Threads threads, CameraPipeLifetime cameraPipeLifetime) {
        Intrinsics.checkNotNullParameter(defaultBackendId, "defaultBackendId");
        Intrinsics.checkNotNullParameter(cameraBackends, "cameraBackends");
        Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(cameraPipeLifetime, "cameraPipeLifetime");
        this.defaultBackendId = defaultBackendId;
        this.cameraBackends = cameraBackends;
        this.cameraPipeContext = cameraPipeContext;
        this.threads = threads;
        this.lock = new Object();
        this.activeCameraBackends = new LinkedHashMap();
        cameraPipeLifetime.addShutdownAction(CameraPipeLifetime.ShutdownType.CAMERA, new Runnable() { // from class: androidx.camera.camera2.pipe.internal.CameraBackendsImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                BuildersKt__BuildersKt.runBlocking$default(null, new CameraBackendsImpl$1$1(this.f$0, null), 1, null);
            }
        });
        CameraBackend cameraBackendMo242getSG3A4s8 = mo242getSG3A4s8(defaultBackendId);
        if (cameraBackendMo242getSG3A4s8 != null) {
            this.default = cameraBackendMo242getSG3A4s8;
            return;
        }
        throw new IllegalStateException(("Failed to load the default backend for " + ((Object) CameraBackendId.m240toStringimpl(defaultBackendId)) + "! Available backends are " + cameraBackends.keySet()).toString());
    }

    @Override // androidx.camera.camera2.pipe.CameraBackends
    public CameraBackend getDefault() {
        return this.default;
    }

    @Override // androidx.camera.camera2.pipe.CameraBackends
    public Set<CameraBackendId> getAllIds() {
        return this.cameraBackends.keySet();
    }

    @Override // androidx.camera.camera2.pipe.CameraBackends
    public Set<CameraBackendId> getActiveIds() {
        Set<CameraBackendId> setKeySet;
        synchronized (this.lock) {
            setKeySet = this.activeCameraBackends.keySet();
        }
        return setKeySet;
    }

    @Override // androidx.camera.camera2.pipe.CameraBackends
    public Object shutdown(Continuation<? super Unit> continuation) {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "CameraBackends#shutdown");
        }
        Map<CameraBackendId, CameraBackend> map = this.activeCameraBackends;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<CameraBackendId, CameraBackend>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue().shutdownAsync());
        }
        Object objJoinAll = AwaitKt.joinAll(arrayList, continuation);
        return objJoinAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoinAll : Unit.INSTANCE;
    }

    @Override // androidx.camera.camera2.pipe.CameraBackends
    /* JADX INFO: renamed from: get-SG3A4s8 */
    public CameraBackend mo242getSG3A4s8(String backendId) {
        Intrinsics.checkNotNullParameter(backendId, "backendId");
        synchronized (this.lock) {
            CameraBackend cameraBackend = this.activeCameraBackends.get(CameraBackendId.m235boximpl(backendId));
            if (cameraBackend != null) {
                return cameraBackend;
            }
            CameraBackendFactory cameraBackendFactory = this.cameraBackends.get(CameraBackendId.m235boximpl(backendId));
            CameraBackend cameraBackendCreate = cameraBackendFactory != null ? cameraBackendFactory.create(new CameraBackendContext(this.cameraPipeContext, this.threads, this)) : null;
            if (cameraBackendCreate != null) {
                if (!CameraBackendId.m238equalsimpl0(backendId, cameraBackendCreate.mo226getIdQwmhuAM())) {
                    throw new IllegalStateException(("Unexpected backend id! Expected " + ((Object) CameraBackendId.m240toStringimpl(backendId)) + " but it was actually " + ((Object) CameraBackendId.m240toStringimpl(cameraBackendCreate.mo226getIdQwmhuAM()))).toString());
                }
                this.activeCameraBackends.put(CameraBackendId.m235boximpl(backendId), cameraBackendCreate);
            }
            return cameraBackendCreate;
        }
    }

    /* JADX INFO: compiled from: CameraBackendsImpl.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraBackendsImpl$CameraBackendContext;", "Landroidx/camera/camera2/pipe/CameraContext;", "appContext", "Landroid/content/Context;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "cameraBackends", "Landroidx/camera/camera2/pipe/CameraBackends;", "<init>", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraBackends;)V", "getAppContext", "()Landroid/content/Context;", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", "getCameraBackends", "()Landroidx/camera/camera2/pipe/CameraBackends;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CameraBackendContext implements CameraContext {
        private final Context appContext;
        private final CameraBackends cameraBackends;
        private final Threads threads;

        public CameraBackendContext(Context appContext, Threads threads, CameraBackends cameraBackends) {
            Intrinsics.checkNotNullParameter(appContext, "appContext");
            Intrinsics.checkNotNullParameter(threads, "threads");
            Intrinsics.checkNotNullParameter(cameraBackends, "cameraBackends");
            this.appContext = appContext;
            this.threads = threads;
            this.cameraBackends = cameraBackends;
        }

        @Override // androidx.camera.camera2.pipe.CameraContext
        public Context getAppContext() {
            return this.appContext;
        }

        @Override // androidx.camera.camera2.pipe.CameraContext
        public Threads getThreads() {
            return this.threads;
        }

        @Override // androidx.camera.camera2.pipe.CameraContext
        public CameraBackends getCameraBackends() {
            return this.cameraBackends;
        }
    }
}
