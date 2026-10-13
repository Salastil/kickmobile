package com.facebook.fresco.vito.core.impl;

import com.facebook.common.closeables.AutoCleanupDelegate;
import com.facebook.datasource.DataSource;
import kotlin.Metadata;

/* JADX INFO: compiled from: PropertyDelegates.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/DataSourceCleanupDelegate;", "Lcom/facebook/common/closeables/AutoCleanupDelegate;", "Lcom/facebook/datasource/DataSource;", "", "<init>", "()V", "core-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DataSourceCleanupDelegate extends AutoCleanupDelegate<DataSource<? extends Object>> {
    public DataSourceCleanupDelegate() {
        super(null, PropertyDelegatesKt.dataSourceCleanupFunction);
    }
}
