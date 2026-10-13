package expo.modules.ui.menu;

import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.ExposedDropdownMenuBoxComposableScope;
import expo.modules.ui.ModifierRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExposedDropdownMenuBoxView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"ExposedDropdownMenuBoxContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/menu/ExposedDropdownMenuBoxProps;", "onExpandedChange", "Lkotlin/Function1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/menu/ExposedDropdownMenuBoxProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ExposedDropdownMenuBoxViewKt {
    static final Unit ExposedDropdownMenuBoxContent$lambda$1(FunctionalComposableScope functionalComposableScope, ExposedDropdownMenuBoxProps exposedDropdownMenuBoxProps, Function1 function1, int i, Composer composer, int i2) {
        ExposedDropdownMenuBoxContent(functionalComposableScope, exposedDropdownMenuBoxProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ExposedDropdownMenuBoxContent(final FunctionalComposableScope functionalComposableScope, final ExposedDropdownMenuBoxProps props, Function1<? super Boolean, Unit> onExpandedChange, Composer composer, final int i) {
        int i2;
        final Function1<? super Boolean, Unit> function1;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onExpandedChange, "onExpandedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1889259556);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenuBoxContent)N(props,onExpandedChange)27@968L83,28@1056L63,24@840L279:ExposedDropdownMenuBoxView.kt#xj3gtm");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onExpandedChange) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            function1 = onExpandedChange;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1889259556, i2, -1, "expo.modules.ui.menu.ExposedDropdownMenuBoxContent (ExposedDropdownMenuBoxView.kt:23)");
            }
            function1 = onExpandedChange;
            ExposedDropdownMenuKt.ExposedDropdownMenuBox(props.getExpanded(), function1, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), ComposableLambdaKt.rememberComposableLambda(1253516678, true, new Function3() { // from class: expo.modules.ui.menu.ExposedDropdownMenuBoxViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ExposedDropdownMenuBoxViewKt.ExposedDropdownMenuBoxContent$lambda$0(functionalComposableScope, (ExposedDropdownMenuBoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 112) | 3072, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.menu.ExposedDropdownMenuBoxViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuBoxViewKt.ExposedDropdownMenuBoxContent$lambda$1(functionalComposableScope, props, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ExposedDropdownMenuBoxContent$lambda$0(FunctionalComposableScope functionalComposableScope, ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
        ComposerKt.sourceInformation(composer, "C29@1062L53:ExposedDropdownMenuBoxView.kt#xj3gtm");
        if ((i & 6) == 0) {
            i |= (i & 8) == 0 ? composer.changed(ExposedDropdownMenuBox) : composer.changedInstance(ExposedDropdownMenuBox) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1253516678, i, -1, "expo.modules.ui.menu.ExposedDropdownMenuBoxContent.<anonymous> (ExposedDropdownMenuBoxView.kt:29)");
            }
            functionalComposableScope.Children(new ExposedDropdownMenuBoxComposableScope(ExposedDropdownMenuBox), composer, ExposedDropdownMenuBoxScope.$stable | (FunctionalComposableScope.$stable << 3));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
