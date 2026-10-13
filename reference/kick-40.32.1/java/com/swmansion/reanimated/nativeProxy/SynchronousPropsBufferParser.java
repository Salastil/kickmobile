package com.swmansion.reanimated.nativeProxy;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.uimanager.ViewProps;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SynchronousPropsBufferParser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020\u0005H\u0002JN\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D26\u0010E\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0013\u0012\u00110J¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020@0FR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/swmansion/reanimated/nativeProxy/SynchronousPropsBufferParser;", "", "<init>", "()V", "CMD_START_OF_VIEW", "", "CMD_START_OF_TRANSFORM", "CMD_END_OF_TRANSFORM", "CMD_END_OF_VIEW", "CMD_OPACITY", "CMD_ELEVATION", "CMD_SHADOW_COLOR", "CMD_BACKGROUND_COLOR", "CMD_TINT_COLOR", "CMD_PLACEHOLDER_TEXT_COLOR", "CMD_BORDER_RADIUS", "CMD_BORDER_TOP_LEFT_RADIUS", "CMD_BORDER_TOP_RIGHT_RADIUS", "CMD_BORDER_TOP_START_RADIUS", "CMD_BORDER_TOP_END_RADIUS", "CMD_BORDER_BOTTOM_LEFT_RADIUS", "CMD_BORDER_BOTTOM_RIGHT_RADIUS", "CMD_BORDER_BOTTOM_START_RADIUS", "CMD_BORDER_BOTTOM_END_RADIUS", "CMD_BORDER_START_START_RADIUS", "CMD_BORDER_START_END_RADIUS", "CMD_BORDER_END_START_RADIUS", "CMD_BORDER_END_END_RADIUS", "CMD_BORDER_COLOR", "CMD_BORDER_TOP_COLOR", "CMD_BORDER_BOTTOM_COLOR", "CMD_BORDER_LEFT_COLOR", "CMD_BORDER_RIGHT_COLOR", "CMD_BORDER_START_COLOR", "CMD_BORDER_END_COLOR", "CMD_BORDER_BLOCK_COLOR", "CMD_BORDER_BLOCK_START_COLOR", "CMD_BORDER_BLOCK_END_COLOR", "CMD_OUTLINE_COLOR", "CMD_OUTLINE_OFFSET", "CMD_OUTLINE_WIDTH", "CMD_TRANSFORM_TRANSLATE_X", "CMD_TRANSFORM_TRANSLATE_Y", "CMD_TRANSFORM_SCALE", "CMD_TRANSFORM_SCALE_X", "CMD_TRANSFORM_SCALE_Y", "CMD_TRANSFORM_ROTATE", "CMD_TRANSFORM_ROTATE_X", "CMD_TRANSFORM_ROTATE_Y", "CMD_TRANSFORM_ROTATE_Z", "CMD_TRANSFORM_SKEW_X", "CMD_TRANSFORM_SKEW_Y", "CMD_TRANSFORM_MATRIX", "CMD_TRANSFORM_PERSPECTIVE", "CMD_UNIT_DEG", "CMD_UNIT_RAD", "CMD_UNIT_PX", "CMD_UNIT_PERCENT", "commandToString", "", "command", "transformCommandToString", "transformCommand", "parse", "", "intBuffer", "", "doubleBuffer", "", "applyProps", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "viewTag", "Lcom/facebook/react/bridge/JavaOnlyMap;", "props", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SynchronousPropsBufferParser {
    private static final int CMD_BACKGROUND_COLOR = 15;
    private static final int CMD_BORDER_BLOCK_COLOR = 47;
    private static final int CMD_BORDER_BLOCK_END_COLOR = 49;
    private static final int CMD_BORDER_BLOCK_START_COLOR = 48;
    private static final int CMD_BORDER_BOTTOM_COLOR = 42;
    private static final int CMD_BORDER_BOTTOM_END_RADIUS = 28;
    private static final int CMD_BORDER_BOTTOM_LEFT_RADIUS = 25;
    private static final int CMD_BORDER_BOTTOM_RIGHT_RADIUS = 26;
    private static final int CMD_BORDER_BOTTOM_START_RADIUS = 27;
    private static final int CMD_BORDER_COLOR = 40;
    private static final int CMD_BORDER_END_COLOR = 46;
    private static final int CMD_BORDER_END_END_RADIUS = 32;
    private static final int CMD_BORDER_END_START_RADIUS = 31;
    private static final int CMD_BORDER_LEFT_COLOR = 43;
    private static final int CMD_BORDER_RADIUS = 20;
    private static final int CMD_BORDER_RIGHT_COLOR = 44;
    private static final int CMD_BORDER_START_COLOR = 45;
    private static final int CMD_BORDER_START_END_RADIUS = 30;
    private static final int CMD_BORDER_START_START_RADIUS = 29;
    private static final int CMD_BORDER_TOP_COLOR = 41;
    private static final int CMD_BORDER_TOP_END_RADIUS = 24;
    private static final int CMD_BORDER_TOP_LEFT_RADIUS = 21;
    private static final int CMD_BORDER_TOP_RIGHT_RADIUS = 22;
    private static final int CMD_BORDER_TOP_START_RADIUS = 23;
    private static final int CMD_ELEVATION = 11;
    private static final int CMD_END_OF_TRANSFORM = 3;
    private static final int CMD_END_OF_VIEW = 4;
    private static final int CMD_OPACITY = 10;
    private static final int CMD_OUTLINE_COLOR = 50;
    private static final int CMD_OUTLINE_OFFSET = 51;
    private static final int CMD_OUTLINE_WIDTH = 52;
    private static final int CMD_PLACEHOLDER_TEXT_COLOR = 18;
    private static final int CMD_SHADOW_COLOR = 19;
    private static final int CMD_START_OF_TRANSFORM = 2;
    private static final int CMD_START_OF_VIEW = 1;
    private static final int CMD_TINT_COLOR = 17;
    private static final int CMD_TRANSFORM_MATRIX = 111;
    private static final int CMD_TRANSFORM_PERSPECTIVE = 112;
    private static final int CMD_TRANSFORM_ROTATE = 105;
    private static final int CMD_TRANSFORM_ROTATE_X = 106;
    private static final int CMD_TRANSFORM_ROTATE_Y = 107;
    private static final int CMD_TRANSFORM_ROTATE_Z = 108;
    private static final int CMD_TRANSFORM_SCALE = 102;
    private static final int CMD_TRANSFORM_SCALE_X = 103;
    private static final int CMD_TRANSFORM_SCALE_Y = 104;
    private static final int CMD_TRANSFORM_SKEW_X = 109;
    private static final int CMD_TRANSFORM_SKEW_Y = 110;
    private static final int CMD_TRANSFORM_TRANSLATE_X = 100;
    private static final int CMD_TRANSFORM_TRANSLATE_Y = 101;
    private static final int CMD_UNIT_DEG = 200;
    private static final int CMD_UNIT_PERCENT = 203;
    private static final int CMD_UNIT_PX = 202;
    private static final int CMD_UNIT_RAD = 201;
    public static final SynchronousPropsBufferParser INSTANCE = new SynchronousPropsBufferParser();

    private SynchronousPropsBufferParser() {
    }

    private final String commandToString(int command) {
        if (command == 10) {
            return ViewProps.OPACITY;
        }
        if (command == 11) {
            return "elevation";
        }
        if (command == 15) {
            return ViewProps.BACKGROUND_COLOR;
        }
        switch (command) {
            case 17:
                return "tintColor";
            case 18:
                return "placeholderTextColor";
            case 19:
                return ViewProps.SHADOW_COLOR;
            case 20:
                return ViewProps.BORDER_RADIUS;
            case 21:
                return ViewProps.BORDER_TOP_LEFT_RADIUS;
            case 22:
                return ViewProps.BORDER_TOP_RIGHT_RADIUS;
            case 23:
                return ViewProps.BORDER_TOP_START_RADIUS;
            case 24:
                return ViewProps.BORDER_TOP_END_RADIUS;
            case 25:
                return ViewProps.BORDER_BOTTOM_LEFT_RADIUS;
            case 26:
                return ViewProps.BORDER_BOTTOM_RIGHT_RADIUS;
            case 27:
                return ViewProps.BORDER_BOTTOM_START_RADIUS;
            case 28:
                return ViewProps.BORDER_BOTTOM_END_RADIUS;
            case 29:
                return ViewProps.BORDER_START_START_RADIUS;
            case 30:
                return ViewProps.BORDER_START_END_RADIUS;
            case 31:
                return ViewProps.BORDER_END_START_RADIUS;
            case 32:
                return ViewProps.BORDER_END_END_RADIUS;
            default:
                switch (command) {
                    case 40:
                        return ViewProps.BORDER_COLOR;
                    case 41:
                        return ViewProps.BORDER_TOP_COLOR;
                    case 42:
                        return ViewProps.BORDER_BOTTOM_COLOR;
                    case 43:
                        return ViewProps.BORDER_LEFT_COLOR;
                    case 44:
                        return ViewProps.BORDER_RIGHT_COLOR;
                    case 45:
                        return ViewProps.BORDER_START_COLOR;
                    case 46:
                        return ViewProps.BORDER_END_COLOR;
                    case 47:
                        return ViewProps.BORDER_BLOCK_COLOR;
                    case 48:
                        return ViewProps.BORDER_BLOCK_START_COLOR;
                    case 49:
                        return ViewProps.BORDER_BLOCK_END_COLOR;
                    case 50:
                        return ViewProps.OUTLINE_COLOR;
                    case 51:
                        return ViewProps.OUTLINE_OFFSET;
                    case 52:
                        return ViewProps.OUTLINE_WIDTH;
                    default:
                        throw new RuntimeException("Unknown command: " + command);
                }
        }
    }

    private final String transformCommandToString(int transformCommand) {
        switch (transformCommand) {
            case 100:
                return ViewProps.TRANSLATE_X;
            case 101:
                return ViewProps.TRANSLATE_Y;
            case 102:
                return "scale";
            case 103:
                return "scaleX";
            case 104:
                return "scaleY";
            case 105:
                return "rotate";
            case CMD_TRANSFORM_ROTATE_X /* 106 */:
                return "rotateX";
            case CMD_TRANSFORM_ROTATE_Y /* 107 */:
                return "rotateY";
            case 108:
                return "rotateZ";
            case 109:
                return "skewX";
            case 110:
                return "skewY";
            case CMD_TRANSFORM_MATRIX /* 111 */:
                return "matrix";
            case CMD_TRANSFORM_PERSPECTIVE /* 112 */:
                return "perspective";
            default:
                throw new RuntimeException("Unknown transform command: " + transformCommand);
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.PrimitiveIterator$OfInt] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.PrimitiveIterator$OfDouble] */
    public final void parse(int[] intBuffer, double[] doubleBuffer, Function2<? super Integer, ? super JavaOnlyMap, Unit> applyProps) {
        String str;
        char c;
        Intrinsics.checkNotNullParameter(intBuffer, "intBuffer");
        Intrinsics.checkNotNullParameter(doubleBuffer, "doubleBuffer");
        Intrinsics.checkNotNullParameter(applyProps, "applyProps");
        ?? it = Arrays.stream(intBuffer).iterator();
        ?? it2 = Arrays.stream(doubleBuffer).iterator();
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        int iNextInt = -1;
        while (it.hasNext()) {
            int iNextInt2 = it.nextInt();
            if (iNextInt2 == 1) {
                iNextInt = it.nextInt();
                javaOnlyMap = new JavaOnlyMap();
            } else if (iNextInt2 == 2) {
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                while (true) {
                    int iNextInt3 = it.nextInt();
                    if (iNextInt3 == 3) {
                        javaOnlyMap.putArray(ViewProps.TRANSFORM, javaOnlyArray);
                        break;
                    }
                    String strTransformCommandToString = transformCommandToString(iNextInt3);
                    switch (iNextInt3) {
                        case 100:
                        case 101:
                            double dNextDouble = it2.nextDouble();
                            int iNextInt4 = it.nextInt();
                            if (iNextInt4 != 202) {
                                c = 203;
                                if (iNextInt4 != 203) {
                                    throw new RuntimeException("Unknown unit command");
                                }
                                javaOnlyArray.pushMap(JavaOnlyMap.INSTANCE.of(strTransformCommandToString, dNextDouble + "%"));
                            } else {
                                c = 203;
                                javaOnlyArray.pushMap(JavaOnlyMap.INSTANCE.of(strTransformCommandToString, Double.valueOf(dNextDouble)));
                            }
                            break;
                        case 102:
                        case 103:
                        case 104:
                        case CMD_TRANSFORM_PERSPECTIVE /* 112 */:
                            javaOnlyArray.pushMap(JavaOnlyMap.INSTANCE.of(strTransformCommandToString, Double.valueOf(it2.nextDouble())));
                            break;
                        case 105:
                        case CMD_TRANSFORM_ROTATE_X /* 106 */:
                        case CMD_TRANSFORM_ROTATE_Y /* 107 */:
                        case 108:
                        case 109:
                        case 110:
                            double dNextDouble2 = it2.nextDouble();
                            int iNextInt5 = it.nextInt();
                            if (iNextInt5 == 200) {
                                str = "deg";
                            } else if (iNextInt5 == 201) {
                                str = "rad";
                            } else {
                                throw new RuntimeException("Unknown unit command");
                            }
                            javaOnlyArray.pushMap(JavaOnlyMap.INSTANCE.of(strTransformCommandToString, dNextDouble2 + str));
                            break;
                        case CMD_TRANSFORM_MATRIX /* 111 */:
                            int iNextInt6 = it.nextInt();
                            JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
                            for (int i = 0; i < iNextInt6; i++) {
                                javaOnlyArray2.pushDouble(it2.nextDouble());
                            }
                            javaOnlyArray.pushMap(JavaOnlyMap.INSTANCE.of(strTransformCommandToString, javaOnlyArray2));
                            break;
                        default:
                            throw new RuntimeException("Unknown transform type: " + iNextInt3);
                    }
                }
            } else if (iNextInt2 != 4) {
                if (iNextInt2 != 15) {
                    if (iNextInt2 != 10 && iNextInt2 != 11) {
                        switch (iNextInt2) {
                            case 17:
                            case 18:
                            case 19:
                                break;
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                                String strCommandToString = commandToString(iNextInt2);
                                double dNextDouble3 = it2.nextDouble();
                                int iNextInt7 = it.nextInt();
                                if (iNextInt7 == 202) {
                                    javaOnlyMap.putDouble(strCommandToString, dNextDouble3);
                                } else {
                                    if (iNextInt7 != 203) {
                                        throw new RuntimeException("Unknown unit command");
                                    }
                                    javaOnlyMap.putString(strCommandToString, dNextDouble3 + "%");
                                }
                                break;
                            default:
                                switch (iNextInt2) {
                                    case 40:
                                    case 41:
                                    case 42:
                                    case 43:
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case 48:
                                    case 49:
                                    case 50:
                                        break;
                                    case 51:
                                    case 52:
                                        break;
                                    default:
                                        throw new RuntimeException("Unexpected command: " + iNextInt2);
                                }
                                break;
                        }
                    }
                    javaOnlyMap.putDouble(commandToString(iNextInt2), it2.nextDouble());
                }
                javaOnlyMap.putInt(commandToString(iNextInt2), it.nextInt());
            } else {
                applyProps.invoke(Integer.valueOf(iNextInt), javaOnlyMap);
            }
        }
    }
}
