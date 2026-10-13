package expo.modules.ui.menu;

import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.MenuDefaults;
import androidx.compose.material3.MenuItemColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.SlotView;
import expo.modules.ui.SlotViewKt;
import expo.modules.ui.UIComposableScope;
import expo.modules.ui.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DropdownMenuItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"DropdownMenuItemContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/menu/DropdownMenuItemProps;", "onItemPressed", "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/menu/DropdownMenuItemProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DropdownMenuItemKt {
    static final Unit DropdownMenuItemContent$lambda$14(FunctionalComposableScope functionalComposableScope, DropdownMenuItemProps dropdownMenuItemProps, Function0 function0, int i, Composer composer, int i2) {
        DropdownMenuItemContent(functionalComposableScope, dropdownMenuItemProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DropdownMenuItemContent(final FunctionalComposableScope functionalComposableScope, final DropdownMenuItemProps props, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        ComposableLambda composableLambda;
        final Function0<Unit> onItemPressed = function0;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onItemPressed, "onItemPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(1769408522);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemContent)N(props,onItemPressed)50@1641L12,55@1835L83,56@1946L640,53@1686L86,70@2826L29,52@1657L1202:DropdownMenuItem.kt#xj3gtm");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onItemPressed) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1769408522, i3, -1, "expo.modules.ui.menu.DropdownMenuItemContent (DropdownMenuItem.kt:44)");
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "text");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "leadingIcon");
            final SlotView slotViewFindChildSlotView3 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "trailingIcon");
            DropdownMenuItemColors elementColors = props.getElementColors();
            MenuItemColors menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, MenuDefaults.$stable);
            boolean enabled = props.getEnabled();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            MenuDefaults menuDefaults = MenuDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(elementColors.getTextColor());
            long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : menuItemColorsItemColors.getTextColor();
            Color composeOrNull2 = UtilsKt.getComposeOrNull(elementColors.getLeadingIconColor());
            long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : menuItemColorsItemColors.getLeadingIconColor();
            Color composeOrNull3 = UtilsKt.getComposeOrNull(elementColors.getTrailingIconColor());
            long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : menuItemColorsItemColors.getTrailingIconColor();
            Color composeOrNull4 = UtilsKt.getComposeOrNull(elementColors.getDisabledTextColor());
            long jM7348unboximpl4 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : menuItemColorsItemColors.getDisabledTextColor();
            Color composeOrNull5 = UtilsKt.getComposeOrNull(elementColors.getDisabledLeadingIconColor());
            long jM7348unboximpl5 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : menuItemColorsItemColors.getDisabledLeadingIconColor();
            Color composeOrNull6 = UtilsKt.getComposeOrNull(elementColors.getDisabledTrailingIconColor());
            MenuItemColors menuItemColorsM4312itemColors5tl4gsc = menuDefaults.m4312itemColors5tl4gsc(jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, jM7348unboximpl4, jM7348unboximpl5, composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : menuItemColorsItemColors.getDisabledTrailingIconColor(), composerStartRestartGroup, MenuDefaults.$stable << 18, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposableLambda composableLambdaRememberComposableLambda = null;
            if (slotViewFindChildSlotView2 == null) {
                composerStartRestartGroup.startReplaceGroup(317011469);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(317011470);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*65@2635L56");
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(174601768, true, new Function2() { // from class: expo.modules.ui.menu.DropdownMenuItemKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DropdownMenuItemKt.DropdownMenuItemContent$lambda$3$lambda$2(slotViewFindChildSlotView2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda2;
            }
            if (slotViewFindChildSlotView3 == null) {
                composerStartRestartGroup.startReplaceGroup(317123565);
            } else {
                composerStartRestartGroup.startReplaceGroup(317123566);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*68@2748L56");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2042261751, true, new Function2() { // from class: expo.modules.ui.menu.DropdownMenuItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return DropdownMenuItemKt.DropdownMenuItemContent$lambda$7$lambda$6(slotViewFindChildSlotView3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposableLambda composableLambda2 = composableLambdaRememberComposableLambda;
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-365373894, true, new Function2() { // from class: expo.modules.ui.menu.DropdownMenuItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DropdownMenuItemKt.DropdownMenuItemContent$lambda$11(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -405409369, "CC(remember):DropdownMenuItem.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                onItemPressed = function0;
                objRememberedValue = new Function0() { // from class: expo.modules.ui.menu.DropdownMenuItemKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DropdownMenuItemKt.DropdownMenuItemContent$lambda$13$lambda$12(onItemPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                onItemPressed = function0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda3, (Function0) objRememberedValue, modifierApplyModifiers, composableLambda, composableLambda2, enabled, menuItemColorsM4312itemColors5tl4gsc, null, null, composerStartRestartGroup, 6, 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.menu.DropdownMenuItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DropdownMenuItemKt.DropdownMenuItemContent$lambda$14(functionalComposableScope, props, onItemPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DropdownMenuItemContent$lambda$11(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:DropdownMenuItem.kt#xj3gtm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-365373894, i, -1, "expo.modules.ui.menu.DropdownMenuItemContent.<anonymous> (DropdownMenuItem.kt:53)");
            }
            if (slotView == null) {
                composer.startReplaceGroup(-1406530357);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1406530356);
                ComposerKt.sourceInformation(composer, "");
                composer.startReplaceGroup(1063006894);
                ComposerKt.sourceInformation(composer, "");
                UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
                composer.startReplaceGroup(1063007760);
                ComposerKt.sourceInformation(composer, "*53@1747L9");
                slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
                composer.endReplaceGroup();
                composer.endReplaceGroup();
                composer.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenuItemContent$lambda$3$lambda$2(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:DropdownMenuItem.kt#xj3gtm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(174601768, i, -1, "expo.modules.ui.menu.DropdownMenuItemContent.<anonymous>.<anonymous> (DropdownMenuItem.kt:65)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(288575486);
            ComposerKt.sourceInformation(composer, "*65@2676L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenuItemContent$lambda$7$lambda$6(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:DropdownMenuItem.kt#xj3gtm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2042261751, i, -1, "expo.modules.ui.menu.DropdownMenuItemContent.<anonymous>.<anonymous> (DropdownMenuItem.kt:68)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-186510579);
            ComposerKt.sourceInformation(composer, "*68@2789L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit DropdownMenuItemContent$lambda$13$lambda$12(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
