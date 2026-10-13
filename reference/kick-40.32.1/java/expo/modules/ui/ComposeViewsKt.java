package expo.modules.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.FloatingToolbarDefaults;
import androidx.compose.material3.FloatingToolbarExitDirection;
import androidx.compose.material3.FloatingToolbarScrollBehavior;
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
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.convertibles.ArrangementKt;
import expo.modules.ui.convertibles.ContentAlignment;
import expo.modules.ui.convertibles.HorizontalAlignment;
import expo.modules.ui.convertibles.HorizontalArrangementCustom;
import expo.modules.ui.convertibles.HorizontalArrangementDefault;
import expo.modules.ui.convertibles.VerticalAlignment;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComposeViews.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\t"}, d2 = {"RowContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/LayoutProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/LayoutProps;Landroidx/compose/runtime/Composer;I)V", "FlowRowContent", "ColumnContent", "BoxContent", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ComposeViewsKt {
    static final Unit BoxContent$lambda$10(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        BoxContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ColumnContent$lambda$7(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        ColumnContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit FlowRowContent$lambda$4(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        FlowRowContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit RowContent$lambda$2(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, int i, Composer composer, int i2) {
        RowContent(functionalComposableScope, layoutProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RowContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        FloatingToolbarScrollBehavior floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs;
        Arrangement.Horizontal start;
        Alignment.Vertical top;
        Modifier.Companion companionNestedScroll$default;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1660310426);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RowContent)N(props)66@2763L83,62@2529L574:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1660310426, i3, -1, "expo.modules.ui.RowContent (ComposeViews.kt:56)");
            }
            FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = props.getFloatingToolbarExitAlwaysScrollBehavior();
            FloatingToolbarExitDirection floatingToolbarExitDirectionM4038boximpl = floatingToolbarExitAlwaysScrollBehavior != null ? FloatingToolbarExitDirection.m4038boximpl(floatingToolbarExitAlwaysScrollBehavior.m12115toComposeExitDirection8LIK8E()) : null;
            if (floatingToolbarExitDirectionM4038boximpl == null) {
                composerStartRestartGroup.startReplaceGroup(1464711377);
                composerStartRestartGroup.endReplaceGroup();
                floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1464711378);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*60@2476L44");
                floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs = FloatingToolbarDefaults.INSTANCE.m4019exitAlwaysScrollBehaviorYyGo6vs(floatingToolbarExitDirectionM4038boximpl.getValue(), null, null, null, composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 14);
                composerStartRestartGroup.endReplaceGroup();
            }
            Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement = props.getHorizontalArrangement();
            if (horizontalArrangement == null || (start = ArrangementKt.toComposeArrangement(horizontalArrangement)) == null) {
                start = Arrangement.INSTANCE.getStart();
            }
            Arrangement.Horizontal horizontal = start;
            VerticalAlignment verticalAlignment = props.getVerticalAlignment();
            if (verticalAlignment == null || (top = verticalAlignment.toComposeAlignment()) == null) {
                top = Alignment.INSTANCE.getTop();
            }
            Alignment.Vertical vertical = top;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            if (floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs != null) {
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs, null, 2, null);
            } else {
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifierApplyModifiers.then(companionNestedScroll$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontal, vertical, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -486047084, "C75@3010L89:ComposeViews.kt#v15e7d");
            functionalComposableScope.Children(new UIComposableScope(rowScopeInstance, null, null, floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs, 6, null), composerStartRestartGroup, (FunctionalComposableScope.$stable << 3) | ((i3 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.RowContent$lambda$2(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void FlowRowContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        Arrangement.Horizontal start;
        Arrangement.Vertical top;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-139151896);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FlowRowContent)N(props)85@3443L83,86@3531L62,81@3197L396:ComposeViews.kt#v15e7d");
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
                ComposerKt.traceEventStart(-139151896, i2, -1, "expo.modules.ui.FlowRowContent (ComposeViews.kt:80)");
            }
            Either<HorizontalArrangementDefault, HorizontalArrangementCustom> horizontalArrangement = props.getHorizontalArrangement();
            if (horizontalArrangement == null || (start = ArrangementKt.toComposeArrangement(horizontalArrangement)) == null) {
                start = Arrangement.INSTANCE.getStart();
            }
            Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement = props.getVerticalArrangement();
            if (verticalArrangement == null || (top = ArrangementKt.m12133toComposeArrangement(verticalArrangement)) == null) {
                top = Arrangement.INSTANCE.getTop();
            }
            FlowLayoutKt.FlowRow(ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), start, top, null, 0, 0, ComposableLambdaKt.rememberComposableLambda(55865379, true, new Function3() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ComposeViewsKt.FlowRowContent$lambda$3(functionalComposableScope, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 56);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.FlowRowContent$lambda$4(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit FlowRowContent$lambda$3(FunctionalComposableScope functionalComposableScope, FlowRowScope FlowRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation(composer, "C87@3537L52:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(FlowRow) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(55865379, i, -1, "expo.modules.ui.FlowRowContent.<anonymous> (ComposeViews.kt:87)");
            }
            functionalComposableScope.Children(new UIComposableScope(FlowRow, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ColumnContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        FloatingToolbarScrollBehavior floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs;
        Arrangement.Vertical top;
        Alignment.Horizontal start;
        Modifier.Companion companionNestedScroll$default;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(578012206);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ColumnContent)N(props)102@4116L83,98@3879L583:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(578012206, i3, -1, "expo.modules.ui.ColumnContent (ComposeViews.kt:92)");
            }
            FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = props.getFloatingToolbarExitAlwaysScrollBehavior();
            FloatingToolbarExitDirection floatingToolbarExitDirectionM4038boximpl = floatingToolbarExitAlwaysScrollBehavior != null ? FloatingToolbarExitDirection.m4038boximpl(floatingToolbarExitAlwaysScrollBehavior.m12115toComposeExitDirection8LIK8E()) : null;
            if (floatingToolbarExitDirectionM4038boximpl == null) {
                composerStartRestartGroup.startReplaceGroup(1037933405);
                composerStartRestartGroup.endReplaceGroup();
                floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1037933406);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*96@3826L44");
                floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs = FloatingToolbarDefaults.INSTANCE.m4019exitAlwaysScrollBehaviorYyGo6vs(floatingToolbarExitDirectionM4038boximpl.getValue(), null, null, null, composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 14);
                composerStartRestartGroup.endReplaceGroup();
            }
            Either<VerticalArrangementDefault, VerticalArrangementCustom> verticalArrangement = props.getVerticalArrangement();
            if (verticalArrangement == null || (top = ArrangementKt.m12133toComposeArrangement(verticalArrangement)) == null) {
                top = Arrangement.INSTANCE.getTop();
            }
            Arrangement.Vertical vertical = top;
            HorizontalAlignment horizontalAlignment = props.getHorizontalAlignment();
            if (horizontalAlignment == null || (start = horizontalAlignment.toComposeAlignment()) == null) {
                start = Alignment.INSTANCE.getStart();
            }
            Alignment.Horizontal horizontal = start;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            if (floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs != null) {
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs, null, 2, null);
            } else {
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifierApplyModifiers.then(companionNestedScroll$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(vertical, horizontal, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1471781984, "C111@4363L95:ComposeViews.kt#v15e7d");
            functionalComposableScope.Children(new UIComposableScope(null, columnScopeInstance, null, floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs, 5, null), composerStartRestartGroup, (FunctionalComposableScope.$stable << 3) | ((i3 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.ColumnContent$lambda$7(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void BoxContent(final FunctionalComposableScope functionalComposableScope, final LayoutProps props, Composer composer, final int i) {
        int i2;
        FloatingToolbarScrollBehavior floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs;
        Alignment topStart;
        Modifier.Companion companionNestedScroll$default;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(105256393);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxContent)N(props)125@4871L83,122@4736L475:ComposeViews.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(105256393, i3, -1, "expo.modules.ui.BoxContent (ComposeViews.kt:116)");
            }
            FloatingToolbarExitAlwaysScrollBehavior floatingToolbarExitAlwaysScrollBehavior = props.getFloatingToolbarExitAlwaysScrollBehavior();
            FloatingToolbarExitDirection floatingToolbarExitDirectionM4038boximpl = floatingToolbarExitAlwaysScrollBehavior != null ? FloatingToolbarExitDirection.m4038boximpl(floatingToolbarExitAlwaysScrollBehavior.m12115toComposeExitDirection8LIK8E()) : null;
            if (floatingToolbarExitDirectionM4038boximpl == null) {
                composerStartRestartGroup.startReplaceGroup(367260002);
                composerStartRestartGroup.endReplaceGroup();
                floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(367260003);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*120@4683L44");
                floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs = FloatingToolbarDefaults.INSTANCE.m4019exitAlwaysScrollBehaviorYyGo6vs(floatingToolbarExitDirectionM4038boximpl.getValue(), null, null, null, composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 14);
                composerStartRestartGroup.endReplaceGroup();
            }
            ContentAlignment contentAlignment = props.getContentAlignment();
            if (contentAlignment == null || (topStart = contentAlignment.toComposeAlignment()) == null) {
                topStart = Alignment.INSTANCE.getTopStart();
            }
            Alignment alignment = topStart;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            if (floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs != null) {
                companionNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(Modifier.INSTANCE, floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs, null, 2, null);
            } else {
                companionNestedScroll$default = Modifier.INSTANCE;
            }
            Modifier modifierThen = modifierApplyModifiers.then(companionNestedScroll$default);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -595693657, "C134@5118L89:ComposeViews.kt#v15e7d");
            functionalComposableScope.Children(new UIComposableScope(null, null, boxScopeInstance, floatingToolbarScrollBehaviorM4019exitAlwaysScrollBehaviorYyGo6vs, 3, null), composerStartRestartGroup, (FunctionalComposableScope.$stable << 3) | ((i3 << 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ComposeViewsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewsKt.BoxContent$lambda$10(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
