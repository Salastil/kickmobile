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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00019B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\"\b\u0002\u0010\u000f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010#J#\u0010.\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0003J\u0092\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\"\b\u0002\u0010\u000f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u000e2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\f\u00104\u001a\u0006\u0012\u0002\b\u000305H\u0016J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R+\u0010\u000f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006:"}, d2 = {"Lexpo/modules/ui/HorizontalCenteredHeroCarouselProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "maxItemWidth", "", "itemSpacing", "contentPadding", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/PaddingValuesRecord;", "minSmallItemWidth", "maxSmallItemWidth", "flingBehavior", "Lexpo/modules/ui/FlingBehaviorType;", "userScrollEnabled", "", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/kotlin/types/Either;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Boolean;Ljava/util/List;)V", "getMaxItemWidth", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getItemSpacing", "getContentPadding", "()Lexpo/modules/kotlin/types/Either;", "getMinSmallItemWidth", "getMaxSmallItemWidth", "getFlingBehavior", "()Lexpo/modules/ui/FlingBehaviorType;", "getUserScrollEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/kotlin/types/Either;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Boolean;Ljava/util/List;)Lexpo/modules/ui/HorizontalCenteredHeroCarouselProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HorizontalCenteredHeroCarouselProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Either<Float, PaddingValuesRecord> contentPadding;
    public FlingBehaviorType flingBehavior;
    public Float itemSpacing;
    public Float maxItemWidth;
    public Float maxSmallItemWidth;
    public Float minSmallItemWidth;
    public List<Map<String, Dynamic>> modifiers;
    public Boolean userScrollEnabled;

    /* JADX INFO: compiled from: CarouselView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/HorizontalCenteredHeroCarouselProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<HorizontalCenteredHeroCarouselProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(HorizontalCenteredHeroCarouselProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("maxItemWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 0, __pika, false, true, false), new PProperty("itemSpacing", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty("contentPadding", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.FLOAT, PTypeDescriptorRegistry.getOrCreateConcrete(PaddingValuesRecord.class, false, null)}), null), 2, __pika, false, true, false), new PProperty("minSmallItemWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("maxSmallItemWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 4, __pika, false, true, false), new PProperty("flingBehavior", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(FlingBehaviorType.class, true, null), 5, __pika, false, true, false), new PProperty("userScrollEnabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 6, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 7, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getMaxItemWidth();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getItemSpacing();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getContentPadding();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getMinSmallItemWidth();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getMaxSmallItemWidth();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getFlingBehavior();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getUserScrollEnabled();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    return ((HorizontalCenteredHeroCarouselProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    ((HorizontalCenteredHeroCarouselProps) obj).maxItemWidth = (Float) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    ((HorizontalCenteredHeroCarouselProps) obj).itemSpacing = (Float) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    ((HorizontalCenteredHeroCarouselProps) obj).contentPadding = (Either) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    ((HorizontalCenteredHeroCarouselProps) obj).minSmallItemWidth = (Float) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    ((HorizontalCenteredHeroCarouselProps) obj).maxSmallItemWidth = (Float) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    ((HorizontalCenteredHeroCarouselProps) obj).flingBehavior = (FlingBehaviorType) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    ((HorizontalCenteredHeroCarouselProps) obj).userScrollEnabled = (Boolean) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalCenteredHeroCarouselProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((HorizontalCenteredHeroCarouselProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public HorizontalCenteredHeroCarouselProps() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalCenteredHeroCarouselProps copy$default(HorizontalCenteredHeroCarouselProps horizontalCenteredHeroCarouselProps, Float f, Float f2, Either either, Float f3, Float f4, FlingBehaviorType flingBehaviorType, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = horizontalCenteredHeroCarouselProps.maxItemWidth;
        }
        if ((i & 2) != 0) {
            f2 = horizontalCenteredHeroCarouselProps.itemSpacing;
        }
        if ((i & 4) != 0) {
            either = horizontalCenteredHeroCarouselProps.contentPadding;
        }
        if ((i & 8) != 0) {
            f3 = horizontalCenteredHeroCarouselProps.minSmallItemWidth;
        }
        if ((i & 16) != 0) {
            f4 = horizontalCenteredHeroCarouselProps.maxSmallItemWidth;
        }
        if ((i & 32) != 0) {
            flingBehaviorType = horizontalCenteredHeroCarouselProps.flingBehavior;
        }
        if ((i & 64) != 0) {
            bool = horizontalCenteredHeroCarouselProps.userScrollEnabled;
        }
        if ((i & 128) != 0) {
            list = horizontalCenteredHeroCarouselProps.modifiers;
        }
        Boolean bool2 = bool;
        List list2 = list;
        Float f5 = f4;
        FlingBehaviorType flingBehaviorType2 = flingBehaviorType;
        return horizontalCenteredHeroCarouselProps.copy(f, f2, either, f3, f5, flingBehaviorType2, bool2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Float getMaxItemWidth() {
        return this.maxItemWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Float getItemSpacing() {
        return this.itemSpacing;
    }

    public final Either<Float, PaddingValuesRecord> component3() {
        return this.contentPadding;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getMinSmallItemWidth() {
        return this.minSmallItemWidth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Float getMaxSmallItemWidth() {
        return this.maxSmallItemWidth;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final FlingBehaviorType getFlingBehavior() {
        return this.flingBehavior;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    public final List<Map<String, Dynamic>> component8() {
        return this.modifiers;
    }

    public final HorizontalCenteredHeroCarouselProps copy(Float maxItemWidth, Float itemSpacing, Either<Float, PaddingValuesRecord> contentPadding, Float minSmallItemWidth, Float maxSmallItemWidth, FlingBehaviorType flingBehavior, Boolean userScrollEnabled, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new HorizontalCenteredHeroCarouselProps(maxItemWidth, itemSpacing, contentPadding, minSmallItemWidth, maxSmallItemWidth, flingBehavior, userScrollEnabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HorizontalCenteredHeroCarouselProps)) {
            return false;
        }
        HorizontalCenteredHeroCarouselProps horizontalCenteredHeroCarouselProps = (HorizontalCenteredHeroCarouselProps) other;
        return Intrinsics.areEqual((Object) this.maxItemWidth, (Object) horizontalCenteredHeroCarouselProps.maxItemWidth) && Intrinsics.areEqual((Object) this.itemSpacing, (Object) horizontalCenteredHeroCarouselProps.itemSpacing) && Intrinsics.areEqual(this.contentPadding, horizontalCenteredHeroCarouselProps.contentPadding) && Intrinsics.areEqual((Object) this.minSmallItemWidth, (Object) horizontalCenteredHeroCarouselProps.minSmallItemWidth) && Intrinsics.areEqual((Object) this.maxSmallItemWidth, (Object) horizontalCenteredHeroCarouselProps.maxSmallItemWidth) && this.flingBehavior == horizontalCenteredHeroCarouselProps.flingBehavior && Intrinsics.areEqual(this.userScrollEnabled, horizontalCenteredHeroCarouselProps.userScrollEnabled) && Intrinsics.areEqual(this.modifiers, horizontalCenteredHeroCarouselProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        Float f = this.maxItemWidth;
        int iHashCode = (f == null ? 0 : f.hashCode()) * 31;
        Float f2 = this.itemSpacing;
        int iHashCode2 = (iHashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
        Either<Float, PaddingValuesRecord> either = this.contentPadding;
        int iHashCode3 = (iHashCode2 + (either == null ? 0 : either.hashCode())) * 31;
        Float f3 = this.minSmallItemWidth;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Float f4 = this.maxSmallItemWidth;
        int iHashCode5 = (iHashCode4 + (f4 == null ? 0 : f4.hashCode())) * 31;
        FlingBehaviorType flingBehaviorType = this.flingBehavior;
        int iHashCode6 = (iHashCode5 + (flingBehaviorType == null ? 0 : flingBehaviorType.hashCode())) * 31;
        Boolean bool = this.userScrollEnabled;
        return ((iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "HorizontalCenteredHeroCarouselProps(maxItemWidth=" + this.maxItemWidth + ", itemSpacing=" + this.itemSpacing + ", contentPadding=" + this.contentPadding + ", minSmallItemWidth=" + this.minSmallItemWidth + ", maxSmallItemWidth=" + this.maxSmallItemWidth + ", flingBehavior=" + this.flingBehavior + ", userScrollEnabled=" + this.userScrollEnabled + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalCenteredHeroCarouselProps(Float f, Float f2, Either<Float, PaddingValuesRecord> either, Float f3, Float f4, FlingBehaviorType flingBehaviorType, Boolean bool, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.maxItemWidth = f;
        this.itemSpacing = f2;
        this.contentPadding = either;
        this.minSmallItemWidth = f3;
        this.maxSmallItemWidth = f4;
        this.flingBehavior = flingBehaviorType;
        this.userScrollEnabled = bool;
        this.modifiers = modifiers;
    }

    public final Float getMaxItemWidth() {
        return this.maxItemWidth;
    }

    public final Float getItemSpacing() {
        return this.itemSpacing;
    }

    public final Either<Float, PaddingValuesRecord> getContentPadding() {
        return this.contentPadding;
    }

    public final Float getMinSmallItemWidth() {
        return this.minSmallItemWidth;
    }

    public final Float getMaxSmallItemWidth() {
        return this.maxSmallItemWidth;
    }

    public final FlingBehaviorType getFlingBehavior() {
        return this.flingBehavior;
    }

    public final Boolean getUserScrollEnabled() {
        return this.userScrollEnabled;
    }

    public /* synthetic */ HorizontalCenteredHeroCarouselProps(Float f, Float f2, Either either, Float f3, Float f4, FlingBehaviorType flingBehaviorType, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : f, (i & 2) != 0 ? null : f2, (i & 4) != 0 ? null : either, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : f4, (i & 32) != 0 ? null : flingBehaviorType, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
