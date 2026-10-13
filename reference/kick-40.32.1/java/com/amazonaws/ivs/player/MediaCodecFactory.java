package com.amazonaws.ivs.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class MediaCodecFactory {
    static final String OMX_SOFTWARE_AV1_DECODER = "c2.android.av1.decoder";
    static final String OMX_SOFTWARE_AVC_DECODER = "OMX.google.h264.decoder";
    static final String OMX_SOFTWARE_HEVC_DECODER = "OMX.google.hevc.decoder";
    static final String OMX_SOFTWARE_VP9_DECODER = "OMX.google.vp9.decoder";

    private MediaCodecFactory() {
    }

    static MediaCodec createCodec(String str, boolean z) {
        MediaCodec mediaCodecCreateDecoderByType;
        String strFindDecoder;
        String strFindDecoder2 = findDecoder(str, z);
        if (strFindDecoder2 == null) {
            try {
                mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(str);
            } catch (IOException e) {
                Logging.w("Failed to create codec " + str, e);
                mediaCodecCreateDecoderByType = null;
            }
        } else {
            mediaCodecCreateDecoderByType = createCodecByName(strFindDecoder2);
        }
        if (mediaCodecCreateDecoderByType != null || !z || (strFindDecoder = findDecoder(str, false)) == null) {
            return mediaCodecCreateDecoderByType;
        }
        return createCodecByName(strFindDecoder + ".secure");
    }

    private static MediaCodec createCodecByName(String str) {
        if (str == null) {
            return null;
        }
        try {
            return MediaCodec.createByCodecName(str);
        } catch (MediaCodec.CodecException | IOException e) {
            Logging.w("Failed to create codec " + str, e);
            return null;
        }
    }

    static MediaCodec createSoftwareCodec(String str) {
        str.hashCode();
        switch (str) {
            case "video/av01":
                return createCodecByName(OMX_SOFTWARE_AV1_DECODER);
            case "video/hevc":
                return createCodecByName(OMX_SOFTWARE_HEVC_DECODER);
            case "video/avc":
                return createCodecByName(OMX_SOFTWARE_AVC_DECODER);
            case "video/x-vnd.on2.vp9":
                return createCodecByName(OMX_SOFTWARE_VP9_DECODER);
            default:
                return null;
        }
    }

    static String findDecoder(String str, boolean z) {
        List<MediaCodecInfo> listFindSupportedCodecs = findSupportedCodecs(str, z);
        if (listFindSupportedCodecs.isEmpty()) {
            return null;
        }
        return listFindSupportedCodecs.get(0).getName();
    }

    static List<MediaCodecInfo> findSupportedCodecs(String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(z ? 1 : 0).getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder() && supportsType(mediaCodecInfo, str)) {
                int i = !z ? 1 : 0;
                if (z && mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("secure-playback")) {
                    i = 1;
                }
                if (i != 0) {
                    arrayList.add(mediaCodecInfo);
                }
            }
        }
        return arrayList;
    }

    private static boolean supportsType(MediaCodecInfo mediaCodecInfo, String str) {
        for (String str2 : mediaCodecInfo.getSupportedTypes()) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean limitMaxDecodeSize(String str) {
        return "OMX.amlogic.avc.decoder.awesome".equals(str);
    }
}
