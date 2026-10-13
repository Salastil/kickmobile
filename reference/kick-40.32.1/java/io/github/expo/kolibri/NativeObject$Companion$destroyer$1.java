package io.github.expo.kolibri;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeObject.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NativeObject$Companion$destroyer$1 implements Cleaner.PointerFree, FunctionAdapter {
    final /* synthetic */ NativeObject.Companion $tmp0;

    NativeObject$Companion$destroyer$1(NativeObject.Companion companion) {
        this.$tmp0 = companion;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Cleaner.PointerFree) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.$tmp0, NativeObject.Companion.class, "nativeDestroy", "nativeDestroy(J)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // io.github.expo.kolibri.Cleaner.PointerFree
    public final void free(long j) {
        this.$tmp0.nativeDestroy(j);
    }
}
