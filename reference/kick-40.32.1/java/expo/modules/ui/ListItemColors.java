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

/* JADX INFO: compiled from: ListItemView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003JQ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\f\u0010%\u001a\u0006\u0012\u0002\b\u00030&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f¨\u0006,"}, d2 = {"Lexpo/modules/ui/ListItemColors;", "Lexpo/modules/kotlin/records/Record;", "Lio/github/expo/pika/PIntrospectionProvider;", "containerColor", "Landroid/graphics/Color;", "contentColor", "leadingContentColor", "trailingContentColor", "supportingContentColor", "overlineContentColor", "<init>", "(Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;Landroid/graphics/Color;)V", "getContainerColor$annotations", "()V", "getContainerColor", "()Landroid/graphics/Color;", "getContentColor$annotations", "getContentColor", "getLeadingContentColor$annotations", "getLeadingContentColor", "getTrailingContentColor$annotations", "getTrailingContentColor", "getSupportingContentColor$annotations", "getSupportingContentColor", "getOverlineContentColor$annotations", "getOverlineContentColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ListItemColors implements Record, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color containerColor;
    public Color contentColor;
    public Color leadingContentColor;
    public Color overlineContentColor;
    public Color supportingContentColor;
    public Color trailingContentColor;

    /* JADX INFO: compiled from: ListItemView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ListItemColors$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ListItemColors> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ListItemColors.class, new PAnnotation[]{new PAnnotation(OptimizedRecord.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("containerColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 0, __pika, false, true, false), new PProperty("contentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("leadingContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("trailingContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 3, __pika, false, true, false), new PProperty("supportingContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 4, __pika, false, true, false), new PProperty("overlineContentColor", PVisibility.PUBLIC, new PAnnotation[]{new PAnnotation(Field.class, MapsKt.emptyMap())}, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                return ((ListItemColors) obj).getContainerColor();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                return ((ListItemColors) obj).getContentColor();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                return ((ListItemColors) obj).getLeadingContentColor();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                return ((ListItemColors) obj).getTrailingContentColor();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                return ((ListItemColors) obj).getSupportingContentColor();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
            return ((ListItemColors) obj).getOverlineContentColor();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                ((ListItemColors) obj).containerColor = (Color) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                ((ListItemColors) obj).contentColor = (Color) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                ((ListItemColors) obj).leadingContentColor = (Color) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                ((ListItemColors) obj).trailingContentColor = (Color) obj2;
            } else if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                ((ListItemColors) obj).supportingContentColor = (Color) obj2;
            } else {
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ListItemColors");
                ((ListItemColors) obj).overlineContentColor = (Color) obj2;
            }
        }
    }

    public ListItemColors() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ ListItemColors copy$default(ListItemColors listItemColors, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, int i, Object obj) {
        if ((i & 1) != 0) {
            color = listItemColors.containerColor;
        }
        if ((i & 2) != 0) {
            color2 = listItemColors.contentColor;
        }
        if ((i & 4) != 0) {
            color3 = listItemColors.leadingContentColor;
        }
        if ((i & 8) != 0) {
            color4 = listItemColors.trailingContentColor;
        }
        if ((i & 16) != 0) {
            color5 = listItemColors.supportingContentColor;
        }
        if ((i & 32) != 0) {
            color6 = listItemColors.overlineContentColor;
        }
        Color color7 = color5;
        Color color8 = color6;
        return listItemColors.copy(color, color2, color3, color4, color7, color8);
    }

    @Field
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getLeadingContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getOverlineContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getSupportingContentColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getTrailingContentColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getLeadingContentColor() {
        return this.leadingContentColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Color getTrailingContentColor() {
        return this.trailingContentColor;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Color getSupportingContentColor() {
        return this.supportingContentColor;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Color getOverlineContentColor() {
        return this.overlineContentColor;
    }

    public final ListItemColors copy(Color containerColor, Color contentColor, Color leadingContentColor, Color trailingContentColor, Color supportingContentColor, Color overlineContentColor) {
        return new ListItemColors(containerColor, contentColor, leadingContentColor, trailingContentColor, supportingContentColor, overlineContentColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListItemColors)) {
            return false;
        }
        ListItemColors listItemColors = (ListItemColors) other;
        return Intrinsics.areEqual(this.containerColor, listItemColors.containerColor) && Intrinsics.areEqual(this.contentColor, listItemColors.contentColor) && Intrinsics.areEqual(this.leadingContentColor, listItemColors.leadingContentColor) && Intrinsics.areEqual(this.trailingContentColor, listItemColors.trailingContentColor) && Intrinsics.areEqual(this.supportingContentColor, listItemColors.supportingContentColor) && Intrinsics.areEqual(this.overlineContentColor, listItemColors.overlineContentColor);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Color color = this.containerColor;
        int iHashCode = (color == null ? 0 : color.hashCode()) * 31;
        Color color2 = this.contentColor;
        int iHashCode2 = (iHashCode + (color2 == null ? 0 : color2.hashCode())) * 31;
        Color color3 = this.leadingContentColor;
        int iHashCode3 = (iHashCode2 + (color3 == null ? 0 : color3.hashCode())) * 31;
        Color color4 = this.trailingContentColor;
        int iHashCode4 = (iHashCode3 + (color4 == null ? 0 : color4.hashCode())) * 31;
        Color color5 = this.supportingContentColor;
        int iHashCode5 = (iHashCode4 + (color5 == null ? 0 : color5.hashCode())) * 31;
        Color color6 = this.overlineContentColor;
        return iHashCode5 + (color6 != null ? color6.hashCode() : 0);
    }

    public String toString() {
        return "ListItemColors(containerColor=" + this.containerColor + ", contentColor=" + this.contentColor + ", leadingContentColor=" + this.leadingContentColor + ", trailingContentColor=" + this.trailingContentColor + ", supportingContentColor=" + this.supportingContentColor + ", overlineContentColor=" + this.overlineContentColor + ")";
    }

    public ListItemColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6) {
        this.containerColor = color;
        this.contentColor = color2;
        this.leadingContentColor = color3;
        this.trailingContentColor = color4;
        this.supportingContentColor = color5;
        this.overlineContentColor = color6;
    }

    public /* synthetic */ ListItemColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : color, (i & 2) != 0 ? null : color2, (i & 4) != 0 ? null : color3, (i & 8) != 0 ? null : color4, (i & 16) != 0 ? null : color5, (i & 32) != 0 ? null : color6);
    }

    public final Color getContainerColor() {
        return this.containerColor;
    }

    public final Color getContentColor() {
        return this.contentColor;
    }

    public final Color getLeadingContentColor() {
        return this.leadingContentColor;
    }

    public final Color getTrailingContentColor() {
        return this.trailingContentColor;
    }

    public final Color getSupportingContentColor() {
        return this.supportingContentColor;
    }

    public final Color getOverlineContentColor() {
        return this.overlineContentColor;
    }
}
