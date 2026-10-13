package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MimeMatchedVideoCapabilities.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Landroidx/camera/video/MimeMatchedVideoCapabilities;", "Landroidx/camera/video/VideoCapabilities;", "mime", "", "cameraInfo", "Landroidx/camera/core/impl/CameraInfoInternal;", "videoEncoderInfoFinder", "Landroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;", "<init>", "(Ljava/lang/String;Landroidx/camera/core/impl/CameraInfoInternal;Landroidx/camera/video/internal/encoder/VideoEncoderInfo$Finder;)V", "validatedData", "Landroidx/camera/video/MimeMatchedVideoCapabilities$ValidatedData;", "getValidatedData", "()Landroidx/camera/video/MimeMatchedVideoCapabilities$ValidatedData;", "validatedData$delegate", "Lkotlin/Lazy;", "getSupportedDynamicRanges", "", "Landroidx/camera/core/DynamicRange;", "getSupportedQualities", "", "Landroidx/camera/video/Quality;", "dynamicRange", "isQualitySupported", "", "quality", "getResolution", "Landroid/util/Size;", "isStabilizationSupported", "toString", "ValidatedData", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MimeMatchedVideoCapabilities implements VideoCapabilities {
    private final CameraInfoInternal cameraInfo;
    private final String mime;

    /* JADX INFO: renamed from: validatedData$delegate, reason: from kotlin metadata */
    private final Lazy validatedData;

    public MimeMatchedVideoCapabilities(String mime, CameraInfoInternal cameraInfo, final VideoEncoderInfo.Finder videoEncoderInfoFinder) {
        Intrinsics.checkNotNullParameter(mime, "mime");
        Intrinsics.checkNotNullParameter(cameraInfo, "cameraInfo");
        Intrinsics.checkNotNullParameter(videoEncoderInfoFinder, "videoEncoderInfoFinder");
        this.mime = mime;
        this.cameraInfo = cameraInfo;
        this.validatedData = LazyKt.lazy(new Function0() { // from class: androidx.camera.video.MimeMatchedVideoCapabilities$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MimeMatchedVideoCapabilities.validatedData_delegate$lambda$0(videoEncoderInfoFinder, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: MimeMatchedVideoCapabilities.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/camera/video/MimeMatchedVideoCapabilities$ValidatedData;", "", "dynamicRanges", "", "Landroidx/camera/core/DynamicRange;", "qualityToSizeMap", "", "Landroidx/camera/video/Quality;", "Landroid/util/Size;", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "getDynamicRanges", "()Ljava/util/Set;", "getQualityToSizeMap", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class ValidatedData {
        private final Set<DynamicRange> dynamicRanges;
        private final Map<Quality, Size> qualityToSizeMap;

        /* JADX WARN: Multi-variable type inference failed */
        public ValidatedData() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ValidatedData copy$default(ValidatedData validatedData, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                set = validatedData.dynamicRanges;
            }
            if ((i & 2) != 0) {
                map = validatedData.qualityToSizeMap;
            }
            return validatedData.copy(set, map);
        }

        public final Set<DynamicRange> component1() {
            return this.dynamicRanges;
        }

        public final Map<Quality, Size> component2() {
            return this.qualityToSizeMap;
        }

        public final ValidatedData copy(Set<DynamicRange> dynamicRanges, Map<Quality, Size> qualityToSizeMap) {
            Intrinsics.checkNotNullParameter(dynamicRanges, "dynamicRanges");
            Intrinsics.checkNotNullParameter(qualityToSizeMap, "qualityToSizeMap");
            return new ValidatedData(dynamicRanges, qualityToSizeMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ValidatedData)) {
                return false;
            }
            ValidatedData validatedData = (ValidatedData) other;
            return Intrinsics.areEqual(this.dynamicRanges, validatedData.dynamicRanges) && Intrinsics.areEqual(this.qualityToSizeMap, validatedData.qualityToSizeMap);
        }

        public int hashCode() {
            return (this.dynamicRanges.hashCode() * 31) + this.qualityToSizeMap.hashCode();
        }

        public String toString() {
            return "ValidatedData(dynamicRanges=" + this.dynamicRanges + ", qualityToSizeMap=" + this.qualityToSizeMap + ')';
        }

        public ValidatedData(Set<DynamicRange> dynamicRanges, Map<Quality, Size> qualityToSizeMap) {
            Intrinsics.checkNotNullParameter(dynamicRanges, "dynamicRanges");
            Intrinsics.checkNotNullParameter(qualityToSizeMap, "qualityToSizeMap");
            this.dynamicRanges = dynamicRanges;
            this.qualityToSizeMap = qualityToSizeMap;
        }

        public /* synthetic */ ValidatedData(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Set<DynamicRange> getDynamicRanges() {
            return this.dynamicRanges;
        }

        public final Map<Quality, Size> getQualityToSizeMap() {
            return this.qualityToSizeMap;
        }
    }

    private final ValidatedData getValidatedData() {
        return (ValidatedData) this.validatedData.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static final ValidatedData validatedData_delegate$lambda$0(VideoEncoderInfo.Finder finder, MimeMatchedVideoCapabilities mimeMatchedVideoCapabilities) {
        Object next;
        VideoEncoderInfo videoEncoderInfoFind = finder.find(mimeMatchedVideoCapabilities.mime);
        int i = 3;
        Set set = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        if (videoEncoderInfoFind == null) {
            return new ValidatedData(set, objArr11 == true ? 1 : 0, i, objArr10 == true ? 1 : 0);
        }
        Set<DynamicRange> supportedDynamicRanges = mimeMatchedVideoCapabilities.cameraInfo.getSupportedDynamicRanges();
        Intrinsics.checkNotNullExpressionValue(supportedDynamicRanges, "getSupportedDynamicRanges(...)");
        if (supportedDynamicRanges.isEmpty()) {
            return new ValidatedData(objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        Set setIntersect = CollectionsKt.intersect(supportedDynamicRanges, VideoConfigUtil.INSTANCE.getDynamicRangesForMime(mimeMatchedVideoCapabilities.mime));
        if (setIntersect.isEmpty()) {
            return new ValidatedData(objArr6 == true ? 1 : 0, objArr5 == true ? 1 : 0, i, objArr4 == true ? 1 : 0);
        }
        List<Size> supportedResolutions = mimeMatchedVideoCapabilities.cameraInfo.getSupportedResolutions(34);
        Intrinsics.checkNotNullExpressionValue(supportedResolutions, "getSupportedResolutions(...)");
        HashSet hashSet = CollectionsKt.toHashSet(supportedResolutions);
        List<Quality> sortedQualities = Quality.getSortedQualities();
        Intrinsics.checkNotNullExpressionValue(sortedQualities, "getSortedQualities(...)");
        ArrayList<Quality.ConstantQuality> arrayList = new ArrayList();
        for (Object obj : sortedQualities) {
            if (obj instanceof Quality.ConstantQuality) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Quality.ConstantQuality constantQuality : arrayList) {
            List<Size> typicalSizes = constantQuality.getTypicalSizes();
            Intrinsics.checkNotNullExpressionValue(typicalSizes, "getTypicalSizes(...)");
            Iterator<T> it = typicalSizes.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Size size = (Size) next;
                if (hashSet.contains(size) && videoEncoderInfoFind.isSizeSupported(size.getWidth(), size.getHeight())) {
                    break;
                }
            }
            Size size2 = (Size) next;
            Pair pair = size2 != null ? TuplesKt.to(constantQuality, size2) : null;
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        Map map = MapsKt.toMap(arrayList2);
        if (map.isEmpty()) {
            return new ValidatedData(objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        return new ValidatedData(setIntersect, map);
    }

    @Override // androidx.camera.video.VideoCapabilities
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return getValidatedData().getDynamicRanges();
    }

    @Override // androidx.camera.video.VideoCapabilities
    public List<Quality> getSupportedQualities(DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        if (DynamicRanges.canResolve(dynamicRange, getValidatedData().getDynamicRanges())) {
            return CollectionsKt.toList(getValidatedData().getQualityToSizeMap().keySet());
        }
        return CollectionsKt.emptyList();
    }

    @Override // androidx.camera.video.VideoCapabilities
    public boolean isQualitySupported(Quality quality, DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        return DynamicRanges.canResolve(dynamicRange, getValidatedData().getDynamicRanges()) && getValidatedData().getQualityToSizeMap().containsKey(quality);
    }

    @Override // androidx.camera.video.VideoCapabilities
    public Size getResolution(Quality quality, DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        if (DynamicRanges.canResolve(dynamicRange, getValidatedData().getDynamicRanges())) {
            return getValidatedData().getQualityToSizeMap().get(quality);
        }
        return null;
    }

    @Override // androidx.camera.video.VideoCapabilities
    public boolean isStabilizationSupported() {
        return this.cameraInfo.isVideoStabilizationSupported();
    }

    public String toString() {
        return "MimeMatchedVideoCapabilities(mime=" + this.mime + ", cameraInfo=" + this.cameraInfo + ')';
    }
}
