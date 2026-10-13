package com.amazonaws.ivs.player;

/* JADX INFO: compiled from: DecodedMediaBuffer.java */
/* JADX INFO: loaded from: classes5.dex */
class FrameInfo {
    final long durationUs;
    final boolean isEndOfStream;
    final long presentationTimeUs;

    FrameInfo(long j, long j2, boolean z) {
        this.presentationTimeUs = j;
        this.durationUs = j2;
        this.isEndOfStream = z;
    }
}
