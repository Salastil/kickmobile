package androidx.media3.muxer;

import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class WebmElements {
    private static final int MAX_CHROMATICITY = 50000;
    private static final int TIMESTAMP_SCALE = 1000000;

    private WebmElements() {
    }

    public static ByteBuffer createUnsignedIntElement(long j, long j2) {
        return wrapIntoElement(j, uintToMinimumLengthByteBuffer(j2));
    }

    public static ByteBuffer createFloatElement(long j, float f) {
        return wrapIntoElement(j, ByteBuffer.wrap(Util.toByteArray(f)));
    }

    public static ByteBuffer createStringElement(long j, String str) {
        return wrapIntoElement(j, ByteBuffer.wrap(Util.getUtf8Bytes(str)));
    }

    public static ByteBuffer createSimpleBlockElement(int i, long j, boolean z, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferEncodeVInt = EbmlUtils.encodeVInt(i);
        byte b = (byte) ((j >> 8) & 255);
        byte b2 = (byte) (j & 255);
        int i2 = z ? 128 : 0;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferEncodeVInt.remaining() + 3 + byteBuffer.remaining());
        byteBufferAllocate.put(byteBufferEncodeVInt);
        byteBufferAllocate.put(b);
        byteBufferAllocate.put(b2);
        byteBufferAllocate.put((byte) i2);
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        return wrapIntoElement(163L, byteBufferAllocate);
    }

    public static ByteBuffer createEbmlHeaderElement() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createUnsignedIntElement(17030L, 1L));
        arrayList.add(createUnsignedIntElement(17143L, 1L));
        arrayList.add(createUnsignedIntElement(17138L, 4L));
        arrayList.add(createUnsignedIntElement(17139L, 8L));
        arrayList.add(createStringElement(17026L, "webm"));
        arrayList.add(createUnsignedIntElement(17031L, 2L));
        arrayList.add(createUnsignedIntElement(17029L, 2L));
        return wrapIntoElement(440786851L, arrayList);
    }

    public static ByteBuffer createSeekHeadElement(long j, long j2, long j3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(createUnsignedIntElement(21419L, 357149030L));
        arrayList2.add(createUnsignedIntElement(21420L, j));
        arrayList.add(wrapIntoElement(19899L, arrayList2));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(createUnsignedIntElement(21419L, 374648427L));
        arrayList3.add(createUnsignedIntElement(21420L, j2));
        arrayList.add(wrapIntoElement(19899L, arrayList3));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(createUnsignedIntElement(21419L, 475249515L));
        arrayList4.add(createUnsignedIntElement(21420L, j3));
        arrayList.add(wrapIntoElement(19899L, arrayList4));
        return wrapIntoElement(290298740L, arrayList);
    }

    public static ByteBuffer createVoidElement(int i) {
        ByteBuffer byteBufferUintToMinimumLengthByteBuffer = uintToMinimumLengthByteBuffer(236L);
        int iRemaining = byteBufferUintToMinimumLengthByteBuffer.remaining();
        Preconditions.checkArgument(i >= 2);
        int i2 = i >= 9 ? 8 : 1;
        int i3 = (i - iRemaining) - i2;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.put(byteBufferUintToMinimumLengthByteBuffer);
        byteBufferAllocate.put(EbmlUtils.encodeVIntWithWidth(i3, i2));
        byteBufferAllocate.position(byteBufferAllocate.position() + i3);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer createInfoElement(float f) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createFloatElement(17545L, f));
        arrayList.add(createUnsignedIntElement(2807729L, 1000000L));
        arrayList.add(createStringElement(19840L, "android"));
        arrayList.add(createStringElement(22337L, "android"));
        return wrapIntoElement(357149030L, arrayList);
    }

    public static ByteBuffer createCuePointElement(long j, int i, long j2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createUnsignedIntElement(179L, j));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(createUnsignedIntElement(247L, i));
        arrayList2.add(createUnsignedIntElement(241L, j2));
        arrayList.add(wrapIntoElement(183L, arrayList2));
        return wrapIntoElement(187L, arrayList);
    }

    public static ByteBuffer createTrackElements(List<Track> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Track track = list.get(i);
            int trackType = MimeTypes.getTrackType(track.format.sampleMimeType);
            if (trackType == 1) {
                arrayList.add(createAudioTrackEntryElement(track.id, track.format));
            } else if (trackType == 2) {
                arrayList.add(createVideoTrackEntryElement(track.id, track.format));
            } else {
                throw new IllegalArgumentException(String.format("Track MimeType %s is not supported in WebM.", track.format.sampleMimeType));
            }
        }
        return wrapIntoElement(374648427L, arrayList);
    }

    private static ByteBuffer createAudioTrackEntryElement(int i, Format format) {
        ByteBuffer byteBufferWrap;
        List<ByteBuffer> commonTrackEntry = getCommonTrackEntry(2, i, 2, format);
        ArrayList arrayList = new ArrayList();
        arrayList.add(createUnsignedIntElement(159L, format.channelCount));
        arrayList.add(createFloatElement(181L, format.sampleRate));
        arrayList.add(createFloatElement(25188L, format.pcmEncoding));
        if (((String) Preconditions.checkNotNull(format.sampleMimeType)).equals(MimeTypes.AUDIO_VORBIS)) {
            byteBufferWrap = CodecSpecificDataUtil.getVorbisInitializationData(format);
        } else {
            byteBufferWrap = ByteBuffer.wrap(format.initializationData.get(0));
        }
        ByteBuffer byteBufferWrapIntoElement = wrapIntoElement(225L, arrayList);
        ByteBuffer byteBufferWrapIntoElement2 = wrapIntoElement(25506L, byteBufferWrap);
        commonTrackEntry.add(byteBufferWrapIntoElement);
        commonTrackEntry.add(byteBufferWrapIntoElement2);
        return wrapIntoElement(174L, commonTrackEntry);
    }

    private static List<ByteBuffer> getCommonTrackEntry(int i, int i2, int i3, Format format) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createUnsignedIntElement(215L, i));
        arrayList.add(createUnsignedIntElement(29637L, i2));
        arrayList.add(createUnsignedIntElement(156L, 0L));
        arrayList.add(createStringElement(2274716L, (String) Preconditions.checkNotNull(format.language)));
        arrayList.add(createStringElement(134L, getCodecId((String) Preconditions.checkNotNull(format.sampleMimeType))));
        arrayList.add(createUnsignedIntElement(131L, i3));
        return arrayList;
    }

    private static String getCodecId(String str) {
        str.hashCode();
        switch (str) {
            case "audio/vorbis":
                return "A_VORBIS";
            case "audio/opus":
                return "A_OPUS";
            case "video/x-vnd.on2.vp8":
                return "V_VP8";
            case "video/x-vnd.on2.vp9":
                return "V_VP9";
            default:
                throw new IllegalArgumentException("Unsupported mime type: " + str);
        }
    }

    private static ByteBuffer createVideoTrackEntryElement(int i, Format format) {
        List<ByteBuffer> commonTrackEntry = getCommonTrackEntry(1, i, 1, format);
        Preconditions.checkNotNull(format.sampleMimeType);
        if (!format.initializationData.isEmpty()) {
            commonTrackEntry.add(wrapIntoElement(25506L, ByteBuffer.wrap(format.initializationData.get(0))));
        }
        commonTrackEntry.add(createVideoElement(format));
        return wrapIntoElement(174L, commonTrackEntry);
    }

    private static ByteBuffer createVideoElement(Format format) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createUnsignedIntElement(176L, format.width));
        arrayList.add(createUnsignedIntElement(186L, format.height));
        if (format.colorInfo != null) {
            arrayList.add(createColorElement(format.colorInfo));
        }
        return wrapIntoElement(224L, arrayList);
    }

    private static ByteBuffer createColorElement(ColorInfo colorInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createUnsignedIntElement(21947L, ColorInfo.colorSpaceToIsoColorPrimaries(colorInfo.colorSpace)));
        arrayList.add(createUnsignedIntElement(21946L, ColorInfo.colorTransferToIsoTransferCharacteristics(colorInfo.colorTransfer)));
        arrayList.add(createUnsignedIntElement(21937L, ColorInfo.colorSpaceToIsoMatrixCoefficients(colorInfo.colorSpace)));
        arrayList.add(createUnsignedIntElement(21945L, colorInfo.colorRange));
        byte[] bArr = colorInfo.hdrStaticInfo;
        if (bArr != null && bArr.length == 25) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            if (byteBufferOrder.get() == 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(createFloatElement(21969L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21970L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21971L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21972L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21973L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21974L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21975L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21976L, byteBufferOrder.getShort() / 50000.0f));
                arrayList2.add(createFloatElement(21977L, byteBufferOrder.getShort()));
                arrayList2.add(createFloatElement(21978L, byteBufferOrder.getShort() * 1.0E-4f));
                short s = byteBufferOrder.getShort();
                short s2 = byteBufferOrder.getShort();
                arrayList2.add(createUnsignedIntElement(21948L, s));
                arrayList2.add(createUnsignedIntElement(21949L, s2));
                arrayList.add(wrapIntoElement(21968L, arrayList2));
            }
        }
        return wrapIntoElement(21936L, arrayList);
    }

    public static ByteBuffer uintToMinimumLengthByteBuffer(long j) {
        int iNumberOfLeadingZeros = j == 0 ? 1 : (71 - Long.numberOfLeadingZeros(j)) / 8;
        byte[] bArr = new byte[iNumberOfLeadingZeros];
        for (int i = iNumberOfLeadingZeros - 1; i >= 0; i--) {
            bArr[i] = (byte) (255 & j);
            j >>>= 8;
        }
        return ByteBuffer.wrap(bArr);
    }

    public static ByteBuffer wrapIntoElement(long j, List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        int iRemaining = 0;
        while (it.hasNext()) {
            iRemaining += it.next().remaining();
        }
        ByteBuffer byteBufferUintToMinimumLengthByteBuffer = uintToMinimumLengthByteBuffer(j);
        ByteBuffer byteBufferEncodeVInt = EbmlUtils.encodeVInt(iRemaining);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferUintToMinimumLengthByteBuffer.remaining() + byteBufferEncodeVInt.remaining() + iRemaining);
        byteBufferAllocate.put(byteBufferUintToMinimumLengthByteBuffer);
        byteBufferAllocate.put(byteBufferEncodeVInt);
        Iterator<ByteBuffer> it2 = list.iterator();
        while (it2.hasNext()) {
            byteBufferAllocate.put(it2.next());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static ByteBuffer wrapIntoElement(long j, ByteBuffer byteBuffer) {
        return wrapIntoElement(j, (List<ByteBuffer>) Collections.singletonList(byteBuffer));
    }
}
