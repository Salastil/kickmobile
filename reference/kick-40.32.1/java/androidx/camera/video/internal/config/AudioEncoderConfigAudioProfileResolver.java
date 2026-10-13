package androidx.camera.video.internal.config;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioEncoderConfigAudioProfileResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/camera/video/internal/config/AudioEncoderConfigAudioProfileResolver;", "Landroidx/core/util/Supplier;", "Landroidx/camera/video/internal/encoder/AudioEncoderConfig;", "mimeType", "", "audioProfile", "", "inputTimebase", "Landroidx/camera/core/impl/Timebase;", "audioSpec", "Landroidx/camera/video/AudioSpec;", "audioSettings", "Landroidx/camera/video/internal/audio/AudioSettings;", "audioProfileProxy", "Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;", "<init>", "(Ljava/lang/String;ILandroidx/camera/core/impl/Timebase;Landroidx/camera/video/AudioSpec;Landroidx/camera/video/internal/audio/AudioSettings;Landroidx/camera/core/impl/EncoderProfilesProxy$AudioProfileProxy;)V", "get", "Companion", "camera-video"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioEncoderConfigAudioProfileResolver implements Supplier<AudioEncoderConfig> {
    private static final String TAG = "AudioEncAdPrflRslvr";
    private final int audioProfile;
    private final EncoderProfilesProxy.AudioProfileProxy audioProfileProxy;
    private final AudioSettings audioSettings;
    private final AudioSpec audioSpec;
    private final Timebase inputTimebase;
    private final String mimeType;

    public AudioEncoderConfigAudioProfileResolver(String mimeType, int i, Timebase inputTimebase, AudioSpec audioSpec, AudioSettings audioSettings, EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(inputTimebase, "inputTimebase");
        Intrinsics.checkNotNullParameter(audioSpec, "audioSpec");
        Intrinsics.checkNotNullParameter(audioSettings, "audioSettings");
        Intrinsics.checkNotNullParameter(audioProfileProxy, "audioProfileProxy");
        this.mimeType = mimeType;
        this.audioProfile = i;
        this.inputTimebase = inputTimebase;
        this.audioSpec = audioSpec;
        this.audioSettings = audioSettings;
        this.audioProfileProxy = audioProfileProxy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    public AudioEncoderConfig get() {
        int bitrate = this.audioSpec.getBitrate();
        if (bitrate == 0) {
            Logger.d(TAG, "Using resolved AUDIO bitrate from AudioProfile");
            bitrate = AudioConfigUtil.INSTANCE.scaleBitrate(this.audioProfileProxy.getBitrate(), this.audioSettings.getChannelCount(), this.audioProfileProxy.getChannels(), this.audioSettings.getEncodeSampleRate(), this.audioProfileProxy.getSampleRate());
        }
        AudioEncoderConfig audioEncoderConfigBuild = AudioEncoderConfig.builder().setMimeType(this.mimeType).setProfile(this.audioProfile).setInputTimebase(this.inputTimebase).setChannelCount(this.audioSettings.getChannelCount()).setCaptureSampleRate(this.audioSettings.getCaptureSampleRate()).setEncodeSampleRate(this.audioSettings.getEncodeSampleRate()).setBitrate(bitrate).build();
        Intrinsics.checkNotNullExpressionValue(audioEncoderConfigBuild, "build(...)");
        return audioEncoderConfigBuild;
    }
}
