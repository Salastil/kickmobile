package com.facebook.react.devsupport.inspector;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.view.Display;
import android.view.FrameMetrics;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.facebook.react.uimanager.ViewProps;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: FrameTimingsObserver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 42\u00020\u0001:\u000234B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bJ\"\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$H\u0002J<\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010&\u001a\u00020$H\u0002J\u0010\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0014H\u0002JF\u0010.\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$2\u0014\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\n0\u0005H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010+2\u0006\u00101\u001a\u000202H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/facebook/react/devsupport/inspector/FrameTimingsObserver;", "", "screenshotsEnabled", "", "onFrameTimingSequence", "Lkotlin/Function1;", "Lcom/facebook/react/devsupport/inspector/FrameTimingSequence;", "Lkotlin/ParameterName;", "name", "sequence", "", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "isSupported", "mainHandler", "Landroid/os/Handler;", "encodingDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "lastFrameBuffer", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/facebook/react/devsupport/inspector/FrameTimingsObserver$FrameData;", "frameCounter", "", "encodingInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTracing", "currentWindow", "Landroid/view/Window;", ViewProps.START, "stop", "setCurrentWindow", "window", "frameMetricsListener", "Landroid/view/Window$OnFrameMetricsAvailableListener;", "emitFrameTiming", "beginTimestamp", "", "endTimestamp", "vsyncIntervalNanos", "emitFrameEvent", "frameId", "threadId", "screenshot", "", "encodeFrame", "frameData", "captureScreenshot", "callback", "encodeScreenshot", "bitmap", "Landroid/graphics/Bitmap;", "FrameData", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FrameTimingsObserver {
    private static final int SCREENSHOT_OUTPUT_SIZE_HINT = 65536;
    private static final int SCREENSHOT_QUALITY = 80;
    private static final float SCREENSHOT_SCALE_FACTOR = 1.0f;
    private volatile Window currentWindow;
    private final CoroutineDispatcher encodingDispatcher;
    private final AtomicBoolean encodingInProgress;
    private int frameCounter;
    private final Window.OnFrameMetricsAvailableListener frameMetricsListener;
    private final boolean isSupported;
    private volatile boolean isTracing;
    private final AtomicReference<FrameData> lastFrameBuffer;
    private final Handler mainHandler;
    private final Function1<FrameTimingSequence, Unit> onFrameTimingSequence;
    private final boolean screenshotsEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public FrameTimingsObserver(boolean z, Function1<? super FrameTimingSequence, Unit> onFrameTimingSequence) {
        Intrinsics.checkNotNullParameter(onFrameTimingSequence, "onFrameTimingSequence");
        this.screenshotsEnabled = z;
        this.onFrameTimingSequence = onFrameTimingSequence;
        this.isSupported = true;
        this.mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.encodingDispatcher = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        this.lastFrameBuffer = new AtomicReference<>(null);
        this.encodingInProgress = new AtomicBoolean(false);
        this.frameMetricsListener = new Window.OnFrameMetricsAvailableListener() { // from class: com.facebook.react.devsupport.inspector.FrameTimingsObserver$$ExternalSyntheticLambda3
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                FrameTimingsObserver.frameMetricsListener$lambda$0(this.f$0, window, frameMetrics, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: FrameTimingsObserver.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006#"}, d2 = {"Lcom/facebook/react/devsupport/inspector/FrameTimingsObserver$FrameData;", "", "bitmap", "Landroid/graphics/Bitmap;", "frameId", "", "threadId", "beginTimestamp", "", "endTimestamp", "vsyncIntervalNanos", "<init>", "(Landroid/graphics/Bitmap;IIJJJ)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getFrameId", "()I", "getThreadId", "getBeginTimestamp", "()J", "getEndTimestamp", "getVsyncIntervalNanos", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final /* data */ class FrameData {
        private final long beginTimestamp;
        private final Bitmap bitmap;
        private final long endTimestamp;
        private final int frameId;
        private final int threadId;
        private final long vsyncIntervalNanos;

        public static /* synthetic */ FrameData copy$default(FrameData frameData, Bitmap bitmap, int i, int i2, long j, long j2, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bitmap = frameData.bitmap;
            }
            if ((i3 & 2) != 0) {
                i = frameData.frameId;
            }
            if ((i3 & 4) != 0) {
                i2 = frameData.threadId;
            }
            if ((i3 & 8) != 0) {
                j = frameData.beginTimestamp;
            }
            if ((i3 & 16) != 0) {
                j2 = frameData.endTimestamp;
            }
            if ((i3 & 32) != 0) {
                j3 = frameData.vsyncIntervalNanos;
            }
            long j4 = j3;
            long j5 = j2;
            int i4 = i2;
            return frameData.copy(bitmap, i, i4, j, j5, j4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getFrameId() {
            return this.frameId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getThreadId() {
            return this.threadId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getBeginTimestamp() {
            return this.beginTimestamp;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getEndTimestamp() {
            return this.endTimestamp;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getVsyncIntervalNanos() {
            return this.vsyncIntervalNanos;
        }

        public final FrameData copy(Bitmap bitmap, int frameId, int threadId, long beginTimestamp, long endTimestamp, long vsyncIntervalNanos) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            return new FrameData(bitmap, frameId, threadId, beginTimestamp, endTimestamp, vsyncIntervalNanos);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FrameData)) {
                return false;
            }
            FrameData frameData = (FrameData) other;
            return Intrinsics.areEqual(this.bitmap, frameData.bitmap) && this.frameId == frameData.frameId && this.threadId == frameData.threadId && this.beginTimestamp == frameData.beginTimestamp && this.endTimestamp == frameData.endTimestamp && this.vsyncIntervalNanos == frameData.vsyncIntervalNanos;
        }

        public int hashCode() {
            return (((((((((this.bitmap.hashCode() * 31) + Integer.hashCode(this.frameId)) * 31) + Integer.hashCode(this.threadId)) * 31) + Long.hashCode(this.beginTimestamp)) * 31) + Long.hashCode(this.endTimestamp)) * 31) + Long.hashCode(this.vsyncIntervalNanos);
        }

        public String toString() {
            return "FrameData(bitmap=" + this.bitmap + ", frameId=" + this.frameId + ", threadId=" + this.threadId + ", beginTimestamp=" + this.beginTimestamp + ", endTimestamp=" + this.endTimestamp + ", vsyncIntervalNanos=" + this.vsyncIntervalNanos + ")";
        }

        public FrameData(Bitmap bitmap, int i, int i2, long j, long j2, long j3) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.bitmap = bitmap;
            this.frameId = i;
            this.threadId = i2;
            this.beginTimestamp = j;
            this.endTimestamp = j2;
            this.vsyncIntervalNanos = j3;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final int getFrameId() {
            return this.frameId;
        }

        public final int getThreadId() {
            return this.threadId;
        }

        public final long getBeginTimestamp() {
            return this.beginTimestamp;
        }

        public final long getEndTimestamp() {
            return this.endTimestamp;
        }

        public final long getVsyncIntervalNanos() {
            return this.vsyncIntervalNanos;
        }
    }

    public final void start() {
        if (this.isSupported) {
            this.frameCounter = 0;
            this.encodingInProgress.set(false);
            this.lastFrameBuffer.set(null);
            this.isTracing = true;
            long jNanoTime = System.nanoTime();
            emitFrameTiming(jNanoTime, jNanoTime, 0L);
            Window window = this.currentWindow;
            if (window != null) {
                window.addOnFrameMetricsAvailableListener(this.frameMetricsListener, this.mainHandler);
            }
        }
    }

    public final void stop() {
        Bitmap bitmap;
        if (this.isSupported) {
            this.isTracing = false;
            Window window = this.currentWindow;
            if (window != null) {
                window.removeOnFrameMetricsAvailableListener(this.frameMetricsListener);
            }
            this.mainHandler.removeCallbacksAndMessages(null);
            FrameData andSet = this.lastFrameBuffer.getAndSet(null);
            if (andSet == null || (bitmap = andSet.getBitmap()) == null) {
                return;
            }
            bitmap.recycle();
        }
    }

    public final void setCurrentWindow(Window window) {
        Window window2;
        if (!this.isSupported || this.currentWindow == window) {
            return;
        }
        Window window3 = this.currentWindow;
        if (window3 != null) {
            window3.removeOnFrameMetricsAvailableListener(this.frameMetricsListener);
        }
        this.currentWindow = window;
        if (!this.isTracing || (window2 = this.currentWindow) == null) {
            return;
        }
        window2.addOnFrameMetricsAvailableListener(this.frameMetricsListener, this.mainHandler);
    }

    static final void frameMetricsListener$lambda$0(FrameTimingsObserver frameTimingsObserver, Window window, FrameMetrics frameMetrics, int i) {
        if (frameTimingsObserver.isTracing) {
            long metric = frameMetrics.getMetric(11);
            long metric2 = metric + frameMetrics.getMetric(8);
            Display display = window.getDecorView().getDisplay();
            frameTimingsObserver.emitFrameTiming(metric, metric2, (long) (1.0E9f / (display != null ? display.getRefreshRate() : 60.0f)));
        }
    }

    static /* synthetic */ void emitFrameTiming$default(FrameTimingsObserver frameTimingsObserver, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j3 = 0;
        }
        frameTimingsObserver.emitFrameTiming(j, j2, j3);
    }

    private final void emitFrameTiming(final long beginTimestamp, final long endTimestamp, final long vsyncIntervalNanos) {
        final int i = this.frameCounter;
        this.frameCounter = i + 1;
        final int iMyTid = Process.myTid();
        if (!this.screenshotsEnabled) {
            emitFrameEvent(i, iMyTid, beginTimestamp, endTimestamp, null, vsyncIntervalNanos);
        } else {
            captureScreenshot(i, iMyTid, beginTimestamp, endTimestamp, vsyncIntervalNanos, new Function1() { // from class: com.facebook.react.devsupport.inspector.FrameTimingsObserver$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FrameTimingsObserver.emitFrameTiming$lambda$1(this.f$0, i, iMyTid, beginTimestamp, endTimestamp, vsyncIntervalNanos, (FrameTimingsObserver.FrameData) obj);
                }
            });
        }
    }

    static final Unit emitFrameTiming$lambda$1(FrameTimingsObserver frameTimingsObserver, int i, int i2, long j, long j2, long j3, FrameData frameData) {
        if (frameData != null) {
            if (frameTimingsObserver.encodingInProgress.compareAndSet(false, true)) {
                frameTimingsObserver.encodeFrame(frameData);
            } else {
                FrameData andSet = frameTimingsObserver.lastFrameBuffer.getAndSet(frameData);
                if (andSet != null) {
                    frameTimingsObserver.emitFrameEvent(andSet.getFrameId(), andSet.getThreadId(), andSet.getBeginTimestamp(), andSet.getEndTimestamp(), null, andSet.getVsyncIntervalNanos());
                    andSet.getBitmap().recycle();
                }
            }
        } else {
            frameTimingsObserver.emitFrameEvent(i, i2, j, j2, null, j3);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.inspector.FrameTimingsObserver$emitFrameEvent$1, reason: invalid class name */
    /* JADX INFO: compiled from: FrameTimingsObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.facebook.react.devsupport.inspector.FrameTimingsObserver$emitFrameEvent$1", f = "FrameTimingsObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $beginTimestamp;
        final /* synthetic */ long $endTimestamp;
        final /* synthetic */ int $frameId;
        final /* synthetic */ byte[] $screenshot;
        final /* synthetic */ int $threadId;
        final /* synthetic */ long $vsyncIntervalNanos;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, int i2, long j, long j2, byte[] bArr, long j3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$frameId = i;
            this.$threadId = i2;
            this.$beginTimestamp = j;
            this.$endTimestamp = j2;
            this.$screenshot = bArr;
            this.$vsyncIntervalNanos = j3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FrameTimingsObserver.this.new AnonymousClass1(this.$frameId, this.$threadId, this.$beginTimestamp, this.$endTimestamp, this.$screenshot, this.$vsyncIntervalNanos, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            FrameTimingsObserver.this.onFrameTimingSequence.invoke(new FrameTimingSequence(this.$frameId, this.$threadId, this.$beginTimestamp, this.$endTimestamp, this.$screenshot, this.$vsyncIntervalNanos));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitFrameEvent(int frameId, int threadId, long beginTimestamp, long endTimestamp, byte[] screenshot, long vsyncIntervalNanos) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(frameId, threadId, beginTimestamp, endTimestamp, screenshot, vsyncIntervalNanos, null), 3, null);
    }

    /* JADX INFO: renamed from: com.facebook.react.devsupport.inspector.FrameTimingsObserver$encodeFrame$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FrameTimingsObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.facebook.react.devsupport.inspector.FrameTimingsObserver$encodeFrame$1", f = "FrameTimingsObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FrameData $frameData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07751(FrameData frameData, Continuation<? super C07751> continuation) {
            super(2, continuation);
            this.$frameData = frameData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FrameTimingsObserver.this.new C07751(this.$frameData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    FrameTimingsObserver.this.emitFrameEvent(this.$frameData.getFrameId(), this.$frameData.getThreadId(), this.$frameData.getBeginTimestamp(), this.$frameData.getEndTimestamp(), FrameTimingsObserver.this.encodeScreenshot(this.$frameData.getBitmap()), this.$frameData.getVsyncIntervalNanos());
                    this.$frameData.getBitmap().recycle();
                    FrameTimingsObserver.this.encodingInProgress.set(false);
                    FrameData frameData = (FrameData) FrameTimingsObserver.this.lastFrameBuffer.getAndSet(null);
                    if (frameData != null) {
                        try {
                            FrameTimingsObserver.this.emitFrameEvent(frameData.getFrameId(), frameData.getThreadId(), frameData.getBeginTimestamp(), frameData.getEndTimestamp(), FrameTimingsObserver.this.encodeScreenshot(frameData.getBitmap()), frameData.getVsyncIntervalNanos());
                        } finally {
                            frameData.getBitmap().recycle();
                        }
                    }
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    this.$frameData.getBitmap().recycle();
                    throw th;
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void encodeFrame(FrameData frameData) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.encodingDispatcher), null, null, new C07751(frameData, null), 3, null);
    }

    private final void captureScreenshot(final int frameId, final int threadId, final long beginTimestamp, final long endTimestamp, final long vsyncIntervalNanos, final Function1<? super FrameData, Unit> callback) {
        if (Build.VERSION.SDK_INT < 26) {
            callback.invoke(null);
            return;
        }
        Window window = this.currentWindow;
        if (window == null) {
            callback.invoke(null);
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        PixelCopy.request(window, bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.facebook.react.devsupport.inspector.FrameTimingsObserver$$ExternalSyntheticLambda4
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                FrameTimingsObserver.captureScreenshot$lambda$2(callback, bitmapCreateBitmap, frameId, threadId, beginTimestamp, endTimestamp, vsyncIntervalNanos, i);
            }
        }, this.mainHandler);
    }

    static final void captureScreenshot$lambda$2(Function1 function1, Bitmap bitmap, int i, int i2, long j, long j2, long j3, int i3) {
        if (i3 == 0) {
            function1.invoke(new FrameData(bitmap, i, i2, j, j2, j3));
        } else {
            bitmap.recycle();
            function1.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] encodeScreenshot(Bitmap bitmap) throws Throwable {
        Bitmap bitmapCreateScaledBitmap;
        Bitmap bitmap2 = null;
        try {
            Window window = this.currentWindow;
            if (window == null) {
                return null;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f = window.getContext().getResources().getDisplayMetrics().density;
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) ((width / f) * 1.0f), (int) ((height / f) * 1.0f), true);
            try {
                Bitmap.CompressFormat compressFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.JPEG;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(65536);
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                    bitmapCreateScaledBitmap.compress(compressFormat, 80, byteArrayOutputStream2);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    if (bitmapCreateScaledBitmap != null) {
                        bitmapCreateScaledBitmap.recycle();
                    }
                    return byteArray;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(byteArrayOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th3) {
                th = th3;
                bitmap2 = bitmapCreateScaledBitmap;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                throw th;
            }
        } catch (Exception unused2) {
            bitmapCreateScaledBitmap = null;
        } catch (Throwable th4) {
            th = th4;
        }
        if (bitmapCreateScaledBitmap != null) {
            bitmapCreateScaledBitmap.recycle();
        }
        return null;
    }
}
