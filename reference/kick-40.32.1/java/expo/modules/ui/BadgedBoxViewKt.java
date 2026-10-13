package expo.modules.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material3.BadgeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BadgedBoxView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"BadgedBoxContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/BadgedBoxProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/BadgedBoxProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BadgedBoxViewKt {
    static final Unit BadgedBoxContent$lambda$4(FunctionalComposableScope functionalComposableScope, BadgedBoxProps badgedBoxProps, int i, Composer composer, int i2) {
        BadgedBoxContent(functionalComposableScope, badgedBoxProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BadgedBoxContent(final FunctionalComposableScope functionalComposableScope, final BadgedBoxProps props, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-14405609);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BadgedBoxContent)N(props)19@586L38,20@658L83,21@746L59,18@563L242:BadgedBoxView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
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
                ComposerKt.traceEventStart(-14405609, i2, -1, "expo.modules.ui.BadgedBoxContent (BadgedBoxView.kt:15)");
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "badge");
            BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(132927119, true, new Function3() { // from class: expo.modules.ui.BadgedBoxViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BadgedBoxViewKt.BadgedBoxContent$lambda$0(slotViewFindChildSlotView, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), ComposableLambdaKt.rememberComposableLambda(-573669487, true, new Function3() { // from class: expo.modules.ui.BadgedBoxViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BadgedBoxViewKt.BadgedBoxContent$lambda$3(functionalComposableScope, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 390, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.BadgedBoxViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BadgedBoxViewKt.BadgedBoxContent$lambda$4(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit BadgedBoxContent$lambda$0(SlotView slotView, BoxScope BadgedBox, Composer composer, int i) {
        Unit unit;
        Composer composer2;
        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
        ComposerKt.sourceInformation(composer, "C:BadgedBoxView.kt#v15e7d");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(132927119, i, -1, "expo.modules.ui.BadgedBoxContent.<anonymous> (BadgedBoxView.kt:19)");
            }
            if (slotView == null) {
                composer.startReplaceGroup(71968486);
                composer.endReplaceGroup();
                unit = null;
            } else {
                composer.startReplaceGroup(-1106057093);
                ComposerKt.sourceInformation(composer, "19@599L12");
                SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
                composer.endReplaceGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                composer.startReplaceGroup(-1106056586);
                ComposerKt.sourceInformation(composer, "19@615L7");
                composer2 = composer;
                BadgeKt.m3505BadgeeopBjH0(null, 0L, 0L, null, composer2, 0, 15);
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(-1106057423);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit BadgedBoxContent$lambda$3(FunctionalComposableScope functionalComposableScope, BoxScope BadgedBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
        ComposerKt.sourceInformation(composer, "C22@782L19,22@752L49:BadgedBoxView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-573669487, i, -1, "expo.modules.ui.BadgedBoxContent.<anonymous> (BadgedBoxView.kt:22)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1540561948, "CC(remember):BadgedBoxView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.BadgedBoxViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(BadgedBoxViewKt.BadgedBoxContent$lambda$3$lambda$2$lambda$1((ExpoComposeView) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            functionalComposableScope.Children(uIComposableScope, (Function1) objRememberedValue, composer, (FunctionalComposableScope.$stable << 6) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final boolean BadgedBoxContent$lambda$3$lambda$2$lambda$1(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !SlotViewKt.isSlotView(it);
    }
}
