package expo.modules.ui;

import androidx.compose.material3.MultiChoiceSegmentedButtonRowScope;
import androidx.compose.material3.SegmentedButtonKt;
import androidx.compose.material3.SingleChoiceSegmentedButtonRowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SegmentedControlView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"SingleChoiceSegmentedButtonRowContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SingleChoiceSegmentedButtonRowProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SingleChoiceSegmentedButtonRowProps;Landroidx/compose/runtime/Composer;I)V", "MultiChoiceSegmentedButtonRowContent", "Lexpo/modules/ui/MultiChoiceSegmentedButtonRowProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/MultiChoiceSegmentedButtonRowProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SegmentedControlViewKt {
    static final Unit MultiChoiceSegmentedButtonRowContent$lambda$3(FunctionalComposableScope functionalComposableScope, MultiChoiceSegmentedButtonRowProps multiChoiceSegmentedButtonRowProps, int i, Composer composer, int i2) {
        MultiChoiceSegmentedButtonRowContent(functionalComposableScope, multiChoiceSegmentedButtonRowProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SingleChoiceSegmentedButtonRowContent$lambda$1(FunctionalComposableScope functionalComposableScope, SingleChoiceSegmentedButtonRowProps singleChoiceSegmentedButtonRowProps, int i, Composer composer, int i2) {
        SingleChoiceSegmentedButtonRowContent(functionalComposableScope, singleChoiceSegmentedButtonRowProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SingleChoiceSegmentedButtonRowContent(final FunctionalComposableScope functionalComposableScope, final SingleChoiceSegmentedButtonRowProps props, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1080114812);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SingleChoiceSegmentedButtonRowContent)N(props)17@683L83,18@771L85,16@619L237:SegmentedControlView.kt#v15e7d");
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
                ComposerKt.traceEventStart(1080114812, i2, -1, "expo.modules.ui.SingleChoiceSegmentedButtonRowContent (SegmentedControlView.kt:15)");
            }
            SegmentedButtonKt.m4623SingleChoiceSegmentedButtonRowuFdPcIQ(ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), 0.0f, ComposableLambdaKt.rememberComposableLambda(-2124498095, true, new Function3() { // from class: expo.modules.ui.SegmentedControlViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SegmentedControlViewKt.SingleChoiceSegmentedButtonRowContent$lambda$0(functionalComposableScope, (SingleChoiceSegmentedButtonRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384, 2);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SegmentedControlViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedControlViewKt.SingleChoiceSegmentedButtonRowContent$lambda$1(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SingleChoiceSegmentedButtonRowContent$lambda$0(FunctionalComposableScope functionalComposableScope, SingleChoiceSegmentedButtonRowScope SingleChoiceSegmentedButtonRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SingleChoiceSegmentedButtonRow, "$this$SingleChoiceSegmentedButtonRow");
        ComposerKt.sourceInformation(composer, "C19@777L75:SegmentedControlView.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(SingleChoiceSegmentedButtonRow) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2124498095, i, -1, "expo.modules.ui.SingleChoiceSegmentedButtonRowContent.<anonymous> (SegmentedControlView.kt:19)");
            }
            functionalComposableScope.Children(new UIComposableScope(SingleChoiceSegmentedButtonRow, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void MultiChoiceSegmentedButtonRowContent(final FunctionalComposableScope functionalComposableScope, final MultiChoiceSegmentedButtonRowProps props, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1083852984);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiChoiceSegmentedButtonRowContent)N(props)31@1181L83,32@1269L84,30@1118L235:SegmentedControlView.kt#v15e7d");
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
                ComposerKt.traceEventStart(1083852984, i2, -1, "expo.modules.ui.MultiChoiceSegmentedButtonRowContent (SegmentedControlView.kt:29)");
            }
            SegmentedButtonKt.m4622MultiChoiceSegmentedButtonRowuFdPcIQ(ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), 0.0f, ComposableLambdaKt.rememberComposableLambda(-1533901015, true, new Function3() { // from class: expo.modules.ui.SegmentedControlViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SegmentedControlViewKt.MultiChoiceSegmentedButtonRowContent$lambda$2(functionalComposableScope, (MultiChoiceSegmentedButtonRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384, 2);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SegmentedControlViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SegmentedControlViewKt.MultiChoiceSegmentedButtonRowContent$lambda$3(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit MultiChoiceSegmentedButtonRowContent$lambda$2(FunctionalComposableScope functionalComposableScope, MultiChoiceSegmentedButtonRowScope MultiChoiceSegmentedButtonRow, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(MultiChoiceSegmentedButtonRow, "$this$MultiChoiceSegmentedButtonRow");
        ComposerKt.sourceInformation(composer, "C33@1275L74:SegmentedControlView.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(MultiChoiceSegmentedButtonRow) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533901015, i, -1, "expo.modules.ui.MultiChoiceSegmentedButtonRowContent.<anonymous> (SegmentedControlView.kt:33)");
            }
            functionalComposableScope.Children(new UIComposableScope(MultiChoiceSegmentedButtonRow, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
