package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.AnimatedShapeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.composer.linkbuffer.GroupFlagsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToggleButton.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u009d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u009d\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u009d\u0001\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u009d\u0001\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u001c\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a3\u0010%\u001a\u00020&2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0003¢\u0006\u0002\u0010+\"\u001e\u0010\u001d\u001a\u00020\u0003*\u00020\n8@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u001e\u0010\"\u001a\u00020\u0003*\u00020\n8@X\u0080\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010!¨\u0006,²\u0006\n\u0010'\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"ToggleButton", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "shapes", "Landroidx/compose/material3/ToggleButtonShapes;", "colors", "Landroidx/compose/material3/ToggleButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/ToggleButtonShapes;Landroidx/compose/material3/ToggleButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ElevatedToggleButton", "TonalToggleButton", "OutlinedToggleButton", "hasRoundedCornerShapes", "getHasRoundedCornerShapes$annotations", "(Landroidx/compose/material3/ToggleButtonShapes;)V", "getHasRoundedCornerShapes", "(Landroidx/compose/material3/ToggleButtonShapes;)Z", "hasCornerBasedShapes", "getHasCornerBasedShapes$annotations", "getHasCornerBasedShapes", "shapeByInteraction", "Landroidx/compose/ui/graphics/Shape;", "pressed", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "(Landroidx/compose/material3/ToggleButtonShapes;ZZLandroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ToggleButtonKt {
    static final Unit ElevatedToggleButton$lambda$0(boolean z, Function1 function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        ElevatedToggleButton(z, function1, modifier, z2, toggleButtonShapes, toggleButtonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit OutlinedToggleButton$lambda$0(boolean z, Function1 function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        OutlinedToggleButton(z, function1, modifier, z2, toggleButtonShapes, toggleButtonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit ToggleButton$lambda$4(boolean z, Function1 function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        ToggleButton(z, function1, modifier, z2, toggleButtonShapes, toggleButtonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit TonalToggleButton$lambda$0(boolean z, Function1 function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, int i3, Composer composer, int i4) {
        TonalToggleButton(z, function1, modifier, z2, toggleButtonShapes, toggleButtonColors, buttonElevation, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getHasCornerBasedShapes$annotations(ToggleButtonShapes toggleButtonShapes) {
    }

    public static /* synthetic */ void getHasRoundedCornerShapes$annotations(ToggleButtonShapes toggleButtonShapes) {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0127  */
    /* JADX WARN: Code duplicated, block: B:107:0x012d  */
    /* JADX WARN: Code duplicated, block: B:108:0x0130  */
    /* JADX WARN: Code duplicated, block: B:110:0x0137  */
    /* JADX WARN: Code duplicated, block: B:113:0x0147  */
    /* JADX WARN: Code duplicated, block: B:117:0x014f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0158  */
    /* JADX WARN: Code duplicated, block: B:122:0x0173  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:139:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:147:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:153:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:154:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:156:0x0206  */
    /* JADX WARN: Code duplicated, block: B:157:0x0208  */
    /* JADX WARN: Code duplicated, block: B:160:0x020e  */
    /* JADX WARN: Code duplicated, block: B:161:0x022f  */
    /* JADX WARN: Code duplicated, block: B:163:0x0233  */
    /* JADX WARN: Code duplicated, block: B:164:0x023d  */
    /* JADX WARN: Code duplicated, block: B:168:0x0252  */
    /* JADX WARN: Code duplicated, block: B:171:0x025e  */
    /* JADX WARN: Code duplicated, block: B:173:0x027b  */
    /* JADX WARN: Code duplicated, block: B:175:0x028b  */
    /* JADX WARN: Code duplicated, block: B:178:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:179:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:181:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:182:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:185:0x031b  */
    /* JADX WARN: Code duplicated, block: B:188:0x0380  */
    /* JADX WARN: Code duplicated, block: B:190:0x0392  */
    /* JADX WARN: Code duplicated, block: B:193:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x0109  */
    /* JADX WARN: Code duplicated, block: B:97:0x010d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117  */
    public static final void ToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        ToggleButtonShapes toggleButtonShapes2;
        ToggleButtonColors toggleButtonColors2;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z4;
        final ButtonElevation buttonElevation2;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final ToggleButtonShapes toggleButtonShapes3;
        final ToggleButtonColors toggleButtonColors3;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z6;
        ToggleButtonShapes toggleButtonShapesM5034shapesFor8Feqmps;
        int i13;
        int i14;
        ButtonElevation buttonElevationM3548buttonElevationR_JCAzs;
        BorderStroke borderStroke4;
        final PaddingValues paddingValuesM3533contentPaddingFor8Feqmps$default;
        MutableInteractionSource mutableInteractionSource3;
        ButtonElevation buttonElevation3;
        Modifier modifier4;
        MutableInteractionSource mutableInteractionSource4;
        MutableInteractionSource mutableInteractionSource5;
        State<Dp> stateShadowElevation$material3;
        float fM10168constructorimpl;
        Object objRememberedValue;
        Object objRememberedValue2;
        int i15;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(579209066);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButton)N(checked,onCheckedChange,modifier,enabled,shapes,colors,elevation,border,contentPadding,interactionSource,content)128@6943L14,129@6995L25,133@7265L66,138@7454L24,146@7726L489,135@7337L878:ToggleButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i17 = i3 & 4;
        if (i17 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        toggleButtonShapes2 = toggleButtonShapes;
                        int i18 = composerStartRestartGroup.changed(toggleButtonShapes2) ? 16384 : 8192;
                        i4 |= i18;
                    } else {
                        toggleButtonShapes2 = toggleButtonShapes;
                    }
                    i4 |= i18;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                if ((196608 & i) == 0) {
                    if ((i3 & 32) == 0) {
                        toggleButtonColors2 = toggleButtonColors;
                        int i19 = composerStartRestartGroup.changed(toggleButtonColors2) ? 131072 : 65536;
                        i4 |= i19;
                    } else {
                        toggleButtonColors2 = toggleButtonColors;
                    }
                    i4 |= i19;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                if ((i & 1572864) != 0) {
                    if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(buttonElevation)) {
                        i16 = 524288;
                    } else {
                        i16 = 1048576;
                    }
                    i4 |= i16;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i4 |= i8;
                    }
                }
                if ((i & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i15 = 4;
                        } else {
                            i15 = 2;
                        }
                        i11 = i2 | i15;
                    } else {
                        i11 = i2;
                    }
                    i12 = i11;
                    if ((i4 & 306783379) == 306783378 || (i12 & 3) != 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z6 = true;
                            } else {
                                z6 = z3;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                                toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            } else {
                                toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                                toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                            }
                            i13 = i4;
                            if ((i3 & 64) != 0) {
                                i14 = 6;
                                buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                i13 &= -3670017;
                            } else {
                                i14 = 6;
                                buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                            }
                            if (i7 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke;
                            }
                            if ((i3 & 256) != 0) {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                                i13 &= -234881025;
                            } else {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                            modifier4 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            if ((i3 & 256) != 0) {
                                i4 &= -234881025;
                            }
                            mutableInteractionSource3 = mutableInteractionSource;
                            i12 = i12;
                            i13 = i4;
                            i14 = 6;
                            borderStroke4 = borderStroke2;
                            modifier4 = modifier2;
                            z6 = z3;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                            toggleButtonColors2 = toggleButtonColors2;
                            buttonElevation3 = buttonElevation;
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1960617487);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1725814362);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
                        mutableInteractionSource5 = mutableInteractionSource4;
                        State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                        long jM5020containerColorWaAFU9c$material3 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
                        final long jM5021contentColorWaAFU9c$material3 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
                        if (buttonElevation3 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1960202708);
                            composerStartRestartGroup.endReplaceGroup();
                            stateShadowElevation$material3 = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1725800331);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                            stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        if (stateShadowElevation$material3 != null) {
                            fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
                        } else {
                            fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                        }
                        float f = fM10168constructorimpl;
                        int i20 = i13 << 6;
                        Shape shapeShapeByInteraction = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState), z, finiteAnimationSpecValue, composerStartRestartGroup, ((i13 >> 12) & 14) | (i20 & 896));
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        PaddingValues paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        ToggleButtonColors toggleButtonColors4 = toggleButtonColors2;
                        ButtonElevation buttonElevation4 = buttonElevation3;
                        BorderStroke borderStroke5 = borderStroke4;
                        Modifier modifier5 = modifier4;
                        SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction, jM5020containerColorWaAFU9c$material3, jM5021contentColorWaAFU9c$material3, 0.0f, f, borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material3, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i20 & 1879048192), 48, 128);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z6;
                        borderStroke3 = borderStroke5;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        toggleButtonColors3 = toggleButtonColors4;
                        buttonElevation2 = buttonElevation4;
                        modifier3 = modifier5;
                        paddingValues2 = paddingValues3;
                        toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        buttonElevation2 = buttonElevation;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        toggleButtonShapes3 = toggleButtonShapes2;
                        toggleButtonColors3 = toggleButtonColors2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 4;
                    } else {
                        i15 = 2;
                    }
                    i11 = i2 | i15;
                } else {
                    i11 = i2;
                }
                i12 = i11;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i13 = i4;
                        if ((i3 & 64) != 0) {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i13 &= -3670017;
                        } else {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i13 &= -234881025;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                        modifier4 = companion;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i13 = i4;
                        if ((i3 & 64) != 0) {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i13 &= -3670017;
                        } else {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i13 &= -234881025;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1960617487);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1725814362);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
                    mutableInteractionSource5 = mutableInteractionSource4;
                    State<Boolean> stateCollectIsPressedAsState2 = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                    long jM5020containerColorWaAFU9c$material4 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
                    final long jM5021contentColorWaAFU9c$material4 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
                    if (buttonElevation3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1960202708);
                        composerStartRestartGroup.endReplaceGroup();
                        stateShadowElevation$material3 = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1725800331);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                        stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (stateShadowElevation$material3 != null) {
                        fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
                    } else {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    float f2 = fM10168constructorimpl;
                    int i21 = i13 << 6;
                    Shape shapeShapeByInteraction2 = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState2), z, finiteAnimationSpecValue2, composerStartRestartGroup, ((i13 >> 12) & 14) | (i21 & 896));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaddingValues paddingValues4 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    ToggleButtonColors toggleButtonColors5 = toggleButtonColors2;
                    ButtonElevation buttonElevation5 = buttonElevation3;
                    BorderStroke borderStroke6 = borderStroke4;
                    Modifier modifier6 = modifier4;
                    SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction2, jM5020containerColorWaAFU9c$material4, jM5021contentColorWaAFU9c$material4, 0.0f, f2, borderStroke6, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material4, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i21 & 1879048192), 48, 128);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z6;
                    borderStroke3 = borderStroke6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    toggleButtonColors3 = toggleButtonColors5;
                    buttonElevation2 = buttonElevation5;
                    modifier3 = modifier6;
                    paddingValues2 = paddingValues4;
                    toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    buttonElevation2 = buttonElevation;
                    borderStroke3 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i18;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i18;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColors2 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                    }
                    i4 |= i19;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                i4 |= i19;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i4 |= i16;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 4;
                    } else {
                        i15 = 2;
                    }
                    i11 = i2 | i15;
                } else {
                    i11 = i2;
                }
                i12 = i11;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i13 = i4;
                        if ((i3 & 64) != 0) {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i13 &= -3670017;
                        } else {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i13 &= -234881025;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                        modifier4 = companion;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i13 = i4;
                        if ((i3 & 64) != 0) {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i13 &= -3670017;
                        } else {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i13 &= -234881025;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1960617487);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1725814362);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
                    mutableInteractionSource5 = mutableInteractionSource4;
                    State<Boolean> stateCollectIsPressedAsState3 = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                    long jM5020containerColorWaAFU9c$material5 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
                    final long jM5021contentColorWaAFU9c$material5 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
                    if (buttonElevation3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1960202708);
                        composerStartRestartGroup.endReplaceGroup();
                        stateShadowElevation$material3 = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1725800331);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                        stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (stateShadowElevation$material3 != null) {
                        fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
                    } else {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    float f3 = fM10168constructorimpl;
                    int i22 = i13 << 6;
                    Shape shapeShapeByInteraction3 = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState3), z, finiteAnimationSpecValue3, composerStartRestartGroup, ((i13 >> 12) & 14) | (i22 & 896));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaddingValues paddingValues5 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    ToggleButtonColors toggleButtonColors6 = toggleButtonColors2;
                    ButtonElevation buttonElevation6 = buttonElevation3;
                    BorderStroke borderStroke7 = borderStroke4;
                    Modifier modifier7 = modifier4;
                    SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction3, jM5020containerColorWaAFU9c$material5, jM5021contentColorWaAFU9c$material5, 0.0f, f3, borderStroke7, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material5, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i22 & 1879048192), 48, 128);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z6;
                    borderStroke3 = borderStroke7;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    toggleButtonColors3 = toggleButtonColors6;
                    buttonElevation2 = buttonElevation6;
                    modifier3 = modifier7;
                    paddingValues2 = paddingValues5;
                    toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    buttonElevation2 = buttonElevation;
                    borderStroke3 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i11 = i2 | i15;
            } else {
                i11 = i2;
            }
            i12 = i11;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i13 = i4;
                    if ((i3 & 64) != 0) {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i13 &= -3670017;
                    } else {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i13 &= -234881025;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                    modifier4 = companion;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i13 = i4;
                    if ((i3 & 64) != 0) {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i13 &= -3670017;
                    } else {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i13 &= -234881025;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1960617487);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1725814362);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                FiniteAnimationSpec finiteAnimationSpecValue4 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
                mutableInteractionSource5 = mutableInteractionSource4;
                State<Boolean> stateCollectIsPressedAsState4 = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                long jM5020containerColorWaAFU9c$material6 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
                final long jM5021contentColorWaAFU9c$material6 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
                if (buttonElevation3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1960202708);
                    composerStartRestartGroup.endReplaceGroup();
                    stateShadowElevation$material3 = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1725800331);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                    stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (stateShadowElevation$material3 != null) {
                    fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                float f4 = fM10168constructorimpl;
                int i23 = i13 << 6;
                Shape shapeShapeByInteraction4 = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState4), z, finiteAnimationSpecValue4, composerStartRestartGroup, ((i13 >> 12) & 14) | (i23 & 896));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaddingValues paddingValues6 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                ToggleButtonColors toggleButtonColors7 = toggleButtonColors2;
                ButtonElevation buttonElevation7 = buttonElevation3;
                BorderStroke borderStroke8 = borderStroke4;
                Modifier modifier8 = modifier4;
                SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction4, jM5020containerColorWaAFU9c$material6, jM5021contentColorWaAFU9c$material6, 0.0f, f4, borderStroke8, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material6, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i23 & 1879048192), 48, 128);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z6;
                borderStroke3 = borderStroke8;
                mutableInteractionSource2 = mutableInteractionSource3;
                toggleButtonColors3 = toggleButtonColors7;
                buttonElevation2 = buttonElevation7;
                modifier3 = modifier8;
                paddingValues2 = paddingValues6;
                toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                buttonElevation2 = buttonElevation;
                borderStroke3 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i18;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i18;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColors2 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                    }
                    i4 |= i19;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                i4 |= i19;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            if ((i & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i4 |= i16;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 4;
                    } else {
                        i15 = 2;
                    }
                    i11 = i2 | i15;
                } else {
                    i11 = i2;
                }
                i12 = i11;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i13 = i4;
                        if ((i3 & 64) != 0) {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i13 &= -3670017;
                        } else {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i13 &= -234881025;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                        modifier4 = companion;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z6 = true;
                        } else {
                            z6 = z3;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i13 = i4;
                        if ((i3 & 64) != 0) {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i13 &= -3670017;
                        } else {
                            i14 = 6;
                            buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i13 &= -234881025;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1960617487);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1725814362);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    FiniteAnimationSpec finiteAnimationSpecValue5 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
                    mutableInteractionSource5 = mutableInteractionSource4;
                    State<Boolean> stateCollectIsPressedAsState5 = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                    long jM5020containerColorWaAFU9c$material7 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
                    final long jM5021contentColorWaAFU9c$material7 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
                    if (buttonElevation3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1960202708);
                        composerStartRestartGroup.endReplaceGroup();
                        stateShadowElevation$material3 = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1725800331);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                        stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (stateShadowElevation$material3 != null) {
                        fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
                    } else {
                        fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                    }
                    float f5 = fM10168constructorimpl;
                    int i24 = i13 << 6;
                    Shape shapeShapeByInteraction5 = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState5), z, finiteAnimationSpecValue5, composerStartRestartGroup, ((i13 >> 12) & 14) | (i24 & 896));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaddingValues paddingValues7 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    ToggleButtonColors toggleButtonColors8 = toggleButtonColors2;
                    ButtonElevation buttonElevation8 = buttonElevation3;
                    BorderStroke borderStroke9 = borderStroke4;
                    Modifier modifier9 = modifier4;
                    SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction5, jM5020containerColorWaAFU9c$material7, jM5021contentColorWaAFU9c$material7, 0.0f, f5, borderStroke9, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material7, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i24 & 1879048192), 48, 128);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z6;
                    borderStroke3 = borderStroke9;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    toggleButtonColors3 = toggleButtonColors8;
                    buttonElevation2 = buttonElevation8;
                    modifier3 = modifier9;
                    paddingValues2 = paddingValues7;
                    toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    buttonElevation2 = buttonElevation;
                    borderStroke3 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i11 = i2 | i15;
            } else {
                i11 = i2;
            }
            i12 = i11;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i13 = i4;
                    if ((i3 & 64) != 0) {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i13 &= -3670017;
                    } else {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i13 &= -234881025;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                    modifier4 = companion;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i13 = i4;
                    if ((i3 & 64) != 0) {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i13 &= -3670017;
                    } else {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i13 &= -234881025;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1960617487);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1725814362);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                FiniteAnimationSpec finiteAnimationSpecValue6 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
                mutableInteractionSource5 = mutableInteractionSource4;
                State<Boolean> stateCollectIsPressedAsState6 = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                long jM5020containerColorWaAFU9c$material8 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
                final long jM5021contentColorWaAFU9c$material8 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
                if (buttonElevation3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1960202708);
                    composerStartRestartGroup.endReplaceGroup();
                    stateShadowElevation$material3 = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1725800331);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                    stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (stateShadowElevation$material3 != null) {
                    fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                float f6 = fM10168constructorimpl;
                int i25 = i13 << 6;
                Shape shapeShapeByInteraction6 = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState6), z, finiteAnimationSpecValue6, composerStartRestartGroup, ((i13 >> 12) & 14) | (i25 & 896));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaddingValues paddingValues8 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                ToggleButtonColors toggleButtonColors9 = toggleButtonColors2;
                ButtonElevation buttonElevation9 = buttonElevation3;
                BorderStroke borderStroke10 = borderStroke4;
                Modifier modifier10 = modifier4;
                SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction6, jM5020containerColorWaAFU9c$material8, jM5021contentColorWaAFU9c$material8, 0.0f, f6, borderStroke10, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material8, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i25 & 1879048192), 48, 128);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z6;
                borderStroke3 = borderStroke10;
                mutableInteractionSource2 = mutableInteractionSource3;
                toggleButtonColors3 = toggleButtonColors9;
                buttonElevation2 = buttonElevation9;
                modifier3 = modifier10;
                paddingValues2 = paddingValues8;
                toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                buttonElevation2 = buttonElevation;
                borderStroke3 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                toggleButtonShapes2 = toggleButtonShapes;
                if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                }
                i4 |= i18;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            i4 |= i18;
        } else {
            toggleButtonShapes2 = toggleButtonShapes;
        }
        if ((196608 & i) == 0) {
            if ((i3 & 32) == 0) {
                toggleButtonColors2 = toggleButtonColors;
                if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                }
                i4 |= i19;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            i4 |= i19;
        } else {
            toggleButtonColors2 = toggleButtonColors;
        }
        if ((i & 1572864) != 0) {
            if ((i3 & 64) == 0) {
                i16 = 524288;
            } else {
                i16 = 524288;
            }
            i4 |= i16;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        i9 = i3 & 512;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 4;
                } else {
                    i15 = 2;
                }
                i11 = i2 | i15;
            } else {
                i11 = i2;
            }
            i12 = i11;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i13 = i4;
                    if ((i3 & 64) != 0) {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i13 &= -3670017;
                    } else {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i13 &= -234881025;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                    modifier4 = companion;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z6 = true;
                    } else {
                        z6 = z3;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i13 = i4;
                    if ((i3 & 64) != 0) {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i13 &= -3670017;
                    } else {
                        i14 = 6;
                        buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i13 &= -234881025;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1960617487);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1725814362);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                FiniteAnimationSpec finiteAnimationSpecValue7 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
                mutableInteractionSource5 = mutableInteractionSource4;
                State<Boolean> stateCollectIsPressedAsState7 = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
                long jM5020containerColorWaAFU9c$material9 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
                final long jM5021contentColorWaAFU9c$material9 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
                if (buttonElevation3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1960202708);
                    composerStartRestartGroup.endReplaceGroup();
                    stateShadowElevation$material3 = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1725800331);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                    stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (stateShadowElevation$material3 != null) {
                    fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
                } else {
                    fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
                }
                float f7 = fM10168constructorimpl;
                int i26 = i13 << 6;
                Shape shapeShapeByInteraction7 = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState7), z, finiteAnimationSpecValue7, composerStartRestartGroup, ((i13 >> 12) & 14) | (i26 & 896));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaddingValues paddingValues9 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                ToggleButtonColors toggleButtonColors10 = toggleButtonColors2;
                ButtonElevation buttonElevation10 = buttonElevation3;
                BorderStroke borderStroke11 = borderStroke4;
                Modifier modifier11 = modifier4;
                SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction7, jM5020containerColorWaAFU9c$material9, jM5021contentColorWaAFU9c$material9, 0.0f, f7, borderStroke11, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material9, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i26 & 1879048192), 48, 128);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z6;
                borderStroke3 = borderStroke11;
                mutableInteractionSource2 = mutableInteractionSource3;
                toggleButtonColors3 = toggleButtonColors10;
                buttonElevation2 = buttonElevation10;
                modifier3 = modifier11;
                paddingValues2 = paddingValues9;
                toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                buttonElevation2 = buttonElevation;
                borderStroke3 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i11 = i2 | i15;
        } else {
            i11 = i2;
        }
        i12 = i11;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "117@6267L35,118@6358L20,119@6429L17");
            if ((i & 1) != 0) {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                } else {
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                }
                i13 = i4;
                if ((i3 & 64) != 0) {
                    i14 = 6;
                    buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    i13 &= -3670017;
                } else {
                    i14 = 6;
                    buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                }
                if (i7 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i13 &= -234881025;
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                modifier4 = companion;
            } else {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                } else {
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    i4 &= -458753;
                    toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.toggleButtonColors(composerStartRestartGroup, 6);
                }
                i13 = i4;
                if ((i3 & 64) != 0) {
                    i14 = 6;
                    buttonElevationM3548buttonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3548buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    i13 &= -3670017;
                } else {
                    i14 = 6;
                    buttonElevationM3548buttonElevationR_JCAzs = buttonElevation;
                }
                if (i7 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i13 &= -234881025;
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                buttonElevation3 = buttonElevationM3548buttonElevationR_JCAzs;
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(579209066, i13, i12, "androidx.compose.material3.ToggleButton (ToggleButton.kt:124)");
            }
            if (mutableInteractionSource3 == null) {
                composerStartRestartGroup.startReplaceGroup(-1960617487);
                ComposerKt.sourceInformation(composerStartRestartGroup, "126@6766L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725813711, "CC(remember):ToggleButton.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1725814362);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            FiniteAnimationSpec finiteAnimationSpecValue8 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, i14);
            mutableInteractionSource5 = mutableInteractionSource4;
            State<Boolean> stateCollectIsPressedAsState8 = PressInteractionKt.collectIsPressedAsState(mutableInteractionSource5, composerStartRestartGroup, 0);
            long jM5020containerColorWaAFU9c$material10 = toggleButtonColors2.m5020containerColorWaAFU9c$material3(z6, z);
            final long jM5021contentColorWaAFU9c$material10 = toggleButtonColors2.m5021contentColorWaAFU9c$material3(z6, z);
            if (buttonElevation3 == null) {
                composerStartRestartGroup.startReplaceGroup(-1960202708);
                composerStartRestartGroup.endReplaceGroup();
                stateShadowElevation$material3 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1725800331);
                ComposerKt.sourceInformation(composerStartRestartGroup, "132@7184L43");
                stateShadowElevation$material3 = buttonElevation3.shadowElevation$material3(z6, mutableInteractionSource5, composerStartRestartGroup, ((i13 >> 9) & 14) | ((i13 >> 12) & 896));
                composerStartRestartGroup.endReplaceGroup();
            }
            if (stateShadowElevation$material3 != null) {
                fM10168constructorimpl = stateShadowElevation$material3.getValue().m10182unboximpl();
            } else {
                fM10168constructorimpl = Dp.m10168constructorimpl(0.0f);
            }
            float f8 = fM10168constructorimpl;
            int i27 = i13 << 6;
            Shape shapeShapeByInteraction8 = shapeByInteraction(toggleButtonShapesM5034shapesFor8Feqmps, ToggleButton$lambda$1(stateCollectIsPressedAsState8), z, finiteAnimationSpecValue8, composerStartRestartGroup, ((i13 >> 12) & 14) | (i27 & 896));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1725791710, "CC(remember):ToggleButton.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ToggleButtonKt.ToggleButton$lambda$2$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PaddingValues paddingValues10 = paddingValuesM3533contentPaddingFor8Feqmps$default;
            ToggleButtonColors toggleButtonColors11 = toggleButtonColors2;
            ButtonElevation buttonElevation11 = buttonElevation3;
            BorderStroke borderStroke12 = borderStroke4;
            Modifier modifier12 = modifier4;
            SurfaceKt.m4783Surfaced85dljk(z, function1, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shapeShapeByInteraction8, jM5020containerColorWaAFU9c$material10, jM5021contentColorWaAFU9c$material10, 0.0f, f8, borderStroke12, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1671845632, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonKt.ToggleButton$lambda$3(jM5021contentColorWaAFU9c$material10, paddingValuesM3533contentPaddingFor8Feqmps$default, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 7294) | (i27 & 1879048192), 48, 128);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z6;
            borderStroke3 = borderStroke12;
            mutableInteractionSource2 = mutableInteractionSource3;
            toggleButtonColors3 = toggleButtonColors11;
            buttonElevation2 = buttonElevation11;
            modifier3 = modifier12;
            paddingValues2 = paddingValues10;
            toggleButtonShapes3 = toggleButtonShapesM5034shapesFor8Feqmps;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            buttonElevation2 = buttonElevation;
            borderStroke3 = borderStroke;
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            toggleButtonShapes3 = toggleButtonShapes2;
            toggleButtonColors3 = toggleButtonColors2;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonKt.ToggleButton$lambda$4(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation2, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleButton$lambda$2$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m9387setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m9370getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    static final Unit ToggleButton$lambda$3(long j, final PaddingValues paddingValues, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C149@7845L10,150@7878L331,147@7736L473:ToggleButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1671845632, i, -1, "androidx.compose.material3.ToggleButton.<anonymous> (ToggleButton.kt:147)");
            }
            ProvideContentColorTextStyleKt.m5412ProvideContentColorTextStyle3JVO9M(j, MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(1921972184, true, new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonKt.ToggleButton$lambda$3$0(paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ToggleButton$lambda$3$0(PaddingValues paddingValues, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C151@7892L307:ToggleButton.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1921972184, i, -1, "androidx.compose.material3.ToggleButton.<anonymous>.<anonymous> (ToggleButton.kt:151)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m2402defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ToggleButtonDefaults.INSTANCE.m5032getMinHeightD9Ej5fM(), 1, null), paddingValues);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6438constructorimpl = Updater.m6438constructorimpl(composer);
            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0115  */
    /* JADX WARN: Code duplicated, block: B:101:0x0118  */
    /* JADX WARN: Code duplicated, block: B:106:0x0127  */
    /* JADX WARN: Code duplicated, block: B:108:0x012d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0130  */
    /* JADX WARN: Code duplicated, block: B:111:0x0137  */
    /* JADX WARN: Code duplicated, block: B:114:0x0149  */
    /* JADX WARN: Code duplicated, block: B:118:0x0151  */
    /* JADX WARN: Code duplicated, block: B:121:0x015b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0173  */
    /* JADX WARN: Code duplicated, block: B:140:0x01aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:148:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:155:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:156:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:159:0x0201  */
    /* JADX WARN: Code duplicated, block: B:160:0x0203  */
    /* JADX WARN: Code duplicated, block: B:163:0x0209  */
    /* JADX WARN: Code duplicated, block: B:164:0x0229  */
    /* JADX WARN: Code duplicated, block: B:166:0x022f  */
    /* JADX WARN: Code duplicated, block: B:167:0x0236  */
    /* JADX WARN: Code duplicated, block: B:171:0x0250  */
    /* JADX WARN: Code duplicated, block: B:174:0x0270  */
    /* JADX WARN: Code duplicated, block: B:176:0x0286  */
    /* JADX WARN: Code duplicated, block: B:179:0x029c  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:92:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:95:0x0104  */
    /* JADX WARN: Code duplicated, block: B:96:0x0107  */
    /* JADX WARN: Code duplicated, block: B:98:0x010b  */
    public static final void ElevatedToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        ToggleButtonShapes toggleButtonShapes2;
        ToggleButtonColors toggleButtonColorsElevatedToggleButtonColors;
        ButtonElevation buttonElevation2;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final ToggleButtonShapes toggleButtonShapes3;
        final ToggleButtonColors toggleButtonColors2;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i13;
        ToggleButtonShapes toggleButtonShapesM5034shapesFor8Feqmps;
        int i14;
        int i15;
        ButtonElevation buttonElevationM3552elevatedButtonElevationR_JCAzs;
        BorderStroke borderStroke4;
        PaddingValues paddingValuesM3533contentPaddingFor8Feqmps$default;
        int i16;
        MutableInteractionSource mutableInteractionSource3;
        PaddingValues paddingValues3;
        int i17;
        ToggleButtonColors toggleButtonColors3;
        boolean z6;
        ToggleButtonShapes toggleButtonShapes4;
        BorderStroke borderStroke5;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(177028532);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedToggleButton)N(checked,onCheckedChange,modifier,enabled,shapes,colors,elevation,border,contentPadding,interactionSource,content)218@11533L366:ToggleButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i19 = i3 & 4;
        if (i19 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        toggleButtonShapes2 = toggleButtonShapes;
                        int i20 = composerStartRestartGroup.changed(toggleButtonShapes2) ? 16384 : 8192;
                        i4 |= i20;
                    } else {
                        toggleButtonShapes2 = toggleButtonShapes;
                    }
                    i4 |= i20;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                if ((196608 & i) == 0) {
                    if ((i3 & 32) == 0) {
                        toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                        int i21 = composerStartRestartGroup.changed(toggleButtonColorsElevatedToggleButtonColors) ? 131072 : 65536;
                        i4 |= i21;
                    } else {
                        toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                    }
                    i4 |= i21;
                } else {
                    toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                }
                if ((1572864 & i) == 0) {
                    if ((i3 & 64) == 0) {
                        buttonElevation2 = buttonElevation;
                        int i22 = composerStartRestartGroup.changed(buttonElevation2) ? 1048576 : 524288;
                        i4 |= i22;
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i4 |= i22;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i4 |= i8;
                    }
                }
                if ((i & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i18 = 4;
                        } else {
                            i18 = 2;
                        }
                        i11 = i2 | i18;
                    } else {
                        i11 = i2;
                    }
                    i12 = i4;
                    if ((i4 & 306783379) == 306783378 || (i11 & 3) != 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i19 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            boolean z7 = i5 == 0 ? z3 : true;
                            if ((i3 & 16) != 0) {
                                i13 = i12 & (-57345);
                                toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            } else {
                                i13 = i12;
                                toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                            }
                            if ((i3 & 32) != 0) {
                                i13 &= -458753;
                                toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                            }
                            i14 = i13;
                            if ((i3 & 64) != 0) {
                                buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                i14 &= -3670017;
                                i15 = i11;
                            } else {
                                i15 = i11;
                                buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                            }
                            if (i7 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke;
                            }
                            if ((i3 & 256) != 0) {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                                i16 = i14 & (-234881025);
                            } else {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                                i16 = i14;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            i17 = i16;
                            toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                            z6 = z7;
                            toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                            borderStroke5 = borderStroke4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i17 = (i3 & 16) != 0 ? i12 & (-57345) : i12;
                            if ((i3 & 32) != 0) {
                                i17 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                i17 &= -3670017;
                            }
                            if ((i3 & 256) != 0) {
                                i17 &= -234881025;
                            }
                            paddingValues3 = paddingValues;
                            mutableInteractionSource3 = mutableInteractionSource;
                            i15 = i11;
                            borderStroke5 = borderStroke2;
                            companion = modifier2;
                            z6 = z3;
                            toggleButtonShapes4 = toggleButtonShapes2;
                            toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
                        }
                        ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        z5 = z6;
                        toggleButtonShapes3 = toggleButtonShapes4;
                        toggleButtonColors2 = toggleButtonColors3;
                        buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
                        borderStroke3 = borderStroke5;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        toggleButtonShapes3 = toggleButtonShapes2;
                        toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
                        buttonElevation3 = buttonElevation2;
                        borderStroke3 = borderStroke;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i11 = i2 | i18;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    toggleButtonColors2 = toggleButtonColors3;
                    buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
                    borderStroke3 = borderStroke5;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i20;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i20;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsElevatedToggleButtonColors)) {
                    }
                    i4 |= i21;
                } else {
                    toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                }
                i4 |= i21;
            } else {
                toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
            }
            if ((1572864 & i) == 0) {
                if ((i3 & 64) == 0) {
                    buttonElevation2 = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevation2)) {
                    }
                    i4 |= i22;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i4 |= i22;
            } else {
                buttonElevation2 = buttonElevation;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i11 = i2 | i18;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    toggleButtonColors2 = toggleButtonColors3;
                    buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
                    borderStroke3 = borderStroke5;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i11 = i2 | i18;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
                toggleButtonShapes3 = toggleButtonShapes4;
                toggleButtonColors2 = toggleButtonColors3;
                buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
                borderStroke3 = borderStroke5;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i20;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i20;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColorsElevatedToggleButtonColors)) {
                    }
                    i4 |= i21;
                } else {
                    toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                }
                i4 |= i21;
            } else {
                toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
            }
            if ((1572864 & i) == 0) {
                if ((i3 & 64) == 0) {
                    buttonElevation2 = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevation2)) {
                    }
                    i4 |= i22;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i4 |= i22;
            } else {
                buttonElevation2 = buttonElevation;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i11 = i2 | i18;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    toggleButtonColors2 = toggleButtonColors3;
                    buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
                    borderStroke3 = borderStroke5;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i11 = i2 | i18;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
                toggleButtonShapes3 = toggleButtonShapes4;
                toggleButtonColors2 = toggleButtonColors3;
                buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
                borderStroke3 = borderStroke5;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                toggleButtonShapes2 = toggleButtonShapes;
                if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                }
                i4 |= i20;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            i4 |= i20;
        } else {
            toggleButtonShapes2 = toggleButtonShapes;
        }
        if ((196608 & i) == 0) {
            if ((i3 & 32) == 0) {
                toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
                if (composerStartRestartGroup.changed(toggleButtonColorsElevatedToggleButtonColors)) {
                }
                i4 |= i21;
            } else {
                toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
            }
            i4 |= i21;
        } else {
            toggleButtonColorsElevatedToggleButtonColors = toggleButtonColors;
        }
        if ((1572864 & i) == 0) {
            if ((i3 & 64) == 0) {
                buttonElevation2 = buttonElevation;
                if (composerStartRestartGroup.changed(buttonElevation2)) {
                }
                i4 |= i22;
            } else {
                buttonElevation2 = buttonElevation;
            }
            i4 |= i22;
        } else {
            buttonElevation2 = buttonElevation;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        i9 = i3 & 512;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i11 = i2 | i18;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
                toggleButtonShapes3 = toggleButtonShapes4;
                toggleButtonColors2 = toggleButtonColors3;
                buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
                borderStroke3 = borderStroke5;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i11 = i2 | i18;
        } else {
            i11 = i2;
        }
        i12 = i4;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "210@11095L35,211@11186L28,212@11265L25");
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 16) != 0) {
                    i13 = i12 & (-57345);
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                } else {
                    i13 = i12;
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    i13 &= -458753;
                    toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                }
                i14 = i13;
                if ((i3 & 64) != 0) {
                    buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    i14 &= -3670017;
                    i15 = i11;
                } else {
                    i15 = i11;
                    buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                }
                if (i7 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i16 = i14 & (-234881025);
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    i16 = i14;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                i17 = i16;
                toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                z6 = z7;
                toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                borderStroke5 = borderStroke4;
            } else {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 16) != 0) {
                    i13 = i12 & (-57345);
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                } else {
                    i13 = i12;
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    i13 &= -458753;
                    toggleButtonColorsElevatedToggleButtonColors = ToggleButtonDefaults.INSTANCE.elevatedToggleButtonColors(composerStartRestartGroup, 6);
                }
                i14 = i13;
                if ((i3 & 64) != 0) {
                    buttonElevationM3552elevatedButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3552elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    i14 &= -3670017;
                    i15 = i11;
                } else {
                    i15 = i11;
                    buttonElevationM3552elevatedButtonElevationR_JCAzs = buttonElevation2;
                }
                if (i7 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i16 = i14 & (-234881025);
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    i16 = i14;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                i17 = i16;
                toggleButtonColors3 = toggleButtonColorsElevatedToggleButtonColors;
                z6 = z7;
                toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                borderStroke5 = borderStroke4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(177028532, i17, i15, "androidx.compose.material3.ElevatedToggleButton (ToggleButton.kt:218)");
            }
            ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors3, buttonElevationM3552elevatedButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            z5 = z6;
            toggleButtonShapes3 = toggleButtonShapes4;
            toggleButtonColors2 = toggleButtonColors3;
            buttonElevation3 = buttonElevationM3552elevatedButtonElevationR_JCAzs;
            borderStroke3 = borderStroke5;
            paddingValues2 = paddingValues3;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            toggleButtonShapes3 = toggleButtonShapes2;
            toggleButtonColors2 = toggleButtonColorsElevatedToggleButtonColors;
            buttonElevation3 = buttonElevation2;
            borderStroke3 = borderStroke;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonKt.ElevatedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors2, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0115  */
    /* JADX WARN: Code duplicated, block: B:101:0x0118  */
    /* JADX WARN: Code duplicated, block: B:106:0x0127  */
    /* JADX WARN: Code duplicated, block: B:108:0x012d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0130  */
    /* JADX WARN: Code duplicated, block: B:111:0x0137  */
    /* JADX WARN: Code duplicated, block: B:114:0x0149  */
    /* JADX WARN: Code duplicated, block: B:118:0x0151  */
    /* JADX WARN: Code duplicated, block: B:121:0x015b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0173  */
    /* JADX WARN: Code duplicated, block: B:140:0x01aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:148:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:149:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:155:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:156:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:159:0x0201  */
    /* JADX WARN: Code duplicated, block: B:160:0x0203  */
    /* JADX WARN: Code duplicated, block: B:163:0x0209  */
    /* JADX WARN: Code duplicated, block: B:164:0x0229  */
    /* JADX WARN: Code duplicated, block: B:166:0x022f  */
    /* JADX WARN: Code duplicated, block: B:167:0x0236  */
    /* JADX WARN: Code duplicated, block: B:171:0x0250  */
    /* JADX WARN: Code duplicated, block: B:174:0x0270  */
    /* JADX WARN: Code duplicated, block: B:176:0x0286  */
    /* JADX WARN: Code duplicated, block: B:179:0x029c  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:92:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:95:0x0104  */
    /* JADX WARN: Code duplicated, block: B:96:0x0107  */
    /* JADX WARN: Code duplicated, block: B:98:0x010b  */
    public static final void TonalToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        ToggleButtonShapes toggleButtonShapes2;
        ToggleButtonColors toggleButtonColors2;
        ButtonElevation buttonElevation2;
        int i7;
        BorderStroke borderStroke2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final ToggleButtonShapes toggleButtonShapes3;
        final ToggleButtonColors toggleButtonColors3;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i13;
        ToggleButtonShapes toggleButtonShapesM5034shapesFor8Feqmps;
        int i14;
        int i15;
        ButtonElevation buttonElevationM3554filledTonalButtonElevationR_JCAzs;
        BorderStroke borderStroke4;
        PaddingValues paddingValuesM3533contentPaddingFor8Feqmps$default;
        int i16;
        MutableInteractionSource mutableInteractionSource3;
        PaddingValues paddingValues3;
        int i17;
        ToggleButtonColors toggleButtonColors4;
        boolean z6;
        ToggleButtonShapes toggleButtonShapes4;
        BorderStroke borderStroke5;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1466986964);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TonalToggleButton)N(checked,onCheckedChange,modifier,enabled,shapes,colors,elevation,border,contentPadding,interactionSource,content)291@15440L366:ToggleButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i19 = i3 & 4;
        if (i19 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        toggleButtonShapes2 = toggleButtonShapes;
                        int i20 = composerStartRestartGroup.changed(toggleButtonShapes2) ? 16384 : 8192;
                        i4 |= i20;
                    } else {
                        toggleButtonShapes2 = toggleButtonShapes;
                    }
                    i4 |= i20;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                if ((196608 & i) == 0) {
                    if ((i3 & 32) == 0) {
                        toggleButtonColors2 = toggleButtonColors;
                        int i21 = composerStartRestartGroup.changed(toggleButtonColors2) ? 131072 : 65536;
                        i4 |= i21;
                    } else {
                        toggleButtonColors2 = toggleButtonColors;
                    }
                    i4 |= i21;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                if ((1572864 & i) == 0) {
                    if ((i3 & 64) == 0) {
                        buttonElevation2 = buttonElevation;
                        int i22 = composerStartRestartGroup.changed(buttonElevation2) ? 1048576 : 524288;
                        i4 |= i22;
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i4 |= i22;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i4 |= i8;
                    }
                }
                if ((i & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i18 = 4;
                        } else {
                            i18 = 2;
                        }
                        i11 = i2 | i18;
                    } else {
                        i11 = i2;
                    }
                    i12 = i4;
                    if ((i4 & 306783379) == 306783378 || (i11 & 3) != 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i19 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            boolean z7 = i5 == 0 ? z3 : true;
                            if ((i3 & 16) != 0) {
                                i13 = i12 & (-57345);
                                toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            } else {
                                i13 = i12;
                                toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                            }
                            if ((i3 & 32) != 0) {
                                i13 &= -458753;
                                toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                            }
                            i14 = i13;
                            if ((i3 & 64) != 0) {
                                buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                i14 &= -3670017;
                                i15 = i11;
                            } else {
                                i15 = i11;
                                buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                            }
                            if (i7 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke;
                            }
                            if ((i3 & 256) != 0) {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                                i16 = i14 & (-234881025);
                            } else {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                                i16 = i14;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            i17 = i16;
                            toggleButtonColors4 = toggleButtonColors2;
                            z6 = z7;
                            toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                            borderStroke5 = borderStroke4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i17 = (i3 & 16) != 0 ? i12 & (-57345) : i12;
                            if ((i3 & 32) != 0) {
                                i17 &= -458753;
                            }
                            if ((i3 & 64) != 0) {
                                i17 &= -3670017;
                            }
                            if ((i3 & 256) != 0) {
                                i17 &= -234881025;
                            }
                            paddingValues3 = paddingValues;
                            mutableInteractionSource3 = mutableInteractionSource;
                            i15 = i11;
                            borderStroke5 = borderStroke2;
                            companion = modifier2;
                            z6 = z3;
                            toggleButtonShapes4 = toggleButtonShapes2;
                            toggleButtonColors4 = toggleButtonColors2;
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
                        }
                        ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        z5 = z6;
                        toggleButtonShapes3 = toggleButtonShapes4;
                        toggleButtonColors3 = toggleButtonColors4;
                        buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
                        borderStroke3 = borderStroke5;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        toggleButtonShapes3 = toggleButtonShapes2;
                        toggleButtonColors3 = toggleButtonColors2;
                        buttonElevation3 = buttonElevation2;
                        borderStroke3 = borderStroke;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i11 = i2 | i18;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors4 = toggleButtonColors2;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors4 = toggleButtonColors2;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    toggleButtonColors3 = toggleButtonColors4;
                    buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
                    borderStroke3 = borderStroke5;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i20;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i20;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColors2 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                    }
                    i4 |= i21;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                i4 |= i21;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            if ((1572864 & i) == 0) {
                if ((i3 & 64) == 0) {
                    buttonElevation2 = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevation2)) {
                    }
                    i4 |= i22;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i4 |= i22;
            } else {
                buttonElevation2 = buttonElevation;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i11 = i2 | i18;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors4 = toggleButtonColors2;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors4 = toggleButtonColors2;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    toggleButtonColors3 = toggleButtonColors4;
                    buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
                    borderStroke3 = borderStroke5;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i11 = i2 | i18;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors4 = toggleButtonColors2;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors4 = toggleButtonColors2;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
                toggleButtonShapes3 = toggleButtonShapes4;
                toggleButtonColors3 = toggleButtonColors4;
                buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
                borderStroke3 = borderStroke5;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i20;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i20;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColors2 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                    }
                    i4 |= i21;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                i4 |= i21;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            if ((1572864 & i) == 0) {
                if ((i3 & 64) == 0) {
                    buttonElevation2 = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevation2)) {
                    }
                    i4 |= i22;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i4 |= i22;
            } else {
                buttonElevation2 = buttonElevation;
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i18 = 4;
                    } else {
                        i18 = 2;
                    }
                    i11 = i2 | i18;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
                    if ((i & 1) != 0) {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors4 = toggleButtonColors2;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    } else {
                        if (i19 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 == 0) {
                        }
                        if ((i3 & 16) != 0) {
                            i13 = i12 & (-57345);
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            i13 &= -458753;
                            toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                        }
                        i14 = i13;
                        if ((i3 & 64) != 0) {
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            i14 &= -3670017;
                            i15 = i11;
                        } else {
                            i15 = i11;
                            buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                        }
                        if (i7 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i16 = i14 & (-234881025);
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i16 = i14;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        i17 = i16;
                        toggleButtonColors4 = toggleButtonColors2;
                        z6 = z7;
                        toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke5 = borderStroke4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z5 = z6;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    toggleButtonColors3 = toggleButtonColors4;
                    buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
                    borderStroke3 = borderStroke5;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    buttonElevation3 = buttonElevation2;
                    borderStroke3 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i11 = i2 | i18;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors4 = toggleButtonColors2;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors4 = toggleButtonColors2;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
                toggleButtonShapes3 = toggleButtonShapes4;
                toggleButtonColors3 = toggleButtonColors4;
                buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
                borderStroke3 = borderStroke5;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                toggleButtonShapes2 = toggleButtonShapes;
                if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                }
                i4 |= i20;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            i4 |= i20;
        } else {
            toggleButtonShapes2 = toggleButtonShapes;
        }
        if ((196608 & i) == 0) {
            if ((i3 & 32) == 0) {
                toggleButtonColors2 = toggleButtonColors;
                if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                }
                i4 |= i21;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            i4 |= i21;
        } else {
            toggleButtonColors2 = toggleButtonColors;
        }
        if ((1572864 & i) == 0) {
            if ((i3 & 64) == 0) {
                buttonElevation2 = buttonElevation;
                if (composerStartRestartGroup.changed(buttonElevation2)) {
                }
                i4 |= i22;
            } else {
                buttonElevation2 = buttonElevation;
            }
            i4 |= i22;
        } else {
            buttonElevation2 = buttonElevation;
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        i9 = i3 & 512;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i18 = 4;
                } else {
                    i18 = 2;
                }
                i11 = i2 | i18;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
                if ((i & 1) != 0) {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors4 = toggleButtonColors2;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                } else {
                    if (i19 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 == 0) {
                    }
                    if ((i3 & 16) != 0) {
                        i13 = i12 & (-57345);
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        i13 &= -458753;
                        toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                    }
                    i14 = i13;
                    if ((i3 & 64) != 0) {
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        i14 &= -3670017;
                        i15 = i11;
                    } else {
                        i15 = i11;
                        buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                    }
                    if (i7 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i16 = i14 & (-234881025);
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i16 = i14;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    i17 = i16;
                    toggleButtonColors4 = toggleButtonColors2;
                    z6 = z7;
                    toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke5 = borderStroke4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z5 = z6;
                toggleButtonShapes3 = toggleButtonShapes4;
                toggleButtonColors3 = toggleButtonColors4;
                buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
                borderStroke3 = borderStroke5;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                buttonElevation3 = buttonElevation2;
                borderStroke3 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i11 = i2 | i18;
        } else {
            i11 = i2;
        }
        i12 = i4;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "283@15002L35,284@15093L25,285@15169L28");
            if ((i & 1) != 0) {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 16) != 0) {
                    i13 = i12 & (-57345);
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                } else {
                    i13 = i12;
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    i13 &= -458753;
                    toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                }
                i14 = i13;
                if ((i3 & 64) != 0) {
                    buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    i14 &= -3670017;
                    i15 = i11;
                } else {
                    i15 = i11;
                    buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                }
                if (i7 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i16 = i14 & (-234881025);
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    i16 = i14;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                i17 = i16;
                toggleButtonColors4 = toggleButtonColors2;
                z6 = z7;
                toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                borderStroke5 = borderStroke4;
            } else {
                if (i19 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 == 0) {
                }
                if ((i3 & 16) != 0) {
                    i13 = i12 & (-57345);
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                } else {
                    i13 = i12;
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    i13 &= -458753;
                    toggleButtonColors2 = ToggleButtonDefaults.INSTANCE.tonalToggleButtonColors(composerStartRestartGroup, 6);
                }
                i14 = i13;
                if ((i3 & 64) != 0) {
                    buttonElevationM3554filledTonalButtonElevationR_JCAzs = ButtonDefaults.INSTANCE.m3554filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    i14 &= -3670017;
                    i15 = i11;
                } else {
                    i15 = i11;
                    buttonElevationM3554filledTonalButtonElevationR_JCAzs = buttonElevation2;
                }
                if (i7 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i16 = i14 & (-234881025);
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    i16 = i14;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                i17 = i16;
                toggleButtonColors4 = toggleButtonColors2;
                z6 = z7;
                toggleButtonShapes4 = toggleButtonShapesM5034shapesFor8Feqmps;
                borderStroke5 = borderStroke4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1466986964, i17, i15, "androidx.compose.material3.TonalToggleButton (ToggleButton.kt:291)");
            }
            ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevationM3554filledTonalButtonElevationR_JCAzs, borderStroke5, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, i17 & 2147483646, i15 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            z5 = z6;
            toggleButtonShapes3 = toggleButtonShapes4;
            toggleButtonColors3 = toggleButtonColors4;
            buttonElevation3 = buttonElevationM3554filledTonalButtonElevationR_JCAzs;
            borderStroke3 = borderStroke5;
            paddingValues2 = paddingValues3;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            toggleButtonShapes3 = toggleButtonShapes2;
            toggleButtonColors3 = toggleButtonColors2;
            buttonElevation3 = buttonElevation2;
            borderStroke3 = borderStroke;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonKt.TonalToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0119  */
    /* JADX WARN: Code duplicated, block: B:102:0x011c  */
    /* JADX WARN: Code duplicated, block: B:107:0x012b  */
    /* JADX WARN: Code duplicated, block: B:109:0x0131  */
    /* JADX WARN: Code duplicated, block: B:110:0x0134  */
    /* JADX WARN: Code duplicated, block: B:112:0x013b  */
    /* JADX WARN: Code duplicated, block: B:115:0x014c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0154  */
    /* JADX WARN: Code duplicated, block: B:122:0x015e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0176  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:142:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:143:0x01af  */
    /* JADX WARN: Code duplicated, block: B:145:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:152:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:153:0x01da  */
    /* JADX WARN: Code duplicated, block: B:156:0x01de  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:161:0x0200  */
    /* JADX WARN: Code duplicated, block: B:163:0x020d  */
    /* JADX WARN: Code duplicated, block: B:166:0x0213  */
    /* JADX WARN: Code duplicated, block: B:167:0x0235  */
    /* JADX WARN: Code duplicated, block: B:170:0x0242  */
    /* JADX WARN: Code duplicated, block: B:171:0x0245  */
    /* JADX WARN: Code duplicated, block: B:174:0x0251  */
    /* JADX WARN: Code duplicated, block: B:177:0x026f  */
    /* JADX WARN: Code duplicated, block: B:179:0x027b  */
    /* JADX WARN: Code duplicated, block: B:182:0x028f  */
    /* JADX WARN: Code duplicated, block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0095  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:93:0x0100  */
    /* JADX WARN: Code duplicated, block: B:96:0x0108  */
    /* JADX WARN: Code duplicated, block: B:97:0x010b  */
    /* JADX WARN: Code duplicated, block: B:99:0x010f  */
    public static final void OutlinedToggleButton(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, ToggleButtonShapes toggleButtonShapes, ToggleButtonColors toggleButtonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        ToggleButtonShapes toggleButtonShapes2;
        ToggleButtonColors toggleButtonColors2;
        int i7;
        ButtonElevation buttonElevation2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z4;
        final PaddingValues paddingValues2;
        final ButtonElevation buttonElevation3;
        final Modifier modifier3;
        final boolean z5;
        final ToggleButtonShapes toggleButtonShapes3;
        final ToggleButtonColors toggleButtonColors3;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i13;
        ToggleButtonShapes toggleButtonShapesM5034shapesFor8Feqmps;
        ToggleButtonColors toggleButtonColorsOutlinedToggleButtonColors;
        BorderStroke borderStrokeOutlinedButtonBorder;
        PaddingValues paddingValuesM3533contentPaddingFor8Feqmps$default;
        int i14;
        int i15;
        boolean z6;
        BorderStroke borderStroke3;
        ToggleButtonShapes toggleButtonShapes4;
        ButtonElevation buttonElevation4;
        ToggleButtonColors toggleButtonColors4;
        PaddingValues paddingValues3;
        MutableInteractionSource mutableInteractionSource3;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1667310484);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedToggleButton)N(checked,onCheckedChange,modifier,enabled,shapes,colors,elevation,border,contentPadding,interactionSource,content)362@19275L366:ToggleButton.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i17 = i3 & 4;
        if (i17 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((i & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        toggleButtonShapes2 = toggleButtonShapes;
                        int i18 = composerStartRestartGroup.changed(toggleButtonShapes2) ? 16384 : 8192;
                        i4 |= i18;
                    } else {
                        toggleButtonShapes2 = toggleButtonShapes;
                    }
                    i4 |= i18;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                if ((196608 & i) == 0) {
                    if ((i3 & 32) == 0) {
                        toggleButtonColors2 = toggleButtonColors;
                        int i19 = composerStartRestartGroup.changed(toggleButtonColors2) ? 131072 : 65536;
                        i4 |= i19;
                    } else {
                        toggleButtonColors2 = toggleButtonColors;
                    }
                    i4 |= i19;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    buttonElevation2 = buttonElevation;
                } else {
                    buttonElevation2 = buttonElevation;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(buttonElevation2)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i4 |= i8;
                    }
                }
                if ((i & 12582912) != 0) {
                    i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 536870912;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i11 = i2 | i16;
                    } else {
                        i11 = i2;
                    }
                    i12 = i4;
                    if ((i4 & 306783379) == 306783378 || (i11 & 3) != 2) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 16) != 0) {
                                toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                                i13 = i12 & (-57345);
                            } else {
                                i13 = i12;
                                toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                            }
                            if ((i3 & 32) != 0) {
                                toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                                i13 &= -458753;
                            } else {
                                toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                            }
                            if (i7 != 0) {
                                buttonElevation2 = null;
                            }
                            if ((i3 & 128) != 0) {
                                if (z) {
                                    composerStartRestartGroup.startReplaceGroup(450604849);
                                    composerStartRestartGroup.endReplaceGroup();
                                    borderStrokeOutlinedButtonBorder = null;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-262560119);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                                    borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                i13 &= -29360129;
                            } else {
                                borderStrokeOutlinedButtonBorder = borderStroke;
                            }
                            if ((i3 & 256) != 0) {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                                i14 = (-234881025) & i13;
                            } else {
                                paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                                i14 = i13;
                            }
                            boolean z7 = z3;
                            i15 = i14;
                            z6 = z7;
                            ToggleButtonShapes toggleButtonShapes5 = toggleButtonShapesM5034shapesFor8Feqmps;
                            borderStroke3 = borderStrokeOutlinedButtonBorder;
                            toggleButtonShapes4 = toggleButtonShapes5;
                            buttonElevation4 = buttonElevation2;
                            toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                                paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            } else {
                                paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            int i20 = (i3 & 16) != 0 ? i12 & (-57345) : i12;
                            if ((i3 & 32) != 0) {
                                i20 &= -458753;
                            }
                            if ((i3 & 128) != 0) {
                                i20 &= -29360129;
                            }
                            if ((i3 & 256) != 0) {
                                i20 &= -234881025;
                            }
                            borderStroke3 = borderStroke;
                            mutableInteractionSource3 = mutableInteractionSource;
                            buttonElevation4 = buttonElevation2;
                            z6 = z3;
                            toggleButtonShapes4 = toggleButtonShapes2;
                            toggleButtonColors4 = toggleButtonColors2;
                            i15 = i20;
                            companion = modifier2;
                            paddingValues3 = paddingValues;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
                        }
                        ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        paddingValues2 = paddingValues3;
                        borderStroke2 = borderStroke3;
                        buttonElevation3 = buttonElevation4;
                        toggleButtonColors3 = toggleButtonColors4;
                        toggleButtonShapes3 = toggleButtonShapes4;
                        z5 = z6;
                        modifier3 = companion;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        paddingValues2 = paddingValues;
                        buttonElevation3 = buttonElevation2;
                        modifier3 = modifier2;
                        z5 = z3;
                        toggleButtonShapes3 = toggleButtonShapes2;
                        toggleButtonColors3 = toggleButtonColors2;
                        borderStroke2 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i11 = i2 | i16;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            i13 = i12 & (-57345);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                            i13 &= -458753;
                        } else {
                            toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                        }
                        if (i7 != 0) {
                            buttonElevation2 = null;
                        }
                        if ((i3 & 128) != 0) {
                            if (z) {
                                composerStartRestartGroup.startReplaceGroup(-262560119);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                                borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(450604849);
                                composerStartRestartGroup.endReplaceGroup();
                                borderStrokeOutlinedButtonBorder = null;
                            }
                            i13 &= -29360129;
                        } else {
                            borderStrokeOutlinedButtonBorder = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i14 = (-234881025) & i13;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i14 = i13;
                        }
                        boolean z8 = z3;
                        i15 = i14;
                        z6 = z8;
                        ToggleButtonShapes toggleButtonShapes6 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke3 = borderStrokeOutlinedButtonBorder;
                        toggleButtonShapes4 = toggleButtonShapes6;
                        buttonElevation4 = buttonElevation2;
                        toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        } else {
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            i13 = i12 & (-57345);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                            i13 &= -458753;
                        } else {
                            toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                        }
                        if (i7 != 0) {
                            buttonElevation2 = null;
                        }
                        if ((i3 & 128) != 0) {
                            if (z) {
                                composerStartRestartGroup.startReplaceGroup(-262560119);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                                borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(450604849);
                                composerStartRestartGroup.endReplaceGroup();
                                borderStrokeOutlinedButtonBorder = null;
                            }
                            i13 &= -29360129;
                        } else {
                            borderStrokeOutlinedButtonBorder = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i14 = (-234881025) & i13;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i14 = i13;
                        }
                        boolean z9 = z3;
                        i15 = i14;
                        z6 = z9;
                        ToggleButtonShapes toggleButtonShapes7 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke3 = borderStrokeOutlinedButtonBorder;
                        toggleButtonShapes4 = toggleButtonShapes7;
                        buttonElevation4 = buttonElevation2;
                        toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        } else {
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = paddingValues3;
                    borderStroke2 = borderStroke3;
                    buttonElevation3 = buttonElevation4;
                    toggleButtonColors3 = toggleButtonColors4;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    z5 = z6;
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    buttonElevation3 = buttonElevation2;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    borderStroke2 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i18;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i18;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColors2 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                    }
                    i4 |= i19;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                i4 |= i19;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
                buttonElevation2 = buttonElevation;
            } else {
                buttonElevation2 = buttonElevation;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(buttonElevation2)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 12582912) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i11 = i2 | i16;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            i13 = i12 & (-57345);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                            i13 &= -458753;
                        } else {
                            toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                        }
                        if (i7 != 0) {
                            buttonElevation2 = null;
                        }
                        if ((i3 & 128) != 0) {
                            if (z) {
                                composerStartRestartGroup.startReplaceGroup(-262560119);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                                borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(450604849);
                                composerStartRestartGroup.endReplaceGroup();
                                borderStrokeOutlinedButtonBorder = null;
                            }
                            i13 &= -29360129;
                        } else {
                            borderStrokeOutlinedButtonBorder = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i14 = (-234881025) & i13;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i14 = i13;
                        }
                        boolean z10 = z3;
                        i15 = i14;
                        z6 = z10;
                        ToggleButtonShapes toggleButtonShapes8 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke3 = borderStrokeOutlinedButtonBorder;
                        toggleButtonShapes4 = toggleButtonShapes8;
                        buttonElevation4 = buttonElevation2;
                        toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        } else {
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            i13 = i12 & (-57345);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                            i13 &= -458753;
                        } else {
                            toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                        }
                        if (i7 != 0) {
                            buttonElevation2 = null;
                        }
                        if ((i3 & 128) != 0) {
                            if (z) {
                                composerStartRestartGroup.startReplaceGroup(-262560119);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                                borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(450604849);
                                composerStartRestartGroup.endReplaceGroup();
                                borderStrokeOutlinedButtonBorder = null;
                            }
                            i13 &= -29360129;
                        } else {
                            borderStrokeOutlinedButtonBorder = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i14 = (-234881025) & i13;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i14 = i13;
                        }
                        boolean z11 = z3;
                        i15 = i14;
                        z6 = z11;
                        ToggleButtonShapes toggleButtonShapes9 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke3 = borderStrokeOutlinedButtonBorder;
                        toggleButtonShapes4 = toggleButtonShapes9;
                        buttonElevation4 = buttonElevation2;
                        toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        } else {
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = paddingValues3;
                    borderStroke2 = borderStroke3;
                    buttonElevation3 = buttonElevation4;
                    toggleButtonColors3 = toggleButtonColors4;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    z5 = z6;
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    buttonElevation3 = buttonElevation2;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    borderStroke2 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i11 = i2 | i16;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        i13 = i12 & (-57345);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                        i13 &= -458753;
                    } else {
                        toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                    }
                    if (i7 != 0) {
                        buttonElevation2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        if (z) {
                            composerStartRestartGroup.startReplaceGroup(-262560119);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                            borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(450604849);
                            composerStartRestartGroup.endReplaceGroup();
                            borderStrokeOutlinedButtonBorder = null;
                        }
                        i13 &= -29360129;
                    } else {
                        borderStrokeOutlinedButtonBorder = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i14 = (-234881025) & i13;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i14 = i13;
                    }
                    boolean z12 = z3;
                    i15 = i14;
                    z6 = z12;
                    ToggleButtonShapes toggleButtonShapes10 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke3 = borderStrokeOutlinedButtonBorder;
                    toggleButtonShapes4 = toggleButtonShapes10;
                    buttonElevation4 = buttonElevation2;
                    toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    } else {
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        i13 = i12 & (-57345);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                        i13 &= -458753;
                    } else {
                        toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                    }
                    if (i7 != 0) {
                        buttonElevation2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        if (z) {
                            composerStartRestartGroup.startReplaceGroup(-262560119);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                            borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(450604849);
                            composerStartRestartGroup.endReplaceGroup();
                            borderStrokeOutlinedButtonBorder = null;
                        }
                        i13 &= -29360129;
                    } else {
                        borderStrokeOutlinedButtonBorder = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i14 = (-234881025) & i13;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i14 = i13;
                    }
                    boolean z13 = z3;
                    i15 = i14;
                    z6 = z13;
                    ToggleButtonShapes toggleButtonShapes11 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke3 = borderStrokeOutlinedButtonBorder;
                    toggleButtonShapes4 = toggleButtonShapes11;
                    buttonElevation4 = buttonElevation2;
                    toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    } else {
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = paddingValues3;
                borderStroke2 = borderStroke3;
                buttonElevation3 = buttonElevation4;
                toggleButtonColors3 = toggleButtonColors4;
                toggleButtonShapes3 = toggleButtonShapes4;
                z5 = z6;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                buttonElevation3 = buttonElevation2;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                borderStroke2 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    toggleButtonShapes2 = toggleButtonShapes;
                    if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                    }
                    i4 |= i18;
                } else {
                    toggleButtonShapes2 = toggleButtonShapes;
                }
                i4 |= i18;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) == 0) {
                    toggleButtonColors2 = toggleButtonColors;
                    if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                    }
                    i4 |= i19;
                } else {
                    toggleButtonColors2 = toggleButtonColors;
                }
                i4 |= i19;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
                buttonElevation2 = buttonElevation;
            } else {
                buttonElevation2 = buttonElevation;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(buttonElevation2)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 12582912) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i11 = i2 | i16;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            i13 = i12 & (-57345);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                            i13 &= -458753;
                        } else {
                            toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                        }
                        if (i7 != 0) {
                            buttonElevation2 = null;
                        }
                        if ((i3 & 128) != 0) {
                            if (z) {
                                composerStartRestartGroup.startReplaceGroup(-262560119);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                                borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(450604849);
                                composerStartRestartGroup.endReplaceGroup();
                                borderStrokeOutlinedButtonBorder = null;
                            }
                            i13 &= -29360129;
                        } else {
                            borderStrokeOutlinedButtonBorder = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i14 = (-234881025) & i13;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i14 = i13;
                        }
                        boolean z14 = z3;
                        i15 = i14;
                        z6 = z14;
                        ToggleButtonShapes toggleButtonShapes12 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke3 = borderStrokeOutlinedButtonBorder;
                        toggleButtonShapes4 = toggleButtonShapes12;
                        buttonElevation4 = buttonElevation2;
                        toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        } else {
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 16) != 0) {
                            toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                            i13 = i12 & (-57345);
                        } else {
                            i13 = i12;
                            toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                        }
                        if ((i3 & 32) != 0) {
                            toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                            i13 &= -458753;
                        } else {
                            toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                        }
                        if (i7 != 0) {
                            buttonElevation2 = null;
                        }
                        if ((i3 & 128) != 0) {
                            if (z) {
                                composerStartRestartGroup.startReplaceGroup(-262560119);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                                borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(450604849);
                                composerStartRestartGroup.endReplaceGroup();
                                borderStrokeOutlinedButtonBorder = null;
                            }
                            i13 &= -29360129;
                        } else {
                            borderStrokeOutlinedButtonBorder = borderStroke;
                        }
                        if ((i3 & 256) != 0) {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                            i14 = (-234881025) & i13;
                        } else {
                            paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                            i14 = i13;
                        }
                        boolean z15 = z3;
                        i15 = i14;
                        z6 = z15;
                        ToggleButtonShapes toggleButtonShapes13 = toggleButtonShapesM5034shapesFor8Feqmps;
                        borderStroke3 = borderStrokeOutlinedButtonBorder;
                        toggleButtonShapes4 = toggleButtonShapes13;
                        buttonElevation4 = buttonElevation2;
                        toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        } else {
                            paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
                    }
                    ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = paddingValues3;
                    borderStroke2 = borderStroke3;
                    buttonElevation3 = buttonElevation4;
                    toggleButtonColors3 = toggleButtonColors4;
                    toggleButtonShapes3 = toggleButtonShapes4;
                    z5 = z6;
                    modifier3 = companion;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    paddingValues2 = paddingValues;
                    buttonElevation3 = buttonElevation2;
                    modifier3 = modifier2;
                    z5 = z3;
                    toggleButtonShapes3 = toggleButtonShapes2;
                    toggleButtonColors3 = toggleButtonColors2;
                    borderStroke2 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i11 = i2 | i16;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        i13 = i12 & (-57345);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                        i13 &= -458753;
                    } else {
                        toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                    }
                    if (i7 != 0) {
                        buttonElevation2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        if (z) {
                            composerStartRestartGroup.startReplaceGroup(-262560119);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                            borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(450604849);
                            composerStartRestartGroup.endReplaceGroup();
                            borderStrokeOutlinedButtonBorder = null;
                        }
                        i13 &= -29360129;
                    } else {
                        borderStrokeOutlinedButtonBorder = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i14 = (-234881025) & i13;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i14 = i13;
                    }
                    boolean z16 = z3;
                    i15 = i14;
                    z6 = z16;
                    ToggleButtonShapes toggleButtonShapes14 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke3 = borderStrokeOutlinedButtonBorder;
                    toggleButtonShapes4 = toggleButtonShapes14;
                    buttonElevation4 = buttonElevation2;
                    toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    } else {
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        i13 = i12 & (-57345);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                        i13 &= -458753;
                    } else {
                        toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                    }
                    if (i7 != 0) {
                        buttonElevation2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        if (z) {
                            composerStartRestartGroup.startReplaceGroup(-262560119);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                            borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(450604849);
                            composerStartRestartGroup.endReplaceGroup();
                            borderStrokeOutlinedButtonBorder = null;
                        }
                        i13 &= -29360129;
                    } else {
                        borderStrokeOutlinedButtonBorder = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i14 = (-234881025) & i13;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i14 = i13;
                    }
                    boolean z17 = z3;
                    i15 = i14;
                    z6 = z17;
                    ToggleButtonShapes toggleButtonShapes15 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke3 = borderStrokeOutlinedButtonBorder;
                    toggleButtonShapes4 = toggleButtonShapes15;
                    buttonElevation4 = buttonElevation2;
                    toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    } else {
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = paddingValues3;
                borderStroke2 = borderStroke3;
                buttonElevation3 = buttonElevation4;
                toggleButtonColors3 = toggleButtonColors4;
                toggleButtonShapes3 = toggleButtonShapes4;
                z5 = z6;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                buttonElevation3 = buttonElevation2;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                borderStroke2 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                toggleButtonShapes2 = toggleButtonShapes;
                if (composerStartRestartGroup.changed(toggleButtonShapes2)) {
                }
                i4 |= i18;
            } else {
                toggleButtonShapes2 = toggleButtonShapes;
            }
            i4 |= i18;
        } else {
            toggleButtonShapes2 = toggleButtonShapes;
        }
        if ((196608 & i) == 0) {
            if ((i3 & 32) == 0) {
                toggleButtonColors2 = toggleButtonColors;
                if (composerStartRestartGroup.changed(toggleButtonColors2)) {
                }
                i4 |= i19;
            } else {
                toggleButtonColors2 = toggleButtonColors;
            }
            i4 |= i19;
        } else {
            toggleButtonColors2 = toggleButtonColors;
        }
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
            buttonElevation2 = buttonElevation;
        } else {
            buttonElevation2 = buttonElevation;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(buttonElevation2)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
        }
        if ((i & 12582912) != 0) {
            i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(paddingValues)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        i9 = i3 & 512;
        if (i9 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i11 = i2 | i16;
            } else {
                i11 = i2;
            }
            i12 = i4;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        i13 = i12 & (-57345);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                        i13 &= -458753;
                    } else {
                        toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                    }
                    if (i7 != 0) {
                        buttonElevation2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        if (z) {
                            composerStartRestartGroup.startReplaceGroup(-262560119);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                            borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(450604849);
                            composerStartRestartGroup.endReplaceGroup();
                            borderStrokeOutlinedButtonBorder = null;
                        }
                        i13 &= -29360129;
                    } else {
                        borderStrokeOutlinedButtonBorder = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i14 = (-234881025) & i13;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i14 = i13;
                    }
                    boolean z18 = z3;
                    i15 = i14;
                    z6 = z18;
                    ToggleButtonShapes toggleButtonShapes16 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke3 = borderStrokeOutlinedButtonBorder;
                    toggleButtonShapes4 = toggleButtonShapes16;
                    buttonElevation4 = buttonElevation2;
                    toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    } else {
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 16) != 0) {
                        toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                        i13 = i12 & (-57345);
                    } else {
                        i13 = i12;
                        toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                    }
                    if ((i3 & 32) != 0) {
                        toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                        i13 &= -458753;
                    } else {
                        toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                    }
                    if (i7 != 0) {
                        buttonElevation2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        if (z) {
                            composerStartRestartGroup.startReplaceGroup(-262560119);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                            borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(450604849);
                            composerStartRestartGroup.endReplaceGroup();
                            borderStrokeOutlinedButtonBorder = null;
                        }
                        i13 &= -29360129;
                    } else {
                        borderStrokeOutlinedButtonBorder = borderStroke;
                    }
                    if ((i3 & 256) != 0) {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                        i14 = (-234881025) & i13;
                    } else {
                        paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                        i14 = i13;
                    }
                    boolean z19 = z3;
                    i15 = i14;
                    z6 = z19;
                    ToggleButtonShapes toggleButtonShapes17 = toggleButtonShapesM5034shapesFor8Feqmps;
                    borderStroke3 = borderStrokeOutlinedButtonBorder;
                    toggleButtonShapes4 = toggleButtonShapes17;
                    buttonElevation4 = buttonElevation2;
                    toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    } else {
                        paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
                }
                ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = paddingValues3;
                borderStroke2 = borderStroke3;
                buttonElevation3 = buttonElevation4;
                toggleButtonColors3 = toggleButtonColors4;
                toggleButtonShapes3 = toggleButtonShapes4;
                z5 = z6;
                modifier3 = companion;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paddingValues2 = paddingValues;
                buttonElevation3 = buttonElevation2;
                modifier3 = modifier2;
                z5 = z3;
                toggleButtonShapes3 = toggleButtonShapes2;
                toggleButtonColors3 = toggleButtonColors2;
                borderStroke2 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i16 = 4;
            } else {
                i16 = 2;
            }
            i11 = i2 | i16;
        } else {
            i11 = i2;
        }
        i12 = i4;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "354@18809L35,355@18900L28");
            if ((i & 1) != 0) {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 16) != 0) {
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    i13 = i12 & (-57345);
                } else {
                    i13 = i12;
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                    i13 &= -458753;
                } else {
                    toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                }
                if (i7 != 0) {
                    buttonElevation2 = null;
                }
                if ((i3 & 128) != 0) {
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(-262560119);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                        borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(450604849);
                        composerStartRestartGroup.endReplaceGroup();
                        borderStrokeOutlinedButtonBorder = null;
                    }
                    i13 &= -29360129;
                } else {
                    borderStrokeOutlinedButtonBorder = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i14 = (-234881025) & i13;
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    i14 = i13;
                }
                boolean z110 = z3;
                i15 = i14;
                z6 = z110;
                ToggleButtonShapes toggleButtonShapes18 = toggleButtonShapesM5034shapesFor8Feqmps;
                borderStroke3 = borderStrokeOutlinedButtonBorder;
                toggleButtonShapes4 = toggleButtonShapes18;
                buttonElevation4 = buttonElevation2;
                toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                } else {
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if ((i3 & 16) != 0) {
                    toggleButtonShapesM5034shapesFor8Feqmps = ToggleButtonDefaults.INSTANCE.m5034shapesFor8Feqmps(ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), composerStartRestartGroup, 54);
                    i13 = i12 & (-57345);
                } else {
                    i13 = i12;
                    toggleButtonShapesM5034shapesFor8Feqmps = toggleButtonShapes2;
                }
                if ((i3 & 32) != 0) {
                    toggleButtonColorsOutlinedToggleButtonColors = ToggleButtonDefaults.INSTANCE.outlinedToggleButtonColors(composerStartRestartGroup, 6);
                    i13 &= -458753;
                } else {
                    toggleButtonColorsOutlinedToggleButtonColors = toggleButtonColors2;
                }
                if (i7 != 0) {
                    buttonElevation2 = null;
                }
                if ((i3 & 128) != 0) {
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(-262560119);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "357@19027L29");
                        borderStrokeOutlinedButtonBorder = ButtonDefaults.INSTANCE.outlinedButtonBorder(z3, composerStartRestartGroup, ((i13 >> 9) & 14) | 48, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(450604849);
                        composerStartRestartGroup.endReplaceGroup();
                        borderStrokeOutlinedButtonBorder = null;
                    }
                    i13 &= -29360129;
                } else {
                    borderStrokeOutlinedButtonBorder = borderStroke;
                }
                if ((i3 & 256) != 0) {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = ButtonDefaults.m3533contentPaddingFor8Feqmps$default(ButtonDefaults.INSTANCE, ButtonDefaults.INSTANCE.m3569getMinHeightD9Ej5fM(), false, false, 6, null);
                    i14 = (-234881025) & i13;
                } else {
                    paddingValuesM3533contentPaddingFor8Feqmps$default = paddingValues;
                    i14 = i13;
                }
                boolean z111 = z3;
                i15 = i14;
                z6 = z111;
                ToggleButtonShapes toggleButtonShapes19 = toggleButtonShapesM5034shapesFor8Feqmps;
                borderStroke3 = borderStrokeOutlinedButtonBorder;
                toggleButtonShapes4 = toggleButtonShapes19;
                buttonElevation4 = buttonElevation2;
                toggleButtonColors4 = toggleButtonColorsOutlinedToggleButtonColors;
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                } else {
                    paddingValues3 = paddingValuesM3533contentPaddingFor8Feqmps$default;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1667310484, i15, i11, "androidx.compose.material3.OutlinedToggleButton (ToggleButton.kt:362)");
            }
            ToggleButton(z, function1, companion, z6, toggleButtonShapes4, toggleButtonColors4, buttonElevation4, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composerStartRestartGroup, 2147483646 & i15, i11 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource3;
            paddingValues2 = paddingValues3;
            borderStroke2 = borderStroke3;
            buttonElevation3 = buttonElevation4;
            toggleButtonColors3 = toggleButtonColors4;
            toggleButtonShapes3 = toggleButtonShapes4;
            z5 = z6;
            modifier3 = companion;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            paddingValues2 = paddingValues;
            buttonElevation3 = buttonElevation2;
            modifier3 = modifier2;
            z5 = z3;
            toggleButtonShapes3 = toggleButtonShapes2;
            toggleButtonColors3 = toggleButtonColors2;
            borderStroke2 = borderStroke;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ToggleButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonKt.OutlinedToggleButton$lambda$0(z, function1, modifier3, z5, toggleButtonShapes3, toggleButtonColors3, buttonElevation3, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final boolean getHasRoundedCornerShapes(ToggleButtonShapes toggleButtonShapes) {
        return (toggleButtonShapes.getShape() instanceof RoundedCornerShape) && (toggleButtonShapes.getPressedShape() instanceof RoundedCornerShape) && (toggleButtonShapes.getCheckedShape() instanceof RoundedCornerShape);
    }

    public static final boolean getHasCornerBasedShapes(ToggleButtonShapes toggleButtonShapes) {
        return (toggleButtonShapes.getShape() instanceof CornerBasedShape) && (toggleButtonShapes.getPressedShape() instanceof CornerBasedShape) && (toggleButtonShapes.getCheckedShape() instanceof CornerBasedShape);
    }

    private static final Shape shapeByInteraction(ToggleButtonShapes toggleButtonShapes, boolean z, boolean z2, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        Shape shape;
        composer.startReplaceGroup(-585100128);
        ComposerKt.sourceInformation(composer, "C(shapeByInteraction)N(shapes,pressed,checked,animationSpec):ToggleButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-585100128, i, -1, "androidx.compose.material3.shapeByInteraction (ToggleButton.kt:955)");
        }
        if (z) {
            shape = toggleButtonShapes.getPressedShape();
        } else if (z2) {
            shape = toggleButtonShapes.getCheckedShape();
        } else {
            shape = toggleButtonShapes.getShape();
        }
        if (getHasRoundedCornerShapes(toggleButtonShapes)) {
            composer.startReplaceGroup(-1740235478);
            ComposerKt.sourceInformation(composer, "");
            composer.startMovableGroup(359505585, toggleButtonShapes);
            ComposerKt.sourceInformation(composer, "966@46124L65");
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.RoundedCornerShape");
            Shape shapeRememberAnimatedShape = AnimatedShapeKt.rememberAnimatedShape((RoundedCornerShape) shape, finiteAnimationSpec, composer, (i >> 6) & 112);
            composer.endMovableGroup();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return shapeRememberAnimatedShape;
        }
        if (getHasCornerBasedShapes(toggleButtonShapes)) {
            composer.startReplaceGroup(-1740097652);
            ComposerKt.sourceInformation(composer, "");
            composer.startMovableGroup(359510031, toggleButtonShapes);
            ComposerKt.sourceInformation(composer, "968@46263L63");
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            Shape shapeRememberAnimatedShape2 = AnimatedShapeKt.rememberAnimatedShape((CornerBasedShape) shape, finiteAnimationSpec, composer, (i >> 6) & 112);
            composer.endMovableGroup();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return shapeRememberAnimatedShape2;
        }
        composer.startReplaceGroup(-1740015006);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return shape;
    }

    private static final boolean ToggleButton$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
