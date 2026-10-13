package expo.modules.kotlin.types;

import android.graphics.Color;
import android.os.Build;
import com.datadog.trace.bootstrap.instrumentation.api.Tags;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ColorCompat.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/types/ColorCompat;", "", "<init>", "()V", "Companion", "LegacyColor", "Api26Impl", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ColorCompat {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LegacyColor defaultLegacyColor = new LegacyColor(0.0f, 0.0f, 0.0f, 1.0f, -16777216);

    @JvmStatic
    public static final float alpha(Color color) {
        return INSTANCE.alpha(color);
    }

    @JvmStatic
    public static final float blue(Color color) {
        return INSTANCE.blue(color);
    }

    @JvmStatic
    public static final float green(Color color) {
        return INSTANCE.green(color);
    }

    @JvmStatic
    public static final float red(Color color) {
        return INSTANCE.red(color);
    }

    @JvmStatic
    public static final int toArgb(Color color) {
        return INSTANCE.toArgb(color);
    }

    @JvmStatic
    public static final Color valueOf(float f, float f2, float f3, float f4) {
        return INSTANCE.valueOf(f, f2, f3, f4);
    }

    @JvmStatic
    public static final Color valueOf(int i) {
        return INSTANCE.valueOf(i);
    }

    /* JADX INFO: compiled from: ColorCompat.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lexpo/modules/kotlin/types/ColorCompat$Companion;", "", "<init>", "()V", "defaultLegacyColor", "Lexpo/modules/kotlin/types/ColorCompat$LegacyColor;", "valueOf", "Landroid/graphics/Color;", "color", "", "red", "", "green", "blue", "alpha", "toArgb", "legacyColor", "toColorComponent", Tags.COMPONENT, "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int toColorComponent(float component) {
            return (int) ((component * 255.0f) + 0.5f);
        }

        private Companion() {
        }

        @JvmStatic
        public final Color valueOf(int color) {
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.INSTANCE.valueOf(color);
            }
            return new LegacyColor(Color.red(color) / 255.0f, Color.green(color) / 255.0f, Color.blue(color) / 255.0f, Color.alpha(color) / 255.0f, color);
        }

        @JvmStatic
        public final Color valueOf(float red, float green, float blue, float alpha) {
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.INSTANCE.valueOf(red, green, blue, alpha);
            }
            float fCoerceIn = RangesKt.coerceIn(red, 0.0f, 1.0f);
            float fCoerceIn2 = RangesKt.coerceIn(green, 0.0f, 1.0f);
            float fCoerceIn3 = RangesKt.coerceIn(blue, 0.0f, 1.0f);
            float fCoerceIn4 = RangesKt.coerceIn(alpha, 0.0f, 1.0f);
            return new LegacyColor(fCoerceIn, fCoerceIn2, fCoerceIn3, fCoerceIn4, Color.argb(toColorComponent(fCoerceIn4), toColorComponent(fCoerceIn), toColorComponent(fCoerceIn2), toColorComponent(fCoerceIn3)));
        }

        @JvmStatic
        public final int toArgb(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.INSTANCE.toArgb(color);
            }
            return legacyColor(color).getArgb();
        }

        @JvmStatic
        public final float alpha(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.INSTANCE.alpha(color);
            }
            return legacyColor(color).getAlpha();
        }

        @JvmStatic
        public final float red(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.INSTANCE.red(color);
            }
            return legacyColor(color).getRed();
        }

        @JvmStatic
        public final float green(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.INSTANCE.green(color);
            }
            return legacyColor(color).getGreen();
        }

        @JvmStatic
        public final float blue(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.INSTANCE.blue(color);
            }
            return legacyColor(color).getBlue();
        }

        private final LegacyColor legacyColor(Color color) {
            LegacyColor legacyColor = color instanceof LegacyColor ? (LegacyColor) color : null;
            return legacyColor == null ? ColorCompat.defaultLegacyColor : legacyColor;
        }
    }

    private ColorCompat() {
    }

    /* JADX INFO: compiled from: ColorCompat.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/types/ColorCompat$LegacyColor;", "Landroid/graphics/Color;", "red", "", "green", "blue", "alpha", "argb", "", "<init>", "(FFFFI)V", "getRed", "()F", "getGreen", "getBlue", "getAlpha", "getArgb", "()I", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class LegacyColor extends Color {
        private final float alpha;
        private final int argb;
        private final float blue;
        private final float green;
        private final float red;

        public LegacyColor(float f, float f2, float f3, float f4, int i) {
            this.red = f;
            this.green = f2;
            this.blue = f3;
            this.alpha = f4;
            this.argb = i;
        }

        public final float getRed() {
            return this.red;
        }

        public final float getGreen() {
            return this.green;
        }

        public final float getBlue() {
            return this.blue;
        }

        public final float getAlpha() {
            return this.alpha;
        }

        public final int getArgb() {
            return this.argb;
        }
    }

    /* JADX INFO: compiled from: ColorCompat.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/ColorCompat$Api26Impl;", "", "<init>", "()V", "valueOf", "Landroid/graphics/Color;", "color", "", "red", "", "green", "blue", "alpha", "toArgb", "expo-modules-core_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Api26Impl {
        public static final Api26Impl INSTANCE = new Api26Impl();

        private Api26Impl() {
        }

        public final Color valueOf(int color) {
            Color colorValueOf = Color.valueOf(color);
            Intrinsics.checkNotNullExpressionValue(colorValueOf, "valueOf(...)");
            return colorValueOf;
        }

        public final Color valueOf(float red, float green, float blue, float alpha) {
            Color colorValueOf = Color.valueOf(red, green, blue, alpha);
            Intrinsics.checkNotNullExpressionValue(colorValueOf, "valueOf(...)");
            return colorValueOf;
        }

        public final int toArgb(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return color.toArgb();
        }

        public final float alpha(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return color.alpha();
        }

        public final float red(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return color.red();
        }

        public final float green(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return color.green();
        }

        public final float blue(Color color) {
            Intrinsics.checkNotNullParameter(color, "color");
            return color.blue();
        }
    }
}
