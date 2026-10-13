package androidx.camera.camera2.pipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007J\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t*\u00020\u0006H\u0007J\u000e\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007J\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007J\u0012\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t*\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/camera/camera2/pipe/FrameBuffers;", "", "<init>", "()V", "tryPeekFirst", "Landroidx/camera/camera2/pipe/Frame;", "Landroidx/camera/camera2/pipe/FrameBuffer;", "tryPeekLast", "tryPeekAll", "", "tryRemoveFirst", "tryRemoveLast", "tryRemoveAll", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameBuffers {
    public static final FrameBuffers INSTANCE = new FrameBuffers();

    private FrameBuffers() {
    }

    @JvmStatic
    public static final Frame tryPeekFirst(FrameBuffer frameBuffer) {
        Intrinsics.checkNotNullParameter(frameBuffer, "<this>");
        FrameReference frameReferencePeekFirstReference = frameBuffer.peekFirstReference();
        if (frameReferencePeekFirstReference != null) {
            return FrameReference.tryAcquire$default(frameReferencePeekFirstReference, null, 1, null);
        }
        return null;
    }

    @JvmStatic
    public static final Frame tryPeekLast(FrameBuffer frameBuffer) {
        Intrinsics.checkNotNullParameter(frameBuffer, "<this>");
        FrameReference frameReferencePeekLastReference = frameBuffer.peekLastReference();
        if (frameReferencePeekLastReference != null) {
            return FrameReference.tryAcquire$default(frameReferencePeekLastReference, null, 1, null);
        }
        return null;
    }

    @JvmStatic
    public static final List<Frame> tryPeekAll(FrameBuffer frameBuffer) {
        Intrinsics.checkNotNullParameter(frameBuffer, "<this>");
        List<FrameReference> listPeekAllReferences = frameBuffer.peekAllReferences();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listPeekAllReferences.iterator();
        while (it.hasNext()) {
            Frame frameTryAcquire$default = FrameReference.tryAcquire$default((FrameReference) it.next(), null, 1, null);
            if (frameTryAcquire$default != null) {
                arrayList.add(frameTryAcquire$default);
            }
        }
        return arrayList;
    }

    @JvmStatic
    public static final Frame tryRemoveFirst(FrameBuffer frameBuffer) {
        Intrinsics.checkNotNullParameter(frameBuffer, "<this>");
        FrameReference frameReferenceRemoveFirstReference = frameBuffer.removeFirstReference();
        if (frameReferenceRemoveFirstReference != null) {
            return FrameReference.tryAcquire$default(frameReferenceRemoveFirstReference, null, 1, null);
        }
        return null;
    }

    @JvmStatic
    public static final Frame tryRemoveLast(FrameBuffer frameBuffer) {
        Intrinsics.checkNotNullParameter(frameBuffer, "<this>");
        FrameReference frameReferenceRemoveLastReference = frameBuffer.removeLastReference();
        if (frameReferenceRemoveLastReference != null) {
            return FrameReference.tryAcquire$default(frameReferenceRemoveLastReference, null, 1, null);
        }
        return null;
    }

    @JvmStatic
    public static final List<Frame> tryRemoveAll(FrameBuffer frameBuffer) {
        Intrinsics.checkNotNullParameter(frameBuffer, "<this>");
        List<FrameReference> listRemoveAllReferences = frameBuffer.removeAllReferences();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listRemoveAllReferences.iterator();
        while (it.hasNext()) {
            Frame frameTryAcquire$default = FrameReference.tryAcquire$default((FrameReference) it.next(), null, 1, null);
            if (frameTryAcquire$default != null) {
                arrayList.add(frameTryAcquire$default);
            }
        }
        return arrayList;
    }
}
