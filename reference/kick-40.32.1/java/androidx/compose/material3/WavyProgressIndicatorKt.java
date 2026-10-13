package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.CircularWavyProgressModifiersKt;
import androidx.compose.material3.internal.LinearWavyProgressModifiersKt;
import androidx.compose.material3.tokens.MotionTokens;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: WavyProgressIndicator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2#\b\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001ai\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0092\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2#\b\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00040\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001ai\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0003\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u0019\"\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!\"\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!¨\u0006$"}, d2 = {"LinearWavyProgressIndicator", "", "progress", "Lkotlin/Function0;", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "trackColor", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trackStroke", "gapSize", "Landroidx/compose/ui/unit/Dp;", "stopSize", "amplitude", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "wavelength", "waveSpeed", "LinearWavyProgressIndicator-1YwxWKA", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFLkotlin/jvm/functions/Function1;FFLandroidx/compose/runtime/Composer;III)V", "LinearWavyProgressIndicator-hvuEXSk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FFFFLandroidx/compose/runtime/Composer;II)V", "CircularWavyProgressIndicator", "CircularWavyProgressIndicator-L8eD4gc", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/drawscope/Stroke;Landroidx/compose/ui/graphics/drawscope/Stroke;FLkotlin/jvm/functions/Function1;FFLandroidx/compose/runtime/Composer;II)V", "CircularWavyProgressIndicator-hvuEXSk", "IncreasingAmplitudeAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getIncreasingAmplitudeAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "DecreasingAmplitudeAnimationSpec", "getDecreasingAmplitudeAnimationSpec", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class WavyProgressIndicatorKt {
    private static final AnimationSpec<Float> IncreasingAmplitudeAnimationSpec = AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingStandardCubicBezier(), 2, null);
    private static final AnimationSpec<Float> DecreasingAmplitudeAnimationSpec = AnimationSpecKt.tween$default(500, 0, MotionTokens.INSTANCE.getEasingEmphasizedAccelerateCubicBezier(), 2, null);

    static final Unit CircularWavyProgressIndicator_L8eD4gc$lambda$1(Function0 function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, Function1 function1, float f2, float f3, int i, int i2, Composer composer, int i3) {
        m5230CircularWavyProgressIndicatorL8eD4gc(function0, modifier, j, j2, stroke, stroke2, f, function1, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit CircularWavyProgressIndicator_hvuEXSk$lambda$1(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, int i, int i2, Composer composer, int i3) {
        m5231CircularWavyProgressIndicatorhvuEXSk(modifier, j, j2, stroke, stroke2, f, f2, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit LinearWavyProgressIndicator_1YwxWKA$lambda$1(Function0 function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, Function1 function1, float f3, float f4, int i, int i2, int i3, Composer composer, int i4) {
        m5232LinearWavyProgressIndicator1YwxWKA(function0, modifier, j, j2, stroke, stroke2, f, f2, function1, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    static final Unit LinearWavyProgressIndicator_hvuEXSk$lambda$4(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, int i, int i2, Composer composer, int i3) {
        m5233LinearWavyProgressIndicatorhvuEXSk(modifier, j, j2, stroke, stroke2, f, f2, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x011a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0130  */
    /* JADX WARN: Code duplicated, block: B:113:0x0136  */
    /* JADX WARN: Code duplicated, block: B:121:0x014c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0163  */
    /* JADX WARN: Code duplicated, block: B:131:0x016c  */
    /* JADX WARN: Code duplicated, block: B:164:0x01d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x01da  */
    /* JADX WARN: Code duplicated, block: B:166:0x01df  */
    /* JADX WARN: Code duplicated, block: B:169:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:170:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:173:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:176:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:177:0x0207  */
    /* JADX WARN: Code duplicated, block: B:180:0x020d  */
    /* JADX WARN: Code duplicated, block: B:181:0x0216  */
    /* JADX WARN: Code duplicated, block: B:184:0x021c  */
    /* JADX WARN: Code duplicated, block: B:187:0x022a  */
    /* JADX WARN: Code duplicated, block: B:188:0x0233  */
    /* JADX WARN: Code duplicated, block: B:191:0x0239  */
    /* JADX WARN: Code duplicated, block: B:192:0x0242  */
    /* JADX WARN: Code duplicated, block: B:195:0x0247  */
    /* JADX WARN: Code duplicated, block: B:196:0x0253  */
    /* JADX WARN: Code duplicated, block: B:199:0x025b  */
    /* JADX WARN: Code duplicated, block: B:200:0x0266  */
    /* JADX WARN: Code duplicated, block: B:204:0x027b  */
    /* JADX WARN: Code duplicated, block: B:205:0x0286  */
    /* JADX WARN: Code duplicated, block: B:208:0x029d  */
    /* JADX WARN: Code duplicated, block: B:209:0x029f  */
    /* JADX WARN: Code duplicated, block: B:214:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:217:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:219:0x030f  */
    /* JADX WARN: Code duplicated, block: B:222:0x0328  */
    /* JADX WARN: Code duplicated, block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:53:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:93:0x0100  */
    /* JADX WARN: Code duplicated, block: B:95:0x0108  */
    /* JADX WARN: Code duplicated, block: B:96:0x010b  */
    /* JADX WARN: Code duplicated, block: B:99:0x0112  */
    /* JADX INFO: renamed from: LinearWavyProgressIndicator-1YwxWKA, reason: not valid java name */
    public static final void m5232LinearWavyProgressIndicator1YwxWKA(final Function0<Float> function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, Function1<? super Float, Float> function1, float f3, float f4, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        int i5;
        long trackColor;
        float fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
        Function1<? super Float, Float> function2;
        int i6;
        boolean z;
        final float f5;
        final long j4;
        final Modifier modifier3;
        final long j5;
        final Stroke stroke3;
        final float f6;
        final float f7;
        final Function1<? super Float, Float> function3;
        final Stroke stroke4;
        final float f8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long indicatorColor;
        Stroke linearIndicatorStroke;
        Stroke linearTrackStroke;
        float fM5226getLinearTrackStopIndicatorSizeD9Ej5fM;
        Function1<? super Float, Float> indicatorAmplitude;
        float fM5223getLinearDeterminateWavelengthD9Ej5fM;
        int i7;
        float f9;
        boolean z2;
        Object objRememberedValue;
        int i8;
        int i9;
        boolean zChangedInstance;
        int i10;
        boolean zChangedInstance2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2019304030);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearWavyProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,stopSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)113@6037L317,109@5882L1193:WavyProgressIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i11 = i3 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    int i12 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i4 |= i12;
                } else {
                    j3 = j;
                }
                i4 |= i12;
            } else {
                j3 = j;
            }
            if ((i & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    i5 = i11;
                    trackColor = j2;
                    int i13 = composerStartRestartGroup.changed(trackColor) ? 2048 : 1024;
                    i4 |= i13;
                } else {
                    i5 = i11;
                    trackColor = j2;
                }
                i4 |= i13;
            } else {
                i5 = i11;
                trackColor = j2;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) != 0) {
                    i10 = 8192;
                } else {
                    if ((32768 & i) == 0) {
                        zChangedInstance2 = composerStartRestartGroup.changed(stroke);
                    } else {
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(stroke);
                    }
                    if (zChangedInstance2) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                }
                i4 |= i10;
            }
            if ((196608 & i) == 0) {
                if ((i3 & 32) != 0) {
                    i9 = 65536;
                } else {
                    if ((262144 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(stroke2);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(stroke2);
                    }
                    if (zChangedInstance) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                }
                i4 |= i9;
            }
            if ((1572864 & i) == 0) {
                if ((i3 & 64) == 0) {
                    fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                    int i14 = composerStartRestartGroup.changed(fM5225getLinearIndicatorTrackGapSizeD9Ej5fM) ? 1048576 : 524288;
                    i4 |= i14;
                } else {
                    fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                }
                i4 |= i14;
            } else {
                fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
            }
            if ((i & 12582912) != 0) {
                i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(f2)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i8 = 67108864;
                    }
                    i4 |= i8;
                } else {
                    function2 = function1;
                }
                i8 = GroupFlagsKt.HasAuxSlotFlag;
                i4 |= i8;
            } else {
                function2 = function1;
            }
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : 536870912;
            }
            if ((i2 & 6) == 0) {
                i6 = i2 | (((i3 & 1024) == 0 || !composerStartRestartGroup.changed(f4)) ? 2 : 4);
            } else {
                i6 = i2;
            }
            if ((i4 & 306783379) == 306783378 || (i6 & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@5245L14,100@5315L10,101@5378L21,102@5457L17");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 4) != 0) {
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i4 &= -897;
                    } else {
                        indicatorColor = j3;
                    }
                    if ((i3 & 8) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                        i4 &= -57345;
                    } else {
                        linearIndicatorStroke = stroke;
                    }
                    if ((i3 & 32) != 0) {
                        linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                        i4 &= -458753;
                    } else {
                        linearTrackStroke = stroke2;
                    }
                    if ((i3 & 64) != 0) {
                        fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5225getLinearIndicatorTrackGapSizeD9Ej5fM();
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5226getLinearTrackStopIndicatorSizeD9Ej5fM();
                        i4 &= -29360129;
                    } else {
                        fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = f2;
                    }
                    if ((i3 & 256) != 0) {
                        indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                        i4 &= -234881025;
                    } else {
                        indicatorAmplitude = function2;
                    }
                    if ((i3 & 512) != 0) {
                        fM5223getLinearDeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5223getLinearDeterminateWavelengthD9Ej5fM();
                        i4 &= -1879048193;
                    } else {
                        fM5223getLinearDeterminateWavelengthD9Ej5fM = f3;
                    }
                    Modifier modifier4 = companion;
                    if ((i3 & 1024) != 0) {
                        f9 = fM5223getLinearDeterminateWavelengthD9Ej5fM;
                        i7 = i6 & (-15);
                    } else {
                        i7 = i6;
                        f9 = f4;
                    }
                    j3 = indicatorColor;
                    modifier2 = modifier4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                    }
                    if ((i3 & 1024) != 0) {
                        i6 &= -15;
                    }
                    linearIndicatorStroke = stroke;
                    linearTrackStroke = stroke2;
                    i4 = i4;
                    indicatorAmplitude = function2;
                    i7 = i6;
                    fM5223getLinearDeterminateWavelengthD9Ej5fM = f3;
                    f9 = f4;
                    fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = f2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2019304030, i4, i7, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:108)");
                }
                Modifier modifierThen = modifier2.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -774014693, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                float f10 = f9;
                Modifier modifierM5386linearWavyProgressIndicatorbMBChCs = LinearWavyProgressModifiersKt.m5386linearWavyProgressIndicatorbMBChCs(ClipKt.clipToBounds(SizeKt.m2419sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen, true, (Function1) objRememberedValue), WavyProgressIndicatorDefaults.INSTANCE.m5222getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m5221getLinearContainerHeightD9Ej5fM())), function0, indicatorAmplitude, j3, trackColor, linearIndicatorStroke, linearTrackStroke, fM5225getLinearIndicatorTrackGapSizeD9Ej5fM, fM5226getLinearTrackStopIndicatorSizeD9Ej5fM, fM5223getLinearDeterminateWavelengthD9Ej5fM, f10);
                Function1<? super Float, Float> function4 = indicatorAmplitude;
                Stroke stroke5 = linearIndicatorStroke;
                float f11 = fM5226getLinearTrackStopIndicatorSizeD9Ej5fM;
                SpacerKt.Spacer(modifierM5386linearWavyProgressIndicatorbMBChCs, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                Modifier modifier5 = modifier2;
                f6 = f11;
                modifier3 = modifier5;
                j4 = trackColor;
                stroke3 = linearTrackStroke;
                f5 = f10;
                float f12 = fM5223getLinearDeterminateWavelengthD9Ej5fM;
                stroke4 = stroke5;
                long j6 = j3;
                function3 = function4;
                f7 = f12;
                j5 = j6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                f5 = f4;
                j4 = trackColor;
                modifier3 = modifier2;
                j5 = j3;
                stroke3 = stroke2;
                f6 = f2;
                f7 = f3;
                function3 = function2;
                stroke4 = stroke;
            }
            f8 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$1(function0, modifier3, j5, j4, stroke4, stroke3, f8, f6, function3, f7, f5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i3 & 4) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i12;
            } else {
                j3 = j;
            }
            i4 |= i12;
        } else {
            j3 = j;
        }
        if ((i & 3072) == 0) {
            if ((i3 & 8) == 0) {
                i5 = i11;
                trackColor = j2;
                if (composerStartRestartGroup.changed(trackColor)) {
                }
                i4 |= i13;
            } else {
                i5 = i11;
                trackColor = j2;
            }
            i4 |= i13;
        } else {
            i5 = i11;
            trackColor = j2;
        }
        if ((i & 24576) == 0) {
            if ((i3 & 16) != 0) {
                i10 = 8192;
            } else {
                if ((32768 & i) == 0) {
                    zChangedInstance2 = composerStartRestartGroup.changed(stroke);
                } else {
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(stroke);
                }
                if (zChangedInstance2) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
            }
            i4 |= i10;
        }
        if ((196608 & i) == 0) {
            if ((i3 & 32) != 0) {
                i9 = 65536;
            } else {
                if ((262144 & i) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(stroke2);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(stroke2);
                }
                if (zChangedInstance) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
            }
            i4 |= i9;
        }
        if ((1572864 & i) == 0) {
            if ((i3 & 64) == 0) {
                fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM5225getLinearIndicatorTrackGapSizeD9Ej5fM)) {
                }
                i4 |= i14;
            } else {
                fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
            }
            i4 |= i14;
        } else {
            fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
        }
        if ((i & 12582912) != 0) {
            i4 |= ((i3 & 128) == 0 || !composerStartRestartGroup.changed(f2)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) == 0) {
            if ((i3 & 256) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i8 = 67108864;
                }
                i4 |= i8;
            } else {
                function2 = function1;
            }
            i8 = GroupFlagsKt.HasAuxSlotFlag;
            i4 |= i8;
        } else {
            function2 = function1;
        }
        if ((i & 805306368) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : 536870912;
        }
        if ((i2 & 6) == 0) {
            i6 = i2 | (((i3 & 1024) == 0 || !composerStartRestartGroup.changed(f4)) ? 2 : 4);
        } else {
            i6 = i2;
        }
        if ((i4 & 306783379) == 306783378) {
            z = true;
        } else {
            z = true;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "99@5245L14,100@5315L10,101@5378L21,102@5457L17");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i4 &= -897;
                } else {
                    indicatorColor = j3;
                }
                if ((i3 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i4 &= -57345;
                } else {
                    linearIndicatorStroke = stroke;
                }
                if ((i3 & 32) != 0) {
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                    i4 &= -458753;
                } else {
                    linearTrackStroke = stroke2;
                }
                if ((i3 & 64) != 0) {
                    fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5225getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i4 &= -3670017;
                }
                if ((i3 & 128) != 0) {
                    fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5226getLinearTrackStopIndicatorSizeD9Ej5fM();
                    i4 &= -29360129;
                } else {
                    fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = f2;
                }
                if ((i3 & 256) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i4 &= -234881025;
                } else {
                    indicatorAmplitude = function2;
                }
                if ((i3 & 512) != 0) {
                    fM5223getLinearDeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5223getLinearDeterminateWavelengthD9Ej5fM();
                    i4 &= -1879048193;
                } else {
                    fM5223getLinearDeterminateWavelengthD9Ej5fM = f3;
                }
                Modifier modifier6 = companion;
                if ((i3 & 1024) != 0) {
                    f9 = fM5223getLinearDeterminateWavelengthD9Ej5fM;
                    i7 = i6 & (-15);
                } else {
                    i7 = i6;
                    f9 = f4;
                }
                j3 = indicatorColor;
                modifier2 = modifier6;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i4 &= -897;
                } else {
                    indicatorColor = j3;
                }
                if ((i3 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i4 &= -57345;
                } else {
                    linearIndicatorStroke = stroke;
                }
                if ((i3 & 32) != 0) {
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                    i4 &= -458753;
                } else {
                    linearTrackStroke = stroke2;
                }
                if ((i3 & 64) != 0) {
                    fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5225getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i4 &= -3670017;
                }
                if ((i3 & 128) != 0) {
                    fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5226getLinearTrackStopIndicatorSizeD9Ej5fM();
                    i4 &= -29360129;
                } else {
                    fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = f2;
                }
                if ((i3 & 256) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i4 &= -234881025;
                } else {
                    indicatorAmplitude = function2;
                }
                if ((i3 & 512) != 0) {
                    fM5223getLinearDeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5223getLinearDeterminateWavelengthD9Ej5fM();
                    i4 &= -1879048193;
                } else {
                    fM5223getLinearDeterminateWavelengthD9Ej5fM = f3;
                }
                Modifier modifier7 = companion;
                if ((i3 & 1024) != 0) {
                    f9 = fM5223getLinearDeterminateWavelengthD9Ej5fM;
                    i7 = i6 & (-15);
                } else {
                    i7 = i6;
                    f9 = f4;
                }
                j3 = indicatorColor;
                modifier2 = modifier7;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2019304030, i4, i7, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:108)");
            }
            Modifier modifierThen2 = modifier2.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -774014693, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            if ((i4 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(function0, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(function0, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f13 = f9;
            Modifier modifierM5386linearWavyProgressIndicatorbMBChCs2 = LinearWavyProgressModifiersKt.m5386linearWavyProgressIndicatorbMBChCs(ClipKt.clipToBounds(SizeKt.m2419sizeVpY3zN4(SemanticsModifierKt.semantics(modifierThen2, true, (Function1) objRememberedValue), WavyProgressIndicatorDefaults.INSTANCE.m5222getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m5221getLinearContainerHeightD9Ej5fM())), function0, indicatorAmplitude, j3, trackColor, linearIndicatorStroke, linearTrackStroke, fM5225getLinearIndicatorTrackGapSizeD9Ej5fM, fM5226getLinearTrackStopIndicatorSizeD9Ej5fM, fM5223getLinearDeterminateWavelengthD9Ej5fM, f13);
            Function1<? super Float, Float> function5 = indicatorAmplitude;
            Stroke stroke6 = linearIndicatorStroke;
            float f14 = fM5226getLinearTrackStopIndicatorSizeD9Ej5fM;
            SpacerKt.Spacer(modifierM5386linearWavyProgressIndicatorbMBChCs2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            Modifier modifier8 = modifier2;
            f6 = f14;
            modifier3 = modifier8;
            j4 = trackColor;
            stroke3 = linearTrackStroke;
            f5 = f13;
            float f15 = fM5223getLinearDeterminateWavelengthD9Ej5fM;
            stroke4 = stroke6;
            long j7 = j3;
            function3 = function5;
            f7 = f15;
            j5 = j7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            f5 = f4;
            j4 = trackColor;
            modifier3 = modifier2;
            j5 = j3;
            stroke3 = stroke2;
            f6 = f2;
            f7 = f3;
            function3 = function2;
            stroke4 = stroke;
        }
        f8 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.LinearWavyProgressIndicator_1YwxWKA$lambda$1(function0, modifier3, j5, j4, stroke4, stroke3, f8, f6, function3, f7, f5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LinearWavyProgressIndicator_1YwxWKA$lambda$0$0(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Object objInvoke = function0.invoke();
        if (Float.isNaN(((Number) objInvoke).floatValue())) {
            objInvoke = null;
        }
        Float f = (Float) objInvoke;
        float fFloatValue = f != null ? f.floatValue() : 0.0f;
        if (fFloatValue < 0.0f) {
            fFloatValue = 0.0f;
        }
        if (fFloatValue > 1.0f) {
            fFloatValue = 1.0f;
        }
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(fFloatValue, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0119  */
    /* JADX WARN: Code duplicated, block: B:105:0x0126  */
    /* JADX WARN: Code duplicated, block: B:106:0x0128  */
    /* JADX WARN: Code duplicated, block: B:109:0x0131  */
    /* JADX WARN: Code duplicated, block: B:136:0x018d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x018f  */
    /* JADX WARN: Code duplicated, block: B:140:0x0198  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:147:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:150:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:159:0x01de  */
    /* JADX WARN: Code duplicated, block: B:160:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:163:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:164:0x0200  */
    /* JADX WARN: Code duplicated, block: B:167:0x0217  */
    /* JADX WARN: Code duplicated, block: B:172:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:177:0x0326  */
    /* JADX WARN: Code duplicated, block: B:182:0x034d  */
    /* JADX WARN: Code duplicated, block: B:187:0x0374  */
    /* JADX WARN: Code duplicated, block: B:191:0x0389  */
    /* JADX WARN: Code duplicated, block: B:194:0x038e  */
    /* JADX WARN: Code duplicated, block: B:195:0x0391  */
    /* JADX WARN: Code duplicated, block: B:198:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:200:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:203:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0084  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:94:0x0103  */
    /* JADX INFO: renamed from: LinearWavyProgressIndicator-hvuEXSk, reason: not valid java name */
    public static final void m5233LinearWavyProgressIndicatorhvuEXSk(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long indicatorColor;
        long trackColor;
        float fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
        float f5;
        boolean z;
        final Modifier modifier3;
        Composer composer2;
        final long j3;
        final long j4;
        final float f6;
        final Stroke stroke3;
        final Stroke stroke4;
        final float f7;
        final float f8;
        final float f9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Stroke linearIndicatorStroke;
        Stroke linearTrackStroke;
        float fM5224getLinearIndeterminateWavelengthD9Ej5fM;
        float f10;
        Stroke stroke5;
        Stroke stroke6;
        long j5;
        long j6;
        float f11;
        float f12;
        final State<Float> stateAnimateFloat;
        final State<Float> stateAnimateFloat2;
        final State<Float> stateAnimateFloat3;
        final State<Float> stateAnimateFloat4;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        float f13;
        float f14;
        int i4;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2070567281);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearWavyProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)178@9454L65,180@9571L219,187@9842L219,194@10114L221,201@10388L221,219@11063L23,220@11132L23,221@11202L24,222@11273L24,208@10615L1062:WavyProgressIndicator.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                indicatorColor = j;
                int i7 = composerStartRestartGroup.changed(indicatorColor) ? 32 : 16;
                i3 |= i7;
            } else {
                indicatorColor = j;
            }
            i3 |= i7;
        } else {
            indicatorColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                trackColor = j2;
                int i8 = composerStartRestartGroup.changed(trackColor) ? 256 : 128;
                i3 |= i8;
            } else {
                trackColor = j2;
            }
            i3 |= i8;
        } else {
            trackColor = j2;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i5 = 1024;
            } else {
                if ((i & 4096) == 0 ? composerStartRestartGroup.changed(stroke) : composerStartRestartGroup.changedInstance(stroke)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
            }
            i3 |= i5;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) != 0) {
                i4 = 8192;
            } else {
                if ((32768 & i) == 0 ? composerStartRestartGroup.changed(stroke2) : composerStartRestartGroup.changedInstance(stroke2)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
            }
            i3 |= i4;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
                int i9 = composerStartRestartGroup.changed(fM5225getLinearIndicatorTrackGapSizeD9Ej5fM) ? 131072 : 65536;
                i3 |= i9;
            } else {
                fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
            }
            i3 |= i9;
        } else {
            fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = f;
        }
        int i10 = i2 & 64;
        if (i10 == 0) {
            if ((1572864 & i) == 0) {
                f5 = f2;
                i3 |= composerStartRestartGroup.changed(f5) ? 1048576 : 524288;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "169@8902L14,170@8972L10,171@9035L21,172@9114L17");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 2) != 0) {
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    } else {
                        linearIndicatorStroke = stroke;
                    }
                    if ((i2 & 16) != 0) {
                        linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                        i3 &= -57345;
                    } else {
                        linearTrackStroke = stroke2;
                    }
                    if ((i2 & 32) != 0) {
                        fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5225getLinearIndicatorTrackGapSizeD9Ej5fM();
                        i3 &= -458753;
                    }
                    if (i10 != 0) {
                        f5 = 1.0f;
                    }
                    if ((i2 & 128) != 0) {
                        fM5224getLinearIndeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5224getLinearIndeterminateWavelengthD9Ej5fM();
                        i3 = (-29360129) & i3;
                    } else {
                        fM5224getLinearIndeterminateWavelengthD9Ej5fM = f3;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                        stroke5 = linearIndicatorStroke;
                        stroke6 = linearTrackStroke;
                        j5 = indicatorColor;
                        j6 = trackColor;
                        f11 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                        f12 = fM5224getLinearIndeterminateWavelengthD9Ej5fM;
                        f10 = f12;
                    } else {
                        f10 = f4;
                        stroke5 = linearIndicatorStroke;
                        stroke6 = linearTrackStroke;
                        j5 = indicatorColor;
                        j6 = trackColor;
                        f11 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                        f12 = fM5224getLinearIndeterminateWavelengthD9Ej5fM;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    stroke5 = stroke;
                    stroke6 = stroke2;
                    f12 = f3;
                    f10 = f4;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    f11 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2070567281, i3, -1, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:177)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("LinearWavyProgressIndicatorProgress", composerStartRestartGroup, 6, 0);
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineHeadAnimationSpec(), "LinearWavyProgressIndicatorFirstHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineTailAnimationSpec(), "LinearWavyProgressIndicatorFirstTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineHeadAnimationSpec(), "LinearWavyProgressIndicatorSecondHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineTailAnimationSpec(), "LinearWavyProgressIndicatorSecondTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
                Modifier modifierClipToBounds = ClipKt.clipToBounds(SizeKt.m2419sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier2.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), WavyProgressIndicatorDefaults.INSTANCE.m5222getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m5221getLinearContainerHeightD9Ej5fM()));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245226074, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(stateAnimateFloat);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(stateAnimateFloat));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245223866, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(stateAnimateFloat2);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(stateAnimateFloat2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245221625, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloat3);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(stateAnimateFloat3));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function2 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245219353, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloat4);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(stateAnimateFloat4));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function0 function3 = (Function0) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                f13 = f5 >= 0.0f ? f5 : 0.0f;
                if (f13 > 1.0f) {
                    f14 = 1.0f;
                } else {
                    f14 = f13;
                }
                SpacerKt.Spacer(LinearWavyProgressModifiersKt.m5385linearWavyProgressIndicatorOFGGHrU(modifierClipToBounds, function0, function1, function2, function3, j5, j6, stroke5, stroke6, f11, f14, f12, f10), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                j3 = j5;
                j4 = j6;
                stroke3 = stroke5;
                stroke4 = stroke6;
                f6 = f11;
                f7 = f12;
                f8 = f10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                j3 = indicatorColor;
                j4 = trackColor;
                f6 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                stroke3 = stroke;
                stroke4 = stroke2;
                f7 = f3;
                f8 = f4;
            }
            f9 = f5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$4(modifier3, j3, j4, stroke3, stroke4, f6, f9, f7, f8, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        f5 = f2;
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "169@8902L14,170@8972L10,171@9035L21,172@9114L17");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i3 &= -7169;
                } else {
                    linearIndicatorStroke = stroke;
                }
                if ((i2 & 16) != 0) {
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                    i3 &= -57345;
                } else {
                    linearTrackStroke = stroke2;
                }
                if ((i2 & 32) != 0) {
                    fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5225getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                }
                if (i10 != 0) {
                    f5 = 1.0f;
                }
                if ((i2 & 128) != 0) {
                    fM5224getLinearIndeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5224getLinearIndeterminateWavelengthD9Ej5fM();
                    i3 = (-29360129) & i3;
                } else {
                    fM5224getLinearIndeterminateWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    f11 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM5224getLinearIndeterminateWavelengthD9Ej5fM;
                    f10 = f12;
                } else {
                    f10 = f4;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    f11 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM5224getLinearIndeterminateWavelengthD9Ej5fM;
                }
            } else {
                if (i6 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    linearIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearIndicatorStroke(composerStartRestartGroup, 0);
                    i3 &= -7169;
                } else {
                    linearIndicatorStroke = stroke;
                }
                if ((i2 & 16) != 0) {
                    linearTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getLinearTrackStroke(composerStartRestartGroup, 0);
                    i3 &= -57345;
                } else {
                    linearTrackStroke = stroke2;
                }
                if ((i2 & 32) != 0) {
                    fM5225getLinearIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5225getLinearIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                }
                if (i10 != 0) {
                    f5 = 1.0f;
                }
                if ((i2 & 128) != 0) {
                    fM5224getLinearIndeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5224getLinearIndeterminateWavelengthD9Ej5fM();
                    i3 = (-29360129) & i3;
                } else {
                    fM5224getLinearIndeterminateWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i3 &= -234881025;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    f11 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM5224getLinearIndeterminateWavelengthD9Ej5fM;
                    f10 = f12;
                } else {
                    f10 = f4;
                    stroke5 = linearIndicatorStroke;
                    stroke6 = linearTrackStroke;
                    j5 = indicatorColor;
                    j6 = trackColor;
                    f11 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
                    f12 = fM5224getLinearIndeterminateWavelengthD9Ej5fM;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070567281, i3, -1, "androidx.compose.material3.LinearWavyProgressIndicator (WavyProgressIndicator.kt:177)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition("LinearWavyProgressIndicatorProgress", composerStartRestartGroup, 6, 0);
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineHeadAnimationSpec(), "LinearWavyProgressIndicatorFirstHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateFirstLineTailAnimationSpec(), "LinearWavyProgressIndicatorFirstTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineHeadAnimationSpec(), "LinearWavyProgressIndicatorSecondHead", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            stateAnimateFloat4 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 1.0f, ProgressIndicatorKt.getLinearIndeterminateSecondLineTailAnimationSpec(), "LinearWavyProgressIndicatorSecondTail", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0);
            Modifier modifierClipToBounds2 = ClipKt.clipToBounds(SizeKt.m2419sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier2.then(AccessibilityUtilKt.getIncreaseVerticalSemanticsBounds())), WavyProgressIndicatorDefaults.INSTANCE.m5222getLinearContainerWidthD9Ej5fM(), WavyProgressIndicatorDefaults.INSTANCE.m5221getLinearContainerHeightD9Ej5fM()));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245226074, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(stateAnimateFloat);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(stateAnimateFloat));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(stateAnimateFloat));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function4 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245223866, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(stateAnimateFloat2);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(stateAnimateFloat2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(stateAnimateFloat2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function5 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245221625, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloat3);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(stateAnimateFloat3));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(stateAnimateFloat3));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function6 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1245219353, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(stateAnimateFloat4);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(stateAnimateFloat4));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(stateAnimateFloat4));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function0 function7 = (Function0) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (f5 >= 0.0f) {
            }
            if (f13 > 1.0f) {
                f14 = 1.0f;
            } else {
                f14 = f13;
            }
            SpacerKt.Spacer(LinearWavyProgressModifiersKt.m5385linearWavyProgressIndicatorOFGGHrU(modifierClipToBounds2, function4, function5, function6, function7, j5, j6, stroke5, stroke6, f11, f14, f12, f10), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            j3 = j5;
            j4 = j6;
            stroke3 = stroke5;
            stroke4 = stroke6;
            f6 = f11;
            f7 = f12;
            f8 = f10;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            j3 = indicatorColor;
            j4 = trackColor;
            f6 = fM5225getLinearIndicatorTrackGapSizeD9Ej5fM;
            stroke3 = stroke;
            stroke4 = stroke2;
            f7 = f3;
            f8 = f4;
        }
        f9 = f5;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.LinearWavyProgressIndicator_hvuEXSk$lambda$4(modifier3, j3, j4, stroke3, stroke4, f6, f9, f7, f8, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$0$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$1$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$2$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float LinearWavyProgressIndicator_hvuEXSk$lambda$3$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0117  */
    /* JADX WARN: Code duplicated, block: B:110:0x012d  */
    /* JADX WARN: Code duplicated, block: B:113:0x013a  */
    /* JADX WARN: Code duplicated, block: B:114:0x013c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0145  */
    /* JADX WARN: Code duplicated, block: B:147:0x01a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:151:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:157:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:158:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:161:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:162:0x01de  */
    /* JADX WARN: Code duplicated, block: B:165:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:168:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:169:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:172:0x0200  */
    /* JADX WARN: Code duplicated, block: B:175:0x020c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0211 A[PHI: r0 r1 r3 r5 r7 r8 r9 r11 r15
      0x0211: PHI (r0v31 androidx.compose.ui.graphics.drawscope.Stroke) = (r0v15 androidx.compose.ui.graphics.drawscope.Stroke), (r0v41 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r1v14 kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>) = 
      (r1v8 kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>)
      (r1v15 kotlin.jvm.functions.Function1<? super java.lang.Float, java.lang.Float>)
     binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r3v17 float) = (r3v5 float), (r3v2 float) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r5v35 int) = (r5v22 int), (r5v44 int) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r7v10 androidx.compose.ui.graphics.drawscope.Stroke) = (r7v5 androidx.compose.ui.graphics.drawscope.Stroke), (r7v11 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r8v9 androidx.compose.ui.Modifier) = (r8v5 androidx.compose.ui.Modifier), (r8v2 androidx.compose.ui.Modifier) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r9v11 long) = (r9v8 long), (r9v6 long) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r11v9 long) = (r11v5 long), (r11v2 long) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]
      0x0211: PHI (r15v13 float) = (r15v9 float), (r15v6 float) binds: [B:174:0x020a, B:146:0x019c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:179:0x021d  */
    /* JADX WARN: Code duplicated, block: B:180:0x022b  */
    /* JADX WARN: Code duplicated, block: B:183:0x0262  */
    /* JADX WARN: Code duplicated, block: B:184:0x0264  */
    /* JADX WARN: Code duplicated, block: B:187:0x026b  */
    /* JADX WARN: Code duplicated, block: B:189:0x0273  */
    /* JADX WARN: Code duplicated, block: B:192:0x028f  */
    /* JADX WARN: Code duplicated, block: B:194:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:197:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00db  */
    /* JADX WARN: Code duplicated, block: B:82:0x00df  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:95:0x0105  */
    /* JADX WARN: Code duplicated, block: B:96:0x0108  */
    /* JADX WARN: Code duplicated, block: B:99:0x010f  */
    /* JADX INFO: renamed from: CircularWavyProgressIndicator-L8eD4gc, reason: not valid java name */
    public static final void m5230CircularWavyProgressIndicatorL8eD4gc(Function0<Float> function0, Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, Function1<? super Float, Float> function1, float f2, float f3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long indicatorColor;
        long trackColor;
        float fM5219getCircularIndicatorTrackGapSizeD9Ej5fM;
        Function1<? super Float, Float> function2;
        float fM5220getCircularWavelengthD9Ej5fM;
        boolean z;
        final Function0<Float> function3;
        final Stroke stroke3;
        final Modifier modifier3;
        final Stroke stroke4;
        final float f4;
        final float f5;
        final long j3;
        final Function1<? super Float, Float> function4;
        final long j4;
        final float f6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Stroke circularIndicatorStroke;
        Stroke circularTrackStroke;
        Function1<? super Float, Float> indicatorAmplitude;
        int i4;
        float f7;
        boolean z2;
        Object objRememberedValue;
        int i5;
        int i6;
        boolean zChangedInstance;
        int i7;
        boolean zChangedInstance2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1437375010);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularWavyProgressIndicator)N(progress,modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)304@15574L485,289@14958L1107:WavyProgressIndicator.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    indicatorColor = j;
                    int i9 = composerStartRestartGroup.changed(indicatorColor) ? 256 : 128;
                    i3 |= i9;
                } else {
                    indicatorColor = j;
                }
                i3 |= i9;
            } else {
                indicatorColor = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    trackColor = j2;
                    int i10 = composerStartRestartGroup.changed(trackColor) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    trackColor = j2;
                }
                i3 |= i10;
            } else {
                trackColor = j2;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) != 0) {
                    i7 = 8192;
                } else {
                    if ((32768 & i) == 0) {
                        zChangedInstance2 = composerStartRestartGroup.changed(stroke);
                    } else {
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(stroke);
                    }
                    if (zChangedInstance2) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) != 0) {
                    i6 = 65536;
                } else {
                    if ((262144 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(stroke2);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(stroke2);
                    }
                    if (zChangedInstance) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                }
                i3 |= i6;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f;
                    int i11 = composerStartRestartGroup.changed(fM5219getCircularIndicatorTrackGapSizeD9Ej5fM) ? 1048576 : 524288;
                    i3 |= i11;
                } else {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f;
                }
                i3 |= i11;
            } else {
                fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    function2 = function1;
                    int i12 = composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                    i3 |= i12;
                } else {
                    function2 = function1;
                }
                i3 |= i12;
            } else {
                function2 = function1;
            }
            if ((i & 100663296) == 0) {
                if ((i2 & 256) == 0) {
                    fM5220getCircularWavelengthD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM5220getCircularWavelengthD9Ej5fM)) {
                        i5 = 67108864;
                    }
                    i3 |= i5;
                } else {
                    fM5220getCircularWavelengthD9Ej5fM = f2;
                }
                i5 = GroupFlagsKt.HasAuxSlotFlag;
                i3 |= i5;
            } else {
                fM5220getCircularWavelengthD9Ej5fM = f2;
            }
            if ((i & 805306368) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : 536870912;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "280@14403L14,281@14473L10,282@14536L23,283@14617L19");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, 0);
                        i3 &= -57345;
                    } else {
                        circularIndicatorStroke = stroke;
                    }
                    if ((i2 & 32) != 0) {
                        circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, 0);
                        i3 &= -458753;
                    } else {
                        circularTrackStroke = stroke2;
                    }
                    if ((i2 & 64) != 0) {
                        fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5219getCircularIndicatorTrackGapSizeD9Ej5fM();
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                        i3 &= -29360129;
                    } else {
                        indicatorAmplitude = function2;
                    }
                    if ((i2 & 256) != 0) {
                        fM5220getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5220getCircularWavelengthD9Ej5fM();
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i4 = i3 & (-1879048193);
                        f7 = fM5220getCircularWavelengthD9Ej5fM;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1437375010, i4, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:288)");
                    }
                    float f8 = fM5220getCircularWavelengthD9Ej5fM;
                    float f9 = f7;
                    Modifier modifierM5359circularWavyProgressIndicator4ohQjRg = CircularWavyProgressModifiersKt.m5359circularWavyProgressIndicator4ohQjRg(SizeKt.m2417size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m5218getCircularContainerSizeD9Ej5fM()), function0, indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, fM5219getCircularIndicatorTrackGapSizeD9Ej5fM, indicatorAmplitude, f8, f9);
                    function3 = function0;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662127331, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                    if ((i4 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function3, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(SemanticsModifierKt.semantics(modifierM5359circularWavyProgressIndicator4ohQjRg, true, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    long j5 = trackColor;
                    f5 = f8;
                    j4 = j5;
                    modifier3 = modifier2;
                    j3 = indicatorColor;
                    f4 = f9;
                    function4 = indicatorAmplitude;
                    stroke4 = circularTrackStroke;
                    stroke3 = circularIndicatorStroke;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    if ((i2 & 512) != 0) {
                        i3 &= -1879048193;
                    }
                    circularIndicatorStroke = stroke;
                    circularTrackStroke = stroke2;
                    indicatorAmplitude = function2;
                }
                i4 = i3;
                f7 = f3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1437375010, i4, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:288)");
                }
                float f10 = fM5220getCircularWavelengthD9Ej5fM;
                float f11 = f7;
                Modifier modifierM5359circularWavyProgressIndicator4ohQjRg2 = CircularWavyProgressModifiersKt.m5359circularWavyProgressIndicator4ohQjRg(SizeKt.m2417size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m5218getCircularContainerSizeD9Ej5fM()), function0, indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, fM5219getCircularIndicatorTrackGapSizeD9Ej5fM, indicatorAmplitude, f10, f11);
                function3 = function0;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662127331, "CC(remember):WavyProgressIndicator.kt#9igjgp");
                if ((i4 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function3, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function3, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SemanticsModifierKt.semantics(modifierM5359circularWavyProgressIndicator4ohQjRg2, true, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                long j6 = trackColor;
                f5 = f10;
                j4 = j6;
                modifier3 = modifier2;
                j3 = indicatorColor;
                f4 = f11;
                function4 = indicatorAmplitude;
                stroke4 = circularTrackStroke;
                stroke3 = circularIndicatorStroke;
            } else {
                function3 = function0;
                composerStartRestartGroup.skipToGroupEnd();
                stroke3 = stroke;
                modifier3 = modifier2;
                stroke4 = stroke2;
                long j7 = trackColor;
                f4 = f3;
                f5 = fM5220getCircularWavelengthD9Ej5fM;
                j3 = indicatorColor;
                function4 = function2;
                j4 = j7;
            }
            f6 = fM5219getCircularIndicatorTrackGapSizeD9Ej5fM;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$1(function3, modifier3, j3, j4, stroke3, stroke4, f6, function4, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                indicatorColor = j;
                if (composerStartRestartGroup.changed(indicatorColor)) {
                }
                i3 |= i9;
            } else {
                indicatorColor = j;
            }
            i3 |= i9;
        } else {
            indicatorColor = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                trackColor = j2;
                if (composerStartRestartGroup.changed(trackColor)) {
                }
                i3 |= i10;
            } else {
                trackColor = j2;
            }
            i3 |= i10;
        } else {
            trackColor = j2;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) != 0) {
                i7 = 8192;
            } else {
                if ((32768 & i) == 0) {
                    zChangedInstance2 = composerStartRestartGroup.changed(stroke);
                } else {
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(stroke);
                }
                if (zChangedInstance2) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
            }
            i3 |= i7;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) != 0) {
                i6 = 65536;
            } else {
                if ((262144 & i) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(stroke2);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(stroke2);
                }
                if (zChangedInstance) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
            }
            i3 |= i6;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM5219getCircularIndicatorTrackGapSizeD9Ej5fM)) {
                }
                i3 |= i11;
            } else {
                fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f;
            }
            i3 |= i11;
        } else {
            fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f;
        }
        if ((i & 12582912) == 0) {
            if ((i2 & 128) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                }
                i3 |= i12;
            } else {
                function2 = function1;
            }
            i3 |= i12;
        } else {
            function2 = function1;
        }
        if ((i & 100663296) == 0) {
            if ((i2 & 256) == 0) {
                fM5220getCircularWavelengthD9Ej5fM = f2;
                if (composerStartRestartGroup.changed(fM5220getCircularWavelengthD9Ej5fM)) {
                    i5 = 67108864;
                }
                i3 |= i5;
            } else {
                fM5220getCircularWavelengthD9Ej5fM = f2;
            }
            i5 = GroupFlagsKt.HasAuxSlotFlag;
            i3 |= i5;
        } else {
            fM5220getCircularWavelengthD9Ej5fM = f2;
        }
        if ((i & 805306368) != 0) {
            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(f3)) ? 268435456 : 536870912;
        }
        if ((i3 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "280@14403L14,281@14473L10,282@14536L23,283@14617L19");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, 0);
                    i3 &= -57345;
                } else {
                    circularIndicatorStroke = stroke;
                }
                if ((i2 & 32) != 0) {
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, 0);
                    i3 &= -458753;
                } else {
                    circularTrackStroke = stroke2;
                }
                if ((i2 & 64) != 0) {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5219getCircularIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i3 &= -29360129;
                } else {
                    indicatorAmplitude = function2;
                }
                if ((i2 & 256) != 0) {
                    fM5220getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5220getCircularWavelengthD9Ej5fM();
                    i3 &= -234881025;
                }
                if ((i2 & 512) != 0) {
                    i4 = i3 & (-1879048193);
                    f7 = fM5220getCircularWavelengthD9Ej5fM;
                } else {
                    i4 = i3;
                    f7 = f3;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, 0);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, 0);
                    i3 &= -57345;
                } else {
                    circularIndicatorStroke = stroke;
                }
                if ((i2 & 32) != 0) {
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, 0);
                    i3 &= -458753;
                } else {
                    circularTrackStroke = stroke2;
                }
                if ((i2 & 64) != 0) {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5219getCircularIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    indicatorAmplitude = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
                    i3 &= -29360129;
                } else {
                    indicatorAmplitude = function2;
                }
                if ((i2 & 256) != 0) {
                    fM5220getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5220getCircularWavelengthD9Ej5fM();
                    i3 &= -234881025;
                }
                if ((i2 & 512) != 0) {
                    i4 = i3 & (-1879048193);
                    f7 = fM5220getCircularWavelengthD9Ej5fM;
                } else {
                    i4 = i3;
                    f7 = f3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1437375010, i4, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:288)");
            }
            float f12 = fM5220getCircularWavelengthD9Ej5fM;
            float f13 = f7;
            Modifier modifierM5359circularWavyProgressIndicator4ohQjRg3 = CircularWavyProgressModifiersKt.m5359circularWavyProgressIndicator4ohQjRg(SizeKt.m2417size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m5218getCircularContainerSizeD9Ej5fM()), function0, indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, fM5219getCircularIndicatorTrackGapSizeD9Ej5fM, indicatorAmplitude, f12, f13);
            function3 = function0;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1662127331, "CC(remember):WavyProgressIndicator.kt#9igjgp");
            if ((i4 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function3, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(function3, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SemanticsModifierKt.semantics(modifierM5359circularWavyProgressIndicator4ohQjRg3, true, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            long j8 = trackColor;
            f5 = f12;
            j4 = j8;
            modifier3 = modifier2;
            j3 = indicatorColor;
            f4 = f13;
            function4 = indicatorAmplitude;
            stroke4 = circularTrackStroke;
            stroke3 = circularIndicatorStroke;
        } else {
            function3 = function0;
            composerStartRestartGroup.skipToGroupEnd();
            stroke3 = stroke;
            modifier3 = modifier2;
            stroke4 = stroke2;
            long j9 = trackColor;
            f4 = f3;
            f5 = fM5220getCircularWavelengthD9Ej5fM;
            j3 = indicatorColor;
            function4 = function2;
            j4 = j9;
        }
        f6 = fM5219getCircularIndicatorTrackGapSizeD9Ej5fM;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.CircularWavyProgressIndicator_L8eD4gc$lambda$1(function3, modifier3, j3, j4, stroke3, stroke4, f6, function4, f5, f4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CircularWavyProgressIndicator_L8eD4gc$lambda$0$0(Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        float fCoerceIn = RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f);
        SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(Float.isNaN(fCoerceIn) ? 0.0f : fCoerceIn, RangesKt.rangeTo(0.0f, 1.0f), 0, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0119  */
    /* JADX WARN: Code duplicated, block: B:105:0x0125  */
    /* JADX WARN: Code duplicated, block: B:106:0x0127  */
    /* JADX WARN: Code duplicated, block: B:109:0x0130  */
    /* JADX WARN: Code duplicated, block: B:136:0x0183 A[PHI: r0 r1 r4 r5 r6 r7 r9 r11 r14
      0x0183: PHI (r0v42 androidx.compose.ui.graphics.drawscope.Stroke) = (r0v15 androidx.compose.ui.graphics.drawscope.Stroke), (r0v51 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r1v30 androidx.compose.ui.graphics.drawscope.Stroke) = (r1v7 androidx.compose.ui.graphics.drawscope.Stroke), (r1v31 androidx.compose.ui.graphics.drawscope.Stroke) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r4v19 float) = (r4v8 float), (r4v20 float) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r5v11 androidx.compose.ui.Modifier) = (r5v4 androidx.compose.ui.Modifier), (r5v3 androidx.compose.ui.Modifier) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r6v35 int) = (r6v23 int), (r6v43 int) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r7v9 long) = (r7v5 long), (r7v2 long) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r9v7 long) = (r9v4 long), (r9v2 long) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r11v14 float) = (r11v9 float), (r11v15 float) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]
      0x0183: PHI (r14v8 float) = (r14v4 float), (r14v9 float) binds: [B:166:0x01f1, B:135:0x017b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:137:0x0188 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x018a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0193  */
    /* JADX WARN: Code duplicated, block: B:142:0x019d  */
    /* JADX WARN: Code duplicated, block: B:145:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:149:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:152:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:153:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:156:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:157:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:159:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:160:0x01df  */
    /* JADX WARN: Code duplicated, block: B:163:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:164:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:167:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:170:0x0200  */
    /* JADX WARN: Code duplicated, block: B:171:0x020e  */
    /* JADX WARN: Code duplicated, block: B:174:0x0263  */
    /* JADX WARN: Code duplicated, block: B:177:0x026f  */
    /* JADX WARN: Code duplicated, block: B:178:0x0273  */
    /* JADX WARN: Code duplicated, block: B:181:0x0311  */
    /* JADX WARN: Code duplicated, block: B:183:0x0320  */
    /* JADX WARN: Code duplicated, block: B:186:0x0337  */
    /* JADX WARN: Code duplicated, block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0084  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:94:0x0103  */
    /* JADX INFO: renamed from: CircularWavyProgressIndicator-hvuEXSk, reason: not valid java name */
    public static final void m5231CircularWavyProgressIndicatorhvuEXSk(Modifier modifier, long j, long j2, Stroke stroke, Stroke stroke2, float f, float f2, float f3, float f4, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long indicatorColor;
        long trackColor;
        float f5;
        float f6;
        boolean z;
        final Stroke stroke3;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f7;
        final Stroke stroke4;
        final float f8;
        final float f9;
        final float f10;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        Stroke circularIndicatorStroke;
        Stroke circularTrackStroke;
        float fM5219getCircularIndicatorTrackGapSizeD9Ej5fM;
        float f11;
        float fM5220getCircularWavelengthD9Ej5fM;
        int i5;
        float f12;
        Function0<ComposeUiNode> constructor;
        int i6;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(958856149);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularWavyProgressIndicator)N(modifier,color:c#ui.graphics.Color,trackColor:c#ui.graphics.Color,stroke,trackStroke,gapSize:c#ui.unit.Dp,amplitude,wavelength:c#ui.unit.Dp,waveSpeed:c#ui.unit.Dp)359@18671L813:WavyProgressIndicator.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                indicatorColor = j;
                int i9 = composerStartRestartGroup.changed(indicatorColor) ? 32 : 16;
                i3 |= i9;
            } else {
                indicatorColor = j;
            }
            i3 |= i9;
        } else {
            indicatorColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                trackColor = j2;
                int i10 = composerStartRestartGroup.changed(trackColor) ? 256 : 128;
                i3 |= i10;
            } else {
                trackColor = j2;
            }
            i3 |= i10;
        } else {
            trackColor = j2;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) != 0) {
                i7 = 1024;
            } else {
                if ((i & 4096) == 0 ? composerStartRestartGroup.changed(stroke) : composerStartRestartGroup.changedInstance(stroke)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
            }
            i3 |= i7;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) != 0) {
                i6 = 8192;
            } else {
                if ((32768 & i) == 0 ? composerStartRestartGroup.changed(stroke2) : composerStartRestartGroup.changedInstance(stroke2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
            }
            i3 |= i6;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f5 = f;
                int i11 = composerStartRestartGroup.changed(f5) ? 131072 : 65536;
                i3 |= i11;
            } else {
                f5 = f;
            }
            i3 |= i11;
        } else {
            f5 = f;
        }
        int i12 = i2 & 64;
        if (i12 == 0) {
            if ((1572864 & i) == 0) {
                f6 = f2;
                i3 |= composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "350@18149L14,351@18219L10,352@18282L23,353@18363L19");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 2) != 0) {
                        i4 = 0;
                        indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                        i3 &= -113;
                    } else {
                        i4 = 0;
                    }
                    if ((i2 & 4) != 0) {
                        trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, i4);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, i4);
                        i3 &= -7169;
                    } else {
                        circularIndicatorStroke = stroke;
                    }
                    if ((i2 & 16) != 0) {
                        circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, i4);
                        i3 &= -57345;
                    } else {
                        circularTrackStroke = stroke2;
                    }
                    if ((i2 & 32) != 0) {
                        fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5219getCircularIndicatorTrackGapSizeD9Ej5fM();
                        i3 &= -458753;
                    } else {
                        fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                    }
                    if (i12 != 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = f6;
                    }
                    if ((i2 & 128) != 0) {
                        fM5220getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5220getCircularWavelengthD9Ej5fM();
                        i3 &= -29360129;
                    } else {
                        fM5220getCircularWavelengthD9Ej5fM = f3;
                    }
                    if ((i2 & 256) != 0) {
                        i5 = i3 & (-234881025);
                        f12 = fM5220getCircularWavelengthD9Ej5fM;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(958856149, i5, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:358)");
                    }
                    Modifier modifierM2417size3ABfNKs = SizeKt.m2417size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m5218getCircularContainerSizeD9Ej5fM());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    float f13 = fM5219getCircularIndicatorTrackGapSizeD9Ej5fM;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2417size3ABfNKs);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Modifier modifier4 = modifier2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6438constructorimpl = Updater.m6438constructorimpl(composerStartRestartGroup);
                    Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902088322, "C360@18764L452,375@19417L61:WavyProgressIndicator.kt#uh7d8r");
                    float f14 = f12;
                    float f15 = f11;
                    Stroke stroke5 = circularIndicatorStroke;
                    Stroke stroke6 = circularTrackStroke;
                    f6 = f15;
                    SpacerKt.Spacer(CircularWavyProgressModifiersKt.m5358circularWavyProgressIndicator4JQtiWo(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, f13, f15, fM5220getCircularWavelengthD9Ej5fM, f14), composerStartRestartGroup, 0);
                    SpacerKt.Spacer(ProgressSemanticsKt.progressSemantics(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = indicatorColor;
                    f7 = f13;
                    modifier3 = modifier4;
                    f9 = f14;
                    stroke4 = stroke6;
                    stroke3 = stroke5;
                    j4 = trackColor;
                    f8 = fM5220getCircularWavelengthD9Ej5fM;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 128) != 0) {
                        i3 &= -29360129;
                    }
                    if ((i2 & 256) != 0) {
                        i3 &= -234881025;
                    }
                    circularIndicatorStroke = stroke;
                    circularTrackStroke = stroke2;
                    fM5220getCircularWavelengthD9Ej5fM = f3;
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                    f11 = f6;
                }
                i5 = i3;
                f12 = f4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(958856149, i5, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:358)");
                }
                Modifier modifierM2417size3ABfNKs2 = SizeKt.m2417size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m5218getCircularContainerSizeD9Ej5fM());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                float f16 = fM5219getCircularIndicatorTrackGapSizeD9Ej5fM;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2417size3ABfNKs2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                Modifier modifier5 = modifier2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6438constructorimpl2 = Updater.m6438constructorimpl(composerStartRestartGroup);
                Updater.m6446setimpl(composerM6438constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6446setimpl(composerM6438constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6446setimpl(composerM6438constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6444reconcileimpl(composerM6438constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6446setimpl(composerM6438constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902088322, "C360@18764L452,375@19417L61:WavyProgressIndicator.kt#uh7d8r");
                float f17 = f12;
                float f18 = f11;
                Stroke stroke7 = circularIndicatorStroke;
                Stroke stroke8 = circularTrackStroke;
                f6 = f18;
                SpacerKt.Spacer(CircularWavyProgressModifiersKt.m5358circularWavyProgressIndicator4JQtiWo(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, f16, f18, fM5220getCircularWavelengthD9Ej5fM, f17), composerStartRestartGroup, 0);
                SpacerKt.Spacer(ProgressSemanticsKt.progressSemantics(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = indicatorColor;
                f7 = f16;
                modifier3 = modifier5;
                f9 = f17;
                stroke4 = stroke8;
                stroke3 = stroke7;
                j4 = trackColor;
                f8 = fM5220getCircularWavelengthD9Ej5fM;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                stroke3 = stroke;
                modifier3 = modifier2;
                j3 = indicatorColor;
                j4 = trackColor;
                f7 = f5;
                stroke4 = stroke2;
                f8 = f3;
                f9 = f4;
            }
            f10 = f6;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WavyProgressIndicatorKt.CircularWavyProgressIndicator_hvuEXSk$lambda$1(modifier3, j3, j4, stroke3, stroke4, f7, f10, f8, f9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        f6 = f2;
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(f3)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(f4)) ? GroupFlagsKt.HasAuxSlotFlag : 67108864;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "350@18149L14,351@18219L10,352@18282L23,353@18363L19");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    i4 = 0;
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                } else {
                    i4 = 0;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, i4);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, i4);
                    i3 &= -7169;
                } else {
                    circularIndicatorStroke = stroke;
                }
                if ((i2 & 16) != 0) {
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, i4);
                    i3 &= -57345;
                } else {
                    circularTrackStroke = stroke2;
                }
                if ((i2 & 32) != 0) {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5219getCircularIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                } else {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                }
                if (i12 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f6;
                }
                if ((i2 & 128) != 0) {
                    fM5220getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5220getCircularWavelengthD9Ej5fM();
                    i3 &= -29360129;
                } else {
                    fM5220getCircularWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i5 = i3 & (-234881025);
                    f12 = fM5220getCircularWavelengthD9Ej5fM;
                } else {
                    i5 = i3;
                    f12 = f4;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 2) != 0) {
                    i4 = 0;
                    indicatorColor = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, 0);
                    i3 &= -113;
                } else {
                    i4 = 0;
                }
                if ((i2 & 4) != 0) {
                    trackColor = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, i4);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    circularIndicatorStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularIndicatorStroke(composerStartRestartGroup, i4);
                    i3 &= -7169;
                } else {
                    circularIndicatorStroke = stroke;
                }
                if ((i2 & 16) != 0) {
                    circularTrackStroke = WavyProgressIndicatorDefaults.INSTANCE.getCircularTrackStroke(composerStartRestartGroup, i4);
                    i3 &= -57345;
                } else {
                    circularTrackStroke = stroke2;
                }
                if ((i2 & 32) != 0) {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5219getCircularIndicatorTrackGapSizeD9Ej5fM();
                    i3 &= -458753;
                } else {
                    fM5219getCircularIndicatorTrackGapSizeD9Ej5fM = f5;
                }
                if (i12 != 0) {
                    f11 = 1.0f;
                } else {
                    f11 = f6;
                }
                if ((i2 & 128) != 0) {
                    fM5220getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5220getCircularWavelengthD9Ej5fM();
                    i3 &= -29360129;
                } else {
                    fM5220getCircularWavelengthD9Ej5fM = f3;
                }
                if ((i2 & 256) != 0) {
                    i5 = i3 & (-234881025);
                    f12 = fM5220getCircularWavelengthD9Ej5fM;
                } else {
                    i5 = i3;
                    f12 = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(958856149, i5, -1, "androidx.compose.material3.CircularWavyProgressIndicator (WavyProgressIndicator.kt:358)");
            }
            Modifier modifierM2417size3ABfNKs3 = SizeKt.m2417size3ABfNKs(modifier2, WavyProgressIndicatorDefaults.INSTANCE.m5218getCircularContainerSizeD9Ej5fM());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            float f19 = fM5219getCircularIndicatorTrackGapSizeD9Ej5fM;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2417size3ABfNKs3);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            Modifier modifier6 = modifier2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6438constructorimpl3 = Updater.m6438constructorimpl(composerStartRestartGroup);
            Updater.m6446setimpl(composerM6438constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1902088322, "C360@18764L452,375@19417L61:WavyProgressIndicator.kt#uh7d8r");
            float f110 = f12;
            float f111 = f11;
            Stroke stroke9 = circularIndicatorStroke;
            Stroke stroke10 = circularTrackStroke;
            f6 = f111;
            SpacerKt.Spacer(CircularWavyProgressModifiersKt.m5358circularWavyProgressIndicator4JQtiWo(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), indicatorColor, trackColor, circularIndicatorStroke, circularTrackStroke, f19, f111, fM5220getCircularWavelengthD9Ej5fM, f110), composerStartRestartGroup, 0);
            SpacerKt.Spacer(ProgressSemanticsKt.progressSemantics(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = indicatorColor;
            f7 = f19;
            modifier3 = modifier6;
            f9 = f110;
            stroke4 = stroke10;
            stroke3 = stroke9;
            j4 = trackColor;
            f8 = fM5220getCircularWavelengthD9Ej5fM;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            stroke3 = stroke;
            modifier3 = modifier2;
            j3 = indicatorColor;
            j4 = trackColor;
            f7 = f5;
            stroke4 = stroke2;
            f8 = f3;
            f9 = f4;
        }
        f10 = f6;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WavyProgressIndicatorKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WavyProgressIndicatorKt.CircularWavyProgressIndicator_hvuEXSk$lambda$1(modifier3, j3, j4, stroke3, stroke4, f7, f10, f8, f9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final AnimationSpec<Float> getIncreasingAmplitudeAnimationSpec() {
        return IncreasingAmplitudeAnimationSpec;
    }

    public static final AnimationSpec<Float> getDecreasingAmplitudeAnimationSpec() {
        return DecreasingAmplitudeAnimationSpec;
    }
}
