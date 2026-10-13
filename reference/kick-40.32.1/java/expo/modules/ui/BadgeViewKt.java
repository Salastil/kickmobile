package expo.modules.ui;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.BadgeDefaults;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.ColorSchemeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BadgeView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0007H\u0002\"\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000b"}, d2 = {"BadgeContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/BadgeProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/BadgeProps;Landroidx/compose/runtime/Composer;I)V", "ensureBadgeContentCircular", "Landroidx/compose/ui/Modifier;", "BadgeHorizontalPaddingTotal", "Landroidx/compose/ui/unit/Dp;", "F", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BadgeViewKt {
    private static final float BadgeHorizontalPaddingTotal = Dp.m10168constructorimpl(8.0f);

    static final Unit BadgeContent$lambda$2(FunctionalComposableScope functionalComposableScope, BadgeProps badgeProps, int i, Composer composer, int i2) {
        BadgeContent(functionalComposableScope, badgeProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BadgeContent(final FunctionalComposableScope functionalComposableScope, final BadgeProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1730918690);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BadgeContent)N(props)27@1011L83:BadgeView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-1730918690, i2, -1, "expo.modules.ui.BadgeContent (BadgeView.kt:25)");
            }
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getContainerColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(-1260512436);
                ComposerKt.sourceInformation(composerStartRestartGroup, "26@962L14");
                jM7348unboximpl = BadgeDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, BadgeDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1260514048);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            long j = jM7348unboximpl;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            composerStartRestartGroup = composerStartRestartGroup;
            if (functionalComposableScope.getView().getChildCount() > 0) {
                composerStartRestartGroup.startReplaceGroup(-421015054);
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1307L176,30@1123L360");
                Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getContentColor());
                if (composeOrNull2 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1260502843);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "33@1261L39");
                    jM7348unboximpl2 = ColorSchemeKt.m3712contentColorForek8zF_U(j, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1260503959);
                    composerStartRestartGroup.endReplaceGroup();
                    jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
                }
                BadgeKt.m3505BadgeeopBjH0(modifierApplyModifiers, j, jM7348unboximpl2, ComposableLambdaKt.rememberComposableLambda(-691536746, true, new Function3() { // from class: expo.modules.ui.BadgeViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BadgeViewKt.BadgeContent$lambda$1(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-420648603);
                ComposerKt.sourceInformation(composerStartRestartGroup, "44@1563L85");
                BadgeKt.m3505BadgeeopBjH0(modifierApplyModifiers, j, 0L, null, composerStartRestartGroup, 0, 12);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.BadgeViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BadgeViewKt.BadgeContent$lambda$2(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit BadgeContent$lambda$1(FunctionalComposableScope functionalComposableScope, RowScope Badge, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
        ComposerKt.sourceInformation(composer, "C35@1315L162:BadgeView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-691536746, i, -1, "expo.modules.ui.BadgeContent.<anonymous> (BadgeView.kt:35)");
            }
            Modifier modifierEnsureBadgeContentCircular = ensureBadgeContentCircular(Modifier.INSTANCE);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierEnsureBadgeContentCircular);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6438constructorimpl = Updater.m6438constructorimpl(composer);
            Updater.m6446setimpl(composerM6438constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6446setimpl(composerM6438constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6446setimpl(composerM6438constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6444reconcileimpl(composerM6438constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6446setimpl(composerM6438constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1359230966, "C39@1440L29:BadgeView.kt#v15e7d");
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Modifier ensureBadgeContentCircular(Modifier modifier) {
        return LayoutModifierKt.layout(modifier, new Function3() { // from class: expo.modules.ui.BadgeViewKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BadgeViewKt.ensureBadgeContentCircular$lambda$4((MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        });
    }

    static final MeasureResult ensureBadgeContentCircular$lambda$4(MeasureScope layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeableMo8808measureBRTryo0 = measurable.mo8808measureBRTryo0(constraints.getValue());
        final int iMax = Math.max(placeableMo8808measureBRTryo0.getWidth(), placeableMo8808measureBRTryo0.getHeight() - layout.mo1728roundToPx0680j_4(BadgeHorizontalPaddingTotal));
        return MeasureScope.layout$default(layout, iMax, placeableMo8808measureBRTryo0.getHeight(), null, new Function1() { // from class: expo.modules.ui.BadgeViewKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BadgeViewKt.ensureBadgeContentCircular$lambda$4$lambda$3(placeableMo8808measureBRTryo0, iMax, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    static final Unit ensureBadgeContentCircular$lambda$4$lambda$3(Placeable placeable, int i, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, placeable, (i - placeable.getWidth()) / 2, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
