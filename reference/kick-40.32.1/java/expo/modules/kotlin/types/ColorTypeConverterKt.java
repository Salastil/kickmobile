package expo.modules.kotlin.types;

import android.graphics.Color;
import androidx.media3.muxer.WebmConstants;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imageutils.JfifUtil;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.bouncycastle.math.Primes;

/* JADX INFO: compiled from: ColorTypeConverter.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0002\u001a\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002\u001a \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002\u001a(\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0002\u001a\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0002H\u0002\u001a\u0012\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u0002H\u0002\" \u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"namedColors", "", "", "", "", "NUM", "rgbCommaSeparated", "Lkotlin/text/Regex;", "rgbSpaceSeparated", "hslCommaSeparated", "hslSpaceSeparated", "hwbPattern", "hex3", "hex4", "hex8", "parseRgbComponent", "value", "parseAlpha", "hueToRgb", ContextChain.TAG_PRODUCT, "q", "t", "hslToColor", "Landroid/graphics/Color;", "h", "s", "l", "a", "hwbToColor", "w", "b", "parseHexColor", "parseCssColorFunction", "expo-modules-core_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ColorTypeConverterKt {
    private static final String NUM = "[-+]?\\d*\\.?\\d+";
    private static final Regex hex3;
    private static final Regex hex4;
    private static final Regex hex8;
    private static final Regex hslCommaSeparated;
    private static final Regex hslSpaceSeparated;
    private static final Regex hwbPattern;
    private static final Map<String, List<Float>> namedColors;
    private static final Regex rgbCommaSeparated;
    private static final Regex rgbSpaceSeparated;

    private static final float hueToRgb(float f, float f2, float f3) {
        float f4;
        if (f3 < 0.0f) {
            f3 += 1.0f;
        } else if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        if (f3 < 0.16666667f) {
            f4 = (f2 - f) * 6.0f * f3;
        } else {
            if (f3 < 0.5f) {
                return f2;
            }
            if (f3 >= 0.6666667f) {
                return f;
            }
            f4 = (f2 - f) * (0.6666667f - f3) * 6.0f;
        }
        return f + f4;
    }

    static {
        Integer numValueOf = Integer.valueOf(MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR);
        Integer numValueOf2 = Integer.valueOf(Primes.SMALL_FACTOR_LIMIT);
        Integer numValueOf3 = Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_ADD_ID);
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to("aliceblue", new Integer[]{240, 248, 255, 255}), TuplesKt.to("antiquewhite", new Integer[]{250, 235, 215, 255}), TuplesKt.to("aqua", new Integer[]{0, 255, 255, 255}), TuplesKt.to("aquamarine", new Integer[]{127, 255, 212, 255}), TuplesKt.to("azure", new Integer[]{240, 255, 255, 255}), TuplesKt.to("beige", new Integer[]{245, 245, 220, 255}), TuplesKt.to("bisque", new Integer[]{255, 228, 196, 255}), TuplesKt.to("black", new Integer[]{0, 0, 0, 255}), TuplesKt.to("blanchedalmond", new Integer[]{255, 235, numValueOf, 255}), TuplesKt.to("blue", new Integer[]{0, 0, 255, 255}), TuplesKt.to("blueviolet", new Integer[]{138, 43, 226, 255}), TuplesKt.to("brown", new Integer[]{Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL), 42, 42, 255}), TuplesKt.to("burlywood", new Integer[]{222, 184, 135, 255}), TuplesKt.to("cadetblue", new Integer[]{95, 158, Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_GROUP), 255}), TuplesKt.to("chartreuse", new Integer[]{127, 255, 0, 255}), TuplesKt.to("chocolate", new Integer[]{210, 105, 30, 255}), TuplesKt.to("coral", new Integer[]{255, 127, 80, 255}), TuplesKt.to("cornflowerblue", new Integer[]{100, 149, 237, 255}), TuplesKt.to("cornsilk", new Integer[]{255, 248, 220, 255}), TuplesKt.to("crimson", new Integer[]{220, 20, 60, 255}), TuplesKt.to("cyan", new Integer[]{0, 255, 255, 255}), TuplesKt.to("darkblue", new Integer[]{0, 0, 139, 255}), TuplesKt.to("darkcyan", new Integer[]{0, 139, 139, 255}), TuplesKt.to("darkgoldenrod", new Integer[]{184, Integer.valueOf(WebmConstants.MkvEbmlElement.CODEC_ID), 11, 255}), TuplesKt.to("darkgray", new Integer[]{169, 169, 169, 255}), TuplesKt.to("darkgreen", new Integer[]{0, 100, 0, 255}), TuplesKt.to("darkgrey", new Integer[]{169, 169, 169, 255}), TuplesKt.to("darkkhaki", new Integer[]{189, Integer.valueOf(WebmConstants.MkvEbmlElement.CUE_TRACK_POSITIONS), 107, 255}), TuplesKt.to("darkmagenta", new Integer[]{139, 0, 139, 255}), TuplesKt.to("darkolivegreen", new Integer[]{85, 107, 47, 255}), TuplesKt.to("darkorange", new Integer[]{255, 140, 0, 255}), TuplesKt.to("darkorchid", new Integer[]{153, 50, 204, 255}), TuplesKt.to("darkred", new Integer[]{139, 0, 0, 255}), TuplesKt.to("darksalmon", new Integer[]{233, 150, 122, 255}), TuplesKt.to("darkseagreen", new Integer[]{143, 188, 143, 255}), TuplesKt.to("darkslateblue", new Integer[]{72, 61, 139, 255}), TuplesKt.to("darkslategray", new Integer[]{47, 79, 79, 255}), TuplesKt.to("darkslategrey", new Integer[]{47, 79, 79, 255}), TuplesKt.to("darkturquoise", new Integer[]{0, 206, 209, 255}), TuplesKt.to("darkviolet", new Integer[]{148, 0, numValueOf2, 255}), TuplesKt.to("deeppink", new Integer[]{255, 20, 147, 255}), TuplesKt.to("deepskyblue", new Integer[]{0, 191, 255, 255}), TuplesKt.to("dimgray", new Integer[]{105, 105, 105, 255}), TuplesKt.to("dimgrey", new Integer[]{105, 105, 105, 255}), TuplesKt.to("dodgerblue", new Integer[]{30, 144, 255, 255}), TuplesKt.to("firebrick", new Integer[]{178, 34, 34, 255}), TuplesKt.to("floralwhite", new Integer[]{255, 250, 240, 255}), TuplesKt.to("forestgreen", new Integer[]{34, 139, 34, 255}), TuplesKt.to("fuchsia", new Integer[]{255, 0, 255, 255}), TuplesKt.to("gainsboro", new Integer[]{220, 220, 220, 255}), TuplesKt.to("ghostwhite", new Integer[]{248, 248, 255, 255}), TuplesKt.to("gold", new Integer[]{255, 215, 0, 255}), TuplesKt.to("goldenrod", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOS), Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL), 32, 255}), TuplesKt.to("gray", new Integer[]{128, 128, 128, 255}), TuplesKt.to("green", new Integer[]{0, 128, 0, 255}), TuplesKt.to("greenyellow", new Integer[]{173, 255, 47, 255}), TuplesKt.to("grey", new Integer[]{128, 128, 128, 255}), TuplesKt.to("honeydew", new Integer[]{240, 255, 240, 255}), TuplesKt.to("hotpink", new Integer[]{255, 105, Integer.valueOf(RotationOptions.ROTATE_180), 255}), TuplesKt.to("indianred", new Integer[]{numValueOf, 92, 92, 255}), TuplesKt.to("indigo", new Integer[]{75, 0, 130, 255}), TuplesKt.to("ivory", new Integer[]{255, 255, 240, 255}), TuplesKt.to("khaki", new Integer[]{240, 230, 140, 255}), TuplesKt.to("lavender", new Integer[]{230, 230, 250, 255}), TuplesKt.to("lavenderblush", new Integer[]{255, 240, 245, 255}), TuplesKt.to("lawngreen", new Integer[]{124, 252, 0, 255}), TuplesKt.to("lemonchiffon", new Integer[]{255, 250, numValueOf, 255}), TuplesKt.to("lightblue", new Integer[]{173, Integer.valueOf(JfifUtil.MARKER_SOI), 230, 255}), TuplesKt.to("lightcoral", new Integer[]{240, 128, 128, 255}), TuplesKt.to("lightcyan", new Integer[]{224, 255, 255, 255}), TuplesKt.to("lightgoldenrodyellow", new Integer[]{250, 250, 210, 255}), TuplesKt.to("lightgray", new Integer[]{numValueOf2, numValueOf2, numValueOf2, 255}), TuplesKt.to("lightgreen", new Integer[]{144, numValueOf3, 144, 255}), TuplesKt.to("lightgrey", new Integer[]{numValueOf2, numValueOf2, numValueOf2, 255}), TuplesKt.to("lightpink", new Integer[]{255, 182, 193, 255}), TuplesKt.to("lightsalmon", new Integer[]{255, Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_GROUP), 122, 255}), TuplesKt.to("lightseagreen", new Integer[]{32, 178, 170, 255}), TuplesKt.to("lightskyblue", new Integer[]{135, 206, 250, 255}), TuplesKt.to("lightslategray", new Integer[]{119, Integer.valueOf(WebmConstants.MkvEbmlElement.FLAG_DEFAULT), 153, 255}), TuplesKt.to("lightslategrey", new Integer[]{119, Integer.valueOf(WebmConstants.MkvEbmlElement.FLAG_DEFAULT), 153, 255}), TuplesKt.to("lightsteelblue", new Integer[]{Integer.valueOf(WebmConstants.MkvEbmlElement.PIXEL_WIDTH), 196, 222, 255}), TuplesKt.to("lightyellow", new Integer[]{255, 255, 224, 255}), TuplesKt.to("lime", new Integer[]{0, 255, 0, 255}), TuplesKt.to("limegreen", new Integer[]{50, numValueOf, 50, 255}), TuplesKt.to("linen", new Integer[]{250, 240, 230, 255}), TuplesKt.to("magenta", new Integer[]{255, 0, 255, 255}), TuplesKt.to("maroon", new Integer[]{128, 0, 0, 255}), TuplesKt.to("mediumaquamarine", new Integer[]{102, numValueOf, 170, 255}), TuplesKt.to("mediumblue", new Integer[]{0, 0, numValueOf, 255}), TuplesKt.to("mediumorchid", new Integer[]{Integer.valueOf(WebmConstants.MkvEbmlElement.PIXEL_HEIGHT), 85, numValueOf2, 255}), TuplesKt.to("mediumpurple", new Integer[]{147, 112, 219, 255}), TuplesKt.to("mediumseagreen", new Integer[]{60, Integer.valueOf(WebmConstants.MkvEbmlElement.CUE_TIME), 113, 255}), TuplesKt.to("mediumslateblue", new Integer[]{123, 104, numValueOf3, 255}), TuplesKt.to("mediumspringgreen", new Integer[]{0, 250, Integer.valueOf(WebmConstants.MkvEbmlElement.FLAG_INTERLACED), 255}), TuplesKt.to("mediumturquoise", new Integer[]{72, 209, 204, 255}), TuplesKt.to("mediumvioletred", new Integer[]{199, 21, 133, 255}), TuplesKt.to("midnightblue", new Integer[]{25, 25, 112, 255}), TuplesKt.to("mintcream", new Integer[]{245, 255, 250, 255}), TuplesKt.to("mistyrose", new Integer[]{255, 228, 225, 255}), TuplesKt.to("moccasin", new Integer[]{255, 228, Integer.valueOf(WebmConstants.MkvEbmlElement.SAMPLING_FREQUENCY), 255}), TuplesKt.to("navajowhite", new Integer[]{255, 222, 173, 255}), TuplesKt.to("navy", new Integer[]{0, 0, 128, 255}), TuplesKt.to("oldlace", new Integer[]{253, 245, 230, 255}), TuplesKt.to("olive", new Integer[]{128, 128, 0, 255}), TuplesKt.to("olivedrab", new Integer[]{107, 142, 35, 255}), TuplesKt.to("orange", new Integer[]{255, Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_ADDITIONAL), 0, 255}), TuplesKt.to("orangered", new Integer[]{255, 69, 0, 255}), TuplesKt.to("orchid", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOS), 112, 214, 255}), TuplesKt.to("palegoldenrod", new Integer[]{numValueOf3, 232, 170, 255}), TuplesKt.to("palegreen", new Integer[]{152, Integer.valueOf(WebmConstants.MkvEbmlElement.REFERENCE_BLOCK), 152, 255}), TuplesKt.to("paleturquoise", new Integer[]{175, numValueOf3, numValueOf3, 255}), TuplesKt.to("palevioletred", new Integer[]{219, 112, 147, 255}), TuplesKt.to("papayawhip", new Integer[]{255, 239, 213, 255}), TuplesKt.to("peachpuff", new Integer[]{255, Integer.valueOf(JfifUtil.MARKER_SOS), 185, 255}), TuplesKt.to("peru", new Integer[]{numValueOf, 133, 63, 255}), TuplesKt.to("pink", new Integer[]{255, 192, 203, 255}), TuplesKt.to("plum", new Integer[]{221, Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_GROUP), 221, 255}), TuplesKt.to("powderblue", new Integer[]{Integer.valueOf(WebmConstants.MkvEbmlElement.PIXEL_WIDTH), 224, 230, 255}), TuplesKt.to("purple", new Integer[]{128, 0, 128, 255}), TuplesKt.to("rebeccapurple", new Integer[]{102, 51, 153, 255}), TuplesKt.to("red", new Integer[]{255, 0, 0, 255}), TuplesKt.to("rosybrown", new Integer[]{188, 143, 143, 255}), TuplesKt.to("royalblue", new Integer[]{65, 105, 225, 255}), TuplesKt.to("saddlebrown", new Integer[]{139, 69, 19, 255}), TuplesKt.to("salmon", new Integer[]{250, 128, 114, 255}), TuplesKt.to("sandybrown", new Integer[]{244, 164, 96, 255}), TuplesKt.to("seagreen", new Integer[]{46, 139, 87, 255}), TuplesKt.to("seashell", new Integer[]{255, 245, numValueOf3, 255}), TuplesKt.to("sienna", new Integer[]{Integer.valueOf(WebmConstants.MkvEbmlElement.BLOCK_GROUP), 82, 45, 255}), TuplesKt.to("silver", new Integer[]{192, 192, 192, 255}), TuplesKt.to("skyblue", new Integer[]{135, 206, 235, 255}), TuplesKt.to("slateblue", new Integer[]{106, 90, numValueOf, 255}), TuplesKt.to("slategray", new Integer[]{112, 128, 144, 255}), TuplesKt.to("slategrey", new Integer[]{112, 128, 144, 255}), TuplesKt.to("snow", new Integer[]{255, 250, 250, 255}), TuplesKt.to("springgreen", new Integer[]{0, 255, 127, 255}), TuplesKt.to("steelblue", new Integer[]{70, 130, Integer.valueOf(RotationOptions.ROTATE_180), 255}), TuplesKt.to("tan", new Integer[]{210, Integer.valueOf(RotationOptions.ROTATE_180), 140, 255}), TuplesKt.to("teal", new Integer[]{0, 128, 128, 255}), TuplesKt.to("thistle", new Integer[]{Integer.valueOf(JfifUtil.MARKER_SOI), 191, Integer.valueOf(JfifUtil.MARKER_SOI), 255}), TuplesKt.to("tomato", new Integer[]{255, 99, 71, 255}), TuplesKt.to("transparent", new Integer[]{0, 0, 0, 0}), TuplesKt.to("turquoise", new Integer[]{64, 224, Integer.valueOf(JfifUtil.MARKER_RST0), 255}), TuplesKt.to("violet", new Integer[]{numValueOf3, 130, numValueOf3, 255}), TuplesKt.to("wheat", new Integer[]{245, 222, Integer.valueOf(WebmConstants.MkvEbmlElement.CUE_TIME), 255}), TuplesKt.to("white", new Integer[]{255, 255, 255, 255}), TuplesKt.to("whitesmoke", new Integer[]{245, 245, 245, 255}), TuplesKt.to("yellow", new Integer[]{255, 255, 0, 255}), TuplesKt.to("yellowgreen", new Integer[]{Integer.valueOf(WebmConstants.MkvEbmlElement.FLAG_INTERLACED), numValueOf, 50, 255}));
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapMapOf.size()));
        for (Map.Entry entry : mapMapOf.entrySet()) {
            Object key = entry.getKey();
            Integer[] numArr = (Integer[]) entry.getValue();
            ArrayList arrayList = new ArrayList(numArr.length);
            for (Integer num : numArr) {
                arrayList.add(Float.valueOf(num.intValue() / 255.0f));
            }
            linkedHashMap.put(key, arrayList);
        }
        namedColors = linkedHashMap;
        rgbCommaSeparated = new Regex("rgba?\\(\\s*([-+]?\\d*\\.?\\d+%?)\\s*,\\s*([-+]?\\d*\\.?\\d+%?)\\s*,\\s*([-+]?\\d*\\.?\\d+%?)\\s*(?:,\\s*([-+]?\\d*\\.?\\d+%?)\\s*)?\\)", RegexOption.IGNORE_CASE);
        rgbSpaceSeparated = new Regex("rgba?\\(\\s*([-+]?\\d*\\.?\\d+%?)\\s+([-+]?\\d*\\.?\\d+%?)\\s+([-+]?\\d*\\.?\\d+%?)\\s*(?:/\\s*([-+]?\\d*\\.?\\d+%?)\\s*)?\\)", RegexOption.IGNORE_CASE);
        hslCommaSeparated = new Regex("hsla?\\(\\s*([-+]?\\d*\\.?\\d+)\\s*,\\s*([-+]?\\d*\\.?\\d+)%\\s*,\\s*([-+]?\\d*\\.?\\d+)%\\s*(?:,\\s*([-+]?\\d*\\.?\\d+%?)\\s*)?\\)", RegexOption.IGNORE_CASE);
        hslSpaceSeparated = new Regex("hsla?\\(\\s*([-+]?\\d*\\.?\\d+)\\s+([-+]?\\d*\\.?\\d+)%\\s+([-+]?\\d*\\.?\\d+)%\\s*(?:/\\s*([-+]?\\d*\\.?\\d+%?)\\s*)?\\)", RegexOption.IGNORE_CASE);
        hwbPattern = new Regex("hwb\\(\\s*([-+]?\\d*\\.?\\d+)\\s+([-+]?\\d*\\.?\\d+)%\\s+([-+]?\\d*\\.?\\d+)%\\s*(?:/\\s*([-+]?\\d*\\.?\\d+%?)\\s*)?\\)", RegexOption.IGNORE_CASE);
        hex3 = new Regex("^#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])$");
        hex4 = new Regex("^#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])$");
        hex8 = new Regex("^#([0-9a-fA-F]{8})$");
    }

    private static final float parseRgbComponent(String str) {
        float f;
        float f2;
        if (StringsKt.endsWith$default(str, "%", false, 2, (Object) null)) {
            f = Float.parseFloat(StringsKt.dropLast(str, 1));
            f2 = 100.0f;
        } else {
            f = Float.parseFloat(str);
            f2 = 255.0f;
        }
        return RangesKt.coerceIn(f / f2, 0.0f, 1.0f);
    }

    private static final float parseAlpha(String str) {
        float f;
        if (str == null) {
            return 1.0f;
        }
        if (StringsKt.endsWith$default(str, "%", false, 2, (Object) null)) {
            f = Float.parseFloat(StringsKt.dropLast(str, 1)) / 100.0f;
        } else {
            f = Float.parseFloat(str);
        }
        return RangesKt.coerceIn(f, 0.0f, 1.0f);
    }

    private static final Color hslToColor(float f, float f2, float f3, float f4) {
        float fHueToRgb;
        float fHueToRgb2;
        float f5 = (((f % 360.0f) + 360.0f) % 360.0f) / 360.0f;
        if (f2 == 0.0f) {
            fHueToRgb2 = f3;
            fHueToRgb = fHueToRgb2;
        } else {
            float f6 = f3 < 0.5f ? (f2 + 1.0f) * f3 : (f3 + f2) - (f2 * f3);
            float f7 = (f3 * 2.0f) - f6;
            float fHueToRgb3 = hueToRgb(f7, f6, f5 + 0.33333334f);
            fHueToRgb = hueToRgb(f7, f6, f5);
            fHueToRgb2 = hueToRgb(f7, f6, f5 - 0.33333334f);
            f3 = fHueToRgb3;
        }
        return ColorCompat.INSTANCE.valueOf(RangesKt.coerceIn(f3, 0.0f, 1.0f), RangesKt.coerceIn(fHueToRgb, 0.0f, 1.0f), RangesKt.coerceIn(fHueToRgb2, 0.0f, 1.0f), f4);
    }

    private static final Color hwbToColor(float f, float f2, float f3, float f4) {
        float fCoerceIn = RangesKt.coerceIn(f2, 0.0f, 1.0f);
        float fCoerceIn2 = RangesKt.coerceIn(f3, 0.0f, 1.0f);
        float f5 = fCoerceIn + fCoerceIn2;
        if (f5 > 1.0f) {
            fCoerceIn /= f5;
        }
        if (f5 > 1.0f) {
            fCoerceIn2 /= f5;
        }
        Color colorHslToColor = hslToColor(f, 1.0f, 0.5f, 1.0f);
        float f6 = (1.0f - fCoerceIn) - fCoerceIn2;
        return ColorCompat.INSTANCE.valueOf(RangesKt.coerceIn((ColorCompat.INSTANCE.red(colorHslToColor) * f6) + fCoerceIn, 0.0f, 1.0f), RangesKt.coerceIn((ColorCompat.INSTANCE.green(colorHslToColor) * f6) + fCoerceIn, 0.0f, 1.0f), RangesKt.coerceIn((ColorCompat.INSTANCE.blue(colorHslToColor) * f6) + fCoerceIn, 0.0f, 1.0f), f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Color parseHexColor(String str) {
        String str2 = str;
        MatchResult matchResultMatchEntire = hex3.matchEntire(str2);
        if (matchResultMatchEntire != null) {
            return ColorCompat.INSTANCE.valueOf(Integer.parseInt(StringsKt.repeat(matchResultMatchEntire.getGroupValues().get(1), 2), CharsKt.checkRadix(16)) / 255.0f, Integer.parseInt(StringsKt.repeat(matchResultMatchEntire.getGroupValues().get(2), 2), CharsKt.checkRadix(16)) / 255.0f, Integer.parseInt(StringsKt.repeat(matchResultMatchEntire.getGroupValues().get(3), 2), CharsKt.checkRadix(16)) / 255.0f, 1.0f);
        }
        MatchResult matchResultMatchEntire2 = hex4.matchEntire(str2);
        if (matchResultMatchEntire2 != null) {
            return ColorCompat.INSTANCE.valueOf(Integer.parseInt(StringsKt.repeat(matchResultMatchEntire2.getGroupValues().get(1), 2), CharsKt.checkRadix(16)) / 255.0f, Integer.parseInt(StringsKt.repeat(matchResultMatchEntire2.getGroupValues().get(2), 2), CharsKt.checkRadix(16)) / 255.0f, Integer.parseInt(StringsKt.repeat(matchResultMatchEntire2.getGroupValues().get(3), 2), CharsKt.checkRadix(16)) / 255.0f, Integer.parseInt(StringsKt.repeat(matchResultMatchEntire2.getGroupValues().get(4), 2), CharsKt.checkRadix(16)) / 255.0f);
        }
        MatchResult matchResultMatchEntire3 = hex8.matchEntire(str2);
        if (matchResultMatchEntire3 == null) {
            return null;
        }
        long j = Long.parseLong(matchResultMatchEntire3.getGroupValues().get(1), CharsKt.checkRadix(16));
        return ColorCompat.INSTANCE.valueOf(((int) ((j >> 24) & 255)) / 255.0f, ((int) ((j >> 16) & 255)) / 255.0f, ((int) ((j >> 8) & 255)) / 255.0f, ((int) (j & 255)) / 255.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Color parseCssColorFunction(String str) {
        String lowerCase = StringsKt.trim((CharSequence) str).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = lowerCase;
        MatchResult matchResultMatchEntire = rgbCommaSeparated.matchEntire(str2);
        if (matchResultMatchEntire == null) {
            matchResultMatchEntire = rgbSpaceSeparated.matchEntire(str2);
        }
        if (matchResultMatchEntire != null) {
            float rgbComponent = parseRgbComponent(matchResultMatchEntire.getGroupValues().get(1));
            float rgbComponent2 = parseRgbComponent(matchResultMatchEntire.getGroupValues().get(2));
            float rgbComponent3 = parseRgbComponent(matchResultMatchEntire.getGroupValues().get(3));
            String str3 = matchResultMatchEntire.getGroupValues().get(4);
            return ColorCompat.INSTANCE.valueOf(rgbComponent, rgbComponent2, rgbComponent3, parseAlpha(str3.length() != 0 ? str3 : null));
        }
        MatchResult matchResultMatchEntire2 = hslCommaSeparated.matchEntire(str2);
        if (matchResultMatchEntire2 == null) {
            matchResultMatchEntire2 = hslSpaceSeparated.matchEntire(str2);
        }
        if (matchResultMatchEntire2 != null) {
            float f = Float.parseFloat(matchResultMatchEntire2.getGroupValues().get(1));
            float f2 = Float.parseFloat(matchResultMatchEntire2.getGroupValues().get(2)) / 100.0f;
            float f3 = Float.parseFloat(matchResultMatchEntire2.getGroupValues().get(3)) / 100.0f;
            String str4 = matchResultMatchEntire2.getGroupValues().get(4);
            return hslToColor(f, RangesKt.coerceIn(f2, 0.0f, 1.0f), RangesKt.coerceIn(f3, 0.0f, 1.0f), parseAlpha(str4.length() != 0 ? str4 : null));
        }
        MatchResult matchResultMatchEntire3 = hwbPattern.matchEntire(str2);
        if (matchResultMatchEntire3 == null) {
            return null;
        }
        float f4 = Float.parseFloat(matchResultMatchEntire3.getGroupValues().get(1));
        float f5 = Float.parseFloat(matchResultMatchEntire3.getGroupValues().get(2)) / 100.0f;
        float f6 = Float.parseFloat(matchResultMatchEntire3.getGroupValues().get(3)) / 100.0f;
        String str5 = matchResultMatchEntire3.getGroupValues().get(4);
        return hwbToColor(f4, f5, f6, parseAlpha(str5.length() != 0 ? str5 : null));
    }
}
