package com.facebook.fresco.vito.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListVitoImagePerfListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0018\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/facebook/fresco/vito/core/ListVitoImagePerfListener;", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "listeners", "", "<init>", "([Lcom/facebook/fresco/vito/core/VitoImagePerfListener;)V", "[Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "onImageMount", "", "drawable", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "onImageUnmount", "onImageBind", "onImageUnbind", "onImageFetch", "onImageSuccess", "wasImmediate", "", "onImageError", "onImageRelease", "onScheduleReleaseDelayed", "onScheduleReleaseNextFrame", "onReleaseImmediately", "onDrawableReconfigured", "onIgnoreResult", "onIgnoreFailure", "onDetached", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListVitoImagePerfListener implements VitoImagePerfListener {
    private final VitoImagePerfListener[] listeners;

    public ListVitoImagePerfListener(VitoImagePerfListener... listeners) {
        Intrinsics.checkNotNullParameter(listeners, "listeners");
        this.listeners = listeners;
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageMount(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageMount(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageUnmount(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageUnmount(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageBind(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageBind(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageUnbind(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageUnbind(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageFetch(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageFetch(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageSuccess(FrescoDrawableInterface drawable, boolean wasImmediate) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageSuccess(drawable, wasImmediate);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageError(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageError(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageRelease(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onImageRelease(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onScheduleReleaseDelayed(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onScheduleReleaseDelayed(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onScheduleReleaseNextFrame(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onScheduleReleaseNextFrame(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onReleaseImmediately(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onReleaseImmediately(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onDrawableReconfigured(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onDrawableReconfigured(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onIgnoreResult(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onIgnoreResult(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onIgnoreFailure(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onIgnoreFailure(drawable);
        }
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onDetached(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        for (VitoImagePerfListener vitoImagePerfListener : this.listeners) {
            vitoImagePerfListener.onDetached(drawable);
        }
    }
}
