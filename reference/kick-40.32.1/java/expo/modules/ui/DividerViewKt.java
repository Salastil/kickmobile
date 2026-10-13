package expo.modules.ui;

import androidx.compose.material3.DividerDefaults;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DividerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"HorizontalDividerContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/DividerProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/DividerProps;Landroidx/compose/runtime/Composer;I)V", "VerticalDividerContent", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DividerViewKt {
    static final Unit HorizontalDividerContent$lambda$0(FunctionalComposableScope functionalComposableScope, DividerProps dividerProps, int i, Composer composer, int i2) {
        HorizontalDividerContent(functionalComposableScope, dividerProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit VerticalDividerContent$lambda$1(FunctionalComposableScope functionalComposableScope, DividerProps dividerProps, int i, Composer composer, int i2) {
        VerticalDividerContent(functionalComposableScope, dividerProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void HorizontalDividerContent(final FunctionalComposableScope functionalComposableScope, final DividerProps props, Composer composer, final int i) {
        int i2;
        Composer composer2;
        float fM3895getThicknessD9Ej5fM;
        long jM7348unboximpl;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(-905354516);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalDividerContent)N(props)22@759L83,21@708L268:DividerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-905354516, i2, -1, "expo.modules.ui.HorizontalDividerContent (DividerView.kt:20)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Float thickness = props.getThickness();
            if (thickness == null) {
                fM3895getThicknessD9Ej5fM = DividerDefaults.INSTANCE.m3895getThicknessD9Ej5fM();
            } else {
                fM3895getThicknessD9Ej5fM = Dp.m10168constructorimpl(thickness.floatValue());
            }
            float f = fM3895getThicknessD9Ej5fM;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(1832682449);
                ComposerKt.sourceInformation(composerStartRestartGroup, "24@967L5");
                jM7348unboximpl = DividerDefaults.INSTANCE.getColor(composerStartRestartGroup, DividerDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1832681054);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            DividerKt.m3899HorizontalDivider9IZ8Weo(modifierApplyModifiers, f, jM7348unboximpl, composerStartRestartGroup, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DividerViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DividerViewKt.HorizontalDividerContent$lambda$0(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void VerticalDividerContent(final FunctionalComposableScope functionalComposableScope, final DividerProps props, Composer composer, final int i) {
        int i2;
        Composer composer2;
        float fM3895getThicknessD9Ej5fM;
        long jM7348unboximpl;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(690924094);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VerticalDividerContent)N(props)31@1119L83,30@1070L266:DividerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(690924094, i2, -1, "expo.modules.ui.VerticalDividerContent (DividerView.kt:29)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            Float thickness = props.getThickness();
            if (thickness == null) {
                fM3895getThicknessD9Ej5fM = DividerDefaults.INSTANCE.m3895getThicknessD9Ej5fM();
            } else {
                fM3895getThicknessD9Ej5fM = Dp.m10168constructorimpl(thickness.floatValue());
            }
            float f = fM3895getThicknessD9Ej5fM;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(-1741865437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "33@1327L5");
                jM7348unboximpl = DividerDefaults.INSTANCE.getColor(composerStartRestartGroup, DividerDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1741866832);
                composerStartRestartGroup.endReplaceGroup();
                jM7348unboximpl = composeOrNull.m7348unboximpl();
            }
            DividerKt.m3900VerticalDivider9IZ8Weo(modifierApplyModifiers, f, jM7348unboximpl, composerStartRestartGroup, 0, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DividerViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DividerViewKt.VerticalDividerContent$lambda$1(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
