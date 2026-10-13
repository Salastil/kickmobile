package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.video.internal.DynamicRangeMatchedEncoderProfilesProvider;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EncoderProfilesResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\bJ\u0016\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\bJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Landroidx/camera/video/EncoderProfilesResolver;", "", "hostProfilesProvider", "Landroidx/camera/core/impl/EncoderProfilesProvider;", "qualitySource", "", "supportedDynamicRanges", "", "Landroidx/camera/core/DynamicRange;", "<init>", "(Landroidx/camera/core/impl/EncoderProfilesProvider;ILjava/util/Set;)V", "fullySpecifiedMap", "", "Landroidx/camera/video/CapabilitiesByQuality;", "nonFullySpecifiedMap", "getSupportedDynamicRanges", "()Ljava/util/Set;", "getSupportedQualities", "", "Landroidx/camera/video/Quality;", "dynamicRange", "isQualitySupported", "", "quality", "getResolution", "Landroid/util/Size;", "getProfiles", "Landroidx/camera/video/internal/VideoValidatedEncoderProfilesProxy;", "findNearestHigherSupportedEncoderProfilesFor", ContentDisposition.Parameters.Size, "findNearestHigherSupportedQualityFor", "getCapabilities", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EncoderProfilesResolver {
    public static final EncoderProfilesResolver EMPTY;
    private final Map<DynamicRange, CapabilitiesByQuality> fullySpecifiedMap;
    private final EncoderProfilesProvider hostProfilesProvider;
    private final Map<DynamicRange, CapabilitiesByQuality> nonFullySpecifiedMap;
    private final int qualitySource;
    private final Set<DynamicRange> supportedDynamicRanges;

    public EncoderProfilesResolver(EncoderProfilesProvider hostProfilesProvider, int i, Set<DynamicRange> supportedDynamicRanges) {
        Intrinsics.checkNotNullParameter(hostProfilesProvider, "hostProfilesProvider");
        Intrinsics.checkNotNullParameter(supportedDynamicRanges, "supportedDynamicRanges");
        this.hostProfilesProvider = hostProfilesProvider;
        this.qualitySource = i;
        this.fullySpecifiedMap = new LinkedHashMap();
        this.nonFullySpecifiedMap = new LinkedHashMap();
        for (DynamicRange dynamicRange : supportedDynamicRanges) {
            CapabilitiesByQuality capabilitiesByQuality = new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.hostProfilesProvider, dynamicRange), this.qualitySource);
            List<Quality> supportedQualities = capabilitiesByQuality.getSupportedQualities();
            Intrinsics.checkNotNullExpressionValue(supportedQualities, "getSupportedQualities(...)");
            if (!supportedQualities.isEmpty()) {
                this.fullySpecifiedMap.put(dynamicRange, capabilitiesByQuality);
            }
        }
        this.supportedDynamicRanges = this.fullySpecifiedMap.keySet();
    }

    static {
        EncoderProfilesProvider EMPTY2 = EncoderProfilesProvider.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY2, "EMPTY");
        EMPTY = new EncoderProfilesResolver(EMPTY2, 1, SetsKt.emptySet());
    }

    public final Set<DynamicRange> getSupportedDynamicRanges() {
        return this.supportedDynamicRanges;
    }

    public final List<Quality> getSupportedQualities(DynamicRange dynamicRange) {
        List<Quality> supportedQualities;
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        return (capabilities == null || (supportedQualities = capabilities.getSupportedQualities()) == null) ? CollectionsKt.emptyList() : supportedQualities;
    }

    public final boolean isQualitySupported(Quality quality, DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities != null) {
            return capabilities.isQualitySupported(quality);
        }
        return false;
    }

    public final Size getResolution(Quality quality, DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities != null) {
            return capabilities.getResolution(quality);
        }
        return null;
    }

    public final VideoValidatedEncoderProfilesProxy getProfiles(Quality quality, DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities != null) {
            return capabilities.getProfiles(quality);
        }
        return null;
    }

    public final VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(Size size, DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities != null) {
            return capabilities.findNearestHigherSupportedEncoderProfilesFor(size);
        }
        return null;
    }

    public final Quality findNearestHigherSupportedQualityFor(Size size, DynamicRange dynamicRange) {
        Quality qualityFindNearestHigherSupportedQualityFor;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities != null && (qualityFindNearestHigherSupportedQualityFor = capabilities.findNearestHigherSupportedQualityFor(size)) != null) {
            return qualityFindNearestHigherSupportedQualityFor;
        }
        Quality NONE = Quality.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    private final CapabilitiesByQuality getCapabilities(DynamicRange dynamicRange) {
        if (dynamicRange.isFullySpecified()) {
            return this.fullySpecifiedMap.get(dynamicRange);
        }
        Map<DynamicRange, CapabilitiesByQuality> map = this.nonFullySpecifiedMap;
        CapabilitiesByQuality capabilitiesByQuality = map.get(dynamicRange);
        if (capabilitiesByQuality == null) {
            capabilitiesByQuality = DynamicRanges.canResolve(dynamicRange, this.fullySpecifiedMap.keySet()) ? new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.hostProfilesProvider, dynamicRange), this.qualitySource) : null;
            map.put(dynamicRange, capabilitiesByQuality);
        }
        return capabilitiesByQuality;
    }
}
