package androidx.camera.viewfinder.core.impl;

import android.view.Surface;
import androidx.camera.viewfinder.core.ViewfinderSurfaceRequest;
import androidx.camera.viewfinder.core.ViewfinderSurfaceSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;

/* JADX INFO: compiled from: ViewfinderSurfaceSessionImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/camera/viewfinder/core/impl/ViewfinderSurfaceSessionImpl;", "Landroidx/camera/viewfinder/core/ViewfinderSurfaceSession;", "surface", "Landroid/view/Surface;", "request", "Landroidx/camera/viewfinder/core/ViewfinderSurfaceRequest;", "onClose", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/Surface;Landroidx/camera/viewfinder/core/ViewfinderSurfaceRequest;Lkotlin/jvm/functions/Function0;)V", "getSurface", "()Landroid/view/Surface;", "getRequest", "()Landroidx/camera/viewfinder/core/ViewfinderSurfaceRequest;", "closed", "Lkotlinx/atomicfu/AtomicBoolean;", "closeGuard", "Landroidx/camera/viewfinder/core/impl/CloseGuardHelper;", "close", "finalize", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewfinderSurfaceSessionImpl implements ViewfinderSurfaceSession {
    private final CloseGuardHelper closeGuard;
    private final AtomicBoolean closed;
    private final Function0<Unit> onClose;
    private final ViewfinderSurfaceRequest request;
    private final Surface surface;

    public ViewfinderSurfaceSessionImpl(Surface surface, ViewfinderSurfaceRequest request, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        this.surface = surface;
        this.request = request;
        this.onClose = onClose;
        this.closed = AtomicFU.atomic(false);
        CloseGuardHelper closeGuardHelperCreate = CloseGuardHelper.INSTANCE.create();
        closeGuardHelperCreate.open("close");
        this.closeGuard = closeGuardHelperCreate;
    }

    @Override // androidx.camera.viewfinder.core.ViewfinderSurfaceSession
    public Surface getSurface() {
        return this.surface;
    }

    @Override // androidx.camera.viewfinder.core.ViewfinderSurfaceSession
    public ViewfinderSurfaceRequest getRequest() {
        return this.request;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.closeGuard.close();
        if (this.closed.getAndSet(true)) {
            return;
        }
        this.onClose.invoke();
    }

    protected final void finalize() {
        this.closeGuard.warnIfOpen();
        close();
    }
}
