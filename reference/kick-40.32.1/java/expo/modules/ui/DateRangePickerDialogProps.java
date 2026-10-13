package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateRangePickerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00019Bm\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jt\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\f\u00104\u001a\u0006\u0012\u0002\b\u000305H\u0016J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u000bHÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lexpo/modules/ui/DateRangePickerDialogProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "initialStartDate", "", "initialEndDate", "variant", "Lexpo/modules/ui/Variant;", "showVariantToggle", "", "confirmButtonLabel", "", "dismissButtonLabel", "color", "Landroid/graphics/Color;", "elementColors", "Lexpo/modules/ui/DateTimePickerColorOverrides;", "selectableDates", "Lexpo/modules/ui/SelectableDatesRecord;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Lexpo/modules/ui/Variant;ZLjava/lang/String;Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;Lexpo/modules/ui/SelectableDatesRecord;)V", "getInitialStartDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInitialEndDate", "getVariant", "()Lexpo/modules/ui/Variant;", "getShowVariantToggle", "()Z", "getConfirmButtonLabel", "()Ljava/lang/String;", "getDismissButtonLabel", "getColor", "()Landroid/graphics/Color;", "getElementColors", "()Lexpo/modules/ui/DateTimePickerColorOverrides;", "getSelectableDates", "()Lexpo/modules/ui/SelectableDatesRecord;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Lexpo/modules/ui/Variant;ZLjava/lang/String;Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;Lexpo/modules/ui/SelectableDatesRecord;)Lexpo/modules/ui/DateRangePickerDialogProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DateRangePickerDialogProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public String confirmButtonLabel;
    public String dismissButtonLabel;
    public DateTimePickerColorOverrides elementColors;
    public Long initialEndDate;
    public Long initialStartDate;
    public SelectableDatesRecord selectableDates;
    public boolean showVariantToggle;
    public Variant variant;

    /* JADX INFO: compiled from: DateRangePickerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/DateRangePickerDialogProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DateRangePickerDialogProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DateRangePickerDialogProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("initialStartDate", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.LONG_NULLABLE, 0, __pika, false, true, false), new PProperty("initialEndDate", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.LONG_NULLABLE, 1, __pika, false, true, false), new PProperty("variant", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Variant.class, false, null), 2, __pika, false, true, false), new PProperty("showVariantToggle", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("confirmButtonLabel", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 4, __pika, false, true, false), new PProperty("dismissButtonLabel", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 5, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 6, __pika, false, true, false), new PProperty("elementColors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(DateTimePickerColorOverrides.class, false, DateTimePickerColorOverrides.__Pika.__pika$IntrospectionData), 7, __pika, false, true, false), new PProperty("selectableDates", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(SelectableDatesRecord.class, true, SelectableDatesRecord.__Pika.__pika$IntrospectionData), 8, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getInitialStartDate();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getInitialEndDate();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getVariant();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return Boolean.valueOf(((DateRangePickerDialogProps) obj).getShowVariantToggle());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getConfirmButtonLabel();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getDismissButtonLabel();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getColor();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getElementColors();
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    return ((DateRangePickerDialogProps) obj).getSelectableDates();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    ((DateRangePickerDialogProps) obj).initialStartDate = (Long) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    ((DateRangePickerDialogProps) obj).initialEndDate = (Long) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.Variant");
                    ((DateRangePickerDialogProps) obj).variant = (Variant) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((DateRangePickerDialogProps) obj).showVariantToggle = ((Boolean) obj2).booleanValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    ((DateRangePickerDialogProps) obj).confirmButtonLabel = (String) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    ((DateRangePickerDialogProps) obj).dismissButtonLabel = (String) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    ((DateRangePickerDialogProps) obj).color = (Color) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateRangePickerDialogProps) obj).elementColors = (DateTimePickerColorOverrides) obj2;
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerDialogProps");
                    ((DateRangePickerDialogProps) obj).selectableDates = (SelectableDatesRecord) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public DateRangePickerDialogProps() {
        this(null, null, null, false, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ DateRangePickerDialogProps copy$default(DateRangePickerDialogProps dateRangePickerDialogProps, Long l, Long l2, Variant variant, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, SelectableDatesRecord selectableDatesRecord, int i, Object obj) {
        if ((i & 1) != 0) {
            l = dateRangePickerDialogProps.initialStartDate;
        }
        if ((i & 2) != 0) {
            l2 = dateRangePickerDialogProps.initialEndDate;
        }
        if ((i & 4) != 0) {
            variant = dateRangePickerDialogProps.variant;
        }
        if ((i & 8) != 0) {
            z = dateRangePickerDialogProps.showVariantToggle;
        }
        if ((i & 16) != 0) {
            str = dateRangePickerDialogProps.confirmButtonLabel;
        }
        if ((i & 32) != 0) {
            str2 = dateRangePickerDialogProps.dismissButtonLabel;
        }
        if ((i & 64) != 0) {
            color = dateRangePickerDialogProps.color;
        }
        if ((i & 128) != 0) {
            dateTimePickerColorOverrides = dateRangePickerDialogProps.elementColors;
        }
        if ((i & 256) != 0) {
            selectableDatesRecord = dateRangePickerDialogProps.selectableDates;
        }
        DateTimePickerColorOverrides dateTimePickerColorOverrides2 = dateTimePickerColorOverrides;
        SelectableDatesRecord selectableDatesRecord2 = selectableDatesRecord;
        String str3 = str2;
        Color color2 = color;
        String str4 = str;
        Variant variant2 = variant;
        return dateRangePickerDialogProps.copy(l, l2, variant2, z, str4, str3, color2, dateTimePickerColorOverrides2, selectableDatesRecord2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getInitialStartDate() {
        return this.initialStartDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getInitialEndDate() {
        return this.initialEndDate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Variant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowVariantToggle() {
        return this.showVariantToggle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getConfirmButtonLabel() {
        return this.confirmButtonLabel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDismissButtonLabel() {
        return this.dismissButtonLabel;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DateTimePickerColorOverrides getElementColors() {
        return this.elementColors;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final SelectableDatesRecord getSelectableDates() {
        return this.selectableDates;
    }

    public final DateRangePickerDialogProps copy(Long initialStartDate, Long initialEndDate, Variant variant, boolean showVariantToggle, String confirmButtonLabel, String dismissButtonLabel, Color color, DateTimePickerColorOverrides elementColors, SelectableDatesRecord selectableDates) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        return new DateRangePickerDialogProps(initialStartDate, initialEndDate, variant, showVariantToggle, confirmButtonLabel, dismissButtonLabel, color, elementColors, selectableDates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateRangePickerDialogProps)) {
            return false;
        }
        DateRangePickerDialogProps dateRangePickerDialogProps = (DateRangePickerDialogProps) other;
        return Intrinsics.areEqual(this.initialStartDate, dateRangePickerDialogProps.initialStartDate) && Intrinsics.areEqual(this.initialEndDate, dateRangePickerDialogProps.initialEndDate) && this.variant == dateRangePickerDialogProps.variant && this.showVariantToggle == dateRangePickerDialogProps.showVariantToggle && Intrinsics.areEqual(this.confirmButtonLabel, dateRangePickerDialogProps.confirmButtonLabel) && Intrinsics.areEqual(this.dismissButtonLabel, dateRangePickerDialogProps.dismissButtonLabel) && Intrinsics.areEqual(this.color, dateRangePickerDialogProps.color) && Intrinsics.areEqual(this.elementColors, dateRangePickerDialogProps.elementColors) && Intrinsics.areEqual(this.selectableDates, dateRangePickerDialogProps.selectableDates);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Long l = this.initialStartDate;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.initialEndDate;
        int iHashCode2 = (((((iHashCode + (l2 == null ? 0 : l2.hashCode())) * 31) + this.variant.hashCode()) * 31) + Boolean.hashCode(this.showVariantToggle)) * 31;
        String str = this.confirmButtonLabel;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.dismissButtonLabel;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Color color = this.color;
        int iHashCode5 = (((iHashCode4 + (color == null ? 0 : color.hashCode())) * 31) + this.elementColors.hashCode()) * 31;
        SelectableDatesRecord selectableDatesRecord = this.selectableDates;
        return iHashCode5 + (selectableDatesRecord != null ? selectableDatesRecord.hashCode() : 0);
    }

    public String toString() {
        return "DateRangePickerDialogProps(initialStartDate=" + this.initialStartDate + ", initialEndDate=" + this.initialEndDate + ", variant=" + this.variant + ", showVariantToggle=" + this.showVariantToggle + ", confirmButtonLabel=" + this.confirmButtonLabel + ", dismissButtonLabel=" + this.dismissButtonLabel + ", color=" + this.color + ", elementColors=" + this.elementColors + ", selectableDates=" + this.selectableDates + ")";
    }

    public DateRangePickerDialogProps(Long l, Long l2, Variant variant, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides elementColors, SelectableDatesRecord selectableDatesRecord) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        this.initialStartDate = l;
        this.initialEndDate = l2;
        this.variant = variant;
        this.showVariantToggle = z;
        this.confirmButtonLabel = str;
        this.dismissButtonLabel = str2;
        this.color = color;
        this.elementColors = elementColors;
        this.selectableDates = selectableDatesRecord;
    }

    public final Long getInitialStartDate() {
        return this.initialStartDate;
    }

    public final Long getInitialEndDate() {
        return this.initialEndDate;
    }

    public /* synthetic */ DateRangePickerDialogProps(Long l, Long l2, Variant variant, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, SelectableDatesRecord selectableDatesRecord, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? Variant.PICKER : variant, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : color, (i & 128) != 0 ? new DateTimePickerColorOverrides() : dateTimePickerColorOverrides, (i & 256) != 0 ? null : selectableDatesRecord);
    }

    public final Variant getVariant() {
        return this.variant;
    }

    public final boolean getShowVariantToggle() {
        return this.showVariantToggle;
    }

    public final String getConfirmButtonLabel() {
        return this.confirmButtonLabel;
    }

    public final String getDismissButtonLabel() {
        return this.dismissButtonLabel;
    }

    public final Color getColor() {
        return this.color;
    }

    public final DateTimePickerColorOverrides getElementColors() {
        return this.elementColors;
    }

    public final SelectableDatesRecord getSelectableDates() {
        return this.selectableDates;
    }
}
