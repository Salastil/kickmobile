package org.brotli.dec;

import androidx.media3.muxer.WebmConstants;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaError;

/* JADX INFO: loaded from: classes11.dex */
final class Prefix {
    static final int[] BLOCK_LENGTH_OFFSET = {1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, 145, 177, 209, WebmConstants.MkvEbmlElement.CUE_CLUSTER_POSITION, 305, 369, 497, 753, 1265, 2289, 4337, 8433, 16625};
    static final int[] BLOCK_LENGTH_N_BITS = {2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};
    static final int[] INSERT_LENGTH_OFFSET = {0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, 130, 194, MediaError.DetailedErrorCode.DASH_NO_INIT, 578, 1090, CastStatusCodes.ERROR_NO_CAST_CONFIGURATION, 6210, 22594};
    static final int[] INSERT_LENGTH_N_BITS = {0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};
    static final int[] COPY_LENGTH_OFFSET = {2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, WebmConstants.MkvEbmlElement.CODEC_ID, 198, 326, 582, 1094, 2118};
    static final int[] COPY_LENGTH_N_BITS = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};
    static final int[] INSERT_RANGE_LUT = {0, 0, 8, 8, 0, 16, 8, 16, 16};
    static final int[] COPY_RANGE_LUT = {0, 8, 0, 8, 16, 0, 16, 8, 16};

    Prefix() {
    }
}
