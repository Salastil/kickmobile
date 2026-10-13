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

/* JADX INFO: compiled from: ProgressView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00012Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\"\b\u0002\u0010\f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00100\rj\u0002`\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015J#\u0010&\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00100\rj\u0002`\u0011HÆ\u0003Jz\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\"\b\u0002\u0010\f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00100\rj\u0002`\u0011HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\f\u0010-\u001a\u0006\u0012\u0002\b\u00030.H\u0016J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015R+\u0010\f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u00100\rj\u0002`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00063"}, d2 = {"Lexpo/modules/ui/CircularProgressIndicatorProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "progress", "", "color", "Landroid/graphics/Color;", "trackColor", "strokeWidth", "strokeCap", "", "gapSize", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/Float;Landroid/graphics/Color;Landroid/graphics/Color;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;)V", "getProgress", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getColor", "()Landroid/graphics/Color;", "getTrackColor", "getStrokeWidth", "getStrokeCap", "()Ljava/lang/String;", "getGapSize", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Float;Landroid/graphics/Color;Landroid/graphics/Color;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;Ljava/util/List;)Lexpo/modules/ui/CircularProgressIndicatorProps;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class CircularProgressIndicatorProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public Float gapSize;
    public List<Map<String, Dynamic>> modifiers;
    public Float progress;
    public String strokeCap;
    public Float strokeWidth;
    public Color trackColor;

    /* JADX INFO: compiled from: ProgressView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/CircularProgressIndicatorProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<CircularProgressIndicatorProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(CircularProgressIndicatorProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("progress", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 0, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("trackColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("strokeWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("strokeCap", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 4, __pika, false, true, false), new PProperty("gapSize", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 5, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    return ((CircularProgressIndicatorProps) obj).getProgress();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    return ((CircularProgressIndicatorProps) obj).getColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    return ((CircularProgressIndicatorProps) obj).getTrackColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    return ((CircularProgressIndicatorProps) obj).getStrokeWidth();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    return ((CircularProgressIndicatorProps) obj).getStrokeCap();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    return ((CircularProgressIndicatorProps) obj).getGapSize();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    return ((CircularProgressIndicatorProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    ((CircularProgressIndicatorProps) obj).progress = (Float) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    ((CircularProgressIndicatorProps) obj).color = (Color) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    ((CircularProgressIndicatorProps) obj).trackColor = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    ((CircularProgressIndicatorProps) obj).strokeWidth = (Float) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    ((CircularProgressIndicatorProps) obj).strokeCap = (String) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    ((CircularProgressIndicatorProps) obj).gapSize = (Float) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.CircularProgressIndicatorProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((CircularProgressIndicatorProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public CircularProgressIndicatorProps() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CircularProgressIndicatorProps copy$default(CircularProgressIndicatorProps circularProgressIndicatorProps, Float f, Color color, Color color2, Float f2, String str, Float f3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = circularProgressIndicatorProps.progress;
        }
        if ((i & 2) != 0) {
            color = circularProgressIndicatorProps.color;
        }
        if ((i & 4) != 0) {
            color2 = circularProgressIndicatorProps.trackColor;
        }
        if ((i & 8) != 0) {
            f2 = circularProgressIndicatorProps.strokeWidth;
        }
        if ((i & 16) != 0) {
            str = circularProgressIndicatorProps.strokeCap;
        }
        if ((i & 32) != 0) {
            f3 = circularProgressIndicatorProps.gapSize;
        }
        if ((i & 64) != 0) {
            list = circularProgressIndicatorProps.modifiers;
        }
        Float f4 = f3;
        List list2 = list;
        String str2 = str;
        Color color3 = color2;
        return circularProgressIndicatorProps.copy(f, color, color3, f2, str2, f4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Float getProgress() {
        return this.progress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getTrackColor() {
        return this.trackColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStrokeCap() {
        return this.strokeCap;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getGapSize() {
        return this.gapSize;
    }

    public final List<Map<String, Dynamic>> component7() {
        return this.modifiers;
    }

    public final CircularProgressIndicatorProps copy(Float progress, Color color, Color trackColor, Float strokeWidth, String strokeCap, Float gapSize, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new CircularProgressIndicatorProps(progress, color, trackColor, strokeWidth, strokeCap, gapSize, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CircularProgressIndicatorProps)) {
            return false;
        }
        CircularProgressIndicatorProps circularProgressIndicatorProps = (CircularProgressIndicatorProps) other;
        return Intrinsics.areEqual((Object) this.progress, (Object) circularProgressIndicatorProps.progress) && Intrinsics.areEqual(this.color, circularProgressIndicatorProps.color) && Intrinsics.areEqual(this.trackColor, circularProgressIndicatorProps.trackColor) && Intrinsics.areEqual((Object) this.strokeWidth, (Object) circularProgressIndicatorProps.strokeWidth) && Intrinsics.areEqual(this.strokeCap, circularProgressIndicatorProps.strokeCap) && Intrinsics.areEqual((Object) this.gapSize, (Object) circularProgressIndicatorProps.gapSize) && Intrinsics.areEqual(this.modifiers, circularProgressIndicatorProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Float f = this.progress;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Color color = this.color;
        int iHashCode2 = (iHashCode + (color == null ? 0 : color.hashCode())) * 31;
        Color color2 = this.trackColor;
        int iHashCode3 = (iHashCode2 + (color2 == null ? 0 : color2.hashCode())) * 31;
        Float f2 = this.strokeWidth;
        int iHashCode4 = (iHashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str = this.strokeCap;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        Float f3 = this.gapSize;
        return ((iHashCode5 + (f3 != null ? f3.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "CircularProgressIndicatorProps(progress=" + this.progress + ", color=" + this.color + ", trackColor=" + this.trackColor + ", strokeWidth=" + this.strokeWidth + ", strokeCap=" + this.strokeCap + ", gapSize=" + this.gapSize + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularProgressIndicatorProps(Float f, Color color, Color color2, Float f2, String str, Float f3, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.progress = f;
        this.color = color;
        this.trackColor = color2;
        this.strokeWidth = f2;
        this.strokeCap = str;
        this.gapSize = f3;
        this.modifiers = modifiers;
    }

    public final Float getProgress() {
        return this.progress;
    }

    public final Color getColor() {
        return this.color;
    }

    public final Color getTrackColor() {
        return this.trackColor;
    }

    public final Float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final String getStrokeCap() {
        return this.strokeCap;
    }

    public final Float getGapSize() {
        return this.gapSize;
    }

    public /* synthetic */ CircularProgressIndicatorProps(Float f, Color color, Color color2, Float f2, String str, Float f3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : color, (i & 4) != 0 ? null : color2, (i & 8) != 0 ? null : f2, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : f3, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
