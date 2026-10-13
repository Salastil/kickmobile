package androidx.camera.camera2.pipe;

import io.ktor.http.ContentDisposition;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: FrameBuffer.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00060\u0001j\u0002`\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0019H&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0019H&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH&J\u001e\u0010 \u001a\u0004\u0018\u00010!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$0#H&J\u001e\u0010%\u001a\u0004\u0018\u00010!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$0#H&J\"\u0010&\u001a\b\u0012\u0004\u0012\u00020!0\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020$0#H&J\n\u0010'\u001a\u0004\u0018\u00010\u0019H&J\n\u0010(\u001a\u0004\u0018\u00010\u0019H&J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH&J\b\u0010*\u001a\u00020+H&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/FrameBuffer;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "streams", "", "Landroidx/camera/camera2/pipe/StreamId;", "getStreams", "()Ljava/util/Set;", "parameters", "", "", "getParameters", "()Ljava/util/Map;", "capacity", "", "getCapacity", "()I", "setCapacity", "(I)V", ContentDisposition.Parameters.Size, "Lkotlinx/coroutines/flow/StateFlow;", "getSize", "()Lkotlinx/coroutines/flow/StateFlow;", "frameFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Landroidx/camera/camera2/pipe/FrameReference;", "getFrameFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "removeFirstReference", "removeLastReference", "removeAllReferences", "", "removeFirstFrameReferenceAndAcquire", "Landroidx/camera/camera2/pipe/Frame;", "predicate", "Lkotlin/Function1;", "", "removeLastFrameReferenceAndAcquire", "removeAllFrameReferencesAndAcquire", "peekFirstReference", "peekLastReference", "peekAllReferences", "close", "", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FrameBuffer extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();

    int getCapacity();

    SharedFlow<FrameReference> getFrameFlow();

    Map<Object, Object> getParameters();

    StateFlow<Integer> getSize();

    Set<StreamId> getStreams();

    List<FrameReference> peekAllReferences();

    FrameReference peekFirstReference();

    FrameReference peekLastReference();

    List<Frame> removeAllFrameReferencesAndAcquire(Function1<? super FrameReference, Boolean> predicate);

    List<FrameReference> removeAllReferences();

    Frame removeFirstFrameReferenceAndAcquire(Function1<? super FrameReference, Boolean> predicate);

    FrameReference removeFirstReference();

    Frame removeLastFrameReferenceAndAcquire(Function1<? super FrameReference, Boolean> predicate);

    FrameReference removeLastReference();

    void setCapacity(int i);
}
