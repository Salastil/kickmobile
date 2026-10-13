package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: Checkbox.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0011\u001aO\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0017\u001a_\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\u0018\u001a=\u0010\u0019\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u001b\u001a3\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0002¢\u0006\u0004\b$\u0010%\u001a;\u0010&\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0002¢\u0006\u0004\b,\u0010-\"\u000e\u0010.\u001a\u00020/X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00103\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102\"\u0010\u00104\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102¨\u00065"}, d2 = {"Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checkmarkStroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "outlineStroke", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "TriStateCheckbox", "state", "Landroidx/compose/ui/state/ToggleableState;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/runtime/Composer;I)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", ViewProps.BORDER_COLOR, "radius", "", "stroke", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/material3/CheckDrawingCache;)V", "SnapAnimationDelay", "", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CheckboxKt {
    private static final float CheckboxDefaultPadding = Dp.m10168constructorimpl(2.0f);
    private static final float CheckboxSize = Dp.m10168constructorimpl(20.0f);
    private static final float RadiusSize = Dp.m10168constructorimpl(2.0f);
    private static final int SnapAnimationDelay = 100;

    /* JADX INFO: compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit Checkbox$lambda$2(boolean z, Function1 function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit Checkbox$lambda$4(boolean z, Function1 function1, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        Checkbox(z, function1, stroke, stroke2, modifier, z2, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit CheckboxImpl$lambda$6(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Stroke stroke, Stroke stroke2, int i, Composer composer, int i2) {
        CheckboxImpl(z, toggleableState, modifier, checkboxColors, stroke, stroke2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TriStateCheckbox$lambda$1(ToggleableState toggleableState, Function0 function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit TriStateCheckbox$lambda$2(ToggleableState toggleableState, Function0 function0, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        TriStateCheckbox(toggleableState, function0, stroke, stroke2, modifier, z, checkboxColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to calculate best type for var: r0v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v8 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r0v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v9 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v6 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r16v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v1 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r16v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v2 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r16v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v3 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r17v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r17v1 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r33v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r34v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r34v0 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v1 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v1 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v14 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v15 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v15 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v16 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v16 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v17 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v17 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v20 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v20 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r4v21 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v21 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r5v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v10 ??, new type: androidx.compose.material3.CheckboxDefaults
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r8v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v4 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r8v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v5 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r33v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r33v0 ??, new type: androidx.compose.runtime.Composer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r34v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r34v0 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v1 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public static final void Checkbox(boolean r27, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, androidx.compose.material3.CheckboxColors r31, androidx.compose.foundation.interaction.MutableInteractionSource r32, androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.CheckboxKt.Checkbox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.CheckboxColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$1$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x012e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0139  */
    /* JADX WARN: Code duplicated, block: B:106:0x0146  */
    /* JADX WARN: Code duplicated, block: B:109:0x0156  */
    /* JADX WARN: Code duplicated, block: B:111:0x016f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0172  */
    /* JADX WARN: Code duplicated, block: B:115:0x0179  */
    /* JADX WARN: Code duplicated, block: B:118:0x0183  */
    /* JADX WARN: Code duplicated, block: B:120:0x018b  */
    /* JADX WARN: Code duplicated, block: B:122:0x019f  */
    /* JADX WARN: Code duplicated, block: B:125:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:127:0x01df  */
    /* JADX WARN: Code duplicated, block: B:130:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:88:0x010a  */
    /* JADX WARN: Code duplicated, block: B:94:0x011a A[PHI: r4 r10 r13 r15
      0x011a: PHI (r4v21 int) = (r4v16 int), (r4v14 int), (r4v22 int) binds: [B:102:0x0137, B:92:0x0116, B:93:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r10v8 androidx.compose.ui.Modifier) = (r10v4 androidx.compose.ui.Modifier), (r10v2 androidx.compose.ui.Modifier), (r10v2 androidx.compose.ui.Modifier) binds: [B:102:0x0137, B:92:0x0116, B:93:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r13v14 boolean) = (r13v4 boolean), (r13v3 boolean), (r13v3 boolean) binds: [B:102:0x0137, B:92:0x0116, B:93:0x0118] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r15v11 androidx.compose.material3.CheckboxColors) = 
      (r15v8 androidx.compose.material3.CheckboxColors)
      (r15v7 androidx.compose.material3.CheckboxColors)
      (r15v7 androidx.compose.material3.CheckboxColors)
     binds: [B:102:0x0137, B:92:0x0116, B:93:0x0118] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:95:0x011f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0121  */
    /* JADX WARN: Code duplicated, block: B:98:0x0128  */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        CheckboxColors checkboxColorsColors;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        final boolean z5;
        final CheckboxColors checkboxColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z6;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource4;
        Function0 function0;
        boolean z7;
        boolean z8;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(534932591);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)N(checked,onCheckedChange,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)162@7424L439:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(stroke) : composerStartRestartGroup.changedInstance(stroke) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(stroke2) : composerStartRestartGroup.changedInstance(stroke2) ? 2048 : 1024;
        }
        int i8 = i2 & 16;
        if (i8 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i9 = composerStartRestartGroup.changed(checkboxColorsColors) ? 1048576 : 524288;
                        i3 |= i9;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i9;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 8388608;
                        } else {
                            i7 = 4194304;
                        }
                        i3 |= i7;
                    }
                }
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = modifier2;
                            z6 = z3;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = null;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(534932591, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                        }
                        ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                        if (function1 != null) {
                            composerStartRestartGroup.startReplaceGroup(1848587702);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z8 = z7 | ((i3 & 14) == 4);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            function0 = (Function0) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1848653391);
                            composerStartRestartGroup.endReplaceGroup();
                            function0 = null;
                        }
                        TriStateCheckbox(ToggleableState, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composerStartRestartGroup, (Stroke.$stable << 6) | (i3 & 896) | (Stroke.$stable << 9) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z5 = z6;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                    }
                    modifier4 = modifier2;
                    z6 = z3;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    checkboxColors3 = checkboxColorsColors;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(534932591, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                    }
                    ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                    if (function1 != null) {
                        composerStartRestartGroup.startReplaceGroup(1848587702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z7 | ((i3 & 14) == 4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = (Function0) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1848653391);
                        composerStartRestartGroup.endReplaceGroup();
                        function0 = null;
                    }
                    TriStateCheckbox(ToggleableState2, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composerStartRestartGroup, (Stroke.$stable << 6) | (i3 & 896) | (Stroke.$stable << 9) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z5 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier2;
                    z5 = z3;
                    checkboxColors2 = checkboxColorsColors;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i9;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i9;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
            }
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(534932591, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                }
                ToggleableState ToggleableState3 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(1848587702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = (Function0) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1848653391);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = null;
                }
                TriStateCheckbox(ToggleableState3, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composerStartRestartGroup, (Stroke.$stable << 6) | (i3 & 896) | (Stroke.$stable << 9) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z5 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                checkboxColors2 = checkboxColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i9;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i9;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
            }
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        z6 = z3;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = null;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        mutableInteractionSource4 = mutableInteractionSource2;
                        checkboxColors3 = checkboxColorsColors;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(534932591, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
                }
                ToggleableState ToggleableState4 = ToggleableStateKt.ToggleableState(z);
                if (function1 != null) {
                    composerStartRestartGroup.startReplaceGroup(1848587702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | ((i3 & 14) == 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = (Function0) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1848653391);
                    composerStartRestartGroup.endReplaceGroup();
                    function0 = null;
                }
                TriStateCheckbox(ToggleableState4, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composerStartRestartGroup, (Stroke.$stable << 6) | (i3 & 896) | (Stroke.$stable << 9) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z5 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier2;
                z5 = z3;
                checkboxColors2 = checkboxColorsColors;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                checkboxColorsColors = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                }
                i3 |= i9;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i3 |= i9;
        } else {
            checkboxColorsColors = checkboxColors;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
        }
        if ((i3 & 4793491) != 4793490) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "159@7349L8");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    modifier4 = modifier2;
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = null;
                } else {
                    modifier4 = modifier2;
                    z6 = z3;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    checkboxColors3 = checkboxColorsColors;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    modifier4 = modifier2;
                    z6 = z3;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = null;
                } else {
                    modifier4 = modifier2;
                    z6 = z3;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    checkboxColors3 = checkboxColorsColors;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(534932591, i3, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:161)");
            }
            ToggleableState ToggleableState5 = ToggleableStateKt.ToggleableState(z);
            if (function1 != null) {
                composerStartRestartGroup.startReplaceGroup(1848587702);
                ComposerKt.sourceInformation(composerStartRestartGroup, "166@7561L29");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1325840916, "CC(remember):Checkbox.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z7 | ((i3 & 14) == 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CheckboxKt.Checkbox$lambda$3$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                function0 = (Function0) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(1848653391);
                composerStartRestartGroup.endReplaceGroup();
                function0 = null;
            }
            TriStateCheckbox(ToggleableState5, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composerStartRestartGroup, (Stroke.$stable << 6) | (i3 & 896) | (Stroke.$stable << 9) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z5 = z6;
            checkboxColors2 = checkboxColors3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier3 = modifier2;
            z5 = z3;
            checkboxColors2 = checkboxColorsColors;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.Checkbox$lambda$4(z, function1, stroke, stroke2, modifier3, z5, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Checkbox$lambda$3$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0082  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:91:0x0112  */
    /* JADX WARN: Code duplicated, block: B:94:0x0190  */
    /* JADX WARN: Code duplicated, block: B:96:0x0198  */
    /* JADX WARN: Code duplicated, block: B:99:0x01a7  */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        CheckboxColors checkboxColorsColors;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Modifier.Companion companion;
        boolean z5;
        Modifier modifier4;
        boolean z6;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,modifier,enabled,colors,interactionSource)215@9923L7,216@9983L337:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i10 = composerStartRestartGroup.changed(checkboxColorsColors) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                        i8 = 6;
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            z5 = i4 == 0 ? z2 : true;
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                modifier4 = companion;
                                z6 = z5;
                                i8 = 6;
                                mutableInteractionSource4 = null;
                                checkboxColors3 = checkboxColorsColors;
                            } else {
                                modifier4 = companion;
                                z6 = z5;
                                checkboxColors3 = checkboxColorsColors;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                            }
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            float fFloor = (float) Math.floor(((Density) objConsume).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                            Stroke stroke = new Stroke(fFloor, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                            Stroke stroke2 = new Stroke(fFloor, 0.0f, 0, 0, null, 30, null);
                            int i11 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                            int i12 = i3 << i8;
                            composer2 = composerStartRestartGroup;
                            TriStateCheckbox(toggleableState, function0, stroke, stroke2, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i11 | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (i12 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z6;
                            checkboxColors2 = checkboxColors3;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            modifier4 = modifier2;
                            z6 = z2;
                            checkboxColors3 = checkboxColorsColors;
                        }
                        mutableInteractionSource4 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                        }
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        float fFloor2 = (float) Math.floor(((Density) objConsume2).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                        Stroke stroke3 = new Stroke(fFloor2, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                        Stroke stroke4 = new Stroke(fFloor2, 0.0f, 0, 0, null, 30, null);
                        int i13 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                        int i14 = i3 << i8;
                        composer2 = composerStartRestartGroup;
                        TriStateCheckbox(toggleableState, function0, stroke3, stroke4, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i13 | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z6;
                        checkboxColors2 = checkboxColors3;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        checkboxColors2 = checkboxColorsColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                    i8 = 6;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                    }
                    ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor3 = (float) Math.floor(((Density) objConsume3).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                    Stroke stroke5 = new Stroke(fFloor3, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                    Stroke stroke6 = new Stroke(fFloor3, 0.0f, 0, 0, null, 30, null);
                    int i15 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                    int i16 = i3 << i8;
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(toggleableState, function0, stroke5, stroke6, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i15 | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                    i8 = 6;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                    }
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor4 = (float) Math.floor(((Density) objConsume4).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                    Stroke stroke7 = new Stroke(fFloor4, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                    Stroke stroke8 = new Stroke(fFloor4, 0.0f, 0, 0, null, 30, null);
                    int i17 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                    int i18 = i3 << i8;
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(toggleableState, function0, stroke7, stroke8, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i17 | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (i18 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                i8 = 6;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                }
                ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor5 = (float) Math.floor(((Density) objConsume5).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                Stroke stroke9 = new Stroke(fFloor5, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                Stroke stroke10 = new Stroke(fFloor5, 0.0f, 0, 0, null, 30, null);
                int i19 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                int i110 = i3 << i8;
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(toggleableState, function0, stroke9, stroke10, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i19 | (57344 & i110) | (458752 & i110) | (3670016 & i110) | (i110 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i10;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i10;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                    i8 = 6;
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            modifier4 = companion;
                            z6 = z5;
                            i8 = 6;
                            mutableInteractionSource4 = null;
                            checkboxColors3 = checkboxColorsColors;
                        } else {
                            modifier4 = companion;
                            z6 = z5;
                            checkboxColors3 = checkboxColorsColors;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                    }
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    float fFloor6 = (float) Math.floor(((Density) objConsume6).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                    Stroke stroke11 = new Stroke(fFloor6, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                    Stroke stroke12 = new Stroke(fFloor6, 0.0f, 0, 0, null, 30, null);
                    int i111 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                    int i112 = i3 << i8;
                    composer2 = composerStartRestartGroup;
                    TriStateCheckbox(toggleableState, function0, stroke11, stroke12, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i111 | (57344 & i112) | (458752 & i112) | (3670016 & i112) | (i112 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z6;
                    checkboxColors2 = checkboxColors3;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                i8 = 6;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                }
                ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor7 = (float) Math.floor(((Density) objConsume7).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                Stroke stroke13 = new Stroke(fFloor7, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                Stroke stroke14 = new Stroke(fFloor7, 0.0f, 0, 0, null, 30, null);
                int i113 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                int i114 = i3 << i8;
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(toggleableState, function0, stroke13, stroke14, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i113 | (57344 & i114) | (458752 & i114) | (3670016 & i114) | (i114 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                checkboxColorsColors = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                }
                i3 |= i10;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i3 |= i10;
        } else {
            checkboxColorsColors = checkboxColors;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
                i8 = 6;
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        modifier4 = companion;
                        z6 = z5;
                        i8 = 6;
                        mutableInteractionSource4 = null;
                        checkboxColors3 = checkboxColorsColors;
                    } else {
                        modifier4 = companion;
                        z6 = z5;
                        checkboxColors3 = checkboxColorsColors;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
                }
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float fFloor8 = (float) Math.floor(((Density) objConsume8).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
                Stroke stroke15 = new Stroke(fFloor8, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
                Stroke stroke16 = new Stroke(fFloor8, 0.0f, 0, 0, null, 30, null);
                int i115 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
                int i116 = i3 << i8;
                composer2 = composerStartRestartGroup;
                TriStateCheckbox(toggleableState, function0, stroke15, stroke16, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i115 | (57344 & i116) | (458752 & i116) | (3670016 & i116) | (i116 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z6;
                checkboxColors2 = checkboxColors3;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "212@9810L8");
            i8 = 6;
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    modifier4 = companion;
                    z6 = z5;
                    i8 = 6;
                    mutableInteractionSource4 = null;
                    checkboxColors3 = checkboxColorsColors;
                } else {
                    modifier4 = companion;
                    z6 = z5;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    modifier4 = companion;
                    z6 = z5;
                    i8 = 6;
                    mutableInteractionSource4 = null;
                    checkboxColors3 = checkboxColorsColors;
                } else {
                    modifier4 = companion;
                    z6 = z5;
                    checkboxColors3 = checkboxColorsColors;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1608358065, i3, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:214)");
            }
            ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fFloor9 = (float) Math.floor(((Density) objConsume9).mo1734toPx0680j_4(CheckboxDefaults.INSTANCE.m3615getStrokeWidthD9Ej5fM()));
            Stroke stroke17 = new Stroke(fFloor9, 0.0f, StrokeCap.INSTANCE.m7714getSquareKaPHkGw(), 0, null, 26, null);
            Stroke stroke18 = new Stroke(fFloor9, 0.0f, 0, 0, null, 30, null);
            int i117 = (i3 & WebSocketProtocol.PAYLOAD_SHORT) | (Stroke.$stable << i8) | (Stroke.$stable << 9);
            int i118 = i3 << i8;
            composer2 = composerStartRestartGroup;
            TriStateCheckbox(toggleableState, function0, stroke17, stroke18, modifier4, z6, checkboxColors3, mutableInteractionSource4, composer2, i117 | (57344 & i118) | (458752 & i118) | (3670016 & i118) | (i118 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z4 = z6;
            checkboxColors2 = checkboxColors3;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            checkboxColors2 = checkboxColorsColors;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.TriStateCheckbox$lambda$1(toggleableState, function0, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0132  */
    /* JADX WARN: Code duplicated, block: B:104:0x0138  */
    /* JADX WARN: Code duplicated, block: B:105:0x0142  */
    /* JADX WARN: Code duplicated, block: B:107:0x0146  */
    /* JADX WARN: Code duplicated, block: B:108:0x014d  */
    /* JADX WARN: Code duplicated, block: B:111:0x015b  */
    /* JADX WARN: Code duplicated, block: B:114:0x016a  */
    /* JADX WARN: Code duplicated, block: B:115:0x0181  */
    /* JADX WARN: Code duplicated, block: B:117:0x019c  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:120:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:124:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:125:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:128:0x0225  */
    /* JADX WARN: Code duplicated, block: B:130:0x022f  */
    /* JADX WARN: Code duplicated, block: B:133:0x023e  */
    /* JADX WARN: Code duplicated, block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0095  */
    /* JADX WARN: Code duplicated, block: B:51:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00da  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x0100  */
    /* JADX WARN: Code duplicated, block: B:89:0x0110  */
    /* JADX WARN: Code duplicated, block: B:97:0x0128 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x012a  */
    /* JADX WARN: Code duplicated, block: B:99:0x012f  */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, final Stroke stroke, final Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        CheckboxColors checkboxColorsColors;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        boolean z3;
        final Modifier modifier3;
        Composer composer2;
        final boolean z4;
        final CheckboxColors checkboxColors2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i9;
        Modifier modifier4;
        boolean z5;
        int i10;
        MutableInteractionSource mutableInteractionSource4;
        boolean z6;
        IndicationNodeFactory indicationNodeFactoryM4528rippleH2RKhps$default;
        MutableInteractionSource mutableInteractionSource5;
        boolean z7;
        Modifier.Companion companionM2655triStateToggleableO2vRcR0;
        Modifier.Companion companionMinimumInteractiveComponentSize;
        Modifier.Companion companionM2350padding3ABfNKs;
        MutableInteractionSource mutableInteractionSource6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-406243761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckbox)N(state,onClick,checkmarkStroke,outlineStroke,modifier,enabled,colors,interactionSource)301@13908L739:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(stroke) : composerStartRestartGroup.changedInstance(stroke) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(stroke2) : composerStartRestartGroup.changedInstance(stroke2) ? 2048 : 1024;
        }
        int i11 = i2 & 16;
        if (i11 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        checkboxColorsColors = checkboxColors;
                        int i12 = composerStartRestartGroup.changed(checkboxColorsColors) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        checkboxColorsColors = checkboxColors;
                    }
                    i3 |= i12;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    if ((12582912 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 8388608;
                        } else {
                            i7 = 4194304;
                        }
                        i3 |= i7;
                    }
                    i8 = i3;
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 64) != 0) {
                                i9 = i8 & (-3670017);
                                checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i9 = i8;
                            }
                            if (i6 != 0) {
                                boolean z8 = z2;
                                modifier4 = companion;
                                z5 = z8;
                                i10 = i9;
                                mutableInteractionSource4 = null;
                            } else {
                                boolean z9 = z2;
                                modifier4 = companion;
                                z5 = z9;
                                i10 = i9;
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i10 = (i2 & 64) != 0 ? i8 & (-3670017) : i8;
                            z5 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                        }
                        z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                        if (z6) {
                            indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
                        } else {
                            indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                        }
                        if (function0 != null) {
                            z7 = z5;
                            companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                            mutableInteractionSource5 = mutableInteractionSource6;
                        } else {
                            mutableInteractionSource5 = mutableInteractionSource4;
                            z7 = z5;
                            companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                        }
                        if (function0 != null) {
                            mutableInteractionSource6 = mutableInteractionSource4;
                            companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                        } else {
                            mutableInteractionSource6 = mutableInteractionSource4;
                            companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                        }
                        Modifier modifierThen = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
                        if (z6) {
                            companionM2350padding3ABfNKs = Modifier.INSTANCE;
                        } else {
                            companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                        }
                        Modifier modifierThen2 = modifierThen.then(companionM2350padding3ABfNKs);
                        int i13 = i10 << 6;
                        boolean z10 = z7;
                        CheckboxColors checkboxColors3 = checkboxColorsColors;
                        CheckboxImpl(z10, toggleableState, modifierThen2, checkboxColors3, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i13) | (Stroke.$stable << 15) | (i13 & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors2 = checkboxColors3;
                        composer2 = composerStartRestartGroup;
                        modifier3 = modifier4;
                        mutableInteractionSource3 = mutableInteractionSource5;
                        z4 = z10;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        z4 = z2;
                        checkboxColors2 = checkboxColorsColors;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            boolean z11 = z2;
                            modifier4 = companion;
                            z5 = z11;
                            i10 = i9;
                            mutableInteractionSource4 = null;
                        } else {
                            boolean z12 = z2;
                            modifier4 = companion;
                            z5 = z12;
                            i10 = i9;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            boolean z13 = z2;
                            modifier4 = companion;
                            z5 = z13;
                            i10 = i9;
                            mutableInteractionSource4 = null;
                        } else {
                            boolean z14 = z2;
                            modifier4 = companion;
                            z5 = z14;
                            i10 = i9;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                    }
                    z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                    if (z6) {
                        indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
                    } else {
                        indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                    }
                    if (function0 != null) {
                        z7 = z5;
                        companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                        mutableInteractionSource5 = mutableInteractionSource6;
                    } else {
                        mutableInteractionSource5 = mutableInteractionSource4;
                        z7 = z5;
                        companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        mutableInteractionSource6 = mutableInteractionSource4;
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        mutableInteractionSource6 = mutableInteractionSource4;
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierThen3 = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
                    if (z6) {
                        companionM2350padding3ABfNKs = Modifier.INSTANCE;
                    } else {
                        companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                    }
                    Modifier modifierThen4 = modifierThen3.then(companionM2350padding3ABfNKs);
                    int i14 = i10 << 6;
                    boolean z15 = z7;
                    CheckboxColors checkboxColors4 = checkboxColorsColors;
                    CheckboxImpl(z15, toggleableState, modifierThen4, checkboxColors4, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i14) | (Stroke.$stable << 15) | (i14 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors4;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier4;
                    mutableInteractionSource3 = mutableInteractionSource5;
                    z4 = z15;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i12;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i12;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                if ((12582912 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            boolean z16 = z2;
                            modifier4 = companion;
                            z5 = z16;
                            i10 = i9;
                            mutableInteractionSource4 = null;
                        } else {
                            boolean z17 = z2;
                            modifier4 = companion;
                            z5 = z17;
                            i10 = i9;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            boolean z18 = z2;
                            modifier4 = companion;
                            z5 = z18;
                            i10 = i9;
                            mutableInteractionSource4 = null;
                        } else {
                            boolean z19 = z2;
                            modifier4 = companion;
                            z5 = z19;
                            i10 = i9;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                    }
                    z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                    if (z6) {
                        indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
                    } else {
                        indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                    }
                    if (function0 != null) {
                        z7 = z5;
                        companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                        mutableInteractionSource5 = mutableInteractionSource6;
                    } else {
                        mutableInteractionSource5 = mutableInteractionSource4;
                        z7 = z5;
                        companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        mutableInteractionSource6 = mutableInteractionSource4;
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        mutableInteractionSource6 = mutableInteractionSource4;
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierThen5 = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
                    if (z6) {
                        companionM2350padding3ABfNKs = Modifier.INSTANCE;
                    } else {
                        companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                    }
                    Modifier modifierThen6 = modifierThen5.then(companionM2350padding3ABfNKs);
                    int i15 = i10 << 6;
                    boolean z110 = z7;
                    CheckboxColors checkboxColors5 = checkboxColorsColors;
                    CheckboxImpl(z110, toggleableState, modifierThen6, checkboxColors5, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i15) | (Stroke.$stable << 15) | (i15 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors5;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier4;
                    mutableInteractionSource3 = mutableInteractionSource5;
                    z4 = z110;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            mutableInteractionSource2 = mutableInteractionSource;
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        boolean z111 = z2;
                        modifier4 = companion;
                        z5 = z111;
                        i10 = i9;
                        mutableInteractionSource4 = null;
                    } else {
                        boolean z112 = z2;
                        modifier4 = companion;
                        z5 = z112;
                        i10 = i9;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        boolean z113 = z2;
                        modifier4 = companion;
                        z5 = z113;
                        i10 = i9;
                        mutableInteractionSource4 = null;
                    } else {
                        boolean z114 = z2;
                        modifier4 = companion;
                        z5 = z114;
                        i10 = i9;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                }
                z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                if (z6) {
                    indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
                } else {
                    indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                }
                if (function0 != null) {
                    z7 = z5;
                    companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                    mutableInteractionSource5 = mutableInteractionSource6;
                } else {
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z5;
                    companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    mutableInteractionSource6 = mutableInteractionSource4;
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    mutableInteractionSource6 = mutableInteractionSource4;
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen7 = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
                if (z6) {
                    companionM2350padding3ABfNKs = Modifier.INSTANCE;
                } else {
                    companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                }
                Modifier modifierThen8 = modifierThen7.then(companionM2350padding3ABfNKs);
                int i16 = i10 << 6;
                boolean z115 = z7;
                CheckboxColors checkboxColors6 = checkboxColorsColors;
                CheckboxImpl(z115, toggleableState, modifierThen8, checkboxColors6, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i16) | (Stroke.$stable << 15) | (i16 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors6;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                mutableInteractionSource3 = mutableInteractionSource5;
                z4 = z115;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    checkboxColorsColors = checkboxColors;
                    if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                    }
                    i3 |= i12;
                } else {
                    checkboxColorsColors = checkboxColors;
                }
                i3 |= i12;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                if ((12582912 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            boolean z116 = z2;
                            modifier4 = companion;
                            z5 = z116;
                            i10 = i9;
                            mutableInteractionSource4 = null;
                        } else {
                            boolean z117 = z2;
                            modifier4 = companion;
                            z5 = z117;
                            i10 = i9;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 64) != 0) {
                            i9 = i8 & (-3670017);
                            checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i9 = i8;
                        }
                        if (i6 != 0) {
                            boolean z118 = z2;
                            modifier4 = companion;
                            z5 = z118;
                            i10 = i9;
                            mutableInteractionSource4 = null;
                        } else {
                            boolean z119 = z2;
                            modifier4 = companion;
                            z5 = z119;
                            i10 = i9;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                    }
                    z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                    if (z6) {
                        indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
                    } else {
                        indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                    }
                    if (function0 != null) {
                        z7 = z5;
                        companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                        mutableInteractionSource5 = mutableInteractionSource6;
                    } else {
                        mutableInteractionSource5 = mutableInteractionSource4;
                        z7 = z5;
                        companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                    }
                    if (function0 != null) {
                        mutableInteractionSource6 = mutableInteractionSource4;
                        companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                    } else {
                        mutableInteractionSource6 = mutableInteractionSource4;
                        companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                    }
                    Modifier modifierThen9 = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
                    if (z6) {
                        companionM2350padding3ABfNKs = Modifier.INSTANCE;
                    } else {
                        companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                    }
                    Modifier modifierThen10 = modifierThen9.then(companionM2350padding3ABfNKs);
                    int i17 = i10 << 6;
                    boolean z1110 = z7;
                    CheckboxColors checkboxColors7 = checkboxColorsColors;
                    CheckboxImpl(z1110, toggleableState, modifierThen10, checkboxColors7, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i17) | (Stroke.$stable << 15) | (i17 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors2 = checkboxColors7;
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier4;
                    mutableInteractionSource3 = mutableInteractionSource5;
                    z4 = z1110;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    z4 = z2;
                    checkboxColors2 = checkboxColorsColors;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            mutableInteractionSource2 = mutableInteractionSource;
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        boolean z1111 = z2;
                        modifier4 = companion;
                        z5 = z1111;
                        i10 = i9;
                        mutableInteractionSource4 = null;
                    } else {
                        boolean z1112 = z2;
                        modifier4 = companion;
                        z5 = z1112;
                        i10 = i9;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        boolean z1113 = z2;
                        modifier4 = companion;
                        z5 = z1113;
                        i10 = i9;
                        mutableInteractionSource4 = null;
                    } else {
                        boolean z1114 = z2;
                        modifier4 = companion;
                        z5 = z1114;
                        i10 = i9;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                }
                z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                if (z6) {
                    indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
                } else {
                    indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                }
                if (function0 != null) {
                    z7 = z5;
                    companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                    mutableInteractionSource5 = mutableInteractionSource6;
                } else {
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z5;
                    companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    mutableInteractionSource6 = mutableInteractionSource4;
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    mutableInteractionSource6 = mutableInteractionSource4;
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen11 = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
                if (z6) {
                    companionM2350padding3ABfNKs = Modifier.INSTANCE;
                } else {
                    companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                }
                Modifier modifierThen12 = modifierThen11.then(companionM2350padding3ABfNKs);
                int i18 = i10 << 6;
                boolean z1115 = z7;
                CheckboxColors checkboxColors8 = checkboxColorsColors;
                CheckboxImpl(z1115, toggleableState, modifierThen12, checkboxColors8, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i18) | (Stroke.$stable << 15) | (i18 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors8;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                mutableInteractionSource3 = mutableInteractionSource5;
                z4 = z1115;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                checkboxColorsColors = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColorsColors)) {
                }
                i3 |= i12;
            } else {
                checkboxColorsColors = checkboxColors;
            }
            i3 |= i12;
        } else {
            checkboxColorsColors = checkboxColors;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            if ((12582912 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        boolean z1116 = z2;
                        modifier4 = companion;
                        z5 = z1116;
                        i10 = i9;
                        mutableInteractionSource4 = null;
                    } else {
                        boolean z1117 = z2;
                        modifier4 = companion;
                        z5 = z1117;
                        i10 = i9;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 64) != 0) {
                        i9 = i8 & (-3670017);
                        checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i9 = i8;
                    }
                    if (i6 != 0) {
                        boolean z1118 = z2;
                        modifier4 = companion;
                        z5 = z1118;
                        i10 = i9;
                        mutableInteractionSource4 = null;
                    } else {
                        boolean z1119 = z2;
                        modifier4 = companion;
                        z5 = z1119;
                        i10 = i9;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
                }
                z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
                if (z6) {
                    indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
                } else {
                    indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
                }
                if (function0 != null) {
                    z7 = z5;
                    companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                    mutableInteractionSource5 = mutableInteractionSource6;
                } else {
                    mutableInteractionSource5 = mutableInteractionSource4;
                    z7 = z5;
                    companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
                }
                if (function0 != null) {
                    mutableInteractionSource6 = mutableInteractionSource4;
                    companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                } else {
                    mutableInteractionSource6 = mutableInteractionSource4;
                    companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
                }
                Modifier modifierThen13 = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
                if (z6) {
                    companionM2350padding3ABfNKs = Modifier.INSTANCE;
                } else {
                    companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
                }
                Modifier modifierThen14 = modifierThen13.then(companionM2350padding3ABfNKs);
                int i19 = i10 << 6;
                boolean z11110 = z7;
                CheckboxColors checkboxColors9 = checkboxColorsColors;
                CheckboxImpl(z11110, toggleableState, modifierThen14, checkboxColors9, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i19) | (Stroke.$stable << 15) | (i19 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors2 = checkboxColors9;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                mutableInteractionSource3 = mutableInteractionSource5;
                z4 = z11110;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                z4 = z2;
                checkboxColors2 = checkboxColorsColors;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        mutableInteractionSource2 = mutableInteractionSource;
        i8 = i3;
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "274@12999L8");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 64) != 0) {
                    i9 = i8 & (-3670017);
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    boolean z11111 = z2;
                    modifier4 = companion;
                    z5 = z11111;
                    i10 = i9;
                    mutableInteractionSource4 = null;
                } else {
                    boolean z11112 = z2;
                    modifier4 = companion;
                    z5 = z11112;
                    i10 = i9;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 64) != 0) {
                    i9 = i8 & (-3670017);
                    checkboxColorsColors = CheckboxDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i9 = i8;
                }
                if (i6 != 0) {
                    boolean z11113 = z2;
                    modifier4 = companion;
                    z5 = z11113;
                    i10 = i9;
                    mutableInteractionSource4 = null;
                } else {
                    boolean z11114 = z2;
                    modifier4 = companion;
                    z5 = z11114;
                    i10 = i9;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-406243761, i10, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:276)");
            }
            z6 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
            if (z6) {
                indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4527rippleH2RKhps(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), checkboxColorsColors.m3612indicatorColorvNxB06k$material3(toggleableState));
            } else {
                indicationNodeFactoryM4528rippleH2RKhps$default = RippleKt.m4528rippleH2RKhps$default(false, Dp.m10168constructorimpl(CheckboxTokens.INSTANCE.m5611getStateLayerSizeD9Ej5fM() / 2.0f), 0L, 4, null);
            }
            if (function0 != null) {
                z7 = z5;
                companionM2655triStateToggleableO2vRcR0 = ToggleableKt.m2655triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource6, indicationNodeFactoryM4528rippleH2RKhps$default, z7, Role.m9361boximpl(Role.INSTANCE.m9370getCheckboxo7Vup1c()), function0);
                mutableInteractionSource5 = mutableInteractionSource6;
            } else {
                mutableInteractionSource5 = mutableInteractionSource4;
                z7 = z5;
                companionM2655triStateToggleableO2vRcR0 = Modifier.INSTANCE;
            }
            if (function0 != null) {
                mutableInteractionSource6 = mutableInteractionSource4;
                companionMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
            } else {
                mutableInteractionSource6 = mutableInteractionSource4;
                companionMinimumInteractiveComponentSize = Modifier.INSTANCE;
            }
            Modifier modifierThen15 = modifier4.then(companionMinimumInteractiveComponentSize).then(companionM2655triStateToggleableO2vRcR0);
            if (z6) {
                companionM2350padding3ABfNKs = Modifier.INSTANCE;
            } else {
                companionM2350padding3ABfNKs = PaddingKt.m2350padding3ABfNKs(Modifier.INSTANCE, CheckboxDefaultPadding);
            }
            Modifier modifierThen16 = modifierThen15.then(companionM2350padding3ABfNKs);
            int i110 = i10 << 6;
            boolean z11115 = z7;
            CheckboxColors checkboxColors10 = checkboxColorsColors;
            CheckboxImpl(z11115, toggleableState, modifierThen16, checkboxColors10, stroke, stroke2, composerStartRestartGroup, ((i10 >> 15) & 14) | ((i10 << 3) & 112) | ((i10 >> 9) & 7168) | (Stroke.$stable << 12) | (57344 & i110) | (Stroke.$stable << 15) | (i110 & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkboxColors2 = checkboxColors10;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier4;
            mutableInteractionSource3 = mutableInteractionSource5;
            z4 = z11115;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            z4 = z2;
            checkboxColors2 = checkboxColorsColors;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxKt.TriStateCheckbox$lambda$2(toggleableState, function0, stroke, stroke2, modifier3, z4, checkboxColors2, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:206:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:208:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:211:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:213:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:217:0x04df  */
    /* JADX WARN: Code duplicated, block: B:221:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:224:0x050b  */
    private static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, final Stroke stroke, final Stroke stroke2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Object currentState;
        float f;
        int i3;
        float f2;
        Object currentState2;
        float f3;
        State<Color> stateCheckmarkColor$material3;
        Stroke stroke3;
        boolean z2;
        final Stroke stroke4;
        boolean z3;
        boolean z4;
        Object obj;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-891330208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxImpl)N(enabled,value,modifier,colors,checkmarkStroke,outlineStroke)479@23102L23,480@23194L14,482@23256L608,500@23931L594,516@24547L32,523@24788L24,524@24842L27,531@25113L476,531@25034L555:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(toggleableState.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(checkboxColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (i & 32768) == 0 ? composerStartRestartGroup.changed(stroke) : composerStartRestartGroup.changedInstance(stroke) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= (i & 262144) == 0 ? composerStartRestartGroup.changed(stroke2) : composerStartRestartGroup.changedInstance(stroke2) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891330208, i2, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:477)");
            }
            boolean z5 = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
            int i5 = i2 >> 3;
            int i6 = i5 & 14;
            final Transition transitionUpdateTransition = TransitionKt.updateTransition(toggleableState, (String) null, composerStartRestartGroup, i6, 2);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            Function3 function3 = new Function3() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return CheckboxKt.CheckboxImpl$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1971@84243L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int i7 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
            if (transitionUpdateTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState = transitionUpdateTransition.getCurrentState();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1864@79141L67");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(transitionUpdateTransition);
                currentState = composerStartRestartGroup.rememberedValue();
                if (zChanged || currentState == Composer.INSTANCE.getEmpty()) {
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        Object currentState3 = transitionUpdateTransition.getCurrentState();
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        composerStartRestartGroup.updateRememberedValue(currentState3);
                        currentState = currentState3;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            ToggleableState toggleableState2 = (ToggleableState) currentState;
            composerStartRestartGroup.startReplaceGroup(-768316570);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:492)");
            }
            int i8 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            float f4 = 0.0f;
            if (i8 == 1) {
                f = 1.0f;
            } else if (i8 != 2) {
                if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf = Float.valueOf(f);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<ToggleableState>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$$inlined$animateFloat$1
                    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.state.ToggleableState, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final ToggleableState invoke() {
                        return transitionUpdateTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ToggleableState toggleableState3 = (ToggleableState) ((State) objRememberedValue).getValue();
            composerStartRestartGroup.startReplaceGroup(-768316570);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                i3 = -1;
                ComposerKt.traceEventStart(-768316570, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:492)");
            } else {
                i3 = -1;
            }
            int i9 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
            if (i9 == 1) {
                f2 = 1.0f;
            } else if (i9 != 2) {
                if (i9 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(f2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged3 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<ToggleableState>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$$inlined$animateFloat$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<ToggleableState> invoke() {
                        return transitionUpdateTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            FiniteAnimationSpec finiteAnimationSpec = (FiniteAnimationSpec) function3.invoke(((State) objRememberedValue2).getValue(), composerStartRestartGroup, 0);
            int i10 = i3;
            final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, fValueOf2, finiteAnimationSpec, vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function4 = new Function3() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return CheckboxKt.CheckboxImpl$lambda$2(finiteAnimationSpecValue, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844118987, "CC(animateFloat)N(transitionSpec,label,targetValueByState)1971@84243L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1143035377, "CC(animateValue)N(typeConverter,transitionSpec,label,targetValueByState)1868@79284L32,1875@79757L49,1875@79738L75,1876@79853L45,1876@79838L67,1878@79918L89:Transition.kt#pdpnli");
            if (transitionUpdateTransition.isSeeking()) {
                composerStartRestartGroup.startReplaceGroup(1666827533);
                composerStartRestartGroup.endReplaceGroup();
                currentState2 = transitionUpdateTransition.getCurrentState();
            } else {
                composerStartRestartGroup.startReplaceGroup(1666573488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1864@79141L67");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054612652, "CC(remember):Transition.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(transitionUpdateTransition);
                currentState2 = composerStartRestartGroup.rememberedValue();
                if (zChanged4 || currentState2 == Composer.INSTANCE.getEmpty()) {
                    Snapshot.Companion companion2 = Snapshot.INSTANCE;
                    Snapshot currentThreadSnapshot2 = companion2.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = companion2.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object currentState4 = transitionUpdateTransition.getCurrentState();
                        companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        composerStartRestartGroup.updateRememberedValue(currentState4);
                        currentState2 = currentState4;
                    } catch (Throwable th2) {
                        companion2.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th2;
                    }
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            }
            ToggleableState toggleableState4 = (ToggleableState) currentState2;
            composerStartRestartGroup.startReplaceGroup(1840054703);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1840054703, 0, i10, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:510)");
            }
            int i11 = WhenMappings.$EnumSwitchMapping$0[toggleableState4.ordinal()];
            if (i11 == 1 || i11 == 2) {
                f3 = 0.0f;
            } else {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f3 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf3 = Float.valueOf(f3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054592958, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged5 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged5 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<ToggleableState>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$$inlined$animateFloat$3
                    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.state.ToggleableState, java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function0
                    public final ToggleableState invoke() {
                        return transitionUpdateTransition.getTargetState();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ToggleableState toggleableState5 = (ToggleableState) ((State) objRememberedValue3).getValue();
            composerStartRestartGroup.startReplaceGroup(1840054703);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1840054703, 0, i10, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:510)");
            }
            int i12 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
            if (i12 != 1 && i12 != 2) {
                if (i12 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                f4 = 1.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf4 = Float.valueOf(f4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1054589890, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged6 = composerStartRestartGroup.changed(transitionUpdateTransition);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged6 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Transition.Segment<ToggleableState>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$$inlined$animateFloat$4
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Transition.Segment<ToggleableState> invoke() {
                        return transitionUpdateTransition.getSegment();
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, fValueOf4, (FiniteAnimationSpec) function4.invoke(((State) objRememberedValue4).getValue(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, -1869782464, "CC(remember):Checkbox.kt#9igjgp");
            Object objRememberedValue5 = composer2.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                Object checkDrawingCache = new CheckDrawingCache(null, null, null, 7, null);
                composer2.updateRememberedValue(checkDrawingCache);
                objRememberedValue5 = checkDrawingCache;
            }
            final CheckDrawingCache checkDrawingCache2 = (CheckDrawingCache) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (z5) {
                composer2.startReplaceGroup(-2128586395);
                ComposerKt.sourceInformation(composer2, "519@24663L30");
                stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(z, toggleableState, composer2, (i7 & WebSocketProtocol.PAYLOAD_SHORT) | (i5 & 896));
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-2128520210);
                ComposerKt.sourceInformation(composer2, "521@24730L21");
                stateCheckmarkColor$material3 = checkboxColors.checkmarkColor$material3(toggleableState, composer2, i6 | ((i7 >> 6) & 112));
                composer2.endReplaceGroup();
            }
            int i13 = (i7 & WebSocketProtocol.PAYLOAD_SHORT) | (i5 & 896);
            final State<Color> stateBoxColor$material3 = checkboxColors.boxColor$material3(z, toggleableState, composer2, i13);
            final State<Color> stateBorderColor$material3 = checkboxColors.borderColor$material3(z, toggleableState, composer2, i13);
            Modifier modifierM2409requiredSize3ABfNKs = SizeKt.m2409requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), z5 ? CheckboxTokens.INSTANCE.m5604getContainerSizeD9Ej5fM() : CheckboxSize);
            ComposerKt.sourceInformationMarkerStart(composer2, -1869763908, "CC(remember):Checkbox.kt#9igjgp");
            boolean zChanged7 = composer2.changed(stateBoxColor$material3) | composer2.changed(stateBorderColor$material3);
            if ((i7 & 458752) != 131072) {
                if ((i7 & 262144) != 0) {
                    stroke3 = stroke2;
                    if (composer2.changedInstance(stroke3)) {
                    }
                    boolean zChanged8 = zChanged7 | z2 | composer2.changed(stateCheckmarkColor$material3) | composer2.changed(stateCreateTransitionAnimation) | composer2.changed(stateCreateTransitionAnimation2);
                    if ((i7 & 57344) != 16384) {
                        if ((i7 & 32768) != 0) {
                            stroke4 = stroke;
                            if (composer2.changedInstance(stroke4)) {
                            }
                            z4 = zChanged8 | z3;
                            Object objRememberedValue6 = composer2.rememberedValue();
                            if (!z4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                final State<Color> state = stateCheckmarkColor$material3;
                                final Stroke stroke5 = stroke3;
                                i4 = 0;
                                obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke5, state, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                                    }
                                };
                                composer2.updateRememberedValue(obj);
                            } else {
                                obj = objRememberedValue6;
                                i4 = 0;
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            stroke4 = stroke;
                        }
                        z3 = false;
                        z4 = zChanged8 | z3;
                        Object objRememberedValue7 = composer2.rememberedValue();
                        if (z4) {
                            final State state2 = stateCheckmarkColor$material3;
                            final Stroke stroke6 = stroke3;
                            i4 = 0;
                            obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke6, state2, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                                }
                            };
                            composer2.updateRememberedValue(obj);
                        } else {
                            final State state3 = stateCheckmarkColor$material3;
                            final Stroke stroke7 = stroke3;
                            i4 = 0;
                            obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke7, state3, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                                }
                            };
                            composer2.updateRememberedValue(obj);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        stroke4 = stroke;
                    }
                    z3 = true;
                    z4 = zChanged8 | z3;
                    Object objRememberedValue8 = composer2.rememberedValue();
                    if (z4) {
                        final State state4 = stateCheckmarkColor$material3;
                        final Stroke stroke8 = stroke3;
                        i4 = 0;
                        obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke8, state4, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    } else {
                        final State state5 = stateCheckmarkColor$material3;
                        final Stroke stroke9 = stroke3;
                        i4 = 0;
                        obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke9, state5, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    stroke3 = stroke2;
                }
                z2 = false;
                boolean zChanged9 = zChanged7 | z2 | composer2.changed(stateCheckmarkColor$material3) | composer2.changed(stateCreateTransitionAnimation) | composer2.changed(stateCreateTransitionAnimation2);
                if ((i7 & 57344) != 16384) {
                    if ((i7 & 32768) != 0) {
                        stroke4 = stroke;
                        if (composer2.changedInstance(stroke4)) {
                        }
                        z4 = zChanged9 | z3;
                        Object objRememberedValue9 = composer2.rememberedValue();
                        if (z4) {
                            final State state6 = stateCheckmarkColor$material3;
                            final Stroke stroke10 = stroke3;
                            i4 = 0;
                            obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke10, state6, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                                }
                            };
                            composer2.updateRememberedValue(obj);
                        } else {
                            final State state7 = stateCheckmarkColor$material3;
                            final Stroke stroke11 = stroke3;
                            i4 = 0;
                            obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke11, state7, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                                }
                            };
                            composer2.updateRememberedValue(obj);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        stroke4 = stroke;
                    }
                    z3 = false;
                    z4 = zChanged9 | z3;
                    Object objRememberedValue10 = composer2.rememberedValue();
                    if (z4) {
                        final State state8 = stateCheckmarkColor$material3;
                        final Stroke stroke12 = stroke3;
                        i4 = 0;
                        obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke12, state8, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    } else {
                        final State state9 = stateCheckmarkColor$material3;
                        final Stroke stroke13 = stroke3;
                        i4 = 0;
                        obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke13, state9, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    stroke4 = stroke;
                }
                z3 = true;
                z4 = zChanged9 | z3;
                Object objRememberedValue11 = composer2.rememberedValue();
                if (z4) {
                    final State state10 = stateCheckmarkColor$material3;
                    final Stroke stroke14 = stroke3;
                    i4 = 0;
                    obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke14, state10, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                } else {
                    final State state11 = stateCheckmarkColor$material3;
                    final Stroke stroke15 = stroke3;
                    i4 = 0;
                    obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke15, state11, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                stroke3 = stroke2;
            }
            z2 = true;
            boolean zChanged10 = zChanged7 | z2 | composer2.changed(stateCheckmarkColor$material3) | composer2.changed(stateCreateTransitionAnimation) | composer2.changed(stateCreateTransitionAnimation2);
            if ((i7 & 57344) != 16384) {
                if ((i7 & 32768) != 0) {
                    stroke4 = stroke;
                    if (composer2.changedInstance(stroke4)) {
                    }
                    z4 = zChanged10 | z3;
                    Object objRememberedValue12 = composer2.rememberedValue();
                    if (z4) {
                        final State state12 = stateCheckmarkColor$material3;
                        final Stroke stroke16 = stroke3;
                        i4 = 0;
                        obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke16, state12, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    } else {
                        final State state13 = stateCheckmarkColor$material3;
                        final Stroke stroke17 = stroke3;
                        i4 = 0;
                        obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke17, state13, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                            }
                        };
                        composer2.updateRememberedValue(obj);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    stroke4 = stroke;
                }
                z3 = false;
                z4 = zChanged10 | z3;
                Object objRememberedValue13 = composer2.rememberedValue();
                if (z4) {
                    final State state14 = stateCheckmarkColor$material3;
                    final Stroke stroke18 = stroke3;
                    i4 = 0;
                    obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke18, state14, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                } else {
                    final State state15 = stateCheckmarkColor$material3;
                    final Stroke stroke19 = stroke3;
                    i4 = 0;
                    obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke19, state15, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                        }
                    };
                    composer2.updateRememberedValue(obj);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                stroke4 = stroke;
            }
            z3 = true;
            z4 = zChanged10 | z3;
            Object objRememberedValue14 = composer2.rememberedValue();
            if (z4) {
                final State state16 = stateCheckmarkColor$material3;
                final Stroke stroke110 = stroke3;
                i4 = 0;
                obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke110, state16, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            } else {
                final State state17 = stateCheckmarkColor$material3;
                final Stroke stroke111 = stroke3;
                i4 = 0;
                obj = new Function1() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return CheckboxKt.CheckboxImpl$lambda$5$0(stateBoxColor$material3, stateBorderColor$material3, stroke111, state17, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, stroke4, checkDrawingCache2, (DrawScope) obj2);
                    }
                };
                composer2.updateRememberedValue(obj);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            CanvasKt.Canvas(modifierM2409requiredSize3ABfNKs, (Function1) obj, composer2, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return CheckboxKt.CheckboxImpl$lambda$6(z, toggleableState, modifier, checkboxColors, stroke, stroke2, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    static final FiniteAnimationSpec CheckboxImpl$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(1780794470);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1780794470, i, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:484)");
        }
        if (segment.getInitialState() != ToggleableState.Off && segment.getTargetState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap(100);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    static final FiniteAnimationSpec CheckboxImpl$lambda$2(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(630790831);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(630790831, i, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:502)");
        }
        if (segment.getInitialState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap$default(0, 1, null);
        } else if (segment.getTargetState() == ToggleableState.Off) {
            finiteAnimationSpec = AnimationSpecKt.snap(100);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxImpl$lambda$5$0(State state, State state2, Stroke stroke, State state3, State state4, State state5, Stroke stroke2, CheckDrawingCache checkDrawingCache, DrawScope drawScope) {
        m3616drawBox1wkBAMs(drawScope, ((Color) state.getValue()).m7348unboximpl(), ((Color) state2.getValue()).m7348unboximpl(), drawScope.mo1734toPx0680j_4(RadiusSize), stroke);
        m3617drawCheck3IgeMak(drawScope, ((Color) state3.getValue()).m7348unboximpl(), ((Number) state4.getValue()).floatValue(), ((Number) state5.getValue()).floatValue(), stroke2, checkDrawingCache);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawBox-1wkBAMs, reason: not valid java name */
    private static final void m3616drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, Stroke stroke) {
        float width = stroke.getWidth() / 2.0f;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7912getSizeNHjbRc() >> 32));
        if (!Color.m7339equalsimpl0(j, j2)) {
            long jM7065constructorimpl = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(stroke.getWidth())) << 32) | (((long) Float.floatToRawIntBits(stroke.getWidth())) & 4294967295L));
            long jM7133constructorimpl = Size.m7133constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * 2.0f))) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat - (stroke.getWidth() * 2.0f))) & 4294967295L));
            float fMax = Math.max(0.0f, f - stroke.getWidth());
            DrawScope.m7908drawRoundRectuAw5IA$default(drawScope, j, jM7065constructorimpl, jM7133constructorimpl, CornerRadius.m7027constructorimpl((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 224, null);
            long jM7065constructorimpl2 = Offset.m7065constructorimpl((((long) Float.floatToRawIntBits(width)) << 32) | (((long) Float.floatToRawIntBits(width)) & 4294967295L));
            float width2 = fIntBitsToFloat - stroke.getWidth();
            float f2 = f - width;
            DrawScope.m7908drawRoundRectuAw5IA$default(drawScope, j2, jM7065constructorimpl2, Size.m7133constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat - stroke.getWidth())) & 4294967295L) | (Float.floatToRawIntBits(width2) << 32)), CornerRadius.m7027constructorimpl((((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L)), stroke, 0.0f, null, 0, 224, null);
            return;
        }
        DrawScope.m7908drawRoundRectuAw5IA$default(drawScope, j, 0L, Size.m7133constructorimpl((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L)), CornerRadius.m7027constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L)), Fill.INSTANCE, 0.0f, null, 0, 226, null);
    }

    /* JADX INFO: renamed from: drawCheck-3IgeMak, reason: not valid java name */
    private static final void m3617drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, Stroke stroke, CheckDrawingCache checkDrawingCache) {
        boolean z = ComposeMaterial3Flags.isCheckboxStylingFixEnabled;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7912getSizeNHjbRc() >> 32));
        float f3 = z ? 0.65f : 0.7f;
        float f4 = z ? 0.25f : 0.2f;
        float f5 = z ? 0.75f : 0.8f;
        float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float fLerp2 = MathHelpersKt.lerp(f3, 0.5f, f2);
        float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().rewind();
        checkDrawingCache.getCheckPath().moveTo(f4 * fIntBitsToFloat, fLerp3 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(fLerp * fIntBitsToFloat, fLerp2 * fIntBitsToFloat);
        checkDrawingCache.getCheckPath().lineTo(f5 * fIntBitsToFloat, fIntBitsToFloat * fLerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().rewind();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m7902drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }
}
