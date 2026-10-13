package expo.modules.ui.icon;

import android.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.graphics.ImageSource;
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
import io.ktor.http.ContentDisposition;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IconView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+B\u0089\u0001\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004\u0012(\b\u0002\u0010\u000e\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u00130\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004HÆ\u0003J)\u0010\"\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u00130\u0004HÆ\u0003J\u008b\u0001\u0010#\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00042(\b\u0002\u0010\u000e\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u00130\u0004HÆ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\f\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0016J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\rHÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R1\u0010\u000e\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u0010j\u0002`\u00120\u000fj\u0002`\u00130\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017¨\u0006,"}, d2 = {"Lexpo/modules/ui/icon/IconProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "source", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/ui/graphics/ImageSource;", "tint", "Landroid/graphics/Color;", "inheritTint", "", ContentDisposition.Parameters.Size, "", "contentDescription", "", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getSource", "()Landroidx/compose/runtime/MutableState;", "getTint", "getInheritTint", "getSize", "getContentDescription", "getModifiers", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class IconProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 0;
    public MutableState<String> contentDescription;
    public MutableState<Boolean> inheritTint;
    public MutableState<List<Map<String, Dynamic>>> modifiers;
    public MutableState<Integer> size;
    public MutableState<ImageSource> source;
    public MutableState<Color> tint;

    /* JADX INFO: compiled from: IconView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/icon/IconProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<IconProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(IconProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("source", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ImageSource.class, true, ImageSource.__Pika.__pika$IntrospectionData)}), null), 0, __pika, false, true, false), new PProperty("tint", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null)}), null), 1, __pika, false, true, false), new PProperty("inheritTint", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.BOOLEAN}), null), 2, __pika, false, true, false), new PProperty(ContentDisposition.Parameters.Size, PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.INT_NULLABLE}), null), 3, __pika, false, true, false), new PProperty("contentDescription", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING_NULLABLE}), null), 4, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null)}), null), 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                return ((IconProps) obj).getSource();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                return ((IconProps) obj).getTint();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                return ((IconProps) obj).getInheritTint();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                return ((IconProps) obj).getSize();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                return ((IconProps) obj).getContentDescription();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
            return ((IconProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.graphics.ImageSource?>");
                ((IconProps) obj).source = (MutableState) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<android.graphics.Color?>");
                ((IconProps) obj).tint = (MutableState) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Boolean>");
                ((IconProps) obj).inheritTint = (MutableState) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Int?>");
                ((IconProps) obj).size = (MutableState) obj2;
                return;
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.String?>");
                ((IconProps) obj).contentDescription = (MutableState) obj2;
                return;
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.icon.IconProps");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>>");
            ((IconProps) obj).modifiers = (MutableState) obj2;
        }
    }

    public IconProps() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IconProps copy$default(IconProps iconProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = iconProps.source;
        }
        if ((i & 2) != 0) {
            mutableState2 = iconProps.tint;
        }
        if ((i & 4) != 0) {
            mutableState3 = iconProps.inheritTint;
        }
        if ((i & 8) != 0) {
            mutableState4 = iconProps.size;
        }
        if ((i & 16) != 0) {
            mutableState5 = iconProps.contentDescription;
        }
        if ((i & 32) != 0) {
            mutableState6 = iconProps.modifiers;
        }
        MutableState mutableState7 = mutableState5;
        MutableState mutableState8 = mutableState6;
        return iconProps.copy(mutableState, mutableState2, mutableState3, mutableState4, mutableState7, mutableState8);
    }

    public final MutableState<ImageSource> component1() {
        return this.source;
    }

    public final MutableState<Color> component2() {
        return this.tint;
    }

    public final MutableState<Boolean> component3() {
        return this.inheritTint;
    }

    public final MutableState<Integer> component4() {
        return this.size;
    }

    public final MutableState<String> component5() {
        return this.contentDescription;
    }

    public final MutableState<List<Map<String, Dynamic>>> component6() {
        return this.modifiers;
    }

    public final IconProps copy(MutableState<ImageSource> source, MutableState<Color> tint, MutableState<Boolean> inheritTint, MutableState<Integer> size, MutableState<String> contentDescription, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(tint, "tint");
        Intrinsics.checkNotNullParameter(inheritTint, "inheritTint");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new IconProps(source, tint, inheritTint, size, contentDescription, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IconProps)) {
            return false;
        }
        IconProps iconProps = (IconProps) other;
        return Intrinsics.areEqual(this.source, iconProps.source) && Intrinsics.areEqual(this.tint, iconProps.tint) && Intrinsics.areEqual(this.inheritTint, iconProps.inheritTint) && Intrinsics.areEqual(this.size, iconProps.size) && Intrinsics.areEqual(this.contentDescription, iconProps.contentDescription) && Intrinsics.areEqual(this.modifiers, iconProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((((((((this.source.hashCode() * 31) + this.tint.hashCode()) * 31) + this.inheritTint.hashCode()) * 31) + this.size.hashCode()) * 31) + this.contentDescription.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "IconProps(source=" + this.source + ", tint=" + this.tint + ", inheritTint=" + this.inheritTint + ", size=" + this.size + ", contentDescription=" + this.contentDescription + ", modifiers=" + this.modifiers + ")";
    }

    public IconProps(MutableState<ImageSource> source, MutableState<Color> tint, MutableState<Boolean> inheritTint, MutableState<Integer> size, MutableState<String> contentDescription, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(tint, "tint");
        Intrinsics.checkNotNullParameter(inheritTint, "inheritTint");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.source = source;
        this.tint = tint;
        this.inheritTint = inheritTint;
        this.size = size;
        this.contentDescription = contentDescription;
        this.modifiers = modifiers;
    }

    public /* synthetic */ IconProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState4, (i & 16) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState5, (i & 32) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState6);
    }

    public final MutableState<ImageSource> getSource() {
        return this.source;
    }

    public final MutableState<Color> getTint() {
        return this.tint;
    }

    public final MutableState<Boolean> getInheritTint() {
        return this.inheritTint;
    }

    public final MutableState<Integer> getSize() {
        return this.size;
    }

    public final MutableState<String> getContentDescription() {
        return this.contentDescription;
    }

    public final MutableState<List<Map<String, Dynamic>>> getModifiers() {
        return this.modifiers;
    }
}
