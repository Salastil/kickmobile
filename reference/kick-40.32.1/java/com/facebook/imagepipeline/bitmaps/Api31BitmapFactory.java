package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Api31BitmapFactory.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/imagepipeline/bitmaps/Api31BitmapFactory;", "Lcom/facebook/imagepipeline/bitmaps/ArtBitmapFactory;", "bitmapPool", "Lcom/facebook/imagepipeline/memory/BitmapPool;", "closeableReferenceFactory", "Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;", "useAshmem", "", "<init>", "(Lcom/facebook/imagepipeline/memory/BitmapPool;Lcom/facebook/imagepipeline/core/CloseableReferenceFactory;Z)V", "createBackingBitmap", "Landroid/graphics/Bitmap;", ViewProps.WIDTH, "", ViewProps.HEIGHT, "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "imagepipeline_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Api31BitmapFactory extends ArtBitmapFactory {
    private final boolean useAshmem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Api31BitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory, boolean z) {
        super(bitmapPool, closeableReferenceFactory);
        Intrinsics.checkNotNullParameter(bitmapPool, "bitmapPool");
        Intrinsics.checkNotNullParameter(closeableReferenceFactory, "closeableReferenceFactory");
        this.useAshmem = z;
    }

    @Override // com.facebook.imagepipeline.bitmaps.ArtBitmapFactory
    public Bitmap createBackingBitmap(int width, int height, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        Bitmap bitmapCreateBackingBitmap = super.createBackingBitmap(width, height, bitmapConfig);
        if (!this.useAshmem) {
            return bitmapCreateBackingBitmap;
        }
        Bitmap bitmapAsShared = bitmapCreateBackingBitmap.asShared();
        Intrinsics.checkNotNull(bitmapAsShared);
        return bitmapAsShared;
    }
}
