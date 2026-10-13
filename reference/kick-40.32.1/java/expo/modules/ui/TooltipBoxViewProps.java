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

/* JADX INFO: compiled from: TooltipView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(BU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\"\b\u0002\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J#\u0010\u001d\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0003J\\\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\"\b\u0002\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000eHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\f\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0016J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R+\u0010\b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u0002`\r0\tj\u0002`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lexpo/modules/ui/TooltipBoxViewProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", "isPersistent", "", "hasAction", "enableUserInput", "focusable", "modifiers", "", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZLjava/lang/Boolean;ZZLjava/util/List;)V", "()Z", "getHasAction", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableUserInput", "getFocusable", "getModifiers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "(ZLjava/lang/Boolean;ZZLjava/util/List;)Lexpo/modules/ui/TooltipBoxViewProps;", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class TooltipBoxViewProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public boolean enableUserInput;
    public boolean focusable;
    public Boolean hasAction;
    public boolean isPersistent;
    public List<Map<String, Dynamic>> modifiers;

    /* JADX INFO: compiled from: TooltipView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/TooltipBoxViewProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<TooltipBoxViewProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(TooltipBoxViewProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty("isPersistent", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("hasAction", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN_NULLABLE, 1, __pika, false, true, false), new PProperty("enableUserInput", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 2, __pika, false, true, false), new PProperty("focusable", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 3, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 4, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("component5", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                return Boolean.valueOf(((TooltipBoxViewProps) obj).isPersistent());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                return ((TooltipBoxViewProps) obj).getHasAction();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                return Boolean.valueOf(((TooltipBoxViewProps) obj).getEnableUserInput());
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                return Boolean.valueOf(((TooltipBoxViewProps) obj).getFocusable());
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
            return ((TooltipBoxViewProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((TooltipBoxViewProps) obj).isPersistent = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                ((TooltipBoxViewProps) obj).hasAction = (Boolean) obj2;
                return;
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((TooltipBoxViewProps) obj).enableUserInput = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((TooltipBoxViewProps) obj).focusable = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i != 4) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.TooltipBoxViewProps");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
            ((TooltipBoxViewProps) obj).modifiers = (List) obj2;
        }
    }

    public TooltipBoxViewProps() {
        this(false, null, false, false, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TooltipBoxViewProps copy$default(TooltipBoxViewProps tooltipBoxViewProps, boolean z, Boolean bool, boolean z2, boolean z3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tooltipBoxViewProps.isPersistent;
        }
        if ((i & 2) != 0) {
            bool = tooltipBoxViewProps.hasAction;
        }
        if ((i & 4) != 0) {
            z2 = tooltipBoxViewProps.enableUserInput;
        }
        if ((i & 8) != 0) {
            z3 = tooltipBoxViewProps.focusable;
        }
        if ((i & 16) != 0) {
            list = tooltipBoxViewProps.modifiers;
        }
        List list2 = list;
        boolean z4 = z2;
        return tooltipBoxViewProps.copy(z, bool, z4, z3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsPersistent() {
        return this.isPersistent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getHasAction() {
        return this.hasAction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getEnableUserInput() {
        return this.enableUserInput;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFocusable() {
        return this.focusable;
    }

    public final List<Map<String, Dynamic>> component5() {
        return this.modifiers;
    }

    public final TooltipBoxViewProps copy(boolean isPersistent, Boolean hasAction, boolean enableUserInput, boolean focusable, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new TooltipBoxViewProps(isPersistent, hasAction, enableUserInput, focusable, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TooltipBoxViewProps)) {
            return false;
        }
        TooltipBoxViewProps tooltipBoxViewProps = (TooltipBoxViewProps) other;
        return this.isPersistent == tooltipBoxViewProps.isPersistent && Intrinsics.areEqual(this.hasAction, tooltipBoxViewProps.hasAction) && this.enableUserInput == tooltipBoxViewProps.enableUserInput && this.focusable == tooltipBoxViewProps.focusable && Intrinsics.areEqual(this.modifiers, tooltipBoxViewProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.isPersistent) * 31;
        Boolean bool = this.hasAction;
        return ((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.enableUserInput)) * 31) + Boolean.hashCode(this.focusable)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "TooltipBoxViewProps(isPersistent=" + this.isPersistent + ", hasAction=" + this.hasAction + ", enableUserInput=" + this.enableUserInput + ", focusable=" + this.focusable + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TooltipBoxViewProps(boolean z, Boolean bool, boolean z2, boolean z3, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.isPersistent = z;
        this.hasAction = bool;
        this.enableUserInput = z2;
        this.focusable = z3;
        this.modifiers = modifiers;
    }

    public final boolean isPersistent() {
        return this.isPersistent;
    }

    public final Boolean getHasAction() {
        return this.hasAction;
    }

    public final boolean getEnableUserInput() {
        return this.enableUserInput;
    }

    public final boolean getFocusable() {
        return this.focusable;
    }

    public /* synthetic */ TooltipBoxViewProps(boolean z, Boolean bool, boolean z2, boolean z3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
