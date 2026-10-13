package androidx.camera.camera2.pipe.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Trace;
import android.util.ArrayMap;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.camera2.pipe.CameraError;
import androidx.camera.camera2.pipe.CameraExtensionMetadata;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.CameraPipe;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import androidx.camera.camera2.pipe.config.CameraPipeContext;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.DurationNs;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.camera2.pipe.core.Permissions;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.core.TimeSource;
import androidx.camera.camera2.pipe.core.Timestamps;
import com.datadog.trace.api.DDSpanTypes;
import java.util.Arrays;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: Camera2MetadataCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Singleton
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B3\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0'2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020+2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-H\u0002¢\u0006\u0004\b.\u0010/J'\u00100\u001a\u0002012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0004\b5\u00106J\b\u00107\u001a\u00020-H\u0002J\u0010\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u000f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000f8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataProvider;", "cameraPipeContext", "Landroid/content/Context;", "threads", "Landroidx/camera/camera2/pipe/core/Threads;", "permissions", "Landroidx/camera/camera2/pipe/core/Permissions;", "cameraMetadataConfig", "Landroidx/camera/camera2/pipe/CameraPipe$CameraMetadataConfig;", "timeSource", "Landroidx/camera/camera2/pipe/core/TimeSource;", "<init>", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/core/Permissions;Landroidx/camera/camera2/pipe/CameraPipe$CameraMetadataConfig;Landroidx/camera/camera2/pipe/core/TimeSource;)V", DDSpanTypes.CACHE, "Landroid/util/ArrayMap;", "", "Landroidx/camera/camera2/pipe/CameraMetadata;", "extensionCache", "Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "extensionCharacteristicsCache", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "getCameraMetadata", "cameraId", "Landroidx/camera/camera2/pipe/CameraId;", "getCameraMetadata-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCameraExtensionMetadata", "extension", "", "getCameraExtensionMetadata-RzXb1QE", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCameraMetadata", "awaitCameraMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "awaitCameraExtensionMetadata", "awaitCameraExtensionMetadata-0r8Bogc", "(Ljava/lang/String;I)Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "getSupportedCameraExtensions", "", "getSupportedCameraExtensions-EfqyGwQ", "(Ljava/lang/String;)Ljava/util/Set;", "createCameraMetadata", "Landroidx/camera/camera2/pipe/compat/Camera2CameraMetadata;", "redacted", "", "createCameraMetadata-0r8Bogc", "(Ljava/lang/String;Z)Landroidx/camera/camera2/pipe/compat/Camera2CameraMetadata;", "createCameraExtensionMetadata", "Landroidx/camera/camera2/pipe/compat/Camera2CameraExtensionMetadata;", "createCameraExtensionMetadata-RzXb1QE", "(Ljava/lang/String;ZI)Landroidx/camera/camera2/pipe/compat/Camera2CameraExtensionMetadata;", "getCameraExtensionCharacteristics", "getCameraExtensionCharacteristics-EfqyGwQ", "(Ljava/lang/String;)Landroid/hardware/camera2/CameraExtensionCharacteristics;", "isMetadataRedacted", "shouldBlockSensorOrientationCache", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2MetadataCache implements Camera2MetadataProvider {
    private final ArrayMap<String, CameraMetadata> cache;
    private final CameraPipe.CameraMetadataConfig cameraMetadataConfig;
    private final Context cameraPipeContext;
    private final ArrayMap<String, CameraExtensionMetadata> extensionCache;
    private final ArrayMap<String, CameraExtensionCharacteristics> extensionCharacteristicsCache;
    private final Permissions permissions;
    private final Threads threads;
    private final TimeSource timeSource;

    @Inject
    public Camera2MetadataCache(@CameraPipeContext Context cameraPipeContext, Threads threads, Permissions permissions, CameraPipe.CameraMetadataConfig cameraMetadataConfig, TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(cameraPipeContext, "cameraPipeContext");
        Intrinsics.checkNotNullParameter(threads, "threads");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(cameraMetadataConfig, "cameraMetadataConfig");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.cameraPipeContext = cameraPipeContext;
        this.threads = threads;
        this.permissions = permissions;
        this.cameraMetadataConfig = cameraMetadataConfig;
        this.timeSource = timeSource;
        this.cache = new ArrayMap<>();
        this.extensionCache = new ArrayMap<>();
        this.extensionCharacteristicsCache = new ArrayMap<>();
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2MetadataProvider
    /* JADX INFO: renamed from: getCameraMetadata-0r8Bogc, reason: not valid java name */
    public Object mo848getCameraMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation) {
        synchronized (this.cache) {
            CameraMetadata cameraMetadata = this.cache.get(str);
            if (cameraMetadata != null) {
                return cameraMetadata;
            }
            Unit unit = Unit.INSTANCE;
            return BuildersKt.withContext(this.threads.getBackgroundDispatcher(), new Camera2MetadataCache$getCameraMetadata$3(this, str, null), continuation);
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2MetadataProvider
    /* JADX INFO: renamed from: getCameraExtensionMetadata-RzXb1QE, reason: not valid java name */
    public Object mo847getCameraExtensionMetadataRzXb1QE(String str, int i, Continuation<? super CameraExtensionMetadata> continuation) {
        synchronized (this.extensionCache) {
            CameraExtensionMetadata cameraExtensionMetadata = this.extensionCache.get(str);
            if (cameraExtensionMetadata != null) {
                return cameraExtensionMetadata;
            }
            Unit unit = Unit.INSTANCE;
            return BuildersKt.withContext(this.threads.getBackgroundDispatcher(), new Camera2MetadataCache$getCameraExtensionMetadata$3(this, str, i, null), continuation);
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2MetadataProvider
    /* JADX INFO: renamed from: awaitCameraMetadata-EfqyGwQ, reason: not valid java name */
    public CameraMetadata mo846awaitCameraMetadataEfqyGwQ(String cameraId) {
        Camera2CameraMetadata camera2CameraMetadataM843createCameraMetadata0r8Bogc;
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(((Object) CameraId.m432toStringimpl(cameraId)) + "#awaitMetadata");
            synchronized (this.cache) {
                camera2CameraMetadataM843createCameraMetadata0r8Bogc = (CameraMetadata) this.cache.get(cameraId);
                if (camera2CameraMetadataM843createCameraMetadata0r8Bogc == null) {
                    if (isMetadataRedacted()) {
                        Unit unit = Unit.INSTANCE;
                        camera2CameraMetadataM843createCameraMetadata0r8Bogc = m843createCameraMetadata0r8Bogc(cameraId, true);
                    } else {
                        Camera2CameraMetadata camera2CameraMetadataM843createCameraMetadata0r8Bogc2 = m843createCameraMetadata0r8Bogc(cameraId, false);
                        this.cache.put(cameraId, camera2CameraMetadataM843createCameraMetadata0r8Bogc2);
                        camera2CameraMetadataM843createCameraMetadata0r8Bogc = camera2CameraMetadataM843createCameraMetadata0r8Bogc2;
                    }
                }
            }
            Trace.endSection();
            return camera2CameraMetadataM843createCameraMetadata0r8Bogc;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2MetadataProvider
    /* JADX INFO: renamed from: awaitCameraExtensionMetadata-0r8Bogc, reason: not valid java name */
    public CameraExtensionMetadata mo845awaitCameraExtensionMetadata0r8Bogc(String cameraId, int extension) throws Exception {
        Camera2CameraExtensionMetadata camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE;
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (Build.VERSION.SDK_INT < 31) {
            throw new Exception("Extension sessions are only supported on Android S or higher. Device SDK is " + Build.VERSION.SDK_INT);
        }
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(((Object) CameraId.m432toStringimpl(cameraId)) + "#awaitExtensionMetadata");
            synchronized (this.extensionCache) {
                camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE = (CameraExtensionMetadata) this.extensionCache.get(cameraId);
                if (camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE == null) {
                    if (isMetadataRedacted()) {
                        Unit unit = Unit.INSTANCE;
                        camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE = m842createCameraExtensionMetadataRzXb1QE(cameraId, true, extension);
                    } else {
                        Camera2CameraExtensionMetadata camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE2 = m842createCameraExtensionMetadataRzXb1QE(cameraId, false, extension);
                        this.extensionCache.put(cameraId, camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE2);
                        camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE = camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE2;
                    }
                }
            }
            Trace.endSection();
            return camera2CameraExtensionMetadataM842createCameraExtensionMetadataRzXb1QE;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2MetadataProvider
    /* JADX INFO: renamed from: getSupportedCameraExtensions-EfqyGwQ, reason: not valid java name */
    public Set<Integer> mo849getSupportedCameraExtensionsEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (Build.VERSION.SDK_INT >= 31) {
            return CollectionsKt.toSet(Api31Compat.getSupportedExtensions(m844getCameraExtensionCharacteristicsEfqyGwQ(cameraId)));
        }
        return SetsKt.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createCameraMetadata-0r8Bogc, reason: not valid java name */
    public final Camera2CameraMetadata m843createCameraMetadata0r8Bogc(String cameraId, boolean redacted) {
        Set<CameraCharacteristics.Key<?>> setPlus;
        String str;
        Timestamps timestamps = Timestamps.INSTANCE;
        long jMo927nowvQl9yQU = this.timeSource.mo927nowvQl9yQU();
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(((Object) CameraId.m432toStringimpl(cameraId)) + "#readCameraMetadata");
            try {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Loading metadata for " + ((Object) CameraId.m432toStringimpl(cameraId)));
                }
                Object systemService = this.cameraPipeContext.getSystemService("camera");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                CameraCharacteristics cameraCharacteristics = ((CameraManager) systemService).getCameraCharacteristics(cameraId);
                Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "getCameraCharacteristics(...)");
                if (cameraCharacteristics != null) {
                    if (shouldBlockSensorOrientationCache(cameraCharacteristics)) {
                        Set<CameraCharacteristics.Key<?>> setEmptySet = this.cameraMetadataConfig.getCameraCacheBlocklist().get(CameraId.m426boximpl(cameraId));
                        if (setEmptySet == null) {
                            setEmptySet = SetsKt.emptySet();
                        }
                        setPlus = SetsKt.plus(setEmptySet, CameraCharacteristics.SENSOR_ORIENTATION);
                    } else {
                        setPlus = this.cameraMetadataConfig.getCameraCacheBlocklist().get(CameraId.m426boximpl(cameraId));
                    }
                    Camera2CameraMetadata camera2CameraMetadata = new Camera2CameraMetadata(cameraId, redacted, cameraCharacteristics, this, MapsKt.emptyMap(), setPlus == null ? this.cameraMetadataConfig.getCacheBlocklist() : SetsKt.plus((Set) this.cameraMetadataConfig.getCacheBlocklist(), (Iterable) setPlus), null);
                    if (Log.INSTANCE.getINFO_LOGGABLE()) {
                        Timestamps timestamps2 = Timestamps.INSTANCE;
                        long jM917constructorimpl = DurationNs.m917constructorimpl(this.timeSource.mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                        if (!redacted) {
                            str = "";
                        } else {
                            if (!redacted) {
                                throw new NoWhenBranchMatchedException();
                            }
                            str = " (redacted)";
                        }
                        StringBuilder sb = new StringBuilder("Loaded metadata for ");
                        sb.append((Object) CameraId.m432toStringimpl(cameraId));
                        sb.append(" in ");
                        Timestamps timestamps3 = Timestamps.INSTANCE;
                        String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        sb.append(str2);
                        sb.append(str);
                        android.util.Log.i(Log.TAG, sb.toString());
                    }
                    Trace.endSection();
                    return camera2CameraMetadata;
                }
                throw new IllegalStateException(("Failed to get CameraCharacteristics for " + ((Object) CameraId.m432toStringimpl(cameraId)) + '!').toString());
            } catch (Throwable th) {
                if (CameraError.INSTANCE.shouldHandleDoNotDisturbException$camera_camera2_pipe(th)) {
                    throw new DoNotDisturbException("Failed to load metadata: Do Not Disturb mode is on!");
                }
                throw new IllegalStateException("Failed to load metadata for " + ((Object) CameraId.m432toStringimpl(cameraId)) + '!', th);
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createCameraExtensionMetadata-RzXb1QE, reason: not valid java name */
    public final Camera2CameraExtensionMetadata m842createCameraExtensionMetadataRzXb1QE(String cameraId, boolean redacted, int extension) {
        String str;
        Timestamps timestamps = Timestamps.INSTANCE;
        long jMo927nowvQl9yQU = this.timeSource.mo927nowvQl9yQU();
        Debug debug = Debug.INSTANCE;
        try {
            Trace.beginSection(((Object) CameraId.m432toStringimpl(cameraId)) + "#readCameraExtensionMetadata");
            try {
                if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                    android.util.Log.d(Log.TAG, "Loading extension metadata for " + ((Object) CameraId.m432toStringimpl(cameraId)));
                }
                Camera2CameraExtensionMetadata camera2CameraExtensionMetadata = new Camera2CameraExtensionMetadata(cameraId, redacted, extension, m844getCameraExtensionCharacteristicsEfqyGwQ(cameraId), MapsKt.emptyMap(), null);
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    Timestamps timestamps2 = Timestamps.INSTANCE;
                    long jM917constructorimpl = DurationNs.m917constructorimpl(this.timeSource.mo927nowvQl9yQU() - jMo927nowvQl9yQU);
                    if (!redacted) {
                        str = "";
                    } else {
                        if (!redacted) {
                            throw new NoWhenBranchMatchedException();
                        }
                        str = " (redacted)";
                    }
                    StringBuilder sb = new StringBuilder("Loaded extension metadata for ");
                    sb.append((Object) CameraId.m432toStringimpl(cameraId));
                    sb.append(" in ");
                    Timestamps timestamps3 = Timestamps.INSTANCE;
                    String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(jM917constructorimpl / 1000000.0d)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    sb.append(str2);
                    sb.append(str);
                    android.util.Log.i(Log.TAG, sb.toString());
                }
                Trace.endSection();
                return camera2CameraExtensionMetadata;
            } catch (Throwable th) {
                throw new IllegalStateException("Failed to load extension metadata for " + ((Object) CameraId.m432toStringimpl(cameraId)) + '!', th);
            }
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getCameraExtensionCharacteristics-EfqyGwQ, reason: not valid java name */
    public final CameraExtensionCharacteristics m844getCameraExtensionCharacteristicsEfqyGwQ(String cameraId) throws CameraAccessException {
        synchronized (this.extensionCharacteristicsCache) {
            CameraExtensionCharacteristics cameraExtensionCharacteristicsM255m = CameraColorSpace$$ExternalSyntheticApiModelOutline6.m255m((Object) this.extensionCharacteristicsCache.get(cameraId));
            if (cameraExtensionCharacteristicsM255m != null) {
                return cameraExtensionCharacteristicsM255m;
            }
            Unit unit = Unit.INSTANCE;
            if (Log.INSTANCE.getDEBUG_LOGGABLE()) {
                android.util.Log.d(Log.TAG, "Retrieving CameraExtensionCharacteristics for " + ((Object) CameraId.m432toStringimpl(cameraId)));
            }
            Object systemService = this.cameraPipeContext.getSystemService("camera");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            CameraExtensionCharacteristics cameraExtensionCharacteristics = Api31Compat.getCameraExtensionCharacteristics((CameraManager) systemService, cameraId);
            if (cameraExtensionCharacteristics != null) {
                return cameraExtensionCharacteristics;
            }
            throw new IllegalStateException(("Failed to get CameraExtensionCharacteristics for " + ((Object) CameraId.m432toStringimpl(cameraId)) + '!').toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMetadataRedacted() {
        return !this.permissions.getHasCameraPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldBlockSensorOrientationCache(CameraCharacteristics characteristics) {
        return Build.VERSION.SDK_INT >= 32 && characteristics.get(CameraCharacteristics.INFO_DEVICE_STATE_SENSOR_ORIENTATION_MAP) != null;
    }
}
