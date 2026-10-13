package expo.modules.ui;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.SearchBarDefaults;
import androidx.compose.material3.SearchBarKt;
import androidx.compose.material3.SearchBarState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.datadog.android.rum.timeseries.TimeseriesConfiguration;
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

/* JADX INFO: compiled from: SearchBarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"SearchBarContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SearchBarProps;", "onSearch", "Lkotlin/Function1;", "Lexpo/modules/ui/GenericEventPayload1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SearchBarProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ExpandedFullScreenSearchBarView", "composableScope", "Lexpo/modules/ui/UIComposableScope;", "view", "Lexpo/modules/ui/SlotView;", "(Lexpo/modules/ui/UIComposableScope;Lexpo/modules/ui/SlotView;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SearchBarViewKt {
    static final Unit ExpandedFullScreenSearchBarView$lambda$11(UIComposableScope uIComposableScope, SlotView slotView, int i, Composer composer, int i2) {
        ExpandedFullScreenSearchBarView(uIComposableScope, slotView, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SearchBarContent$lambda$8(FunctionalComposableScope functionalComposableScope, SearchBarProps searchBarProps, Function1 function1, int i, Composer composer, int i2) {
        SearchBarContent(functionalComposableScope, searchBarProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SearchBarContent(final FunctionalComposableScope functionalComposableScope, final SearchBarProps props, final Function1<? super GenericEventPayload1<String>, Unit> onSearch, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onSearch, "onSearch");
        Composer composerStartRestartGroup = composer.startRestartGroup(371565385);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SearchBarContent)N(props,onSearch)22@887L24,23@935L24,26@996L333,39@1432L83,36@1332L187:SearchBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onSearch) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(371565385, i2, -1, "expo.modules.ui.SearchBarContent (SearchBarView.kt:21)");
            }
            final SearchBarState searchBarStateRememberSearchBarState = SearchBarKt.rememberSearchBarState(null, null, null, composerStartRestartGroup, 0, 7);
            final TextFieldState textFieldStateM3028rememberTextFieldStateLepunE = TextFieldStateKt.m3028rememberTextFieldStateLepunE(null, 0L, composerStartRestartGroup, 0, 3);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-316915073, true, new Function2() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarViewKt.SearchBarContent$lambda$5(textFieldStateM3028rememberTextFieldStateLepunE, searchBarStateRememberSearchBarState, onSearch, functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            SearchBarKt.m4589SearchBarnbWgWpA(searchBarStateRememberSearchBarState, composableLambdaRememberComposableLambda, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3), null, null, 0.0f, 0.0f, composerStartRestartGroup, 48, TimeseriesConfiguration.DEFAULT_BUFFER_SIZE);
            composerStartRestartGroup = composerStartRestartGroup;
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "expandedFullScreenSearchBar");
            if (slotViewFindChildSlotView == null) {
                composerStartRestartGroup.startReplaceGroup(1174582483);
            } else {
                composerStartRestartGroup.startReplaceGroup(1174582484);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*47@1768L76,44@1673L171");
                SearchBarKt.m4585ExpandedFullScreenSearchBar_UtchM0(searchBarStateRememberSearchBarState, composableLambdaRememberComposableLambda, null, null, null, 0.0f, 0.0f, null, null, ComposableLambdaKt.rememberComposableLambda(-1850969304, true, new Function3() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SearchBarViewKt.SearchBarContent$lambda$7$lambda$6(slotViewFindChildSlotView, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, TypedValues.Position.TYPE_CURVE_FIT);
                composerStartRestartGroup = composerStartRestartGroup;
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarViewKt.SearchBarContent$lambda$8(functionalComposableScope, props, onSearch, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SearchBarContent$lambda$5(TextFieldState textFieldState, SearchBarState searchBarState, final Function1 function1, final FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C30@1135L57,31@1216L99,27@1022L301:SearchBarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-316915073, i, -1, "expo.modules.ui.SearchBarContent.<anonymous> (SearchBarView.kt:27)");
            }
            SearchBarDefaults searchBarDefaults = SearchBarDefaults.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 387297368, "CC(remember):SearchBarView.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SearchBarViewKt.SearchBarContent$lambda$5$lambda$1$lambda$0(function1, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            searchBarDefaults.InputField(textFieldState, searchBarState, (Function1) objRememberedValue, null, false, false, null, ComposableLambdaKt.rememberComposableLambda(-853294493, true, new Function2() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarViewKt.SearchBarContent$lambda$5$lambda$4(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, null, null, null, null, null, null, null, null, null, null, composer, 12582912, 0, SearchBarDefaults.$stable, 1048440);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit SearchBarContent$lambda$5$lambda$1$lambda$0(Function1 function1, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        function1.invoke(new GenericEventPayload1(value));
        return Unit.INSTANCE;
    }

    static final Unit SearchBarContent$lambda$5$lambda$4(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C32@1267L37,32@1228L77:SearchBarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-853294493, i, -1, "expo.modules.ui.SearchBarContent.<anonymous>.<anonymous> (SearchBarView.kt:32)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 322747432, "CC(remember):SearchBarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SearchBarViewKt.SearchBarContent$lambda$5$lambda$4$lambda$3$lambda$2((ExpoComposeView) obj));
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

    static final boolean SearchBarContent$lambda$5$lambda$4$lambda$3$lambda$2(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SlotViewKt.isSlotWithName(it, "placeholder");
    }

    static final Unit SearchBarContent$lambda$7$lambda$6(SlotView slotView, ColumnScope ExpandedFullScreenSearchBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ExpandedFullScreenSearchBar, "$this$ExpandedFullScreenSearchBar");
        ComposerKt.sourceInformation(composer, "C48@1776L62:SearchBarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1850969304, i, -1, "expo.modules.ui.SearchBarContent.<anonymous>.<anonymous> (SearchBarView.kt:48)");
            }
            ExpandedFullScreenSearchBarView(new UIComposableScope(null, null, null, null, 15, null), slotView, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ExpandedFullScreenSearchBarView(final UIComposableScope uIComposableScope, final SlotView slotView, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1686571609);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpandedFullScreenSearchBarView)N(composableScope,view):SearchBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(uIComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(slotView) : composerStartRestartGroup.changedInstance(slotView) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1686571609, i2, -1, "expo.modules.ui.ExpandedFullScreenSearchBarView (SearchBarView.kt:54)");
            }
            composerStartRestartGroup.startReplaceGroup(-1592641143);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*57@2011L9");
            slotView.Content(uIComposableScope, composerStartRestartGroup, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SearchBarViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SearchBarViewKt.ExpandedFullScreenSearchBarView$lambda$11(uIComposableScope, slotView, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
