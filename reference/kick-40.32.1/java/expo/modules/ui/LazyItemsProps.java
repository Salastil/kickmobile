package expo.modules.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyItemsView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB=\u0012\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0004HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0004HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001e"}, d2 = {"Lexpo/modules/ui/LazyItemsProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "itemKeys", "Landroidx/compose/runtime/MutableState;", "", "", "revision", "", "estimatedItemSize", "", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getItemKeys", "()Landroidx/compose/runtime/MutableState;", "getRevision", "getEstimatedItemSize", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class LazyItemsProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 0;
    public MutableState<Double> estimatedItemSize;
    public MutableState<List<String>> itemKeys;
    public MutableState<Integer> revision;

    /* JADX INFO: compiled from: LazyItemsView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/LazyItemsProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<LazyItemsProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(LazyItemsProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("itemKeys", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING}), null)}), null), 0, __pika, false, true, false), new PProperty("revision", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.INT}), null), 1, __pika, false, true, false), new PProperty("estimatedItemSize", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.DOUBLE}), null), 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyItemsProps");
                return ((LazyItemsProps) obj).getItemKeys();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyItemsProps");
                return ((LazyItemsProps) obj).getRevision();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyItemsProps");
            return ((LazyItemsProps) obj).getEstimatedItemSize();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyItemsProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.collections.List<kotlin.String>>");
                ((LazyItemsProps) obj).itemKeys = (MutableState) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyItemsProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Int>");
                ((LazyItemsProps) obj).revision = (MutableState) obj2;
                return;
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.LazyItemsProps");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Double>");
            ((LazyItemsProps) obj).estimatedItemSize = (MutableState) obj2;
        }
    }

    public LazyItemsProps() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LazyItemsProps copy$default(LazyItemsProps lazyItemsProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = lazyItemsProps.itemKeys;
        }
        if ((i & 2) != 0) {
            mutableState2 = lazyItemsProps.revision;
        }
        if ((i & 4) != 0) {
            mutableState3 = lazyItemsProps.estimatedItemSize;
        }
        return lazyItemsProps.copy(mutableState, mutableState2, mutableState3);
    }

    public final MutableState<List<String>> component1() {
        return this.itemKeys;
    }

    public final MutableState<Integer> component2() {
        return this.revision;
    }

    public final MutableState<Double> component3() {
        return this.estimatedItemSize;
    }

    public final LazyItemsProps copy(MutableState<List<String>> itemKeys, MutableState<Integer> revision, MutableState<Double> estimatedItemSize) {
        Intrinsics.checkNotNullParameter(itemKeys, "itemKeys");
        Intrinsics.checkNotNullParameter(revision, "revision");
        Intrinsics.checkNotNullParameter(estimatedItemSize, "estimatedItemSize");
        return new LazyItemsProps(itemKeys, revision, estimatedItemSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LazyItemsProps)) {
            return false;
        }
        LazyItemsProps lazyItemsProps = (LazyItemsProps) other;
        return Intrinsics.areEqual(this.itemKeys, lazyItemsProps.itemKeys) && Intrinsics.areEqual(this.revision, lazyItemsProps.revision) && Intrinsics.areEqual(this.estimatedItemSize, lazyItemsProps.estimatedItemSize);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((this.itemKeys.hashCode() * 31) + this.revision.hashCode()) * 31) + this.estimatedItemSize.hashCode();
    }

    public String toString() {
        return "LazyItemsProps(itemKeys=" + this.itemKeys + ", revision=" + this.revision + ", estimatedItemSize=" + this.estimatedItemSize + ")";
    }

    public LazyItemsProps(MutableState<List<String>> itemKeys, MutableState<Integer> revision, MutableState<Double> estimatedItemSize) {
        Intrinsics.checkNotNullParameter(itemKeys, "itemKeys");
        Intrinsics.checkNotNullParameter(revision, "revision");
        Intrinsics.checkNotNullParameter(estimatedItemSize, "estimatedItemSize");
        this.itemKeys = itemKeys;
        this.revision = revision;
        this.estimatedItemSize = estimatedItemSize;
    }

    public /* synthetic */ LazyItemsProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Double.valueOf(64.0d), null, 2, null) : mutableState3);
    }

    public final MutableState<List<String>> getItemKeys() {
        return this.itemKeys;
    }

    public final MutableState<Integer> getRevision() {
        return this.revision;
    }

    public final MutableState<Double> getEstimatedItemSize() {
        return this.estimatedItemSize;
    }
}
