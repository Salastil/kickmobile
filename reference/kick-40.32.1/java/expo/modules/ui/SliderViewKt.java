package expo.modules.ui;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
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
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006²\u0006\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u008a\u0084\u0002²\u0006\u0010\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u008a\u0084\u0002²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"SliderContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SliderProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SliderProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release", "onValueChange", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/ui/SliderValueChangedEvent;", "onValueChangeFinished", "localValue", "", "isDragging", "", "prevPropsValue"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SliderViewKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(SliderViewKt.class, "onValueChange", "<v#0>", 1)), Reflection.property0(new PropertyReference0Impl(SliderViewKt.class, "onValueChangeFinished", "<v#1>", 1))};

    static final Unit SliderContent$lambda$24(FunctionalComposableScope functionalComposableScope, SliderProps sliderProps, int i, Composer composer, int i2) {
        SliderContent(functionalComposableScope, sliderProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SliderContent(final FunctionalComposableScope functionalComposableScope, SliderProps sliderProps, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final MutableState mutableState;
        final SliderProps props = sliderProps;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(347902402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderContent)N(props)60@1747L74,61@1853L55,62@1935L39,67@2167L86,68@2274L34,70@2412L51,82@2767L312,129@4236L83,96@3271L176,102@3477L66,107@3584L308,118@3906L296,90@3083L1240:SliderView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(347902402, i2, -1, "expo.modules.ui.SliderContent (SliderView.kt:59)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673236180, "CC(remember):SliderView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                ViewEventDelegate viewEventDelegate = new ViewEventDelegate(functionalComposableScope.getView(), null);
                composerStartRestartGroup.updateRememberedValue(viewEventDelegate);
                objRememberedValue = viewEventDelegate;
            }
            final ViewEventDelegate viewEventDelegate2 = (ViewEventDelegate) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673232807, "CC(remember):SliderView.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                ViewEventDelegate viewEventDelegate3 = new ViewEventDelegate(functionalComposableScope.getView(), null);
                composerStartRestartGroup.updateRememberedValue(viewEventDelegate3);
                objRememberedValue2 = viewEventDelegate3;
            }
            final ViewEventDelegate viewEventDelegate4 = (ViewEventDelegate) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673230199, "CC(remember):SliderView.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float min = props.getMin();
            Float lowerLimit = props.getLowerLimit();
            final float fMax = Math.max(min, lowerLimit != null ? lowerLimit.floatValue() : Float.NEGATIVE_INFINITY);
            float max = props.getMax();
            Float upperLimit = props.getUpperLimit();
            final float fMin = Math.min(max, upperLimit != null ? upperLimit.floatValue() : Float.POSITIVE_INFINITY);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673222728, "CC(remember):SliderView.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(RangesKt.coerceIn(props.getValue(), fMax, fMin));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673219356, "CC(remember):SliderView.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fCoerceIn = RangesKt.coerceIn(props.getValue(), fMax, fMin);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673214923, "CC(remember):SliderView.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = PrimitiveSnapshotStateKt.mutableFloatStateOf(fCoerceIn);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (fCoerceIn != SliderContent$lambda$12(mutableFloatState2)) {
                mutableFloatState2.setFloatValue(fCoerceIn);
                if (!SliderContent$lambda$9(mutableState2)) {
                    mutableFloatState.setFloatValue(fCoerceIn);
                }
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "thumb");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "track");
            final androidx.compose.material3.SliderColors sliderColorsM4694colorsq0g_0yA = SliderDefaults.INSTANCE.m4694colorsq0g_0yA(UtilsKt.getCompose(props.getColors().getThumbColor()), UtilsKt.getCompose(props.getColors().getActiveTrackColor()), UtilsKt.getCompose(props.getColors().getActiveTickColor()), UtilsKt.getCompose(props.getColors().getInactiveTrackColor()), UtilsKt.getCompose(props.getColors().getInactiveTickColor()), 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 992);
            float fSliderContent$lambda$6 = SliderContent$lambda$6(mutableFloatState);
            ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo = RangesKt.rangeTo(sliderProps.getMin(), sliderProps.getMax());
            int steps = sliderProps.getSteps();
            boolean enabled = sliderProps.getEnabled();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(sliderProps.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673187310, "CC(remember):SliderView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(fMax) | composerStartRestartGroup.changed(fMin) | composerStartRestartGroup.changedInstance(viewEventDelegate2);
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: expo.modules.ui.SliderViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderViewKt.SliderContent$lambda$15$lambda$14(fMax, fMin, mutableState2, mutableFloatState, viewEventDelegate2, ((Float) obj).floatValue());
                    }
                };
                mutableState = mutableState2;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                mutableState = mutableState2;
            }
            Function1 function1 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -673180828, "CC(remember):SliderView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(viewEventDelegate4);
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: expo.modules.ui.SliderViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SliderViewKt.SliderContent$lambda$17$lambda$16(mutableState, viewEventDelegate4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            props = sliderProps;
            SliderKt.Slider(fSliderContent$lambda$6, function1, modifierApplyModifiers, enabled, (Function0) objRememberedValue8, sliderColorsM4694colorsq0g_0yA, mutableInteractionSource, steps, ComposableLambdaKt.rememberComposableLambda(-1003691522, true, new Function3() { // from class: expo.modules.ui.SliderViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SliderViewKt.SliderContent$lambda$20(slotViewFindChildSlotView, mutableInteractionSource, sliderColorsM4694colorsq0g_0yA, props, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(2007364607, true, new Function3() { // from class: expo.modules.ui.SliderViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SliderViewKt.SliderContent$lambda$23(slotViewFindChildSlotView2, props, sliderColorsM4694colorsq0g_0yA, (SliderState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), closedFloatingPointRangeRangeTo, composerStartRestartGroup, 907542528, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SliderViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderViewKt.SliderContent$lambda$24(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ViewEventCallback<SliderValueChangedEvent> SliderContent$lambda$1(ViewEventDelegate<SliderValueChangedEvent> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[0]);
    }

    private static final ViewEventCallback<Unit> SliderContent$lambda$3(ViewEventDelegate<Unit> viewEventDelegate) {
        return viewEventDelegate.getValue($$delegatedProperties[1]);
    }

    private static final float SliderContent$lambda$6(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    private static final void SliderContent$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean SliderContent$lambda$9(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final float SliderContent$lambda$12(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    static final Unit SliderContent$lambda$15$lambda$14(float f, float f2, MutableState mutableState, MutableFloatState mutableFloatState, ViewEventDelegate viewEventDelegate, float f3) {
        float fCoerceIn = RangesKt.coerceIn(f3, f, f2);
        SliderContent$lambda$10(mutableState, true);
        mutableFloatState.setFloatValue(fCoerceIn);
        SliderContent$lambda$1(viewEventDelegate).invoke(new SliderValueChangedEvent(fCoerceIn));
        return Unit.INSTANCE;
    }

    static final Unit SliderContent$lambda$17$lambda$16(MutableState mutableState, ViewEventDelegate viewEventDelegate) {
        SliderContent$lambda$10(mutableState, false);
        SliderContent$lambda$3(viewEventDelegate).invoke(Unit.INSTANCE);
        return Unit.INSTANCE;
    }

    static final Unit SliderContent$lambda$20(SlotView slotView, MutableInteractionSource mutableInteractionSource, androidx.compose.material3.SliderColors sliderColors, SliderProps sliderProps, SliderState sliderState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(sliderState, "sliderState");
        ComposerKt.sourceInformation(composer, "CN(sliderState):SliderView.kt#v15e7d");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003691522, i, -1, "expo.modules.ui.SliderContent.<anonymous> (SliderView.kt:108)");
            }
            if (slotView != null) {
                composer.startReplaceGroup(588234963);
                ComposerKt.sourceInformation(composer, "");
                UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
                composer.startReplaceGroup(1820091807);
                ComposerKt.sourceInformation(composer, "*109@3694L9");
                slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
                composer.endReplaceGroup();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(588323871);
                ComposerKt.sourceInformation(composer, "111@3746L132");
                SliderDefaults.INSTANCE.m4688Thumb9LiSoMs(mutableInteractionSource, null, sliderColors, sliderProps.getEnabled(), 0L, composer, 196614, 18);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit SliderContent$lambda$23(SlotView slotView, SliderProps sliderProps, androidx.compose.material3.SliderColors sliderColors, SliderState sliderState, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(sliderState, "sliderState");
        ComposerKt.sourceInformation(composer, "CN(sliderState):SliderView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(sliderState) : composer.changedInstance(sliderState) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007364607, i2, -1, "expo.modules.ui.SliderContent.<anonymous> (SliderView.kt:119)");
            }
            if (slotView != null) {
                composer.startReplaceGroup(-1725570254);
                ComposerKt.sourceInformation(composer, "");
                UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
                composer.startReplaceGroup(637074272);
                ComposerKt.sourceInformation(composer, "*120@4016L9");
                slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
                composer.endReplaceGroup();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1725481718);
                ComposerKt.sourceInformation(composer, "122@4068L120");
                SliderDefaults.INSTANCE.m4691Track4EFweAY(sliderState, (Modifier) null, sliderProps.getEnabled(), sliderColors, (Function2<? super DrawScope, ? super Offset, Unit>) null, (Function3<? super DrawScope, ? super Offset, ? super Color, Unit>) null, 0.0f, 0.0f, composer, 100663296 | SliderState.$stable | (i2 & 14), 242);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
