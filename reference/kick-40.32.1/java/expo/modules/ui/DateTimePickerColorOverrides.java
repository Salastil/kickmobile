package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatePickerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bp\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001xB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010v\u001a\u0006\u0012\u0002\b\u00030wH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\tR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\tR\u001e\u0010%\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\tR\u001e\u0010(\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\tR\u001e\u0010+\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010\tR\u001e\u0010.\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\tR\u001e\u00101\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\tR\u001e\u00104\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\tR\u001e\u00107\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\tR\u001e\u0010:\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\tR\u001e\u0010=\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\tR\u001e\u0010@\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\tR\u001e\u0010C\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010\tR\u001e\u0010F\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u0010\u0004\u001a\u0004\bH\u0010\tR\u001e\u0010I\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\tR\u001e\u0010L\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010\u0004\u001a\u0004\bN\u0010\tR\u001e\u0010O\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\tR\u001e\u0010R\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\tR\u001e\u0010U\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u0010\u0004\u001a\u0004\bW\u0010\tR\u001e\u0010X\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bY\u0010\u0004\u001a\u0004\bZ\u0010\tR\u001e\u0010[\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u0010\u0004\u001a\u0004\b]\u0010\tR\u001e\u0010^\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b_\u0010\u0004\u001a\u0004\b`\u0010\tR\u001e\u0010a\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bb\u0010\u0004\u001a\u0004\bc\u0010\tR\u001e\u0010d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010\u0004\u001a\u0004\bf\u0010\tR\u001e\u0010g\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bh\u0010\u0004\u001a\u0004\bi\u0010\tR\u001e\u0010j\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bk\u0010\u0004\u001a\u0004\bl\u0010\tR\u001e\u0010m\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bn\u0010\u0004\u001a\u0004\bo\u0010\tR\u001e\u0010p\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bq\u0010\u0004\u001a\u0004\br\u0010\tR\u001e\u0010s\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bt\u0010\u0004\u001a\u0004\bu\u0010\t¨\u0006y"}, d2 = {"Lexpo/modules/ui/DateTimePickerColorOverrides;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "<init>", "()V", "containerColor", "Landroid/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "()Landroid/graphics/Color;", "titleContentColor", "getTitleContentColor$annotations", "getTitleContentColor", "headlineContentColor", "getHeadlineContentColor$annotations", "getHeadlineContentColor", "weekdayContentColor", "getWeekdayContentColor$annotations", "getWeekdayContentColor", "subheadContentColor", "getSubheadContentColor$annotations", "getSubheadContentColor", "navigationContentColor", "getNavigationContentColor$annotations", "getNavigationContentColor", "yearContentColor", "getYearContentColor$annotations", "getYearContentColor", "disabledYearContentColor", "getDisabledYearContentColor$annotations", "getDisabledYearContentColor", "currentYearContentColor", "getCurrentYearContentColor$annotations", "getCurrentYearContentColor", "selectedYearContentColor", "getSelectedYearContentColor$annotations", "getSelectedYearContentColor", "disabledSelectedYearContentColor", "getDisabledSelectedYearContentColor$annotations", "getDisabledSelectedYearContentColor", "selectedYearContainerColor", "getSelectedYearContainerColor$annotations", "getSelectedYearContainerColor", "disabledSelectedYearContainerColor", "getDisabledSelectedYearContainerColor$annotations", "getDisabledSelectedYearContainerColor", "dayContentColor", "getDayContentColor$annotations", "getDayContentColor", "disabledDayContentColor", "getDisabledDayContentColor$annotations", "getDisabledDayContentColor", "selectedDayContentColor", "getSelectedDayContentColor$annotations", "getSelectedDayContentColor", "disabledSelectedDayContentColor", "getDisabledSelectedDayContentColor$annotations", "getDisabledSelectedDayContentColor", "selectedDayContainerColor", "getSelectedDayContainerColor$annotations", "getSelectedDayContainerColor", "disabledSelectedDayContainerColor", "getDisabledSelectedDayContainerColor$annotations", "getDisabledSelectedDayContainerColor", "todayContentColor", "getTodayContentColor$annotations", "getTodayContentColor", "todayDateBorderColor", "getTodayDateBorderColor$annotations", "getTodayDateBorderColor", "dayInSelectionRangeContentColor", "getDayInSelectionRangeContentColor$annotations", "getDayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "getDayInSelectionRangeContainerColor$annotations", "getDayInSelectionRangeContainerColor", "dividerColor", "getDividerColor$annotations", "getDividerColor", "clockDialColor", "getClockDialColor$annotations", "getClockDialColor", "clockDialSelectedContentColor", "getClockDialSelectedContentColor$annotations", "getClockDialSelectedContentColor", "clockDialUnselectedContentColor", "getClockDialUnselectedContentColor$annotations", "getClockDialUnselectedContentColor", "selectorColor", "getSelectorColor$annotations", "getSelectorColor", "periodSelectorBorderColor", "getPeriodSelectorBorderColor$annotations", "getPeriodSelectorBorderColor", "periodSelectorSelectedContainerColor", "getPeriodSelectorSelectedContainerColor$annotations", "getPeriodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "getPeriodSelectorUnselectedContainerColor$annotations", "getPeriodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "getPeriodSelectorSelectedContentColor$annotations", "getPeriodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "getPeriodSelectorUnselectedContentColor$annotations", "getPeriodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "getTimeSelectorSelectedContainerColor$annotations", "getTimeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "getTimeSelectorUnselectedContainerColor$annotations", "getTimeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "getTimeSelectorSelectedContentColor$annotations", "getTimeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "getTimeSelectorUnselectedContentColor$annotations", "getTimeSelectorUnselectedContentColor", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DateTimePickerColorOverrides implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color clockDialColor;
    public Color clockDialSelectedContentColor;
    public Color clockDialUnselectedContentColor;
    public Color containerColor;
    public Color currentYearContentColor;
    public Color dayContentColor;
    public Color dayInSelectionRangeContainerColor;
    public Color dayInSelectionRangeContentColor;
    public Color disabledDayContentColor;
    public Color disabledSelectedDayContainerColor;
    public Color disabledSelectedDayContentColor;
    public Color disabledSelectedYearContainerColor;
    public Color disabledSelectedYearContentColor;
    public Color disabledYearContentColor;
    public Color dividerColor;
    public Color headlineContentColor;
    public Color navigationContentColor;
    public Color periodSelectorBorderColor;
    public Color periodSelectorSelectedContainerColor;
    public Color periodSelectorSelectedContentColor;
    public Color periodSelectorUnselectedContainerColor;
    public Color periodSelectorUnselectedContentColor;
    public Color selectedDayContainerColor;
    public Color selectedDayContentColor;
    public Color selectedYearContainerColor;
    public Color selectedYearContentColor;
    public Color selectorColor;
    public Color subheadContentColor;
    public Color timeSelectorSelectedContainerColor;
    public Color timeSelectorSelectedContentColor;
    public Color timeSelectorUnselectedContainerColor;
    public Color timeSelectorUnselectedContentColor;
    public Color titleContentColor;
    public Color todayContentColor;
    public Color todayDateBorderColor;
    public Color weekdayContentColor;
    public Color yearContentColor;

    /* JADX INFO: compiled from: DatePickerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/DateTimePickerColorOverrides$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DateTimePickerColorOverrides> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DateTimePickerColorOverrides.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("containerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("titleContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("headlineContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("weekdayContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("subheadContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("navigationContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false), new PProperty("yearContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 6, __pika, false, true, false), new PProperty("disabledYearContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 7, __pika, false, true, false), new PProperty("currentYearContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 8, __pika, false, true, false), new PProperty("selectedYearContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 9, __pika, false, true, false), new PProperty("disabledSelectedYearContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 10, __pika, false, true, false), new PProperty("selectedYearContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 11, __pika, false, true, false), new PProperty("disabledSelectedYearContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 12, __pika, false, true, false), new PProperty("dayContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 13, __pika, false, true, false), new PProperty("disabledDayContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 14, __pika, false, true, false), new PProperty("selectedDayContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 15, __pika, false, true, false), new PProperty("disabledSelectedDayContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 16, __pika, false, true, false), new PProperty("selectedDayContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 17, __pika, false, true, false), new PProperty("disabledSelectedDayContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 18, __pika, false, true, false), new PProperty("todayContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 19, __pika, false, true, false), new PProperty("todayDateBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 20, __pika, false, true, false), new PProperty("dayInSelectionRangeContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 21, __pika, false, true, false), new PProperty("dayInSelectionRangeContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 22, __pika, false, true, false), new PProperty("dividerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 23, __pika, false, true, false), new PProperty("clockDialColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 24, __pika, false, true, false), new PProperty("clockDialSelectedContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 25, __pika, false, true, false), new PProperty("clockDialUnselectedContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 26, __pika, false, true, false), new PProperty("selectorColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 27, __pika, false, true, false), new PProperty("periodSelectorBorderColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 28, __pika, false, true, false), new PProperty("periodSelectorSelectedContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 29, __pika, false, true, false), new PProperty("periodSelectorUnselectedContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 30, __pika, false, true, false), new PProperty("periodSelectorSelectedContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 31, __pika, false, true, false), new PProperty("periodSelectorUnselectedContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 32, __pika, false, true, false), new PProperty("timeSelectorSelectedContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 33, __pika, false, true, false), new PProperty("timeSelectorUnselectedContainerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 34, __pika, false, true, false), new PProperty("timeSelectorSelectedContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 35, __pika, false, true, false), new PProperty("timeSelectorUnselectedContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 36, __pika, false, true, false)}, PEmptyArrays.EMPTY_FUNCTIONS, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getContainerColor();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getTitleContentColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getHeadlineContentColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getWeekdayContentColor();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getSubheadContentColor();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getNavigationContentColor();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getYearContentColor();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDisabledYearContentColor();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getCurrentYearContentColor();
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getSelectedYearContentColor();
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDisabledSelectedYearContentColor();
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getSelectedYearContainerColor();
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDisabledSelectedYearContainerColor();
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDayContentColor();
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDisabledDayContentColor();
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getSelectedDayContentColor();
                case 16:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDisabledSelectedDayContentColor();
                case 17:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getSelectedDayContainerColor();
                case 18:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDisabledSelectedDayContainerColor();
                case 19:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getTodayContentColor();
                case 20:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getTodayDateBorderColor();
                case 21:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDayInSelectionRangeContentColor();
                case 22:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDayInSelectionRangeContainerColor();
                case 23:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getDividerColor();
                case 24:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getClockDialColor();
                case 25:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getClockDialSelectedContentColor();
                case 26:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getClockDialUnselectedContentColor();
                case 27:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getSelectorColor();
                case 28:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getPeriodSelectorBorderColor();
                case 29:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getPeriodSelectorSelectedContainerColor();
                case 30:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getPeriodSelectorUnselectedContainerColor();
                case 31:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getPeriodSelectorSelectedContentColor();
                case 32:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getPeriodSelectorUnselectedContentColor();
                case 33:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getTimeSelectorSelectedContainerColor();
                case 34:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getTimeSelectorUnselectedContainerColor();
                case 35:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getTimeSelectorSelectedContentColor();
                case 36:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    return ((DateTimePickerColorOverrides) obj).getTimeSelectorUnselectedContentColor();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).containerColor = (Color) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).titleContentColor = (Color) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).headlineContentColor = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).weekdayContentColor = (Color) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).subheadContentColor = (Color) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).navigationContentColor = (Color) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).yearContentColor = (Color) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).disabledYearContentColor = (Color) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).currentYearContentColor = (Color) obj2;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).selectedYearContentColor = (Color) obj2;
                    return;
                case 10:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).disabledSelectedYearContentColor = (Color) obj2;
                    return;
                case 11:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).selectedYearContainerColor = (Color) obj2;
                    return;
                case 12:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).disabledSelectedYearContainerColor = (Color) obj2;
                    return;
                case 13:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).dayContentColor = (Color) obj2;
                    return;
                case 14:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).disabledDayContentColor = (Color) obj2;
                    return;
                case 15:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).selectedDayContentColor = (Color) obj2;
                    return;
                case 16:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).disabledSelectedDayContentColor = (Color) obj2;
                    return;
                case 17:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).selectedDayContainerColor = (Color) obj2;
                    return;
                case 18:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).disabledSelectedDayContainerColor = (Color) obj2;
                    return;
                case 19:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).todayContentColor = (Color) obj2;
                    return;
                case 20:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).todayDateBorderColor = (Color) obj2;
                    return;
                case 21:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).dayInSelectionRangeContentColor = (Color) obj2;
                    return;
                case 22:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).dayInSelectionRangeContainerColor = (Color) obj2;
                    return;
                case 23:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).dividerColor = (Color) obj2;
                    return;
                case 24:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).clockDialColor = (Color) obj2;
                    return;
                case 25:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).clockDialSelectedContentColor = (Color) obj2;
                    return;
                case 26:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).clockDialUnselectedContentColor = (Color) obj2;
                    return;
                case 27:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).selectorColor = (Color) obj2;
                    return;
                case 28:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).periodSelectorBorderColor = (Color) obj2;
                    return;
                case 29:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).periodSelectorSelectedContainerColor = (Color) obj2;
                    return;
                case 30:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).periodSelectorUnselectedContainerColor = (Color) obj2;
                    return;
                case 31:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).periodSelectorSelectedContentColor = (Color) obj2;
                    return;
                case 32:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).periodSelectorUnselectedContentColor = (Color) obj2;
                    return;
                case 33:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).timeSelectorSelectedContainerColor = (Color) obj2;
                    return;
                case 34:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).timeSelectorUnselectedContainerColor = (Color) obj2;
                    return;
                case 35:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).timeSelectorSelectedContentColor = (Color) obj2;
                    return;
                case 36:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateTimePickerColorOverrides) obj).timeSelectorUnselectedContentColor = (Color) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    @Field
    public static /* synthetic */ void getClockDialColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getClockDialSelectedContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getClockDialUnselectedContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCurrentYearContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDayContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDayInSelectionRangeContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDayInSelectionRangeContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledDayContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledSelectedDayContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledSelectedDayContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledSelectedYearContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledSelectedYearContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledYearContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDividerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getHeadlineContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getNavigationContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getPeriodSelectorBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getPeriodSelectorSelectedContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getPeriodSelectorSelectedContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getPeriodSelectorUnselectedContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getPeriodSelectorUnselectedContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedDayContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedDayContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedYearContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedYearContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectorColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSubheadContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeSelectorSelectedContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeSelectorSelectedContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeSelectorUnselectedContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimeSelectorUnselectedContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTitleContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTodayContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTodayDateBorderColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getWeekdayContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getYearContentColor$annotations() {
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public final Color getContainerColor() {
        return this.containerColor;
    }

    public final Color getTitleContentColor() {
        return this.titleContentColor;
    }

    public final Color getHeadlineContentColor() {
        return this.headlineContentColor;
    }

    public final Color getWeekdayContentColor() {
        return this.weekdayContentColor;
    }

    public final Color getSubheadContentColor() {
        return this.subheadContentColor;
    }

    public final Color getNavigationContentColor() {
        return this.navigationContentColor;
    }

    public final Color getYearContentColor() {
        return this.yearContentColor;
    }

    public final Color getDisabledYearContentColor() {
        return this.disabledYearContentColor;
    }

    public final Color getCurrentYearContentColor() {
        return this.currentYearContentColor;
    }

    public final Color getSelectedYearContentColor() {
        return this.selectedYearContentColor;
    }

    public final Color getDisabledSelectedYearContentColor() {
        return this.disabledSelectedYearContentColor;
    }

    public final Color getSelectedYearContainerColor() {
        return this.selectedYearContainerColor;
    }

    public final Color getDisabledSelectedYearContainerColor() {
        return this.disabledSelectedYearContainerColor;
    }

    public final Color getDayContentColor() {
        return this.dayContentColor;
    }

    public final Color getDisabledDayContentColor() {
        return this.disabledDayContentColor;
    }

    public final Color getSelectedDayContentColor() {
        return this.selectedDayContentColor;
    }

    public final Color getDisabledSelectedDayContentColor() {
        return this.disabledSelectedDayContentColor;
    }

    public final Color getSelectedDayContainerColor() {
        return this.selectedDayContainerColor;
    }

    public final Color getDisabledSelectedDayContainerColor() {
        return this.disabledSelectedDayContainerColor;
    }

    public final Color getTodayContentColor() {
        return this.todayContentColor;
    }

    public final Color getTodayDateBorderColor() {
        return this.todayDateBorderColor;
    }

    public final Color getDayInSelectionRangeContentColor() {
        return this.dayInSelectionRangeContentColor;
    }

    public final Color getDayInSelectionRangeContainerColor() {
        return this.dayInSelectionRangeContainerColor;
    }

    public final Color getDividerColor() {
        return this.dividerColor;
    }

    public final Color getClockDialColor() {
        return this.clockDialColor;
    }

    public final Color getClockDialSelectedContentColor() {
        return this.clockDialSelectedContentColor;
    }

    public final Color getClockDialUnselectedContentColor() {
        return this.clockDialUnselectedContentColor;
    }

    public final Color getSelectorColor() {
        return this.selectorColor;
    }

    public final Color getPeriodSelectorBorderColor() {
        return this.periodSelectorBorderColor;
    }

    public final Color getPeriodSelectorSelectedContainerColor() {
        return this.periodSelectorSelectedContainerColor;
    }

    public final Color getPeriodSelectorUnselectedContainerColor() {
        return this.periodSelectorUnselectedContainerColor;
    }

    public final Color getPeriodSelectorSelectedContentColor() {
        return this.periodSelectorSelectedContentColor;
    }

    public final Color getPeriodSelectorUnselectedContentColor() {
        return this.periodSelectorUnselectedContentColor;
    }

    public final Color getTimeSelectorSelectedContainerColor() {
        return this.timeSelectorSelectedContainerColor;
    }

    public final Color getTimeSelectorUnselectedContainerColor() {
        return this.timeSelectorUnselectedContainerColor;
    }

    public final Color getTimeSelectorSelectedContentColor() {
        return this.timeSelectorSelectedContentColor;
    }

    public final Color getTimeSelectorUnselectedContentColor() {
        return this.timeSelectorUnselectedContentColor;
    }
}
