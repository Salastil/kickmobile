package androidx.camera.core.featuregroup.impl.resolver;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SessionConfig;
import androidx.camera.core.UseCase;
import androidx.camera.core.featuregroup.GroupableFeature;
import androidx.camera.core.featuregroup.impl.ResolvedFeatureGroup;
import androidx.camera.core.featuregroup.impl.UseCaseType;
import androidx.camera.core.featuregroup.impl.feature.FeatureTypeInternal;
import androidx.camera.core.featuregroup.impl.feature.VideoStabilizationFeature;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import androidx.camera.core.impl.utils.UseCaseUtil;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultFeatureGroupResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J8\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\u0012\u0010\u0015\u001a\u00020\u0016*\b\u0012\u0004\u0012\u00020\f0\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/camera/core/featuregroup/impl/resolver/DefaultFeatureGroupResolver;", "Landroidx/camera/core/featuregroup/impl/resolver/FeatureGroupResolver;", "cameraInfoInternal", "Landroidx/camera/core/impl/CameraInfoInternal;", "<init>", "(Landroidx/camera/core/impl/CameraInfoInternal;)V", "resolveFeatureGroup", "Landroidx/camera/core/featuregroup/impl/resolver/FeatureGroupResolutionResult;", "sessionConfig", "Landroidx/camera/core/SessionConfig;", "getMissingUseCase", "Landroidx/camera/core/featuregroup/impl/resolver/FeatureGroupResolutionResult$UseCaseMissing;", "Landroidx/camera/core/featuregroup/GroupableFeature;", "useCases", "", "Landroidx/camera/core/UseCase;", "getFeatureListResolvedByPriority", "orderedPreferredFeatures", FirebaseAnalytics.Param.INDEX, "", "currentOptionalFeatures", "isConflictFree", "", "", "Companion", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultFeatureGroupResolver implements FeatureGroupResolver {
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "DefaultFeatureGroupResolver";
    private final CameraInfoInternal cameraInfoInternal;

    /* JADX INFO: compiled from: DefaultFeatureGroupResolver.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[VideoStabilization.values().length];
            try {
                iArr[VideoStabilization.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VideoStabilization.ON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FeatureTypeInternal.values().length];
            try {
                iArr2[FeatureTypeInternal.IMAGE_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FeatureTypeInternal.DYNAMIC_RANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FeatureTypeInternal.FPS_RANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FeatureTypeInternal.VIDEO_STABILIZATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FeatureTypeInternal.RECORDING_QUALITY.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DefaultFeatureGroupResolver(CameraInfoInternal cameraInfoInternal) {
        Intrinsics.checkNotNullParameter(cameraInfoInternal, "cameraInfoInternal");
        this.cameraInfoInternal = cameraInfoInternal;
    }

    @Override // androidx.camera.core.featuregroup.impl.resolver.FeatureGroupResolver
    public FeatureGroupResolutionResult resolveFeatureGroup(SessionConfig sessionConfig) {
        Intrinsics.checkNotNullParameter(sessionConfig, "sessionConfig");
        List<UseCase> useCases = sessionConfig.getUseCases();
        Set<GroupableFeature> requiredFeatureGroup = sessionConfig.getRequiredFeatureGroup();
        List<GroupableFeature> preferredFeatureGroup = sessionConfig.getPreferredFeatureGroup();
        if (requiredFeatureGroup.isEmpty() && preferredFeatureGroup.isEmpty()) {
            throw new IllegalArgumentException("Must have at least one required or preferred feature".toString());
        }
        for (UseCase useCase : useCases) {
            if (UseCaseType.INSTANCE.getFeatureGroupUseCaseType(useCase) == UseCaseType.UNDEFINED) {
                return new FeatureGroupResolutionResult.UnsupportedUseCase(useCase);
            }
        }
        Iterator<T> it = requiredFeatureGroup.iterator();
        while (it.hasNext()) {
            FeatureGroupResolutionResult.UseCaseMissing missingUseCase = getMissingUseCase((GroupableFeature) it.next(), useCases);
            if (missingUseCase != null) {
                return missingUseCase;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : preferredFeatureGroup) {
            FeatureGroupResolutionResult.UseCaseMissing missingUseCase2 = getMissingUseCase((GroupableFeature) obj, useCases);
            if (missingUseCase2 != null) {
                Logger.d(TAG, "resolveFeatureGroup: filtered out preferred feature due to " + missingUseCase2);
            } else {
                missingUseCase2 = null;
            }
            if (missingUseCase2 == null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        Logger.d(TAG, "resolveFeatureGroup: filteredPreferredFeatures = " + arrayList2);
        return getFeatureListResolvedByPriority$default(this, sessionConfig, arrayList2, 0, null, 12, null);
    }

    /* JADX WARN: Code duplicated, block: B:67:0x00e4  */
    private final FeatureGroupResolutionResult.UseCaseMissing getMissingUseCase(GroupableFeature groupableFeature, List<? extends UseCase> list) {
        boolean z;
        boolean z2;
        boolean z3;
        String string;
        List<? extends UseCase> list2 = list;
        boolean z4 = list2 instanceof Collection;
        boolean z5 = false;
        if (!z4 || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (((UseCase) it.next()) instanceof ImageCapture) {
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        if (z4 && list2.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    UseCase useCase = (UseCase) it2.next();
                    if ((useCase instanceof Preview) || UseCaseUtil.isVideoCapture(useCase)) {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            }
        }
        if (z4 && list2.isEmpty()) {
            z3 = false;
        } else {
            Iterator<T> it3 = list2.iterator();
            while (true) {
                if (it3.hasNext()) {
                    UseCase useCase2 = (UseCase) it3.next();
                    if ((useCase2 instanceof Preview) || (useCase2 instanceof ImageAnalysis) || UseCaseUtil.isVideoCapture(useCase2)) {
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
            }
        }
        if (!z4 || !list2.isEmpty()) {
            Iterator<T> it4 = list2.iterator();
            while (it4.hasNext()) {
                if (UseCaseUtil.isVideoCapture((UseCase) it4.next())) {
                    z5 = true;
                    break;
                }
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$1[groupableFeature.getFeatureTypeInternal().ordinal()];
        if (i == 1) {
            string = UseCaseType.IMAGE_CAPTURE.toString();
            if (z) {
                string = null;
            }
        } else if (i == 2) {
            string = UseCaseType.PREVIEW + " or " + UseCaseType.VIDEO_CAPTURE;
            if (z2) {
                string = null;
            }
        } else if (i == 3) {
            string = UseCaseType.PREVIEW + " or " + UseCaseType.VIDEO_CAPTURE + " or " + UseCaseType.IMAGE_ANALYSIS;
            if (z3) {
                string = null;
            }
        } else if (i == 4) {
            Intrinsics.checkNotNull(groupableFeature, "null cannot be cast to non-null type androidx.camera.core.featuregroup.impl.feature.VideoStabilizationFeature");
            int i2 = WhenMappings.$EnumSwitchMapping$0[((VideoStabilizationFeature) groupableFeature).getVideoStabilization().ordinal()];
            if (i2 == 1) {
                string = UseCaseType.PREVIEW + " or " + UseCaseType.VIDEO_CAPTURE + " or " + UseCaseType.IMAGE_ANALYSIS;
                if (z3) {
                    string = null;
                }
            } else if (i2 != 2) {
                string = null;
            } else {
                string = UseCaseType.VIDEO_CAPTURE.toString();
                if (z5) {
                    string = null;
                }
            }
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            string = UseCaseType.VIDEO_CAPTURE.toString();
            if (z5) {
                string = null;
            }
        }
        if (string != null) {
            return new FeatureGroupResolutionResult.UseCaseMissing(string, groupableFeature);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ FeatureGroupResolutionResult getFeatureListResolvedByPriority$default(DefaultFeatureGroupResolver defaultFeatureGroupResolver, SessionConfig sessionConfig, List list, int i, List list2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return defaultFeatureGroupResolver.getFeatureListResolvedByPriority(sessionConfig, list, i, list2);
    }

    private final FeatureGroupResolutionResult getFeatureListResolvedByPriority(SessionConfig sessionConfig, List<? extends GroupableFeature> orderedPreferredFeatures, int index, List<? extends GroupableFeature> currentOptionalFeatures) {
        if (index >= orderedPreferredFeatures.size()) {
            Set<? extends GroupableFeature> setPlus = SetsKt.plus((Set) sessionConfig.getRequiredFeatureGroup(), (Iterable) currentOptionalFeatures);
            Logger.d(TAG, "getFeatureListResolvedByPriority: features = " + setPlus + ", useCases = " + sessionConfig.getUseCases());
            if (isConflictFree(setPlus) && this.cameraInfoInternal.isResolvedFeatureGroupSupported(new ResolvedFeatureGroup(setPlus), sessionConfig)) {
                return new FeatureGroupResolutionResult.Supported(new ResolvedFeatureGroup(setPlus));
            }
            return FeatureGroupResolutionResult.Unsupported.INSTANCE;
        }
        int i = index + 1;
        FeatureGroupResolutionResult featureListResolvedByPriority = getFeatureListResolvedByPriority(sessionConfig, orderedPreferredFeatures, i, CollectionsKt.plus((Collection<? extends GroupableFeature>) currentOptionalFeatures, orderedPreferredFeatures.get(index)));
        return featureListResolvedByPriority instanceof FeatureGroupResolutionResult.Supported ? featureListResolvedByPriority : getFeatureListResolvedByPriority(sessionConfig, orderedPreferredFeatures, i, currentOptionalFeatures);
    }

    private final boolean isConflictFree(Set<? extends GroupableFeature> set) {
        Set<? extends GroupableFeature> set2 = set;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(((GroupableFeature) it.next()).getFeatureTypeInternal());
        }
        for (FeatureTypeInternal featureTypeInternal : CollectionsKt.distinct(arrayList)) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : set2) {
                if (((GroupableFeature) obj).getFeatureTypeInternal() == featureTypeInternal) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() > 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: DefaultFeatureGroupResolver.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/camera/core/featuregroup/impl/resolver/DefaultFeatureGroupResolver$Companion;", "", "<init>", "()V", "TAG", "", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
