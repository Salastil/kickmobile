package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MaterialTheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\u00118G¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00178FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001a¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/MaterialTheme;", "", "<init>", "()V", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "getColorScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ColorScheme;", "typography", "Landroidx/compose/material3/Typography;", "getTypography", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Typography;", "shapes", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/Shapes;", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "getMotionScheme$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getMotionScheme", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MotionScheme;", "LocalMaterialTheme", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/material3/MaterialTheme$Values;", "getLocalMaterialTheme", "()Landroidx/compose/runtime/CompositionLocal;", "LocalMotionScheme", "getLocalMotionScheme$annotations", "getLocalMotionScheme", "Values", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MaterialTheme {
    public static final int $stable = 0;
    public static final MaterialTheme INSTANCE = new MaterialTheme();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use [LocalMaterialTheme.current.motionScheme] instead")
    public static /* synthetic */ void getLocalMotionScheme$annotations() {
    }

    public static /* synthetic */ void getMotionScheme$annotations(Composer composer, int i) {
    }

    private MaterialTheme() {
    }

    public final ColorScheme getColorScheme(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -561618718, "C(<get-colorScheme>)130@5602L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-561618718, i, -1, "androidx.compose.material3.MaterialTheme.<get-colorScheme> (MaterialTheme.kt:130)");
        }
        CompositionLocal<Values> localMaterialTheme = getLocalMaterialTheme();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMaterialTheme);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ColorScheme colorScheme = ((Values) objConsume).getColorScheme();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return colorScheme;
    }

    public final Typography getTypography(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -942794935, "C(<get-typography>)138@5903L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-942794935, i, -1, "androidx.compose.material3.MaterialTheme.<get-typography> (MaterialTheme.kt:138)");
        }
        CompositionLocal<Values> localMaterialTheme = getLocalMaterialTheme();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMaterialTheme);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Typography typography = ((Values) objConsume).getTypography();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return typography;
    }

    public final Shapes getShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 419509830, "C(<get-shapes>)146@6187L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(419509830, i, -1, "androidx.compose.material3.MaterialTheme.<get-shapes> (MaterialTheme.kt:146)");
        }
        CompositionLocal<Values> localMaterialTheme = getLocalMaterialTheme();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMaterialTheme);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Shapes shapes = ((Values) objConsume).getShapes();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapes;
    }

    public final MotionScheme getMotionScheme(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -506613891, "C(<get-motionScheme>)151@6453L7:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-506613891, i, -1, "androidx.compose.material3.MaterialTheme.<get-motionScheme> (MaterialTheme.kt:151)");
        }
        CompositionLocal<Values> localMaterialTheme = getLocalMaterialTheme();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localMaterialTheme);
        ComposerKt.sourceInformationMarkerEnd(composer);
        MotionScheme motionScheme = ((Values) objConsume).getMotionScheme();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return motionScheme;
    }

    public final CompositionLocal<Values> getLocalMaterialTheme() {
        return MaterialThemeKt._localMaterialTheme;
    }

    public final CompositionLocal<MotionScheme> getLocalMotionScheme() {
        return CompositionLocalKt.compositionLocalWithComputedDefaultOf(new Function1() { // from class: androidx.compose.material3.MaterialTheme$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((MaterialTheme.Values) ((CompositionLocalAccessorScope) obj).getCurrentValue(MaterialTheme.INSTANCE.getLocalMaterialTheme())).getMotionScheme();
            }
        });
    }

    /* JADX INFO: compiled from: MaterialTheme.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/MaterialTheme$Values;", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "typography", "Landroidx/compose/material3/Typography;", "shapes", "Landroidx/compose/material3/Shapes;", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "<init>", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Typography;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/MotionScheme;)V", "getColorScheme", "()Landroidx/compose/material3/ColorScheme;", "getTypography", "()Landroidx/compose/material3/Typography;", "getShapes", "()Landroidx/compose/material3/Shapes;", "getMotionScheme", "()Landroidx/compose/material3/MotionScheme;", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Values {
        public static final int $stable = 0;
        private final ColorScheme colorScheme;
        private final MotionScheme motionScheme;
        private final Shapes shapes;
        private final Typography typography;

        public Values() {
            this(null, null, null, null, 15, null);
        }

        public Values(ColorScheme colorScheme, Typography typography, Shapes shapes, MotionScheme motionScheme) {
            this.colorScheme = colorScheme;
            this.typography = typography;
            this.shapes = shapes;
            this.motionScheme = motionScheme;
        }

        public /* synthetic */ Values(ColorScheme colorScheme, Typography typography, Shapes shapes, MotionScheme motionScheme, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? ColorSchemeKt.m3724lightColorScheme_VG5OTI$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 65535, null) : colorScheme, (i & 2) != 0 ? new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : typography, (i & 4) != 0 ? new Shapes(null, null, null, null, null, 31, null) : shapes, (i & 8) != 0 ? MotionScheme.INSTANCE.standard() : motionScheme);
        }

        public final ColorScheme getColorScheme() {
            return this.colorScheme;
        }

        public final Typography getTypography() {
            return this.typography;
        }

        public final Shapes getShapes() {
            return this.shapes;
        }

        public final MotionScheme getMotionScheme() {
            return this.motionScheme;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Values values = (Values) other;
            return Intrinsics.areEqual(this.colorScheme, values.colorScheme) && Intrinsics.areEqual(this.typography, values.typography) && Intrinsics.areEqual(this.shapes, values.shapes) && Intrinsics.areEqual(this.motionScheme, values.motionScheme);
        }

        public int hashCode() {
            return (((((this.colorScheme.hashCode() * 31) + this.typography.hashCode()) * 31) + this.shapes.hashCode()) * 31) + this.motionScheme.hashCode();
        }

        public String toString() {
            return "Values(colorScheme=" + this.colorScheme + ", typography=" + this.typography + ", shapes=" + this.shapes + ", motionScheme=" + this.motionScheme + ')';
        }
    }
}
