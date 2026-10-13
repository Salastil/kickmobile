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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00014Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\"\b\u0002\u0010\r\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\fHÆ\u0003J#\u0010(\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012HÆ\u0003Jz\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\"\b\u0002\u0010\r\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\f\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0016J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\tHÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR+\u0010\r\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\u000ej\u0002`\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00065"}, d2 = {"Lexpo/modules/ui/LinearProgressIndicatorProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "progress", "", "color", "Landroid/graphics/Color;", "trackColor", "strokeCap", "", "gapSize", "drawStopIndicator", "Lexpo/modules/ui/DrawStopIndicatorConfig;", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/Float;Landroid/graphics/Color;Landroid/graphics/Color;Ljava/lang/String;Ljava/lang/Float;Lexpo/modules/ui/DrawStopIndicatorConfig;Ljava/util/List;)V", "getProgress", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getColor", "()Landroid/graphics/Color;", "getTrackColor", "getStrokeCap", "()Ljava/lang/String;", "getGapSize", "getDrawStopIndicator", "()Lexpo/modules/ui/DrawStopIndicatorConfig;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Float;Landroid/graphics/Color;Landroid/graphics/Color;Ljava/lang/String;Ljava/lang/Float;Lexpo/modules/ui/DrawStopIndicatorConfig;Ljava/util/List;)Lexpo/modules/ui/LinearProgressIndicatorProps;", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LinearProgressIndicatorProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color color;
    public DrawStopIndicatorConfig drawStopIndicator;
    public Float gapSize;
    public List<Map<String, Dynamic>> modifiers;
    public Float progress;
    public String strokeCap;
    public Color trackColor;

    /* JADX INFO: compiled from: ProgressView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/LinearProgressIndicatorProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<LinearProgressIndicatorProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(LinearProgressIndicatorProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("progress", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 0, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("trackColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("strokeCap", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.STRING_NULLABLE, 3, __pika, false, true, false), new PProperty("gapSize", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 4, __pika, false, true, false), new PProperty("drawStopIndicator", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(DrawStopIndicatorConfig.class, true, DrawStopIndicatorConfig.__Pika.__pika$IntrospectionData), 5, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    return ((LinearProgressIndicatorProps) obj).getProgress();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    return ((LinearProgressIndicatorProps) obj).getColor();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    return ((LinearProgressIndicatorProps) obj).getTrackColor();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    return ((LinearProgressIndicatorProps) obj).getStrokeCap();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    return ((LinearProgressIndicatorProps) obj).getGapSize();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    return ((LinearProgressIndicatorProps) obj).getDrawStopIndicator();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    return ((LinearProgressIndicatorProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    ((LinearProgressIndicatorProps) obj).progress = (Float) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    ((LinearProgressIndicatorProps) obj).color = (Color) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    ((LinearProgressIndicatorProps) obj).trackColor = (Color) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    ((LinearProgressIndicatorProps) obj).strokeCap = (String) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    ((LinearProgressIndicatorProps) obj).gapSize = (Float) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    ((LinearProgressIndicatorProps) obj).drawStopIndicator = (DrawStopIndicatorConfig) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LinearProgressIndicatorProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((LinearProgressIndicatorProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public LinearProgressIndicatorProps() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LinearProgressIndicatorProps copy$default(LinearProgressIndicatorProps linearProgressIndicatorProps, Float f, Color color, Color color2, String str, Float f2, DrawStopIndicatorConfig drawStopIndicatorConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = linearProgressIndicatorProps.progress;
        }
        if ((i & 2) != 0) {
            color = linearProgressIndicatorProps.color;
        }
        if ((i & 4) != 0) {
            color2 = linearProgressIndicatorProps.trackColor;
        }
        if ((i & 8) != 0) {
            str = linearProgressIndicatorProps.strokeCap;
        }
        if ((i & 16) != 0) {
            f2 = linearProgressIndicatorProps.gapSize;
        }
        if ((i & 32) != 0) {
            drawStopIndicatorConfig = linearProgressIndicatorProps.drawStopIndicator;
        }
        if ((i & 64) != 0) {
            list = linearProgressIndicatorProps.modifiers;
        }
        DrawStopIndicatorConfig drawStopIndicatorConfig2 = drawStopIndicatorConfig;
        List list2 = list;
        Float f3 = f2;
        Color color3 = color2;
        return linearProgressIndicatorProps.copy(f, color, color3, str, f3, drawStopIndicatorConfig2, list2);
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
    public final String getStrokeCap() {
        return this.strokeCap;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getGapSize() {
        return this.gapSize;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DrawStopIndicatorConfig getDrawStopIndicator() {
        return this.drawStopIndicator;
    }

    public final List<Map<String, Dynamic>> component7() {
        return this.modifiers;
    }

    public final LinearProgressIndicatorProps copy(Float progress, Color color, Color trackColor, String strokeCap, Float gapSize, DrawStopIndicatorConfig drawStopIndicator, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new LinearProgressIndicatorProps(progress, color, trackColor, strokeCap, gapSize, drawStopIndicator, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LinearProgressIndicatorProps)) {
            return false;
        }
        LinearProgressIndicatorProps linearProgressIndicatorProps = (LinearProgressIndicatorProps) other;
        return Intrinsics.areEqual((Object) this.progress, (Object) linearProgressIndicatorProps.progress) && Intrinsics.areEqual(this.color, linearProgressIndicatorProps.color) && Intrinsics.areEqual(this.trackColor, linearProgressIndicatorProps.trackColor) && Intrinsics.areEqual(this.strokeCap, linearProgressIndicatorProps.strokeCap) && Intrinsics.areEqual((Object) this.gapSize, (Object) linearProgressIndicatorProps.gapSize) && Intrinsics.areEqual(this.drawStopIndicator, linearProgressIndicatorProps.drawStopIndicator) && Intrinsics.areEqual(this.modifiers, linearProgressIndicatorProps.modifiers);
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
        String str = this.strokeCap;
        int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Float f2 = this.gapSize;
        int iHashCode5 = (iHashCode4 + (f2 == null ? 0 : f2.hashCode())) * 31;
        DrawStopIndicatorConfig drawStopIndicatorConfig = this.drawStopIndicator;
        return ((iHashCode5 + (drawStopIndicatorConfig != null ? drawStopIndicatorConfig.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "LinearProgressIndicatorProps(progress=" + this.progress + ", color=" + this.color + ", trackColor=" + this.trackColor + ", strokeCap=" + this.strokeCap + ", gapSize=" + this.gapSize + ", drawStopIndicator=" + this.drawStopIndicator + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LinearProgressIndicatorProps(Float f, Color color, Color color2, String str, Float f2, DrawStopIndicatorConfig drawStopIndicatorConfig, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.progress = f;
        this.color = color;
        this.trackColor = color2;
        this.strokeCap = str;
        this.gapSize = f2;
        this.drawStopIndicator = drawStopIndicatorConfig;
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

    public final String getStrokeCap() {
        return this.strokeCap;
    }

    public final Float getGapSize() {
        return this.gapSize;
    }

    public final DrawStopIndicatorConfig getDrawStopIndicator() {
        return this.drawStopIndicator;
    }

    public /* synthetic */ LinearProgressIndicatorProps(Float f, Color color, Color color2, String str, Float f2, DrawStopIndicatorConfig drawStopIndicatorConfig, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : color, (i & 4) != 0 ? null : color2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : f2, (i & 32) != 0 ? null : drawStopIndicatorConfig, (i & 64) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
