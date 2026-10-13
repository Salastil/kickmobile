package expo.modules.ui;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.MultiChoiceSegmentedButtonRowScope;
import androidx.compose.material3.SegmentedButtonDefaults;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SegmentedButtonView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"SegmentedButtonContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SegmentedButtonProps;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "onCheckedChange", "Lkotlin/Function1;", "Lexpo/modules/ui/GenericEventPayload1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SegmentedButtonProps;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SegmentedButtonViewKt {
    static final Unit SegmentedButtonContent$lambda$4(FunctionalComposableScope functionalComposableScope, SegmentedButtonProps segmentedButtonProps, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        SegmentedButtonContent(functionalComposableScope, segmentedButtonProps, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButtonContent$lambda$9(FunctionalComposableScope functionalComposableScope, SegmentedButtonProps segmentedButtonProps, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        SegmentedButtonContent(functionalComposableScope, segmentedButtonProps, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SegmentedButtonContent(final FunctionalComposableScope functionalComposableScope, final SegmentedButtonProps props, final Function0<Unit> onClick, final Function1<? super GenericEventPayload1<Boolean>, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        ComposableLambda composableLambdaRememberComposableLambda;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-148025820);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SegmentedButtonContent)N(props,onClick,onCheckedChange)55@2112L858,70@3010L39,71@3084L83:SegmentedButtonView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-148025820, i2, -1, "expo.modules.ui.SegmentedButtonContent (SegmentedButtonView.kt:48)");
            }
            SegmentedButtonColors colors = props.getColors();
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "label");
            ViewParent parent = functionalComposableScope.getView().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            int iIndexOfChild = viewGroup != null ? viewGroup.indexOfChild(functionalComposableScope.getView()) : 0;
            int childCount = viewGroup != null ? viewGroup.getChildCount() : 1;
            int i3 = i2;
            SegmentedButtonDefaults segmentedButtonDefaults = SegmentedButtonDefaults.INSTANCE;
            long compose = UtilsKt.getCompose(colors.getActiveBorderColor());
            androidx.compose.material3.SegmentedButtonColors segmentedButtonColorsM4619colorsXqyqHi0 = segmentedButtonDefaults.m4619colorsXqyqHi0(UtilsKt.getCompose(colors.getActiveContainerColor()), UtilsKt.getCompose(colors.getActiveContentColor()), compose, UtilsKt.getCompose(colors.getInactiveContainerColor()), UtilsKt.getCompose(colors.getInactiveContentColor()), UtilsKt.getCompose(colors.getInactiveBorderColor()), UtilsKt.getCompose(colors.getDisabledActiveContainerColor()), UtilsKt.getCompose(colors.getDisabledActiveContentColor()), UtilsKt.getCompose(colors.getDisabledActiveBorderColor()), UtilsKt.getCompose(colors.getDisabledInactiveContainerColor()), UtilsKt.getCompose(colors.getDisabledInactiveContentColor()), UtilsKt.getCompose(colors.getDisabledInactiveBorderColor()), composerStartRestartGroup, 0, 384, 0);
            Shape shapeItemShape = SegmentedButtonDefaults.INSTANCE.itemShape(iIndexOfChild, childCount, null, composerStartRestartGroup, 3072, 4);
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            composerStartRestartGroup = composerStartRestartGroup;
            if (slotViewFindChildSlotView == null) {
                composerStartRestartGroup.startReplaceGroup(1095749453);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1095749454);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*73@3231L98");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(314958992, true, new Function2() { // from class: expo.modules.ui.SegmentedButtonViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SegmentedButtonViewKt.SegmentedButtonContent$lambda$3$lambda$2(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (composableLambdaRememberComposableLambda == null) {
                composableLambdaRememberComposableLambda = ComposableSingletons$SegmentedButtonViewKt.INSTANCE.getLambda$1431986096$expo_ui_release();
            }
            Function2<Composer, Integer, Unit> function3 = composableLambdaRememberComposableLambda;
            RowScope rowScope = UIComposableScopeKt.getRowScope(functionalComposableScope.getComposableScope());
            SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope = rowScope instanceof SingleChoiceSegmentedButtonRowScope ? (SingleChoiceSegmentedButtonRowScope) rowScope : null;
            RowScope rowScope2 = UIComposableScopeKt.getRowScope(functionalComposableScope.getComposableScope());
            MultiChoiceSegmentedButtonRowScope multiChoiceSegmentedButtonRowScope = rowScope2 instanceof MultiChoiceSegmentedButtonRowScope ? (MultiChoiceSegmentedButtonRowScope) rowScope2 : null;
            if (singleChoiceSegmentedButtonRowScope == null && multiChoiceSegmentedButtonRowScope == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: expo.modules.ui.SegmentedButtonViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SegmentedButtonViewKt.SegmentedButtonContent$lambda$4(functionalComposableScope, props, onClick, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                if (singleChoiceSegmentedButtonRowScope != null) {
                    composerStartRestartGroup.startReplaceGroup(1096326705);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*94@3830L227");
                    SegmentedButtonKt.SegmentedButton(singleChoiceSegmentedButtonRowScope, props.getSelected(), onClick, shapeItemShape, modifierApplyModifiers, props.getEnabled(), segmentedButtonColorsM4619colorsXqyqHi0, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) null, function3, composerStartRestartGroup, i3 & 896, 0, 960);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (multiChoiceSegmentedButtonRowScope != null) {
                        composerStartRestartGroup.startReplaceGroup(1096624646);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*108@4204L45,106@4128L271");
                        boolean checked = props.getChecked();
                        boolean enabled = props.getEnabled();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1412501488, "CC(remember):SegmentedButtonView.kt#9igjgp");
                        boolean z = (i3 & 7168) == 2048;
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: expo.modules.ui.SegmentedButtonViewKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return SegmentedButtonViewKt.SegmentedButtonContent$lambda$8$lambda$7$lambda$6(onCheckedChange, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        SegmentedButtonKt.SegmentedButton(multiChoiceSegmentedButtonRowScope, checked, (Function1<? super Boolean, Unit>) objRememberedValue, shapeItemShape, modifierApplyModifiers, enabled, segmentedButtonColorsM4619colorsXqyqHi0, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) null, function3, composerStartRestartGroup, 0, 0, 960);
                        composerStartRestartGroup = composerStartRestartGroup;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1092549758);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: expo.modules.ui.SegmentedButtonViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedButtonViewKt.SegmentedButtonContent$lambda$9(functionalComposableScope, props, onClick, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final Unit SegmentedButtonContent$lambda$3$lambda$2(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:SegmentedButtonView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(314958992, i, -1, "expo.modules.ui.SegmentedButtonContent.<anonymous>.<anonymous> (SegmentedButtonView.kt:74)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(2027882040);
            ComposerKt.sourceInformation(composer, "*76@3296L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit SegmentedButtonContent$lambda$8$lambda$7$lambda$6(Function1 function1, boolean z) {
        function1.invoke(new GenericEventPayload1(Boolean.valueOf(z)));
        return Unit.INSTANCE;
    }
}
