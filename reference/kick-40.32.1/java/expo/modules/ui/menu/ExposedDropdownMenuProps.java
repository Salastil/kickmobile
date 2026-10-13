package expo.modules.ui.menu;

import android.graphics.Color;
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

/* JADX INFO: compiled from: ExposedDropdownMenuView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"BA\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J#\u0010\u0018\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\rHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\f\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R+\u0010\u0007\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bj\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lexpo/modules/ui/menu/ExposedDropdownMenuProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "expanded", "", "containerColor", "Landroid/graphics/Color;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZLandroid/graphics/Color;Ljava/util/List;)V", "getExpanded", "()Z", "getContainerColor", "()Landroid/graphics/Color;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ExposedDropdownMenuProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public Color containerColor;
    public boolean expanded;
    public List<Map<String, Dynamic>> modifiers;

    /* JADX INFO: compiled from: ExposedDropdownMenuView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/menu/ExposedDropdownMenuProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ExposedDropdownMenuProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ExposedDropdownMenuProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("expanded", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("containerColor", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 1, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 2, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.ExposedDropdownMenuProps");
                return Boolean.valueOf(((ExposedDropdownMenuProps) obj).getExpanded());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.ExposedDropdownMenuProps");
                return ((ExposedDropdownMenuProps) obj).getContainerColor();
            }
            if (i != 2) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.ExposedDropdownMenuProps");
            return ((ExposedDropdownMenuProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.ExposedDropdownMenuProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((ExposedDropdownMenuProps) obj).expanded = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.ExposedDropdownMenuProps");
                ((ExposedDropdownMenuProps) obj).containerColor = (Color) obj2;
            } else {
                if (i != 2) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.ExposedDropdownMenuProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((ExposedDropdownMenuProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public ExposedDropdownMenuProps() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExposedDropdownMenuProps copy$default(ExposedDropdownMenuProps exposedDropdownMenuProps, boolean z, Color color, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = exposedDropdownMenuProps.expanded;
        }
        if ((i & 2) != 0) {
            color = exposedDropdownMenuProps.containerColor;
        }
        if ((i & 4) != 0) {
            list = exposedDropdownMenuProps.modifiers;
        }
        return exposedDropdownMenuProps.copy(z, color, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getExpanded() {
        return this.expanded;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Color getContainerColor() {
        return this.containerColor;
    }

    public final List<Map<String, Dynamic>> component3() {
        return this.modifiers;
    }

    public final ExposedDropdownMenuProps copy(boolean expanded, Color containerColor, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ExposedDropdownMenuProps(expanded, containerColor, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExposedDropdownMenuProps)) {
            return false;
        }
        ExposedDropdownMenuProps exposedDropdownMenuProps = (ExposedDropdownMenuProps) other;
        return this.expanded == exposedDropdownMenuProps.expanded && Intrinsics.areEqual(this.containerColor, exposedDropdownMenuProps.containerColor) && Intrinsics.areEqual(this.modifiers, exposedDropdownMenuProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.expanded) * 31;
        Color color = this.containerColor;
        return ((iHashCode + (color == null ? 0 : color.hashCode())) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ExposedDropdownMenuProps(expanded=" + this.expanded + ", containerColor=" + this.containerColor + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExposedDropdownMenuProps(boolean z, Color color, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.expanded = z;
        this.containerColor = color;
        this.modifiers = modifiers;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final Color getContainerColor() {
        return this.containerColor;
    }

    public /* synthetic */ ExposedDropdownMenuProps(boolean z, Color color, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : color, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
