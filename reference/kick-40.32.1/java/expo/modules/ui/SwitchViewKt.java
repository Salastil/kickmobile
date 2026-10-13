package expo.modules.ui;

import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwitchView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"SwitchContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SwitchProps;", "onCheckedChange", "Lkotlin/Function1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SwitchProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SwitchViewKt {
    static final Unit SwitchContent$lambda$4(FunctionalComposableScope functionalComposableScope, SwitchProps switchProps, Function1 function1, int i, Composer composer, int i2) {
        SwitchContent(functionalComposableScope, switchProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SwitchContent(final FunctionalComposableScope functionalComposableScope, final SwitchProps props, final Function1<? super Boolean, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        ComposableLambda composableLambdaRememberComposableLambda;
        long jM7348unboximpl;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        long jM7348unboximpl4;
        long jM7348unboximpl5;
        long jM7348unboximpl6;
        long jM7348unboximpl7;
        long jM7348unboximpl8;
        long jM7348unboximpl9;
        long jM7348unboximpl10;
        long jM7348unboximpl11;
        long jM7348unboximpl12;
        long jM7348unboximpl13;
        long jM7348unboximpl14;
        long jM7348unboximpl15;
        long jM7348unboximpl16;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(2013740342);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchContent)N(props,onCheckedChange)57@2022L83,68@2335L2252,54@1916L2675:SwitchView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCheckedChange) ? 256 : 128;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2013740342, i3, -1, "expo.modules.ui.SwitchContent (SwitchView.kt:51)");
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "thumbContent");
            boolean value = props.getValue();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            boolean enabled = props.getEnabled();
            if (slotViewFindChildSlotView == null) {
                composerStartRestartGroup.startReplaceGroup(-764208661);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-764208660);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*60@2189L110");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1203318188, true, new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwitchViewKt.SwitchContent$lambda$3$lambda$2(slotViewFindChildSlotView, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
            SwitchDefaults switchDefaults = SwitchDefaults.INSTANCE;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColors().getCheckedThumbColor());
            if (composeOrNull != null) {
                composerStartRestartGroup.startReplaceGroup(-1825761097);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825758617);
                ComposerKt.sourceInformation(composerStartRestartGroup, "70@2440L8");
                jM7348unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j = jM7348unboximpl;
            Color composeOrNull2 = UtilsKt.getComposeOrNull(props.getColors().getCheckedTrackColor());
            if (composeOrNull2 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825757097);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl2 = composeOrNull2.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825754617);
                ComposerKt.sourceInformation(composerStartRestartGroup, "72@2565L8");
                jM7348unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j2 = jM7348unboximpl2;
            Color composeOrNull3 = UtilsKt.getComposeOrNull(props.getColors().getCheckedBorderColor());
            if (composeOrNull3 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825753063);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl3 = composeOrNull3.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825750552);
                ComposerKt.sourceInformation(composerStartRestartGroup, "74@2692L8");
                jM7348unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedBorderColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j3 = jM7348unboximpl3;
            Color composeOrNull4 = UtilsKt.getComposeOrNull(props.getColors().getCheckedIconColor());
            if (composeOrNull4 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825749035);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl4 = composeOrNull4.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825746586);
                ComposerKt.sourceInformation(composerStartRestartGroup, "76@2816L8");
                jM7348unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedIconColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j4 = jM7348unboximpl4;
            Color composeOrNull5 = UtilsKt.getComposeOrNull(props.getColors().getUncheckedThumbColor());
            if (composeOrNull5 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825745029);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl5 = composeOrNull5.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825742487);
                ComposerKt.sourceInformation(composerStartRestartGroup, "78@2944L8");
                jM7348unboximpl5 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j5 = jM7348unboximpl5;
            Color composeOrNull6 = UtilsKt.getComposeOrNull(props.getColors().getUncheckedTrackColor());
            if (composeOrNull6 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825740837);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl6 = composeOrNull6.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825738295);
                ComposerKt.sourceInformation(composerStartRestartGroup, "80@3075L8");
                jM7348unboximpl6 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j6 = jM7348unboximpl6;
            Color composeOrNull7 = UtilsKt.getComposeOrNull(props.getColors().getUncheckedBorderColor());
            if (composeOrNull7 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825736611);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl7 = composeOrNull7.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825734038);
                ComposerKt.sourceInformation(composerStartRestartGroup, "82@3208L8");
                jM7348unboximpl7 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedBorderColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j7 = jM7348unboximpl7;
            Color composeOrNull8 = UtilsKt.getComposeOrNull(props.getColors().getUncheckedIconColor());
            if (composeOrNull8 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825732391);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl8 = composeOrNull8.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825729880);
                ComposerKt.sourceInformation(composerStartRestartGroup, "84@3338L8");
                jM7348unboximpl8 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedIconColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j8 = jM7348unboximpl8;
            Color composeOrNull9 = UtilsKt.getComposeOrNull(props.getColors().getDisabledCheckedBorderColor());
            if (composeOrNull9 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825728023);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl9 = composeOrNull9.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825725264);
                ComposerKt.sourceInformation(composerStartRestartGroup, "86@3482L8");
                jM7348unboximpl9 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledCheckedBorderColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j9 = jM7348unboximpl9;
            Color composeOrNull10 = UtilsKt.getComposeOrNull(props.getColors().getDisabledCheckedThumbColor());
            if (composeOrNull10 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825723193);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl10 = composeOrNull10.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825720465);
                ComposerKt.sourceInformation(composerStartRestartGroup, "88@3632L8");
                jM7348unboximpl10 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledCheckedThumbColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j10 = jM7348unboximpl10;
            Color composeOrNull11 = UtilsKt.getComposeOrNull(props.getColors().getDisabledCheckedTrackColor());
            if (composeOrNull11 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825718425);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl11 = composeOrNull11.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825715697);
                ComposerKt.sourceInformation(composerStartRestartGroup, "90@3781L8");
                jM7348unboximpl11 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledCheckedTrackColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j11 = jM7348unboximpl11;
            Color composeOrNull12 = UtilsKt.getComposeOrNull(props.getColors().getDisabledCheckedIconColor());
            if (composeOrNull12 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825713691);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl12 = composeOrNull12.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825710994);
                ComposerKt.sourceInformation(composerStartRestartGroup, "92@3928L8");
                jM7348unboximpl12 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledCheckedIconColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j12 = jM7348unboximpl12;
            Color composeOrNull13 = UtilsKt.getComposeOrNull(props.getColors().getDisabledUncheckedBorderColor());
            if (composeOrNull13 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825708883);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl13 = composeOrNull13.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825706062);
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4082L8");
                jM7348unboximpl13 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledUncheckedBorderColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j13 = jM7348unboximpl13;
            Color composeOrNull14 = UtilsKt.getComposeOrNull(props.getColors().getDisabledUncheckedThumbColor());
            if (composeOrNull14 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825703861);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl14 = composeOrNull14.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825701071);
                ComposerKt.sourceInformation(composerStartRestartGroup, "96@4238L8");
                jM7348unboximpl14 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledUncheckedThumbColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j14 = jM7348unboximpl14;
            Color composeOrNull15 = UtilsKt.getComposeOrNull(props.getColors().getDisabledUncheckedTrackColor());
            if (composeOrNull15 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825698901);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl15 = composeOrNull15.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825696111);
                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4393L8");
                jM7348unboximpl15 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledUncheckedTrackColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            long j15 = jM7348unboximpl15;
            Color composeOrNull16 = UtilsKt.getComposeOrNull(props.getColors().getDisabledUncheckedIconColor());
            if (composeOrNull16 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825693975);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl16 = composeOrNull16.m7348unboximpl();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825691216);
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@4546L8");
                jM7348unboximpl16 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getDisabledUncheckedIconColor();
                composerStartRestartGroup.endReplaceGroup();
            }
            SwitchKt.Switch(value, onCheckedChange, modifierApplyModifiers, composableLambda, enabled, switchDefaults.m4813colorsV1nXRL4(j, j2, j3, j4, j5, j6, j7, j8, j10, j11, j9, j12, j14, j15, j13, jM7348unboximpl16, composerStartRestartGroup, 0, SwitchDefaults.$stable << 18, 0), null, composerStartRestartGroup, (i3 >> 3) & 112, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwitchViewKt.SwitchContent$lambda$4(functionalComposableScope, props, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SwitchContent$lambda$3$lambda$2(SlotView slotView, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:SwitchView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1203318188, i, -1, "expo.modules.ui.SwitchContent.<anonymous>.<anonymous> (SwitchView.kt:61)");
            }
            UIComposableScope uIComposableScope = new UIComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(-1042574464);
            ComposerKt.sourceInformation(composer, "*63@2260L9");
            slotView.Content(uIComposableScope, composer, (ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
