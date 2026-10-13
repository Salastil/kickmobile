package androidx.camera.video.internal.config;

import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AudioSettingsAudioProfileResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/video/internal/config/AudioSettingsAudioProfileResolver;", "Landroidx/core/util/Supplier;", "Landroidx/camera/video/internal/audio/AudioSettings;", "audioSpec", "Landroidx/camera/video/AudioSpec;", "audioProfile", "Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;", "captureToEncodeRatio", "Landroid/util/Rational;", "<init>", "(Landroidx/camera/video/AudioSpec;Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;Landroid/util/Rational;)V", "get", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSettingsAudioProfileResolver implements Supplier<AudioSettings> {
    private static final String TAG = "AudioSrcAdPrflRslvr";
    private final EncoderProfilesProxy.AudioProfileProxy audioProfile;
    private final AudioSpec audioSpec;
    private final Rational captureToEncodeRatio;

    public AudioSettingsAudioProfileResolver(AudioSpec audioSpec, EncoderProfilesProxy.AudioProfileProxy audioProfile, Rational rational) {
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        Intrinsics.checkNotNullParameter(audioProfile, "audioProfile");
        this.audioSpec = audioSpec;
        this.audioProfile = audioProfile;
        this.captureToEncodeRatio = rational;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public AudioSettings get() {
        int iResolveAudioSource = AudioConfigUtil.INSTANCE.resolveAudioSource(this.audioSpec);
        int iResolveAudioSourceFormat = AudioConfigUtil.INSTANCE.resolveAudioSourceFormat(this.audioSpec);
        int channelCount = this.audioSpec.getChannelCount();
        int channels = this.audioProfile.getChannels();
        if (channelCount == -1) {
            Logger.d(TAG, "Resolved AUDIO channel count from AudioProfile: " + channels);
            channelCount = channels;
        } else {
            Logger.d(TAG, "Media spec AUDIO channel count overrides AudioProfile [AudioProfile channel count: " + channels + ", Resolved Channel Count: " + channelCount + AbstractJsonLexerKt.END_LIST);
        }
        int sampleRate = this.audioSpec.getSampleRate();
        int sampleRate2 = this.audioProfile.getSampleRate();
        if (sampleRate == 0) {
            sampleRate = sampleRate2;
        }
        CaptureEncodeRates captureEncodeRatesResolveSampleRates$camera_video = AudioConfigUtil.INSTANCE.resolveSampleRates$camera_video(sampleRate, channelCount, iResolveAudioSourceFormat, this.captureToEncodeRatio);
        Logger.d(TAG, "Using resolved AUDIO sample rate or nearest supported from AudioProfile: Capture sample rate: " + captureEncodeRatesResolveSampleRates$camera_video.getCaptureRate() + "Hz. Encode sample rate: " + captureEncodeRatesResolveSampleRates$camera_video.getEncodeRate() + "Hz. [AudioProfile sample rate: " + sampleRate2 + "Hz]");
        AudioSettings audioSettingsBuild = AudioSettings.builder().setAudioSource(iResolveAudioSource).setAudioFormat(iResolveAudioSourceFormat).setChannelCount(channelCount).setCaptureSampleRate(captureEncodeRatesResolveSampleRates$camera_video.getCaptureRate()).setEncodeSampleRate(captureEncodeRatesResolveSampleRates$camera_video.getEncodeRate()).build();
        Intrinsics.checkNotNullExpressionValue(audioSettingsBuild, "build(...)");
        return audioSettingsBuild;
    }
}
