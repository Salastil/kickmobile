package com.amazonaws.ivs.player;

import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
interface MediaDecoder extends Releasable {
    void configure(MediaFormat mediaFormat);

    void decode(MediaSample mediaSample);

    void flush();

    MediaDecoderInfo getInfo();

    ByteBuffer getOutput();

    long getOutputTime();

    boolean hasInput();

    boolean hasOutput();

    @Override // com.amazonaws.ivs.player.Releasable
    void release();

    void reset();
}
