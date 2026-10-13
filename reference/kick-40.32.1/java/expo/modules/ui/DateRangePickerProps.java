package expo.modules.ui;

import android.graphics.Color;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import io.github.expo.pika.PAnnotation;
import io.github.expo.pika.PEmptyArrays;
import io.github.expo.pika.PFunction;
import io.github.expo.pika.PIntrospectionData;
import io.github.expo.pika.PIntrospectionProvider;
import io.github.expo.pika.PProperty;
import io.github.expo.pika.PPropertyAccessor;
import io.github.expo.pika.PTypeDescriptor;
import io.github.expo.pika.PTypeDescriptorRegistry;
import io.github.expo.pika.PVisibility;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DateRangePickerView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;By\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\"\b\u0002\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003J#\u00100\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016HÆ\u0003J\u0080\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\"\b\u0002\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\f\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0016J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R+\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lexpo/modules/ui/DateRangePickerProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "initialStartDate", "", "initialEndDate", "variant", "Lexpo/modules/ui/Variant;", "showVariantToggle", "", "color", "Landroid/graphics/Color;", "elementColors", "Lexpo/modules/ui/DateTimePickerColorOverrides;", "selectableDates", "Lexpo/modules/ui/SelectableDatesRecord;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Lexpo/modules/ui/Variant;ZLandroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;Lexpo/modules/ui/SelectableDatesRecord;Ljava/util/List;)V", "getInitialStartDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInitialEndDate", "getVariant", "()Lexpo/modules/ui/Variant;", "getShowVariantToggle", "()Z", "getColor", "()Landroid/graphics/Color;", "getElementColors", "()Lexpo/modules/ui/DateTimePickerColorOverrides;", "getSelectableDates", "()Lexpo/modules/ui/SelectableDatesRecord;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Lexpo/modules/ui/Variant;ZLandroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;Lexpo/modules/ui/SelectableDatesRecord;Ljava/util/List;)Lexpo/modules/ui/DateRangePickerProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DateRangePickerProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public DateTimePickerColorOverrides elementColors;
    public Long initialEndDate;
    public Long initialStartDate;
    public List<Map<String, Dynamic>> modifiers;
    public SelectableDatesRecord selectableDates;
    public boolean showVariantToggle;
    public Variant variant;

    /* JADX INFO: compiled from: DateRangePickerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/DateRangePickerProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DateRangePickerProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DateRangePickerProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("initialStartDate", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.LONG_NULLABLE, 0, __pika, false, true, false), new PProperty("initialEndDate", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.LONG_NULLABLE, 1, __pika, false, true, false), new PProperty("variant", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Variant.class, false, null), 2, __pika, false, true, false), new PProperty("showVariantToggle", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("elementColors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(DateTimePickerColorOverrides.class, false, DateTimePickerColorOverrides.__Pika.__pika$IntrospectionData), 5, __pika, false, true, false), new PProperty("selectableDates", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(SelectableDatesRecord.class, true, SelectableDatesRecord.__Pika.__pika$IntrospectionData), 6, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 7, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return ((DateRangePickerProps) obj).getInitialStartDate();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return ((DateRangePickerProps) obj).getInitialEndDate();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return ((DateRangePickerProps) obj).getVariant();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return Boolean.valueOf(((DateRangePickerProps) obj).getShowVariantToggle());
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return ((DateRangePickerProps) obj).getColor();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return ((DateRangePickerProps) obj).getElementColors();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return ((DateRangePickerProps) obj).getSelectableDates();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    return ((DateRangePickerProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    ((DateRangePickerProps) obj).initialStartDate = (Long) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    ((DateRangePickerProps) obj).initialEndDate = (Long) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.Variant");
                    ((DateRangePickerProps) obj).variant = (Variant) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((DateRangePickerProps) obj).showVariantToggle = ((Boolean) obj2).booleanValue();
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    ((DateRangePickerProps) obj).color = (Color) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                    ((DateRangePickerProps) obj).elementColors = (DateTimePickerColorOverrides) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    ((DateRangePickerProps) obj).selectableDates = (SelectableDatesRecord) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.DateRangePickerProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((DateRangePickerProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public DateRangePickerProps() {
        this(null, null, null, false, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DateRangePickerProps copy$default(DateRangePickerProps dateRangePickerProps, Long l, Long l2, Variant variant, boolean z, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, SelectableDatesRecord selectableDatesRecord, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = dateRangePickerProps.initialStartDate;
        }
        if ((i & 2) != 0) {
            l2 = dateRangePickerProps.initialEndDate;
        }
        if ((i & 4) != 0) {
            variant = dateRangePickerProps.variant;
        }
        if ((i & 8) != 0) {
            z = dateRangePickerProps.showVariantToggle;
        }
        if ((i & 16) != 0) {
            color = dateRangePickerProps.color;
        }
        if ((i & 32) != 0) {
            dateTimePickerColorOverrides = dateRangePickerProps.elementColors;
        }
        if ((i & 64) != 0) {
            selectableDatesRecord = dateRangePickerProps.selectableDates;
        }
        if ((i & 128) != 0) {
            list = dateRangePickerProps.modifiers;
        }
        SelectableDatesRecord selectableDatesRecord2 = selectableDatesRecord;
        List list2 = list;
        Color color2 = color;
        DateTimePickerColorOverrides dateTimePickerColorOverrides2 = dateTimePickerColorOverrides;
        return dateRangePickerProps.copy(l, l2, variant, z, color2, dateTimePickerColorOverrides2, selectableDatesRecord2, list2);
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
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DateTimePickerColorOverrides getElementColors() {
        return this.elementColors;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final SelectableDatesRecord getSelectableDates() {
        return this.selectableDates;
    }

    public final List<Map<String, Dynamic>> component8() {
        return this.modifiers;
    }

    public final DateRangePickerProps copy(Long initialStartDate, Long initialEndDate, Variant variant, boolean showVariantToggle, Color color, DateTimePickerColorOverrides elementColors, SelectableDatesRecord selectableDates, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new DateRangePickerProps(initialStartDate, initialEndDate, variant, showVariantToggle, color, elementColors, selectableDates, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DateRangePickerProps)) {
            return false;
        }
        DateRangePickerProps dateRangePickerProps = (DateRangePickerProps) other;
        return Intrinsics.areEqual(this.initialStartDate, dateRangePickerProps.initialStartDate) && Intrinsics.areEqual(this.initialEndDate, dateRangePickerProps.initialEndDate) && this.variant == dateRangePickerProps.variant && this.showVariantToggle == dateRangePickerProps.showVariantToggle && Intrinsics.areEqual(this.color, dateRangePickerProps.color) && Intrinsics.areEqual(this.elementColors, dateRangePickerProps.elementColors) && Intrinsics.areEqual(this.selectableDates, dateRangePickerProps.selectableDates) && Intrinsics.areEqual(this.modifiers, dateRangePickerProps.modifiers);
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
        Color color = this.color;
        int iHashCode3 = (((iHashCode2 + (color == null ? 0 : color.hashCode())) * 31) + this.elementColors.hashCode()) * 31;
        SelectableDatesRecord selectableDatesRecord = this.selectableDates;
        return ((iHashCode3 + (selectableDatesRecord != null ? selectableDatesRecord.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "DateRangePickerProps(initialStartDate=" + this.initialStartDate + ", initialEndDate=" + this.initialEndDate + ", variant=" + this.variant + ", showVariantToggle=" + this.showVariantToggle + ", color=" + this.color + ", elementColors=" + this.elementColors + ", selectableDates=" + this.selectableDates + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DateRangePickerProps(Long l, Long l2, Variant variant, boolean z, Color color, DateTimePickerColorOverrides elementColors, SelectableDatesRecord selectableDatesRecord, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.initialStartDate = l;
        this.initialEndDate = l2;
        this.variant = variant;
        this.showVariantToggle = z;
        this.color = color;
        this.elementColors = elementColors;
        this.selectableDates = selectableDatesRecord;
        this.modifiers = modifiers;
    }

    public final Long getInitialStartDate() {
        return this.initialStartDate;
    }

    public final Long getInitialEndDate() {
        return this.initialEndDate;
    }

    public /* synthetic */ DateRangePickerProps(Long l, Long l2, Variant variant, boolean z, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, SelectableDatesRecord selectableDatesRecord, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? Variant.PICKER : variant, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : color, (i & 32) != 0 ? new DateTimePickerColorOverrides() : dateTimePickerColorOverrides, (i & 64) != 0 ? null : selectableDatesRecord, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Variant getVariant() {
        return this.variant;
    }

    public final boolean getShowVariantToggle() {
        return this.showVariantToggle;
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

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
