package androidx.camera.camera2.impl;

import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComboRequestListener.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0001J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J/\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001f\u0010/\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J'\u00104\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J'\u00109\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010:\u001a\u00020!H\u0016¢\u0006\u0004\b;\u0010#R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R8\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\b8\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006<"}, d2 = {"Landroidx/camera/camera2/impl/ComboRequestListener;", "Landroidx/camera/camera2/pipe/Request$Listener;", "<init>", "()V", "requestListeners", "", "Ljava/util/concurrent/Executor;", "value", "", "listeners", "getListeners", "()Ljava/util/Map;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "executor", "removeListener", "onAborted", "request", "Landroidx/camera/camera2/pipe/Request;", "onBufferLost", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "onBufferLost-iiEMlm4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JII)V", "onComplete", "result", "Landroidx/camera/camera2/pipe/FrameInfo;", "onComplete-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;)V", "onFailed", "requestFailure", "Landroidx/camera/camera2/pipe/RequestFailure;", "onFailed-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/RequestFailure;)V", "onPartialCaptureResult", "captureResult", "Landroidx/camera/camera2/pipe/FrameMetadata;", "onPartialCaptureResult-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameMetadata;)V", "onRequestSequenceAborted", "onRequestSequenceCompleted", "onRequestSequenceCompleted-RuT0dZU", "(Landroidx/camera/camera2/pipe/RequestMetadata;J)V", "onRequestSequenceCreated", "onRequestSequenceSubmitted", "onStarted", "timestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "onStarted-uGKBvU4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JJ)V", "onTotalCaptureResult", "totalCaptureResult", "onTotalCaptureResult-CcXjc1I", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComboRequestListener implements Request.Listener {
    private final Map<Request.Listener, Executor> requestListeners = new LinkedHashMap();
    private volatile Map<Request.Listener, ? extends Executor> listeners = MapsKt.emptyMap();

    @Inject
    public ComboRequestListener() {
    }

    public final Map<Request.Listener, Executor> getListeners() {
        return this.listeners;
    }

    public final void addListener(Request.Listener listener, Executor executor) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(executor, "executor");
        if (this.listeners.containsKey(listener)) {
            throw new IllegalStateException((listener + " was already registered!").toString());
        }
        synchronized (this.requestListeners) {
            this.requestListeners.put(listener, executor);
            this.listeners = MapsKt.toMap(this.requestListeners);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeListener(Request.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.requestListeners) {
            this.requestListeners.remove(listener);
            this.listeners = MapsKt.toMap(this.requestListeners);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onAborted(final Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    key.onAborted(request);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onBufferLost-iiEMlm4 */
    public void mo83onBufferLostiiEMlm4(final RequestMetadata requestMetadata, final long frameNumber, final int streamId, final int outputId) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    key.mo83onBufferLostiiEMlm4(requestMetadata, frameNumber, streamId, outputId);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onComplete-CcXjc1I */
    public void mo49onCompleteCcXjc1I(final RequestMetadata requestMetadata, final long frameNumber, final FrameInfo result) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(result, "result");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    key.mo49onCompleteCcXjc1I(requestMetadata, frameNumber, result);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onFailed-CcXjc1I */
    public void mo50onFailedCcXjc1I(final RequestMetadata requestMetadata, final long frameNumber, final RequestFailure requestFailure) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    key.mo50onFailedCcXjc1I(requestMetadata, frameNumber, requestFailure);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onPartialCaptureResult-CcXjc1I */
    public void mo84onPartialCaptureResultCcXjc1I(final RequestMetadata requestMetadata, final long frameNumber, final FrameMetadata captureResult) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(captureResult, "captureResult");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    key.mo84onPartialCaptureResultCcXjc1I(requestMetadata, frameNumber, captureResult);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onRequestSequenceAborted(final RequestMetadata requestMetadata) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    key.onRequestSequenceAborted(requestMetadata);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onRequestSequenceCompleted-RuT0dZU */
    public void mo86onRequestSequenceCompletedRuT0dZU(final RequestMetadata requestMetadata, final long frameNumber) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    key.mo86onRequestSequenceCompletedRuT0dZU(requestMetadata, frameNumber);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onRequestSequenceCreated(final RequestMetadata requestMetadata) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    key.onRequestSequenceCreated(requestMetadata);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onRequestSequenceSubmitted(final RequestMetadata requestMetadata) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    key.onRequestSequenceSubmitted(requestMetadata);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onStarted-uGKBvU4 */
    public void mo87onStarteduGKBvU4(final RequestMetadata requestMetadata, final long frameNumber, final long timestamp) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    key.mo87onStarteduGKBvU4(requestMetadata, frameNumber, timestamp);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I */
    public void mo51onTotalCaptureResultCcXjc1I(final RequestMetadata requestMetadata, final long frameNumber, final FrameInfo totalCaptureResult) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
        for (Map.Entry<Request.Listener, ? extends Executor> entry : this.listeners.entrySet()) {
            final Request.Listener key = entry.getKey();
            entry.getValue().execute(new Runnable() { // from class: androidx.camera.camera2.impl.ComboRequestListener$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    key.mo51onTotalCaptureResultCcXjc1I(requestMetadata, frameNumber, totalCaptureResult);
                }
            });
        }
    }
}
