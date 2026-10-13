package expo.modules.ui;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.uimanager.ViewProps;
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

/* JADX INFO: compiled from: AnimatedVisibilityView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\u0006j\u0002`\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J#\u0010\u001b\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\u0006j\u0002`\u000fHÆ\u0003J[\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\"\b\u0002\u0010\n\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\u0006j\u0002`\u000fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\f\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R+\u0010\n\u001a\u001c\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u0002`\u000e0\u0006j\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006&"}, d2 = {"Lexpo/modules/ui/AnimatedVisibilityProps;", "Lexpo/modules/kotlin/views/ComposeProps;", "Lio/github/expo/pika/PIntrospectionProvider;", ViewProps.VISIBLE, "", "enterTransition", "", "Lexpo/modules/ui/EnterTransitionRecord;", "exitTransition", "Lexpo/modules/ui/ExitTransitionRecord;", "modifiers", "", "", "Lcom/facebook/react/bridge/Dynamic;", "Lexpo/modules/ui/ModifierType;", "Lexpo/modules/ui/ModifierList;", "<init>", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getVisible", "()Z", "getEnterTransition", "()Ljava/util/List;", "getExitTransition", "getModifiers", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "getIntrospectionData", "Lio/github/expo/pika/PIntrospectionData;", "hashCode", "", "toString", "__Pika", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class AnimatedVisibilityProps implements ComposeProps, PIntrospectionProvider {
    public static final int $stable = 8;
    public List<EnterTransitionRecord> enterTransition;
    public List<ExitTransitionRecord> exitTransition;
    public List<Map<String, Dynamic>> modifiers;
    public boolean visible;

    /* JADX INFO: compiled from: AnimatedVisibilityView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lexpo/modules/ui/AnimatedVisibilityProps$__Pika;", "", "<init>", "()V", "expo-ui_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class __Pika implements PPropertyAccessor {
        public static final int $stable;
        public static final __Pika INSTANCE;
        public static final PIntrospectionData<AnimatedVisibilityProps> __pika$IntrospectionData;

        static {
            __Pika __pika = new __Pika();
            INSTANCE = __pika;
            __pika$IntrospectionData = new PIntrospectionData<>(AnimatedVisibilityProps.class, new PAnnotation[]{new PAnnotation(OptimizedComposeProps.class, MapsKt.emptyMap())}, new PProperty[]{new PProperty(ViewProps.VISIBLE, PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.BOOLEAN, 0, __pika, false, true, false), new PProperty("enterTransition", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(EnterTransitionRecord.class, false, EnterTransitionRecord.__Pika.__pika$IntrospectionData)}), null), 1, __pika, false, true, false), new PProperty("exitTransition", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, true, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateConcrete(ExitTransitionRecord.class, false, ExitTransitionRecord.__Pika.__pika$IntrospectionData)}), null), 2, __pika, false, true, false), new PProperty("modifiers", PVisibility.PUBLIC, PEmptyArrays.EMPTY_ANNOTATIONS, PTypeDescriptorRegistry.getOrCreateParameterized(List.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.getOrCreateParameterized(Map.class, false, CollectionsKt.listOf((Object[]) new PTypeDescriptor[]{PTypeDescriptorRegistry.STRING, PTypeDescriptorRegistry.getOrCreateConcrete(Dynamic.class, false, null)}), null)}), null), 3, __pika, false, true, false)}, new PFunction[]{new PFunction("component1", PVisibility.PUBLIC), new PFunction("component2", PVisibility.PUBLIC), new PFunction("component3", PVisibility.PUBLIC), new PFunction("component4", PVisibility.PUBLIC), new PFunction("copy", PVisibility.PUBLIC), new PFunction("toString", PVisibility.PUBLIC), new PFunction("hashCode", PVisibility.PUBLIC), new PFunction("equals", PVisibility.PUBLIC)}, null);
            $stable = 8;
        }

        private __Pika() {
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public Object __pika$PropertyGet(Object obj, int i) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
                return Boolean.valueOf(((AnimatedVisibilityProps) obj).getVisible());
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
                return ((AnimatedVisibilityProps) obj).getEnterTransition();
            }
            if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
                return ((AnimatedVisibilityProps) obj).getExitTransition();
            }
            if (i != 3) {
                throw new IndexOutOfBoundsException(String.valueOf(i));
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
            return ((AnimatedVisibilityProps) obj).getModifiers();
        }

        @Override // io.github.expo.pika.PPropertyAccessor
        public void __pika$PropertySet(Object obj, int i, Object obj2) {
            if (i == 0) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                ((AnimatedVisibilityProps) obj).visible = ((Boolean) obj2).booleanValue();
                return;
            }
            if (i == 1) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
                ((AnimatedVisibilityProps) obj).enterTransition = (List) obj2;
            } else if (i == 2) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
                ((AnimatedVisibilityProps) obj).exitTransition = (List) obj2;
            } else {
                if (i != 3) {
                    throw new IndexOutOfBoundsException(String.valueOf(i));
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type expo.modules.ui.AnimatedVisibilityProps");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, com.facebook.react.bridge.Dynamic>>");
                ((AnimatedVisibilityProps) obj).modifiers = (List) obj2;
            }
        }
    }

    public AnimatedVisibilityProps() {
        this(false, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnimatedVisibilityProps copy$default(AnimatedVisibilityProps animatedVisibilityProps, boolean z, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = animatedVisibilityProps.visible;
        }
        if ((i & 2) != 0) {
            list = animatedVisibilityProps.enterTransition;
        }
        if ((i & 4) != 0) {
            list2 = animatedVisibilityProps.exitTransition;
        }
        if ((i & 8) != 0) {
            list3 = animatedVisibilityProps.modifiers;
        }
        return animatedVisibilityProps.copy(z, list, list2, list3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    public final List<EnterTransitionRecord> component2() {
        return this.enterTransition;
    }

    public final List<ExitTransitionRecord> component3() {
        return this.exitTransition;
    }

    public final List<Map<String, Dynamic>> component4() {
        return this.modifiers;
    }

    public final AnimatedVisibilityProps copy(boolean visible, List<EnterTransitionRecord> enterTransition, List<ExitTransitionRecord> exitTransition, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        return new AnimatedVisibilityProps(visible, enterTransition, exitTransition, modifiers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnimatedVisibilityProps)) {
            return false;
        }
        AnimatedVisibilityProps animatedVisibilityProps = (AnimatedVisibilityProps) other;
        return this.visible == animatedVisibilityProps.visible && Intrinsics.areEqual(this.enterTransition, animatedVisibilityProps.enterTransition) && Intrinsics.areEqual(this.exitTransition, animatedVisibilityProps.exitTransition) && Intrinsics.areEqual(this.modifiers, animatedVisibilityProps.modifiers);
    }

    @Override // io.github.expo.pika.PIntrospectionProvider
    public PIntrospectionData<?> getIntrospectionData() {
        return __Pika.__pika$IntrospectionData;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.visible) * 31;
        List<EnterTransitionRecord> list = this.enterTransition;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<ExitTransitionRecord> list2 = this.exitTransition;
        return ((iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.modifiers.hashCode();
    }

    public String toString() {
        return "AnimatedVisibilityProps(visible=" + this.visible + ", enterTransition=" + this.enterTransition + ", exitTransition=" + this.exitTransition + ", modifiers=" + this.modifiers + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatedVisibilityProps(boolean z, List<EnterTransitionRecord> list, List<ExitTransitionRecord> list2, List<? extends Map<String, ? extends Dynamic>> modifiers) {
        Intrinsics.checkNotNullParameter(modifiers, "modifiers");
        this.visible = z;
        this.enterTransition = list;
        this.exitTransition = list2;
        this.modifiers = modifiers;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final List<EnterTransitionRecord> getEnterTransition() {
        return this.enterTransition;
    }

    public final List<ExitTransitionRecord> getExitTransition() {
        return this.exitTransition;
    }

    public /* synthetic */ AnimatedVisibilityProps(boolean z, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public final List<Map<String, Dynamic>> getModifiers() {
        return this.modifiers;
    }
}
