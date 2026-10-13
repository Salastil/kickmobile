package expo.modules.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.NavigationBarDefaults;
import androidx.compose.material3.NavigationBarItemDefaults;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NavigationBarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a'\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"NavigationBarContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/NavigationBarProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/NavigationBarProps;Landroidx/compose/runtime/Composer;I)V", "NavigationBarItemContent", "Lexpo/modules/ui/NavigationBarItemProps;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/NavigationBarItemProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NavigationBarViewKt {
    static final Unit NavigationBarContent$lambda$3(FunctionalComposableScope functionalComposableScope, NavigationBarProps navigationBarProps, int i, Composer composer, int i2) {
        NavigationBarContent(functionalComposableScope, navigationBarProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationBarItemContent$lambda$6(FunctionalComposableScope functionalComposableScope, NavigationBarItemProps navigationBarItemProps, Function0 function0, int i, Composer composer, int i2) {
        NavigationBarItemContent(functionalComposableScope, navigationBarItemProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit NavigationBarItemContent$lambda$9(FunctionalComposableScope functionalComposableScope, NavigationBarItemProps navigationBarItemProps, Function0 function0, int i, Composer composer, int i2) {
        NavigationBarItemContent(functionalComposableScope, navigationBarItemProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NavigationBarContent(final FunctionalComposableScope functionalComposableScope, final NavigationBarProps props, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        float fM4360getElevationD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-21424606);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBarContent)N(props)49@1899L83,56@2252L98,51@1986L364:NavigationBarView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-21424606, i2, -1, "expo.modules.ui.NavigationBarContent (NavigationBarView.kt:47)");
            }
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getContainerColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(885795984);
                ComposerKt.sourceInformation(composerStartRestartGroup, "48@1850L14");
                jM7348unboximpl = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, NavigationBarDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(885794124);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            long j = jM7348unboximpl;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getContentColor());
            if (composeOrNull2 == null) {
                composerStartRestartGroup.startReplaceGroup(885804841);
                ComposerKt.sourceInformation(composerStartRestartGroup, "54@2126L39");
                jM7348unboximpl2 = ColorSchemeKt.m3712contentColorForek8zF_U(j, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(885803725);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            }
            long j2 = jM7348unboximpl2;
            Float tonalElevation = props.getTonalElevation();
            if (tonalElevation == null) {
                fM4360getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m4360getElevationD9Ej5fM();
            } else {
                fM4360getElevationD9Ej5fM = Dp.m10168constructorimpl(tonalElevation.floatValue());
            }
            NavigationBarKt.m4378NavigationBarHsRjFd4(modifierApplyModifiers, j, j2, fM4360getElevationD9Ej5fM, null, ComposableLambdaKt.rememberComposableLambda(263234971, true, new Function3() { // from class: expo.modules.ui.NavigationBarViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NavigationBarViewKt.NavigationBarContent$lambda$2(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.NavigationBarViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarViewKt.NavigationBarContent$lambda$3(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit NavigationBarContent$lambda$2(FunctionalComposableScope functionalComposableScope, RowScope NavigationBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(NavigationBar, "$this$NavigationBar");
        ComposerKt.sourceInformation(composer, "C57@2326L19,57@2258L88:NavigationBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(NavigationBar) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(263234971, i, -1, "expo.modules.ui.NavigationBarContent.<anonymous> (NavigationBarView.kt:57)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(NavigationBar, null, null, null, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, -434260946, "CC(remember):NavigationBarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.NavigationBarViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavigationBarViewKt.NavigationBarContent$lambda$2$lambda$1$lambda$0((ExpoComposeView) obj));
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

    static final boolean NavigationBarContent$lambda$2$lambda$1$lambda$0(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !SlotViewKt.isSlotView(it);
    }

    public static final void NavigationBarItemContent(final FunctionalComposableScope functionalComposableScope, final NavigationBarItemProps props, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        ComposableLambda composableLambdaRememberComposableLambda;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1477326134);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBarItemContent)N(props,onClick)68@2623L83,*76@2967L44,83@3180L738,73@2877L1047:NavigationBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1477326134, i2, -1, "expo.modules.ui.NavigationBarItemContent (NavigationBarView.kt:65)");
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "icon");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "label");
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            if (slotViewFindChildSlotView2 == null) {
                composerStartRestartGroup.startReplaceGroup(493382758);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(493382759);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*69@2777L21");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-898690409, true, new Function2() { // from class: expo.modules.ui.NavigationBarViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarViewKt.NavigationBarItemContent$lambda$5$lambda$4(slotViewFindChildSlotView2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
            RowScope rowScope = UIComposableScopeKt.getRowScope(functionalComposableScope.getComposableScope());
            if (rowScope != null) {
                boolean selected = props.getSelected();
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-299309185, true, new Function2() { // from class: expo.modules.ui.NavigationBarViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarViewKt.NavigationBarItemContent$lambda$8$lambda$7(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                boolean enabled = props.getEnabled();
                boolean alwaysShowLabel = props.getAlwaysShowLabel();
                NavigationBarItemDefaults navigationBarItemDefaults = NavigationBarItemDefaults.INSTANCE;
                Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getSelectedIconColor());
                long jM7348unboximpl = composeOrNull != null ? composeOrNull.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
                Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getSelectedTextColor());
                long jM7348unboximpl2 = composeOrNull2 != null ? composeOrNull2.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
                Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getColors().getSelectedIndicatorColor());
                long jM7348unboximpl3 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
                Color composeOrNull4 = UtilsKt.getComposeOrNull(props.getColors().getUnselectedIconColor());
                long jM7348unboximpl4 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
                Color composeOrNull5 = UtilsKt.getComposeOrNull(props.getColors().getUnselectedTextColor());
                long jM7348unboximpl5 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
                Color composeOrNull6 = UtilsKt.getComposeOrNull(props.getColors().getDisabledIconColor());
                long jM7348unboximpl6 = composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU();
                Color composeOrNull7 = UtilsKt.getComposeOrNull(props.getColors().getDisabledTextColor());
                NavigationBarKt.NavigationBarItem(rowScope, selected, onClick, composableLambdaRememberComposableLambda2, modifierApplyModifiers, enabled, composableLambda, alwaysShowLabel, navigationBarItemDefaults.m4373colors69fazGs(jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, jM7348unboximpl4, jM7348unboximpl5, jM7348unboximpl6, composeOrNull7 != null ? composeOrNull7.m7348unboximpl() : Color.INSTANCE.m7374getUnspecified0d7_KjU(), composerStartRestartGroup, NavigationBarItemDefaults.$stable << 21, 0), null, composerStartRestartGroup, (i2 & 896) | 3072, 256);
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
                    function2 = new Function2() { // from class: expo.modules.ui.NavigationBarViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarViewKt.NavigationBarItemContent$lambda$6(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: expo.modules.ui.NavigationBarViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarViewKt.NavigationBarItemContent$lambda$9(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    static final Unit NavigationBarItemContent$lambda$5$lambda$4(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C69@2784L12:NavigationBarView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-898690409, i, -1, "expo.modules.ui.NavigationBarItemContent.<anonymous>.<anonymous> (NavigationBarView.kt:69)");
            }
            SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit NavigationBarItemContent$lambda$8$lambda$7(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:NavigationBarView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-299309185, i, -1, "expo.modules.ui.NavigationBarItemContent.<anonymous>.<anonymous> (NavigationBarView.kt:77)");
            }
            if (slotView == null) {
                composer.startReplaceGroup(-367799658);
            } else {
                composer.startReplaceGroup(126682827);
                ComposerKt.sourceInformation(composer, "77@2991L12");
                SlotViewKt.renderSlot(slotView, composer, ViewEventDelegate.$stable | ExpoComposeView.$stable);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
