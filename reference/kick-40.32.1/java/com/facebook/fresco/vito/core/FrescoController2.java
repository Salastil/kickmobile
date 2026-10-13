package com.facebook.fresco.vito.core;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.fresco.ui.common.ImagePerfDataListener;
import com.facebook.fresco.ui.common.OnFadeListener;
import com.facebook.fresco.vito.listener.ImageListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: FrescoController2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0002H\u0003\"\f\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0006J%\u0010\u0002\u001a\u0002H\u0003\"\f\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJb\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/FrescoController2;", "", "createDrawable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/graphics/drawable/Drawable;", "Lcom/facebook/fresco/vito/core/FrescoDrawableInterface;", "()Landroid/graphics/drawable/Drawable;", "uiFramework", "", "(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;", "fetch", "", "drawable", "imageRequest", "Lcom/facebook/fresco/vito/core/VitoImageRequest;", "callerContext", "contextChain", "Lcom/facebook/common/callercontext/ContextChain;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/fresco/vito/listener/ImageListener;", "perfDataListener", "Lcom/facebook/fresco/ui/common/ImagePerfDataListener;", "onFadeListener", "Lcom/facebook/fresco/ui/common/OnFadeListener;", "viewportDimensions", "Landroid/graphics/Rect;", "vitoImageRequestListener", "Lcom/facebook/fresco/vito/core/VitoImageRequestListener;", "releaseDelayed", "", "releaseNextFrame", "releaseImmediately", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FrescoController2 {
    <T extends Drawable & FrescoDrawableInterface> T createDrawable(String uiFramework);

    boolean fetch(FrescoDrawableInterface drawable, VitoImageRequest imageRequest, Object callerContext, ContextChain contextChain, ImageListener listener, ImagePerfDataListener perfDataListener, OnFadeListener onFadeListener, Rect viewportDimensions, VitoImageRequestListener vitoImageRequestListener);

    void releaseDelayed(FrescoDrawableInterface drawable);

    void releaseImmediately(FrescoDrawableInterface drawable);

    void releaseNextFrame(FrescoDrawableInterface drawable);

    /* JADX INFO: compiled from: FrescoController2.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T extends Drawable & FrescoDrawableInterface> T createDrawable(FrescoController2 frescoController2) {
            return (T) FrescoController2.super.createDrawable();
        }
    }

    default <T extends Drawable & FrescoDrawableInterface> T createDrawable() {
        return (T) createDrawable(null);
    }

    static /* synthetic */ boolean fetch$default(FrescoController2 frescoController2, FrescoDrawableInterface frescoDrawableInterface, VitoImageRequest vitoImageRequest, Object obj, ContextChain contextChain, ImageListener imageListener, ImagePerfDataListener imagePerfDataListener, OnFadeListener onFadeListener, Rect rect, VitoImageRequestListener vitoImageRequestListener, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetch");
        }
        if ((i & 32) != 0) {
            imagePerfDataListener = null;
        }
        if ((i & 256) != 0) {
            vitoImageRequestListener = null;
        }
        return frescoController2.fetch(frescoDrawableInterface, vitoImageRequest, obj, contextChain, imageListener, imagePerfDataListener, onFadeListener, rect, vitoImageRequestListener);
    }
}
