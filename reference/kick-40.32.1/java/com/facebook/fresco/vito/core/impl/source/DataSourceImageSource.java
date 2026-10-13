package com.facebook.fresco.vito.core.impl.source;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.fresco.vito.source.ImageSource;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataSourceImageSource.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/source/DataSourceImageSource;", "Lcom/facebook/fresco/vito/source/ImageSource;", "dataSourceSupplier", "Lcom/facebook/common/internal/Supplier;", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "<init>", "(Lcom/facebook/common/internal/Supplier;)V", "getDataSourceSupplier", "()Lcom/facebook/common/internal/Supplier;", "getClassNameString", "", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DataSourceImageSource implements ImageSource {
    private final Supplier<DataSource<CloseableReference<CloseableImage>>> dataSourceSupplier;

    public DataSourceImageSource(Supplier<DataSource<CloseableReference<CloseableImage>>> dataSourceSupplier) {
        Intrinsics.checkNotNullParameter(dataSourceSupplier, "dataSourceSupplier");
        this.dataSourceSupplier = dataSourceSupplier;
    }

    public final Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier() {
        return this.dataSourceSupplier;
    }

    @Override // com.facebook.fresco.vito.source.ImageSource
    public String getClassNameString() {
        return "DataSourceImageSource";
    }
}
