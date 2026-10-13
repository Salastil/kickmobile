package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Trace;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraStream;
import androidx.camera.camera2.pipe.CameraTimestamp;
import androidx.camera.camera2.pipe.CaptureSequence;
import androidx.camera.camera2.pipe.CaptureSequences;
import androidx.camera.camera2.pipe.FrameNumber;
import androidx.camera.camera2.pipe.OutputId;
import androidx.camera.camera2.pipe.OutputStream;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestFailure;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.SensorTimestamp;
import androidx.camera.camera2.pipe.StreamGraph;
import androidx.camera.camera2.pipe.StreamId;
import androidx.camera.camera2.pipe.StrictMode;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: Camera2CaptureSequence.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0081\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ(\u00106\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020)H\u0016J \u00106\u001a\u00020,2\u0006\u00109\u001a\u00020\u00042\u0006\u0010;\u001a\u00020)2\u0006\u0010:\u001a\u00020)H\u0016J \u0010<\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010<\u001a\u00020,2\u0006\u00109\u001a\u00020\u00042\u0006\u0010=\u001a\u00020>H\u0016J(\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u0002082\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020)H\u0016J \u0010A\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0016J'\u0010A\u001a\u00020,2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020,2\u0006\u00109\u001a\u00020\u00042\u0006\u0010I\u001a\u00020.H\u0016J \u0010J\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00042\u0006\u0010K\u001a\u00020LH\u0016J'\u0010M\u001a\u00020,2\u0006\u0010N\u001a\u00020\f2\u0006\u0010D\u001a\u00020E2\u0006\u0010O\u001a\u00020PH\u0002¢\u0006\u0004\bQ\u0010RJ\u001f\u0010J\u001a\u00020,2\u0006\u00109\u001a\u00020\u00042\u0006\u0010D\u001a\u00020EH\u0016¢\u0006\u0004\bS\u0010TJ(\u0010U\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u00132\u0006\u0010W\u001a\u00020)H\u0016J\u0017\u0010X\u001a\u0004\u0018\u00010\u00142\u0006\u0010V\u001a\u00020\u0013H\u0002¢\u0006\u0002\bYJ \u0010Z\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u0010[\u001a\u00020.2\u0006\u0010;\u001a\u00020)H\u0016J\u0018\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020.2\u0006\u0010;\u001a\u00020)H\u0016J\u0018\u0010\\\u001a\u00020,2\u0006\u00107\u001a\u0002082\u0006\u0010[\u001a\u00020.H\u0016J\u0010\u0010\\\u001a\u00020,2\u0006\u0010[\u001a\u00020.H\u0016J\u0010\u0010]\u001a\u00020\f2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010^\u001a\u00020,H\u0080@¢\u0006\u0004\b_\u0010`J\b\u0010a\u001a\u00020bH\u0016R\u0016\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R$\u00101\u001a\u00020.2\u0006\u00100\u001a\u00020.8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006c"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CaptureSequence;", "Landroidx/camera/camera2/pipe/compat/Camera2CaptureCallback;", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "Landroidx/camera/camera2/pipe/CaptureSequence;", "Landroid/hardware/camera2/CaptureRequest;", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "repeating", "", "captureRequestList", "", "captureMetadataList", "Landroidx/camera/camera2/pipe/RequestMetadata;", "listeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "sequenceListener", "Landroidx/camera/camera2/pipe/CaptureSequence$CaptureSequenceListener;", "surfaceToStreamMap", "", "Landroid/view/Surface;", "Landroidx/camera/camera2/pipe/StreamId;", "surfaceToOutputMap", "Landroidx/camera/camera2/pipe/OutputId;", "streamGraph", "Landroidx/camera/camera2/pipe/StreamGraph;", "strictMode", "Landroidx/camera/camera2/pipe/StrictMode;", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/pipe/CaptureSequence$CaptureSequenceListener;Ljava/util/Map;Ljava/util/Map;Landroidx/camera/camera2/pipe/StreamGraph;Landroidx/camera/camera2/pipe/StrictMode;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCameraId-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "getRepeating", "()Z", "getCaptureRequestList", "()Ljava/util/List;", "getCaptureMetadataList", "getListeners", "getSequenceListener", "()Landroidx/camera/camera2/pipe/CaptureSequence$CaptureSequenceListener;", "debugId", "", "hasStarted", "Lkotlinx/coroutines/CompletableDeferred;", "", "_sequenceNumber", "", "Ljava/lang/Integer;", "value", "sequenceNumber", "getSequenceNumber", "()I", "setSequenceNumber", "(I)V", "onCaptureStarted", "captureSession", "Landroid/hardware/camera2/CameraCaptureSession;", "captureRequest", "captureTimestamp", "captureFrameNumber", "onCaptureProgressed", "partialCaptureResult", "Landroid/hardware/camera2/CaptureResult;", "onReadoutStarted", "session", "onCaptureCompleted", "captureResult", "Landroid/hardware/camera2/TotalCaptureResult;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "onCaptureCompleted-rmrZIYk", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/TotalCaptureResult;J)V", "onCaptureProcessProgressed", "progress", "onCaptureFailed", "captureFailure", "Landroid/hardware/camera2/CaptureFailure;", "invokeCaptureFailure", "request", "requestFailure", "Landroidx/camera/camera2/pipe/RequestFailure;", "invokeCaptureFailure-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/RequestFailure;)V", "onCaptureFailed-RuT0dZU", "(Landroid/hardware/camera2/CaptureRequest;J)V", "onCaptureBufferLost", "surface", "frameId", "getStreamId", "getStreamId-Lfjdq8s", "onCaptureSequenceCompleted", "captureSequenceId", "onCaptureSequenceAborted", "readRequestMetadata", "awaitStarted", "awaitStarted$camera_camera2_pipe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2CaptureSequence extends CameraCaptureSession.CaptureCallback implements Camera2CaptureCallback, CaptureSequence<CaptureRequest> {
    private volatile Integer _sequenceNumber;
    private final String cameraId;
    private final List<RequestMetadata> captureMetadataList;
    private final List<CaptureRequest> captureRequestList;
    private final long debugId;
    private final CompletableDeferred<Unit> hasStarted;
    private final List<Request.Listener> listeners;
    private final boolean repeating;
    private final CaptureSequence.CaptureSequenceListener sequenceListener;
    private final StreamGraph streamGraph;
    private final StrictMode strictMode;
    private final Map<Surface, OutputId> surfaceToOutputMap;
    private final Map<Surface, StreamId> surfaceToStreamMap;

    public /* synthetic */ Camera2CaptureSequence(String str, boolean z, List list, List list2, List list3, CaptureSequence.CaptureSequenceListener captureSequenceListener, Map map, Map map2, StreamGraph streamGraph, StrictMode strictMode, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, list, list2, list3, captureSequenceListener, map, map2, streamGraph, strictMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Camera2CaptureSequence(String cameraId, boolean z, List<CaptureRequest> captureRequestList, List<? extends RequestMetadata> captureMetadataList, List<? extends Request.Listener> listeners, CaptureSequence.CaptureSequenceListener sequenceListener, Map<Surface, StreamId> surfaceToStreamMap, Map<Surface, OutputId> surfaceToOutputMap, StreamGraph streamGraph, StrictMode strictMode) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(captureRequestList, "captureRequestList");
        Intrinsics.checkNotNullParameter(captureMetadataList, "captureMetadataList");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        Intrinsics.checkNotNullParameter(sequenceListener, "sequenceListener");
        Intrinsics.checkNotNullParameter(surfaceToStreamMap, "surfaceToStreamMap");
        Intrinsics.checkNotNullParameter(surfaceToOutputMap, "surfaceToOutputMap");
        Intrinsics.checkNotNullParameter(streamGraph, "streamGraph");
        Intrinsics.checkNotNullParameter(strictMode, "strictMode");
        this.cameraId = cameraId;
        this.repeating = z;
        this.captureRequestList = captureRequestList;
        this.captureMetadataList = captureMetadataList;
        this.listeners = listeners;
        this.sequenceListener = sequenceListener;
        this.surfaceToStreamMap = surfaceToStreamMap;
        this.surfaceToOutputMap = surfaceToOutputMap;
        this.streamGraph = streamGraph;
        this.strictMode = strictMode;
        this.debugId = Camera2CaptureSequenceProcessorKt.getCaptureSequenceDebugIds().incrementAndGet();
        this.hasStarted = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (getCaptureRequestList().size() != getCaptureMetadataList().size()) {
            throw new IllegalStateException("CaptureRequestList and CaptureMetadataList must have a 1:1 mapping.".toString());
        }
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    /* JADX INFO: renamed from: getCameraId-Dz_R5H8, reason: from getter */
    public String getCameraId() {
        return this.cameraId;
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    public boolean getRepeating() {
        return this.repeating;
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    public List<CaptureRequest> getCaptureRequestList() {
        return this.captureRequestList;
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    public List<RequestMetadata> getCaptureMetadataList() {
        return this.captureMetadataList;
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    public List<Request.Listener> getListeners() {
        return this.listeners;
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    public CaptureSequence.CaptureSequenceListener getSequenceListener() {
        return this.sequenceListener;
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    public int getSequenceNumber() {
        int iIntValue;
        if (this._sequenceNumber == null) {
            synchronized (this) {
                Integer num = this._sequenceNumber;
                if (num == null) {
                    throw new IllegalStateException(("SequenceNumber has not been set for " + this + '!').toString());
                }
                iIntValue = num.intValue();
            }
            return iIntValue;
        }
        Integer num2 = this._sequenceNumber;
        if (num2 != null) {
            return num2.intValue();
        }
        throw new IllegalStateException(("SequenceNumber has not been set for " + this + '!').toString());
    }

    @Override // androidx.camera.camera2.pipe.CaptureSequence
    public void setSequenceNumber(int i) {
        this._sequenceNumber = Integer.valueOf(i);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession captureSession, CaptureRequest captureRequest, long captureTimestamp, long captureFrameNumber) {
        Intrinsics.checkNotNullParameter(captureSession, "captureSession");
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        onCaptureStarted(captureRequest, captureFrameNumber, captureTimestamp);
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CaptureCallback
    public void onCaptureStarted(CaptureRequest captureRequest, long captureFrameNumber, long captureTimestamp) {
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureStarted");
        long jM462constructorimpl = CameraTimestamp.m462constructorimpl(captureTimestamp);
        long jM532constructorimpl = FrameNumber.m532constructorimpl(captureFrameNumber);
        this.hasStarted.complete(Unit.INSTANCE);
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Camera2CaptureSequence camera2CaptureSequence = this;
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            camera2CaptureSequence.getListeners().get(i).mo87onStarteduGKBvU4(requestMetadata, jM532constructorimpl, jM462constructorimpl);
        }
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = requestMetadata.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            requestMetadata.getRequest().getListeners().get(i2).mo87onStarteduGKBvU4(requestMetadata, jM532constructorimpl, jM462constructorimpl);
        }
        Debug debug5 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug6 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession captureSession, CaptureRequest captureRequest, CaptureResult partialCaptureResult) {
        Intrinsics.checkNotNullParameter(captureSession, "captureSession");
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Intrinsics.checkNotNullParameter(partialCaptureResult, "partialCaptureResult");
        onCaptureProgressed(captureRequest, partialCaptureResult);
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CaptureCallback
    public void onCaptureProgressed(CaptureRequest captureRequest, CaptureResult partialCaptureResult) {
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Intrinsics.checkNotNullParameter(partialCaptureResult, "partialCaptureResult");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureProgressed");
        long jM532constructorimpl = FrameNumber.m532constructorimpl(partialCaptureResult.getFrameNumber());
        AndroidFrameMetadata androidFrameMetadata = new AndroidFrameMetadata(partialCaptureResult, getCameraId(), null);
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Camera2CaptureSequence camera2CaptureSequence = this;
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            camera2CaptureSequence.getListeners().get(i).mo84onPartialCaptureResultCcXjc1I(requestMetadata, jM532constructorimpl, androidFrameMetadata);
        }
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = requestMetadata.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            requestMetadata.getRequest().getListeners().get(i2).mo84onPartialCaptureResultCcXjc1I(requestMetadata, jM532constructorimpl, androidFrameMetadata);
        }
        Debug debug5 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug6 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onReadoutStarted(CameraCaptureSession session, CaptureRequest captureRequest, long captureTimestamp, long captureFrameNumber) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onReadoutStarted");
        long jM739constructorimpl = SensorTimestamp.m739constructorimpl(captureTimestamp);
        long jM532constructorimpl = FrameNumber.m532constructorimpl(captureFrameNumber);
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Camera2CaptureSequence camera2CaptureSequence = this;
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            camera2CaptureSequence.getListeners().get(i).mo85onReadoutStartedmP9r9w(requestMetadata, jM532constructorimpl, jM739constructorimpl);
        }
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = requestMetadata.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            requestMetadata.getRequest().getListeners().get(i2).mo85onReadoutStartedmP9r9w(requestMetadata, jM532constructorimpl, jM739constructorimpl);
        }
        Debug debug5 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug6 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession captureSession, CaptureRequest captureRequest, TotalCaptureResult captureResult) {
        Intrinsics.checkNotNullParameter(captureSession, "captureSession");
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Intrinsics.checkNotNullParameter(captureResult, "captureResult");
        mo827onCaptureCompletedrmrZIYk(captureRequest, captureResult, FrameNumber.m532constructorimpl(captureResult.getFrameNumber()));
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CaptureCallback
    /* JADX INFO: renamed from: onCaptureCompleted-rmrZIYk */
    public void mo827onCaptureCompletedrmrZIYk(CaptureRequest captureRequest, TotalCaptureResult captureResult, long frameNumber) {
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Intrinsics.checkNotNullParameter(captureResult, "captureResult");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureCompleted");
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("onCaptureSequenceComplete");
        Camera2CaptureSequence camera2CaptureSequence = this;
        getSequenceListener().onCaptureSequenceComplete(camera2CaptureSequence);
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        AndroidFrameInfo androidFrameInfo = new AndroidFrameInfo(captureResult, getCameraId(), requestMetadata, null);
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("onTotalCaptureResult");
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Debug debug5 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            camera2CaptureSequence.getListeners().get(i).mo51onTotalCaptureResultCcXjc1I(requestMetadata, frameNumber, androidFrameInfo);
        }
        Debug debug6 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug7 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = requestMetadata.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            requestMetadata.getRequest().getListeners().get(i2).mo51onTotalCaptureResultCcXjc1I(requestMetadata, frameNumber, androidFrameInfo);
        }
        Debug debug8 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug9 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug10 = Debug.INSTANCE;
        Trace.beginSection("onComplete");
        CaptureSequences captureSequences2 = CaptureSequences.INSTANCE;
        Debug debug11 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size3 = camera2CaptureSequence.getListeners().size();
        for (int i3 = 0; i3 < size3; i3++) {
            camera2CaptureSequence.getListeners().get(i3).mo49onCompleteCcXjc1I(requestMetadata, frameNumber, androidFrameInfo);
        }
        Debug debug12 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug13 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size4 = requestMetadata.getRequest().getListeners().size();
        for (int i4 = 0; i4 < size4; i4++) {
            requestMetadata.getRequest().getListeners().get(i4).mo49onCompleteCcXjc1I(requestMetadata, frameNumber, androidFrameInfo);
        }
        Debug debug14 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug15 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug16 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CaptureCallback
    public void onCaptureProcessProgressed(CaptureRequest captureRequest, int progress) {
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureProcessProgressed");
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Camera2CaptureSequence camera2CaptureSequence = this;
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            camera2CaptureSequence.getListeners().get(i).onCaptureProgress(requestMetadata, progress);
        }
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = requestMetadata.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            requestMetadata.getRequest().getListeners().get(i2).onCaptureProgress(requestMetadata, progress);
        }
        Debug debug5 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug6 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession captureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        Intrinsics.checkNotNullParameter(captureSession, "captureSession");
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Intrinsics.checkNotNullParameter(captureFailure, "captureFailure");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureFailed");
        this.hasStarted.complete(Unit.INSTANCE);
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        m830invokeCaptureFailureCcXjc1I(requestMetadata, FrameNumber.m532constructorimpl(captureFailure.getFrameNumber()), new AndroidCaptureFailure(requestMetadata, captureFailure));
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    /* JADX INFO: renamed from: invokeCaptureFailure-CcXjc1I, reason: not valid java name */
    private final void m830invokeCaptureFailureCcXjc1I(RequestMetadata request, long frameNumber, RequestFailure requestFailure) {
        CaptureSequence.CaptureSequenceListener sequenceListener = getSequenceListener();
        Camera2CaptureSequence camera2CaptureSequence = this;
        sequenceListener.onCaptureSequenceComplete(camera2CaptureSequence);
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            camera2CaptureSequence.getListeners().get(i).mo50onFailedCcXjc1I(request, frameNumber, requestFailure);
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug3 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = request.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            request.getRequest().getListeners().get(i2).mo50onFailedCcXjc1I(request, frameNumber, requestFailure);
        }
        Debug debug4 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CaptureCallback
    /* JADX INFO: renamed from: onCaptureFailed-RuT0dZU */
    public void mo828onCaptureFailedRuT0dZU(CaptureRequest captureRequest, long frameNumber) {
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureFailed");
        this.hasStarted.complete(Unit.INSTANCE);
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        m830invokeCaptureFailureCcXjc1I(requestMetadata, frameNumber, new ExtensionRequestFailure(requestMetadata, false, frameNumber, 0, null));
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(CameraCaptureSession captureSession, CaptureRequest captureRequest, Surface surface, long frameId) {
        Intrinsics.checkNotNullParameter(captureSession, "captureSession");
        Intrinsics.checkNotNullParameter(captureRequest, "captureRequest");
        Intrinsics.checkNotNullParameter(surface, "surface");
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureBufferLost");
        long jM532constructorimpl = FrameNumber.m532constructorimpl(frameId);
        StreamId streamIdM829getStreamIdLfjdq8s = m829getStreamIdLfjdq8s(surface);
        OutputId outputId = this.surfaceToOutputMap.get(surface);
        if (streamIdM829getStreamIdLfjdq8s == null) {
            throw new IllegalStateException(("Unable to find the streamId for " + surface + " on " + ((Object) FrameNumber.m536toStringimpl(jM532constructorimpl))).toString());
        }
        if (outputId == null) {
            throw new IllegalStateException(("Unable to find the outputId for " + surface + " on " + ((Object) FrameNumber.m536toStringimpl(jM532constructorimpl))).toString());
        }
        RequestMetadata requestMetadata = readRequestMetadata(captureRequest);
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Camera2CaptureSequence camera2CaptureSequence = this;
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getListeners().size();
        for (int i = 0; i < size; i++) {
            camera2CaptureSequence.getListeners().get(i).m696onBufferLostDlC0U5Y(requestMetadata, jM532constructorimpl, streamIdM829getStreamIdLfjdq8s.m797unboximpl());
        }
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size2 = requestMetadata.getRequest().getListeners().size();
        for (int i2 = 0; i2 < size2; i2++) {
            requestMetadata.getRequest().getListeners().get(i2).m696onBufferLostDlC0U5Y(requestMetadata, jM532constructorimpl, streamIdM829getStreamIdLfjdq8s.m797unboximpl());
        }
        Debug debug5 = Debug.INSTANCE;
        Trace.endSection();
        CaptureSequences captureSequences2 = CaptureSequences.INSTANCE;
        Debug debug6 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size3 = camera2CaptureSequence.getListeners().size();
        for (int i3 = 0; i3 < size3; i3++) {
            camera2CaptureSequence.getListeners().get(i3).mo83onBufferLostiiEMlm4(requestMetadata, jM532constructorimpl, streamIdM829getStreamIdLfjdq8s.m797unboximpl(), outputId.m577unboximpl());
        }
        Debug debug7 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug8 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size4 = requestMetadata.getRequest().getListeners().size();
        for (int i4 = 0; i4 < size4; i4++) {
            requestMetadata.getRequest().getListeners().get(i4).mo83onBufferLostiiEMlm4(requestMetadata, jM532constructorimpl, streamIdM829getStreamIdLfjdq8s.m797unboximpl(), outputId.m577unboximpl());
        }
        Debug debug9 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug10 = Debug.INSTANCE;
        Trace.endSection();
    }

    /* JADX INFO: renamed from: getStreamId-Lfjdq8s, reason: not valid java name */
    private final StreamId m829getStreamIdLfjdq8s(Surface surface) {
        CameraStream stream;
        StreamId streamId = this.surfaceToStreamMap.get(surface);
        if (streamId != null) {
            return streamId;
        }
        OutputId outputId = this.surfaceToOutputMap.get(surface);
        OutputStream outputStreamM785getiYJqvbA = outputId != null ? this.streamGraph.m785getiYJqvbA(outputId.m577unboximpl()) : null;
        if (outputStreamM785getiYJqvbA == null || (stream = outputStreamM785getiYJqvbA.getStream()) == null) {
            return null;
        }
        return StreamId.m791boximpl(stream.getId());
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession captureSession, int captureSequenceId, long captureFrameNumber) {
        Intrinsics.checkNotNullParameter(captureSession, "captureSession");
        onCaptureSequenceCompleted(captureSequenceId, captureFrameNumber);
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CaptureCallback
    public void onCaptureSequenceCompleted(int captureSequenceId, long captureFrameNumber) {
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureSequenceCompleted");
        this.hasStarted.complete(Unit.INSTANCE);
        Camera2CaptureSequence camera2CaptureSequence = this;
        getSequenceListener().onCaptureSequenceComplete(camera2CaptureSequence);
        StrictMode strictMode = this.strictMode;
        if (!(getSequenceNumber() == captureSequenceId)) {
            String str = "onCaptureSequenceCompleted was invoked on " + getSequenceNumber() + ", but expected " + captureSequenceId + '!';
            if (!strictMode.getEnabled()) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, str);
                }
            } else {
                throw new IllegalStateException(str);
            }
        }
        long jM532constructorimpl = FrameNumber.m532constructorimpl(captureFrameNumber);
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getCaptureMetadataList().size();
        for (int i = 0; i < size; i++) {
            RequestMetadata requestMetadata = camera2CaptureSequence.getCaptureMetadataList().get(i);
            int size2 = camera2CaptureSequence.getListeners().size();
            for (int i2 = 0; i2 < size2; i2++) {
                camera2CaptureSequence.getListeners().get(i2).mo86onRequestSequenceCompletedRuT0dZU(requestMetadata, jM532constructorimpl);
            }
        }
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size3 = camera2CaptureSequence.getCaptureMetadataList().size();
        for (int i3 = 0; i3 < size3; i3++) {
            RequestMetadata requestMetadata2 = camera2CaptureSequence.getCaptureMetadataList().get(i3);
            int size4 = requestMetadata2.getRequest().getListeners().size();
            for (int i4 = 0; i4 < size4; i4++) {
                requestMetadata2.getRequest().getListeners().get(i4).mo86onRequestSequenceCompletedRuT0dZU(requestMetadata2, jM532constructorimpl);
            }
        }
        Debug debug5 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug6 = Debug.INSTANCE;
        Trace.endSection();
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession captureSession, int captureSequenceId) {
        Intrinsics.checkNotNullParameter(captureSession, "captureSession");
        onCaptureSequenceAborted(captureSequenceId);
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CaptureCallback
    public void onCaptureSequenceAborted(int captureSequenceId) {
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("onCaptureSequenceAborted");
        this.hasStarted.complete(Unit.INSTANCE);
        Camera2CaptureSequence camera2CaptureSequence = this;
        getSequenceListener().onCaptureSequenceComplete(camera2CaptureSequence);
        StrictMode strictMode = this.strictMode;
        if (!(getSequenceNumber() == captureSequenceId)) {
            String str = "onCaptureSequenceAborted was invoked on " + getSequenceNumber() + ", but expected " + captureSequenceId + '!';
            if (!strictMode.getEnabled()) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, str);
                }
            } else {
                throw new IllegalStateException(str);
            }
        }
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Debug debug2 = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = camera2CaptureSequence.getCaptureMetadataList().size();
        for (int i = 0; i < size; i++) {
            RequestMetadata requestMetadata = camera2CaptureSequence.getCaptureMetadataList().get(i);
            int size2 = camera2CaptureSequence.getListeners().size();
            for (int i2 = 0; i2 < size2; i2++) {
                camera2CaptureSequence.getListeners().get(i2).onRequestSequenceAborted(requestMetadata);
            }
        }
        Debug debug3 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug4 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size3 = camera2CaptureSequence.getCaptureMetadataList().size();
        for (int i3 = 0; i3 < size3; i3++) {
            RequestMetadata requestMetadata2 = camera2CaptureSequence.getCaptureMetadataList().get(i3);
            int size4 = requestMetadata2.getRequest().getListeners().size();
            for (int i4 = 0; i4 < size4; i4++) {
                requestMetadata2.getRequest().getListeners().get(i4).onRequestSequenceAborted(requestMetadata2);
            }
        }
        Debug debug5 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug6 = Debug.INSTANCE;
        Trace.endSection();
    }

    private final RequestMetadata readRequestMetadata(CaptureRequest captureRequest) {
        int size = getCaptureRequestList().size();
        for (int i = 0; i < size; i++) {
            if (getCaptureRequestList().get(i) == captureRequest) {
                return getCaptureMetadataList().get(i);
            }
        }
        throw new IllegalArgumentException("Failed to find CaptureRequest " + captureRequest + " in " + getCaptureRequestList());
    }

    public final Object awaitStarted$camera_camera2_pipe(Continuation<? super Unit> continuation) {
        Object objAwait = this.hasStarted.await(continuation);
        return objAwait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwait : Unit.INSTANCE;
    }

    public String toString() {
        return "Camera2CaptureSequence-" + this.debugId;
    }
}
