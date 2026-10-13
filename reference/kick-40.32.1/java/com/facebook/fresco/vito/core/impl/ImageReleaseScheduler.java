package com.facebook.fresco.vito.core.impl;

import android.os.Handler;
import android.os.Looper;
import com.facebook.drawee.components.DeferredReleaser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageReleaseScheduler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImageReleaseScheduler;", "", "<init>", "()V", "improveDelayedReleasing", "", "getImproveDelayedReleasing", "()Z", "setImproveDelayedReleasing", "(Z)V", "enableReleaseDelayed", "getEnableReleaseDelayed", "setEnableReleaseDelayed", "enableReleaseNextFrame", "getEnableReleaseNextFrame", "setEnableReleaseNextFrame", "enableReleaseImmediately", "getEnableReleaseImmediately", "setEnableReleaseImmediately", "handler", "Landroid/os/Handler;", "deferredReleaser", "Lcom/facebook/drawee/components/DeferredReleaser;", "kotlin.jvm.PlatformType", "releaseImmediately", "", "drawable", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "releaseDelayed", "releaseDelayMs", "", "releaseNextFrame", "cancelAllReleasing", "cancelReleaseDelayed", "cancelReleaseNextFrame", "createReleaseState", "Lcom/facebook/fresco/vito/core/impl/ImageReleaseScheduler$ImageReleaseState;", "ImageReleaseState", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImageReleaseScheduler {
    private static boolean improveDelayedReleasing;
    public static final ImageReleaseScheduler INSTANCE = new ImageReleaseScheduler();
    private static boolean enableReleaseDelayed = true;
    private static boolean enableReleaseNextFrame = true;
    private static boolean enableReleaseImmediately = true;
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final DeferredReleaser deferredReleaser = DeferredReleaser.getInstance();

    private ImageReleaseScheduler() {
    }

    public final boolean getImproveDelayedReleasing() {
        return improveDelayedReleasing;
    }

    public final void setImproveDelayedReleasing(boolean z) {
        improveDelayedReleasing = z;
    }

    public final boolean getEnableReleaseDelayed() {
        return enableReleaseDelayed;
    }

    public final void setEnableReleaseDelayed(boolean z) {
        enableReleaseDelayed = z;
    }

    public final boolean getEnableReleaseNextFrame() {
        return enableReleaseNextFrame;
    }

    public final void setEnableReleaseNextFrame(boolean z) {
        enableReleaseNextFrame = z;
    }

    public final boolean getEnableReleaseImmediately() {
        return enableReleaseImmediately;
    }

    public final void setEnableReleaseImmediately(boolean z) {
        enableReleaseImmediately = z;
    }

    /* JADX INFO: compiled from: ImageReleaseScheduler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/ImageReleaseScheduler$ImageReleaseState;", "Ljava/lang/Runnable;", "Lcom/facebook/drawee/components/DeferredReleaser$Releasable;", "drawable", "Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "<init>", "(Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;)V", "getDrawable", "()Lcom/facebook/fresco/vito/core/impl/KFrescoVitoDrawable;", "delayedReleasePending", "", "getDelayedReleasePending", "()Z", "setDelayedReleasePending", "(Z)V", "run", "", "release", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ImageReleaseState implements Runnable, DeferredReleaser.Releasable {
        private boolean delayedReleasePending;
        private final KFrescoVitoDrawable drawable;

        public ImageReleaseState(KFrescoVitoDrawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            this.drawable = drawable;
        }

        public final KFrescoVitoDrawable getDrawable() {
            return this.drawable;
        }

        public final boolean getDelayedReleasePending() {
            return this.delayedReleasePending;
        }

        public final void setDelayedReleasePending(boolean z) {
            this.delayedReleasePending = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageReleaseScheduler.INSTANCE.releaseNextFrame(this.drawable);
        }

        @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
        public void release() {
            this.drawable.reset();
        }
    }

    public final void releaseImmediately(KFrescoVitoDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (enableReleaseImmediately) {
            drawable.get_imagePerfListener().onReleaseImmediately(drawable);
            drawable.reset();
        }
    }

    public final void releaseDelayed(KFrescoVitoDrawable drawable, long releaseDelayMs) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!enableReleaseDelayed || drawable.getReleaseState().getDelayedReleasePending()) {
            return;
        }
        drawable.get_imagePerfListener().onScheduleReleaseDelayed(drawable);
        handler.postDelayed(drawable.getReleaseState(), releaseDelayMs);
        if (improveDelayedReleasing) {
            drawable.getReleaseState().setDelayedReleasePending(true);
        }
    }

    public final void releaseNextFrame(KFrescoVitoDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (enableReleaseNextFrame) {
            cancelReleaseDelayed(drawable);
            drawable.get_imagePerfListener().onScheduleReleaseNextFrame(drawable);
            deferredReleaser.scheduleDeferredRelease(drawable.getReleaseState());
        }
    }

    public final void cancelAllReleasing(KFrescoVitoDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        cancelReleaseDelayed(drawable);
        cancelReleaseNextFrame(drawable);
    }

    public final void cancelReleaseDelayed(KFrescoVitoDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!improveDelayedReleasing || drawable.getReleaseState().getDelayedReleasePending()) {
            handler.removeCallbacks(drawable.getReleaseState());
        }
        drawable.getReleaseState().setDelayedReleasePending(false);
    }

    public final void cancelReleaseNextFrame(KFrescoVitoDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        deferredReleaser.cancelDeferredRelease(drawable.getReleaseState());
    }

    public final ImageReleaseState createReleaseState(KFrescoVitoDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        return new ImageReleaseState(drawable);
    }
}
