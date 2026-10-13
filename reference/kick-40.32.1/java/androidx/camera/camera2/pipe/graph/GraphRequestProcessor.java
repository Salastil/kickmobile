package androidx.camera.camera2.pipe.graph;

import android.hardware.camera2.CameraAccessException;
import android.os.Trace;
import androidx.camera.camera2.pipe.CaptureSequence;
import androidx.camera.camera2.pipe.CaptureSequenceProcessor;
import androidx.camera.camera2.pipe.CaptureSequences;
import androidx.camera.camera2.pipe.InputRequest;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.compat.ObjectUnavailableException;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.media.ImageWrapper;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: GraphRequestProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u000e\u0018\u0000 +2\u00020\u0001:\u0001+B#\b\u0002\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0014J\u0010\u0010\u0015\u001a\u00020\u0011H\u0080@¢\u0006\u0004\b\u0016\u0010\u0017Jm\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\u0012\u0010 \u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\u0012\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001cH\u0000¢\u0006\u0002\b$J\b\u0010%\u001a\u00020&H\u0016J\u0019\u0010'\u001a\u00020\u0011\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0004H\u0082\bJ\u0019\u0010)\u001a\u00020\u0011\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0004H\u0082\bJ\u0019\u0010*\u001a\u00020\u0011\"\u0004\b\u0000\u0010(*\b\u0012\u0004\u0012\u0002H(0\u0004H\u0082\bR \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006,"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "", "captureSequenceProcessor", "Landroidx/camera/camera2/pipe/CaptureSequenceProcessor;", "Landroidx/camera/camera2/pipe/CaptureSequence;", "<init>", "(Landroidx/camera/camera2/pipe/CaptureSequenceProcessor;)V", "debugId", "", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "activeCaptureSequences", "", "activeBurstListener", "androidx/camera/camera2/pipe/graph/GraphRequestProcessor$activeBurstListener$1", "Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor$activeBurstListener$1;", "abortCaptures", "", "abortCaptures$camera_camera2_pipe", "stopRepeating", "stopRepeating$camera_camera2_pipe", "shutdown", "shutdown$camera_camera2_pipe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submit", "", "isRepeating", "requests", "", "Landroidx/camera/camera2/pipe/Request;", "defaultParameters", "", "graphParameters", "requiredParameters", "listeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "submit$camera_camera2_pipe", "toString", "", "invokeOnAborted", ExifInterface.GPS_DIRECTION_TRUE, "invokeOnRequestSequenceCreated", "invokeOnRequestSequenceSubmitted", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GraphRequestProcessor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GraphRequestProcessor$activeBurstListener$1 activeBurstListener;
    private final List<CaptureSequence<?>> activeCaptureSequences;
    private final CaptureSequenceProcessor<Object, CaptureSequence<Object>> captureSequenceProcessor;
    private final AtomicBoolean closed;
    private final int debugId;

    public /* synthetic */ GraphRequestProcessor(CaptureSequenceProcessor captureSequenceProcessor, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureSequenceProcessor);
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.camera.camera2.pipe.graph.GraphRequestProcessor$activeBurstListener$1] */
    private GraphRequestProcessor(CaptureSequenceProcessor<? extends Object, CaptureSequence<Object>> captureSequenceProcessor) {
        this.captureSequenceProcessor = captureSequenceProcessor;
        this.debugId = GraphRequestProcessorKt.getGraphRequestProcessorIds().incrementAndGet();
        this.closed = AtomicFU.atomic(false);
        this.activeCaptureSequences = new ArrayList();
        this.activeBurstListener = new CaptureSequence.CaptureSequenceListener() { // from class: androidx.camera.camera2.pipe.graph.GraphRequestProcessor$activeBurstListener$1
            @Override // androidx.camera.camera2.pipe.CaptureSequence.CaptureSequenceListener
            public void onCaptureSequenceComplete(CaptureSequence<?> captureSequence) {
                Intrinsics.checkNotNullParameter(captureSequence, "captureSequence");
                if (captureSequence.getRepeating()) {
                    return;
                }
                List list = this.this$0.activeCaptureSequences;
                GraphRequestProcessor graphRequestProcessor = this.this$0;
                synchronized (list) {
                    graphRequestProcessor.activeCaptureSequences.remove(captureSequence);
                }
            }
        };
    }

    /* JADX INFO: compiled from: GraphRequestProcessor.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Landroidx/camera/camera2/pipe/graph/GraphRequestProcessor;", "captureSequenceProcessor", "Landroidx/camera/camera2/pipe/CaptureSequenceProcessor;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GraphRequestProcessor from(CaptureSequenceProcessor<?, ?> captureSequenceProcessor) {
            Intrinsics.checkNotNullParameter(captureSequenceProcessor, "captureSequenceProcessor");
            return new GraphRequestProcessor(captureSequenceProcessor, null);
        }
    }

    public final void abortCaptures$camera_camera2_pipe() {
        List<CaptureSequence> list;
        synchronized (this.activeCaptureSequences) {
            list = CollectionsKt.toList(this.activeCaptureSequences);
            this.activeCaptureSequences.clear();
        }
        for (CaptureSequence captureSequence : list) {
            CaptureSequences captureSequences = CaptureSequences.INSTANCE;
            Debug debug = Debug.INSTANCE;
            Trace.beginSection("InvokeInternalListeners");
            int size = captureSequence.getCaptureMetadataList().size();
            for (int i = 0; i < size; i++) {
                RequestMetadata requestMetadata = captureSequence.getCaptureMetadataList().get(i);
                int size2 = captureSequence.getListeners().size();
                for (int i2 = 0; i2 < size2; i2++) {
                    captureSequence.getListeners().get(i2).onAborted(requestMetadata.getRequest());
                }
            }
            Debug debug2 = Debug.INSTANCE;
            Trace.endSection();
            Debug debug3 = Debug.INSTANCE;
            Trace.beginSection("InvokeRequestListeners");
            int size3 = captureSequence.getCaptureMetadataList().size();
            for (int i3 = 0; i3 < size3; i3++) {
                RequestMetadata requestMetadata2 = captureSequence.getCaptureMetadataList().get(i3);
                int size4 = requestMetadata2.getRequest().getListeners().size();
                for (int i4 = 0; i4 < size4; i4++) {
                    requestMetadata2.getRequest().getListeners().get(i4).onAborted(requestMetadata2.getRequest());
                }
            }
            Debug debug4 = Debug.INSTANCE;
            Trace.endSection();
        }
        this.captureSequenceProcessor.abortCaptures();
    }

    public final void stopRepeating$camera_camera2_pipe() {
        this.captureSequenceProcessor.stopRepeating();
    }

    public final Object shutdown$camera_camera2_pipe(Continuation<? super Unit> continuation) {
        if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
            android.util.Log.d(Log.TAG, "Closing " + this);
        }
        if (this.closed.compareAndSet(false, true)) {
            Object objShutdown = this.captureSequenceProcessor.shutdown(continuation);
            return objShutdown == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objShutdown : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final boolean submit$camera_camera2_pipe(boolean isRepeating, List<Request> requests, Map<?, ? extends Object> defaultParameters, Map<?, ? extends Object> graphParameters, Map<?, ? extends Object> requiredParameters, List<? extends Request.Listener> listeners) {
        Throwable th;
        boolean z;
        ImageWrapper image;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(defaultParameters, "defaultParameters");
        Intrinsics.checkNotNullParameter(graphParameters, "graphParameters");
        Intrinsics.checkNotNullParameter(requiredParameters, "requiredParameters");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        if (this.closed.getValue()) {
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to submit " + requests + ": " + this + " is closed.");
            }
            return false;
        }
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("CXCP#buildCaptureSequence");
            CaptureSequence<?> captureSequenceBuild = this.captureSequenceProcessor.build(isRepeating, requests, defaultParameters, graphParameters, requiredParameters, this.activeBurstListener, listeners);
            Trace.endSection();
            boolean z2 = true;
            if (captureSequenceBuild == null) {
                List<Request> list = requests;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (((Request) it.next()).getInputRequest() != null) {
                            for (Request request : requests) {
                                InputRequest inputRequest = request.getInputRequest();
                                if (inputRequest != null && (image = inputRequest.getImage()) != null) {
                                    UByte$$ExternalSyntheticBackport0.m12761m((Object) image);
                                    Unit unit = Unit.INSTANCE;
                                }
                                Iterator<Request.Listener> it2 = request.getListeners().iterator();
                                while (it2.hasNext()) {
                                    it2.next().onAborted(request);
                                }
                            }
                            return true;
                        }
                    }
                }
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to submit " + requests + ": " + this + " failed to build CaptureSequence.");
                }
                return false;
            }
            if (this.closed.getValue()) {
                if (Log.INSTANCE.getWARN_LOGGABLE()) {
                    android.util.Log.w(Log.TAG, "Failed to submit " + requests + ": " + this + " is closed.");
                }
                return false;
            }
            if (!captureSequenceBuild.getRepeating()) {
                synchronized (this.activeCaptureSequences) {
                    this.activeCaptureSequences.add(captureSequenceBuild);
                }
            }
            try {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, this + " submitting " + captureSequenceBuild);
                }
                CaptureSequences captureSequences = CaptureSequences.INSTANCE;
                Debug debug2 = Debug.INSTANCE;
                Trace.beginSection("InvokeInternalListeners");
                int size = captureSequenceBuild.getCaptureMetadataList().size();
                for (int i = 0; i < size; i++) {
                    RequestMetadata requestMetadata = captureSequenceBuild.getCaptureMetadataList().get(i);
                    int size2 = captureSequenceBuild.getListeners().size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        captureSequenceBuild.getListeners().get(i2).onRequestSequenceCreated(requestMetadata);
                    }
                }
                Debug debug3 = Debug.INSTANCE;
                Trace.endSection();
                Debug debug4 = Debug.INSTANCE;
                Trace.beginSection("InvokeRequestListeners");
                int size3 = captureSequenceBuild.getCaptureMetadataList().size();
                for (int i3 = 0; i3 < size3; i3++) {
                    RequestMetadata requestMetadata2 = captureSequenceBuild.getCaptureMetadataList().get(i3);
                    int size4 = requestMetadata2.getRequest().getListeners().size();
                    for (int i4 = 0; i4 < size4; i4++) {
                        requestMetadata2.getRequest().getListeners().get(i4).onRequestSequenceCreated(requestMetadata2);
                    }
                }
                Debug debug5 = Debug.INSTANCE;
                Trace.endSection();
                synchronized (captureSequenceBuild) {
                    if (this.closed.getValue()) {
                        if (Log.INSTANCE.getWARN_LOGGABLE()) {
                            android.util.Log.w(Log.TAG, "Failed to submit " + captureSequenceBuild + ": " + this + " is closed.");
                        }
                        if (!captureSequenceBuild.getRepeating()) {
                            synchronized (this.activeCaptureSequences) {
                                this.activeCaptureSequences.remove(captureSequenceBuild);
                            }
                            CaptureSequences captureSequences2 = CaptureSequences.INSTANCE;
                            Debug debug6 = Debug.INSTANCE;
                            Trace.beginSection("InvokeInternalListeners");
                            int size5 = captureSequenceBuild.getCaptureMetadataList().size();
                            for (int i5 = 0; i5 < size5; i5++) {
                                RequestMetadata requestMetadata3 = captureSequenceBuild.getCaptureMetadataList().get(i5);
                                int size6 = captureSequenceBuild.getListeners().size();
                                for (int i6 = 0; i6 < size6; i6++) {
                                    captureSequenceBuild.getListeners().get(i6).onAborted(requestMetadata3.getRequest());
                                }
                            }
                            Debug debug7 = Debug.INSTANCE;
                            Trace.endSection();
                            Debug debug8 = Debug.INSTANCE;
                            Trace.beginSection("InvokeRequestListeners");
                            int size7 = captureSequenceBuild.getCaptureMetadataList().size();
                            for (int i7 = 0; i7 < size7; i7++) {
                                RequestMetadata requestMetadata4 = captureSequenceBuild.getCaptureMetadataList().get(i7);
                                int size8 = requestMetadata4.getRequest().getListeners().size();
                                for (int i8 = 0; i8 < size8; i8++) {
                                    requestMetadata4.getRequest().getListeners().get(i8).onAborted(requestMetadata4.getRequest());
                                }
                            }
                            Debug debug9 = Debug.INSTANCE;
                            Trace.endSection();
                        }
                        return false;
                    }
                    Debug debug10 = Debug.INSTANCE;
                    try {
                        Trace.beginSection("CXCP#submit(CaptureSequence)");
                        Integer numSubmit = this.captureSequenceProcessor.submit(captureSequenceBuild);
                        int iIntValue = numSubmit != null ? numSubmit.intValue() : -1;
                        captureSequenceBuild.setSequenceNumber(iIntValue);
                        Trace.endSection();
                        if (iIntValue != -1) {
                            CaptureSequences captureSequences3 = CaptureSequences.INSTANCE;
                            Debug debug11 = Debug.INSTANCE;
                            Trace.beginSection("InvokeInternalListeners");
                            int size9 = captureSequenceBuild.getCaptureMetadataList().size();
                            for (int i9 = 0; i9 < size9; i9++) {
                                RequestMetadata requestMetadata5 = captureSequenceBuild.getCaptureMetadataList().get(i9);
                                int size10 = captureSequenceBuild.getListeners().size();
                                for (int i10 = 0; i10 < size10; i10++) {
                                    captureSequenceBuild.getListeners().get(i10).onRequestSequenceSubmitted(requestMetadata5);
                                }
                            }
                            Debug debug12 = Debug.INSTANCE;
                            Trace.endSection();
                            Debug debug13 = Debug.INSTANCE;
                            Trace.beginSection("InvokeRequestListeners");
                            int size11 = captureSequenceBuild.getCaptureMetadataList().size();
                            for (int i11 = 0; i11 < size11; i11++) {
                                RequestMetadata requestMetadata6 = captureSequenceBuild.getCaptureMetadataList().get(i11);
                                int size12 = requestMetadata6.getRequest().getListeners().size();
                                for (int i12 = 0; i12 < size12; i12++) {
                                    requestMetadata6.getRequest().getListeners().get(i12).onRequestSequenceSubmitted(requestMetadata6);
                                }
                            }
                            Debug debug14 = Debug.INSTANCE;
                            Trace.endSection();
                            try {
                                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                                    android.util.Log.d(Log.TAG, this + " submitted " + captureSequenceBuild);
                                }
                                z = true;
                            } catch (CameraAccessException unused) {
                                if (!z2 && !captureSequenceBuild.getRepeating()) {
                                    synchronized (this.activeCaptureSequences) {
                                        this.activeCaptureSequences.remove(captureSequenceBuild);
                                    }
                                    CaptureSequences captureSequences4 = CaptureSequences.INSTANCE;
                                    Debug debug15 = Debug.INSTANCE;
                                    Trace.beginSection("InvokeInternalListeners");
                                    int size13 = captureSequenceBuild.getCaptureMetadataList().size();
                                    for (int i13 = 0; i13 < size13; i13++) {
                                        RequestMetadata requestMetadata7 = captureSequenceBuild.getCaptureMetadataList().get(i13);
                                        int size14 = captureSequenceBuild.getListeners().size();
                                        for (int i14 = 0; i14 < size14; i14++) {
                                            captureSequenceBuild.getListeners().get(i14).onAborted(requestMetadata7.getRequest());
                                        }
                                    }
                                    Debug debug16 = Debug.INSTANCE;
                                    Trace.endSection();
                                    Debug debug17 = Debug.INSTANCE;
                                    Trace.beginSection("InvokeRequestListeners");
                                    int size15 = captureSequenceBuild.getCaptureMetadataList().size();
                                    for (int i15 = 0; i15 < size15; i15++) {
                                        RequestMetadata requestMetadata8 = captureSequenceBuild.getCaptureMetadataList().get(i15);
                                        int size16 = requestMetadata8.getRequest().getListeners().size();
                                        for (int i16 = 0; i16 < size16; i16++) {
                                            requestMetadata8.getRequest().getListeners().get(i16).onAborted(requestMetadata8.getRequest());
                                        }
                                    }
                                    Debug debug18 = Debug.INSTANCE;
                                    Trace.endSection();
                                }
                                return false;
                            } catch (ObjectUnavailableException unused2) {
                                if (!z2 && !captureSequenceBuild.getRepeating()) {
                                    synchronized (this.activeCaptureSequences) {
                                        this.activeCaptureSequences.remove(captureSequenceBuild);
                                    }
                                    CaptureSequences captureSequences5 = CaptureSequences.INSTANCE;
                                    Debug debug19 = Debug.INSTANCE;
                                    Trace.beginSection("InvokeInternalListeners");
                                    int size17 = captureSequenceBuild.getCaptureMetadataList().size();
                                    for (int i17 = 0; i17 < size17; i17++) {
                                        RequestMetadata requestMetadata9 = captureSequenceBuild.getCaptureMetadataList().get(i17);
                                        int size18 = captureSequenceBuild.getListeners().size();
                                        for (int i18 = 0; i18 < size18; i18++) {
                                            captureSequenceBuild.getListeners().get(i18).onAborted(requestMetadata9.getRequest());
                                        }
                                    }
                                    Debug debug20 = Debug.INSTANCE;
                                    Trace.endSection();
                                    Debug debug21 = Debug.INSTANCE;
                                    Trace.beginSection("InvokeRequestListeners");
                                    int size19 = captureSequenceBuild.getCaptureMetadataList().size();
                                    for (int i19 = 0; i19 < size19; i19++) {
                                        RequestMetadata requestMetadata10 = captureSequenceBuild.getCaptureMetadataList().get(i19);
                                        int size20 = requestMetadata10.getRequest().getListeners().size();
                                        for (int i20 = 0; i20 < size20; i20++) {
                                            requestMetadata10.getRequest().getListeners().get(i20).onAborted(requestMetadata10.getRequest());
                                        }
                                    }
                                    Debug debug22 = Debug.INSTANCE;
                                    Trace.endSection();
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                if (z2 || captureSequenceBuild.getRepeating()) {
                                    throw th;
                                }
                                synchronized (this.activeCaptureSequences) {
                                    this.activeCaptureSequences.remove(captureSequenceBuild);
                                }
                                CaptureSequences captureSequences6 = CaptureSequences.INSTANCE;
                                Debug debug23 = Debug.INSTANCE;
                                Trace.beginSection("InvokeInternalListeners");
                                int size21 = captureSequenceBuild.getCaptureMetadataList().size();
                                for (int i21 = 0; i21 < size21; i21++) {
                                    RequestMetadata requestMetadata11 = captureSequenceBuild.getCaptureMetadataList().get(i21);
                                    int size22 = captureSequenceBuild.getListeners().size();
                                    for (int i22 = 0; i22 < size22; i22++) {
                                        captureSequenceBuild.getListeners().get(i22).onAborted(requestMetadata11.getRequest());
                                    }
                                }
                                Debug debug24 = Debug.INSTANCE;
                                Trace.endSection();
                                Debug debug25 = Debug.INSTANCE;
                                Trace.beginSection("InvokeRequestListeners");
                                int size23 = captureSequenceBuild.getCaptureMetadataList().size();
                                for (int i23 = 0; i23 < size23; i23++) {
                                    RequestMetadata requestMetadata12 = captureSequenceBuild.getCaptureMetadataList().get(i23);
                                    int size24 = requestMetadata12.getRequest().getListeners().size();
                                    for (int i24 = 0; i24 < size24; i24++) {
                                        requestMetadata12.getRequest().getListeners().get(i24).onAborted(requestMetadata12.getRequest());
                                    }
                                }
                                Debug debug26 = Debug.INSTANCE;
                                Trace.endSection();
                                throw th;
                            }
                        } else {
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to submit " + captureSequenceBuild + ": " + this + " received -1 from submit.");
                            }
                            z = false;
                            z2 = false;
                        }
                        if (z || captureSequenceBuild.getRepeating()) {
                            return z2;
                        }
                        synchronized (this.activeCaptureSequences) {
                            this.activeCaptureSequences.remove(captureSequenceBuild);
                        }
                        CaptureSequences captureSequences7 = CaptureSequences.INSTANCE;
                        Debug debug27 = Debug.INSTANCE;
                        Trace.beginSection("InvokeInternalListeners");
                        int size25 = captureSequenceBuild.getCaptureMetadataList().size();
                        for (int i25 = 0; i25 < size25; i25++) {
                            RequestMetadata requestMetadata13 = captureSequenceBuild.getCaptureMetadataList().get(i25);
                            int size26 = captureSequenceBuild.getListeners().size();
                            for (int i26 = 0; i26 < size26; i26++) {
                                captureSequenceBuild.getListeners().get(i26).onAborted(requestMetadata13.getRequest());
                            }
                        }
                        Debug debug28 = Debug.INSTANCE;
                        Trace.endSection();
                        Debug debug29 = Debug.INSTANCE;
                        Trace.beginSection("InvokeRequestListeners");
                        int size27 = captureSequenceBuild.getCaptureMetadataList().size();
                        for (int i27 = 0; i27 < size27; i27++) {
                            RequestMetadata requestMetadata14 = captureSequenceBuild.getCaptureMetadataList().get(i27);
                            int size28 = requestMetadata14.getRequest().getListeners().size();
                            for (int i28 = 0; i28 < size28; i28++) {
                                requestMetadata14.getRequest().getListeners().get(i28).onAborted(requestMetadata14.getRequest());
                            }
                        }
                        Debug debug30 = Debug.INSTANCE;
                        Trace.endSection();
                        return z2;
                    } catch (Throwable th3) {
                        Trace.endSection();
                        throw th3;
                    }
                }
            } catch (CameraAccessException unused3) {
                z2 = false;
            } catch (ObjectUnavailableException unused4) {
                z2 = false;
            } catch (Throwable th4) {
                th = th4;
                z2 = false;
            }
        } catch (Throwable th5) {
            Trace.endSection();
            throw th5;
        }
    }

    public String toString() {
        return "GraphRequestProcessor-" + this.debugId;
    }

    private final <T> void invokeOnAborted(CaptureSequence<? extends T> captureSequence) {
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = captureSequence.getCaptureMetadataList().size();
        for (int i = 0; i < size; i++) {
            RequestMetadata requestMetadata = captureSequence.getCaptureMetadataList().get(i);
            int size2 = captureSequence.getListeners().size();
            for (int i2 = 0; i2 < size2; i2++) {
                captureSequence.getListeners().get(i2).onAborted(requestMetadata.getRequest());
            }
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug3 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size3 = captureSequence.getCaptureMetadataList().size();
        for (int i3 = 0; i3 < size3; i3++) {
            RequestMetadata requestMetadata2 = captureSequence.getCaptureMetadataList().get(i3);
            int size4 = requestMetadata2.getRequest().getListeners().size();
            for (int i4 = 0; i4 < size4; i4++) {
                requestMetadata2.getRequest().getListeners().get(i4).onAborted(requestMetadata2.getRequest());
            }
        }
        Debug debug4 = Debug.INSTANCE;
        Trace.endSection();
    }

    private final <T> void invokeOnRequestSequenceCreated(CaptureSequence<? extends T> captureSequence) {
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = captureSequence.getCaptureMetadataList().size();
        for (int i = 0; i < size; i++) {
            RequestMetadata requestMetadata = captureSequence.getCaptureMetadataList().get(i);
            int size2 = captureSequence.getListeners().size();
            for (int i2 = 0; i2 < size2; i2++) {
                captureSequence.getListeners().get(i2).onRequestSequenceCreated(requestMetadata);
            }
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug3 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size3 = captureSequence.getCaptureMetadataList().size();
        for (int i3 = 0; i3 < size3; i3++) {
            RequestMetadata requestMetadata2 = captureSequence.getCaptureMetadataList().get(i3);
            int size4 = requestMetadata2.getRequest().getListeners().size();
            for (int i4 = 0; i4 < size4; i4++) {
                requestMetadata2.getRequest().getListeners().get(i4).onRequestSequenceCreated(requestMetadata2);
            }
        }
        Debug debug4 = Debug.INSTANCE;
        Trace.endSection();
    }

    private final <T> void invokeOnRequestSequenceSubmitted(CaptureSequence<? extends T> captureSequence) {
        CaptureSequences captureSequences = CaptureSequences.INSTANCE;
        Debug debug = Debug.INSTANCE;
        Trace.beginSection("InvokeInternalListeners");
        int size = captureSequence.getCaptureMetadataList().size();
        for (int i = 0; i < size; i++) {
            RequestMetadata requestMetadata = captureSequence.getCaptureMetadataList().get(i);
            int size2 = captureSequence.getListeners().size();
            for (int i2 = 0; i2 < size2; i2++) {
                captureSequence.getListeners().get(i2).onRequestSequenceSubmitted(requestMetadata);
            }
        }
        Debug debug2 = Debug.INSTANCE;
        Trace.endSection();
        Debug debug3 = Debug.INSTANCE;
        Trace.beginSection("InvokeRequestListeners");
        int size3 = captureSequence.getCaptureMetadataList().size();
        for (int i3 = 0; i3 < size3; i3++) {
            RequestMetadata requestMetadata2 = captureSequence.getCaptureMetadataList().get(i3);
            int size4 = requestMetadata2.getRequest().getListeners().size();
            for (int i4 = 0; i4 < size4; i4++) {
                requestMetadata2.getRequest().getListeners().get(i4).onRequestSequenceSubmitted(requestMetadata2);
            }
        }
        Debug debug4 = Debug.INSTANCE;
        Trace.endSection();
    }
}
