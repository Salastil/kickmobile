package com.facebook.fresco.vito.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;

/* JADX INFO: compiled from: AnimatedImagePerfLoggingListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/AnimatedImagePerfLoggingListener;", "", "onCloseableAnimatedImageCreationStart", "", "imageId", "", "timestampNs", "", "onCloseableAnimatedImageCreationEnd", FirebaseAnalytics.Param.SUCCESS, "", "onDrawableCreationStart", "onDrawableCreationEnd", "onFrameDropped", "frameNumber", "", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AnimatedImagePerfLoggingListener {
    void onCloseableAnimatedImageCreationEnd(String imageId, long timestampNs, boolean success);

    void onCloseableAnimatedImageCreationStart(String imageId, long timestampNs);

    void onDrawableCreationEnd(String imageId, long timestampNs, boolean success);

    void onDrawableCreationStart(String imageId, long timestampNs);

    void onFrameDropped(String imageId, int frameNumber, long timestampNs);
}
