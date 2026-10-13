package expo.modules.ui;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.DatePickerColors;
import androidx.compose.material3.DatePickerDefaults;
import androidx.compose.material3.DatePickerDialog_androidKt;
import androidx.compose.material3.DatePickerKt;
import androidx.compose.material3.DatePickerState;
import androidx.compose.material3.DisplayMode;
import androidx.compose.material3.SelectableDates;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TimePickerColors;
import androidx.compose.material3.TimePickerDefaults;
import androidx.compose.material3.TimePickerKt;
import androidx.compose.material3.TimePickerLayoutType;
import androidx.compose.material3.TimePickerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.window.DialogWindowProvider;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.FunctionalComposableScope;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DatePickerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a+\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\f\u001a/\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001b0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'H\u0007¢\u0006\u0002\u0010(\u001a7\u0010)\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020*2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001b0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'H\u0007¢\u0006\u0002\u0010+\u001a-\u0010,\u001a\u00020\u001b*\u00020-2\u0006\u0010!\u001a\u00020.2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001b0$H\u0007¢\u0006\u0002\u0010/\u001a3\u00100\u001a\u00020\u001b2\b\b\u0002\u00101\u001a\u0002022\u0006\u0010!\u001a\u00020.2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001b0$H\u0007¢\u0006\u0002\u00103\u001a3\u00104\u001a\u00020\u001b2\b\b\u0002\u00101\u001a\u0002022\u0006\u0010!\u001a\u00020.2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001b0$H\u0007¢\u0006\u0002\u00103¨\u00065"}, d2 = {"toUtcDayMillis", "", "localMillis", "rememberSelectableDates", "Landroidx/compose/material3/SelectableDates;", "selectableDatesRecord", "Lexpo/modules/ui/SelectableDatesRecord;", "(Lexpo/modules/ui/SelectableDatesRecord;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableDates;", "rememberDatePickerYearRange", "Lkotlin/ranges/IntRange;", "initialDateMillis", "initialEndDateMillis", "(Lexpo/modules/ui/SelectableDatesRecord;JLjava/lang/Long;Landroidx/compose/runtime/Composer;II)Lkotlin/ranges/IntRange;", "buildDatePickerColors", "Landroidx/compose/material3/DatePickerColors;", "elementColors", "Lexpo/modules/ui/DateTimePickerColorOverrides;", "colorProp", "Landroidx/compose/ui/graphics/Color;", "defaults", "buildDatePickerColors-BAq54LU", "(Lexpo/modules/ui/DateTimePickerColorOverrides;Landroidx/compose/ui/graphics/Color;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerColors;", "buildTimePickerColors", "Landroidx/compose/material3/TimePickerColors;", "buildTimePickerColors-BAq54LU", "(Lexpo/modules/ui/DateTimePickerColorOverrides;Landroidx/compose/ui/graphics/Color;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerColors;", "ApplyDatePickerDialogKeyboardBehavior", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "ApplyDatePickerDialogKeyboardBehavior-QujVXRc", "(ILandroidx/compose/runtime/Composer;I)V", "ExpoDatePickerDialogContent", "props", "Lexpo/modules/ui/DatePickerDialogProps;", "onDateSelected", "Lkotlin/Function1;", "Lexpo/modules/ui/DatePickerResult;", "onDismissRequest", "Lkotlin/Function0;", "(Lexpo/modules/ui/DatePickerDialogProps;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ExpoTimePickerDialogContent", "Lexpo/modules/ui/TimePickerDialogProps;", "(Lexpo/modules/ui/TimePickerDialogProps;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DateTimePickerContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "Lexpo/modules/ui/DateTimePickerProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/DateTimePickerProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ExpoDatePicker", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lexpo/modules/ui/DateTimePickerProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ExpoTimePicker", "expo-ui_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DatePickerViewKt {
    static final Unit ApplyDatePickerDialogKeyboardBehavior_QujVXRc$lambda$11(int i, int i2, Composer composer, int i3) {
        m12112ApplyDatePickerDialogKeyboardBehaviorQujVXRc(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    static final Unit DateTimePickerContent$lambda$46(FunctionalComposableScope functionalComposableScope, DateTimePickerProps dateTimePickerProps, Function1 function1, int i, Composer composer, int i2) {
        DateTimePickerContent(functionalComposableScope, dateTimePickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePicker$lambda$51(Modifier modifier, DateTimePickerProps dateTimePickerProps, Function1 function1, int i, int i2, Composer composer, int i3) {
        ExpoDatePicker(modifier, dateTimePickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$27(DatePickerDialogProps datePickerDialogProps, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        ExpoDatePickerDialogContent(datePickerDialogProps, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePicker$lambda$54(Modifier modifier, DateTimePickerProps dateTimePickerProps, Function1 function1, int i, int i2, Composer composer, int i3) {
        ExpoTimePicker(modifier, dateTimePickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$41(TimePickerDialogProps timePickerDialogProps, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        ExpoTimePickerDialogContent(timePickerDialogProps, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final long toUtcDayMillis(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        Calendar calendar2 = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        calendar2.set(calendar.get(1), calendar.get(2), calendar.get(5), 0, 0, 0);
        calendar2.set(14, 0);
        return calendar2.getTimeInMillis();
    }

    public static final SelectableDates rememberSelectableDates(SelectableDatesRecord selectableDatesRecord, Composer composer, int i) {
        final Integer numValueOf;
        SelectableDates allDates;
        ComposerKt.sourceInformationMarkerStart(composer, -1912423973, "C(rememberSelectableDates)N(selectableDatesRecord)203@6935L1177:DatePickerView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1912423973, i, -1, "expo.modules.ui.rememberSelectableDates (DatePickerView.kt:200)");
        }
        final Integer numValueOf2 = null;
        Long start = selectableDatesRecord != null ? selectableDatesRecord.getStart() : null;
        Long end = selectableDatesRecord != null ? selectableDatesRecord.getEnd() : null;
        ComposerKt.sourceInformationMarkerStart(composer, 406573396, "CC(remember):DatePickerView.kt#9igjgp");
        boolean zChanged = composer.changed(start) | composer.changed(end);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            if (start != null || end != null) {
                final Long lValueOf = start != null ? Long.valueOf(toUtcDayMillis(start.longValue())) : null;
                final Long lValueOf2 = end != null ? Long.valueOf(toUtcDayMillis(end.longValue())) : null;
                if (start != null) {
                    long jLongValue = start.longValue();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(jLongValue);
                    numValueOf = Integer.valueOf(calendar.get(1));
                } else {
                    numValueOf = null;
                }
                if (end != null) {
                    long jLongValue2 = end.longValue();
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.setTimeInMillis(jLongValue2);
                    numValueOf2 = Integer.valueOf(calendar2.get(1));
                }
                allDates = new SelectableDates() { // from class: expo.modules.ui.DatePickerViewKt$rememberSelectableDates$1$1
                    @Override // androidx.compose.material3.SelectableDates
                    public boolean isSelectableDate(long utcTimeMillis) {
                        Long l = lValueOf;
                        if (l != null && utcTimeMillis < l.longValue()) {
                            return false;
                        }
                        Long l2 = lValueOf2;
                        return l2 == null || utcTimeMillis <= l2.longValue();
                    }

                    @Override // androidx.compose.material3.SelectableDates
                    public boolean isSelectableYear(int year) {
                        Integer num = numValueOf;
                        if (num != null && year < num.intValue()) {
                            return false;
                        }
                        Integer num2 = numValueOf2;
                        return num2 == null || year <= num2.intValue();
                    }
                };
            } else {
                allDates = DatePickerDefaults.INSTANCE.getAllDates();
            }
            objRememberedValue = allDates;
            composer.updateRememberedValue(objRememberedValue);
        }
        SelectableDates selectableDates = (SelectableDates) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return selectableDates;
    }

    public static final IntRange rememberDatePickerYearRange(SelectableDatesRecord selectableDatesRecord, long j, Long l, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1782089943, "C(rememberDatePickerYearRange)N(selectableDatesRecord,initialDateMillis,initialEndDateMillis)259@8744L699:DatePickerView.kt#v15e7d");
        if ((i2 & 4) != 0) {
            l = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1782089943, i, -1, "expo.modules.ui.rememberDatePickerYearRange (DatePickerView.kt:256)");
        }
        Long start = selectableDatesRecord != null ? selectableDatesRecord.getStart() : null;
        Long end = selectableDatesRecord != null ? selectableDatesRecord.getEnd() : null;
        ComposerKt.sourceInformationMarkerStart(composer, -1103505486, "CC(remember):DatePickerView.kt#9igjgp");
        boolean zChanged = composer.changed(start) | composer.changed(end) | ((((i & 112) ^ 48) > 32 && composer.changed(j)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(l)) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            IntRange yearRange = DatePickerDefaults.INSTANCE.getYearRange();
            Function1 function1 = new Function1() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Integer.valueOf(DatePickerViewKt.rememberDatePickerYearRange$lambda$7$lambda$6(((Long) obj).longValue()));
                }
            };
            int iIntValue = start != null ? ((Number) function1.invoke(start)).intValue() : yearRange.getFirst();
            int iIntValue2 = end != null ? ((Number) function1.invoke(end)).intValue() : yearRange.getLast();
            int iIntValue3 = ((Number) function1.invoke(Long.valueOf(j))).intValue();
            int iIntValue4 = l != null ? ((Number) function1.invoke(l)).intValue() : iIntValue3;
            objRememberedValue = new IntRange(Math.min(iIntValue, Math.min(iIntValue3, iIntValue4)), Math.max(iIntValue2, Math.max(iIntValue3, iIntValue4)));
            composer.updateRememberedValue(objRememberedValue);
        }
        IntRange intRange = (IntRange) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return intRange;
    }

    static final int rememberDatePickerYearRange$lambda$7$lambda$6(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(1);
    }

    /* JADX INFO: renamed from: buildDatePickerColors-BAq54LU, reason: not valid java name */
    public static final DatePickerColors m12113buildDatePickerColorsBAq54LU(DateTimePickerColorOverrides dateTimePickerColorOverrides, Color color, DatePickerColors datePickerColors, Composer composer, int i, int i2) {
        long jM7348unboximpl;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        long jM7348unboximpl4;
        ComposerKt.sourceInformationMarkerStart(composer, 1991323504, "C(buildDatePickerColors)N(elementColors,colorProp:c#ui.graphics.Color,defaults)279@9740L8:DatePickerView.kt#v15e7d");
        DateTimePickerColorOverrides dateTimePickerColorOverrides2 = (i2 & 1) != 0 ? new DateTimePickerColorOverrides() : dateTimePickerColorOverrides;
        Color color2 = (i2 & 2) != 0 ? null : color;
        DatePickerColors datePickerColorsColors = (i2 & 4) != 0 ? DatePickerDefaults.INSTANCE.colors(composer, 6) : datePickerColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1991323504, i, -1, "expo.modules.ui.buildDatePickerColors (DatePickerView.kt:280)");
        }
        Color composeOrNull = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getContainerColor());
        long jM7348unboximpl5 = composeOrNull != null ? composeOrNull.m7348unboximpl() : datePickerColorsColors.getContainerColor();
        Color composeOrNull2 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getTitleContentColor());
        if (composeOrNull2 != null) {
            jM7348unboximpl = composeOrNull2.m7348unboximpl();
        } else {
            jM7348unboximpl = color2 != null ? color2.m7348unboximpl() : datePickerColorsColors.getTitleContentColor();
        }
        Color composeOrNull3 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getHeadlineContentColor());
        if (composeOrNull3 != null) {
            jM7348unboximpl2 = composeOrNull3.m7348unboximpl();
        } else {
            jM7348unboximpl2 = color2 != null ? color2.m7348unboximpl() : datePickerColorsColors.getHeadlineContentColor();
        }
        Color composeOrNull4 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getWeekdayContentColor());
        long jM7348unboximpl6 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : datePickerColorsColors.getWeekdayContentColor();
        Color composeOrNull5 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getSubheadContentColor());
        long jM7348unboximpl7 = composeOrNull5 != null ? composeOrNull5.m7348unboximpl() : datePickerColorsColors.getSubheadContentColor();
        Color composeOrNull6 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getNavigationContentColor());
        long jM7348unboximpl8 = composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : datePickerColorsColors.getNavigationContentColor();
        Color composeOrNull7 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getYearContentColor());
        long jM7348unboximpl9 = composeOrNull7 != null ? composeOrNull7.m7348unboximpl() : datePickerColorsColors.getYearContentColor();
        Color composeOrNull8 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDisabledYearContentColor());
        long jM7348unboximpl10 = composeOrNull8 != null ? composeOrNull8.m7348unboximpl() : datePickerColorsColors.getDisabledYearContentColor();
        Color composeOrNull9 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getCurrentYearContentColor());
        long jM7348unboximpl11 = composeOrNull9 != null ? composeOrNull9.m7348unboximpl() : datePickerColorsColors.getCurrentYearContentColor();
        Color composeOrNull10 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getSelectedYearContentColor());
        long jM7348unboximpl12 = composeOrNull10 != null ? composeOrNull10.m7348unboximpl() : datePickerColorsColors.getSelectedYearContentColor();
        Color composeOrNull11 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDisabledSelectedYearContentColor());
        long jM7348unboximpl13 = composeOrNull11 != null ? composeOrNull11.m7348unboximpl() : datePickerColorsColors.getDisabledSelectedYearContentColor();
        Color composeOrNull12 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getSelectedYearContainerColor());
        long jM7348unboximpl14 = composeOrNull12 != null ? composeOrNull12.m7348unboximpl() : datePickerColorsColors.getSelectedYearContainerColor();
        Color composeOrNull13 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDisabledSelectedYearContainerColor());
        long jM7348unboximpl15 = composeOrNull13 != null ? composeOrNull13.m7348unboximpl() : datePickerColorsColors.getDisabledSelectedYearContainerColor();
        Color composeOrNull14 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDayContentColor());
        long jM7348unboximpl16 = composeOrNull14 != null ? composeOrNull14.m7348unboximpl() : datePickerColorsColors.getDayContentColor();
        Color composeOrNull15 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDisabledDayContentColor());
        long jM7348unboximpl17 = composeOrNull15 != null ? composeOrNull15.m7348unboximpl() : datePickerColorsColors.getDisabledDayContentColor();
        Color composeOrNull16 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getSelectedDayContentColor());
        long jM7348unboximpl18 = composeOrNull16 != null ? composeOrNull16.m7348unboximpl() : datePickerColorsColors.getSelectedDayContentColor();
        Color composeOrNull17 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDisabledSelectedDayContentColor());
        long jM7348unboximpl19 = composeOrNull17 != null ? composeOrNull17.m7348unboximpl() : datePickerColorsColors.getDisabledSelectedDayContentColor();
        Color composeOrNull18 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getSelectedDayContainerColor());
        if (composeOrNull18 != null) {
            jM7348unboximpl3 = composeOrNull18.m7348unboximpl();
        } else {
            jM7348unboximpl3 = color2 != null ? color2.m7348unboximpl() : datePickerColorsColors.getSelectedDayContainerColor();
        }
        Color composeOrNull19 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDisabledSelectedDayContainerColor());
        long jM7348unboximpl20 = composeOrNull19 != null ? composeOrNull19.m7348unboximpl() : datePickerColorsColors.getDisabledSelectedDayContainerColor();
        Color composeOrNull20 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getTodayContentColor());
        long jM7348unboximpl21 = composeOrNull20 != null ? composeOrNull20.m7348unboximpl() : datePickerColorsColors.getTodayContentColor();
        Color composeOrNull21 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getTodayDateBorderColor());
        if (composeOrNull21 != null) {
            jM7348unboximpl4 = composeOrNull21.m7348unboximpl();
        } else {
            jM7348unboximpl4 = color2 != null ? color2.m7348unboximpl() : datePickerColorsColors.getTodayDateBorderColor();
        }
        long j = jM7348unboximpl4;
        Color composeOrNull22 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDayInSelectionRangeContentColor());
        long jM7348unboximpl22 = composeOrNull22 != null ? composeOrNull22.m7348unboximpl() : datePickerColorsColors.getDayInSelectionRangeContentColor();
        Color composeOrNull23 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDayInSelectionRangeContainerColor());
        long jM7348unboximpl23 = composeOrNull23 != null ? composeOrNull23.m7348unboximpl() : datePickerColorsColors.getDayInSelectionRangeContainerColor();
        Color composeOrNull24 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getDividerColor());
        DatePickerColors datePickerColorsM3764copytNwlRmA = datePickerColorsColors.m3764copytNwlRmA((16777216 & 1) != 0 ? datePickerColorsColors.containerColor : jM7348unboximpl5, (16777216 & 2) != 0 ? datePickerColorsColors.titleContentColor : jM7348unboximpl, (16777216 & 4) != 0 ? datePickerColorsColors.headlineContentColor : jM7348unboximpl2, (16777216 & 8) != 0 ? datePickerColorsColors.weekdayContentColor : jM7348unboximpl6, (16777216 & 16) != 0 ? datePickerColorsColors.subheadContentColor : jM7348unboximpl7, (16777216 & 32) != 0 ? datePickerColorsColors.navigationContentColor : jM7348unboximpl8, (16777216 & 64) != 0 ? datePickerColorsColors.yearContentColor : jM7348unboximpl9, (16777216 & 128) != 0 ? datePickerColorsColors.disabledYearContentColor : jM7348unboximpl10, (16777216 & 256) != 0 ? datePickerColorsColors.currentYearContentColor : jM7348unboximpl11, (16777216 & 512) != 0 ? datePickerColorsColors.selectedYearContentColor : jM7348unboximpl12, (16777216 & 1024) != 0 ? datePickerColorsColors.disabledSelectedYearContentColor : jM7348unboximpl13, (16777216 & 2048) != 0 ? datePickerColorsColors.selectedYearContainerColor : jM7348unboximpl14, (16777216 & 4096) != 0 ? datePickerColorsColors.disabledSelectedYearContainerColor : jM7348unboximpl15, (16777216 & 8192) != 0 ? datePickerColorsColors.dayContentColor : jM7348unboximpl16, (16777216 & 16384) != 0 ? datePickerColorsColors.disabledDayContentColor : jM7348unboximpl17, (16777216 & 32768) != 0 ? datePickerColorsColors.selectedDayContentColor : jM7348unboximpl18, (16777216 & 65536) != 0 ? datePickerColorsColors.disabledSelectedDayContentColor : jM7348unboximpl19, (16777216 & 131072) != 0 ? datePickerColorsColors.selectedDayContainerColor : jM7348unboximpl3, (16777216 & 262144) != 0 ? datePickerColorsColors.disabledSelectedDayContainerColor : jM7348unboximpl20, (16777216 & 524288) != 0 ? datePickerColorsColors.todayContentColor : jM7348unboximpl21, (16777216 & 1048576) != 0 ? datePickerColorsColors.todayDateBorderColor : j, (16777216 & 2097152) != 0 ? datePickerColorsColors.dayInSelectionRangeContainerColor : jM7348unboximpl23, (16777216 & 4194304) != 0 ? datePickerColorsColors.dayInSelectionRangeContentColor : jM7348unboximpl22, (16777216 & 8388608) != 0 ? datePickerColorsColors.dividerColor : composeOrNull24 != null ? composeOrNull24.m7348unboximpl() : datePickerColorsColors.getDividerColor(), (16777216 & 16777216) != 0 ? datePickerColorsColors.dateTextFieldColors : null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerColorsM3764copytNwlRmA;
    }

    /* JADX INFO: renamed from: buildTimePickerColors-BAq54LU, reason: not valid java name */
    public static final TimePickerColors m12114buildTimePickerColorsBAq54LU(DateTimePickerColorOverrides dateTimePickerColorOverrides, Color color, TimePickerColors timePickerColors, Composer composer, int i, int i2) {
        long jM7348unboximpl;
        long jM7348unboximpl2;
        long jM7348unboximpl3;
        ComposerKt.sourceInformationMarkerStart(composer, -1016419281, "C(buildTimePickerColors)N(elementColors,colorProp:c#ui.graphics.Color,defaults)314@13032L8:DatePickerView.kt#v15e7d");
        DateTimePickerColorOverrides dateTimePickerColorOverrides2 = (i2 & 1) != 0 ? new DateTimePickerColorOverrides() : dateTimePickerColorOverrides;
        Color color2 = (i2 & 2) != 0 ? null : color;
        TimePickerColors timePickerColorsColors = (i2 & 4) != 0 ? TimePickerDefaults.INSTANCE.colors(composer, 6) : timePickerColors;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1016419281, i, -1, "expo.modules.ui.buildTimePickerColors (DatePickerView.kt:315)");
        }
        Color composeOrNull = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getContainerColor());
        long jM7348unboximpl4 = composeOrNull != null ? composeOrNull.m7348unboximpl() : timePickerColorsColors.getContainerColor();
        Color composeOrNull2 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getClockDialColor());
        if (composeOrNull2 != null) {
            jM7348unboximpl = composeOrNull2.m7348unboximpl();
        } else {
            Color colorM7328boximpl = color2 != null ? Color.m7328boximpl(Color.m7337copywmQWz5c$default(color2.m7348unboximpl(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null)) : null;
            jM7348unboximpl = colorM7328boximpl != null ? colorM7328boximpl.m7348unboximpl() : timePickerColorsColors.getClockDialColor();
        }
        long j = jM7348unboximpl;
        Color composeOrNull3 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getClockDialSelectedContentColor());
        long jM7348unboximpl5 = composeOrNull3 != null ? composeOrNull3.m7348unboximpl() : timePickerColorsColors.getClockDialSelectedContentColor();
        Color composeOrNull4 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getClockDialUnselectedContentColor());
        long jM7348unboximpl6 = composeOrNull4 != null ? composeOrNull4.m7348unboximpl() : timePickerColorsColors.getClockDialUnselectedContentColor();
        Color composeOrNull5 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getSelectorColor());
        if (composeOrNull5 != null) {
            jM7348unboximpl2 = composeOrNull5.m7348unboximpl();
        } else {
            jM7348unboximpl2 = color2 != null ? color2.m7348unboximpl() : timePickerColorsColors.getSelectorColor();
        }
        long j2 = jM7348unboximpl2;
        Color composeOrNull6 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getPeriodSelectorBorderColor());
        long jM7348unboximpl7 = composeOrNull6 != null ? composeOrNull6.m7348unboximpl() : timePickerColorsColors.getPeriodSelectorBorderColor();
        Color composeOrNull7 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getPeriodSelectorSelectedContainerColor());
        long jM7348unboximpl8 = composeOrNull7 != null ? composeOrNull7.m7348unboximpl() : timePickerColorsColors.getPeriodSelectorSelectedContainerColor();
        Color composeOrNull8 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getPeriodSelectorUnselectedContainerColor());
        long jM7348unboximpl9 = composeOrNull8 != null ? composeOrNull8.m7348unboximpl() : timePickerColorsColors.getPeriodSelectorUnselectedContainerColor();
        Color composeOrNull9 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getPeriodSelectorSelectedContentColor());
        long jM7348unboximpl10 = composeOrNull9 != null ? composeOrNull9.m7348unboximpl() : timePickerColorsColors.getPeriodSelectorSelectedContentColor();
        Color composeOrNull10 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getPeriodSelectorUnselectedContentColor());
        long jM7348unboximpl11 = composeOrNull10 != null ? composeOrNull10.m7348unboximpl() : timePickerColorsColors.getPeriodSelectorUnselectedContentColor();
        Color composeOrNull11 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getTimeSelectorSelectedContainerColor());
        if (composeOrNull11 != null) {
            jM7348unboximpl3 = composeOrNull11.m7348unboximpl();
        } else {
            jM7348unboximpl3 = color2 != null ? color2.m7348unboximpl() : timePickerColorsColors.getTimeSelectorSelectedContainerColor();
        }
        long j3 = jM7348unboximpl3;
        Color composeOrNull12 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getTimeSelectorUnselectedContainerColor());
        long jM7348unboximpl12 = composeOrNull12 != null ? composeOrNull12.m7348unboximpl() : timePickerColorsColors.getTimeSelectorUnselectedContainerColor();
        Color composeOrNull13 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getTimeSelectorSelectedContentColor());
        long jM7348unboximpl13 = composeOrNull13 != null ? composeOrNull13.m7348unboximpl() : timePickerColorsColors.getTimeSelectorSelectedContentColor();
        Color composeOrNull14 = UtilsKt.getComposeOrNull(dateTimePickerColorOverrides2.getTimeSelectorUnselectedContentColor());
        TimePickerColors timePickerColorsM4935copydVHXu7A = timePickerColorsColors.m4935copydVHXu7A(j, j2, jM7348unboximpl4, jM7348unboximpl7, jM7348unboximpl5, jM7348unboximpl6, jM7348unboximpl8, jM7348unboximpl9, jM7348unboximpl10, jM7348unboximpl11, j3, jM7348unboximpl12, jM7348unboximpl13, composeOrNull14 != null ? composeOrNull14.m7348unboximpl() : timePickerColorsColors.getTimeSelectorUnselectedContentColor());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return timePickerColorsM4935copydVHXu7A;
    }

    /* JADX INFO: renamed from: ApplyDatePickerDialogKeyboardBehavior-QujVXRc, reason: not valid java name */
    public static final void m12112ApplyDatePickerDialogKeyboardBehaviorQujVXRc(final int i, Composer composer, final int i2) {
        int i3;
        Window window;
        WindowManager.LayoutParams attributes;
        Composer composerStartRestartGroup = composer.startRestartGroup(1749864474);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ApplyDatePickerDialogKeyboardBehavior)N(displayMode:c#material3.DisplayMode)337@15251L7,338@15318L7,339@15356L98,342@15468L359,342@15457L370:DatePickerView.kt#v15e7d");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1749864474, i3, -1, "expo.modules.ui.ApplyDatePickerDialogKeyboardBehavior (DatePickerView.kt:336)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final View view = (View) objConsume;
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2007412132, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(view);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                ViewParent parent = view.getParent();
                DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
                objRememberedValue = (dialogWindowProvider == null || (window = dialogWindowProvider.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : Integer.valueOf(attributes.softInputMode);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Integer num = (Integer) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2007408287, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(view) | ((i3 & 14) == 4) | composerStartRestartGroup.changed(softwareKeyboardController) | composerStartRestartGroup.changed(num);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerViewKt.ApplyDatePickerDialogKeyboardBehavior_QujVXRc$lambda$10$lambda$9(view, i, softwareKeyboardController, num);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ApplyDatePickerDialogKeyboardBehavior_QujVXRc$lambda$11(i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ApplyDatePickerDialogKeyboardBehavior_QujVXRc$lambda$10$lambda$9(View view, int i, SoftwareKeyboardController softwareKeyboardController, Integer num) {
        Window window;
        ViewParent parent = view.getParent();
        DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
        if (dialogWindowProvider == null || (window = dialogWindowProvider.getWindow()) == null) {
            return Unit.INSTANCE;
        }
        if (DisplayMode.m3889equalsimpl0(i, DisplayMode.INSTANCE.m3894getPickerjFl4v0())) {
            window.setSoftInputMode(48);
            if (softwareKeyboardController != null) {
                softwareKeyboardController.hide();
            }
        } else if (num != null) {
            window.setSoftInputMode(num.intValue());
        }
        return Unit.INSTANCE;
    }

    public static final void ExpoDatePickerDialogContent(final DatePickerDialogProps datePickerDialogProps, final Function1<? super DatePickerResult, Unit> onDateSelected, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        int i2;
        boolean z;
        DatePickerColors datePickerColors;
        int i3;
        String str;
        final ButtonColors buttonColorsM3576textButtonColorsro_MJ88;
        final DatePickerDialogProps props = datePickerDialogProps;
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(1233192626);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpoDatePickerDialogContent)N(props,onDateSelected,onDismissRequest)356@16055L7,358@16144L46,359@16212L24,361@16309L63,363@16388L321,374@16815L8,374@16726L98,379@17018L22,380@17062L260,385@17344L173,391@17543L709,378@16977L1275:DatePickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(props) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 256 : 128;
        }
        int i4 = i2;
        if (!composerStartRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1233192626, i4, -1, "expo.modules.ui.ExpoDatePickerDialogContent (DatePickerView.kt:355)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Locale locale = ((Configuration) objConsume).getLocales().get(0);
            int iM12131toDisplayModejFl4v0 = props.getVariant().m12131toDisplayModejFl4v0();
            SelectableDates selectableDatesRememberSelectableDates = rememberSelectableDates(props.getSelectableDates(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -312847894, "CC(remember):DatePickerView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = Long.valueOf(new Date().getTime());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            long jLongValue = ((Number) objRememberedValue).longValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Long initialDate = props.getInitialDate();
            if (initialDate != null) {
                jLongValue = initialDate.longValue();
            }
            long j = jLongValue;
            IntRange intRangeRememberDatePickerYearRange = rememberDatePickerYearRange(props.getSelectableDates(), j, null, composerStartRestartGroup, 0, 4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -312841965, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(iM12131toDisplayModejFl4v0) | composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(selectableDatesRememberSelectableDates) | composerStartRestartGroup.changed(intRangeRememberDatePickerYearRange);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Intrinsics.checkNotNull(locale);
                objRememberedValue2 = DatePickerKt.m3809DatePickerStatesHin3Bw(locale, props.getInitialDate(), Long.valueOf(j), intRangeRememberDatePickerYearRange, iM12131toDisplayModejFl4v0, selectableDatesRememberSelectableDates);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final DatePickerState datePickerState = (DatePickerState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DatePickerColors datePickerColorsM12113buildDatePickerColorsBAq54LU = m12113buildDatePickerColorsBAq54LU(props.getElementColors(), UtilsKt.getComposeOrNull(props.getColor()), DatePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6), composerStartRestartGroup, 0, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull != null) {
                composerStartRestartGroup.startReplaceGroup(-1107688394);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*376@16899L35");
                z = false;
                datePickerColors = datePickerColorsM12113buildDatePickerColorsBAq54LU;
                i3 = i4;
                str = "CC(remember):DatePickerView.kt#9igjgp";
                buttonColorsM3576textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3576textButtonColorsro_MJ88(0L, composeOrNull.m7348unboximpl(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 13);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1107688395);
                composerStartRestartGroup.endReplaceGroup();
                buttonColorsM3576textButtonColorsro_MJ88 = null;
                datePickerColors = datePickerColorsM12113buildDatePickerColorsBAq54LU;
                str = "CC(remember):DatePickerView.kt#9igjgp";
                i3 = i4;
                z = false;
            }
            if (buttonColorsM3576textButtonColorsro_MJ88 == null) {
                composerStartRestartGroup.startReplaceGroup(-312824124);
                ComposerKt.sourceInformation(composerStartRestartGroup, "376@16955L18");
                buttonColorsM3576textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.textButtonColors(composerStartRestartGroup, ButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-312827503);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -312822104, str);
            boolean z2 = (i3 & 896) == 256 ? true : z;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$16$lambda$15(onDismissRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final DatePickerColors datePickerColors2 = datePickerColors;
            props = datePickerDialogProps;
            DatePickerDialog_androidKt.m3794DatePickerDialogGmEhDVc((Function0) objRememberedValue3, ComposableLambdaKt.rememberComposableLambda(-1116712124, true, new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$20(onDateSelected, datePickerState, buttonColorsM3576textButtonColorsro_MJ88, datePickerDialogProps, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(780267334, true, new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$24(onDismissRequest, buttonColorsM3576textButtonColorsro_MJ88, datePickerDialogProps, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0.0f, datePickerColors2, null, ComposableLambdaKt.rememberComposableLambda(-1921501989, true, new Function3() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$26(datePickerState, datePickerColors2, datePickerDialogProps, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 100666416, RotationOptions.ROTATE_180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$27(props, onDateSelected, onDismissRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ExpoDatePickerDialogContent$lambda$16$lambda$15(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$20(final Function1 function1, final DatePickerState datePickerState, ButtonColors buttonColors, final DatePickerDialogProps datePickerDialogProps, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C381@17091L69,381@17229L87,381@17070L246:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1116712124, i, -1, "expo.modules.ui.ExpoDatePickerDialogContent.<anonymous> (DatePickerView.kt:381)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 581473833, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(datePickerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$20$lambda$18$lambda$17(function1, datePickerState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0<Unit>) function0, (Modifier) null, datePickerState.getSelectedDateMillis() != null, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1764719809, true, new Function3() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$20$lambda$19(datePickerDialogProps, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 490);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$20$lambda$18$lambda$17(Function1 function1, DatePickerState datePickerState) {
        function1.invoke(new DatePickerResult(datePickerState.getSelectedDateMillis()));
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$20$lambda$19(DatePickerDialogProps datePickerDialogProps, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C382@17239L69:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1764719809, i, -1, "expo.modules.ui.ExpoDatePickerDialogContent.<anonymous>.<anonymous> (DatePickerView.kt:382)");
            }
            String confirmButtonLabel = datePickerDialogProps.getConfirmButtonLabel();
            if (confirmButtonLabel == null) {
                composer.startReplaceGroup(-616344060);
                ComposerKt.sourceInformation(composer, "382@17272L35");
                confirmButtonLabel = StringResources_androidKt.stringResource(android.R.string.ok, composer, 6);
            } else {
                composer.startReplaceGroup(-616344928);
            }
            composer.endReplaceGroup();
            TextKt.m4929TextNvy7gAk(confirmButtonLabel, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$24(final Function0 function0, ButtonColors buttonColors, final DatePickerDialogProps datePickerDialogProps, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C386@17373L22,386@17420L91,386@17352L159:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(780267334, i, -1, "expo.modules.ui.ExpoDatePickerDialogContent.<anonymous> (DatePickerView.kt:386)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1782367876, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$24$lambda$22$lambda$21(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-633268029, true, new Function3() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$24$lambda$23(datePickerDialogProps, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$24$lambda$22$lambda$21(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$24$lambda$23(DatePickerDialogProps datePickerDialogProps, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C387@17430L73:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-633268029, i, -1, "expo.modules.ui.ExpoDatePickerDialogContent.<anonymous>.<anonymous> (DatePickerView.kt:387)");
            }
            String dismissButtonLabel = datePickerDialogProps.getDismissButtonLabel();
            if (dismissButtonLabel == null) {
                composer.startReplaceGroup(1314781578);
                ComposerKt.sourceInformation(composer, "387@17463L39");
                dismissButtonLabel = StringResources_androidKt.stringResource(android.R.string.cancel, composer, 6);
            } else {
                composer.startReplaceGroup(1314780710);
            }
            composer.endReplaceGroup();
            TextKt.m4929TextNvy7gAk(dismissButtonLabel, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$26(final DatePickerState datePickerState, final DatePickerColors datePickerColors, final DatePickerDialogProps datePickerDialogProps, ColumnScope DatePickerDialog, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DatePickerDialog, "$this$DatePickerDialog");
        ComposerKt.sourceInformation(composer, "C393@17589L50,397@17933L315,397@17850L398:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1921501989, i, -1, "expo.modules.ui.ExpoDatePickerDialogContent.<anonymous> (DatePickerView.kt:392)");
            }
            final int iMo3832getDisplayModejFl4v0 = datePickerState.mo3832getDisplayModejFl4v0();
            m12112ApplyDatePickerDialogKeyboardBehaviorQujVXRc(iMo3832getDisplayModejFl4v0, composer, 0);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m7328boximpl(datePickerColors.getNavigationContentColor())), ComposableLambdaKt.rememberComposableLambda(744053147, true, new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoDatePickerDialogContent$lambda$26$lambda$25(iMo3832getDisplayModejFl4v0, datePickerDialogProps, datePickerState, datePickerColors, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoDatePickerDialogContent$lambda$26$lambda$25(int i, DatePickerDialogProps datePickerDialogProps, DatePickerState datePickerState, DatePickerColors datePickerColors, Composer composer, int i2) {
        Modifier.Companion companionWrapContentHeight;
        ComposerKt.sourceInformation(composer, "C398@17941L301:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(744053147, i2, -1, "expo.modules.ui.ExpoDatePickerDialogContent.<anonymous>.<anonymous> (DatePickerView.kt:398)");
            }
            if (DisplayMode.m3889equalsimpl0(i, DisplayMode.INSTANCE.m3894getPickerjFl4v0())) {
                companionWrapContentHeight = SizeKt.wrapContentHeight(Modifier.INSTANCE, Alignment.INSTANCE.getTop(), true);
            } else {
                companionWrapContentHeight = Modifier.INSTANCE;
            }
            DatePickerKt.DatePicker(datePickerState, companionWrapContentHeight, null, datePickerColors, null, null, datePickerDialogProps.getShowVariantToggle(), null, composer, 0, RotationOptions.ROTATE_180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ExpoTimePickerDialogContent(final TimePickerDialogProps props, final Function1<? super DatePickerResult, Unit> onDateSelected, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        int i2;
        boolean z;
        TimePickerColors timePickerColors;
        String str;
        ButtonColors buttonColorsM3576textButtonColorsro_MJ88;
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(-423514060);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpoTimePickerDialogContent)N(props,onDateSelected,onDismissRequest)417@18499L312,429@18927L8,429@18838L98,434@19125L22,435@19169L443,448@19634L173,454@19874L142,433@19089L931:DatePickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(props) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-423514060, i2, -1, "expo.modules.ui.ExpoTimePickerDialogContent (DatePickerView.kt:414)");
            }
            final Long initialDate = props.getInitialDate();
            boolean zIs24Hour = props.is24Hour();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1024889548, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zIs24Hour) | composerStartRestartGroup.changed(initialDate);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Calendar calendar = Calendar.getInstance();
                if (initialDate != null) {
                    calendar.setTimeInMillis(initialDate.longValue());
                }
                objRememberedValue = TimePickerKt.TimePickerState(calendar.get(11), calendar.get(12), props.is24Hour());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final TimePickerState timePickerState = (TimePickerState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TimePickerColors timePickerColorsM12114buildTimePickerColorsBAq54LU = m12114buildTimePickerColorsBAq54LU(props.getElementColors(), UtilsKt.getComposeOrNull(props.getColor()), TimePickerDefaults.INSTANCE.colors(composerStartRestartGroup, 6), composerStartRestartGroup, 0, 0);
            Color composeOrNull = UtilsKt.getComposeOrNull(props.getColor());
            if (composeOrNull == null) {
                composerStartRestartGroup.startReplaceGroup(1707284115);
                composerStartRestartGroup.endReplaceGroup();
                buttonColorsM3576textButtonColorsro_MJ88 = null;
                timePickerColors = timePickerColorsM12114buildTimePickerColorsBAq54LU;
                z = true;
                str = "CC(remember):DatePickerView.kt#9igjgp";
            } else {
                composerStartRestartGroup.startReplaceGroup(1707284116);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*431@19011L35");
                z = true;
                timePickerColors = timePickerColorsM12114buildTimePickerColorsBAq54LU;
                str = "CC(remember):DatePickerView.kt#9igjgp";
                buttonColorsM3576textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m3576textButtonColorsro_MJ88(0L, composeOrNull.m7348unboximpl(), 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 13);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (buttonColorsM3576textButtonColorsro_MJ88 == null) {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(1024907430);
                ComposerKt.sourceInformation(composerStartRestartGroup, "431@19067L18");
                buttonColorsM3576textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.textButtonColors(composerStartRestartGroup, ButtonDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(1024904051);
                composerStartRestartGroup.endReplaceGroup();
            }
            long containerColor = timePickerColors.getContainerColor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1024909290, str);
            boolean z2 = (i2 & 896) == 256 ? z : false;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$31$lambda$30(onDismissRequest);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ButtonColors buttonColors = buttonColorsM3576textButtonColorsro_MJ88;
            final TimePickerColors timePickerColors2 = timePickerColors;
            Composer composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m3453AlertDialogOix01E0((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1405172500, z, new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$35(initialDate, timePickerState, onDateSelected, buttonColors, props, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-994562134, z, new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$39(onDismissRequest, buttonColors, props, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, ComposableLambdaKt.rememberComposableLambda(1768837063, z, new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$40(timePickerState, timePickerColors2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, containerColor, 0L, 0L, 0L, 0.0f, null, composer2, 1575984, 0, 16052);
            composerStartRestartGroup = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$41(props, onDateSelected, onDismissRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ExpoTimePickerDialogContent$lambda$31$lambda$30(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$35(final Long l, final TimePickerState timePickerState, final Function1 function1, ButtonColors buttonColors, final TimePickerDialogProps timePickerDialogProps, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C436@19198L296,444@19519L87,436@19177L429:DatePickerView.kt#v15e7d");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1405172500, i, -1, "expo.modules.ui.ExpoTimePickerDialogContent.<anonymous> (DatePickerView.kt:436)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1751040332, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composer.changed(l) | composer.changedInstance(timePickerState) | composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$35$lambda$33$lambda$32(l, timePickerState, function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1986060623, true, new Function3() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$35$lambda$34(timePickerDialogProps, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$35$lambda$33$lambda$32(Long l, TimePickerState timePickerState, Function1 function1) {
        Calendar calendar = Calendar.getInstance();
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        calendar.set(11, timePickerState.getHour());
        calendar.set(12, timePickerState.getMinute());
        function1.invoke(new DatePickerResult(Long.valueOf(calendar.getTime().getTime())));
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$35$lambda$34(TimePickerDialogProps timePickerDialogProps, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C445@19529L69:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1986060623, i, -1, "expo.modules.ui.ExpoTimePickerDialogContent.<anonymous>.<anonymous> (DatePickerView.kt:445)");
            }
            String confirmButtonLabel = timePickerDialogProps.getConfirmButtonLabel();
            if (confirmButtonLabel == null) {
                composer.startReplaceGroup(1638780690);
                ComposerKt.sourceInformation(composer, "445@19562L35");
                confirmButtonLabel = StringResources_androidKt.stringResource(android.R.string.ok, composer, 6);
            } else {
                composer.startReplaceGroup(1638779822);
            }
            composer.endReplaceGroup();
            TextKt.m4929TextNvy7gAk(confirmButtonLabel, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$39(final Function0 function0, ButtonColors buttonColors, final TimePickerDialogProps timePickerDialogProps, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C449@19663L22,449@19710L91,449@19642L159:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-994562134, i, -1, "expo.modules.ui.ExpoTimePickerDialogContent.<anonymous> (DatePickerView.kt:449)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2003497184, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$39$lambda$37$lambda$36(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (Shape) null, buttonColors, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1898296307, true, new Function3() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DatePickerViewKt.ExpoTimePickerDialogContent$lambda$39$lambda$38(timePickerDialogProps, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 494);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$39$lambda$37$lambda$36(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$39$lambda$38(TimePickerDialogProps timePickerDialogProps, RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C450@19720L73:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898296307, i, -1, "expo.modules.ui.ExpoTimePickerDialogContent.<anonymous>.<anonymous> (DatePickerView.kt:450)");
            }
            String dismissButtonLabel = timePickerDialogProps.getDismissButtonLabel();
            if (dismissButtonLabel == null) {
                composer.startReplaceGroup(1098351188);
                ComposerKt.sourceInformation(composer, "450@19753L39");
                dismissButtonLabel = StringResources_androidKt.stringResource(android.R.string.cancel, composer, 6);
            } else {
                composer.startReplaceGroup(1098350320);
            }
            composer.endReplaceGroup();
            TextKt.m4929TextNvy7gAk(dismissButtonLabel, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit ExpoTimePickerDialogContent$lambda$40(TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C455@19882L128:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1768837063, i, -1, "expo.modules.ui.ExpoTimePickerDialogContent.<anonymous> (DatePickerView.kt:455)");
            }
            TimePickerKt.m4986TimePickermT9BvqQ(timePickerState, null, timePickerColors, TimePickerLayoutType.INSTANCE.m5009getVerticalQJTpgSE(), composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void DateTimePickerContent(final FunctionalComposableScope functionalComposableScope, DateTimePickerProps props, final Function1<? super DatePickerResult, Unit> onDateSelected, Composer composer, final int i) {
        int i2;
        final DateTimePickerProps dateTimePickerProps;
        boolean z;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(2052567908);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DateTimePickerContent)N(props,onDateSelected)467@20236L83:DatePickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            dateTimePickerProps = props;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052567908, i2, -1, "expo.modules.ui.DateTimePickerContent (DatePickerView.kt:466)");
            }
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, AppContext.$stable << 3);
            composerStartRestartGroup = composerStartRestartGroup;
            if (props.getDisplayedComponents() == DisplayedComponents.HOUR_AND_MINUTE) {
                composerStartRestartGroup.startReplaceGroup(601522017);
                ComposerKt.sourceInformation(composerStartRestartGroup, "469@20449L32,469@20398L83");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127784356, "CC(remember):DatePickerView.kt#9igjgp");
                z = (i2 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerViewKt.DateTimePickerContent$lambda$43$lambda$42(onDateSelected, (DatePickerResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                dateTimePickerProps = props;
                ExpoTimePicker(modifierApplyModifiers, dateTimePickerProps, (Function1) objRememberedValue, composerStartRestartGroup, i2 & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                dateTimePickerProps = props;
                composerStartRestartGroup.startReplaceGroup(601620225);
                ComposerKt.sourceInformation(composerStartRestartGroup, "473@20548L32,473@20497L83");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1127787524, "CC(remember):DatePickerView.kt#9igjgp");
                z = (i2 & 896) == 256;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return DatePickerViewKt.DateTimePickerContent$lambda$45$lambda$44(onDateSelected, (DatePickerResult) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ExpoDatePicker(modifierApplyModifiers, dateTimePickerProps, (Function1) objRememberedValue2, composerStartRestartGroup, i2 & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.DateTimePickerContent$lambda$46(functionalComposableScope, dateTimePickerProps, onDateSelected, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit DateTimePickerContent$lambda$43$lambda$42(Function1 function1, DatePickerResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    static final Unit DateTimePickerContent$lambda$45$lambda$44(Function1 function1, DatePickerResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    public static final void ExpoDatePicker(Modifier modifier, final DateTimePickerProps props, final Function1<? super DatePickerResult, Unit> onDateSelected, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(73851819);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpoDatePicker)N(modifier,props,onDateSelected)482@20798L7,484@20884L24,486@20987L46,487@21052L63,489@21131L315,500@21491L75,500@21450L116,504@21583L69,508@21940L145,508@21857L228:DatePickerView.kt#v15e7d");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 256 : 128;
        }
        int i5 = i3;
        if (!composerStartRestartGroup.shouldExecute((i5 & 147) != 146, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(73851819, i5, -1, "expo.modules.ui.ExpoDatePicker (DatePickerView.kt:481)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Locale locale = ((Configuration) objConsume).getLocales().get(0);
            int iM12131toDisplayModejFl4v0 = props.getVariant().m12131toDisplayModejFl4v0();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2042836477, "CC(remember):DatePickerView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = Long.valueOf(new Date().getTime());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            long jLongValue = ((Number) objRememberedValue).longValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Long initialDate = props.getInitialDate();
            if (initialDate != null) {
                jLongValue = initialDate.longValue();
            }
            SelectableDates selectableDatesRememberSelectableDates = rememberSelectableDates(props.getSelectableDates(), composerStartRestartGroup, 0);
            long j = jLongValue;
            IntRange intRangeRememberDatePickerYearRange = rememberDatePickerYearRange(props.getSelectableDates(), j, null, composerStartRestartGroup, 0, 4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2042828282, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(iM12131toDisplayModejFl4v0) | composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(selectableDatesRememberSelectableDates) | composerStartRestartGroup.changed(intRangeRememberDatePickerYearRange);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Intrinsics.checkNotNull(locale);
                objRememberedValue2 = DatePickerKt.m3809DatePickerStatesHin3Bw(locale, Long.valueOf(j), Long.valueOf(j), intRangeRememberDatePickerYearRange, iM12131toDisplayModejFl4v0, selectableDatesRememberSelectableDates);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final DatePickerState datePickerState = (DatePickerState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Long selectedDateMillis = datePickerState.getSelectedDateMillis();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2042817002, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged2 = ((i5 & 896) == 256) | composerStartRestartGroup.changed(datePickerState);
            DatePickerViewKt$ExpoDatePicker$1$1 datePickerViewKt$ExpoDatePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || datePickerViewKt$ExpoDatePicker$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                datePickerViewKt$ExpoDatePicker$1$1RememberedValue = new DatePickerViewKt$ExpoDatePicker$1$1(onDateSelected, datePickerState, null);
                composerStartRestartGroup.updateRememberedValue(datePickerViewKt$ExpoDatePicker$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(selectedDateMillis, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) datePickerViewKt$ExpoDatePicker$1$1RememberedValue, composerStartRestartGroup, 0);
            final DatePickerColors datePickerColorsM12113buildDatePickerColorsBAq54LU = m12113buildDatePickerColorsBAq54LU(props.getElementColors(), UtilsKt.getComposeOrNull(props.getColor()), null, composerStartRestartGroup, 0, 4);
            composer2 = composerStartRestartGroup;
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m7328boximpl(datePickerColorsM12113buildDatePickerColorsBAq54LU.getNavigationContentColor())), ComposableLambdaKt.rememberComposableLambda(1301895275, true, new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoDatePicker$lambda$50(props, datePickerState, companion, datePickerColorsM12113buildDatePickerColorsBAq54LU, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoDatePicker$lambda$51(companion, props, onDateSelected, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit ExpoDatePicker$lambda$50(DateTimePickerProps dateTimePickerProps, DatePickerState datePickerState, Modifier modifier, DatePickerColors datePickerColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C509@21946L135:DatePickerView.kt#v15e7d");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1301895275, i, -1, "expo.modules.ui.ExpoDatePicker.<anonymous> (DatePickerView.kt:509)");
            }
            DatePickerKt.DatePicker(datePickerState, modifier, null, datePickerColors, null, null, dateTimePickerProps.getShowVariantToggle(), null, composer, 0, RotationOptions.ROTATE_180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ExpoTimePicker(Modifier modifier, final DateTimePickerProps props, final Function1<? super DatePickerResult, Unit> onDateSelected, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onDateSelected, "onDateSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-369319700);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExpoTimePicker)N(modifier,props,onDateSelected)523@22318L338,536@22701L290,536@22660L331,551@23112L69,547@22995L190:DatePickerView.kt#v15e7d");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDateSelected) ? 256 : 128;
        }
        int i5 = i3;
        if (!composerStartRestartGroup.shouldExecute((i5 & 147) != 146, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-369319700, i5, -1, "expo.modules.ui.ExpoTimePicker (DatePickerView.kt:520)");
            }
            Long initialDate = props.getInitialDate();
            boolean zIs24Hour = props.is24Hour();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1566061534, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zIs24Hour) | composerStartRestartGroup.changed(initialDate);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setLenient(false);
                if (initialDate != null) {
                    calendar.setTimeInMillis(initialDate.longValue());
                }
                objRememberedValue = TimePickerKt.TimePickerState(calendar.get(11), calendar.get(12), props.is24Hour());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            TimePickerState timePickerState = (TimePickerState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Integer numValueOf = Integer.valueOf(timePickerState.getHour());
            Integer numValueOf2 = Integer.valueOf(timePickerState.getMinute());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1566073742, "CC(remember):DatePickerView.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(initialDate) | composerStartRestartGroup.changedInstance(timePickerState) | ((i5 & 896) == 256);
            DatePickerViewKt$ExpoTimePicker$1$1 datePickerViewKt$ExpoTimePicker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || datePickerViewKt$ExpoTimePicker$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                datePickerViewKt$ExpoTimePicker$1$1RememberedValue = new DatePickerViewKt$ExpoTimePicker$1$1(initialDate, timePickerState, onDateSelected, null);
                composerStartRestartGroup.updateRememberedValue(datePickerViewKt$ExpoTimePicker$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, numValueOf2, (Function2) datePickerViewKt$ExpoTimePicker$1$1RememberedValue, composerStartRestartGroup, 0);
            Modifier modifier3 = modifier;
            TimePickerKt.m4986TimePickermT9BvqQ(timePickerState, modifier3, m12114buildTimePickerColorsBAq54LU(props.getElementColors(), UtilsKt.getComposeOrNull(props.getColor()), null, composerStartRestartGroup, 0, 4), TimePickerLayoutType.INSTANCE.m5009getVerticalQJTpgSE(), composerStartRestartGroup, (i5 << 3) & 112, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DatePickerViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DatePickerViewKt.ExpoTimePicker$lambda$54(modifier2, props, onDateSelected, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
