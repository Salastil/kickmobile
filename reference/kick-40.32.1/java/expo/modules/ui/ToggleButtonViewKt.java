package expo.modules.ui;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconToggleButtonColors;
import androidx.compose.material3.ToggleButtonDefaults;
import androidx.compose.material3.ToggleButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.facebook.imageutils.JfifUtil;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToggleButtonView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\f"}, d2 = {"ToggleButtonContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/ToggleButtonProps;", "onCheckedChange", "Lkotlin/Function1;", "Lexpo/modules/ui/ToggleButtonValueChangeEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/ToggleButtonProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "IconToggleButtonContent", "FilledIconToggleButtonContent", "OutlinedIconToggleButtonContent", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ToggleButtonViewKt {
    static final Unit FilledIconToggleButtonContent$lambda$11(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Function1 function1, int i, Composer composer, int i2) {
        FilledIconToggleButtonContent(functionalComposableScope, toggleButtonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit IconToggleButtonContent$lambda$7(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Function1 function1, int i, Composer composer, int i2) {
        IconToggleButtonContent(functionalComposableScope, toggleButtonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit OutlinedIconToggleButtonContent$lambda$15(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Function1 function1, int i, Composer composer, int i2) {
        OutlinedIconToggleButtonContent(functionalComposableScope, toggleButtonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ToggleButtonContent$lambda$3(FunctionalComposableScope functionalComposableScope, ToggleButtonProps toggleButtonProps, Function1 function1, int i, Composer composer, int i2) {
        ToggleButtonContent(functionalComposableScope, toggleButtonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ToggleButtonContent(final FunctionalComposableScope functionalComposableScope, final ToggleButtonProps props, final Function1<? super ToggleButtonValueChangeEvent, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1479239328);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleButtonContent)N(props,onCheckedChange)48@1715L83,54@2009L432,51@1866L53,62@2446L54,49@1801L699:ToggleButtonView.kt#v15e7d");
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
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1479239328, i3, -1, "expo.modules.ui.ToggleButtonContent (ToggleButtonView.kt:47)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            boolean checked = props.getChecked();
            boolean enabled = props.getEnabled();
            androidx.compose.material3.ToggleButtonColors toggleButtonColorsM5035toggleButtonColors5tl4gsc = ToggleButtonDefaults.INSTANCE.m5035toggleButtonColors5tl4gsc(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), UtilsKt.getCompose(props.getColors().getCheckedContainerColor()), UtilsKt.getCompose(props.getColors().getCheckedContentColor()), composerStartRestartGroup, ToggleButtonDefaults.$stable << 18, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 85191637, "CC(remember):ToggleButtonView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ToggleButtonViewKt.ToggleButtonContent$lambda$1$lambda$0(onCheckedChange, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ToggleButtonKt.ToggleButton(checked, (Function1) objRememberedValue, modifierApplyModifiers, enabled, null, toggleButtonColorsM5035toggleButtonColors5tl4gsc, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-583527806, true, new Function3() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ToggleButtonViewKt.ToggleButtonContent$lambda$2(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 0, 6, 976);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.ToggleButtonContent$lambda$3(functionalComposableScope, props, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ToggleButtonContent$lambda$1$lambda$0(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }

    static final Unit ToggleButtonContent$lambda$2(FunctionalComposableScope functionalComposableScope, RowScope ToggleButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ToggleButton, "$this$ToggleButton");
        ComposerKt.sourceInformation(composer, "C63@2452L44:ToggleButtonView.kt#v15e7d");
        if ((i & 6) == 0) {
            i |= composer.changed(ToggleButton) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-583527806, i, -1, "expo.modules.ui.ToggleButtonContent.<anonymous> (ToggleButtonView.kt:63)");
            }
            functionalComposableScope.Children(new UIComposableScope(ToggleButton, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void IconToggleButtonContent(final FunctionalComposableScope functionalComposableScope, final ToggleButtonProps props, final Function1<? super ToggleButtonValueChangeEvent, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(-810863641);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconToggleButtonContent)N(props,onCheckedChange)72@2695L83,78@2991L436,75@2850L53,86@3432L39,73@2781L690:ToggleButtonView.kt#v15e7d");
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
                ComposerKt.traceEventStart(-810863641, i3, -1, "expo.modules.ui.IconToggleButtonContent (ToggleButtonView.kt:71)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            boolean checked = props.getChecked();
            boolean enabled = props.getEnabled();
            IconToggleButtonColors iconToggleButtonColorsM4130iconToggleButtonColors5tl4gsc = IconButtonDefaults.INSTANCE.m4130iconToggleButtonColors5tl4gsc(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), UtilsKt.getCompose(props.getColors().getCheckedContainerColor()), UtilsKt.getCompose(props.getColors().getCheckedContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 18, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1850867300, "CC(remember):ToggleButtonView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ToggleButtonViewKt.IconToggleButtonContent$lambda$5$lambda$4(onCheckedChange, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.IconToggleButton(checked, (Function1<? super Boolean, Unit>) objRememberedValue, modifierApplyModifiers, enabled, iconToggleButtonColorsM4130iconToggleButtonColors5tl4gsc, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1961276794, true, new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.IconToggleButtonContent$lambda$6(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.IconToggleButtonContent$lambda$7(functionalComposableScope, props, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit IconToggleButtonContent$lambda$5$lambda$4(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }

    static final Unit IconToggleButtonContent$lambda$6(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C87@3438L29:ToggleButtonView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1961276794, i, -1, "expo.modules.ui.IconToggleButtonContent.<anonymous> (ToggleButtonView.kt:87)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void FilledIconToggleButtonContent(final FunctionalComposableScope functionalComposableScope, final ToggleButtonProps props, final Function1<? super ToggleButtonValueChangeEvent, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(1831519653);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledIconToggleButtonContent)N(props,onCheckedChange)96@3672L83,102@3974L442,99@3833L53,110@4421L39,97@3758L702:ToggleButtonView.kt#v15e7d");
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
                ComposerKt.traceEventStart(1831519653, i3, -1, "expo.modules.ui.FilledIconToggleButtonContent (ToggleButtonView.kt:95)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            boolean checked = props.getChecked();
            boolean enabled = props.getEnabled();
            IconToggleButtonColors iconToggleButtonColorsM4120filledIconToggleButtonColors5tl4gsc = IconButtonDefaults.INSTANCE.m4120filledIconToggleButtonColors5tl4gsc(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), UtilsKt.getCompose(props.getColors().getCheckedContainerColor()), UtilsKt.getCompose(props.getColors().getCheckedContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 18, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -846193318, "CC(remember):ToggleButtonView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ToggleButtonViewKt.FilledIconToggleButtonContent$lambda$9$lambda$8(onCheckedChange, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.FilledIconToggleButton(checked, (Function1<? super Boolean, Unit>) objRememberedValue, modifierApplyModifiers, enabled, (Shape) null, iconToggleButtonColorsM4120filledIconToggleButtonColors5tl4gsc, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-945153606, true, new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.FilledIconToggleButtonContent$lambda$10(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.FilledIconToggleButtonContent$lambda$11(functionalComposableScope, props, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit FilledIconToggleButtonContent$lambda$9$lambda$8(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }

    static final Unit FilledIconToggleButtonContent$lambda$10(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C111@4427L29:ToggleButtonView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-945153606, i, -1, "expo.modules.ui.FilledIconToggleButtonContent.<anonymous> (ToggleButtonView.kt:111)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OutlinedIconToggleButtonContent(final FunctionalComposableScope functionalComposableScope, final ToggleButtonProps props, final Function1<? super ToggleButtonValueChangeEvent, Unit> onCheckedChange, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(927498405);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedIconToggleButtonContent)N(props,onCheckedChange)120@4663L83,126@4967L444,123@4826L53,134@5416L39,121@4749L706:ToggleButtonView.kt#v15e7d");
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
                ComposerKt.traceEventStart(927498405, i3, -1, "expo.modules.ui.OutlinedIconToggleButtonContent (ToggleButtonView.kt:119)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            boolean checked = props.getChecked();
            boolean enabled = props.getEnabled();
            IconToggleButtonColors iconToggleButtonColorsM4136outlinedIconToggleButtonColors5tl4gsc = IconButtonDefaults.INSTANCE.m4136outlinedIconToggleButtonColors5tl4gsc(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), UtilsKt.getCompose(props.getColors().getCheckedContainerColor()), UtilsKt.getCompose(props.getColors().getCheckedContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 18, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2027218726, "CC(remember):ToggleButtonView.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ToggleButtonViewKt.OutlinedIconToggleButtonContent$lambda$13$lambda$12(onCheckedChange, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            IconButtonKt.OutlinedIconToggleButton(checked, (Function1<? super Boolean, Unit>) objRememberedValue, modifierApplyModifiers, enabled, (Shape) null, iconToggleButtonColorsM4136outlinedIconToggleButtonColors5tl4gsc, (BorderStroke) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-644351877, true, new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.OutlinedIconToggleButtonContent$lambda$14(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100663296, JfifUtil.MARKER_RST0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.ToggleButtonViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ToggleButtonViewKt.OutlinedIconToggleButtonContent$lambda$15(functionalComposableScope, props, onCheckedChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OutlinedIconToggleButtonContent$lambda$13$lambda$12(Function1 function1, boolean z) {
        function1.invoke(new ToggleButtonValueChangeEvent(z));
        return Unit.INSTANCE;
    }

    static final Unit OutlinedIconToggleButtonContent$lambda$14(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C135@5422L29:ToggleButtonView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-644351877, i, -1, "expo.modules.ui.OutlinedIconToggleButtonContent.<anonymous> (ToggleButtonView.kt:135)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
