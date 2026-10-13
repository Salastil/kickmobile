package com.amazonaws.ivs.player;

import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: DecodedMediaBuffer.java */
/* JADX INFO: loaded from: classes5.dex */
class DecodedAudioBuffer implements Releasable {
    final ByteBuffer buffer;
    final int bytesSize;
    final int index;
    final FrameInfo info;
    Releasable releaseCallback;

    DecodedAudioBuffer(ByteBuffer byteBuffer, int i, FrameInfo frameInfo, int i2, Releasable releasable) {
        this.buffer = byteBuffer;
        this.bytesSize = i;
        this.info = frameInfo;
        this.index = i2;
        this.releaseCallback = releasable;
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        Releasable releasable = this.releaseCallback;
        if (releasable != null) {
            try {
                releasable.release();
            } catch (Exception e) {
                Log.e("DecodedAudioBuffer", "Encountered exception calling release " + e);
            }
        }
    }
}
