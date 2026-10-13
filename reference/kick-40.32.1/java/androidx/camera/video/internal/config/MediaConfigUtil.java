package androidx.camera.video.internal.config;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.utils.CodecUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaConfigUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J4\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J4\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002JF\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J2\u0010\"\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J2\u0010#\u001a\u00020$2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u001c\u0010%\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0007J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/camera/video/internal/config/MediaConfigUtil;", "", "<init>", "()V", "TAG", "", "OUTPUT_FORMAT_DEFAULT", "", "supportedVideoEncoderMimesOverride", "", "supportedAudioEncoderMimesOverride", "setSupportedEncoderMimeTypes", "", "videoMimes", "audioMimes", "getSupportedVideoEncoderMimes", "getSupportedAudioEncoderMimes", "resolveMediaInfo", "Landroidx/camera/video/internal/config/MediaInfo;", "mediaSpec", "Landroidx/camera/video/MediaSpec;", "dynamicRange", "Landroidx/camera/core/DynamicRange;", "encoderProfiles", "Landroidx/camera/core/impl/EncoderProfilesProxy;", "resolveByEncoderProfiles", "outputFormat", "videoMime", "audioMime", "resolveByFormatCombo", "resolveFormatCombo", "Landroidx/camera/video/internal/config/FormatCombo;", "supportedVideoEncoderMimes", "supportedAudioEncoderMimes", "resolveByDefault", "resolveCompatibleProfiles", "Landroidx/camera/video/internal/config/MediaConfigUtil$CompatibleProfiles;", "resolveCompatibleEncoderProfiles", "outputFormatToMuxerFormat", "mediaRecorderFormatToOutputFormat", "mediaRecorderFormat", "CompatibleProfiles", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaConfigUtil {
    public static final MediaConfigUtil INSTANCE = new MediaConfigUtil();
    private static final int OUTPUT_FORMAT_DEFAULT = 0;
    private static final String TAG = "MediaConfigUtil";
    private static List<String> supportedAudioEncoderMimesOverride;
    private static List<String> supportedVideoEncoderMimesOverride;

    /* JADX INFO: Access modifiers changed from: private */
    public final int mediaRecorderFormatToOutputFormat(int mediaRecorderFormat) {
        if (mediaRecorderFormat == 1 || mediaRecorderFormat == 2) {
            return 0;
        }
        return mediaRecorderFormat != 9 ? -1 : 1;
    }

    @JvmStatic
    public static final int outputFormatToMuxerFormat(int outputFormat) {
        return outputFormat == 1 ? 1 : 0;
    }

    private MediaConfigUtil() {
    }

    public final void setSupportedEncoderMimeTypes(List<String> videoMimes, List<String> audioMimes) {
        supportedVideoEncoderMimesOverride = videoMimes;
        supportedAudioEncoderMimesOverride = audioMimes;
    }

    private final List<String> getSupportedVideoEncoderMimes() {
        List<String> list = supportedVideoEncoderMimesOverride;
        return list == null ? CodecUtil.getVideoEncoderMimeTypes() : list;
    }

    private final List<String> getSupportedAudioEncoderMimes() {
        List<String> list = supportedAudioEncoderMimesOverride;
        return list == null ? CodecUtil.getAudioEncoderMimeTypes() : list;
    }

    @JvmStatic
    public static final MediaInfo resolveMediaInfo(MediaSpec mediaSpec, DynamicRange dynamicRange, EncoderProfilesProxy encoderProfiles) {
        Intrinsics.checkNotNullParameter(mediaSpec, "mediaSpec");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        Logger.d(TAG, "Resolving MediaInfo for MediaSpec: " + mediaSpec + ", DynamicRange: " + dynamicRange + ", EncoderProfiles: " + encoderProfiles);
        int outputFormat = mediaSpec.getOutputFormat();
        String mimeType = mediaSpec.getVideoSpec().getMimeType();
        String mimeType2 = mediaSpec.getAudioSpec().getMimeType();
        MediaConfigUtil mediaConfigUtil = INSTANCE;
        MediaInfo mediaInfoResolveByEncoderProfiles = mediaConfigUtil.resolveByEncoderProfiles(encoderProfiles, dynamicRange, outputFormat, mimeType, mimeType2);
        if (mediaInfoResolveByEncoderProfiles != null) {
            return mediaInfoResolveByEncoderProfiles;
        }
        MediaInfo mediaInfoResolveByFormatCombo = mediaConfigUtil.resolveByFormatCombo(encoderProfiles, dynamicRange, outputFormat, mimeType, mimeType2);
        return mediaInfoResolveByFormatCombo != null ? mediaInfoResolveByFormatCombo : mediaConfigUtil.resolveByDefault(encoderProfiles, dynamicRange, outputFormat, mimeType, mimeType2);
    }

    private final MediaInfo resolveByEncoderProfiles(EncoderProfilesProxy encoderProfiles, DynamicRange dynamicRange, int outputFormat, String videoMime, String audioMime) {
        CompatibleProfiles compatibleProfilesResolveCompatibleProfiles = resolveCompatibleProfiles(encoderProfiles, dynamicRange, outputFormat, videoMime, audioMime);
        Logger.d(TAG, "Resolved CompatibleProfiles: " + compatibleProfilesResolveCompatibleProfiles);
        if (!compatibleProfilesResolveCompatibleProfiles.isFullyCompatible()) {
            compatibleProfilesResolveCompatibleProfiles = null;
        }
        if (compatibleProfilesResolveCompatibleProfiles == null) {
            return null;
        }
        MediaInfo mediaInfo = compatibleProfilesResolveCompatibleProfiles.toMediaInfo();
        Logger.d(TAG, "Resolved MediaInfo by CompatibleProfiles: " + mediaInfo);
        return mediaInfo;
    }

    private final MediaInfo resolveByFormatCombo(EncoderProfilesProxy encoderProfiles, DynamicRange dynamicRange, int outputFormat, String videoMime, String audioMime) {
        FormatCombo formatComboResolveFormatCombo = resolveFormatCombo(outputFormat, videoMime, audioMime, dynamicRange, getSupportedVideoEncoderMimes(), getSupportedAudioEncoderMimes());
        Logger.d(TAG, "Resolved FormatCombo: " + formatComboResolveFormatCombo);
        if (formatComboResolveFormatCombo == null) {
            return null;
        }
        int container = formatComboResolveFormatCombo.getContainer();
        String videoMime2 = formatComboResolveFormatCombo.getVideoMime();
        Intrinsics.checkNotNull(videoMime2);
        String audioMime2 = formatComboResolveFormatCombo.getAudioMime();
        if (audioMime2 == null) {
            audioMime2 = AudioSpec.MIME_TYPE_UNSPECIFIED;
        }
        CompatibleProfiles compatibleProfilesResolveCompatibleProfiles = resolveCompatibleProfiles(encoderProfiles, dynamicRange, container, videoMime2, audioMime2);
        ContainerInfo containerInfo = new ContainerInfo(formatComboResolveFormatCombo.getContainer(), compatibleProfilesResolveCompatibleProfiles.getEncoderProfiles());
        VideoMimeInfo videoMimeInfo = new VideoMimeInfo(formatComboResolveFormatCombo.getVideoMime(), 0, compatibleProfilesResolveCompatibleProfiles.getVideoProfile(), 2, null);
        String audioMime3 = formatComboResolveFormatCombo.getAudioMime();
        MediaInfo mediaInfo = new MediaInfo(containerInfo, videoMimeInfo, audioMime3 != null ? new AudioMimeInfo(audioMime3, AudioConfigUtil.INSTANCE.audioMimeToAudioProfile(audioMime3), compatibleProfilesResolveCompatibleProfiles.getAudioProfile()) : null);
        Logger.d(TAG, "Resolved MediaInfo by FormatCombo: " + mediaInfo);
        return mediaInfo;
    }

    private final FormatCombo resolveFormatCombo(int outputFormat, String videoMime, String audioMime, DynamicRange dynamicRange, List<String> supportedVideoEncoderMimes, List<String> supportedAudioEncoderMimes) {
        Object next;
        Logger.d(TAG, "resolveFormatCombo - supportedVideoEncoderMimes: " + supportedVideoEncoderMimes + ", supportedAudioEncoderMimes: " + supportedAudioEncoderMimes);
        FormatComboRegistry registry = DynamicRangeFormatComboRegistry.INSTANCE.getRegistry(dynamicRange);
        Object obj = null;
        if (registry == null) {
            return null;
        }
        List<FormatCombo> combos = registry.getCombos(outputFormat, videoMime, audioMime);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : combos) {
            if (((FormatCombo) obj2).getVideoMime() != null) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Logger.d(TAG, "eligibleFormatCombos: " + arrayList2);
        if (arrayList2.isEmpty()) {
            return null;
        }
        ArrayList arrayList3 = arrayList2;
        Iterator it = arrayList3.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            FormatCombo formatCombo = (FormatCombo) next;
            if (CollectionsKt.contains(supportedVideoEncoderMimes, formatCombo.getVideoMime()) && CollectionsKt.contains(supportedAudioEncoderMimes, formatCombo.getAudioMime())) {
                break;
            }
        }
        FormatCombo formatCombo2 = (FormatCombo) next;
        if (formatCombo2 != null) {
            return formatCombo2;
        }
        for (Object obj3 : arrayList3) {
            FormatCombo formatCombo3 = (FormatCombo) obj3;
            if (CollectionsKt.contains(supportedVideoEncoderMimes, formatCombo3.getVideoMime()) && formatCombo3.getAudioMime() == null) {
                obj = obj3;
                break;
            }
        }
        FormatCombo formatCombo4 = (FormatCombo) obj;
        return formatCombo4 == null ? (FormatCombo) CollectionsKt.firstOrNull((List) arrayList2) : formatCombo4;
    }

    private final MediaInfo resolveByDefault(EncoderProfilesProxy encoderProfiles, DynamicRange dynamicRange, int outputFormat, String videoMime, String audioMime) {
        Integer numValueOf = Integer.valueOf(outputFormat);
        if (numValueOf.intValue() == -1) {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        if (Intrinsics.areEqual(videoMime, VideoSpec.MIME_TYPE_UNSPECIFIED)) {
            videoMime = null;
        }
        if (videoMime == null && (videoMime = VideoConfigUtil.INSTANCE.getDynamicRangeDefaultMime(dynamicRange)) == null) {
            videoMime = VideoConfigUtil.INSTANCE.outputFormatToVideoMime(outputFormat);
        }
        if (Intrinsics.areEqual(audioMime, AudioSpec.MIME_TYPE_UNSPECIFIED)) {
            audioMime = null;
        }
        if (audioMime == null) {
            audioMime = AudioConfigUtil.INSTANCE.outputFormatToAudioMime(outputFormat);
        }
        int i = iIntValue;
        CompatibleProfiles compatibleProfilesResolveCompatibleProfiles = resolveCompatibleProfiles(encoderProfiles, dynamicRange, i, videoMime, audioMime);
        MediaInfo mediaInfo = new MediaInfo(new ContainerInfo(i, compatibleProfilesResolveCompatibleProfiles.getEncoderProfiles()), new VideoMimeInfo(videoMime, 0, compatibleProfilesResolveCompatibleProfiles.getVideoProfile(), 2, null), new AudioMimeInfo(audioMime, AudioConfigUtil.INSTANCE.audioMimeToAudioProfile(audioMime), compatibleProfilesResolveCompatibleProfiles.getAudioProfile()));
        Logger.d(TAG, "Resolved MediaInfo by Default: " + mediaInfo);
        return mediaInfo;
    }

    private final CompatibleProfiles resolveCompatibleProfiles(EncoderProfilesProxy encoderProfiles, DynamicRange dynamicRange, int outputFormat, String videoMime, String audioMime) {
        if (encoderProfiles == null) {
            return CompatibleProfiles.INSTANCE.getEMPTY();
        }
        EncoderProfilesProxy encoderProfilesProxyResolveCompatibleEncoderProfiles = resolveCompatibleEncoderProfiles(outputFormat, encoderProfiles);
        VideoConfigUtil videoConfigUtil = VideoConfigUtil.INSTANCE;
        List<EncoderProfilesProxy.VideoProfileProxy> videoProfiles = encoderProfiles.getVideoProfiles();
        Intrinsics.checkNotNullExpressionValue(videoProfiles, "getVideoProfiles(...)");
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxyResolveCompatibleVideoProfile = videoConfigUtil.resolveCompatibleVideoProfile(videoMime, dynamicRange, videoProfiles);
        AudioConfigUtil audioConfigUtil = AudioConfigUtil.INSTANCE;
        List<EncoderProfilesProxy.AudioProfileProxy> audioProfiles = encoderProfiles.getAudioProfiles();
        Intrinsics.checkNotNullExpressionValue(audioProfiles, "getAudioProfiles(...)");
        return new CompatibleProfiles(encoderProfilesProxyResolveCompatibleEncoderProfiles, videoProfileProxyResolveCompatibleVideoProfile, audioConfigUtil.resolveCompatibleAudioProfile(audioMime, audioProfiles));
    }

    private final EncoderProfilesProxy resolveCompatibleEncoderProfiles(int outputFormat, EncoderProfilesProxy encoderProfiles) {
        if (encoderProfiles == null) {
            return null;
        }
        if (outputFormat == -1 || outputFormat == INSTANCE.mediaRecorderFormatToOutputFormat(encoderProfiles.getRecommendedFileFormat())) {
            return encoderProfiles;
        }
        return null;
    }

    /* JADX INFO: compiled from: MediaConfigUtil.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006 "}, d2 = {"Landroidx/camera/video/internal/config/MediaConfigUtil$CompatibleProfiles;", "", "encoderProfiles", "Landroidx/camera/core/impl/EncoderProfilesProxy;", "videoProfile", "Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;", "audioProfile", "Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;", "<init>", "(Landroidx/camera/core/impl/EncoderProfilesProxy;Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;)V", "getEncoderProfiles", "()Landroidx/camera/core/impl/EncoderProfilesProxy;", "getVideoProfile", "()Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;", "getAudioProfile", "()Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;", "isFullyCompatible", "", "()Z", "toMediaInfo", "Landroidx/camera/video/internal/config/MediaInfo;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class CompatibleProfiles {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final CompatibleProfiles EMPTY = new CompatibleProfiles(null, null, null, 7, null);
        private final EncoderProfilesProxy.AudioProfileProxy audioProfile;
        private final EncoderProfilesProxy encoderProfiles;
        private final EncoderProfilesProxy.VideoProfileProxy videoProfile;

        public CompatibleProfiles() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ CompatibleProfiles copy$default(CompatibleProfiles compatibleProfiles, EncoderProfilesProxy encoderProfilesProxy, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy, int i, Object obj) {
            if ((i & 1) != 0) {
                encoderProfilesProxy = compatibleProfiles.encoderProfiles;
            }
            if ((i & 2) != 0) {
                videoProfileProxy = compatibleProfiles.videoProfile;
            }
            if ((i & 4) != 0) {
                audioProfileProxy = compatibleProfiles.audioProfile;
            }
            return compatibleProfiles.copy(encoderProfilesProxy, videoProfileProxy, audioProfileProxy);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final EncoderProfilesProxy getEncoderProfiles() {
            return this.encoderProfiles;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final EncoderProfilesProxy.VideoProfileProxy getVideoProfile() {
            return this.videoProfile;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final EncoderProfilesProxy.AudioProfileProxy getAudioProfile() {
            return this.audioProfile;
        }

        public final CompatibleProfiles copy(EncoderProfilesProxy encoderProfiles, EncoderProfilesProxy.VideoProfileProxy videoProfile, EncoderProfilesProxy.AudioProfileProxy audioProfile) {
            return new CompatibleProfiles(encoderProfiles, videoProfile, audioProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CompatibleProfiles)) {
                return false;
            }
            CompatibleProfiles compatibleProfiles = (CompatibleProfiles) other;
            return Intrinsics.areEqual(this.encoderProfiles, compatibleProfiles.encoderProfiles) && Intrinsics.areEqual(this.videoProfile, compatibleProfiles.videoProfile) && Intrinsics.areEqual(this.audioProfile, compatibleProfiles.audioProfile);
        }

        public int hashCode() {
            EncoderProfilesProxy encoderProfilesProxy = this.encoderProfiles;
            int iHashCode = (encoderProfilesProxy == null ? 0 : encoderProfilesProxy.hashCode()) * 31;
            EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = this.videoProfile;
            int iHashCode2 = (iHashCode + (videoProfileProxy == null ? 0 : videoProfileProxy.hashCode())) * 31;
            EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = this.audioProfile;
            return iHashCode2 + (audioProfileProxy != null ? audioProfileProxy.hashCode() : 0);
        }

        public String toString() {
            return "CompatibleProfiles(encoderProfiles=" + this.encoderProfiles + ", videoProfile=" + this.videoProfile + ", audioProfile=" + this.audioProfile + ')';
        }

        public CompatibleProfiles(EncoderProfilesProxy encoderProfilesProxy, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
            this.encoderProfiles = encoderProfilesProxy;
            this.videoProfile = videoProfileProxy;
            this.audioProfile = audioProfileProxy;
        }

        public /* synthetic */ CompatibleProfiles(EncoderProfilesProxy encoderProfilesProxy, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : encoderProfilesProxy, (i & 2) != 0 ? null : videoProfileProxy, (i & 4) != 0 ? null : audioProfileProxy);
        }

        public final EncoderProfilesProxy getEncoderProfiles() {
            return this.encoderProfiles;
        }

        public final EncoderProfilesProxy.VideoProfileProxy getVideoProfile() {
            return this.videoProfile;
        }

        public final EncoderProfilesProxy.AudioProfileProxy getAudioProfile() {
            return this.audioProfile;
        }

        /* JADX INFO: compiled from: MediaConfigUtil.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/camera/video/internal/config/MediaConfigUtil$CompatibleProfiles$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/camera/video/internal/config/MediaConfigUtil$CompatibleProfiles;", "getEMPTY", "()Landroidx/camera/video/internal/config/MediaConfigUtil$CompatibleProfiles;", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CompatibleProfiles getEMPTY() {
                return CompatibleProfiles.EMPTY;
            }
        }

        public final boolean isFullyCompatible() {
            return (this.encoderProfiles == null || this.videoProfile == null || this.audioProfile == null) ? false : true;
        }

        public final MediaInfo toMediaInfo() {
            if (!isFullyCompatible()) {
                throw new IllegalStateException("Check failed.");
            }
            MediaConfigUtil mediaConfigUtil = MediaConfigUtil.INSTANCE;
            EncoderProfilesProxy encoderProfilesProxy = this.encoderProfiles;
            Intrinsics.checkNotNull(encoderProfilesProxy);
            ContainerInfo containerInfo = new ContainerInfo(mediaConfigUtil.mediaRecorderFormatToOutputFormat(encoderProfilesProxy.getRecommendedFileFormat()), this.encoderProfiles);
            EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = this.videoProfile;
            Intrinsics.checkNotNull(videoProfileProxy);
            String mediaType = videoProfileProxy.getMediaType();
            Intrinsics.checkNotNullExpressionValue(mediaType, "getMediaType(...)");
            VideoMimeInfo videoMimeInfo = new VideoMimeInfo(mediaType, 0, this.videoProfile, 2, null);
            EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = this.audioProfile;
            Intrinsics.checkNotNull(audioProfileProxy);
            String mediaType2 = audioProfileProxy.getMediaType();
            Intrinsics.checkNotNullExpressionValue(mediaType2, "getMediaType(...)");
            return new MediaInfo(containerInfo, videoMimeInfo, new AudioMimeInfo(mediaType2, this.audioProfile.getProfile(), this.audioProfile));
        }
    }
}
