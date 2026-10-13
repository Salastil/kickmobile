package expo.modules.ui;

import androidx.compose.material3.AlertDialogDefaults;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertDialogView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"AlertDialogContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/AlertDialogProps;", "onDismissRequest", "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/AlertDialogProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AlertDialogViewKt {
    static final Unit AlertDialogContent$lambda$11(FunctionalComposableScope functionalComposableScope, AlertDialogProps alertDialogProps, Function0 function0, int i, Composer composer, int i2) {
        AlertDialogContent(functionalComposableScope, alertDialogProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AlertDialogContent(final FunctionalComposableScope functionalComposableScope, final AlertDialogProps props, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        int i2;
        ComposableLambda composableLambdaRememberComposableLambda;
        ComposableLambda composableLambdaRememberComposableLambda2;
        ComposableLambda composableLambda;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        long jM7348unboximpl4;
        float fM3442getTonalElevationD9Ej5fM;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(790970353);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialogContent)N(props,onDismissRequest)55@1952L83,51@1825L22,52@1869L49,50@1789L1385:AlertDialogView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(790970353, i3, -1, "expo.modules.ui.AlertDialogContent (AlertDialogView.kt:43)");
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "title");
            final SlotView slotViewFindChildSlotView2 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "text");
            final SlotView slotViewFindChildSlotView3 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "confirmButton");
            final SlotView slotViewFindChildSlotView4 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "dismissButton");
            final SlotView slotViewFindChildSlotView5 = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "icon");
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposableLambda composableLambdaRememberComposableLambda3 = null;
            if (slotViewFindChildSlotView4 == null) {
                composerStartRestartGroup.startReplaceGroup(1607916747);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1607916748);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*57@2092L19");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-360490510, true, new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogViewKt.AlertDialogContent$lambda$1$lambda$0(slotViewFindChildSlotView4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (slotViewFindChildSlotView == null) {
                composerStartRestartGroup.startReplaceGroup(1607982219);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda2 = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1607982220);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*60@2158L19");
                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-978804267, true, new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogViewKt.AlertDialogContent$lambda$3$lambda$2(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (slotViewFindChildSlotView2 == null) {
                composerStartRestartGroup.startReplaceGroup(1608045707);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1608045708);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*63@2222L19");
                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(22481447, true, new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogViewKt.AlertDialogContent$lambda$5$lambda$4(slotViewFindChildSlotView2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda4;
            }
            if (slotViewFindChildSlotView5 == null) {
                composerStartRestartGroup.startReplaceGroup(1608109195);
            } else {
                composerStartRestartGroup.startReplaceGroup(1608109196);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*66@2286L19");
                composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-1944065508, true, new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AlertDialogViewKt.AlertDialogContent$lambda$7$lambda$6(slotViewFindChildSlotView5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposableLambda composableLambda2 = composableLambdaRememberComposableLambda3;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getContainerColor());
            if (composeOrNull != null) {
                composerStartRestartGroup.startReplaceGroup(-86670874);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-86668673);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@2405L14");
                jM7348unboximpl = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, AlertDialogDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            }
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getIconContentColor());
            if (composeOrNull2 != null) {
                composerStartRestartGroup.startReplaceGroup(-86667350);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-86665087);
                ComposerKt.sourceInformation(composerStartRestartGroup, "71@2517L16");
                jM7348unboximpl2 = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, AlertDialogDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            }
            Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getColors().getTitleContentColor());
            if (composeOrNull3 != null) {
                composerStartRestartGroup.startReplaceGroup(-86663668);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl3 = composeOrNull3.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-86661374);
                ComposerKt.sourceInformation(composerStartRestartGroup, "73@2633L17");
                jM7348unboximpl3 = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, AlertDialogDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            }
            Color composeOrNull4 = UtilsKt.getComposeOrNull(props.getColors().getTextContentColor());
            if (composeOrNull4 != null) {
                composerStartRestartGroup.startReplaceGroup(-86659958);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl4 = composeOrNull4.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-86657695);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@2748L16");
                jM7348unboximpl4 = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, AlertDialogDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            }
            Double tonalElevation = props.getTonalElevation();
            if (tonalElevation == null) {
                fM3442getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m3442getTonalElevationD9Ej5fM();
            } else {
                fM3442getTonalElevationD9Ej5fM = Dp.m10168constructorimpl((float) tonalElevation.doubleValue());
            }
            DialogProperties dialogProperties = new DialogProperties(props.getProperties().getDismissOnBackPress(), props.getProperties().getDismissOnClickOutside(), null, props.getProperties().getUsePlatformDefaultWidth(), props.getProperties().getDecorFitsSystemWindows(), null, 0, null, 228, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -86687225, "CC(remember):AlertDialogView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AlertDialogViewKt.AlertDialogContent$lambda$9$lambda$8(onDismissRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidAlertDialog_androidKt.m3453AlertDialogOix01E0((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(636702777, true, new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogViewKt.AlertDialogContent$lambda$10(slotViewFindChildSlotView3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifierApplyModifiers, composableLambdaRememberComposableLambda, composableLambda2, composableLambdaRememberComposableLambda2, composableLambda, null, jM7348unboximpl, jM7348unboximpl2, jM7348unboximpl3, jM7348unboximpl4, fM3442getTonalElevationD9Ej5fM, dialogProperties, composerStartRestartGroup, 48, 0, 128);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.AlertDialogViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AlertDialogViewKt.AlertDialogContent$lambda$11(functionalComposableScope, props, onDismissRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit AlertDialogContent$lambda$9$lambda$8(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit AlertDialogContent$lambda$10(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:AlertDialogView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(636702777, i, -1, "expo.modules.ui.AlertDialogContent.<anonymous> (AlertDialogView.kt:53)");
            }
            if (slotView == null) {
                composer.startReplaceGroup(1436881596);
            } else {
                composer.startReplaceGroup(1986013669);
                ComposerKt.sourceInformation(composer, "53@1900L12");
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

    static final Unit AlertDialogContent$lambda$1$lambda$0(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C57@2097L12:AlertDialogView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-360490510, i, -1, "expo.modules.ui.AlertDialogContent.<anonymous>.<anonymous> (AlertDialogView.kt:57)");
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

    static final Unit AlertDialogContent$lambda$3$lambda$2(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C60@2163L12:AlertDialogView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-978804267, i, -1, "expo.modules.ui.AlertDialogContent.<anonymous>.<anonymous> (AlertDialogView.kt:60)");
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

    static final Unit AlertDialogContent$lambda$5$lambda$4(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C63@2227L12:AlertDialogView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(22481447, i, -1, "expo.modules.ui.AlertDialogContent.<anonymous>.<anonymous> (AlertDialogView.kt:63)");
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

    static final Unit AlertDialogContent$lambda$7$lambda$6(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2291L12:AlertDialogView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1944065508, i, -1, "expo.modules.ui.AlertDialogContent.<anonymous>.<anonymous> (AlertDialogView.kt:66)");
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
}
