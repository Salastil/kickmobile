package androidx.camera.video.internal.config;

import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AudioConfigUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\"\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J(\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u000e\u0010(\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010)\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 J\u001e\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007J.\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J/\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"H\u0000¢\u0006\u0002\b7R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/camera/video/internal/config/AudioConfigUtil;", "", "<init>", "()V", "TAG", "", "AUDIO_SAMPLE_RATE_DEFAULT", "", "AUDIO_CHANNEL_COUNT_DEFAULT", "AUDIO_SOURCE_FORMAT_DEFAULT", "AUDIO_SOURCE_DEFAULT", "AAC_DEFAULT_PROFILE", "AUDIO_ENCODER_MIME_MPEG4_DEFAULT", "AUDIO_ENCODER_MIME_WEBM_DEFAULT", "resolveCompatibleAudioProfile", "Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;", "audioMime", "audioProfiles", "", "outputFormatToAudioMime", "outputFormat", "audioMimeToAudioProfile", "resolveAudioMimeInfo", "Landroidx/camera/video/internal/config/AudioMimeInfo;", "mediaSpec", "Landroidx/camera/video/MediaSpec;", "encoderProfiles", "Landroidx/camera/video/internal/VideoValidatedEncoderProfilesProxy;", "resolveAudioSettings", "Landroidx/camera/video/internal/audio/AudioSettings;", "audioMimeInfo", "audioSpec", "Landroidx/camera/video/AudioSpec;", "captureToEncodeRatio", "Landroid/util/Rational;", "resolveAudioEncoderConfig", "Landroidx/camera/video/internal/encoder/AudioEncoderConfig;", "inputTimebase", "Landroidx/camera/core/impl/Timebase;", "audioSettings", "resolveAudioSource", "resolveAudioSourceFormat", "selectSampleRateOrNearestSupported", "channelCount", "sourceFormat", "initialTargetSampleRate", "scaleBitrate", "baseBitrate", "actualChannelCount", "baseChannelCount", "actualSampleRate", "baseSampleRate", "resolveSampleRates", "Landroidx/camera/video/internal/config/CaptureEncodeRates;", "targetEncodeSampleRate", "resolveSampleRates$camera_video", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioConfigUtil {
    private static final int AAC_DEFAULT_PROFILE = 2;
    public static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    private static final String AUDIO_ENCODER_MIME_MPEG4_DEFAULT = "audio/mp4a-latm";
    private static final String AUDIO_ENCODER_MIME_WEBM_DEFAULT = "audio/vorbis";
    public static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    public static final int AUDIO_SOURCE_DEFAULT = 5;
    public static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    public static final AudioConfigUtil INSTANCE = new AudioConfigUtil();
    private static final String TAG = "AudioConfigUtil";

    private AudioConfigUtil() {
    }

    public final EncoderProfilesProxy.AudioProfileProxy resolveCompatibleAudioProfile(String audioMime, List<? extends EncoderProfilesProxy.AudioProfileProxy> audioProfiles) {
        Object next;
        Intrinsics.checkNotNullParameter(audioMime, "audioMime");
        Intrinsics.checkNotNullParameter(audioProfiles, "audioProfiles");
        int iAudioMimeToAudioProfile = audioMimeToAudioProfile(audioMime);
        Iterator<T> it = audioProfiles.iterator();
        while (it.hasNext()) {
            next = it.next();
            EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = (EncoderProfilesProxy.AudioProfileProxy) next;
            if (Intrinsics.areEqual(audioMime, AudioSpec.MIME_TYPE_UNSPECIFIED) || (Intrinsics.areEqual(audioProfileProxy.getMediaType(), audioMime) && audioProfileProxy.getProfile() == iAudioMimeToAudioProfile)) {
                return (EncoderProfilesProxy.AudioProfileProxy) next;
            }
        }
        next = null;
        return (EncoderProfilesProxy.AudioProfileProxy) next;
    }

    public final String outputFormatToAudioMime(int outputFormat) {
        if (outputFormat == 1) {
            return "audio/vorbis";
        }
        return "audio/mp4a-latm";
    }

    public final int audioMimeToAudioProfile(String audioMime) {
        Intrinsics.checkNotNullParameter(audioMime, "audioMime");
        return Intrinsics.areEqual(audioMime, "audio/mp4a-latm") ? 2 : -1;
    }

    @JvmStatic
    public static final AudioMimeInfo resolveAudioMimeInfo(MediaSpec mediaSpec, VideoValidatedEncoderProfilesProxy encoderProfiles) {
        EncoderProfilesProxy.AudioProfileProxy defaultAudioProfile;
        Intrinsics.checkNotNullParameter(mediaSpec, "mediaSpec");
        String strOutputFormatToAudioMime = MediaSpec.INSTANCE.outputFormatToAudioMime(mediaSpec.getOutputFormat());
        int iOutputFormatToAudioProfile = MediaSpec.INSTANCE.outputFormatToAudioProfile(mediaSpec.getOutputFormat());
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy = null;
        if (encoderProfiles != null && (defaultAudioProfile = encoderProfiles.getDefaultAudioProfile()) != null) {
            String mediaType = defaultAudioProfile.getMediaType();
            Intrinsics.checkNotNullExpressionValue(mediaType, "getMediaType(...)");
            int profile = defaultAudioProfile.getProfile();
            if (Intrinsics.areEqual(mediaType, EncoderProfilesProxy.AudioProfileProxy.MEDIA_TYPE_NONE)) {
                Logger.d(TAG, "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: " + strOutputFormatToAudioMime + "(profile: " + iOutputFormatToAudioProfile + ")]");
            } else if (mediaSpec.getOutputFormat() == -1) {
                Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_UNSPECIFIED. Using EncoderProfiles to derive AUDIO settings [mime type: " + mediaType + "(profile: " + profile + ")]");
                audioProfileProxy = defaultAudioProfile;
                strOutputFormatToAudioMime = mediaType;
                iOutputFormatToAudioProfile = profile;
            } else if (Intrinsics.areEqual(strOutputFormatToAudioMime, mediaType) && iOutputFormatToAudioProfile == profile) {
                Logger.d(TAG, "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: " + mediaType + "(profile: " + iOutputFormatToAudioProfile + ")]");
                audioProfileProxy = defaultAudioProfile;
                strOutputFormatToAudioMime = mediaType;
            } else {
                Logger.d(TAG, "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: " + mediaType + "(profile: " + profile + "), chosen mime type: " + strOutputFormatToAudioMime + "(profile: " + iOutputFormatToAudioProfile + ")]");
            }
        }
        return new AudioMimeInfo(strOutputFormatToAudioMime, iOutputFormatToAudioProfile, audioProfileProxy);
    }

    @JvmStatic
    public static final AudioSettings resolveAudioSettings(AudioMimeInfo audioMimeInfo, AudioSpec audioSpec, Rational captureToEncodeRatio) {
        AudioSettingsDefaultResolver audioSettingsDefaultResolver;
        Intrinsics.checkNotNullParameter(audioMimeInfo, "audioMimeInfo");
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        if (audioMimeInfo.getCompatibleAudioProfile() != null) {
            audioSettingsDefaultResolver = new AudioSettingsAudioProfileResolver(audioSpec, audioMimeInfo.getCompatibleAudioProfile(), captureToEncodeRatio);
        } else {
            audioSettingsDefaultResolver = new AudioSettingsDefaultResolver(audioSpec, captureToEncodeRatio);
        }
        Object obj = audioSettingsDefaultResolver.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (AudioSettings) obj;
    }

    @JvmStatic
    public static final AudioEncoderConfig resolveAudioEncoderConfig(AudioMimeInfo audioMimeInfo, Timebase inputTimebase, AudioSettings audioSettings, AudioSpec audioSpec) {
        AudioEncoderConfigDefaultResolver audioEncoderConfigDefaultResolver;
        Intrinsics.checkNotNullParameter(audioMimeInfo, "audioMimeInfo");
        Intrinsics.checkNotNullParameter(inputTimebase, "inputTimebase");
        Intrinsics.checkNotNullParameter(audioSettings, "audioSettings");
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        if (audioMimeInfo.getCompatibleAudioProfile() != null) {
            audioEncoderConfigDefaultResolver = new AudioEncoderConfigAudioProfileResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), inputTimebase, audioSpec, audioSettings, audioMimeInfo.getCompatibleAudioProfile());
        } else {
            audioEncoderConfigDefaultResolver = new AudioEncoderConfigDefaultResolver(audioMimeInfo.getMimeType(), audioMimeInfo.getProfile(), inputTimebase, audioSpec, audioSettings);
        }
        Object obj = audioEncoderConfigDefaultResolver.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return (AudioEncoderConfig) obj;
    }

    public final int resolveAudioSource(AudioSpec audioSpec) {
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        int source = audioSpec.getSource();
        if (source == -1) {
            Logger.d(TAG, "Using default AUDIO source: 5");
            return 5;
        }
        Logger.d(TAG, "Using provided AUDIO source: " + source);
        return source;
    }

    public final int resolveAudioSourceFormat(AudioSpec audioSpec) {
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        int sourceFormat = audioSpec.getSourceFormat();
        if (sourceFormat == -1) {
            Logger.d(TAG, "Using default AUDIO source format: 2");
            return 2;
        }
        Logger.d(TAG, "Using provided AUDIO source format: " + sourceFormat);
        return sourceFormat;
    }

    public final int selectSampleRateOrNearestSupported(int channelCount, int sourceFormat, final int initialTargetSampleRate) {
        ArrayList arrayList = null;
        int i = 0;
        int iIntValue = initialTargetSampleRate;
        while (!AudioSource.isSettingsSupported(iIntValue, channelCount, sourceFormat)) {
            Logger.d(TAG, "Sample rate " + iIntValue + " Hz is not supported by audio source with channel count " + channelCount + " and source format " + sourceFormat);
            if (arrayList == null) {
                Logger.d(TAG, "Trying common sample rates in proximity order to target " + initialTargetSampleRate + " Hz");
                arrayList = new ArrayList(AudioSettings.COMMON_SAMPLE_RATES);
                final Function2 function2 = new Function2() { // from class: androidx.camera.video.internal.config.AudioConfigUtil$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return Integer.valueOf(AudioConfigUtil.selectSampleRateOrNearestSupported$lambda$0(initialTargetSampleRate, ((Integer) obj).intValue(), ((Integer) obj2).intValue()));
                    }
                };
                CollectionsKt.sortWith(arrayList, new Comparator() { // from class: androidx.camera.video.internal.config.AudioConfigUtil$$ExternalSyntheticLambda1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ((Number) function2.invoke(obj, obj2)).intValue();
                    }
                });
            }
            if (i < arrayList.size()) {
                iIntValue = ((Number) arrayList.get(i)).intValue();
                i++;
            } else {
                Logger.d(TAG, "No sample rate found or supported by audio source. Falling back to default sample rate of 44100 Hz");
                return 44100;
            }
        }
        return iIntValue;
    }

    static final int selectSampleRateOrNearestSupported$lambda$0(int i, int i2, int i3) {
        int iAbs = Math.abs(i2 - i) - Math.abs(i3 - i);
        if (iAbs == 0) {
            return MathKt.getSign(i2 - i3);
        }
        return MathKt.getSign(iAbs);
    }

    public final int scaleBitrate(int baseBitrate, int actualChannelCount, int baseChannelCount, int actualSampleRate, int baseSampleRate) {
        String str;
        int iDoubleValue = (int) (((double) baseBitrate) * new Rational(actualChannelCount, baseChannelCount).doubleValue() * new Rational(actualSampleRate, baseSampleRate).doubleValue());
        if (!Logger.isDebugEnabled(TAG)) {
            str = "";
        } else {
            str = "Base Bitrate(" + baseBitrate + "bps) * Channel Count Ratio(" + actualChannelCount + " / " + baseChannelCount + ") * Sample Rate Ratio(" + actualSampleRate + " / " + baseSampleRate + ") = " + iDoubleValue;
        }
        Logger.d(TAG, str);
        return iDoubleValue;
    }

    public final CaptureEncodeRates resolveSampleRates$camera_video(int targetEncodeSampleRate, int channelCount, int sourceFormat, Rational captureToEncodeRatio) {
        int iSelectSampleRateOrNearestSupported;
        int encodeRate;
        if (captureToEncodeRatio == null) {
            iSelectSampleRateOrNearestSupported = selectSampleRateOrNearestSupported(channelCount, sourceFormat, targetEncodeSampleRate);
            encodeRate = iSelectSampleRateOrNearestSupported;
        } else {
            iSelectSampleRateOrNearestSupported = selectSampleRateOrNearestSupported(channelCount, sourceFormat, CaptureEncodeRatesKt.toCaptureRate(targetEncodeSampleRate, captureToEncodeRatio));
            encodeRate = CaptureEncodeRatesKt.toEncodeRate(iSelectSampleRateOrNearestSupported, captureToEncodeRatio);
        }
        Logger.d(TAG, "Resolved capture/encode sample rate " + iSelectSampleRateOrNearestSupported + "Hz/" + encodeRate + "Hz, [target sample rate: " + targetEncodeSampleRate + ", channel count: " + channelCount + ", source format: " + sourceFormat + ", capture to encode sample rate ratio: " + captureToEncodeRatio + AbstractJsonLexerKt.END_LIST);
        return new CaptureEncodeRates(iSelectSampleRateOrNearestSupported, encodeRate);
    }
}
