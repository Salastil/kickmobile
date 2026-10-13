package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import androidx.camera.camera2.compat.StreamConfigurationMapCompat;
import androidx.camera.camera2.compat.workaround.OutputSizesCorrector;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.exifinterface.media.ExifInterface;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HighSpeedResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J8\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u0002H\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00160\u001b\"\u0004\b\u0000\u0010\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u0002H\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00160\u001bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fJ&\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00160\u00162\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00160\u0016J'\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0%\u0018\u00010$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0016¢\u0006\u0002\u0010'J$\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0016\"\u0004\b\u0000\u0010\u001c*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u00160\u0016H\u0002J\u001c\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0%0\u00162\u0006\u0010 \u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Landroidx/camera/camera2/internal/HighSpeedResolver;", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;)V", "isHighSpeedSupported", "", "()Z", "isHighSpeedSupported$delegate", "Lkotlin/Lazy;", "maxSize", "Landroid/util/Size;", "getMaxSize", "()Landroid/util/Size;", "maxSize$delegate", "streamConfigurationMapCompat", "Landroidx/camera/camera2/compat/StreamConfigurationMapCompat;", "getStreamConfigurationMapCompat", "()Landroidx/camera/camera2/compat/StreamConfigurationMapCompat;", "streamConfigurationMapCompat$delegate", "supportedSizes", "", "getSupportedSizes", "()Ljava/util/List;", "supportedSizes$delegate", "filterCommonSupportedSizes", "", ExifInterface.GPS_DIRECTION_TRUE, "sizesMap", "getMaxFrameRate", "", ContentDisposition.Parameters.Size, "getSizeArrangements", "sizesList", "getFrameRateRangesFor", "", "Landroid/util/Range;", "surfaceSizes", "(Ljava/util/List;)[Landroid/util/Range;", "findCommonElements", "getHighSpeedVideoFpsRangesFor", "Companion", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HighSpeedResolver {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Range<Integer> DEFAULT_FPS;
    private static final String TAG = "HighSpeedResolver";
    private final CameraMetadata cameraMetadata;

    /* JADX INFO: renamed from: isHighSpeedSupported$delegate, reason: from kotlin metadata */
    private final Lazy isHighSpeedSupported;

    /* JADX INFO: renamed from: maxSize$delegate, reason: from kotlin metadata */
    private final Lazy maxSize;

    /* JADX INFO: renamed from: streamConfigurationMapCompat$delegate, reason: from kotlin metadata */
    private final Lazy streamConfigurationMapCompat;

    /* JADX INFO: renamed from: supportedSizes$delegate, reason: from kotlin metadata */
    private final Lazy supportedSizes;

    @JvmStatic
    public static final boolean isHighSpeedOn(Collection<? extends AttachedSurfaceInfo> collection, Collection<? extends UseCaseConfig<?>> collection2) {
        return INSTANCE.isHighSpeedOn(collection, collection2);
    }

    public HighSpeedResolver(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        this.cameraMetadata = cameraMetadata;
        this.isHighSpeedSupported = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.internal.HighSpeedResolver$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(HighSpeedResolver.isHighSpeedSupported_delegate$lambda$0(this.f$0));
            }
        });
        this.maxSize = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.internal.HighSpeedResolver$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HighSpeedResolver.maxSize_delegate$lambda$0(this.f$0);
            }
        });
        this.streamConfigurationMapCompat = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.internal.HighSpeedResolver$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HighSpeedResolver.streamConfigurationMapCompat_delegate$lambda$0(this.f$0);
            }
        });
        this.supportedSizes = LazyKt.lazy(new Function0() { // from class: androidx.camera.camera2.internal.HighSpeedResolver$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HighSpeedResolver.supportedSizes_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final boolean isHighSpeedSupported() {
        return ((Boolean) this.isHighSpeedSupported.getValue()).booleanValue();
    }

    static final boolean isHighSpeedSupported_delegate$lambda$0(HighSpeedResolver highSpeedResolver) {
        CameraMetadata cameraMetadata = highSpeedResolver.cameraMetadata;
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) cameraMetadata.get(REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i : iArr) {
                if (i == 9) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Size getMaxSize() {
        return (Size) this.maxSize.getValue();
    }

    static final Size maxSize_delegate$lambda$0(HighSpeedResolver highSpeedResolver) {
        List<Size> supportedSizes = highSpeedResolver.getSupportedSizes();
        if (supportedSizes.isEmpty()) {
            supportedSizes = null;
        }
        if (supportedSizes == null) {
            return null;
        }
        Iterator<T> it = supportedSizes.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            int area = SizeUtil.getArea((Size) next);
            do {
                Object next2 = it.next();
                int area2 = SizeUtil.getArea((Size) next2);
                if (area < area2) {
                    next = next2;
                    area = area2;
                }
            } while (it.hasNext());
        }
        return (Size) next;
    }

    private final StreamConfigurationMapCompat getStreamConfigurationMapCompat() {
        return (StreamConfigurationMapCompat) this.streamConfigurationMapCompat.getValue();
    }

    static final StreamConfigurationMapCompat streamConfigurationMapCompat_delegate$lambda$0(HighSpeedResolver highSpeedResolver) {
        CameraMetadata cameraMetadata = highSpeedResolver.cameraMetadata;
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        Intrinsics.checkNotNullExpressionValue(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraMetadata.get(SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new IllegalArgumentException("Cannot retrieve SCALER_STREAM_CONFIGURATION_MAP");
        }
        return new StreamConfigurationMapCompat(streamConfigurationMap, new OutputSizesCorrector(highSpeedResolver.cameraMetadata, streamConfigurationMap));
    }

    private final List<Size> getSupportedSizes() {
        return (List) this.supportedSizes.getValue();
    }

    static final List supportedSizes_delegate$lambda$0(HighSpeedResolver highSpeedResolver) {
        List list;
        Size[] highSpeedVideoSizes = highSpeedResolver.getStreamConfigurationMapCompat().getHighSpeedVideoSizes();
        return (highSpeedVideoSizes == null || (list = ArraysKt.toList(highSpeedVideoSizes)) == null) ? CollectionsKt.emptyList() : list;
    }

    public final <T> Map<T, List<Size>> filterCommonSupportedSizes(Map<T, ? extends List<Size>> sizesMap) {
        Intrinsics.checkNotNullParameter(sizesMap, "sizesMap");
        List<T> listFindCommonElements = findCommonElements(CollectionsKt.toList(sizesMap.values()));
        ArrayList arrayList = new ArrayList();
        for (T t : listFindCommonElements) {
            if (getSupportedSizes().contains((Size) t)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(sizesMap.size()));
        Iterator<T> it = sizesMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            List list = (List) entry.getValue();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : list) {
                if (arrayList2.contains((Size) obj)) {
                    arrayList3.add(obj);
                }
            }
            linkedHashMap.put(key, arrayList3);
        }
        return linkedHashMap;
    }

    public final int getMaxFrameRate(Size size) {
        Intrinsics.checkNotNullParameter(size, "size");
        List<Range<Integer>> highSpeedVideoFpsRangesFor = getHighSpeedVideoFpsRangesFor(size);
        if (highSpeedVideoFpsRangesFor.isEmpty()) {
            highSpeedVideoFpsRangesFor = null;
        }
        if (highSpeedVideoFpsRangesFor == null) {
            Logger.w(TAG, "No supported high speed  fps for " + size);
            return 0;
        }
        Iterator<T> it = highSpeedVideoFpsRangesFor.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Integer num = (Integer) ((Range) it.next()).getUpper();
        while (it.hasNext()) {
            Integer num2 = (Integer) ((Range) it.next()).getUpper();
            if (num.compareTo(num2) < 0) {
                num = num2;
            }
        }
        Intrinsics.checkNotNullExpressionValue(num, "maxOf(...)");
        return num.intValue();
    }

    public final List<List<Size>> getSizeArrangements(List<? extends List<Size>> sizesList) {
        Intrinsics.checkNotNullParameter(sizesList, "sizesList");
        if (sizesList.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<Size> listFindCommonElements = findCommonElements(sizesList);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listFindCommonElements, 10));
        for (Size size : listFindCommonElements) {
            int size2 = sizesList.size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i = 0; i < size2; i++) {
                arrayList2.add(size);
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public final Range<Integer>[] getFrameRateRangesFor(List<Size> surfaceSizes) {
        Intrinsics.checkNotNullParameter(surfaceSizes, "surfaceSizes");
        int size = surfaceSizes.size();
        if (1 > size || size >= 3 || CollectionsKt.distinct(surfaceSizes).size() != 1) {
            return null;
        }
        ArrayList highSpeedVideoFpsRangesFor = getHighSpeedVideoFpsRangesFor(surfaceSizes.get(0));
        if (highSpeedVideoFpsRangesFor.isEmpty()) {
            highSpeedVideoFpsRangesFor = null;
        }
        if (highSpeedVideoFpsRangesFor == null) {
            return null;
        }
        if (surfaceSizes.size() == 2) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : highSpeedVideoFpsRangesFor) {
                Range range = (Range) obj;
                if (Intrinsics.areEqual(range.getLower(), range.getUpper())) {
                    arrayList.add(obj);
                }
            }
            highSpeedVideoFpsRangesFor = arrayList;
        }
        return (Range[]) highSpeedVideoFpsRangesFor.toArray(new Range[0]);
    }

    private final <T> List<T> findCommonElements(List<? extends List<? extends T>> list) {
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<T> mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.first((List) list));
        Iterator<T> it = CollectionsKt.drop(list, 1).iterator();
        while (it.hasNext()) {
            mutableList.retainAll((List) it.next());
        }
        return mutableList;
    }

    private final List<Range<Integer>> getHighSpeedVideoFpsRangesFor(Size size) {
        Object objM12684constructorimpl;
        List listFilterNotNull;
        List<Range<Integer>> list;
        try {
            Result.Companion companion = Result.INSTANCE;
            HighSpeedResolver highSpeedResolver = this;
            objM12684constructorimpl = Result.m12684constructorimpl(getStreamConfigurationMapCompat().getHighSpeedVideoFpsRangesFor(size));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM12684constructorimpl = Result.m12684constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m12690isFailureimpl(objM12684constructorimpl)) {
            objM12684constructorimpl = null;
        }
        Range[] rangeArr = (Range[]) objM12684constructorimpl;
        return (rangeArr == null || (listFilterNotNull = ArraysKt.filterNotNull(rangeArr)) == null || (list = CollectionsKt.toList(listFilterNotNull)) == null) ? CollectionsKt.emptyList() : list;
    }

    /* JADX INFO: compiled from: HighSpeedResolver.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/internal/HighSpeedResolver$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_FPS", "Landroid/util/Range;", "", "getDEFAULT_FPS", "()Landroid/util/Range;", "isHighSpeedOn", "", "attachedSurfaces", "", "Landroidx/camera/core/impl/AttachedSurfaceInfo;", "newUseCaseConfigs", "Landroidx/camera/core/impl/UseCaseConfig;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Range<Integer> getDEFAULT_FPS() {
            return HighSpeedResolver.DEFAULT_FPS;
        }

        @JvmStatic
        public final boolean isHighSpeedOn(Collection<? extends AttachedSurfaceInfo> attachedSurfaces, Collection<? extends UseCaseConfig<?>> newUseCaseConfigs) {
            boolean z;
            Intrinsics.checkNotNullParameter(attachedSurfaces, "attachedSurfaces");
            Intrinsics.checkNotNullParameter(newUseCaseConfigs, "newUseCaseConfigs");
            Collection<? extends AttachedSurfaceInfo> collection = attachedSurfaces;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(((AttachedSurfaceInfo) it.next()).getSessionType()));
            }
            ArrayList arrayList2 = arrayList;
            Collection<? extends UseCaseConfig<?>> collection2 = newUseCaseConfigs;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
            Iterator<T> it2 = collection2.iterator();
            while (true) {
                z = false;
                if (!it2.hasNext()) {
                    break;
                }
                arrayList3.add(Integer.valueOf(((UseCaseConfig) it2.next()).getSessionType(0)));
            }
            List listPlus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
            boolean z2 = listPlus instanceof Collection;
            if (!z2 || !listPlus.isEmpty()) {
                Iterator it3 = listPlus.iterator();
                while (it3.hasNext()) {
                    if (((Number) it3.next()).intValue() == 1) {
                        z = true;
                        break;
                    }
                }
            }
            if (!z || (z2 && listPlus.isEmpty())) {
                return z;
            }
            Iterator it4 = listPlus.iterator();
            while (it4.hasNext()) {
                if (((Number) it4.next()).intValue() != 1) {
                    throw new IllegalArgumentException("All sessionTypes should be high-speed when any of them is high-speed".toString());
                }
            }
            return z;
        }
    }

    static {
        Integer numValueOf = Integer.valueOf(TimeseriesConfiguration.DEFAULT_BUFFER_SIZE);
        DEFAULT_FPS = new Range<>(numValueOf, numValueOf);
    }
}
