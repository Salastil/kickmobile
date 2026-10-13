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

/* JADX INFO: compiled from: ToggleButtonView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%BI\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J#\u0010\u001b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\"\b\u0002\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\f\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R+\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lexpo/modules/ui/ToggleButtonProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "checked", "", "enabled", "colors", "Lexpo/modules/ui/ToggleButtonColors;", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZZLexpo/modules/ui/ToggleButtonColors;Ljava/util/List;)V", "getChecked", "()Z", "getEnabled", "getColors", "()Lexpo/modules/ui/ToggleButtonColors;", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ToggleButtonProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public boolean checked;
    public ToggleButtonColors colors;
    public boolean enabled;
    public List<Map<String, Dynamic>> modifiers;

    /* JADX INFO: compiled from: ToggleButtonView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/ToggleButtonProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<ToggleButtonProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(ToggleButtonProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("checked", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("enabled", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 1, __pika, false, true, false), new PProperty("colors", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateConcrete(ToggleButtonColors.class, false, ToggleButtonColors.__Pika.__pika$IntrospectionData), 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
                return Boolean.valueOf(((ToggleButtonProps) obj).getChecked());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
                return Boolean.valueOf(((ToggleButtonProps) obj).getEnabled());
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
                return ((ToggleButtonProps) obj).getColors();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
            return ((ToggleButtonProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((ToggleButtonProps) obj).checked = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((ToggleButtonProps) obj).enabled = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonColors");
                ((ToggleButtonProps) obj).colors = (ToggleButtonColors) obj2;
                return;
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.ToggleButtonProps");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
            ((ToggleButtonProps) obj).modifiers = (List) obj2;
        }
    }

    public ToggleButtonProps() {
        this(false, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToggleButtonProps copy$default(ToggleButtonProps toggleButtonProps, boolean z, boolean z2, ToggleButtonColors toggleButtonColors, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = toggleButtonProps.checked;
        }
        if ((i & 2) != 0) {
            z2 = toggleButtonProps.enabled;
        }
        if ((i & 4) != 0) {
            toggleButtonColors = toggleButtonProps.colors;
        }
        if ((i & 8) != 0) {
            list = toggleButtonProps.modifiers;
        }
        return toggleButtonProps.copy(z, z2, toggleButtonColors, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ToggleButtonColors getColors() {
        return this.colors;
    }

    public final List<Map<String, Dynamic>> component4() {
        return this.modifiers;
    }

    public final ToggleButtonProps copy(boolean checked, boolean enabled, ToggleButtonColors colors, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new ToggleButtonProps(checked, enabled, colors, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToggleButtonProps)) {
            return false;
        }
        ToggleButtonProps toggleButtonProps = (ToggleButtonProps) other;
        return this.checked == toggleButtonProps.checked && this.enabled == toggleButtonProps.enabled && Intrinsics.areEqual(this.colors, toggleButtonProps.colors) && Intrinsics.areEqual(this.modifiers, toggleButtonProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.checked) * 31) + Boolean.hashCode(this.enabled)) * 31) + this.colors.hashCode()) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "ToggleButtonProps(checked=" + this.checked + ", enabled=" + this.enabled + ", colors=" + this.colors + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToggleButtonProps(boolean z, boolean z2, ToggleButtonColors colors, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.checked = z;
        this.enabled = z2;
        this.colors = colors;
        this.modifiers = modifiers;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public /* synthetic */ ToggleButtonProps(boolean z, boolean z2, ToggleButtonColors toggleButtonColors, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? new ToggleButtonColors(null, null, null, null, null, null, 63, null) : toggleButtonColors, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final ToggleButtonColors getColors() {
        return this.colors;
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
