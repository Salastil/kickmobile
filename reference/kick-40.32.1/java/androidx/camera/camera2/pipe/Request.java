package androidx.camera.camera2.pipe;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Requests.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001(Bq\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0007H\u0086\u0002¢\u0006\u0002\u0010\u001fJ$\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\tH\u0086\u0002¢\u0006\u0002\u0010 J#\u0010!\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\tH\u0002¢\u0006\u0002\u0010 J#\u0010!\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0007H\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020#J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'H\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R!\u0010\b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Landroidx/camera/camera2/pipe/Request;", "", "streams", "", "Landroidx/camera/camera2/pipe/StreamId;", "parameters", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "extras", "Landroidx/camera/camera2/pipe/Metadata$Key;", "listeners", "Landroidx/camera/camera2/pipe/Request$Listener;", "template", "Landroidx/camera/camera2/pipe/RequestTemplate;", "inputRequest", "Landroidx/camera/camera2/pipe/InputRequest;", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Landroidx/camera/camera2/pipe/RequestTemplate;Landroidx/camera/camera2/pipe/InputRequest;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStreams", "()Ljava/util/List;", "getParameters", "()Ljava/util/Map;", "getExtras", "getListeners", "getTemplate-ejQnlcg", "()Landroidx/camera/camera2/pipe/RequestTemplate;", "getInputRequest", "()Landroidx/camera/camera2/pipe/InputRequest;", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Landroid/hardware/camera2/CaptureRequest$Key;)Ljava/lang/Object;", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "getUnchecked", "toString", "", "toStringVerbose", "toStringInternal", "verbose", "", "Listener", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Request {
    private final Map<Metadata.Key<?>, Object> extras;
    private final InputRequest inputRequest;
    private final List<Listener> listeners;
    private final Map<CaptureRequest.Key<?>, Object> parameters;
    private final List<StreamId> streams;
    private final RequestTemplate template;

    public /* synthetic */ Request(List list, Map map, Map map2, List list2, RequestTemplate requestTemplate, InputRequest inputRequest, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, map, map2, list2, requestTemplate, inputRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Request(List<StreamId> streams, Map<CaptureRequest.Key<?>, ? extends Object> parameters, Map<Metadata.Key<?>, ? extends Object> extras, List<? extends Listener> listeners, RequestTemplate requestTemplate, InputRequest inputRequest) {
        Intrinsics.checkNotNullParameter(streams, "streams");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.streams = streams;
        this.parameters = parameters;
        this.extras = extras;
        this.listeners = listeners;
        this.template = requestTemplate;
        this.inputRequest = inputRequest;
    }

    public final List<StreamId> getStreams() {
        return this.streams;
    }

    public /* synthetic */ Request(List list, Map map, Map map2, List list2, RequestTemplate requestTemplate, InputRequest inputRequest, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? null : requestTemplate, (i & 32) != 0 ? null : inputRequest, null);
    }

    public final Map<CaptureRequest.Key<?>, Object> getParameters() {
        return this.parameters;
    }

    public final Map<Metadata.Key<?>, Object> getExtras() {
        return this.extras;
    }

    public final List<Listener> getListeners() {
        return this.listeners;
    }

    /* JADX INFO: renamed from: getTemplate-ejQnlcg, reason: not valid java name and from getter */
    public final RequestTemplate getTemplate() {
        return this.template;
    }

    public final InputRequest getInputRequest() {
        return this.inputRequest;
    }

    public final <T> T get(CaptureRequest.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) getUnchecked(key);
    }

    public final <T> T get(Metadata.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) getUnchecked(key);
    }

    /* JADX INFO: compiled from: Requests.kt */
    @kotlin.Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J'\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u0018J'\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010\u000bJ'\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0017¢\u0006\u0004\b'\u0010(J/\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u00102\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u00103\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001f\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u00106ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00067À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/Request$Listener;", "", "onStarted", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "timestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "onStarted-uGKBvU4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JJ)V", "onPartialCaptureResult", "captureResult", "Landroidx/camera/camera2/pipe/FrameMetadata;", "onPartialCaptureResult-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameMetadata;)V", "onCaptureProgress", "progress", "", "onTotalCaptureResult", "totalCaptureResult", "Landroidx/camera/camera2/pipe/FrameInfo;", "onTotalCaptureResult-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;)V", "onComplete", "result", "onComplete-CcXjc1I", "onFailed", "requestFailure", "Landroidx/camera/camera2/pipe/RequestFailure;", "onFailed-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/RequestFailure;)V", "onReadoutStarted", "Landroidx/camera/camera2/pipe/SensorTimestamp;", "onReadoutStarted-mP9r-9w", "onBufferLost", "stream", "Landroidx/camera/camera2/pipe/StreamId;", "onBufferLost-DlC0U5Y", "(Landroidx/camera/camera2/pipe/RequestMetadata;JI)V", "streamId", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "onBufferLost-iiEMlm4", "(Landroidx/camera/camera2/pipe/RequestMetadata;JII)V", "onAborted", "request", "Landroidx/camera/camera2/pipe/Request;", "onRequestSequenceCreated", "onRequestSequenceSubmitted", "onRequestSequenceAborted", "onRequestSequenceCompleted", "onRequestSequenceCompleted-RuT0dZU", "(Landroidx/camera/camera2/pipe/RequestMetadata;J)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Listener {
        default void onAborted(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
        }

        @Deprecated(message = "Use the onBufferLost with OutputId.")
        /* JADX INFO: renamed from: onBufferLost-DlC0U5Y, reason: not valid java name */
        default void m696onBufferLostDlC0U5Y(RequestMetadata requestMetadata, long frameNumber, int stream) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        /* JADX INFO: renamed from: onBufferLost-iiEMlm4 */
        default void mo83onBufferLostiiEMlm4(RequestMetadata requestMetadata, long frameNumber, int streamId, int outputId) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        default void onCaptureProgress(RequestMetadata requestMetadata, int progress) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        /* JADX INFO: renamed from: onComplete-CcXjc1I */
        default void mo49onCompleteCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo result) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(result, "result");
        }

        /* JADX INFO: renamed from: onFailed-CcXjc1I */
        default void mo50onFailedCcXjc1I(RequestMetadata requestMetadata, long frameNumber, RequestFailure requestFailure) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
        }

        /* JADX INFO: renamed from: onPartialCaptureResult-CcXjc1I */
        default void mo84onPartialCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameMetadata captureResult) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(captureResult, "captureResult");
        }

        /* JADX INFO: renamed from: onReadoutStarted-mP9r-9w */
        default void mo85onReadoutStartedmP9r9w(RequestMetadata requestMetadata, long frameNumber, long timestamp) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        default void onRequestSequenceAborted(RequestMetadata requestMetadata) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        /* JADX INFO: renamed from: onRequestSequenceCompleted-RuT0dZU */
        default void mo86onRequestSequenceCompletedRuT0dZU(RequestMetadata requestMetadata, long frameNumber) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        default void onRequestSequenceCreated(RequestMetadata requestMetadata) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        default void onRequestSequenceSubmitted(RequestMetadata requestMetadata) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        /* JADX INFO: renamed from: onStarted-uGKBvU4 */
        default void mo87onStarteduGKBvU4(RequestMetadata requestMetadata, long frameNumber, long timestamp) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        }

        /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I */
        default void mo51onTotalCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo totalCaptureResult) {
            Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
            Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
        }

        /* JADX INFO: compiled from: Requests.kt */
        @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            /* JADX INFO: renamed from: onStarted-uGKBvU4, reason: not valid java name */
            public static void m704onStarteduGKBvU4(Listener listener, RequestMetadata requestMetadata, long j, long j2) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.mo87onStarteduGKBvU4(requestMetadata, j, j2);
            }

            @Deprecated
            /* JADX INFO: renamed from: onPartialCaptureResult-CcXjc1I, reason: not valid java name */
            public static void m701onPartialCaptureResultCcXjc1I(Listener listener, RequestMetadata requestMetadata, long j, FrameMetadata captureResult) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Intrinsics.checkNotNullParameter(captureResult, "captureResult");
                Listener.super.mo84onPartialCaptureResultCcXjc1I(requestMetadata, j, captureResult);
            }

            @Deprecated
            public static void onCaptureProgress(Listener listener, RequestMetadata requestMetadata, int i) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.onCaptureProgress(requestMetadata, i);
            }

            @Deprecated
            /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I, reason: not valid java name */
            public static void m705onTotalCaptureResultCcXjc1I(Listener listener, RequestMetadata requestMetadata, long j, FrameInfo totalCaptureResult) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
                Listener.super.mo51onTotalCaptureResultCcXjc1I(requestMetadata, j, totalCaptureResult);
            }

            @Deprecated
            /* JADX INFO: renamed from: onComplete-CcXjc1I, reason: not valid java name */
            public static void m699onCompleteCcXjc1I(Listener listener, RequestMetadata requestMetadata, long j, FrameInfo result) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Intrinsics.checkNotNullParameter(result, "result");
                Listener.super.mo49onCompleteCcXjc1I(requestMetadata, j, result);
            }

            @Deprecated
            /* JADX INFO: renamed from: onFailed-CcXjc1I, reason: not valid java name */
            public static void m700onFailedCcXjc1I(Listener listener, RequestMetadata requestMetadata, long j, RequestFailure requestFailure) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Intrinsics.checkNotNullParameter(requestFailure, "requestFailure");
                Listener.super.mo50onFailedCcXjc1I(requestMetadata, j, requestFailure);
            }

            @Deprecated
            /* JADX INFO: renamed from: onReadoutStarted-mP9r-9w, reason: not valid java name */
            public static void m702onReadoutStartedmP9r9w(Listener listener, RequestMetadata requestMetadata, long j, long j2) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.mo85onReadoutStartedmP9r9w(requestMetadata, j, j2);
            }

            @Deprecated(message = "Use the onBufferLost with OutputId.")
            @Deprecated
            /* JADX INFO: renamed from: onBufferLost-DlC0U5Y, reason: not valid java name */
            public static void m697onBufferLostDlC0U5Y(Listener listener, RequestMetadata requestMetadata, long j, int i) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.m696onBufferLostDlC0U5Y(requestMetadata, j, i);
            }

            @Deprecated
            /* JADX INFO: renamed from: onBufferLost-iiEMlm4, reason: not valid java name */
            public static void m698onBufferLostiiEMlm4(Listener listener, RequestMetadata requestMetadata, long j, int i, int i2) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.mo83onBufferLostiiEMlm4(requestMetadata, j, i, i2);
            }

            @Deprecated
            public static void onAborted(Listener listener, Request request) {
                Intrinsics.checkNotNullParameter(request, "request");
                Listener.super.onAborted(request);
            }

            @Deprecated
            public static void onRequestSequenceCreated(Listener listener, RequestMetadata requestMetadata) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.onRequestSequenceCreated(requestMetadata);
            }

            @Deprecated
            public static void onRequestSequenceSubmitted(Listener listener, RequestMetadata requestMetadata) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.onRequestSequenceSubmitted(requestMetadata);
            }

            @Deprecated
            public static void onRequestSequenceAborted(Listener listener, RequestMetadata requestMetadata) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.onRequestSequenceAborted(requestMetadata);
            }

            @Deprecated
            /* JADX INFO: renamed from: onRequestSequenceCompleted-RuT0dZU, reason: not valid java name */
            public static void m703onRequestSequenceCompletedRuT0dZU(Listener listener, RequestMetadata requestMetadata, long j) {
                Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
                Listener.super.mo86onRequestSequenceCompletedRuT0dZU(requestMetadata, j);
            }
        }
    }

    private final <T> T getUnchecked(Metadata.Key<T> key) {
        return (T) this.extras.get(key);
    }

    private final <T> T getUnchecked(CaptureRequest.Key<T> key) {
        return (T) this.parameters.get(key);
    }

    public String toString() {
        return toStringInternal(false);
    }

    public final String toStringVerbose() {
        return toStringInternal(true);
    }

    private final String toStringInternal(boolean verbose) {
        String str;
        String str2;
        String str3 = "";
        if (this.template == null) {
            str = "";
        } else {
            str = ", template=" + ((Object) RequestTemplate.m720toStringimpl(this.template.m721unboximpl()));
        }
        if (!verbose || this.parameters.isEmpty()) {
            str2 = "";
        } else {
            str2 = ", parameters=" + Debug.INSTANCE.formatParameterMap(this.parameters, 5);
        }
        if (verbose && !this.extras.isEmpty()) {
            str3 = ", extras=" + Debug.INSTANCE.formatParameterMap(this.extras, 5);
        }
        return "Request(streams=" + this.streams + str + str2 + str3 + ")@" + Integer.toHexString(hashCode());
    }
}
