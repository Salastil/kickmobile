package androidx.camera.video.internal.config;

import android.util.Rational;
import androidx.camera.core.Logger;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.core.util.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioSettingsDefaultResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/camera/video/internal/config/AudioSettingsDefaultResolver;", "Landroidx/core/util/Supplier;", "Landroidx/camera/video/internal/audio/AudioSettings;", "audioSpec", "Landroidx/camera/video/AudioSpec;", "captureToEncodeRatio", "Landroid/util/Rational;", "<init>", "(Landroidx/camera/video/AudioSpec;Landroid/util/Rational;)V", "get", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioSettingsDefaultResolver implements Supplier<AudioSettings> {
    private static final String TAG = "DefAudioResolver";
    private final AudioSpec audioSpec;
    private final Rational captureToEncodeRatio;

    public AudioSettingsDefaultResolver(AudioSpec audioSpec, Rational rational) {
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        this.audioSpec = audioSpec;
        this.captureToEncodeRatio = rational;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public AudioSettings get() {
        int iResolveAudioSource = AudioConfigUtil.INSTANCE.resolveAudioSource(this.audioSpec);
        int iResolveAudioSourceFormat = AudioConfigUtil.INSTANCE.resolveAudioSourceFormat(this.audioSpec);
        int channelCount = this.audioSpec.getChannelCount();
        if (channelCount == -1) {
            Logger.d(TAG, "Using fallback AUDIO channel count: 1");
            channelCount = 1;
        } else {
            Logger.d(TAG, "Using supplied AUDIO channel count: " + channelCount);
        }
        int sampleRate = this.audioSpec.getSampleRate();
        if (sampleRate == 0) {
            sampleRate = 44100;
        }
        CaptureEncodeRates captureEncodeRatesResolveSampleRates$camera_video = AudioConfigUtil.INSTANCE.resolveSampleRates$camera_video(sampleRate, channelCount, iResolveAudioSourceFormat, this.captureToEncodeRatio);
        Logger.d(TAG, "Using AUDIO sample rate resolved from AudioSpec: Capture sample rate: " + captureEncodeRatesResolveSampleRates$camera_video.getCaptureRate() + "Hz. Encode sample rate: " + captureEncodeRatesResolveSampleRates$camera_video.getEncodeRate() + "Hz.");
        AudioSettings audioSettingsBuild = AudioSettings.builder().setAudioSource(iResolveAudioSource).setAudioFormat(iResolveAudioSourceFormat).setChannelCount(channelCount).setCaptureSampleRate(captureEncodeRatesResolveSampleRates$camera_video.getCaptureRate()).setEncodeSampleRate(captureEncodeRatesResolveSampleRates$camera_video.getEncodeRate()).build();
        Intrinsics.checkNotNullExpressionValue(audioSettingsBuild, "build(...)");
        return audioSettingsBuild;
    }
}
