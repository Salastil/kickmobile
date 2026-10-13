package androidx.camera.viewfinder.core.impl;

import android.util.CloseGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloseGuardHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/camera/viewfinder/core/impl/CloseGuardApi30Impl;", "Landroidx/camera/viewfinder/core/impl/CloseGuardImpl;", "<init>", "()V", "platformImpl", "Landroid/util/CloseGuard;", "open", "", "closeMethodName", "", "close", "warnIfOpen", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class CloseGuardApi30Impl implements CloseGuardImpl {
    private final CloseGuard platformImpl = new CloseGuard();

    @Override // androidx.camera.viewfinder.core.impl.CloseGuardImpl
    public void open(String closeMethodName) {
        Intrinsics.checkNotNullParameter(closeMethodName, "closeMethodName");
        this.platformImpl.open(closeMethodName);
    }

    @Override // androidx.camera.viewfinder.core.impl.CloseGuardImpl
    public void close() {
        this.platformImpl.close();
    }

    @Override // androidx.camera.viewfinder.core.impl.CloseGuardImpl
    public void warnIfOpen() {
        this.platformImpl.warnIfOpen();
    }
}
