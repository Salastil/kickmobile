package com.facebook.fresco.vito.core;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.fresco.ui.common.VisibilityAware;
import com.facebook.fresco.vito.listener.ImageListener;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrescoDrawableInterface.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0017H&J\b\u0010&\u001a\u00020\u0017H&J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0017H&J\u0012\u00100\u001a\u00020 2\b\u00101\u001a\u0004\u0018\u000102H&J\u0014\u00109\u001a\u0004\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010#H&J\n\u0010D\u001a\u0004\u0018\u00010EH&J\u0018\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH&J\b\u0010J\u001a\u00020 H&J\u0010\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020MH&J\b\u0010N\u001a\u00020\u0017H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u00020\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0014\u0010\"\u001a\u0004\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010'\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u001a\u0010*\u001a\u0004\u0018\u00010+X¦\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00103\u001a\u0004\u0018\u000104X¦\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010;\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR\u001a\u0010>\u001a\u0004\u0018\u00010?X¦\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006OÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "Lcom/facebook/fresco/ui/common/VisibilityAware;", "imageId", "", "getImageId", "()J", "callerContext", "", "getCallerContext", "()Ljava/lang/Object;", "setCallerContext", "(Ljava/lang/Object;)V", "imagePerfListener", "Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "getImagePerfListener", "()Lcom/facebook/fresco/vito/core/VitoImagePerfListener;", "uiFramework", "", "getUiFramework", "()Ljava/lang/String;", "setUiFramework", "(Ljava/lang/String;)V", "forceReloadIfImageAlreadySet", "", "getForceReloadIfImageAlreadySet", "()Z", "setForceReloadIfImageAlreadySet", "(Z)V", "retriggerListenersIfImageAlreadySet", "getRetriggerListenersIfImageAlreadySet", "setRetriggerListenersIfImageAlreadySet", "setMutateDrawables", "", "mutateDrawables", "actualImageDrawable", "Landroid/graphics/drawable/Drawable;", "getActualImageDrawable", "()Landroid/graphics/drawable/Drawable;", "hasImage", "isFetchSubmitted", "setFetchSubmitted", "fetchSubmitted", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "getImageRequest", "()Lcom/facebook/fresco/vito/core/VitoImageRequest;", "setImageRequest", "(Lcom/facebook/fresco/vito/core/VitoImageRequest;)V", "setVisibilityCallback", "visibilityCallback", "Lcom/facebook/drawee/drawable/VisibilityCallback;", "imageListener", "Lcom/facebook/fresco/vito/listener/ImageListener;", "getImageListener", "()Lcom/facebook/fresco/vito/listener/ImageListener;", "setImageListener", "(Lcom/facebook/fresco/vito/listener/ImageListener;)V", "setOverlayDrawable", "drawable", "extras", "getExtras", "setExtras", "refetchRunnable", "Ljava/lang/Runnable;", "getRefetchRunnable", "()Ljava/lang/Runnable;", "setRefetchRunnable", "(Ljava/lang/Runnable;)V", "getImagePerfLoggingListener", "Lcom/facebook/fresco/vito/core/ImagePerfLoggingListener;", "setIntrinsicSize", ViewProps.WIDTH, "", ViewProps.HEIGHT, "configureWhenUnderlyingChanged", "getActualImageBounds", "outBounds", "Landroid/graphics/RectF;", "hasBitmapWithGainmap", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FrescoDrawableInterface extends VisibilityAware {
    void configureWhenUnderlyingChanged();

    void getActualImageBounds(RectF outBounds);

    Drawable getActualImageDrawable();

    Object getCallerContext();

    Object getExtras();

    boolean getForceReloadIfImageAlreadySet();

    long getImageId();

    ImageListener getImageListener();

    VitoImagePerfListener getImagePerfListener();

    ImagePerfLoggingListener getImagePerfLoggingListener();

    VitoImageRequest getImageRequest();

    Runnable getRefetchRunnable();

    boolean getRetriggerListenersIfImageAlreadySet();

    String getUiFramework();

    boolean hasBitmapWithGainmap();

    boolean hasImage();

    boolean isFetchSubmitted();

    void setCallerContext(Object obj);

    void setExtras(Object obj);

    void setFetchSubmitted(boolean fetchSubmitted);

    void setForceReloadIfImageAlreadySet(boolean z);

    void setImageListener(ImageListener imageListener);

    void setImageRequest(VitoImageRequest vitoImageRequest);

    void setIntrinsicSize(int width, int height);

    void setMutateDrawables(boolean mutateDrawables);

    Drawable setOverlayDrawable(Drawable drawable);

    void setRefetchRunnable(Runnable runnable);

    void setRetriggerListenersIfImageAlreadySet(boolean z);

    void setUiFramework(String str);

    void setVisibilityCallback(VisibilityCallback visibilityCallback);
}
