package expo.modules.ui;

import androidx.compose.material3.ProgressIndicatorDefaults;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.WavyProgressIndicatorDefaults;
import androidx.compose.material3.WavyProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0019\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0012*\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0013\u001a\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\u0016H\u0002\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"LinearProgressIndicatorContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/LinearProgressIndicatorProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/LinearProgressIndicatorProps;Landroidx/compose/runtime/Composer;I)V", "CircularProgressIndicatorContent", "Lexpo/modules/ui/CircularProgressIndicatorProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/CircularProgressIndicatorProps;Landroidx/compose/runtime/Composer;I)V", "LinearWavyProgressIndicatorContent", "Lexpo/modules/ui/LinearWavyProgressIndicatorProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/LinearWavyProgressIndicatorProps;Landroidx/compose/runtime/Composer;I)V", "CircularWavyProgressIndicatorContent", "Lexpo/modules/ui/CircularWavyProgressIndicatorProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/CircularWavyProgressIndicatorProps;Landroidx/compose/runtime/Composer;I)V", "IndeterminateAmplitude", "", "toAmplitude", "Lkotlin/Function1;", "(Ljava/lang/Float;)Lkotlin/jvm/functions/Function1;", "toStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ProgressViewKt {
    private static final float IndeterminateAmplitude = 1.0f;

    static final Unit CircularProgressIndicatorContent$lambda$9(FunctionalComposableScope functionalComposableScope, CircularProgressIndicatorProps circularProgressIndicatorProps, int i, Composer composer, int i2) {
        CircularProgressIndicatorContent(functionalComposableScope, circularProgressIndicatorProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit CircularWavyProgressIndicatorContent$lambda$15(FunctionalComposableScope functionalComposableScope, CircularWavyProgressIndicatorProps circularWavyProgressIndicatorProps, int i, Composer composer, int i2) {
        CircularWavyProgressIndicatorContent(functionalComposableScope, circularWavyProgressIndicatorProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit LinearProgressIndicatorContent$lambda$6(FunctionalComposableScope functionalComposableScope, LinearProgressIndicatorProps linearProgressIndicatorProps, int i, Composer composer, int i2) {
        LinearProgressIndicatorContent(functionalComposableScope, linearProgressIndicatorProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit LinearWavyProgressIndicatorContent$lambda$12(FunctionalComposableScope functionalComposableScope, LinearWavyProgressIndicatorProps linearWavyProgressIndicatorProps, int i, Composer composer, int i2) {
        LinearWavyProgressIndicatorContent(functionalComposableScope, linearWavyProgressIndicatorProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final float toAmplitude$lambda$16(float f, float f2) {
        return f;
    }

    public static final void LinearProgressIndicatorContent(final FunctionalComposableScope functionalComposableScope, final LinearProgressIndicatorProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        float fM4485getLinearIndicatorTrackGapSizeD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2145439722);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearProgressIndicatorContent)N(props)47@1750L83:ProgressView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2145439722, i2, -1, "expo.modules.ui.LinearProgressIndicatorContent (ProgressView.kt:46)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(-183261183);
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@1903L11");
                jM7348unboximpl = ProgressIndicatorDefaults.INSTANCE.getLinearColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-183262888);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            final long j = jM7348unboximpl;
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getTrackColor());
            if (composeOrNull2 == null) {
                composerStartRestartGroup.startReplaceGroup(-183258266);
                ComposerKt.sourceInformation(composerStartRestartGroup, "49@1994L16");
                jM7348unboximpl2 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-183260126);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            }
            long j2 = jM7348unboximpl2;
            StrokeCap strokeCap = toStrokeCap(props.getStrokeCap());
            final int value = strokeCap != null ? strokeCap.getValue() : ProgressIndicatorDefaults.INSTANCE.m4486getLinearStrokeCapKaPHkGw();
            Float gapSize = props.getGapSize();
            if (gapSize == null) {
                fM4485getLinearIndicatorTrackGapSizeD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m4485getLinearIndicatorTrackGapSizeD9Ej5fM();
            } else {
                fM4485getLinearIndicatorTrackGapSizeD9Ej5fM = Dp.m10168constructorimpl(gapSize.floatValue());
            }
            float f = fM4485getLinearIndicatorTrackGapSizeD9Ej5fM;
            if (props.getProgress() != null) {
                composerStartRestartGroup.startReplaceGroup(-1385779509);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                final DrawStopIndicatorConfig drawStopIndicator = props.getDrawStopIndicator();
                if (drawStopIndicator != null) {
                    composerStartRestartGroup.startReplaceGroup(-1385697483);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "57@2371L18,62@2533L374,56@2327L617");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183246200, "CC(remember):ProgressView.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(props);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(props.getProgress().floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183240660, "CC(remember):ProgressView.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(drawStopIndicator) | composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(value);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ProgressViewKt.LinearProgressIndicatorContent$lambda$3$lambda$2(drawStopIndicator, j, value, (DrawScope) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProgressIndicatorKt.m4500LinearProgressIndicatorGJbTh5U(function0, modifierApplyModifiers, j, j2, value, f, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1385078103);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "74@3008L18,73@2964L213");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -183225816, "CC(remember):ProgressView.kt#9igjgp");
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(props);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(props.getProgress().floatValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProgressIndicatorKt.m4500LinearProgressIndicatorGJbTh5U((Function0) objRememberedValue3, modifierApplyModifiers, j, j2, value, f, null, composerStartRestartGroup, 0, 64);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1384844704);
                ComposerKt.sourceInformation(composerStartRestartGroup, "83@3199L162");
                ProgressIndicatorKt.m4505LinearProgressIndicatorrIrjwxo(modifierApplyModifiers, j, j2, value, f, composerStartRestartGroup, 0, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressViewKt.LinearProgressIndicatorContent$lambda$6(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit LinearProgressIndicatorContent$lambda$3$lambda$2(DrawStopIndicatorConfig drawStopIndicatorConfig, long j, int i, DrawScope LinearProgressIndicator) {
        float fM4487getLinearTrackStopIndicatorSizeD9Ej5fM;
        Intrinsics.checkNotNullParameter(LinearProgressIndicator, "$this$LinearProgressIndicator");
        ProgressIndicatorDefaults progressIndicatorDefaults = ProgressIndicatorDefaults.INSTANCE;
        Float stopSize = drawStopIndicatorConfig.getStopSize();
        if (stopSize == null) {
            fM4487getLinearTrackStopIndicatorSizeD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m4487getLinearTrackStopIndicatorSizeD9Ej5fM();
        } else {
            fM4487getLinearTrackStopIndicatorSizeD9Ej5fM = Dp.m10168constructorimpl(stopSize.floatValue());
        }
        float f = fM4487getLinearTrackStopIndicatorSizeD9Ej5fM;
        Color composeOrNull = UtilsKt.getComposeOrNull(drawStopIndicatorConfig.getColor());
        if (composeOrNull != null) {
            j = composeOrNull.m7348unboximpl();
        }
        long j2 = j;
        StrokeCap strokeCap = toStrokeCap(drawStopIndicatorConfig.getStrokeCap());
        if (strokeCap != null) {
            i = strokeCap.getValue();
        }
        progressIndicatorDefaults.m4480drawStopIndicatorEgI2THU(LinearProgressIndicator, f, j2, i);
        return Unit.INSTANCE;
    }

    public static final void CircularProgressIndicatorContent(final FunctionalComposableScope functionalComposableScope, final CircularProgressIndicatorProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        float fM4484getCircularStrokeWidthD9Ej5fM;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        float fM4483getCircularIndicatorTrackGapSizeD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(489144406);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicatorContent)N(props)110@3887L83:ProgressView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(489144406, i2, -1, "expo.modules.ui.CircularProgressIndicatorContent (ProgressView.kt:109)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(1916348611);
                ComposerKt.sourceInformation(composerStartRestartGroup, "111@4040L13");
                jM7348unboximpl = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1916346906);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            Float strokeWidth = props.getStrokeWidth();
            if (strokeWidth == null) {
                fM4484getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m4484getCircularStrokeWidthD9Ej5fM();
            } else {
                fM4484getCircularStrokeWidthD9Ej5fM = Dp.m10168constructorimpl(strokeWidth.floatValue());
            }
            float f = fM4484getCircularStrokeWidthD9Ej5fM;
            if (props.getProgress() != null) {
                composerStartRestartGroup.startReplaceGroup(-722583363);
                ComposerKt.sourceInformation(composerStartRestartGroup, "120@4541L18,119@4497L234");
                Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getTrackColor());
                if (composeOrNull2 == null) {
                    composerStartRestartGroup.startReplaceGroup(1916355635);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "115@4259L29");
                    jM7348unboximpl3 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1916353775);
                    composerStartRestartGroup.endReplaceGroup();
                    jM7348unboximpl3 = composeOrNull2.m7348unboximpl();
                }
                long j = jM7348unboximpl3;
                StrokeCap strokeCap = toStrokeCap(props.getStrokeCap());
                int value = strokeCap != null ? strokeCap.getValue() : ProgressIndicatorDefaults.INSTANCE.m4481getCircularDeterminateStrokeCapKaPHkGw();
                Float gapSize = props.getGapSize();
                if (gapSize == null) {
                    fM4483getCircularIndicatorTrackGapSizeD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m4483getCircularIndicatorTrackGapSizeD9Ej5fM();
                } else {
                    fM4483getCircularIndicatorTrackGapSizeD9Ej5fM = Dp.m10168constructorimpl(gapSize.floatValue());
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1916364648, "CC(remember):ProgressView.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(props);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(props.getProgress().floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProgressIndicatorKt.m4495CircularProgressIndicatorIyT6zlY((Function0) objRememberedValue, modifierApplyModifiers, jM7348unboximpl, f, j, value, fM4483getCircularIndicatorTrackGapSizeD9Ej5fM, composerStartRestartGroup, 0, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-722027626);
                ComposerKt.sourceInformation(composerStartRestartGroup, "132@4971L172");
                Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getTrackColor());
                if (composeOrNull3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1916373717);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "129@4824L31");
                    jM7348unboximpl2 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1916371857);
                    composerStartRestartGroup.endReplaceGroup();
                    jM7348unboximpl2 = composeOrNull3.m7348unboximpl();
                }
                StrokeCap strokeCap2 = toStrokeCap(props.getStrokeCap());
                ProgressIndicatorKt.m4492CircularProgressIndicator4lLiAd8(modifierApplyModifiers, jM7348unboximpl, f, jM7348unboximpl2, strokeCap2 != null ? strokeCap2.getValue() : ProgressIndicatorDefaults.INSTANCE.m4482getCircularIndeterminateStrokeCapKaPHkGw(), 0.0f, composerStartRestartGroup, 0, 32);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressViewKt.CircularProgressIndicatorContent$lambda$9(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void LinearWavyProgressIndicatorContent(final FunctionalComposableScope functionalComposableScope, final LinearWavyProgressIndicatorProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        float fM5226getLinearTrackStopIndicatorSizeD9Ej5fM;
        float fM5224getLinearIndeterminateWavelengthD9Ej5fM;
        float fM5223getLinearDeterminateWavelengthD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1016280330);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearWavyProgressIndicatorContent)N(props)160@5708L83:ProgressView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1016280330, i2, -1, "expo.modules.ui.LinearWavyProgressIndicatorContent (ProgressView.kt:159)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(-1687810972);
                ComposerKt.sourceInformation(composerStartRestartGroup, "161@5865L14");
                jM7348unboximpl = WavyProgressIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, WavyProgressIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1687812801);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getTrackColor());
            if (composeOrNull2 == null) {
                composerStartRestartGroup.startReplaceGroup(-1687807840);
                ComposerKt.sourceInformation(composerStartRestartGroup, "162@5963L10");
                jM7348unboximpl2 = WavyProgressIndicatorDefaults.INSTANCE.getTrackColor(composerStartRestartGroup, WavyProgressIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1687809824);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            }
            Float stopSize = props.getStopSize();
            if (stopSize == null) {
                fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5226getLinearTrackStopIndicatorSizeD9Ej5fM();
            } else {
                fM5226getLinearTrackStopIndicatorSizeD9Ej5fM = Dp.m10168constructorimpl(stopSize.floatValue());
            }
            float f = fM5226getLinearTrackStopIndicatorSizeD9Ej5fM;
            if (props.getProgress() != null) {
                composerStartRestartGroup.startReplaceGroup(-782283803);
                ComposerKt.sourceInformation(composerStartRestartGroup, "169@6259L18,168@6213L309");
                Float wavelength = props.getWavelength();
                if (wavelength == null) {
                    fM5223getLinearDeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5223getLinearDeterminateWavelengthD9Ej5fM();
                } else {
                    fM5223getLinearDeterminateWavelengthD9Ej5fM = Dp.m10168constructorimpl(wavelength.floatValue());
                }
                Function1<Float, Float> amplitude = toAmplitude(props.getAmplitude());
                Float waveSpeed = props.getWaveSpeed();
                float fM10168constructorimpl = waveSpeed != null ? Dp.m10168constructorimpl(waveSpeed.floatValue()) : fM5223getLinearDeterminateWavelengthD9Ej5fM;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1687798360, "CC(remember):ProgressView.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(props);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(props.getProgress().floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                WavyProgressIndicatorKt.m5232LinearWavyProgressIndicator1YwxWKA((Function0) objRememberedValue, modifierApplyModifiers, jM7348unboximpl, jM7348unboximpl2, null, null, 0.0f, f, amplitude, fM5223getLinearDeterminateWavelengthD9Ej5fM, fM10168constructorimpl, composerStartRestartGroup, 0, 0, 112);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                long j = jM7348unboximpl2;
                long j2 = jM7348unboximpl;
                composerStartRestartGroup.startReplaceGroup(-781859785);
                ComposerKt.sourceInformation(composerStartRestartGroup, "181@6644L257");
                Float wavelength2 = props.getWavelength();
                if (wavelength2 == null) {
                    fM5224getLinearIndeterminateWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5224getLinearIndeterminateWavelengthD9Ej5fM();
                } else {
                    fM5224getLinearIndeterminateWavelengthD9Ej5fM = Dp.m10168constructorimpl(wavelength2.floatValue());
                }
                float f2 = fM5224getLinearIndeterminateWavelengthD9Ej5fM;
                Float amplitude2 = props.getAmplitude();
                float fFloatValue = amplitude2 != null ? amplitude2.floatValue() : 1.0f;
                Float waveSpeed2 = props.getWaveSpeed();
                WavyProgressIndicatorKt.m5233LinearWavyProgressIndicatorhvuEXSk(modifierApplyModifiers, j2, j, null, null, 0.0f, fFloatValue, f2, waveSpeed2 != null ? Dp.m10168constructorimpl(waveSpeed2.floatValue()) : f2, composerStartRestartGroup, 0, 56);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressViewKt.LinearWavyProgressIndicatorContent$lambda$12(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void CircularWavyProgressIndicatorContent(final FunctionalComposableScope functionalComposableScope, final CircularWavyProgressIndicatorProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        float fM5220getCircularWavelengthD9Ej5fM;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1591281526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularWavyProgressIndicatorContent)N(props)209@7443L83:ProgressView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1591281526, i2, -1, "expo.modules.ui.CircularWavyProgressIndicatorContent (ProgressView.kt:208)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(213199075);
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@7596L13");
                jM7348unboximpl = ProgressIndicatorDefaults.INSTANCE.getCircularColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(213197370);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            Float wavelength = props.getWavelength();
            if (wavelength == null) {
                fM5220getCircularWavelengthD9Ej5fM = WavyProgressIndicatorDefaults.INSTANCE.m5220getCircularWavelengthD9Ej5fM();
            } else {
                fM5220getCircularWavelengthD9Ej5fM = Dp.m10168constructorimpl(wavelength.floatValue());
            }
            float f = fM5220getCircularWavelengthD9Ej5fM;
            Float waveSpeed = props.getWaveSpeed();
            float fM10168constructorimpl = waveSpeed != null ? Dp.m10168constructorimpl(waveSpeed.floatValue()) : f;
            if (props.getProgress() != null) {
                composerStartRestartGroup.startReplaceGroup(-1980564338);
                ComposerKt.sourceInformation(composerStartRestartGroup, "218@7951L18,217@7903L260");
                Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getTrackColor());
                if (composeOrNull2 == null) {
                    composerStartRestartGroup.startReplaceGroup(213207795);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "215@7868L29");
                    jM7348unboximpl3 = ProgressIndicatorDefaults.INSTANCE.getCircularDeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(213205935);
                    composerStartRestartGroup.endReplaceGroup();
                    jM7348unboximpl3 = composeOrNull2.m7348unboximpl();
                }
                long j = jM7348unboximpl3;
                Function1<Float, Float> amplitude = toAmplitude(props.getAmplitude());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 213210440, "CC(remember):ProgressView.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(props);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(props.getProgress().floatValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                WavyProgressIndicatorKt.m5230CircularWavyProgressIndicatorL8eD4gc((Function0) objRememberedValue, modifierApplyModifiers, jM7348unboximpl, j, null, null, 0.0f, amplitude, f, fM10168constructorimpl, composerStartRestartGroup, 0, 112);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                long j2 = jM7348unboximpl;
                composerStartRestartGroup.startReplaceGroup(-1980180155);
                ComposerKt.sourceInformation(composerStartRestartGroup, "229@8293L235");
                Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getTrackColor());
                if (composeOrNull3 == null) {
                    composerStartRestartGroup.startReplaceGroup(213220213);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "227@8256L31");
                    jM7348unboximpl2 = ProgressIndicatorDefaults.INSTANCE.getCircularIndeterminateTrackColor(composerStartRestartGroup, ProgressIndicatorDefaults.$stable);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(213218353);
                    composerStartRestartGroup.endReplaceGroup();
                    jM7348unboximpl2 = composeOrNull3.m7348unboximpl();
                }
                Float amplitude2 = props.getAmplitude();
                WavyProgressIndicatorKt.m5231CircularWavyProgressIndicatorhvuEXSk(modifierApplyModifiers, j2, jM7348unboximpl2, null, null, 0.0f, amplitude2 != null ? amplitude2.floatValue() : 1.0f, f, fM10168constructorimpl, composerStartRestartGroup, 0, 56);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressViewKt.CircularWavyProgressIndicatorContent$lambda$15(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final Function1<Float, Float> toAmplitude(Float f) {
        if (f != null) {
            final float fFloatValue = f.floatValue();
            return new Function1() { // from class: expo.modules.ui.ProgressViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Float.valueOf(ProgressViewKt.toAmplitude$lambda$16(fFloatValue, ((Float) obj).floatValue()));
                }
            };
        }
        return WavyProgressIndicatorDefaults.INSTANCE.getIndicatorAmplitude();
    }

    private static final StrokeCap toStrokeCap(String str) {
        String lowerCase;
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            int iHashCode = lowerCase.hashCode();
            if (iHashCode != -894674659) {
                if (iHashCode != 3035667) {
                    if (iHashCode == 108704142 && lowerCase.equals("round")) {
                        return StrokeCap.m7705boximpl(StrokeCap.INSTANCE.m7713getRoundKaPHkGw());
                    }
                } else if (lowerCase.equals("butt")) {
                    return StrokeCap.m7705boximpl(StrokeCap.INSTANCE.m7712getButtKaPHkGw());
                }
            } else if (lowerCase.equals("square")) {
                return StrokeCap.m7705boximpl(StrokeCap.INSTANCE.m7714getSquareKaPHkGw());
            }
        }
        return null;
    }
}
