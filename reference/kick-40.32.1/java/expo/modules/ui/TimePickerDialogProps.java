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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+BK\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003JR\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\f\u0010&\u001a\u0006\u0012\u0002\b\u00030'H\u0016J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Lexpo/modules/ui/TimePickerDialogProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "initialDate", "", "is24Hour", "", "confirmButtonLabel", "", "dismissButtonLabel", "color", "Landroid/graphics/Color;", "elementColors", "Lexpo/modules/ui/DateTimePickerColorOverrides;", "<init>", "(Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;)V", "getInitialDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getConfirmButtonLabel", "()Ljava/lang/String;", "getDismissButtonLabel", "getColor", "()Landroid/graphics/Color;", "getElementColors", "()Lexpo/modules/ui/DateTimePickerColorOverrides;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Landroid/graphics/Color;Lexpo/modules/ui/DateTimePickerColorOverrides;)Lexpo/modules/ui/TimePickerDialogProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TimePickerDialogProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public String confirmButtonLabel;
    public String dismissButtonLabel;
    public DateTimePickerColorOverrides elementColors;
    public Long initialDate;
    public boolean is24Hour;

    /* JADX INFO: compiled from: DatePickerView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/TimePickerDialogProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TimePickerDialogProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TimePickerDialogProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("initialDate", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.LONG_NULLABLE, 0, __pika, false, true, false), new PProperty("is24Hour", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, false, true, false), new PProperty("confirmButtonLabel", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 2, __pika, false, true, false), new PProperty("dismissButtonLabel", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 3, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("elementColors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(DateTimePickerColorOverrides.class, false, DateTimePickerColorOverrides.__Pika.__pika$IntrospectionData), 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                return ((TimePickerDialogProps) obj).getInitialDate();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                return Boolean.valueOf(((TimePickerDialogProps) obj).is24Hour());
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                return ((TimePickerDialogProps) obj).getConfirmButtonLabel();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                return ((TimePickerDialogProps) obj).getDismissButtonLabel();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                return ((TimePickerDialogProps) obj).getColor();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
            return ((TimePickerDialogProps) obj).getElementColors();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                ((TimePickerDialogProps) obj).initialDate = (Long) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((TimePickerDialogProps) obj).is24Hour = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                ((TimePickerDialogProps) obj).confirmButtonLabel = (String) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                ((TimePickerDialogProps) obj).dismissButtonLabel = (String) obj2;
            } else if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                ((TimePickerDialogProps) obj).color = (Color) obj2;
            } else {
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TimePickerDialogProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.DateTimePickerColorOverrides");
                ((TimePickerDialogProps) obj).elementColors = (DateTimePickerColorOverrides) obj2;
            }
        }
    }

    public TimePickerDialogProps() {
        this(null, false, null, null, null, null, 63, null);
    }

    public static /* synthetic */ TimePickerDialogProps copy$default(TimePickerDialogProps timePickerDialogProps, Long l, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, int i, Object obj) {
        if ((i & 1) != 0) {
            l = timePickerDialogProps.initialDate;
        }
        if ((i & 2) != 0) {
            z = timePickerDialogProps.is24Hour;
        }
        if ((i & 4) != 0) {
            str = timePickerDialogProps.confirmButtonLabel;
        }
        if ((i & 8) != 0) {
            str2 = timePickerDialogProps.dismissButtonLabel;
        }
        if ((i & 16) != 0) {
            color = timePickerDialogProps.color;
        }
        if ((i & 32) != 0) {
            dateTimePickerColorOverrides = timePickerDialogProps.elementColors;
        }
        Color color2 = color;
        DateTimePickerColorOverrides dateTimePickerColorOverrides2 = dateTimePickerColorOverrides;
        return timePickerDialogProps.copy(l, z, str, str2, color2, dateTimePickerColorOverrides2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getInitialDate() {
        return this.initialDate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIs24Hour() {
        return this.is24Hour;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getConfirmButtonLabel() {
        return this.confirmButtonLabel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDismissButtonLabel() {
        return this.dismissButtonLabel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DateTimePickerColorOverrides getElementColors() {
        return this.elementColors;
    }

    public final TimePickerDialogProps copy(Long initialDate, boolean is24Hour, String confirmButtonLabel, String dismissButtonLabel, Color color, DateTimePickerColorOverrides elementColors) {
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        return new TimePickerDialogProps(initialDate, is24Hour, confirmButtonLabel, dismissButtonLabel, color, elementColors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimePickerDialogProps)) {
            return false;
        }
        TimePickerDialogProps timePickerDialogProps = (TimePickerDialogProps) other;
        return Intrinsics.areEqual(this.initialDate, timePickerDialogProps.initialDate) && this.is24Hour == timePickerDialogProps.is24Hour && Intrinsics.areEqual(this.confirmButtonLabel, timePickerDialogProps.confirmButtonLabel) && Intrinsics.areEqual(this.dismissButtonLabel, timePickerDialogProps.dismissButtonLabel) && Intrinsics.areEqual(this.color, timePickerDialogProps.color) && Intrinsics.areEqual(this.elementColors, timePickerDialogProps.elementColors);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Long l = this.initialDate;
        int iHashCode = (((l == null ? 0 : l.hashCode()) * 31) + Boolean.hashCode(this.is24Hour)) * 31;
        String str = this.confirmButtonLabel;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.dismissButtonLabel;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Color color = this.color;
        return ((iHashCode3 + (color != null ? color.hashCode() : 0)) * 31) + this.elementColors.hashCode();
    }

    public String toString() {
        return "TimePickerDialogProps(initialDate=" + this.initialDate + ", is24Hour=" + this.is24Hour + ", confirmButtonLabel=" + this.confirmButtonLabel + ", dismissButtonLabel=" + this.dismissButtonLabel + ", color=" + this.color + ", elementColors=" + this.elementColors + ")";
    }

    public TimePickerDialogProps(Long l, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides elementColors) {
        Intrinsics.checkNotNullParameter(elementColors, "elementColors");
        this.initialDate = l;
        this.is24Hour = z;
        this.confirmButtonLabel = str;
        this.dismissButtonLabel = str2;
        this.color = color;
        this.elementColors = elementColors;
    }

    public final Long getInitialDate() {
        return this.initialDate;
    }

    public final boolean is24Hour() {
        return this.is24Hour;
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

    public /* synthetic */ TimePickerDialogProps(Long l, boolean z, String str, String str2, Color color, DateTimePickerColorOverrides dateTimePickerColorOverrides, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : color, (i & 32) != 0 ? new DateTimePickerColorOverrides() : dateTimePickerColorOverrides);
    }

    public final DateTimePickerColorOverrides getElementColors() {
        return this.elementColors;
    }
}
