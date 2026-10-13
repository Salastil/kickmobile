package expo.modules.ui.menu;

import android.graphics.Color;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.MenuDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DropdownMenu.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"DropdownMenuContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/menu/DropdownMenuProps;", "onDismissRequest", "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/menu/DropdownMenuProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DropdownMenuKt {
    static final Unit DropdownMenuContent$lambda$8(FunctionalComposableScope functionalComposableScope, DropdownMenuProps dropdownMenuProps, Function0 function0, int i, Composer composer, int i2) {
        DropdownMenuContent(functionalComposableScope, dropdownMenuProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DropdownMenuContent(final FunctionalComposableScope functionalComposableScope, final DropdownMenuProps props, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        int i2;
        Composer composer2;
        long jM7348unboximpl;
        RoundedCornerShape shape;
        float fM4309getShadowElevationD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2145409353);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuContent)N(props,onDismissRequest)22@777L83,22@745L722:DropdownMenu.kt#xj3gtm");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2145409353, i3, -1, "expo.modules.ui.menu.DropdownMenuContent (DropdownMenu.kt:19)");
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "items");
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierApplyModifiers);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 851805667, "C24@943L19,24@904L59,32@1320L143,26@969L494:DropdownMenu.kt#xj3gtm");
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2105688292, "CC(remember):DropdownMenu.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.menu.DropdownMenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DropdownMenuKt.DropdownMenuContent$lambda$7$lambda$1$lambda$0((ExpoComposeView) obj));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            functionalComposableScope.Children(uIComposableScope, (Function1) objRememberedValue, composerStartRestartGroup, (FunctionalComposableScope.$stable << 6) | 48 | ((i3 << 6) & 896));
            Color color = props.getColor();
            androidx.compose.ui.graphics.Color composeOrNull = color != null ? UtilsKt.getComposeOrNull(color) : null;
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(2105691679);
                ComposerKt.sourceInformation(composerStartRestartGroup, "27@1049L14");
                jM7348unboximpl = MenuDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, MenuDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(2105690346);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            Float cornerRadius = props.getCornerRadius();
            RoundedCornerShape roundedCornerShapeM2680RoundedCornerShape0680j_4 = cornerRadius != null ? RoundedCornerShapeKt.m2680RoundedCornerShape0680j_4(Dp.m10168constructorimpl(cornerRadius.floatValue())) : null;
            if (roundedCornerShapeM2680RoundedCornerShape0680j_4 == null) {
                composerStartRestartGroup.startReplaceGroup(2105694870);
                ComposerKt.sourceInformation(composerStartRestartGroup, "28@1149L5");
                shape = MenuDefaults.INSTANCE.getShape(composerStartRestartGroup, MenuDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(2105692700);
                composerStartRestartGroup.endReplaceGroup();
                shape = roundedCornerShapeM2680RoundedCornerShape0680j_4;
            }
            Shape shape2 = shape;
            Float shadowElevation = props.getShadowElevation();
            if (shadowElevation == null) {
                fM4309getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m4309getShadowElevationD9Ej5fM();
            } else {
                fM4309getShadowElevationD9Ej5fM = Dp.m10168constructorimpl(shadowElevation.floatValue());
            }
            composer2 = composerStartRestartGroup;
            AndroidMenu_androidKt.m3458DropdownMenuIlH_yew(props.getExpanded(), onDismissRequest, null, 0L, null, null, shape2, jM7348unboximpl, 0.0f, fM4309getShadowElevationD9Ej5fM, null, ComposableLambdaKt.rememberComposableLambda(-10723092, true, new Function3() { // from class: expo.modules.ui.menu.DropdownMenuKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DropdownMenuKt.DropdownMenuContent$lambda$7$lambda$6(slotViewFindChildSlotView, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i3 >> 3) & 112, 48, 1340);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.menu.DropdownMenuKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DropdownMenuKt.DropdownMenuContent$lambda$8(functionalComposableScope, props, onDismissRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final boolean DropdownMenuContent$lambda$7$lambda$1$lambda$0(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !SlotViewKt.isSlotView(it);
    }

    static final Unit DropdownMenuContent$lambda$7$lambda$6(SlotView slotView, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C:DropdownMenu.kt#xj3gtm");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-10723092, i, -1, "expo.modules.ui.menu.DropdownMenuContent.<anonymous>.<anonymous> (DropdownMenu.kt:33)");
            }
            if (slotView == null) {
                composer.startReplaceGroup(-1624027517);
            } else {
                composer.startReplaceGroup(-1624027516);
                ComposerKt.sourceInformation(composer, "");
                composer.startReplaceGroup(-1714955544);
                ComposerKt.sourceInformation(composer, "");
                UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
                composer.startReplaceGroup(-1714954376);
                ComposerKt.sourceInformation(composer, "*36@1418L9");
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
}
