package com.facebook.fresco.vito.core.impl;

import com.facebook.fresco.vito.core.FrescoDrawableInterface;
import com.facebook.fresco.vito.core.VitoImagePerfListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NopImagePerfListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0018"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/NopImagePerfListener;", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "<init>", "()V", "onImageMount", "", "drawable", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "onImageUnmount", "onImageBind", "onImageUnbind", "onImageFetch", "onImageSuccess", "wasImmediate", "", "onImageError", "onImageRelease", "onScheduleReleaseDelayed", "onScheduleReleaseNextFrame", "onReleaseImmediately", "onDrawableReconfigured", "onIgnoreResult", "onIgnoreFailure", "onDetached", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NopImagePerfListener implements VitoImagePerfListener {
    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onDetached(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onDrawableReconfigured(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onIgnoreFailure(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onIgnoreResult(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageBind(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageError(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageFetch(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageMount(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageRelease(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageSuccess(FrescoDrawableInterface drawable, boolean wasImmediate) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageUnbind(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onImageUnmount(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onReleaseImmediately(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onScheduleReleaseDelayed(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // com.facebook.fresco.vito.core.VitoImagePerfListener
    public void onScheduleReleaseNextFrame(FrescoDrawableInterface drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }
}
