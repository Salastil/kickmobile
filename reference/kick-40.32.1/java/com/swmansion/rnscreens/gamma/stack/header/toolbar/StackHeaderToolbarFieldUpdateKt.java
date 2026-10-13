package com.swmansion.rnscreens.gamma.stack.header.toolbar;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderToolbarFieldUpdate.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0000¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"valueOrNull", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;", "(Lcom/swmansion/rnscreens/gamma/stack/header/toolbar/StackHeaderToolbarFieldUpdate;)Ljava/lang/Object;", "react-native-screens_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StackHeaderToolbarFieldUpdateKt {
    public static final <T> T valueOrNull(StackHeaderToolbarFieldUpdate<? extends T> stackHeaderToolbarFieldUpdate) {
        Intrinsics.checkNotNullParameter(stackHeaderToolbarFieldUpdate, "<this>");
        if (Intrinsics.areEqual(stackHeaderToolbarFieldUpdate, StackHeaderToolbarFieldUpdate.Reset.INSTANCE)) {
            return null;
        }
        if (stackHeaderToolbarFieldUpdate instanceof StackHeaderToolbarFieldUpdate.Set) {
            return (T) ((StackHeaderToolbarFieldUpdate.Set) stackHeaderToolbarFieldUpdate).getValue();
        }
        throw new NoWhenBranchMatchedException();
    }
}
