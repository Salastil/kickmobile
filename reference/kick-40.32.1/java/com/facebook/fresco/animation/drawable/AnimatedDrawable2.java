package com.facebook.fresco.animation.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.logging.FLog;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.drawable.DrawableProperties;
import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.bitmap.BitmapAnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.vito.options.AnimatedOptions;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedDrawable2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\b\u0016\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002[\\B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u000bH\u0016J\u0010\u00101\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0014J\u0010\u00104\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\u0014H\u0016J\u0012\u00109\u001a\u00020.2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020\u0014H\u0016J\u0006\u0010=\u001a\u00020.J\u000e\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020\u0014J\u000e\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0014J\u000e\u0010P\u001a\u00020.2\u0006\u0010\u0018\u001a\u00020\rJ\u000e\u0010Q\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010R\u001a\u00020.2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010S\u001a\u00020.2\b\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020\rH\u0002J\b\u0010V\u001a\u00020.H\u0002J\b\u0010W\u001a\u00020\rH\u0002J\u0010\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u0014H\u0014J\b\u0010Z\u001a\u00020.H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010>\u001a\u0004\u0018\u00010\u00052\b\u0010>\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u0007R\u0011\u0010B\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bC\u0010\u0010R\u0011\u0010D\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010H\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bI\u0010\u0010R\u0011\u0010J\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bK\u0010\u001eR\u0011\u0010N\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bO\u0010\u001e¨\u0006]"}, d2 = {"Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "Lcom/facebook/drawable/base/DrawableWithCaches;", "_animationBackend", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "<init>", "(Lcom/facebook/fresco/animation/backend/AnimationBackend;)V", "frameScheduler", "Lcom/facebook/fresco/animation/frame/FrameScheduler;", "_isRunning", "", "value", "", "startTimeMs", "getStartTimeMs", "()J", "lastFrameAnimationTimeMs", "expectedRenderTimeMs", "lastDrawnFrameNumber", "", "pausedStartTimeMsDifference", "pausedLastFrameAnimationTimeMsDifference", "pausedLastDrawnFrameNumber", "frameSchedulingDelayMs", "frameSchedulingOffsetMs", "_droppedFrames", "_consecutiveDroppedFrames", "maxConsecutiveDroppedFrames", "getMaxConsecutiveDroppedFrames", "()I", "setMaxConsecutiveDroppedFrames", "(I)V", "animationListener", "Lcom/facebook/fresco/animation/drawable/AnimationListener;", "drawListener", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2$DrawListener;", "animationBackendListener", "Lcom/facebook/fresco/animation/backend/AnimationBackend$Listener;", "drawableProperties", "Lcom/facebook/drawee/drawable/DrawableProperties;", "invalidateRunnable", "Ljava/lang/Runnable;", "getIntrinsicWidth", "getIntrinsicHeight", ViewProps.START, "", "stop", "isRunning", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "preloadAnimation", "animationBackend", "getAnimationBackend", "()Lcom/facebook/fresco/animation/backend/AnimationBackend;", "setAnimationBackend", "droppedFrames", "getDroppedFrames", "isInfiniteAnimation", "()Z", "jumpToFrame", "targetFrameNumber", "loopDurationMs", "getLoopDurationMs", "frameCount", "getFrameCount", "getFrameDurationMs", "frameNumber", "loopCount", "getLoopCount", "setFrameSchedulingDelayMs", "setFrameSchedulingOffsetMs", "setAnimationListener", "setDrawListener", "scheduleNextFrame", "targetAnimationTimeMs", "onFrameDropped", "now", "onLevelChange", FirebaseAnalytics.Param.LEVEL, "dropCaches", "DrawListener", "Companion", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    private static final int DEFAULT_FRAME_SCHEDULING_DELAY_MS = 8;
    private static final int DEFAULT_FRAME_SCHEDULING_OFFSET_MS = 0;
    private static final int DEFAULT_MAX_CONSECUTIVE_DROPPED_FRAMES = 150;
    private AnimationBackend _animationBackend;
    private int _consecutiveDroppedFrames;
    private int _droppedFrames;
    private volatile boolean _isRunning;
    private final AnimationBackend.Listener animationBackendListener;
    private volatile AnimationListener animationListener;
    private volatile DrawListener drawListener;
    private DrawableProperties drawableProperties;
    private long expectedRenderTimeMs;
    private FrameScheduler frameScheduler;
    private long frameSchedulingDelayMs;
    private long frameSchedulingOffsetMs;
    private final Runnable invalidateRunnable;
    private int lastDrawnFrameNumber;
    private long lastFrameAnimationTimeMs;
    private int maxConsecutiveDroppedFrames;
    private int pausedLastDrawnFrameNumber;
    private long pausedLastFrameAnimationTimeMsDifference;
    private long pausedStartTimeMsDifference;
    private long startTimeMs;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Class<?> TAG = AnimatedDrawable2.class;
    private static final AnimationListener NO_OP_LISTENER = new BaseAnimationListener();

    /* JADX INFO: compiled from: AnimatedDrawable2.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bæ\u0080\u0001\u0018\u00002\u00020\u0001Jh\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH&¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2$DrawListener;", "", "onDraw", "", "animatedDrawable", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "frameScheduler", "Lcom/facebook/fresco/animation/frame/FrameScheduler;", "frameNumberToDraw", "", "frameDrawn", "", "isAnimationRunning", "animationStartTimeMs", "", "animationTimeMs", "lastFrameAnimationTimeMs", "actualRenderTimeStartMs", "actualRenderTimeEndMs", "startRenderTimeForNextFrameMs", "scheduledRenderTimeForNextFrameMs", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface DrawListener {
        void onDraw(AnimatedDrawable2 animatedDrawable, FrameScheduler frameScheduler, int frameNumberToDraw, boolean frameDrawn, boolean isAnimationRunning, long animationStartTimeMs, long animationTimeMs, long lastFrameAnimationTimeMs, long actualRenderTimeStartMs, long actualRenderTimeEndMs, long startRenderTimeForNextFrameMs, long scheduledRenderTimeForNextFrameMs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatedDrawable2() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public /* synthetic */ AnimatedDrawable2(AnimationBackend animationBackend, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : animationBackend);
    }

    public AnimatedDrawable2(AnimationBackend animationBackend) {
        this._animationBackend = animationBackend;
        this.frameSchedulingDelayMs = 8L;
        this.maxConsecutiveDroppedFrames = DEFAULT_MAX_CONSECUTIVE_DROPPED_FRAMES;
        this.animationListener = NO_OP_LISTENER;
        AnimationBackend.Listener listener = new AnimationBackend.Listener() { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2$$ExternalSyntheticLambda0
            @Override // com.facebook.fresco.animation.backend.AnimationBackend.Listener
            public final void onAnimationLoaded() {
                this.f$0.animationListener.onAnimationLoaded();
            }
        };
        this.animationBackendListener = listener;
        this.invalidateRunnable = new Runnable() { // from class: com.facebook.fresco.animation.drawable.AnimatedDrawable2$invalidateRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.unscheduleSelf(this);
                this.this$0.invalidateSelf();
            }
        };
        this.frameScheduler = INSTANCE.createSchedulerForBackendAndDelayMethod(this._animationBackend);
        AnimationBackend animationBackend2 = this._animationBackend;
        if (animationBackend2 != null) {
            animationBackend2.setAnimationListener(listener);
        }
    }

    public final long getStartTimeMs() {
        return this.startTimeMs;
    }

    public final int getMaxConsecutiveDroppedFrames() {
        return this.maxConsecutiveDroppedFrames;
    }

    public final void setMaxConsecutiveDroppedFrames(int i) {
        this.maxConsecutiveDroppedFrames = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this._animationBackend;
        return animationBackend != null ? animationBackend.getBitmapWidth() : super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this._animationBackend;
        return animationBackend != null ? animationBackend.getBitmapHeight() : super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationBackend animationBackend;
        if (this._isRunning || (animationBackend = this._animationBackend) == null) {
            return;
        }
        Intrinsics.checkNotNull(animationBackend);
        if (animationBackend.getFrameCount() <= 1) {
            return;
        }
        this._isRunning = true;
        this._consecutiveDroppedFrames = 0;
        long jNow = now();
        long j = jNow - this.pausedStartTimeMsDifference;
        this.startTimeMs = j;
        this.expectedRenderTimeMs = j;
        this.lastFrameAnimationTimeMs = jNow - this.pausedLastFrameAnimationTimeMsDifference;
        this.lastDrawnFrameNumber = this.pausedLastDrawnFrameNumber;
        invalidateSelf();
        this.animationListener.onAnimationStart(this);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this._isRunning) {
            long jNow = now();
            this.pausedStartTimeMsDifference = jNow - this.startTimeMs;
            this.pausedLastFrameAnimationTimeMsDifference = jNow - this.lastFrameAnimationTimeMs;
            this.pausedLastDrawnFrameNumber = this.lastDrawnFrameNumber;
            this._isRunning = false;
            this.startTimeMs = 0L;
            this.expectedRenderTimeMs = 0L;
            this.lastFrameAnimationTimeMs = -1L;
            this.lastDrawnFrameNumber = -1;
            AnimationBackend animationBackend = this._animationBackend;
            if (animationBackend != null) {
                animationBackend.clear();
            }
            unscheduleSelf(this.invalidateRunnable);
            this.animationListener.onAnimationStop(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this._isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long j;
        long j2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this._animationBackend == null || this.frameScheduler == null) {
            return;
        }
        long jNow = now();
        long jMax = this._isRunning ? (jNow - this.startTimeMs) + this.frameSchedulingOffsetMs : (long) Math.max(this.lastFrameAnimationTimeMs, 0.0d);
        FrameScheduler frameScheduler = this.frameScheduler;
        Intrinsics.checkNotNull(frameScheduler);
        int frameNumberToRender = frameScheduler.getFrameNumberToRender(jMax, this.lastFrameAnimationTimeMs);
        if (frameNumberToRender == -1) {
            AnimationBackend animationBackend = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend);
            frameNumberToRender = animationBackend.getFrameCount() - 1;
            AnimationBackend animationBackend2 = this._animationBackend;
            BitmapAnimationBackend bitmapAnimationBackend = animationBackend2 instanceof BitmapAnimationBackend ? (BitmapAnimationBackend) animationBackend2 : null;
            AnimatedOptions animatedOptions = bitmapAnimationBackend != null ? bitmapAnimationBackend.getAnimatedOptions() : null;
            if (animatedOptions == null || !animatedOptions.useFallbackThumbnail()) {
                this.animationListener.onAnimationStop(this);
                this._isRunning = false;
            }
        } else if (frameNumberToRender == 0 && this.lastDrawnFrameNumber != -1 && jNow >= this.expectedRenderTimeMs) {
            this.animationListener.onAnimationRepeat(this);
        }
        int i = frameNumberToRender;
        AnimationBackend animationBackend3 = this._animationBackend;
        Intrinsics.checkNotNull(animationBackend3);
        AnimatedDrawable2 animatedDrawable2 = this;
        boolean zDrawFrame = animationBackend3.drawFrame(animatedDrawable2, canvas, i);
        if (zDrawFrame) {
            this.animationListener.onAnimationFrame(animatedDrawable2, i);
            this.lastDrawnFrameNumber = i;
            this._consecutiveDroppedFrames = 0;
        }
        if (!zDrawFrame) {
            onFrameDropped();
            int i2 = this._consecutiveDroppedFrames + 1;
            this._consecutiveDroppedFrames = i2;
            int i3 = this.maxConsecutiveDroppedFrames;
            if (i3 > 0 && i2 >= i3) {
                FLog.w(TAG, "Animation circuit breaker tripped after %d consecutive dropped frames; stopping animation (frameToDraw=%d, totalDropped=%d)", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(this._droppedFrames));
                this._isRunning = false;
                unscheduleSelf(this.invalidateRunnable);
                this.animationListener.onAnimationStop(animatedDrawable2);
                return;
            }
        }
        long jNow2 = now();
        if (this._isRunning) {
            FrameScheduler frameScheduler2 = this.frameScheduler;
            Intrinsics.checkNotNull(frameScheduler2);
            long targetRenderTimeForNextFrameMs = frameScheduler2.getTargetRenderTimeForNextFrameMs(jNow2 - this.startTimeMs);
            if (targetRenderTimeForNextFrameMs != -1) {
                long j3 = this.frameSchedulingDelayMs + targetRenderTimeForNextFrameMs;
                scheduleNextFrame(j3);
                j2 = j3;
                j = targetRenderTimeForNextFrameMs;
            } else {
                this.animationListener.onAnimationStop(animatedDrawable2);
                this._isRunning = false;
                j2 = -1;
                j = targetRenderTimeForNextFrameMs;
            }
        } else {
            j = -1;
            j2 = -1;
        }
        DrawListener drawListener = this.drawListener;
        if (drawListener != null) {
            FrameScheduler frameScheduler3 = this.frameScheduler;
            if (frameScheduler3 != null) {
                drawListener.onDraw(this, frameScheduler3, i, zDrawFrame, this._isRunning, this.startTimeMs, jMax, this.lastFrameAnimationTimeMs, jNow, jNow2, j, j2);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        this.lastFrameAnimationTimeMs = jMax;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.drawableProperties == null) {
            this.drawableProperties = new DrawableProperties();
        }
        DrawableProperties drawableProperties = this.drawableProperties;
        Intrinsics.checkNotNull(drawableProperties);
        drawableProperties.setAlpha(alpha);
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.setAlpha(alpha);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.drawableProperties == null) {
            this.drawableProperties = new DrawableProperties();
        }
        DrawableProperties drawableProperties = this.drawableProperties;
        Intrinsics.checkNotNull(drawableProperties);
        drawableProperties.setColorFilter(colorFilter);
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.setColorFilter(colorFilter);
        }
    }

    public final void preloadAnimation() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.preloadAnimation();
        }
    }

    /* JADX INFO: renamed from: getAnimationBackend, reason: from getter */
    public final AnimationBackend get_animationBackend() {
        return this._animationBackend;
    }

    public final void setAnimationBackend(AnimationBackend animationBackend) {
        AnimationBackend animationBackend2 = this._animationBackend;
        if (animationBackend2 != null) {
            Intrinsics.checkNotNull(animationBackend2);
            animationBackend2.setAnimationListener(null);
        }
        this._animationBackend = animationBackend;
        if (animationBackend != null) {
            AnimationBackend animationBackend3 = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend3);
            this.frameScheduler = new DropFramesFrameScheduler(animationBackend3);
            AnimationBackend animationBackend4 = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend4);
            animationBackend4.setAnimationListener(this.animationBackendListener);
            AnimationBackend animationBackend5 = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend5);
            animationBackend5.setBounds(getBounds());
            DrawableProperties drawableProperties = this.drawableProperties;
            if (drawableProperties != null) {
                drawableProperties.applyTo(this);
            }
        }
        this.frameScheduler = INSTANCE.createSchedulerForBackendAndDelayMethod(this._animationBackend);
        stop();
    }

    public final long getDroppedFrames() {
        return this._droppedFrames;
    }

    public final boolean isInfiniteAnimation() {
        FrameScheduler frameScheduler = this.frameScheduler;
        return frameScheduler != null && frameScheduler.isInfiniteAnimation();
    }

    public final void jumpToFrame(int targetFrameNumber) {
        FrameScheduler frameScheduler;
        if (this._animationBackend == null || (frameScheduler = this.frameScheduler) == null) {
            return;
        }
        Intrinsics.checkNotNull(frameScheduler);
        this.lastFrameAnimationTimeMs = frameScheduler.getTargetRenderTimeMs(targetFrameNumber);
        this.pausedLastDrawnFrameNumber = targetFrameNumber;
        this.pausedStartTimeMsDifference = 0L;
        this.pausedLastFrameAnimationTimeMsDifference = 0L;
        long jNow = now() - this.lastFrameAnimationTimeMs;
        this.startTimeMs = jNow;
        this.expectedRenderTimeMs = jNow;
        invalidateSelf();
    }

    public final long getLoopDurationMs() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0L;
        }
        FrameScheduler frameScheduler = this.frameScheduler;
        if (frameScheduler != null) {
            Intrinsics.checkNotNull(frameScheduler);
            return frameScheduler.getLoopDurationMs();
        }
        Intrinsics.checkNotNull(animationBackend);
        int frameCount = animationBackend.getFrameCount();
        int frameDurationMs = 0;
        for (int i = 0; i < frameCount; i++) {
            AnimationBackend animationBackend2 = this._animationBackend;
            Intrinsics.checkNotNull(animationBackend2);
            frameDurationMs += animationBackend2.getFrameDurationMs(i);
        }
        return frameDurationMs;
    }

    public final int getFrameCount() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0;
        }
        Intrinsics.checkNotNull(animationBackend);
        return animationBackend.getFrameCount();
    }

    public final int getFrameDurationMs(int frameNumber) {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0;
        }
        Intrinsics.checkNotNull(animationBackend);
        return animationBackend.getFrameDurationMs(frameNumber);
    }

    public final int getLoopCount() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend == null) {
            return 0;
        }
        Intrinsics.checkNotNull(animationBackend);
        return animationBackend.getLoopCount();
    }

    public final void setFrameSchedulingDelayMs(long frameSchedulingDelayMs) {
        this.frameSchedulingDelayMs = frameSchedulingDelayMs;
    }

    public final void setFrameSchedulingOffsetMs(long frameSchedulingOffsetMs) {
        this.frameSchedulingOffsetMs = frameSchedulingOffsetMs;
    }

    public final void setAnimationListener(AnimationListener animationListener) {
        if (animationListener == null) {
            animationListener = NO_OP_LISTENER;
        }
        this.animationListener = animationListener;
    }

    public final void setDrawListener(DrawListener drawListener) {
        this.drawListener = drawListener;
    }

    private final void scheduleNextFrame(long targetAnimationTimeMs) {
        long j = this.startTimeMs + targetAnimationTimeMs;
        this.expectedRenderTimeMs = j;
        scheduleSelf(this.invalidateRunnable, j);
    }

    private final void onFrameDropped() {
        this._droppedFrames++;
        if (FLog.isLoggable(FLog.VERBOSE)) {
            FLog.v(TAG, "Dropped a frame. Count: %s", Integer.valueOf(this._droppedFrames));
        }
    }

    private final long now() {
        return SystemClock.uptimeMillis();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        if (this._isRunning) {
            return false;
        }
        long j = level;
        if (this.lastFrameAnimationTimeMs == j) {
            return false;
        }
        this.lastFrameAnimationTimeMs = j;
        invalidateSelf();
        return true;
    }

    @Override // com.facebook.drawable.base.DrawableWithCaches
    public void dropCaches() {
        AnimationBackend animationBackend = this._animationBackend;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }

    /* JADX INFO: compiled from: AnimatedDrawable2.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2$Companion;", "", "<init>", "()V", "TAG", "Ljava/lang/Class;", "NO_OP_LISTENER", "Lcom/facebook/fresco/animation/drawable/AnimationListener;", "DEFAULT_FRAME_SCHEDULING_DELAY_MS", "", "DEFAULT_FRAME_SCHEDULING_OFFSET_MS", "DEFAULT_MAX_CONSECUTIVE_DROPPED_FRAMES", "createSchedulerForBackendAndDelayMethod", "Lcom/facebook/fresco/animation/frame/FrameScheduler;", "animationBackend", "Lcom/facebook/fresco/animation/backend/AnimationBackend;", "animated-drawable_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FrameScheduler createSchedulerForBackendAndDelayMethod(AnimationBackend animationBackend) {
            if (animationBackend == null) {
                return null;
            }
            return new DropFramesFrameScheduler(animationBackend);
        }
    }
}
