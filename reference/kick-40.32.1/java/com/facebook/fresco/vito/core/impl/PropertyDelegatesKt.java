package com.facebook.fresco.vito.core.impl;

import com.facebook.datasource.DataSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PropertyDelegates.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\"\"\u0010\u0000\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"dataSourceCleanupFunction", "Lkotlin/Function1;", "Lcom/facebook/datasource/DataSource;", "", "", "core-impl_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PropertyDelegatesKt {
    private static final Function1<DataSource<? extends Object>, Unit> dataSourceCleanupFunction = new Function1() { // from class: com.facebook.fresco.vito.core.impl.PropertyDelegatesKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PropertyDelegatesKt.dataSourceCleanupFunction$lambda$0((DataSource) obj);
        }
    };

    static final Unit dataSourceCleanupFunction$lambda$0(DataSource it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.close();
        return Unit.INSTANCE;
    }
}
