package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecDefaultDataSpaceQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderDataSpace;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.media3.common.MimeTypes;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: VideoConfigUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tJ\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 2\u0006\u0010!\u001a\u00020\u0005J>\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0,H\u0007J\u0018\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200H\u0007JP\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0007J\u0016\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\tJ#\u0010>\u001a\u00020?2\u0006\u0010'\u001a\u00020(2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0,H\u0000¢\u0006\u0002\bAR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Landroidx/camera/video/internal/config/VideoConfigUtil;", "", "<init>", "()V", "TAG", "", "MIME_TO_DATA_SPACE_MAP", "", "", "", "Landroidx/camera/video/internal/encoder/VideoEncoderDataSpace;", "VIDEO_FRAME_RATE_FIXED_DEFAULT", "VIDEO_ENCODER_MIME_MPEG4_DEFAULT", "VIDEO_ENCODER_MIME_WEBM_DEFAULT", "resolveCompatibleVideoProfile", "Landroidx/camera/core/impl/EncoderProfilesProxy$VideoProfileProxy;", "videoMime", "dynamicRange", "Landroidx/camera/core/DynamicRange;", "videoProfiles", "", "resolveVideoMimeInfo", "Landroidx/camera/video/internal/config/VideoMimeInfo;", "mediaSpec", "Landroidx/camera/video/MediaSpec;", "encoderProfiles", "Landroidx/camera/video/internal/VideoValidatedEncoderProfilesProxy;", "outputFormatToVideoMime", "outputFormat", "getDynamicRangeDefaultMimeOrThrow", "getDynamicRangeDefaultMime", "getDynamicRangesForMime", "", "mime", "resolveVideoEncoderConfig", "Landroidx/camera/video/internal/encoder/VideoEncoderConfig;", "videoMimeInfo", "inputTimebase", "Landroidx/camera/core/impl/Timebase;", "videoSpec", "Landroidx/camera/video/VideoSpec;", "surfaceSize", "Landroid/util/Size;", "expectedFrameRateRange", "Landroid/util/Range;", "workaroundDataSpaceIfRequired", "config", "hasGlProcessing", "", "scaleBitrate", "baseBitrate", "actualBitDepth", "baseBitDepth", "actualFrameRate", "baseFrameRate", "actualWidth", "baseWidth", "actualHeight", "baseHeight", "mimeAndProfileToEncoderDataSpace", "mimeType", "codecProfileLevel", "resolveFrameRates", "Landroidx/camera/video/internal/config/CaptureEncodeRates;", "expectedCaptureFrameRateRange", "resolveFrameRates$camera_video", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoConfigUtil {
    public static final VideoConfigUtil INSTANCE = new VideoConfigUtil();
    private static final Map<String, Map<Integer, VideoEncoderDataSpace>> MIME_TO_DATA_SPACE_MAP = MapsKt.mutableMapOf(TuplesKt.to("video/hevc", MapsKt.mapOf(TuplesKt.to(1, VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED), TuplesKt.to(2, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG), TuplesKt.to(4096, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ), TuplesKt.to(8192, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ))), TuplesKt.to("video/av01", MapsKt.mapOf(TuplesKt.to(1, VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED), TuplesKt.to(2, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG), TuplesKt.to(4096, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ), TuplesKt.to(8192, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ))), TuplesKt.to("video/x-vnd.on2.vp9", MapsKt.mapOf(TuplesKt.to(1, VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED), TuplesKt.to(4, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG), TuplesKt.to(4096, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ), TuplesKt.to(16384, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ), TuplesKt.to(2, VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED), TuplesKt.to(8, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG), TuplesKt.to(8192, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ), TuplesKt.to(32768, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ))), TuplesKt.to(MimeTypes.VIDEO_DOLBY_VISION, MapsKt.mapOf(TuplesKt.to(256, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG), TuplesKt.to(512, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT709))));
    private static final String TAG = "VideoConfigUtil";
    private static final String VIDEO_ENCODER_MIME_MPEG4_DEFAULT = "video/avc";
    private static final String VIDEO_ENCODER_MIME_WEBM_DEFAULT = "video/x-vnd.on2.vp8";
    public static final int VIDEO_FRAME_RATE_FIXED_DEFAULT = 30;

    private VideoConfigUtil() {
    }

    public final EncoderProfilesProxy.VideoProfileProxy resolveCompatibleVideoProfile(String videoMime, DynamicRange dynamicRange, List<? extends EncoderProfilesProxy.VideoProfileProxy> videoProfiles) {
        Object next;
        Intrinsics.checkNotNullParameter(videoMime, "videoMime");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        Intrinsics.checkNotNullParameter(videoProfiles, "videoProfiles");
        Set<Integer> setDynamicRangeToVideoProfileHdrFormats = DynamicRangeUtil.dynamicRangeToVideoProfileHdrFormats(dynamicRange);
        Intrinsics.checkNotNullExpressionValue(setDynamicRangeToVideoProfileHdrFormats, "dynamicRangeToVideoProfileHdrFormats(...)");
        Set<Integer> setDynamicRangeToVideoProfileBitDepth = DynamicRangeUtil.dynamicRangeToVideoProfileBitDepth(dynamicRange);
        Intrinsics.checkNotNullExpressionValue(setDynamicRangeToVideoProfileBitDepth, "dynamicRangeToVideoProfileBitDepth(...)");
        Iterator<T> it = videoProfiles.iterator();
        while (it.hasNext()) {
            next = it.next();
            EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = (EncoderProfilesProxy.VideoProfileProxy) next;
            if (setDynamicRangeToVideoProfileHdrFormats.contains(Integer.valueOf(videoProfileProxy.getHdrFormat())) && setDynamicRangeToVideoProfileBitDepth.contains(Integer.valueOf(videoProfileProxy.getBitDepth())) && (Intrinsics.areEqual(videoMime, VideoSpec.MIME_TYPE_UNSPECIFIED) || Intrinsics.areEqual(videoProfileProxy.getMediaType(), videoMime))) {
                return (EncoderProfilesProxy.VideoProfileProxy) next;
            }
        }
        next = null;
        return (EncoderProfilesProxy.VideoProfileProxy) next;
    }

    @JvmStatic
    public static final VideoMimeInfo resolveVideoMimeInfo(MediaSpec mediaSpec, DynamicRange dynamicRange, VideoValidatedEncoderProfilesProxy encoderProfiles) {
        EncoderProfilesProxy.VideoProfileProxy next;
        Intrinsics.checkNotNullParameter(mediaSpec, "mediaSpec");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        if (!dynamicRange.isFullySpecified()) {
            throw new IllegalStateException(("Dynamic range must be a fully specified dynamic range [provided dynamic range: " + dynamicRange + AbstractJsonLexerKt.END_LIST).toString());
        }
        String strOutputFormatToVideoMime = MediaSpec.INSTANCE.outputFormatToVideoMime(mediaSpec.getOutputFormat());
        if (encoderProfiles != null) {
            Set<Integer> setDynamicRangeToVideoProfileHdrFormats = DynamicRangeUtil.dynamicRangeToVideoProfileHdrFormats(dynamicRange);
            Intrinsics.checkNotNullExpressionValue(setDynamicRangeToVideoProfileHdrFormats, "dynamicRangeToVideoProfileHdrFormats(...)");
            Set<Integer> setDynamicRangeToVideoProfileBitDepth = DynamicRangeUtil.dynamicRangeToVideoProfileBitDepth(dynamicRange);
            Intrinsics.checkNotNullExpressionValue(setDynamicRangeToVideoProfileBitDepth, "dynamicRangeToVideoProfileBitDepth(...)");
            Iterator<EncoderProfilesProxy.VideoProfileProxy> it = encoderProfiles.getVideoProfiles().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (setDynamicRangeToVideoProfileHdrFormats.contains(Integer.valueOf(next.getHdrFormat())) && setDynamicRangeToVideoProfileBitDepth.contains(Integer.valueOf(next.getBitDepth()))) {
                        String mediaType = next.getMediaType();
                        Intrinsics.checkNotNullExpressionValue(mediaType, "getMediaType(...)");
                        if (Intrinsics.areEqual(strOutputFormatToVideoMime, mediaType)) {
                            Logger.d(TAG, "MediaSpec video mime matches EncoderProfiles. Using EncoderProfiles to derive VIDEO settings [mime type: " + strOutputFormatToVideoMime + AbstractJsonLexerKt.END_LIST);
                        } else if (mediaSpec.getOutputFormat() == -1) {
                            Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_UNSPECIFIED. Using CamcorderProfile to derive VIDEO settings [mime type: " + strOutputFormatToVideoMime + ", dynamic range: " + dynamicRange + AbstractJsonLexerKt.END_LIST);
                        }
                        strOutputFormatToVideoMime = mediaType;
                    }
                } else {
                    next = null;
                }
            }
        } else {
            next = null;
        }
        if (next == null) {
            if (mediaSpec.getOutputFormat() == -1) {
                strOutputFormatToVideoMime = INSTANCE.getDynamicRangeDefaultMimeOrThrow(dynamicRange);
            }
            if (encoderProfiles == null) {
                Logger.d(TAG, "No EncoderProfiles present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + strOutputFormatToVideoMime + ", dynamic range: " + dynamicRange + AbstractJsonLexerKt.END_LIST);
            } else {
                Logger.d(TAG, "No video EncoderProfile is compatible with requested output format and dynamic range. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + strOutputFormatToVideoMime + ", dynamic range: " + dynamicRange + AbstractJsonLexerKt.END_LIST);
            }
        }
        return new VideoMimeInfo(strOutputFormatToVideoMime, 0, next, 2, null);
    }

    public final String outputFormatToVideoMime(int outputFormat) {
        if (outputFormat == 1) {
            return "video/x-vnd.on2.vp8";
        }
        return "video/avc";
    }

    private final String getDynamicRangeDefaultMimeOrThrow(DynamicRange dynamicRange) {
        String dynamicRangeDefaultMime = getDynamicRangeDefaultMime(dynamicRange);
        if (dynamicRangeDefaultMime != null) {
            return dynamicRangeDefaultMime;
        }
        throw new UnsupportedOperationException("Unsupported dynamic range: " + dynamicRange + "\nNo supported default mime type available.");
    }

    public final String getDynamicRangeDefaultMime(DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        int encoding = dynamicRange.getEncoding();
        if (encoding == 1) {
            return "video/avc";
        }
        if (encoding == 3 || encoding == 4 || encoding == 5) {
            return "video/hevc";
        }
        if (encoding != 6) {
            return null;
        }
        return MimeTypes.VIDEO_DOLBY_VISION;
    }

    public final Set<DynamicRange> getDynamicRangesForMime(String mime) {
        Intrinsics.checkNotNullParameter(mime, "mime");
        return DynamicRangeFormatComboRegistry.INSTANCE.getDynamicRangesForVideoMime(mime);
    }

    @JvmStatic
    public static final VideoEncoderConfig resolveVideoEncoderConfig(VideoMimeInfo videoMimeInfo, Timebase inputTimebase, VideoSpec videoSpec, Size surfaceSize, DynamicRange dynamicRange, Range<Integer> expectedFrameRateRange) {
        VideoEncoderConfigDefaultResolver videoEncoderConfigDefaultResolver;
        Intrinsics.checkNotNullParameter(videoMimeInfo, "videoMimeInfo");
        Intrinsics.checkNotNullParameter(inputTimebase, "inputTimebase");
        Intrinsics.checkNotNullParameter(videoSpec, "videoSpec");
        Intrinsics.checkNotNullParameter(surfaceSize, "surfaceSize");
        Intrinsics.checkNotNullParameter(dynamicRange, "dynamicRange");
        Intrinsics.checkNotNullParameter(expectedFrameRateRange, "expectedFrameRateRange");
        if (videoMimeInfo.getCompatibleVideoProfile() != null) {
            videoEncoderConfigDefaultResolver = new VideoEncoderConfigVideoProfileResolver(videoMimeInfo.getMimeType(), inputTimebase, videoSpec, surfaceSize, videoMimeInfo.getCompatibleVideoProfile(), dynamicRange, expectedFrameRateRange);
        } else {
            videoEncoderConfigDefaultResolver = new VideoEncoderConfigDefaultResolver(videoMimeInfo.getMimeType(), inputTimebase, videoSpec, surfaceSize, dynamicRange, expectedFrameRateRange);
        }
        Object obj = videoEncoderConfigDefaultResolver.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (VideoEncoderConfig) obj;
    }

    @JvmStatic
    public static final VideoEncoderConfig workaroundDataSpaceIfRequired(VideoEncoderConfig config, boolean hasGlProcessing) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!Intrinsics.areEqual(config.getDataSpace(), VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED)) {
            return config;
        }
        MediaCodecDefaultDataSpaceQuirk mediaCodecDefaultDataSpaceQuirk = (MediaCodecDefaultDataSpaceQuirk) DeviceQuirks.get(MediaCodecDefaultDataSpaceQuirk.class);
        if (!hasGlProcessing || mediaCodecDefaultDataSpaceQuirk == null) {
            return config;
        }
        VideoEncoderDataSpace suggestedDataSpace = mediaCodecDefaultDataSpaceQuirk.getSuggestedDataSpace();
        Intrinsics.checkNotNullExpressionValue(suggestedDataSpace, "getSuggestedDataSpace(...)");
        VideoEncoderConfig videoEncoderConfigBuild = config.toBuilder().setDataSpace(suggestedDataSpace).build();
        Intrinsics.checkNotNullExpressionValue(videoEncoderConfigBuild, "build(...)");
        return videoEncoderConfigBuild;
    }

    @JvmStatic
    public static final int scaleBitrate(int baseBitrate, int actualBitDepth, int baseBitDepth, int actualFrameRate, int baseFrameRate, int actualWidth, int baseWidth, int actualHeight, int baseHeight) {
        String str;
        int iDoubleValue = (int) (((double) baseBitrate) * new Rational(actualBitDepth, baseBitDepth).doubleValue() * new Rational(actualFrameRate, baseFrameRate).doubleValue() * new Rational(actualWidth, baseWidth).doubleValue() * new Rational(actualHeight, baseHeight).doubleValue());
        if (Logger.isDebugEnabled(TAG)) {
            str = "Base Bitrate(" + baseBitrate + "bps) * Bit Depth Ratio (" + actualBitDepth + " / " + baseBitDepth + ") * Frame Rate Ratio(" + actualFrameRate + " / " + baseFrameRate + ") * Width Ratio(" + actualWidth + " / " + baseWidth + ") * Height Ratio(" + actualHeight + " / " + baseHeight + ") = " + iDoubleValue;
        } else {
            str = "";
        }
        Logger.d(TAG, str);
        return iDoubleValue;
    }

    public final VideoEncoderDataSpace mimeAndProfileToEncoderDataSpace(String mimeType, int codecProfileLevel) {
        VideoEncoderDataSpace videoEncoderDataSpace;
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Map<Integer, VideoEncoderDataSpace> map = MIME_TO_DATA_SPACE_MAP.get(mimeType);
        if (map != null && (videoEncoderDataSpace = map.get(Integer.valueOf(codecProfileLevel))) != null) {
            return videoEncoderDataSpace;
        }
        Logger.w(TAG, "Unsupported mime type " + mimeType + " or profile level " + codecProfileLevel + ". Data space is unspecified.");
        VideoEncoderDataSpace ENCODER_DATA_SPACE_UNSPECIFIED = VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
        Intrinsics.checkNotNullExpressionValue(ENCODER_DATA_SPACE_UNSPECIFIED, "ENCODER_DATA_SPACE_UNSPECIFIED");
        return ENCODER_DATA_SPACE_UNSPECIFIED;
    }

    public final CaptureEncodeRates resolveFrameRates$camera_video(VideoSpec videoSpec, Range<Integer> expectedCaptureFrameRateRange) {
        int iIntValue;
        String strValueOf;
        Intrinsics.checkNotNullParameter(videoSpec, "videoSpec");
        Intrinsics.checkNotNullParameter(expectedCaptureFrameRateRange, "expectedCaptureFrameRateRange");
        if (Intrinsics.areEqual(expectedCaptureFrameRateRange, SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED)) {
            iIntValue = 30;
        } else {
            Object upper = expectedCaptureFrameRateRange.getUpper();
            Intrinsics.checkNotNull(upper);
            iIntValue = ((Number) upper).intValue();
        }
        int encodeFrameRate = videoSpec.getEncodeFrameRate() != 0 ? videoSpec.getEncodeFrameRate() : iIntValue;
        StringBuilder sb = new StringBuilder("Resolved capture/encode frame rate ");
        sb.append(iIntValue);
        sb.append("fps/");
        sb.append(encodeFrameRate);
        sb.append("fps, [Expected operating range: ");
        if (Intrinsics.areEqual(expectedCaptureFrameRateRange, SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED)) {
            strValueOf = "<UNSPECIFIED>";
        } else {
            strValueOf = String.valueOf(expectedCaptureFrameRateRange);
        }
        sb.append(strValueOf);
        sb.append(AbstractJsonLexerKt.END_LIST);
        Logger.d(TAG, sb.toString());
        return new CaptureEncodeRates(iIntValue, encodeFrameRate);
    }
}
