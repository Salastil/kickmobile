package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.AssistChipDefaults;
import androidx.compose.material3.ChipColors;
import androidx.compose.material3.ChipElevation;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FilterChipDefaults;
import androidx.compose.material3.InputChipDefaults;
import androidx.compose.material3.SelectableChipColors;
import androidx.compose.material3.SelectableChipElevation;
import androidx.compose.material3.SuggestionChipDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
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

/* JADX INFO: compiled from: ChipView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fH\u0007¢\u0006\u0002\u0010\u000e\u001a-\u0010\u000f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\t\u001a\u00020\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fH\u0007¢\u0006\u0002\u0010\u0011\u001a-\u0010\u0012\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\t\u001a\u00020\u00132\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fH\u0007¢\u0006\u0002\u0010\u0014\u001a-\u0010\u0015\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\t\u001a\u00020\u00162\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fH\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"slotContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "slotName", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Ljava/lang/String;)Lkotlin/jvm/functions/Function2;", "AssistChipContent", "props", "Lexpo/modules/ui/AssistChipProps;", "onPress", "Lkotlin/Function1;", "Lexpo/modules/ui/ChipPressedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/AssistChipProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FilterChipContent", "Lexpo/modules/ui/FilterChipProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/FilterChipProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "InputChipContent", "Lexpo/modules/ui/InputChipProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/InputChipProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SuggestionChipContent", "Lexpo/modules/ui/SuggestionChipProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SuggestionChipProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChipViewKt {
    static final Unit AssistChipContent$lambda$6(FunctionalComposableScope functionalComposableScope, AssistChipProps assistChipProps, Function1 function1, int i, Composer composer, int i2) {
        AssistChipContent(functionalComposableScope, assistChipProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit FilterChipContent$lambda$9(FunctionalComposableScope functionalComposableScope, FilterChipProps filterChipProps, Function1 function1, int i, Composer composer, int i2) {
        FilterChipContent(functionalComposableScope, filterChipProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit InputChipContent$lambda$12(FunctionalComposableScope functionalComposableScope, InputChipProps inputChipProps, Function1 function1, int i, Composer composer, int i2) {
        InputChipContent(functionalComposableScope, inputChipProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SuggestionChipContent$lambda$15(FunctionalComposableScope functionalComposableScope, SuggestionChipProps suggestionChipProps, Function1 function1, int i, Composer composer, int i2) {
        SuggestionChipContent(functionalComposableScope, suggestionChipProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final Function2<Composer, Integer, Unit> slotContent(FunctionalComposableScope functionalComposableScope, String str) {
        final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), str);
        if (slotViewFindChildSlotView != null) {
            return ComposableLambdaKt.composableLambdaInstance(-672806421, true, new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.slotContent$lambda$3$lambda$2(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
        return null;
    }

    static final Unit slotContent$lambda$3$lambda$2(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ChipView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-672806421, i, -1, "expo.modules.ui.slotContent.<anonymous>.<anonymous> (ChipView.kt:93)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(1973092569);
            ComposerKt.sourceInformation(composer, "*95@2688L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void AssistChipContent(final FunctionalComposableScope functionalComposableScope, final AssistChipProps props, final Function1<? super ChipPressedEvent, Unit> onPress, Composer composer, final int i) {
        int i2;
        ChipElevation chipElevationM3497assistChipElevationaqJV_2Y;
        BorderStroke borderStrokeM3495assistChipBorderh1eTWw;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Composer composerStartRestartGroup = composer.startRestartGroup(-814404900);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AssistChipContent)N(props,onPress)118@3177L83,120@3296L418,145@4317L31,144@4291L318:ChipView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPress) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-814404900, i3, -1, "expo.modules.ui.AssistChipContent (ChipView.kt:117)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            AssistChipDefaults assistChipDefaults = AssistChipDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getLabelColor());
            long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getColors().getLeadingIconContentColor());
            long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull4 = UtilsKt.getComposeOrNull(props.getColors().getTrailingIconContentColor());
            ChipColors chipColorsM3496assistChipColorsoq7We08 = assistChipDefaults.m3496assistChipColorsoq7We08(jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU(), 0L, 0L, 0L, 0L, composerStartRestartGroup, AssistChipDefaults.$stable << 24, 240);
            if (props.getElevation() != null) {
                composerStartRestartGroup.startReplaceGroup(334624694);
                ComposerKt.sourceInformation(composerStartRestartGroup, "128@3788L51");
                chipElevationM3497assistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m3497assistChipElevationaqJV_2Y(Dp.m10168constructorimpl(props.getElevation().floatValue()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, AssistChipDefaults.$stable << 18, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(334709076);
                ComposerKt.sourceInformation(composerStartRestartGroup, "130@3874L21");
                chipElevationM3497assistChipElevationaqJV_2Y = AssistChipDefaults.INSTANCE.m3497assistChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, AssistChipDefaults.$stable << 18, 63);
                composerStartRestartGroup.endReplaceGroup();
            }
            ChipElevation chipElevation = chipElevationM3497assistChipElevationaqJV_2Y;
            if (props.getBorder() != null) {
                composerStartRestartGroup.startReplaceGroup(334808121);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                Color composeOrNull5 = UtilsKt.getComposeOrNull(props.getBorder().getColor());
                if (composeOrNull5 != null) {
                    composerStartRestartGroup.startReplaceGroup(334887016);
                    composerStartRestartGroup.endReplaceGroup();
                    borderStrokeM3495assistChipBorderh1eTWw = BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(props.getBorder().getWidth()), composeOrNull5.m7348unboximpl());
                } else {
                    composerStartRestartGroup.startReplaceGroup(334955991);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@4123L78");
                    borderStrokeM3495assistChipBorderh1eTWw = AssistChipDefaults.INSTANCE.m3495assistChipBorderh1eTWw(props.getEnabled(), 0L, 0L, Dp.m10168constructorimpl(props.getBorder().getWidth()), composerStartRestartGroup, AssistChipDefaults.$stable << 12, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(335074752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "141@4242L41");
                borderStrokeM3495assistChipBorderh1eTWw = AssistChipDefaults.INSTANCE.m3495assistChipBorderh1eTWw(props.getEnabled(), 0L, 0L, 0.0f, composerStartRestartGroup, AssistChipDefaults.$stable << 12, 14);
                composerStartRestartGroup.endReplaceGroup();
            }
            BorderStroke borderStroke = borderStrokeM3495assistChipBorderh1eTWw;
            Function2<Composer, Integer, Unit> function2SlotContent = slotContent(functionalComposableScope, "label");
            if (function2SlotContent == null) {
                function2SlotContent = ComposableSingletons$ChipViewKt.INSTANCE.getLambda$778385937$expo_ui_release();
            }
            Function2<Composer, Integer, Unit> function2 = function2SlotContent;
            Function2<Composer, Integer, Unit> function2SlotContent2 = slotContent(functionalComposableScope, "leadingIcon");
            Function2<Composer, Integer, Unit> function2SlotContent3 = slotContent(functionalComposableScope, "trailingIcon");
            boolean enabled = props.getEnabled();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -959019301, "CC(remember):ChipView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChipViewKt.AssistChipContent$lambda$5$lambda$4(onPress);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ChipKt.AssistChip((Function0) objRememberedValue, function2, modifierApplyModifiers, enabled, function2SlotContent2, function2SlotContent3, null, chipColorsM3496assistChipColorsoq7We08, chipElevation, borderStroke, null, null, null, composerStartRestartGroup, 0, 0, 7232);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.AssistChipContent$lambda$6(functionalComposableScope, props, onPress, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit AssistChipContent$lambda$5$lambda$4(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }

    public static final void FilterChipContent(final FunctionalComposableScope functionalComposableScope, final FilterChipProps props, final Function1<? super ChipPressedEvent, Unit> onPress, Composer composer, final int i) {
        int i2;
        SelectableChipElevation selectableChipElevationM3971filterChipElevationaqJV_2Y;
        BorderStroke borderStrokeM3969filterChipBorder_7El2pE;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Composer composerStartRestartGroup = composer.startRestartGroup(-95315138);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterChipContent)N(props,onPress)176@5108L83,178@5227L712,207@6627L31,205@6570L349:ChipView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPress) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-95315138, i3, -1, "expo.modules.ui.FilterChipContent (ChipView.kt:175)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            FilterChipDefaults filterChipDefaults = FilterChipDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getLabelColor());
            long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getColors().getIconColor());
            long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull4 = UtilsKt.getComposeOrNull(props.getColors().getSelectedContainerColor());
            long jM7348unboximpl4 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull5 = UtilsKt.getComposeOrNull(props.getColors().getSelectedLabelColor());
            long jM7348unboximpl5 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull6 = UtilsKt.getComposeOrNull(props.getColors().getSelectedLeadingIconColor());
            long jM7348unboximpl6 = composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull7 = UtilsKt.getComposeOrNull(props.getColors().getSelectedTrailingIconColor());
            SelectableChipColors selectableChipColorsM3970filterChipColorsXqyqHi0 = filterChipDefaults.m3970filterChipColorsXqyqHi0(jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, 0L, 0L, 0L, 0L, jM7348unboximpl4, 0L, jM7348unboximpl5, jM7348unboximpl6, composeOrNull7 != null ? composeOrNull7.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU(), composerStartRestartGroup, 0, FilterChipDefaults.$stable << 6, 376);
            Composer composer2 = composerStartRestartGroup;
            if (props.getElevation() != null) {
                composer2.startReplaceGroup(-558856364);
                ComposerKt.sourceInformation(composer2, "189@6013L51");
                selectableChipElevationM3971filterChipElevationaqJV_2Y = FilterChipDefaults.INSTANCE.m3971filterChipElevationaqJV_2Y(Dp.m10168constructorimpl(props.getElevation().floatValue()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, FilterChipDefaults.$stable << 18, 62);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-558771982);
                ComposerKt.sourceInformation(composer2, "191@6099L21");
                selectableChipElevationM3971filterChipElevationaqJV_2Y = FilterChipDefaults.INSTANCE.m3971filterChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, FilterChipDefaults.$stable << 18, 63);
                composer2.endReplaceGroup();
            }
            SelectableChipElevation selectableChipElevation = selectableChipElevationM3971filterChipElevationaqJV_2Y;
            if (props.getBorder() != null) {
                composer2.startReplaceGroup(-558672100);
                ComposerKt.sourceInformation(composer2, "");
                Color composeOrNull8 = UtilsKt.getComposeOrNull(props.getBorder().getColor());
                if (composeOrNull8 != null) {
                    composer2.startReplaceGroup(-558594042);
                    composer2.endReplaceGroup();
                    borderStrokeM3969filterChipBorder_7El2pE = BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(props.getBorder().getWidth()), composeOrNull8.m7348unboximpl());
                } else {
                    composer2.startReplaceGroup(-558524230);
                    ComposerKt.sourceInformation(composer2, "199@6348L105");
                    borderStrokeM3969filterChipBorder_7El2pE = FilterChipDefaults.INSTANCE.m3969filterChipBorder_7El2pE(props.getEnabled(), props.getSelected(), 0L, 0L, 0L, 0L, Dp.m10168constructorimpl(props.getBorder().getWidth()), 0.0f, composer2, FilterChipDefaults.$stable << 24, 188);
                    composer2 = composer2;
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-558378685);
                ComposerKt.sourceInformation(composer2, "202@6494L68");
                borderStrokeM3969filterChipBorder_7El2pE = FilterChipDefaults.INSTANCE.m3969filterChipBorder_7El2pE(props.getEnabled(), props.getSelected(), 0L, 0L, 0L, 0L, 0.0f, 0.0f, composer2, FilterChipDefaults.$stable << 24, 252);
                composer2 = composer2;
                composer2.endReplaceGroup();
            }
            BorderStroke borderStroke = borderStrokeM3969filterChipBorder_7El2pE;
            boolean selected = props.getSelected();
            Function2<Composer, Integer, Unit> function2SlotContent = slotContent(functionalComposableScope, "label");
            if (function2SlotContent == null) {
                function2SlotContent = ComposableSingletons$ChipViewKt.INSTANCE.m12094getLambda$1073824393$expo_ui_release();
            }
            Function2<Composer, Integer, Unit> function2 = function2SlotContent;
            Function2<Composer, Integer, Unit> function2SlotContent2 = slotContent(functionalComposableScope, "leadingIcon");
            Function2<Composer, Integer, Unit> function2SlotContent3 = slotContent(functionalComposableScope, "trailingIcon");
            boolean enabled = props.getEnabled();
            ComposerKt.sourceInformationMarkerStart(composer2, -1403480547, "CC(remember):ChipView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composer2.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChipViewKt.FilterChipContent$lambda$8$lambda$7(onPress);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Composer composer3 = composer2;
            ChipKt.FilterChip(selected, (Function0) objRememberedValue, function2, modifierApplyModifiers, enabled, function2SlotContent2, function2SlotContent3, null, selectableChipColorsM3970filterChipColorsXqyqHi0, selectableChipElevation, borderStroke, null, null, null, composer3, 0, 0, 14464);
            composerStartRestartGroup = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.FilterChipContent$lambda$9(functionalComposableScope, props, onPress, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit FilterChipContent$lambda$8$lambda$7(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }

    public static final void InputChipContent(final FunctionalComposableScope functionalComposableScope, final InputChipProps props, final Function1<? super ChipPressedEvent, Unit> onPress, Composer composer, final int i) {
        int i2;
        SelectableChipElevation selectableChipElevationM4178inputChipElevationaqJV_2Y;
        BorderStroke borderStrokeM4176inputChipBorder_7El2pE;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Composer composerStartRestartGroup = composer.startRestartGroup(1618033924);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InputChipContent)N(props,onPress)239@7452L83,241@7570L823,270@9041L31,269@9016L338:ChipView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPress) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1618033924, i3, -1, "expo.modules.ui.InputChipContent (ChipView.kt:238)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            InputChipDefaults inputChipDefaults = InputChipDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getLabelColor());
            long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getColors().getLeadingIconColor());
            long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull4 = UtilsKt.getComposeOrNull(props.getColors().getTrailingIconColor());
            long jM7348unboximpl4 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull5 = UtilsKt.getComposeOrNull(props.getColors().getSelectedContainerColor());
            long jM7348unboximpl5 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull6 = UtilsKt.getComposeOrNull(props.getColors().getSelectedLabelColor());
            long jM7348unboximpl6 = composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull7 = UtilsKt.getComposeOrNull(props.getColors().getSelectedLeadingIconColor());
            long jM7348unboximpl7 = composeOrNull7 != null ? composeOrNull7.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull8 = UtilsKt.getComposeOrNull(props.getColors().getSelectedTrailingIconColor());
            SelectableChipColors selectableChipColorsM4177inputChipColorskwJvTHA = inputChipDefaults.m4177inputChipColorskwJvTHA(jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, jM7348unboximpl4, 0L, 0L, 0L, 0L, jM7348unboximpl5, 0L, jM7348unboximpl6, jM7348unboximpl7, composeOrNull8 != null ? composeOrNull8.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU(), composerStartRestartGroup, 0, InputChipDefaults.$stable << 9, 752);
            Composer composer2 = composerStartRestartGroup;
            if (props.getElevation() != null) {
                composer2.startReplaceGroup(431850768);
                ComposerKt.sourceInformation(composer2, "253@8466L50");
                selectableChipElevationM4178inputChipElevationaqJV_2Y = InputChipDefaults.INSTANCE.m4178inputChipElevationaqJV_2Y(Dp.m10168constructorimpl(props.getElevation().floatValue()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, InputChipDefaults.$stable << 18, 62);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(431933166);
                ComposerKt.sourceInformation(composer2, "255@8550L20");
                selectableChipElevationM4178inputChipElevationaqJV_2Y = InputChipDefaults.INSTANCE.m4178inputChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer2, InputChipDefaults.$stable << 18, 63);
                composer2.endReplaceGroup();
            }
            SelectableChipElevation selectableChipElevation = selectableChipElevationM4178inputChipElevationaqJV_2Y;
            if (props.getBorder() != null) {
                composer2.startReplaceGroup(432031064);
                ComposerKt.sourceInformation(composer2, "");
                Color composeOrNull9 = UtilsKt.getComposeOrNull(props.getBorder().getColor());
                if (composeOrNull9 != null) {
                    composer2.startReplaceGroup(432109184);
                    composer2.endReplaceGroup();
                    borderStrokeM4176inputChipBorder_7El2pE = BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(props.getBorder().getWidth()), composeOrNull9.m7348unboximpl());
                } else {
                    composer2.startReplaceGroup(432178934);
                    ComposerKt.sourceInformation(composer2, "263@8797L104");
                    borderStrokeM4176inputChipBorder_7El2pE = InputChipDefaults.INSTANCE.m4176inputChipBorder_7El2pE(props.getEnabled(), props.getSelected(), 0L, 0L, 0L, 0L, Dp.m10168constructorimpl(props.getBorder().getWidth()), 0.0f, composer2, InputChipDefaults.$stable << 24, 188);
                    composer2 = composer2;
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(432322495);
                ComposerKt.sourceInformation(composer2, "266@8941L67");
                borderStrokeM4176inputChipBorder_7El2pE = InputChipDefaults.INSTANCE.m4176inputChipBorder_7El2pE(props.getEnabled(), props.getSelected(), 0L, 0L, 0L, 0L, 0.0f, 0.0f, composer2, InputChipDefaults.$stable << 24, 252);
                composer2 = composer2;
                composer2.endReplaceGroup();
            }
            BorderStroke borderStroke = borderStrokeM4176inputChipBorder_7El2pE;
            Function2<Composer, Integer, Unit> function2SlotContent = slotContent(functionalComposableScope, "label");
            if (function2SlotContent == null) {
                function2SlotContent = ComposableSingletons$ChipViewKt.INSTANCE.getLambda$289642877$expo_ui_release();
            }
            Function2<Composer, Integer, Unit> function2 = function2SlotContent;
            boolean enabled = props.getEnabled();
            boolean selected = props.getSelected();
            Function2<Composer, Integer, Unit> function2SlotContent2 = slotContent(functionalComposableScope, "avatar");
            Function2<Composer, Integer, Unit> function2SlotContent3 = slotContent(functionalComposableScope, "trailingIcon");
            ComposerKt.sourceInformationMarkerStart(composer2, 152497123, "CC(remember):ChipView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composer2.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChipViewKt.InputChipContent$lambda$11$lambda$10(onPress);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Composer composer3 = composer2;
            ChipKt.InputChip(selected, (Function0) objRememberedValue, function2, modifierApplyModifiers, enabled, null, function2SlotContent2, function2SlotContent3, null, selectableChipColorsM4177inputChipColorskwJvTHA, selectableChipElevation, borderStroke, null, null, null, composer3, 0, 0, 28960);
            composerStartRestartGroup = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.InputChipContent$lambda$12(functionalComposableScope, props, onPress, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit InputChipContent$lambda$11$lambda$10(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }

    public static final void SuggestionChipContent(final FunctionalComposableScope functionalComposableScope, final SuggestionChipProps props, final Function1<? super ChipPressedEvent, Unit> onPress, Composer composer, final int i) {
        int i2;
        ChipElevation chipElevationM4778suggestionChipElevationaqJV_2Y;
        BorderStroke borderStrokeM4776suggestionChipBorderh1eTWw;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onPress, "onPress");
        Composer composerStartRestartGroup = composer.startRestartGroup(672669606);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SuggestionChipContent)N(props,onPress)301@9844L83,303@9967L296,327@10902L31,326@10872L260:ChipView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPress) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(672669606, i3, -1, "expo.modules.ui.SuggestionChipContent (ChipView.kt:300)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            SuggestionChipDefaults suggestionChipDefaults = SuggestionChipDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getLabelColor());
            long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
            Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getColors().getIconContentColor());
            ChipColors chipColorsM4777suggestionChipColors5tl4gsc = suggestionChipDefaults.m4777suggestionChipColors5tl4gsc(jM7348unboximpl, jM7348unboximpl2, composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU(), 0L, 0L, 0L, composerStartRestartGroup, SuggestionChipDefaults.$stable << 18, 56);
            if (props.getElevation() != null) {
                composerStartRestartGroup.startReplaceGroup(-816534172);
                ComposerKt.sourceInformation(composerStartRestartGroup, "310@10341L55");
                chipElevationM4778suggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m4778suggestionChipElevationaqJV_2Y(Dp.m10168constructorimpl(props.getElevation().floatValue()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, SuggestionChipDefaults.$stable << 18, 62);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-816441854);
                ComposerKt.sourceInformation(composerStartRestartGroup, "312@10435L25");
                chipElevationM4778suggestionChipElevationaqJV_2Y = SuggestionChipDefaults.INSTANCE.m4778suggestionChipElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, SuggestionChipDefaults.$stable << 18, 63);
                composerStartRestartGroup.endReplaceGroup();
            }
            ChipElevation chipElevation = chipElevationM4778suggestionChipElevationaqJV_2Y;
            if (props.getBorder() != null) {
                composerStartRestartGroup.startReplaceGroup(-816334873);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                Color composeOrNull4 = UtilsKt.getComposeOrNull(props.getBorder().getColor());
                if (composeOrNull4 != null) {
                    composerStartRestartGroup.startReplaceGroup(-816256226);
                    composerStartRestartGroup.endReplaceGroup();
                    borderStrokeM4776suggestionChipBorderh1eTWw = BorderStrokeKt.m1584BorderStrokecXLIe8U(Dp.m10168constructorimpl(props.getBorder().getWidth()), composeOrNull4.m7348unboximpl());
                } else {
                    composerStartRestartGroup.startReplaceGroup(-816187003);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "320@10692L82");
                    borderStrokeM4776suggestionChipBorderh1eTWw = SuggestionChipDefaults.INSTANCE.m4776suggestionChipBorderh1eTWw(props.getEnabled(), 0L, 0L, Dp.m10168constructorimpl(props.getBorder().getWidth()), composerStartRestartGroup, SuggestionChipDefaults.$stable << 12, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-816060306);
                ComposerKt.sourceInformation(composerStartRestartGroup, "323@10819L45");
                borderStrokeM4776suggestionChipBorderh1eTWw = SuggestionChipDefaults.INSTANCE.m4776suggestionChipBorderh1eTWw(props.getEnabled(), 0L, 0L, 0.0f, composerStartRestartGroup, SuggestionChipDefaults.$stable << 12, 14);
                composerStartRestartGroup.endReplaceGroup();
            }
            BorderStroke borderStroke = borderStrokeM4776suggestionChipBorderh1eTWw;
            Function2<Composer, Integer, Unit> function2SlotContent = slotContent(functionalComposableScope, "label");
            if (function2SlotContent == null) {
                function2SlotContent = ComposableSingletons$ChipViewKt.INSTANCE.getLambda$1542534682$expo_ui_release();
            }
            Function2<Composer, Integer, Unit> function2 = function2SlotContent;
            Function2<Composer, Integer, Unit> function2SlotContent2 = slotContent(functionalComposableScope, "icon");
            boolean enabled = props.getEnabled();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2104530971, "CC(remember):ChipView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChipViewKt.SuggestionChipContent$lambda$14$lambda$13(onPress);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ChipKt.SuggestionChip((Function0) objRememberedValue, function2, modifierApplyModifiers, enabled, function2SlotContent2, null, chipColorsM4777suggestionChipColors5tl4gsc, chipElevation, borderStroke, null, null, null, composerStartRestartGroup, 0, 0, 3616);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ChipViewKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipViewKt.SuggestionChipContent$lambda$15(functionalComposableScope, props, onPress, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SuggestionChipContent$lambda$14$lambda$13(Function1 function1) {
        function1.invoke(new ChipPressedEvent());
        return Unit.INSTANCE;
    }
}
