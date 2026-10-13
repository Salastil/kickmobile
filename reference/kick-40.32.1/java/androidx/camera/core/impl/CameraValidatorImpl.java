package androidx.camera.core.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.camera.core.CameraIdentifier;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CameraValidator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0016J\u001e\u0010\u0016\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/camera/core/impl/CameraValidatorImpl;", "Landroidx/camera/core/impl/CameraValidator;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "availableCamerasSelector", "Landroidx/camera/core/CameraSelector;", "<init>", "(Landroid/content/Context;Landroidx/camera/core/CameraSelector;)V", "isVirtualDevice", "", "validationCriteria", "Landroidx/camera/core/impl/CameraValidatorImpl$ValidationCriteria;", "validateOnFirstInit", "", "cameraRepository", "Landroidx/camera/core/impl/CameraRepository;", "isChangeInvalid", "currentCameras", "", "Landroidx/camera/core/impl/CameraInternal;", "removedCameras", "Landroidx/camera/core/CameraIdentifier;", "hasCamera", "cameras", "selector", "getValidationCriteria", "ValidationCriteria", "Api34Impl", "Companion", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraValidatorImpl implements CameraValidator {
    private static final String TAG = "CameraValidator";
    private final CameraSelector availableCamerasSelector;
    private final Context context;
    private final boolean isVirtualDevice;
    private final ValidationCriteria validationCriteria;

    public CameraValidatorImpl(Context context, CameraSelector cameraSelector) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.availableCamerasSelector = cameraSelector;
        this.isVirtualDevice = isVirtualDevice(context);
        this.validationCriteria = getValidationCriteria();
    }

    @Override // androidx.camera.core.impl.CameraValidator
    public void validateOnFirstInit(CameraRepository cameraRepository) throws CameraValidator.CameraIdListIncorrectException {
        Intrinsics.checkNotNullParameter(cameraRepository, "cameraRepository");
        if (this.isVirtualDevice) {
            Logger.d(TAG, "Virtual device with " + cameraRepository.getCameras().size() + " cameras. Skipping validation.");
            return;
        }
        Logger.d(TAG, "Verifying camera lens facing on " + Build.DEVICE);
        if (this.validationCriteria.getCheckBack()) {
            try {
                Intrinsics.checkNotNull(CameraSelector.DEFAULT_BACK_CAMERA.select(cameraRepository.getCameras()));
            } catch (RuntimeException e) {
                e = e;
                Logger.w(TAG, "Camera LENS_FACING_BACK verification failed", e);
            }
        }
        e = null;
        if (this.validationCriteria.getCheckFront()) {
            try {
                Intrinsics.checkNotNull(CameraSelector.DEFAULT_FRONT_CAMERA.select(cameraRepository.getCameras()));
            } catch (RuntimeException e2) {
                Logger.w(TAG, "Camera LENS_FACING_FRONT verification failed", e2);
                if (e == null) {
                    e = e2;
                }
            }
        }
        if (e != null) {
            throw new CameraValidator.CameraIdListIncorrectException("Expected camera missing from device.", cameraRepository.getCameras().size(), e);
        }
    }

    @Override // androidx.camera.core.impl.CameraValidator
    public boolean isChangeInvalid(Set<? extends CameraInternal> currentCameras, Set<CameraIdentifier> removedCameras) {
        Intrinsics.checkNotNullParameter(currentCameras, "currentCameras");
        Intrinsics.checkNotNullParameter(removedCameras, "removedCameras");
        if (this.isVirtualDevice || !(this.validationCriteria.getCheckBack() || this.validationCriteria.getCheckFront())) {
            return false;
        }
        CameraSelector DEFAULT_BACK_CAMERA = CameraSelector.DEFAULT_BACK_CAMERA;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA, "DEFAULT_BACK_CAMERA");
        boolean zHasCamera = hasCamera(currentCameras, DEFAULT_BACK_CAMERA);
        CameraSelector DEFAULT_FRONT_CAMERA = CameraSelector.DEFAULT_FRONT_CAMERA;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_FRONT_CAMERA, "DEFAULT_FRONT_CAMERA");
        boolean zHasCamera2 = hasCamera(currentCameras, DEFAULT_FRONT_CAMERA);
        Set<CameraIdentifier> set = removedCameras;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((CameraIdentifier) it.next()).getInternalId());
        }
        Set set2 = CollectionsKt.toSet(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : currentCameras) {
            if (!set2.contains(((CameraInternal) obj).getCameraInfo().getCameraId())) {
                arrayList2.add(obj);
            }
        }
        Set<? extends CameraInternal> set3 = CollectionsKt.toSet(arrayList2);
        CameraSelector DEFAULT_BACK_CAMERA2 = CameraSelector.DEFAULT_BACK_CAMERA;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_BACK_CAMERA2, "DEFAULT_BACK_CAMERA");
        boolean zHasCamera3 = hasCamera(set3, DEFAULT_BACK_CAMERA2);
        CameraSelector DEFAULT_FRONT_CAMERA2 = CameraSelector.DEFAULT_FRONT_CAMERA;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_FRONT_CAMERA2, "DEFAULT_FRONT_CAMERA");
        return (this.validationCriteria.getCheckBack() && zHasCamera && !zHasCamera3) || (this.validationCriteria.getCheckFront() && zHasCamera2 && !hasCamera(set3, DEFAULT_FRONT_CAMERA2));
    }

    private final boolean hasCamera(Set<? extends CameraInternal> cameras, CameraSelector selector) {
        try {
            selector.select(new LinkedHashSet<>(cameras));
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    /* JADX INFO: compiled from: CameraValidator.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/camera/core/impl/CameraValidatorImpl$ValidationCriteria;", "", "checkBack", "", "checkFront", "<init>", "(ZZ)V", "getCheckBack", "()Z", "getCheckFront", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class ValidationCriteria {
        private final boolean checkBack;
        private final boolean checkFront;

        public static /* synthetic */ ValidationCriteria copy$default(ValidationCriteria validationCriteria, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = validationCriteria.checkBack;
            }
            if ((i & 2) != 0) {
                z2 = validationCriteria.checkFront;
            }
            return validationCriteria.copy(z, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getCheckBack() {
            return this.checkBack;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCheckFront() {
            return this.checkFront;
        }

        public final ValidationCriteria copy(boolean checkBack, boolean checkFront) {
            return new ValidationCriteria(checkBack, checkFront);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidationCriteria)) {
                return false;
            }
            ValidationCriteria validationCriteria = (ValidationCriteria) other;
            return this.checkBack == validationCriteria.checkBack && this.checkFront == validationCriteria.checkFront;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.checkBack) * 31) + Boolean.hashCode(this.checkFront);
        }

        public String toString() {
            return "ValidationCriteria(checkBack=" + this.checkBack + ", checkFront=" + this.checkFront + ')';
        }

        public ValidationCriteria(boolean z, boolean z2) {
            this.checkBack = z;
            this.checkFront = z2;
        }

        public final boolean getCheckBack() {
            return this.checkBack;
        }

        public final boolean getCheckFront() {
            return this.checkFront;
        }
    }

    private final ValidationCriteria getValidationCriteria() {
        PackageManager packageManager = this.context.getPackageManager();
        CameraSelector cameraSelector = this.availableCamerasSelector;
        Integer lensFacing = cameraSelector != null ? cameraSelector.getLensFacing() : null;
        boolean zHasSystemFeature = packageManager.hasSystemFeature("android.hardware.camera");
        boolean zHasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.camera.front");
        boolean z = false;
        boolean z2 = zHasSystemFeature && (lensFacing == null || lensFacing.intValue() == 1);
        if (zHasSystemFeature2 && (lensFacing == null || lensFacing.intValue() == 0)) {
            z = true;
        }
        return new ValidationCriteria(z2, z);
    }

    private final boolean isVirtualDevice(Context context) {
        return Build.VERSION.SDK_INT >= 34 && Api34Impl.INSTANCE.getDeviceId(context) != 0;
    }

    /* JADX INFO: compiled from: CameraValidator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/core/impl/CameraValidatorImpl$Api34Impl;", "", "<init>", "()V", "getDeviceId", "", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api34Impl {
        public static final Api34Impl INSTANCE = new Api34Impl();

        private Api34Impl() {
        }

        public final int getDeviceId(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getDeviceId();
        }
    }
}
