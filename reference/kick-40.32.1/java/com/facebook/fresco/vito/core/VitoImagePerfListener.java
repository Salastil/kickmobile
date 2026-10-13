package com.facebook.fresco.vito.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: VitoImagePerfListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "", "onImageMount", "", "drawable", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "onImageUnmount", "onImageBind", "onImageUnbind", "onImageFetch", "onImageSuccess", "wasImmediate", "", "onImageError", "onImageRelease", "onScheduleReleaseDelayed", "onScheduleReleaseNextFrame", "onReleaseImmediately", "onDrawableReconfigured", "onIgnoreResult", "onIgnoreFailure", "onDetached", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VitoImagePerfListener {
    void onDetached(FrescoDrawableInterface drawable);

    void onDrawableReconfigured(FrescoDrawableInterface drawable);

    void onIgnoreFailure(FrescoDrawableInterface drawable);

    void onIgnoreResult(FrescoDrawableInterface drawable);

    void onImageBind(FrescoDrawableInterface drawable);

    void onImageError(FrescoDrawableInterface drawable);

    void onImageFetch(FrescoDrawableInterface drawable);

    void onImageMount(FrescoDrawableInterface drawable);

    void onImageRelease(FrescoDrawableInterface drawable);

    void onImageSuccess(FrescoDrawableInterface drawable, boolean wasImmediate);

    void onImageUnbind(FrescoDrawableInterface drawable);

    void onImageUnmount(FrescoDrawableInterface drawable);

    void onReleaseImmediately(FrescoDrawableInterface drawable);

    void onScheduleReleaseDelayed(FrescoDrawableInterface drawable);

    void onScheduleReleaseNextFrame(FrescoDrawableInterface drawable);
}
