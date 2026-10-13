package com.facebook.fresco.vito.core;

import android.graphics.Rect;
import com.datadog.android.rum.internal.RumFeature;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.VisibilityAware;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposedImagePerfLoggingListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0096\u0001J%\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J%\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u001b\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J%\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0001¨\u0006\u001d"}, d2 = {"Lcom/facebook/fresco/vito/core/ComposedImagePerfLoggingListener;", "Lcom/facebook/fresco/ui/common/ControllerListener2;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "Lcom/facebook/fresco/ui/common/VisibilityAware;", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "controllerListener", "visibilityAware", "<init>", "(Lcom/facebook/fresco/ui/common/ControllerListener2;Lcom/facebook/fresco/ui/common/VisibilityAware;)V", "onEmptyEvent", "", "callerContext", "", "onFailure", "id", "", RumFeature.EVENT_THROWABLE_PROPERTY, "", "extraData", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "onFinalImageSet", "imageInfo", "onIntermediateImageFailed", "onIntermediateImageSet", "onRelease", "onSubmit", "reportVisible", ViewProps.VISIBLE, "", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ComposedImagePerfLoggingListener implements ControllerListener2<ImageInfo>, VisibilityAware, ImagePerfLoggingListener {
    private final /* synthetic */ ControllerListener2<ImageInfo> $$delegate_0;
    private final /* synthetic */ VisibilityAware $$delegate_1;

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onEmptyEvent(Object callerContext) {
        this.$$delegate_0.onEmptyEvent(callerContext);
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFailure(String id, Throwable throwable, ControllerListener2.Extras extraData) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.$$delegate_0.onFailure(id, throwable, extraData);
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onFinalImageSet(String id, ImageInfo imageInfo, ControllerListener2.Extras extraData) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.$$delegate_0.onFinalImageSet(id, imageInfo, extraData);
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageFailed(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.$$delegate_0.onIntermediateImageFailed(id);
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.$$delegate_0.onIntermediateImageSet(id, imageInfo);
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onRelease(String id, ControllerListener2.Extras extraData) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.$$delegate_0.onRelease(id, extraData);
    }

    @Override // com.facebook.fresco.ui.common.ControllerListener2
    public void onSubmit(String id, Object callerContext, ControllerListener2.Extras extraData) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.$$delegate_0.onSubmit(id, callerContext, extraData);
    }

    @Override // com.facebook.fresco.ui.common.VisibilityAware
    public void reportVisible(boolean visible) {
        this.$$delegate_1.reportVisible(visible);
    }

    public ComposedImagePerfLoggingListener(ControllerListener2<ImageInfo> controllerListener, VisibilityAware visibilityAware) {
        Intrinsics.checkNotNullParameter(controllerListener, "controllerListener");
        Intrinsics.checkNotNullParameter(visibilityAware, "visibilityAware");
        this.$$delegate_0 = controllerListener;
        this.$$delegate_1 = visibilityAware;
    }

    @Override // com.facebook.fresco.vito.core.ImagePerfLoggingListener
    public void onImageSet(CloseableReference<CloseableImage> closeableReference, Rect rect) {
        super.onImageSet(closeableReference, rect);
    }
}
