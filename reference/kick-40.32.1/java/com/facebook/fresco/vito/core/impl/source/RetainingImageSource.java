package com.facebook.fresco.vito.core.impl.source;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.RetainingDataSourceSupplier;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.fresco.vito.source.ImageSourceProvider;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetainingImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007J,\u0010\u0017\u001a\u00020\u00132$\u0010\u0018\u001a \u0012\u0004\u0012\u00020\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00110\u00100\u000fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR.\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00110\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/source/RetainingImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "_currentSource", "dataSourceSupplier", "Lcom/facebook/datasource/RetainingDataSourceSupplier;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "<init>", "(Lcom/facebook/fresco/vito/source/ImageSource;Lcom/facebook/datasource/RetainingDataSourceSupplier;)V", "getDataSourceSupplier", "()Lcom/facebook/datasource/RetainingDataSourceSupplier;", "currentSource", "getCurrentSource", "()Lcom/facebook/fresco/vito/source/ImageSource;", "imageSourceUpdateFunction", "Lkotlin/Function1;", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/datasource/DataSource;", "updateImageSource", "", "imageSource", "forceReload", "", "setImageSourceUpdateFunction", "function", "getClassNameString", "", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RetainingImageSource implements ImageSource {
    private ImageSource _currentSource;
    private final RetainingDataSourceSupplier<CloseableReference<CloseableImage>> dataSourceSupplier;
    private Function1<? super ImageSource, ? extends Supplier<DataSource<CloseableReference<CloseableImage>>>> imageSourceUpdateFunction;

    /* JADX WARN: Multi-variable type inference failed */
    public RetainingImageSource() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final void updateImageSource(ImageSource imageSource) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        updateImageSource$default(this, imageSource, false, 2, null);
    }

    public RetainingImageSource(ImageSource _currentSource, RetainingDataSourceSupplier<CloseableReference<CloseableImage>> dataSourceSupplier) {
        Intrinsics.checkNotNullParameter(_currentSource, "_currentSource");
        Intrinsics.checkNotNullParameter(dataSourceSupplier, "dataSourceSupplier");
        this._currentSource = _currentSource;
        this.dataSourceSupplier = dataSourceSupplier;
    }

    public /* synthetic */ RetainingImageSource(ImageSource imageSource, RetainingDataSourceSupplier retainingDataSourceSupplier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ImageSourceProvider.emptySource() : imageSource, (i & 2) != 0 ? new RetainingDataSourceSupplier() : retainingDataSourceSupplier);
    }

    public final RetainingDataSourceSupplier<CloseableReference<CloseableImage>> getDataSourceSupplier() {
        return this.dataSourceSupplier;
    }

    /* JADX INFO: renamed from: getCurrentSource, reason: from getter */
    public final ImageSource get_currentSource() {
        return this._currentSource;
    }

    public static /* synthetic */ void updateImageSource$default(RetainingImageSource retainingImageSource, ImageSource imageSource, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        retainingImageSource.updateImageSource(imageSource, z);
    }

    public final void updateImageSource(ImageSource imageSource, boolean forceReload) {
        Intrinsics.checkNotNullParameter(imageSource, "imageSource");
        if (forceReload || !Intrinsics.areEqual(this._currentSource, imageSource)) {
            this._currentSource = imageSource;
            Function1<? super ImageSource, ? extends Supplier<DataSource<CloseableReference<CloseableImage>>>> function1 = this.imageSourceUpdateFunction;
            if (function1 != null) {
                this.dataSourceSupplier.replaceSupplier(function1.invoke(imageSource));
            }
        }
    }

    public final void setImageSourceUpdateFunction(Function1<? super ImageSource, ? extends Supplier<DataSource<CloseableReference<CloseableImage>>>> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.imageSourceUpdateFunction = function;
        updateImageSource(this._currentSource, true);
    }

    @Override // com.facebook.fresco.vito.source.ImageSource
    public String getClassNameString() {
        return "RetainingImageSource";
    }
}
