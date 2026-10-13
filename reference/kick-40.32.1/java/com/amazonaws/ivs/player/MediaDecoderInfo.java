package com.amazonaws.ivs.player;

import android.media.MediaCodec;

/* JADX INFO: loaded from: classes5.dex */
public class MediaDecoderInfo {
    private final String name;

    public MediaDecoderInfo(MediaCodec mediaCodec) {
        this.name = mediaCodec.getName();
    }

    public String getName() {
        return this.name;
    }
}
