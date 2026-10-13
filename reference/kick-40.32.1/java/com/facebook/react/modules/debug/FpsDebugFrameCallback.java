package com.facebook.react.modules.debug;

import android.view.Choreographer;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FpsDebugFrameCallback.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010'\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0011\u0010!\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u001e\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001e¨\u0006,"}, d2 = {"Lcom/facebook/react/modules/debug/FpsDebugFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;)V", "choreographer", "Landroid/view/Choreographer;", "firstFrameTime", "", "lastFrameTime", "numFrameCallbacks", "", "expectedNumFramesPrev", "fourPlusFrameStutters", "numFrameCallbacksWithBatchDispatches", "targetFps", "", "doFrame", "", "l", ViewProps.START, "stop", "fps", "getFps", "()D", "jsFPS", "getJsFPS", "numFrames", "getNumFrames", "()I", "numJSFrames", "getNumJSFrames", "expectedNumFrames", "getExpectedNumFrames", "value", "", "isRunningOnFabric", "()Z", "get4PlusFrameStutters", "totalTimeMS", "getTotalTimeMS", "reset", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FpsDebugFrameCallback implements Choreographer.FrameCallback {
    private static final Companion Companion = new Companion(null);
    private static final double DEFAULT_FPS = 60.0d;
    private Choreographer choreographer;
    private int expectedNumFramesPrev;
    private long firstFrameTime;
    private int fourPlusFrameStutters;
    private boolean isRunningOnFabric;
    private long lastFrameTime;
    private int numFrameCallbacks;
    private int numFrameCallbacksWithBatchDispatches;
    private final ReactContext reactContext;
    private double targetFps;

    public final void start() {
        start$default(this, 0.0d, 1, null);
    }

    public FpsDebugFrameCallback(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.firstFrameTime = -1L;
        this.lastFrameTime = -1L;
        this.targetFps = 60.0d;
        this.isRunningOnFabric = true;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long l) {
        if (this.firstFrameTime == -1) {
            this.firstFrameTime = l;
        }
        this.lastFrameTime = l;
        this.numFrameCallbacks++;
        int expectedNumFrames = getExpectedNumFrames();
        if ((expectedNumFrames - this.expectedNumFramesPrev) - 1 >= 4) {
            this.fourPlusFrameStutters++;
        }
        this.expectedNumFramesPrev = expectedNumFrames;
        Choreographer choreographer = this.choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this);
        }
    }

    public static /* synthetic */ void start$default(FpsDebugFrameCallback fpsDebugFrameCallback, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            d = fpsDebugFrameCallback.targetFps;
        }
        fpsDebugFrameCallback.start(d);
    }

    public final void start(double targetFps) {
        if (!ReactBuildConfig.UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE) {
            this.isRunningOnFabric = true;
        }
        this.targetFps = targetFps;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.debug.FpsDebugFrameCallback$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FpsDebugFrameCallback.start$lambda$0(this.f$0);
            }
        });
    }

    static final void start$lambda$0(FpsDebugFrameCallback fpsDebugFrameCallback) {
        Choreographer choreographer = Choreographer.getInstance();
        fpsDebugFrameCallback.choreographer = choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(fpsDebugFrameCallback);
        }
    }

    public final void stop() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.debug.FpsDebugFrameCallback$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FpsDebugFrameCallback.stop$lambda$1(this.f$0);
            }
        });
    }

    static final void stop$lambda$1(FpsDebugFrameCallback fpsDebugFrameCallback) {
        Choreographer choreographer = Choreographer.getInstance();
        fpsDebugFrameCallback.choreographer = choreographer;
        if (choreographer != null) {
            choreographer.removeFrameCallback(fpsDebugFrameCallback);
        }
    }

    public final double getFps() {
        if (this.lastFrameTime == this.firstFrameTime) {
            return 0.0d;
        }
        return (((double) getNumFrames()) * 1.0E9d) / (this.lastFrameTime - this.firstFrameTime);
    }

    public final double getJsFPS() {
        if (this.lastFrameTime == this.firstFrameTime) {
            return 0.0d;
        }
        return (((double) getNumJSFrames()) * 1.0E9d) / (this.lastFrameTime - this.firstFrameTime);
    }

    public final int getNumFrames() {
        return this.numFrameCallbacks - 1;
    }

    private final int getNumJSFrames() {
        return this.numFrameCallbacksWithBatchDispatches - 1;
    }

    public final int getExpectedNumFrames() {
        return (int) (((this.targetFps * ((double) getTotalTimeMS())) / 1000.0d) + 1.0d);
    }

    /* JADX INFO: renamed from: isRunningOnFabric, reason: from getter */
    public final boolean getIsRunningOnFabric() {
        return this.isRunningOnFabric;
    }

    /* JADX INFO: renamed from: get4PlusFrameStutters, reason: from getter */
    public final int getFourPlusFrameStutters() {
        return this.fourPlusFrameStutters;
    }

    private final int getTotalTimeMS() {
        return (int) ((this.lastFrameTime - this.firstFrameTime) / 1000000.0d);
    }

    public final void reset() {
        this.firstFrameTime = -1L;
        this.lastFrameTime = -1L;
        this.numFrameCallbacks = 0;
        this.fourPlusFrameStutters = 0;
        this.numFrameCallbacksWithBatchDispatches = 0;
    }

    /* JADX INFO: compiled from: FpsDebugFrameCallback.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/modules/debug/FpsDebugFrameCallback$Companion;", "", "<init>", "()V", "DEFAULT_FPS", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
