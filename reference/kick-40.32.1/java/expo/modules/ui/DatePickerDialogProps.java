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

/* JADX INFO: compiled from: DatePickerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00016Ba\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003Jh\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\f\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0016J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00067"}, d2 = {"Lexpo/modules/ui/DatePickerDialogProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "initialDate", "", "variant", "Lexpo/modules/ui/Variant;", "showVariantToggle", "", "confirmButtonLabel", "", "dismissButtonLabel", "color", "Landroid/graphics/Color;", "elementColors", "Lexpo/modules/ui/DateTimePickerColorOverrides;", "selectableDates", "Lexpo/modules/ui/SelectableDatesRecord;", "<init>", "(Ljava/lang/Long;Lexpo/modules/ui/Variant;ZLjava/lang/String;Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;Lexpo/modules/ui/SelectableDatesRecord;)V", "getInitialDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVariant", "()Lexpo/modules/ui/Variant;", "getShowVariantToggle", "()Z", "getConfirmButtonLabel", "()Ljava/lang/String;", "getDismissButtonLabel", "getColor", "()Landroid/graphics/Color;", "getElementColors", "()Lexpo/modules/ui/DateTimePickerColorOverrides;", "getSelectableDates", "()Lexpo/modules/ui/SelectableDatesRecord;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Lexpo/modules/ui/Variant;ZLjava/lang/String;Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;Lexpo/modules/ui/SelectableDatesRecord;)Lexpo/modules/ui/DatePickerDialogProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DatePickerDialogProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public String confirmButtonLabel;
    public String dismissButtonLabel;
    public DateTimePickerColorOverrides elementColors;
    public Long initialDate;
    public SelectableDatesRecord selectableDates;
    public boolean showVariantToggle;
    public Variant variant;

    /* JADX INFO: compiled from: DatePickerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/DatePickerDialogProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DatePickerDialogProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DatePickerDialogProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("initialDate", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.LONG_NULLABLE, 0, __pika, false, true, false), new PProperty("variant", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Variant.class, false, null), 1, __pika, false, true, false), new PProperty("showVariantToggle", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty("confirmButtonLabel", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 3, __pika, false, true, false), new PProperty("dismissButtonLabel", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 4, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false), new PProperty("elementColors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(DateTimePickerColorOverrides.class, false, DateTimePickerColorOverrides.__Pika.__pika$IntrospectionData), 6, __pika, false, true, false), new PProperty("selectableDates", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(SelectableDatesRecord.class, true, SelectableDatesRecord.__Pika.__pika$IntrospectionData), 7, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return ((DatePickerDialogProps) obj).getInitialDate();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return ((DatePickerDialogProps) obj).getVariant();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return Boolean.valueOf(((DatePickerDialogProps) obj).getShowVariantToggle());
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return ((DatePickerDialogProps) obj).getConfirmButtonLabel();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return ((DatePickerDialogProps) obj).getDismissButtonLabel();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return ((DatePickerDialogProps) obj).getColor();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return ((DatePickerDialogProps) obj).getElementColors();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    return ((DatePickerDialogProps) obj).getSelectableDates();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    ((DatePickerDialogProps) obj).initialDate = (Long) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.Variant");
                    ((DatePickerDialogProps) obj).variant = (Variant) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((DatePickerDialogProps) obj).showVariantToggle = ((Boolean) obj2).booleanValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    ((DatePickerDialogProps) obj).confirmButtonLabel = (String) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    ((DatePickerDialogProps) obj).dismissButtonLabel = (String) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    ((DatePickerDialogProps) obj).color = (Color) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DatePickerDialogProps) obj).elementColors = (DateTimePickerColorOverrides) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DatePickerDialogProps");
                    ((DatePickerDialogProps) obj).selectableDates = (SelectableDatesRecord) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public DatePickerDialogProps() {
        this(null, null, false, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ DatePickerDialogProps copy$default(DatePickerDialogProps datePickerDialogProps, Long l, Variant variant, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, SelectableDatesRecord selectableDatesRecord, int i, Object obj) {
        if ((i & 1) != 0) {
            l = datePickerDialogProps.initialDate;
        }
        if ((i & 2) != 0) {
            variant = datePickerDialogProps.variant;
        }
        if ((i & 4) != 0) {
            z = datePickerDialogProps.showVariantToggle;
        }
        if ((i & 8) != 0) {
            str = datePickerDialogProps.confirmButtonLabel;
        }
        if ((i & 16) != 0) {
            str2 = datePickerDialogProps.dismissButtonLabel;
        }
        if ((i & 32) != 0) {
            color = datePickerDialogProps.color;
        }
        if ((i & 64) != 0) {
            dateTimePickerColorOverrides = datePickerDialogProps.elementColors;
        }
        if ((i & 128) != 0) {
            selectableDatesRecord = datePickerDialogProps.selectableDates;
        }
        DateTimePickerColorOverrides dateTimePickerColorOverrides2 = dateTimePickerColorOverrides;
        SelectableDatesRecord selectableDatesRecord2 = selectableDatesRecord;
        String str3 = str2;
        Color color2 = color;
        return datePickerDialogProps.copy(l, variant, z, str, str3, color2, dateTimePickerColorOverrides2, selectableDatesRecord2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getInitialDate() {
        return this.initialDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Variant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getShowVariantToggle() {
        return this.showVariantToggle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getConfirmButtonLabel() {
        return this.confirmButtonLabel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDismissButtonLabel() {
        return this.dismissButtonLabel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final DateTimePickerColorOverrides getElementColors() {
        return this.elementColors;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SelectableDatesRecord getSelectableDates() {
        return this.selectableDates;
    }

    public final DatePickerDialogProps copy(Long initialDate, Variant variant, boolean showVariantToggle, String confirmButtonLabel, String dismissButtonLabel, Color color, DateTimePickerColorOverrides elementColors, SelectableDatesRecord selectableDates) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        return new DatePickerDialogProps(initialDate, variant, showVariantToggle, confirmButtonLabel, dismissButtonLabel, color, elementColors, selectableDates);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DatePickerDialogProps)) {
            return false;
        }
        DatePickerDialogProps datePickerDialogProps = (DatePickerDialogProps) other;
        return Intrinsics.areEqual(this.initialDate, datePickerDialogProps.initialDate) && this.variant == datePickerDialogProps.variant && this.showVariantToggle == datePickerDialogProps.showVariantToggle && Intrinsics.areEqual(this.confirmButtonLabel, datePickerDialogProps.confirmButtonLabel) && Intrinsics.areEqual(this.dismissButtonLabel, datePickerDialogProps.dismissButtonLabel) && Intrinsics.areEqual(this.color, datePickerDialogProps.color) && Intrinsics.areEqual(this.elementColors, datePickerDialogProps.elementColors) && Intrinsics.areEqual(this.selectableDates, datePickerDialogProps.selectableDates);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Long l = this.initialDate;
        int iHashCode = (((((l == null ? 0 : l.hashCode()) * 31) + this.variant.hashCode()) * 31) + Boolean.hashCode(this.showVariantToggle)) * 31;
        String str = this.confirmButtonLabel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.dismissButtonLabel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Color color = this.color;
        int iHashCode4 = (((iHashCode3 + (color == null ? 0 : color.hashCode())) * 31) + this.elementColors.hashCode()) * 31;
        SelectableDatesRecord selectableDatesRecord = this.selectableDates;
        return iHashCode4 + (selectableDatesRecord != null ? selectableDatesRecord.hashCode() : 0);
    }

    public String toString() {
        return "DatePickerDialogProps(initialDate=" + this.initialDate + ", variant=" + this.variant + ", showVariantToggle=" + this.showVariantToggle + ", confirmButtonLabel=" + this.confirmButtonLabel + ", dismissButtonLabel=" + this.dismissButtonLabel + ", color=" + this.color + ", elementColors=" + this.elementColors + ", selectableDates=" + this.selectableDates + ")";
    }

    public DatePickerDialogProps(Long l, Variant variant, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides elementColors, SelectableDatesRecord selectableDatesRecord) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        this.initialDate = l;
        this.variant = variant;
        this.showVariantToggle = z;
        this.confirmButtonLabel = str;
        this.dismissButtonLabel = str2;
        this.color = color;
        this.elementColors = elementColors;
        this.selectableDates = selectableDatesRecord;
    }

    public final Long getInitialDate() {
        return this.initialDate;
    }

    public /* synthetic */ DatePickerDialogProps(Long l, Variant variant, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, SelectableDatesRecord selectableDatesRecord, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? Variant.PICKER : variant, (i & 4) != 0 ? true : z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : color, (i & 64) != 0 ? new DateTimePickerColorOverrides() : dateTimePickerColorOverrides, (i & 128) != 0 ? null : selectableDatesRecord);
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
