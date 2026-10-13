package expo.modules.ui;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.types.Either;
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

/* JADX INFO: compiled from: CarouselView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00014Bq\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\"\b\u0002\u0010\r\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J#\u0010)\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u0013HÆ\u0003Jx\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\"\b\u0002\u0010\r\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u0013HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\f\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0016J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R+\u0010\r\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00065"}, d2 = {"Lexpo/modules/ui/HorizontalUncontainedCarouselProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "itemWidth", "", "itemSpacing", "contentPadding", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/PaddingValuesRecord;", "flingBehavior", "Lexpo/modules/ui/FlingBehaviorType;", "userScrollEnabled", "", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(FLjava/lang/Float;Lexpo/modules/kotlin/types/Either;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Boolean;Ljava/util/List;)V", "getItemWidth", "()F", "getItemSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getContentPadding", "()Lexpo/modules/kotlin/types/Either;", "getFlingBehavior", "()Lexpo/modules/ui/FlingBehaviorType;", "getUserScrollEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(FLjava/lang/Float;Lexpo/modules/kotlin/types/Either;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Boolean;Ljava/util/List;)Lexpo/modules/ui/HorizontalUncontainedCarouselProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HorizontalUncontainedCarouselProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Either<Float, PaddingValuesRecord> contentPadding;
    public FlingBehaviorType flingBehavior;
    public Float itemSpacing;
    public float itemWidth;
    public List<Map<String, Dynamic>> modifiers;
    public Boolean userScrollEnabled;

    /* JADX INFO: compiled from: CarouselView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/HorizontalUncontainedCarouselProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<HorizontalUncontainedCarouselProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(HorizontalUncontainedCarouselProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("itemWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT, 0, __pika, false, true, false), new PProperty("itemSpacing", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty("contentPadding", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.FLOAT, PTypeDescriptorRegistry.getOrCreateConcrete(PaddingValuesRecord.class, false, null)}), null), 2, __pika, false, true, false), new PProperty("flingBehavior", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(FlingBehaviorType.class, true, null), 3, __pika, false, true, false), new PProperty("userScrollEnabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 4, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                return Float.valueOf(((HorizontalUncontainedCarouselProps) obj).getItemWidth());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                return ((HorizontalUncontainedCarouselProps) obj).getItemSpacing();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                return ((HorizontalUncontainedCarouselProps) obj).getContentPadding();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                return ((HorizontalUncontainedCarouselProps) obj).getFlingBehavior();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                return ((HorizontalUncontainedCarouselProps) obj).getUserScrollEnabled();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
            return ((HorizontalUncontainedCarouselProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                ((HorizontalUncontainedCarouselProps) obj).itemWidth = ((Float) obj2).floatValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                ((HorizontalUncontainedCarouselProps) obj).itemSpacing = (Float) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                ((HorizontalUncontainedCarouselProps) obj).contentPadding = (Either) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                ((HorizontalUncontainedCarouselProps) obj).flingBehavior = (FlingBehaviorType) obj2;
            } else if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                ((HorizontalUncontainedCarouselProps) obj).userScrollEnabled = (Boolean) obj2;
            } else {
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalUncontainedCarouselProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((HorizontalUncontainedCarouselProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public HorizontalUncontainedCarouselProps() {
        this(0.0f, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalUncontainedCarouselProps copy$default(HorizontalUncontainedCarouselProps horizontalUncontainedCarouselProps, float f, Float f2, Either either, FlingBehaviorType flingBehaviorType, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = horizontalUncontainedCarouselProps.itemWidth;
        }
        if ((i & 2) != 0) {
            f2 = horizontalUncontainedCarouselProps.itemSpacing;
        }
        if ((i & 4) != 0) {
            either = horizontalUncontainedCarouselProps.contentPadding;
        }
        if ((i & 8) != 0) {
            flingBehaviorType = horizontalUncontainedCarouselProps.flingBehavior;
        }
        if ((i & 16) != 0) {
            bool = horizontalUncontainedCarouselProps.userScrollEnabled;
        }
        if ((i & 32) != 0) {
            list = horizontalUncontainedCarouselProps.modifiers;
        }
        Boolean bool2 = bool;
        List list2 = list;
        return horizontalUncontainedCarouselProps.copy(f, f2, either, flingBehaviorType, bool2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getItemWidth() {
        return this.itemWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getItemSpacing() {
        return this.itemSpacing;
    }

    public final Either<Float, PaddingValuesRecord> component3() {
        return this.contentPadding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final FlingBehaviorType getFlingBehavior() {
        return this.flingBehavior;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    public final List<Map<String, Dynamic>> component6() {
        return this.modifiers;
    }

    public final HorizontalUncontainedCarouselProps copy(float itemWidth, Float itemSpacing, Either<Float, PaddingValuesRecord> contentPadding, FlingBehaviorType flingBehavior, Boolean userScrollEnabled, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new HorizontalUncontainedCarouselProps(itemWidth, itemSpacing, contentPadding, flingBehavior, userScrollEnabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HorizontalUncontainedCarouselProps)) {
            return false;
        }
        HorizontalUncontainedCarouselProps horizontalUncontainedCarouselProps = (HorizontalUncontainedCarouselProps) other;
        return Float.compare(this.itemWidth, horizontalUncontainedCarouselProps.itemWidth) == 0 && Intrinsics.areEqual((Object) this.itemSpacing, (Object) horizontalUncontainedCarouselProps.itemSpacing) && Intrinsics.areEqual(this.contentPadding, horizontalUncontainedCarouselProps.contentPadding) && this.flingBehavior == horizontalUncontainedCarouselProps.flingBehavior && Intrinsics.areEqual(this.userScrollEnabled, horizontalUncontainedCarouselProps.userScrollEnabled) && Intrinsics.areEqual(this.modifiers, horizontalUncontainedCarouselProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.itemWidth) * 31;
        Float f = this.itemSpacing;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Either<Float, PaddingValuesRecord> either = this.contentPadding;
        int iHashCode3 = (iHashCode2 + (either == null ? 0 : either.hashCode())) * 31;
        FlingBehaviorType flingBehaviorType = this.flingBehavior;
        int iHashCode4 = (iHashCode3 + (flingBehaviorType == null ? 0 : flingBehaviorType.hashCode())) * 31;
        Boolean bool = this.userScrollEnabled;
        return ((iHashCode4 + (bool != null ? bool.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "HorizontalUncontainedCarouselProps(itemWidth=" + this.itemWidth + ", itemSpacing=" + this.itemSpacing + ", contentPadding=" + this.contentPadding + ", flingBehavior=" + this.flingBehavior + ", userScrollEnabled=" + this.userScrollEnabled + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalUncontainedCarouselProps(float f, Float f2, Either<Float, PaddingValuesRecord> either, FlingBehaviorType flingBehaviorType, Boolean bool, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.itemWidth = f;
        this.itemSpacing = f2;
        this.contentPadding = either;
        this.flingBehavior = flingBehaviorType;
        this.userScrollEnabled = bool;
        this.modifiers = modifiers;
    }

    public final float getItemWidth() {
        return this.itemWidth;
    }

    public final Float getItemSpacing() {
        return this.itemSpacing;
    }

    public final Either<Float, PaddingValuesRecord> getContentPadding() {
        return this.contentPadding;
    }

    public final FlingBehaviorType getFlingBehavior() {
        return this.flingBehavior;
    }

    public final Boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    public /* synthetic */ HorizontalUncontainedCarouselProps(float f, Float f2, Either either, FlingBehaviorType flingBehaviorType, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 200.0f : f, (i & 2) != 0 ? null : f2, (i & 4) != 0 ? null : either, (i & 8) != 0 ? null : flingBehaviorType, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
