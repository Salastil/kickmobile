package androidx.camera.camera2.adapter;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.TagsKt;
import androidx.camera.camera2.pipe.FrameInfo;
import androidx.camera.camera2.pipe.RequestMetadata;
import androidx.camera.camera2.pipe.UnsafeWrapper;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CaptureResultAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J'\u0010&\u001a\u0004\u0018\u0001H'\"\b\b\u0000\u0010'*\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H'0*H\u0016¢\u0006\u0002\u0010+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006,"}, d2 = {"Landroidx/camera/camera2/adapter/CaptureResultAdapter;", "Landroidx/camera/core/impl/CameraCaptureResult;", "Landroidx/camera/camera2/pipe/UnsafeWrapper;", "requestMetadata", "Landroidx/camera/camera2/pipe/RequestMetadata;", "frameNumber", "Landroidx/camera/camera2/pipe/FrameNumber;", "result", "Landroidx/camera/camera2/pipe/FrameInfo;", "<init>", "(Landroidx/camera/camera2/pipe/RequestMetadata;JLandroidx/camera/camera2/pipe/FrameInfo;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getResult$camera_camera2", "()Landroidx/camera/camera2/pipe/FrameInfo;", "getAfMode", "Landroidx/camera/core/impl/CameraCaptureMetaData$AfMode;", "getAfState", "Landroidx/camera/core/impl/CameraCaptureMetaData$AfState;", "getAeMode", "Landroidx/camera/core/impl/CameraCaptureMetaData$AeMode;", "getAeState", "Landroidx/camera/core/impl/CameraCaptureMetaData$AeState;", "getAwbMode", "Landroidx/camera/core/impl/CameraCaptureMetaData$AwbMode;", "getAwbState", "Landroidx/camera/core/impl/CameraCaptureMetaData$AwbState;", "getFlashState", "Landroidx/camera/core/impl/CameraCaptureMetaData$FlashState;", "getTimestamp", "", "getTagBundle", "Landroidx/camera/core/impl/TagBundle;", "populateExifData", "", "exifBuilder", "Landroidx/camera/core/impl/utils/ExifData$Builder;", "getCaptureResult", "Landroid/hardware/camera2/CaptureResult;", "unwrapAs", ExifInterface.GPS_DIRECTION_TRUE, "", "type", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureResultAdapter implements CameraCaptureResult, UnsafeWrapper {
    private final long frameNumber;
    private final RequestMetadata requestMetadata;
    private final FrameInfo result;

    public /* synthetic */ CaptureResultAdapter(RequestMetadata requestMetadata, long j, FrameInfo frameInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(requestMetadata, j, frameInfo);
    }

    private CaptureResultAdapter(RequestMetadata requestMetadata, long j, FrameInfo result) {
        Intrinsics.checkNotNullParameter(requestMetadata, "requestMetadata");
        Intrinsics.checkNotNullParameter(result, "result");
        this.requestMetadata = requestMetadata;
        this.frameNumber = j;
        this.result = result;
    }

    /* JADX INFO: renamed from: getResult$camera_camera2, reason: from getter */
    public final FrameInfo getResult() {
        return this.result;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfMode getAfMode() {
        return CaptureResultAdapterKt.getAfMode(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfState getAfState() {
        return CaptureResultAdapterKt.getAfState(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeMode getAeMode() {
        return CaptureResultAdapterKt.getAeMode(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeState getAeState() {
        return CaptureResultAdapterKt.getAeState(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbMode getAwbMode() {
        return CaptureResultAdapterKt.getAwbMode(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbState getAwbState() {
        return CaptureResultAdapterKt.getAwbState(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.FlashState getFlashState() {
        return CaptureResultAdapterKt.getFlashState(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        return CaptureResultAdapterKt.getTimestamp(this.result.getMetadata());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public TagBundle getTagBundle() {
        return (TagBundle) this.requestMetadata.getOrDefault(TagsKt.getCAMERAX_TAG_BUNDLE(), TagBundle.emptyBundle());
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public void populateExifData(ExifData.Builder exifBuilder) {
        Intrinsics.checkNotNullParameter(exifBuilder, "exifBuilder");
        super.populateExifData(exifBuilder);
        CaptureResultAdapterKt.populateExifData(this.result.getMetadata(), exifBuilder);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CaptureResult getCaptureResult() {
        Object objUnwrapAs = unwrapAs(Reflection.getOrCreateKotlinClass(TotalCaptureResult.class));
        if (objUnwrapAs != null) {
            return (CaptureResult) objUnwrapAs;
        }
        throw new IllegalStateException(("Failed to unwrap " + this + " as TotalCaptureResult").toString());
    }

    @Override // androidx.camera.camera2.pipe.UnsafeWrapper
    public <T> T unwrapAs(KClass<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        boolean zAreEqual = Intrinsics.areEqual(type, Reflection.getOrCreateKotlinClass(FrameInfo.class));
        FrameInfo frameInfo = this.result;
        if (zAreEqual) {
            Intrinsics.checkNotNull(frameInfo, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CaptureResultAdapter.unwrapAs");
            return (T) frameInfo;
        }
        return (T) frameInfo.unwrapAs(type);
    }
}
