package expo.modules.ui;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.SearchBarDefaults;
import androidx.compose.material3.SearchBarKt;
import androidx.compose.material3.SearchBarState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DockedSearchBarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"DockedSearchBarContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/DockedSearchBarProps;", "onQueryChange", "Lkotlin/Function1;", "Lexpo/modules/ui/GenericEventPayload1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/DockedSearchBarProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DockedSearchBarViewKt {
    static final Unit DockedSearchBarContent$lambda$12(FunctionalComposableScope functionalComposableScope, DockedSearchBarProps dockedSearchBarProps, Function1 function1, int i, Composer composer, int i2) {
        DockedSearchBarContent(functionalComposableScope, dockedSearchBarProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DockedSearchBarContent(final FunctionalComposableScope functionalComposableScope, final DockedSearchBarProps props, final Function1<? super GenericEventPayload1<String>, Unit> onQueryChange, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onQueryChange, "onQueryChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(726740923);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DockedSearchBarContent)N(props,onQueryChange)27@993L24,28@1041L24,30@1090L116,30@1069L137,51@1740L83,38@1305L401,37@1272L2,35@1210L620:DockedSearchBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onQueryChange) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(726740923, i3, -1, "expo.modules.ui.DockedSearchBarContent (DockedSearchBarView.kt:26)");
            }
            final SearchBarState searchBarStateRememberSearchBarState = SearchBarKt.rememberSearchBarState(null, null, null, composerStartRestartGroup, 0, 7);
            final TextFieldState textFieldStateM3028rememberTextFieldStateLepunE = TextFieldStateKt.m3028rememberTextFieldStateLepunE(null, 0L, composerStartRestartGroup, 0, 3);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1681633265, "CC(remember):DockedSearchBarView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textFieldStateM3028rememberTextFieldStateLepunE) | ((i3 & 896) == 256);
            DockedSearchBarViewKt$DockedSearchBarContent$1$1 dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue = new DockedSearchBarViewKt$DockedSearchBarContent$1$1(textFieldStateM3028rememberTextFieldStateLepunE, onQueryChange, null);
                composerStartRestartGroup.updateRememberedValue(dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue, composerStartRestartGroup, 6);
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-307730611, true, new Function2() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DockedSearchBarViewKt.DockedSearchBarContent$lambda$9(textFieldStateM3028rememberTextFieldStateLepunE, searchBarStateRememberSearchBarState, functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1681627555, "CC(remember):DockedSearchBarView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        ((Boolean) obj).booleanValue();
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SearchBarKt.m4577DockedSearchBarEQC0FA8(composableLambdaRememberComposableLambda, false, (Function1) objRememberedValue, modifierApplyModifiers, null, null, 0.0f, 0.0f, ComposableSingletons$DockedSearchBarViewKt.INSTANCE.getLambda$304213221$expo_ui_release(), composerStartRestartGroup, 100663734, 240);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DockedSearchBarViewKt.DockedSearchBarContent$lambda$12(functionalComposableScope, props, onQueryChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DockedSearchBarContent$lambda$9(TextFieldState textFieldState, SearchBarState searchBarState, final FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C42@1444L2,43@1470L99,46@1593L99,39@1331L369:DockedSearchBarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-307730611, i, -1, "expo.modules.ui.DockedSearchBarContent.<anonymous> (DockedSearchBarView.kt:39)");
            }
            SearchBarDefaults searchBarDefaults = SearchBarDefaults.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 623630703, "CC(remember):DockedSearchBarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DockedSearchBarViewKt.DockedSearchBarContent$lambda$9$lambda$2$lambda$1((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            searchBarDefaults.InputField(textFieldState, searchBarState, (Function1) objRememberedValue, null, false, false, null, ComposableLambdaKt.rememberComposableLambda(1645871153, true, new Function2() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DockedSearchBarViewKt.DockedSearchBarContent$lambda$9$lambda$5(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-1139074318, true, new Function2() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DockedSearchBarViewKt.DockedSearchBarContent$lambda$9$lambda$8(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, null, null, null, null, null, null, null, null, null, composer, 113246592, 0, SearchBarDefaults.$stable, 1048184);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBarContent$lambda$9$lambda$2$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    static final Unit DockedSearchBarContent$lambda$9$lambda$5(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C44@1521L37,44@1482L77:DockedSearchBarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1645871153, i, -1, "expo.modules.ui.DockedSearchBarContent.<anonymous>.<anonymous> (DockedSearchBarView.kt:44)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1134214774, "CC(remember):DockedSearchBarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DockedSearchBarViewKt.DockedSearchBarContent$lambda$9$lambda$5$lambda$4$lambda$3((ExpoComposeView) obj));
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

    static final boolean DockedSearchBarContent$lambda$9$lambda$5$lambda$4$lambda$3(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SlotViewKt.isSlotWithName(it, "placeholder");
    }

    static final Unit DockedSearchBarContent$lambda$9$lambda$8(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C47@1644L37,47@1605L77:DockedSearchBarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1139074318, i, -1, "expo.modules.ui.DockedSearchBarContent.<anonymous>.<anonymous> (DockedSearchBarView.kt:47)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 566242551, "CC(remember):DockedSearchBarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DockedSearchBarViewKt.DockedSearchBarContent$lambda$9$lambda$8$lambda$7$lambda$6((ExpoComposeView) obj));
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

    static final boolean DockedSearchBarContent$lambda$9$lambda$8$lambda$7$lambda$6(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SlotViewKt.isSlotWithName(it, "leadingIcon");
    }
}
