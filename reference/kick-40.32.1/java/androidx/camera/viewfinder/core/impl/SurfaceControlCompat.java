package androidx.camera.viewfinder.core.impl;

import android.os.Build;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.SurfaceView;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurfaceControlCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u000e2\u00020\u0001:\u0003\u000e\u000f\u0010J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H&\u0082\u0001\u0002\u0011\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat;", "", "newSurface", "Landroid/view/Surface;", "setBufferSize", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "release", "detach", "reparent", "", "newParent", "Companion", "SurfaceControlApi29Impl", "SurfaceControlStub", "Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat$SurfaceControlApi29Impl;", "Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat$SurfaceControlStub;", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SurfaceControlCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @JvmStatic
    static SurfaceControlCompat create(SurfaceView surfaceView, int i, int i2, int i3, String str) {
        return INSTANCE.create(surfaceView, i, i2, i3, str);
    }

    @JvmStatic
    static SurfaceControlCompat create(SurfaceControlCompat surfaceControlCompat, int i, int i2, String str) {
        return INSTANCE.create(surfaceControlCompat, i, i2, str);
    }

    @JvmStatic
    static SurfaceControlCompat wrap(SurfaceView surfaceView) {
        return INSTANCE.wrap(surfaceView);
    }

    void detach();

    Surface newSurface();

    void release();

    boolean reparent(SurfaceControlCompat newParent);

    void setBufferSize(int width, int height);

    /* JADX INFO: compiled from: SurfaceControlCompat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0007H\u0007¨\u0006\u0010"}, d2 = {"Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat;", "parent", "Landroid/view/SurfaceView;", "format", "", ViewProps.WIDTH, ViewProps.HEIGHT, "name", "", "wrap", "surfaceView", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @JvmStatic
        public final SurfaceControlCompat create(SurfaceView parent, int format, int width, int height, String name) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(name, "name");
            if (Build.VERSION.SDK_INT >= 29) {
                return new SurfaceControlApi29Impl(parent, format, width, height, name);
            }
            return SurfaceControlStub.INSTANCE;
        }

        @JvmStatic
        public final SurfaceControlCompat create(SurfaceControlCompat parent, int width, int height, String name) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(name, "name");
            if (Build.VERSION.SDK_INT >= 29) {
                return new SurfaceControlApi29Impl(parent, width, height, name);
            }
            return SurfaceControlStub.INSTANCE;
        }

        @JvmStatic
        public final SurfaceControlCompat wrap(SurfaceView surfaceView) {
            Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
            if (Build.VERSION.SDK_INT >= 29) {
                SurfaceControl surfaceControl = surfaceView.getSurfaceControl();
                Intrinsics.checkNotNullExpressionValue(surfaceControl, "getSurfaceControl(...)");
                return new SurfaceControlApi29Impl(surfaceControl);
            }
            return SurfaceControlStub.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SurfaceControlCompat.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u000eB)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat$SurfaceControlApi29Impl;", "Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat;", "surfaceControl", "Landroid/view/SurfaceControl;", "<init>", "(Landroid/view/SurfaceControl;)V", "parent", "Landroid/view/SurfaceView;", "format", "", ViewProps.WIDTH, ViewProps.HEIGHT, "name", "", "(Landroid/view/SurfaceView;IIILjava/lang/String;)V", "(Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat;IILjava/lang/String;)V", "initializeNewSurfaceControl", "", "newSurface", "Landroid/view/Surface;", "setBufferSize", "release", "detach", "reparent", "", "newParent", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class SurfaceControlApi29Impl implements SurfaceControlCompat {
        private final SurfaceControl surfaceControl;

        public SurfaceControlApi29Impl(SurfaceControl surfaceControl) {
            Intrinsics.checkNotNullParameter(surfaceControl, "surfaceControl");
            this.surfaceControl = surfaceControl;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public SurfaceControlApi29Impl(SurfaceView parent, int i, int i2, int i3, String name) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(name, "name");
            SurfaceControl surfaceControlBuild = new SurfaceControl.Builder().setName(name).setFormat(i).setBufferSize(i2, i3).setParent(parent.getSurfaceControl()).build();
            Intrinsics.checkNotNullExpressionValue(surfaceControlBuild, "build(...)");
            this(surfaceControlBuild);
            initializeNewSurfaceControl();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public SurfaceControlApi29Impl(SurfaceControlCompat parent, int i, int i2, String name) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(name, "name");
            SurfaceControl surfaceControlBuild = new SurfaceControl.Builder().setName(name).setBufferSize(i, i2).setParent(((SurfaceControlApi29Impl) parent).surfaceControl).build();
            Intrinsics.checkNotNullExpressionValue(surfaceControlBuild, "build(...)");
            this(surfaceControlBuild);
            initializeNewSurfaceControl();
        }

        private final void initializeNewSurfaceControl() {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            try {
                transaction.setVisibility(this.surfaceControl, true).apply();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(transaction, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(transaction, th);
                    throw th2;
                }
            }
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public Surface newSurface() {
            return new Surface(this.surfaceControl);
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public void setBufferSize(int width, int height) {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            try {
                transaction.setBufferSize(this.surfaceControl, width, height).apply();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(transaction, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(transaction, th);
                    throw th2;
                }
            }
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public void release() {
            this.surfaceControl.release();
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public void detach() {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            try {
                transaction.reparent(this.surfaceControl, null).apply();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(transaction, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(transaction, th);
                    throw th2;
                }
            }
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public boolean reparent(SurfaceControlCompat newParent) {
            Intrinsics.checkNotNullParameter(newParent, "newParent");
            if (!this.surfaceControl.isValid()) {
                return false;
            }
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            try {
                transaction.reparent(this.surfaceControl, ((SurfaceControlApi29Impl) newParent).surfaceControl).apply();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(transaction, null);
                return true;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(transaction, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SurfaceControlCompat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0016¨\u0006\u0010"}, d2 = {"Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat$SurfaceControlStub;", "Landroidx/camera/viewfinder/core/impl/SurfaceControlCompat;", "<init>", "()V", "newSurface", "Landroid/view/Surface;", "setBufferSize", "", ViewProps.WIDTH, "", ViewProps.HEIGHT, "release", "detach", "reparent", "", "newParent", "viewfinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class SurfaceControlStub implements SurfaceControlCompat {
        public static final SurfaceControlStub INSTANCE = new SurfaceControlStub();

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public void detach() {
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public Surface newSurface() {
            return null;
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public void release() {
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public boolean reparent(SurfaceControlCompat newParent) {
            Intrinsics.checkNotNullParameter(newParent, "newParent");
            return false;
        }

        @Override // androidx.camera.viewfinder.core.impl.SurfaceControlCompat
        public void setBufferSize(int width, int height) {
        }

        private SurfaceControlStub() {
        }
    }
}
