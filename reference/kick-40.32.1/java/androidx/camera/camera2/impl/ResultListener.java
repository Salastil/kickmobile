package androidx.camera.camera2.impl;

import android.hardware.camera2.CaptureResult;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.FrameMetadata;
import androidx.camera.camera2.pipe.Request;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: compiled from: CapturePipeline.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/impl/ResultListener;", "Landroidx/camera/camera2/pipe/Request$Listener;", "timeLimitNs", "", "checker", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/FrameInfo;", "Lkotlin/ParameterName;", "name", "totalCaptureResult", "", "<init>", "(JLkotlin/jvm/functions/Function1;)V", "completeSignal", "Lkotlinx/coroutines/CompletableDeferred;", "result", "Lkotlinx/coroutines/Deferred;", "getResult", "()Lkotlinx/coroutines/Deferred;", "timestampOfFirstUpdateNs", "Ljava/lang/Long;", "onTotalCaptureResult", "", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "onTotalCaptureResult-CcXjc1I", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResultListener implements Request.Listener {
    private final Function1<FrameInfo, Boolean> checker;
    private final CompletableDeferred<FrameInfo> completeSignal;
    private final long timeLimitNs;
    private volatile Long timestampOfFirstUpdateNs;

    /* JADX WARN: Multi-variable type inference failed */
    public ResultListener(long j, Function1<? super FrameInfo, Boolean> checker) {
        Intrinsics.checkNotNullParameter(checker, "checker");
        this.timeLimitNs = j;
        this.checker = checker;
        this.completeSignal = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }

    public final Deferred<FrameInfo> getResult() {
        return this.completeSignal;
    }

    @Override // androidx.camera.camera2.pipe.Request.Listener
    /* JADX INFO: renamed from: onTotalCaptureResult-CcXjc1I */
    public void mo51onTotalCaptureResultCcXjc1I(RequestMetadata requestMetadata, long frameNumber, FrameInfo totalCaptureResult) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(totalCaptureResult, "totalCaptureResult");
        if (this.completeSignal.isCompleted() || this.completeSignal.isCancelled()) {
            return;
        }
        FrameMetadata metadata = totalCaptureResult.getMetadata();
        CaptureResult.Key SENSOR_TIMESTAMP = CaptureResult.SENSOR_TIMESTAMP;
        Intrinsics.checkNotNullExpressionValue(SENSOR_TIMESTAMP, "SENSOR_TIMESTAMP");
        Long l = (Long) metadata.get(SENSOR_TIMESTAMP);
        if (l != null && this.timestampOfFirstUpdateNs == null) {
            this.timestampOfFirstUpdateNs = l;
        }
        Long l2 = this.timestampOfFirstUpdateNs;
        if (this.timeLimitNs != 0 && l2 != null && l != null && l.longValue() - l2.longValue() > this.timeLimitNs) {
            this.completeSignal.complete(null);
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Wait for capture result timeout, current: " + l.longValue() + " first: " + l2.longValue());
                return;
            }
            return;
        }
        if (this.checker.invoke(totalCaptureResult).booleanValue()) {
            this.completeSignal.complete(totalCaptureResult);
        }
    }
}
