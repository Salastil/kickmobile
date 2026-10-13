package expo.modules.ui;

import androidx.compose.material3.SwitchKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.state.ObservableState;
import expo.modules.ui.state.WorkletCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncSwitchView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"SyncSwitchContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SyncSwitchProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SyncSwitchProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SyncSwitchViewKt {
    static final Unit SyncSwitchContent$lambda$0(FunctionalComposableScope functionalComposableScope, SyncSwitchProps syncSwitchProps, int i, Composer composer, int i2) {
        SyncSwitchContent(functionalComposableScope, syncSwitchProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SyncSwitchContent$lambda$3(FunctionalComposableScope functionalComposableScope, SyncSwitchProps syncSwitchProps, int i, Composer composer, int i2) {
        SyncSwitchContent(functionalComposableScope, syncSwitchProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SyncSwitchContent(final FunctionalComposableScope functionalComposableScope, final SyncSwitchProps props, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(2137960472);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SyncSwitchContent)N(props)24@783L98,28@915L113,22@717L344:SyncSwitchView.kt#v15e7d");
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
                ComposerKt.traceEventStart(2137960472, i2, -1, "expo.modules.ui.SyncSwitchContent (SyncSwitchView.kt:19)");
            }
            final ObservableState observableStateIsOn = props.isOn();
            if (observableStateIsOn != null) {
                boolean zBooleanValue = ((Boolean) observableStateIsOn.binding(false)).booleanValue();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1585652282, "CC(remember):SyncSwitchView.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(observableStateIsOn) | composerStartRestartGroup.changedInstance(props);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.SyncSwitchViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return SyncSwitchViewKt.SyncSwitchContent$lambda$2$lambda$1(observableStateIsOn, props, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwitchKt.Switch(zBooleanValue, (Function1) objRememberedValue, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), null, props.getEnabled(), null, null, composerStartRestartGroup, 0, 104);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: expo.modules.ui.SyncSwitchViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SyncSwitchViewKt.SyncSwitchContent$lambda$0(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: expo.modules.ui.SyncSwitchViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SyncSwitchViewKt.SyncSwitchContent$lambda$3(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final Unit SyncSwitchContent$lambda$2$lambda$1(ObservableState observableState, SyncSwitchProps syncSwitchProps, boolean z) {
        observableState.setValue(Boolean.valueOf(z));
        WorkletCallback onCheckedChangeSync = syncSwitchProps.getOnCheckedChangeSync();
        if (onCheckedChangeSync != null) {
            onCheckedChangeSync.invoke(Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }
}
