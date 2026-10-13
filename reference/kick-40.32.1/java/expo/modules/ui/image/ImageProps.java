package expo.modules.ui.image;

import android.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.views.ComposeProps;
import expo.modules.kotlin.views.OptimizedComposeProps;
import expo.modules.ui.convertibles.ContentAlignment;
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
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B\u0097\u0001\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012(\b\u0002\u0010\u0010\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u00140\u0011j\u0002`\u00150\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004HÆ\u0003J)\u0010&\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u00140\u0011j\u0002`\u00150\u0004HÆ\u0003J\u0099\u0001\u0010'\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00042\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042(\b\u0002\u0010\u0010\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u00140\u0011j\u0002`\u00150\u0004HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\f\u0010,\u001a\u0006\u0012\u0002\b\u00030-H\u0016J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u000bHÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R1\u0010\u0010\u001a\"\u0012\u001e\u0012\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u00140\u0011j\u0002`\u00150\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019¨\u00062"}, d2 = {"Lexpo/modules/ui/image/ImageProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "source", "Landroidx/compose/runtime/MutableState;", "Lexpo/modules/ui/graphics/ImageSource;", "contentScale", "Lexpo/modules/ui/image/ImageContentScale;", "alignment", "Lexpo/modules/ui/convertibles/ContentAlignment;", "contentDescription", "", "tint", "Landroid/graphics/Color;", "alpha", "", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;)V", "getSource", "()Landroidx/compose/runtime/MutableState;", "getContentScale", "getAlignment", "getContentDescription", "getTint", "getAlpha", "getModifiers", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ImageProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 0;
    public MutableState<ContentAlignment> alignment;
    public MutableState<Float> alpha;
    public MutableState<String> contentDescription;
    public MutableState<ImageContentScale> contentScale;
    public MutableState<List<Map<String, Dynamic>>> modifiers;
    public MutableState<ImageSource> source;
    public MutableState<Color> tint;

    /* JADX INFO: compiled from: ImageView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/image/ImageProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ImageProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ImageProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("source", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ImageSource.class, true, ImageSource.__Pika.__pika$IntrospectionData)}), null), 0, __pika, false, true, false), new PProperty("contentScale", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ImageContentScale.class, false, null)}), null), 1, __pika, false, true, false), new PProperty("alignment", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ContentAlignment.class, false, null)}), null), 2, __pika, false, true, false), new PProperty("contentDescription", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING_NULLABLE}), null), 3, __pika, false, true, false), new PProperty("tint", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null)}), null), 4, __pika, false, true, false), new PProperty("alpha", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.FLOAT}), null), 5, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(MutableState.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null)}), null), 6, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("component7", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    return ((ImageProps) obj).getSource();
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    return ((ImageProps) obj).getContentScale();
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    return ((ImageProps) obj).getAlignment();
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    return ((ImageProps) obj).getContentDescription();
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    return ((ImageProps) obj).getTint();
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    return ((ImageProps) obj).getAlpha();
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    return ((ImageProps) obj).getModifiers();
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            switch (i) {
                case 0:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.graphics.ImageSource?>");
                    ((ImageProps) obj).source = (MutableState) obj2;
                    return;
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.image.ImageContentScale>");
                    ((ImageProps) obj).contentScale = (MutableState) obj2;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<expo.modules.ui.convertibles.ContentAlignment>");
                    ((ImageProps) obj).alignment = (MutableState) obj2;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.String?>");
                    ((ImageProps) obj).contentDescription = (MutableState) obj2;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<android.graphics.Color?>");
                    ((ImageProps) obj).tint = (MutableState) obj2;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.Float>");
                    ((ImageProps) obj).alpha = (MutableState) obj2;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.image.ImageProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>>");
                    ((ImageProps) obj).modifiers = (MutableState) obj2;
                    return;
                default:
                    throw new IndexOutOfBoundsException(String.valueOf(i));
            }
        }
    }

    public ImageProps() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageProps copy$default(ImageProps imageProps, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableState = imageProps.source;
        }
        if ((i & 2) != 0) {
            mutableState2 = imageProps.contentScale;
        }
        if ((i & 4) != 0) {
            mutableState3 = imageProps.alignment;
        }
        if ((i & 8) != 0) {
            mutableState4 = imageProps.contentDescription;
        }
        if ((i & 16) != 0) {
            mutableState5 = imageProps.tint;
        }
        if ((i & 32) != 0) {
            mutableState6 = imageProps.alpha;
        }
        if ((i & 64) != 0) {
            mutableState7 = imageProps.modifiers;
        }
        MutableState mutableState8 = mutableState6;
        MutableState mutableState9 = mutableState7;
        MutableState mutableState10 = mutableState5;
        MutableState mutableState11 = mutableState3;
        return imageProps.copy(mutableState, mutableState2, mutableState11, mutableState4, mutableState10, mutableState8, mutableState9);
    }

    public final MutableState<ImageSource> component1() {
        return this.source;
    }

    public final MutableState<ImageContentScale> component2() {
        return this.contentScale;
    }

    public final MutableState<ContentAlignment> component3() {
        return this.alignment;
    }

    public final MutableState<String> component4() {
        return this.contentDescription;
    }

    public final MutableState<Color> component5() {
        return this.tint;
    }

    public final MutableState<Float> component6() {
        return this.alpha;
    }

    public final MutableState<List<Map<String, Dynamic>>> component7() {
        return this.modifiers;
    }

    public final ImageProps copy(MutableState<ImageSource> source, MutableState<ImageContentScale> contentScale, MutableState<ContentAlignment> alignment, MutableState<String> contentDescription, MutableState<Color> tint, MutableState<Float> alpha, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(tint, "tint");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ImageProps(source, contentScale, alignment, contentDescription, tint, alpha, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageProps)) {
            return false;
        }
        ImageProps imageProps = (ImageProps) other;
        return Intrinsics.areEqual(this.source, imageProps.source) && Intrinsics.areEqual(this.contentScale, imageProps.contentScale) && Intrinsics.areEqual(this.alignment, imageProps.alignment) && Intrinsics.areEqual(this.contentDescription, imageProps.contentDescription) && Intrinsics.areEqual(this.tint, imageProps.tint) && Intrinsics.areEqual(this.alpha, imageProps.alpha) && Intrinsics.areEqual(this.modifiers, imageProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((((((((((this.source.hashCode() * 31) + this.contentScale.hashCode()) * 31) + this.alignment.hashCode()) * 31) + this.contentDescription.hashCode()) * 31) + this.tint.hashCode()) * 31) + this.alpha.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ImageProps(source=" + this.source + ", contentScale=" + this.contentScale + ", alignment=" + this.alignment + ", contentDescription=" + this.contentDescription + ", tint=" + this.tint + ", alpha=" + this.alpha + ", modifiers=" + this.modifiers + ")";
    }

    public ImageProps(MutableState<ImageSource> source, MutableState<ImageContentScale> contentScale, MutableState<ContentAlignment> alignment, MutableState<String> contentDescription, MutableState<Color> tint, MutableState<Float> alpha, MutableState<List<Map<String, Dynamic>>> modifiers) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Intrinsics.checkNotNullParameter(tint, "tint");
        Intrinsics.checkNotNullParameter(alpha, "alpha");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.source = source;
        this.contentScale = contentScale;
        this.alignment = alignment;
        this.contentDescription = contentDescription;
        this.tint = tint;
        this.alpha = alpha;
        this.modifiers = modifiers;
    }

    public /* synthetic */ ImageProps(MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState, (i & 2) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ImageContentScale.FIT, null, 2, null) : mutableState2, (i & 4) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ContentAlignment.CENTER, null, 2, null) : mutableState3, (i & 8) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState4, (i & 16) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null) : mutableState5, (i & 32) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null) : mutableState6, (i & 64) != 0 ? SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null) : mutableState7);
    }

    public final MutableState<ImageSource> getSource() {
        return this.source;
    }

    public final MutableState<ImageContentScale> getContentScale() {
        return this.contentScale;
    }

    public final MutableState<ContentAlignment> getAlignment() {
        return this.alignment;
    }

    public final MutableState<String> getContentDescription() {
        return this.contentDescription;
    }

    public final MutableState<Color> getTint() {
        return this.tint;
    }

    public final MutableState<Float> getAlpha() {
        return this.alpha;
    }

    public final MutableState<List<Map<String, Dynamic>>> getModifiers() {
        return this.modifiers;
    }
}
