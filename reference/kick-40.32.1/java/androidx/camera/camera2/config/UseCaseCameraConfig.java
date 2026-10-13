package androidx.camera.camera2.config;

import android.util.Pair;
import androidx.camera.camera2.adapter.CameraStateAdapter;
import androidx.camera.camera2.adapter.GraphStateToCameraStateAdapter;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraGraphConfigProvider;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import dagger.Module;
import dagger.Provides;
import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UseCaseCameraConfig.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'BC\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0014\u001a\u00020\tH\u0007J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÂ\u0003J\t\u0010 \u001a\u00020\u0007HÂ\u0003J\t\u0010!\u001a\u00020\tHÂ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÂ\u0003JO\u0010$\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Landroidx/camera/camera2/config/UseCaseCameraConfig;", "", "cameraGraphFactory", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "Landroidx/camera/camera2/pipe/CameraGraph;", "graphStateToCameraStateAdapter", "Landroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;", "sessionConfigAdapter", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionProcessor", "Landroidx/camera/core/impl/SessionProcessor;", "lazyCreationResult", "Lkotlin/Lazy;", "Landroidx/camera/camera2/impl/CameraGraphConfigProvider$CameraGraphCreationResult;", "<init>", "(Lkotlin/jvm/functions/Function1;Landroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;Landroidx/camera/camera2/adapter/SessionConfigAdapter;Landroidx/camera/core/impl/SessionProcessor;Lkotlin/Lazy;)V", "cameraGraphConfig", "getCameraGraphConfig", "()Landroidx/camera/camera2/pipe/CameraGraph$Config;", "provideSessionConfigAdapter", "provideSessionProcessor", "provideUseCaseGraphContext", "Landroidx/camera/camera2/config/UseCaseGraphContext;", "cameraStateAdapter", "Landroidx/camera/camera2/adapter/CameraStateAdapter;", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Module
public final /* data */ class UseCaseCameraConfig {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<CameraGraph.Config, CameraGraph> cameraGraphFactory;
    private final GraphStateToCameraStateAdapter graphStateToCameraStateAdapter;
    private final Lazy<CameraGraphConfigProvider.CameraGraphCreationResult> lazyCreationResult;
    private final SessionConfigAdapter sessionConfigAdapter;
    private final SessionProcessor sessionProcessor;

    private final Function1<CameraGraph.Config, CameraGraph> component1() {
        return this.cameraGraphFactory;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final GraphStateToCameraStateAdapter getGraphStateToCameraStateAdapter() {
        return this.graphStateToCameraStateAdapter;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final SessionConfigAdapter getSessionConfigAdapter() {
        return this.sessionConfigAdapter;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final SessionProcessor getSessionProcessor() {
        return this.sessionProcessor;
    }

    private final Lazy<CameraGraphConfigProvider.CameraGraphCreationResult> component5() {
        return this.lazyCreationResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UseCaseCameraConfig copy$default(UseCaseCameraConfig useCaseCameraConfig, Function1 function1, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, SessionConfigAdapter sessionConfigAdapter, SessionProcessor sessionProcessor, Lazy lazy, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = useCaseCameraConfig.cameraGraphFactory;
        }
        if ((i & 2) != 0) {
            graphStateToCameraStateAdapter = useCaseCameraConfig.graphStateToCameraStateAdapter;
        }
        if ((i & 4) != 0) {
            sessionConfigAdapter = useCaseCameraConfig.sessionConfigAdapter;
        }
        if ((i & 8) != 0) {
            sessionProcessor = useCaseCameraConfig.sessionProcessor;
        }
        if ((i & 16) != 0) {
            lazy = useCaseCameraConfig.lazyCreationResult;
        }
        Lazy lazy2 = lazy;
        SessionConfigAdapter sessionConfigAdapter2 = sessionConfigAdapter;
        return useCaseCameraConfig.copy(function1, graphStateToCameraStateAdapter, sessionConfigAdapter2, sessionProcessor, lazy2);
    }

    public final UseCaseCameraConfig copy(Function1<? super CameraGraph.Config, ? extends CameraGraph> cameraGraphFactory, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, SessionConfigAdapter sessionConfigAdapter, SessionProcessor sessionProcessor, Lazy<CameraGraphConfigProvider.CameraGraphCreationResult> lazyCreationResult) {
        Intrinsics.checkNotNullParameter(cameraGraphFactory, "cameraGraphFactory");
        Intrinsics.checkNotNullParameter(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        Intrinsics.checkNotNullParameter(sessionConfigAdapter, "sessionConfigAdapter");
        Intrinsics.checkNotNullParameter(lazyCreationResult, "lazyCreationResult");
        return new UseCaseCameraConfig(cameraGraphFactory, graphStateToCameraStateAdapter, sessionConfigAdapter, sessionProcessor, lazyCreationResult);
    }

    public String toString() {
        return "UseCaseCameraConfig(cameraGraphFactory=" + this.cameraGraphFactory + ", graphStateToCameraStateAdapter=" + this.graphStateToCameraStateAdapter + ", sessionConfigAdapter=" + this.sessionConfigAdapter + ", sessionProcessor=" + this.sessionProcessor + ", lazyCreationResult=" + this.lazyCreationResult + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UseCaseCameraConfig(Function1<? super CameraGraph.Config, ? extends CameraGraph> cameraGraphFactory, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, SessionConfigAdapter sessionConfigAdapter, SessionProcessor sessionProcessor, Lazy<CameraGraphConfigProvider.CameraGraphCreationResult> lazyCreationResult) {
        Intrinsics.checkNotNullParameter(cameraGraphFactory, "cameraGraphFactory");
        Intrinsics.checkNotNullParameter(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        Intrinsics.checkNotNullParameter(sessionConfigAdapter, "sessionConfigAdapter");
        Intrinsics.checkNotNullParameter(lazyCreationResult, "lazyCreationResult");
        this.cameraGraphFactory = cameraGraphFactory;
        this.graphStateToCameraStateAdapter = graphStateToCameraStateAdapter;
        this.sessionConfigAdapter = sessionConfigAdapter;
        this.sessionProcessor = sessionProcessor;
        this.lazyCreationResult = lazyCreationResult;
    }

    public final CameraGraph.Config getCameraGraphConfig() {
        return this.lazyCreationResult.getValue().getConfig();
    }

    @Provides
    @UseCaseCameraScope
    public final SessionConfigAdapter provideSessionConfigAdapter() {
        return this.sessionConfigAdapter;
    }

    @Provides
    @UseCaseCameraScope
    public final SessionProcessor provideSessionProcessor() {
        return this.sessionProcessor;
    }

    @Provides
    @UseCaseCameraScope
    public final UseCaseGraphContext provideUseCaseGraphContext(CameraStateAdapter cameraStateAdapter) {
        Intrinsics.checkNotNullParameter(cameraStateAdapter, "cameraStateAdapter");
        Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
        if (Logger.isDebugEnabled(Log.TAG)) {
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Prepared UseCaseGraphContext (Deferred)");
        }
        return new UseCaseGraphContext(new Provider() { // from class: androidx.camera.camera2.config.UseCaseCameraConfig$$ExternalSyntheticLambda0
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                UseCaseCameraConfig useCaseCameraConfig = this.f$0;
                return useCaseCameraConfig.cameraGraphFactory.invoke(useCaseCameraConfig.getCameraGraphConfig());
            }
        }, cameraStateAdapter, this.graphStateToCameraStateAdapter, new Provider() { // from class: androidx.camera.camera2.config.UseCaseCameraConfig$$ExternalSyntheticLambda1
            @Override // javax.inject.Provider, jakarta.inject.Provider
            public final Object get() {
                return this.f$0.lazyCreationResult.getValue().getStreamConfigMap();
            }
        }, null, 16, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.camera.camera2.config.UseCaseCameraConfig");
        UseCaseCameraConfig useCaseCameraConfig = (UseCaseCameraConfig) other;
        return Intrinsics.areEqual(this.sessionConfigAdapter, useCaseCameraConfig.sessionConfigAdapter) && Intrinsics.areEqual(this.graphStateToCameraStateAdapter, useCaseCameraConfig.graphStateToCameraStateAdapter) && Intrinsics.areEqual(this.sessionProcessor, useCaseCameraConfig.sessionProcessor);
    }

    public int hashCode() {
        int iHashCode = ((this.sessionConfigAdapter.hashCode() * 31) + this.graphStateToCameraStateAdapter.hashCode()) * 31;
        SessionProcessor sessionProcessor = this.sessionProcessor;
        return iHashCode + (sessionProcessor != null ? sessionProcessor.hashCode() : 0);
    }

    /* JADX INFO: compiled from: UseCaseCameraConfig.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/config/UseCaseCameraConfig$Companion;", "", "<init>", "()V", "create", "Landroidx/camera/camera2/config/UseCaseCameraConfig;", "sessionConfigAdapter", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "cameraGraphConfigProvider", "Landroidx/camera/camera2/impl/CameraGraphConfigProvider;", "cameraGraphFactory", "Lkotlin/Function1;", "Landroidx/camera/camera2/pipe/CameraGraph$Config;", "Landroidx/camera/camera2/pipe/CameraGraph;", "graphStateToCameraStateAdapter", "Landroidx/camera/camera2/adapter/GraphStateToCameraStateAdapter;", "sessionProcessor", "Landroidx/camera/core/impl/SessionProcessor;", "isExtensions", "", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UseCaseCameraConfig create(final SessionConfigAdapter sessionConfigAdapter, final CameraGraphConfigProvider cameraGraphConfigProvider, Function1<? super CameraGraph.Config, ? extends CameraGraph> cameraGraphFactory, final GraphStateToCameraStateAdapter graphStateToCameraStateAdapter, final SessionProcessor sessionProcessor, final boolean isExtensions) {
            Intrinsics.checkNotNullParameter(sessionConfigAdapter, "sessionConfigAdapter");
            Intrinsics.checkNotNullParameter(cameraGraphConfigProvider, "cameraGraphConfigProvider");
            Intrinsics.checkNotNullParameter(cameraGraphFactory, "cameraGraphFactory");
            Intrinsics.checkNotNullParameter(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
            return new UseCaseCameraConfig(cameraGraphFactory, graphStateToCameraStateAdapter, sessionConfigAdapter, sessionProcessor, LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.config.UseCaseCameraConfig$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UseCaseCameraConfig.Companion.create$lambda$0(sessionConfigAdapter, isExtensions, sessionProcessor, cameraGraphConfigProvider, graphStateToCameraStateAdapter);
                }
            }));
        }

        static final CameraGraphConfigProvider.CameraGraphCreationResult create$lambda$0(SessionConfigAdapter sessionConfigAdapter, boolean z, SessionProcessor sessionProcessor, CameraGraphConfigProvider cameraGraphConfigProvider, GraphStateToCameraStateAdapter graphStateToCameraStateAdapter) {
            int iM417getNORMAL2uNL3no;
            Pair<Integer, Integer> implementationType;
            SessionConfig validSessionConfigOrNull = sessionConfigAdapter.getValidSessionConfigOrNull();
            if (z) {
                iM417getNORMAL2uNL3no = CameraGraph.OperatingMode.INSTANCE.m415getEXTENSION2uNL3no();
            } else if (validSessionConfigOrNull == null) {
                iM417getNORMAL2uNL3no = CameraGraph.OperatingMode.INSTANCE.m417getNORMAL2uNL3no();
            } else if (validSessionConfigOrNull.getSessionType() == 1) {
                iM417getNORMAL2uNL3no = CameraGraph.OperatingMode.INSTANCE.m416getHIGH_SPEED2uNL3no();
            } else {
                iM417getNORMAL2uNL3no = validSessionConfigOrNull.getSessionType() == 0 ? CameraGraph.OperatingMode.INSTANCE.m417getNORMAL2uNL3no() : CameraGraph.OperatingMode.INSTANCE.m414customEP6OhB0(validSessionConfigOrNull.getSessionType());
            }
            int i = iM417getNORMAL2uNL3no;
            Integer num = null;
            if (z && sessionProcessor != null && (implementationType = sessionProcessor.getImplementationType()) != null) {
                num = (Integer) implementationType.second;
            }
            return cameraGraphConfigProvider.m92create79VDu0o(i, validSessionConfigOrNull, false, graphStateToCameraStateAdapter, num, sessionConfigAdapter.getSurfaceToStreamUseCaseMap(), sessionConfigAdapter.getSurfaceToStreamUseHintMap());
        }
    }
}
