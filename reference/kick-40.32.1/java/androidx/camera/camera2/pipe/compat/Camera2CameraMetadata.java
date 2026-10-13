package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.os.Build;
import android.os.Trace;
import android.util.ArrayMap;
import androidx.camera.camera2.pipe.CameraExtensionMetadata;
import androidx.camera.camera2.pipe.CameraId;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Debug;
import androidx.camera.camera2.pipe.core.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: Camera2CameraMetadata.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b\u0012\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\fH\u0096\u0002¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\f2\u0006\u0010!\u001a\u0002H\u001dH\u0016¢\u0006\u0002\u0010\"J$\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0010H\u0096\u0002¢\u0006\u0002\u0010#J)\u0010 \u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00102\u0006\u0010!\u001a\u0002H\u001dH\u0016¢\u0006\u0002\u0010$J'\u0010%\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001d0'H\u0016¢\u0006\u0002\u0010(J\u0018\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u0003H\u0016¢\u0006\u0004\bA\u0010BJ\u0016\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001aH\u0016J'\u0010P\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d*\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0010H\u0002¢\u0006\u0002\u0010QR\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00188\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00188\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001e\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010+R\u001e\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010+R\u001e\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010+R\u001e\u00104\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010+R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010+R\u001e\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010+R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010+R\u001a\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010I\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010J\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010K\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003000\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010M\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010N\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010O\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0\u000f0HX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2CameraMetadata;", "Landroidx/camera/camera2/pipe/CameraMetadata;", "camera", "Landroidx/camera/camera2/pipe/CameraId;", "isRedacted", "", "characteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "metadataProvider", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataProvider;", "metadata", "", "Landroidx/camera/camera2/pipe/Metadata$Key;", "", "cacheBlocklist", "", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "<init>", "(Ljava/lang/String;ZLandroid/hardware/camera2/CameraCharacteristics;Landroidx/camera/camera2/pipe/compat/Camera2MetadataProvider;Ljava/util/Map;Ljava/util/Set;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCamera-Dz_R5H8", "()Ljava/lang/String;", "Ljava/lang/String;", "()Z", "values", "Landroid/util/ArrayMap;", "extensionCache", "", "Landroidx/camera/camera2/pipe/CameraExtensionMetadata;", "get", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Landroidx/camera/camera2/pipe/Metadata$Key;)Ljava/lang/Object;", "getOrDefault", Constants.COLLATION_DEFAULT, "(Landroidx/camera/camera2/pipe/Metadata$Key;Ljava/lang/Object;)Ljava/lang/Object;", "(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "(Landroid/hardware/camera2/CameraCharacteristics$Key;Ljava/lang/Object;)Ljava/lang/Object;", "unwrapAs", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", UserMetadata.KEYDATA_FILENAME, "getKeys", "()Ljava/util/Set;", "requestKeys", "Landroid/hardware/camera2/CaptureRequest$Key;", "getRequestKeys", "resultKeys", "Landroid/hardware/camera2/CaptureResult$Key;", "getResultKeys", "sessionKeys", "getSessionKeys", "sessionCharacteristicsKeys", "getSessionCharacteristicsKeys", "physicalCameraIds", "getPhysicalCameraIds", "physicalRequestKeys", "getPhysicalRequestKeys", "supportedExtensions", "getSupportedExtensions", "getPhysicalMetadata", "cameraId", "getPhysicalMetadata-0r8Bogc", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPhysicalMetadata", "awaitPhysicalMetadata-EfqyGwQ", "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/CameraMetadata;", "getExtensionMetadata", "extension", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitExtensionMetadata", "_supportedExtensions", "Lkotlin/Lazy;", "_keys", "_requestKeys", "_resultKeys", "_physicalCameraIds", "_physicalRequestKeys", "_sessionCharacteristicsKeys", "_sessionKeys", "getOrThrow", "(Landroid/hardware/camera2/CameraCharacteristics;Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Camera2CameraMetadata implements CameraMetadata {
    private final Lazy<Set<CameraCharacteristics.Key<?>>> _keys;
    private final Lazy<Set<CameraId>> _physicalCameraIds;
    private final Lazy<Set<CaptureRequest.Key<?>>> _physicalRequestKeys;
    private final Lazy<Set<CaptureRequest.Key<?>>> _requestKeys;
    private final Lazy<Set<CaptureResult.Key<?>>> _resultKeys;
    private final Lazy<Set<CameraCharacteristics.Key<?>>> _sessionCharacteristicsKeys;
    private final Lazy<Set<CaptureRequest.Key<?>>> _sessionKeys;
    private final Lazy<Set<Integer>> _supportedExtensions;
    private final Set<CameraCharacteristics.Key<?>> cacheBlocklist;
    private final String camera;
    private final CameraCharacteristics characteristics;
    private final ArrayMap<Integer, CameraExtensionMetadata> extensionCache;
    private final boolean isRedacted;
    private final Map<androidx.camera.camera2.pipe.Metadata.Key<?>, Object> metadata;
    private final Camera2MetadataProvider metadataProvider;
    private final ArrayMap<CameraCharacteristics.Key<?>, Object> values;

    /* JADX INFO: renamed from: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$getExtensionMetadata$1, reason: invalid class name */
    /* JADX INFO: compiled from: Camera2CameraMetadata.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "androidx.camera.camera2.pipe.compat.Camera2CameraMetadata", f = "Camera2CameraMetadata.kt", i = {0}, l = {140}, m = "getExtensionMetadata", n = {"extension"}, s = {"I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Camera2CameraMetadata.this.getExtensionMetadata(0, this);
        }
    }

    public /* synthetic */ Camera2CameraMetadata(String str, boolean z, CameraCharacteristics cameraCharacteristics, Camera2MetadataProvider camera2MetadataProvider, Map map, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, cameraCharacteristics, camera2MetadataProvider, map, set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Camera2CameraMetadata(String camera, boolean z, CameraCharacteristics characteristics, Camera2MetadataProvider metadataProvider, Map<androidx.camera.camera2.pipe.Metadata.Key<?>, ? extends Object> metadata, Set<? extends CameraCharacteristics.Key<?>> cacheBlocklist) {
        Intrinsics.checkNotNullParameter(camera, "camera");
        Intrinsics.checkNotNullParameter(characteristics, "characteristics");
        Intrinsics.checkNotNullParameter(metadataProvider, "metadataProvider");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(cacheBlocklist, "cacheBlocklist");
        this.camera = camera;
        this.isRedacted = z;
        this.characteristics = characteristics;
        this.metadataProvider = metadataProvider;
        this.metadata = metadata;
        this.cacheBlocklist = cacheBlocklist;
        this.values = new ArrayMap<>();
        this.extensionCache = new ArrayMap<>();
        this._supportedExtensions = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._supportedExtensions$lambda$0(this.f$0);
            }
        });
        this._keys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._keys$lambda$0(this.f$0);
            }
        });
        this._requestKeys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._requestKeys$lambda$0(this.f$0);
            }
        });
        this._resultKeys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._resultKeys$lambda$0(this.f$0);
            }
        });
        this._physicalCameraIds = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._physicalCameraIds$lambda$0(this.f$0);
            }
        });
        this._physicalRequestKeys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._physicalRequestKeys$lambda$0(this.f$0);
            }
        });
        this._sessionCharacteristicsKeys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._sessionCharacteristicsKeys$lambda$0(this.f$0);
            }
        });
        this._sessionKeys = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: androidx.camera.camera2.pipe.compat.Camera2CameraMetadata$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Camera2CameraMetadata._sessionKeys$lambda$0(this.f$0);
            }
        });
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    /* JADX INFO: renamed from: getCamera-Dz_R5H8, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    /* JADX INFO: renamed from: isRedacted, reason: from getter */
    public boolean getIsRedacted() {
        return this.isRedacted;
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

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public <T> T get(CameraCharacteristics.Key<T> key) {
        T t;
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.cacheBlocklist.contains(key)) {
            return (T) getOrThrow(this.characteristics, key);
        }
        synchronized (this.values) {
            t = (T) this.values.get(key);
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) getOrThrow(this.characteristics, key);
        if (t2 == null) {
            return t2;
        }
        synchronized (this.values) {
            this.values.put(key, t2);
            Unit unit = Unit.INSTANCE;
        }
        return t2;
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public <T> T getOrDefault(CameraCharacteristics.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) get(key);
        return t2 == null ? t : t2;
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(CameraCharacteristics.class))) {
            return null;
        }
        Object obj = this.characteristics;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.Camera2CameraMetadata.unwrapAs");
        return (T) obj;
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<CameraCharacteristics.Key<?>> getKeys() {
        return this._keys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<CaptureRequest.Key<?>> getRequestKeys() {
        return this._requestKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<CaptureResult.Key<?>> getResultKeys() {
        return this._resultKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<CaptureRequest.Key<?>> getSessionKeys() {
        return this._sessionKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<CameraCharacteristics.Key<?>> getSessionCharacteristicsKeys() {
        return this._sessionCharacteristicsKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<CameraId> getPhysicalCameraIds() {
        return this._physicalCameraIds.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<CaptureRequest.Key<?>> getPhysicalRequestKeys() {
        return this._physicalRequestKeys.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Set<Integer> getSupportedExtensions() {
        return this._supportedExtensions.getValue();
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    /* JADX INFO: renamed from: getPhysicalMetadata-0r8Bogc */
    public Object mo446getPhysicalMetadata0r8Bogc(String str, Continuation<? super CameraMetadata> continuation) {
        if (!getPhysicalCameraIds().contains(CameraId.m426boximpl(str))) {
            throw new IllegalStateException((((Object) CameraId.m432toStringimpl(str)) + " is not a valid physical camera on " + this).toString());
        }
        return this.metadataProvider.mo848getCameraMetadata0r8Bogc(str, continuation);
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    /* JADX INFO: renamed from: awaitPhysicalMetadata-EfqyGwQ */
    public CameraMetadata mo444awaitPhysicalMetadataEfqyGwQ(String cameraId) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        if (!getPhysicalCameraIds().contains(CameraId.m426boximpl(cameraId))) {
            throw new IllegalStateException((((Object) CameraId.m432toStringimpl(cameraId)) + " is not a valid physical camera on " + this).toString());
        }
        return this.metadataProvider.mo846awaitCameraMetadataEfqyGwQ(cameraId);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public Object getExtensionMetadata(int i, Continuation<? super CameraExtensionMetadata> continuation) {
        AnonymousClass1 anonymousClass1;
        CameraExtensionMetadata cameraExtensionMetadata;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objMo847getCameraExtensionMetadataRzXb1QE = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo847getCameraExtensionMetadataRzXb1QE);
            synchronized (this.extensionCache) {
                cameraExtensionMetadata = this.extensionCache.get(Boxing.boxInt(i));
            }
            if (cameraExtensionMetadata != null) {
                return cameraExtensionMetadata;
            }
            Camera2MetadataProvider camera2MetadataProvider = this.metadataProvider;
            String camera = getCamera();
            anonymousClass1.I$0 = i;
            anonymousClass1.label = 1;
            objMo847getCameraExtensionMetadataRzXb1QE = camera2MetadataProvider.mo847getCameraExtensionMetadataRzXb1QE(camera, i, anonymousClass1);
            if (objMo847getCameraExtensionMetadataRzXb1QE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$0;
            ResultKt.throwOnFailure(objMo847getCameraExtensionMetadataRzXb1QE);
        }
        CameraExtensionMetadata cameraExtensionMetadata2 = (CameraExtensionMetadata) objMo847getCameraExtensionMetadataRzXb1QE;
        synchronized (this.extensionCache) {
            this.extensionCache.put(Boxing.boxInt(i), cameraExtensionMetadata2);
            Unit unit = Unit.INSTANCE;
        }
        return cameraExtensionMetadata2;
    }

    @Override // androidx.camera.camera2.pipe.CameraMetadata
    public CameraExtensionMetadata awaitExtensionMetadata(int extension) {
        CameraExtensionMetadata cameraExtensionMetadata;
        synchronized (this.extensionCache) {
            cameraExtensionMetadata = this.extensionCache.get(Integer.valueOf(extension));
        }
        if (cameraExtensionMetadata != null) {
            return cameraExtensionMetadata;
        }
        CameraExtensionMetadata cameraExtensionMetadataMo845awaitCameraExtensionMetadata0r8Bogc = this.metadataProvider.mo845awaitCameraExtensionMetadata0r8Bogc(getCamera(), extension);
        synchronized (this.extensionCache) {
            this.extensionCache.put(Integer.valueOf(extension), cameraExtensionMetadataMo845awaitCameraExtensionMetadata0r8Bogc);
            Unit unit = Unit.INSTANCE;
        }
        return cameraExtensionMetadataMo845awaitCameraExtensionMetadata0r8Bogc;
    }

    static final Set _supportedExtensions$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection("Camera-" + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())) + "#supportedExtensions");
                return camera2CameraMetadata.metadataProvider.mo849getSupportedCameraExtensionsEfqyGwQ(camera2CameraMetadata.getCamera());
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getSupportedExtensions from Camera-" + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())), assertionError);
            }
            return SetsKt.emptySet();
        }
    }

    static final Set _keys$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection(((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())) + "#keys");
                List<CameraCharacteristics.Key<?>> keys = camera2CameraMetadata.characteristics.getKeys();
                if (keys == null) {
                    keys = CollectionsKt.emptyList();
                }
                return CollectionsKt.toSet(keys);
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getKeys from " + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())) + AbstractJsonLexerKt.END_OBJ, assertionError);
            }
            return SetsKt.emptySet();
        }
    }

    static final Set _requestKeys$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection(((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())) + "#availableCaptureRequestKeys");
                List<CaptureRequest.Key<?>> availableCaptureRequestKeys = camera2CameraMetadata.characteristics.getAvailableCaptureRequestKeys();
                if (availableCaptureRequestKeys == null) {
                    availableCaptureRequestKeys = CollectionsKt.emptyList();
                }
                return CollectionsKt.toSet(availableCaptureRequestKeys);
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getAvailableCaptureRequestKeys from " + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())), assertionError);
            }
            return SetsKt.emptySet();
        }
    }

    static final Set _resultKeys$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection(((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())) + "#availableCaptureResultKeys");
                List<CaptureResult.Key<?>> availableCaptureResultKeys = camera2CameraMetadata.characteristics.getAvailableCaptureResultKeys();
                if (availableCaptureResultKeys == null) {
                    availableCaptureResultKeys = CollectionsKt.emptyList();
                }
                return CollectionsKt.toSet(availableCaptureResultKeys);
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getAvailableCaptureResultKeys from " + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())), assertionError);
            }
            return SetsKt.emptySet();
        }
    }

    static final Set _physicalCameraIds$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        if (Build.VERSION.SDK_INT < 28) {
            return SetsKt.emptySet();
        }
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection(((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())) + "#physicalCameraIds");
                Set<String> physicalCameraIds = Api28Compat.getPhysicalCameraIds(camera2CameraMetadata.characteristics);
                if (Log.INSTANCE.getINFO_LOGGABLE()) {
                    android.util.Log.i(Log.TAG, "Loaded physicalCameraIds from " + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())) + ": " + physicalCameraIds);
                }
                if (physicalCameraIds == null) {
                    physicalCameraIds = SetsKt.emptySet();
                }
                Set<String> set = physicalCameraIds;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    arrayList.add(CameraId.m426boximpl(CameraId.m427constructorimpl((String) it.next())));
                }
                return CollectionsKt.toSet(arrayList);
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getPhysicalCameraIds from " + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())), assertionError);
            }
            return SetsKt.emptySet();
        } catch (NullPointerException e2) {
            NullPointerException nullPointerException = e2;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getPhysicalCameraIds from " + ((Object) CameraId.m432toStringimpl(camera2CameraMetadata.getCamera())), nullPointerException);
            }
            return SetsKt.emptySet();
        }
    }

    static final Set _physicalRequestKeys$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        if (Build.VERSION.SDK_INT < 28) {
            return SetsKt.emptySet();
        }
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection("Camera-" + camera2CameraMetadata.getCamera() + "#availablePhysicalCameraRequestKeys");
                List<CaptureRequest.Key<?>> availablePhysicalCameraRequestKeys = Api28Compat.getAvailablePhysicalCameraRequestKeys(camera2CameraMetadata.characteristics);
                if (availablePhysicalCameraRequestKeys == null) {
                    availablePhysicalCameraRequestKeys = CollectionsKt.emptyList();
                }
                return CollectionsKt.toSet(availablePhysicalCameraRequestKeys);
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getAvailablePhysicalCameraRequestKeys from Camera-" + camera2CameraMetadata.getCamera(), assertionError);
            }
            return SetsKt.emptySet();
        }
    }

    static final Set _sessionCharacteristicsKeys$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        if (Build.VERSION.SDK_INT < 35) {
            return SetsKt.emptySet();
        }
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection("Camera-" + camera2CameraMetadata.getCamera() + "#getAvailableSessionCharacteristicsKeys");
                List<CameraCharacteristics.Key<?>> availableSessionCharacteristicsKeys = Api35Compat.getAvailableSessionCharacteristicsKeys(camera2CameraMetadata.characteristics);
                if (availableSessionCharacteristicsKeys == null) {
                    availableSessionCharacteristicsKeys = CollectionsKt.emptyList();
                }
                return CollectionsKt.toSet(availableSessionCharacteristicsKeys);
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getAvailableSessionCharacteristicsKeys from Camera-" + camera2CameraMetadata.getCamera(), assertionError);
            }
            return SetsKt.emptySet();
        }
    }

    static final Set _sessionKeys$lambda$0(Camera2CameraMetadata camera2CameraMetadata) {
        if (Build.VERSION.SDK_INT < 28) {
            return SetsKt.emptySet();
        }
        try {
            Debug debug = Debug.INSTANCE;
            try {
                Trace.beginSection("Camera-" + camera2CameraMetadata.getCamera() + "#availableSessionKeys");
                List<CaptureRequest.Key<?>> availableSessionKeys = Api28Compat.getAvailableSessionKeys(camera2CameraMetadata.characteristics);
                if (availableSessionKeys == null) {
                    availableSessionKeys = CollectionsKt.emptyList();
                }
                return CollectionsKt.toSet(availableSessionKeys);
            } finally {
                Trace.endSection();
            }
        } catch (AssertionError e) {
            AssertionError assertionError = e;
            if (Log.INSTANCE.getWARN_LOGGABLE()) {
                android.util.Log.w(Log.TAG, "Failed to getAvailableSessionKeys from Camera-" + camera2CameraMetadata.getCamera(), assertionError);
            }
            return SetsKt.emptySet();
        }
    }

    private final <T> T getOrThrow(CameraCharacteristics cameraCharacteristics, CameraCharacteristics.Key<T> key) {
        try {
            return (T) cameraCharacteristics.get(key);
        } catch (AssertionError unused) {
            throw new IllegalStateException("Failed to get characteristic for " + key + ": Framework throw an AssertionError");
        }
    }
}
