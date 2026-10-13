package androidx.media3.muxer;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes5.dex */
final class WebmConstants {
    public static final int MAX_META_SEEK_SIZE = 72;
    public static final long MKV_UNKNOWN_LENGTH = 144115188075855871L;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MkvEbmlElement {
        public static final int ALPHA_MODE = 21440;
        public static final int ASPECT_RATIO_TYPE = 21683;
        public static final int AUDIO = 225;
        public static final int BIT_DEPTH = 25188;
        public static final int BLOCK = 161;
        public static final int BLOCK_ADDITIONAL = 165;
        public static final int BLOCK_ADDITIONS = 30113;
        public static final int BLOCK_ADD_ID = 238;
        public static final int BLOCK_DURATION = 155;
        public static final int BLOCK_GROUP = 160;
        public static final int BLOCK_MORE = 166;
        public static final int CHANNELS = 159;
        public static final int CLUSTER = 524531317;
        public static final int CODEC_ID = 134;
        public static final int CODEC_NAME = 2459272;
        public static final int CODEC_PRIVATE = 25506;
        public static final int COLOUR = 21936;
        public static final int CUES = 475249515;
        public static final int CUE_BLOCK_NUMBER = 21368;
        public static final int CUE_CLUSTER_POSITION = 241;
        public static final int CUE_POINT = 187;
        public static final int CUE_TIME = 179;
        public static final int CUE_TRACK = 247;
        public static final int CUE_TRACK_POSITIONS = 183;
        public static final int DATE_UTC = 17505;
        public static final int DEFAULT_DURATION = 2352003;
        public static final int DISPLAY_HEIGHT = 21690;
        public static final int DISPLAY_UNIT = 21682;
        public static final int DISPLAY_WIDTH = 21680;
        public static final int DOC_TYPE = 17026;
        public static final int DOC_TYPE_READ_VERSION = 17029;
        public static final int DOC_TYPE_VERSION = 17031;
        public static final int EBML = 440786851;
        public static final int EBML_MAX_ID_LENGTH = 17138;
        public static final int EBML_MAX_SIZE_LENGTH = 17139;
        public static final int EBML_READ_VERSION = 17143;
        public static final int EBML_VERSION = 17030;
        public static final int FLAG_DEFAULT = 136;
        public static final int FLAG_ENABLED = 185;
        public static final int FLAG_FORCED = 21930;
        public static final int FLAG_INTERLACED = 154;
        public static final int FLAG_LACING = 156;
        public static final int FRAME_RATE = 2327523;
        public static final int INFO = 357149030;
        public static final int LACE_NUMBER = 204;
        public static final int LANGUAGE = 2274716;
        public static final int LUMINANCE_MAX = 21977;
        public static final int LUMINANCE_MIN = 21978;
        public static final int MASTERING_METADATA = 21968;
        public static final int MATRIX_COEFFICIENTS = 21937;
        public static final int MAX_BLOCK_ADDITION_ID = 21998;
        public static final int MAX_CLL = 21948;
        public static final int MAX_FALL = 21949;
        public static final int MUXING_APP = 19840;
        public static final int NAME = 21358;
        public static final int OUTPUT_SAMPLING_FREQUENCY = 30901;
        public static final int PIXEL_CROP_BOTTOM = 21674;
        public static final int PIXEL_CROP_LEFT = 21708;
        public static final int PIXEL_CROP_RIGHT = 21725;
        public static final int PIXEL_CROP_TOP = 21691;
        public static final int PIXEL_HEIGHT = 186;
        public static final int PIXEL_WIDTH = 176;
        public static final int PREV_SIZE = 171;
        public static final int PRIMARIES = 21947;
        public static final int PRIMARY_B_CHROMATICITY_X = 21973;
        public static final int PRIMARY_B_CHROMATICITY_Y = 21974;
        public static final int PRIMARY_G_CHROMATICITY_X = 21971;
        public static final int PRIMARY_G_CHROMATICITY_Y = 21972;
        public static final int PRIMARY_R_CHROMATICITY_X = 21969;
        public static final int PRIMARY_R_CHROMATICITY_Y = 21970;
        public static final int RANGE = 21945;
        public static final int REFERENCE_BLOCK = 251;
        public static final int SAMPLING_FREQUENCY = 181;
        public static final int SEEK = 19899;
        public static final int SEEK_HEAD = 290298740;
        public static final int SEEK_ID = 21419;
        public static final int SEEK_POSITION = 21420;
        public static final int SEGMENT = 408125543;
        public static final int SEGMENT_DURATION = 17545;
        public static final int SIGNATURE = 32437;
        public static final int SIGNATURE_ALGO = 32394;
        public static final int SIGNATURE_ELEMENTS = 32347;
        public static final int SIGNATURE_ELEMENT_LIST = 32379;
        public static final int SIGNATURE_HASH = 32410;
        public static final int SIGNATURE_PUBLIC_KEY = 32421;
        public static final int SIGNATURE_SLOT = 458458727;
        public static final int SIGNED_ELEMENT = 25906;
        public static final int SIMPLE_BLOCK = 163;
        public static final int STEREO_MODE = 21432;
        public static final int TIMESTAMP = 231;
        public static final int TIMESTAMP_SCALE = 2807729;
        public static final int TRACKS = 374648427;
        public static final int TRACK_ENTRY = 174;
        public static final int TRACK_NUMBER = 215;
        public static final int TRACK_TYPE = 131;
        public static final int TRACK_UID = 29637;
        public static final int TRANSFER_CHARACTERISTICS = 21946;
        public static final int VIDEO = 224;
        public static final int VOID = 236;
        public static final int WHITE_POINT_CHROMATICITY_X = 21975;
        public static final int WHITE_POINT_CHROMATICITY_Y = 21976;
        public static final int WRITING_APP = 22337;
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackNumber {
        public static final int AUDIO = 2;
        public static final int VIDEO = 1;
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TrackType {
        public static final int AUDIO = 2;
        public static final int BUTTONS = 18;
        public static final int COMPLEX = 3;
        public static final int CONTROL = 32;
        public static final int INVALID = -1;
        public static final int LOGO = 16;
        public static final int SUBTITLE = 17;
        public static final int VIDEO = 1;
    }

    private WebmConstants() {
    }
}
