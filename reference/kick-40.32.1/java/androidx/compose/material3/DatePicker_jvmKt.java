package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.facebook.hermes.intl.Constants;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.YearMonth;
import j$.time.ZoneOffset;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: DatePicker.jvmAndAndroid.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000b\u001a \u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a \u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0004\u001aC\u0010\u0014\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001aO\u0010\u001a\u001a\u00020\u00112\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aM\u0010 \u001a\u00020\u001d2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aY\u0010#\u001a\u00020\u001d2\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b!\u0010\"\u001a\u001d\u0010&\u001a\u00020%*\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b&\u0010'\u001a\u0015\u0010(\u001a\u0004\u0018\u00010\u0007*\u00020\u0011H\u0007¢\u0006\u0004\b(\u0010)\u001a\u001b\u0010+\u001a\u00020%*\u00020\u00112\u0006\u0010*\u001a\u00020\tH\u0007¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020\t*\u00020\u0011H\u0007¢\u0006\u0004\b-\u0010.\u001a'\u00101\u001a\u00020%*\u00020\u001d2\b\u0010/\u001a\u0004\u0018\u00010\u00072\b\u00100\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b1\u00102\u001a\u0015\u00103\u001a\u0004\u0018\u00010\u0007*\u00020\u001dH\u0007¢\u0006\u0004\b3\u00104\u001a\u0015\u00105\u001a\u0004\u0018\u00010\u0007*\u00020\u001dH\u0007¢\u0006\u0004\b5\u00104\u001a\u001b\u0010+\u001a\u00020%*\u00020\u001d2\u0006\u0010*\u001a\u00020\tH\u0007¢\u0006\u0004\b+\u00106\u001a\u0013\u0010-\u001a\u00020\t*\u00020\u001dH\u0007¢\u0006\u0004\b-\u00107\u001a\u0017\u0010:\u001a\u00020\t2\u0006\u00109\u001a\u000208H\u0003¢\u0006\u0004\b:\u0010;\u001a\u0017\u0010<\u001a\u0002082\u0006\u0010*\u001a\u00020\tH\u0003¢\u0006\u0004\b<\u0010=\u001a\u001b\u0010?\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u000108H\u0003¢\u0006\u0004\b?\u0010@\u001a\u001b\u0010A\u001a\u0004\u0018\u0001082\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0004\bA\u0010B¨\u0006C"}, d2 = {"", "template", "localizedYear", "formatDatePickerNavigateToYearString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "verboseDateDescription", "formatHeadlineDescription", "j$/time/LocalDate", "initialSelectedDate", "j$/time/YearMonth", "initialDisplayedMonth", "Lkotlin/ranges/IntRange;", "yearRange", "Landroidx/compose/material3/DisplayMode;", "initialDisplayMode", "Landroidx/compose/material3/SelectableDates;", "selectableDates", "Landroidx/compose/material3/DatePickerState;", "rememberDatePickerState-EU0dCGE", "(Lj$/time/LocalDate;Lj$/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "rememberDatePickerState", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", Constants.LOCALE, "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Lj$/time/LocalDate;Lj$/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "DatePickerState", "initialSelectedStartDate", "initialSelectedEndDate", "Landroidx/compose/material3/DateRangePickerState;", "rememberDateRangePickerState-IlFM19s", "(Lj$/time/LocalDate;Lj$/time/LocalDate;Lj$/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "rememberDateRangePickerState", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Lj$/time/LocalDate;Lj$/time/LocalDate;Lj$/time/YearMonth;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "DateRangePickerState", "date", "", "setSelectedDate", "(Landroidx/compose/material3/DatePickerState;Lj$/time/LocalDate;)V", "getSelectedDate", "(Landroidx/compose/material3/DatePickerState;)Lj$/time/LocalDate;", "yearMonth", "setDisplayedMonth", "(Landroidx/compose/material3/DatePickerState;Lj$/time/YearMonth;)V", "getDisplayedMonth", "(Landroidx/compose/material3/DatePickerState;)Lj$/time/YearMonth;", "startDate", "endDate", "setSelection", "(Landroidx/compose/material3/DateRangePickerState;Lj$/time/LocalDate;Lj$/time/LocalDate;)V", "getSelectedStartDate", "(Landroidx/compose/material3/DateRangePickerState;)Lj$/time/LocalDate;", "getSelectedEndDate", "(Landroidx/compose/material3/DateRangePickerState;Lj$/time/YearMonth;)V", "(Landroidx/compose/material3/DateRangePickerState;)Lj$/time/YearMonth;", "", "millisUtcFirstOfMonth", "getYearMonth", "(J)Lj$/time/YearMonth;", "getYearMonthMillisUtc", "(Lj$/time/YearMonth;)J", "millisUtc", "getLocalDate", "(Ljava/lang/Long;)Lj$/time/LocalDate;", "getLocalDateMillisUtc", "(Lj$/time/LocalDate;)Ljava/lang/Long;", "material3"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DatePicker_jvmKt {
    public static final String formatDatePickerNavigateToYearString(String str, String str2) {
        String str3 = String.format(str, Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        return str3;
    }

    public static final String formatHeadlineDescription(String str, String str2) {
        String str3 = String.format(str, Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
        return str3;
    }

    /* JADX INFO: renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    public static final DatePickerState m3838rememberDatePickerStateEU0dCGE(LocalDate localDate, YearMonth yearMonth, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -2037014061, "C(rememberDatePickerState)N(initialSelectedDate,initialDisplayedMonth,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)75@3403L283:DatePicker.jvmAndAndroid.kt#uh7d8r");
        if ((i3 & 2) != 0) {
            yearMonth = localDate != null ? YearMonth.from(localDate) : null;
        }
        if ((i3 & 4) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        IntRange intRange2 = intRange;
        if ((i3 & 8) != 0) {
            i = DisplayMode.INSTANCE.m3894getPickerjFl4v0();
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        SelectableDates selectableDates2 = selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2037014061, i2, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.jvmAndAndroid.kt:72)");
        }
        DatePickerState datePickerStateM3825rememberDatePickerStateEU0dCGE = DatePickerKt.m3825rememberDatePickerStateEU0dCGE(localDate != null ? getLocalDateMillisUtc(localDate) : null, yearMonth != null ? Long.valueOf(getYearMonthMillisUtc(yearMonth)) : null, intRange2, i4, selectableDates2, composer, i2 & 65408, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return datePickerStateM3825rememberDatePickerStateEU0dCGE;
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m3835DatePickerStatesHin3Bw$default(Locale locale, LocalDate localDate, YearMonth yearMonth, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            yearMonth = localDate != null ? YearMonth.from(localDate) : null;
        }
        YearMonth yearMonth2 = yearMonth;
        if ((i2 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        IntRange intRange2 = intRange;
        if ((i2 & 16) != 0) {
            i = DisplayMode.INSTANCE.m3894getPickerjFl4v0();
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m3834DatePickerStatesHin3Bw(locale, localDate, yearMonth2, intRange2, i3, selectableDates);
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m3834DatePickerStatesHin3Bw(Locale locale, LocalDate localDate, YearMonth yearMonth, IntRange intRange, int i, SelectableDates selectableDates) {
        return DatePickerKt.m3809DatePickerStatesHin3Bw(locale, getLocalDateMillisUtc(localDate), yearMonth != null ? Long.valueOf(getYearMonthMillisUtc(yearMonth)) : null, intRange, i, selectableDates);
    }

    /* JADX INFO: renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m3839rememberDateRangePickerStateIlFM19s(LocalDate localDate, LocalDate localDate2, YearMonth yearMonth, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, -931481122, "C(rememberDateRangePickerState)N(initialSelectedStartDate,initialSelectedEndDate,initialDisplayedMonth,yearRange,initialDisplayMode:c#material3.DisplayMode,selectableDates)179@9356L367:DatePicker.jvmAndAndroid.kt#uh7d8r");
        if ((i3 & 4) != 0) {
            yearMonth = localDate != null ? YearMonth.from(localDate) : null;
        }
        if ((i3 & 8) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        IntRange intRange2 = intRange;
        int iM3894getPickerjFl4v0 = (i3 & 16) != 0 ? DisplayMode.INSTANCE.m3894getPickerjFl4v0() : i;
        SelectableDates allDates = (i3 & 32) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-931481122, i2, -1, "androidx.compose.material3.rememberDateRangePickerState (DatePicker.jvmAndAndroid.kt:175)");
        }
        DateRangePickerState dateRangePickerStateM3855rememberDateRangePickerStateIlFM19s = DateRangePickerKt.m3855rememberDateRangePickerStateIlFM19s(localDate != null ? getLocalDateMillisUtc(localDate) : null, localDate2 != null ? getLocalDateMillisUtc(localDate2) : null, yearMonth != null ? Long.valueOf(getYearMonthMillisUtc(yearMonth)) : null, intRange2, iM3894getPickerjFl4v0, allDates, composer, i2 & 523264, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dateRangePickerStateM3855rememberDateRangePickerStateIlFM19s;
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m3837DateRangePickerStateHVP43zI$default(Locale locale, LocalDate localDate, LocalDate localDate2, YearMonth yearMonth, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            yearMonth = localDate != null ? YearMonth.from(localDate) : null;
        }
        YearMonth yearMonth2 = yearMonth;
        if ((i2 & 16) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        IntRange intRange2 = intRange;
        if ((i2 & 32) != 0) {
            i = DisplayMode.INSTANCE.m3894getPickerjFl4v0();
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m3836DateRangePickerStateHVP43zI(locale, localDate, localDate2, yearMonth2, intRange2, i3, selectableDates);
    }

    /* JADX INFO: renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m3836DateRangePickerStateHVP43zI(Locale locale, LocalDate localDate, LocalDate localDate2, YearMonth yearMonth, IntRange intRange, int i, SelectableDates selectableDates) {
        return DateRangePickerKt.m3851DateRangePickerStateHVP43zI(locale, getLocalDateMillisUtc(localDate), getLocalDateMillisUtc(localDate2), yearMonth != null ? Long.valueOf(getYearMonthMillisUtc(yearMonth)) : null, intRange, i, selectableDates);
    }

    public static final void setSelectedDate(DatePickerState datePickerState, LocalDate localDate) {
        datePickerState.setSelectedDateMillis(getLocalDateMillisUtc(localDate));
    }

    public static final LocalDate getSelectedDate(DatePickerState datePickerState) {
        return getLocalDate(datePickerState.getSelectedDateMillis());
    }

    public static final void setDisplayedMonth(DatePickerState datePickerState, YearMonth yearMonth) {
        datePickerState.setDisplayedMonthMillis(getYearMonthMillisUtc(yearMonth));
    }

    public static final YearMonth getDisplayedMonth(DatePickerState datePickerState) {
        return getYearMonth(datePickerState.getDisplayedMonthMillis());
    }

    public static final void setSelection(DateRangePickerState dateRangePickerState, LocalDate localDate, LocalDate localDate2) {
        dateRangePickerState.setSelection(getLocalDateMillisUtc(localDate), getLocalDateMillisUtc(localDate2));
    }

    public static final LocalDate getSelectedStartDate(DateRangePickerState dateRangePickerState) {
        return getLocalDate(dateRangePickerState.getSelectedStartDateMillis());
    }

    public static final LocalDate getSelectedEndDate(DateRangePickerState dateRangePickerState) {
        return getLocalDate(dateRangePickerState.getSelectedEndDateMillis());
    }

    public static final void setDisplayedMonth(DateRangePickerState dateRangePickerState, YearMonth yearMonth) {
        dateRangePickerState.setDisplayedMonthMillis(getYearMonthMillisUtc(yearMonth));
    }

    public static final YearMonth getDisplayedMonth(DateRangePickerState dateRangePickerState) {
        return getYearMonth(dateRangePickerState.getDisplayedMonthMillis());
    }

    private static final YearMonth getYearMonth(long j) {
        return YearMonth.from(Instant.ofEpochMilli(j).atZone(ZoneOffset.UTC));
    }

    private static final long getYearMonthMillisUtc(YearMonth yearMonth) {
        return yearMonth.atDay(1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    private static final LocalDate getLocalDate(Long l) {
        if (l == null) {
            return null;
        }
        return Instant.ofEpochMilli(l.longValue()).atZone(ZoneOffset.UTC).toLocalDate();
    }

    private static final Long getLocalDateMillisUtc(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Long.valueOf(localDate.atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli());
    }
}
