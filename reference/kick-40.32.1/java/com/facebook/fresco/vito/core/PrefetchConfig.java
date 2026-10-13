package com.facebook.fresco.vito.core;

import kotlin.Metadata;

/* JADX INFO: compiled from: PrefetchConfig.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/facebook/fresco/vito/core/PrefetchConfig;", "", "prefetchInOnPrepare", "", "prefetchInOnBoundsDefinedForDynamicSize", "prefetchTargetOnPrepare", "Lcom/facebook/fresco/vito/core/PrefetchTarget;", "prefetchTargetOnBoundsDefined", "closePrefetchDataSourceOnBindorOnMount", "closePrefetchDataSourceOnUnbind", "closePrefetchDataSourceOnUnmount", "closePrefetchDataSourceOnDetached", "core_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PrefetchConfig {
    boolean closePrefetchDataSourceOnBindorOnMount();

    boolean closePrefetchDataSourceOnDetached();

    boolean closePrefetchDataSourceOnUnbind();

    boolean closePrefetchDataSourceOnUnmount();

    boolean prefetchInOnBoundsDefinedForDynamicSize();

    boolean prefetchInOnPrepare();

    PrefetchTarget prefetchTargetOnBoundsDefined();

    PrefetchTarget prefetchTargetOnPrepare();
}
