package androidx.camera.camera2.pipe.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.pipe.Parameters;
import androidx.camera.camera2.pipe.config.CameraGraphScope;
import androidx.camera.camera2.pipe.config.ForCameraGraph;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Token;
import androidx.camera.camera2.pipe.graph.GraphProcessor;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CameraGraphParametersImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraGraphScope
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B#\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ$\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0014J$\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0015H\u0096\u0002¢\u0006\u0002\u0010\u0016J0\u0010\u0017\u001a\u00020\u0018\"\b\b\u0000\u0010\u0011*\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00132\b\u0010\u0019\u001a\u0004\u0018\u0001H\u0011H\u0096\u0002¢\u0006\u0002\u0010\u001aJ0\u0010\u0017\u001a\u00020\u0018\"\b\b\u0000\u0010\u0011*\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00152\b\u0010\u0019\u001a\u0004\u0018\u0001H\u0011H\u0096\u0002¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00182\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001eH\u0016J0\u0010\u001f\u001a\u00020\u000f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r2\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0003J\b\u0010!\u001a\u00020\u0018H\u0016J\u001c\u0010\"\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0016J\u001c\u0010\"\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0015H\u0016J\u0014\u0010#\u001a\u00020\u000f2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0003J\b\u0010(\u001a\u00020\u0018H\u0002J\u0006\u0010)\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraGraphParametersImpl;", "Landroidx/camera/camera2/pipe/Parameters;", "sessionLock", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/GraphProcessor;", "graphScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroidx/camera/camera2/pipe/internal/GraphSessionLock;Landroidx/camera/camera2/pipe/graph/GraphProcessor;Lkotlinx/coroutines/CoroutineScope;)V", "lock", "", "parameters", "", "dirty", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CaptureRequest$Key;", "(Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Object;", "Landroidx/camera/camera2/pipe/Metadata$Key;", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "set", "", "value", "(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V", "(Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)V", "setAll", "newParameters", "", "modify", "map", "clear", "remove", "removeAll", UserMetadata.KEYDATA_FILENAME, "", "shouldApplyUpdate", "modified", "applyUpdate", "flush", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraGraphParametersImpl implements Parameters {
    private boolean dirty;
    private final GraphProcessor graphProcessor;
    private final CoroutineScope graphScope;
    private final Object lock;
    private final Map<Object, Object> parameters;
    private final GraphSessionLock sessionLock;

    @Inject
    public CameraGraphParametersImpl(GraphSessionLock sessionLock, GraphProcessor graphProcessor, @ForCameraGraph CoroutineScope graphScope) {
        Intrinsics.checkNotNullParameter(sessionLock, "sessionLock");
        Intrinsics.checkNotNullParameter(graphProcessor, "graphProcessor");
        Intrinsics.checkNotNullParameter(graphScope, "graphScope");
        this.sessionLock = sessionLock;
        this.graphProcessor = graphProcessor;
        this.graphScope = graphScope;
        this.lock = new Object();
        this.parameters = new LinkedHashMap();
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public <T> T get(CaptureRequest.Key<T> key) {
        T t;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            t = (T) this.parameters.get(key);
        }
        return t;
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public <T> T get(androidx.camera.camera2.pipe.Metadata.Key<T> key) {
        T t;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            t = (T) this.parameters.get(key);
        }
        return t;
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public <T> void set(CaptureRequest.Key<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        setAll(MapsKt.mapOf(TuplesKt.to(key, value)));
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public <T> void set(androidx.camera.camera2.pipe.Metadata.Key<T> key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        setAll(MapsKt.mapOf(TuplesKt.to(key, value)));
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public void setAll(Map<Object, ? extends Object> newParameters) {
        boolean z;
        boolean zShouldApplyUpdate;
        Intrinsics.checkNotNullParameter(newParameters, "newParameters");
        synchronized (this.lock) {
            Iterator<Map.Entry<Object, ? extends Object>> it = newParameters.entrySet().iterator();
            loop0: while (true) {
                z = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    Map.Entry<Object, ? extends Object> next = it.next();
                    if (modify(this.parameters, next.getKey(), next.getValue()) || z) {
                        z = true;
                    }
                }
            }
            zShouldApplyUpdate = shouldApplyUpdate(z);
        }
        if (zShouldApplyUpdate) {
            applyUpdate();
        }
    }

    private final boolean modify(Map<Object, Object> map, Object key, Object value) {
        if ((key instanceof CaptureRequest.Key) || (key instanceof androidx.camera.camera2.pipe.Metadata.Key)) {
            if (map.containsKey(key) && Intrinsics.areEqual(map.get(key), value)) {
                return false;
            }
            map.put(key, value);
            return true;
        }
        if (Log.INSTANCE.getWARN_LOGGABLE()) {
            android.util.Log.w(Log.TAG, "Skipping set parameter (key=" + key + ", value=" + value + "). " + key + " is not a valid parameter type.");
        }
        return false;
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public void clear() {
        boolean zShouldApplyUpdate;
        synchronized (this.lock) {
            if (this.parameters.isEmpty()) {
                zShouldApplyUpdate = false;
            } else {
                this.parameters.clear();
                zShouldApplyUpdate = shouldApplyUpdate(true);
            }
        }
        if (zShouldApplyUpdate) {
            applyUpdate();
        }
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public <T> boolean remove(CaptureRequest.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return removeAll(SetsKt.setOf(key));
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public <T> boolean remove(androidx.camera.camera2.pipe.Metadata.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return removeAll(SetsKt.setOf(key));
    }

    @Override // androidx.camera.camera2.pipe.Parameters
    public boolean removeAll(Set<?> keys) {
        boolean z;
        boolean zShouldApplyUpdate;
        Intrinsics.checkNotNullParameter(keys, "keys");
        synchronized (this.lock) {
            z = false;
            for (Object obj : keys) {
                if (this.parameters.containsKey(obj)) {
                    TypeIntrinsics.asMutableMap(this.parameters).remove(obj);
                    z = true;
                }
                if (!(obj instanceof CaptureRequest.Key) && !(obj instanceof androidx.camera.camera2.pipe.Metadata.Key) && Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Skipping removing parameter with key " + obj + ". " + obj + " is not a valid parameter type.");
                }
            }
            zShouldApplyUpdate = shouldApplyUpdate(z);
        }
        if (zShouldApplyUpdate) {
            applyUpdate();
        }
        return z;
    }

    private final boolean shouldApplyUpdate(boolean modified) {
        if (!modified || this.dirty) {
            return false;
        }
        this.dirty = true;
        return true;
    }

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.internal.CameraGraphParametersImpl$applyUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: CameraGraphParametersImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/camera/camera2/pipe/core/Token;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.internal.CameraGraphParametersImpl$applyUpdate$1", f = "CameraGraphParametersImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Token, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CameraGraphParametersImpl.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Token token, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(token, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CameraGraphParametersImpl.this.flush();
            return Unit.INSTANCE;
        }
    }

    private final void applyUpdate() {
        this.sessionLock.withTokenIn$camera_camera2_pipe(this.graphScope, new AnonymousClass1(null));
    }

    public final void flush() {
        synchronized (this.lock) {
            if (this.dirty) {
                this.dirty = false;
                this.graphProcessor.updateGraphParameters(new HashMap(this.parameters));
            }
        }
    }
}
