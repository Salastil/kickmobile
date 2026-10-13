package expo.modules.ui;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.convertibles.ContentAlignment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PullToRefreshBoxView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"PullToRefreshBoxContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/PullToRefreshBoxProps;", "onRefresh", "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/PullToRefreshBoxProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PullToRefreshBoxViewKt {
    static final Unit PullToRefreshBoxContent$lambda$4(FunctionalComposableScope functionalComposableScope, PullToRefreshBoxProps pullToRefreshBoxProps, Function0 function0, int i, Composer composer, int i2) {
        PullToRefreshBoxContent(functionalComposableScope, pullToRefreshBoxProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PullToRefreshBoxContent(final FunctionalComposableScope functionalComposableScope, final PullToRefreshBoxProps props, final Function0<Unit> onRefresh, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Alignment topStart;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onRefresh, "onRefresh");
        Composer composerStartRestartGroup = composer.startRestartGroup(1583733953);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PullToRefreshBoxContent)N(props,onRefresh)38@1535L28,54@2299L83,42@1634L15,45@1790L475,55@2387L39,40@1567L859:PullToRefreshBoxView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onRefresh) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1583733953, i3, -1, "expo.modules.ui.PullToRefreshBoxContent (PullToRefreshBoxView.kt:36)");
            }
            final boolean zIsRefreshing = props.isRefreshing();
            final PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            ContentAlignment contentAlignment = props.getContentAlignment();
            if (contentAlignment == null || (topStart = contentAlignment.toComposeAlignment()) == null) {
                topStart = Alignment.INSTANCE.getTopStart();
            }
            Alignment alignment = topStart;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1549915248, "CC(remember):PullToRefreshBoxView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.PullToRefreshBoxViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PullToRefreshBoxViewKt.PullToRefreshBoxContent$lambda$1$lambda$0(onRefresh);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PullToRefreshKt.m5525PullToRefreshBoxgMrHQkA(zIsRefreshing, (Function0) objRememberedValue, modifierApplyModifiers, pullToRefreshStateRememberPullToRefreshState, alignment, ComposableLambdaKt.rememberComposableLambda(558816218, true, new Function3() { // from class: expo.modules.ui.PullToRefreshBoxViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PullToRefreshBoxViewKt.PullToRefreshBoxContent$lambda$2(props, functionalComposableScope, pullToRefreshStateRememberPullToRefreshState, zIsRefreshing, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), false, 0.0f, ComposableLambdaKt.rememberComposableLambda(1306651421, true, new Function3() { // from class: expo.modules.ui.PullToRefreshBoxViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PullToRefreshBoxViewKt.PullToRefreshBoxContent$lambda$3(functionalComposableScope, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100859904, 192);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.PullToRefreshBoxViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PullToRefreshBoxViewKt.PullToRefreshBoxContent$lambda$4(functionalComposableScope, props, onRefresh, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit PullToRefreshBoxContent$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit PullToRefreshBoxContent$lambda$2(PullToRefreshBoxProps pullToRefreshBoxProps, FunctionalComposableScope functionalComposableScope, PullToRefreshState pullToRefreshState, boolean z, BoxScope PullToRefreshBox, Composer composer, int i) {
        long jM7348unboximpl;
        long jM7348unboximpl2;
        Intrinsics.checkNotNullParameter(PullToRefreshBox, "$this$PullToRefreshBox");
        ComposerKt.sourceInformation(composer, "C49@1947L93,46@1820L439:PullToRefreshBoxView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(558816218, i, -1, "expo.modules.ui.PullToRefreshBoxContent.<anonymous> (PullToRefreshBoxView.kt:46)");
            }
            PullToRefreshDefaults pullToRefreshDefaults = PullToRefreshDefaults.INSTANCE;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(pullToRefreshBoxProps.getIndicator().getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, AppContext.$stable << 3);
            Color composeOrNull = UtilsKt.getComposeOrNull(pullToRefreshBoxProps.getIndicator().getColor());
            if (composeOrNull == null) {
                composer.startReplaceGroup(151484161);
                ComposerKt.sourceInformation(composer, "50@2111L11");
                jM7348unboximpl = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(151482146);
                composer.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            Color composeOrNull2 = UtilsKt.getComposeOrNull(pullToRefreshBoxProps.getIndicator().getContainerColor());
            if (composeOrNull2 == null) {
                composer.startReplaceGroup(151487630);
                ComposerKt.sourceInformation(composer, "51@2219L11");
                jM7348unboximpl2 = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurfaceContainerHigh();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(151485336);
                composer.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            }
            pullToRefreshDefaults.m5518LoadingIndicator4eDdRP8(pullToRefreshState, z, modifierApplyModifiers, jM7348unboximpl2, jM7348unboximpl, 0.0f, 0.0f, composer, PullToRefreshDefaults.$stable << 21, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit PullToRefreshBoxContent$lambda$3(FunctionalComposableScope functionalComposableScope, BoxScope PullToRefreshBox, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(PullToRefreshBox, "$this$PullToRefreshBox");
        ComposerKt.sourceInformation(composer, "C56@2393L29:PullToRefreshBoxView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1306651421, i, -1, "expo.modules.ui.PullToRefreshBoxContent.<anonymous> (PullToRefreshBoxView.kt:56)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
