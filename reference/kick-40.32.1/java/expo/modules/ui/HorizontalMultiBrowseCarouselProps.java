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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:B\u0089\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\"\b\u0002\u0010\u000f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J#\u0010/\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0003J\u0090\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\"\b\u0002\u0010\u000f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\f\u00105\u001a\u0006\u0012\u0002\b\u000306H\u0016J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R+\u0010\u000f\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011j\u0002`\u00140\u0010j\u0002`\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006;"}, d2 = {"Lexpo/modules/ui/HorizontalMultiBrowseCarouselProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "preferredItemWidth", "", "itemSpacing", "contentPadding", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/PaddingValuesRecord;", "minSmallItemWidth", "maxSmallItemWidth", "flingBehavior", "Lexpo/modules/ui/FlingBehaviorType;", "userScrollEnabled", "", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(FLjava/lang/Float;Lexpo/modules/kotlin/types/Either;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Boolean;Ljava/util/List;)V", "getPreferredItemWidth", "()F", "getItemSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getContentPadding", "()Lexpo/modules/kotlin/types/Either;", "getMinSmallItemWidth", "getMaxSmallItemWidth", "getFlingBehavior", "()Lexpo/modules/ui/FlingBehaviorType;", "getUserScrollEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(FLjava/lang/Float;Lexpo/modules/kotlin/types/Either;Ljava/lang/Float;Ljava/lang/Float;Lexpo/modules/ui/FlingBehaviorType;Ljava/lang/Boolean;Ljava/util/List;)Lexpo/modules/ui/HorizontalMultiBrowseCarouselProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HorizontalMultiBrowseCarouselProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Either<Float, PaddingValuesRecord> contentPadding;
    public FlingBehaviorType flingBehavior;
    public Float itemSpacing;
    public Float maxSmallItemWidth;
    public Float minSmallItemWidth;
    public List<Map<String, Dynamic>> modifiers;
    public float preferredItemWidth;
    public Boolean userScrollEnabled;

    /* JADX INFO: compiled from: CarouselView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/HorizontalMultiBrowseCarouselProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<HorizontalMultiBrowseCarouselProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(HorizontalMultiBrowseCarouselProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("preferredItemWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT, 0, __pika, false, true, false), new PProperty("itemSpacing", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 1, __pika, false, true, false), new PProperty("contentPadding", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.FLOAT, PTypeDescriptorRegistry.getOrCreateConcrete(PaddingValuesRecord.class, false, null)}), null), 2, __pika, false, true, false), new PProperty("minSmallItemWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("maxSmallItemWidth", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 4, __pika, false, true, false), new PProperty("flingBehavior", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(FlingBehaviorType.class, true, null), 5, __pika, false, true, false), new PProperty("userScrollEnabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 6, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 7, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("component8", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return Float.valueOf(((HorizontalMultiBrowseCarouselProps) obj).getPreferredItemWidth());
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return ((HorizontalMultiBrowseCarouselProps) obj).getItemSpacing();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return ((HorizontalMultiBrowseCarouselProps) obj).getContentPadding();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return ((HorizontalMultiBrowseCarouselProps) obj).getMinSmallItemWidth();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return ((HorizontalMultiBrowseCarouselProps) obj).getMaxSmallItemWidth();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return ((HorizontalMultiBrowseCarouselProps) obj).getFlingBehavior();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return ((HorizontalMultiBrowseCarouselProps) obj).getUserScrollEnabled();
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    return ((HorizontalMultiBrowseCarouselProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Float");
                    ((HorizontalMultiBrowseCarouselProps) obj).preferredItemWidth = ((Float) obj2).floatValue();
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    ((HorizontalMultiBrowseCarouselProps) obj).itemSpacing = (Float) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    ((HorizontalMultiBrowseCarouselProps) obj).contentPadding = (Either) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    ((HorizontalMultiBrowseCarouselProps) obj).minSmallItemWidth = (Float) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    ((HorizontalMultiBrowseCarouselProps) obj).maxSmallItemWidth = (Float) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    ((HorizontalMultiBrowseCarouselProps) obj).flingBehavior = (FlingBehaviorType) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    ((HorizontalMultiBrowseCarouselProps) obj).userScrollEnabled = (Boolean) obj2;
                    return;
                case 7:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalMultiBrowseCarouselProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((HorizontalMultiBrowseCarouselProps) obj).modifiers = (List) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public HorizontalMultiBrowseCarouselProps() {
        this(0.0f, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalMultiBrowseCarouselProps copy$default(HorizontalMultiBrowseCarouselProps horizontalMultiBrowseCarouselProps, float f, Float f2, Either either, Float f3, Float f4, FlingBehaviorType flingBehaviorType, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            f = horizontalMultiBrowseCarouselProps.preferredItemWidth;
        }
        if ((i & 2) != 0) {
            f2 = horizontalMultiBrowseCarouselProps.itemSpacing;
        }
        if ((i & 4) != 0) {
            either = horizontalMultiBrowseCarouselProps.contentPadding;
        }
        if ((i & 8) != 0) {
            f3 = horizontalMultiBrowseCarouselProps.minSmallItemWidth;
        }
        if ((i & 16) != 0) {
            f4 = horizontalMultiBrowseCarouselProps.maxSmallItemWidth;
        }
        if ((i & 32) != 0) {
            flingBehaviorType = horizontalMultiBrowseCarouselProps.flingBehavior;
        }
        if ((i & 64) != 0) {
            bool = horizontalMultiBrowseCarouselProps.userScrollEnabled;
        }
        if ((i & 128) != 0) {
            list = horizontalMultiBrowseCarouselProps.modifiers;
        }
        Boolean bool2 = bool;
        List list2 = list;
        Float f5 = f4;
        FlingBehaviorType flingBehaviorType2 = flingBehaviorType;
        return horizontalMultiBrowseCarouselProps.copy(f, f2, either, f3, f5, flingBehaviorType2, bool2, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getPreferredItemWidth() {
        return this.preferredItemWidth;
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

    public final HorizontalMultiBrowseCarouselProps copy(float preferredItemWidth, Float itemSpacing, Either<Float, PaddingValuesRecord> contentPadding, Float minSmallItemWidth, Float maxSmallItemWidth, FlingBehaviorType flingBehavior, Boolean userScrollEnabled, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new HorizontalMultiBrowseCarouselProps(preferredItemWidth, itemSpacing, contentPadding, minSmallItemWidth, maxSmallItemWidth, flingBehavior, userScrollEnabled, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HorizontalMultiBrowseCarouselProps)) {
            return false;
        }
        HorizontalMultiBrowseCarouselProps horizontalMultiBrowseCarouselProps = (HorizontalMultiBrowseCarouselProps) other;
        return Float.compare(this.preferredItemWidth, horizontalMultiBrowseCarouselProps.preferredItemWidth) == 0 && Intrinsics.areEqual((Object) this.itemSpacing, (Object) horizontalMultiBrowseCarouselProps.itemSpacing) && Intrinsics.areEqual(this.contentPadding, horizontalMultiBrowseCarouselProps.contentPadding) && Intrinsics.areEqual((Object) this.minSmallItemWidth, (Object) horizontalMultiBrowseCarouselProps.minSmallItemWidth) && Intrinsics.areEqual((Object) this.maxSmallItemWidth, (Object) horizontalMultiBrowseCarouselProps.maxSmallItemWidth) && this.flingBehavior == horizontalMultiBrowseCarouselProps.flingBehavior && Intrinsics.areEqual(this.userScrollEnabled, horizontalMultiBrowseCarouselProps.userScrollEnabled) && Intrinsics.areEqual(this.modifiers, horizontalMultiBrowseCarouselProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.preferredItemWidth) * 31;
        Float f = this.itemSpacing;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        Either<Float, PaddingValuesRecord> either = this.contentPadding;
        int iHashCode3 = (iHashCode2 + (either == null ? 0 : either.hashCode())) * 31;
        Float f2 = this.minSmallItemWidth;
        int iHashCode4 = (iHashCode3 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.maxSmallItemWidth;
        int iHashCode5 = (iHashCode4 + (f3 == null ? 0 : f3.hashCode())) * 31;
        FlingBehaviorType flingBehaviorType = this.flingBehavior;
        int iHashCode6 = (iHashCode5 + (flingBehaviorType == null ? 0 : flingBehaviorType.hashCode())) * 31;
        Boolean bool = this.userScrollEnabled;
        return ((iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "HorizontalMultiBrowseCarouselProps(preferredItemWidth=" + this.preferredItemWidth + ", itemSpacing=" + this.itemSpacing + ", contentPadding=" + this.contentPadding + ", minSmallItemWidth=" + this.minSmallItemWidth + ", maxSmallItemWidth=" + this.maxSmallItemWidth + ", flingBehavior=" + this.flingBehavior + ", userScrollEnabled=" + this.userScrollEnabled + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalMultiBrowseCarouselProps(float f, Float f2, Either<Float, PaddingValuesRecord> either, Float f3, Float f4, FlingBehaviorType flingBehaviorType, Boolean bool, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.preferredItemWidth = f;
        this.itemSpacing = f2;
        this.contentPadding = either;
        this.minSmallItemWidth = f3;
        this.maxSmallItemWidth = f4;
        this.flingBehavior = flingBehaviorType;
        this.userScrollEnabled = bool;
        this.modifiers = modifiers;
    }

    public final float getPreferredItemWidth() {
        return this.preferredItemWidth;
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

    public /* synthetic */ HorizontalMultiBrowseCarouselProps(float f, Float f2, Either either, Float f3, Float f4, FlingBehaviorType flingBehaviorType, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 200.0f : f, (i & 2) != 0 ? null : f2, (i & 4) != 0 ? null : either, (i & 8) != 0 ? null : f3, (i & 16) != 0 ? null : f4, (i & 32) != 0 ? null : flingBehaviorType, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
