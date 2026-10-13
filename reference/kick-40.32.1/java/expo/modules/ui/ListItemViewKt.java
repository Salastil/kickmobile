package expo.modules.ui;

import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.ListItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListItemView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"ListItemContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ListItemProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ListItemProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ListItemViewKt {
    static final Unit ListItemContent$lambda$20(FunctionalComposableScope functionalComposableScope, ListItemProps listItemProps, int i, Composer composer, int i2) {
        ListItemContent(functionalComposableScope, listItemProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ListItemContent(final FunctionalComposableScope functionalComposableScope, final ListItemProps props, Composer composer, final int i) {
        int i2;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambdaRememberComposableLambda2;
        ComposableLambda composableLambdaRememberComposableLambda3;
        float fM4246getElevationD9Ej5fM;
        float fM4246getElevationD9Ej5fM2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1333864526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListItemContent)N(props)34@1202L83,36@1326L8,37@1367L697,59@2443L124,58@2411L956:ListItemView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-1333864526, i2, -1, "expo.modules.ui.ListItemContent (ListItemView.kt:33)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            androidx.compose.material3.ListItemColors listItemColorsColors = ListItemDefaults.INSTANCE.colors(composerStartRestartGroup, ListItemDefaults.$stable);
            ListItemDefaults listItemDefaults = ListItemDefaults.INSTANCE;
            ListItemColors colors = props.getColors();
            ComposableLambda composableLambdaRememberComposableLambda4 = null;
            Color composeOrNull = UtilsKt.getComposeOrNull(colors != null ? colors.getContainerColor() : null);
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : listItemColorsColors.getContainerColor();
            ListItemColors colors2 = props.getColors();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(colors2 != null ? colors2.getContentColor() : null);
            long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : listItemColorsColors.getContentColor();
            ListItemColors colors3 = props.getColors();
            Color composeOrNull3 = UtilsKt.getComposeOrNull(colors3 != null ? colors3.getLeadingContentColor() : null);
            long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : listItemColorsColors.getLeadingContentColor();
            ListItemColors colors4 = props.getColors();
            Color composeOrNull4 = UtilsKt.getComposeOrNull(colors4 != null ? colors4.getTrailingContentColor() : null);
            long jM7348unboximpl4 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : listItemColorsColors.getTrailingContentColor();
            ListItemColors colors5 = props.getColors();
            Color composeOrNull5 = UtilsKt.getComposeOrNull(colors5 != null ? colors5.getSupportingContentColor() : null);
            long jM7348unboximpl5 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : listItemColorsColors.getSupportingContentColor();
            ListItemColors colors6 = props.getColors();
            Color composeOrNull6 = UtilsKt.getComposeOrNull(colors6 != null ? colors6.getOverlineContentColor() : null);
            androidx.compose.material3.ListItemColors listItemColorsM4244colorsLIdIuno = listItemDefaults.m4244colorsLIdIuno(jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, jM7348unboximpl4, composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : listItemColorsColors.m4226getOverlineContentColor0d7_KjU(), jM7348unboximpl5, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 0, ListItemDefaults.$stable << 12, 16777152);
            composerStartRestartGroup = composerStartRestartGroup;
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "headlineContent");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "overlineContent");
            final SlotView slotViewFindChildSlotView3 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "supportingContent");
            final SlotView slotViewFindChildSlotView4 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "leadingContent");
            final SlotView slotViewFindChildSlotView5 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "trailingContent");
            ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(1634643600, true, new Function2() { // from class: expo.modules.ui.ListItemViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemViewKt.ListItemContent$lambda$3(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            if (slotViewFindChildSlotView2 == null) {
                composerStartRestartGroup.startReplaceGroup(-119132571);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-119132570);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*68@2646L88");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(678565717, true, new Function2() { // from class: expo.modules.ui.ListItemViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemViewKt.ListItemContent$lambda$7$lambda$6(slotViewFindChildSlotView2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (slotViewFindChildSlotView3 == null) {
                composerStartRestartGroup.startReplaceGroup(-118981787);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda2 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-118981786);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*75@2798L88");
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-1224894378, true, new Function2() { // from class: expo.modules.ui.ListItemViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemViewKt.ListItemContent$lambda$11$lambda$10(slotViewFindChildSlotView3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (slotViewFindChildSlotView4 == null) {
                composerStartRestartGroup.startReplaceGroup(-118836955);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda3 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-118836954);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*82@2944L88");
                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(1166612823, true, new Function2() { // from class: expo.modules.ui.ListItemViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemViewKt.ListItemContent$lambda$15$lambda$14(slotViewFindChildSlotView4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (slotViewFindChildSlotView5 == null) {
                composerStartRestartGroup.startReplaceGroup(-118690139);
            } else {
                composerStartRestartGroup.startReplaceGroup(-118690138);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*89@3092L88");
                composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-736847272, true, new Function2() { // from class: expo.modules.ui.ListItemViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListItemViewKt.ListItemContent$lambda$19$lambda$18(slotViewFindChildSlotView5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposableLambda composableLambda = composableLambdaRememberComposableLambda4;
            Float tonalElevation = props.getTonalElevation();
            if (tonalElevation == null) {
                fM4246getElevationD9Ej5fM = ListItemDefaults.INSTANCE.m4246getElevationD9Ej5fM();
            } else {
                fM4246getElevationD9Ej5fM = Dp.m10168constructorimpl(tonalElevation.floatValue());
            }
            float f = fM4246getElevationD9Ej5fM;
            Float shadowElevation = props.getShadowElevation();
            if (shadowElevation == null) {
                fM4246getElevationD9Ej5fM2 = ListItemDefaults.INSTANCE.m4246getElevationD9Ej5fM();
            } else {
                fM4246getElevationD9Ej5fM2 = Dp.m10168constructorimpl(shadowElevation.floatValue());
            }
            ListItemKt.m4260ListItemHXNGIdc(composableLambdaRememberComposableLambda5, modifierApplyModifiers, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, composableLambdaRememberComposableLambda3, composableLambda, listItemColorsM4244colorsLIdIuno, f, fM4246getElevationD9Ej5fM2, composerStartRestartGroup, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ListItemViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListItemViewKt.ListItemContent$lambda$20(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ListItemContent$lambda$3(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItemView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1634643600, i, -1, "expo.modules.ui.ListItemContent.<anonymous> (ListItemView.kt:60)");
            }
            if (slotView == null) {
                composer.startReplaceGroup(1328314197);
            } else {
                composer.startReplaceGroup(1328314198);
                ComposerKt.sourceInformation(composer, "");
                composer.startReplaceGroup(-1065529386);
                ComposerKt.sourceInformation(composer, "");
                UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
                composer.startReplaceGroup(-1065528218);
                ComposerKt.sourceInformation(composer, "*62@2532L9");
                slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
                composer.endReplaceGroup();
                composer.endReplaceGroup();
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ListItemContent$lambda$7$lambda$6(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItemView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(678565717, i, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:69)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-733373397);
            ComposerKt.sourceInformation(composer, "*70@2705L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ListItemContent$lambda$11$lambda$10(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItemView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1224894378, i, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:76)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-302456596);
            ComposerKt.sourceInformation(composer, "*77@2857L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ListItemContent$lambda$15$lambda$14(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItemView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1166612823, i, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:83)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(128460205);
            ComposerKt.sourceInformation(composer, "*84@3003L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ListItemContent$lambda$19$lambda$18(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:ListItemView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-736847272, i, -1, "expo.modules.ui.ListItemContent.<anonymous>.<anonymous> (ListItemView.kt:90)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(559377006);
            ComposerKt.sourceInformation(composer, "*91@3151L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
