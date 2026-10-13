package com.amazonaws.ivs.player;

import android.media.MediaCodecInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.gms.cast.MediaError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class VideoCapabilities {
    public static final float DEFAULT_PLAYBACK_RATE = 1.0f;
    public static final float MAX_PLAYBACK_RATE = 2.0f;
    boolean isSoftware;
    int maxBitrate;
    int maxFramerate;
    int maxHeight;
    int maxInstances;
    int maxLevel;
    int maxProfile;
    int maxWidth;
    private static final float[] PLAYBACK_RATES = {2.0f, 1.5f, 1.0f};
    private static final Map<String, VideoCapabilities> CAPABILITIES = new HashMap();
    private static final Map<String, MediaCodecInfo> MEDIACODEC_CAPABILITIES = new HashMap();
    private static final Map<String, Boolean> SUPPORTED_TYPES = new HashMap();

    private static int av1LevelIndicationFromOMX(int i) {
        switch (i) {
            case 2:
                return 1;
            case 4:
                return 2;
            case 8:
                return 3;
            case 16:
                return 4;
            case 32:
                return 5;
            case 64:
                return 6;
            case 128:
                return 7;
            case 256:
                return 8;
            case 512:
                return 9;
            case 1024:
                return 10;
            case 2048:
                return 11;
            case 4096:
                return 12;
            case 8192:
                return 13;
            case 16384:
                return 14;
            case 32768:
                return 15;
            case 65536:
                return 16;
            case 131072:
                return 17;
            case 262144:
                return 18;
            case 524288:
                return 19;
            case 1048576:
                return 20;
            case 2097152:
                return 21;
            case 4194304:
                return 22;
            case 8388608:
                return 23;
            default:
                return 0;
        }
    }

    private static int av1ProfileIndicationFromOMX(int i) {
        return 0;
    }

    private static int avcLevelIndicationFromOMX(int i) {
        if (i == 1) {
            return 10;
        }
        if (i == 2) {
            return 9;
        }
        switch (i) {
            case 4:
                return 11;
            case 8:
                return 12;
            case 16:
                return 13;
            case 32:
                return 20;
            case 64:
                return 21;
            case 128:
                return 22;
            case 256:
                return 30;
            case 512:
                return 31;
            case 1024:
                return 32;
            case 2048:
                return 40;
            case 4096:
                return 41;
            case 16384:
                return 50;
            case 32768:
                return 51;
            case 65536:
                return 52;
            case 131072:
                return 60;
            case 262144:
                return 61;
            case 524288:
                return 62;
            default:
                return 42;
        }
    }

    private static int avcProfileIndicationFromOMX(int i) {
        if (i == 1) {
            return 66;
        }
        if (i == 4) {
            return 88;
        }
        if (i == 8) {
            return 100;
        }
        if (i == 16) {
            return MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE;
        }
        if (i != 32) {
            return i != 64 ? 77 : 244;
        }
        return 122;
    }

    private static int hevcLevelIndicationFromOMX(int i) {
        switch (i) {
            case 4:
            case 8:
                return 60;
            case 16:
            case 32:
                return 63;
            case 64:
            case 128:
                return 90;
            case 256:
            case 512:
                return 93;
            case 1024:
            case 2048:
                return TimeseriesConfiguration.DEFAULT_BUFFER_SIZE;
            case 4096:
            case 8192:
                return 123;
            case 16384:
            case 32768:
                return 150;
            case 65536:
            case 131072:
                return 153;
            case 262144:
            case 524288:
                return WebmConstants.MkvEbmlElement.FLAG_LACING;
            case 1048576:
            case 2097152:
                return RotationOptions.ROTATE_180;
            case 4194304:
            case 8388608:
                return WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS;
            case 16777216:
            case GroupFlagsKt.HasAuxSlotFlag /* 33554432 */:
                return WebmConstants.MkvEbmlElement.PIXEL_HEIGHT;
            default:
                return 30;
        }
    }

    private static int hevcProfileIndicationFromOMX(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i == 4) {
                    return 3;
                }
                if (i != 4096 && i != 8192) {
                    return 0;
                }
            }
        }
        return i2;
    }

    private static int vp9LevelIndicationFromOMX(int i) {
        if (i == 1) {
            return 10;
        }
        if (i == 2) {
            return 11;
        }
        if (i == 4) {
            return 20;
        }
        if (i == 8) {
            return 21;
        }
        if (i == 16) {
            return 30;
        }
        if (i == 32) {
            return 31;
        }
        if (i == 64) {
            return 40;
        }
        if (i == 128) {
            return 41;
        }
        if (i == 256) {
            return 50;
        }
        if (i == 2048) {
            return 60;
        }
        if (i != 4096) {
            return i != 8192 ? 51 : 62;
        }
        return 61;
    }

    private static int vp9ProfileIndicationFromOMX(int i) {
        if (i == 2) {
            return 1;
        }
        if (i != 4) {
            if (i == 8) {
                return 3;
            }
            if (i != 4096) {
                return i != 8192 ? 0 : 3;
            }
        }
        return 2;
    }

    private VideoCapabilities() {
    }

    public static boolean isSoftwareCodec(MediaCodecInfo mediaCodecInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            return !mediaCodecInfo.isHardwareAccelerated();
        }
        String lowerCase = mediaCodecInfo.getName().toLowerCase();
        return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
    }

    public static synchronized boolean isTypeSupported(String str) {
        if (str.equalsIgnoreCase("video/avc")) {
            return true;
        }
        Boolean bool = SUPPORTED_TYPES.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        for (MediaCodecInfo mediaCodecInfo : MediaCodecFactory.findSupportedCodecs(str, false)) {
            if (!mediaCodecInfo.isEncoder() && !isSoftwareCodec(mediaCodecInfo)) {
                SUPPORTED_TYPES.put(str, true);
                return true;
            }
        }
        SUPPORTED_TYPES.put(str, false);
        return false;
    }

    public static float getMaxPlaybackRateForQuality(String str, Quality quality) {
        if (quality == null || TextUtils.isEmpty(str)) {
            Logging.e("getMaxPlaybackRateForQuality: invalid parameters");
            return 1.0f;
        }
        MediaCodecInfo mediaCodecInfo = getMediaCodecInfo(str);
        if (mediaCodecInfo != null && quality.getFramerate() > 1.0f) {
            MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities();
            for (float f : PLAYBACK_RATES) {
                if (videoCapabilities.areSizeAndRateSupported(quality.getWidth(), quality.getHeight(), quality.getFramerate() * f)) {
                    return f;
                }
            }
        } else if (Float.compare(quality.getFramerate(), 0.0f) == 0 && Float.compare(quality.getWidth(), 0.0f) == 0 && Float.compare(quality.getHeight(), 0.0f) == 0) {
            return 2.0f;
        }
        return 1.0f;
    }

    public static VideoCapabilities getCapabilities(String str) {
        Map<String, VideoCapabilities> map = CAPABILITIES;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        VideoCapabilities videoCapabilities = new VideoCapabilities();
        videoCapabilities.maxBitrate = Integer.MAX_VALUE;
        videoCapabilities.maxWidth = 1920;
        videoCapabilities.maxHeight = 1280;
        videoCapabilities.maxFramerate = 30;
        videoCapabilities.maxProfile = 100;
        videoCapabilities.maxLevel = 42;
        videoCapabilities.maxInstances = 1;
        MediaCodecInfo mediaCodecInfo = getMediaCodecInfo(str);
        if (mediaCodecInfo != null) {
            videoCapabilities.setVideoCapabilities(str, mediaCodecInfo);
        }
        map.put(str, videoCapabilities);
        return videoCapabilities;
    }

    private static MediaCodecInfo getMediaCodecInfo(String str) {
        Map<String, MediaCodecInfo> map = MEDIACODEC_CAPABILITIES;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        for (MediaCodecInfo mediaCodecInfo : MediaCodecFactory.findSupportedCodecs(str, false)) {
            if (!mediaCodecInfo.isEncoder() && !isSoftwareCodec(mediaCodecInfo)) {
                Logging.d("Selected hardware decoder for " + str + ": " + mediaCodecInfo.getName());
                MEDIACODEC_CAPABILITIES.put(str, mediaCodecInfo);
                return mediaCodecInfo;
            }
        }
        mediaCodecInfo = null;
        MEDIACODEC_CAPABILITIES.put(str, mediaCodecInfo);
        return mediaCodecInfo;
    }

    private void setVideoCapabilities(String str, MediaCodecInfo mediaCodecInfo) {
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
        this.maxBitrate = ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
        this.maxWidth = ((Integer) videoCapabilities.getSupportedWidths().getUpper()).intValue();
        this.maxHeight = ((Integer) videoCapabilities.getSupportedHeights().getUpper()).intValue();
        this.maxFramerate = ((Integer) videoCapabilities.getSupportedFrameRates().getUpper()).intValue();
        this.maxInstances = capabilitiesForType.getMaxSupportedInstances();
        if (MediaCodecFactory.limitMaxDecodeSize(mediaCodecInfo.getName())) {
            this.maxWidth = 1920;
            this.maxHeight = 1088;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < capabilitiesForType.profileLevels.length; i3++) {
            int i4 = capabilitiesForType.profileLevels[i3].profile;
            int i5 = capabilitiesForType.profileLevels[i3].level;
            if (i4 > i && (!str.equals("video/avc") || i4 <= 64)) {
                i = i4;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        if (str.equals("video/avc")) {
            if (i == 0) {
                i = 8;
            }
            if (i2 == 0) {
                i2 = 8192;
            }
        } else if (str.equals("video/x-vnd.on2.vp9")) {
            if (i == 0) {
                i = 1;
            }
            if (i2 == 0) {
                i2 = 128;
            }
        } else if (str.equals("video/av01") && i2 == 0) {
            i2 = 2;
        }
        if (str.equals("video/avc")) {
            this.maxProfile = avcProfileIndicationFromOMX(i);
            this.maxLevel = avcLevelIndicationFromOMX(i2);
            return;
        }
        if (str.equals("video/x-vnd.on2.vp9")) {
            this.maxProfile = vp9ProfileIndicationFromOMX(i);
            this.maxLevel = vp9LevelIndicationFromOMX(i2);
            this.isSoftware = isSoftwareCodec(mediaCodecInfo);
            Logging.d("VP9 decoder " + mediaCodecInfo.getName() + " isSoftware: " + this.isSoftware);
            return;
        }
        if (str.equals("video/av01")) {
            this.maxProfile = av1ProfileIndicationFromOMX(i);
            this.maxLevel = av1LevelIndicationFromOMX(i2);
        } else if (str.equals("video/hevc")) {
            this.maxProfile = hevcProfileIndicationFromOMX(i);
            this.maxLevel = hevcLevelIndicationFromOMX(i2);
            this.isSoftware = isSoftwareCodec(mediaCodecInfo);
            Logging.d("HEVC decoder " + mediaCodecInfo.getName() + " isSoftware: " + this.isSoftware);
        }
    }

    public int getMaxBitrate() {
        return this.maxBitrate;
    }

    public int getMaxFramerate() {
        return this.maxFramerate;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxProfile() {
        return this.maxProfile;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public int getMaxInstances() {
        return this.maxInstances;
    }

    public String toString() {
        return "maxBitrate=" + this.maxBitrate + ", maxFramerate=" + this.maxFramerate + ", maxWidth=" + this.maxWidth + ", maxHeight=" + this.maxHeight + ", maxProfile=" + this.maxProfile + ", maxLevel=" + this.maxLevel;
    }
}
