package org.bouncycastle.pqc.crypto.hqc;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.runtime.GapComposerKt;
import androidx.media3.muxer.WebmConstants;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cast.MediaError;
import com.google.mlkit.common.MlKitException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.bouncycastle.math.Primes;

/* JADX INFO: loaded from: classes11.dex */
class GFCalculator {
    static int[] exp = {1, 2, 4, 8, 16, 32, 64, 128, 29, 58, 116, 232, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 135, 19, 38, 76, 152, 45, 90, RotationOptions.ROTATE_180, 117, 234, 201, 143, 3, 6, 12, 24, 48, 96, 192, 157, 39, 78, WebmConstants.MkvEbmlElement.FLAG_LACING, 37, 74, 148, 53, 106, 212, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 119, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, 193, WebmConstants.MkvEbmlElement.CHANNELS, 35, 70, 140, 5, 10, 20, 40, 80, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 93, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT, 105, 210, 185, 111, 222, WebmConstants.MkvEbmlElement.BLOCK, 95, 190, 97, 194, 153, 47, 94, 188, 101, 202, 137, 15, 30, 60, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, 240, 253, WebmConstants.MkvEbmlElement.TIMESTAMP, Primes.SMALL_FACTOR_LIMIT, WebmConstants.MkvEbmlElement.CUE_POINT, 107, 214, 177, 127, 254, 225, 223, WebmConstants.MkvEbmlElement.SIMPLE_BLOCK, 91, 182, 113, 226, JfifUtil.MARKER_EOI, 175, 67, WebmConstants.MkvEbmlElement.CODEC_ID, 17, 34, 68, WebmConstants.MkvEbmlElement.FLAG_DEFAULT, 13, 26, 52, 104, JfifUtil.MARKER_RST0, 189, 103, 206, 129, 31, 62, 124, 248, 237, 199, 147, 59, 118, WebmConstants.MkvEbmlElement.VOID, 197, 151, 51, 102, 204, 133, 23, 46, 92, 184, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, JfifUtil.MARKER_SOS, 169, 79, 158, 33, 66, 132, 21, 42, 84, 168, 77, WebmConstants.MkvEbmlElement.FLAG_INTERLACED, 41, 82, 164, 85, 170, 73, 146, 57, 114, 228, 213, WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS, 115, 230, 209, 191, 99, 198, 145, 63, WebSocketProtocol.PAYLOAD_SHORT, 252, 229, 215, WebmConstants.MkvEbmlElement.CUE_TIME, 123, 246, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 255, 227, 219, WebmConstants.MkvEbmlElement.PREV_SIZE, 75, 150, 49, 98, 196, 149, 55, MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE, 220, WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, 87, WebmConstants.MkvEbmlElement.TRACK_ENTRY, 65, 130, 25, 50, 100, 200, 141, 7, 14, 28, 56, 112, 224, 221, 167, 83, WebmConstants.MkvEbmlElement.BLOCK_MORE, 81, 162, 89, 178, 121, 242, 249, 239, 195, WebmConstants.MkvEbmlElement.BLOCK_DURATION, 43, 86, 172, 69, 138, 9, 18, 36, 72, 144, 61, 122, 244, 245, WebmConstants.MkvEbmlElement.CUE_TRACK, 243, WebmConstants.MkvEbmlElement.REFERENCE_BLOCK, 235, 203, 139, 11, 22, 44, 88, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, GapComposerKt.nodeKey, 250, 233, 207, WebmConstants.MkvEbmlElement.TRACK_TYPE, 27, 54, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, JfifUtil.MARKER_SOI, 173, 71, 142, 1, 2, 4};
    static int[] log = {0, 0, 1, 25, 2, 50, 26, 198, 3, 223, 51, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, 27, 104, 199, 75, 4, 100, 224, 14, 52, 141, 239, 129, 28, 193, 105, 248, 200, 8, 76, 113, 5, 138, 101, 47, 225, 36, 15, 33, 53, 147, 142, JfifUtil.MARKER_SOS, 240, 18, 130, 69, 29, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 194, GapComposerKt.nodeKey, 106, 39, 249, 185, 201, WebmConstants.MkvEbmlElement.FLAG_INTERLACED, 9, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE, 77, 228, 114, WebmConstants.MkvEbmlElement.BLOCK_MORE, 6, 191, 139, 98, 102, 221, 48, 253, 226, 152, 37, WebmConstants.MkvEbmlElement.CUE_TIME, 16, 145, 34, WebmConstants.MkvEbmlElement.FLAG_DEFAULT, 54, JfifUtil.MARKER_RST0, 148, 206, 143, 150, 219, 189, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 210, 19, 92, WebmConstants.MkvEbmlElement.TRACK_TYPE, 56, 70, 64, 30, 66, 182, WebmConstants.MkvEbmlElement.SIMPLE_BLOCK, 195, 72, WebSocketProtocol.PAYLOAD_SHORT, MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE, 107, 58, 40, 84, 250, 133, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT, 61, 202, 94, WebmConstants.MkvEbmlElement.BLOCK_DURATION, WebmConstants.MkvEbmlElement.CHANNELS, 10, 21, 121, 43, 78, 212, 229, 172, 115, 243, 167, 87, 7, 112, 192, WebmConstants.MkvEbmlElement.CUE_TRACK, 140, 128, 99, 13, 103, 74, 222, 237, 49, 197, 254, 24, 227, WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL, 153, 119, 38, 184, RotationOptions.ROTATE_180, 124, 17, 68, 146, JfifUtil.MARKER_EOI, 35, 32, 137, 46, 55, 63, 209, 91, 149, 188, 207, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 144, 135, 151, 178, 220, 252, 190, 97, 242, 86, Primes.SMALL_FACTOR_LIMIT, WebmConstants.MkvEbmlElement.PREV_SIZE, 20, 42, 93, 158, 132, 60, 57, 83, 71, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 65, 162, 31, 45, 67, JfifUtil.MARKER_SOI, WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS, 123, 164, 118, 196, 23, 73, WebmConstants.MkvEbmlElement.VOID, 127, 12, 111, 246, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, WebmConstants.MkvEbmlElement.BLOCK, 59, 82, 41, 157, 85, 170, WebmConstants.MkvEbmlElement.REFERENCE_BLOCK, 96, WebmConstants.MkvEbmlElement.CODEC_ID, 177, WebmConstants.MkvEbmlElement.CUE_POINT, 204, 62, 90, 203, 89, 95, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, WebmConstants.MkvEbmlElement.FLAG_LACING, 169, WebmConstants.MkvEbmlElement.BLOCK_GROUP, 81, 11, 245, 22, 235, 122, 117, 44, 215, 79, WebmConstants.MkvEbmlElement.TRACK_ENTRY, 213, 233, 230, WebmConstants.MkvEbmlElement.TIMESTAMP, 173, 232, 116, 214, 244, 234, 168, 80, 88, 175};

    GFCalculator() {
    }

    static int inverse(int i) {
        return exp[255 - log[i]] & Utils.toUnsigned16Bits((-i) >> 31);
    }

    static int mod(int i) {
        int unsigned16Bits = Utils.toUnsigned16Bits(i - 255);
        return Utils.toUnsigned16Bits(unsigned16Bits + (Utils.toUnsigned8bits(-(unsigned16Bits >> 15)) & 255));
    }

    static int mult(int i, int i2) {
        int unsigned16Bits = Utils.toUnsigned16Bits((-i) >> 31) & Utils.toUnsigned16Bits((-i2) >> 31);
        int[] iArr = exp;
        int[] iArr2 = log;
        return Utils.toUnsigned16Bits(iArr[mod(iArr2[i] + iArr2[i2])] & unsigned16Bits);
    }
}
