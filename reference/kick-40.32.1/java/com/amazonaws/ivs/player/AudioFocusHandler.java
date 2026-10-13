package com.amazonaws.ivs.player;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import androidx.media.AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes5.dex */
class AudioFocusHandler implements AudioManager.OnAudioFocusChangeListener {
    private final AudioManager audioManager;
    private boolean enabled;
    private AudioFocusRequest focusRequest;
    private int focusMode = -1;
    private int defaultAudioStream = 3;

    AudioFocusHandler(Context context) {
        this.audioManager = (AudioManager) context.getSystemService("audio");
    }

    void setEnabled(boolean z) {
        this.enabled = z;
        if (z) {
            return;
        }
        abandonFocus();
    }

    public void requestFocus() {
        int iRequestAudioFocus;
        if (this.enabled) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest.Builder builderM = AudioFocusRequestCompat$$ExternalSyntheticApiModelOutline0.m(2);
                builderM.setAudioAttributes(new AudioAttributes.Builder().setContentType(3).setUsage(1).build());
                builderM.setWillPauseWhenDucked(false);
                builderM.setOnAudioFocusChangeListener(this);
                AudioFocusRequest audioFocusRequestBuild = builderM.build();
                this.focusRequest = audioFocusRequestBuild;
                iRequestAudioFocus = this.audioManager.requestAudioFocus(audioFocusRequestBuild);
            } else {
                iRequestAudioFocus = this.audioManager.requestAudioFocus(this, this.defaultAudioStream, 2);
            }
            if (iRequestAudioFocus != 1) {
                if (iRequestAudioFocus == 0) {
                    Logging.w("requestAudioFocus AUDIOFOCUS_REQUEST_FAILED");
                } else {
                    if (iRequestAudioFocus != 2) {
                        return;
                    }
                    Logging.w("requestAudioFocus AUDIOFOCUS_REQUEST_DELAYED");
                }
            }
        }
    }

    public void abandonFocus() {
        if (this.enabled) {
            if (Build.VERSION.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequest = this.focusRequest;
                if (audioFocusRequest != null) {
                    this.audioManager.abandonAudioFocusRequest(audioFocusRequest);
                    return;
                }
                return;
            }
            this.audioManager.abandonAudioFocus(this);
        }
    }

    public int getVolumeControlStream() {
        AudioFocusRequest audioFocusRequest;
        if (Build.VERSION.SDK_INT >= 26 && (audioFocusRequest = this.focusRequest) != null) {
            return audioFocusRequest.getAudioAttributes().getVolumeControlStream();
        }
        return this.defaultAudioStream;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        this.focusMode = i;
        if (i != -1) {
            return;
        }
        Logging.i("AUDIOFOCUS_LOSS pause");
    }
}
