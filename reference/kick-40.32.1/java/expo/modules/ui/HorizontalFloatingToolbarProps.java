package expo.modules.ui;

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

/* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J#\u0010\u0018\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\rHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\f\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0016J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0007\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lexpo/modules/ui/HorizontalFloatingToolbarProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "variant", "Lexpo/modules/ui/HorizontalFloatingToolbarVariant;", "colors", "Lexpo/modules/ui/HorizontalFloatingToolbarColors;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(Lexpo/modules/ui/HorizontalFloatingToolbarVariant;Lexpo/modules/ui/HorizontalFloatingToolbarColors;Ljava/util/List;)V", "getVariant", "()Lexpo/modules/ui/HorizontalFloatingToolbarVariant;", "getColors", "()Lexpo/modules/ui/HorizontalFloatingToolbarColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class HorizontalFloatingToolbarProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public HorizontalFloatingToolbarColors colors;
    public List<Map<String, Dynamic>> modifiers;
    public HorizontalFloatingToolbarVariant variant;

    /* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/HorizontalFloatingToolbarProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<HorizontalFloatingToolbarProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(HorizontalFloatingToolbarProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("variant", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(HorizontalFloatingToolbarVariant.class, true, null), 0, __pika, false, true, false), new PProperty("colors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(HorizontalFloatingToolbarColors.class, false, HorizontalFloatingToolbarColors.__Pika.__pika$IntrospectionData), 1, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalFloatingToolbarProps");
                return ((HorizontalFloatingToolbarProps) obj).getVariant();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalFloatingToolbarProps");
                return ((HorizontalFloatingToolbarProps) obj).getColors();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalFloatingToolbarProps");
            return ((HorizontalFloatingToolbarProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalFloatingToolbarProps");
                ((HorizontalFloatingToolbarProps) obj).variant = (HorizontalFloatingToolbarVariant) obj2;
            } else {
                if (i == 1) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalFloatingToolbarProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.HorizontalFloatingToolbarColors");
                    ((HorizontalFloatingToolbarProps) obj).colors = (HorizontalFloatingToolbarColors) obj2;
                    return;
                }
                if (i != 2) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.HorizontalFloatingToolbarProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((HorizontalFloatingToolbarProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public HorizontalFloatingToolbarProps() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalFloatingToolbarProps copy$default(HorizontalFloatingToolbarProps horizontalFloatingToolbarProps, HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant, HorizontalFloatingToolbarColors horizontalFloatingToolbarColors, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontalFloatingToolbarVariant = horizontalFloatingToolbarProps.variant;
        }
        if ((i & 2) != 0) {
            horizontalFloatingToolbarColors = horizontalFloatingToolbarProps.colors;
        }
        if ((i & 4) != 0) {
            list = horizontalFloatingToolbarProps.modifiers;
        }
        return horizontalFloatingToolbarProps.copy(horizontalFloatingToolbarVariant, horizontalFloatingToolbarColors, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HorizontalFloatingToolbarVariant getVariant() {
        return this.variant;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HorizontalFloatingToolbarColors getColors() {
        return this.colors;
    }

    public final List<Map<String, Dynamic>> component3() {
        return this.modifiers;
    }

    public final HorizontalFloatingToolbarProps copy(HorizontalFloatingToolbarVariant variant, HorizontalFloatingToolbarColors colors, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new HorizontalFloatingToolbarProps(variant, colors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HorizontalFloatingToolbarProps)) {
            return false;
        }
        HorizontalFloatingToolbarProps horizontalFloatingToolbarProps = (HorizontalFloatingToolbarProps) other;
        return this.variant == horizontalFloatingToolbarProps.variant && Intrinsics.areEqual(this.colors, horizontalFloatingToolbarProps.colors) && Intrinsics.areEqual(this.modifiers, horizontalFloatingToolbarProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant = this.variant;
        return ((((horizontalFloatingToolbarVariant == null ? 0 : horizontalFloatingToolbarVariant.hashCode()) * 31) + this.colors.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "HorizontalFloatingToolbarProps(variant=" + this.variant + ", colors=" + this.colors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HorizontalFloatingToolbarProps(HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant, HorizontalFloatingToolbarColors colors, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.variant = horizontalFloatingToolbarVariant;
        this.colors = colors;
        this.modifiers = modifiers;
    }

    public final HorizontalFloatingToolbarVariant getVariant() {
        return this.variant;
    }

    public /* synthetic */ HorizontalFloatingToolbarProps(HorizontalFloatingToolbarVariant horizontalFloatingToolbarVariant, HorizontalFloatingToolbarColors horizontalFloatingToolbarColors, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? HorizontalFloatingToolbarVariant.STANDARD : horizontalFloatingToolbarVariant, (i & 2) != 0 ? new HorizontalFloatingToolbarColors() : horizontalFloatingToolbarColors, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final HorizontalFloatingToolbarColors getColors() {
        return this.colors;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
