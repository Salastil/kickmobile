package expo.modules.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.FloatingToolbarColors;
import androidx.compose.material3.FloatingToolbarDefaults;
import androidx.compose.material3.FloatingToolbarKt;
import androidx.compose.material3.FloatingToolbarScrollBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"HorizontalFloatingToolbarContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/HorizontalFloatingToolbarProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/HorizontalFloatingToolbarProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HorizontalFloatingToolbarViewKt {

    /* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HorizontalFloatingToolbarVariant.values().length];
            try {
                iArr[HorizontalFloatingToolbarVariant.VIBRANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit HorizontalFloatingToolbarContent$lambda$15(FunctionalComposableScope functionalComposableScope, HorizontalFloatingToolbarProps horizontalFloatingToolbarProps, int i, Composer composer, int i2) {
        HorizontalFloatingToolbarContent(functionalComposableScope, horizontalFloatingToolbarProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void HorizontalFloatingToolbarContent(final FunctionalComposableScope functionalComposableScope, final HorizontalFloatingToolbarProps props, Composer composer, final int i) {
        int i2;
        boolean z;
        FloatingToolbarColors floatingToolbarColorsM4029standardFloatingToolbarColorsro_MJ88;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1356050480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalFloatingToolbarContent)N(props)61@2473L48,65@2564L690,86@3386L83:HorizontalFloatingToolbarView.kt#v15e7d");
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
                ComposerKt.traceEventStart(1356050480, i2, -1, "expo.modules.ui.HorizontalFloatingToolbarContent (HorizontalFloatingToolbarView.kt:43)");
            }
            HorizontalFloatingToolbarVariant variant = props.getVariant();
            if ((variant != null ? WhenMappings.$EnumSwitchMapping$0[variant.ordinal()] : -1) == 1) {
                composerStartRestartGroup.startReplaceGroup(1789428130);
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1663L306");
                z = true;
                floatingToolbarColorsM4029standardFloatingToolbarColorsro_MJ88 = FloatingToolbarDefaults.INSTANCE.m4030vibrantFloatingToolbarColorsro_MJ88(UtilsKt.getCompose(props.getColors().getToolbarContainerColor()), UtilsKt.getCompose(props.getColors().getToolbarContentColor()), UtilsKt.getCompose(props.getColors().getFabContainerColor()), UtilsKt.getCompose(props.getColors().getFabContentColor()), composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                z = true;
                composerStartRestartGroup.startReplaceGroup(1789439107);
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2006L307");
                floatingToolbarColorsM4029standardFloatingToolbarColorsro_MJ88 = FloatingToolbarDefaults.INSTANCE.m4029standardFloatingToolbarColorsro_MJ88(UtilsKt.getCompose(props.getColors().getToolbarContainerColor()), UtilsKt.getCompose(props.getColors().getToolbarContentColor()), UtilsKt.getCompose(props.getColors().getFabContainerColor()), UtilsKt.getCompose(props.getColors().getFabContentColor()), composerStartRestartGroup, FloatingToolbarDefaults.$stable << 12, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            final FloatingToolbarColors floatingToolbarColors = floatingToolbarColorsM4029standardFloatingToolbarColorsro_MJ88;
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "floatingActionButton");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1789453792, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(slotViewFindChildSlotView);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$1$lambda$0(slotViewFindChildSlotView);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1570128376, z, new Function2() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$8(props, function0, floatingToolbarColors, functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            NestedScrollConnection nestedScrollConnection = UIComposableScopeKt.getNestedScrollConnection(functionalComposableScope.getComposableScope());
            FloatingToolbarScrollBehavior floatingToolbarScrollBehavior = nestedScrollConnection instanceof FloatingToolbarScrollBehavior ? (FloatingToolbarScrollBehavior) nestedScrollConnection : null;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            if (slotViewFindChildSlotView != null) {
                composerStartRestartGroup.startReplaceGroup(-360483364);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@3699L73,89@3504L268");
                FloatingToolbarKt.m4068HorizontalFloatingToolbarekznXB8(true, composableLambdaRememberComposableLambda, modifierApplyModifiers, floatingToolbarColors, null, floatingToolbarScrollBehavior, null, 0, null, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-754015553, z, new Function3() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$11(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 54, 48, 2000);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-360203217);
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@3932L73,99@3788L217");
                FloatingToolbarKt.m4067HorizontalFloatingToolbarLJWHXA8(true, modifierApplyModifiers, floatingToolbarColors, null, floatingToolbarScrollBehavior, null, null, null, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1063106219, z, new Function3() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$14(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6, 6, 1000);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$15(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit HorizontalFloatingToolbarContent$lambda$1$lambda$0(SlotView slotView) {
        ViewEventCallback<Unit> onSlotEvent$expo_ui_release;
        if (slotView != null && (onSlotEvent$expo_ui_release = slotView.getOnSlotEvent$expo_ui_release()) != null) {
            onSlotEvent$expo_ui_release.invoke(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    static final Unit HorizontalFloatingToolbarContent$lambda$8(HorizontalFloatingToolbarProps horizontalFloatingToolbarProps, Function0 function0, FloatingToolbarColors floatingToolbarColors, final FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:HorizontalFloatingToolbarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1570128376, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous> (HorizontalFloatingToolbarView.kt:66)");
            }
            HorizontalFloatingToolbarVariant variant = horizontalFloatingToolbarProps.getVariant();
            if ((variant != null ? WhenMappings.$EnumSwitchMapping$0[variant.ordinal()] : -1) == 1) {
                composer.startReplaceGroup(-1359844876);
                ComposerKt.sourceInformation(composer, "71@2831L104,67@2667L268");
                FloatingToolbarDefaults.INSTANCE.m4018VibrantFloatingActionButtonvRFhKjU(function0, null, null, floatingToolbarColors.getFabContainerColor(), floatingToolbarColors.getFabContentColor(), null, ComposableLambdaKt.rememberComposableLambda(443807521, true, new Function2() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$8$lambda$4(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, (FloatingToolbarDefaults.$stable << 21) | 1572864, 38);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1359835019);
                ComposerKt.sourceInformation(composer, "79@3140L104,75@2975L269");
                FloatingToolbarDefaults.INSTANCE.m4017StandardFloatingActionButtonvRFhKjU(function0, null, null, floatingToolbarColors.getFabContainerColor(), floatingToolbarColors.getFabContentColor(), null, ComposableLambdaKt.rememberComposableLambda(1784730855, true, new Function2() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$8$lambda$7(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, (FloatingToolbarDefaults.$stable << 21) | 1572864, 38);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit HorizontalFloatingToolbarContent$lambda$8$lambda$4(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@2880L46,72@2841L86:HorizontalFloatingToolbarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(443807521, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous>.<anonymous> (HorizontalFloatingToolbarView.kt:72)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1297266991, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$8$lambda$4$lambda$3$lambda$2((ExpoComposeView) obj));
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

    static final boolean HorizontalFloatingToolbarContent$lambda$8$lambda$4$lambda$3$lambda$2(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SlotViewKt.isSlotWithName(it, "floatingActionButton");
    }

    static final Unit HorizontalFloatingToolbarContent$lambda$8$lambda$7(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3189L46,80@3150L86:HorizontalFloatingToolbarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1784730855, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous>.<anonymous> (HorizontalFloatingToolbarView.kt:80)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1434402165, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$8$lambda$7$lambda$6$lambda$5((ExpoComposeView) obj));
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

    static final boolean HorizontalFloatingToolbarContent$lambda$8$lambda$7$lambda$6$lambda$5(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return SlotViewKt.isSlotWithName(it, "floatingActionButton");
    }

    static final Unit HorizontalFloatingToolbarContent$lambda$11(FunctionalComposableScope functionalComposableScope, RowScope HorizontalFloatingToolbar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(HorizontalFloatingToolbar, "$this$HorizontalFloatingToolbar");
        ComposerKt.sourceInformation(composer, "C96@3746L19,96@3707L59:HorizontalFloatingToolbarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-754015553, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous> (HorizontalFloatingToolbarView.kt:96)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1240528114, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$11$lambda$10$lambda$9((ExpoComposeView) obj));
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

    static final boolean HorizontalFloatingToolbarContent$lambda$11$lambda$10$lambda$9(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !SlotViewKt.isSlotView(it);
    }

    static final Unit HorizontalFloatingToolbarContent$lambda$14(FunctionalComposableScope functionalComposableScope, RowScope HorizontalFloatingToolbar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(HorizontalFloatingToolbar, "$this$HorizontalFloatingToolbar");
        ComposerKt.sourceInformation(composer, "C105@3979L19,105@3940L59:HorizontalFloatingToolbarView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1063106219, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous> (HorizontalFloatingToolbarView.kt:105)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            ComposerKt.sourceInformationMarkerStart(composer, 557141512, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$14$lambda$13$lambda$12((ExpoComposeView) obj));
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

    static final boolean HorizontalFloatingToolbarContent$lambda$14$lambda$13$lambda$12(ExpoComposeView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return !SlotViewKt.isSlotView(it);
    }
}
