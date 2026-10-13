package com.facebook.react.uimanager.style;

import android.content.Context;
import android.graphics.Shader;
import com.datadog.android.rum.internal.domain.event.RumEventSerializer;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LinearGradient.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J,\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient;", "Lcom/facebook/react/uimanager/style/Gradient;", "direction", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "colorStops", "", "Lcom/facebook/react/uimanager/style/ColorStop;", "<init>", "(Lcom/facebook/react/uimanager/style/LinearGradient$Direction;Ljava/util/List;)V", "getDirection", "()Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "getColorStops", "()Ljava/util/List;", "getShader", "Landroid/graphics/Shader;", ViewProps.WIDTH, "", ViewProps.HEIGHT, "getAngleForKeyword", "", "keyword", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$KeywordType;", "endPointsFromAngle", "Lkotlin/Pair;", "", "angle", "Companion", "Direction", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LinearGradient implements Gradient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<ColorStop> colorStops;
    private final Direction direction;

    /* JADX INFO: compiled from: LinearGradient.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Direction.KeywordType.values().length];
            try {
                iArr[Direction.KeywordType.TO_TOP_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Direction.KeywordType.TO_BOTTOM_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Direction.KeywordType.TO_TOP_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Direction.KeywordType.TO_BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LinearGradient(Direction direction, List<ColorStop> colorStops) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(colorStops, "colorStops");
        this.direction = direction;
        this.colorStops = colorStops;
    }

    public final List<ColorStop> getColorStops() {
        return this.colorStops;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    /* JADX INFO: compiled from: LinearGradient.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Companion;", "", "<init>", "()V", "parse", "Lcom/facebook/react/uimanager/style/Gradient;", "gradientMap", "Lcom/facebook/react/bridge/ReadableMap;", RumEventSerializer.GLOBAL_ATTRIBUTE_PREFIX, "Landroid/content/Context;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:20:0x005a  */
        public final Gradient parse(ReadableMap gradientMap, Context context) {
            Direction.Keyword keyword;
            ArrayList arrayList;
            Integer numValueOf;
            Intrinsics.checkNotNullParameter(gradientMap, "gradientMap");
            Intrinsics.checkNotNullParameter(context, "context");
            ReadableMap readableMap = gradientMap.hasKey("direction") ? gradientMap : null;
            if (readableMap == null) {
                keyword = null;
            } else {
                ReadableMap map = readableMap.getMap("direction");
                if (map == null) {
                    return null;
                }
                String string = map.getString("type");
                if (Intrinsics.areEqual(string, "angle")) {
                    keyword = new Direction.Angle(map.getDouble("value"));
                } else if (Intrinsics.areEqual(string, "keyword")) {
                    Direction.KeywordType keywordTypeFromString = Direction.KeywordType.INSTANCE.fromString(map.getString("value"));
                    keyword = keywordTypeFromString != null ? new Direction.Keyword(keywordTypeFromString) : null;
                } else {
                    keyword = null;
                }
            }
            if (!gradientMap.hasKey("colorStops")) {
                gradientMap = null;
            }
            if (gradientMap != null) {
                ReadableArray array = gradientMap.getArray("colorStops");
                if (array == null) {
                    return null;
                }
                arrayList = new ArrayList(array.size());
                int size = array.size();
                for (int i = 0; i < size; i++) {
                    ReadableMap map2 = array.getMap(i);
                    if (map2 != null) {
                        if (!map2.hasKey("color") || map2.isNull("color")) {
                            numValueOf = null;
                        } else if (map2.getType("color") == ReadableType.Map) {
                            numValueOf = ColorPropConverter.getColor(map2.getMap("color"), context);
                        } else {
                            numValueOf = Integer.valueOf(map2.getInt("color"));
                        }
                        arrayList.add(new ColorStop(numValueOf, LengthPercentage.Companion.setFromDynamic$default(LengthPercentage.INSTANCE, map2.getDynamic(ViewProps.POSITION), false, 2, null)));
                    }
                }
            } else {
                arrayList = null;
            }
            if (keyword == null || arrayList == null) {
                return null;
            }
            return new LinearGradient(keyword, arrayList);
        }
    }

    /* JADX INFO: compiled from: LinearGradient.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "", "<init>", "()V", "Angle", "Keyword", "KeywordType", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Angle;", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keyword;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Direction {
        public /* synthetic */ Direction(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Direction() {
        }

        /* JADX INFO: compiled from: LinearGradient.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Angle;", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "angle", "", "<init>", "(D)V", "getAngle", "()D", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Angle extends Direction {
            private final double angle;

            public Angle(double d) {
                super(null);
                this.angle = d;
            }

            public final double getAngle() {
                return this.angle;
            }
        }

        /* JADX INFO: compiled from: LinearGradient.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction$Keyword;", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction;", "keyword", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$KeywordType;", "<init>", "(Lcom/facebook/react/uimanager/style/LinearGradient$Direction$KeywordType;)V", "getKeyword", "()Lcom/facebook/react/uimanager/style/LinearGradient$Direction$KeywordType;", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Keyword extends Direction {
            private final KeywordType keyword;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Keyword(KeywordType keyword) {
                super(null);
                Intrinsics.checkNotNullParameter(keyword, "keyword");
                this.keyword = keyword;
            }

            public final KeywordType getKeyword() {
                return this.keyword;
            }
        }

        /* JADX INFO: compiled from: LinearGradient.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction$KeywordType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TO_TOP_RIGHT", "TO_BOTTOM_RIGHT", "TO_TOP_LEFT", "TO_BOTTOM_LEFT", "Companion", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public enum KeywordType {
            TO_TOP_RIGHT("to top right"),
            TO_BOTTOM_RIGHT("to bottom right"),
            TO_TOP_LEFT("to top left"),
            TO_BOTTOM_LEFT("to bottom left");

            private final String value;
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            public static EnumEntries<KeywordType> getEntries() {
                return $ENTRIES;
            }

            KeywordType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }

            /* JADX INFO: compiled from: LinearGradient.kt */
            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/react/uimanager/style/LinearGradient$Direction$KeywordType$Companion;", "", "<init>", "()V", "fromString", "Lcom/facebook/react/uimanager/style/LinearGradient$Direction$KeywordType;", "value", "", "ReactAndroid"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                public final KeywordType fromString(String value) {
                    for (KeywordType keywordType : KeywordType.values()) {
                        if (Intrinsics.areEqual(keywordType.getValue(), value)) {
                            return keywordType;
                        }
                    }
                    return null;
                }
            }
        }
    }

    @Override // com.facebook.react.uimanager.style.Gradient
    public Shader getShader(float width, float height) {
        LinearGradient linearGradient;
        double angleForKeyword;
        Direction direction = this.direction;
        if (direction instanceof Direction.Angle) {
            angleForKeyword = ((Direction.Angle) direction).getAngle();
            linearGradient = this;
        } else {
            if (!(direction instanceof Direction.Keyword)) {
                throw new NoWhenBranchMatchedException();
            }
            linearGradient = this;
            angleForKeyword = linearGradient.getAngleForKeyword(((Direction.Keyword) direction).getKeyword(), width, height);
        }
        Pair<float[], float[]> pairEndPointsFromAngle = linearGradient.endPointsFromAngle(angleForKeyword, height, width);
        float[] fArrComponent1 = pairEndPointsFromAngle.component1();
        float[] fArrComponent2 = pairEndPointsFromAngle.component2();
        float f = fArrComponent2[0] - fArrComponent1[0];
        float f2 = fArrComponent2[1] - fArrComponent1[1];
        List<ProcessedColorStop> fixedColorStops = ColorStopUtils.INSTANCE.getFixedColorStops(linearGradient.colorStops, (float) Math.sqrt((f * f) + (f2 * f2)));
        int[] iArr = new int[fixedColorStops.size()];
        float[] fArr = new float[fixedColorStops.size()];
        int i = 0;
        for (Object obj : fixedColorStops) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ProcessedColorStop processedColorStop = (ProcessedColorStop) obj;
            Integer color = processedColorStop.getColor();
            if (color != null && processedColorStop.getPosition() != null) {
                iArr[i] = color.intValue();
                fArr[i] = processedColorStop.getPosition().floatValue();
            }
            i = i2;
        }
        return new android.graphics.LinearGradient(fArrComponent1[0], fArrComponent1[1], fArrComponent2[0], fArrComponent2[1], iArr, fArr, Shader.TileMode.CLAMP);
    }

    private final double getAngleForKeyword(Direction.KeywordType keyword, double width, double height) {
        int i = WhenMappings.$EnumSwitchMapping$0[keyword.ordinal()];
        if (i == 1) {
            return 90.0d - Math.toDegrees(Math.atan(width / height));
        }
        if (i == 2) {
            return Math.toDegrees(Math.atan(width / height)) + 90.0d;
        }
        if (i == 3) {
            return Math.toDegrees(Math.atan(width / height)) + 270.0d;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return Math.toDegrees(Math.atan(height / width)) + 180.0d;
    }

    private final Pair<float[], float[]> endPointsFromAngle(double angle, float height, float width) {
        float[] fArr;
        double d = angle % 360.0d;
        if (d < 0.0d) {
            d += 360.0d;
        }
        if (d == 0.0d) {
            return new Pair<>(new float[]{0.0f, height}, new float[]{0.0f, 0.0f});
        }
        if (d == 90.0d) {
            return new Pair<>(new float[]{0.0f, 0.0f}, new float[]{width, 0.0f});
        }
        if (d == 180.0d) {
            return new Pair<>(new float[]{0.0f, 0.0f}, new float[]{0.0f, height});
        }
        if (d == 270.0d) {
            return new Pair<>(new float[]{width, 0.0f}, new float[]{0.0f, 0.0f});
        }
        float fTan = (float) Math.tan(Math.toRadians(90.0d - d));
        float f = (-1.0f) / fTan;
        float f2 = height / 2.0f;
        float f3 = width / 2.0f;
        if (d < 90.0d) {
            fArr = new float[]{f3, f2};
        } else if (d < 180.0d) {
            fArr = new float[]{f3, -f2};
        } else if (d < 270.0d) {
            fArr = new float[]{-f3, -f2};
        } else {
            fArr = new float[]{-f3, f2};
        }
        float f4 = fArr[1] - (fArr[0] * f);
        float f5 = f4 / (fTan - f);
        float f6 = (f * f5) + f4;
        return new Pair<>(new float[]{f3 - f5, f2 + f6}, new float[]{f3 + f5, f2 - f6});
    }
}
