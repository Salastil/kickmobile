package androidx.camera.camera2.pipe.media;

import androidx.camera.camera2.pipe.OutputId;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageSource.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/media/ExpectedOutputsListener;", "", "onExpectedOutputs", "", "outputTimestamp", "", "outputIds", "", "Landroidx/camera/camera2/pipe/OutputId;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ExpectedOutputsListener {
    void onExpectedOutputs(long outputTimestamp, Set<OutputId> outputIds);
}
