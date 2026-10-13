package androidx.camera.camera2.pipe;

import java.util.Set;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Frame.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 #2\u00020\u0001:\u0001#J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u001c\u0010 \u001a\u0004\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001dH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0003"}, d2 = {"Landroidx/camera/camera2/pipe/FrameReference;", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "getRequestMetadata", "()Landroidx/camera/camera2/pipe/RequestMetadata;", "frameId", "Landroidx/camera/camera2/pipe/FrameId;", "getFrameId-OMxQvVY", "()J", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "getFrameNumber-Ugla2oM", "frameTimestamp", "Landroidx/camera/camera2/pipe/CameraTimestamp;", "getFrameTimestamp-LS1Wq50", "frameInfoStatus", "Landroidx/camera/camera2/pipe/OutputStatus;", "getFrameInfoStatus-U7r42EA", "()I", "imageStatus", "streamId", "Landroidx/camera/camera2/pipe/StreamId;", "imageStatus-Oo2lJfM", "(I)I", "outputId", "Landroidx/camera/camera2/pipe/OutputId;", "imageStatus-BWjvHWQ", "imageStreams", "", "getImageStreams", "()Ljava/util/Set;", "tryAcquire", "Landroidx/camera/camera2/pipe/Frame;", "streamFilter", "Companion", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FrameReference {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: getFrameId-OMxQvVY, reason: not valid java name */
    long mo539getFrameIdOMxQvVY();

    /* JADX INFO: renamed from: getFrameInfoStatus-U7r42EA, reason: not valid java name */
    int mo540getFrameInfoStatusU7r42EA();

    /* JADX INFO: renamed from: getFrameNumber-Ugla2oM, reason: not valid java name */
    long mo541getFrameNumberUgla2oM();

    /* JADX INFO: renamed from: getFrameTimestamp-LS1Wq50, reason: not valid java name */
    long mo542getFrameTimestampLS1Wq50();

    Set<StreamId> getImageStreams();

    RequestMetadata getRequestMetadata();

    /* JADX INFO: renamed from: imageStatus-Oo2lJfM, reason: not valid java name */
    int mo544imageStatusOo2lJfM(int streamId);

    Frame tryAcquire(Set<StreamId> streamFilter);

    /* JADX INFO: compiled from: Frame.kt */
    @kotlin.Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: imageStatus-BWjvHWQ, reason: not valid java name */
        public static int m545imageStatusBWjvHWQ(FrameReference frameReference, int i) {
            return FrameReference.super.mo543imageStatusBWjvHWQ(i);
        }
    }

    /* JADX INFO: renamed from: imageStatus-BWjvHWQ, reason: not valid java name */
    default int mo543imageStatusBWjvHWQ(int outputId) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Frame tryAcquire$default(FrameReference frameReference, Set set, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryAcquire");
        }
        if ((i & 1) != 0) {
            set = null;
        }
        return frameReference.tryAcquire(set);
    }

    /* JADX INFO: compiled from: Frame.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¨\u0006\n"}, d2 = {"Landroidx/camera/camera2/pipe/FrameReference$Companion;", "", "<init>", "()V", "acquire", "Landroidx/camera/camera2/pipe/Frame;", "Landroidx/camera/camera2/pipe/FrameReference;", "streamFilter", "", "Landroidx/camera/camera2/pipe/StreamId;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Frame acquire$default(Companion companion, FrameReference frameReference, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = null;
            }
            return companion.acquire(frameReference, set);
        }

        public final Frame acquire(FrameReference frameReference, Set<StreamId> set) {
            Intrinsics.checkNotNullParameter(frameReference, "<this>");
            Frame frameTryAcquire = frameReference.tryAcquire(set);
            if (frameTryAcquire != null) {
                return frameTryAcquire;
            }
            throw new IllegalStateException(("Failed to acquire a strong reference to " + frameReference + '!').toString());
        }
    }
}
