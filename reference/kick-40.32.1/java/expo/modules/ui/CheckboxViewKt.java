package expo.modules.ui;

import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckboxView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"CheckboxContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/CheckboxProps;", "onCheckedChange", "Lkotlin/Function1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/CheckboxProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckboxContent", "Lexpo/modules/ui/TriStateCheckboxProps;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/TriStateCheckboxProps;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CheckboxViewKt {

    /* JADX INFO: compiled from: CheckboxView.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableStateValue.values().length];
            try {
                iArr[ToggleableStateValue.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableStateValue.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableStateValue.INDETERMINATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static final Unit CheckboxContent$lambda$0(FunctionalComposableScope functionalComposableScope, CheckboxProps checkboxProps, Function1 function1, int i, Composer composer, int i2) {
        CheckboxContent(functionalComposableScope, checkboxProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TriStateCheckboxContent$lambda$1(FunctionalComposableScope functionalComposableScope, TriStateCheckboxProps triStateCheckboxProps, Function0 function0, int i, Composer composer, int i2) {
        TriStateCheckboxContent(functionalComposableScope, triStateCheckboxProps, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CheckboxContent(final FunctionalComposableScope functionalComposableScope, final CheckboxProps props, final Function1<? super Boolean, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(414162473);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxContent)N(props,onCheckedChange)47@1531L83,49@1675L420,40@1358L741:CheckboxView.kt#v15e7d");
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
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(414162473, i2, -1, "expo.modules.ui.CheckboxContent (CheckboxView.kt:39)");
            }
            boolean value = props.getValue();
            Function1<? super Boolean, Unit> function1 = props.getNativeClickable() ? onCheckedChange : null;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            boolean enabled = props.getEnabled();
            androidx.compose.material3.CheckboxColors checkboxColorsM3613colors5tl4gsc = CheckboxDefaults.INSTANCE.m3613colors5tl4gsc(UtilsKt.getCompose(props.getColors().getCheckedColor()), UtilsKt.getCompose(props.getColors().getUncheckedColor()), UtilsKt.getCompose(props.getColors().getCheckmarkColor()), UtilsKt.getCompose(props.getColors().getDisabledCheckedColor()), UtilsKt.getCompose(props.getColors().getDisabledUncheckedColor()), UtilsKt.getCompose(props.getColors().getDisabledIndeterminateColor()), composerStartRestartGroup, CheckboxDefaults.$stable << 18, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            CheckboxKt.Checkbox(value, function1, modifierApplyModifiers, enabled, checkboxColorsM3613colors5tl4gsc, null, composerStartRestartGroup, 0, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CheckboxViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxViewKt.CheckboxContent$lambda$0(functionalComposableScope, props, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TriStateCheckboxContent(final FunctionalComposableScope functionalComposableScope, final TriStateCheckboxProps props, final Function0<Unit> onClick, Composer composer, final int i) {
        int i2;
        ToggleableState toggleableState;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(141733852);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TriStateCheckboxContent)N(props,onClick)91@3016L83,93@3160L420,80@2658L926:CheckboxView.kt#v15e7d");
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
                ComposerKt.traceEventStart(141733852, i2, -1, "expo.modules.ui.TriStateCheckboxContent (CheckboxView.kt:79)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[props.getState().ordinal()];
            if (i3 == 1) {
                toggleableState = ToggleableState.On;
            } else if (i3 == 2) {
                toggleableState = ToggleableState.Off;
            } else {
                if (i3 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                toggleableState = ToggleableState.Indeterminate;
            }
            Function0<Unit> function0 = props.getNativeClickable() ? onClick : null;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            boolean enabled = props.getEnabled();
            androidx.compose.material3.CheckboxColors checkboxColorsM3613colors5tl4gsc = CheckboxDefaults.INSTANCE.m3613colors5tl4gsc(UtilsKt.getCompose(props.getColors().getCheckedColor()), UtilsKt.getCompose(props.getColors().getUncheckedColor()), UtilsKt.getCompose(props.getColors().getCheckmarkColor()), UtilsKt.getCompose(props.getColors().getDisabledCheckedColor()), UtilsKt.getCompose(props.getColors().getDisabledUncheckedColor()), UtilsKt.getCompose(props.getColors().getDisabledIndeterminateColor()), composerStartRestartGroup, CheckboxDefaults.$stable << 18, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            CheckboxKt.TriStateCheckbox(toggleableState, function0, modifierApplyModifiers, enabled, checkboxColorsM3613colors5tl4gsc, null, composerStartRestartGroup, 0, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.CheckboxViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CheckboxViewKt.TriStateCheckboxContent$lambda$1(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
