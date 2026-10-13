package androidx.camera.camera2.pipe;

import androidx.camera.camera2.pipe.media.ImageSource;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: StreamGraph.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001$J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H¦\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\tH&¢\u0006\u0004\b\"\u0010#R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006%À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/StreamGraph;", "", "streams", "", "Landroidx/camera/camera2/pipe/CameraStream;", "getStreams", "()Ljava/util/List;", "streamIds", "", "Landroidx/camera/camera2/pipe/StreamId;", "getStreamIds", "()Ljava/util/Set;", "inputs", "Landroidx/camera/camera2/pipe/InputStream;", "getInputs", "outputs", "Landroidx/camera/camera2/pipe/OutputStream;", "getOutputs", "get", "config", "Landroidx/camera/camera2/pipe/CameraStream$Config;", "streamId", "get-aKI5c8E", "(I)Landroidx/camera/camera2/pipe/CameraStream;", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "get-iYJqvbA", "(I)Landroidx/camera/camera2/pipe/OutputStream;", "getOutputLatency", "Landroidx/camera/camera2/pipe/StreamGraph$OutputLatency;", "getOutputLatency-IL232MI", "(ILandroidx/camera/camera2/pipe/OutputId;)Landroidx/camera/camera2/pipe/StreamGraph$OutputLatency;", "getImageSource", "Landroidx/camera/camera2/pipe/media/ImageSource;", "getImageSource-aKI5c8E", "(I)Landroidx/camera/camera2/pipe/media/ImageSource;", "OutputLatency", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface StreamGraph {
    CameraStream get(CameraStream.Config config);

    /* JADX INFO: renamed from: getImageSource-aKI5c8E, reason: not valid java name */
    ImageSource mo786getImageSourceaKI5c8E(int streamId);

    List<InputStream> getInputs();

    /* JADX INFO: renamed from: getOutputLatency-IL232MI, reason: not valid java name */
    OutputLatency mo787getOutputLatencyIL232MI(int streamId, OutputId outputId);

    List<OutputStream> getOutputs();

    Set<StreamId> getStreamIds();

    List<CameraStream> getStreams();

    /* JADX INFO: compiled from: StreamGraph.kt */
    @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: get-aKI5c8E, reason: not valid java name */
        public static CameraStream m788getaKI5c8E(StreamGraph streamGraph, int i) {
            return StreamGraph.super.m784getaKI5c8E(i);
        }

        @Deprecated
        /* JADX INFO: renamed from: get-iYJqvbA, reason: not valid java name */
        public static OutputStream m789getiYJqvbA(StreamGraph streamGraph, int i) {
            return StreamGraph.super.m785getiYJqvbA(i);
        }
    }

    /* JADX INFO: renamed from: get-aKI5c8E, reason: not valid java name */
    default CameraStream m784getaKI5c8E(int streamId) {
        Object next;
        Iterator<T> it = getStreams().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (StreamId.m794equalsimpl0(((CameraStream) next).getId(), streamId)) {
                return (CameraStream) next;
            }
        }
        next = null;
        return (CameraStream) next;
    }

    /* JADX INFO: renamed from: get-iYJqvbA, reason: not valid java name */
    default OutputStream m785getiYJqvbA(int outputId) {
        Object next;
        Iterator<T> it = getOutputs().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (OutputId.m574equalsimpl0(((OutputStream) next).getId(), outputId)) {
                return (OutputStream) next;
            }
        }
        next = null;
        return (OutputStream) next;
    }

    /* JADX INFO: renamed from: getOutputLatency-IL232MI$default, reason: not valid java name */
    static /* synthetic */ OutputLatency m783getOutputLatencyIL232MI$default(StreamGraph streamGraph, int i, OutputId outputId, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOutputLatency-IL232MI");
        }
        if ((i2 & 2) != 0) {
            outputId = null;
        }
        return streamGraph.mo787getOutputLatencyIL232MI(i, outputId);
    }

    /* JADX INFO: compiled from: StreamGraph.kt */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/StreamGraph$OutputLatency;", "", "estimatedCaptureLatencyNs", "", "estimatedProcessingLatencyNs", "<init>", "(JJ)V", "getEstimatedCaptureLatencyNs", "()J", "getEstimatedProcessingLatencyNs", "estimatedLatencyNs", "getEstimatedLatencyNs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class OutputLatency {
        private final long estimatedCaptureLatencyNs;
        private final long estimatedProcessingLatencyNs;

        public static /* synthetic */ OutputLatency copy$default(OutputLatency outputLatency, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = outputLatency.estimatedCaptureLatencyNs;
            }
            if ((i & 2) != 0) {
                j2 = outputLatency.estimatedProcessingLatencyNs;
            }
            return outputLatency.copy(j, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getEstimatedCaptureLatencyNs() {
            return this.estimatedCaptureLatencyNs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getEstimatedProcessingLatencyNs() {
            return this.estimatedProcessingLatencyNs;
        }

        public final OutputLatency copy(long estimatedCaptureLatencyNs, long estimatedProcessingLatencyNs) {
            return new OutputLatency(estimatedCaptureLatencyNs, estimatedProcessingLatencyNs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OutputLatency)) {
                return false;
            }
            OutputLatency outputLatency = (OutputLatency) other;
            return this.estimatedCaptureLatencyNs == outputLatency.estimatedCaptureLatencyNs && this.estimatedProcessingLatencyNs == outputLatency.estimatedProcessingLatencyNs;
        }

        public int hashCode() {
            return (Long.hashCode(this.estimatedCaptureLatencyNs) * 31) + Long.hashCode(this.estimatedProcessingLatencyNs);
        }

        public String toString() {
            return "OutputLatency(estimatedCaptureLatencyNs=" + this.estimatedCaptureLatencyNs + ", estimatedProcessingLatencyNs=" + this.estimatedProcessingLatencyNs + ')';
        }

        public OutputLatency(long j, long j2) {
            this.estimatedCaptureLatencyNs = j;
            this.estimatedProcessingLatencyNs = j2;
        }

        public final long getEstimatedCaptureLatencyNs() {
            return this.estimatedCaptureLatencyNs;
        }

        public final long getEstimatedProcessingLatencyNs() {
            return this.estimatedProcessingLatencyNs;
        }

        public final long getEstimatedLatencyNs() {
            return this.estimatedCaptureLatencyNs + this.estimatedProcessingLatencyNs;
        }
    }
}
