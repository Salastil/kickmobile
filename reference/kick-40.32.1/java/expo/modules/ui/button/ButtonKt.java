package expo.modules.ui.button;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.react.uimanager.ViewProps;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a-\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\f\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\r\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u000e\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0007¢\u0006\u0002\u0010\u000b\u001a-\u0010\u000f\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\tH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\u0010"}, d2 = {"toPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Lexpo/modules/ui/button/ContentPaddingRecord;", "ButtonContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/button/ButtonProps;", ViewProps.ON_CLICK, "Lkotlin/Function1;", "Lexpo/modules/ui/button/ButtonPressedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/button/ButtonProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FilledTonalButtonContent", "OutlinedButtonContent", "ElevatedButtonContent", "TextButtonContent", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ButtonKt {
    static final Unit ButtonContent$lambda$3(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        ButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ElevatedButtonContent$lambda$15(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        ElevatedButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit FilledTonalButtonContent$lambda$7(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        FilledTonalButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit OutlinedButtonContent$lambda$11(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        OutlinedButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit TextButtonContent$lambda$19(FunctionalComposableScope functionalComposableScope, ButtonProps buttonProps, Function1 function1, int i, Composer composer, int i2) {
        TextButtonContent(functionalComposableScope, buttonProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final PaddingValues toPaddingValues(ContentPaddingRecord contentPaddingRecord) {
        float fMo2300calculateLeftPaddingu2uoSUM;
        float top;
        float fMo2301calculateRightPaddingu2uoSUM;
        float bottom;
        Intrinsics.checkNotNullParameter(contentPaddingRecord, "<this>");
        Double start = contentPaddingRecord.getStart();
        if (start == null) {
            fMo2300calculateLeftPaddingu2uoSUM = ButtonDefaults.INSTANCE.getContentPadding().mo2300calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr);
        } else {
            fMo2300calculateLeftPaddingu2uoSUM = Dp.m10168constructorimpl((float) start.doubleValue());
        }
        Double top2 = contentPaddingRecord.getTop();
        if (top2 == null) {
            top = ButtonDefaults.INSTANCE.getContentPadding().getTop();
        } else {
            top = Dp.m10168constructorimpl((float) top2.doubleValue());
        }
        Double end = contentPaddingRecord.getEnd();
        if (end == null) {
            fMo2301calculateRightPaddingu2uoSUM = ButtonDefaults.INSTANCE.getContentPadding().mo2301calculateRightPaddingu2uoSUM(LayoutDirection.Ltr);
        } else {
            fMo2301calculateRightPaddingu2uoSUM = Dp.m10168constructorimpl((float) end.doubleValue());
        }
        Double bottom2 = contentPaddingRecord.getBottom();
        if (bottom2 == null) {
            bottom = ButtonDefaults.INSTANCE.getContentPadding().getBottom();
        } else {
            bottom = Dp.m10168constructorimpl((float) bottom2.doubleValue());
        }
        return PaddingKt.m2346PaddingValuesa9UjIt4(fMo2300calculateLeftPaddingu2uoSUM, top, fMo2301calculateRightPaddingu2uoSUM, bottom);
    }

    public static final void ButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onClick, Composer composer, final int i) {
        int i2;
        PaddingValues contentPadding;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1885623749);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonContent)N(props,onClick)76@2609L282,83@2996L83,73@2422L33,84@3084L54,72@2400L738:Button.kt#kazlex");
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
                ComposerKt.traceEventStart(1885623749, i2, -1, "expo.modules.ui.button.ButtonContent (Button.kt:71)");
            }
            boolean enabled = props.getEnabled();
            ContentPaddingRecord contentPadding2 = props.getContentPadding();
            if (contentPadding2 == null || (contentPadding = toPaddingValues(contentPadding2)) == null) {
                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
            }
            PaddingValues paddingValues = contentPadding;
            int i3 = i2;
            androidx.compose.material3.ButtonColors buttonColorsM3547buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3547buttonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(-391753430);
                ComposerKt.sourceInformation(composerStartRestartGroup, "82@2957L5");
                shapeShapeFromShapeRecord = ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable);
            } else {
                composerStartRestartGroup.startReplaceGroup(-391755042);
            }
            composerStartRestartGroup.endReplaceGroup();
            Shape shape = shapeShapeFromShapeRecord;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -391770522, "CC(remember):Button.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonKt.ButtonContent$lambda$1$lambda$0(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.ButtonKt.Button((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, buttonColorsM3547buttonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1117397035, true, new Function3() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ButtonKt.ButtonContent$lambda$2(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 352);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.ButtonContent$lambda$3(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ButtonContent$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit ButtonContent$lambda$2(FunctionalComposableScope functionalComposableScope, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C85@3090L44:Button.kt#kazlex");
        if ((i & 6) == 0) {
            i |= composer.changed(Button) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1117397035, i, -1, "expo.modules.ui.button.ButtonContent.<anonymous> (Button.kt:85)");
            }
            functionalComposableScope.Children(new UIComposableScope(Button, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void FilledTonalButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onClick, Composer composer, final int i) {
        int i2;
        PaddingValues contentPadding;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1808845327);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilledTonalButtonContent)N(props,onClick)98@3498L293,105@3907L83,95@3311L33,106@3995L54,94@3278L771:Button.kt#kazlex");
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
                ComposerKt.traceEventStart(-1808845327, i2, -1, "expo.modules.ui.button.FilledTonalButtonContent (Button.kt:93)");
            }
            boolean enabled = props.getEnabled();
            ContentPaddingRecord contentPadding2 = props.getContentPadding();
            if (contentPadding2 == null || (contentPadding = toPaddingValues(contentPadding2)) == null) {
                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
            }
            PaddingValues paddingValues = contentPadding;
            int i3 = i2;
            androidx.compose.material3.ButtonColors buttonColorsM3553filledTonalButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3553filledTonalButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(1161418529);
                ComposerKt.sourceInformation(composerStartRestartGroup, "104@3857L16");
                shapeShapeFromShapeRecord = ButtonDefaults.INSTANCE.getFilledTonalShape(composerStartRestartGroup, ButtonDefaults.$stable);
            } else {
                composerStartRestartGroup.startReplaceGroup(1161416917);
            }
            composerStartRestartGroup.endReplaceGroup();
            Shape shape = shapeShapeFromShapeRecord;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1161401074, "CC(remember):Button.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonKt.FilledTonalButtonContent$lambda$5$lambda$4(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.ButtonKt.FilledTonalButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, buttonColorsM3553filledTonalButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-755235133, true, new Function3() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ButtonKt.FilledTonalButtonContent$lambda$6(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 352);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.FilledTonalButtonContent$lambda$7(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit FilledTonalButtonContent$lambda$5$lambda$4(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit FilledTonalButtonContent$lambda$6(FunctionalComposableScope functionalComposableScope, RowScope FilledTonalButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(FilledTonalButton, "$this$FilledTonalButton");
        ComposerKt.sourceInformation(composer, "C107@4001L44:Button.kt#kazlex");
        if ((i & 6) == 0) {
            i |= composer.changed(FilledTonalButton) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-755235133, i, -1, "expo.modules.ui.button.FilledTonalButtonContent.<anonymous> (Button.kt:107)");
            }
            functionalComposableScope.Children(new UIComposableScope(FilledTonalButton, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OutlinedButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onClick, Composer composer, final int i) {
        int i2;
        PaddingValues contentPadding;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1345238471);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedButtonContent)N(props,onClick)120@4403L290,127@4806L83,117@4216L33,128@4894L54,116@4186L762:Button.kt#kazlex");
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
                ComposerKt.traceEventStart(1345238471, i2, -1, "expo.modules.ui.button.OutlinedButtonContent (Button.kt:115)");
            }
            boolean enabled = props.getEnabled();
            ContentPaddingRecord contentPadding2 = props.getContentPadding();
            if (contentPadding2 == null || (contentPadding = toPaddingValues(contentPadding2)) == null) {
                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
            }
            PaddingValues paddingValues = contentPadding;
            int i3 = i2;
            androidx.compose.material3.ButtonColors buttonColorsM3574outlinedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3574outlinedButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(-10962860);
                ComposerKt.sourceInformation(composerStartRestartGroup, "126@4759L13");
                shapeShapeFromShapeRecord = ButtonDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, ButtonDefaults.$stable);
            } else {
                composerStartRestartGroup.startReplaceGroup(-10964472);
            }
            composerStartRestartGroup.endReplaceGroup();
            Shape shape = shapeShapeFromShapeRecord;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -10980216, "CC(remember):Button.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonKt.OutlinedButtonContent$lambda$9$lambda$8(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.ButtonKt.OutlinedButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, buttonColorsM3574outlinedButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(684765205, true, new Function3() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ButtonKt.OutlinedButtonContent$lambda$10(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 352);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.OutlinedButtonContent$lambda$11(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit OutlinedButtonContent$lambda$9$lambda$8(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit OutlinedButtonContent$lambda$10(FunctionalComposableScope functionalComposableScope, RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C129@4900L44:Button.kt#kazlex");
        if ((i & 6) == 0) {
            i |= composer.changed(OutlinedButton) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(684765205, i, -1, "expo.modules.ui.button.OutlinedButtonContent.<anonymous> (Button.kt:129)");
            }
            functionalComposableScope.Children(new UIComposableScope(OutlinedButton, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ElevatedButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onClick, Composer composer, final int i) {
        int i2;
        PaddingValues contentPadding;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1611592945);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedButtonContent)N(props,onClick)142@5302L290,149@5705L83,139@5115L33,150@5793L54,138@5085L762:Button.kt#kazlex");
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
                ComposerKt.traceEventStart(-1611592945, i2, -1, "expo.modules.ui.button.ElevatedButtonContent (Button.kt:137)");
            }
            boolean enabled = props.getEnabled();
            ContentPaddingRecord contentPadding2 = props.getContentPadding();
            if (contentPadding2 == null || (contentPadding = toPaddingValues(contentPadding2)) == null) {
                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
            }
            PaddingValues paddingValues = contentPadding;
            int i3 = i2;
            androidx.compose.material3.ButtonColors buttonColorsM3551elevatedButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3551elevatedButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(1742396316);
                ComposerKt.sourceInformation(composerStartRestartGroup, "148@5658L13");
                shapeShapeFromShapeRecord = ButtonDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, ButtonDefaults.$stable);
            } else {
                composerStartRestartGroup.startReplaceGroup(1742394704);
            }
            composerStartRestartGroup.endReplaceGroup();
            Shape shape = shapeShapeFromShapeRecord;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1742378960, "CC(remember):Button.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonKt.ElevatedButtonContent$lambda$13$lambda$12(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.ButtonKt.ElevatedButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, buttonColorsM3551elevatedButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-1212766955, true, new Function3() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ButtonKt.ElevatedButtonContent$lambda$14(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 352);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.ElevatedButtonContent$lambda$15(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ElevatedButtonContent$lambda$13$lambda$12(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit ElevatedButtonContent$lambda$14(FunctionalComposableScope functionalComposableScope, RowScope ElevatedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(ElevatedButton, "$this$ElevatedButton");
        ComposerKt.sourceInformation(composer, "C151@5799L44:Button.kt#kazlex");
        if ((i & 6) == 0) {
            i |= composer.changed(ElevatedButton) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1212766955, i, -1, "expo.modules.ui.button.ElevatedButtonContent.<anonymous> (Button.kt:151)");
            }
            functionalComposableScope.Children(new UIComposableScope(ElevatedButton, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void TextButtonContent(final FunctionalComposableScope functionalComposableScope, final ButtonProps props, final Function1<? super ButtonPressedEvent, Unit> onClick, Composer composer, final int i) {
        int i2;
        PaddingValues textButtonContentPadding;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1727331886);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextButtonContent)N(props,onClick)164@6203L286,171@6598L83,161@6006L33,172@6686L54,160@5980L760:Button.kt#kazlex");
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
                ComposerKt.traceEventStart(-1727331886, i2, -1, "expo.modules.ui.button.TextButtonContent (Button.kt:159)");
            }
            boolean enabled = props.getEnabled();
            ContentPaddingRecord contentPadding = props.getContentPadding();
            if (contentPadding == null || (textButtonContentPadding = toPaddingValues(contentPadding)) == null) {
                textButtonContentPadding = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
            }
            PaddingValues paddingValues = textButtonContentPadding;
            int i3 = i2;
            androidx.compose.material3.ButtonColors buttonColorsM3576textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3576textButtonColorsro_MJ88(UtilsKt.getCompose(props.getColors().getContainerColor()), UtilsKt.getCompose(props.getColors().getContentColor()), UtilsKt.getCompose(props.getColors().getDisabledContainerColor()), UtilsKt.getCompose(props.getColors().getDisabledContentColor()), composerStartRestartGroup, ButtonDefaults.$stable << 12, 0);
            Shape shapeShapeFromShapeRecord = ShapeViewKt.shapeFromShapeRecord(props.getShape());
            if (shapeShapeFromShapeRecord == null) {
                composerStartRestartGroup.startReplaceGroup(-2108543653);
                ComposerKt.sourceInformation(composerStartRestartGroup, "170@6555L9");
                shapeShapeFromShapeRecord = ButtonDefaults.INSTANCE.getTextShape(composerStartRestartGroup, ButtonDefaults.$stable);
            } else {
                composerStartRestartGroup.startReplaceGroup(-2108545265);
            }
            composerStartRestartGroup.endReplaceGroup();
            Shape shape = shapeShapeFromShapeRecord;
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2108561197, "CC(remember):Button.kt#9igjgp");
            boolean z = (i3 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ButtonKt.TextButtonContent$lambda$17$lambda$16(onClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            androidx.compose.material3.ButtonKt.TextButton((Function0<Unit>) objRememberedValue, modifierApplyModifiers, enabled, shape, buttonColorsM3576textButtonColorsro_MJ88, (ButtonElevation) null, (BorderStroke) null, paddingValues, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-237974283, true, new Function3() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ButtonKt.TextButtonContent$lambda$18(functionalComposableScope, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 352);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.button.ButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.TextButtonContent$lambda$19(functionalComposableScope, props, onClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit TextButtonContent$lambda$17$lambda$16(Function1 function1) {
        function1.invoke(new ButtonPressedEvent());
        return Unit.INSTANCE;
    }

    static final Unit TextButtonContent$lambda$18(FunctionalComposableScope functionalComposableScope, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C173@6692L44:Button.kt#kazlex");
        if ((i & 6) == 0) {
            i |= composer.changed(TextButton) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-237974283, i, -1, "expo.modules.ui.button.TextButtonContent.<anonymous> (Button.kt:173)");
            }
            functionalComposableScope.Children(new UIComposableScope(TextButton, null, null, null, 14, null), composer, FunctionalComposableScope.$stable << 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
