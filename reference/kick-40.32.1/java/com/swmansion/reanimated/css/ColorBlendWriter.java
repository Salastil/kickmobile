package com.swmansion.reanimated.css;

import android.view.View;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CSSPropertyWriter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/swmansion/reanimated/css/ColorBlendWriter;", "Lcom/swmansion/reanimated/css/CSSPropertyWriter;", "name", "", "fromColor", "", "toColor", "access", "Lcom/swmansion/reanimated/css/ColorAccess;", "<init>", "(Ljava/lang/String;IILcom/swmansion/reanimated/css/ColorAccess;)V", "animatorEndpoints", "Lkotlin/Pair;", "", "fromBits", "toBits", "setValue", "", "view", "Landroid/view/View;", "value", "", "get", "(Landroid/view/View;)Ljava/lang/Float;", "resumeFrom", "matches", "", "blend", "fraction", "Companion", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ColorBlendWriter extends CSSPropertyWriter {
    private final ColorAccess access;
    private int fromColor;
    private final int toColor;
    private static final Companion Companion = new Companion(null);
    private static final int[] CHANNEL_SHIFTS = {24, 16, 8, 0};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorBlendWriter(String name, int i, int i2, ColorAccess access) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(access, "access");
        this.fromColor = i;
        this.toColor = i2;
        this.access = access;
    }

    @Override // com.swmansion.reanimated.css.CSSPropertyWriter
    public Pair<Double, Double> animatorEndpoints(double fromBits, double toBits) {
        return TuplesKt.to(Double.valueOf(0.0d), Double.valueOf(1.0d));
    }

    @Override // android.util.FloatProperty
    public void setValue(View view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.access.write(view, blend(value));
    }

    @Override // android.util.Property
    public Float get(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return Float.valueOf(0.0f);
    }

    @Override // com.swmansion.reanimated.css.CSSPropertyWriter
    public float resumeFrom(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Integer num = this.access.read(view);
        if (num == null) {
            return 0.0f;
        }
        this.fromColor = num.intValue();
        return 0.0f;
    }

    @Override // com.swmansion.reanimated.css.CSSPropertyWriter
    public boolean matches(View view, float value) {
        Intrinsics.checkNotNullParameter(view, "view");
        Integer num = this.access.read(view);
        return num != null && num.intValue() == blend(value);
    }

    private final int blend(float fraction) {
        int iCoerceIn = 0;
        for (int i : CHANNEL_SHIFTS) {
            int i2 = (this.fromColor >>> i) & 255;
            iCoerceIn |= RangesKt.coerceIn(i2 + MathKt.roundToInt((((this.toColor >>> i) & 255) - i2) * fraction), 0, 255) << i;
        }
        return iCoerceIn;
    }

    /* JADX INFO: compiled from: CSSPropertyWriter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/swmansion/reanimated/css/ColorBlendWriter$Companion;", "", "<init>", "()V", "CHANNEL_SHIFTS", "", "getCHANNEL_SHIFTS", "()[I", "react-native-reanimated_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int[] getCHANNEL_SHIFTS() {
            return ColorBlendWriter.CHANNEL_SHIFTS;
        }
    }
}
