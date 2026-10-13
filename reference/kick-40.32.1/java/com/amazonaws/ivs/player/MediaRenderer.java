package com.amazonaws.ivs.player;

import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
interface MediaRenderer extends Releasable {
    void configure(MediaFormat mediaFormat);

    void flush();

    long getRenderedPresentationTime();

    @Override // com.amazonaws.ivs.player.Releasable
    void release();

    void render(ByteBuffer byteBuffer, int i, long j);

    void setPlaybackRate(float f);

    boolean shouldProcessMore();

    void start();

    void stop();
}
