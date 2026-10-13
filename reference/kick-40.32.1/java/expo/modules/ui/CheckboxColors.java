package expo.modules.ui;

import android.graphics.Color;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.OptimizedRecord;
import io.github.expo.pika.PAnnotation;
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

/* JADX INFO: compiled from: CheckboxView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003JQ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f¨\u0006,"}, d2 = {"Lexpo/modules/ui/CheckboxColors;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "checkedColor", "Landroid/graphics/Color;", "disabledCheckedColor", "uncheckedColor", "disabledUncheckedColor", "checkmarkColor", "disabledIndeterminateColor", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;)V", "getCheckedColor$annotations", "()V", "getCheckedColor", "()Landroid/graphics/Color;", "getDisabledCheckedColor$annotations", "getDisabledCheckedColor", "getUncheckedColor$annotations", "getUncheckedColor", "getDisabledUncheckedColor$annotations", "getDisabledUncheckedColor", "getCheckmarkColor$annotations", "getCheckmarkColor", "getDisabledIndeterminateColor$annotations", "getDisabledIndeterminateColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CheckboxColors implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color checkedColor;
    public Color checkmarkColor;
    public Color disabledCheckedColor;
    public Color disabledIndeterminateColor;
    public Color disabledUncheckedColor;
    public Color uncheckedColor;

    /* JADX INFO: compiled from: CheckboxView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/CheckboxColors$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<CheckboxColors> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(CheckboxColors.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("checkedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("disabledCheckedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("uncheckedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("disabledUncheckedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("checkmarkColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("disabledIndeterminateColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                return ((CheckboxColors) obj).getCheckedColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                return ((CheckboxColors) obj).getDisabledCheckedColor();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                return ((CheckboxColors) obj).getUncheckedColor();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                return ((CheckboxColors) obj).getDisabledUncheckedColor();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                return ((CheckboxColors) obj).getCheckmarkColor();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
            return ((CheckboxColors) obj).getDisabledIndeterminateColor();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                ((CheckboxColors) obj).checkedColor = (Color) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                ((CheckboxColors) obj).disabledCheckedColor = (Color) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                ((CheckboxColors) obj).uncheckedColor = (Color) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                ((CheckboxColors) obj).disabledUncheckedColor = (Color) obj2;
            } else if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                ((CheckboxColors) obj).checkmarkColor = (Color) obj2;
            } else {
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CheckboxColors");
                ((CheckboxColors) obj).disabledIndeterminateColor = (Color) obj2;
            }
        }
    }

    public CheckboxColors() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ CheckboxColors copy$default(CheckboxColors checkboxColors, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, int i, Object obj) {
        if ((i & 1) != 0) {
            color = checkboxColors.checkedColor;
        }
        if ((i & 2) != 0) {
            color2 = checkboxColors.disabledCheckedColor;
        }
        if ((i & 4) != 0) {
            color3 = checkboxColors.uncheckedColor;
        }
        if ((i & 8) != 0) {
            color4 = checkboxColors.disabledUncheckedColor;
        }
        if ((i & 16) != 0) {
            color5 = checkboxColors.checkmarkColor;
        }
        if ((i & 32) != 0) {
            color6 = checkboxColors.disabledIndeterminateColor;
        }
        Color color7 = color5;
        Color color8 = color6;
        return checkboxColors.copy(color, color2, color3, color4, color7, color8);
    }

    @Field
    public static /* synthetic */ void getCheckedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getCheckmarkColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledCheckedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledIndeterminateColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledUncheckedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUncheckedColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getCheckedColor() {
        return this.checkedColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getDisabledCheckedColor() {
        return this.disabledCheckedColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getUncheckedColor() {
        return this.uncheckedColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getDisabledUncheckedColor() {
        return this.disabledUncheckedColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getCheckmarkColor() {
        return this.checkmarkColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getDisabledIndeterminateColor() {
        return this.disabledIndeterminateColor;
    }

    public final CheckboxColors copy(Color checkedColor, Color disabledCheckedColor, Color uncheckedColor, Color disabledUncheckedColor, Color checkmarkColor, Color disabledIndeterminateColor) {
        return new CheckboxColors(checkedColor, disabledCheckedColor, uncheckedColor, disabledUncheckedColor, checkmarkColor, disabledIndeterminateColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckboxColors)) {
            return false;
        }
        CheckboxColors checkboxColors = (CheckboxColors) other;
        return Intrinsics.areEqual(this.checkedColor, checkboxColors.checkedColor) && Intrinsics.areEqual(this.disabledCheckedColor, checkboxColors.disabledCheckedColor) && Intrinsics.areEqual(this.uncheckedColor, checkboxColors.uncheckedColor) && Intrinsics.areEqual(this.disabledUncheckedColor, checkboxColors.disabledUncheckedColor) && Intrinsics.areEqual(this.checkmarkColor, checkboxColors.checkmarkColor) && Intrinsics.areEqual(this.disabledIndeterminateColor, checkboxColors.disabledIndeterminateColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.checkedColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.disabledCheckedColor;
        int iHashCode2 = (iHashCode + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.uncheckedColor;
        int iHashCode3 = (iHashCode2 + (color3 == null ? 0 : color3.hashCode())) * 31;
        Color color4 = this.disabledUncheckedColor;
        int iHashCode4 = (iHashCode3 + (color4 == null ? 0 : color4.hashCode())) * 31;
        Color color5 = this.checkmarkColor;
        int iHashCode5 = (iHashCode4 + (color5 == null ? 0 : color5.hashCode())) * 31;
        Color color6 = this.disabledIndeterminateColor;
        return iHashCode5 + (color6 != null ? color6.hashCode() : 0);
    }

    public String toString() {
        return "CheckboxColors(checkedColor=" + this.checkedColor + ", disabledCheckedColor=" + this.disabledCheckedColor + ", uncheckedColor=" + this.uncheckedColor + ", disabledUncheckedColor=" + this.disabledUncheckedColor + ", checkmarkColor=" + this.checkmarkColor + ", disabledIndeterminateColor=" + this.disabledIndeterminateColor + ")";
    }

    public CheckboxColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6) {
        this.checkedColor = color;
        this.disabledCheckedColor = color2;
        this.uncheckedColor = color3;
        this.disabledUncheckedColor = color4;
        this.checkmarkColor = color5;
        this.disabledIndeterminateColor = color6;
    }

    public /* synthetic */ CheckboxColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? null : color3, (i & 8) != 0 ? null : color4, (i & 16) != 0 ? null : color5, (i & 32) != 0 ? null : color6);
    }

    public final Color getCheckedColor() {
        return this.checkedColor;
    }

    public final Color getDisabledCheckedColor() {
        return this.disabledCheckedColor;
    }

    public final Color getUncheckedColor() {
        return this.uncheckedColor;
    }

    public final Color getDisabledUncheckedColor() {
        return this.disabledUncheckedColor;
    }

    public final Color getCheckmarkColor() {
        return this.checkmarkColor;
    }

    public final Color getDisabledIndeterminateColor() {
        return this.disabledIndeterminateColor;
    }
}
