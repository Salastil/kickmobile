package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraExtensionCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.os.Trace;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraColorSpace$$ExternalSyntheticApiModelOutline6;
import androidx.camera.camera2.pipe.CameraExtensionMetadata;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: Camera2CameraExtensionMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u001e\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0!H\u0096\u0002¢\u0006\u0002\u0010\"J$\u0010\u001e\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\fH\u0096\u0002¢\u0006\u0002\u0010#J)\u0010$\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010%\u001a\u0002H\u001fH\u0016¢\u0006\u0002\u0010&J)\u0010$\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001f0\f2\u0006\u0010%\u001a\u0002H\u001fH\u0016¢\u0006\u0002\u0010'J'\u0010(\u001a\u0004\u0018\u0001H\u001f\"\b\b\u0000\u0010\u001f*\u00020\r2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u001f0*H\u0016¢\u0006\u0002\u0010+J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u00108\u001a\u00020\u0007H\u0016J\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\u00109\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0016J\u001e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0007H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R,\u0010\u001b\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00180\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0013R\u0014\u0010-\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0013R\u001e\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030!0\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001e\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00100R\u001e\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00100R\u001e\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010>\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003050\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraExtensionMetadata;", "Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "isRedacted", "", "cameraExtension", "", "extensionCharacteristics", "Landroid/hardware/camera2/CameraExtensionCharacteristics;", "metadata", "", "Landroidx/camera/camera2/pipe/Metadata$Key;", "", "<init>", "(Ljava/lang/String;ZILandroid/hardware/camera2/CameraExtensionCharacteristics;Ljava/util/Map;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "()Z", "getCameraExtension", "()I", "supportedExtensionSizesByFormat", "", "Lkotlin/Lazy;", "", "Landroid/util/Size;", "supportedExtensionSizesByClass", "Ljava/lang/Class;", "supportedPostviewSizes", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroid/hardware/camera2/CameraCharacteristics$Key;Ljava/lang/Object;)Ljava/lang/Object;", "(Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)Ljava/lang/Object;", "unwrapAs", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "isPostviewSupported", "isCaptureProgressSupported", UserMetadata.KEYDATA_FILENAME, "getKeys", "()Ljava/util/Set;", "requestKeys", "Landroid/hardware/camera2/CaptureRequest$Key;", "getRequestKeys", "resultKeys", "Landroid/hardware/camera2/CaptureResult$Key;", "getResultKeys", "getOutputSizes", "imageFormat", "klass", "getPostviewSizes", "captureSize", "format", "_requestKeys", "_resultKeys", "_isPostviewSupported", "_isCaptureProgressSupported", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2CameraExtensionMetadata implements CameraExtensionMetadata {
    private final Lazy<Boolean> _isCaptureProgressSupported;
    private final Lazy<Boolean> _isPostviewSupported;
    private final Lazy<Set<CaptureRequest.Key<?>>> _requestKeys;
    private final Lazy<Set<CaptureResult.Key<?>>> _resultKeys;
    private final String camera;
    private final int cameraExtension;
    private final CameraExtensionCharacteristics extensionCharacteristics;
    private final boolean isRedacted;
    private final Map<androidx.camera.camera2.pipe.Metadata.Key<?>, Object> metadata;
    private final Map<Class<?>, Lazy<Set<Size>>> supportedExtensionSizesByClass;
    private final Map<Integer, Lazy<Set<Size>>> supportedExtensionSizesByFormat;
    private final Map<Size, Lazy<Set<Size>>> supportedPostviewSizes;

    public /* synthetic */ Camera2CameraExtensionMetadata(String str, boolean z, int i, CameraExtensionCharacteristics cameraExtensionCharacteristics, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, i, cameraExtensionCharacteristics, map);
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public <T> T get(CameraCharacteristics.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public <T> T getOrDefault(CameraCharacteristics.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        return t;
    }

    private Camera2CameraExtensionMetadata(String camera, boolean z, int i, CameraExtensionCharacteristics extensionCharacteristics, Map<androidx.camera.camera2.pipe.Metadata.Key<?>, ? extends Object> metadata) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        Intrinsics.checkNotNullParameter(extensionCharacteristics, "extensionCharacteristics");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.camera = camera;
        this.isRedacted = z;
        this.cameraExtension = i;
        this.extensionCharacteristics = extensionCharacteristics;
        this.metadata = metadata;
        this.supportedExtensionSizesByFormat = new LinkedHashMap();
        this.supportedExtensionSizesByClass = new LinkedHashMap();
        this.supportedPostviewSizes = new LinkedHashMap();
        this._requestKeys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Set<? extends CaptureRequest.Key<Object>>>(this) { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata$special$$inlined$lazyOrEmptySet$1
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends CaptureRequest.Key<Object>> invoke() {
                Set<? extends CaptureRequest.Key<Object>> setEmptySet;
                String str = ((Object) CameraId.m432toStringimpl(this.this$0.getCamera())) + "#availableCaptureRequestKeys";
                try {
                    Debug debug = Debug.INSTANCE;
                    try {
                        Trace.beginSection(str);
                        if (Build.VERSION.SDK_INT >= 33) {
                            setEmptySet = CollectionsKt.toSet(Api33Compat.getAvailableCaptureRequestKeys(this.this$0.extensionCharacteristics, this.this$0.getCameraExtension()));
                        } else {
                            setEmptySet = SetsKt.emptySet();
                        }
                        if (setEmptySet == null) {
                            setEmptySet = SetsKt.emptySet();
                        }
                        return setEmptySet;
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching {} and ignoring exception.", th);
                    }
                    return SetsKt.emptySet();
                }
            }
        });
        this._resultKeys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Set<? extends CaptureResult.Key<Object>>>(this) { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata$special$$inlined$lazyOrEmptySet$2
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends CaptureResult.Key<Object>> invoke() {
                Set<? extends CaptureResult.Key<Object>> setEmptySet;
                String str = ((Object) CameraId.m432toStringimpl(this.this$0.getCamera())) + "#availableCaptureResultKeys";
                try {
                    Debug debug = Debug.INSTANCE;
                    try {
                        Trace.beginSection(str);
                        if (Build.VERSION.SDK_INT >= 33) {
                            setEmptySet = CollectionsKt.toSet(Api33Compat.getAvailableCaptureResultKeys(this.this$0.extensionCharacteristics, this.this$0.getCameraExtension()));
                        } else {
                            setEmptySet = SetsKt.emptySet();
                        }
                        if (setEmptySet == null) {
                            setEmptySet = SetsKt.emptySet();
                        }
                        return setEmptySet;
                    } finally {
                        Trace.endSection();
                    }
                } catch (Throwable th) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching {} and ignoring exception.", th);
                    }
                    return SetsKt.emptySet();
                }
            }
        });
        this._isPostviewSupported = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Boolean>(this) { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata$special$$inlined$lazyOrFalse$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String str = ((Object) CameraId.m432toStringimpl(this.this$0.getCamera())) + "#isPostviewSupported";
                boolean z2 = false;
                try {
                    Debug debug = Debug.INSTANCE;
                    try {
                        Trace.beginSection(str);
                        boolean zIsPostviewAvailable = Build.VERSION.SDK_INT >= 34 ? Api34Compat.isPostviewAvailable(this.this$0.extensionCharacteristics, this.this$0.getCameraExtension()) : false;
                        Trace.endSection();
                        z2 = zIsPostviewAvailable;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching false and ignoring exception.", th2);
                    }
                }
                return Boolean.valueOf(z2);
            }
        });
        this._isCaptureProgressSupported = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Boolean>(this) { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata$special$$inlined$lazyOrFalse$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                String str = ((Object) CameraId.m432toStringimpl(this.this$0.getCamera())) + "#isCaptureProgressSupported";
                boolean z2 = false;
                try {
                    Debug debug = Debug.INSTANCE;
                    try {
                        Trace.beginSection(str);
                        boolean zIsCaptureProcessProgressAvailable = Build.VERSION.SDK_INT >= 34 ? Api34Compat.isCaptureProcessProgressAvailable(this.this$0.extensionCharacteristics, this.this$0.getCameraExtension()) : false;
                        Trace.endSection();
                        z2 = zIsCaptureProcessProgressAvailable;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (Log.INSTANCE.getWARN_LOGGABLE()) {
                        android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching false and ignoring exception.", th2);
                    }
                }
                return Boolean.valueOf(z2);
            }
        });
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    /* JADX INFO: renamed from: isRedacted, reason: from getter */
    public boolean getIsRedacted() {
        return this.isRedacted;
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public int getCameraExtension() {
        return this.cameraExtension;
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T get(androidx.camera.camera2.pipe.Metadata.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.metadata.get(key);
    }

    @Override // androidx.camera.camera2.pipe.Metadata
    public <T> T getOrDefault(androidx.camera.camera2.pipe.Metadata.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) this.metadata.get(key);
        return t2 == null ? t : t2;
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraColorSpace$$ExternalSyntheticApiModelOutline6.m273m$1()))) {
            return null;
        }
        Object obj = this.extensionCharacteristics;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata.unwrapAs");
        return (T) obj;
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public boolean isPostviewSupported() {
        return this._isPostviewSupported.getValue().booleanValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public boolean isCaptureProgressSupported() {
        return this._isCaptureProgressSupported.getValue().booleanValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public Set<CameraCharacteristics.Key<?>> getKeys() {
        return SetsKt.emptySet();
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public Set<CaptureRequest.Key<?>> getRequestKeys() {
        return this._requestKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public Set<CaptureResult.Key<?>> getResultKeys() {
        return this._resultKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public Set<Size> getOutputSizes(final int imageFormat) {
        Lazy<Set<Size>> lazy;
        synchronized (this.supportedExtensionSizesByFormat) {
            Map<Integer, Lazy<Set<Size>>> map = this.supportedExtensionSizesByFormat;
            Integer numValueOf = Integer.valueOf(imageFormat);
            Lazy<Set<Size>> lazy2 = map.get(numValueOf);
            if (lazy2 == null) {
                lazy2 = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Set<? extends Size>>(imageFormat, this, imageFormat) { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata$getOutputSizes$lambda$0$0$$inlined$lazyOrEmptySet$1
                    final /* synthetic */ int $imageFormat$inlined;
                    final /* synthetic */ int $imageFormat$inlined$1;

                    {
                        this.$imageFormat$inlined$1 = imageFormat;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Set<? extends Size> invoke() {
                        String str = ((Object) CameraId.m432toStringimpl(this.this$0.getCamera())) + "#getExtensionSupportedSizes(" + this.$imageFormat$inlined + ')';
                        try {
                            Debug debug = Debug.INSTANCE;
                            try {
                                Trace.beginSection(str);
                                Set<? extends Size> set = CollectionsKt.toSet(Api31Compat.getExtensionSupportedSizes(this.this$0.extensionCharacteristics, this.this$0.getCameraExtension(), this.$imageFormat$inlined$1));
                                if (set == null) {
                                    set = SetsKt.emptySet();
                                }
                                return set;
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to get " + str + "! Caching {} and ignoring exception.", th);
                            }
                            return SetsKt.emptySet();
                        }
                    }
                });
                map.put(numValueOf, lazy2);
            }
            lazy = lazy2;
        }
        return lazy.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public Set<Size> getOutputSizes(final Class<?> klass) {
        Lazy<Set<Size>> lazy;
        Intrinsics.checkNotNullParameter(klass, "klass");
        synchronized (this.supportedExtensionSizesByClass) {
            Map<Class<?>, Lazy<Set<Size>>> map = this.supportedExtensionSizesByClass;
            Lazy<Set<Size>> lazy2 = map.get(klass);
            if (lazy2 == null) {
                final String str = ((Object) CameraId.m432toStringimpl(getCamera())) + "#getExtensionSupportedSizes(" + klass.getName() + ')';
                lazy2 = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Set<? extends Size>>() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata$getOutputSizes$lambda$1$0$$inlined$lazyOrEmptySet$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Set<? extends Size> invoke() {
                        String str2 = str;
                        try {
                            Debug debug = Debug.INSTANCE;
                            try {
                                Trace.beginSection(str2);
                                Set<? extends Size> set = CollectionsKt.toSet(Api31Compat.getExtensionSupportedSizes(this.extensionCharacteristics, this.getCameraExtension(), (Class<?>) klass));
                                if (set == null) {
                                    set = SetsKt.emptySet();
                                }
                                return set;
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to get " + str2 + "! Caching {} and ignoring exception.", th);
                            }
                            return SetsKt.emptySet();
                        }
                    }
                });
                map.put(klass, lazy2);
            }
            lazy = lazy2;
        }
        return lazy.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraExtensionMetadata
    public Set<Size> getPostviewSizes(final Size captureSize, final int format) {
        Lazy<Set<Size>> lazy;
        Intrinsics.checkNotNullParameter(captureSize, "captureSize");
        if (Build.VERSION.SDK_INT < 34) {
            return SetsKt.emptySet();
        }
        synchronized (this.supportedPostviewSizes) {
            Map<Size, Lazy<Set<Size>>> map = this.supportedPostviewSizes;
            Lazy<Set<Size>> lazy2 = map.get(captureSize);
            if (lazy2 == null) {
                final String str = ((Object) CameraId.m432toStringimpl(getCamera())) + "#getPostviewSupportedSizes(" + captureSize + ", " + format + ')';
                lazy2 = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new Function0<Set<? extends Size>>() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraExtensionMetadata$getPostviewSizes$lambda$0$0$$inlined$lazyOrEmptySet$1
                    @Override // kotlin.jvm.functions.Function0
                    public final Set<? extends Size> invoke() {
                        String str2 = str;
                        try {
                            Debug debug = Debug.INSTANCE;
                            try {
                                Trace.beginSection(str2);
                                Set<? extends Size> set = CollectionsKt.toSet(Api34Compat.getPostviewSupportedSizes(this.extensionCharacteristics, this.getCameraExtension(), captureSize, format));
                                if (set == null) {
                                    set = SetsKt.emptySet();
                                }
                                return set;
                            } finally {
                                Trace.endSection();
                            }
                        } catch (Throwable th) {
                            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                                android.util.Log.w(Log.TAG, "Failed to get " + str2 + "! Caching {} and ignoring exception.", th);
                            }
                            return SetsKt.emptySet();
                        }
                    }
                });
                map.put(captureSize, lazy2);
            }
            lazy = lazy2;
        }
        return lazy.getValue();
    }
}
