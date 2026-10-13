package com.amazonaws.ivs.player;

import android.media.MediaCodec;
import android.media.MediaFormat;
import io.ktor.util.date.GMTDateParser;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
class MediaSample implements Releasable {
    public final ByteBuffer buffer;
    public final MediaCodec.CryptoInfo cryptoInfo;
    public final long decodeTimeUs;
    public final long durationUs;
    public MediaFormat format;
    public final boolean isDecodeOnly;
    public final boolean isSyncSample;
    public final long presentationTimeUs;
    private Releasable releaseCallback;
    public final int size;
    public boolean isDecodeOnlySeek = false;
    public boolean isEndOfStream = false;
    private final AtomicBoolean released = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public static int fourcc(char c, char c2, char c3, char c4) {
        return ((c & 255) << 24) | ((c2 & 255) << 16) | ((c3 & 255) << 8) | (c4 & 255);
    }

    MediaSample(ByteBuffer byteBuffer, int i, long j, long j2, long j3, boolean z, boolean z2) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Invalid buffer");
        }
        this.buffer = byteBuffer;
        this.size = i;
        this.decodeTimeUs = j;
        this.presentationTimeUs = j2;
        this.durationUs = j3;
        this.isSyncSample = z;
        this.isDecodeOnly = z2;
        this.cryptoInfo = null;
    }

    MediaSample(ByteBuffer byteBuffer, int i, long j, long j2, long j3, boolean z, boolean z2, byte[] bArr, byte[] bArr2, int[] iArr, int[] iArr2, int i2, int i3) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Invalid buffer");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("Invalid initialization vector");
        }
        if (bArr2 == null || bArr2.length == 0) {
            throw new IllegalArgumentException("Invalid key id");
        }
        this.buffer = byteBuffer;
        this.size = i;
        this.decodeTimeUs = j;
        this.presentationTimeUs = j2;
        this.durationUs = j3;
        this.isSyncSample = z;
        this.isDecodeOnly = z2;
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.cryptoInfo = cryptoInfo;
        cryptoInfo.iv = bArr;
        cryptoInfo.key = bArr2;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.numSubSamples = i2;
        cryptoInfo.mode = i3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Sample: , size=");
        sb.append(this.size);
        sb.append(", decodeTimeUs=");
        sb.append(this.decodeTimeUs);
        sb.append(", presentationTimeUs=");
        sb.append(this.presentationTimeUs);
        sb.append(", durationUs=");
        sb.append(this.durationUs);
        sb.append(", isSyncSample=");
        sb.append(this.isSyncSample);
        sb.append(", isDecodeOnly=");
        sb.append(this.isDecodeOnly);
        sb.append(", cryptoInfo=");
        MediaCodec.CryptoInfo cryptoInfo = this.cryptoInfo;
        sb.append(cryptoInfo == null ? "" : cryptoInfo.toString());
        return sb.toString();
    }

    public void setReleaseCallback(Releasable releasable) {
        this.releaseCallback = releasable;
    }

    @Override // com.amazonaws.ivs.player.Releasable
    public void release() {
        Releasable releasable;
        if (!this.released.compareAndSet(false, true) || (releasable = this.releaseCallback) == null) {
            return;
        }
        releasable.release();
    }

    enum TrackID {
        VIDEO(MediaSample.fourcc('v', 'i', GMTDateParser.DAY_OF_MONTH, 'e')),
        AUDIO(MediaSample.fourcc(GMTDateParser.SECONDS, 'o', AbstractJsonLexerKt.UNICODE_ESC, 'n')),
        TEXT(MediaSample.fourcc('t', 'e', 'x', 't')),
        META(MediaSample.fourcc(GMTDateParser.MINUTES, 'e', 't', 'a'));

        final int value;

        TrackID(int i) {
            this.value = i;
        }
    }
}
