package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.config.UseCaseCameraScope;
import androidx.camera.camera2.config.UseCaseGraphContext;
import androidx.camera.camera2.pipe.AeMode;
import androidx.camera.camera2.pipe.AfMode;
import androidx.camera.camera2.pipe.AwbMode;
import androidx.camera.camera2.pipe.CameraControls3A;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.RequestTemplate;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import com.datadog.android.ndk.internal.NdkCrashLog;
import com.datadog.android.rum.internal.RumFeature;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: UseCaseCameraState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002ABB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0092\u0001\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0)2\u001a\b\u0002\u0010*\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020\u00122\u001a\b\u0002\u0010-\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\b\b\u0002\u0010.\u001a\u00020\u00122\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u000100H\u0086@¢\u0006\u0004\b3\u00104J|\u00105\u001a\u00020\u000b2\u0018\u0010*\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00122\u0018\u0010-\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\u0006\u0010.\u001a\u00020\u00122\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010\u001e2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u000100H\u0083\b¢\u0006\u0002\b6J\u000e\u00107\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u00108J\u000e\u00109\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u00108J\u0006\u0010:\u001a\u00020\u000bJ&\u0010;\u001a\u00020\u000b*\u00020<2\u0018\u0010*\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010+H\u0002J1\u0010=\u001a\u0004\u0018\u00010>*\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010+2\n\u0010?\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002¢\u0006\u0002\u0010@R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u00010\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0017\u0012\u0004\u0012\u00020\u00010\u00148\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00198\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00060&R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraState;", "", "useCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "templateParamsOverride", "Landroidx/camera/camera2/compat/workaround/TemplateParamsOverride;", "<init>", "(Landroidx/camera/camera2/config/UseCaseGraphContext;Landroidx/camera/camera2/compat/workaround/TemplateParamsOverride;)V", "lock", "updateSignal", "Lkotlinx/coroutines/CompletableDeferred;", "", "submittedRequestCounter", "Lkotlinx/atomicfu/AtomicInt;", "updateSignals", "Lkotlin/collections/ArrayDeque;", "Landroidx/camera/camera2/impl/UseCaseCameraState$RequestSignal;", "updating", "", "currentParameters", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "currentInternalParameters", "Landroidx/camera/camera2/pipe/Metadata$Key;", "currentStreams", "", "Landroidx/camera/camera2/pipe/StreamId;", "currentListeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "currentTemplate", "Landroidx/camera/camera2/pipe/RequestTemplate;", "lastAeMode", "Landroidx/camera/camera2/pipe/AeMode;", "lastAfMode", "Landroidx/camera/camera2/pipe/AfMode;", "lastAwbMode", "Landroidx/camera/camera2/pipe/AwbMode;", "requestListener", "Landroidx/camera/camera2/impl/UseCaseCameraState$RequestListener;", "pendingSignalCount", "updateAsync", "Lkotlinx/coroutines/Deferred;", "parameters", "", "appendParameters", "internalParameters", "appendInternalParameters", "streams", "", "template", "listeners", "updateAsync-Tp9XwKQ", "(Ljava/util/Map;ZLjava/util/Map;ZLjava/util/Set;Landroidx/camera/camera2/pipe/RequestTemplate;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateState", "updateState-HOTx9TI", "tryStartRepeating", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitLatest", "close", "update3A", "Landroidx/camera/camera2/pipe/CameraGraph$Session;", "getIntOrNull", "", "key", "(Ljava/util/Map;Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Integer;", "RequestSignal", "RequestListener", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@UseCaseCameraScope
public final class UseCaseCameraState {
    private final Map<androidx.camera.camera2.pipe.Metadata.Key<?>, Object> currentInternalParameters;
    private final Set<Request.Listener> currentListeners;
    private final Map<CaptureRequest.Key<?>, Object> currentParameters;
    private final Set<StreamId> currentStreams;
    private RequestTemplate currentTemplate;
    private AeMode lastAeMode;
    private AfMode lastAfMode;
    private AwbMode lastAwbMode;
    private final Object lock;
    private final AtomicInt pendingSignalCount;
    private final RequestListener requestListener;
    private final AtomicInt submittedRequestCounter;
    private final TemplateParamsOverride templateParamsOverride;
    private CompletableDeferred<Unit> updateSignal;
    private ArrayDeque<RequestSignal> updateSignals;
    private boolean updating;
    private final UseCaseGraphContext useCaseGraphContext;

    /* JADX INFO: renamed from: androidx.camera.camera2.impl.UseCaseCameraState$submitLatest$1, reason: invalid class name */
    /* JADX INFO: compiled from: UseCaseCameraState.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.impl.UseCaseCameraState", f = "UseCaseCameraState.kt", i = {0}, l = {400}, m = "submitLatest", n = {"signalToComplete"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UseCaseCameraState.this.submitLatest(this);
        }
    }

    @Inject
    public UseCaseCameraState(UseCaseGraphContext useCaseGraphContext, TemplateParamsOverride templateParamsOverride) {
        Intrinsics.checkNotNullParameter(useCaseGraphContext, "useCaseGraphContext");
        Intrinsics.checkNotNullParameter(templateParamsOverride, "templateParamsOverride");
        this.useCaseGraphContext = useCaseGraphContext;
        this.templateParamsOverride = templateParamsOverride;
        this.lock = new Object();
        this.submittedRequestCounter = AtomicFU.atomic(0);
        this.updateSignals = new ArrayDeque<>();
        this.currentParameters = new LinkedHashMap();
        this.currentInternalParameters = new LinkedHashMap();
        this.currentStreams = new LinkedHashSet();
        this.currentListeners = new LinkedHashSet();
        this.requestListener = new RequestListener();
        this.pendingSignalCount = AtomicFU.atomic(0);
    }

    /* JADX INFO: compiled from: UseCaseCameraState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraState$RequestSignal;", "", "requestNo", "", NdkCrashLog.SIGNAL_KEY_NAME, "Lkotlinx/coroutines/CompletableDeferred;", "", "<init>", "(ILkotlinx/coroutines/CompletableDeferred;)V", "getRequestNo", "()I", "getSignal", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class RequestSignal {
        private final int requestNo;
        private final CompletableDeferred<Unit> signal;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequestSignal copy$default(RequestSignal requestSignal, int i, CompletableDeferred completableDeferred, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = requestSignal.requestNo;
            }
            if ((i2 & 2) != 0) {
                completableDeferred = requestSignal.signal;
            }
            return requestSignal.copy(i, completableDeferred);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRequestNo() {
            return this.requestNo;
        }

        public final CompletableDeferred<Unit> component2() {
            return this.signal;
        }

        public final RequestSignal copy(int requestNo, CompletableDeferred<Unit> signal) {
            Intrinsics.checkNotNullParameter(signal, "signal");
            return new RequestSignal(requestNo, signal);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestSignal)) {
                return false;
            }
            RequestSignal requestSignal = (RequestSignal) other;
            return this.requestNo == requestSignal.requestNo && Intrinsics.areEqual(this.signal, requestSignal.signal);
        }

        public int hashCode() {
            return (Integer.hashCode(this.requestNo) * 31) + this.signal.hashCode();
        }

        public String toString() {
            return "RequestSignal(requestNo=" + this.requestNo + ", signal=" + this.signal + ')';
        }

        public RequestSignal(int i, CompletableDeferred<Unit> signal) {
            Intrinsics.checkNotNullParameter(signal, "signal");
            this.requestNo = i;
            this.signal = signal;
        }

        public final int getRequestNo() {
            return this.requestNo;
        }

        public final CompletableDeferred<Unit> getSignal() {
            return this.signal;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: updateAsync-Tp9XwKQ$default, reason: not valid java name */
    public static /* synthetic */ Object m147updateAsyncTp9XwKQ$default(UseCaseCameraState useCaseCameraState, Map map, boolean z, Map map2, boolean z2, Set set, RequestTemplate requestTemplate, Set set2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            map2 = null;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        if ((i & 16) != 0) {
            set = null;
        }
        if ((i & 32) != 0) {
            requestTemplate = null;
        }
        if ((i & 64) != 0) {
            set2 = null;
        }
        return useCaseCameraState.m149updateAsyncTp9XwKQ(map, z, map2, z2, set, requestTemplate, set2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r8v3, types: [T, java.lang.Object, kotlinx.coroutines.CompletableDeferred<kotlin.Unit>] */
    /* JADX INFO: renamed from: updateAsync-Tp9XwKQ, reason: not valid java name */
    public final Object m149updateAsyncTp9XwKQ(Map<CaptureRequest.Key<?>, ? extends Object> map, boolean z, Map<androidx.camera.camera2.pipe.Metadata.Key<?>, ? extends Object> map2, boolean z2, Set<StreamId> set, RequestTemplate requestTemplate, Set<? extends Request.Listener> set2, Continuation<? super Deferred<Unit>> continuation) {
        UseCaseCameraState$updateAsync$1 useCaseCameraState$updateAsync$1;
        Ref.ObjectRef objectRef;
        if (continuation instanceof UseCaseCameraState$updateAsync$1) {
            useCaseCameraState$updateAsync$1 = (UseCaseCameraState$updateAsync$1) continuation;
            if ((useCaseCameraState$updateAsync$1.label & Integer.MIN_VALUE) != 0) {
                useCaseCameraState$updateAsync$1.label -= Integer.MIN_VALUE;
            } else {
                useCaseCameraState$updateAsync$1 = new UseCaseCameraState$updateAsync$1(this, continuation);
            }
        } else {
            useCaseCameraState$updateAsync$1 = new UseCaseCameraState$updateAsync$1(this, continuation);
        }
        Object obj = useCaseCameraState$updateAsync$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = useCaseCameraState$updateAsync$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            synchronized (this.lock) {
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "UseCaseCameraState#updateState: parameters = " + map + ", internalParameters = " + map2 + ", streams = " + set + ", template = " + requestTemplate);
                }
                if (map != null) {
                    if (!z) {
                        this.currentParameters.clear();
                    }
                    this.currentParameters.putAll(map);
                }
                if (map2 != null) {
                    if (!z2) {
                        this.currentInternalParameters.clear();
                    }
                    this.currentInternalParameters.putAll(map2);
                }
                if (set != null) {
                    this.currentStreams.clear();
                    this.currentStreams.addAll(set);
                }
                if (requestTemplate != null) {
                    this.currentTemplate = requestTemplate;
                }
                if (set2 != null) {
                    this.currentListeners.clear();
                    this.currentListeners.addAll(set2);
                }
                if (this.updateSignal == null) {
                    this.updateSignal = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                }
                if (this.updating) {
                    CompletableDeferred<Unit> completableDeferred = this.updateSignal;
                    Intrinsics.checkNotNull(completableDeferred);
                    return completableDeferred;
                }
                this.updating = true;
                ?? r8 = this.updateSignal;
                Intrinsics.checkNotNull(r8);
                objectRef2.element = r8;
                Unit unit = Unit.INSTANCE;
                useCaseCameraState$updateAsync$1.L$0 = objectRef2;
                useCaseCameraState$updateAsync$1.label = 1;
                if (submitLatest(useCaseCameraState$updateAsync$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) useCaseCameraState$updateAsync$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return objectRef.element;
    }

    /* JADX INFO: renamed from: updateState-HOTx9TI, reason: not valid java name */
    private final void m148updateStateHOTx9TI(Map<CaptureRequest.Key<?>, ? extends Object> parameters, boolean appendParameters, Map<androidx.camera.camera2.pipe.Metadata.Key<?>, ? extends Object> internalParameters, boolean appendInternalParameters, Set<StreamId> streams, RequestTemplate template, Set<? extends Request.Listener> listeners) {
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "UseCaseCameraState#updateState: parameters = " + parameters + ", internalParameters = " + internalParameters + ", streams = " + streams + ", template = " + template);
        }
        if (parameters != null) {
            if (!appendParameters) {
                this.currentParameters.clear();
            }
            this.currentParameters.putAll(parameters);
        }
        if (internalParameters != null) {
            if (!appendInternalParameters) {
                this.currentInternalParameters.clear();
            }
            this.currentInternalParameters.putAll(internalParameters);
        }
        if (streams != null) {
            this.currentStreams.clear();
            this.currentStreams.addAll(streams);
        }
        if (template != null) {
            this.currentTemplate = template;
        }
        if (listeners != null) {
            this.currentListeners.clear();
            this.currentListeners.addAll(listeners);
        }
    }

    public final Object tryStartRepeating(Continuation<? super Unit> continuation) {
        Object objSubmitLatest = submitLatest(continuation);
        return objSubmitLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSubmitLatest : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:65:0x0154  */
    /* JADX WARN: Code duplicated, block: B:70:0x0170 A[Catch: all -> 0x018d, TryCatch #3 {, blocks: (B:68:0x016c, B:70:0x0170, B:71:0x0178), top: B:87:0x016c }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0181  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:87:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x0154, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, kotlinx.coroutines.CompletableDeferred<kotlin.Unit>] */
    /* JADX WARN: Type inference failed for: r10v11, types: [T, androidx.camera.camera2.pipe.Request] */
    /* JADX WARN: Type inference failed for: r10v12, types: [T, kotlinx.coroutines.CompletableDeferred<kotlin.Unit>] */
    public final Object submitLatest(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref.ObjectRef objectRef;
        CancellationException cancellationException;
        CompletableDeferred completableDeferred;
        int iIncrementAndGet;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAcquireSession = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAcquireSession);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            try {
                CameraGraph graph = this.useCaseGraphContext.getGraph();
                anonymousClass1.L$0 = objectRef2;
                anonymousClass1.label = 1;
                objAcquireSession = graph.acquireSession(anonymousClass1);
                if (objAcquireSession == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            } catch (CancellationException e) {
                e = e;
                objectRef = objectRef2;
                Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
                cancellationException = e;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Cannot acquire session at " + this, cancellationException);
                }
                synchronized (this.lock) {
                    if (this.updating) {
                        this.updating = false;
                        objectRef.element = this.updateSignal;
                        this.updateSignal = null;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(objAcquireSession);
            } catch (CancellationException e2) {
                e = e2;
                Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
                cancellationException = e;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Cannot acquire session at " + this, cancellationException);
                }
                synchronized (this.lock) {
                    if (this.updating) {
                        this.updating = false;
                        objectRef.element = this.updateSignal;
                        this.updateSignal = null;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    completableDeferred = (CompletableDeferred) objectRef.element;
                    if (completableDeferred != null) {
                        Boxing.boxBoolean(completableDeferred.complete(Unit.INSTANCE));
                    }
                    return Unit.INSTANCE;
                }
            }
        }
        AutoCloseable autoCloseable = (AutoCloseable) objAcquireSession;
        try {
            CameraGraph.Session session = (CameraGraph.Session) autoCloseable;
            Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            synchronized (this.lock) {
                if (this.currentStreams.isEmpty()) {
                    objectRef3.element = null;
                } else {
                    RequestTemplate requestTemplate = this.currentTemplate;
                    List list = CollectionsKt.toList(this.currentStreams);
                    Map mapPlus = MapsKt.plus(this.templateParamsOverride.mo81getOverrideParamsxlOpshk(this.currentTemplate), MapsKt.toMap(this.currentParameters));
                    Map mutableMap = MapsKt.toMutableMap(this.currentInternalParameters);
                    mutableMap.put(TagsKt.getUSE_CASE_CAMERA_STATE_CUSTOM_TAG(), Boxing.boxInt(this.submittedRequestCounter.incrementAndGet()));
                    List mutableList = CollectionsKt.toMutableList((Collection) this.currentListeners);
                    mutableList.add(this.requestListener);
                    objectRef3.element = new Request(list, mapPlus, mutableMap, mutableList, requestTemplate, null, 32, null);
                }
                objectRef4.element = this.updateSignal;
                this.updating = false;
                this.updateSignal = null;
                Unit unit3 = Unit.INSTANCE;
            }
            if (objectRef3.element == 0) {
                session.stopRepeating();
                objectRef.element = objectRef4.element;
            } else {
                CompletableDeferred completableDeferred2 = (CompletableDeferred) objectRef4.element;
                if (completableDeferred2 != null) {
                    synchronized (this.lock) {
                        this.updateSignals.add(new RequestSignal(this.submittedRequestCounter.getValue(), completableDeferred2));
                        iIncrementAndGet = this.pendingSignalCount.incrementAndGet();
                    }
                    Boxing.boxInt(iIncrementAndGet);
                }
                Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Update RepeatingRequest: " + objectRef3.element);
                }
                session.startRepeating((Request) objectRef3.element);
                update3A(session, ((Request) objectRef3.element).getParameters());
            }
            Unit unit4 = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(autoCloseable, null);
            completableDeferred = (CompletableDeferred) objectRef.element;
            if (completableDeferred != null) {
                Boxing.boxBoolean(completableDeferred.complete(Unit.INSTANCE));
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(autoCloseable, th);
                throw th2;
            }
        }
    }

    public final void close() {
        synchronized (this.lock) {
            if (this.updating) {
                this.updating = false;
                CompletableDeferred<Unit> completableDeferred = this.updateSignal;
                if (completableDeferred != null) {
                    completableDeferred.completeExceptionally(new CancellationException("UseCaseCameraState closed"));
                }
                this.updateSignal = null;
            }
            while (!this.updateSignals.isEmpty()) {
                this.updateSignals.removeFirst().getSignal().completeExceptionally(new CancellationException("UseCaseCameraState closed"));
                this.pendingSignalCount.decrementAndGet();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void update3A(CameraGraph.Session session, Map<CaptureRequest.Key<?>, ? extends Object> map) {
        AeMode aeModeM162fromIntOrNullkQd0u18;
        AfMode afModeM180fromIntOrNullMKXwA8g;
        CaptureRequest.Key<?> CONTROL_AE_MODE = CaptureRequest.CONTROL_AE_MODE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AE_MODE, "CONTROL_AE_MODE");
        Integer intOrNull = getIntOrNull(map, CONTROL_AE_MODE);
        AwbMode awbModeM206fromIntOrNullSaEiwI = null;
        if (intOrNull != null) {
            aeModeM162fromIntOrNullkQd0u18 = AeMode.INSTANCE.m162fromIntOrNullkQd0u18(intOrNull.intValue());
        } else {
            aeModeM162fromIntOrNullkQd0u18 = null;
        }
        CaptureRequest.Key<?> CONTROL_AF_MODE = CaptureRequest.CONTROL_AF_MODE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AF_MODE, "CONTROL_AF_MODE");
        Integer intOrNull2 = getIntOrNull(map, CONTROL_AF_MODE);
        if (intOrNull2 != null) {
            afModeM180fromIntOrNullMKXwA8g = AfMode.INSTANCE.m180fromIntOrNullMKXwA8g(intOrNull2.intValue());
        } else {
            afModeM180fromIntOrNullMKXwA8g = null;
        }
        CaptureRequest.Key<?> CONTROL_AWB_MODE = CaptureRequest.CONTROL_AWB_MODE;
        Intrinsics.checkNotNullExpressionValue(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
        Integer intOrNull3 = getIntOrNull(map, CONTROL_AWB_MODE);
        if (intOrNull3 != null) {
            awbModeM206fromIntOrNullSaEiwI = AwbMode.INSTANCE.m206fromIntOrNullSaEiwI(intOrNull3.intValue());
        }
        AwbMode awbMode = awbModeM206fromIntOrNullSaEiwI;
        boolean z = (aeModeM162fromIntOrNullkQd0u18 == null || Intrinsics.areEqual(aeModeM162fromIntOrNullkQd0u18, this.lastAeMode)) ? false : true;
        boolean z2 = (afModeM180fromIntOrNullMKXwA8g == null || Intrinsics.areEqual(afModeM180fromIntOrNullMKXwA8g, this.lastAfMode)) ? false : true;
        boolean z3 = (awbMode == null || Intrinsics.areEqual(awbMode, this.lastAwbMode)) ? false : true;
        if (z || z2 || z3) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "UseCaseCameraState: Updating 3A modes: AE(" + aeModeM162fromIntOrNullkQd0u18 + ", changed=" + z + "), AF(" + afModeM180fromIntOrNullMKXwA8g + ", changed=" + z2 + "), AWB(" + awbMode + ", changed=" + z3 + ')');
            }
            CameraControls3A.m307update3AydBZfZg$default(session, aeModeM162fromIntOrNullkQd0u18, afModeM180fromIntOrNullMKXwA8g, awbMode, null, null, null, 56, null);
            if (aeModeM162fromIntOrNullkQd0u18 != null) {
                this.lastAeMode = aeModeM162fromIntOrNullkQd0u18;
            }
            if (afModeM180fromIntOrNullMKXwA8g != null) {
                this.lastAfMode = afModeM180fromIntOrNullMKXwA8g;
            }
            if (awbMode != null) {
                this.lastAwbMode = awbMode;
            }
        }
    }

    private final Integer getIntOrNull(Map<CaptureRequest.Key<?>, ? extends Object> map, CaptureRequest.Key<?> key) {
        Object obj = map != null ? map.get(key) : null;
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    /* JADX INFO: compiled from: UseCaseCameraState.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u0010\u0014\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\"\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¨\u0006\u001b"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraState$RequestListener;", "Landroidx/camera/camera2/pipe/Request$Listener;", "<init>", "(Landroidx/camera/camera2/impl/UseCaseCameraState;)V", "onTotalCaptureResult", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "totalCaptureResult", "Landroidx/camera/camera2/pipe/FrameInfo;", "onTotalCaptureResult-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;)V", "onFailed", "requestFailure", "Landroidx/camera/camera2/pipe/RequestFailure;", "onFailed-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/RequestFailure;)V", "completeExceptionally", "complete", "Lkotlin/collections/ArrayDeque;", "Landroidx/camera/camera2/impl/UseCaseCameraState$RequestSignal;", "requestNo", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class RequestListener implements Request.Listener {
        public RequestListener() {
        }

        @Override // androidx.camera.camera2.pipe.Request.Listener
        /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I */
        public void mo51onTotalCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo totalCaptureResult) {
            Integer num;
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
            if (UseCaseCameraState.this.pendingSignalCount.getValue() == 0 || (num = (Integer) requestMetadata.get(TagsKt.getUSE_CASE_CAMERA_STATE_CUSTOM_TAG())) == null) {
                return;
            }
            UseCaseCameraState useCaseCameraState = UseCaseCameraState.this;
            int iIntValue = num.intValue();
            synchronized (useCaseCameraState.lock) {
                complete(useCaseCameraState.updateSignals, iIntValue);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.camera.camera2.pipe.Request.Listener
        /* JADX INFO: renamed from: onFailed-CcXjc1I */
        public void mo50onFailedCcXjc1I(RequestMetadata requestMetadata, long frameNumber, RequestFailure requestFailure) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
            if (UseCaseCameraState.this.pendingSignalCount.getValue() == 0) {
                return;
            }
            completeExceptionally(requestMetadata, requestFailure);
        }

        static /* synthetic */ void completeExceptionally$default(RequestListener requestListener, RequestMetadata requestMetadata, RequestFailure requestFailure, int i, Object obj) {
            if ((i & 2) != 0) {
                requestFailure = null;
            }
            requestListener.completeExceptionally(requestMetadata, requestFailure);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x003a  */
        private final void completeExceptionally(RequestMetadata requestMetadata, RequestFailure requestFailure) {
            String str;
            Integer num = (Integer) requestMetadata.get(TagsKt.getUSE_CASE_CAMERA_STATE_CUSTOM_TAG());
            if (num != null) {
                UseCaseCameraState useCaseCameraState = UseCaseCameraState.this;
                int iIntValue = num.intValue();
                synchronized (useCaseCameraState.lock) {
                    ArrayDeque<RequestSignal> arrayDeque = useCaseCameraState.updateSignals;
                    StringBuilder sb = new StringBuilder("Failed in framework level");
                    if (requestFailure != null) {
                        str = " with CaptureFailure.reason = " + requestFailure.getReason();
                        if (str == null) {
                            str = "";
                        }
                    } else {
                        str = "";
                    }
                    sb.append(str);
                    completeExceptionally(arrayDeque, iIntValue, new Throwable(sb.toString()));
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        private final void complete(ArrayDeque<RequestSignal> arrayDeque, int i) {
            while (!arrayDeque.isEmpty() && arrayDeque.first().getRequestNo() <= i) {
                arrayDeque.first().getSignal().complete(Unit.INSTANCE);
                CollectionsKt.removeFirst(arrayDeque);
                UseCaseCameraState.this.pendingSignalCount.decrementAndGet();
            }
        }

        private final void completeExceptionally(ArrayDeque<RequestSignal> arrayDeque, int i, Throwable th) {
            while (!arrayDeque.isEmpty() && arrayDeque.first().getRequestNo() <= i) {
                arrayDeque.first().getSignal().completeExceptionally(th);
                CollectionsKt.removeFirst(arrayDeque);
                UseCaseCameraState.this.pendingSignalCount.decrementAndGet();
            }
        }
    }
}
