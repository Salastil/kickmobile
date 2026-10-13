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

/* JADX INFO: compiled from: NavigationBarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001/B[\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J]\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\f\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0016J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010¨\u00060"}, d2 = {"Lexpo/modules/ui/NavigationBarItemColors;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "selectedIconColor", "Landroid/graphics/Color;", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;)V", "getSelectedIconColor$annotations", "()V", "getSelectedIconColor", "()Landroid/graphics/Color;", "getSelectedTextColor$annotations", "getSelectedTextColor", "getSelectedIndicatorColor$annotations", "getSelectedIndicatorColor", "getUnselectedIconColor$annotations", "getUnselectedIconColor", "getUnselectedTextColor$annotations", "getUnselectedTextColor", "getDisabledIconColor$annotations", "getDisabledIconColor", "getDisabledTextColor$annotations", "getDisabledTextColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NavigationBarItemColors implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color disabledIconColor;
    public Color disabledTextColor;
    public Color selectedIconColor;
    public Color selectedIndicatorColor;
    public Color selectedTextColor;
    public Color unselectedIconColor;
    public Color unselectedTextColor;

    /* JADX INFO: compiled from: NavigationBarView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/NavigationBarItemColors$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<NavigationBarItemColors> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(NavigationBarItemColors.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("selectedIconColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("selectedTextColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("selectedIndicatorColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("unselectedIconColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("unselectedTextColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("disabledIconColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false), new PProperty("disabledTextColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    return ((NavigationBarItemColors) obj).getSelectedIconColor();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    return ((NavigationBarItemColors) obj).getSelectedTextColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    return ((NavigationBarItemColors) obj).getSelectedIndicatorColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    return ((NavigationBarItemColors) obj).getUnselectedIconColor();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    return ((NavigationBarItemColors) obj).getUnselectedTextColor();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    return ((NavigationBarItemColors) obj).getDisabledIconColor();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    return ((NavigationBarItemColors) obj).getDisabledTextColor();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    ((NavigationBarItemColors) obj).selectedIconColor = (Color) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    ((NavigationBarItemColors) obj).selectedTextColor = (Color) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    ((NavigationBarItemColors) obj).selectedIndicatorColor = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    ((NavigationBarItemColors) obj).unselectedIconColor = (Color) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    ((NavigationBarItemColors) obj).unselectedTextColor = (Color) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    ((NavigationBarItemColors) obj).disabledIconColor = (Color) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.NavigationBarItemColors");
                    ((NavigationBarItemColors) obj).disabledTextColor = (Color) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public NavigationBarItemColors() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NavigationBarItemColors copy$default(NavigationBarItemColors navigationBarItemColors, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, int i, Object obj) {
        if ((i & 1) != 0) {
            color = navigationBarItemColors.selectedIconColor;
        }
        if ((i & 2) != 0) {
            color2 = navigationBarItemColors.selectedTextColor;
        }
        if ((i & 4) != 0) {
            color3 = navigationBarItemColors.selectedIndicatorColor;
        }
        if ((i & 8) != 0) {
            color4 = navigationBarItemColors.unselectedIconColor;
        }
        if ((i & 16) != 0) {
            color5 = navigationBarItemColors.unselectedTextColor;
        }
        if ((i & 32) != 0) {
            color6 = navigationBarItemColors.disabledIconColor;
        }
        if ((i & 64) != 0) {
            color7 = navigationBarItemColors.disabledTextColor;
        }
        Color color8 = color6;
        Color color9 = color7;
        Color color10 = color5;
        Color color11 = color3;
        return navigationBarItemColors.copy(color, color2, color11, color4, color10, color8, color9);
    }

    @Field
    public static /* synthetic */ void getDisabledIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getDisabledTextColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedIndicatorColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSelectedTextColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUnselectedIconColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getUnselectedTextColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getSelectedIconColor() {
        return this.selectedIconColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getSelectedTextColor() {
        return this.selectedTextColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getUnselectedIconColor() {
        return this.unselectedIconColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getUnselectedTextColor() {
        return this.unselectedTextColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getDisabledIconColor() {
        return this.disabledIconColor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Color getDisabledTextColor() {
        return this.disabledTextColor;
    }

    public final NavigationBarItemColors copy(Color selectedIconColor, Color selectedTextColor, Color selectedIndicatorColor, Color unselectedIconColor, Color unselectedTextColor, Color disabledIconColor, Color disabledTextColor) {
        return new NavigationBarItemColors(selectedIconColor, selectedTextColor, selectedIndicatorColor, unselectedIconColor, unselectedTextColor, disabledIconColor, disabledTextColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) other;
        return Intrinsics.areEqual(this.selectedIconColor, navigationBarItemColors.selectedIconColor) && Intrinsics.areEqual(this.selectedTextColor, navigationBarItemColors.selectedTextColor) && Intrinsics.areEqual(this.selectedIndicatorColor, navigationBarItemColors.selectedIndicatorColor) && Intrinsics.areEqual(this.unselectedIconColor, navigationBarItemColors.unselectedIconColor) && Intrinsics.areEqual(this.unselectedTextColor, navigationBarItemColors.unselectedTextColor) && Intrinsics.areEqual(this.disabledIconColor, navigationBarItemColors.disabledIconColor) && Intrinsics.areEqual(this.disabledTextColor, navigationBarItemColors.disabledTextColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.selectedIconColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.selectedTextColor;
        int iHashCode2 = (iHashCode + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.selectedIndicatorColor;
        int iHashCode3 = (iHashCode2 + (color3 == null ? 0 : color3.hashCode())) * 31;
        Color color4 = this.unselectedIconColor;
        int iHashCode4 = (iHashCode3 + (color4 == null ? 0 : color4.hashCode())) * 31;
        Color color5 = this.unselectedTextColor;
        int iHashCode5 = (iHashCode4 + (color5 == null ? 0 : color5.hashCode())) * 31;
        Color color6 = this.disabledIconColor;
        int iHashCode6 = (iHashCode5 + (color6 == null ? 0 : color6.hashCode())) * 31;
        Color color7 = this.disabledTextColor;
        return iHashCode6 + (color7 != null ? color7.hashCode() : 0);
    }

    public String toString() {
        return "NavigationBarItemColors(selectedIconColor=" + this.selectedIconColor + ", selectedTextColor=" + this.selectedTextColor + ", selectedIndicatorColor=" + this.selectedIndicatorColor + ", unselectedIconColor=" + this.unselectedIconColor + ", unselectedTextColor=" + this.unselectedTextColor + ", disabledIconColor=" + this.disabledIconColor + ", disabledTextColor=" + this.disabledTextColor + ")";
    }

    public NavigationBarItemColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7) {
        this.selectedIconColor = color;
        this.selectedTextColor = color2;
        this.selectedIndicatorColor = color3;
        this.unselectedIconColor = color4;
        this.unselectedTextColor = color5;
        this.disabledIconColor = color6;
        this.disabledTextColor = color7;
    }

    public /* synthetic */ NavigationBarItemColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color color7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? null : color3, (i & 8) != 0 ? null : color4, (i & 16) != 0 ? null : color5, (i & 32) != 0 ? null : color6, (i & 64) != 0 ? null : color7);
    }

    public final Color getSelectedIconColor() {
        return this.selectedIconColor;
    }

    public final Color getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final Color getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    public final Color getUnselectedIconColor() {
        return this.unselectedIconColor;
    }

    public final Color getUnselectedTextColor() {
        return this.unselectedTextColor;
    }

    public final Color getDisabledIconColor() {
        return this.disabledIconColor;
    }

    public final Color getDisabledTextColor() {
        return this.disabledTextColor;
    }
}
