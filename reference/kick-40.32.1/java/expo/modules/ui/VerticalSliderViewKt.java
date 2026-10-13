package expo.modules.ui;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: VerticalSliderView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006²\u0006\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u008a\u0084\u0002²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"VerticalSliderContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/VerticalSliderProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/VerticalSliderProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release", "onValueChange", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/ui/SliderValueChangedEvent;", "onValueChangeFinished", "localValue", "", "prevPropsValue"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VerticalSliderViewKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(VerticalSliderViewKt.class, "onValueChange", "<v#0>", 1)), Reflection.property0(new PropertyReference0Impl(VerticalSliderViewKt.class, "onValueChangeFinished", "<v#1>", 1))};

    static final Unit VerticalSliderContent$lambda$28(FunctionalComposableScope functionalComposableScope, VerticalSliderProps verticalSliderProps, int i, Composer composer, int i2) {
        VerticalSliderContent(functionalComposableScope, verticalSliderProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void VerticalSliderContent(final FunctionalComposableScope functionalComposableScope, final VerticalSliderProps props, Composer composer, final int i) {
        int i2;
        SliderState sliderState;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(803397824);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalSliderContent)N(props)36@1436L82,37@1550L63,38@1640L39,43@1872L86,45@2062L51,47@2135L206,65@2657L312,72@3004L103,79@3122L453,79@3111L464:VerticalSliderView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2);
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
                ComposerKt.traceEventStart(803397824, i2, -1, "expo.modules.ui.VerticalSliderContent (VerticalSliderView.kt:35)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1028797934, "CC(remember):VerticalSliderView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                ViewEventDelegate viewEventDelegate = new ViewEventDelegate(functionalComposableScope.getView(), null);
                composerStartRestartGroup.updateRememberedValue(viewEventDelegate);
                objRememberedValue = viewEventDelegate;
            }
            final ViewEventDelegate viewEventDelegate2 = (ViewEventDelegate) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1028794305, "CC(remember):VerticalSliderView.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                ViewEventDelegate viewEventDelegate3 = new ViewEventDelegate(functionalComposableScope.getView(), null);
                composerStartRestartGroup.updateRememberedValue(viewEventDelegate3);
                objRememberedValue2 = viewEventDelegate3;
            }
            final ViewEventDelegate viewEventDelegate4 = (ViewEventDelegate) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1028791449, "CC(remember):VerticalSliderView.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float min = props.getMin();
            Float lowerLimit = props.getLowerLimit();
            final float fMax = Math.max(min, lowerLimit != null ? lowerLimit.floatValue() : Float.NEGATIVE_INFINITY);
            float max = props.getMax();
            Float upperLimit = props.getUpperLimit();
            final float fMin = Math.min(max, upperLimit != null ? upperLimit.floatValue() : Float.POSITIVE_INFINITY);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1028783978, "CC(remember):VerticalSliderView.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(RangesKt.coerceIn(props.getValue(), fMax, fMin));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fCoerceIn = RangesKt.coerceIn(props.getValue(), fMax, fMin);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1028777933, "CC(remember):VerticalSliderView.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(fCoerceIn);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float min2 = props.getMin();
            float max2 = props.getMax();
            int steps = props.getSteps();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1028775442, "CC(remember):VerticalSliderView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(min2) | composerStartRestartGroup.changed(max2) | composerStartRestartGroup.changed(steps);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new SliderState(RangesKt.coerceIn(VerticalSliderContent$lambda$6(mutableFloatState), fMax, fMin), props.getSteps(), null, RangesKt.rangeTo(props.getMin(), props.getMax()), 4, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final SliderState sliderState2 = (SliderState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (fCoerceIn != VerticalSliderContent$lambda$9(mutableFloatState2)) {
                mutableFloatState2.setFloatValue(fCoerceIn);
                if (!sliderState2.isDragging()) {
                    mutableFloatState.setFloatValue(fCoerceIn);
                }
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "thumb");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "track");
            androidx.compose.material3.SliderColors sliderColorsM4694colorsq0g_0yA = SliderDefaults.INSTANCE.m4694colorsq0g_0yA(UtilsKt.getCompose(props.getColors().getThumbColor()), UtilsKt.getCompose(props.getColors().getActiveTrackColor()), UtilsKt.getCompose(props.getColors().getActiveTickColor()), UtilsKt.getCompose(props.getColors().getInactiveTrackColor()), UtilsKt.getCompose(props.getColors().getInactiveTickColor()), 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 992);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1028743611, "CC(remember):VerticalSliderView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sliderState2) | composerStartRestartGroup.changed(fMax) | composerStartRestartGroup.changed(fMin) | composerStartRestartGroup.changedInstance(viewEventDelegate2) | composerStartRestartGroup.changedInstance(viewEventDelegate4);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                Function0 function0 = new Function0() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return VerticalSliderViewKt.VerticalSliderContent$lambda$15$lambda$14(sliderState2, fMax, fMin, mutableFloatState, viewEventDelegate2, viewEventDelegate4);
                    }
                };
                sliderState = sliderState2;
                composerStartRestartGroup.updateRememberedValue(function0);
                objRememberedValue7 = function0;
            } else {
                sliderState = sliderState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue7, composerStartRestartGroup, 0);
            if (slotViewFindChildSlotView != null && slotViewFindChildSlotView2 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825767972);
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@3851L81,105@3948L81,96@3640L422");
                SliderKt.VerticalSlider(sliderState, modifierApplyModifiers, props.getEnabled(), props.getReverseDirection(), sliderColorsM4694colorsq0g_0yA, mutableInteractionSource, ComposableLambdaKt.rememberComposableLambda(1265721992, true, new Function3() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return VerticalSliderViewKt.VerticalSliderContent$lambda$18(slotViewFindChildSlotView, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1438136073, true, new Function3() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return VerticalSliderViewKt.VerticalSliderContent$lambda$21(slotViewFindChildSlotView2, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, SliderState.$stable | 14352384, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (slotViewFindChildSlotView != null) {
                composerStartRestartGroup.startReplaceGroup(-1825321603);
                ComposerKt.sourceInformation(composerStartRestartGroup, "117@4304L81,111@4093L325");
                SliderKt.VerticalSlider(sliderState, modifierApplyModifiers, props.getEnabled(), props.getReverseDirection(), sliderColorsM4694colorsq0g_0yA, mutableInteractionSource, ComposableLambdaKt.rememberComposableLambda(1004514993, true, new Function3() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return VerticalSliderViewKt.VerticalSliderContent$lambda$24(slotViewFindChildSlotView, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), null, composerStartRestartGroup, SliderState.$stable | 1769472, 128);
                composerStartRestartGroup.endReplaceGroup();
            } else if (slotViewFindChildSlotView2 != null) {
                composerStartRestartGroup.startReplaceGroup(-1824968451);
                ComposerKt.sourceInformation(composerStartRestartGroup, "129@4660L81,123@4449L325");
                SliderKt.VerticalSlider(sliderState, modifierApplyModifiers, props.getEnabled(), props.getReverseDirection(), sliderColorsM4694colorsq0g_0yA, mutableInteractionSource, null, ComposableLambdaKt.rememberComposableLambda(1675786001, true, new Function3() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return VerticalSliderViewKt.VerticalSliderContent$lambda$27(slotViewFindChildSlotView2, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, SliderState.$stable | 12779520, 64);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1824635170);
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@4788L228");
                SliderKt.VerticalSlider(sliderState, modifierApplyModifiers, props.getEnabled(), props.getReverseDirection(), sliderColorsM4694colorsq0g_0yA, mutableInteractionSource, null, null, composerStartRestartGroup, SliderState.$stable | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 192);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return VerticalSliderViewKt.VerticalSliderContent$lambda$28(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ViewEventCallback<SliderValueChangedEvent> VerticalSliderContent$lambda$1(ViewEventDelegate<SliderValueChangedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[0]);
    }

    private static final ViewEventCallback<Unit> VerticalSliderContent$lambda$3(ViewEventDelegate<Unit> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[1]);
    }

    private static final float VerticalSliderContent$lambda$6(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    private static final float VerticalSliderContent$lambda$9(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    static final Unit VerticalSliderContent$lambda$15$lambda$14(final SliderState sliderState, final float f, final float f2, final MutableFloatState mutableFloatState, final ViewEventDelegate viewEventDelegate, final ViewEventDelegate viewEventDelegate2) {
        sliderState.setOnValueChange(new Function1() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return VerticalSliderViewKt.VerticalSliderContent$lambda$15$lambda$14$lambda$12(f, f2, sliderState, mutableFloatState, viewEventDelegate, ((Float) obj).floatValue());
            }
        });
        sliderState.setOnValueChangeFinished(new Function0() { // from class: expo.modules.ui.VerticalSliderViewKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return VerticalSliderViewKt.VerticalSliderContent$lambda$15$lambda$14$lambda$13(viewEventDelegate2);
            }
        });
        float fCoerceIn = RangesKt.coerceIn(VerticalSliderContent$lambda$6(mutableFloatState), f, f2);
        if (sliderState.getValue() != fCoerceIn) {
            sliderState.setValue(fCoerceIn);
        }
        return Unit.INSTANCE;
    }

    static final Unit VerticalSliderContent$lambda$15$lambda$14$lambda$12(float f, float f2, SliderState sliderState, MutableFloatState mutableFloatState, ViewEventDelegate viewEventDelegate, float f3) {
        float fCoerceIn = RangesKt.coerceIn(f3, f, f2);
        mutableFloatState.setFloatValue(fCoerceIn);
        sliderState.setValue(fCoerceIn);
        VerticalSliderContent$lambda$1(viewEventDelegate).invoke(new SliderValueChangedEvent(fCoerceIn));
        return Unit.INSTANCE;
    }

    static final Unit VerticalSliderContent$lambda$15$lambda$14$lambda$13(ViewEventDelegate viewEventDelegate) {
        VerticalSliderContent$lambda$3(viewEventDelegate).invoke(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    static final Unit VerticalSliderContent$lambda$18(SlotView slotView, SliderState it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):VerticalSliderView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1265721992, i, -1, "expo.modules.ui.VerticalSliderContent.<anonymous> (VerticalSliderView.kt:103)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(883090793);
            ComposerKt.sourceInformation(composer, "*103@3911L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit VerticalSliderContent$lambda$21(SlotView slotView, SliderState it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):VerticalSliderView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1438136073, i, -1, "expo.modules.ui.VerticalSliderContent.<anonymous> (VerticalSliderView.kt:106)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-930701910);
            ComposerKt.sourceInformation(composer, "*106@4008L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit VerticalSliderContent$lambda$24(SlotView slotView, SliderState it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):VerticalSliderView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1004514993, i, -1, "expo.modules.ui.VerticalSliderContent.<anonymous> (VerticalSliderView.kt:118)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-1028732078);
            ComposerKt.sourceInformation(composer, "*118@4364L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit VerticalSliderContent$lambda$27(SlotView slotView, SliderState it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it):VerticalSliderView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1675786001, i, -1, "expo.modules.ui.VerticalSliderContent.<anonymous> (VerticalSliderView.kt:130)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-182387790);
            ComposerKt.sourceInformation(composer, "*130@4720L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
