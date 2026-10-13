package expo.modules.ui;

import com.datadog.android.core.internal.metrics.BatchMetricsDispatcher;
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

/* JADX INFO: compiled from: VerticalSliderView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001=B\u0089\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\"\b\u0002\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\fHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J#\u00103\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016HÆ\u0003J\u0090\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\"\b\u0002\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\f2\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\f\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0016J\t\u0010;\u001a\u00020\nHÖ\u0001J\t\u0010<\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R+\u0010\u0010\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u0002`\u00150\u0011j\u0002`\u0016¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006>"}, d2 = {"Lexpo/modules/ui/VerticalSliderProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "value", "", BatchMetricsDispatcher.UPLOADER_DELAY_MIN_KEY, BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, "lowerLimit", "upperLimit", "steps", "", "enabled", "", "reverseDirection", "colors", "Lexpo/modules/ui/SliderColors;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(FFFLjava/lang/Float;Ljava/lang/Float;IZZLexpo/modules/ui/SliderColors;Ljava/util/List;)V", "getValue", "()F", "getMin", "getMax", "getLowerLimit", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getUpperLimit", "getSteps", "()I", "getEnabled", "()Z", "getReverseDirection", "getColors", "()Lexpo/modules/ui/SliderColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(FFFLjava/lang/Float;Ljava/lang/Float;IZZLexpo/modules/ui/SliderColors;Ljava/util/List;)Lexpo/modules/ui/VerticalSliderProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VerticalSliderProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public SliderColors colors;
    public boolean enabled;
    public Float lowerLimit;
    public float max;
    public float min;
    public List<Map<String, Dynamic>> modifiers;
    public boolean reverseDirection;
    public int steps;
    public Float upperLimit;
    public float value;

    /* JADX INFO: compiled from: VerticalSliderView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/VerticalSliderProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<VerticalSliderProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(VerticalSliderProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("value", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT, 0, __pika, false, true, false), new PProperty(BatchMetricsDispatcher.UPLOADER_DELAY_MIN_KEY, PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT, 1, __pika, false, true, false), new PProperty(BatchMetricsDispatcher.UPLOADER_DELAY_MAX_KEY, PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT, 2, __pika, false, true, false), new PProperty("lowerLimit", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("upperLimit", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 4, __pika, false, true, false), new PProperty("steps", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.INT, 5, __pika, false, true, false), new PProperty("enabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 6, __pika, false, true, false), new PProperty("reverseDirection", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 7, __pika, false, true, false), new PProperty("colors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(SliderColors.class, false, SliderColors.__Pika.__pika$IntrospectionData), 8, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 9, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("component9", PVisibility.PUBLIC), new PFunction("component10", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return Float.valueOf(((VerticalSliderProps) obj).getValue());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return Float.valueOf(((VerticalSliderProps) obj).getMin());
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return Float.valueOf(((VerticalSliderProps) obj).getMax());
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return ((VerticalSliderProps) obj).getLowerLimit();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return ((VerticalSliderProps) obj).getUpperLimit();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return Integer.valueOf(((VerticalSliderProps) obj).getSteps());
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return Boolean.valueOf(((VerticalSliderProps) obj).getEnabled());
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return Boolean.valueOf(((VerticalSliderProps) obj).getReverseDirection());
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return ((VerticalSliderProps) obj).getColors();
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    return ((VerticalSliderProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((VerticalSliderProps) obj).value = ((Float) obj2).floatValue();
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((VerticalSliderProps) obj).min = ((Float) obj2).floatValue();
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((VerticalSliderProps) obj).max = ((Float) obj2).floatValue();
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    ((VerticalSliderProps) obj).lowerLimit = (Float) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    ((VerticalSliderProps) obj).upperLimit = (Float) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                    ((VerticalSliderProps) obj).steps = ((Integer) obj2).intValue();
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((VerticalSliderProps) obj).enabled = ((Boolean) obj2).booleanValue();
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    ((VerticalSliderProps) obj).reverseDirection = ((Boolean) obj2).booleanValue();
                    return;
                case 8:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.SliderColors");
                    ((VerticalSliderProps) obj).colors = (SliderColors) obj2;
                    return;
                case 9:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.VerticalSliderProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((VerticalSliderProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public VerticalSliderProps() {
        this(0.0f, 0.0f, 0.0f, null, null, 0, false, false, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerticalSliderProps copy$default(VerticalSliderProps verticalSliderProps, float f, float f2, float f3, Float f4, Float f5, int i, boolean z, boolean z2, SliderColors sliderColors, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = verticalSliderProps.value;
        }
        if ((i2 & 2) != 0) {
            f2 = verticalSliderProps.min;
        }
        if ((i2 & 4) != 0) {
            f3 = verticalSliderProps.max;
        }
        if ((i2 & 8) != 0) {
            f4 = verticalSliderProps.lowerLimit;
        }
        if ((i2 & 16) != 0) {
            f5 = verticalSliderProps.upperLimit;
        }
        if ((i2 & 32) != 0) {
            i = verticalSliderProps.steps;
        }
        if ((i2 & 64) != 0) {
            z = verticalSliderProps.enabled;
        }
        if ((i2 & 128) != 0) {
            z2 = verticalSliderProps.reverseDirection;
        }
        if ((i2 & 256) != 0) {
            sliderColors = verticalSliderProps.colors;
        }
        if ((i2 & 512) != 0) {
            list = verticalSliderProps.modifiers;
        }
        SliderColors sliderColors2 = sliderColors;
        List list2 = list;
        boolean z3 = z;
        boolean z4 = z2;
        Float f6 = f5;
        int i3 = i;
        return verticalSliderProps.copy(f, f2, f3, f4, f6, i3, z3, z4, sliderColors2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getValue() {
        return this.value;
    }

    public final List<Map<String, Dynamic>> component10() {
        return this.modifiers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getMin() {
        return this.min;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getMax() {
        return this.max;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getLowerLimit() {
        return this.lowerLimit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getUpperLimit() {
        return this.upperLimit;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSteps() {
        return this.steps;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final SliderColors getColors() {
        return this.colors;
    }

    public final VerticalSliderProps copy(float value, float min, float max, Float lowerLimit, Float upperLimit, int steps, boolean enabled, boolean reverseDirection, SliderColors colors, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new VerticalSliderProps(value, min, max, lowerLimit, upperLimit, steps, enabled, reverseDirection, colors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerticalSliderProps)) {
            return false;
        }
        VerticalSliderProps verticalSliderProps = (VerticalSliderProps) other;
        return Float.compare(this.value, verticalSliderProps.value) == 0 && Float.compare(this.min, verticalSliderProps.min) == 0 && Float.compare(this.max, verticalSliderProps.max) == 0 && Intrinsics.areEqual((Object) this.lowerLimit, (Object) verticalSliderProps.lowerLimit) && Intrinsics.areEqual((Object) this.upperLimit, (Object) verticalSliderProps.upperLimit) && this.steps == verticalSliderProps.steps && this.enabled == verticalSliderProps.enabled && this.reverseDirection == verticalSliderProps.reverseDirection && Intrinsics.areEqual(this.colors, verticalSliderProps.colors) && Intrinsics.areEqual(this.modifiers, verticalSliderProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((((Float.hashCode(this.value) * 31) + Float.hashCode(this.min)) * 31) + Float.hashCode(this.max)) * 31;
        Float f = this.lowerLimit;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.upperLimit;
        return ((((((((((iHashCode2 + (f2 != null ? f2.hashCode() : 0)) * 31) + Integer.hashCode(this.steps)) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.reverseDirection)) * 31) + this.colors.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "VerticalSliderProps(value=" + this.value + ", min=" + this.min + ", max=" + this.max + ", lowerLimit=" + this.lowerLimit + ", upperLimit=" + this.upperLimit + ", steps=" + this.steps + ", enabled=" + this.enabled + ", reverseDirection=" + this.reverseDirection + ", colors=" + this.colors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VerticalSliderProps(float f, float f2, float f3, Float f4, Float f5, int i, boolean z, boolean z2, SliderColors colors, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.value = f;
        this.min = f2;
        this.max = f3;
        this.lowerLimit = f4;
        this.upperLimit = f5;
        this.steps = i;
        this.enabled = z;
        this.reverseDirection = z2;
        this.colors = colors;
        this.modifiers = modifiers;
    }

    public final float getValue() {
        return this.value;
    }

    public final float getMin() {
        return this.min;
    }

    public final float getMax() {
        return this.max;
    }

    public final Float getLowerLimit() {
        return this.lowerLimit;
    }

    public final Float getUpperLimit() {
        return this.upperLimit;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public /* synthetic */ VerticalSliderProps(float f, float f2, float f3, Float f4, Float f5, int i, boolean z, boolean z2, SliderColors sliderColors, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0.0f : f, (i2 & 2) != 0 ? 0.0f : f2, (i2 & 4) != 0 ? 1.0f : f3, (i2 & 8) != 0 ? null : f4, (i2 & 16) != 0 ? null : f5, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? true : z, (i2 & 128) != 0 ? false : z2, (i2 & 256) != 0 ? new SliderColors() : sliderColors, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final SliderColors getColors() {
        return this.colors;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
