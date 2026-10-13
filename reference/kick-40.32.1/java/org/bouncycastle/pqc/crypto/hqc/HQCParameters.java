package org.bouncycastle.pqc.crypto.hqc;

import androidx.media3.muxer.WebmConstants;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cast.MediaError;
import org.bouncycastle.pqc.crypto.KEMParameters;

/* JADX INFO: loaded from: classes11.dex */
public class HQCParameters implements KEMParameters {
    static final int GF_MUL_ORDER = 255;
    static final int PARAM_M = 8;
    public static final HQCParameters hqc128 = new HQCParameters("hqc-128", 17669, 46, 384, 16, 31, 15, 66, 75, 75, 16767881, 4, new int[]{89, 69, 153, 116, WebmConstants.MkvEbmlElement.PIXEL_WIDTH, 117, 111, 75, 73, 233, 242, 233, 65, 210, 21, 139, 103, 173, 67, 118, 105, 210, WebmConstants.MkvEbmlElement.TRACK_ENTRY, MediaError.DetailedErrorCode.SOURCE_BUFFER_FAILURE, 74, 69, 228, 82, 255, WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY, 1});
    public static final HQCParameters hqc192 = new HQCParameters("hqc-192", 35851, 56, 640, 24, 33, 16, 100, 114, 114, 16742417, 5, new int[]{45, JfifUtil.MARKER_SOI, 239, 24, 253, 104, 27, 40, 107, 50, WebmConstants.MkvEbmlElement.SIMPLE_BLOCK, 210, 227, WebmConstants.MkvEbmlElement.CODEC_ID, 224, 158, 119, 13, 158, 1, WebmConstants.MkvEbmlElement.BLOCK_ADD_ID, 164, 82, 43, 15, 232, 246, 142, 50, 189, 29, 232, 1});
    public static final HQCParameters hqc256 = new HQCParameters("hqc-256", 57637, 90, 640, 32, 59, 29, WebmConstants.MkvEbmlElement.TRACK_TYPE, 149, 149, 16772367, 5, new int[]{49, 167, 49, 39, 200, 121, 124, 91, 240, 63, 148, 71, 150, 123, 87, 101, 32, 215, WebmConstants.MkvEbmlElement.CHANNELS, 71, 201, 115, 97, 210, WebmConstants.MkvEbmlElement.PIXEL_HEIGHT, WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS, 141, JfifUtil.MARKER_EOI, 123, 12, 31, 243, RotationOptions.ROTATE_180, 219, 152, 239, 99, 141, 4, 246, 191, 144, 8, 232, 47, 27, 141, 178, 130, 64, 124, 47, 39, 188, JfifUtil.MARKER_SOI, 48, 199, WebmConstants.MkvEbmlElement.CUE_POINT, 1});
    private int delta;
    private int fft;
    private int g;
    private int[] generatorPoly;
    private HQCEngine hqcEngine;
    private int k;
    private int n;
    private int n1;
    private int n2;
    private final String name;
    private int utilRejectionThreshold;
    private int w;
    private int we;
    private int wr;

    private HQCParameters(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int[] iArr) {
        this.name = str;
        this.n = i;
        this.n1 = i2;
        this.n2 = i3;
        this.k = i4;
        this.delta = i6;
        this.w = i7;
        this.wr = i8;
        this.we = i9;
        this.generatorPoly = iArr;
        this.g = i5;
        this.utilRejectionThreshold = i10;
        this.fft = i11;
        this.hqcEngine = new HQCEngine(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, iArr);
    }

    int getDelta() {
        return this.delta;
    }

    HQCEngine getEngine() {
        return this.hqcEngine;
    }

    int getK() {
        return this.k;
    }

    int getN() {
        return this.n;
    }

    int getN1() {
        return this.n1;
    }

    int getN1N2_BYTES() {
        return ((this.n1 * this.n2) + 7) / 8;
    }

    int getN2() {
        return this.n2;
    }

    int getN_BYTES() {
        return (this.n + 7) / 8;
    }

    public String getName() {
        return this.name;
    }

    int getSALT_SIZE_BYTES() {
        return 16;
    }

    int getSHA512_BYTES() {
        return 64;
    }

    public int getSessionKeySize() {
        return 256;
    }

    int getW() {
        return this.w;
    }

    int getWe() {
        return this.we;
    }

    int getWr() {
        return this.wr;
    }
}
