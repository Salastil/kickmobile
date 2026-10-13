package expo.modules.ui;

import android.content.res.Configuration;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.DatePickerColors;
import androidx.compose.material3.DatePickerDefaults;
import androidx.compose.material3.DatePickerDialog_androidKt;
import androidx.compose.material3.DateRangePickerKt;
import androidx.compose.material3.DateRangePickerState;
import androidx.compose.material3.SelectableDates;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DateRangePickerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0003¢\u0006\u0002\u0010\t\u001a7\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u000b*\u00020\u00152\u0006\u0010\f\u001a\u00020\u00162\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fH\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"rememberDateRangePickerState", "Landroidx/compose/material3/DateRangePickerState;", "initialStartDate", "", "initialEndDate", "variant", "Lexpo/modules/ui/Variant;", "selectableDatesRecord", "Lexpo/modules/ui/SelectableDatesRecord;", "(Ljava/lang/Long;Ljava/lang/Long;Lexpo/modules/ui/Variant;Lexpo/modules/ui/SelectableDatesRecord;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DateRangePickerState;", "ExpoDateRangePickerDialogContent", "", "props", "Lexpo/modules/ui/DateRangePickerDialogProps;", "onDateRangeSelected", "Lkotlin/Function1;", "Lexpo/modules/ui/DateRangePickerResult;", "onDismissRequest", "Lkotlin/Function0;", "(Lexpo/modules/ui/DateRangePickerDialogProps;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lexpo/modules/ui/DateRangePickerProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/DateRangePickerProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DateRangePickerViewKt {
    static final Unit DateRangePickerContent$lambda$19(FunctionalComposableScope functionalComposableScope, DateRangePickerProps dateRangePickerProps, Function1 function1, int i, Composer composer, int i2) {
        DateRangePickerContent(functionalComposableScope, dateRangePickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$16(DateRangePickerDialogProps dateRangePickerDialogProps, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        ExpoDateRangePickerDialogContent(dateRangePickerDialogProps, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final DateRangePickerState rememberDateRangePickerState(Long l, Long l2, Variant variant, SelectableDatesRecord selectableDatesRecord, Composer composer, int i) {
        Long l3;
        ComposerKt.sourceInformationMarkerStart(composer, -799647461, "C(rememberDateRangePickerState)N(initialStartDate,initialEndDate,variant,selectableDatesRecord)67@2459L7,69@2546L46,70@2614L24,72@2720L105,78@2841L396,90@3297L347,90@3241L403:DateRangePickerView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-799647461, i, -1, "expo.modules.ui.rememberDateRangePickerState (DateRangePickerView.kt:66)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Locale locale = ((Configuration) objConsume).getLocales().get(0);
        int iM12131toDisplayModejFl4v0 = variant.m12131toDisplayModejFl4v0();
        int i2 = (i >> 9) & 14;
        SelectableDates selectableDatesRememberSelectableDates = DatePickerViewKt.rememberSelectableDates(selectableDatesRecord, composer, i2);
        ComposerKt.sourceInformationMarkerStart(composer, 337949715, "CC(remember):DateRangePickerView.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = Long.valueOf(new Date().getTime());
            composer.updateRememberedValue(objRememberedValue);
        }
        long jLongValue = ((Number) objRememberedValue).longValue();
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (l != null) {
            jLongValue = l.longValue();
        }
        int i3 = i << 3;
        long j = jLongValue;
        IntRange intRangeRememberDatePickerYearRange = DatePickerViewKt.rememberDatePickerYearRange(selectableDatesRecord, j, l2, composer, (i3 & 896) | i2, 0);
        ComposerKt.sourceInformationMarkerStart(composer, 337957351, "CC(remember):DateRangePickerView.kt#9igjgp");
        boolean zChanged = composer.changed(locale) | composer.changed(iM12131toDisplayModejFl4v0) | composer.changed(selectableDatesRememberSelectableDates) | composer.changed(intRangeRememberDatePickerYearRange);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            Intrinsics.checkNotNull(locale);
            l3 = l2;
            objRememberedValue2 = DateRangePickerKt.m3851DateRangePickerStateHVP43zI(locale, l, l3, Long.valueOf(j), intRangeRememberDatePickerYearRange, iM12131toDisplayModejFl4v0, selectableDatesRememberSelectableDates);
            composer.updateRememberedValue(objRememberedValue2);
        } else {
            l3 = l2;
        }
        DateRangePickerState dateRangePickerState = (DateRangePickerState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 337971894, "CC(remember):DateRangePickerView.kt#9igjgp");
        boolean zChanged2 = composer.changed(dateRangePickerState) | ((((i & 14) ^ 6) > 4 && composer.changed(l)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(l3)) || (i & 48) == 32);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function2) new DateRangePickerViewKt$rememberDateRangePickerState$1$1(dateRangePickerState, l, l3, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(dateRangePickerState, l, l3, (Function2) objRememberedValue3, composer, i3 & 1008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dateRangePickerState;
    }

    public static final void ExpoDateRangePickerDialogContent(DateRangePickerDialogProps props, final Function1<? super DateRangePickerResult, Unit> onDateRangeSelected, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        int i2;
        final DateRangePickerDialogProps dateRangePickerDialogProps;
        DatePickerColors datePickerColors;
        int i3;
        int i4;
        final ButtonColors buttonColorsM3576textButtonColorsro_MJ88;
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateRangeSelected, "onDateRangeSelected");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1920898829);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpoDateRangePickerDialogContent)N(props,onDateRangeSelected,onDismissRequest)110@3896L132,116@4133L8,116@4044L98,121@4336L22,122@4380L471,138@4873L173,144@5072L324,120@4295L1101:DateRangePickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(props) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDateRangeSelected) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 256 : 128;
        }
        int i5 = i2;
        if (!composerStartRestartGroup.shouldExecute((i5 & 147) != 146, i5 & 1)) {
            dateRangePickerDialogProps = props;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1920898829, i5, -1, "expo.modules.ui.ExpoDateRangePickerDialogContent (DateRangePickerView.kt:109)");
            }
            final DateRangePickerState dateRangePickerStateRememberDateRangePickerState = rememberDateRangePickerState(props.getInitialStartDate(), props.getInitialEndDate(), props.getVariant(), props.getSelectableDates(), composerStartRestartGroup, 0);
            DatePickerColors datePickerColorsM12113buildDatePickerColorsBAq54LU = DatePickerViewKt.m12113buildDatePickerColorsBAq54LU(props.getElementColors(), UtilsKt.getComposeOrNull(props.getColor()), DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6), composerStartRestartGroup, 0, 0);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(647766708);
                composerStartRestartGroup.endReplaceGroup();
                buttonColorsM3576textButtonColorsro_MJ88 = null;
                datePickerColors = datePickerColorsM12113buildDatePickerColorsBAq54LU;
                i3 = 256;
                i4 = i5;
            } else {
                composerStartRestartGroup.startReplaceGroup(647766709);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*118@4217L35");
                datePickerColors = datePickerColorsM12113buildDatePickerColorsBAq54LU;
                i3 = 256;
                i4 = i5;
                buttonColorsM3576textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3576textButtonColorsro_MJ88(0L, composeOrNull.m7348unboximpl(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 13);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (buttonColorsM3576textButtonColorsro_MJ88 == null) {
                composerStartRestartGroup.startReplaceGroup(852182117);
                ComposerKt.sourceInformation(composerStartRestartGroup, "118@4273L18");
                buttonColorsM3576textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.textButtonColors(composerStartRestartGroup, ButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(852178738);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 852184137, "CC(remember):DateRangePickerView.kt#9igjgp");
            boolean z = (i4 & 896) == i3;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$5$lambda$4(onDismissRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            dateRangePickerDialogProps = props;
            final DatePickerColors datePickerColors2 = datePickerColors;
            DatePickerDialog_androidKt.m3794DatePickerDialogGmEhDVc((Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-792648159, true, new Function2() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$9(onDateRangeSelected, dateRangePickerStateRememberDateRangePickerState, buttonColorsM3576textButtonColorsro_MJ88, dateRangePickerDialogProps, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1578646049, true, new Function2() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$13(onDismissRequest, buttonColorsM3576textButtonColorsro_MJ88, dateRangePickerDialogProps, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0.0f, datePickerColors2, null, ComposableLambdaKt.rememberComposableLambda(1390740394, true, new Function3() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$15(dateRangePickerStateRememberDateRangePickerState, datePickerColors2, dateRangePickerDialogProps, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100666416, RotationOptions.ROTATE_180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$16(dateRangePickerDialogProps, onDateRangeSelected, onDismissRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$5$lambda$4(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$9(final Function1 function1, final DateRangePickerState dateRangePickerState, ButtonColors buttonColors, final DateRangePickerDialogProps dateRangePickerDialogProps, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C124@4418L204,134@4758L87,123@4388L457:DateRangePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-792648159, i, -1, "expo.modules.ui.ExpoDateRangePickerDialogContent.<anonymous> (DateRangePickerView.kt:123)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1525667987, "CC(remember):DateRangePickerView.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(dateRangePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$9$lambda$7$lambda$6(function1, dateRangePickerState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0<Unit>) function0, (Modifier) null, (dateRangePickerState.getSelectedStartDateMillis() == null || dateRangePickerState.getSelectedEndDateMillis() == null) ? false : true, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-807128316, true, new Function3() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$9$lambda$8(dateRangePickerDialogProps, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 490);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$9$lambda$7$lambda$6(Function1 function1, DateRangePickerState dateRangePickerState) {
        function1.invoke(new DateRangePickerResult(dateRangePickerState.getSelectedStartDateMillis(), dateRangePickerState.getSelectedEndDateMillis()));
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$9$lambda$8(DateRangePickerDialogProps dateRangePickerDialogProps, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C135@4768L69:DateRangePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-807128316, i, -1, "expo.modules.ui.ExpoDateRangePickerDialogContent.<anonymous>.<anonymous> (DateRangePickerView.kt:135)");
            }
            String confirmButtonLabel = dateRangePickerDialogProps.getConfirmButtonLabel();
            if (confirmButtonLabel == null) {
                composer.startReplaceGroup(1738770311);
                ComposerKt.sourceInformation(composer, "135@4801L35");
                confirmButtonLabel = StringResources_androidKt.stringResource(android.R.string.ok, composer, 6);
            } else {
                composer.startReplaceGroup(1738769443);
            }
            composer.endReplaceGroup();
            TextKt.m4929TextNvy7gAk(confirmButtonLabel, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$13(final Function0 function0, ButtonColors buttonColors, final DateRangePickerDialogProps dateRangePickerDialogProps, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C139@4902L22,139@4949L91,139@4881L159:DateRangePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1578646049, i, -1, "expo.modules.ui.ExpoDateRangePickerDialogContent.<anonymous> (DateRangePickerView.kt:139)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -955396651, "CC(remember):DateRangePickerView.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$13$lambda$11$lambda$10(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1593126206, true, new Function3() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$13$lambda$12(dateRangePickerDialogProps, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$13$lambda$11$lambda$10(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$13$lambda$12(DateRangePickerDialogProps dateRangePickerDialogProps, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C140@4959L73:DateRangePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1593126206, i, -1, "expo.modules.ui.ExpoDateRangePickerDialogContent.<anonymous>.<anonymous> (DateRangePickerView.kt:140)");
            }
            String dismissButtonLabel = dateRangePickerDialogProps.getDismissButtonLabel();
            if (dismissButtonLabel == null) {
                composer.startReplaceGroup(-1985925175);
                ComposerKt.sourceInformation(composer, "140@4992L39");
                dismissButtonLabel = StringResources_androidKt.stringResource(android.R.string.cancel, composer, 6);
            } else {
                composer.startReplaceGroup(-1985926043);
            }
            composer.endReplaceGroup();
            TextKt.m4929TextNvy7gAk(dismissButtonLabel, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$15(final DateRangePickerState dateRangePickerState, final DatePickerColors datePickerColors, final DateRangePickerDialogProps dateRangePickerDialogProps, ColumnScope DatePickerDialog, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DatePickerDialog, "$this$DatePickerDialog");
        ComposerKt.sourceInformation(composer, "C146@5118L50,148@5257L135,148@5174L218:DateRangePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1390740394, i, -1, "expo.modules.ui.ExpoDateRangePickerDialogContent.<anonymous> (DateRangePickerView.kt:145)");
            }
            DatePickerViewKt.m12112ApplyDatePickerDialogKeyboardBehaviorQujVXRc(dateRangePickerState.mo3856getDisplayModejFl4v0(), composer, 0);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m7328boximpl(datePickerColors.getNavigationContentColor())), ComposableLambdaKt.rememberComposableLambda(-1501706518, true, new Function2() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerViewKt.ExpoDateRangePickerDialogContent$lambda$15$lambda$14(dateRangePickerDialogProps, dateRangePickerState, datePickerColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDateRangePickerDialogContent$lambda$15$lambda$14(DateRangePickerDialogProps dateRangePickerDialogProps, DateRangePickerState dateRangePickerState, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C149@5265L121:DateRangePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1501706518, i, -1, "expo.modules.ui.ExpoDateRangePickerDialogContent.<anonymous>.<anonymous> (DateRangePickerView.kt:149)");
            }
            DateRangePickerKt.DateRangePicker(dateRangePickerState, null, null, datePickerColors, null, null, dateRangePickerDialogProps.getShowVariantToggle(), null, composer, 0, 182);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
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
    public static final void DateRangePickerContent(final FunctionalComposableScope functionalComposableScope, final DateRangePickerProps props, final Function1<? super DateRangePickerResult, Unit> onDateRangeSelected, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateRangeSelected, "onDateRangeSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(250824311);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateRangePickerContent)N(props,onDateRangeSelected)164@5630L83,165@5728L132,172@5939L162,172@5864L237,181@6118L69,182@6273L150,182@6190L233:DateRangePickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDateRangeSelected) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(250824311, i2, -1, "expo.modules.ui.DateRangePickerContent (DateRangePickerView.kt:163)");
            }
            final Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            final DateRangePickerState dateRangePickerStateRememberDateRangePickerState = rememberDateRangePickerState(props.getInitialStartDate(), props.getInitialEndDate(), props.getVariant(), props.getSelectableDates(), composerStartRestartGroup, 0);
            Long selectedStartDateMillis = dateRangePickerStateRememberDateRangePickerState.getSelectedStartDateMillis();
            Long selectedEndDateMillis = dateRangePickerStateRememberDateRangePickerState.getSelectedEndDateMillis();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 524011705, "CC(remember):DateRangePickerView.kt#9igjgp");
            boolean zChanged = ((i2 & 896) == 256) | composerStartRestartGroup.changed(dateRangePickerStateRememberDateRangePickerState);
            DateRangePickerViewKt$DateRangePickerContent$1$1 dateRangePickerViewKt$DateRangePickerContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || dateRangePickerViewKt$DateRangePickerContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                dateRangePickerViewKt$DateRangePickerContent$1$1RememberedValue = new DateRangePickerViewKt$DateRangePickerContent$1$1(onDateRangeSelected, dateRangePickerStateRememberDateRangePickerState, null);
                composerStartRestartGroup.updateRememberedValue(dateRangePickerViewKt$DateRangePickerContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(selectedStartDateMillis, selectedEndDateMillis, (Function2) dateRangePickerViewKt$DateRangePickerContent$1$1RememberedValue, composerStartRestartGroup, 0);
            final DatePickerColors datePickerColorsM12113buildDatePickerColorsBAq54LU = DatePickerViewKt.m12113buildDatePickerColorsBAq54LU(props.getElementColors(), UtilsKt.getComposeOrNull(props.getColor()), null, composerStartRestartGroup, 0, 4);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m7328boximpl(datePickerColorsM12113buildDatePickerColorsBAq54LU.getNavigationContentColor())), ComposableLambdaKt.rememberComposableLambda(547502519, true, new Function2() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerViewKt.DateRangePickerContent$lambda$18(props, dateRangePickerStateRememberDateRangePickerState, modifierApplyModifiers, datePickerColorsM12113buildDatePickerColorsBAq54LU, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DateRangePickerViewKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DateRangePickerViewKt.DateRangePickerContent$lambda$19(functionalComposableScope, props, onDateRangeSelected, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DateRangePickerContent$lambda$18(DateRangePickerProps dateRangePickerProps, DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C183@6279L140:DateRangePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(547502519, i, -1, "expo.modules.ui.DateRangePickerContent.<anonymous> (DateRangePickerView.kt:183)");
            }
            DateRangePickerKt.DateRangePicker(dateRangePickerState, modifier, null, datePickerColors, null, null, dateRangePickerProps.getShowVariantToggle(), null, composer, 0, RotationOptions.ROTATE_180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
