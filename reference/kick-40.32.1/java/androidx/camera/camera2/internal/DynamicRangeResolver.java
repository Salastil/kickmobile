package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.compat.DynamicRangeProfilesCompat;
import androidx.camera.camera2.impl.Camera2Logger;
import androidx.camera.camera2.pipe.CameraMetadata;
import androidx.camera.camera2.pipe.core.Log;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: compiled from: DynamicRangeResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\tJD\u0010\r\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012JN\u0010\u0017\u001a\u00020\u00102\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eH\u0002JD\u0010\u001f\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\"\u001a\u00020#H\u0002J&\u0010$\u001a\u00020%2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u001e2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J.\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\u00102\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0002J\u0010\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0010\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u0010H\u0002J&\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0002J\u0018\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Landroidx/camera/camera2/internal/DynamicRangeResolver;", "", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "<init>", "(Landroidx/camera/camera2/pipe/CameraMetadata;)V", "getCameraMetadata", "()Landroidx/camera/camera2/pipe/CameraMetadata;", "is10BitSupported", "", "dynamicRangesInfo", "Landroidx/camera/camera2/compat/DynamicRangeProfilesCompat;", "is10BitDynamicRangeSupported", "resolveAndValidateDynamicRanges", "", "Landroidx/camera/core/impl/UseCaseConfig;", "Landroidx/camera/core/DynamicRange;", "existingSurfaces", "", "Landroidx/camera/core/impl/AttachedSurfaceInfo;", "newUseCaseConfigs", "useCasePriorityOrder", "", "resolveDynamicRangeAndUpdateConstraints", "supportedDynamicRanges", "", "orderedExistingDynamicRanges", "orderedNewDynamicRanges", "config", "outCombinedConstraints", "", "resolveDynamicRange", "requestedDynamicRange", "combinedConstraints", "rangeOwnerLabel", "", "updateConstraints", "", "newDynamicRange", "findSupportedHdrMatch", "rangeToMatch", "fullySpecifiedCandidateRanges", "", CryptoServicesPermission.CONSTRAINTS, "isFullyUnspecified", "dynamicRange", "isPartiallySpecified", "canResolveWithinConstraints", "rangeToResolve", "candidateRange", "canResolveDynamicRange", "testRange", "fullySpecifiedRange", "Api33Impl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DynamicRangeResolver {
    private final CameraMetadata cameraMetadata;
    private final DynamicRangeProfilesCompat dynamicRangesInfo;
    private final boolean is10BitSupported;

    public DynamicRangeResolver(CameraMetadata cameraMetadata) {
        Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
        this.cameraMetadata = cameraMetadata;
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        Intrinsics.checkNotNullExpressionValue(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) cameraMetadata.get(REQUEST_AVAILABLE_CAPABILITIES);
        this.is10BitSupported = iArr != null ? ArraysKt.contains(iArr, 18) : false;
        this.dynamicRangesInfo = DynamicRangeProfilesCompat.INSTANCE.fromCameraMetaData(cameraMetadata);
    }

    public final CameraMetadata getCameraMetadata() {
        return this.cameraMetadata;
    }

    /* JADX INFO: renamed from: is10BitDynamicRangeSupported, reason: from getter */
    public final boolean getIs10BitSupported() {
        return this.is10BitSupported;
    }

    public final Map<UseCaseConfig<?>, DynamicRange> resolveAndValidateDynamicRanges(List<? extends AttachedSurfaceInfo> existingSurfaces, List<? extends UseCaseConfig<?>> newUseCaseConfigs, List<Integer> useCasePriorityOrder) {
        Intrinsics.checkNotNullParameter(existingSurfaces, "existingSurfaces");
        Intrinsics.checkNotNullParameter(newUseCaseConfigs, "newUseCaseConfigs");
        Intrinsics.checkNotNullParameter(useCasePriorityOrder, "useCasePriorityOrder");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<? extends AttachedSurfaceInfo> it = existingSurfaces.iterator();
        while (it.hasNext()) {
            DynamicRange dynamicRange = it.next().getDynamicRange();
            Intrinsics.checkNotNullExpressionValue(dynamicRange, "getDynamicRange(...)");
            linkedHashSet.add(dynamicRange);
        }
        Set<DynamicRange> supportedDynamicRanges = this.dynamicRangesInfo.getSupportedDynamicRanges();
        Set<DynamicRange> mutableSet = CollectionsKt.toMutableSet(supportedDynamicRanges);
        Iterator<DynamicRange> it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            updateConstraints(mutableSet, it2.next(), this.dynamicRangesInfo);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<Integer> it3 = useCasePriorityOrder.iterator();
        while (it3.hasNext()) {
            UseCaseConfig<?> useCaseConfig = newUseCaseConfigs.get(it3.next().intValue());
            DynamicRange dynamicRange2 = useCaseConfig.getDynamicRange();
            Intrinsics.checkNotNullExpressionValue(dynamicRange2, "getDynamicRange(...)");
            if (isFullyUnspecified(dynamicRange2)) {
                arrayList3.add(useCaseConfig);
            } else if (isPartiallySpecified(dynamicRange2)) {
                arrayList2.add(useCaseConfig);
            } else {
                arrayList.add(useCaseConfig);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList<UseCaseConfig<?>> arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        for (UseCaseConfig<?> useCaseConfig2 : arrayList4) {
            DynamicRangeResolver dynamicRangeResolver = this;
            LinkedHashSet linkedHashSet3 = linkedHashSet2;
            DynamicRange dynamicRangeResolveDynamicRangeAndUpdateConstraints = dynamicRangeResolver.resolveDynamicRangeAndUpdateConstraints(supportedDynamicRanges, linkedHashSet, linkedHashSet3, useCaseConfig2, mutableSet);
            linkedHashMap.put(useCaseConfig2, dynamicRangeResolveDynamicRangeAndUpdateConstraints);
            if (!linkedHashSet.contains(dynamicRangeResolveDynamicRangeAndUpdateConstraints)) {
                linkedHashSet3.add(dynamicRangeResolveDynamicRangeAndUpdateConstraints);
            }
            this = dynamicRangeResolver;
            linkedHashSet2 = linkedHashSet3;
        }
        return linkedHashMap;
    }

    private final DynamicRange resolveDynamicRangeAndUpdateConstraints(Set<DynamicRange> supportedDynamicRanges, Set<DynamicRange> orderedExistingDynamicRanges, Set<DynamicRange> orderedNewDynamicRanges, UseCaseConfig<?> config, Set<DynamicRange> outCombinedConstraints) {
        DynamicRange dynamicRange = config.getDynamicRange();
        Intrinsics.checkNotNullExpressionValue(dynamicRange, "getDynamicRange(...)");
        String targetName = config.getTargetName();
        Intrinsics.checkNotNullExpressionValue(targetName, "getTargetName(...)");
        DynamicRange dynamicRangeResolveDynamicRange = resolveDynamicRange(dynamicRange, outCombinedConstraints, orderedExistingDynamicRanges, orderedNewDynamicRanges, targetName);
        if (dynamicRangeResolveDynamicRange != null) {
            updateConstraints(outCombinedConstraints, dynamicRangeResolveDynamicRange, this.dynamicRangesInfo);
            return dynamicRangeResolveDynamicRange;
        }
        throw new IllegalArgumentException("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  " + config.getTargetName() + "\nRequested dynamic range:\n  " + dynamicRange + "\nSupported dynamic ranges:\n  " + supportedDynamicRanges + "\nConstrained set of concurrent dynamic ranges:\n  " + outCombinedConstraints);
    }

    private final DynamicRange resolveDynamicRange(DynamicRange requestedDynamicRange, Set<DynamicRange> combinedConstraints, Set<DynamicRange> orderedExistingDynamicRanges, Set<DynamicRange> orderedNewDynamicRanges, String rangeOwnerLabel) {
        DynamicRange recommended10BitDynamicRange;
        if (requestedDynamicRange.isFullySpecified()) {
            if (combinedConstraints.contains(requestedDynamicRange)) {
                return requestedDynamicRange;
            }
            return null;
        }
        int encoding = requestedDynamicRange.getEncoding();
        int bitDepth = requestedDynamicRange.getBitDepth();
        if (encoding == 1 && bitDepth == 0) {
            if (combinedConstraints.contains(DynamicRange.SDR)) {
                return DynamicRange.SDR;
            }
            return null;
        }
        DynamicRange dynamicRangeFindSupportedHdrMatch = findSupportedHdrMatch(requestedDynamicRange, orderedExistingDynamicRanges, combinedConstraints);
        if (dynamicRangeFindSupportedHdrMatch != null) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " from existing attached surface.\n" + requestedDynamicRange + "\n->\n" + dynamicRangeFindSupportedHdrMatch);
            }
            return dynamicRangeFindSupportedHdrMatch;
        }
        DynamicRange dynamicRangeFindSupportedHdrMatch2 = findSupportedHdrMatch(requestedDynamicRange, orderedNewDynamicRanges, combinedConstraints);
        if (dynamicRangeFindSupportedHdrMatch2 != null) {
            Camera2Logger camera2Logger2 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " from concurrently bound use case.\n" + requestedDynamicRange + "\n->\n" + dynamicRangeFindSupportedHdrMatch2);
            }
            return dynamicRangeFindSupportedHdrMatch2;
        }
        DynamicRange SDR = DynamicRange.SDR;
        Intrinsics.checkNotNullExpressionValue(SDR, "SDR");
        if (canResolveWithinConstraints(requestedDynamicRange, SDR, combinedConstraints)) {
            Camera2Logger camera2Logger3 = Camera2Logger.INSTANCE;
            if (Logger.isDebugEnabled(Log.TAG)) {
                android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " to no compatible HDR dynamic ranges.\n" + requestedDynamicRange + "\n->\n" + DynamicRange.SDR);
            }
            return DynamicRange.SDR;
        }
        if (encoding == 2 && (bitDepth == 10 || bitDepth == 0)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (Build.VERSION.SDK_INT >= 33) {
                recommended10BitDynamicRange = Api33Impl.INSTANCE.getRecommended10BitDynamicRange(this.cameraMetadata);
                if (recommended10BitDynamicRange != null) {
                    linkedHashSet.add(recommended10BitDynamicRange);
                }
            } else {
                recommended10BitDynamicRange = null;
            }
            DynamicRange HLG_10_BIT = DynamicRange.HLG_10_BIT;
            Intrinsics.checkNotNullExpressionValue(HLG_10_BIT, "HLG_10_BIT");
            linkedHashSet.add(HLG_10_BIT);
            DynamicRange dynamicRangeFindSupportedHdrMatch3 = findSupportedHdrMatch(requestedDynamicRange, linkedHashSet, combinedConstraints);
            if (dynamicRangeFindSupportedHdrMatch3 != null) {
                Camera2Logger camera2Logger4 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    String str = Camera2Logger.TRUNCATED_TAG;
                    StringBuilder sb = new StringBuilder("DynamicRangeResolver: Resolved dynamic range for use case ");
                    sb.append(rangeOwnerLabel);
                    sb.append("from ");
                    sb.append(Intrinsics.areEqual(dynamicRangeFindSupportedHdrMatch3, recommended10BitDynamicRange) ? "recommended" : "required");
                    sb.append(" 10-bit supported dynamic range.\n");
                    sb.append(requestedDynamicRange);
                    sb.append("\n->\n");
                    sb.append(dynamicRangeFindSupportedHdrMatch3);
                    android.util.Log.d(str, sb.toString());
                }
                return dynamicRangeFindSupportedHdrMatch3;
            }
        }
        for (DynamicRange dynamicRange : combinedConstraints) {
            if (!dynamicRange.isFullySpecified()) {
                throw new IllegalStateException("Candidate dynamic range must be fully specified.".toString());
            }
            if (!Intrinsics.areEqual(dynamicRange, DynamicRange.SDR) && canResolveDynamicRange(requestedDynamicRange, dynamicRange)) {
                Camera2Logger camera2Logger5 = Camera2Logger.INSTANCE;
                if (Logger.isDebugEnabled(Log.TAG)) {
                    android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "DynamicRangeResolver: Resolved dynamic range for use case " + rangeOwnerLabel + " from validated dynamic range constraints or supported HDR dynamic ranges.\n" + requestedDynamicRange + "\n->\n" + dynamicRange);
                }
                return dynamicRange;
            }
        }
        return null;
    }

    private final void updateConstraints(Set<DynamicRange> combinedConstraints, DynamicRange newDynamicRange, DynamicRangeProfilesCompat dynamicRangesInfo) {
        Set<DynamicRange> set = combinedConstraints;
        Preconditions.checkState(!set.isEmpty(), "Cannot update already-empty constraints.");
        Set<DynamicRange> dynamicRangeCaptureRequestConstraints = dynamicRangesInfo.getDynamicRangeCaptureRequestConstraints(newDynamicRange);
        Set<DynamicRange> set2 = dynamicRangeCaptureRequestConstraints;
        if (set2.isEmpty()) {
            return;
        }
        Set set3 = CollectionsKt.toSet(combinedConstraints);
        combinedConstraints.retainAll(set2);
        if (set.isEmpty()) {
            throw new IllegalArgumentException(("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  " + newDynamicRange + "\nConstraints:\n  " + dynamicRangeCaptureRequestConstraints + "\nExisting constraints:\n  " + set3).toString());
        }
    }

    private final DynamicRange findSupportedHdrMatch(DynamicRange rangeToMatch, Collection<DynamicRange> fullySpecifiedCandidateRanges, Set<DynamicRange> constraints) {
        if (rangeToMatch.getEncoding() == 1) {
            return null;
        }
        for (DynamicRange dynamicRange : fullySpecifiedCandidateRanges) {
            int encoding = dynamicRange.getEncoding();
            if (!dynamicRange.isFullySpecified()) {
                throw new IllegalStateException("Fully specified DynamicRange must have fully defined encoding.".toString());
            }
            if (encoding != 1 && canResolveWithinConstraints(rangeToMatch, dynamicRange, constraints)) {
                return dynamicRange;
            }
        }
        return null;
    }

    private final boolean isFullyUnspecified(DynamicRange dynamicRange) {
        return Intrinsics.areEqual(dynamicRange, DynamicRange.UNSPECIFIED);
    }

    private final boolean isPartiallySpecified(DynamicRange dynamicRange) {
        if (dynamicRange.getEncoding() == 2) {
            return true;
        }
        if (dynamicRange.getEncoding() == 0 || dynamicRange.getBitDepth() != 0) {
            return dynamicRange.getEncoding() == 0 && dynamicRange.getBitDepth() != 0;
        }
        return true;
    }

    private final boolean canResolveWithinConstraints(DynamicRange rangeToResolve, DynamicRange candidateRange, Set<DynamicRange> constraints) {
        if (!constraints.contains(candidateRange)) {
            Camera2Logger camera2Logger = Camera2Logger.INSTANCE;
            if (!Logger.isDebugEnabled(Log.TAG)) {
                return false;
            }
            android.util.Log.d(Camera2Logger.TRUNCATED_TAG, "DynamicRangeResolver: Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  " + rangeToResolve + "\nCandidate dynamic range:\n  " + candidateRange);
            return false;
        }
        return canResolveDynamicRange(rangeToResolve, candidateRange);
    }

    private final boolean canResolveDynamicRange(DynamicRange testRange, DynamicRange fullySpecifiedRange) {
        if (!fullySpecifiedRange.isFullySpecified()) {
            throw new IllegalStateException(("Fully specified range " + fullySpecifiedRange + " not actually fully specified.").toString());
        }
        if (testRange.getEncoding() == 2 && fullySpecifiedRange.getEncoding() == 1) {
            return false;
        }
        if (testRange.getEncoding() == 2 || testRange.getEncoding() == 0 || testRange.getEncoding() == fullySpecifiedRange.getEncoding()) {
            return testRange.getBitDepth() == 0 || testRange.getBitDepth() == fullySpecifiedRange.getBitDepth();
        }
        return false;
    }

    /* JADX INFO: compiled from: DynamicRangeResolver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/camera2/internal/DynamicRangeResolver$Api33Impl;", "", "<init>", "()V", "getRecommended10BitDynamicRange", "Landroidx/camera/core/DynamicRange;", "cameraMetadata", "Landroidx/camera/camera2/pipe/CameraMetadata;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Api33Impl {
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        public final DynamicRange getRecommended10BitDynamicRange(CameraMetadata cameraMetadata) {
            Intrinsics.checkNotNullParameter(cameraMetadata, "cameraMetadata");
            CameraCharacteristics.Key REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE = CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE;
            Intrinsics.checkNotNullExpressionValue(REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE, "REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE");
            Long l = (Long) cameraMetadata.get(REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (l != null) {
                return DynamicRangeConversions.INSTANCE.profileToDynamicRange(l.longValue());
            }
            return null;
        }
    }
}
