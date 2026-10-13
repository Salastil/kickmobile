package expo.modules.ui;

import androidx.compose.material3.LoadingIndicatorDefaults;
import androidx.compose.material3.LoadingIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.state.ObservableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoadingView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"LoadingIndicatorContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/LoadingIndicatorProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/LoadingIndicatorProps;Landroidx/compose/runtime/Composer;I)V", "ContainedLoadingIndicatorContent", "Lexpo/modules/ui/ContainedLoadingIndicatorProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ContainedLoadingIndicatorProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class LoadingViewKt {
    static final Unit ContainedLoadingIndicatorContent$lambda$5(FunctionalComposableScope functionalComposableScope, ContainedLoadingIndicatorProps containedLoadingIndicatorProps, int i, Composer composer, int i2) {
        ContainedLoadingIndicatorContent(functionalComposableScope, containedLoadingIndicatorProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit LoadingIndicatorContent$lambda$2(FunctionalComposableScope functionalComposableScope, LoadingIndicatorProps loadingIndicatorProps, int i, Composer composer, int i2) {
        LoadingIndicatorContent(functionalComposableScope, loadingIndicatorProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void LoadingIndicatorContent(final FunctionalComposableScope functionalComposableScope, final LoadingIndicatorProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(599588265);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingIndicatorContent)N(props)26@947L83:LoadingView.kt#v15e7d");
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
                ComposerKt.traceEventStart(599588265, i2, -1, "expo.modules.ui.LoadingIndicatorContent (LoadingView.kt:25)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(678714391);
                ComposerKt.sourceInformation(composerStartRestartGroup, "27@1108L14");
                jM7348unboximpl = LoadingIndicatorDefaults.INSTANCE.getIndicatorColor(composerStartRestartGroup, LoadingIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(678712717);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            final ObservableState progress = props.getProgress();
            if (progress != null) {
                composerStartRestartGroup.startReplaceGroup(-434604456);
                ComposerKt.sourceInformation(composerStartRestartGroup, "32@1231L53,31@1196L151");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 678718366, "CC(remember):LoadingView.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(progress);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: expo.modules.ui.LoadingViewKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(LoadingViewKt.LoadingIndicatorContent$lambda$1$lambda$0(progress));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LoadingIndicatorKt.m4291LoadingIndicatorcf5BqRc((Function0) objRememberedValue, modifierApplyModifiers, jM7348unboximpl, null, composerStartRestartGroup, 0, 8);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-434441024);
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1363L79");
                LoadingIndicatorKt.m4290LoadingIndicator3IgeMak(modifierApplyModifiers, jM7348unboximpl, null, composerStartRestartGroup, 0, 4);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.LoadingViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingViewKt.LoadingIndicatorContent$lambda$2(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final float LoadingIndicatorContent$lambda$1$lambda$0(ObservableState observableState) {
        Object value = observableState.getValue();
        Number number = value instanceof Number ? (Number) value : null;
        if (number != null) {
            return number.floatValue();
        }
        return 0.0f;
    }

    public static final void ContainedLoadingIndicatorContent(final FunctionalComposableScope functionalComposableScope, final ContainedLoadingIndicatorProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1656221893);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ContainedLoadingIndicatorContent)N(props)58@1885L83:LoadingView.kt#v15e7d");
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
                ComposerKt.traceEventStart(1656221893, i2, -1, "expo.modules.ui.ContainedLoadingIndicatorContent (LoadingView.kt:57)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(-1803617668);
                ComposerKt.sourceInformation(composerStartRestartGroup, "59@2046L23");
                jM7348unboximpl = LoadingIndicatorDefaults.INSTANCE.getContainedIndicatorColor(composerStartRestartGroup, LoadingIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1803619342);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            long j = jM7348unboximpl;
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getContainerColor());
            if (composeOrNull2 == null) {
                composerStartRestartGroup.startReplaceGroup(-1803614148);
                ComposerKt.sourceInformation(composerStartRestartGroup, "60@2156L23");
                jM7348unboximpl2 = LoadingIndicatorDefaults.INSTANCE.getContainedContainerColor(composerStartRestartGroup, LoadingIndicatorDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1803616101);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            }
            final ObservableState progress = props.getProgress();
            if (progress != null) {
                composerStartRestartGroup.startReplaceGroup(-77367421);
                ComposerKt.sourceInformation(composerStartRestartGroup, "65@2297L53,64@2253L208");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1803609606, "CC(remember):LoadingView.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(progress);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: expo.modules.ui.LoadingViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(LoadingViewKt.ContainedLoadingIndicatorContent$lambda$4$lambda$3(progress));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                LoadingIndicatorKt.m4289ContainedLoadingIndicatorY0xEhic((Function0) objRememberedValue, modifierApplyModifiers, jM7348unboximpl2, j, null, null, composerStartRestartGroup, 0, 48);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-77147445);
                ComposerKt.sourceInformation(composerStartRestartGroup, "71@2477L136");
                LoadingIndicatorKt.m4288ContainedLoadingIndicatorDTcfvLk(modifierApplyModifiers, jM7348unboximpl2, j, null, null, composerStartRestartGroup, 0, 24);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.LoadingViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LoadingViewKt.ContainedLoadingIndicatorContent$lambda$5(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final float ContainedLoadingIndicatorContent$lambda$4$lambda$3(ObservableState observableState) {
        Object value = observableState.getValue();
        Number number = value instanceof Number ? (Number) value : null;
        if (number != null) {
            return number.floatValue();
        }
        return 0.0f;
    }
}
