package androidx.camera.viewfinder.core.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloseGuardHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Landroidx/camera/viewfinder/core/impl/CloseGuardNoOpImpl;", "Landroidx/camera/viewfinder/core/impl/CloseGuardImpl;", "<init>", "()V", "open", "", "closeMethodName", "", "close", "warnIfOpen", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CloseGuardNoOpImpl implements CloseGuardImpl {
    @Override // androidx.camera.viewfinder.core.impl.CloseGuardImpl
    public void close() {
    }

    @Override // androidx.camera.viewfinder.core.impl.CloseGuardImpl
    public void open(String closeMethodName) {
        Intrinsics.checkNotNullParameter(closeMethodName, "closeMethodName");
    }

    @Override // androidx.camera.viewfinder.core.impl.CloseGuardImpl
    public void warnIfOpen() {
    }
}
