package com.amazonaws.ivs.player;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: DecodedMediaBuffer.java */
/* JADX INFO: loaded from: classes5.dex */
class DecodedImageBuffer implements Releasable {
    final int index;
    final FrameInfo info;
    Releasable releaseCallback;
    Callable<Boolean> render;
    boolean rendered = false;

    DecodedImageBuffer(FrameInfo frameInfo, int i) {
        this.index = i;
        this.info = frameInfo;
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        Releasable releasable = this.releaseCallback;
        if (releasable != null) {
            releasable.release();
        }
    }

    boolean render() throws Exception {
        Callable<Boolean> callable = this.render;
        if (callable != null) {
            return callable.call().booleanValue();
        }
        return true;
    }

    void setRenderCommand(Callable<Boolean> callable) {
        this.render = callable;
    }
}
