package androidx.camera.extensions;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExtensionSessionConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eBE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\r\u0010\u000eB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000f\"\u00020\b¢\u0006\u0004\b\r\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/camera/extensions/ExtensionSessionConfig;", "Landroidx/camera/core/SessionConfig;", "mode", "", "extensionsManager", "Landroidx/camera/extensions/ExtensionsManager;", "useCases", "", "Landroidx/camera/core/UseCase;", "viewPort", "Landroidx/camera/core/ViewPort;", "effects", "Landroidx/camera/core/CameraEffect;", "<init>", "(ILandroidx/camera/extensions/ExtensionsManager;Ljava/util/List;Landroidx/camera/core/ViewPort;Ljava/util/List;)V", "", "(ILandroidx/camera/extensions/ExtensionsManager;[Landroidx/camera/core/UseCase;)V", "getMode", "()I", "getExtensionsManager", "()Landroidx/camera/extensions/ExtensionsManager;", "requireNonEmptyUseCases", "", "getRequireNonEmptyUseCases", "()Z", "_cameraFilter", "Landroidx/camera/core/CameraFilter;", "cameraFilter", "getCameraFilter", "()Landroidx/camera/core/CameraFilter;", "Builder", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtensionSessionConfig extends SessionConfig {
    private final CameraFilter _cameraFilter;
    private final ExtensionsManager extensionsManager;
    private final int mode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtensionSessionConfig(int i, ExtensionsManager extensionsManager) {
        this(i, extensionsManager, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtensionSessionConfig(int i, ExtensionsManager extensionsManager, List<? extends UseCase> useCases) {
        this(i, extensionsManager, useCases, null, null, 24, null);
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtensionSessionConfig(int i, ExtensionsManager extensionsManager, List<? extends UseCase> useCases, ViewPort viewPort) {
        this(i, extensionsManager, useCases, viewPort, null, 16, null);
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
    }

    @Override // androidx.camera.core.SessionConfig
    public boolean getRequireNonEmptyUseCases() {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionSessionConfig(int i, ExtensionsManager extensionsManager, List<? extends UseCase> useCases, ViewPort viewPort, List<? extends CameraEffect> effects) {
        super(useCases, viewPort, effects, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
        Intrinsics.checkNotNullParameter(effects, "effects");
        this.mode = i;
        this.extensionsManager = extensionsManager;
        this._cameraFilter = extensionsManager.getExtensionCameraFilterAndInjectCameraConfig$camera_extensions(i);
    }

    public final int getMode() {
        return this.mode;
    }

    public final ExtensionsManager getExtensionsManager() {
        return this.extensionsManager;
    }

    public /* synthetic */ ExtensionSessionConfig(int i, ExtensionsManager extensionsManager, List list, ViewPort viewPort, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, extensionsManager, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? null : viewPort, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list2);
    }

    @Override // androidx.camera.core.SessionConfig
    /* JADX INFO: renamed from: getCameraFilter, reason: from getter */
    public CameraFilter get_cameraFilter() {
        return this._cameraFilter;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExtensionSessionConfig(int i, ExtensionsManager extensionsManager, UseCase... useCases) {
        this(i, extensionsManager, ArraysKt.toList(useCases), null, null, 24, null);
        Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
        Intrinsics.checkNotNullParameter(useCases, "useCases");
    }

    /* JADX INFO: compiled from: ExtensionSessionConfig.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/camera/extensions/ExtensionSessionConfig$Builder;", "", "mode", "", "extensionsManager", "Landroidx/camera/extensions/ExtensionsManager;", "<init>", "(ILandroidx/camera/extensions/ExtensionsManager;)V", "useCases", "", "Landroidx/camera/core/UseCase;", "viewPort", "Landroidx/camera/core/ViewPort;", "effects", "Landroidx/camera/core/CameraEffect;", "addUseCase", "useCase", "setViewPort", "addEffect", "effect", "build", "Landroidx/camera/extensions/ExtensionSessionConfig;", "camera-extensions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private List<CameraEffect> effects;
        private final ExtensionsManager extensionsManager;
        private final int mode;
        private final List<UseCase> useCases;
        private ViewPort viewPort;

        public Builder(int i, ExtensionsManager extensionsManager) {
            Intrinsics.checkNotNullParameter(extensionsManager, "extensionsManager");
            this.mode = i;
            this.extensionsManager = extensionsManager;
            this.useCases = new ArrayList();
            this.effects = new ArrayList();
        }

        public final Builder addUseCase(UseCase useCase) {
            Intrinsics.checkNotNullParameter(useCase, "useCase");
            this.useCases.add(useCase);
            return this;
        }

        public final Builder setViewPort(ViewPort viewPort) {
            Intrinsics.checkNotNullParameter(viewPort, "viewPort");
            this.viewPort = viewPort;
            return this;
        }

        public final Builder addEffect(CameraEffect effect) {
            Intrinsics.checkNotNullParameter(effect, "effect");
            this.effects.add(effect);
            return this;
        }

        public final ExtensionSessionConfig build() {
            return new ExtensionSessionConfig(this.mode, this.extensionsManager, CollectionsKt.toList(this.useCases), this.viewPort, CollectionsKt.toList(this.effects));
        }
    }
}
