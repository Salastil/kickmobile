package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.types.Either;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.convertibles.HorizontalAlignment;
import expo.modules.ui.convertibles.VerticalArrangementCustom;
import expo.modules.ui.convertibles.VerticalArrangementDefault;
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

/* JADX INFO: compiled from: LazyColumnView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)By\u0012\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b0\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u0012(\b\u0002\u0010\r\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u00130\u0004¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b0\u0004HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004HÆ\u0003J)\u0010\u001e\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u00130\u0004HÆ\u0003J{\u0010\u001f\u001a\u00020\u00002\"\b\u0002\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b0\u00042\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00042(\b\u0002\u0010\r\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u00130\u0004HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\f\u0010$\u001a\u0006\u0012\u0002\b\u00030%H\u0016J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0010HÖ\u0001R+\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R1\u0010\r\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fj\u0002`\u00120\u000ej\u0002`\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017¨\u0006*"}, d2 = {"Lexpo/modules/ui/LazyColumnProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "verticalArrangement", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/convertibles/VerticalArrangementDefault;", "Lexpo/modules/ui/convertibles/VerticalArrangementCustom;", "Lexpo/modules/ui/convertibles/VerticalArrangement;", "horizontalAlignment", "Lexpo/modules/ui/convertibles/HorizontalAlignment;", "contentPadding", "Lexpo/modules/ui/ContentPadding;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getVerticalArrangement", "()Landroidx/compose/runtime/MutableState;", "getHorizontalAlignment", "getContentPadding", "getModifiers", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LazyColumnProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 0;
    public MutableState<ContentPadding> contentPadding;
    public MutableState<HorizontalAlignment> horizontalAlignment;
    public MutableState<List<Map<String, Dynamic>>> modifiers;
    public MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> verticalArrangement;

    /* JADX INFO: compiled from: LazyColumnView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/LazyColumnProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<LazyColumnProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(LazyColumnProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("verticalArrangement", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Either.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(VerticalArrangementDefault.class, false, null), PTypeDescriptorRegistry.getOrCreateConcrete(VerticalArrangementCustom.class, false, null)}), null)}), null), 0, __pika, false, true, false), new PProperty("horizontalAlignment", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(HorizontalAlignment.class, true, null)}), null), 1, __pika, false, true, false), new PProperty("contentPadding", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ContentPadding.class, true, ContentPadding.__Pika.__pika$IntrospectionData)}), null), 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
                return ((LazyColumnProps) obj).getVerticalArrangement();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
                return ((LazyColumnProps) obj).getHorizontalAlignment();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
                return ((LazyColumnProps) obj).getContentPadding();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
            return ((LazyColumnProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.kotlin.types.Either<expo.modules.ui.convertibles.VerticalArrangementDefault, expo.modules.ui.convertibles.VerticalArrangementCustom>?>");
                ((LazyColumnProps) obj).verticalArrangement = (MutableState) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.convertibles.HorizontalAlignment?>");
                ((LazyColumnProps) obj).horizontalAlignment = (MutableState) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.ContentPadding?>");
                ((LazyColumnProps) obj).contentPadding = (MutableState) obj2;
                return;
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyColumnProps");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>>");
            ((LazyColumnProps) obj).modifiers = (MutableState) obj2;
        }
    }

    public LazyColumnProps() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LazyColumnProps copy$default(LazyColumnProps lazyColumnProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = lazyColumnProps.verticalArrangement;
        }
        if ((i & 2) != 0) {
            mutableState2 = lazyColumnProps.horizontalAlignment;
        }
        if ((i & 4) != 0) {
            mutableState3 = lazyColumnProps.contentPadding;
        }
        if ((i & 8) != 0) {
            mutableState4 = lazyColumnProps.modifiers;
        }
        return lazyColumnProps.copy(mutableState, mutableState2, mutableState3, mutableState4);
    }

    public final MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> component1() {
        return this.verticalArrangement;
    }

    public final MutableState<HorizontalAlignment> component2() {
        return this.horizontalAlignment;
    }

    public final MutableState<ContentPadding> component3() {
        return this.contentPadding;
    }

    public final MutableState<List<Map<String, Dynamic>>> component4() {
        return this.modifiers;
    }

    public final LazyColumnProps copy(MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> verticalArrangement, MutableState<HorizontalAlignment> horizontalAlignment, MutableState<ContentPadding> contentPadding, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new LazyColumnProps(verticalArrangement, horizontalAlignment, contentPadding, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LazyColumnProps)) {
            return false;
        }
        LazyColumnProps lazyColumnProps = (LazyColumnProps) other;
        return Intrinsics.areEqual(this.verticalArrangement, lazyColumnProps.verticalArrangement) && Intrinsics.areEqual(this.horizontalAlignment, lazyColumnProps.horizontalAlignment) && Intrinsics.areEqual(this.contentPadding, lazyColumnProps.contentPadding) && Intrinsics.areEqual(this.modifiers, lazyColumnProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((((this.verticalArrangement.hashCode() * 31) + this.horizontalAlignment.hashCode()) * 31) + this.contentPadding.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "LazyColumnProps(verticalArrangement=" + this.verticalArrangement + ", horizontalAlignment=" + this.horizontalAlignment + ", contentPadding=" + this.contentPadding + ", modifiers=" + this.modifiers + ")";
    }

    public LazyColumnProps(MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> verticalArrangement, MutableState<HorizontalAlignment> horizontalAlignment, MutableState<ContentPadding> contentPadding, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.verticalArrangement = verticalArrangement;
        this.horizontalAlignment = horizontalAlignment;
        this.contentPadding = contentPadding;
        this.modifiers = modifiers;
    }

    public /* synthetic */ LazyColumnProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState4);
    }

    public final MutableState<Either<VerticalArrangementDefault, VerticalArrangementCustom>> getVerticalArrangement() {
        return this.verticalArrangement;
    }

    public final MutableState<HorizontalAlignment> getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public final MutableState<ContentPadding> getContentPadding() {
        return this.contentPadding;
    }

    public final MutableState<List<Map<String, Dynamic>>> getModifiers() {
        return this.modifiers;
    }
}
