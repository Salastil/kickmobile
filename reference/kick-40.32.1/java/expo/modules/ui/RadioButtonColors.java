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

/* JADX INFO: compiled from: RadioButtonView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\f\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r¨\u0006$"}, d2 = {"Lexpo/modules/ui/RadioButtonColors;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "selectedColor", "Landroid/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;)V", "getSelectedColor$annotations", "()V", "getSelectedColor", "()Landroid/graphics/Color;", "getUnselectedColor$annotations", "getUnselectedColor", "getDisabledSelectedColor$annotations", "getDisabledSelectedColor", "getDisabledUnselectedColor$annotations", "getDisabledUnselectedColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RadioButtonColors implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color disabledSelectedColor;
    public Color disabledUnselectedColor;
    public Color selectedColor;
    public Color unselectedColor;

    /* JADX INFO: compiled from: RadioButtonView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/RadioButtonColors$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<RadioButtonColors> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(RadioButtonColors.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("selectedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("unselectedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("disabledSelectedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("disabledUnselectedColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
                return ((RadioButtonColors) obj).getSelectedColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
                return ((RadioButtonColors) obj).getUnselectedColor();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
                return ((RadioButtonColors) obj).getDisabledSelectedColor();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
            return ((RadioButtonColors) obj).getDisabledUnselectedColor();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
                ((RadioButtonColors) obj).selectedColor = (Color) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
                ((RadioButtonColors) obj).unselectedColor = (Color) obj2;
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
                ((RadioButtonColors) obj).disabledSelectedColor = (Color) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RadioButtonColors");
                ((RadioButtonColors) obj).disabledUnselectedColor = (Color) obj2;
            }
        }
    }

    public RadioButtonColors() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RadioButtonColors copy$default(RadioButtonColors radioButtonColors, Color color, Color color2, Color color3, Color color4, int i, Object obj) {
        if ((i & 1) != 0) {
            color = radioButtonColors.selectedColor;
        }
        if ((i & 2) != 0) {
            color2 = radioButtonColors.unselectedColor;
        }
        if ((i & 4) != 0) {
            color3 = radioButtonColors.disabledSelectedColor;
        }
        if ((i & 8) != 0) {
            color4 = radioButtonColors.disabledUnselectedColor;
        }
        return radioButtonColors.copy(color, color2, color3, color4);
    }

    @Field
    public static /* synthetic */ void getDisabledSelectedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledUnselectedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUnselectedColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getSelectedColor() {
        return this.selectedColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getUnselectedColor() {
        return this.unselectedColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getDisabledSelectedColor() {
        return this.disabledSelectedColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getDisabledUnselectedColor() {
        return this.disabledUnselectedColor;
    }

    public final RadioButtonColors copy(Color selectedColor, Color unselectedColor, Color disabledSelectedColor, Color disabledUnselectedColor) {
        return new RadioButtonColors(selectedColor, unselectedColor, disabledSelectedColor, disabledUnselectedColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadioButtonColors)) {
            return false;
        }
        RadioButtonColors radioButtonColors = (RadioButtonColors) other;
        return Intrinsics.areEqual(this.selectedColor, radioButtonColors.selectedColor) && Intrinsics.areEqual(this.unselectedColor, radioButtonColors.unselectedColor) && Intrinsics.areEqual(this.disabledSelectedColor, radioButtonColors.disabledSelectedColor) && Intrinsics.areEqual(this.disabledUnselectedColor, radioButtonColors.disabledUnselectedColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.selectedColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.unselectedColor;
        int iHashCode2 = (iHashCode + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.disabledSelectedColor;
        int iHashCode3 = (iHashCode2 + (color3 == null ? 0 : color3.hashCode())) * 31;
        Color color4 = this.disabledUnselectedColor;
        return iHashCode3 + (color4 != null ? color4.hashCode() : 0);
    }

    public String toString() {
        return "RadioButtonColors(selectedColor=" + this.selectedColor + ", unselectedColor=" + this.unselectedColor + ", disabledSelectedColor=" + this.disabledSelectedColor + ", disabledUnselectedColor=" + this.disabledUnselectedColor + ")";
    }

    public RadioButtonColors(Color color, Color color2, Color color3, Color color4) {
        this.selectedColor = color;
        this.unselectedColor = color2;
        this.disabledSelectedColor = color3;
        this.disabledUnselectedColor = color4;
    }

    public /* synthetic */ RadioButtonColors(Color color, Color color2, Color color3, Color color4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? null : color3, (i & 8) != 0 ? null : color4);
    }

    public final Color getSelectedColor() {
        return this.selectedColor;
    }

    public final Color getUnselectedColor() {
        return this.unselectedColor;
    }

    public final Color getDisabledSelectedColor() {
        return this.disabledSelectedColor;
    }

    public final Color getDisabledUnselectedColor() {
        return this.disabledUnselectedColor;
    }
}
