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

/* JADX INFO: compiled from: DropdownMenuRecords.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u00011Bc\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ#\u0010%\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u0011HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJj\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\"\b\u0002\u0010\u000b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\f\u0010,\u001a\u0006\u0012\u0002\b\u00030-H\u0016J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u000b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u00100\fj\u0002`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001c¨\u00062"}, d2 = {"Lexpo/modules/ui/menu/DropdownMenuProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "activationMethod", "Lexpo/modules/ui/menu/ActivationMethod;", "expanded", "", "color", "Landroid/graphics/Color;", "cornerRadius", "", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "shadowElevation", "<init>", "(Lexpo/modules/ui/menu/ActivationMethod;ZLandroid/graphics/Color;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Float;)V", "getActivationMethod", "()Lexpo/modules/ui/menu/ActivationMethod;", "getExpanded", "()Z", "getColor", "()Landroid/graphics/Color;", "getCornerRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getModifiers", "()Ljava/util/List;", "getShadowElevation", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lexpo/modules/ui/menu/ActivationMethod;ZLandroid/graphics/Color;Ljava/lang/Float;Ljava/util/List;Ljava/lang/Float;)Lexpo/modules/ui/menu/DropdownMenuProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class DropdownMenuProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public ActivationMethod activationMethod;
    public Color color;
    public Float cornerRadius;
    public boolean expanded;
    public List<Map<String, Dynamic>> modifiers;
    public Float shadowElevation;

    /* JADX INFO: compiled from: DropdownMenuRecords.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/menu/DropdownMenuProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<DropdownMenuProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(DropdownMenuProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("activationMethod", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ActivationMethod.class, false, null), 0, __pika, false, true, false), new PProperty("expanded", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, false, true, false), new PProperty("color", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(Color.class, true, null), 2, __pika, false, true, false), new PProperty("cornerRadius", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 3, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 4, __pika, false, true, false), new PProperty("shadowElevation", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.FLOAT_NULLABLE, 5, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("component6", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                return ((DropdownMenuProps) obj).getActivationMethod();
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                return Boolean.valueOf(((DropdownMenuProps) obj).getExpanded());
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                return ((DropdownMenuProps) obj).getColor();
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                return ((DropdownMenuProps) obj).getCornerRadius();
            }
            if (i == 4) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                return ((DropdownMenuProps) obj).getModifiers();
            }
            if (i != 5) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
            return ((DropdownMenuProps) obj).getShadowElevation();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.menu.ActivationMethod");
                ((DropdownMenuProps) obj).activationMethod = (ActivationMethod) obj2;
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((DropdownMenuProps) obj).expanded = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                ((DropdownMenuProps) obj).color = (Color) obj2;
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                ((DropdownMenuProps) obj).cornerRadius = (Float) obj2;
            } else {
                if (i == 4) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                    ((DropdownMenuProps) obj).modifiers = (List) obj2;
                    return;
                }
                if (i != 5) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.menu.DropdownMenuProps");
                ((DropdownMenuProps) obj).shadowElevation = (Float) obj2;
            }
        }
    }

    public DropdownMenuProps() {
        this(null, false, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DropdownMenuProps copy$default(DropdownMenuProps dropdownMenuProps, ActivationMethod activationMethod, boolean z, Color color, Float f, List list, Float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            activationMethod = dropdownMenuProps.activationMethod;
        }
        if ((i & 2) != 0) {
            z = dropdownMenuProps.expanded;
        }
        if ((i & 4) != 0) {
            color = dropdownMenuProps.color;
        }
        if ((i & 8) != 0) {
            f = dropdownMenuProps.cornerRadius;
        }
        if ((i & 16) != 0) {
            list = dropdownMenuProps.modifiers;
        }
        if ((i & 32) != 0) {
            f2 = dropdownMenuProps.shadowElevation;
        }
        List list2 = list;
        Float f3 = f2;
        return dropdownMenuProps.copy(activationMethod, z, color, f, list2, f3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ActivationMethod getActivationMethod() {
        return this.activationMethod;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getExpanded() {
        return this.expanded;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    public final List<Map<String, Dynamic>> component5() {
        return this.modifiers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Float getShadowElevation() {
        return this.shadowElevation;
    }

    public final DropdownMenuProps copy(ActivationMethod activationMethod, boolean expanded, Color color, Float cornerRadius, List<? extends Map<String, ? extends Dynamic>> modifiers, Float shadowElevation) {
        Intrinsics.checkNotNullParameter(activationMethod, "activationMethod");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new DropdownMenuProps(activationMethod, expanded, color, cornerRadius, modifiers, shadowElevation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuProps)) {
            return false;
        }
        DropdownMenuProps dropdownMenuProps = (DropdownMenuProps) other;
        return this.activationMethod == dropdownMenuProps.activationMethod && this.expanded == dropdownMenuProps.expanded && Intrinsics.areEqual(this.color, dropdownMenuProps.color) && Intrinsics.areEqual((Object) this.cornerRadius, (Object) dropdownMenuProps.cornerRadius) && Intrinsics.areEqual(this.modifiers, dropdownMenuProps.modifiers) && Intrinsics.areEqual((Object) this.shadowElevation, (Object) dropdownMenuProps.shadowElevation);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = ((this.activationMethod.hashCode() * 31) + Boolean.hashCode(this.expanded)) * 31;
        Color color = this.color;
        int iHashCode2 = (iHashCode + (color == null ? 0 : color.hashCode())) * 31;
        Float f = this.cornerRadius;
        int iHashCode3 = (((iHashCode2 + (f == null ? 0 : f.hashCode())) * 31) + this.modifiers.hashCode()) * 31;
        Float f2 = this.shadowElevation;
        return iHashCode3 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        return "DropdownMenuProps(activationMethod=" + this.activationMethod + ", expanded=" + this.expanded + ", color=" + this.color + ", cornerRadius=" + this.cornerRadius + ", modifiers=" + this.modifiers + ", shadowElevation=" + this.shadowElevation + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DropdownMenuProps(ActivationMethod activationMethod, boolean z, Color color, Float f, List<? extends Map<String, ? extends Dynamic>> modifiers, Float f2) {
        Intrinsics.checkNotNullParameter(activationMethod, "activationMethod");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.activationMethod = activationMethod;
        this.expanded = z;
        this.color = color;
        this.cornerRadius = f;
        this.modifiers = modifiers;
        this.shadowElevation = f2;
    }

    public /* synthetic */ DropdownMenuProps(ActivationMethod activationMethod, boolean z, Color color, Float f, List list, Float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ActivationMethod.SINGLE_PRESS : activationMethod, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : color, (i & 8) != 0 ? null : f, (i & 16) != 0 ? CollectionsKt.emptyList() : list, (i & 32) != 0 ? null : f2);
    }

    public final ActivationMethod getActivationMethod() {
        return this.activationMethod;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final Color getColor() {
        return this.color;
    }

    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }

    public final Float getShadowElevation() {
        return this.shadowElevation;
    }
}
