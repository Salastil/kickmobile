package androidx.media3.muxer;

/* JADX INFO: loaded from: classes5.dex */
public final class BufferInfo {
    public final int flags;
    public final long presentationTimeUs;
    public final int size;

    public BufferInfo(long j, int i, int i2) {
        this.presentationTimeUs = j;
        this.size = i;
        this.flags = i2;
    }
}
