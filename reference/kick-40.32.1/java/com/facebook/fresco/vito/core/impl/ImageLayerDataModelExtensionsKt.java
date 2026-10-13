package com.facebook.fresco.vito.core.impl;

import android.graphics.drawable.Drawable;
import com.facebook.fresco.vito.renderer.DrawableImageDataModel;
import com.facebook.fresco.vito.renderer.ImageDataModel;
import kotlin.Metadata;

/* JADX INFO: compiled from: ImageLayerDataModelExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"maybeGetDrawable", "Landroid/graphics/drawable/Drawable;", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ImageLayerDataModelExtensionsKt {
    public static final Drawable maybeGetDrawable(ImageDataModel imageDataModel) {
        DrawableImageDataModel drawableImageDataModel = imageDataModel instanceof DrawableImageDataModel ? (DrawableImageDataModel) imageDataModel : null;
        if (drawableImageDataModel != null) {
            return drawableImageDataModel.getDrawable();
        }
        return null;
    }
}
