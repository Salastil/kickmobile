package androidx.camera.viewfinder.core.impl;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloseGuardHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/viewfinder/core/impl/CloseGuardHelper;", "", "impl", "Landroidx/camera/viewfinder/core/impl/CloseGuardImpl;", "<init>", "(Landroidx/camera/viewfinder/core/impl/CloseGuardImpl;)V", "open", "", "closeMethodName", "", "close", "warnIfOpen", "Companion", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CloseGuardHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CloseGuardImpl impl;

    public /* synthetic */ CloseGuardHelper(CloseGuardImpl closeGuardImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(closeGuardImpl);
    }

    private CloseGuardHelper(CloseGuardImpl closeGuardImpl) {
        this.impl = closeGuardImpl;
    }

    public final void open(String closeMethodName) {
        Intrinsics.checkNotNullParameter(closeMethodName, "closeMethodName");
        this.impl.open(closeMethodName);
    }

    public final void close() {
        this.impl.close();
    }

    public final void warnIfOpen() {
        this.impl.warnIfOpen();
    }

    /* JADX INFO: compiled from: CloseGuardHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Landroidx/camera/viewfinder/core/impl/CloseGuardHelper$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/viewfinder/core/impl/CloseGuardHelper;", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CloseGuardHelper create() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (Build.VERSION.SDK_INT >= 30) {
                return new CloseGuardHelper(new CloseGuardApi30Impl(), defaultConstructorMarker);
            }
            return new CloseGuardHelper(new CloseGuardNoOpImpl(), defaultConstructorMarker);
        }
    }
}
