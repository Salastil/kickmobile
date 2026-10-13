package expo.modules.ui.button;

import android.graphics.Color;
import androidx.compose.material3.FloatingActionButtonDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.SlotView;
import expo.modules.ui.SlotViewKt;
import expo.modules.ui.UIComposableScope;
import expo.modules.ui.UtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"FloatingActionButtonContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/button/FloatingActionButtonProps;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/button/FloatingActionButtonProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FloatingActionButtonKt {

    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FloatingActionButtonVariant.values().length];
            try {
                iArr[FloatingActionButtonVariant.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FloatingActionButtonVariant.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FloatingActionButtonVariant.EXTENDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FloatingActionButtonVariant.MEDIUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit FloatingActionButtonContent$lambda$8(FunctionalComposableScope functionalComposableScope, FloatingActionButtonProps floatingActionButtonProps, Function0 function0, int i, Composer composer, int i2) {
        FloatingActionButtonContent(functionalComposableScope, floatingActionButtonProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void FloatingActionButtonContent(final FunctionalComposableScope functionalComposableScope, final FloatingActionButtonProps props, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        long jM7348unboximpl;
        ComposableLambda composableLambdaRememberComposableLambda;
        final Function0<Unit> onClick = function0;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1829926430);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FloatingActionButtonContent)N(props,onClick)40@1495L83:FloatingActionButton.kt#kazlex");
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
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1829926430, i3, -1, "expo.modules.ui.button.FloatingActionButtonContent (FloatingActionButton.kt:38)");
            }
            Color containerColor = props.getContainerColor();
            ComposableLambda composableLambdaRememberComposableLambda2 = null;
            androidx.compose.ui.graphics.Color colorM7328boximpl = containerColor != null ? androidx.compose.ui.graphics.Color.m7328boximpl(UtilsKt.getCompose(containerColor)) : null;
            if (colorM7328boximpl == null) {
                composerStartRestartGroup.startReplaceGroup(-1917668176);
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1446L14");
                jM7348unboximpl = FloatingActionButtonDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, FloatingActionButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1917670098);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = colorM7328boximpl.m7348unboximpl();
            }
            long j = jM7348unboximpl;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "icon");
            if (slotViewFindChildSlotView == null) {
                composerStartRestartGroup.startReplaceGroup(682076751);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(682076752);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*44@1703L98");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1754245384, true, new Function2() { // from class: expo.modules.ui.button.FloatingActionButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FloatingActionButtonKt.FloatingActionButtonContent$lambda$3$lambda$2(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (composableLambdaRememberComposableLambda == null) {
                composableLambdaRememberComposableLambda = ComposableSingletons$FloatingActionButtonKt.INSTANCE.getLambda$2023503970$expo_ui_release();
            }
            int i4 = WhenMappings.$EnumSwitchMapping$0[props.getVariant().ordinal()];
            if (i4 == 1) {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(-1917654183);
                ComposerKt.sourceInformation(composerStartRestartGroup, "54@1879L151");
                onClick = function0;
                androidx.compose.material3.FloatingActionButtonKt.m4003SmallFloatingActionButtonXz6DiA(onClick, modifierApplyModifiers, null, j, 0L, null, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, (i3 >> 6) & 14, 116);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i4 != 2) {
                if (i4 == 3) {
                    Function2<Composer, Integer, Unit> function2 = composableLambdaRememberComposableLambda;
                    composerStartRestartGroup.startReplaceGroup(682659490);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2548L224");
                    final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "text");
                    if (slotViewFindChildSlotView2 == null) {
                        composerStartRestartGroup.startReplaceGroup(682770159);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(682770160);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*69@2405L122");
                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-880721783, true, new Function2() { // from class: expo.modules.ui.button.FloatingActionButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return FloatingActionButtonKt.FloatingActionButtonContent$lambda$7$lambda$6(slotViewFindChildSlotView2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (composableLambdaRememberComposableLambda2 == null) {
                        composableLambdaRememberComposableLambda2 = ComposableSingletons$FloatingActionButtonKt.INSTANCE.getLambda$84818774$expo_ui_release();
                    }
                    androidx.compose.material3.FloatingActionButtonKt.m3990ExtendedFloatingActionButtonElI57k(composableLambdaRememberComposableLambda2, function2, function0, modifierApplyModifiers, props.getExpanded(), null, j, 0L, null, null, composerStartRestartGroup, i3 & 896, 928);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (i4 != 4) {
                        composerStartRestartGroup.startReplaceGroup(-1917655226);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-1917624044);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "86@2821L146");
                    composerStartRestartGroup = composerStartRestartGroup;
                    androidx.compose.material3.FloatingActionButtonKt.m3993FloatingActionButtonXz6DiA(onClick, modifierApplyModifiers, null, j, 0L, null, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, (i3 >> 6) & 14, 116);
                    composerStartRestartGroup.endReplaceGroup();
                }
                onClick = function0;
            } else {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(-1917648007);
                ComposerKt.sourceInformation(composerStartRestartGroup, "60@2072L151");
                onClick = function0;
                androidx.compose.material3.FloatingActionButtonKt.m3997LargeFloatingActionButtonXz6DiA(onClick, modifierApplyModifiers, null, j, 0L, null, null, composableLambdaRememberComposableLambda, composerStartRestartGroup, (i3 >> 6) & 14, 116);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.FloatingActionButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FloatingActionButtonKt.FloatingActionButtonContent$lambda$8(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit FloatingActionButtonContent$lambda$3$lambda$2(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:FloatingActionButton.kt#kazlex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1754245384, i, -1, "expo.modules.ui.button.FloatingActionButtonContent.<anonymous>.<anonymous> (FloatingActionButton.kt:45)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(2092334752);
            ComposerKt.sourceInformation(composer, "*47@1768L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit FloatingActionButtonContent$lambda$7$lambda$6(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:FloatingActionButton.kt#kazlex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880721783, i, -1, "expo.modules.ui.button.FloatingActionButtonContent.<anonymous>.<anonymous> (FloatingActionButton.kt:70)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-265074439);
            ComposerKt.sourceInformation(composer, "*72@2482L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
