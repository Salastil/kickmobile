package com.amazonaws.ivs.player;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.Process;
import android.os.Trace;
import androidx.work.PeriodicWorkRequest;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
class AudioTrackRenderer implements MediaRenderer, AudioRenderer {
    private static final int BUFFERS = 2;
    private static final int MAX_PLAYBACK_RATE = 2;
    private int audioSessionId;
    private int bufferSize;
    private int bytesWritten;
    private MediaFormat format;
    private int frameSizeBytes;
    private long framesWritten;
    private int maxPlaybackRate;
    private boolean outOfSync;
    private float playbackRate;
    private long playheadBasePosition;
    private long playheadPrevPosition;
    private long sampleTimeUs;
    private long startMediaTimeUs;
    private long startSystemTimeNs;
    private boolean started;
    private AudioTrack track;
    private float volume;

    private static int createChannelConfig(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                return 6396;
            default:
                return 1;
        }
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public boolean shouldProcessMore() {
        return true;
    }

    AudioTrackRenderer() {
        this(2);
    }

    AudioTrackRenderer(int i) {
        this.volume = 1.0f;
        this.playbackRate = 1.0f;
        this.outOfSync = false;
        this.maxPlaybackRate = i;
        Process.setThreadPriority(-19);
    }

    private void updateTrackVolume() {
        if (this.track != null) {
            Logging.i("Set audio track volume " + this.volume);
            checkResult(this.track.setVolume(this.volume));
        }
    }

    private void updatePlaybackRate() {
        AudioTrack audioTrack = this.track;
        if (audioTrack == null || audioTrack.getState() != 1) {
            return;
        }
        Logging.i("Set playback rate " + this.playbackRate);
        this.track.setPlaybackParams(new PlaybackParams().setSpeed(this.playbackRate));
    }

    private void adjustBufferSize(float f, float f2) {
        if (this.track != null) {
            float fMax = Math.max(f, 1.0f);
            float fMax2 = Math.max(f2, 1.0f);
            if (fMax != fMax2) {
                AudioTrack audioTrack = this.track;
                audioTrack.setBufferSizeInFrames((int) ((audioTrack.getBufferSizeInFrames() * fMax2) / fMax));
            }
        }
    }

