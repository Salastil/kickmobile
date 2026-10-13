package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.RequestNumber;
import kotlin.Metadata;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;
import kotlinx.atomicfu.AtomicLong;

/* JADX INFO: compiled from: Camera2CaptureSequenceProcessor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\u0010\f\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"captureSequenceProcessorDebugIds", "Lkotlinx/atomicfu/AtomicInt;", "getCaptureSequenceProcessorDebugIds", "()Lkotlinx/atomicfu/AtomicInt;", "captureSequenceDebugIds", "Lkotlinx/atomicfu/AtomicLong;", "getCaptureSequenceDebugIds", "()Lkotlinx/atomicfu/AtomicLong;", "requestTags", "getRequestTags", "nextRequestNumber", "Landroidx/camera/camera2/pipe/RequestNumber;", "()J", "REQUIRE_SURFACE_FOR_ALL_STREAMS", "", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class Camera2CaptureSequenceProcessorKt {
    private static final boolean REQUIRE_SURFACE_FOR_ALL_STREAMS = false;
    private static final AtomicInt captureSequenceProcessorDebugIds = AtomicFU.atomic(0);
    private static final AtomicLong captureSequenceDebugIds = AtomicFU.atomic(0L);
    private static final AtomicLong requestTags = AtomicFU.atomic(0L);

    public static final AtomicInt getCaptureSequenceProcessorDebugIds() {
        return captureSequenceProcessorDebugIds;
    }

    public static final AtomicLong getCaptureSequenceDebugIds() {
        return captureSequenceDebugIds;
    }

    public static final AtomicLong getRequestTags() {
        return requestTags;
    }

    public static final long nextRequestNumber() {
        return RequestNumber.m708constructorimpl(requestTags.incrementAndGet());
    }
}
