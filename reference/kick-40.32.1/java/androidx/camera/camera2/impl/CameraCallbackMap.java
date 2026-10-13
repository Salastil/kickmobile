package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.camera.camera2.adapter.CameraUseCaseAdapter;
import androidx.camera.camera2.adapter.CaptureResultAdapter;
import androidx.camera.camera2.compat.Api24Compat;
import androidx.camera.camera2.compat.Api34Compat;
import androidx.camera.camera2.config.CameraScope;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.TagBundle;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: CameraCallbackMap.kt */
/* JADX INFO: loaded from: classes.dex */
@CameraScope
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J/\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010 \u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\f\u0010%\u001a\u00020&*\u00020\u0017H\u0002J'\u0010'\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020.H\u0016J'\u0010/\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001f\u00105\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0004\b6\u00107J'\u00108\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H\u0016¢\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020&H\u0016J'\u0010?\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00109\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010<J\u0012\u0010B\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Landroidx/camera/camera2/impl/CameraCallbackMap;", "Landroidx/camera/camera2/pipe/Request$Listener;", "<init>", "()V", "callbackMap", "", "Landroidx/camera/core/impl/CameraCaptureCallback;", "Ljava/util/concurrent/Executor;", "rejectOperationCameraCaptureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "getRejectOperationCameraCaptureSession", "()Landroid/hardware/camera2/CameraCaptureSession;", "rejectOperationCameraCaptureSession$delegate", "Lkotlin/Lazy;", "callbacks", "", "addCaptureCallback", "", "callback", "executor", "removeCaptureCallback", "onBufferLost", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "onBufferLost-iiEMlm4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JII)V", "onComplete", "result", "Landroidx/camera/camera2/pipe/FrameInfo;", "onComplete-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;)V", "getCaptureConfigId", "", "onFailed", "requestFailure", "Landroidx/camera/camera2/pipe/RequestFailure;", "onFailed-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/RequestFailure;)V", "onAborted", "request", "Landroidx/camera/camera2/pipe/Request;", "onPartialCaptureResult", "captureResult", "Landroidx/camera/camera2/pipe/FrameMetadata;", "onPartialCaptureResult-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameMetadata;)V", "onRequestSequenceAborted", "onRequestSequenceCompleted", "onRequestSequenceCompleted-RuT0dZU", "(Landroidx/camera/camera2/pipe/RequestMetadata;J)V", "onStarted", "timestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "onStarted-uGKBvU4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JJ)V", "onCaptureProgress", "progress", "onReadoutStarted", "Landroidx/camera/camera2/pipe/SensorTimestamp;", "onReadoutStarted-mP9r-9w", "getCameraCaptureSession", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraCallbackMap implements Request.Listener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<CameraCaptureCallback, Executor> callbackMap = new LinkedHashMap();

    /* JADX INFO: renamed from: rejectOperationCameraCaptureSession$delegate, reason: from kotlin metadata */
    private final Lazy rejectOperationCameraCaptureSession = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return CameraCallbackMap.rejectOperationCameraCaptureSession_delegate$lambda$0();
        }
    });
    private volatile Map<CameraCaptureCallback, ? extends Executor> callbacks = MapsKt.emptyMap();

    @Inject
    public CameraCallbackMap() {
    }

    private final CameraCaptureSession getRejectOperationCameraCaptureSession() {
        return (CameraCaptureSession) this.rejectOperationCameraCaptureSession.getValue();
    }

    static final RejectOperationCameraCaptureSession rejectOperationCameraCaptureSession_delegate$lambda$0() {
        return new RejectOperationCameraCaptureSession();
    }

    public final void addCaptureCallback(CameraCaptureCallback callback, Executor executor) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        if (this.callbacks.containsKey(callback)) {
            throw new IllegalStateException((callback + " was already registered!").toString());
        }
        synchronized (this.callbackMap) {
            this.callbackMap.put(callback, executor);
            this.callbacks = MapsKt.toMap(this.callbackMap);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeCaptureCallback(CameraCaptureCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this.callbackMap) {
            this.callbackMap.remove(callback);
            this.callbacks = MapsKt.toMap(this.callbackMap);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onBufferLost-iiEMlm4, reason: not valid java name */
    public void mo83onBufferLostiiEMlm4(RequestMetadata requestMetadata, final long frameNumber, int streamId, int outputId) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                final Surface surface = requestMetadata.getStreams().get(StreamId.m791boximpl(streamId));
                if (cameraCaptureSession != null && captureRequest != null && surface != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Api24Compat.onCaptureBufferLost(((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback(), cameraCaptureSession, captureRequest, surface, frameNumber);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onComplete-CcXjc1I */
    public void mo49onCompleteCcXjc1I(final RequestMetadata requestMetadata, long frameNumber, FrameInfo result) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(result, "result");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = getCameraCaptureSession(requestMetadata);
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                final TotalCaptureResult totalCaptureResult = (TotalCaptureResult) result.unwrapAs(Reflection.getOrCreateKotlinClass(TotalCaptureResult.class));
                if (cameraCaptureSession != null && captureRequest != null && totalCaptureResult != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback().onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                        }
                    });
                }
            } else {
                final CaptureResultAdapter captureResultAdapter = new CaptureResultAdapter(requestMetadata, frameNumber, result, null);
                value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        key.onCaptureCompleted(this.getCaptureConfigId(requestMetadata), captureResultAdapter);
                    }
                });
            }
        }
    }

    private final int getCaptureConfigId(RequestMetadata requestMetadata) {
        TagBundle tagBundle = (TagBundle) requestMetadata.get(TagsKt.getCAMERAX_TAG_BUNDLE());
        Object tag = tagBundle != null ? tagBundle.getTag(CaptureConfig.CAPTURE_CONFIG_ID_TAG_KEY) : null;
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onFailed-CcXjc1I */
    public void mo50onFailedCcXjc1I(final RequestMetadata requestMetadata, long frameNumber, RequestFailure requestFailure) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = getCameraCaptureSession(requestMetadata);
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                final CaptureFailure captureFailure = (CaptureFailure) requestFailure.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureFailure.class));
                if (cameraCaptureSession != null && captureRequest != null && captureFailure != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback().onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                        }
                    });
                }
            } else {
                final CameraCaptureFailure cameraCaptureFailure = new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR);
                value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        key.onCaptureFailed(this.getCaptureConfigId(requestMetadata), cameraCaptureFailure);
                    }
                });
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onAborted(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            Object obj = request.getExtras().get(TagsKt.getCAMERAX_TAG_BUNDLE());
            TagBundle tagBundle = obj instanceof TagBundle ? (TagBundle) obj : null;
            Object tag = tagBundle != null ? tagBundle.getTag(CaptureConfig.CAPTURE_CONFIG_ID_TAG_KEY) : null;
            Integer num = tag instanceof Integer ? (Integer) tag : null;
            final int iIntValue = num != null ? num.intValue() : -1;
            value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    key.onCaptureCancelled(iIntValue);
                }
            });
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onPartialCaptureResult-CcXjc1I, reason: not valid java name */
    public void mo84onPartialCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameMetadata captureResult) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(captureResult, "captureResult");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                final CaptureResult captureResult2 = (CaptureResult) captureResult.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureResult.class));
                if (cameraCaptureSession != null && captureRequest != null && captureResult2 != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda16
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback().onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult2);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onRequestSequenceAborted(final RequestMetadata requestMetadata) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CameraCaptureSession.class));
                CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                if (cameraCaptureSession != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback().onCaptureSequenceAborted(cameraCaptureSession, -1);
                        }
                    });
                }
            } else {
                value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        key.onCaptureCancelled(this.getCaptureConfigId(requestMetadata));
                    }
                });
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onRequestSequenceCompleted-RuT0dZU, reason: not valid java name */
    public void mo86onRequestSequenceCompletedRuT0dZU(RequestMetadata requestMetadata, final long frameNumber) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = getCameraCaptureSession(requestMetadata);
                CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                if (cameraCaptureSession != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback().onCaptureSequenceCompleted(cameraCaptureSession, -1, frameNumber);
                        }
                    });
                }
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onStarted-uGKBvU4, reason: not valid java name */
    public void mo87onStarteduGKBvU4(final RequestMetadata requestMetadata, final long frameNumber, final long timestamp) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = getCameraCaptureSession(requestMetadata);
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                if (cameraCaptureSession != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback().onCaptureStarted(cameraCaptureSession, captureRequest, timestamp, frameNumber);
                        }
                    });
                }
            } else {
                value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        key.onCaptureStarted(this.getCaptureConfigId(requestMetadata));
                    }
                });
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    public void onCaptureProgress(final RequestMetadata requestMetadata, final int progress) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                final CaptureResult captureResult = (CaptureResult) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureResult.class));
                if (cameraCaptureSession != null && captureRequest != null && captureResult != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda10
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback().onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                        }
                    });
                }
            } else {
                value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        key.onCaptureProcessProgressed(this.getCaptureConfigId(requestMetadata), progress);
                    }
                });
            }
        }
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onReadoutStarted-mP9r-9w, reason: not valid java name */
    public void mo85onReadoutStartedmP9r9w(RequestMetadata requestMetadata, final long frameNumber, final long timestamp) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        for (Map.Entry<CameraCaptureCallback, ? extends Executor> entry : this.callbacks.entrySet()) {
            final CameraCaptureCallback key = entry.getKey();
            Executor value = entry.getValue();
            if (key instanceof CameraUseCaseAdapter.CaptureCallbackContainer) {
                final CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CameraCaptureSession.class));
                final CaptureRequest captureRequest = (CaptureRequest) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CaptureRequest.class));
                if (cameraCaptureSession != null && captureRequest != null) {
                    value.execute(new Runnable() { // from class: androidx.camera.camera2.impl.CameraCallbackMap$$ExternalSyntheticLambda17
                        @Override // java.lang.Runnable
                        public final void run() {
                            Api34Compat.onReadoutStarted(((CameraUseCaseAdapter.CaptureCallbackContainer) key).getCaptureCallback(), cameraCaptureSession, captureRequest, timestamp, frameNumber);
                        }
                    });
                }
            }
        }
    }

    private final CameraCaptureSession getCameraCaptureSession(RequestMetadata requestMetadata) {
        CameraCaptureSession cameraCaptureSession = (CameraCaptureSession) requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(CameraCaptureSession.class));
        if (cameraCaptureSession != null) {
            return cameraCaptureSession;
        }
        if (Build.VERSION.SDK_INT < 31 || ComponentDialog$$ExternalSyntheticApiModelOutline0.m11m(requestMetadata.unwrapAs(Reflection.getOrCreateKotlinClass(ComponentDialog$$ExternalSyntheticApiModelOutline0.m20m()))) == null) {
            return null;
        }
        return getRejectOperationCameraCaptureSession();
    }

    /* JADX INFO: compiled from: CameraCallbackMap.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Landroidx/camera/camera2/impl/CameraCallbackMap$Companion;", "", "<init>", "()V", "createFor", "Landroidx/camera/camera2/impl/CameraCallbackMap;", "callbacks", "", "Landroidx/camera/core/impl/CameraCaptureCallback;", "executor", "Ljava/util/concurrent/Executor;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CameraCallbackMap createFor(Collection<? extends CameraCaptureCallback> callbacks, Executor executor) {
            Intrinsics.checkNotNullParameter(callbacks, "callbacks");
            Intrinsics.checkNotNullParameter(executor, "executor");
            CameraCallbackMap cameraCallbackMap = new CameraCallbackMap();
            Iterator<T> it = callbacks.iterator();
            while (it.hasNext()) {
                cameraCallbackMap.addCaptureCallback((CameraCaptureCallback) it.next(), executor);
            }
            return cameraCallbackMap;
        }
    }
}
