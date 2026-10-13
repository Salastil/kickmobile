package expo.modules.ui.button;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.ModifierRegistry;
import expo.modules.ui.ShapeViewKt;
import expo.modules.ui.UIComposableScope;
import expo.modules.ui.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\f"}, d2 = {"IconButtonContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/button/ButtonProps;", "onButtonPressed", "Lkotlin/Function1;", "Lexpo/modules/ui/button/ButtonPressedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/button/ButtonProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FilledIconButtonContent", "FilledTonalIconButtonContent", "OutlinedIconButtonContent", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IconButtonKt {
    static final Unit FilledIconButtonContent$lambda$7(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        FilledIconButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit FilledTonalIconButtonContent$lambda$11(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        FilledTonalIconButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit IconButtonContent$lambda$3(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        IconButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit OutlinedIconButtonContent$lambda$15(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        OutlinedIconButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void IconButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onButtonPressed, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Shape shape;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onButtonPressed, "onButtonPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1783704283);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(IconButtonContent)N(props,onButtonPressed)23@864L286,30@1239L83,21@760L41,31@1327L39,20@734L632:IconButton.kt#kazlex");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onButtonPressed) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1783704283, i2, -1, "expo.modules.ui.button.IconButtonContent (IconButton.kt:18)");
            }
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            boolean enabled = props.getEnabled();
            int i3 = i2;
            IconButtonColors iconButtonColorsM4128iconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m4128iconButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(-447844270);
                ComposerKt.sourceInformation(composerStartRestartGroup, "29@1192L13");
                Shape standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, IconButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                shape = standardShape;
            } else {
                composerStartRestartGroup.startReplaceGroup(-447845138);
                composerStartRestartGroup.endReplaceGroup();
                shape = shapeShapeFromShapeRecord;
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -447858066, "CC(remember):IconButton.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IconButtonKt.IconButtonContent$lambda$1$lambda$0(onButtonPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, iconButtonColorsM4128iconButtonColorsro_MJ88, (MutableInteractionSource) null, shape, ComposableLambdaKt.rememberComposableLambda(-1426087609, true, new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.IconButtonContent$lambda$2(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 16);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.IconButtonContent$lambda$3(functionalComposableScope, props, onButtonPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit IconButtonContent$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit IconButtonContent$lambda$2(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C32@1333L29:IconButton.kt#kazlex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426087609, i, -1, "expo.modules.ui.button.IconButtonContent.<anonymous> (IconButton.kt:32)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void FilledIconButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onButtonPressed, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Shape shape;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onButtonPressed, "onButtonPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(-562500057);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledIconButtonContent)N(props,onButtonPressed)45@1697L292,52@2076L83,43@1593L41,53@2164L39,42@1561L642:IconButton.kt#kazlex");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onButtonPressed) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-562500057, i2, -1, "expo.modules.ui.button.FilledIconButtonContent (IconButton.kt:40)");
            }
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            boolean enabled = props.getEnabled();
            int i3 = i2;
            IconButtonColors iconButtonColorsM4119filledIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m4119filledIconButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(603345682);
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@2031L11");
                Shape filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, IconButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                shape = filledShape;
            } else {
                composerStartRestartGroup.startReplaceGroup(603344814);
                composerStartRestartGroup.endReplaceGroup();
                shape = shapeShapeFromShapeRecord;
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 603331696, "CC(remember):IconButton.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IconButtonKt.FilledIconButtonContent$lambda$5$lambda$4(onButtonPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.IconButtonKt.FilledIconButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, iconButtonColorsM4119filledIconButtonColorsro_MJ88, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(650398471, true, new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.FilledIconButtonContent$lambda$6(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 32);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.FilledIconButtonContent$lambda$7(functionalComposableScope, props, onButtonPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit FilledIconButtonContent$lambda$5$lambda$4(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit FilledIconButtonContent$lambda$6(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C54@2170L29:IconButton.kt#kazlex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(650398471, i, -1, "expo.modules.ui.button.FilledIconButtonContent.<anonymous> (IconButton.kt:54)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void FilledTonalIconButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onButtonPressed, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Shape shape;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onButtonPressed, "onButtonPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1403205295);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledTonalIconButtonContent)N(props,onButtonPressed)67@2544L297,74@2928L83,65@2440L41,75@3016L39,64@2403L652:IconButton.kt#kazlex");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onButtonPressed) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1403205295, i2, -1, "expo.modules.ui.button.FilledTonalIconButtonContent (IconButton.kt:62)");
            }
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            boolean enabled = props.getEnabled();
            int i3 = i2;
            IconButtonColors iconButtonColorsM4121filledTonalIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m4121filledTonalIconButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(139464092);
                ComposerKt.sourceInformation(composerStartRestartGroup, "73@2883L11");
                Shape filledShape = IconButtonDefaults.INSTANCE.getFilledShape(composerStartRestartGroup, IconButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                shape = filledShape;
            } else {
                composerStartRestartGroup.startReplaceGroup(139463224);
                composerStartRestartGroup.endReplaceGroup();
                shape = shapeShapeFromShapeRecord;
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 139449946, "CC(remember):IconButton.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IconButtonKt.FilledTonalIconButtonContent$lambda$9$lambda$8(onButtonPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.IconButtonKt.FilledTonalIconButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, iconButtonColorsM4121filledTonalIconButtonColorsro_MJ88, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(834977543, true, new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.FilledTonalIconButtonContent$lambda$10(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572864, 32);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.FilledTonalIconButtonContent$lambda$11(functionalComposableScope, props, onButtonPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit FilledTonalIconButtonContent$lambda$9$lambda$8(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit FilledTonalIconButtonContent$lambda$10(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C76@3022L29:IconButton.kt#kazlex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(834977543, i, -1, "expo.modules.ui.button.FilledTonalIconButtonContent.<anonymous> (IconButton.kt:76)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OutlinedIconButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onButtonPressed, Composer composer, final int i) {
        int i2;
        Shape shape;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onButtonPressed, "onButtonPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(-576580825);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedIconButtonContent)N(props,onButtonPressed)89@3390L294,96@3773L83,87@3286L41,97@3861L39,86@3252L648:IconButton.kt#kazlex");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onButtonPressed) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-576580825, i2, -1, "expo.modules.ui.button.OutlinedIconButtonContent (IconButton.kt:84)");
            }
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            boolean enabled = props.getEnabled();
            int i3 = i2;
            IconButtonColors iconButtonColorsM4134outlinedIconButtonColorsro_MJ88 = IconButtonDefaults.INSTANCE.m4134outlinedIconButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, IconButtonDefaults.$stable << 12, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(-43370284);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@3726L13");
                Shape outlinedShape = IconButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, IconButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
                shape = outlinedShape;
            } else {
                composerStartRestartGroup.startReplaceGroup(-43371152);
                composerStartRestartGroup.endReplaceGroup();
                shape = shapeShapeFromShapeRecord;
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -43384336, "CC(remember):IconButton.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IconButtonKt.OutlinedIconButtonContent$lambda$13$lambda$12(onButtonPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.IconButtonKt.OutlinedIconButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, iconButtonColorsM4134outlinedIconButtonColorsro_MJ88, (BorderStroke) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1177655462, true, new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.OutlinedIconButtonContent$lambda$14(functionalComposableScope, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.IconButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconButtonKt.OutlinedIconButtonContent$lambda$15(functionalComposableScope, props, onButtonPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OutlinedIconButtonContent$lambda$13$lambda$12(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit OutlinedIconButtonContent$lambda$14(FunctionalComposableScope functionalComposableScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C98@3867L29:IconButton.kt#kazlex");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1177655462, i, -1, "expo.modules.ui.button.OutlinedIconButtonContent.<anonymous> (IconButton.kt:98)");
            }
            functionalComposableScope.Children(new UIComposableScope(null, null, null, null, 15, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
