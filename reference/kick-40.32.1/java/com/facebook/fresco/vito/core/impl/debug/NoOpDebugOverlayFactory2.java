package com.facebook.fresco.vito.core.impl.debug;

import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.vito.core.impl.FrescoDrawable2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoOpDebugOverlayFactory2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/fresco/vito/core/impl/debug/NoOpDebugOverlayFactory2;", "Lcom/facebook/fresco/vito/core/impl/debug/DebugOverlayFactory2;", "<init>", "()V", "update", "", "drawable", "Lcom/facebook/fresco/vito/core/impl/FrescoDrawable2;", "extras", "Lcom/facebook/fresco/ui/common/ControllerListener2$Extras;", "core-java-impl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NoOpDebugOverlayFactory2 implements DebugOverlayFactory2 {
    @Override // com.facebook.fresco.vito.core.impl.debug.DebugOverlayFactory2
    public void update(FrescoDrawable2 drawable, ControllerListener2.Extras extras) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }
}
