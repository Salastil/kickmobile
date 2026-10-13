package com.amazonaws.ivs.player;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class Formats {
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};

    private Formats() {
    }

    public static MediaFormat createVideoFormat(String str, ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2) {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(MediaType.removeParameters(str), i, i2);
        mediaFormatCreateVideoFormat.setInteger("max-input-size", 0);
        if (byteBufferArr != null) {
            for (int i3 = 0; i3 < byteBufferArr.length; i3++) {
                ByteBuffer byteBufferAddNALStartCodes = addNALStartCodes(byteBufferArr[i3]);
                byteBufferArr[i3] = byteBufferAddNALStartCodes;
                if (byteBufferAddNALStartCodes.remaining() > 4) {
                    mediaFormatCreateVideoFormat.setByteBuffer("csd-" + i3, byteBufferArr[i3]);
                }
            }
        }
        setProtectionData(mediaFormatCreateVideoFormat, byteBufferArr2);
        return mediaFormatCreateVideoFormat;
    }

    public static MediaFormat createAudioFormat(String str, ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer[] byteBufferArr2) {
        String strRemoveParameters = MediaType.removeParameters(str);
        if (MediaType.AUDIO_AAC.equals(strRemoveParameters)) {
            strRemoveParameters = "audio/mp4a-latm";
        }
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(strRemoveParameters, i, i2);
        if (byteBufferArr != null) {
            for (int i3 = 0; i3 < byteBufferArr.length; i3++) {
                mediaFormatCreateAudioFormat.setByteBuffer("csd-" + i3, byteBufferArr[i3]);
            }
        }
        setProtectionData(mediaFormatCreateAudioFormat, byteBufferArr2);
        return mediaFormatCreateAudioFormat;
    }

    private static void setProtectionData(MediaFormat mediaFormat, ByteBuffer[] byteBufferArr) {
        if (byteBufferArr != null) {
            for (int i = 0; i < byteBufferArr.length; i++) {
                mediaFormat.setByteBuffer("drm-" + i, byteBufferArr[i]);
            }
        }
    }

    public static MediaFormat createTextFormat(String str) {
        return MediaFormat.createSubtitleFormat(MediaType.removeParameters(str), null);
    }

    private static ByteBuffer addNALStartCodes(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocateDirect(4);
        }
        if (byteBuffer.remaining() > 4) {
            byte[] bArr = new byte[4];
            byteBuffer.get(bArr);
            byteBuffer.rewind();
            if (Arrays.equals(bArr, NAL_START_CODE)) {
                return byteBuffer;
            }
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining() + 4);
        byteBufferAllocateDirect.put(NAL_START_CODE);
        byteBufferAllocateDirect.put(byteBuffer);
        byteBufferAllocateDirect.rewind();
        return byteBufferAllocateDirect;
    }
}