    @Override // com.amazonaws.ivs.player.AudioRenderer
    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    @Override // com.amazonaws.ivs.player.AudioRenderer
    public void setVolume(float f) {
        this.volume = f;
        updateTrackVolume();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void setPlaybackRate(float f) {
        this.startMediaTimeUs = getCurrentMediaTimeUs();
        this.startSystemTimeNs = System.nanoTime();
        adjustBufferSize(this.playbackRate, f);
        this.playbackRate = f;
        try {
            updatePlaybackRate();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            configure(this.format);
        }
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void configure(MediaFormat mediaFormat) {
        this.format = mediaFormat;
        int integer = mediaFormat.getInteger("sample-rate");
        int integer2 = mediaFormat.getInteger("channel-count");
        AudioTrack audioTrack = this.track;
        if (audioTrack != null) {
            if (audioTrack.getSampleRate() == integer && this.track.getChannelCount() == integer2) {
                return;
            }
            flush();
            release();
        }
        Trace.beginSection("AudioTrackRenderer configure");
        int iCreateChannelConfig = createChannelConfig(integer2);
        int minBufferSize = AudioTrack.getMinBufferSize(integer, iCreateChannelConfig, 2);
        this.bufferSize = minBufferSize;
        if (minBufferSize == -2) {
            this.bufferSize = integer;
            Logging.w("Error getting min buffer size using sample rate " + integer);
        }
        this.bufferSize *= this.maxPlaybackRate * 2;
        this.frameSizeBytes = integer2 * 2;
        this.framesWritten = 0L;
        int i = this.audioSessionId;
        if (i <= 0) {
            i = 0;
        }
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(3).setUsage(1).build();
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setEncoding(2).setSampleRate(integer).setChannelMask(iCreateChannelConfig).build();
        Logging.i("Creating audio track format: " + audioFormatBuild);
        this.track = new AudioTrack.Builder().setAudioAttributes(audioAttributesBuild).setAudioFormat(audioFormatBuild).setBufferSizeInBytes(this.bufferSize).setTransferMode(1).setSessionId(i).build();
        adjustBufferSize((float) this.maxPlaybackRate, this.playbackRate);
        this.audioSessionId = this.track.getAudioSessionId();
        updateTrackVolume();
        updatePlaybackRate();
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void start() {
        Trace.beginSection("AudioTrackRenderer start");
        this.started = true;
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void stop() {
        Trace.beginSection("AudioTrackRenderer start");
        this.started = false;
        AudioTrack audioTrack = this.track;
        if (audioTrack != null && audioTrack.getPlayState() == 3) {
            this.track.pause();
            this.startMediaTimeUs = 0L;
            this.startSystemTimeNs = 0L;
        }
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void flush() {
        Trace.beginSection("AudioTrackRenderer flush");
        this.sampleTimeUs = 0L;
        this.framesWritten = 0L;
        this.bytesWritten = 0;
        this.playheadPrevPosition = 0L;
        this.startMediaTimeUs = 0L;
        this.startSystemTimeNs = 0L;
        this.outOfSync = false;
        AudioTrack audioTrack = this.track;
        if (audioTrack != null) {
            audioTrack.stop();
            this.track.flush();
            long playbackHeadPosition = this.track.getPlaybackHeadPosition();
            if (playbackHeadPosition > 0) {
                Logging.w("audio position at flush " + playbackHeadPosition);
                release();
            }
        }
        Trace.endSection();
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public void render(ByteBuffer byteBuffer, int i, long j) {
        if (this.track == null || i == 0) {
            return;
        }
        Trace.beginSection("AudioTrackRenderer render " + j);
        long currentMediaTimeUs = getCurrentMediaTimeUs();
        if (this.startMediaTimeUs <= 0) {
            this.startMediaTimeUs = j;
        } else if (this.outOfSync) {
            if (j < currentMediaTimeUs) {
                return;
            } else {
                this.outOfSync = false;
            }
        } else if (this.startSystemTimeNs > 0 && currentMediaTimeUs - j > PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            this.outOfSync = true;
            Logging.i(String.format("Audio samples out of sync current: %d present: %d", Long.valueOf(currentMediaTimeUs), Long.valueOf(j)));
            return;
        }
        int iWrite = this.track.write(byteBuffer, i, 0);
        this.framesWritten += (long) (i / this.frameSizeBytes);
        int i2 = this.bytesWritten + i;
        this.bytesWritten = i2;
        this.sampleTimeUs = j;
        if (this.started && i2 >= this.bufferSize / this.maxPlaybackRate && this.track.getPlayState() != 3) {
            if (this.startSystemTimeNs <= 0) {
                this.startSystemTimeNs = System.nanoTime();
            }
            this.track.play();
        }
        checkResult(iWrite);
        Trace.endSection();
    }

    private long getCurrentMediaTimeUs() {
        if (this.startMediaTimeUs <= 0 || this.startSystemTimeNs <= 0) {
            return -1L;
        }
        long jNanoTime = (long) ((System.nanoTime() - this.startSystemTimeNs) * this.playbackRate);
        long j = this.startMediaTimeUs;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return j + (jNanoTime / 1000);
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer, com.amazonaws.ivs.player.Releasable
    public void release() {
        if (this.track != null) {
            try {
                Trace.beginSection("AudioTrackRenderer release");
                this.track.release();
            } finally {
                this.track = null;
                Trace.endSection();
            }
        }
    }

    @Override // com.amazonaws.ivs.player.MediaRenderer
    public long getRenderedPresentationTime() {
        AudioTrack audioTrack;
        if (this.sampleTimeUs == 0 || (audioTrack = this.track) == null || audioTrack.getPlayState() != 3) {
            return -1L;
        }
        long renderedPositionInFrames = this.sampleTimeUs - ((long) (((this.framesWritten - getRenderedPositionInFrames()) / ((double) this.track.getSampleRate())) * 1000000.0d));
        if (renderedPositionInFrames < 0) {
            return 0L;
        }
        return renderedPositionInFrames;
    }

    public void setPlaybackPositionUpdateListener(AudioTrack.OnPlaybackPositionUpdateListener onPlaybackPositionUpdateListener, int i) {
        AudioTrack audioTrack = this.track;
        if (audioTrack != null) {
            audioTrack.setPlaybackPositionUpdateListener(onPlaybackPositionUpdateListener);
            this.track.setPositionNotificationPeriod(i);
        }
    }

    public void setMarkerPosition(long j) {
        AudioTrack audioTrack = this.track;
        if (audioTrack == null) {
            return;
        }
        this.track.setNotificationMarkerPosition((int) (4294967295L & (getRenderedPositionInFrames() + ((((j - this.sampleTimeUs) + 1) * ((long) audioTrack.getSampleRate())) / 1000000))));
    }

    private long getRenderedPositionInFrames() {
        long playbackHeadPosition = ((long) this.track.getPlaybackHeadPosition()) & 4294967295L;
        long j = this.playheadPrevPosition;
        if (j > 0 && playbackHeadPosition < j) {
            Logging.w("AudioTrack.getPlaybackHeadPosition " + playbackHeadPosition + " < previous " + this.playheadPrevPosition);
            this.playheadBasePosition = this.playheadPrevPosition;
        }
        this.playheadPrevPosition = playbackHeadPosition;
        return playbackHeadPosition + this.playheadBasePosition;
    }

    private void checkResult(int i) {
        if (i == -6) {
            Logging.e("AudioTrack.ERROR_DEAD_OBJECT");
            flush();
        } else if (i == -3) {
            Logging.e("AudioTrack.ERROR_INVALID_OPERATION");
        } else {
            if (i != -2) {
                return;
            }
            Logging.e("AudioTrack.ERROR_BAD_VALUE");
        }
    }
}
