package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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

/* JADX INFO: compiled from: RNHostView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#Bg\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012(\b\u0002\u0010\b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e0\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J)\u0010\u0019\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e0\u0004HÆ\u0003Ji\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042(\b\u0002\u0010\b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e0\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u000bHÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R1\u0010\b\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lexpo/modules/ui/RNHostViewProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "matchContentsHorizontal", "Landroidx/compose/runtime/MutableState;", "", "matchContentsVertical", "expoInternalSizeFromChildren", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getMatchContentsHorizontal", "()Landroidx/compose/runtime/MutableState;", "getMatchContentsVertical", "getExpoInternalSizeFromChildren", "getModifiers", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class RNHostViewProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 0;
    public MutableState<Boolean> expoInternalSizeFromChildren;
    public MutableState<Boolean> matchContentsHorizontal;
    public MutableState<Boolean> matchContentsVertical;
    public MutableState<List<Map<String, Dynamic>>> modifiers;

    /* JADX INFO: compiled from: RNHostView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/RNHostViewProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<RNHostViewProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(RNHostViewProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("matchContentsHorizontal", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN_NULLABLE}), null), 0, __pika, false, true, false), new PProperty("matchContentsVertical", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN_NULLABLE}), null), 1, __pika, false, true, false), new PProperty("expoInternalSizeFromChildren", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN_NULLABLE}), null), 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
                return ((RNHostViewProps) obj).getMatchContentsHorizontal();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
                return ((RNHostViewProps) obj).getMatchContentsVertical();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
                return ((RNHostViewProps) obj).getExpoInternalSizeFromChildren();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
            return ((RNHostViewProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean?>");
                ((RNHostViewProps) obj).matchContentsHorizontal = (MutableState) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean?>");
                ((RNHostViewProps) obj).matchContentsVertical = (MutableState) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean?>");
                ((RNHostViewProps) obj).expoInternalSizeFromChildren = (MutableState) obj2;
                return;
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.RNHostViewProps");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>>");
            ((RNHostViewProps) obj).modifiers = (MutableState) obj2;
        }
    }

    public RNHostViewProps() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RNHostViewProps copy$default(RNHostViewProps rNHostViewProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = rNHostViewProps.matchContentsHorizontal;
        }
        if ((i & 2) != 0) {
            mutableState2 = rNHostViewProps.matchContentsVertical;
        }
        if ((i & 4) != 0) {
            mutableState3 = rNHostViewProps.expoInternalSizeFromChildren;
        }
        if ((i & 8) != 0) {
            mutableState4 = rNHostViewProps.modifiers;
        }
        return rNHostViewProps.copy(mutableState, mutableState2, mutableState3, mutableState4);
    }

    public final MutableState<Boolean> component1() {
        return this.matchContentsHorizontal;
    }

    public final MutableState<Boolean> component2() {
        return this.matchContentsVertical;
    }

    public final MutableState<Boolean> component3() {
        return this.expoInternalSizeFromChildren;
    }

    public final MutableState<List<Map<String, Dynamic>>> component4() {
        return this.modifiers;
    }

    public final RNHostViewProps copy(MutableState<Boolean> matchContentsHorizontal, MutableState<Boolean> matchContentsVertical, MutableState<Boolean> expoInternalSizeFromChildren, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(matchContentsHorizontal, "matchContentsHorizontal");
        Intrinsics.checkNotNullParameter(matchContentsVertical, "matchContentsVertical");
        Intrinsics.checkNotNullParameter(expoInternalSizeFromChildren, "expoInternalSizeFromChildren");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new RNHostViewProps(matchContentsHorizontal, matchContentsVertical, expoInternalSizeFromChildren, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RNHostViewProps)) {
            return false;
        }
        RNHostViewProps rNHostViewProps = (RNHostViewProps) other;
        return Intrinsics.areEqual(this.matchContentsHorizontal, rNHostViewProps.matchContentsHorizontal) && Intrinsics.areEqual(this.matchContentsVertical, rNHostViewProps.matchContentsVertical) && Intrinsics.areEqual(this.expoInternalSizeFromChildren, rNHostViewProps.expoInternalSizeFromChildren) && Intrinsics.areEqual(this.modifiers, rNHostViewProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((((this.matchContentsHorizontal.hashCode() * 31) + this.matchContentsVertical.hashCode()) * 31) + this.expoInternalSizeFromChildren.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "RNHostViewProps(matchContentsHorizontal=" + this.matchContentsHorizontal + ", matchContentsVertical=" + this.matchContentsVertical + ", expoInternalSizeFromChildren=" + this.expoInternalSizeFromChildren + ", modifiers=" + this.modifiers + ")";
    }

    public RNHostViewProps(MutableState<Boolean> matchContentsHorizontal, MutableState<Boolean> matchContentsVertical, MutableState<Boolean> expoInternalSizeFromChildren, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(matchContentsHorizontal, "matchContentsHorizontal");
        Intrinsics.checkNotNullParameter(matchContentsVertical, "matchContentsVertical");
        Intrinsics.checkNotNullParameter(expoInternalSizeFromChildren, "expoInternalSizeFromChildren");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.matchContentsHorizontal = matchContentsHorizontal;
        this.matchContentsVertical = matchContentsVertical;
        this.expoInternalSizeFromChildren = expoInternalSizeFromChildren;
        this.modifiers = modifiers;
    }

    public /* synthetic */ RNHostViewProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState4);
    }

    public final MutableState<Boolean> getMatchContentsHorizontal() {
        return this.matchContentsHorizontal;
    }

    public final MutableState<Boolean> getMatchContentsVertical() {
        return this.matchContentsVertical;
    }

    public final MutableState<Boolean> getExpoInternalSizeFromChildren() {
        return this.expoInternalSizeFromChildren;
    }

    public final MutableState<List<Map<String, Dynamic>>> getModifiers() {
        return this.modifiers;
    }
}
