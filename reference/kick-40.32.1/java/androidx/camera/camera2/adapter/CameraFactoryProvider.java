package androidx.camera.camera2.adapter;

import android.content.Context;
import android.os.Trace;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.impl.CameraInteropStateCallbackRepository;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.CameraPipeKt;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.SystemTimeSource;
import androidx.camera.camera2.pipe.core.Timestamps;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.StreamSpecsCalculator;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraFactoryProvider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ<\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J'\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\b\u001bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/camera/camera2/adapter/CameraFactoryProvider;", "Landroidx/camera/core/impl/CameraFactory$Provider;", "sharedCameraPipe", "Landroidx/camera/camera2/pipe/CameraPipe;", "sharedAppContext", "Landroid/content/Context;", "sharedThreadConfig", "Landroidx/camera/core/impl/CameraThreadConfig;", "<init>", "(Landroidx/camera/camera2/pipe/CameraPipe;Landroid/content/Context;Landroidx/camera/core/impl/CameraThreadConfig;)V", "sharedInteropCallbacks", "Landroidx/camera/camera2/impl/CameraInteropStateCallbackRepository;", "newInstance", "Landroidx/camera/core/impl/CameraFactory;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "threadConfig", "availableCamerasLimiter", "Landroidx/camera/core/CameraSelector;", "cameraOpenRetryMaxTimeoutInMs", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "streamSpecsCalculator", "Landroidx/camera/core/internal/StreamSpecsCalculator;", "createCameraPipe", "openRetryMaxTimeout", "Landroidx/camera/camera2/pipe/core/DurationNs;", "createCameraPipe-ck8WKOA", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraFactoryProvider implements CameraFactory.Provider {
    private final Context sharedAppContext;
    private final CameraPipe sharedCameraPipe;
    private final CameraInteropStateCallbackRepository sharedInteropCallbacks;
    private final CameraThreadConfig sharedThreadConfig;

    public CameraFactoryProvider() {
        this(null, null, null, 7, null);
    }

    public CameraFactoryProvider(CameraPipe cameraPipe, Context context, CameraThreadConfig cameraThreadConfig) {
        this.sharedCameraPipe = cameraPipe;
        this.sharedAppContext = context;
        this.sharedThreadConfig = cameraThreadConfig;
        this.sharedInteropCallbacks = new CameraInteropStateCallbackRepository();
    }

    public /* synthetic */ CameraFactoryProvider(CameraPipe cameraPipe, Context context, CameraThreadConfig cameraThreadConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cameraPipe, (i & 2) != 0 ? null : context, (i & 4) != 0 ? null : cameraThreadConfig);
    }

    @Override // androidx.camera.core.impl.CameraFactory.Provider
    public CameraFactory newInstance(final Context context, final CameraThreadConfig threadConfig, CameraSelector availableCamerasLimiter, long cameraOpenRetryMaxTimeoutInMs, CameraXConfig cameraXConfig, StreamSpecsCalculator streamSpecsCalculator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(threadConfig, "threadConfig");
        Intrinsics.checkNotNullParameter(streamSpecsCalculator, "streamSpecsCalculator");
        final DurationNs durationNsM915boximpl = cameraOpenRetryMaxTimeoutInMs == -1 ? null : DurationNs.m915boximpl(DurationNs.m917constructorimpl(cameraOpenRetryMaxTimeoutInMs));
        Lazy lazy = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.adapter.CameraFactoryProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CameraFactoryProvider.newInstance$lambda$0(this.f$0, context, threadConfig, durationNsM915boximpl);
            }
        });
        Context context2 = this.sharedAppContext;
        Context context3 = context2 == null ? context : context2;
        CameraThreadConfig cameraThreadConfig = this.sharedThreadConfig;
        CameraThreadConfig cameraThreadConfig2 = cameraThreadConfig == null ? threadConfig : cameraThreadConfig;
        CameraInteropStateCallbackRepository cameraInteropStateCallbackRepository = this.sharedInteropCallbacks;
        if (cameraXConfig == null) {
            cameraXConfig = new CameraXConfig.Builder().build();
            Intrinsics.checkNotNullExpressionValue(cameraXConfig, "build(...)");
        }
        return new CameraFactoryAdapter(lazy, context3, cameraThreadConfig2, cameraInteropStateCallbackRepository, availableCamerasLimiter, streamSpecsCalculator, cameraXConfig);
    }

    static final CameraPipe newInstance$lambda$0(CameraFactoryProvider cameraFactoryProvider, Context context, CameraThreadConfig cameraThreadConfig, DurationNs durationNs) {
        if (cameraFactoryProvider.sharedCameraPipe != null) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "Using shared a " + cameraFactoryProvider.sharedCameraPipe + " instance.");
            }
            return cameraFactoryProvider.sharedCameraPipe;
        }
        return cameraFactoryProvider.m42createCameraPipeck8WKOA(context, cameraThreadConfig, durationNs);
    }

    /* JADX INFO: renamed from: createCameraPipe-ck8WKOA, reason: not valid java name */
    private final CameraPipe m42createCameraPipeck8WKOA(Context context, CameraThreadConfig threadConfig, DurationNs openRetryMaxTimeout) {
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection("Create CameraPipe");
            SystemTimeSource systemTimeSource = new SystemTimeSource();
            Timestamps timestamps = Timestamps.INSTANCE;
            long jMo927nowvQl9yQU = systemTimeSource.mo927nowvQl9yQU();
            Context persistentApplicationContext = ContextUtil.getPersistentApplicationContext(context);
            Intrinsics.checkNotNullExpressionValue(persistentApplicationContext, "getPersistentApplicationContext(...)");
            CameraPipe CameraPipe = CameraPipeKt.CameraPipe(new CameraPipe.Config(persistentApplicationContext, new CameraPipe.ThreadConfig(null, null, null, CameraXExecutors.newSequentialExecutor(threadConfig.getCameraExecutor()), null, null, null, 119, null), null, null, new CameraPipe.CameraInteropConfig(this.sharedInteropCallbacks.get_deviceStateCallback(), this.sharedInteropCallbacks.getSessionStateCallback(), openRetryMaxTimeout, null), null, null, null, WebmConstants.MkvEbmlElement.VOID, null));
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                String str = Camera2Logger.TRUNCATED_TAG;
                StringBuilder sb = new StringBuilder("Created CameraPipe in ");
                Timestamps timestamps2 = Timestamps.INSTANCE;
                Timestamps timestamps3 = Timestamps.INSTANCE;
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(DurationNs.m917constructorimpl(systemTimeSource.mo927nowvQl9yQU() - jMo927nowvQl9yQU) / 1000000.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                sb.append(str2);
                android.util.Log.d(str, sb.toString());
            }
            return CameraPipe;
        } finally {
            Trace.endSection();
        }
    }
}
