package com.facebook.fresco.vito.renderer;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageDataModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/facebook/fresco/vito/renderer/DrawableImageDataModel;", "Lcom/facebook/fresco/vito/renderer/ImageDataModel;", "drawable", "Landroid/graphics/drawable/Drawable;", "disableScaling", "", "<init>", "(Landroid/graphics/drawable/Drawable;Z)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getDisableScaling", "()Z", ViewProps.WIDTH, "", "getWidth", "()I", ViewProps.HEIGHT, "getHeight", "setCallback", "", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "renderer_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DrawableImageDataModel extends ImageDataModel {
    private final boolean disableScaling;
    private final Drawable drawable;
    private final int height;
    private final int width;

    public /* synthetic */ DrawableImageDataModel(Drawable drawable, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, (i & 2) != 0 ? false : z);
    }

    public final boolean getDisableScaling() {
        return this.disableScaling;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableImageDataModel(Drawable drawable, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.drawable = drawable;
        this.disableScaling = z;
        int intrinsicHeight = -1;
        this.width = (z || (drawable instanceof NinePatchDrawable)) ? -1 : drawable.getIntrinsicWidth();
        if (!z && !(drawable instanceof NinePatchDrawable)) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        this.height = intrinsicHeight;
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public int getWidth() {
        return this.width;
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public int getHeight() {
        return this.height;
    }

    @Override // com.facebook.fresco.vito.renderer.ImageDataModel
    public void setCallback(Drawable.Callback callback) {
        this.drawable.setCallback(callback);
    }
}
